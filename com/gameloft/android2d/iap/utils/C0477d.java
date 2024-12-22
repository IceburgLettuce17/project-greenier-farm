package com.gameloft.android2d.iap.utils;

import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.telephony.TelephonyManager;
import android.webkit.WebView;
import com.gameloft.android2d.iap.C0463b;
import java.io.File;
import java.util.Locale;
import p001a.p004b.p005a.p006a.C0012k;

public final class C0477d {
    private static boolean adM;
    private static C0474a adN;

    private static WifiManager f2866ep;

    private static String[][] f2856ee = {new String[]{"eng", "en"}, new String[]{"fra", "fr"}, new String[]{"deu", "de"}, new String[]{"esl", "es"}, new String[]{"spa", "es"}, new String[]{"ita", "it"}, new String[]{"jpn", "jp"}, new String[]{"por", "br"}, new String[]{"por", "pt"}};

    private static String f2855Yh = null;

    private static String f2857ef = null;
    private static String userAgent = null;

    private static String f2858eg = null;

    private static String f2859eh = null;

    private static String f2860ei = null;

    private static String f2861ej = null;

    private static String f2862ek = null;

    private static String f2863el = null;

    private static String f2864em = null;

    private static WebView f2865eo = null;

    private static ConnectivityManager f2867er = null;

    public C0477d() {
        m2599sH();
    }

    public C0477d(String str, String str2) {
        m2599sH();
        if (str == null || str.equals("") || str2 == null || str2.equals("")) {
            return;
        }
        adN.f2851dJ = true;
        adN.f2852dK = str;
        adN.f2853dL = Integer.parseInt(str2);
    }

    public static boolean m2587at() {
        WifiManager wifiManager = (WifiManager) C0488o.getContext().getSystemService("wifi");
        f2866ep = wifiManager;
        return wifiManager.getWifiState() == 3;
    }

    public static String m2588au() {
        return f2857ef;
    }

    public static String m2589av() {
        return f2862ek;
    }

    private static String m2590cv(String str) {
        return str.equalsIgnoreCase("hdidfv") ? System.getProperty("HDIDFV") : System.getProperty("IMEI");
    }

    public static String getNetworkCountryIso() {
        return f2863el;
    }

    public static String getNetworkOperator() {
        return f2858eg;
    }

    public static String getNetworkOperatorName() {
        return f2859eh;
    }

    public static String getSimCountryIso() {
        return f2864em;
    }

    public static String getSimOperator() {
        return f2860ei;
    }

    public static String getSimOperatorName() {
        return f2861ej;
    }

    public static String getUserAgent() {
        return userAgent;
    }

    public static String m2592qe() {
        return f2855Yh;
    }

    public static boolean m2593qg() {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) C0488o.getContext().getSystemService("connectivity");
        if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
            return activeNetworkInfo.isConnected();
        }
        return false;
    }

    public static void m2594sC() {
        f2866ep.setWifiEnabled(false);
    }

    public static void m2595sD() {
        f2866ep.setWifiEnabled(true);
    }

    public static boolean m2596sE() {
        return f2866ep.getWifiState() == 0;
    }

    public static boolean m2597sF() {
        return f2866ep.getWifiState() == 2;
    }

    public static boolean m2598sG() {
        ConnectivityManager connectivityManager = f2867er;
        ConnectivityManager connectivityManager2 = f2867er;
        if (connectivityManager.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTED) {
            C0012k.m39a("IAP-Device", "Phone Data Connection READY!!!");
            return true;
        }
        C0012k.m39a("IAP-Device", "Phone Data Connection HANDSHAKING!!!");
        return false;
    }

    public static void m2599sH() {
        String str;
        if (f2867er == null) {
            f2867er = (ConnectivityManager) C0488o.getContext().getSystemService("connectivity");
        }
        TelephonyManager telephonyManager = (TelephonyManager) C0488o.getContext().getSystemService("phone");
        switch (telephonyManager.getSimState()) {
            case 1:
                str = "SIM_ABSENT";
                break;
            case 2:
                str = "SIM_PIN_REQUIRED";
                break;
            case 3:
                str = "SIM_PUK_REQUIRED";
                break;
            default:
                str = "SIM_ERROR_UNKNOWN";
                break;
        }
        if (f2857ef == null) {
            f2857ef = m2590cv("IMEI");
        }
        if (f2855Yh == null && C0463b.m2545qR() != 0) {
            f2855Yh = m2590cv("HDIDFV");
        }
        if (C0463b.m2545qR() != 2) {
            if (f2858eg == null) {
                f2858eg = telephonyManager.getNetworkOperator();
            }
            if (f2858eg.trim().length() == 0) {
                f2858eg = str;
            }
            if (f2859eh == null) {
                f2859eh = telephonyManager.getNetworkOperatorName();
            }
            if (f2859eh.trim().length() == 0) {
                f2859eh = str;
            }
            if (f2860ei == null) {
                f2860ei = telephonyManager.getSimOperator();
            }
            if (f2860ei.trim().length() == 0) {
                f2860ei = str;
            }
            if (f2861ej == null) {
                f2861ej = telephonyManager.getSimOperatorName();
            }
            if (f2861ej.trim().length() == 0) {
                f2861ej = str;
            }
            if (f2862ek == null || f2862ek.equals("00")) {
                f2862ek = telephonyManager.getLine1Number();
            }
            if (f2862ek == null) {
                f2862ek = "00";
            }
            if (f2863el == null) {
                f2863el = telephonyManager.getNetworkCountryIso();
            }
            if (f2864em == null) {
                f2864em = telephonyManager.getSimCountryIso();
            }
            adM = telephonyManager.isNetworkRoaming();
        }
        String iSO3Language = Locale.getDefault().getISO3Language();
        int i = 0;
        while (true) {
            if (i < f2856ee.length) {
                if (iSO3Language.compareToIgnoreCase(f2856ee[i][0]) == 0) {
                    String str2 = f2856ee[i][1];
                } else {
                    i++;
                }
            }
        }
        if (!C0463b.m2544qQ()) {
            String externalStorageState = Environment.getExternalStorageState();
            if (externalStorageState == "removed" || externalStorageState == "unmounted" || externalStorageState == "bad_removal") {
                C0488o.getContext().getFilesDir().getAbsolutePath();
            } else {
                File file = new File(Environment.getExternalStorageDirectory(), ".gameloft");
                file.mkdirs();
                file.getAbsolutePath();
            }
            try {
                ((Activity) C0488o.getContext()).runOnUiThread(new C0478e());
            } catch (Exception e) {
                userAgent = "GL_EMU_001";
                C0012k.m38a(e);
            }
        }
        adN = new C0474a();
        C0012k.m41c("IAP-Device", "InitDeviceValues END!!! ");
    }

    public static void m2600sI() {
        f2857ef = null;
        f2858eg = null;
        f2859eh = null;
        f2860ei = null;
        f2861ej = null;
        f2862ek = null;
        f2863el = null;
        f2864em = null;
    }

    public static String m2601sJ() {
        return Build.MODEL;
    }

    public static String m2602sK() {
        return Build.DEVICE;
    }

    public static boolean m2603sL() {
        return adM;
    }

    public static C0474a m2604sM() {
        return adN;
    }
}
