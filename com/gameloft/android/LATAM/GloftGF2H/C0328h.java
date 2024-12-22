package com.gameloft.android.LATAM.GloftGF2H;

import com.facebook.widget.PlacePickerFragment;
import p009b.p010a.p016e.C0100b;
import p009b.p010a.p016e.C0101c;

public final class C0328h {

    private static String f1916dP = "GLOT_";

    private int f1917dM = PlacePickerFragment.DEFAULT_RADIUS_IN_METERS;

    private int f1918dN;

    private int f1919dO;

    public C0328h() {
        C0100b m887e = C0316bp.m887e("GLOT_synchronizerCounter", false);
        if (m887e == null) {
            m1971ao();
            return;
        }
        try {
            byte[] m234fq = m887e.m234fq(1);
            this.f1918dN = C0316bp.m888f(m234fq, 0);
            this.f1919dO = C0316bp.m888f(m234fq, 4);
        } catch (Exception e) {
        }
        new StringBuffer("AAAA ").append(this.f1918dN).append("/").append(this.f1919dO).toString();
    }

    private static C0287an m1970F(int i) {
        C0100b m887e = C0316bp.m887e(new StringBuffer().append(f1916dP).append(i).toString(), false);
        if (m887e != null) {
            try {
                if (m887e.m235uD() > 0) {
                    byte[] m234fq = m887e.m234fq(1);
                    String m891h = C0316bp.m891h(m234fq, 4);
                    boolean z = C0316bp.m888f(m234fq, 0) == 1;
                    C0287an c0287an = new C0287an(m891h);
                    c0287an.f511wb = z;
                    return c0287an;
                }
            } catch (Exception e) {
            }
        }
        return null;
    }

    private void m1971ao() {
        try {
            byte[] bArr = new byte[8];
            C0316bp.m880a(this.f1918dN, bArr, 0);
            C0316bp.m880a(this.f1919dO, bArr, 4);
            C0100b m887e = C0316bp.m887e("GLOT_synchronizerCounter", true);
            if (m887e.m235uD() > 0) {
                m887e.m231b(1, bArr, 0, bArr.length);
            } else {
                m887e.m232e(bArr, 0, bArr.length);
            }
        } catch (Exception e) {
        }
    }

    public final void m1972a(C0287an c0287an) {
        byte[] bytes = c0287an.toString().getBytes();
        byte[] bArr = new byte[4];
        C0316bp.m880a(c0287an.f511wb ? 1 : 0, bArr, 0);
        byte[] m882a = C0316bp.m882a(bArr, bytes);
        try {
            C0100b m887e = C0316bp.m887e(new StringBuffer().append(f1916dP).append(this.f1919dO).toString(), true);
            if (m887e.m235uD() > 0) {
                m887e.m231b(1, m882a, 0, m882a.length);
            } else {
                m887e.m232e(m882a, 0, m882a.length);
            }
        } catch (Exception e) {
        }
    }

    public final int m1973al() {
        this.f1919dO++;
        if (this.f1919dO > this.f1917dM) {
            this.f1919dO = 0;
        }
        if (this.f1919dO == this.f1918dN) {
            this.f1919dO--;
        }
        m1971ao();
        return this.f1919dO;
    }

    public final int m1974am() {
        try {
            C0100b.m224dk(new StringBuffer().append(f1916dP).append(this.f1918dN).toString());
            if (this.f1918dN == this.f1919dO) {
                return this.f1918dN;
            }
            this.f1918dN++;
            if (this.f1918dN > this.f1917dM) {
                this.f1918dN = 0;
            }
            m1971ao();
            return this.f1918dN;
        } catch (C0101c e) {
            return this.f1918dN;
        }
    }

    public final C0287an m1975an() {
        return m1970F(this.f1919dO);
    }

    public final C0287an m1976ap() {
        return m1970F(this.f1918dN);
    }

    final int m1977aq() {
        return this.f1919dO;
    }
}
