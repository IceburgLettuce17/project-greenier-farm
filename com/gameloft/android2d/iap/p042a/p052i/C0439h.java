package com.gameloft.android2d.iap.p042a.p052i;

import com.gameloft.android2d.iap.C0463b;
import com.gameloft.android2d.iap.utils.C0477d;
import com.gameloft.android2d.iap.utils.C0491r;
import java.math.BigInteger;
import java.security.MessageDigest;
import p001a.p004b.p005a.p006a.C0012k;

final class C0439h extends Thread {
    private C0432a ado;
    private int ads;

    C0439h(C0432a c0432a, int i) {
        this.ado = c0432a;
        this.ads = i;
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
        str = this.ado.f2769Zw;
        str2 = this.ado.f2770Zx;
        C0491r c0491r = new C0491r(new C0477d(str, str2));
        String l = Long.toString(System.currentTimeMillis());
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            StringBuilder sb = new StringBuilder();
            str3 = this.ado.adh;
            StringBuilder append = sb.append(str3).append('_');
            str4 = this.ado.f2771wK;
            messageDigest.update(append.append(str4).append('_').append(l).append('_').append("SHENZHOUFUGAMELOFT").toString().getBytes());
            byte[] digest = messageDigest.digest();
            String format = String.format("%0" + (digest.length << 1) + "x", new BigInteger(1, digest));
            str5 = this.ado.adb;
            str6 = this.ado.adh;
            str7 = this.ado.f2771wK;
            C0491r.m2679e(str5, str6, l, str7, format);
            while (!c0491r.m2696tl()) {
                try {
                    Thread.sleep(50L);
                } catch (Exception e) {
                }
            }
            if (C0491r.m2682tg() == 0) {
                C0463b.setResult(7);
                C0463b.m2552qY();
            } else if (this.ads <= 4) {
                C0440i.m2448a(5L, this.ads + 1, this.ado);
            } else {
                C0463b.setResult(3);
                C0463b.m2521eV(C0491r.m2682tg());
            }
        } catch (Exception e2) {
            C0012k.m40b("IAP-ShenzhoufuBilling", "Exception when creating signature in checkBilling");
            C0463b.setResult(3);
            C0463b.m2521eV(-11);
        }
    }
}
