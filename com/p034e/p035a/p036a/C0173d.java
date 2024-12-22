package com.p034e.p035a.p036a;

import android.os.Bundle;
import android.webkit.CookieSyncManager;

final class C0173d implements InterfaceC0177f {

    private final int f123Ye;
    private C0162b ahE;
    private final InterfaceC0177f ahF;

    C0173d(C0162b c0162b, int i, InterfaceC0177f interfaceC0177f) {
        this.ahE = c0162b;
        this.f123Ye = i;
        this.ahF = interfaceC0177f;
    }

    @Override
    public final void mo318a(C0180i c0180i) {
        this.ahF.mo318a(c0180i);
    }

    @Override
    public final void mo319a(C0181j c0181j) {
        this.ahF.mo319a(c0181j);
    }

    @Override
    public final void onCancel() {
        this.ahF.onCancel();
    }

    @Override
    public final void onComplete(Bundle bundle) {
        CookieSyncManager.getInstance().sync();
        String string = bundle.getString("code");
        if (1 == this.f123Ye) {
            C0162b.m293a(this.ahE, string);
        } else if (this.f123Ye == 0) {
            this.ahF.onComplete(bundle);
        }
    }
}
