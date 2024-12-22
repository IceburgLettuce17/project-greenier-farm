package com.gameloft.android2d.iap.p042a.p053j;

import com.gameloft.android2d.iap.C0463b;
import com.gameloft.android2d.iap.p042a.AbstractC0358a;
import com.gameloft.android2d.iap.p042a.p051h.C0414f;
import com.gameloft.android2d.iap.utils.C0476c;
import com.gameloft.android2d.iap.utils.C0477d;
import com.gameloft.android2d.iap.utils.C0487n;
import com.gameloft.android2d.iap.utils.C0488o;
import com.gameloft.android2d.iap.utils.C0491r;
import com.gameloft.android2d.iap.utils.C0492s;
import java.util.Locale;
import p001a.p004b.p005a.p006a.C0012k;

public final class C0441a extends AbstractC0358a {
    private static C0445e adv;

    private String f2775wM;

    public C0441a() {
        this.f2744Zq = "sms_2d";
        adv = new C0445e(this);
    }

    private void m2451af(String str) {
        if (str != null) {
            this.f2775wM += str + " ";
        }
    }

    private void m2452cs(String str) {
        C0463b.m2499ac(true);
        C0463b.m2502ae(false);
        C0414f.m2387r(f2724wS[0], "0");
        this.f2775wM = "";
        String str2 = this.f2753Zz;
        String m2530qC = C0463b.m2530qC();
        String m2529qB = C0463b.m2529qB();
        String str3 = C0463b.m2528qA().aeU;
        String str4 = this.profileId;
        String upperCase = C0463b.getLanguage().toUpperCase();
        C0012k.m41c("IAP-SMSBilling", "Game language:        " + upperCase);
        String m2531qD = (C0463b.m2531qD() == null || C0463b.m2531qD().equals("")) ? "0" : C0463b.m2531qD();
        C0491r.m2681tf();
        String m2588au = C0477d.m2588au();
        String valueOf = String.valueOf(C0414f.m2372cF());
        int m2399sm = C0414f.m2399sm();
        String str5 = "ct" + m2399sm;
        if (upperCase == null || upperCase.equals("")) {
            C0012k.m41c("IAP-SMSBilling", "Warning, Missing input language from game setting, get language from phone settings instead.");
            upperCase = Locale.getDefault().getLanguage().toUpperCase();
        }
        C0012k.m41c("IAP-SMSBilling", "alias:        " + str2);
        C0012k.m41c("IAP-SMSBilling", "demoCode:     " + m2530qC);
        C0012k.m41c("IAP-SMSBilling", "unlockCode:   " + m2529qB);
        C0012k.m41c("IAP-SMSBilling", "phoneModel:   " + str3);
        C0012k.m41c("IAP-SMSBilling", "profileID:    " + str4);
        C0012k.m41c("IAP-SMSBilling", "lang:         " + upperCase);
        C0012k.m41c("IAP-SMSBilling", "contentID:    " + str);
        C0012k.m41c("IAP-SMSBilling", "downloadCode: " + m2531qD);
        C0012k.m41c("IAP-SMSBilling", "IMEI:         " + m2588au);
        C0012k.m41c("IAP-SMSBilling", "amount:       " + valueOf);
        C0012k.m41c("IAP-SMSBilling", "SMSCounter:   " + str5);
        if (!m2229bq(m2530qC) || !m2229bq(m2529qB) || !m2229bq(str3) || !m2229bq(str4)) {
            C0012k.m40b("IAP-SMSBilling", "IAP_INVALID_REQUEST (-5)");
            C0463b.setResult(3);
            C0463b.m2521eV(-5);
            return;
        }
        if (!m2229bq(str)) {
            C0012k.m40b("IAP-SMSBilling", "IAP_ERROR_ITEM_NOT_AVAILABLE (-2)");
            C0463b.setResult(3);
            C0463b.m2521eV(-2);
            return;
        }
        if (C0463b.m2543qP()) {
            this.f2775wM = "100000";
            int i = 0;
            if (this.type.equals("7")) {
                this.f2775wM += "00";
            } else {
                this.f2775wM += "01";
            }
            if (!m2530qC.equals("") && !m2530qC.equals("0")) {
                String m2453j = m2453j(Long.parseLong(m2530qC, 36));
                this.f2775wM += "000000";
                while (m2453j.length() + i < 21) {
                    this.f2775wM += "0";
                    i++;
                }
                i = 0;
                this.f2775wM += m2453j;
            }
            if (!m2529qB.equals("")) {
                String binaryString = Integer.toBinaryString(Integer.parseInt(m2529qB));
                this.f2775wM += "000001";
                while (binaryString.length() + i < 14) {
                    this.f2775wM += "0";
                    i++;
                }
                i = 0;
                this.f2775wM += binaryString;
            }
            if (!str3.equals("")) {
                String binaryString2 = Integer.toBinaryString(Integer.parseInt(str3));
                this.f2775wM += "000010";
                while (binaryString2.length() + i < 15) {
                    this.f2775wM += "0";
                    i++;
                }
                i = 0;
                this.f2775wM += binaryString2;
            }
            if (!str4.equals("")) {
                String binaryString3 = Integer.toBinaryString(Integer.parseInt(str4));
                this.f2775wM += "000011";
                while (binaryString3.length() + i < 14) {
                    this.f2775wM += "0";
                    i++;
                }
                i = 0;
                this.f2775wM += binaryString3;
            }
            if (!m2588au.equals("")) {
                String m2453j2 = m2453j(Long.parseLong(m2588au));
                this.f2775wM += "000110";
                while (m2453j2.length() + i < 50) {
                    this.f2775wM += "0";
                    i++;
                }
                i = 0;
                this.f2775wM += m2453j2;
            }
            if (!upperCase.equals("")) {
                String m2453j3 = m2453j(Long.parseLong(upperCase, 36));
                this.f2775wM += "000100";
                while (m2453j3.length() + i < 11) {
                    this.f2775wM += "0";
                    i++;
                }
                i = 0;
                this.f2775wM += m2453j3;
            }
            if (!"1".equals("")) {
                String binaryString4 = Integer.toBinaryString(Integer.parseInt("1"));
                this.f2775wM += "000101";
                while (binaryString4.length() + i < 6) {
                    this.f2775wM += "0";
                    i++;
                }
                i = 0;
                this.f2775wM += binaryString4;
            }
            if (!m2531qD.equals("") && !m2531qD.equals("0")) {
                String m2453j4 = m2453j(Long.parseLong(m2531qD, 36));
                this.f2775wM += "000111";
                while (m2453j4.length() + i < 57) {
                    this.f2775wM += "0";
                    i++;
                }
                i = 0;
                this.f2775wM += m2453j4;
            }
            if (!str.equals("")) {
                String m2453j5 = m2453j(Long.parseLong(str));
                this.f2775wM += "010000";
                while (m2453j5.length() + i < 16) {
                    this.f2775wM += "0";
                    i++;
                }
                i = 0;
                this.f2775wM += m2453j5;
            }
            String m2453j6 = m2453j(m2399sm);
            this.f2775wM += "001111";
            while (m2453j6.length() + i < 12) {
                this.f2775wM += "0";
                i++;
            }
            this.f2775wM += m2453j6;
            if (!valueOf.equals("")) {
                String m2453j7 = m2453j(Long.parseLong(valueOf));
                this.f2775wM += "001110";
                for (int i2 = 0; m2453j7.length() + i2 < 20; i2++) {
                    this.f2775wM += "0";
                }
                this.f2775wM += m2453j7;
            }
            this.f2775wM += "00";
        } else {
            m2451af(str2);
            m2451af(this.type.equals("7") ? "UNLOCK" : "INAPP");
            m2451af("V016");
            m2451af(m2530qC);
            m2451af(m2529qB);
            m2451af(str3);
            m2451af(str4);
            m2451af(upperCase);
            m2451af("1");
            m2451af(str);
            m2451af(m2531qD);
            m2451af(m2588au);
            m2451af(valueOf);
            m2451af(str5);
        }
        this.f2775wM.trim();
        C0012k.m41c("IAP-SMSBilling", "sendSMS: " + this.f2775wM);
        C0463b.m2500ad(true);
        C0463b.setResult(1);
        m2455sz();
    }

    private static String m2453j(long j) {
        String str = "";
        while (j > 0) {
            str = j % 2 == 0 ? str + "0" : str + "1";
            j /= 2;
        }
        return new StringBuilder(str).reverse().toString();
    }

    private void m2455sz() {
        new C0442b(this).start();
    }

    @Override
    public final void mo2252bW(String str) {
        C0414f.m2384h(str, 28);
        C0414f.m2384h(this.f2753Zz, 30);
        C0414f.m2384h(this.f2752Zy, 31);
        C0414f.m2384h(this.profileId, 32);
        C0414f.m2384h(this.type, 33);
        if (C0463b.m2544qQ()) {
            C0414f.m2384h(this.f2735ZK, 36);
        }
    }

    @Override
    public final void mo2253bp(String str) {
        C0012k.m41c("IAP-SMSBilling", "SMSBilling an item");
        if (C0463b.m2544qQ()) {
            m2452cs(str);
            return;
        }
        C0012k.m41c("IAP-SMSBilling", "Using SMS Encrypted");
        C0463b.m2499ac(true);
        C0463b.m2502ae(false);
        C0414f.m2387r(f2724wS[0], "0");
        this.f2775wM = "";
        String str2 = this.f2753Zz;
        String m2530qC = C0463b.m2530qC();
        String m2529qB = C0463b.m2529qB();
        String str3 = C0463b.m2528qA().aeU;
        String str4 = this.profileId;
        String upperCase = C0463b.getLanguage().toUpperCase();
        C0012k.m41c("IAP-SMSBilling", "Game language:        " + upperCase);
        String m2531qD = (C0463b.m2531qD() == null || C0463b.m2531qD().equals("")) ? "0" : C0463b.m2531qD();
        C0491r.m2681tf();
        String m2588au = C0477d.m2588au();
        String valueOf = String.valueOf(C0414f.m2372cF());
        int m2399sm = C0414f.m2399sm();
        String str5 = "ct" + m2399sm;
        if (upperCase == null || upperCase.equals("")) {
            C0012k.m41c("IAP-SMSBilling", "Warning, Missing input language from game setting, get language from phone settings instead.");
            upperCase = Locale.getDefault().getLanguage().toUpperCase();
        }
        C0012k.m41c("IAP-SMSBilling", "alias:        " + str2);
        C0012k.m41c("IAP-SMSBilling", "demoCode:     " + m2530qC);
        C0012k.m41c("IAP-SMSBilling", "unlockCode:   " + m2529qB);
        C0012k.m41c("IAP-SMSBilling", "phoneModel:   " + str3);
        C0012k.m41c("IAP-SMSBilling", "profileID:    " + str4);
        C0012k.m41c("IAP-SMSBilling", "lang:         " + upperCase);
        C0012k.m41c("IAP-SMSBilling", "contentID:    " + str);
        C0012k.m41c("IAP-SMSBilling", "downloadCode: " + m2531qD);
        C0012k.m41c("IAP-SMSBilling", "IMEI:         " + m2588au);
        C0012k.m41c("IAP-SMSBilling", "amount:       " + valueOf);
        C0012k.m41c("IAP-SMSBilling", "SMSCounter:   " + str5);
        if (!m2229bq(m2530qC) || !m2229bq(m2529qB) || !m2229bq(str3) || !m2229bq(str4)) {
            C0012k.m40b("IAP-SMSBilling", "IAP_INVALID_REQUEST (-5)");
            C0463b.setResult(3);
            C0463b.m2521eV(-5);
            return;
        }
        if (!m2229bq(str)) {
            C0012k.m40b("IAP-SMSBilling", "IAP_ERROR_ITEM_NOT_AVAILABLE (-2)");
            C0463b.setResult(3);
            C0463b.m2521eV(-2);
            return;
        }
        String str6 = (((((((this.type.equals("7") ? "10000000" : "10000001") + C0487n.m2630F("000000", m2530qC)) + C0487n.m2630F("000001", m2529qB)) + C0487n.m2630F("000010", str3)) + C0487n.m2630F("000011", str4)) + C0487n.m2630F("000100", upperCase)) + C0487n.m2630F("000101", "1")) + C0487n.m2630F("010000", str);
        String str7 = !m2531qD.equals("0") ? str6 + C0487n.m2630F("000111", m2531qD) : str6;
        String m2632cF = C0487n.m2632cF(m2588au);
        if (m2632cF == null) {
            m2632cF = "111111";
        }
        String str8 = ((str7 + C0487n.m2630F(m2632cF, m2588au)) + C0487n.m2630F("001110", valueOf)) + C0487n.m2630F("001111", String.valueOf(m2399sm));
        C0012k.m39a("IAP-SMSBilling", str8.length() + ":" + str8);
        if (str8.length() % 8 != 0) {
            do {
                str8 = str8 + "0";
            } while (str8.length() % 8 != 0);
        }
        C0012k.m39a("IAP-SMSBilling", str8.length() + ":" + str8);
        String str9 = "" + new String(new C0476c().m2585f(C0492s.m2702b(C0487n.m2631cE(str8), C0492s.m2703cU("57786eaf7b1c579364a8b96a4d76e5e4"))));
        m2451af(str2);
        m2451af("GameloftOrder");
        m2451af(str9);
        this.f2775wM.trim();
        C0012k.m41c("IAP-SMSBilling", "sendSMS: " + this.f2775wM);
        C0463b.m2500ad(true);
        C0463b.setResult(1);
        m2455sz();
    }

    @Override
    public final boolean mo2269rG() {
        C0012k.m41c("IAP-SMSBilling", "[isPendingTransaction]" + C0414f.m2396sj());
        String m2396sj = C0414f.m2396sj();
        if (m2396sj == null || !m2396sj.equals("7")) {
            return false;
        }
        C0463b.setResult(C0488o.m2641ap(m2396sj));
        C0414f.m2379cn("");
        return true;
    }

    @Override
    public final String mo2270rH() {
        this.f2753Zz = C0414f.m2383fa(30);
        this.f2752Zy = C0414f.m2383fa(31);
        this.profileId = C0414f.m2383fa(32);
        this.type = C0414f.m2383fa(33);
        if (C0463b.m2544qQ()) {
            this.f2735ZK = C0414f.m2383fa(36);
        }
        return C0414f.m2383fa(28);
    }
}
