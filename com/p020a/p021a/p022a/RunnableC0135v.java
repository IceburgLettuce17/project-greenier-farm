package com.p020a.p021a.p022a;

import android.os.Handler;

final class RunnableC0135v implements Runnable {

    final AbstractC0137x f114aZ;

    RunnableC0135v(AbstractC0137x abstractC0137x) {
        this.f114aZ = abstractC0137x;
    }

    @Override
    public final void run() {
        new Handler(C0133t.m258Q().getMainLooper()).post(new RunnableC0136w(this));
    }
}
