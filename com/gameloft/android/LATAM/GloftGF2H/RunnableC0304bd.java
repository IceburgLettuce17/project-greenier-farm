package com.gameloft.android.LATAM.GloftGF2H;

import android.widget.ProgressBar;

final class RunnableC0304bd implements Runnable {

    private RunnableC0303bc f644zy;

    RunnableC0304bd(RunnableC0303bc runnableC0303bc) {
        this.f644zy = runnableC0303bc;
    }

    @Override
    public final void run() {
        ProgressBar progressBar;
        int i;
        ProgressBar progressBar2;
        int i2;
        progressBar = StartUpdate.f358zu;
        if (progressBar != null) {
            progressBar2 = StartUpdate.f358zu;
            i2 = this.f644zy.f643zx.f366zs;
            progressBar2.setProgress(i2);
        }
        i = this.f644zy.f643zx.f366zs;
        if (i == 100) {
            this.f644zy.f643zx.m601bb(3);
        }
    }
}
