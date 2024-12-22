package com.gameloft.android.LATAM.GloftGF2H;

import android.os.Handler;

final class RunnableC0303bc implements Runnable {

    final StartUpdate f643zx;

    RunnableC0303bc(StartUpdate startUpdate) {
        this.f643zx = startUpdate;
    }

    @Override
    public final void run() {
        int i;
        C0326f c0326f;
        Handler handler;
        while (i < 100) {
            while (!c0326f.m1968aj()) {
                try {
                    Thread.sleep(50L);
                } catch (Exception e) {
                }
            }
            StartUpdate.m588a(this.f643zx, 100);
            handler = StartUpdate.mHandler;
            handler.post(new RunnableC0304bd(this));
        }
    }
}
