package p009b.p010a.p011a;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public final class C0038d implements InterfaceC0037c {
    private URLConnection aij;
    private HttpURLConnection aik;

    public C0038d(String str, int i) {
        this.aij = new URL(str).openConnection();
        if (this.aij instanceof HttpURLConnection) {
            this.aik = (HttpURLConnection) this.aij;
            this.aik.setRequestMethod("GET");
        }
        this.aij.setDoInput(true);
        this.aij.setDoOutput(true);
    }

    @Override
    public final void close() {
        if (this.aik != null) {
            this.aik.disconnect();
        }
    }

    @Override
    public final long getDate() {
        return this.aij.getDate();
    }

    @Override
    public final int getResponseCode() {
        if (this.aik != null) {
            return this.aik.getResponseCode();
        }
        return 200;
    }

    @Override
    public final void setRequestMethod(String str) {
        if (this.aik != null) {
            this.aik.setRequestMethod(str);
        }
    }

    @Override
    public final void setRequestProperty(String str, String str2) {
        this.aij.setRequestProperty(str, str2);
    }

    @Override
    public final InputStream mo107tP() {
        return this.aij.getInputStream();
    }

    @Override
    public final OutputStream mo108tQ() {
        return this.aij.getOutputStream();
    }
}
