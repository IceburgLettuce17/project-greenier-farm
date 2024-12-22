package com.gameloft.android2d.iap.p042a.p051h;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import p001a.p004b.p005a.p006a.C0012k;

final class RunnableC0427s implements Runnable {
    private AsyncTaskC0426r acR;

    RunnableC0427s(AsyncTaskC0426r asyncTaskC0426r) {
        this.acR = asyncTaskC0426r;
    }

    @Override
    public final void run() {
        C0409a c0409a;
        Intent intent = new Intent();
        c0409a = this.acR.acQ;
        intent.setData(Uri.parse(c0409a.acn));
        intent.addFlags(268435456);
        this.acR.acO.m2416u(0, false);
        try {
            this.acR.acO.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            C0012k.m40b("IAP-SamsungIABActivity", "ActivityNotFoundException: " + e.getMessage());
        }
    }
}
