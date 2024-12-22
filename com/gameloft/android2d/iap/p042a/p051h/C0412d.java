package com.gameloft.android2d.iap.p042a.p051h;

import com.gameloft.android2d.iap.C0463b;
import com.gameloft.android2d.iap.InterfaceC0357a;
import com.gameloft.android2d.iap.p042a.AbstractC0358a;
import com.gameloft.android2d.iap.utils.C0477d;
import com.gameloft.android2d.iap.utils.C0488o;
import com.gameloft.android2d.iap.utils.C0491r;
import p001a.p004b.p005a.p006a.C0012k;

public final class C0412d extends AbstractC0358a implements InterfaceC0357a {
    static C0412d acx = null;

    public C0412d() {
        this.f2744Zq = "samsung";
    }

    public static void m2363eZ(int i) {
        if (i == 1) {
            C0414f.m2381cp("1");
            new C0413e().start();
        } else if (i == 0) {
            C0463b.setResult(10);
        } else if (i == 2) {
            C0463b.setResult(3);
            C0414f.m2379cn("");
            C0414f.m2381cp("");
        }
    }

    @Override
    public final void mo2253bp(String str) {
        acx = this;
        C0491r.aff = true;
        C0012k.m41c("IAP-SamsungBilling", "SamsungBilling an item");
        C0012k.m41c("IAP-SamsungBilling", "[requestPurchaseItem ] getGroupId " + this.f2742ZR + ", itemid = " + this.f2740ZP);
        ActivityC0422n.m2409a(this.f2742ZR, this.f2740ZP, acx);
    }

    @Override
    public final void mo2267rE() {
        C0012k.m41c("IAP-SamsungBilling", "######################### VerificationBilling ##################");
        String m2383fa = C0414f.m2383fa(23);
        String m2383fa2 = C0414f.m2383fa(24);
        String m2383fa3 = C0414f.m2383fa(25);
        String m2383fa4 = C0414f.m2383fa(22);
        String str = "|" + m2383fa + "|" + C0414f.m2389sc() + "|" + C0414f.m2383fa(21) + "|" + C0463b.m2529qB();
        C0463b.setResult(1);
        C0491r c0491r = new C0491r(new C0477d(m2383fa2, m2383fa3));
        if (!C0491r.aff) {
            m2383fa4 = m2383fa4.replace("https", "http");
        }
        C0012k.m41c("IAP-SamsungBilling", "Verification in process: " + m2383fa4 + "?" + str);
        C0491r.m2666J(m2383fa4, str);
        while (!c0491r.m2697tn()) {
            try {
                Thread.sleep(50L);
            } catch (Exception e) {
            }
        }
        if (C0491r.m2682tg() != 0) {
            C0463b.setResult(3);
            if (C0491r.m2682tg() != -1000) {
                C0463b.m2521eV(-1);
                C0491r.aff = false;
                return;
            }
            C0463b.m2521eV(C0491r.m2682tg());
            C0414f.m2381cp("");
            C0414f.m2379cn("");
            C0012k.m41c("IAP-SamsungBilling", "Verification failed!!!!!!!!!!!!!!!!!!!");
            C0463b.m2521eV(-5);
            return;
        }
        try {
            if (C0463b.m2498aT(C0488o.m2641ap(c0491r.m2691qB()))) {
                C0012k.m41c("IAP-SamsungBilling", "Verification successed!!!!!!!!!!!!!!!!!!!");
                C0012k.m41c("IAP-SamsungBilling", "Purchase successed!!!!!!!!!!!!!!!!!!!!!!!");
                C0414f.m2381cp("");
                C0414f.m2379cn(new StringBuilder().append(C0463b.m2554qz()).toString());
                C0012k.m41c("IAP-SamsungBilling", "Saved Pending Transaction Result: " + C0463b.m2554qz());
            } else {
                C0463b.setResult(3);
                C0463b.m2521eV(-5);
            }
        } catch (Exception e2) {
            C0463b.setResult(3);
            C0463b.m2521eV(-5);
            C0012k.m41c("IAP-SamsungBilling", "Exception when verify Unlock code!!!");
        }
    }

    @Override
    public final boolean mo2268rF() {
        C0012k.m41c("IAP-SamsungBilling", "isPendingVerificationBilling");
        String m2368am = C0414f.m2368am(C0414f.f2724wS[16]);
        if (m2368am == "") {
            m2368am = null;
        }
        if (m2368am != null && m2368am.equals("1")) {
            return true;
        }
        C0012k.m41c("IAP-SamsungBilling", "[isPendingVerificationBilling] urlquery " + m2368am);
        return false;
    }

    @Override
    public final boolean mo2269rG() {
        C0012k.m41c("IAP-SamsungBilling", "[isPendingTransaction]" + C0414f.m2396sj());
        String m2396sj = C0414f.m2396sj();
        if (m2396sj == null || !m2396sj.equals("7")) {
            return false;
        }
        C0463b.setResult(C0488o.m2641ap(m2396sj));
        C0414f.m2379cn("");
        return true;
    }
}
