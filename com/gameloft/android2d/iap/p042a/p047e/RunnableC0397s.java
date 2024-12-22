package com.gameloft.android2d.iap.p042a.p047e;

import java.util.List;

final class RunnableC0397s implements Runnable {
    private List abk;
    private RunnableC0396r abl;

    RunnableC0397s(RunnableC0396r runnableC0396r, List list) {
        this.abl = runnableC0396r;
        this.abk = list;
    }

    @Override
    public final void run() {
        this.abl.abi.m2354a((C0370aa) this.abl.abh.get(0), (C0403y) this.abk.get(0));
    }
}
