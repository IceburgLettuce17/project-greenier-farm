package com.gameloft.android2d.iap.p042a.p054k;

import android.content.DialogInterface;
import com.gameloft.android2d.iap.C0463b;

final class DialogInterfaceOnClickListenerC0448c implements DialogInterface.OnClickListener {
    DialogInterfaceOnClickListenerC0448c(C0447b c0447b) {
    }

    @Override
    public final void onClick(DialogInterface dialogInterface, int i) {
        C0463b.setResult(3);
        dialogInterface.cancel();
    }
}
