package com.gameloft.android2d.socialnetwork;

import android.os.Bundle;
import com.facebook.android.Facebook;
import com.p034e.p035a.p036a.C0156a;
import com.p034e.p035a.p036a.C0180i;
import com.p034e.p035a.p036a.C0181j;
import com.p034e.p035a.p036a.InterfaceC0177f;

final class C0512as implements InterfaceC0177f {
    C0512as() {
    }

    @Override
    public final void mo318a(C0180i c0180i) {
        String str = "Weibo : Login Error : " + c0180i;
    }

    @Override
    public final void mo319a(C0181j c0181j) {
        String str = "Weibo : Login IO Error: " + c0181j;
    }

    @Override
    public final void onCancel() {
        C0511ar.m2754af(true);
    }

    @Override
    public final void onComplete(Bundle bundle) {
        C0156a c0156a;
        String string = bundle.getString("code");
        if (string != null) {
            String str = "Weibo : Login Error : " + string;
            return;
        }
        C0511ar.m2754af(false);
        C0156a unused = C0511ar.ahj = new C0156a(bundle.getString("access_token"), bundle.getString(Facebook.EXPIRES));
        c0156a = C0511ar.ahj;
        if (c0156a.isSessionValid()) {
            C0511ar.m2761dn();
        }
    }
}
