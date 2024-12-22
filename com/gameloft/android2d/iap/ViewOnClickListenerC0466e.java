package com.gameloft.android2d.iap;

import android.view.View;

final class ViewOnClickListenerC0466e implements View.OnClickListener {

    private C0465d f2846Zm;

    ViewOnClickListenerC0466e(C0465d c0465d) {
        this.f2846Zm = c0465d;
    }

    @Override
    public final void onClick(View view) {
        C0463b c0463b;
        int i;
        C0463b c0463b2;
        String str;
        C0463b c0463b3;
        c0463b = C0463b.f2809Ym;
        i = c0463b.f2830Yq;
        c0463b2 = C0463b.f2809Ym;
        str = c0463b2.f2831Yr;
        C0463b.m2510c(i, str, this.f2846Zm.f2845Zl);
        c0463b3 = C0463b.f2809Ym;
        c0463b3.f2826YG.cancel();
    }
}
