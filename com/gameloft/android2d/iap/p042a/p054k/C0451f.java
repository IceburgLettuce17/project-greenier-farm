package com.gameloft.android2d.iap.p042a.p054k;

import com.gameloft.android2d.iap.C0463b;
import com.gameloft.android2d.iap.p042a.p051h.C0414f;
import com.gameloft.android2d.iap.utils.C0477d;
import com.gameloft.android2d.iap.utils.C0491r;

final class C0451f extends Thread {
    final C0446a adF;
    private String adq;
    private String adr;

    C0451f(C0446a c0446a, String str, String str2) {
        this.adF = c0446a;
        this.adq = str;
        this.adr = str2;
    }

    @Override
    public final void run() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String[] m2693ti;
        String str13;
        String unused;
        str = this.adF.f2780Zw;
        str2 = this.adF.f2781Zx;
        C0491r c0491r = new C0491r(new C0477d(str, str2));
        str3 = this.adF.ada;
        str4 = this.adF.f2778Yp;
        str5 = this.adF.adc;
        str6 = this.adF.f2779Zr;
        str7 = this.adF.add;
        str8 = this.adF.ade;
        str9 = this.adF.adf;
        str10 = this.adF.f2782wK;
        str11 = this.adF.adx;
        String str14 = this.adq;
        str12 = this.adF.f2783wL;
        unused = this.adF.adg;
        C0491r.m2669a(str3, str4, str5, str6, str7, str8, str9, str10, str11, str14, str12, this.adr);
        while (true) {
            m2693ti = c0491r.m2693ti();
            if (m2693ti != null) {
                break;
            } else {
                try {
                    Thread.sleep(50L);
                } catch (Exception e) {
                }
            }
        }
        if (C0491r.m2682tg() != 0) {
            C0463b.setResult(3);
            C0463b.m2521eV(C0491r.m2682tg());
            return;
        }
        this.adF.adh = m2693ti[1];
        str13 = this.adF.adh;
        C0414f.m2379cn(str13);
        this.adF.adA = m2693ti[2];
        this.adF.adB = m2693ti[3];
        this.adF.f2777YF.runOnUiThread(new C0452g(this));
    }
}
