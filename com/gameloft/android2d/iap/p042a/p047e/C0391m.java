package com.gameloft.android2d.iap.p042a.p047e;

public final class C0391m extends Exception {
    private C0403y aaL;

    public C0391m(int i, String str) {
        this(new C0403y(i, str));
    }

    public C0391m(int i, String str, Exception exc) {
        this(new C0403y(i, str), exc);
    }

    private C0391m(C0403y c0403y) {
        this(c0403y, (Exception) null);
    }

    private C0391m(C0403y c0403y, Exception exc) {
        super(c0403y.abo, exc);
        this.aaL = c0403y;
    }

    public final C0403y m2339rV() {
        return this.aaL;
    }
}
