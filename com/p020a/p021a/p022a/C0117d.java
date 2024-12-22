package com.p020a.p021a.p022a;

import android.os.Handler;

final class C0117d {

    private Handler f94aH;

    C0117d(Handler handler) {
        this.f94aH = handler;
    }

    final boolean post(Runnable runnable) {
        return this.f94aH.post(runnable);
    }
}
