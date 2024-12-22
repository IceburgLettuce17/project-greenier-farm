package com.p034e.p035a.p036a;

import android.os.Handler;
import android.os.Message;
import com.facebook.widget.PlacePickerFragment;

final class HandlerC0170c extends Handler {
    private C0162b ahE;

    HandlerC0170c(C0162b c0162b) {
        this.ahE = c0162b;
    }

    @Override
    public final void handleMessage(Message message) {
        switch (message.what) {
            case PlacePickerFragment.DEFAULT_RADIUS_IN_METERS:
                if (message.getData() == null) {
                    C0162b.m290a(this.ahE).mo319a(new C0181j("Failed to receive access token."));
                    break;
                } else {
                    C0162b.m290a(this.ahE).onComplete(message.getData());
                    break;
                }
            case 1001:
                if (message.obj != null) {
                    C0162b.m290a(this.ahE).mo319a((C0181j) message.obj);
                }
                if (message.getData() != null) {
                    C0162b.m290a(this.ahE).mo319a(new C0181j(String.valueOf(message.getData().getString("error")) + "-" + message.getData().getString("error_description"), Integer.parseInt(message.getData().getString("error_code"))));
                    break;
                }
                break;
        }
    }
}
