package com.p020a.p021a.p022a;

import com.amazon.android.Kiwi;

final class RunnableC0127n implements Runnable {

    private String f106aT;

    RunnableC0127n(C0126m c0126m, String str) {
        this.f106aT = str;
    }

    @Override
    public final void run() {
        Kiwi.addCommandToCommandTaskPipeline(new C0122i(this.f106aT));
    }
}
