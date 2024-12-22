package p009b.p010a.p011a;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class C0044j implements InterfaceC0042h {
    Socket aim;

    public C0044j(String str) {
        int indexOf = str.indexOf("://") + 3;
        int lastIndexOf = str.lastIndexOf(":") + 1;
        this.aim = new Socket(str.substring(indexOf, lastIndexOf - 1), Integer.parseInt(str.substring(lastIndexOf)));
    }

    @Override
    public void close() {
        this.aim.close();
    }

    @Override
    public InputStream mo107tP() {
        return this.aim.getInputStream();
    }

    @Override
    public OutputStream mo108tQ() {
        return this.aim.getOutputStream();
    }
}
