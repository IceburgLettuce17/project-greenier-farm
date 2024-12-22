package com.gameloft.android2d.iap.p042a.p051h;

import android.app.Activity;
import android.content.DialogInterface;

final class DialogInterfaceOnClickListenerC0417i implements DialogInterface.OnClickListener {
    private Activity acB;
    private Runnable acE;
    private boolean acF;

    DialogInterfaceOnClickListenerC0417i(C0414f c0414f, Runnable runnable, boolean z, Activity activity) {
        this.acE = runnable;
        this.acF = z;
        this.acB = activity;
    }

    @Override
    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.acE != null) {
            this.acE.run();
        }
        dialogInterface.dismiss();
        if (this.acF) {
            this.acB.finish();
        }
    }
}
