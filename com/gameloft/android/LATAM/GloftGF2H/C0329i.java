package com.gameloft.android.LATAM.GloftGF2H;

import java.util.Vector;

public final class C0329i {

    String f1921dR;

    String f1923dT;

    private Vector f1922dS = new Vector();

    private long f1925dV = 0;

    private int f1926dW = 0;

    long f1920dQ = 0;

    String f1928dY = "anonymous";

    String f1927dX = "1";

    C0291ar f1924dU = new C0291ar();

    C0329i() {
    }

    public final void m1978a(C0291ar c0291ar) {
        if (this.f1924dU.f592yi != null) {
            int length = this.f1924dU.f592yi.length;
            int length2 = c0291ar.f592yi.length + length;
            byte[] bArr = new byte[length];
            System.arraycopy(this.f1924dU.f592yi, 0, bArr, 0, length);
            this.f1924dU.f592yi = new byte[length2];
            System.arraycopy(bArr, 0, this.f1924dU.f592yi, 0, length);
            System.arraycopy(c0291ar.f592yi, 0, this.f1924dU.f592yi, length, c0291ar.f592yi.length);
        } else {
            this.f1924dU.f592yi = new byte[c0291ar.f592yi.length];
            System.arraycopy(c0291ar.f592yi, 0, this.f1924dU.f592yi, 0, c0291ar.f592yi.length);
        }
        this.f1925dV += c0291ar.f592yi.length;
        this.f1926dW++;
    }

    public final String m1979ar() {
        return (String) this.f1922dS.lastElement();
    }

    public final void m1980i(String str) {
        this.f1922dS.addElement(str);
    }
}
