package com.gameloft.android2d.iap.utils;

import com.gameloft.android2d.iap.C0463b;
import java.net.URLEncoder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p001a.p004b.p005a.p006a.C0012k;

public final class C0491r {

    private static int f2880Ys;
    private static C0477d afe;
    private static String afg;
    private static RunnableC0479f afh;

    public static long f2882dI;
    private String url;
    public static boolean aff = true;

    public static String f2881dG = null;

    public C0491r(C0477d c0477d) {
        afe = c0477d;
        f2881dG = null;
        if (this.url != null && this.url.length() != 0) {
            this.url = this.url.trim();
        }
        afh = new RunnableC0479f();
        if (f2881dG == null) {
            f2881dG = "";
        } else {
            f2881dG = f2881dG.trim();
        }
    }

    public static void m2665E(int i) {
        f2880Ys = i;
    }

    public static void m2666J(String str, String str2) {
        C0012k.m41c("IAP-XPlayer", "sendHTTPVerificationGoogleBillingRequest");
        afh.cancel();
        String str3 = "b=contentpurchase" + str2;
        if (!str.equals("https://secure.gameloft.com/freemium/wapbilling/validate.php")) {
            str2 = str3;
        }
        f2880Ys = -100;
        afh.m2607f(str, str2);
    }

    public static void m2667K(String str, String str2) {
        C0012k.m41c("IAP-XPlayer", "sendFreemiumLimitsValidationRequest");
        afh.cancel();
        f2880Ys = -100;
        afh.m2607f(str, "b=validatelimits" + str2);
    }

    public static void m2668a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        C0012k.m41c("IAP-XPlayer", "sendHTTPPurchaseRequest");
        afh.cancel();
        String str8 = (("b=contentpurchase|" + str4 + "|") + str2 + "|" + str3 + "|") + str5;
        if (str6 != null && !str6.equals("")) {
            str8 = str8 + "&d=" + str6;
        }
        f2880Ys = -100;
        afh.m2607f(str, str8 + "&phoneId=" + str7);
    }

    public static void m2669a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        C0012k.m41c("IAP-XPlayer", "sendUMPTransactionRequest");
        afh.cancel();
        f2880Ys = -100;
        afh.m2607f(str, "game=" + str2 + "&content=" + str3 + "&price=" + str4 + "&money=" + str5 + "&ggi=" + str6 + "&gliveid=" + str7 + "&imei=" + str8 + "&umpversion=" + str9 + "&timestamp=" + str10 + "&d=" + str11 + "&sign=" + str12);
    }

    public static void m2670a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15) {
        C0012k.m41c("IAP-XPlayer", "sendUMPTransactionRequest");
        afh.cancel();
        f2880Ys = -100;
        afh.m2607f(str, "game=" + str2 + "&content=" + str3 + "&price=" + str4 + "&money=" + str5 + "&ggi=" + str6 + "&gliveid=" + str7 + "&imei=" + str8 + "&timestamp=" + str9 + "&d=" + str10 + "&cardnumber=" + str11 + "&cardpwd=" + str12 + "&cardmoney=" + str13 + "&cardtype=" + str14 + "&sign=" + str15);
    }

    private static String m2671ay(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (Exception e) {
            return str;
        }
    }

    private static String m2672c(String str, int i, char c) {
        int i2 = 0;
        int indexOf = str.indexOf(124, 1);
        int i3 = i;
        while (i3 > 0) {
            if (i2 == -1) {
                return null;
            }
            i3--;
            i2 = indexOf;
            indexOf = str.indexOf(124, indexOf + 1);
        }
        if (i2 == -1) {
            return null;
        }
        if (indexOf == -1) {
            indexOf = str.length();
        }
        if (i > 0) {
            i2++;
        }
        if (i2 == indexOf) {
            return "";
        }
        if (i2 > indexOf) {
            return null;
        }
        try {
            char[] cArr = new char[indexOf - i2];
            str.getChars(i2, indexOf, cArr, 0);
            return new String(cArr);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public static void m2673cP(String str) {
        C0477d.m2600sI();
        C0477d.m2599sH();
        afh.cancel();
        StringBuilder append = new StringBuilder().append("").append("game=").append(m2671ay(C0463b.m2530qC())).append("&network_country_ISO=");
        C0477d c0477d = afe;
        StringBuilder append2 = append.append(m2671ay(C0477d.getNetworkCountryIso())).append("&network_operator=");
        C0477d c0477d2 = afe;
        StringBuilder append3 = append2.append(m2671ay(C0477d.getNetworkOperator())).append("&network_operator_name=");
        C0477d c0477d3 = afe;
        StringBuilder append4 = append3.append(m2671ay(C0477d.getNetworkOperatorName())).append("&sim_country_iso=");
        C0477d c0477d4 = afe;
        StringBuilder append5 = append4.append(m2671ay(C0477d.getSimCountryIso())).append("&sim_operator=");
        C0477d c0477d5 = afe;
        StringBuilder append6 = append5.append(m2671ay(C0477d.getSimOperator())).append("&sim_operator_name=");
        C0477d c0477d6 = afe;
        StringBuilder append7 = append6.append(m2671ay(C0477d.getSimOperatorName())).append("&line_number=");
        C0477d c0477d7 = afe;
        StringBuilder append8 = append7.append(m2671ay(C0477d.m2589av())).append("&is_network_roaming=");
        C0477d c0477d8 = afe;
        StringBuilder append9 = append8.append(C0477d.m2603sL()).append("&android_build_device=");
        C0477d c0477d9 = afe;
        StringBuilder append10 = append9.append(m2671ay(C0477d.m2602sK())).append("&android_build_model=");
        C0477d c0477d10 = afe;
        String sb = append10.append(m2671ay(C0477d.m2601sJ())).append("&supportswap=1&game_version=").append(C0463b.m2532qE()).append("&lang=").append(m2671ay(C0463b.getLanguage().toLowerCase())).append("&supportscc=").append(C0463b.m2533qF() ? "1" : "0").append("&supports_wapother=").append(C0463b.f2800YR ? "1" : "0").append("&supports_paypal=").append(C0463b.f2801YS ? "1" : "0").append("&supports_amazon=").append(C0463b.f2802YT ? "1" : "0").append("&supportsoem=").append(C0463b.m2536qI() ? "1" : "0").append(C0463b.m2537qJ() ? "&supports_sms=0" : "").append(C0463b.m2538qK() ? "&supports_http=0" : "").append("&supports_ump=").append(C0463b.m2534qG() ? "1" : "0").append("&supports_shenzhoufu=").append(C0463b.m2535qH() ? "1" : "0").append("&show_2d_tier=").append(!C0463b.f2792YJ.equals("USE_IAP_GL_SHOP") ? "1" : "0").append("&supports_ccprices=").append(!C0463b.f2794YL ? "1" : "0").append(C0463b.f2805YW ? "&v=1.2" : "").append("&d=").append(m2671ay(C0463b.m2531qD())).toString();
        f2880Ys = -100;
        f2882dI = System.currentTimeMillis();
        afh.m2607f(str, sb);
    }

    public static void m2674cQ(String str) {
        C0012k.m41c("IAP-XPlayer", "sendGetHKServicesNameRequest");
        afh.cancel();
        f2880Ys = -100;
        afh.m2607f(str, "");
    }

    public static void m2675cR(String str) {
        C0012k.m41c("IAP-XPlayer", "SendManagedContentItemPurchasedRequest ...");
        afh.cancel();
        f2880Ys = -100;
        String property = System.getProperty("UserName");
        C0477d c0477d = afe;
        afh.m2607f(str, "game=" + m2671ay(C0463b.m2530qC()) + "&imei=" + m2671ay(C0477d.m2588au()) + "&acnum" + m2671ay(property));
    }

    public static void m2676cS(String str) {
        afg = new JSONObject(str).optString("message");
    }

    public static void m2677cT(String str) {
        C0012k.m41c("IAP-XPlayer", "sendTimeStampPurchaseRequest");
        afh.cancel();
        f2880Ys = -100;
        afh.m2607f(str, "");
    }

    public static void m2678d(String str, String str2, String str3, String str4, String str5) {
        C0012k.m41c("IAP-XPlayer", "sendUMPBillingCheckRequest");
        afh.cancel();
        f2880Ys = -100;
        afh.m2607f(str, "transactionid=" + str2 + "&timestamp=" + str3 + "&imei=" + str4 + "&sign=" + str5);
    }

    public static void m2679e(String str, String str2, String str3, String str4, String str5) {
        C0012k.m41c("IAP-XPlayer", "sendUMPBillingCheckRequest");
        afh.cancel();
        f2880Ys = -100;
        afh.m2607f(str, "transactionid=" + str2 + "&timestamp=" + str3 + "&imei=" + str4 + "&sign=" + str5);
    }

    public static C0474a m2680sM() {
        C0477d c0477d = afe;
        return C0477d.m2604sM();
    }

    public static C0477d m2681tf() {
        return afe;
    }

    public static int m2682tg() {
        return f2880Ys;
    }

    public static boolean m2683tm() {
        C0012k.m41c("IAP-XPlayer", "handleGetHKServicesNameRequest");
        if (afh.isInProgress()) {
            return false;
        }
        if (afh.f2870dC) {
            return true;
        }
        if (afh.f2868dA != null && afh.f2868dA != "") {
            String str = afh.f2868dA;
            C0012k.m41c("IAP-XPlayer", str);
            try {
                JSONArray optJSONArray = new JSONObject(str).optJSONArray("s");
                for (int i = 0; i < optJSONArray.length(); i++) {
                    C0012k.m41c("IAP-XPlayer", "Services: " + optJSONArray.getString(i));
                    C0463b.f2817Zg.add(optJSONArray.getString(i));
                }
            } catch (JSONException e) {
            }
        }
        return true;
    }

    public static boolean m2684to() {
        C0012k.m41c("IAP-XPlayer", "handleFreemiumLimitsValidationRequest");
        if (afh.isInProgress()) {
            return false;
        }
        if (afh.f2870dC) {
            return true;
        }
        if (afh.f2868dA != null && afh.f2868dA != "") {
            return true;
        }
        f2880Ys = 40;
        return true;
    }

    public static boolean m2685tp() {
        C0012k.m41c("IAP-XPlayer", "handleManagedContentItemPurchasedRequest ...");
        if (afh.isInProgress()) {
            return false;
        }
        if (afh.f2870dC) {
            return true;
        }
        if (afh.f2868dA == null || afh.f2868dA == "") {
            f2880Ys = 40;
            return true;
        }
        String str = afh.f2868dA;
        if (str != null) {
            C0463b.f2820Zj = new String("," + str.substring(1, str.length() - 1) + ",");
        }
        C0012k.m41c("IAP-XPlayer", C0463b.f2820Zj);
        return true;
    }

    public static RunnableC0479f m2686tq() {
        return afh;
    }

    public static String m2687tr() {
        return afg;
    }

    public static boolean m2688ts() {
        C0012k.m41c("IAP-XPlayer", "handleTimeStampPurchaseRequest");
        if (afh.isInProgress()) {
            return false;
        }
        if (afh.f2870dC) {
            return true;
        }
        if (afh.f2868dA == null || afh.f2868dA == "") {
            f2880Ys = 40;
            return true;
        }
        C0012k.m41c("IAP-XPlayer", "handleTimeStampPurchaseRequest:" + afh.f2868dA);
        f2880Ys = 0;
        return true;
    }

    public static String m2689tt() {
        return afh.f2868dA;
    }

    public final boolean m2690ch() {
        C0012k.m41c("IAP-XPlayer", "handleHTTPPurchaseRequest");
        if (afh.isInProgress()) {
            return false;
        }
        if (afh.f2870dC) {
            return true;
        }
        if (afh.f2868dA != null && afh.f2868dA != "") {
            String m2672c = m2672c(afh.f2868dA, 0, '|');
            try {
                if (m2672c.equals("FAILURE")) {
                    f2880Ys = Integer.parseInt(m2672c(afh.f2868dA, 1, '|'));
                    return true;
                }
                if (m2672c.equals("SUCCESS")) {
                    f2880Ys = 0;
                    return true;
                }
            } catch (NumberFormatException e) {
                f2880Ys = 40;
                String m2672c2 = m2672c(afh.f2868dA, 1, '|');
                if (m2672c2.indexOf("PB") != -1) {
                    try {
                        f2880Ys = Integer.parseInt(m2672c2.substring(2, m2672c2.length()));
                    } catch (NumberFormatException e2) {
                    }
                }
                return true;
            }
        }
        f2880Ys = 40;
        return true;
    }

    public final String m2691qB() {
        return (afh.f2868dA == null || afh.f2868dA == "") ? "0" : m2672c(afh.f2868dA, 2, '|');
    }

    public final boolean m2692th() {
        C0012k.m39a("IAP-XPlayer", "handleProfileRequest()");
        if (afh.isInProgress()) {
            if (System.currentTimeMillis() - f2882dI <= 10000) {
                return false;
            }
            f2882dI = 0L;
            afh.cancel();
            f2880Ys = -2;
            return true;
        }
        if (afh.f2870dC) {
            return true;
        }
        C0012k.m39a("IAP-XPlayer", "Value for response on whttp.m_response =" + afh.f2868dA);
        if (afh.f2868dA == null || afh.f2868dA == "") {
            f2880Ys = 40;
            return true;
        }
        f2880Ys = 0;
        if (!afh.f2868dA.contains("error")) {
            return true;
        }
        f2880Ys = 40;
        return true;
    }

    public final String[] m2693ti() {
        C0012k.m41c("IAP-XPlayer", "handleUMPTransactionRequest");
        if (afh.isInProgress()) {
            return null;
        }
        if (afh.f2870dC) {
            return new String[]{"error"};
        }
        if (afh.f2868dA != null && afh.f2868dA != "") {
            String m2672c = m2672c(afh.f2868dA, 0, '|');
            try {
                if (m2672c.equals("FAILURE")) {
                    f2880Ys = Integer.parseInt(m2672c(afh.f2868dA, 1, '|'));
                    return new String[]{m2672c(afh.f2868dA, 0, '|'), m2672c(afh.f2868dA, 1, '|')};
                }
                if (m2672c.equals("SUCCESS")) {
                    f2880Ys = 0;
                    return new String[]{m2672c(afh.f2868dA, 0, '|'), m2672c(afh.f2868dA, 1, '|'), m2672c(afh.f2868dA, 2, '|'), m2672c(afh.f2868dA, 3, '|')};
                }
            } catch (NumberFormatException e) {
                f2880Ys = 40;
                String m2672c2 = m2672c(afh.f2868dA, 1, '|');
                String[] strArr = {m2672c(afh.f2868dA, 0, '|'), m2672c(afh.f2868dA, 1, '|')};
                if (m2672c2.indexOf("PB") == -1) {
                    return strArr;
                }
                try {
                    f2880Ys = Integer.parseInt(m2672c2.substring(2, m2672c2.length()));
                    return strArr;
                } catch (NumberFormatException e2) {
                    return strArr;
                }
            }
        }
        f2880Ys = 40;
        return new String[]{"error"};
    }

    public final boolean m2694tj() {
        C0012k.m41c("IAP-XPlayer", "handleUMPBillingCheckPurchaseRequest");
        if (afh.isInProgress()) {
            return false;
        }
        if (afh.f2870dC) {
            return true;
        }
        if (afh.f2868dA != null && afh.f2868dA != "") {
            String m2672c = m2672c(afh.f2868dA, 0, '|');
            try {
                if (m2672c.equals("FAILURE")) {
                    f2880Ys = Integer.parseInt(m2672c(afh.f2868dA, 1, '|'));
                    return true;
                }
                if (m2672c.equals("SUCCESS")) {
                    f2880Ys = 0;
                    return true;
                }
            } catch (NumberFormatException e) {
                f2880Ys = 40;
                String m2672c2 = m2672c(afh.f2868dA, 1, '|');
                if (m2672c2.indexOf("PB") != -1) {
                    try {
                        f2880Ys = Integer.parseInt(m2672c2.substring(2, m2672c2.length()));
                    } catch (NumberFormatException e2) {
                    }
                }
                return true;
            }
        }
        f2880Ys = 40;
        return true;
    }

    public final String[] m2695tk() {
        C0012k.m41c("IAP-XPlayer", "handleShenzhoufuTransactionRequest");
        if (afh.isInProgress()) {
            return null;
        }
        if (afh.f2870dC) {
            return new String[]{"error"};
        }
        if (afh.f2868dA != null && afh.f2868dA != "") {
            String m2672c = m2672c(afh.f2868dA, 0, '|');
            try {
                if (m2672c.equals("FAILURE")) {
                    f2880Ys = Integer.parseInt(m2672c(afh.f2868dA, 1, '|'));
                    return new String[]{m2672c(afh.f2868dA, 0, '|'), m2672c(afh.f2868dA, 1, '|')};
                }
                if (m2672c.equals("SUCCESS")) {
                    f2880Ys = 0;
                    return new String[]{m2672c(afh.f2868dA, 0, '|'), m2672c(afh.f2868dA, 1, '|')};
                }
            } catch (NumberFormatException e) {
                f2880Ys = 40;
                String m2672c2 = m2672c(afh.f2868dA, 1, '|');
                String[] strArr = {m2672c(afh.f2868dA, 0, '|'), m2672c(afh.f2868dA, 1, '|')};
                if (m2672c2.indexOf("PB") == -1) {
                    return strArr;
                }
                try {
                    f2880Ys = Integer.parseInt(m2672c2.substring(2, m2672c2.length()));
                    return strArr;
                } catch (NumberFormatException e2) {
                    return strArr;
                }
            }
        }
        f2880Ys = 40;
        return new String[]{"error"};
    }

    public final boolean m2696tl() {
        C0012k.m41c("IAP-XPlayer", "handleUMPBillingCheckPurchaseRequest");
        if (afh.isInProgress()) {
            return false;
        }
        if (afh.f2870dC) {
            return true;
        }
        if (afh.f2868dA != null && afh.f2868dA != "") {
            String m2672c = m2672c(afh.f2868dA, 0, '|');
            try {
                if (m2672c.equals("FAILURE")) {
                    f2880Ys = Integer.parseInt(m2672c(afh.f2868dA, 1, '|'));
                    return true;
                }
                if (m2672c.equals("SUCCESS")) {
                    f2880Ys = 0;
                    return true;
                }
            } catch (NumberFormatException e) {
                f2880Ys = 40;
                String m2672c2 = m2672c(afh.f2868dA, 1, '|');
                if (m2672c2.indexOf("PB") != -1) {
                    try {
                        f2880Ys = Integer.parseInt(m2672c2.substring(2, m2672c2.length()));
                    } catch (NumberFormatException e2) {
                    }
                }
                return true;
            }
        }
        f2880Ys = 40;
        return true;
    }

    public final boolean m2697tn() {
        C0012k.m41c("IAP-XPlayer", "handleHTTPVerificationBillingRequest");
        if (afh.isInProgress()) {
            return false;
        }
        if (afh.f2870dC) {
            return true;
        }
        if (afh.f2868dA != null && afh.f2868dA != "") {
            String m2672c = m2672c(afh.f2868dA, 0, '|');
            try {
                if (m2672c.equals("FAILURE")) {
                    f2880Ys = -1000;
                    return true;
                }
                if (m2672c.equals("SUCCESS")) {
                    f2880Ys = 0;
                    return true;
                }
            } catch (NumberFormatException e) {
                f2880Ys = 40;
                String m2672c2 = m2672c(afh.f2868dA, 1, '|');
                if (m2672c2.indexOf("PB") != -1) {
                    try {
                        f2880Ys = Integer.parseInt(m2672c2.substring(2, m2672c2.length()));
                    } catch (NumberFormatException e2) {
                    }
                }
                return true;
            }
        }
        f2880Ys = 40;
        return true;
    }
}
