package com.gameloft.android2d.iap;

import android.view.View;
import com.gameloft.android.LATAM.GloftGF2H.C0320bt;

final class ViewOnClickListenerC0467f implements View.OnClickListener {
    ViewOnClickListenerC0467f(C0465d c0465d) {
    }

    @Override
    public final void onClick(View view) {
        C0463b c0463b;
        c0463b = C0463b.f2809Ym;
        c0463b.f2826YG.cancel();
        C0463b.setResult(10);
        C0320bt.m1914pX();
    }
}
