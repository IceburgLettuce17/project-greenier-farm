package com.gameloft.android.LATAM.GloftGF2H;

import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.webkit.WebView;
import java.io.File;
import java.util.Locale;
import java.util.UUID;
import p001a.p004b.p005a.p006a.C0002a;

public final class C0332l {

    private static C0327g f1943en;

    private static WifiManager f1945ep;

    private static String f1947es;

    private TelephonyManager f1948eq;

    private static String[][] f1934ee = {new String[]{"eng", "en"}, new String[]{"fra", "fr"}, new String[]{"deu", "de"}, new String[]{"esl", "es"}, new String[]{"spa", "es"}, new String[]{"ita", "it"}, new String[]{"jpn", "jp"}, new String[]{"por", "br"}, new String[]{"por", "pt"}};

    private static String f1935ef = null;
    private static String userAgent = null;

    private static String f1936eg = null;

    private static String f1937eh = null;

    private static String f1938ei = null;

    private static String f1939ej = null;

    private static String f1940ek = null;

    private static String f1941el = null;

    private static String f1942em = null;

    private static WebView f1944eo = null;

    private static ConnectivityManager f1946er = null;

    public C0332l() {
        String str;
        String absolutePath;
        if (f1946er == null) {
            f1946er = (ConnectivityManager) C0325e.getContext().getSystemService("connectivity");
        }
        this.f1948eq = (TelephonyManager) C0325e.getContext().getSystemService("phone");
        switch (this.f1948eq.getSimState()) {
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
        if (f1935ef == null) {
            f1935ef = getDeviceId();
        }
        if (f1936eg == null) {
            f1936eg = this.f1948eq.getNetworkOperator();
        }
        if (f1936eg.trim().length() == 0) {
            f1936eg = str;
        }
        if (f1937eh == null) {
            f1937eh = this.f1948eq.getNetworkOperatorName();
        }
        if (f1937eh.trim().length() == 0) {
            f1937eh = str;
        }
        if (f1938ei == null) {
            f1938ei = this.f1948eq.getSimOperator();
        }
        if (f1938ei.trim().length() == 0) {
            f1938ei = str;
        }
        if (f1939ej == null) {
            f1939ej = this.f1948eq.getSimOperatorName();
        }
        if (f1939ej.trim().length() == 0) {
            f1939ej = str;
        }
        if (f1940ek == null || f1940ek.equals("00")) {
            f1940ek = this.f1948eq.getLine1Number();
        }
        if (f1940ek == null) {
            f1940ek = "00";
        }
        if (f1941el == null) {
            f1941el = this.f1948eq.getNetworkCountryIso();
        }
        if (f1942em == null) {
            f1942em = this.f1948eq.getSimCountryIso();
        }
        this.f1948eq.isNetworkRoaming();
        m1988j(Locale.getDefault().getISO3Language());
        String externalStorageState = Environment.getExternalStorageState();
        if (externalStorageState == "removed" || externalStorageState == "unmounted" || externalStorageState == "bad_removal") {
            absolutePath = C0325e.getContext().getFilesDir().getAbsolutePath();
        } else {
            File file = new File(Environment.getExternalStorageDirectory(), ".gameloft");
            file.mkdirs();
            absolutePath = file.getAbsolutePath();
        }
        f1947es = absolutePath;
        try {
            if (f1944eo == null) {
                f1944eo = new WebView(C0325e.getContext());
            }
            userAgent = f1944eo.getSettings().getUserAgentString();
        } catch (Exception e) {
            userAgent = "GL_EMU_001";
            C0002a.m6a(e);
        }
        f1943en = new C0327g();
    }

    public static C0327g m1983ai() {
        return f1943en;
    }

    public static boolean m1984at() {
        WifiManager wifiManager = (WifiManager) C0325e.getContext().getSystemService("wifi");
        f1945ep = wifiManager;
        return wifiManager.getWifiState() == 3;
    }

    public static String m1985au() {
        return f1935ef;
    }

    public static String m1986av() {
        if (f1940ek == null) {
            try {
                String line1Number = ((TelephonyManager) C0325e.getContext().getSystemService("phone")).getLine1Number();
                f1940ek = line1Number;
                if (line1Number == null || f1940ek.equals("")) {
                    f1940ek = "00";
                }
            } catch (Exception e) {
                f1940ek = "00";
            }
        }
        return f1940ek;
    }

    private static synchronized String m1987aw() {
        String deviceId;
        synchronized (C0332l.class) {
            if (C0325e.getContext() == null) {
                "SUtils.getContext() == null".toString();
                "You must call SUtils.setContext() first".toString();
                deviceId = null;
            } else {
                "Try using IMEI".toString();
                deviceId = ((TelephonyManager) C0325e.getContext().getSystemService("phone")).getDeviceId();
                if (deviceId == null) {
                    if (Build.VERSION.SDK_INT > 8) {
                        "Try using SERIAL, Android 2.3".toString();
                        deviceId = Build.SERIAL;
                        if (deviceId != null) {
                        }
                    }
                    try {
                        "Try using SERIAL".toString();
                        Class<?> cls = Class.forName("android.os.SystemProperties");
                        deviceId = (String) cls.getMethod("get", String.class).invoke(cls, "ro.serialno");
                        if (deviceId != null) {
                            if (deviceId.length() > 0) {
                            }
                        }
                    } catch (Exception e) {
                    }
                    "Try using ANDROID_ID".toString();
                    deviceId = Settings.Secure.getString(C0325e.getContext().getContentResolver(), "android_id");
                    if (deviceId == null || deviceId.length() <= 0) {
                        "Try using UUID".toString();
                        String str = C0325e.m1961g("SDFolder", f1947es) + "/.nomedia";
                        deviceId = C0325e.m1962h(str);
                        if (deviceId == null || deviceId.length() == 0) {
                            deviceId = UUID.randomUUID().toString().replaceAll("-", "");
                            C0325e.m1963h(str, deviceId);
                            try {
                                File file = new File(str);
                                if (file.exists()) {
                                    file.setReadOnly();
                                }
                            } catch (Exception e2) {
                            }
                        }
                    }
                }
            }
        }
        return deviceId;
    }

    public static String getDeviceId() {
        return (!m1984at() || Build.MODEL == null || Build.DEVICE == null) ? m1987aw() : m1987aw();
    }

    public static String getUserAgent() {
        return userAgent;
    }

    private static String m1988j(String str) {
        for (int i = 0; i < f1934ee.length; i++) {
            if (str.compareToIgnoreCase(f1934ee[i][0]) == 0) {
                return f1934ee[i][1];
            }
        }
        return "en";
    }
}
