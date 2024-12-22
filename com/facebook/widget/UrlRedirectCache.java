package com.facebook.widget;

import android.content.Context;
import com.facebook.internal.FileLruCache;
import com.facebook.internal.Utility;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

class UrlRedirectCache {
    private static volatile FileLruCache urlRedirectCache;
    static final String TAG = UrlRedirectCache.class.getSimpleName();
    private static final String REDIRECT_CONTENT_TAG = TAG + "_Redirect";

    UrlRedirectCache() {
    }

    static void cacheUrlRedirect(Context context, URL url, URL url2) {
        OutputStream outputStream;
        Throwable th;
        OutputStream openPutStream;
        if (url == null || url2 == null) {
            return;
        }
        try {
            try {
                openPutStream = getCache(context).openPutStream(url.toString(), REDIRECT_CONTENT_TAG);
            } catch (Throwable th2) {
                outputStream = null;
                th = th2;
            }
            try {
                openPutStream.write(url2.toString().getBytes());
                Utility.closeQuietly(openPutStream);
            } catch (Throwable th3) {
                outputStream = openPutStream;
                th = th3;
                Utility.closeQuietly(outputStream);
                throw th;
            }
        } catch (IOException e) {
            Utility.closeQuietly(null);
        }
    }

    static synchronized FileLruCache getCache(Context context) {
        FileLruCache fileLruCache;
        synchronized (UrlRedirectCache.class) {
            if (urlRedirectCache == null) {
                urlRedirectCache = new FileLruCache(context.getApplicationContext(), TAG, new FileLruCache.Limits());
            }
            fileLruCache = urlRedirectCache;
        }
        return fileLruCache;
    }

    static URL getRedirectedUrl(Context context, URL url) {
        InputStreamReader inputStreamReader;
        InputStreamReader inputStreamReader2;
        boolean z = false;
        if (url == null) {
            return null;
        }
        String url2 = url.toString();
        try {
            FileLruCache cache = getCache(context);
            String str = url2;
            inputStreamReader = null;
            while (true) {
                try {
                    InputStream inputStream = cache.get(str, REDIRECT_CONTENT_TAG);
                    if (inputStream == null) {
                        break;
                    }
                    inputStreamReader2 = new InputStreamReader(inputStream);
                    try {
                        char[] cArr = new char[128];
                        StringBuilder sb = new StringBuilder();
                        while (true) {
                            int read = inputStreamReader2.read(cArr, 0, cArr.length);
                            if (read <= 0) {
                                break;
                            }
                            sb.append(cArr, 0, read);
                        }
                        Utility.closeQuietly(inputStreamReader2);
                        str = sb.toString();
                        inputStreamReader = inputStreamReader2;
                        z = true;
                    } catch (MalformedURLException e) {
                        Utility.closeQuietly(inputStreamReader2);
                        return null;
                    } catch (IOException e2) {
                        Utility.closeQuietly(inputStreamReader2);
                        return null;
                    } catch (Throwable th) {
                        inputStreamReader = inputStreamReader2;
                        th = th;
                        Utility.closeQuietly(inputStreamReader);
                        throw th;
                    }
                } catch (MalformedURLException e3) {
                    inputStreamReader2 = inputStreamReader;
                } catch (IOException e4) {
                    inputStreamReader2 = inputStreamReader;
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            URL url3 = z ? new URL(str) : null;
            Utility.closeQuietly(inputStreamReader);
            return url3;
        } catch (MalformedURLException e5) {
            inputStreamReader2 = null;
        } catch (IOException e6) {
            inputStreamReader2 = null;
        } catch (Throwable th3) {
            th = th3;
            inputStreamReader = null;
        }
    }
}
