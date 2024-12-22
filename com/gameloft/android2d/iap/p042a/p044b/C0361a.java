package com.gameloft.android2d.iap.p042a.p044b;

import android.app.Activity;
import android.provider.Settings;
import com.gameloft.android2d.iap.C0463b;
import com.gameloft.android2d.iap.p042a.AbstractC0358a;
import com.gameloft.android2d.iap.p042a.p051h.C0414f;
import com.gameloft.android2d.iap.utils.C0477d;
import com.gameloft.android2d.iap.utils.C0484k;
import com.gameloft.android2d.iap.utils.C0488o;
import com.gameloft.android2d.iap.utils.C0491r;
import java.util.HashMap;
import p001a.p004b.p005a.p006a.C0012k;

public final class C0361a extends AbstractC0358a {

    public static C0361a f2757ZV = null;

    public C0361a() {
        this.f2744Zq = "wap_amazon";
    }

    private static String m2286bX(String str) {
        new C0491r(new C0477d(C0414f.m2383fa(24), C0414f.m2383fa(25)));
        C0491r.m2677cT(str);
        while (!C0491r.m2688ts()) {
            try {
                Thread.sleep(50L);
            } catch (Exception e) {
            }
        }
        if (C0491r.m2682tg() != 0) {
            C0012k.m41c("IAP-AmazonPayBilling", "TimeStamp request failed");
            return null;
        }
        String m2689tt = C0491r.m2689tt();
        C0012k.m41c("IAP-AmazonPayBilling", "TimeStamp request success = " + m2689tt);
        return m2689tt;
    }

    @Override
    public final void mo2253bp(String str) {
        C0012k.m41c("IAP-AmazonPayBilling", "AmazonPayBilling an item");
        try {
            f2757ZV = this;
            String str2 = this.url;
            String m2286bX = m2286bX(str2);
            if (m2286bX == null) {
                C0463b.setResult(3);
                C0463b.m2521eV(-1);
            } else {
                String substring = m2286bX.substring(2, m2286bX.length() - 2);
                C0491r.m2681tf();
                String m2588au = C0477d.m2588au();
                String m2530qC = C0463b.m2530qC();
                String property = System.getProperty("UserName");
                String m2649cJ = C0488o.m2649cJ("0_" + property + "_" + str + "_" + m2588au + "_gameloft");
                String m2628g = C0484k.m2628g(new C0484k(C0488o.m2649cJ(m2649cJ).substring(0, 16), m2649cJ.substring(6, m2649cJ.length()) + substring).m2629cC("IAPOK" + Settings.Secure.getString(C0488o.getContext().getContentResolver(), "android_id")));
                HashMap hashMap = new HashMap();
                hashMap.put("x-up-gl-ggi", "0");
                hashMap.put("x-up-gl-acnum", property);
                hashMap.put("x-up-gl-imei", m2588au);
                hashMap.put("uandroid", m2628g);
                ((Activity) C0488o.getContext()).runOnUiThread(new C0362b(this, str2, property, str, m2649cJ, m2530qC, hashMap));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public final void mo2267rE() {
        C0012k.m41c("IAP-AmazonPayBilling", "######################### VerificationBilling ##################");
        String m2383fa = C0414f.m2383fa(24);
        String m2383fa2 = C0414f.m2383fa(25);
        String str = "purchase_id=" + C0414f.m2400sn();
        C0463b.setResult(1);
        C0491r c0491r = new C0491r(new C0477d(m2383fa, m2383fa2));
        C0012k.m41c("IAP-AmazonPayBilling", "Verification in process: https://secure.gameloft.com/freemium/wapbilling/validate.php?" + str);
        C0491r.m2666J("https://secure.gameloft.com/freemium/wapbilling/validate.php", str);
        while (!c0491r.m2697tn()) {
            try {
                Thread.sleep(50L);
            } catch (Exception e) {
            }
        }
        if (C0491r.m2682tg() == 0) {
            C0463b.m2552qY();
            C0463b.setResult(7);
            C0012k.m41c("IAP-AmazonPayBilling", "Verification successed!!!!!!!!!!!!!!!!!!!");
            C0012k.m41c("IAP-AmazonPayBilling", "Purchase successed!!!!!!!!!!!!!!!!!!!!!!!");
            C0414f.m2382cq("");
            C0414f.m2379cn(new StringBuilder().append(C0463b.m2554qz()).toString());
            C0012k.m41c("IAP-AmazonPayBilling", "Saved Pending Transaction Result: " + C0463b.m2554qz());
            return;
        }
        C0463b.setResult(3);
        if (C0491r.m2682tg() != -1000) {
            C0463b.m2521eV(-1);
            return;
        }
        C0463b.m2521eV(C0491r.m2682tg());
        C0414f.m2382cq("");
        C0414f.m2379cn("");
        C0012k.m41c("IAP-AmazonPayBilling", "Verification failed!!!!!!!!!!!!!!!!!!!");
    }

    @Override
    public final boolean mo2268rF() {
        String m2400sn = C0414f.m2400sn();
        C0012k.m41c("IAP-AmazonPayBilling", "[isPendingVerificationBilling] wapPurchaseId: " + m2400sn);
        return (m2400sn == null || m2400sn.equals("")) ? false : true;
    }

    @Override
    public final boolean mo2269rG() {
        C0012k.m41c("IAP-AmazonPayBilling", "[isPendingTransaction]" + C0414f.m2396sj());
        String m2396sj = C0414f.m2396sj();
        if (m2396sj == null || !m2396sj.equals("7")) {
            return false;
        }
        C0463b.setResult(C0488o.m2641ap(m2396sj));
        C0414f.m2379cn("");
        return true;
    }
}
