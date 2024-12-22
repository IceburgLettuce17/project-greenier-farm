package com.gameloft.android2d.iap.p042a.p043a;

import android.app.Activity;
import com.gameloft.android2d.iap.C0463b;
import com.gameloft.android2d.iap.p042a.AbstractC0358a;
import com.gameloft.android2d.iap.p042a.p051h.C0414f;
import com.gameloft.android2d.iap.utils.C0477d;
import com.gameloft.android2d.iap.utils.C0488o;
import com.gameloft.android2d.iap.utils.C0491r;
import com.p020a.p021a.p022a.C0133t;
import p001a.p004b.p005a.p006a.C0012k;

public final class C0359a extends AbstractC0358a {

    private Activity f2754YF;

    private C0360b f2755ZT;

    public C0359a() {
        C0012k.m41c("IAP-AmazonBilling", "Created AmazonBilling");
        this.f2744Zq = "amazon";
        if (C0414f.m2397sk() == null || C0414f.m2397sk().equals("")) {
            this.f2754YF = (Activity) C0488o.getContext();
            this.f2755ZT = new C0360b(this, this.f2754YF);
            C0133t.m262a(this.f2755ZT);
        }
    }

    static boolean m2285a(C0359a c0359a, boolean z) {
        return z;
    }

    @Override
    public final void mo2253bp(String str) {
        C0012k.m41c("IAP-AmazonBilling", "AmazonBilling an item: " + this.f2740ZP);
        C0133t.m263f(this.f2740ZP);
        C0463b.setResult(1);
    }

    @Override
    public final void mo2267rE() {
        C0012k.m41c("IAP-AmazonBilling", "######################### VerificationBilling ##################");
        String m2397sk = C0414f.m2397sk();
        String m2368am = C0414f.m2368am(C0414f.f2724wS[15]);
        if (m2368am == "") {
            m2368am = null;
        }
        String m2383fa = C0414f.m2383fa(23);
        String m2383fa2 = C0414f.m2383fa(24);
        String m2383fa3 = C0414f.m2383fa(25);
        String m2383fa4 = C0414f.m2383fa(22);
        String str = "|" + m2383fa + "|" + C0414f.m2389sc() + "|" + C0414f.m2383fa(21) + "|" + C0463b.m2529qB() + "|" + m2397sk + "|" + m2368am;
        C0463b.setResult(1);
        C0491r c0491r = new C0491r(new C0477d(m2383fa2, m2383fa3));
        C0012k.m41c("IAP-AmazonBilling", "Verification in process: " + m2383fa4 + str);
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
            } else {
                C0463b.m2521eV(C0491r.m2682tg());
                C0414f.m2380co("");
                C0414f.m2379cn("");
                C0012k.m41c("IAP-AmazonBilling", "Verification failed!!!!!!!!!!!!!!!!!!!");
                return;
            }
        }
        try {
            if (C0463b.m2498aT(C0488o.m2641ap(c0491r.m2691qB()))) {
                C0012k.m41c("IAP-AmazonBilling", "Verification successed!!!!!!!!!!!!!!!!!!!");
                C0012k.m41c("IAP-AmazonBilling", "Purchase successed!!!!!!!!!!!!!!!!!!!!!!!");
                C0414f.m2380co("");
                C0414f.m2379cn(new StringBuilder().append(C0463b.m2554qz()).toString());
                C0012k.m41c("IAP-AmazonBilling", "Saved Pending Transaction Result: " + C0463b.m2554qz());
            } else {
                C0463b.setResult(3);
                C0463b.m2521eV(-5);
            }
        } catch (Exception e2) {
            C0463b.setResult(3);
            C0463b.m2521eV(-5);
            C0012k.m41c("IAP-AmazonBilling", "Exception when verify Unlock code!!!");
        }
    }

    @Override
    public final boolean mo2268rF() {
        String m2397sk = C0414f.m2397sk();
        C0012k.m41c("IAP-AmazonBilling", "[isPendingVerificationBilling] orderId: " + m2397sk);
        return (m2397sk == null || m2397sk.equals("")) ? false : true;
    }

    @Override
    public final boolean mo2269rG() {
        C0012k.m41c("IAP-AmazonBilling", "[ isPendingTransaction] ");
        try {
            String m2395si = C0414f.m2395si();
            String m2396sj = C0414f.m2396sj();
            C0012k.m41c("IAP-AmazonBilling", "mSavedNotify: " + m2395si + " Pending State: " + m2396sj);
            if (m2395si == null || m2396sj == null) {
                C0414f.m2377cm("");
                C0414f.m2379cn("");
                return false;
            }
            C0012k.m41c("IAP-AmazonBilling", "Restore last purchase state: " + m2396sj);
            C0463b.setResult(C0488o.m2641ap(m2396sj));
            return true;
        } catch (Exception e) {
            C0012k.m41c("IAP-AmazonBilling", "Exception in CheckPendingTransaction: " + e);
            C0414f.m2377cm("");
            C0414f.m2379cn("");
            return false;
        }
    }
}
