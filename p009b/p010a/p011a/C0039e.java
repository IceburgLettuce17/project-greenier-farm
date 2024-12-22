package p009b.p010a.p011a;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.security.SecureRandom;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

public class C0039e implements InterfaceC0037c {
    boolean aht = false;
    URLConnection aij;
    HttpsURLConnection ail;

    public C0039e(String str, int i) {
        TrustManager[] trustManagerArr = {new C0040f()};
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, trustManagerArr, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext.getSocketFactory());
        } catch (Exception e) {
            e.printStackTrace();
        }
        HttpsURLConnection.setDefaultHostnameVerifier(new C0041g());
        this.aij = new URL(str).openConnection();
        if (this.aij instanceof HttpsURLConnection) {
            this.ail = (HttpsURLConnection) this.aij;
        }
        this.aij.setDoInput(true);
        this.aij.setDoOutput(true);
    }

    @Override
    public void close() {
        if (this.ail != null) {
            this.ail.disconnect();
        }
    }

    @Override
    public long getDate() {
        return this.aij.getDate();
    }

    @Override
    public int getResponseCode() {
        if (this.ail != null) {
            return this.ail.getResponseCode();
        }
        return 200;
    }

    @Override
    public void setRequestMethod(String str) {
        if (this.ail != null) {
            this.ail.setRequestMethod(str);
        }
    }

    @Override
    public void setRequestProperty(String str, String str2) {
        this.aij.setRequestProperty(str, str2);
    }

    @Override
    public InputStream mo107tP() {
        return this.aij.getInputStream();
    }

    @Override
    public OutputStream mo108tQ() {
        return this.aij.getOutputStream();
    }
}
