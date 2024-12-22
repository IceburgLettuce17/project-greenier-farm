package com.gameloft.android2d.iap;

import android.os.Looper;
import com.gameloft.android2d.iap.p042a.AbstractC0358a;
import com.gameloft.android2d.iap.p042a.p051h.C0414f;
import com.gameloft.android2d.iap.utils.C0477d;
import com.gameloft.android2d.iap.utils.C0483j;
import com.gameloft.android2d.iap.utils.C0489p;
import com.gameloft.android2d.iap.utils.C0490q;
import com.gameloft.android2d.iap.utils.C0491r;
import p001a.p004b.p005a.p006a.C0012k;

final class RunnableC0470i implements Runnable {

    private long f2847Zl;

    private int f2848Zn;

    private String f2849Zo;

    RunnableC0470i(int i, String str, long j) {
        this.f2848Zn = i;
        this.f2849Zo = str;
        this.f2847Zl = j;
    }

    @Override
    public final void run() {
        C0463b c0463b;
        C0489p c0489p;
        boolean z;
        C0463b c0463b2;
        C0489p c0489p2;
        C0463b c0463b3;
        C0463b c0463b4;
        C0463b c0463b5;
        int i;
        C0463b c0463b6;
        String str;
        C0463b c0463b7;
        C0489p c0489p3;
        C0463b c0463b8;
        C0463b c0463b9;
        C0463b c0463b10;
        C0463b c0463b11;
        int i2;
        C0463b c0463b12;
        String str2;
        c0463b = C0463b.f2809Ym;
        c0489p = c0463b.f2827Yn;
        C0490q c0490q = c0489p.aeI;
        int i3 = this.f2848Zn;
        String lowerCase = this.f2849Zo.toLowerCase();
        if (c0490q.m2661cO(lowerCase)) {
            C0012k.m41c("IAP-ShopProfile", "[isNonConsumableItem] itemType " + lowerCase);
            z = c0490q.m2660cN(lowerCase).get(Integer.valueOf(i3)).m2624sU().equalsIgnoreCase("1");
        } else {
            z = false;
        }
        if (z) {
            C0012k.m41c("IAP-IAPLib", "Is non-comsumable item? " + this.f2849Zo);
            C0463b.f2820Zj = null;
            C0463b.m2561rf();
            C0012k.m41c("IAP-IAPLib", "mManagedContentsList = " + C0463b.f2820Zj + ", contentID" + C0463b.m2571v(this.f2848Zn, this.f2849Zo) + " XPlayer.getLastErrorCode() " + C0491r.m2682tg());
            if (C0463b.f2820Zj != null && C0463b.f2820Zj.indexOf("," + C0463b.m2571v(this.f2848Zn, this.f2849Zo) + ",") != -1) {
                C0463b.setResult(7);
                return;
            } else if (C0491r.m2682tg() == -2) {
                C0463b.setResult(3);
                C0463b.m2521eV(-1);
                return;
            }
        }
        Looper.prepare();
        c0463b2 = C0463b.f2809Ym;
        c0489p2 = c0463b2.f2827Yn;
        C0483j c0483j = c0489p2.aeI.m2660cN(this.f2849Zo.toLowerCase()).get(Integer.valueOf(this.f2848Zn));
        AbstractC0358a m2620sQ = c0483j.m2620sQ();
        if (C0463b.f2791YI) {
            c0463b7 = C0463b.f2809Ym;
            c0489p3 = c0463b7.f2827Yn;
            String str3 = c0489p3.aeI.aeW;
            String str4 = "|" + c0483j.getId() + "|" + m2620sQ.m2272rn() + "|" + m2620sQ.m2273ro() + "|" + C0463b.getLanguage().toLowerCase() + "|" + C0463b.m2529qB();
            new C0491r(new C0477d(m2620sQ.m2279ru(), m2620sQ.m2280rv()));
            C0491r.m2667K(str3, str4);
            while (!C0491r.m2684to()) {
                try {
                    Thread.sleep(50L);
                } catch (Exception e) {
                }
            }
            if (C0491r.m2682tg() == 403 || C0491r.m2682tg() == 429) {
                c0463b8 = C0463b.f2809Ym;
                c0463b8.f2825YF.runOnUiThread(new C0471j(this));
                return;
            }
            c0463b9 = C0463b.f2809Ym;
            c0463b9.f2830Yq = this.f2848Zn;
            c0463b10 = C0463b.f2809Ym;
            c0463b10.f2831Yr = this.f2849Zo;
            String str5 = InterfaceC0357a.f2724wS[2];
            c0463b11 = C0463b.f2809Ym;
            i2 = c0463b11.f2830Yq;
            C0414f.m2387r(str5, String.valueOf(i2));
            String str6 = InterfaceC0357a.f2724wS[6];
            c0463b12 = C0463b.f2809Ym;
            str2 = c0463b12.f2831Yr;
            C0414f.m2387r(str6, str2);
            C0012k.m41c("IAP-IAPLib", "Save CC Info, Last price: " + m2620sQ.m2272rn() + ", last Profile Id: " + m2620sQ.getProfileId());
            C0414f.m2373ci(m2620sQ.m2272rn());
            C0414f.m2374cj(m2620sQ.getProfileId());
            C0414f.m2375ck(m2620sQ.m2273ro());
            C0414f.m2376cl(this.f2847Zl > 0 ? String.valueOf(this.f2847Zl) : String.valueOf(C0463b.m2524i(this.f2848Zn, this.f2849Zo)));
            C0414f.m2369c(c0483j.m2619sP());
            C0414f.m2367a(m2620sQ);
            m2620sQ.mo2252bW(c0483j.getId());
            m2620sQ.mo2253bp(c0483j.getId());
        } else {
            c0463b3 = C0463b.f2809Ym;
            c0463b3.f2830Yq = this.f2848Zn;
            c0463b4 = C0463b.f2809Ym;
            c0463b4.f2831Yr = this.f2849Zo;
            String str7 = InterfaceC0357a.f2724wS[2];
            c0463b5 = C0463b.f2809Ym;
            i = c0463b5.f2830Yq;
            C0414f.m2387r(str7, String.valueOf(i));
            String str8 = InterfaceC0357a.f2724wS[6];
            c0463b6 = C0463b.f2809Ym;
            str = c0463b6.f2831Yr;
            C0414f.m2387r(str8, str);
            C0012k.m41c("IAP-IAPLib", "Save CC Info, Last price: " + m2620sQ.m2272rn() + ", last Profile Id: " + m2620sQ.getProfileId());
            C0414f.m2373ci(m2620sQ.m2272rn());
            C0414f.m2374cj(m2620sQ.getProfileId());
            C0414f.m2375ck(m2620sQ.m2273ro());
            C0414f.m2376cl(this.f2847Zl > 0 ? String.valueOf(this.f2847Zl) : String.valueOf(C0463b.m2524i(this.f2848Zn, this.f2849Zo)));
            C0414f.m2369c(c0483j.m2619sP());
            C0414f.m2367a(m2620sQ);
            m2620sQ.mo2252bW(c0483j.getId());
            m2620sQ.mo2253bp(c0483j.getId());
        }
        Looper.loop();
    }
}
