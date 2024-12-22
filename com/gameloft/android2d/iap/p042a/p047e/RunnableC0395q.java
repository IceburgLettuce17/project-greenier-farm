package com.gameloft.android2d.iap.p042a.p047e;

final class RunnableC0395q implements Runnable {
    private C0403y abe;
    private C0404z abf;
    private RunnableC0394p abg;

    RunnableC0395q(RunnableC0394p runnableC0394p, C0403y c0403y, C0404z c0404z) {
        this.abg = runnableC0394p;
        this.abe = c0403y;
        this.abf = c0404z;
    }

    @Override
    public final void run() {
        this.abg.abd.m2357a(this.abe, this.abf);
    }
}
