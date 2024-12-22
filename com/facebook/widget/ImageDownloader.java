package com.facebook.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import com.facebook.FacebookException;
import com.facebook.internal.Utility;
import com.facebook.widget.ImageRequest;
import com.facebook.widget.WorkQueue;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

class ImageDownloader {
    private static final int CACHE_READ_QUEUE_MAX_CONCURRENT = 2;
    private static final int DOWNLOAD_QUEUE_MAX_CONCURRENT = 8;
    private static final Handler handler = new Handler();
    private static WorkQueue downloadQueue = new WorkQueue(8);
    private static WorkQueue cacheReadQueue = new WorkQueue(2);
    private static final Map<RequestKey, DownloaderContext> pendingRequests = new HashMap();

    class CacheReadWorkItem implements Runnable {
        private boolean allowCachedRedirects;
        private Context context;
        private RequestKey key;

        CacheReadWorkItem(Context context, RequestKey requestKey, boolean z) {
            this.context = context;
            this.key = requestKey;
            this.allowCachedRedirects = z;
        }

        @Override
        public void run() {
            ImageDownloader.readFromCache(this.key, this.context, this.allowCachedRedirects);
        }
    }

    class DownloadImageWorkItem implements Runnable {
        private Context context;
        private RequestKey key;

        DownloadImageWorkItem(Context context, RequestKey requestKey) {
            this.context = context;
            this.key = requestKey;
        }

        @Override
        public void run() {
            ImageDownloader.download(this.key, this.context);
        }
    }

    class DownloaderContext {
        boolean isCancelled;
        ImageRequest request;
        WorkQueue.WorkItem workItem;

        private DownloaderContext() {
        }
    }

    class RequestKey {
        private static final int HASH_MULTIPLIER = 37;
        private static final int HASH_SEED = 29;
        Object tag;
        URL url;

        RequestKey(URL url, Object obj) {
            this.url = url;
            this.tag = obj;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof RequestKey)) {
                return false;
            }
            RequestKey requestKey = (RequestKey) obj;
            return requestKey.url == this.url && requestKey.tag == this.tag;
        }

        public int hashCode() {
            return ((this.url.hashCode() + 1073) * HASH_MULTIPLIER) + this.tag.hashCode();
        }
    }

    ImageDownloader() {
    }

    static boolean cancelRequest(ImageRequest imageRequest) {
        boolean z;
        RequestKey requestKey = new RequestKey(imageRequest.getImageUrl(), imageRequest.getCallerTag());
        synchronized (pendingRequests) {
            DownloaderContext downloaderContext = pendingRequests.get(requestKey);
            if (downloaderContext == null) {
                z = false;
            } else if (downloaderContext.workItem.cancel()) {
                pendingRequests.remove(requestKey);
                z = true;
            } else {
                downloaderContext.isCancelled = true;
                z = true;
            }
        }
        return z;
    }

    public static void download(RequestKey requestKey, Context context) {
        HttpURLConnection httpURLConnection;
        Closeable closeable;
        HttpURLConnection httpURLConnection2;
        Exception exc;
        HttpURLConnection httpURLConnection3;
        Closeable closeable2;
        InputStream inputStream;
        Closeable closeable3 = null;
        r3 = null;
        r3 = null;
        r3 = null;
        closeable3 = null;
        Bitmap bitmap = null;
        boolean z = true;
        try {
            httpURLConnection3 = (HttpURLConnection) requestKey.url.openConnection();
        } catch (IOException e) {
            e = e;
            closeable = null;
            httpURLConnection2 = null;
        } catch (Throwable th) {
            th = th;
            httpURLConnection = null;
        }
        try {
            try {
                httpURLConnection3.setInstanceFollowRedirects(false);
                try {
                    switch (httpURLConnection3.getResponseCode()) {
                        case 200:
                            inputStream = ImageResponseCache.interceptAndCacheImageStream(context, httpURLConnection3);
                            exc = null;
                            bitmap = BitmapFactory.decodeStream(inputStream);
                            Utility.closeQuietly(inputStream);
                            Utility.disconnectQuietly(httpURLConnection3);
                            break;
                        case 301:
                        case 302:
                            try {
                                String headerField = httpURLConnection3.getHeaderField("location");
                                if (Utility.isNullOrEmpty(headerField)) {
                                    z = false;
                                    exc = null;
                                    inputStream = null;
                                } else {
                                    URL url = new URL(headerField);
                                    UrlRedirectCache.cacheUrlRedirect(context, requestKey.url, url);
                                    DownloaderContext removePendingRequest = removePendingRequest(requestKey);
                                    if (removePendingRequest != null && !removePendingRequest.isCancelled) {
                                        enqueueCacheRead(removePendingRequest.request, new RequestKey(url, requestKey.tag), false);
                                    }
                                    z = false;
                                    exc = null;
                                    inputStream = null;
                                }
                                Utility.closeQuietly(inputStream);
                                Utility.disconnectQuietly(httpURLConnection3);
                            } catch (IOException e2) {
                                closeable = null;
                                httpURLConnection2 = httpURLConnection3;
                                e = e2;
                                z = false;
                                Utility.closeQuietly(closeable);
                                Utility.disconnectQuietly(httpURLConnection2);
                                exc = e;
                                if (z) {
                                }
                            }
                            break;
                        default:
                            inputStream = httpURLConnection3.getErrorStream();
                            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                            char[] cArr = new char[128];
                            StringBuilder sb = new StringBuilder();
                            while (true) {
                                int read = inputStreamReader.read(cArr, 0, cArr.length);
                                if (read <= 0) {
                                    Utility.closeQuietly(inputStreamReader);
                                    exc = new FacebookException(sb.toString());
                                    Utility.closeQuietly(inputStream);
                                    Utility.disconnectQuietly(httpURLConnection3);
                                    break;
                                } else {
                                    sb.append(cArr, 0, read);
                                }
                            }
                    }
                } catch (IOException e3) {
                    httpURLConnection2 = httpURLConnection3;
                    e = e3;
                } catch (Throwable th2) {
                    closeable3 = closeable2;
                    httpURLConnection = httpURLConnection3;
                    th = th2;
                    Utility.closeQuietly(closeable3);
                    Utility.disconnectQuietly(httpURLConnection);
                    throw th;
                }
            } catch (IOException e4) {
                closeable = null;
                httpURLConnection2 = httpURLConnection3;
                e = e4;
            }
            if (z) {
                return;
            }
            issueResponse(requestKey, exc, bitmap, false);
        } catch (Throwable th3) {
            httpURLConnection = httpURLConnection3;
            th = th3;
        }
    }

    static void downloadAsync(ImageRequest imageRequest) {
        if (imageRequest == null) {
            return;
        }
        RequestKey requestKey = new RequestKey(imageRequest.getImageUrl(), imageRequest.getCallerTag());
        synchronized (pendingRequests) {
            DownloaderContext downloaderContext = pendingRequests.get(requestKey);
            if (downloaderContext != null) {
                downloaderContext.request = imageRequest;
                downloaderContext.isCancelled = false;
                downloaderContext.workItem.moveToFront();
            } else {
                enqueueCacheRead(imageRequest, requestKey, imageRequest.isCachedRedirectAllowed());
            }
        }
    }

    private static void enqueueCacheRead(ImageRequest imageRequest, RequestKey requestKey, boolean z) {
        enqueueRequest(imageRequest, requestKey, cacheReadQueue, new CacheReadWorkItem(imageRequest.getContext(), requestKey, z));
    }

    private static void enqueueDownload(ImageRequest imageRequest, RequestKey requestKey) {
        enqueueRequest(imageRequest, requestKey, downloadQueue, new DownloadImageWorkItem(imageRequest.getContext(), requestKey));
    }

    private static void enqueueRequest(ImageRequest imageRequest, RequestKey requestKey, WorkQueue workQueue, Runnable runnable) {
        synchronized (pendingRequests) {
            DownloaderContext downloaderContext = new DownloaderContext();
            downloaderContext.request = imageRequest;
            pendingRequests.put(requestKey, downloaderContext);
            downloaderContext.workItem = workQueue.addActiveWorkItem(runnable);
        }
    }

    private static void issueResponse(RequestKey requestKey, final Exception exc, final Bitmap bitmap, final boolean z) {
        final ImageRequest imageRequest;
        final ImageRequest.Callback callback;
        DownloaderContext removePendingRequest = removePendingRequest(requestKey);
        if (removePendingRequest == null || removePendingRequest.isCancelled || (callback = (imageRequest = removePendingRequest.request).getCallback()) == null) {
            return;
        }
        handler.post(new Runnable() {
            @Override
            public final void run() {
                callback.onCompleted(new ImageResponse(ImageRequest.this, exc, z, bitmap));
            }
        });
    }

    static void prioritizeRequest(ImageRequest imageRequest) {
        RequestKey requestKey = new RequestKey(imageRequest.getImageUrl(), imageRequest.getCallerTag());
        synchronized (pendingRequests) {
            DownloaderContext downloaderContext = pendingRequests.get(requestKey);
            if (downloaderContext != null) {
                downloaderContext.workItem.moveToFront();
            }
        }
    }

    public static void readFromCache(RequestKey requestKey, Context context, boolean z) {
        boolean z2;
        InputStream inputStream;
        URL redirectedUrl;
        if (!z || (redirectedUrl = UrlRedirectCache.getRedirectedUrl(context, requestKey.url)) == null) {
            z2 = false;
            inputStream = null;
        } else {
            InputStream cachedImageStream = ImageResponseCache.getCachedImageStream(redirectedUrl, context);
            inputStream = cachedImageStream;
            z2 = cachedImageStream != null;
        }
        if (!z2) {
            inputStream = ImageResponseCache.getCachedImageStream(requestKey.url, context);
        }
        if (inputStream != null) {
            Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
            Utility.closeQuietly(inputStream);
            issueResponse(requestKey, null, decodeStream, z2);
        } else {
            DownloaderContext removePendingRequest = removePendingRequest(requestKey);
            if (removePendingRequest == null || removePendingRequest.isCancelled) {
                return;
            }
            enqueueDownload(removePendingRequest.request, requestKey);
        }
    }

    private static DownloaderContext removePendingRequest(RequestKey requestKey) {
        DownloaderContext remove;
        synchronized (pendingRequests) {
            remove = pendingRequests.remove(requestKey);
        }
        return remove;
    }
}
