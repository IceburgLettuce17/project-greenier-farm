package com.gameloft.android2d.iap.p042a.p052i;

import com.gameloft.android2d.iap.C0463b;
import com.gameloft.android2d.iap.utils.C0477d;
import com.gameloft.android2d.iap.utils.C0491r;

final class C0438g extends Thread {
    private C0432a ado;
    private String adq;
    private String adr;

    C0438g(C0432a c0432a, String str, String str2) {
        this.ado = c0432a;
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
        String[] m2695tk;
        String unused;
        str = this.ado.f2769Zw;
        str2 = this.ado.f2770Zx;
        C0491r c0491r = new C0491r(new C0477d(str, str2));
        str3 = this.ado.ada;
        str4 = this.ado.f2767Yp;
        str5 = this.ado.adc;
        str6 = this.ado.f2768Zr;
        str7 = this.ado.add;
        str8 = this.ado.ade;
        str9 = this.ado.adf;
        str10 = this.ado.f2771wK;
        String str12 = this.adq;
        str11 = this.ado.f2772wL;
        String m2443sv = C0432a.m2443sv();
        String m2444sw = C0432a.m2444sw();
        String m2445sx = C0432a.m2445sx();
        String m2446sy = C0432a.m2446sy();
        unused = this.ado.adg;
        C0491r.m2670a(str3, str4, str5, str6, str7, str8, str9, str10, str12, str11, m2443sv, m2444sw, m2445sx, m2446sy, this.adr);
        C0432a c0432a = this.ado;
        C0432a.m2442su();
        while (true) {
            m2695tk = c0491r.m2695tk();
            if (m2695tk != null) {
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
        } else {
            this.ado.adh = m2695tk[1];
            this.ado.m2447fc(0);
        }
    }
}
