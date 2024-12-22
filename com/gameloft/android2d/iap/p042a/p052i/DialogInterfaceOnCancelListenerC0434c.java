package com.gameloft.android2d.iap.p042a.p052i;

import android.content.DialogInterface;
import com.gameloft.android2d.iap.C0463b;

final class DialogInterfaceOnCancelListenerC0434c implements DialogInterface.OnCancelListener {
    DialogInterfaceOnCancelListenerC0434c(C0433b c0433b) {
    }

    @Override
    public final void onCancel(DialogInterface dialogInterface) {
        if (!C0432a.adn) {
            C0463b.setResult(3);
        }
        C0432a.adn = false;
    }
}
