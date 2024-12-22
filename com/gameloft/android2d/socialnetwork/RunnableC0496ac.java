package com.gameloft.android2d.socialnetwork;

import com.facebook.Request;
import com.facebook.RequestBatch;

final class RunnableC0496ac implements Runnable {
    private RequestBatch val$batch;

    RunnableC0496ac(RequestBatch requestBatch) {
        this.val$batch = requestBatch;
    }

    @Override
    public final void run() {
        Request.executeBatchAsync(this.val$batch);
    }
}
