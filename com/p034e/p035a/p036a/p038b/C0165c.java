package com.p034e.p035a.p036a.p038b;

import java.net.Socket;
import java.security.KeyStore;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;

final class C0165c extends SSLSocketFactory {
    private SSLContext ahY;

    public C0165c(KeyStore keyStore) {
        super(keyStore);
        this.ahY = SSLContext.getInstance("TLS");
        this.ahY.init(null, new TrustManager[]{new C0166d(this)}, null);
    }

    @Override
    public final Socket createSocket() {
        return this.ahY.getSocketFactory().createSocket();
    }

    @Override
    public final Socket createSocket(Socket socket, String str, int i, boolean z) {
        return this.ahY.getSocketFactory().createSocket(socket, str, i, z);
    }
}
