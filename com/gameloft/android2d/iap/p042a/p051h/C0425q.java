package com.gameloft.android2d.iap.p042a.p051h;

import p001a.p004b.p005a.p006a.C0012k;

final class C0425q implements InterfaceC0421m {
    private ActivityC0422n acO;

    C0425q(ActivityC0422n activityC0422n) {
        this.acO = activityC0422n;
    }

    @Override
    public final void mo2406fb(int i) {
        if (i == 0) {
            ActivityC0422n.m2413d(this.acO);
        } else {
            C0012k.m40b("IAP-SamsungIABActivity", "In-app Purchase Service Bind failed.");
            this.acO.m2416u(0, true);
        }
    }
}