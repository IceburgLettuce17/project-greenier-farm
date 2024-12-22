package com.gameloft.android2d.iap.p042a.p049f;

import com.gameloft.android2d.iap.C0463b;
import com.gameloft.android2d.iap.utils.C0477d;
import com.gameloft.android2d.iap.utils.C0488o;
import com.gameloft.android2d.iap.utils.C0491r;
import p001a.p004b.p005a.p006a.C0012k;

final class C0406b extends Thread {
    private String acb;
    private String acc;
    private String acd;
    private String ace;
    private String acf;
    private String acg;
    private String ach;
    private String aci;
    private String acj;
    private C0405a ack;

    C0406b(C0405a c0405a, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.ack = c0405a;
        this.acb = str;
        this.acc = str2;
        this.acd = str3;
        this.ace = str4;
        this.acf = str5;
        this.acg = str6;
        this.ach = str7;
        this.aci = str8;
        this.acj = str9;
    }

    @Override
    public final void run() {
        boolean z;
        boolean z2;
        boolean z3 = true;
        C0491r c0491r = new C0491r(new C0477d(this.acb, this.acc));
        C0491r.m2681tf();
        if (C0477d.m2587at() && (C0477d.m2589av() == null || C0477d.m2589av().trim().equals(""))) {
            C0477d.m2594sC();
            this.ack.abY = System.currentTimeMillis();
            this.ack.aca = true;
        } else {
            this.ack.aca = false;
        }
        z = this.ack.aca;
        if (z) {
            while (C0477d.m2596sE()) {
                C0012k.m41c("IAP-HTTPBilling", "Disabling Wi-Fi");
            }
            while (!C0477d.m2598sG() && System.currentTimeMillis() - this.ack.abY <= this.ack.abZ) {
                C0012k.m41c("IAP-HTTPBilling", "Waiting for transference on Phone Data Service");
            }
        }
        if (C0477d.m2593qg()) {
            C0491r.m2668a(this.acd, this.ace, this.acf, this.acg, this.ach, this.aci, this.acj);
            while (!c0491r.m2690ch()) {
                try {
                    Thread.sleep(50L);
                } catch (Exception e) {
                }
            }
            z3 = false;
        }
        z2 = this.ack.aca;
        if (z2) {
            C0477d.m2595sD();
            this.ack.aca = false;
            this.ack.abY = System.currentTimeMillis();
            while (C0477d.m2597sF() && System.currentTimeMillis() - this.ack.abY <= this.ack.abZ) {
                C0012k.m41c("IAP-HTTPBilling", "ENABLING Wi-Fi!!!");
            }
        }
        if (z3) {
            C0463b.setResult(3);
            C0463b.m2521eV(-1);
            return;
        }
        if (C0491r.m2682tg() != 0) {
            C0463b.setResult(3);
            if (C0491r.m2682tg() == -2) {
                C0463b.m2521eV(-1);
                return;
            } else {
                C0463b.m2521eV(C0491r.m2682tg());
                return;
            }
        }
        try {
            if (C0463b.m2498aT(C0488o.m2641ap(c0491r.m2691qB()))) {
                return;
            }
            C0463b.setResult(3);
            C0463b.m2521eV(-5);
        } catch (Exception e2) {
            C0463b.setResult(3);
            C0463b.m2521eV(-5);
            C0012k.m41c("IAP-HTTPBilling", "Exception when verify Unlock code!!!");
        }
    }
}
