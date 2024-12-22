package com.gameloft.android2d.iap.p042a.p054k;

import android.app.AlertDialog;
import com.gameloft.android2d.iap.utils.C0488o;

final class C0447b extends Thread {
    final C0446a adF;

    C0447b(C0446a c0446a) {
        this.adF = c0446a;
    }

    @Override
    public final void run() {
        AlertDialog.Builder builder = new AlertDialog.Builder(C0488o.getContext());
        AlertDialog.Builder cancelable = builder.setMessage(this.adF.m2275rq()).setCancelable(false);
        C0446a c0446a = this.adF;
        AlertDialog.Builder positiveButton = cancelable.setPositiveButton(C0446a.m2484ss(), new DialogInterfaceOnClickListenerC0449d(this));
        C0446a c0446a2 = this.adF;
        positiveButton.setNegativeButton(C0446a.m2485st(), new DialogInterfaceOnClickListenerC0448c(this));
        this.adF.adC = builder.create();
        AlertDialog.Builder cancelable2 = builder.setMessage(this.adF.m2276rr()).setCancelable(false);
        C0446a c0446a3 = this.adF;
        cancelable2.setPositiveButton(C0446a.m2484ss(), new DialogInterfaceOnClickListenerC0450e(this));
        this.adF.adD = builder.create();
    }
}
