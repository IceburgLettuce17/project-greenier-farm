package com.gameloft.android2d.iap.p042a.p047e;

public final class C0403y {
    int abn;
    String abo;

    public C0403y(int i, String str) {
        this.abn = i;
        if (str == null || str.trim().length() == 0) {
            this.abo = C0392n.m2344eY(i);
        } else {
            this.abo = str + " (response: " + C0392n.m2344eY(i) + ")";
        }
    }

    public final boolean isFailure() {
        return !m2358rX();
    }

    public final boolean m2358rX() {
        return this.abn == 0;
    }

    public final String toString() {
        return "IabResult: " + this.abo;
    }
}
