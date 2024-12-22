package com.gameloft.android2d.iap.p042a.p046d;

import com.gameloft.android2d.iap.C0463b;
import com.gameloft.android2d.iap.p042a.AbstractC0358a;
import com.gameloft.android2d.iap.p042a.p047e.p048a.C0368a;
import com.gameloft.android2d.iap.p042a.p051h.C0414f;
import com.gameloft.android2d.iap.utils.C0477d;
import com.gameloft.android2d.iap.utils.C0488o;
import com.gameloft.android2d.iap.utils.C0492s;
import p001a.p004b.p005a.p006a.C0012k;

public final class C0365a extends AbstractC0358a {
    public C0365a() {
        this.f2744Zq = "cc_2d";
    }

    @Override
    public final void mo2252bW(String str) {
        C0414f.m2384h(str, 28);
        C0414f.m2384h(this.url, 29);
    }

    @Override
    public final void mo2253bp(String str) {
        C0012k.m41c("IAP-CCARDBilling", "CCARDBilling an item");
        if (!C0477d.m2593qg()) {
            C0012k.m39a("IAP-CCARDBilling", "Device have no connection, please turn on WIFI or 3G...");
            C0463b.setResult(3);
            C0463b.m2521eV(-1);
            return;
        }
        String str2 = this.url;
        String m2530qC = C0463b.m2530qC();
        String sb = new StringBuilder().append(C0463b.m2547qT()).toString();
        String m2529qB = C0463b.m2529qB();
        String m2655z = C0488o.m2655z(C0368a.m2303e(C0492s.m2699a(m2529qB.getBytes(), str + "gameloft|0Ft$23#?a" + sb)));
        String m2531qD = C0463b.m2531qD();
        if (m2531qD == null || (m2531qD != null && m2531qD.equals(""))) {
            m2531qD = "0";
        }
        if (!m2229bq(str2) || !m2229bq(m2530qC) || !m2229bq(str) || !m2229bq(sb) || !m2229bq(m2529qB)) {
            C0012k.m40b("IAP-CCARDBilling", "IAP_INVALID_REQUEST (-5)");
            C0463b.setResult(3);
            C0463b.m2521eV(-5);
        } else {
            String str3 = str2 + ((((("" + (str2.contains("?") ? "igpcode=" : "?igpcode=") + m2530qC) + "&content_id=" + str) + "&tier=" + sb) + "&stamp=" + m2655z) + "&d=" + m2531qD);
            C0012k.m41c("IAP-CCARDBilling", "Unlock Code: " + m2529qB);
            C0012k.m41c("IAP-CCARDBilling", "CCARD Request: " + str3);
            new C0366b(this, str3).start();
        }
    }

    @Override
    public final String mo2270rH() {
        this.url = C0414f.m2383fa(29);
        return C0414f.m2383fa(28);
    }
}
