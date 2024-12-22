package p009b.p010a.p012b;

import javax.microedition.khronos.opengles.GL10;

final class C0076y {
    private boolean ajX;
    private int ajY;
    private boolean ajZ;
    boolean aka;
    C0075x akb;

    private C0076y() {
    }

    C0076y(byte b2) {
        this();
    }

    public final synchronized void m190a(C0075x c0075x) {
        String str = "exiting tid=" + c0075x.getId();
        C0075x.m183a(c0075x, true);
        if (this.akb == c0075x) {
            this.akb = null;
        }
        notifyAll();
    }

    public final synchronized void m191b(GL10 gl10) {
        if (!this.ajZ) {
            m192uo();
            gl10.glGetString(7937);
            this.aka = false;
            notifyAll();
            this.ajZ = true;
        }
    }

    void m192uo() {
        if (this.ajX) {
            return;
        }
        this.ajY = 0;
        this.ajX = true;
    }
}
