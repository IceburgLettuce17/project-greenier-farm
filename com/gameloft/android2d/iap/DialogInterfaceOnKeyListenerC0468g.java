package com.gameloft.android2d.iap;

import android.content.DialogInterface;
import android.view.KeyEvent;
import com.gameloft.android.LATAM.GloftGF2H.C0320bt;

final class DialogInterfaceOnKeyListenerC0468g implements DialogInterface.OnKeyListener {
    DialogInterfaceOnKeyListenerC0468g(C0465d c0465d) {
    }

    @Override
    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        C0463b c0463b;
        if (i == 4 && keyEvent.getAction() == 1) {
            c0463b = C0463b.f2809Ym;
            c0463b.f2826YG.cancel();
            C0463b.setResult(10);
            C0320bt.m1914pX();
        }
        return true;
    }
}
