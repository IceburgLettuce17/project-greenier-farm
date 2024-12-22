package com.gameloft.android2d.iap.p042a.p047e;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import com.gameloft.android.wrapper.C0355i;
import com.gameloft.android2d.iap.C0463b;
import com.gameloft.android2d.iap.p042a.AbstractC0358a;
import com.gameloft.android2d.iap.p042a.p051h.C0414f;
import com.gameloft.android2d.iap.utils.C0477d;
import com.gameloft.android2d.iap.utils.C0483j;
import com.gameloft.android2d.iap.utils.C0488o;
import com.gameloft.android2d.iap.utils.C0490q;
import com.gameloft.android2d.iap.utils.C0491r;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p001a.p004b.p005a.p006a.C0012k;

public final class C0388j extends AbstractC0358a {
    private static C0392n aaE;
    private static boolean aaG = false;
    private C0390l aaD;
    private String aaF = null;
    C0402x aaH = new C0402x(this);
    C0400v aaI = new C0400v(this);
    C0399u aaJ = new C0399u(this);
    private ServiceC0367a aad;
    private Handler mHandler;

    public C0388j() {
        this.f2744Zq = "google";
    }

    private static JSONObject m2332b(String str, String str2, String[] strArr) {
        C0012k.m41c("IAP-GoogleBilling", "createGoogleItemJSON");
        HashMap hashMap = new HashMap();
        String str3 = "";
        if (strArr != null) {
            for (String str4 : strArr) {
                str3 = str3 + str4 + ";";
            }
        }
        hashMap.put("uid", str);
        hashMap.put("amount", str2);
        hashMap.put("offline-items", str3);
        return new JSONObject(hashMap);
    }

    public static boolean m2333ca(String str) {
        C0483j c0483j;
        if (!C0463b.f2806YX) {
            return false;
        }
        C0490q m2528qA = C0463b.m2528qA();
        if (str != null) {
            Enumeration<String> keys = m2528qA.aeL.keys();
            while (keys.hasMoreElements()) {
                c0483j = m2528qA.aeL.get(keys.nextElement());
                if (str.equals(c0483j.m2617cz("google").f2740ZP)) {
                    break;
                }
            }
        }
        c0483j = null;
        if (c0483j == null) {
            return false;
        }
        C0012k.m41c("IAP-GoogleBilling", "Found item, comsume it!!!");
        AbstractC0358a m2620sQ = c0483j.m2620sQ();
        C0414f.m2373ci(m2620sQ.f2745Zr);
        C0414f.m2374cj(m2620sQ.profileId);
        C0414f.m2375ck(m2620sQ.f2746Zs);
        C0414f.m2367a(m2620sQ);
        return true;
    }

    public static boolean m2334f(String str, boolean z) {
        C0012k.m41c("IAP-GoogleBilling", "PushOutGoogleItemInfoPurchased");
        String m2383fa = C0414f.m2383fa(35);
        C0012k.m41c("IAP-GoogleBilling", "PushOutGoogleItemInfoPurchased - JSON load:" + m2383fa);
        if (m2383fa == null || m2383fa.equals("")) {
            return false;
        }
        try {
            JSONArray jSONArray = new JSONArray(m2383fa);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject.getString("uid").equals(str)) {
                    C0012k.m41c("IAP-GoogleBilling", "PushOutGoogleItemInfoPurchased - Find out item purchased");
                    if (z) {
                        C0012k.m41c("IAP-GoogleBilling", "PushOutGoogleItemInfoPurchased - Save item to game");
                        C0414f.m2376cl(jSONObject.getString("amount"));
                        C0414f.m2369c(jSONObject.getString("offline-items").split(";"));
                    }
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        arrayList.add(jSONArray.getJSONObject(i2).toString());
                    }
                    arrayList.remove(i);
                    JSONArray jSONArray2 = new JSONArray((Collection) arrayList);
                    C0012k.m41c("IAP-GoogleBilling", "PushOutGoogleItemInfoPurchased - JSON array is saved:" + jSONArray2.toString());
                    C0414f.m2384h(jSONArray2.toString(), 35);
                    return true;
                }
            }
            return false;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean m2335rS() {
        return aaG;
    }

    public final void m2337a(String str, String str2, String[] strArr) {
        C0012k.m41c("IAP-GoogleBilling", "PushInGoogleItemInfoPurchased");
        String m2383fa = C0414f.m2383fa(35);
        C0012k.m41c("IAP-GoogleBilling", "PushInGoogleItemInfoPurchased - JSON load:" + m2383fa);
        if (m2383fa == null || m2383fa.equals("")) {
            C0012k.m41c("IAP-GoogleBilling", "PushInGoogleItemInfoPurchased - JSON array not exist");
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(m2332b(str, str2, strArr));
            C0012k.m41c("IAP-GoogleBilling", "PushInGoogleItemInfoPurchased - JSON array is saved:" + jSONArray.toString());
            C0414f.m2384h(jSONArray.toString(), 35);
            return;
        }
        try {
            JSONArray jSONArray2 = new JSONArray(m2383fa);
            for (int i = 0; i < jSONArray2.length(); i++) {
                if (jSONArray2.getJSONObject(i).getString("uid").equals(str)) {
                    C0012k.m41c("IAP-GoogleBilling", "PushInGoogleItemInfoPurchased - Item existed");
                    return;
                }
            }
            jSONArray2.put(m2332b(str, str2, strArr));
            C0012k.m41c("IAP-GoogleBilling", "PushInGoogleItemInfoPurchased - JSON array is saved:" + jSONArray2.toString());
            C0414f.m2384h(jSONArray2.toString(), 35);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public final void mo2253bp(String str) {
        try {
            C0463b.m2559rd();
        } catch (Exception e) {
            C0012k.m41c("IAP-GoogleBilling", "Bill Exception : " + e.getMessage());
        }
        if (C0463b.f2819Zi == 1) {
            C0463b.setResult(3);
            return;
        }
        C0012k.m41c("IAP-GoogleBilling", "GoogleBilling an item");
        this.aaF = this.f2740ZP;
        C0491r.aff = true;
        if (C0463b.f2790YH) {
            C0463b.setResult(1);
            C0012k.m41c("IAP-GoogleBilling", "setupGoogleBillingV3");
            C0463b.f2806YX = false;
            m2338rT();
            return;
        }
        Activity activity = (Activity) C0488o.getContext();
        this.mHandler = new Handler();
        this.aaD = new C0390l(this, this.mHandler);
        this.aad = new ServiceC0367a();
        this.aad.setContext(activity);
        C0375af.m2309a(this.aaD);
        if (!this.aad.m2300rK()) {
            C0463b.setResult(3);
        } else if (!this.aad.m2298bY("subs")) {
            C0463b.setResult(3);
        } else {
            this.aad.m2299f(this.aaF, "inapp", "");
            C0463b.setResult(1);
        }
    }

    @Override
    public final void mo2267rE() {
        C0012k.m41c("IAP-GoogleBilling", "######################### VerificationBilling ##################");
        String m2397sk = C0414f.m2397sk();
        String m2383fa = C0414f.m2383fa(23);
        String m2383fa2 = C0414f.m2383fa(24);
        String m2383fa3 = C0414f.m2383fa(25);
        String m2383fa4 = C0414f.m2383fa(22);
        String str = "|" + m2383fa + "|" + C0414f.m2389sc() + "|" + C0414f.m2383fa(21) + "|" + C0463b.m2529qB() + "|" + m2397sk;
        String m2222qs = C0355i.m2222qs();
        if (C0488o.m2643bq(m2222qs)) {
            str = str + "&injected_igp=" + m2222qs;
        }
        String m2223qt = C0355i.m2223qt();
        if (C0488o.m2643bq(m2223qt)) {
            str = str + "&d=" + m2223qt;
        }
        C0012k.m41c("IAP-GoogleBilling", "injectedIGPCode: " + m2222qs + ", injectedSerialKey=" + m2223qt);
        C0463b.setResult(1);
        C0491r c0491r = new C0491r(new C0477d(m2383fa2, m2383fa3));
        if (!C0491r.aff) {
            m2383fa4 = m2383fa4.replace("https", "http");
        }
        C0012k.m41c("IAP-GoogleBilling", "Verification in process: " + m2383fa4 + "?" + str);
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
                C0012k.m41c("IAP-GoogleBilling", "Verification failed!!!!!!!!!!!!!!!!!!!");
                return;
            }
        }
        try {
            if (C0463b.m2498aT(C0488o.m2641ap(c0491r.m2691qB()))) {
                C0012k.m41c("IAP-GoogleBilling", "Verification successed!!!!!!!!!!!!!!!!!!!");
                C0012k.m41c("IAP-GoogleBilling", "Purchase successed!!!!!!!!!!!!!!!!!!!!!!!");
                C0414f.m2380co("");
                C0414f.m2379cn(new StringBuilder().append(C0463b.m2554qz()).toString());
                C0012k.m41c("IAP-GoogleBilling", "Saved Pending Transaction Result: " + C0463b.m2554qz());
            } else {
                C0463b.setResult(3);
                C0463b.m2521eV(-5);
            }
        } catch (Exception e2) {
            C0463b.setResult(3);
            C0463b.m2521eV(-5);
            C0012k.m41c("IAP-GoogleBilling", "Exception when verify Unlock code!!!");
        }
    }

    @Override
    public final boolean mo2268rF() {
        String m2397sk = C0414f.m2397sk();
        C0012k.m41c("IAP-GoogleBilling", "[isPendingVerificationBilling] orderId: " + m2397sk);
        if (m2397sk != null && !m2397sk.equals("")) {
            return true;
        }
        if (C0463b.f2806YX) {
            C0012k.m41c("IAP-GoogleBilling", "Comsume Google items at begin game!!!");
            m2338rT();
        }
        return false;
    }

    @Override
    public final boolean mo2269rG() {
        C0012k.m41c("IAP-GoogleBilling", "[ isPendingTransaction] ");
        try {
            String m2395si = C0414f.m2395si();
            String m2396sj = C0414f.m2396sj();
            C0012k.m41c("IAP-GoogleBilling", "mSavedNotify: " + m2395si + " Pending State: " + m2396sj);
            if (m2395si == null || m2395si.equals("") || m2396sj == null || m2396sj.equals("")) {
                C0414f.m2377cm("");
                C0414f.m2379cn("");
                return false;
            }
            C0012k.m41c("IAP-GoogleBilling", "Restore last purchase state: " + m2396sj);
            C0463b.setResult(C0488o.m2641ap(m2396sj));
            return true;
        } catch (Exception e) {
            C0012k.m41c("IAP-GoogleBilling", "Exception in CheckPendingTransaction: " + e);
            C0414f.m2377cm("");
            C0414f.m2379cn("");
            return false;
        }
    }

    public final void m2338rT() {
        if (aaG) {
            C0012k.m41c("IAP-GoogleBilling", "Setup already. Querying inventory.");
            aaE.m2349a(this.aaH);
            return;
        }
        String m2540qM = C0463b.m2540qM();
        if (m2540qM == null || m2540qM == "") {
            C0012k.m41c("IAP-GoogleBilling", "The public key is invalid.");
            C0463b.setResult(3);
            throw new RuntimeException("The public key is invalid.");
        }
        C0012k.m41c("IAP-GoogleBilling", "Creating IAB helper.");
        C0392n c0392n = new C0392n((Activity) C0488o.getContext(), m2540qM);
        aaE = c0392n;
        c0392n.aaM = true;
        C0012k.m41c("IAP-GoogleBilling", "Starting setup.");
        C0392n c0392n2 = aaE;
        C0401w c0401w = new C0401w(this);
        if (c0392n2.aaO) {
            throw new IllegalStateException("IAB helper is already set up.");
        }
        c0392n2.m2351cd("Starting in-app billing setup.");
        c0392n2.aaT = new ServiceConnectionC0393o(c0392n2, c0401w);
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        if (!c0392n2.mContext.getPackageManager().queryIntentServices(intent, 0).isEmpty()) {
            c0392n2.mContext.bindService(intent, c0392n2.aaT, 1);
        } else if (c0401w != null) {
            c0401w.m2356a(new C0403y(3, "Billing service unavailable on device."));
        }
    }
}
