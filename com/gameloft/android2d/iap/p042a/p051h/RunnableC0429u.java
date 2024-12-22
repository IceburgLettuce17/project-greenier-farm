package com.gameloft.android2d.iap.p042a.p051h;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import p001a.p004b.p005a.p006a.C0012k;

final class RunnableC0429u implements Runnable {
    private AsyncTaskC0428t acS;

    RunnableC0429u(AsyncTaskC0428t asyncTaskC0428t) {
        this.acS = asyncTaskC0428t;
    }

    @Override
    public final void run() {
        C0409a c0409a;
        Intent intent = new Intent();
        c0409a = this.acS.acQ;
        intent.setData(Uri.parse(c0409a.acn));
        intent.addFlags(268435456);
        try {
            this.acS.acO.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            C0012k.m40b("IAP-SamsungIABActivity", "Exception: " + e.getMessage());
            this.acS.acO.m2416u(0, true);
        }
    }
}
