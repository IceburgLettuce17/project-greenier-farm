package com.p020a.p021a.p022a;

import com.amazon.android.Kiwi;

final class RunnableC0128o implements Runnable {

    private String f107aT;

    private String f108aU;

    RunnableC0128o(C0126m c0126m, String str, String str2) {
        this.f108aU = str;
        this.f107aT = str2;
    }

    @Override
    public final void run() {
        Kiwi.addCommandToCommandTaskPipeline(new C0125l(this.f108aU, this.f107aT));
    }
}
