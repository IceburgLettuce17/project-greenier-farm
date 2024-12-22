package com.gameloft.android2d.iap.p042a.p054k;

import android.app.Activity;
import android.app.AlertDialog;
import com.gameloft.android2d.iap.C0463b;
import com.gameloft.android2d.iap.p042a.AbstractC0358a;
import com.gameloft.android2d.iap.p042a.p051h.C0414f;
import com.gameloft.android2d.iap.utils.C0477d;
import com.gameloft.android2d.iap.utils.C0488o;
import com.gameloft.android2d.iap.utils.C0491r;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;
import p001a.p004b.p005a.p006a.C0012k;

public final class C0446a extends AbstractC0358a {
    private static C0460o adE;
    private static String[] adk = {"EN", "FR", "DE", "ES", "IT", "BR", "PT", "TR", "RU", "PL", "ZH", "KR", "JP", "TH", "VI"};
    private static String[] adl = {"Continue", "Continuer", "Weiter", "Continuar", "Continua", "Continuar", "Continuar", "Devam", "Продолжить", "Kontynuuj", "继续", "계속", "コンティニュー", "เล่นเกมต่อ", "Tiếp tục"};
    private static String[] adm = {"Cancel", "Annuler", "Abbrechen", "Cancelar", "Annulla", "Cancelar", "Cancelar", "İptal", "Отмена", "Anuluj", "取消", "취소", "キャンセル", "ยกเลิก", "Hủy bỏ"};

    Activity f2777YF;

    private String f2778Yp;

    private String f2779Zr;
    private String adA;
    private String adB;
    AlertDialog adC;
    AlertDialog adD;
    private String ada;
    private String adb;
    private String adc;
    private String add;
    private String ade;
    private String adf;
    private String adg;
    private String adh;
    private String adx;
    private String ady;
    private String adz;

    private String f2782wK;

    private String f2783wL;

    private String f2780Zw = super.f2750Zw;

    private String f2781Zx = super.f2751Zx;
    private String adj = Locale.getDefault().getLanguage().toUpperCase();

    public C0446a() {
        C0012k.m41c("IAP-UMPBilling", "Created UMPBilling");
        this.f2744Zq = "ump_2d";
        this.f2777YF = (Activity) C0488o.getContext();
        adE = new C0460o(this);
    }

    public static String m2484ss() {
        String upperCase = C0463b.getLanguage().toUpperCase();
        int i = 0;
        for (int i2 = 0; i2 < adk.length; i2++) {
            if (upperCase.compareTo(adk[i2]) == 0) {
                i = i2;
            }
        }
        return i < adl.length ? adl[i] : adl[0];
    }

    public static String m2485st() {
        String upperCase = C0463b.getLanguage().toUpperCase();
        int i = 0;
        for (int i2 = 0; i2 < adk.length; i2++) {
            if (upperCase.compareTo(adk[i2]) == 0) {
                i = i2;
            }
        }
        return i < adm.length ? adm[i] : adm[0];
    }

    @Override
    public final void mo2253bp(String str) {
        C0012k.m41c("IAP-UMPBilling", "UMPBilling an item");
        this.f2777YF.runOnUiThread(new C0447b(this));
        this.ada = this.f2727ZC;
        this.adb = this.f2728ZD;
        this.f2778Yp = C0463b.m2530qC();
        this.adc = str;
        this.f2779Zr = super.f2745Zr;
        this.add = this.f2741ZQ;
        this.ade = "0";
        this.adf = "0";
        C0491r.m2681tf();
        this.f2782wK = C0477d.m2588au();
        this.adx = "R3";
        this.f2783wL = C0463b.m2531qD();
        if (this.f2783wL == null) {
            this.f2783wL = "0";
        }
        this.adg = "0";
        this.ady = this.f2725ZA;
        this.adz = this.f2726ZB;
        String l = Long.toString(System.currentTimeMillis());
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update((this.f2778Yp + '_' + this.f2779Zr + '_' + this.add + '_' + this.adc + '_' + this.ade + '_' + this.adf + '_' + this.f2782wK + '_' + this.adx + '_' + l + '_' + this.f2783wL + "_UMPGAMELOFT").getBytes());
            byte[] digest = messageDigest.digest();
            String format = String.format("%0" + (digest.length << 1) + "x", new BigInteger(1, digest));
            this.f2780Zw = super.f2750Zw;
            this.f2781Zx = super.f2751Zx;
            this.adj = Locale.getDefault().getLanguage().toUpperCase();
            C0012k.m41c("IAP-UMPBilling", "demoCode:     " + this.f2778Yp);
            C0012k.m41c("IAP-UMPBilling", "contentID:    " + this.adc);
            C0012k.m41c("IAP-UMPBilling", "price:   \t   " + this.f2779Zr);
            C0012k.m41c("IAP-UMPBilling", "moneyID:      " + this.add);
            C0012k.m41c("IAP-UMPBilling", "ggi:          " + this.ade);
            C0012k.m41c("IAP-UMPBilling", "gliveID:      " + this.adf);
            C0012k.m41c("IAP-UMPBilling", "phoneModel:   " + this.f2782wK);
            C0012k.m41c("IAP-UMPBilling", "umpVersion:   " + this.adx);
            C0012k.m41c("IAP-UMPBilling", "timeStamp:    " + l);
            C0012k.m41c("IAP-UMPBilling", "downloadCode: " + this.f2783wL);
            C0012k.m41c("IAP-UMPBilling", "signature:    " + format);
            C0012k.m41c("IAP-UMPBilling", "lang:         " + this.adj);
            C0012k.m41c("IAP-UMPBilling", "channel:      " + this.adg);
            if (!m2229bq(this.f2778Yp) || !m2229bq(this.f2782wK)) {
                C0012k.m40b("IAP-UMPBilling", "IAP_INVALID_REQUEST (-5)");
                C0463b.setResult(3);
                C0463b.m2521eV(-5);
            } else if (m2229bq(this.adc)) {
                C0463b.setResult(1);
                new C0451f(this, l, format).start();
            } else {
                C0012k.m40b("IAP-UMPBilling", "IAP_ERROR_ITEM_NOT_AVAILABLE (-2)");
                C0463b.setResult(3);
                C0463b.m2521eV(-2);
            }
        } catch (Exception e) {
            C0012k.m40b("IAP-UMPBilling", "Exception when creating signature in startTransactionForID");
            C0463b.setResult(3);
            C0463b.m2521eV(-11);
        }
    }

    public final void m2488fc(int i) {
        new C0455j(this, i).start();
    }

    @Override
    public final boolean mo2269rG() {
        String m2396sj = C0414f.m2396sj();
        C0012k.m41c("IAP-UMPBilling", "Is Have Transaction Pending UMP:" + m2396sj);
        if (m2396sj != null) {
            String m2383fa = C0414f.m2383fa(24);
            String m2383fa2 = C0414f.m2383fa(25);
            String m2383fa3 = C0414f.m2383fa(26);
            C0491r.m2681tf();
            String m2588au = C0477d.m2588au();
            C0491r c0491r = new C0491r(new C0477d(m2383fa, m2383fa2));
            String l = Long.toString(System.currentTimeMillis());
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update((m2396sj + '_' + m2588au + '_' + l + "_UMPGAMELOFT").getBytes());
                byte[] digest = messageDigest.digest();
                C0491r.m2678d(m2383fa3, m2396sj, l, m2588au, String.format("%0" + (digest.length << 1) + "x", new BigInteger(1, digest)));
                while (!c0491r.m2694tj()) {
                    try {
                        Thread.sleep(50L);
                    } catch (Exception e) {
                    }
                }
                if (C0491r.m2682tg() != 0) {
                    C0463b.m2558rc();
                } else {
                    C0463b.setResult(7);
                    C0463b.m2552qY();
                }
            } catch (Exception e2) {
                C0012k.m40b("IAP-UMPBilling", "Exception when creating signature in checkBilling");
                C0463b.m2558rc();
            }
        }
        return true;
    }
}
