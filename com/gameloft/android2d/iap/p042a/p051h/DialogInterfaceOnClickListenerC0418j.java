package com.gameloft.android2d.iap.p042a.p051h;

import android.app.Activity;
import android.content.DialogInterface;

final class DialogInterfaceOnClickListenerC0418j implements DialogInterface.OnClickListener {
    private Activity acB;
    private boolean acF;

    DialogInterfaceOnClickListenerC0418j(C0414f c0414f, boolean z, Activity activity) {
        this.acF = z;
        this.acB = activity;
    }

    @Override
    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        C0412d.m2363eZ(0);
        if (this.acF) {
            this.acB.finish();
        }
    }
}
