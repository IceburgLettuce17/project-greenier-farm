package com.gameloft.android2d.iap;

import android.app.Activity;
import android.app.ActivityManager;
import android.os.SystemClock;
import com.gameloft.android.LATAM.GloftGF2H.C0320bt;
import com.gameloft.android2d.iap.p042a.AbstractC0358a;
import com.gameloft.android2d.iap.p042a.p051h.C0414f;
import com.gameloft.android2d.iap.utils.C0477d;
import com.gameloft.android2d.iap.utils.C0483j;
import com.gameloft.android2d.iap.utils.C0488o;
import com.gameloft.android2d.iap.utils.C0489p;
import com.gameloft.android2d.iap.utils.C0490q;
import com.gameloft.android2d.iap.utils.C0491r;
import com.gameloft.android2d.iap.utils.C0492s;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Vector;
import p001a.p004b.p005a.p006a.C0002a;
import p001a.p004b.p005a.p006a.C0012k;
import p009b.p010a.p012b.DialogC0064m;

public final class C0463b implements InterfaceC0357a {

    private static String[][] f2813Zc;

    Activity f2825YF;

    DialogC0064m f2826YG;

    private C0489p f2827Yn;

    private static final C0463b f2809Ym = new C0463b();

    private static String f2810Yt = "IAP.Version: 1.1.9";

    public static String f2789YE = null;

    public static boolean f2790YH = false;

    public static boolean f2791YI = false;

    public static String f2792YJ = null;

    public static boolean f2793YK = false;

    public static boolean f2794YL = false;

    public static boolean f2795YM = false;

    private static boolean f2796YN = false;

    private static long f2797YO = -2000;

    private static long f2798YP = 0;

    private static long f2799YQ = 0;

    public static boolean f2800YR = false;

    public static boolean f2801YS = false;

    public static boolean f2802YT = false;

    private static boolean f2803YU = false;

    private static int f2804YV = 0;

    public static boolean f2805YW = false;

    public static boolean f2806YX = true;

    private static boolean f2807YY = false;

    private static boolean f2808YZ = false;

    public static boolean f2811Za = true;

    private static String f2812Zb = "";

    private static int f2814Zd = 0;

    private static int f2815Ze = 1;

    private static int f2816Zf = 2;

    public static ArrayList<String> f2817Zg = new ArrayList<>();

    private static String f2818Zh = null;

    public static int f2819Zi = 0;

    public static String f2820Zj = null;
    private boolean enabled = true;

    private String f2828Yo = "";
    private int state = 0;

    private String f2829Yp = "";

    private String f2839wL = "";

    private int f2830Yq = -1;

    private String f2831Yr = "";

    private String f2840wN = "";

    private int f2832Ys = 0;

    private boolean f2843wm = false;

    private String f2833Yu = "";

    private boolean f2834Yv = false;

    private boolean f2835Yw = false;

    private boolean f2836Yx = false;

    private boolean f2837Yy = false;

    private int f2838Yz = 0;

    private boolean f2821YA = false;

    private boolean f2822YB = false;

    private String f2823YC = "";

    private String f2824YD = "";

    private boolean f2841wV = false;

    private boolean f2842wX = false;

    private C0463b() {
    }

    public static void m2496a(Activity activity, String str, String str2, String str3, boolean z, String str4, String str5, String str6, String str7, String str8, boolean z2, boolean z3, int i, boolean z4, boolean z5, String str9, boolean z6, boolean z7, boolean z8, boolean z9, int i2, boolean z10, boolean z11, boolean z12, boolean z13) {
        C0463b c0463b = f2809Ym;
        f2803YU = z9;
        C0463b c0463b2 = f2809Ym;
        f2804YV = i2;
        C0488o.setContext(activity);
        f2809Ym.f2825YF = (Activity) C0488o.getContext();
        m2512cj();
        f2809Ym.f2829Yp = str;
        f2809Ym.f2833Yu = str2;
        f2809Ym.f2834Yv = str3 != null && str3.equals("1");
        f2809Ym.f2821YA = str4 != null && str4.equals("1");
        f2809Ym.f2822YB = str5 != null && str5.equals("1");
        f2809Ym.f2835Yw = z;
        C0463b c0463b3 = f2809Ym;
        f2809Ym.f2824YD = str7;
        f2809Ym.f2836Yx = z2;
        f2809Ym.f2837Yy = z3;
        f2809Ym.f2838Yz = i;
        f2809Ym.f2823YC = Locale.getDefault().getLanguage().toLowerCase();
        f2809Ym.f2839wL = C0488o.m2640ag();
        f2809Ym.f2828Yo = C0488o.m2651tb();
        f2809Ym.f2840wN = m2529qB();
        if (f2809Ym.f2840wN.equals("")) {
            C0012k.m41c("IAP-IAPLib", "init: No previous unlock code, generate new one.");
            f2809Ym.f2840wN = C0488o.m2647cH();
            C0414f.m2387r(f2724wS[1], f2809Ym.f2840wN);
        }
        f2789YE = str8;
        f2790YH = z4;
        f2805YW = z13;
        f2791YI = z5;
        f2792YJ = str9;
        f2793YK = z6;
        f2794YL = z7;
        f2800YR = z8;
        f2801YS = z11;
        f2802YT = z12;
        if (!f2809Ym.f2834Yv) {
            f2794YL = true;
            f2800YR = false;
            f2801YS = false;
            f2802YT = false;
        }
        if (z10) {
            f2807YY = true;
            f2808YZ = true;
        }
        f2809Ym.f2843wm = true;
        f2795YM = false;
        if (f2810Yt != null) {
            f2810Yt += ;
            C0012k.m41c("IAP-IAPLib", f2810Yt);
        } else {
            C0012k.m41c("IAP-IAPLib", "IAP.Version Not Set");
        }
        f2809Ym.f2827Yn = new C0489p();
    }

    static boolean m2497a(C0463b c0463b, boolean z) {
        c0463b.enabled = true;
        return true;
    }

    public static boolean m2498aT(int i) {
        boolean z = false;
        f2809Ym.f2840wN = m2529qB();
        if (f2809Ym.f2840wN != null && f2809Ym.f2840wN.length() > 0) {
            z = C0488o.m2634G(String.valueOf(i), f2809Ym.f2840wN);
        }
        C0012k.m41c("IAP-IAPLib", "verifyRequest: inputCode: " + i + " " + (z ? "Unlocked" : "Still Locked"));
        if (z) {
            m2552qY();
            setResult(7);
            m2515co();
        }
        return z;
    }

    public static void m2499ac(boolean z) {
        C0463b c0463b = f2809Ym;
    }

    public static void m2500ad(boolean z) {
        C0463b c0463b = f2809Ym;
    }

    public static boolean m2501ad(String str) {
        f2812Zb = str;
        setResult(5);
        return true;
    }

    public static void m2502ae(boolean z) {
        f2809Ym.f2841wV = z;
    }

    public static boolean m2503ae(String str) {
        String str2 = null;
        for (int i = 0; i < f2813Zc[0].length; i++) {
            if (f2813Zc[f2815Ze][i].equals(f2812Zb) && f2813Zc[f2816Zf][i].equals(str)) {
                str2 = f2813Zc[0][i];
            }
        }
        f2809Ym.f2833Yu = "EMBED:" + str2;
        m2546qS();
        return true;
    }

    public static int m2504ah(String str) {
        try {
            return f2809Ym.f2827Yn.aeI.m2660cN(str.toLowerCase()).size();
        } catch (Exception e) {
            return 0;
        }
    }

    public static void m2506b(int i, String str, long j) {
        C0012k.m41c("IAP-IAPLib", "[sendRequest ] pricePoint " + i + "itemType");
        try {
            setResult(1);
            f2809Ym.f2830Yq = i;
            f2809Ym.f2831Yr = str;
            String str2 = "";
            try {
                str2 = f2809Ym.f2827Yn.aeI.aeP;
            } catch (Exception e) {
            }
            if ("google".equals(m2525j(i, str)) || (str2 != null && str2.equals("195") && "sms_2d".equals(m2525j(i, str)))) {
                C0012k.m41c("IAP-IAPLib", "Google Billing, send Imediately");
                m2510c(f2809Ym.f2830Yq, f2809Ym.f2831Yr, j);
                return;
            }
            int m2511cI = m2511cI();
            if (m2511cI == 3 || m2511cI == 2 || m2511cI == 4 || m2511cI == 5 || C0414f.m2371cB() || !("http_2d".equals(m2525j(i, str)) || "sms_2d".equals(m2525j(i, str)))) {
                C0012k.m41c("IAP-IAPLib", "Special flow or Resend, need to implement custom confirmation : " + m2511cI);
                m2510c(f2809Ym.f2830Yq, f2809Ym.f2831Yr, j);
            } else {
                f2809Ym.f2825YF.runOnUiThread(new C0465d(m2511cI, j));
                f2809Ym.f2825YF.runOnUiThread(new C0469h());
            }
        } catch (Exception e2) {
            setResult(3);
            e2.printStackTrace();
        }
    }

    public static void m2507bn(String str) {
        if (f2809Ym.f2823YC != null && !f2809Ym.f2823YC.equalsIgnoreCase(str)) {
            f2795YM = false;
            setResult(0);
        }
        f2809Ym.f2823YC = str;
    }

    public static String m2508bo(String str) {
        String str2;
        int indexOf;
        String str3 = null;
        if (str == null || str.equals("")) {
            C0012k.m41c("IAP-IAPLib", "URL-SUPPORT field is empty or missing");
            return null;
        }
        try {
            String m2388sb = C0414f.m2388sb();
            if (m2388sb != null) {
                String str4 = str + "&extra_1=" + C0492s.m2698a(C0492s.m2699a(m2388sb.getBytes(), "a8bc1a23a89"));
                String m2368am = C0414f.m2368am(C0414f.f2724wS[7]);
                if (m2368am != null && (indexOf = m2368am.indexOf(95)) > 0) {
                    str3 = m2368am.substring(indexOf + 1);
                }
                if (str3 == null || str3.equals("")) {
                    C0012k.m41c("IAP-IAPLib", "ProfileID is empty or missing");
                    str2 = str4 + "&extra_6=" + C0492s.m2698a(C0492s.m2699a(C0414f.m2391se().getBytes(), "a8bc1a23a89"));
                } else {
                    C0012k.m41c("IAP-IAPLib", "ProfileID is valid");
                    str2 = str4 + "&extra_2=" + str3;
                }
            } else {
                str2 = str;
            }
            try {
                C0012k.m41c("IAP-IAPLib", "Customer Care URL: " + str2);
                return str2;
            } catch (Exception e) {
                return str2;
            }
        } catch (Exception e2) {
            return str;
        }
    }

    public static void m2510c(int i, String str, long j) {
        try {
            if (f2796YN) {
                C0012k.m41c("IAP-IAPLib", "You have a unfinished purchase. Cannot start new transaction!!!!");
                return;
            }
            if (!C0414f.m2371cB()) {
                C0320bt.m1913pW();
            }
            f2796YN = true;
            setResult(1);
            new Thread(new RunnableC0470i(i, str, j)).start();
        } catch (Exception e) {
            C0012k.m41c("IAP-IAPLib", "send request exec fail  " + e.toString());
            setResult(3);
        }
    }

    public static int m2511cI() {
        try {
            int i = f2809Ym.f2827Yn.aeI.aeZ;
            if (i == 3) {
                return 0;
            }
            return i;
        } catch (Exception e) {
            return 0;
        }
    }

    public static boolean m2512cj() {
        f2809Ym.f2841wV = C0414f.m2370cA();
        f2809Ym.f2842wX = C0414f.m2371cB();
        return f2809Ym.f2841wV || f2809Ym.f2842wX;
    }

    public static void m2513ck() {
        f2809Ym.f2842wX = true;
        C0414f.m2387r(f2724wS[4], "1");
        AbstractC0358a m1a = C0002a.m1a(C0414f.m2383fa(20));
        m1a.mo2253bp(m1a.mo2270rH());
    }

    public static int m2514cm() {
        return f2809Ym.f2832Ys;
    }

    private static void m2515co() {
        C0012k.m41c("IAP-IAPLib", "cleanStatus: start");
        C0463b c0463b = f2809Ym;
        C0463b c0463b2 = f2809Ym;
        C0012k.m41c("IAP-IAPLib", "clean: generate new unlock code.");
        f2809Ym.f2840wN = C0488o.m2647cH();
        C0414f.m2387r(f2724wS[1], f2809Ym.f2840wN);
        f2809Ym.f2841wV = false;
        C0414f.m2387r(f2724wS[0], "0");
        f2809Ym.f2842wX = false;
        C0414f.m2387r(f2724wS[4], "0");
        C0414f.m2387r(f2724wS[5], "0");
        f2796YN = false;
    }

    public static String m2516cu() {
        C0483j c0483j;
        C0012k.m41c("IAP-IAPLib", "GetTermsAndConditions new ");
        try {
            if (f2809Ym.f2827Yn.aeI.m2660cN("Cash".toLowerCase()).size() > 0) {
                c0483j = f2809Ym.f2827Yn.aeI.m2660cN("Cash".toLowerCase()).get(f2809Ym.f2827Yn.aeI.m2660cN("Cash".toLowerCase()).keys().nextElement());
            } else {
                f2809Ym.f2827Yn.aeI.m2660cN("Coin".toLowerCase()).size();
                c0483j = f2809Ym.f2827Yn.aeI.m2660cN("Coin".toLowerCase()).get(f2809Ym.f2827Yn.aeI.m2660cN("Coin".toLowerCase()).keys().nextElement());
            }
            if (c0483j == null) {
                return null;
            }
            C0012k.m41c("IAP-IAPLib", "GetTermsAndConditions new T&C:" + c0483j.m2620sQ().f2748Zu);
            return c0483j.m2620sQ().f2748Zu;
        } catch (Exception e) {
            C0012k.m40b("IAP-IAPLib", "GetTermsAndConditions new " + e.toString());
            return null;
        }
    }

    public static int m2518dJ() {
        int i = f2809Ym.state;
        m2512cj();
        if (i == 3 || i == 7) {
            f2809Ym.state = 0;
            C0414f.m2387r(f2724wS[5], "0");
            f2796YN = false;
            if (i != 3 || f2809Ym.f2832Ys != -1) {
                m2558rc();
                return i;
            }
        } else {
            if (i == 11) {
                if (f2811Za) {
                    f2809Ym.state = 4;
                    return 4;
                }
                f2809Ym.state = 0;
                return i;
            }
            if (i == 0) {
                C0414f.m2387r(f2724wS[5], "0");
            }
        }
        return i;
    }

    static void m2519do() {
        try {
            C0012k.m41c("IAP-IAPLib", "[CheckPendingVerification]");
            int m2547qT = m2547qT();
            C0012k.m41c("IAP-IAPLib", "[CheckPendingVerification] pricepoint = " + m2547qT);
            String m2549qV = m2549qV();
            C0012k.m41c("IAP-IAPLib", "[CheckPendingVerification] itemType = " + m2549qV);
            if (m2547qT >= 0 && m2549qV != null) {
                String m2383fa = C0414f.m2383fa(20);
                if (C0488o.m2643bq(m2383fa)) {
                    AbstractC0358a m1a = C0002a.m1a(m2383fa);
                    if (m1a.mo2269rG()) {
                        C0012k.m41c("IAP-IAPLib", "[CheckPendingVerification] isPendingTransaction");
                    } else if (m1a.mo2268rF()) {
                        m1a.mo2267rE();
                    }
                } else {
                    C0012k.m41c("IAP-IAPLib", "[CheckPendingVerification] No last Billing Type");
                }
            }
        } catch (Exception e) {
            C0012k.m41c("IAP-IAPLib", "[CheckPendingVerification] exception: " + e.getMessage());
        }
    }

    public static void m2521eV(int i) {
        f2809Ym.f2832Ys = i;
    }

    public static String getLanguage() {
        return f2809Ym.f2823YC;
    }

    public static long m2524i(int i, String str) {
        try {
            C0483j c0483j = f2809Ym.f2827Yn.aeI.m2660cN(str.toLowerCase()).get(Integer.valueOf(i));
            if (c0483j != null) {
                return c0483j.m2621sR();
            }
            return 0L;
        } catch (Exception e) {
            C0012k.m40b("IAP-IAPLib", "getVirtualCurrency : pricepoint = " + i + ", itemType = " + str);
            return -1L;
        }
    }

    public static String m2525j(int i, String str) {
        String str2;
        try {
            C0483j c0483j = f2809Ym.f2827Yn.aeI.m2660cN(str.toLowerCase()).get(Integer.valueOf(i));
            if (c0483j == null) {
                C0012k.m40b("IAP-IAPLib", "GetBillingType: item is null. pricePoint = " + i + ", itemType =" + str);
                str2 = null;
            } else {
                str2 = c0483j.m2620sQ().f2744Zq;
            }
            return str2;
        } catch (Exception e) {
            C0012k.m40b("IAP-IAPLib", "GetBillingType ERR pricePoint = " + i + ", itemType =" + str);
            return null;
        }
    }

    public static String m2526p(int i, String str) {
        String str2;
        try {
            C0483j c0483j = f2809Ym.f2827Yn.aeI.m2660cN(str.toLowerCase()).get(Integer.valueOf(i));
            if (c0483j == null) {
                C0012k.m40b("IAP-IAPLib", "GetPrice: item is null. pricePoint = " + i + ", itemType =" + str);
                str2 = null;
            } else {
                str2 = c0483j.m2620sQ().f2747Zt;
            }
            return str2;
        } catch (Exception e) {
            C0012k.m40b("IAP-IAPLib", "GetPrice ERR pricePoint = " + i + ", itemType =" + str);
            return null;
        }
    }

    public static int m2527q(int i, String str) {
        int i2;
        int i3 = -1;
        try {
            if (str.equalsIgnoreCase("Cash")) {
                i2 = f2809Ym.f2827Yn.aeI.m2662fd(i);
            } else if (str.equalsIgnoreCase("Coin")) {
                i2 = f2809Ym.f2827Yn.aeI.m2663fe(i);
            } else if (f2809Ym.f2827Yn.aeI.m2661cO(str)) {
                C0490q c0490q = f2809Ym.f2827Yn.aeI;
                i2 = c0490q.m2661cO(str) ? c0490q.aeM.get(str.toLowerCase() + "_0").intValue() : -1;
            } else {
                i2 = -1;
            }
            C0012k.m41c("IAP-IAPLib", "[GetPricePoint] index = " + i + " ,  itemType " + str + ", pricePoint " + i2);
            i3 = i2;
            return i3;
        } catch (Exception e) {
            C0012k.m40b("IAP-IAPLib", " GetPricePoint:: (index = " + i + "), (itemType = " + str + ")");
            return i3;
        }
    }

    public static C0490q m2528qA() {
        return f2809Ym.f2827Yn.aeI;
    }

    public static String m2529qB() {
        C0463b c0463b = f2809Ym;
        String m2368am = C0414f.m2368am(C0414f.f2724wS[1]);
        if (m2368am == null) {
            m2368am = "";
        }
        c0463b.f2840wN = m2368am;
        return f2809Ym.f2840wN;
    }

    public static String m2530qC() {
        return f2809Ym.f2829Yp;
    }

    public static String m2531qD() {
        return f2809Ym.f2839wL;
    }

    public static String m2532qE() {
        return f2809Ym.f2828Yo;
    }

    public static boolean m2533qF() {
        return f2809Ym.f2834Yv;
    }

    public static boolean m2534qG() {
        return f2809Ym.f2821YA;
    }

    public static boolean m2535qH() {
        return f2809Ym.f2822YB;
    }

    public static boolean m2536qI() {
        return f2809Ym.f2835Yw;
    }

    public static boolean m2537qJ() {
        return f2809Ym.f2836Yx;
    }

    public static boolean m2538qK() {
        return f2809Ym.f2837Yy;
    }

    public static int m2539qL() {
        return f2809Ym.f2838Yz;
    }

    public static String m2540qM() {
        return f2809Ym.f2824YD;
    }

    public static boolean m2541qN() {
        boolean m2394sh = C0414f.m2394sh();
        C0012k.m41c("IAP-IAPLib", "Checking if IAP is available: " + (f2809Ym.enabled ? "" : "NOT ") + "Enabled & " + (m2394sh ? "" : "NOT ") + "Is Demo.");
        return f2809Ym.enabled && !m2394sh;
    }

    public static boolean m2542qO() {
        if (f2809Ym == null) {
            return false;
        }
        C0463b c0463b = f2809Ym;
        return f2803YU;
    }

    public static boolean m2543qP() {
        return f2807YY;
    }

    public static boolean m2544qQ() {
        return f2808YZ;
    }

    public static int m2545qR() {
        if (f2809Ym == null) {
            return 0;
        }
        C0463b c0463b = f2809Ym;
        return f2804YV;
    }

    public static void m2546qS() {
        if (!f2809Ym.f2843wm) {
            setResult(11);
            f2809Ym.f2832Ys = -8;
            C0012k.m42d("IAP-IAPLib", "GetFeed: Init not performed.");
            return;
        }
        if (f2809Ym.f2829Yp == null || f2809Ym.f2829Yp.equals("")) {
            setResult(11);
            f2809Ym.f2832Ys = -9;
            C0012k.m42d("IAP-IAPLib", "GetFeed: IGP Code Missing.");
        } else {
            if (!f2795YM) {
                C0463b c0463b = f2809Ym;
                c0463b.getClass();
                new Thread(new RunnableC0473l(c0463b, (byte) 0)).start();
                setResult(9);
                return;
            }
            setResult(10);
            f2809Ym.f2832Ys = 0;
            if (m2512cj()) {
                C0012k.m39a("IAP-IAPLib", "SMS sent switch to redeem screen");
                setResult(2);
            }
            new C0464c().start();
        }
    }

    public static int m2547qT() {
        if (f2809Ym.f2830Yq == -1) {
            f2809Ym.f2830Yq = C0414f.m2378cn();
        }
        C0012k.m41c("IAP-IAPLib", "GetPackageIDPurchased: " + f2809Ym.f2830Yq);
        return f2809Ym.f2830Yq;
    }

    public static long m2548qU() {
        return C0414f.m2372cF();
    }

    public static String m2549qV() {
        if (f2809Ym.f2831Yr.equals("")) {
            C0463b c0463b = f2809Ym;
            String m2368am = C0414f.m2368am(C0414f.f2724wS[6]);
            if (m2368am == null || (!m2368am.toLowerCase().equals("Cash".toLowerCase()) && !m2368am.toLowerCase().equals("Coin".toLowerCase()))) {
                m2368am = "";
            }
            c0463b.f2831Yr = m2368am;
        }
        C0012k.m41c("IAP-IAPLib", "GetPackageTypePurchased: " + f2809Ym.f2831Yr);
        return f2809Ym.f2831Yr;
    }

    public static void m2550qW() {
        C0012k.m41c("IAP-IAPLib", "set text for confirmation screen wp8");
    }

    public static void m2551qX() {
        f2795YM = false;
    }

    public static void m2552qY() {
        try {
            String m2389sc = C0414f.m2389sc();
            if (m2389sc == null || m2389sc.equals("") || C0414f.m2383fa(20).equals("cc_2d")) {
                return;
            }
            float m2646cH = C0488o.m2646cH(m2389sc);
            String m2388sb = C0414f.m2388sb();
            float m2646cH2 = (m2388sb != null ? C0488o.m2646cH(m2388sb) : 0.0f) + m2646cH;
            C0012k.m41c("IAP-IAPLib", "TotalMoney Spent: " + m2646cH2 + " Profile ID : " + C0414f.m2390sd());
            C0414f.m2387r(C0414f.f2724wS[7], String.valueOf(m2646cH2) + "_" + C0414f.m2390sd());
        } catch (Exception e) {
            C0012k.m41c("IAP-IAPLib", "Exception save money spent :" + e);
        }
    }

    public static String m2553qZ() {
        return f2809Ym.f2827Yn.aeI.afc;
    }

    public static int m2554qz() {
        return f2809Ym.state;
    }

    public static int m2555r(int i, String str) {
        int i2;
        C0483j c0483j;
        try {
            c0483j = f2809Ym.f2827Yn.aeI.m2660cN(str.toLowerCase()).get(Integer.valueOf(i));
        } catch (Exception e) {
            C0012k.m40b("IAP-IAPLib", "exception: " + e.getMessage());
        }
        if (c0483j == null) {
            C0012k.m41c("IAP-IAPLib", "The item is not available");
            i2 = 0;
        } else {
            if (C0488o.m2646cH(c0483j.m2620sQ().f2745Zr) > 5.0f && m2511cI() == 6) {
                i2 = 1;
            }
            i2 = 0;
        }
        return i2;
    }

    public static String m2556ra() {
        return f2809Ym.f2827Yn.aeI.afd;
    }

    public static long m2557rb() {
        long elapsedRealtime = (f2797YO - (SystemClock.elapsedRealtime() - f2798YP)) + 2000;
        if (f2799YQ > 0 && elapsedRealtime <= 0) {
            f2795YM = false;
        }
        f2799YQ = elapsedRealtime;
        return elapsedRealtime;
    }

    public static void m2558rc() {
        C0012k.m41c("IAP-IAPLib", "Clear saving purchase info.");
        C0414f.m2377cm("");
        C0414f.m2379cn("");
        C0414f.m2387r(C0414f.f2724wS[15], "");
        C0414f.m2380co("");
        C0414f.m2381cp("");
        C0414f.m2382cq("");
    }

    public static void m2559rd() {
        if (f2817Zg.isEmpty()) {
            C0012k.m41c("IAP-IAPLib", "Services list is empty");
            m2560re();
            f2819Zi = 1;
            return;
        }
        ActivityManager activityManager = (ActivityManager) C0488o.getContext().getSystemService("activity");
        f2819Zi = 0;
        for (ActivityManager.RunningServiceInfo runningServiceInfo : activityManager.getRunningServices(Integer.MAX_VALUE)) {
            String m2650cK = C0488o.m2650cK(runningServiceInfo.service.getClassName() + f2818Zh);
            if (f2817Zg.contains(m2650cK)) {
                C0012k.m41c("IAP-IAPLib", "Found HK Service: " + m2650cK + "  Name: " + runningServiceInfo.service.getClassName());
                f2819Zi = 1;
                return;
            }
        }
    }

    static void m2560re() {
        try {
            f2818Zh = "VYak174TwfgThk2HPOfH";
            C0012k.m41c("IAP-IAPLib", "[Get srvc name List]");
            if (f2817Zg.isEmpty()) {
                new C0491r(new C0477d());
                C0491r.m2674cQ("http://confirmation.gameloft.com/freemium/content/");
                while (!C0491r.m2683tm()) {
                    try {
                        Thread.sleep(20L);
                    } catch (Exception e) {
                    }
                }
            }
        } catch (Exception e2) {
            C0012k.m41c("IAP-IAPLib", " Exception : " + e2.getMessage());
        }
    }

    public static void reset() {
        C0012k.m41c("IAP-IAPLib", "reset: start");
        C0414f.m2387r(f2724wS[2], "");
        C0414f.m2387r(f2724wS[6], "");
        C0414f.m2387r(f2724wS[3], "");
        if (f2795YM) {
            setResult(10);
        } else {
            setResult(0);
        }
        m2515co();
    }

    public static void m2561rf() {
        C0012k.m41c("IAP-IAPLib", "[Get managed contents List]");
        try {
            new C0491r(new C0477d());
            C0491r.m2675cR("https://iap.gameloft.com/freemium/getmanageditems/");
            while (!C0491r.m2685tp()) {
                try {
                    Thread.sleep(20L);
                } catch (Exception e) {
                }
            }
        } catch (Exception e2) {
            C0012k.m41c("IAP-IAPLib", " Exception : " + e2.getMessage());
        }
    }

    public static String m2562rg() {
        return C0414f.m2391se();
    }

    public static String[] m2563rh() {
        try {
            InputStream resourceAsStream = C0488o.getResourceAsStream("IAPprofiles");
            if (resourceAsStream != null) {
                Vector[] vectorArr = new Vector[3];
                for (int i = 0; i < vectorArr.length; i++) {
                    vectorArr[i] = new Vector();
                }
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    int indexOf = readLine.indexOf(58);
                    if (indexOf != -1) {
                        vectorArr[0].addElement(readLine.substring(0, indexOf));
                        int i2 = indexOf + 1;
                        int indexOf2 = readLine.indexOf(58, i2);
                        if (indexOf2 != -1) {
                            vectorArr[f2815Ze].addElement(readLine.substring(i2, indexOf2));
                            int i3 = indexOf2 + 1;
                            vectorArr[f2816Zf].addElement(readLine.substring(i3, readLine.indexOf(58, i3)));
                        }
                    }
                }
                f2813Zc = (String[][]) Array.newInstance((Class<?>) String.class, 3, vectorArr[0].size());
                for (int i4 = 0; i4 < f2813Zc.length; i4++) {
                    f2813Zc[i4] = C0488o.m2644c(vectorArr[i4]);
                }
            }
            return C0488o.m2642b(f2813Zc[f2815Ze]);
        } catch (Exception e) {
            return null;
        }
    }

    public static String[] m2564ri() {
        Vector vector = new Vector();
        for (int i = 0; i < f2813Zc[f2815Ze].length; i++) {
            if (f2813Zc[f2815Ze][i].equals(f2812Zb)) {
                vector.addElement(f2813Zc[f2816Zf][i]);
            }
        }
        return C0488o.m2642b(C0488o.m2644c(vector));
    }

    public static long m2568s(int i, String str) {
        long j;
        try {
            C0483j c0483j = f2809Ym.f2827Yn.aeI.m2660cN(str.toLowerCase()).get(Integer.valueOf(i));
            j = c0483j != null ? c0483j.m2622sS() : 0L;
        } catch (Exception e) {
            C0012k.m41c("IAP-IAPLib", "Expcetion, getVirtualCurrency : " + e);
            j = -1;
        }
        C0012k.m41c("IAP-IAPLib", "PricePoint: " + i + " itemType: " + str + "GetVirtualCurrency: " + j);
        return j;
    }

    public static void setResult(int i) {
        f2809Ym.state = i;
        if (f2809Ym.state == 2 || f2809Ym.state == 10) {
            C0012k.m41c("IAP-IAPLib", "clear transaction in progress status");
            f2796YN = false;
        }
        C0012k.m39a("IAP-IAPLib", "result: " + i);
    }

    public static float m2569t(int i, String str) {
        try {
            C0483j c0483j = f2809Ym.f2827Yn.aeI.m2660cN(str.toLowerCase()).get(Integer.valueOf(i));
            if (c0483j == null) {
                return -1.0f;
            }
            return C0488o.m2646cH(c0483j.m2620sQ().f2745Zr);
        } catch (Exception e) {
            C0012k.m41c("IAP-IAPLib", "GetPriceValue - exception: " + e.getMessage());
            return -1.0f;
        }
    }

    public static String m2570u(int i, String str) {
        try {
            C0483j c0483j = f2809Ym.f2827Yn.aeI.m2660cN(str.toLowerCase()).get(Integer.valueOf(i));
            if (c0483j == null) {
                return null;
            }
            return c0483j.m2620sQ().f2746Zs;
        } catch (Exception e) {
            C0012k.m41c("IAP-IAPLib", "getItemCurrencyISOCode - exception: " + e.getMessage());
            return null;
        }
    }

    public static String m2571v(int i, String str) {
        try {
            C0483j c0483j = f2809Ym.f2827Yn.aeI.m2660cN(str.toLowerCase()).get(Integer.valueOf(i));
            if (c0483j == null) {
                return null;
            }
            return c0483j.getId();
        } catch (Exception e) {
            C0012k.m41c("IAP-IAPLib", "GetItemContentID - exception: " + e.getMessage());
            return null;
        }
    }
}
