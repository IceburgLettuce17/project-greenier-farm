package com.p034e.p035a.p036a.p038b;

import android.text.TextUtils;
import com.p034e.p035a.p036a.C0181j;
import com.p034e.p035a.p036a.C0182k;
import com.p034e.p035a.p036a.p040d.C0175b;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.KeyStore;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;

public final class C0164b {
    private static final String ahV;
    private static final String ahW;
    private static final String ahX;

    static {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 1; i < 12; i++) {
            long currentTimeMillis = System.currentTimeMillis() + i;
            if (currentTimeMillis % 3 == 0) {
                stringBuffer.append(((char) currentTimeMillis) % '\t');
            } else if (currentTimeMillis % 3 == 1) {
                stringBuffer.append((char) ((currentTimeMillis % 26) + 65));
            } else {
                stringBuffer.append((char) ((currentTimeMillis % 26) + 97));
            }
        }
        ahV = stringBuffer.toString();
        ahW = "--" + ahV;
        ahX = "--" + ahV + "--";
    }

    public static String m301a(String str, String str2, C0182k c0182k, String str3) {
        try {
            HttpClient m305tN = m305tN();
            HttpUriRequest httpUriRequest = null;
            m305tN.getParams().setParameter("http.route.default-proxy", C0167e.m306tO());
            if (str2.equals("GET")) {
                httpUriRequest = new HttpGet(String.valueOf(str) + "?" + C0175b.m321a(c0182k));
            } else if (str2.equals("POST")) {
                HttpPost httpPost = new HttpPost(str);
                String value = c0182k.getValue("content-type");
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                if (TextUtils.isEmpty(str3)) {
                    if (value != null) {
                        int indexOf = c0182k.ahP.indexOf("content-type");
                        if (indexOf >= 0) {
                            c0182k.ahP.remove(indexOf);
                            c0182k.ahQ.remove(indexOf);
                        }
                        httpPost.setHeader("Content-Type", value);
                    } else {
                        httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");
                    }
                    byteArrayOutputStream.write(C0175b.m323b(c0182k).getBytes("UTF-8"));
                } else {
                    m303a(byteArrayOutputStream, c0182k);
                    httpPost.setHeader("Content-Type", "multipart/form-data; boundary=" + ahV);
                    m304a(byteArrayOutputStream, str3);
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                httpPost.setEntity(new ByteArrayEntity(byteArray));
                httpUriRequest = httpPost;
            } else if (str2.equals("DELETE")) {
                httpUriRequest = new HttpDelete(str);
            }
            HttpResponse execute = m305tN.execute(httpUriRequest);
            int statusCode = execute.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                throw new C0181j(m302a(execute), statusCode);
            }
            return m302a(execute);
        } catch (IOException e) {
            throw new C0181j(e);
        }
    }

    private static String m302a(HttpResponse httpResponse) {
        try {
            InputStream content = httpResponse.getEntity().getContent();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Header firstHeader = httpResponse.getFirstHeader("Content-Encoding");
            InputStream gZIPInputStream = (firstHeader == null || firstHeader.getValue().toLowerCase().indexOf("gzip") < 0) ? content : new GZIPInputStream(content);
            byte[] bArr = new byte[512];
            while (true) {
                int read = gZIPInputStream.read(bArr);
                if (read == -1) {
                    return new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (IOException | IllegalStateException e) {
            return "";
        }
    }

    private static void m303a(OutputStream outputStream, C0182k c0182k) {
        for (int i = 0; i < c0182k.ahP.size(); i++) {
            String m335fi = c0182k.m335fi(i);
            StringBuilder sb = new StringBuilder(10);
            sb.setLength(0);
            sb.append(ahW).append("\r\n");
            sb.append("content-disposition: form-data; name=\"").append(m335fi).append("\"\r\n\r\n");
            sb.append(c0182k.getValue(m335fi)).append("\r\n");
            try {
                outputStream.write(sb.toString().getBytes());
            } catch (IOException e) {
                throw new C0181j(e);
            }
        }
    }

    private static void m304a(OutputStream outputStream, String str) {
        FileInputStream fileInputStream;
        if (str == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(ahW).append("\r\n");
        sb.append("Content-Disposition: form-data; name=\"pic\"; filename=\"news_image").append("\"\r\n");
        ?? append = sb.append("Content-Type: ").append("image/png");
        append.append("\r\n\r\n");
        try {
            try {
                outputStream.write(sb.toString().getBytes());
                fileInputStream = new FileInputStream(str);
            } catch (IOException e) {
                e = e;
            } catch (Throwable th) {
                th = th;
                append = 0;
                if (append != 0) {
                }
                throw th;
            }
            try {
                byte[] bArr = new byte[51200];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        outputStream.write("\r\n".getBytes());
                        outputStream.write(("\r\n" + ahX).getBytes());
                        try {
                            fileInputStream.close();
                            return;
                        } catch (IOException e2) {
                            throw new C0181j(e2);
                        }
                    }
                    outputStream.write(bArr, 0, read);
                }
            } catch (IOException e3) {
                e = e3;
                throw new C0181j(e);
            }
        } catch (Throwable th2) {
            th = th2;
            if (append != 0) {
                try {
                    append.close();
                } catch (IOException e4) {
                    throw new C0181j(e4);
                }
            }
            throw th;
        }
    }

    private static HttpClient m305tN() {
        try {
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null, null);
            C0165c c0165c = new C0165c(keyStore);
            c0165c.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            BasicHttpParams basicHttpParams = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(basicHttpParams, 10000);
            HttpConnectionParams.setSoTimeout(basicHttpParams, 10000);
            HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
            HttpProtocolParams.setContentCharset(basicHttpParams, "UTF-8");
            SchemeRegistry schemeRegistry = new SchemeRegistry();
            schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
            schemeRegistry.register(new Scheme("https", c0165c, 443));
            ThreadSafeClientConnManager threadSafeClientConnManager = new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry);
            HttpConnectionParams.setConnectionTimeout(basicHttpParams, 5000);
            HttpConnectionParams.setSoTimeout(basicHttpParams, 20000);
            return new DefaultHttpClient(threadSafeClientConnManager, basicHttpParams);
        } catch (Exception e) {
            return new DefaultHttpClient();
        }
    }
}
