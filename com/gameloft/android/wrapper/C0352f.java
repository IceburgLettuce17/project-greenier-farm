package com.gameloft.android.wrapper;

import android.content.SharedPreferences;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import java.util.Locale;
import java.util.UUID;
import p009b.p010a.p015d.AbstractActivityC0092a;

public final class C0352f {

    public static String f2702XR = "";

    public static String f2703XS = "";

    private static String f2704XT = "2.3";

    public static int f2705XU = 1500;

    public static String f2706XV = "http://ingameads.gameloft.com/redir/hdloading.php?game=#GAME#&country=#COUNTRY#&lg=#LANG#&ver=#IGP_VERSION#&device=#DEVICE#&f=#FIRMWARE#&udid=#ID#&androidid=#ANDROIDID#&g_ver=#VERSION#&line_number=#LINE_NUMBER#";

    private static String f2707XW = "https://ingameads.gameloft.com/redir/?from=#GAME#&op=#CARRIER#&game=#GAME#&ver=#VERSION#&lg=#LANG#&country=#COUNTRY#&d=#DEVICE#&f=#FIRMWARE#&udid=#ID#";

    private static String f2708XX;

    private static String f2709XY;

    private static String f2710XZ;

    private static String f2711Ya;

    private static String f2712Yb;

    private static String f2713Yc;

    static String f2714Yd;

    private static String f2715ek;

    public static void m2183a(AbstractActivityC0092a abstractActivityC0092a) {
        TelephonyManager telephonyManager = (TelephonyManager) C0355i.getContext().getSystemService("phone");
        f2708XX = getDeviceId();
        f2709XY = m2188qa();
        Locale locale = Locale.getDefault();
        f2710XZ = locale.getLanguage();
        f2711Ya = locale.getCountry();
        f2712Yb = Build.MANUFACTURER + "_" + Build.MODEL;
        f2713Yc = Build.VERSION.RELEASE;
        f2714Yd = AbstractActivityC0092a.akX;
        f2702XR = AbstractActivityC0092a.akY;
        String str = AbstractActivityC0092a.VERSION;
        f2703XS = abstractActivityC0092a.m214di("MIDlet-Version");
        if (abstractActivityC0092a.m214di("IGP-VERSION") != null) {
            f2704XT = abstractActivityC0092a.m214di("IGP-VERSION");
        }
        if (f2715ek == null) {
            try {
                String line1Number = telephonyManager.getLine1Number();
                f2715ek = line1Number;
                if (line1Number == null || f2715ek.equals("")) {
                    f2715ek = "00";
                }
            } catch (Exception e) {
                f2715ek = "00";
            }
        }
    }

    public static String m2184bh(String str) {
        if (str.compareTo(f2706XV) != 0) {
            return str.compareTo(f2707XW) == 0 ? str.replace("#GAME#", f2702XR).replace("#COUNTRY#", f2711Ya).replace("#LANG#", f2710XZ).replace("#VERSION#", f2703XS).replace("#DEVICE#", f2712Yb).replace("#FIRMWARE#", f2713Yc).replace("#ID#", f2708XX).replace("#CARRIER#", f2714Yd).replace(" ", "") : str.replace("#GAME#", f2702XR).replace("#COUNTRY#", f2711Ya).replace("#LANG#", f2710XZ).replace("#VERSION#", f2703XS).replace("#DEVICE#", f2712Yb).replace("#FIRMWARE#", f2713Yc).replace("#ID#", f2708XX).replace("#ANDROIDID#", f2709XY).replace("#IGP_VERSION#", f2704XT).replace("#LINE_NUMBER#", f2715ek).replace("#CARRIER#", f2714Yd).replace(" ", "");
        }
        return str.replace("#GAME#", f2702XR).replace("#COUNTRY#", f2711Ya).replace("#LANG#", f2710XZ).replace("#VERSION#", f2703XS).replace("#DEVICE#", f2712Yb).replace("#FIRMWARE#", f2713Yc).replace("#ID#", C0347a.m2169T(f2708XX)).replace("#ANDROIDID#", f2709XY).replace("#IGP_VERSION#", f2704XT).replace("#LINE_NUMBER#", C0347a.m2169T(f2715ek)).replace(" ", "") + "&enc=1";
    }

    public static String m2185bi(String str) {
        return str.equals("IMEI") ? getDeviceId() : str.equals("microedition.device") ? Build.MODEL.toUpperCase() : str.equals("microedition.device.version") ? Build.VERSION.RELEASE.toUpperCase() : str.equals("microedition.device.aid") ? m2188qa() : "";
    }

    public static void m2186eU(int i) {
        new Thread(new RunnableC0354h(i)).start();
    }

    private static synchronized String getDeviceId() {
        String str = null;
        synchronized (C0352f.class) {
            if (C0355i.getContext() != null) {
                String deviceId = ((TelephonyManager) C0355i.getContext().getSystemService("phone")).getDeviceId();
                if (deviceId != null) {
                    str = deviceId;
                } else {
                    if (Build.VERSION.SDK_INT > 8) {
                        try {
                            str = (String) Build.class.getField("SERIAL").get(null);
                        } catch (IllegalAccessException e) {
                            str = deviceId;
                        } catch (IllegalArgumentException e2) {
                            str = deviceId;
                        } catch (NoSuchFieldException e3) {
                            str = deviceId;
                        } catch (SecurityException e4) {
                            str = deviceId;
                        }
                        if (str != null) {
                        }
                    }
                    try {
                        Class<?> cls = Class.forName("android.os.SystemProperties");
                        str = (String) cls.getMethod("get", String.class).invoke(cls, "ro.serialno");
                        if (str != null) {
                            if (str.length() > 0) {
                            }
                        }
                    } catch (Exception e5) {
                    }
                    str = Settings.Secure.getString(C0355i.getContext().getContentResolver(), "android_id");
                    if (str == null || str.length() <= 0) {
                        SharedPreferences sharedPreferences = C0355i.getContext().getSharedPreferences("UUID", 0);
                        str = sharedPreferences.getString("UUID", UUID.randomUUID().toString().replaceAll("-", ""));
                        sharedPreferences.edit().putString("UUID", str);
                    }
                }
            }
        }
        return str;
    }

    public static void m2187pZ() {
        new Thread(new RunnableC0353g()).start();
    }

    private static synchronized String m2188qa() {
        String string;
        synchronized (C0352f.class) {
            if (C0355i.getContext() == null) {
                string = "0";
            } else {
                string = Settings.Secure.getString(C0355i.getContext().getContentResolver(), "android_id");
                if (string != null) {
                }
                string = "0";
            }
        }
        return string;
    }
}
