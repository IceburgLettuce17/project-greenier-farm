package com.gameloft.android2d.iap.p042a.p051h;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;

final class RunnableC0415g implements Runnable {
    private Activity acB;
    private C0414f acC;

    RunnableC0415g(C0414f c0414f, Activity activity) {
        this.acC = c0414f;
        this.acB = activity;
    }

    @Override
    public final void run() {
        Uri parse = Uri.parse("samsungapps://ProductDetail/com.sec.android.iap");
        Intent intent = new Intent();
        intent.setData(parse);
        if (Build.VERSION.SDK_INT >= 12) {
            intent.addFlags(335544352);
        } else {
            intent.addFlags(335544320);
        }
        C0412d.m2363eZ(0);
        this.acC.mContext.startActivity(intent);
        this.acB.finish();
    }
}
