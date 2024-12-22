package com.gameloft.android2d.iap.p042a.p043a;

import android.app.Activity;
import com.p020a.p021a.p022a.C0109a;
import com.p020a.p021a.p022a.C0133t;
import p001a.p004b.p005a.p006a.C0012k;

final class C0360b extends C0109a {

    private C0359a f2756ZU;

    public C0360b(C0359a c0359a, Activity activity) {
        super(activity);
        this.f2756ZU = c0359a;
    }

    @Override
    public final void mo240c(boolean z) {
        C0012k.m41c("IAP-AmazonBilling", "onSdkAvailable recieved: Response -" + z);
        C0359a.m2285a(this.f2756ZU, z);
        C0133t.m260S();
    }
}
