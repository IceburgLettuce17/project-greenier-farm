package com.gameloft.android.LATAM.GloftGF2H;

import android.content.DialogInterface;
import android.view.KeyEvent;

final class DialogInterfaceOnKeyListenerC0302bb implements DialogInterface.OnKeyListener {
    DialogInterfaceOnKeyListenerC0302bb(Start start) {
    }

    @Override
    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i != 4) {
            return true;
        }
        System.exit(0);
        return true;
    }
}
