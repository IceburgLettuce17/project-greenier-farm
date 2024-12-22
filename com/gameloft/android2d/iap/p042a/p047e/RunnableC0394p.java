package com.gameloft.android2d.iap.p042a.p047e;

import android.os.Handler;
import java.util.List;

final class RunnableC0394p implements Runnable {
    private C0392n aaZ;
    private boolean aba;
    private List abb;
    private Handler abc;
    final C0402x abd;

    RunnableC0394p(C0392n c0392n, boolean z, List list, Handler handler, C0402x c0402x) {
        this.aaZ = c0392n;
        this.aba = z;
        this.abb = list;
        this.abc = handler;
        this.abd = c0402x;
    }

    @Override
    public final void run() {
        C0403y c0403y = new C0403y(0, "Inventory refresh successful.");
        C0404z c0404z = null;
        try {
            c0404z = this.aaZ.m2346a(this.aba, this.abb);
        } catch (C0391m e) {
            c0403y = e.m2339rV();
        }
        this.aaZ.m2353rW();
        this.abc.post(new RunnableC0395q(this, c0403y, c0404z));
    }
}
