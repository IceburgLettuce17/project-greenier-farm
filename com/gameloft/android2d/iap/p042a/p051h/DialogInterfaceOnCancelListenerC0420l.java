package com.gameloft.android2d.iap.p042a.p051h;

import android.app.Activity;
import android.content.DialogInterface;

final class DialogInterfaceOnCancelListenerC0420l implements DialogInterface.OnCancelListener {
    private Activity acB;

    DialogInterfaceOnCancelListenerC0420l(C0414f c0414f, Activity activity) {
        this.acB = activity;
    }

    @Override
    public final void onCancel(DialogInterface dialogInterface) {
        C0412d.m2363eZ(0);
        this.acB.finish();
    }
}
