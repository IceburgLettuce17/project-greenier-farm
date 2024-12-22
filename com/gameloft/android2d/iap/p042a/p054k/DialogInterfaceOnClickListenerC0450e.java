package com.gameloft.android2d.iap.p042a.p054k;

import android.content.DialogInterface;

final class DialogInterfaceOnClickListenerC0450e implements DialogInterface.OnClickListener {
    private C0447b adG;

    DialogInterfaceOnClickListenerC0450e(C0447b c0447b) {
        this.adG = c0447b;
    }

    @Override
    public final void onClick(DialogInterface dialogInterface, int i) {
        new C0454i(this.adG.adF).start();
    }
}
