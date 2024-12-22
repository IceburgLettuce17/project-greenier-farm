package com.gameloft.android2d.iap.p042a.p052i;

import android.app.Activity;
import android.app.AlertDialog;
import com.gameloft.android2d.iap.C0463b;
import com.gameloft.android2d.iap.p042a.AbstractC0358a;
import com.gameloft.android2d.iap.utils.C0477d;
import com.gameloft.android2d.iap.utils.C0488o;
import com.gameloft.android2d.iap.utils.C0491r;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;
import p001a.p004b.p005a.p006a.C0012k;

public final class C0432a extends AbstractC0358a {
    private static String acW;
    private static String acX;
    private static String acY;
    private static String acZ;
    private static String[] adk = {"EN", "FR", "DE", "ES", "IT", "BR", "PT", "TR", "RU", "PL", "ZH", "KR", "JP", "TH", "VI"};
    private static String[] adl = {"Continue", "Continuer", "Weiter", "Continuar", "Continua", "Continuar", "Continuar", "Devam", "Продолжить", "Kontynuuj", "继续", "계속", "コンティニュー", "เล่นเกมต่อ", "Tiếp tục"};
    private static String[] adm = {"Cancel", "Annuler", "Abbrechen", "Cancelar", "Annulla", "Cancelar", "Cancelar", "İptal", "Отмена", "Anuluj", "取消", "취소", "キャンセル", "ยกเลิก", "Hủy bỏ"};
    public static boolean adn = false;

    private Activity f2766YF;

    private String f2767Yp;

    private String f2768Zr;
    private String ada;
    private String adb;
    private String adc;
    private String add;
    private String ade;
    private String adf;
    private String adg;
    private String adh;
    AlertDialog adi;

    private String f2771wK;

    private String f2772wL;

    private String f2769Zw = super.f2750Zw;

    private String f2770Zx = super.f2751Zx;
    private String adj = Locale.getDefault().getLanguage().toUpperCase();

    public C0432a() {
        C0012k.m41c("IAP-ShenzhoufuBilling", "Created ShenzhoufuBilling");
        this.f2744Zq = "shenzhoufu_2d";
        this.f2766YF = (Activity) C0488o.getContext();
    }

    static void m2424a(C0432a c0432a, String str) {
        c0432a.ada = c0432a.f2727ZC;
        c0432a.adb = c0432a.f2728ZD;
        c0432a.f2767Yp = C0463b.m2530qC();
        c0432a.adc = str;
        c0432a.f2768Zr = ((AbstractC0358a) c0432a).f2745Zr;
        c0432a.add = c0432a.f2741ZQ;
        c0432a.ade = "0";
        c0432a.adf = "0";
        C0491r.m2681tf();
        c0432a.f2771wK = C0477d.m2588au();
        c0432a.f2772wL = C0463b.m2531qD();
        if (c0432a.f2772wL == null) {
            c0432a.f2772wL = "0";
        }
        c0432a.adg = "0";
        String l = Long.toString(System.currentTimeMillis());
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update((c0432a.f2767Yp + '_' + c0432a.f2768Zr + '_' + c0432a.add + '_' + c0432a.adc + '_' + c0432a.ade + '_' + c0432a.adf + '_' + c0432a.f2771wK + '_' + ((String) null) + '_' + ((String) null) + '_' + ((String) null) + '_' + l + '_' + c0432a.f2772wL + "_SHENZHOUFUGAMELOFT").getBytes());
            byte[] digest = messageDigest.digest();
            String format = String.format("%0" + (digest.length << 1) + "x", new BigInteger(1, digest));
            c0432a.f2769Zw = ((AbstractC0358a) c0432a).f2750Zw;
            c0432a.f2770Zx = ((AbstractC0358a) c0432a).f2751Zx;
            c0432a.adj = Locale.getDefault().getLanguage().toUpperCase();
            C0012k.m41c("IAP-ShenzhoufuBilling", "demoCode:     " + c0432a.f2767Yp);
            C0012k.m41c("IAP-ShenzhoufuBilling", "contentID:    " + c0432a.adc);
            C0012k.m41c("IAP-ShenzhoufuBilling", "price:   \t   " + c0432a.f2768Zr);
            C0012k.m41c("IAP-ShenzhoufuBilling", "moneyID:      " + c0432a.add);
            C0012k.m41c("IAP-ShenzhoufuBilling", "ggi:          " + c0432a.ade);
            C0012k.m41c("IAP-ShenzhoufuBilling", "gliveID:      " + c0432a.adf);
            C0012k.m41c("IAP-ShenzhoufuBilling", "phoneModel:   " + c0432a.f2771wK);
            C0012k.m41c("IAP-ShenzhoufuBilling", "cardnumber:   " + ((String) null));
            C0012k.m41c("IAP-ShenzhoufuBilling", "cardpwd:      " + ((String) null));
            C0012k.m41c("IAP-ShenzhoufuBilling", "cardmoney:    " + ((String) null));
            C0012k.m41c("IAP-ShenzhoufuBilling", "cardtype:     " + ((String) null));
            C0012k.m41c("IAP-ShenzhoufuBilling", "timeStamp:    " + l);
            C0012k.m41c("IAP-ShenzhoufuBilling", "downloadCode: " + c0432a.f2772wL);
            C0012k.m41c("IAP-ShenzhoufuBilling", "signature:    " + format);
            C0012k.m41c("IAP-ShenzhoufuBilling", "lang:         " + c0432a.adj);
            C0012k.m41c("IAP-ShenzhoufuBilling", "channel:      " + c0432a.adg);
            if (!m2229bq(c0432a.f2767Yp) || !m2229bq(c0432a.f2771wK)) {
                C0012k.m40b("IAP-ShenzhoufuBilling", "IAP_INVALID_REQUEST (-5)");
                C0463b.setResult(3);
                C0463b.m2521eV(-5);
                m2442su();
                return;
            }
            if (m2229bq(c0432a.adc)) {
                C0463b.setResult(1);
                new C0438g(c0432a, l, format).start();
            } else {
                C0012k.m40b("IAP-ShenzhoufuBilling", "IAP_ERROR_ITEM_NOT_AVAILABLE (-2)");
                C0463b.setResult(3);
                C0463b.m2521eV(-2);
                m2442su();
            }
        } catch (Exception e) {
            C0012k.m40b("IAP-ShenzhoufuBilling", "Exception when creating signature in startTransactionForID");
            C0463b.setResult(3);
            C0463b.m2521eV(-11);
            m2442su();
        }
    }

    public static String m2440ss() {
        String upperCase = C0463b.getLanguage().toUpperCase();
        int i = 0;
        for (int i2 = 0; i2 < adk.length; i2++) {
            if (upperCase.compareTo(adk[i2]) == 0) {
                i = i2;
            }
        }
        return i < adl.length ? adl[i] : adl[0];
    }

    public static String m2441st() {
        String upperCase = C0463b.getLanguage().toUpperCase();
        int i = 0;
        for (int i2 = 0; i2 < adk.length; i2++) {
            if (upperCase.compareTo(adk[i2]) == 0) {
                i = i2;
            }
        }
        return i < adm.length ? adm[i] : adm[0];
    }

    public static void m2442su() {
        acW = null;
        acX = null;
        acY = null;
        acZ = null;
    }

    static String m2443sv() {
        return null;
    }

    static String m2444sw() {
        return null;
    }

    static String m2445sx() {
        return null;
    }

    static String m2446sy() {
        return null;
    }

    @Override
    public final void mo2253bp(String str) {
        C0012k.m41c("IAP-ShenzhoufuBilling", "ShenzhoufuBilling an item");
        this.f2766YF.runOnUiThread(new C0433b(this, str));
        this.f2766YF.runOnUiThread(new C0437f(this));
    }

    public final void m2447fc(int i) {
        new C0439h(this, i).start();
    }
}
