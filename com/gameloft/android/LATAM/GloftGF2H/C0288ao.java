package com.gameloft.android.LATAM.GloftGF2H;

import com.facebook.widget.PlacePickerFragment;
import com.gameloft.android.wrapper.C0355i;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.Hashtable;
import java.util.Random;
import java.util.Timer;
import java.util.Vector;
import p009b.p010a.p015d.AbstractActivityC0092a;
import p009b.p010a.p016e.C0100b;
import p009b.p018b.p019a.C0107b;

public final class C0288ao {

    private static RunnableC0345y f547wk;

    private static int f548wl;

    private static AbstractActivityC0092a f539wc = null;

    static int f540wd = -1;

    static String f541we = "";

    static int f542wf = -1;

    private static String f543wg = "";

    private static long f544wh = -1;

    private static long f545wi = -1;

    private static String f546wj = "PaySMS.IAP.Version:1.1.9";

    private static boolean f549wm = false;

    private static String[][] f550wn = null;

    private static boolean f551wo = false;

    private static Vector[] f552wp = null;

    private static String[][] f553wq = null;

    private static String[][] f554wr = null;

    private static int[] f555ws = null;

    private static String[][] f556wt = null;

    private static Hashtable f557wu = null;

    private static int f558wv = -1;

    private static Vector f559ww = null;

    private static Vector f560wx = null;

    private static int f561wy = -1;

    private static String[] f562wz = null;

    private static int f513wA = -1;

    private static String[][] f514wB = null;

    private static String[] f515wC = null;

    private static String f516wD = null;

    private static String f517wE = null;

    private static String f518wF = null;

    private static String f519wG = null;

    private static String f520wH = null;

    private static String f521wI = null;

    private static String f522wJ = null;

    private static String f523wK = null;

    private static String f524wL = null;

    private static String f525wM = "";

    private static String f526wN = "";

    private static int f527wO = -1;

    private static String f528wP = "0";

    private static long f529wQ = 0;

    private static long f530wR = 1;

    public static final String[] f531wS = {"rmsSMS", "Cm1zY2", "rmsPackageId", "rmsAvailableProfiles", "rmsRedeemUnlocked", "rmsItemType", "rmsUnlocked", "rmsMoneySpent", "rmsCurrentRegion", "rmsCurrentCarrier", "Cm1zY1", "rmsSMSCnt", "rmsLastBillingType", "rmsLastAmount"};

    private static boolean f532wT = false;

    private static boolean f533wU = false;

    private static boolean f534wV = false;

    private static boolean f535wW = false;

    private static boolean f536wX = false;

    private static boolean f537wY = false;

    private static String f538wZ = "";

    private static String f566xa = "";

    private static String f567xb = "";

    private static String f568xc = "";

    private static String f569xd = "";

    private static String f570xe = "";

    private static String f571xf = "";

    private static String f572xg = "/IAP_profiles";

    private static String f573xh = "/IAP_texts";

    private static String f574xi = "/IAP_SpecialFlowTexts";

    private static Timer f512dZ = null;

    public static C0107b f575xj = null;

    public static boolean f576xk = false;

    public static boolean f577xl = false;

    private static int f578xm = 0;
    private static int errorCode = 0;

    private static String f579xn = "933";

    private static String f580xo = "5023";

    private static String f581xp = "5025";

    private static String f582xq = "";

    private static String f583xr = "";

    private static String[] f584xs = {"Cash", "Coin"};

    private static Vector f585xt = null;

    private static Vector f586xu = null;

    private static Vector f587xv = null;

    private static String[] f588xw = null;

    private static boolean f589xx = false;

    private static boolean f590xy = false;

    private static int[] f591xz = {100, 110, 120, 130, 140, 150};

    private static int[] f563xA = {199, 399, 999, 1999, 2999, 3999};

    private static int f564xB = 4;

    private static char f565xC = '.';

    static {
        String[] strArr = {"2124", "2126", "2128", "2130", "3501", "3503", "3505", "3507", "3509", "3511"};
        String[] strArr2 = {"1152", "1154", "1049", "1156", "2741", "2743", "2745", "2878"};
        String[] strArr3 = {"1104", "1106", "1108", "1110"};
        String[] strArr4 = {"5133", "5031", "5033", "5135", "5229", "5231"};
        int[] iArr = {25, 50, 100, 150};
    }

    private static String m710G(int i, int i2) {
        int i3 = 0;
        if (m779cx() == 0) {
            while (true) {
                int i4 = i3;
                if (i4 >= f560wx.size()) {
                    break;
                }
                int intValue = ((Integer) f560wx.elementAt(i4)).intValue();
                if (f550wn[intValue][14].equals(String.valueOf(i2))) {
                    return f550wn[intValue][i];
                }
                i3 = i4 + 1;
            }
        } else {
            for (int i5 = 0; i5 < f553wq.length; i5++) {
                if (f553wq[i5][0].equals(f583xr)) {
                    return f553wq[i5][i];
                }
            }
        }
        return "";
    }

    private static String m711a(String str, int i, char c) {
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

    private static String m712a(String[][] strArr, int i, String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if (str.equals(strArr[i2][2]) && str2.equals(strArr[i2][3]) && Integer.parseInt(strArr[i2][14]) == i) {
                return strArr[i2][9];
            }
        }
        return null;
    }

    public static void m714a(int i, String str, long j) {
        String str2;
        String str3;
        String str4;
        new StringBuffer("PaySMS.sendRequest: start (PricePoint:").append(i).append(") (Item Type: ").append(str).append(") (overwriteVirtualCurrency: ").append(j).append(")").toString();
        if (!C0338r.f2521sk && !m788m(i, str)) {
            new StringBuffer("PaySMS.sendRequest: IAP-ContentID-").append(str).append("-").append(i).append(" missing in JAD").toString();
            return;
        }
        f542wf = i;
        if (C0338r.f2521sk) {
            f540wd = m787l(i, str);
        } else {
            f540wd = i;
        }
        f541we = str;
        boolean z = false;
        if (f538wZ.equals("1")) {
            str2 = f571xf;
        } else {
            if (m779cx() == 0) {
                new StringBuffer("PaySMS.sendRequest: currentValidProfiles: ").append(f560wx == null ? "null" : new StringBuffer("Size: ").append(f560wx.size()).toString()).toString();
                if (f560wx != null && f560wx.size() != 0) {
                    f527wO = 0;
                    int i2 = 0;
                    boolean z2 = false;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= f560wx.size()) {
                            str2 = "";
                            z = z2;
                            break;
                        }
                        int intValue = ((Integer) f560wx.elementAt(i3)).intValue();
                        try {
                        } catch (Exception e) {
                            f527wO = 0;
                        }
                        if (Integer.parseInt(f550wn[intValue][14]) == i) {
                            f527wO = intValue;
                            z2 = true;
                            str2 = f550wn[f527wO][6];
                            z = true;
                            break;
                        }
                        continue;
                        i2 = i3 + 1;
                    }
                } else {
                    f527wO = -1;
                    str2 = "";
                }
            } else {
                f550wn = f553wq;
                str2 = m779cx() == 1 ? "SMS" : m779cx() == 2 ? "HTTP" : "";
                int i4 = 0;
                while (true) {
                    if (i4 >= f550wn.length) {
                        break;
                    }
                    if (f550wn[i4][0].equals(f583xr)) {
                        f527wO = i4;
                        z = true;
                        break;
                    }
                    i4++;
                }
            }
            new StringBuffer("PaySMS.sendRequest: currentProfile: ").append(f527wO).toString();
            if (z && f527wO != -1) {
                new StringBuffer("PaySMS.sendRequest: Id: ").append(f550wn[f527wO][0]).append(" Billing: ").append(f550wn[f527wO][6]).append(" Region: ").append(f550wn[f527wO][2]).append(" Carrier: ").append(f550wn[f527wO][3]).append(" Pricepoint: ").append(f550wn[f527wO][14]).toString();
            }
        }
        if (f549wm) {
            new StringBuffer("creditCardEnabled: ").append(f589xx).toString();
            if (j > 0) {
                f529wQ = j;
            } else {
                f529wQ = m784i(i, str);
            }
            if (z && str2.equals("SMS")) {
                f532wT = true;
                f534wV = false;
                m792r(f531wS[0], "0");
                f525wM = "";
                if (f538wZ.equals("1")) {
                    f568xc = getProperty(new StringBuffer("IAP-Alias-PP").append(f542wf).toString());
                } else {
                    f568xc = "";
                }
                if (!f568xc.equals("")) {
                    m725af(f568xc);
                } else if (f527wO != -1 && !f550wn[f527wO][10].equals("")) {
                    m725af(f550wn[f527wO][10]);
                }
                if (f550wn[f527wO][12].equals("7")) {
                    m725af("UNLOCK");
                } else {
                    m725af("INAPP");
                }
                m725af("V016");
                m725af(f522wJ);
                m725af(f526wN);
                m725af(f523wK);
                if (f538wZ.equals("1")) {
                    f567xb = getProperty(new StringBuffer("IAP-ProfileID-PP").append(f542wf).toString());
                } else {
                    f567xb = "";
                }
                if (!f567xb.equals("")) {
                    m725af(f567xb);
                } else {
                    if (f527wO == -1) {
                        errorCode = 7;
                        return;
                    }
                    m725af(f550wn[f527wO][0]);
                }
                if (f543wg.equals("")) {
                    m725af("EN");
                } else {
                    m725af(f543wg);
                }
                if (f550wn[f527wO][12].equals("7")) {
                    m725af("7");
                } else {
                    m725af("1");
                }
                String property = getProperty(new StringBuffer("IAP-ContentID-").append(f541we).append("-").append(f542wf).toString());
                if (property.equals("")) {
                    new StringBuffer("PaySMS.sendHTTP:Error: Wrong Item. IAP-ContentID-").append(f541we).append("-").append(f542wf).append(" missing in JAD").toString();
                    errorCode = -2;
                    return;
                }
                m725af(property);
                if (C0338r.f2513sc) {
                    m725af(f524wL);
                }
                m725af(f528wP);
                m725af(new StringBuffer().append(f529wQ).toString());
                m725af(new StringBuffer("ct").append(f530wR).toString());
                f525wM.trim();
                new StringBuffer("PaySMS.sendSMS: smsContent: ").append(f525wM).toString();
                f535wW = true;
                new C0289ap().start();
                return;
            }
            if (!z || !str2.equals("HTTP")) {
                if (f589xx && f527wO == -1) {
                    m782g(i, str);
                    return;
                } else if (f589xx) {
                    m782g(i, str);
                    return;
                } else {
                    errorCode = -2;
                    return;
                }
            }
            f547wk = new RunnableC0345y(false);
            if (f538wZ.equals("1")) {
                str3 = f570xe;
                str4 = getProperty(new StringBuffer("IAP-ProfileID-PP").append(f542wf).toString());
                f567xb = str4;
            } else if (f527wO == -1) {
                errorCode = 7;
                return;
            } else {
                str3 = f550wn[f527wO][11];
                str4 = f550wn[f527wO][0];
            }
            if (str3.equals("") || str4.equals("")) {
                errorCode = 4;
                return;
            }
            new StringBuffer("PaySMS.sendHTTP: URL = ").append(str3).toString();
            if (!str3.startsWith("http://")) {
                str3 = new StringBuffer("http://").append(str3).toString();
            }
            if (!str3.endsWith("?")) {
                str3 = new StringBuffer().append(str3).append("?").toString();
            }
            String property2 = getProperty(new StringBuffer("IAP-ContentID-").append(f541we).append("-").append(f542wf).toString());
            if (property2.equals("")) {
                new StringBuffer("PaySMS.sendHTTP:Error: Wrong Item. IAP-ContentID-").append(f541we).append("-").append(f542wf).append(" missing in JAD").toString();
                errorCode = -2;
                return;
            }
            String str5 = f522wJ;
            String str6 = f526wN;
            String str7 = f524wL;
            String str8 = f523wK;
            f547wk.cancel();
            String str9 = C0338r.f2517sg ? "%7C" : "|";
            String stringBuffer = new StringBuffer().append(new StringBuffer().append(new StringBuffer("b=contentpurchase").append(str9).append(str5).append(str9).toString()).append(property2).append(str9).append(str4).append(str9).toString()).append(str6).toString();
            if (!str7.equals("")) {
                stringBuffer = new StringBuffer().append(stringBuffer).append("&d=").append(str7).toString();
            }
            String stringBuffer2 = new StringBuffer().append(stringBuffer).append("&phoneId=").append(str8).toString();
            f548wl = -100;
            f547wk.m2153a(str3, stringBuffer2, 0);
            m792r(f531wS[1], f526wN);
            m792r(f531wS[2], String.valueOf(f540wd));
            m792r(f531wS[5], f541we);
            m792r(f531wS[12], "http_2d");
            m792r(f531wS[13], new StringBuffer().append(f529wQ).toString());
            if (!f538wZ.equals("1")) {
                m715a(f560wx);
            }
            f578xm = 1;
        }
    }

    public static void m715a(Vector vector) {
        String str = "";
        for (int i = 0; i < vector.size(); i++) {
            str = new StringBuffer().append(str).append(vector.elementAt(i)).append(";").toString();
        }
        new StringBuffer("PaySMS.storeProfileID: ").append(str).toString();
        m792r(f531wS[3], String.valueOf(str));
    }

    private static boolean m716a(String[] strArr, String[] strArr2, String[] strArr3) {
        int i;
        int i2;
        if (strArr3 == null) {
            errorCode = 8;
            return false;
        }
        for (int i3 = 0; i3 < strArr3.length; i3++) {
            new StringBuffer("PaySMS.loadProfileConfiguration: profilesArgs[").append(i3).append("]: ").append(strArr3[i3]).toString();
        }
        int i4 = 0;
        int[] iArr = new int[strArr3.length];
        String[][] strArr4 = (String[][]) Array.newInstance((Class<?>) String.class, strArr3.length, 17);
        int i5 = 0;
        int[] iArr2 = new int[strArr3.length];
        int i6 = 0;
        while (i6 < strArr3.length) {
            int i7 = 0;
            for (int i8 = 0; i8 < 16; i8++) {
                int indexOf = strArr3[i6].indexOf(";", i7);
                strArr4[i6][i8] = strArr3[i6].substring(i7, indexOf);
                i7 = indexOf + 1;
            }
            if (m729aj(strArr4[i6][0])) {
                i = i5 + 1;
                iArr2[i5] = i6;
            } else {
                i = i5;
            }
            if (strArr4[i6][6].equals("CC")) {
                f588xw = strArr4[i6];
            }
            int i9 = 0;
            while (true) {
                if (i9 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i9];
                if (str == null || str.length() == 0 || !strArr4[i6][0].equals(str)) {
                    i9++;
                } else if (!m729aj(strArr4[i6][0]) && !strArr4[i6][6].equals("CC")) {
                    iArr[i4] = i6;
                    strArr2[i9] = null;
                    i2 = i4 + 1;
                }
            }
            i2 = i4;
            i6++;
            i4 = i2;
            i5 = i;
        }
        if (i5 != 0) {
            f553wq = new String[i5][];
            for (int i10 = 0; i10 < f553wq.length; i10++) {
                f553wq[i10] = strArr4[iArr2[i10]];
            }
        }
        if (i4 == 0) {
            return false;
        }
        f550wn = new String[i4][];
        for (int i11 = 0; i11 < f550wn.length; i11++) {
            f550wn[i11] = strArr4[iArr[i11]];
        }
        for (int i12 = 0; i12 < i4; i12++) {
            try {
                String str2 = f550wn[i12][9];
                String m712a = m712a(strArr4, 3, f550wn[i12][2], f550wn[i12][3]);
                int parseInt = Integer.parseInt(f550wn[i12][14]);
                if (m712a != null) {
                    f550wn[i12][16] = new StringBuffer().append(((m734ao(str2) * f591xz[parseInt - 1]) * 100000) / m734ao(m712a)).toString();
                } else {
                    new StringBuffer("Tier 3 of this profile is not found, searching for Tier 2, Profile : ").append(f550wn[i12][0]).toString();
                    long j = 1;
                    String m712a2 = m712a(strArr4, 2, f550wn[i12][2], f550wn[i12][3]);
                    if (m712a2 == null) {
                        new StringBuffer("Tier 2 of this profile is not found, searching for Tier 1, Profile : ").append(f550wn[i12][0]).toString();
                        String m712a3 = m712a(strArr4, 1, f550wn[i12][2], f550wn[i12][3]);
                        if (m712a3 == null) {
                            new StringBuffer("Tier 1 of this profile is not found, searching for Tier 4, Profile : ").append(f550wn[i12][0]).toString();
                            String m712a4 = m712a(strArr4, 4, f550wn[i12][2], f550wn[i12][3]);
                            if (m712a4 != null) {
                                j = (m734ao(m712a4) * f563xA[2]) / f563xA[3];
                            }
                        } else {
                            j = (m734ao(m712a3) * f563xA[2]) / f563xA[0];
                        }
                    } else {
                        j = (m734ao(m712a2) * f563xA[2]) / f563xA[1];
                    }
                    f550wn[i12][16] = new StringBuffer().append(((m734ao(str2) * f591xz[parseInt - 1]) * 100000) / j).toString();
                }
                new StringBuffer("profile Id :\t").append(f550wn[i12][0]).append("\tTier:\t").append(parseInt).append("\tRatios :\t").append(f550wn[i12][16]).toString();
            } catch (Exception e) {
            }
        }
        m780cy();
        return true;
    }

    public static boolean m717aT(int i) {
        String m744cC = m744cC();
        f526wN = m744cC;
        boolean z = (m744cC == null || f526wN.length() <= 0) ? false : String.valueOf(i).equals(String.valueOf(Integer.parseInt(f526wN) ^ 53412));
        new StringBuffer("PaySMS.verifyRequest: inputCode: ").append(i).append(" ").append(z ? "Unlocked" : "Still Locked").toString();
        if (z) {
            if (C0338r.f2488sD && !f590xy) {
                try {
                    String m732am = m732am(f531wS[7]);
                    String substring = (m732am == null || m732am.equals("")) ? "0" : m732am.substring(0, m732am.indexOf(95));
                    int m769cn = m769cn();
                    String m746cE = m746cE();
                    if (C0338r.f2521sk) {
                        m769cn = m786k(m769cn, m746cE);
                    }
                    String m710G = m710G(0, m769cn);
                    String m710G2 = m710G(9, m769cn);
                    String replace = substring.replace(',', '.');
                    String replace2 = m710G2.replace(',', '.');
                    long m734ao = m734ao(replace);
                    long m734ao2 = m734ao(replace2);
                    char c = (replace.indexOf(f565xC) == -1 && replace2.indexOf(f565xC) == -1) ? ' ' : f565xC;
                    long j = m734ao + m734ao2;
                    String stringBuffer = c == ' ' ? new StringBuffer().append(j / 100000).toString() : new StringBuffer().append(j / 100000).append(c).append(j % 100000).toString();
                    new StringBuffer("totalMoneySpent : ").append(stringBuffer).append("  profileID: ").append(m710G).toString();
                    m792r(f531wS[7], new StringBuffer().append(stringBuffer).append("_").append(m710G).toString());
                } catch (Exception e) {
                    new StringBuffer("Exception : ").append(e).toString();
                }
            }
            errorCode = 0;
            if (!m719aV(m769cn()).equals("http_2d")) {
                f537wY = true;
            }
            m770co();
        }
        return z;
    }

    private static String m718aU(int i) {
        int i2;
        int i3 = 0;
        if (f590xy) {
            return " ";
        }
        new StringBuffer("PaySMS.getPrice: begin (").append(i).append(")").toString();
        if (f538wZ.equals("1")) {
            String property = getProperty(new StringBuffer("IAP-Price-PP").append(i).toString());
            f569xd = property;
            if (property.equals("")) {
                return null;
            }
            return f569xd;
        }
        new StringBuffer("PaySMS.getPrice: currentValidProfiles: ").append(f560wx == null ? "NULL" : new StringBuffer("Size: ").append(f560wx.size()).toString()).toString();
        if (f560wx == null) {
            if (f589xx) {
                return " ";
            }
            return null;
        }
        if (m779cx() == 0) {
            while (true) {
                if (i3 >= f560wx.size()) {
                    i2 = -1;
                    break;
                }
                i2 = ((Integer) f560wx.elementAt(i3)).intValue();
                if (Integer.parseInt(f550wn[i2][14]) == i) {
                    break;
                }
                i3++;
            }
        } else {
            for (int i4 = 0; i4 < f553wq.length; i4++) {
                if (f553wq[i4][0].equals(f583xr)) {
                    return f553wq[i4][9];
                }
            }
            i2 = -1;
        }
        new StringBuffer("PaySMS.getPrice: profileIndex: ").append(i2).toString();
        if (i2 != -1) {
            return f550wn[i2][4];
        }
        if (f589xx) {
            return " ";
        }
        return null;
    }

    private static String m719aV(int i) {
        int i2;
        boolean z = false;
        if (m779cx() != 0) {
            if (m779cx() == 1) {
                return "sms_2d";
            }
            if (m779cx() == 2) {
                return "http_2d";
            }
            if (m779cx() == 3) {
                return "cc_2d";
            }
        }
        new StringBuffer("PaySMS.GetBillingType: currentValidProfiles: ").append(f560wx == null ? "NULL" : new StringBuffer("Size: ").append(f560wx.size()).toString()).toString();
        if (f560wx == null) {
            return "cc_2d";
        }
        int i3 = 0;
        while (true) {
            if (i3 >= f560wx.size()) {
                i2 = 0;
                break;
            }
            i2 = ((Integer) f560wx.elementAt(i3)).intValue();
            if (Integer.parseInt(f550wn[i2][14]) == i) {
                z = true;
                break;
            }
            i3++;
        }
        if (!z) {
            return "cc_2d";
        }
        if (f550wn[i2][6].equals("SMS")) {
            return "sms_2d";
        }
        if (f550wn[i2][6].equals("HTTP")) {
            return "http_2d";
        }
        return null;
    }

    private static String m720aW(int i) {
        String property;
        String[][] strArr = {new String[]{"mcc", "phone.mcc", "MCC", "com.sonyericsson.net.mcc", "com.lge.net.cmcc"}, new String[]{"mnc", "phone.mnc", "MNC", "com.sonyericsson.net.mnc", "com.lge.net.cmnc"}, new String[]{"IMSI", "phone.imsi", "imsi"}};
        if (i >= 0 && i < strArr.length) {
            for (String str : strArr[i]) {
                try {
                    property = System.getProperty(str);
                } catch (Exception e) {
                }
                if (!m733an(property)) {
                    new StringBuffer("PaySMS. getNetworkInfo ").append(property).toString();
                    return property;
                }
                continue;
            }
        }
        return null;
    }

    public static int m721aX(int i) {
        if (m750cI() != 6 || f560wx == null) {
            return 0;
        }
        for (int i2 = 0; i2 < f560wx.size(); i2++) {
            int intValue = ((Integer) f560wx.elementAt(i2)).intValue();
            if (Integer.parseInt(f550wn[intValue][14]) == i) {
                long m734ao = m734ao(f550wn[intValue][9]);
                new StringBuffer("Fixed price : ").append(f550wn[intValue][9]).toString();
                if (m734ao <= 500000) {
                    return 0;
                }
                new StringBuffer("Found Price greater than 5 Euros : ").append(f550wn[intValue][9]).toString();
                return 1;
            }
            continue;
        }
        return 0;
    }

    private static boolean m723ad(String str) {
        new StringBuffer("PaySMS.setRegion: start (Region: ").append(str).append(")").toString();
        if (str.equals("Other")) {
            f590xy = true;
            m777cv();
            return true;
        }
        if (f514wB == null) {
            return false;
        }
        for (int i = 0; i < f514wB.length; i++) {
            if (m794t(str, f514wB[i][0])) {
                f558wv = i;
                f513wA = i;
                m792r(f531wS[8], str);
                new StringBuffer("PaySMS.setRegion: REGION: ").append(str).append(" - ID: ").append(i).toString();
                m771cp();
                m777cv();
                return true;
            }
        }
        return false;
    }

    private static boolean m724ae(String str) {
        new StringBuffer("PaySMS.setCarrier: start (Carrier: ").append(str).append(")").toString();
        if (f550wn == null || f514wB == null || f513wA == -1) {
            return false;
        }
        if (str.equals("Other")) {
            f590xy = true;
            m777cv();
            return true;
        }
        if (f560wx == null) {
            f560wx = new Vector();
        }
        f560wx.removeAllElements();
        for (int i = 0; i < f550wn.length; i++) {
            if (f550wn[i][2].indexOf(f514wB[f513wA][0]) != -1) {
                for (int i2 = 0; i2 < f552wp[i].size(); i2++) {
                    String str2 = (String) f552wp[i].elementAt(i2);
                    if (str2 != null) {
                        int indexOf = str2.indexOf(40);
                        if (indexOf == -1) {
                            indexOf = str2.length();
                        }
                        if (m794t(str, str2.substring(0, indexOf))) {
                            f560wx.addElement(new Integer(i));
                        }
                    }
                }
            }
        }
        if (f560wx.size() <= 0) {
            return false;
        }
        new StringBuffer("PaySMS.setCarrier: currentValidProfiles.size() ").append(f560wx.size()).toString();
        m777cv();
        m792r(f531wS[9], str);
        return true;
    }

    private static void m725af(String str) {
        if (str != null) {
            f525wM = new StringBuffer().append(f525wM).append(str).append(" ").toString();
        }
    }

    private static String[][] m726ag(String str) {
        Vector vector = new Vector();
        for (int i = 0; i < f550wn.length; i++) {
            if (f550wn[i][2].indexOf(str) != -1) {
                for (int i2 = 0; i2 < f552wp[i].size(); i2++) {
                    String str2 = (String) f552wp[i].elementAt(i2);
                    String str3 = f550wn[i][0];
                    if (str2 != null) {
                        int indexOf = str2.indexOf(40);
                        if (indexOf == -1) {
                            indexOf = str2.length();
                        }
                        new StringBuffer("PaySMS.getProfilesCarrierAndIds: regionName = ").append(str).append(", carrierName = ").append(str2).toString();
                        if ((f520wH == null || m793s(str2, f520wH)) && !vector.contains(str2.substring(0, indexOf))) {
                            vector.addElement(new String[]{str2.substring(0, indexOf), str3});
                            new StringBuffer("PaySMS.getProfilesCarrierAndIds: carrierName = ").append(str2.substring(0, indexOf)).toString();
                            if (f520wH != null) {
                                m792r(f531wS[9], new String(str2.substring(0, indexOf)));
                            }
                        }
                    }
                }
            }
        }
        String[][] strArr = (String[][]) Array.newInstance((Class<?>) String.class, vector.size(), 2);
        vector.copyInto(strArr);
        return strArr;
    }

    public static int m727ah(String str) {
        if (str.equals("Cash")) {
            return f586xu.size();
        }
        if (str.equals("Coin")) {
            return f587xv.size();
        }
        return -1;
    }

    private static String m728ai(String str) {
        new StringBuffer("PaySMS.retrieveTermsAndConditions: id = '").append(str).append("'").toString();
        if (str == null || str.length() == 0) {
            return "";
        }
        for (int i = 0; i < f554wr.length; i++) {
            String[][] strArr = f554wr;
            new StringBuffer("PaySMS.retrieveTermsAndConditions: profilesTexts[").append(i).append("][TEXT_PROFILE_ID] = '").append(f554wr[i][0]).append("'").toString();
            if (m794t(f554wr[i][0], str)) {
                return f554wr[i][1];
            }
        }
        return "";
    }

    private static boolean m729aj(String str) {
        return str.equals(f579xn) || str.equals(f580xo) || str.equals(f581xp);
    }

    private static String[] m730ak(String str) {
        if (str == null) {
            return null;
        }
        Vector vector = new Vector();
        int i = 0;
        while (i < str.length()) {
            int indexOf = str.indexOf(59, i);
            if (indexOf != -1) {
                vector.addElement(str.substring(i, indexOf));
                i = indexOf + 1;
            } else {
                i = str.length();
            }
        }
        String[] strArr = new String[vector.size()];
        vector.copyInto(strArr);
        return strArr;
    }

    private static String[] m731al(String str) {
        int i;
        int indexOf;
        int i2 = 0;
        "".getClass();
        InputStream resourceAsStream = C0355i.getResourceAsStream(str);
        String str2 = "";
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(2048);
            byte[] bArr = new byte[256];
            while (true) {
                int read = resourceAsStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            resourceAsStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            if (C0338r.f2511sa) {
                str2 = new String(byteArray, 0, byteArray.length, "UTF-8");
            } else {
                StringBuffer stringBuffer = new StringBuffer((byteArray.length / 2) + 2);
                int i3 = 0;
                while (i3 < byteArray.length + 0) {
                    if ((byteArray[i3] & 128) == 0) {
                        i = i3 + 1;
                        stringBuffer.append((char) (byteArray[i3] & 255));
                    } else if ((byteArray[i3] & 224) == 192) {
                        if (i3 + 1 >= byteArray.length + 0 || (byteArray[i3 + 1] & 192) != 128) {
                            throw new Exception();
                        }
                        int i4 = i3 + 1;
                        i = i4 + 1;
                        stringBuffer.append((char) (((byteArray[i3] & 31) << 6) | (byteArray[i4] & 63)));
                    } else {
                        if ((byteArray[i3] & 240) != 224) {
                            throw new Exception();
                        }
                        if (i3 + 2 >= byteArray.length + 0 || (byteArray[i3 + 1] & 192) != 128 || (byteArray[i3 + 2] & 192) != 128) {
                            throw new Exception();
                        }
                        int i5 = i3 + 1;
                        int i6 = i5 + 1;
                        int i7 = ((byteArray[i3] & 15) << 12) | ((byteArray[i5] & 63) << 6);
                        i = i6 + 1;
                        stringBuffer.append((char) (i7 | (byteArray[i6] & 63)));
                    }
                    int i8 = i;
                    str2 = stringBuffer.toString().toUpperCase();
                    i3 = i8;
                }
            }
            Vector vector = new Vector();
            do {
                indexOf = str2.indexOf(10, i2);
                if (indexOf != -1) {
                    vector.addElement(str2.substring(i2, indexOf));
                    i2 = indexOf + 1;
                }
            } while (indexOf != -1);
            String[] strArr = new String[vector.size()];
            vector.copyInto(strArr);
            return strArr;
        } catch (Exception e) {
            new StringBuffer("PaySMS.readFile: ").append(str).append(" Exception: ").append(e.toString()).toString();
            return null;
        }
    }

    private static String m732am(String str) {
        String str2;
        byte[] m234fq;
        try {
            C0100b m227g = C0100b.m227g(str, true);
            str2 = (m227g.m235uD() <= 0 || (m234fq = m227g.m234fq(1)) == null) ? null : new String(m234fq);
        } catch (Exception e) {
            new StringBuffer("PaySMS.rmsLoad: Exception: ").append(str).append(" ").append(e.toString()).toString();
            str2 = null;
        }
        try {
            C0100b.m229uC();
        } catch (Exception e2) {
            new StringBuffer("PaySMS.rmsLoad: Exception: ").append(str).append(" ").append(e2.toString()).toString();
        }
        return str2;
    }

    private static boolean m733an(String str) {
        return str == null || str.length() == 0 || str.equals("null");
    }

    private static long m734ao(String str) {
        String replace = str.replace(',', '.');
        int indexOf = replace.indexOf(f565xC);
        if (indexOf == -1) {
            return m735ap(replace) * 100000;
        }
        long m735ap = m735ap(replace.substring(0, indexOf)) * 100000;
        String substring = replace.substring(indexOf + 1);
        while (substring.length() < 5) {
            substring = new StringBuffer().append(substring).append("0").toString();
        }
        return m735ap(substring) + m735ap;
    }

    private static int m735ap(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            return -1;
        }
    }

    public static void m736aq(String str) {
    }

    public static void m739b(String str, long j, long j2) {
        f543wg = str;
        f544wh = j;
        f545wi = j2;
        f539wc = GLLib.f143iL;
        errorCode = 0;
        if (f560wx == null) {
            f560wx = new Vector();
        }
        if (f554wr == null) {
            f554wr = m778cw();
        }
        f514wB = m781cz();
        f534wV = m742cA();
        f536wX = m743cB();
        String m744cC = m744cC();
        f526wN = m744cC;
        if (m744cC.equals("")) {
            f526wN = m749cH();
            m792r(f531wS[1], f526wN);
        }
        f530wR = m745cD();
        f549wm = true;
        if (f546wj != null) {
            f546wj = new StringBuffer().append(f546wj).toString();
        }
        if (!m748cG() && m779cx() == 0 && f551wo && m772cq()) {
            m792r(f531wS[8], f514wB[f558wv][0]);
            m771cp();
        }
        m777cv();
    }

    private static String[] m741b(String[] strArr) {
        boolean z;
        Vector vector = new Vector();
        for (int i = 0; i < strArr.length; i++) {
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    z = false;
                    break;
                }
                if (strArr[i].equals(strArr[i2])) {
                    z = true;
                    break;
                }
                i2++;
            }
            if (!z) {
                vector.addElement(strArr[i]);
            }
        }
        String[] strArr2 = new String[vector.size()];
        vector.copyInto(strArr2);
        return strArr2;
    }

    private static boolean m742cA() {
        String m732am = m732am(f531wS[0]);
        return m732am != null && m732am.equals("1");
    }

    private static boolean m743cB() {
        String m732am = m732am(f531wS[4]);
        return m732am != null && m732am.equals("1");
    }

    private static String m744cC() {
        String m732am = m732am(f531wS[1]);
        return m732am != null ? m732am : "";
    }

    private static long m745cD() {
        try {
            String m732am = m732am(f531wS[11]);
            if (m732am != null) {
                return Long.parseLong(m732am);
            }
        } catch (Exception e) {
        }
        return 1L;
    }

    private static String m746cE() {
        String m732am = m732am(f531wS[5]);
        return m732am != null ? m732am : "";
    }

    public static long m747cF() {
        try {
            String m732am = m732am(f531wS[13]);
            if (m732am != null) {
                return Long.parseLong(m732am);
            }
        } catch (Exception e) {
        }
        return 0L;
    }

    private static boolean m748cG() {
        String m732am = m732am(f531wS[3]);
        if (m732am == null || m732am.length() == 0) {
            return false;
        }
        Vector vector = new Vector();
        int i = 0;
        int indexOf = m732am.indexOf(";");
        while (indexOf != -1) {
            vector.addElement(new Integer(Integer.parseInt(m732am.substring(i, indexOf))));
            i = indexOf + 1;
            indexOf = m732am.indexOf(";", i);
        }
        f560wx = vector;
        return true;
    }

    private static String m749cH() {
        int abs = Math.abs(new Random().nextInt() % 9999);
        while (abs < 1000) {
            if (abs < 1000) {
                abs += PlacePickerFragment.DEFAULT_RADIUS_IN_METERS;
            }
        }
        return String.valueOf(abs);
    }

    public static int m750cI() {
        int intValue;
        String str;
        String str2;
        if (f560wx == null || f560wx.size() <= 0 || f590xy) {
            return 0;
        }
        if (m779cx() != 0) {
            return 8;
        }
        try {
            intValue = ((Integer) f560wx.elementAt(0)).intValue();
            String str3 = f550wn[intValue][0];
            str = f550wn[intValue][1];
            new StringBuffer("profileID : ").append(str3).toString();
            str2 = f550wn[intValue][2];
        } catch (Exception e) {
            new StringBuffer("PaySMS. GetSpecialFlow,  Exception: ").append(e).toString();
        }
        if (str2 == null) {
            return 8;
        }
        String trim = str2.substring(str2.indexOf(40) + 1, str2.lastIndexOf(58)).trim();
        new StringBuffer("PaySMS. Country code ").append(trim).toString();
        if (str.indexOf("Open Market") != -1) {
            if (trim.equals("90:TR")) {
                return 3;
            }
            if (trim.equals("33:FR")) {
                return 6;
            }
        }
        if (trim.equals("62:ID") && str.indexOf("Indonesia Telkomsel") != -1) {
            return 11;
        }
        if (trim.equals("61:AU") && str.indexOf("Australia VODAFONE") != -1) {
            return 16;
        }
        if (f550wn[intValue][6].equals("SMS")) {
            if (trim.equals("49:DE")) {
                return 2;
            }
            if (trim.equals("45:DK")) {
                return 4;
            }
            if (trim.equals("43:AT")) {
                return 5;
            }
            if (trim.equals("91:IN")) {
                return 7;
            }
            if (trim.equals("34:ES")) {
                return 0;
            }
            if (trim.equals("44:GB") || trim.equals("353:IE")) {
                return 10;
            }
            if (trim.equals("58:VE")) {
                return 12;
            }
        }
        if (trim.equals("34:ES") && f550wn[intValue][6].equals("HTTP")) {
            return str.indexOf("Movistar SP") != -1 ? 13 : 9;
        }
        return 8;
    }

    public static String m751cJ() {
        if (!C0338r.f2488sD) {
            return GLLib.f143iL.m214di("URL-SUPPORT");
        }
        try {
            String m214di = GLLib.f143iL.m214di("URL-SUPPORT");
            if (m214di == null) {
                return null;
            }
            if (f590xy) {
                return m214di;
            }
            String m732am = m732am(f531wS[7]);
            if (m732am == null || m732am.equals("")) {
                return m214di;
            }
            String substring = m732am.substring(0, m732am.indexOf(95));
            return new StringBuffer().append(m214di).append("&extra_1=").append(GLLib.m373a(GLLib.m399a(substring.getBytes(), "a8bc1a23a89", true))).append("&extra_2=").append(m732am.substring(m732am.indexOf(95) + 1)).toString();
        } catch (Exception e) {
            return null;
        }
    }

    static long m759cR() {
        long j = f530wR;
        f530wR = 1 + j;
        return j;
    }

    private static boolean m763ch() {
        if (f547wk.isInProgress()) {
            return false;
        }
        if (f547wk.f2654dC) {
            return true;
        }
        if (f547wk.f2652dA != null && f547wk.f2652dA != "") {
            String m711a = m711a(f547wk.f2652dA, 0, '|');
            try {
                if (m711a.equals("FAILURE")) {
                    f548wl = Integer.parseInt(m711a(f547wk.f2652dA, 1, '|'));
                    return true;
                }
                if (m711a.equals("SUCCESS")) {
                    f526wN = m711a(f547wk.f2652dA, 2, '|');
                    f548wl = 0;
                    return true;
                }
            } catch (NumberFormatException e) {
                f548wl = 40;
                String m711a2 = m711a(f547wk.f2652dA, 1, '|');
                if (m711a2.indexOf("PB") != -1) {
                    try {
                        f548wl = Integer.parseInt(m711a2.substring(2, m711a2.length()));
                    } catch (NumberFormatException e2) {
                    }
                }
                return true;
            }
        }
        f548wl = 40;
        return true;
    }

    public static boolean m764ci() {
        boolean z;
        if (C0338r.f2521sk) {
            f564xB = C0338r.f2522sl;
        }
        f556wt = new String[17][];
        f555ws = new int[f564xB + 1];
        if (C0338r.f2524sn) {
            String m732am = m732am(f531wS[6]);
            if ((m732am == null || m732am.equals("1") || !m732am.equals("0")) ? false : true) {
                errorCode = -10;
                return false;
            }
        }
        if (!C0338r.f2514sd) {
            return true;
        }
        f539wc = GLLib.f143iL;
        String property = getProperty("IAP-OverrideFromJad");
        f538wZ = property;
        if (property.equals("1")) {
            String upperCase = getProperty("IAP-BillingType").toUpperCase();
            f571xf = upperCase;
            if (upperCase.equals("HTTP")) {
                String property2 = getProperty("IAP-BillingURL");
                f570xe = property2;
                if (property2.equals("")) {
                    f538wZ = "0";
                }
            } else if (!f571xf.equals("SMS")) {
                f538wZ = "0";
            }
        }
        if (!f546wj.substring(f546wj.lastIndexOf(58) + 1).equals(getProperty("IAP-Version"))) {
        }
        String property3 = getProperty("IAP-GameCodeIGP");
        f522wJ = property3;
        if (property3.length() == 0) {
            z = false;
        } else {
            String property4 = getProperty("IAP-PhoneModel");
            f523wK = property4;
            if (property4.length() == 0) {
                f523wK = "5477";
            }
            String property5 = getProperty("IAP-Test");
            f582xq = property5;
            if (property5.length() == 0) {
                f582xq = "0";
            }
            if (m779cx() != 0) {
                if (m779cx() == 1) {
                    f583xr = f579xn;
                } else if (m779cx() == 2) {
                    f583xr = f580xo;
                } else {
                    f582xq = "0";
                    f583xr = "";
                }
            }
            new StringBuffer("PaySMS.parseJadFields:iapTestField: ").append(f582xq).append(" useTestProfile: ").append(f583xr).toString();
            f516wD = getProperty("IAP-DebugNumber");
            String m720aW = m720aW(1);
            if (m733an(m720aW)) {
                String m720aW2 = m720aW(2);
                if (!m733an(m720aW2)) {
                    m720aW = m720aW2.substring(3, 5);
                }
            }
            if (!m733an(m720aW) && m720aW.length() == 1) {
                m720aW = new StringBuffer("0").append(m720aW).toString();
            }
            f520wH = m720aW;
            String property6 = System.getProperty("wireless.messaging.sms.smsc");
            if (property6 != null && property6.length() > 0) {
                f519wG = property6;
            }
            String property7 = getProperty("IAP-DebugSMSCenter");
            f517wE = getProperty("IAP-DebugMNC");
            if (!property7.equals("")) {
                f519wG = property7;
            }
            if (!f517wE.equals("")) {
                f520wH = f517wE;
            }
            f524wL = getProperty("Download-Code");
            if (getProperty("IAP-EnableCreditCard").equals("1")) {
                f589xx = true;
            }
            f585xt = new Vector();
            f586xu = new Vector();
            f587xv = new Vector();
            for (int i = 0; i < f584xs.length; i++) {
                for (int i2 = 1; i2 <= f564xB; i2++) {
                    String property8 = getProperty(new StringBuffer("IAP-ContentID-").append(f584xs[i]).append("-").append(i2).toString());
                    if (property8 != null && !property8.equals("")) {
                        f585xt.addElement(property8);
                    }
                }
            }
            new StringBuffer("PaySMS.parseJadFields: ValidContentIDs: ").append(f585xt).toString();
            int i3 = 0;
            while (i3 < f585xt.size()) {
                String str = (String) f585xt.elementAt(i3);
                int i4 = i3 + 1;
                boolean z2 = false;
                while (i4 < f585xt.size()) {
                    if (f585xt.elementAt(i4).equals(str)) {
                        f585xt.removeElementAt(i4);
                        i4--;
                        z2 = true;
                    }
                    i4++;
                }
                if (z2) {
                    f585xt.removeElementAt(i3);
                    i3--;
                }
                i3++;
            }
            if (f585xt.size() == 0) {
                z = false;
            } else {
                new StringBuffer("PaySMS.parseJadFields: ValidContentIDs: ").append(f585xt).toString();
                String property9 = getProperty("IAP-Profiles");
                if (property9.equals("")) {
                    z = false;
                } else {
                    if (property9.length() > 0 && property9.charAt(property9.length() - 1) != ';') {
                        property9 = new StringBuffer().append(property9).append(";").toString();
                    }
                    String[] m730ak = m730ak(property9);
                    if (m730ak == null) {
                        z = false;
                    } else if (m716a((String[]) null, m730ak, m731al(f572xg))) {
                        f551wo = true;
                        z = true;
                    } else {
                        z = f589xx;
                    }
                }
            }
        }
        new StringBuffer("PaySMS.checkAvailable:parseJadFields: ").append(z ? "true" : "false").toString();
        if (!z) {
            return false;
        }
        new StringBuffer("PaySMS.checkAvailable:validProfiles: ").append("true").toString();
        return true;
    }

    public static boolean m765cj() {
        f534wV = m742cA();
        f536wX = m743cB();
        return f534wV || f536wX;
    }

    public static void m766ck() {
        f536wX = true;
        m792r(f531wS[4], "1");
        int m769cn = m769cn();
        String m746cE = m746cE();
        if (C0338r.f2521sk) {
            m769cn = m786k(m769cn, m746cE);
        }
        m714a(m769cn, m746cE, 0L);
    }

    public static int m767cl() {
        if (C0338r.f2489sE) {
            f534wV = m742cA();
            f536wX = m743cB();
        }
        if (f537wY) {
            f537wY = false;
            return 7;
        }
        if (!f549wm) {
            return 0;
        }
        if (f534wV) {
            return 2;
        }
        if (f535wW) {
            return 1;
        }
        if (f532wT || f536wX) {
            if (!f536wX) {
                m770co();
                return 3;
            }
            f532wT = false;
            f534wV = true;
            m792r(f531wS[0], "1");
            return 8;
        }
        if (f578xm != 1) {
            if (!f538wZ.equals("1") && m779cx() == 0) {
                if (errorCode != 0) {
                    return 3;
                }
                if ((f560wx == null || f560wx.size() <= 0) && ((!f589xx || f551wo) && !f590xy)) {
                    if (f513wA < 0) {
                        return 4;
                    }
                    if (f560wx.size() <= 0) {
                        return 5;
                    }
                }
            }
            return 6;
        }
        if (!m763ch()) {
            return 1;
        }
        f578xm = 0;
        int i = f547wk.isInProgress() ? -1 : f547wk.f2654dC ? -2 : f548wl;
        if (i == 0) {
            if (m717aT(Integer.parseInt(f526wN))) {
                errorCode = 0;
                m770co();
                return 7;
            }
            errorCode = 1;
            m770co();
            return 3;
        }
        if (i == -2) {
            errorCode = -1;
            m770co();
            return 3;
        }
        errorCode = i;
        m770co();
        return 3;
    }

    public static int m768cm() {
        return errorCode;
    }

    private static int m769cn() {
        String m732am = m732am(f531wS[2]);
        if (m732am == null || m732am.length() == 0) {
            return -1;
        }
        try {
            return Integer.parseInt(m732am);
        } catch (Exception e) {
            return -1;
        }
    }

    private static void m770co() {
        f535wW = false;
        f532wT = false;
        f549wm = false;
        m792r(f531wS[1], "");
        f534wV = false;
        m792r(f531wS[0], "0");
        f536wX = false;
        m792r(f531wS[4], "0");
        f590xy = false;
    }

    private static boolean m771cp() {
        boolean z;
        boolean z2;
        String m732am = m732am(f531wS[9]);
        new StringBuffer("PaySMS.detectCarrier: getCarrierStored == ").append(m732am).toString();
        if (m732am != null && !m732am.equals("") && m724ae(m732am)) {
            return true;
        }
        if (f560wx == null) {
            f560wx = new Vector();
        }
        if (f560wx.size() == 1) {
            f527wO = ((Integer) f560wx.elementAt(0)).intValue();
            new StringBuffer("PaySMS.detectCarrier: Carrier selection skipped, detected profile: ").append(f527wO).toString();
            return true;
        }
        f561wy = -1;
        f527wO = -1;
        f560wx.removeAllElements();
        String[][] m726ag = m726ag(f514wB[f513wA][0]);
        f562wz = new String[m726ag.length];
        String[] strArr = new String[m726ag.length];
        for (int i = 0; i < m726ag.length; i++) {
            f562wz[i] = m726ag[i][0];
            strArr[i] = m726ag[i][1];
        }
        f562wz = m741b(f562wz);
        String[] m741b = m741b(strArr);
        new StringBuffer("PaySMS.detectCarrier: currentIDS ").append(m741b.length).append(", currentCarriers = ").append(f562wz.length).toString();
        if (m741b.length == 1) {
            f561wy = 0;
            int i2 = 0;
            while (i2 < f550wn.length && !f550wn[i2][0].equals(m741b[0])) {
                i2++;
            }
            if (f550wn[i2][1].toLowerCase().indexOf("open market") != -1) {
                z2 = !f533wU;
                new StringBuffer("PaySMS.detectCarrier:currentIDS.length == 1 isOpenMarket").append(z2).toString();
            } else {
                z2 = false;
            }
            if (f589xx && f520wH == null && !z2) {
                return true;
            }
            if (f550wn[i2][0].equals(m741b[0])) {
                f560wx.addElement(new Integer(i2));
            }
            new StringBuffer("PaySMS.detectCarrier: Carrier selection skipped, only one profile. currentValidProfiles.size() ").append(f560wx.size()).toString();
            return true;
        }
        if (f562wz.length == 1) {
            f561wy = 0;
            new StringBuffer("PaySMS.detectCarrier: Carrier selection skipped, only one carrier: ").append(f562wz[f561wy]).toString();
            if (f589xx && f520wH == null) {
                return true;
            }
            for (int i3 = 0; i3 < f550wn.length; i3++) {
                if (f550wn[i3][2].indexOf(f514wB[f513wA][0]) != -1) {
                    for (int i4 = 0; i4 < f552wp[i3].size(); i4++) {
                        if (((String) f552wp[i3].elementAt(i4)).indexOf(f562wz[f561wy]) != -1) {
                            f560wx.addElement(new Integer(i3));
                        }
                    }
                }
            }
            new StringBuffer("PaySMS.detectCarrier: currentValidProfiles.size =  ").append(f560wx.size()).toString();
            return true;
        }
        if (f562wz.length > 0) {
            String[][] strArr2 = (String[][]) Array.newInstance((Class<?>) String.class, m741b.length, 2);
            boolean z3 = true;
            boolean z4 = true;
            for (int i5 = 0; i5 < m741b.length; i5++) {
                new StringBuffer("PaySMS.detectCarrier: currentIDS[").append(i5).append("]= ").append(m741b[i5]).toString();
                int i6 = 0;
                while (true) {
                    if (i6 >= f550wn.length) {
                        break;
                    }
                    if (f550wn[i6][0].equals(m741b[i5])) {
                        strArr2[i5][0] = f550wn[i6][3];
                        strArr2[i5][1] = new StringBuffer().append(i6).toString();
                        new StringBuffer("PaySMS.detectCarrier: is Openmarket???? ").append(f550wn[i6][1]).toString();
                        if (f550wn[i6][1].toUpperCase().indexOf("OPEN MARKET") == -1) {
                            z4 = false;
                        }
                        if (f550wn[i6][1].toUpperCase().indexOf("OTHER CARRIERS") == -1) {
                            z3 = false;
                        }
                    } else {
                        i6++;
                    }
                }
            }
            if (z4 || z3) {
                z = true;
            } else {
                z = true;
                for (int i7 = 1; i7 < strArr2.length; i7++) {
                    if (!strArr2[i7][0].equals(strArr2[i7 - 1][0])) {
                        new StringBuffer("PaySMS.detectCarrier: multiCarrierProfiles[i] ").append(strArr2[i7][0]).toString();
                        new StringBuffer("PaySMS.detectCarrier: multiCarrierProfiles[i-1] ").append(strArr2[i7 - 1][0]).toString();
                        z = false;
                    }
                }
            }
            if (f533wU) {
                z4 = false;
            }
            if (!z4) {
                z = false;
            }
            new StringBuffer("PaySMS.detectCarrier: multiCarrierProfiles: ").append(z).append(", isOpenMarket: ").append(z4).toString();
            if (z) {
                if (!f589xx || f520wH != null || z4) {
                    for (String str : m741b) {
                        int i8 = 0;
                        while (true) {
                            if (i8 >= f550wn.length) {
                                break;
                            }
                            if (f550wn[i8][0].equals(str)) {
                                f560wx.addElement(new Integer(i8));
                                break;
                            }
                            i8++;
                        }
                    }
                    new StringBuffer("PaySMS.detectCarrier: Dont auto skip carrier selection(except OpenMarket). currentValidProfiles.size() ").append(f560wx.size()).toString();
                }
                new StringBuffer("PaySMS.detectCarrier: More than one carrier, but multicarrier profiles: ").append(strArr2[0][0]).toString();
                return true;
            }
            int length = f562wz.length;
            for (int i9 = 0; i9 < length; i9++) {
                f562wz[i9] = f562wz[i9].trim();
            }
            int[] iArr = new int[length];
            for (int i10 = 0; i10 < length; i10++) {
                iArr[i10] = i10;
                new StringBuffer("PaySMS.detectCarrier: carrierNames[").append(i10).append("]: ").append(f562wz[i10]).toString();
            }
        }
        return false;
    }

    private static boolean m772cq() {
        new StringBuffer("PaySMS.detectRegion getRegionStored ").append(m774cs()).toString();
        String m774cs = m774cs();
        if (m774cs != null && !m774cs.equals("") && m723ad(m774cs)) {
            return true;
        }
        if (f558wv != -1) {
            f513wA = f558wv;
            return true;
        }
        f513wA = -1;
        f527wO = -1;
        f560wx = null;
        f515wC = new String[f514wB.length];
        for (int i = 0; i < f515wC.length; i++) {
            f515wC[i] = f514wB[i][0];
        }
        if (f515wC.length == 1 && (f519wG == null || f558wv == -1)) {
            f513wA = 0;
            f558wv = 0;
            new StringBuffer("PaySMS.detectRegion: Region selection skipped, only one region: ").append(f515wC[f513wA]).toString();
            return true;
        }
        if (f519wG != null && f558wv != -1) {
            f513wA = f558wv;
            new StringBuffer("PaySMS.detectRegion: Region selection skipped, region auto-detected: ").append(f558wv).toString();
            return true;
        }
        int length = f515wC.length;
        for (int i2 = 0; i2 < length - 1; i2++) {
            for (int i3 = i2 + 1; i3 < length; i3++) {
                if (f515wC[i2].compareTo(f515wC[i3]) > 0) {
                    String str = f515wC[i2];
                    f515wC[i2] = f515wC[i3];
                    f515wC[i3] = str;
                }
            }
        }
        return false;
    }

    public static String[] m773cr() {
        if (f515wC != null) {
            return f515wC;
        }
        return null;
    }

    private static String m774cs() {
        return m732am(f531wS[8]);
    }

    public static String[] m775ct() {
        if (f550wn == null || f514wB == null || f558wv == -1) {
            return null;
        }
        Vector vector = new Vector();
        for (int i = 0; i < f550wn.length; i++) {
            if (f550wn[i][2].indexOf(f514wB[f558wv][0]) != -1) {
                for (int i2 = 0; i2 < f552wp[i].size(); i2++) {
                    String str = (String) f552wp[i].elementAt(i2);
                    int indexOf = str.indexOf(40);
                    if (indexOf == -1) {
                        indexOf = str.length();
                    }
                    if (!vector.contains(str.substring(0, indexOf))) {
                        vector.addElement(str.substring(0, indexOf));
                    }
                }
            }
        }
        if (f588xw != null && f589xx) {
            vector.size();
            vector.addElement("Other");
        }
        String[] strArr = new String[vector.size()];
        vector.copyInto(strArr);
        return strArr;
    }

    public static String m776cu() {
        String str;
        String str2;
        String str3 = null;
        new StringBuffer("PaySMS.GetTermsAndConditions: currentValidProfiles: ").append(f560wx == null ? "NULL" : new StringBuffer("Size: ").append(f560wx.size()).toString()).toString();
        if (f590xy || f560wx == null) {
            return null;
        }
        if (m779cx() == 0) {
            if (f560wx.size() > 0) {
                int intValue = ((Integer) f560wx.elementAt(0)).intValue();
                try {
                    String str4 = f550wn[intValue][13];
                    try {
                        str = f550wn[intValue][15];
                        str3 = str4;
                    } catch (Exception e) {
                        str2 = str4;
                        str3 = str2;
                        str = null;
                        new StringBuffer("PaySMS.GetTermsAndConditions: tncID = '").append(str3).append("'").toString();
                        String m728ai = m728ai(str3);
                        new StringBuffer("PaySMS.GetTermsAndConditions: tnc = '").append(m728ai).append("'").toString();
                        new StringBuffer("PaySMS.GetTermsAndConditions: supportNumber = '").append(str).append("'").toString();
                        String m791q = m791q(m728ai, str);
                        new StringBuffer("PaySMS.GetTermsAndConditions: tnc without phone number = '").append(m791q).append("'").toString();
                        return m791q;
                    }
                } catch (Exception e2) {
                    str2 = null;
                }
            }
            str = null;
        } else {
            if (f553wq.length > 0) {
                for (int i = 0; i < f553wq.length; i++) {
                    if (f553wq[i][0].equals(f583xr)) {
                        str3 = f553wq[i][13];
                        str = null;
                        break;
                    }
                }
            }
            str = null;
        }
        new StringBuffer("PaySMS.GetTermsAndConditions: tncID = '").append(str3).append("'").toString();
        String m728ai2 = m728ai(str3);
        new StringBuffer("PaySMS.GetTermsAndConditions: tnc = '").append(m728ai2).append("'").toString();
        new StringBuffer("PaySMS.GetTermsAndConditions: supportNumber = '").append(str).append("'").toString();
        String m791q2 = m791q(m728ai2, str);
        new StringBuffer("PaySMS.GetTermsAndConditions: tnc without phone number = '").append(m791q2).append("'").toString();
        return m791q2;
    }

    private static void m777cv() {
        f586xu.removeAllElements();
        f587xv.removeAllElements();
        if (m779cx() == 0 && f560wx != null && f560wx.size() > 0) {
            new StringBuffer("PaySMS.parseValidItems: IAP_TEST_FIELD_NONE ").append(f560wx.size()).toString();
            for (int i = 0; i < f560wx.size(); i++) {
                int parseInt = Integer.parseInt(f550wn[((Integer) f560wx.elementAt(i)).intValue()][14]);
                if (m788m(parseInt, "Cash")) {
                    f586xu.addElement(new Integer(parseInt));
                }
                if (m788m(parseInt, "Coin")) {
                    f587xv.addElement(new Integer(parseInt));
                }
            }
        } else if (f589xx || m779cx() != 0) {
            new StringBuffer("PaySMS.parseValidItems: IAP_TEST_FIELD or CC. creditCardEnabled = ").append(f589xx).toString();
            for (int i2 = 1; i2 <= f564xB; i2++) {
                if (m788m(i2, "Cash")) {
                    f586xu.addElement(new Integer(i2));
                }
                if (m788m(i2, "Coin")) {
                    f587xv.addElement(new Integer(i2));
                }
            }
        }
        for (int i3 = 0; i3 < f586xu.size() - 1; i3++) {
            int i4 = i3 + 1;
            while (true) {
                int i5 = i4;
                if (i5 < f586xu.size()) {
                    int intValue = ((Integer) f586xu.elementAt(i3)).intValue();
                    int intValue2 = ((Integer) f586xu.elementAt(i5)).intValue();
                    if (intValue > intValue2) {
                        f586xu.setElementAt(new Integer(intValue2), i3);
                        f586xu.setElementAt(new Integer(intValue), i5);
                    }
                    i4 = i5 + 1;
                }
            }
        }
        for (int i6 = 0; i6 < f587xv.size() - 1; i6++) {
            int i7 = i6 + 1;
            while (true) {
                int i8 = i7;
                if (i8 < f587xv.size()) {
                    int intValue3 = ((Integer) f587xv.elementAt(i6)).intValue();
                    int intValue4 = ((Integer) f587xv.elementAt(i8)).intValue();
                    if (intValue3 > intValue4) {
                        f587xv.setElementAt(new Integer(intValue4), i6);
                        f587xv.setElementAt(new Integer(intValue3), i8);
                    }
                    i7 = i8 + 1;
                }
            }
        }
        new StringBuffer("PaySMS.parseValidItems: number of cash: ").append(f586xu.size()).toString();
        new StringBuffer("PaySMS.parseValidItems: number of coin: ").append(f587xv.size()).toString();
    }

    private static String[][] m778cw() {
        String[] m731al = m731al(f573xh);
        if (m731al == null) {
            return null;
        }
        String[][] strArr = (String[][]) Array.newInstance((Class<?>) String.class, m731al.length, 2);
        for (int i = 0; i < m731al.length; i++) {
            int indexOf = m731al[i].indexOf(59);
            if (indexOf != -1) {
                strArr[i][0] = m731al[i].substring(0, indexOf);
                strArr[i][1] = m731al[i].substring(indexOf + 1, m731al[i].length());
            }
        }
        for (int i2 = 0; i2 < strArr.length; i2++) {
            new StringBuffer("PaySMS.loadSpecificTextsFile: ID: ").append(strArr[i2][0]).append(" TEXT: ").append(strArr[i2][1]).toString();
        }
        return strArr;
    }

    private static int m779cx() {
        if (f582xq.equals("0")) {
            return 0;
        }
        if (f582xq.equals("1")) {
            return 1;
        }
        return f582xq.equals("2") ? 2 : 0;
    }

    private static void m780cy() {
        int i = 0;
        int length = f550wn.length;
        if (f588xw != null) {
            length++;
        }
        f552wp = new Vector[length];
        for (int i2 = 0; i2 < f550wn.length; i2++) {
            f552wp[i2] = new Vector();
            String str = f550wn[i2][3];
            new StringBuffer("PaySMS.parseMultipleCarriers: Carriers - Profile: ").append(f550wn[i2][0]).toString();
            int indexOf = str.indexOf("¬", 0);
            if (indexOf == -1) {
                f552wp[i2].addElement(str);
                new StringBuffer("PaySMS.parseMultipleCarriers: \t\t").append(str).toString();
            } else {
                int i3 = 0;
                while (indexOf != -1) {
                    f552wp[i2].addElement(str.substring(i3, indexOf));
                    new StringBuffer("PaySMS.parseMultipleCarriers: \t\t").append(str.substring(i3, indexOf)).toString();
                    i3 = indexOf + 1;
                    indexOf = str.indexOf("¬", i3);
                }
                f552wp[i2].addElement(str.substring(i3, str.length()));
                new StringBuffer("PaySMS.parseMultipleCarriers: \t\t").append(str.substring(i3, str.length())).toString();
            }
            new StringBuffer("\tSize: ").append(f552wp[i2].size()).toString();
        }
        if (f588xw != null) {
            f552wp[f550wn.length] = new Vector();
            String str2 = f588xw[3];
            new StringBuffer("PaySMS.parseMultipleCarriers: Carriers - Profile: ").append(f588xw[0]).toString();
            int indexOf2 = str2.indexOf("¬", 0);
            if (indexOf2 == -1) {
                f552wp[f550wn.length].addElement(str2);
                new StringBuffer("PaySMS.parseMultipleCarriers: \t\t").append(str2).toString();
            } else {
                while (indexOf2 != -1) {
                    f552wp[f550wn.length].addElement(str2.substring(i, indexOf2));
                    new StringBuffer("PaySMS.parseMultipleCarriers: \t\t").append(str2.substring(i, indexOf2)).toString();
                    i = indexOf2 + 1;
                    indexOf2 = str2.indexOf("¬", i);
                }
                f552wp[f550wn.length].addElement(str2.substring(i, str2.length()));
                new StringBuffer("PaySMS.parseMultipleCarriers: \t\t").append(str2.substring(i, str2.length())).toString();
            }
            new StringBuffer("\tSize: ").append(f552wp[f550wn.length].size()).toString();
        }
    }

    private static String[][] m781cz() {
        if (!f551wo || m779cx() != 0) {
            return null;
        }
        Vector vector = new Vector();
        for (int i = 0; i < f550wn.length; i++) {
            String str = f550wn[i][2];
            int i2 = 0;
            boolean z = false;
            while (!z && i2 < vector.size()) {
                boolean z2 = m794t(str, (String) vector.elementAt(i2)) ? true : z;
                i2++;
                z = z2;
            }
            if (!z) {
                vector.addElement(f550wn[i][2]);
            }
        }
        if (f588xw != null && f589xx && vector.size() > 1) {
            vector.addElement("Other");
        }
        String[] strArr = new String[vector.size()];
        vector.copyInto(strArr);
        vector.removeAllElements();
        Vector vector2 = new Vector();
        String[][] strArr2 = (String[][]) Array.newInstance((Class<?>) String.class, strArr.length, 2);
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < strArr.length; i5++) {
            String str2 = strArr[i5];
            int indexOf = str2.indexOf(40);
            if (indexOf != -1) {
                strArr2[i5][0] = str2.substring(0, indexOf);
                int i6 = indexOf + 1;
                int indexOf2 = str2.indexOf(58, i6);
                str2.lastIndexOf(58);
                m732am(f531wS[8]);
                if (indexOf2 != -1) {
                    strArr2[i5][1] = str2.substring(i6, indexOf2);
                    if (f519wG != null && f519wG.startsWith(strArr2[i5][1], 1) && i4 <= indexOf2 - i6) {
                        i4 = indexOf2 - i6;
                        f558wv = i5;
                        new StringBuffer("currentAutoDetectedRegion ").append(f558wv).toString();
                        vector2.addElement(new String[]{strArr2[i5][0], strArr2[i5][1]});
                        i3++;
                    }
                }
            } else {
                strArr2[i5][0] = str2;
                strArr2[i5][1] = "";
            }
            new StringBuffer("PaySMS.getProfilesRegions:          regionsConfig[").append(i5).append("][REGION_NAME]: ").append(strArr2[i5][0]).toString();
            new StringBuffer("PaySMS.getProfilesRegions:          regionsConfig[").append(i5).append("][REGION_CODE]: ").append(strArr2[i5][1]).toString();
        }
        if (i3 > 1) {
            f558wv = -1;
            strArr2 = (String[][]) Array.newInstance((Class<?>) String.class, vector2.size(), 2);
            vector2.copyInto(strArr2);
        }
        new StringBuffer("PaySMS.getProfilesRegions: Auto-detected: ").append(f558wv == -1 ? "NONE" : strArr2[f558wv][0]).toString();
        return strArr2;
    }

    private static void m782g(int i, String str) {
        new StringBuffer("PaySMS.sendRequest CREDIT CARD: Pricepoint:").append(i).append(" Type:").append(str).toString();
        String str2 = f588xw[11];
        String property = getProperty(new StringBuffer("IAP-ContentID-").append(str).append("-").append(i).toString());
        if (property.equals("")) {
            new StringBuffer("PaySMS.sendCCARD: Wrong Item. IAP-ContentID-").append(str).append("-").append(i).append(" missing in JAD").toString();
            errorCode = -2;
            return;
        }
        new StringBuffer("PaySMS.sendCCARD, unlockCode: ").append(f526wN).toString();
        String stringBuffer = new StringBuffer().append(str2).append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("").append("?igpcode=").append(f522wJ).toString()).append("&content_id=").append(property).toString()).append("&tier=").append(i).toString()).append("&stamp=").append(C0335o.m2069z(GLLib.m434b(GLLib.m399a(f526wN.getBytes(), new StringBuffer().append(property).append("gameloft|0Ft$23#?a").append(i).toString(), true)))).toString()).append("&d=").append(f524wL).toString()).toString();
        new StringBuffer("PaySMS.sendRequest CREDIT CARD: ").append(stringBuffer).toString();
        m792r(f531wS[12], "cc_2d");
        if (stringBuffer != null) {
            GLLib.m341B(stringBuffer);
        }
        m792r(f531wS[0], "1");
        m792r(f531wS[1], f526wN);
        m792r(f531wS[2], String.valueOf(f540wd));
        m792r(f531wS[5], f541we);
        m792r(f531wS[13], new StringBuffer().append(f529wQ).toString());
    }

    public static String getProperty(String str) {
        String m214di = f539wc.m214di(str);
        return m214di == null ? "" : m214di;
    }

    public static String m783h(int i, String str) {
        if (C0338r.f2521sk || m788m(i, str)) {
            return m718aU(i);
        }
        new StringBuffer("PaySMS.getPrice: IAP-ContentID-").append(str).append("-").append(i).append(" missing in JAD").toString();
        return null;
    }

    public static long m784i(int i, String str) {
        long j;
        new StringBuffer("PaySMS.getVirtualCurrency: begin pricepoint: ").append(i).append(", itemType: ").append(str).toString();
        long j2 = str.equals("Cash") ? f544wh : str.equals("Coin") ? f545wi : 0L;
        if (m779cx() == 0 && f560wx != null && f560wx.size() > 0) {
            j = 0;
            int i2 = 0;
            while (true) {
                if (i2 >= f560wx.size()) {
                    break;
                }
                int intValue = ((Integer) f560wx.elementAt(i2)).intValue();
                if (Integer.parseInt(f550wn[intValue][14]) == i) {
                    j = (Long.parseLong(f550wn[intValue][16]) * j2) / 10000000;
                    j += ((Long.parseLong(f550wn[intValue][16]) * j2) % 10000000) / 5000000;
                    break;
                }
                continue;
                i2++;
            }
        } else {
            j = (((f563xA[i - 1] * j2) * f591xz[i - 1]) / (f563xA[2] * 100)) + ((((j2 * f563xA[i - 1]) * f591xz[i - 1]) % (f563xA[2] * 100)) / ((f563xA[2] * 100) >> 1));
        }
        int length = new StringBuffer().append(j).toString().length();
        int i3 = 1;
        if (length == 2) {
            i3 = 2;
        } else if (length > 2) {
            i3 = 5;
            for (int i4 = 0; i4 < length - 3; i4++) {
                i3 *= 10;
            }
        }
        new StringBuffer("currency:\t").append(j).append("\tRound Up:\t").append(i3).toString();
        if (j % i3 != 0) {
            j = ((j / i3) + 1) * i3;
        }
        new StringBuffer("Rounded currency:\t").append(j).toString();
        return j;
    }

    public static String m785j(int i, String str) {
        if (C0338r.f2521sk || m788m(i, str)) {
            return m719aV(i);
        }
        new StringBuffer("PaySMS.GetBillingType: IAP-ContentID-").append(str).append("-").append(i).append(" missing in JAD").toString();
        return "";
    }

    public static int m786k(int i, String str) {
        new StringBuffer("PaySMS.getPricePoint: itemIndex").append(i).append(", itemType ").append(str).toString();
        if (str.equals("Cash") && i <= f586xu.size()) {
            return ((Integer) f586xu.elementAt(i)).intValue();
        }
        if (!str.equals("Coin") || i > f587xv.size()) {
            return -1;
        }
        return ((Integer) f587xv.elementAt(i)).intValue();
    }

    private static int m787l(int i, String str) {
        int i2 = 0;
        if (!str.equals("Cash")) {
            if (str.equals("Coin")) {
                while (true) {
                    int i3 = i2;
                    if (i3 >= f587xv.size()) {
                        break;
                    }
                    if (((Integer) f587xv.elementAt(i3)).intValue() == i) {
                        return i3;
                    }
                    i2 = i3 + 1;
                }
            }
            return -1;
        }
        while (true) {
            int i4 = i2;
            if (i4 >= f586xu.size()) {
                return -1;
            }
            if (((Integer) f586xu.elementAt(i4)).intValue() == i) {
                return i4;
            }
            i2 = i4 + 1;
        }
    }

    private static boolean m788m(int i, String str) {
        String property = getProperty(new StringBuffer("IAP-ContentID-").append(str).append("-").append(i).toString());
        boolean z = f585xt.contains(property);
        new StringBuffer("PaySMS.isValidContentID: IAP-ContentID-").append(str).append("-").append(i).append(": ").append(property).append(z ? " - Valid" : " - Invalid").toString();
        return z;
    }

    static boolean m790o(boolean z) {
        f535wW = false;
        return false;
    }

    private static String m791q(String str, String str2) {
        String stringBuffer;
        if (str == null || str.equals("")) {
            return null;
        }
        try {
            int indexOf = str.indexOf("<phone>");
            int indexOf2 = str.indexOf("</phone>", indexOf + 7);
            String substring = str.substring(0, indexOf);
            String substring2 = str.substring(indexOf + 7, indexOf2);
            String substring3 = str.substring(indexOf2 + 8, str.length());
            if (str2 == null || str2.equals("")) {
                stringBuffer = new StringBuffer().append(substring).append(substring3).toString();
            } else {
                int indexOf3 = substring2.indexOf("<support_number>");
                stringBuffer = new StringBuffer().append(substring).append(new StringBuffer().append(substring2.substring(0, indexOf3)).append(str2).append(substring2.substring(indexOf3 + 16, substring2.length())).toString()).append(substring3).toString();
            }
            return stringBuffer;
        } catch (Exception e) {
            return str;
        }
    }

    public static void m792r(String str, String str2) {
        C0100b c0100b = null;
        try {
            c0100b = C0100b.m227g(str, true);
            byte[] bytes = str2.getBytes();
            if (c0100b.m235uD() > 0) {
                c0100b.m231b(1, bytes, 0, bytes.length);
            } else {
                c0100b.m232e(bytes, 0, bytes.length);
            }
        } catch (Exception e) {
            new StringBuffer("PaySMS.rmsSave: Exception: ").append(e.toString()).toString();
        }
        if (c0100b != null) {
            try {
                C0100b.m229uC();
            } catch (Exception e2) {
                new StringBuffer("PaySMS.rmsSave: Exception: ").append(e2.toString()).toString();
            }
        }
    }

    public static void reset() {
        f533wU = true;
        f558wv = -1;
        f513wA = -1;
        f560wx = null;
        f537wY = false;
        m792r(f531wS[2], "");
        m792r(f531wS[5], "");
        m792r(f531wS[13], "");
        m792r(f531wS[3], "");
        m792r(f531wS[8], "");
        m792r(f531wS[9], "");
        f520wH = null;
        f521wI = null;
        m770co();
    }

    private static boolean m793s(String str, String str2) {
        if (m733an(str) || m733an(str2)) {
            return false;
        }
        int length = str2.length();
        for (int i = 0; i <= str.length() - length; i++) {
            if (m794t(str.substring(i, i + length), str2)) {
                return true;
            }
        }
        return false;
    }

    private static boolean m794t(String str, String str2) {
        if (str != null && str2 != null) {
            return str.toUpperCase().equals(str2.toUpperCase());
        }
        new StringBuffer("PaySMS.equalsIgnoreCase: s1 = '").append(str).append("', s2 = '").append(str2).append("'").toString();
        return false;
    }

    public static void warning(String str) {
    }
}
