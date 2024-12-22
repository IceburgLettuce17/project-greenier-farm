package p001a.p004b.p005a.p007b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class HandlerC0030d extends Handler {

    private C0029c f82ax;

    HandlerC0030d(C0029c c0029c, Looper looper) {
        super(looper);
        this.f82ax = c0029c;
    }

    @Override
    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                C0029c.m100a(this.f82ax);
                break;
            default:
                super.handleMessage(message);
                break;
        }
    }
}
