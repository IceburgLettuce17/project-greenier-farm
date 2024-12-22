package com.gameloft.android2d.socialnetwork;

import com.facebook.Request;
import com.facebook.RequestBatch;

final class RunnableC0525i implements Runnable {
    private RequestBatch val$batch;

    RunnableC0525i(C0521e c0521e, RequestBatch requestBatch) {
        this.val$batch = requestBatch;
    }

    @Override
    public final void run() {
        Request.executeBatchAsync(this.val$batch);
    }
}
