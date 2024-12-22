package com.gameloft.android2d.iap.p042a.p054k;

import com.gameloft.android2d.iap.C0463b;
import com.gameloft.android2d.iap.utils.C0477d;
import com.gameloft.android2d.iap.utils.C0491r;
import java.math.BigInteger;
import java.security.MessageDigest;
import p001a.p004b.p005a.p006a.C0012k;

final class C0455j extends Thread {
    private C0446a adF;
    private int ads;

    C0455j(C0446a c0446a, int i) {
        this.adF = c0446a;
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
        str = this.adF.f2780Zw;
        str2 = this.adF.f2781Zx;
        C0491r c0491r = new C0491r(new C0477d(str, str2));
        String l = Long.toString(System.currentTimeMillis());
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            StringBuilder sb = new StringBuilder();
            str3 = this.adF.adh;
            StringBuilder append = sb.append(str3).append('_');
            str4 = this.adF.f2782wK;
            messageDigest.update(append.append(str4).append('_').append(l).append('_').append("UMPGAMELOFT").toString().getBytes());
            byte[] digest = messageDigest.digest();
            String format = String.format("%0" + (digest.length << 1) + "x", new BigInteger(1, digest));
            str5 = this.adF.adb;
            str6 = this.adF.adh;
            str7 = this.adF.f2782wK;
            C0491r.m2678d(str5, str6, l, str7, format);
            while (!c0491r.m2694tj()) {
                try {
                    Thread.sleep(50L);
                } catch (Exception e) {
                }
            }
            if (C0491r.m2682tg() == 0) {
                C0463b.setResult(7);
                C0463b.m2552qY();
            } else if (this.ads <= 4) {
                C0456k.m2489a(5L, this.ads + 1, this.adF);
            } else {
                C0463b.setResult(3);
                C0463b.m2521eV(C0491r.m2682tg());
            }
        } catch (Exception e2) {
            C0012k.m40b("IAP-UMPBilling", "Exception when creating signature in checkBilling");
            C0463b.setResult(3);
            C0463b.m2521eV(-11);
        }
    }
}
