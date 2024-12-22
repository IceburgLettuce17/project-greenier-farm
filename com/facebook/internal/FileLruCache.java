package com.facebook.internal;

import android.content.Context;
import com.facebook.LoggingBehavior;
import com.facebook.Settings;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidParameterException;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public final class FileLruCache {
    private static final String HEADER_CACHEKEY_KEY = "key";
    private static final String HEADER_CACHE_CONTENT_TAG_KEY = "tag";
    static final String TAG = FileLruCache.class.getSimpleName();
    private static final AtomicLong bufferIndex = new AtomicLong();
    private final File directory;
    private boolean isTrimPending;
    private final Limits limits;
    private final Object lock = new Object();
    private final String tag;

    class BufferFile {
        private static final String FILE_NAME_PREFIX = "buffer";
        private static final FilenameFilter filterExcludeBufferFiles = new FilenameFilter() {
            @Override
            public final boolean accept(File file, String str) {
                return !str.startsWith(BufferFile.FILE_NAME_PREFIX);
            }
        };
        private static final FilenameFilter filterExcludeNonBufferFiles = new FilenameFilter() {
            @Override
            public final boolean accept(File file, String str) {
                return str.startsWith(BufferFile.FILE_NAME_PREFIX);
            }
        };

        private BufferFile() {
        }

        static void deleteAll(File file) {
            for (File file2 : file.listFiles(excludeNonBufferFiles())) {
                file2.delete();
            }
        }

        static FilenameFilter excludeBufferFiles() {
            return filterExcludeBufferFiles;
        }

        static FilenameFilter excludeNonBufferFiles() {
            return filterExcludeNonBufferFiles;
        }

        static File newFile(File file) {
            return new File(file, FILE_NAME_PREFIX + Long.valueOf(FileLruCache.bufferIndex.incrementAndGet()).toString());
        }
    }

    class CloseCallbackOutputStream extends OutputStream {
        final StreamCloseCallback callback;
        final OutputStream innerStream;

        CloseCallbackOutputStream(OutputStream outputStream, StreamCloseCallback streamCloseCallback) {
            this.innerStream = outputStream;
            this.callback = streamCloseCallback;
        }

        @Override
        public void close() {
            try {
                this.innerStream.close();
            } finally {
                this.callback.onClose();
            }
        }

        @Override
        public void flush() {
            this.innerStream.flush();
        }

        @Override
        public void write(int i) {
            this.innerStream.write(i);
        }

        @Override
        public void write(byte[] bArr) {
            this.innerStream.write(bArr);
        }

        @Override
        public void write(byte[] bArr, int i, int i2) {
            this.innerStream.write(bArr, i, i2);
        }
    }

    final class CopyingInputStream extends InputStream {
        final InputStream input;
        final OutputStream output;

        CopyingInputStream(InputStream inputStream, OutputStream outputStream) {
            this.input = inputStream;
            this.output = outputStream;
        }

        @Override
        public final int available() {
            return this.input.available();
        }

        @Override
        public final void close() {
            try {
                this.input.close();
            } finally {
                this.output.close();
            }
        }

        @Override
        public final void mark(int i) {
            throw new UnsupportedOperationException();
        }

        @Override
        public final boolean markSupported() {
            return false;
        }

        @Override
        public final int read() {
            int read = this.input.read();
            if (read >= 0) {
                this.output.write(read);
            }
            return read;
        }

        @Override
        public final int read(byte[] bArr) {
            int read = this.input.read(bArr);
            if (read > 0) {
                this.output.write(bArr, 0, read);
            }
            return read;
        }

        @Override
        public final int read(byte[] bArr, int i, int i2) {
            int read = this.input.read(bArr, i, i2);
            if (read > 0) {
                this.output.write(bArr, i, read);
            }
            return read;
        }

        @Override
        public final synchronized void reset() {
            throw new UnsupportedOperationException();
        }

        @Override
        public final long skip(long j) {
            int read;
            byte[] bArr = new byte[1024];
            long j2 = 0;
            while (j2 < j && (read = read(bArr, 0, (int) Math.min(j - j2, bArr.length))) >= 0) {
                j2 += read;
            }
            return j2;
        }
    }

    public final class Limits {
        private int fileCount = 1024;
        private int byteCount = 1048576;

        final int getByteCount() {
            return this.byteCount;
        }

        final int getFileCount() {
            return this.fileCount;
        }

        final void setByteCount(int i) {
            if (i < 0) {
                throw new InvalidParameterException("Cache byte-count limit must be >= 0");
            }
            this.byteCount = i;
        }

        final void setFileCount(int i) {
            if (i < 0) {
                throw new InvalidParameterException("Cache file count limit must be >= 0");
            }
            this.fileCount = i;
        }
    }

    final class ModifiedFile implements Comparable<ModifiedFile> {
        private final File file;
        private final long modified;

        ModifiedFile(File file) {
            this.file = file;
            this.modified = file.lastModified();
        }

        @Override
        public final int compareTo(ModifiedFile modifiedFile) {
            if (getModified() < modifiedFile.getModified()) {
                return -1;
            }
            if (getModified() > modifiedFile.getModified()) {
                return 1;
            }
            return getFile().compareTo(modifiedFile.getFile());
        }

        public final boolean equals(Object obj) {
            return (obj instanceof ModifiedFile) && compareTo((ModifiedFile) obj) == 0;
        }

        final File getFile() {
            return this.file;
        }

        final long getModified() {
            return this.modified;
        }
    }

    interface StreamCloseCallback {
        void onClose();
    }

    final class StreamHeader {
        private static final int HEADER_VERSION = 0;

        private StreamHeader() {
        }

        static JSONObject readHeader(InputStream inputStream) {
            JSONObject jSONObject;
            int i = 0;
            if (inputStream.read() != 0) {
                return null;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < 3; i3++) {
                int read = inputStream.read();
                if (read == -1) {
                    Logger.log(LoggingBehavior.CACHE, FileLruCache.TAG, "readHeader: stream.read returned -1 while reading header size");
                    return null;
                }
                i2 = (i2 << 8) + (read & 255);
            }
            byte[] bArr = new byte[i2];
            while (i < bArr.length) {
                int read2 = inputStream.read(bArr, i, bArr.length - i);
                if (read2 <= 0) {
                    Logger.log(LoggingBehavior.CACHE, FileLruCache.TAG, "readHeader: stream.read stopped at " + Integer.valueOf(i) + " when expected " + bArr.length);
                    return null;
                }
                i += read2;
            }
            try {
                Object nextValue = new JSONTokener(new String(bArr)).nextValue();
                if (nextValue instanceof JSONObject) {
                    jSONObject = (JSONObject) nextValue;
                } else {
                    Logger.log(LoggingBehavior.CACHE, FileLruCache.TAG, "readHeader: expected JSONObject, got " + nextValue.getClass().getCanonicalName());
                    jSONObject = null;
                }
                return jSONObject;
            } catch (JSONException e) {
                throw new IOException(e.getMessage());
            }
        }

        static void writeHeader(OutputStream outputStream, JSONObject jSONObject) {
            byte[] bytes = jSONObject.toString().getBytes();
            outputStream.write(0);
            outputStream.write((bytes.length >> 16) & 255);
            outputStream.write((bytes.length >> 8) & 255);
            outputStream.write(bytes.length & 255);
            outputStream.write(bytes);
        }
    }

    public FileLruCache(Context context, String str, Limits limits) {
        this.tag = str;
        this.limits = limits;
        this.directory = new File(context.getCacheDir(), str);
        this.directory.mkdirs();
        BufferFile.deleteAll(this.directory);
    }

    private void postTrim() {
        synchronized (this.lock) {
            if (!this.isTrimPending) {
                this.isTrimPending = true;
                Settings.getExecutor().execute(new Runnable() {
                    @Override
                    public void run() {
                        FileLruCache.this.trim();
                    }
                });
            }
        }
    }

    public void renameToTargetAndTrim(String str, File file) {
        if (!file.renameTo(new File(this.directory, Utility.md5hash(str)))) {
            file.delete();
        }
        postTrim();
    }

    public void trim() {
        try {
            Logger.log(LoggingBehavior.CACHE, TAG, "trim started");
            PriorityQueue priorityQueue = new PriorityQueue();
            File[] listFiles = this.directory.listFiles(BufferFile.excludeBufferFiles());
            int length = listFiles.length;
            long j = 0;
            long j2 = 0;
            int i = 0;
            while (i < length) {
                File file = listFiles[i];
                ModifiedFile modifiedFile = new ModifiedFile(file);
                priorityQueue.add(modifiedFile);
                Logger.log(LoggingBehavior.CACHE, TAG, "  trim considering time=" + Long.valueOf(modifiedFile.getModified()) + " name=" + modifiedFile.getFile().getName());
                i++;
                j++;
                j2 = file.length() + j2;
            }
            long j3 = j2;
            long j4 = j;
            while (true) {
                if (j3 <= this.limits.getByteCount() && j4 <= this.limits.getFileCount()) {
                    synchronized (this.lock) {
                        this.isTrimPending = false;
                        this.lock.notifyAll();
                    }
                    return;
                }
                File file2 = ((ModifiedFile) priorityQueue.remove()).getFile();
                Logger.log(LoggingBehavior.CACHE, TAG, "  trim removing " + file2.getName());
                j3 -= file2.length();
                long j5 = j4 - 1;
                file2.delete();
                j4 = j5;
            }
        } catch (Throwable th) {
            synchronized (this.lock) {
                this.isTrimPending = false;
                this.lock.notifyAll();
                throw th;
            }
        }
    }

    public final void clearForTest() {
        for (File file : this.directory.listFiles()) {
            file.delete();
        }
    }

    public final InputStream get(String str) {
        return get(str, null);
    }

    public final InputStream get(String str, String str2) {
        File file = new File(this.directory, Utility.md5hash(str));
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file), Utility.DEFAULT_STREAM_BUFFER_SIZE);
            try {
                JSONObject readHeader = StreamHeader.readHeader(bufferedInputStream);
                if (readHeader == null) {
                    return null;
                }
                String optString = readHeader.optString(HEADER_CACHEKEY_KEY);
                if (optString == null || !optString.equals(str)) {
                    return null;
                }
                String optString2 = readHeader.optString(HEADER_CACHE_CONTENT_TAG_KEY, null);
                if ((str2 == null && optString2 != null) || (str2 != null && !str2.equals(optString2))) {
                    return null;
                }
                long time = new Date().getTime();
                Logger.log(LoggingBehavior.CACHE, TAG, "Setting lastModified to " + Long.valueOf(time) + " for " + file.getName());
                file.setLastModified(time);
                return bufferedInputStream;
            } finally {
                bufferedInputStream.close();
            }
        } catch (IOException e) {
            return null;
        }
    }

    public final InputStream interceptAndPut(String str, InputStream inputStream) {
        return new CopyingInputStream(inputStream, openPutStream(str));
    }

    final OutputStream openPutStream(String str) {
        return openPutStream(str, null);
    }

    public final OutputStream openPutStream(final String str, String str2) {
        final File newFile = BufferFile.newFile(this.directory);
        newFile.delete();
        if (!newFile.createNewFile()) {
            throw new IOException("Could not create file at " + newFile.getAbsolutePath());
        }
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new CloseCallbackOutputStream(new FileOutputStream(newFile), new StreamCloseCallback() {
                @Override
                public void onClose() {
                    FileLruCache.this.renameToTargetAndTrim(str, newFile);
                }
            }), Utility.DEFAULT_STREAM_BUFFER_SIZE);
            try {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(HEADER_CACHEKEY_KEY, str);
                    if (!Utility.isNullOrEmpty(str2)) {
                        jSONObject.put(HEADER_CACHE_CONTENT_TAG_KEY, str2);
                    }
                    StreamHeader.writeHeader(bufferedOutputStream, jSONObject);
                    return bufferedOutputStream;
                } catch (Throwable th) {
                    bufferedOutputStream.close();
                    throw th;
                }
            } catch (JSONException e) {
                Logger.log(LoggingBehavior.CACHE, 5, TAG, "Error creating JSON header for cache file: " + e);
                throw new IOException(e.getMessage());
            }
        } catch (FileNotFoundException e2) {
            Logger.log(LoggingBehavior.CACHE, 5, TAG, "Error creating buffer output stream: " + e2);
            throw new IOException(e2.getMessage());
        }
    }

    final long sizeInBytesForTest() {
        synchronized (this.lock) {
            while (this.isTrimPending) {
                try {
                    this.lock.wait();
                } catch (InterruptedException e) {
                }
            }
        }
        long j = 0;
        for (File file : this.directory.listFiles()) {
            j += file.length();
        }
        return j;
    }

    public final String toString() {
        return "{FileLruCache: tag:" + this.tag + " file:" + this.directory.getName() + "}";
    }
}
