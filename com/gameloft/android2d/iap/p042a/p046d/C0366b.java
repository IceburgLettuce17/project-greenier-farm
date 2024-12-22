package com.gameloft.android2d.iap.p042a.p046d;

import android.content.Intent;
import android.net.Uri;
import com.gameloft.android2d.iap.C0463b;
import com.gameloft.android2d.iap.InterfaceC0357a;
import com.gameloft.android2d.iap.p042a.p051h.C0414f;
import com.gameloft.android2d.iap.utils.C0488o;

final class C0366b extends Thread {
    private String aae;

    C0366b(C0365a c0365a, String str) {
        this.aae = str;
    }

    @Override
    public final void run() {
        C0488o.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.aae)));
        C0414f.m2387r(InterfaceC0357a.f2724wS[0], "1");
        C0414f.m2387r(InterfaceC0357a.f2724wS[1], C0463b.m2529qB());
        C0414f.m2387r(InterfaceC0357a.f2724wS[2], String.valueOf(C0463b.m2547qT()));
        C0414f.m2387r(InterfaceC0357a.f2724wS[6], C0463b.m2549qV());
        C0463b.setResult(2);
    }
}
