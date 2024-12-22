package com.gameloft.android2d.iap.p042a.p052i;

import android.app.AlertDialog;
import com.gameloft.android2d.iap.utils.C0488o;

final class C0433b extends Thread {

    final String f2773ZY;
    final C0432a ado;

    C0433b(C0432a c0432a, String str) {
        this.ado = c0432a;
        this.f2773ZY = str;
    }

    @Override
    public final void run() {
        C0432a.adn = false;
        AlertDialog.Builder builder = new AlertDialog.Builder(C0488o.getContext());
        AlertDialog.Builder cancelable = builder.setMessage(this.ado.m2277rs()).setCancelable(true);
        C0432a c0432a = this.ado;
        AlertDialog.Builder positiveButton = cancelable.setPositiveButton(C0432a.m2440ss(), new DialogInterfaceOnClickListenerC0436e(this));
        C0432a c0432a2 = this.ado;
        positiveButton.setNegativeButton(C0432a.m2441st(), new DialogInterfaceOnClickListenerC0435d(this)).setOnCancelListener(new DialogInterfaceOnCancelListenerC0434c(this));
        this.ado.adi = builder.create();
    }
}
