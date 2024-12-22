package com.gameloft.android2d.iap;

import android.app.AlertDialog;
import com.gameloft.android2d.iap.utils.C0488o;
import com.gameloft.android2d.iap.utils.C0491r;

final class C0471j extends Thread {
    C0471j(RunnableC0470i runnableC0470i) {
    }

    @Override
    public final void run() {
        AlertDialog create = new AlertDialog.Builder(C0488o.getContext()).create();
        create.setCancelable(false);
        create.setMessage(C0491r.m2687tr());
        create.setButton("OK", new DialogInterfaceOnClickListenerC0472k(this));
        create.show();
    }
}
