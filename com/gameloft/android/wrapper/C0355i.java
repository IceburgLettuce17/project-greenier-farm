package com.gameloft.android.wrapper;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.Signature;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import dalvik.system.PathClassLoader;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Hashtable;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.net.ssl.HttpsURLConnection;
import p009b.p010a.p015d.AbstractActivityC0092a;

public final class C0355i {

    public static boolean f2717Yf = true;
    private static Context mContext = null;

    public static String f2718Yg = "";
    private static String userAgent = null;

    private static String f2719Yh = "";

    private static String f2720Yi = "";
    public static String response = null;

    private static String f2721Yj = "glot_log.txt";

    private static String f2722Yk = null;

    private static String f2723Yl = null;

    public static String m2189A(String str, String str2) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            InputStream openRawResource = mContext.getResources().openRawResource(mContext.getResources().getIdentifier(str, str2, mContext.getPackageName()));
            for (int read = openRawResource.read(); read != -1; read = openRawResource.read()) {
                byteArrayOutputStream.write(read);
            }
            openRawResource.close();
        } catch (IOException e) {
        } catch (Exception e2) {
        }
        return byteArrayOutputStream.toString();
    }

    public static byte[] m2190B(String str, String str2) {
        try {
            SecretKey generateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(str2.getBytes()));
            Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
            cipher.init(1, generateSecret);
            byte[] bytes = str.getBytes();
            int length = bytes.length % 8 == 0 ? bytes.length / 8 : (bytes.length / 8) + 1;
            byte[] bArr = new byte[length << 3];
            for (int i = 0; i < (length << 3); i++) {
                bArr[i] = 0;
            }
            System.arraycopy(bytes, 0, bArr, 0, bytes.length);
            return cipher.doFinal(bArr);
        } catch (Exception e) {
            return null;
        }
    }

    private static int m2191a(String str, int i, String str2) {
        int i2 = mContext.getSharedPreferences(str2, 0).getInt(str, 0);
        String str3 = "getPreferenceInt(" + str + ", 0 " + i2 + ", " + str2 + ")";
        return i2;
    }

    public static long m2192a(String str, Context context) {
        String absolutePath;
        File file;
        try {
            if (str.contains(context.getPackageName())) {
                file = new File(str.substring(0, str.indexOf(context.getPackageName())));
            } else {
                String externalStorageState = Environment.getExternalStorageState();
                if (externalStorageState == "removed" || externalStorageState == "unmounted" || externalStorageState == "bad_removal") {
                    absolutePath = mContext.getFilesDir().getAbsolutePath();
                } else {
                    File file2 = new File(Environment.getExternalStorageDirectory(), ".gameloft");
                    file2.mkdirs();
                    absolutePath = file2.getAbsolutePath();
                }
                file = str == absolutePath ? new File("/sdcard/") : new File(str);
            }
            if (!file.exists()) {
                file.mkdirs();
            }
            StatFs statFs = new StatFs(file.getAbsolutePath());
            return (statFs.getAvailableBlocks() * statFs.getBlockSize()) / 1048576;
        } catch (Exception e) {
            return 0L;
        }
    }

    private static String m2193a(InputStream inputStream, String str) {
        return new String(m2203f(inputStream), str);
    }

    public static void m2194a(String str, Object obj, String str2) {
        String str3 = "setPreferences(" + str + ", " + obj + ", " + str2 + ")";
        SharedPreferences.Editor edit = mContext.getSharedPreferences(str2, 0).edit();
        if (obj instanceof String) {
            edit.putString(str, (String) obj);
        } else if (obj instanceof Integer) {
            edit.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Boolean) {
            edit.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Long) {
            edit.putLong(str, ((Long) obj).longValue());
        }
        edit.commit();
    }

    public static void m2195a(String str, boolean z, String str2) {
        if (str.equals("") || str == null) {
            return;
        }
        f2721Yj = str;
        try {
            File file = new File(Environment.getExternalStorageDirectory(), "GlotDebug");
            if (file.exists()) {
                FileWriter fileWriter = new FileWriter(new File(file, f2721Yj), z);
                fileWriter.append((CharSequence) (str2 + "\n"));
                fileWriter.flush();
                fileWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String m2196av() {
        try {
            String line1Number = ((TelephonyManager) mContext.getSystemService("phone")).getLine1Number();
            if (line1Number != null) {
                if (!line1Number.equals("")) {
                    return line1Number;
                }
            }
            return "00";
        } catch (Exception e) {
            return "00";
        }
    }

    public static boolean m2197b(String str, boolean z, String str2) {
        try {
            boolean z2 = mContext.getSharedPreferences(str2, 0).getBoolean(str, true);
            String str3 = "getPreferenceBoolean(" + str + ", true " + z2 + ", " + str2 + ")";
            return z2;
        } catch (Exception e) {
            String str4 = "getPreferenceBoolean(" + str + ", true false, " + str2 + ")";
            return false;
        }
    }

    public static void m2198bj(String str) {
        InputStream inputStream;
        int i = 0;
        System.currentTimeMillis();
        try {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
            httpsURLConnection.setRequestMethod("GET");
            httpsURLConnection.setRequestProperty("Connection", "close");
            httpsURLConnection.setRequestProperty("User-Agent", userAgent);
            String m2189A = m2189A("serialkey", "raw");
            if (m2189A != null) {
                httpsURLConnection.setRequestProperty("x-gl-d", m2189A);
            }
            httpsURLConnection.setRequestProperty("x-android-os-build-model", Build.MODEL);
            httpsURLConnection.setRequestProperty("x-up-gl-subno", m2196av());
            httpsURLConnection.setRequestProperty("x-up-gl-imei", getDeviceId());
            if (httpsURLConnection.getResponseCode() != 200) {
                return;
            }
            synchronized (httpsURLConnection) {
                inputStream = httpsURLConnection.getInputStream();
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[16];
            while (i != -1) {
                i = inputStream.read(bArr, 0, 16);
                if (i != -1) {
                    byteArrayOutputStream.write(bArr, 0, i);
                }
            }
            response = byteArrayOutputStream.toString();
            httpsURLConnection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void m2199bk(String str) {
        m2195a(f2721Yj, true, str);
    }

    public static Hashtable m2200bl(String str) {
        return new Hashtable(mContext.getSharedPreferences(str, 0).getAll());
    }

    private static String m2202e(String str, String str2, String str3) {
        String string = mContext.getSharedPreferences(str3, 0).getString(str, str2);
        String str4 = "getPreferenceString(" + str + ", " + str2 + " " + string + ", " + str3 + ")";
        return string;
    }

    private static byte[] m2203f(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public static Activity getActivity() {
        return (Activity) mContext;
    }

    public static Context getContext() {
        return mContext;
    }

    public static synchronized String getDeviceId() {
        String m2204i;
        synchronized (C0355i.class) {
            m2204i = mContext == null ? null : m2204i(mContext);
        }
        return m2204i;
    }

    public static String getNetworkCountryIso() {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) mContext.getSystemService("phone");
            if (telephonyManager != null) {
                return telephonyManager.getNetworkCountryIso();
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public static String getNetworkOperator() {
        String str;
        String str2;
        String str3;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) mContext.getSystemService("phone");
            if (telephonyManager != null) {
                switch (telephonyManager.getSimState()) {
                    case 1:
                        str3 = "SIM_ABSENT";
                        break;
                    case 2:
                        str3 = "SIM_PIN_REQUIRED";
                        break;
                    case 3:
                        str3 = "SIM_PUK_REQUIRED";
                        break;
                    default:
                        str3 = "SIM_ERROR_UNKNOWN";
                        break;
                }
                str2 = telephonyManager.getNetworkOperator();
                str = str3;
            } else {
                str2 = null;
                str = "SIM_ERROR_UNKNOWN";
            }
        } catch (Exception e) {
            str = "SIM_ERROR_UNKNOWN";
            str2 = null;
        }
        return (str2 == null || str2.trim().length() == 0) ? str : str2;
    }

    public static final InputStream getResourceAsStream(String str) {
        if (str.startsWith("/")) {
            str = str.substring(1);
        }
        String lowerCase = str.substring(str.lastIndexOf(47) + 1).toLowerCase();
        int indexOf = lowerCase.indexOf(46);
        if (indexOf != -1) {
            lowerCase = lowerCase.substring(0, indexOf);
        }
        String str2 = str.substring(0, str.lastIndexOf(47) + 1) + "res_" + lowerCase;
        if (f2717Yf) {
            String str3 = "Trying to get protected resource using forward lock. Resource: " + str2;
        }
        int identifier = mContext.getResources().getIdentifier(str2, "drawable", mContext.getPackageName());
        if (identifier != 0) {
            if (f2717Yf) {
                String str4 = "Forward lock protection ok. Protected resource exists: " + str2 + " with ID=" + identifier;
            }
            InputStream openRawResource = mContext.getResources().openRawResource(identifier);
            if (openRawResource != null) {
                return openRawResource;
            }
        }
        if (f2717Yf) {
            String str5 = "Resource: " + str + " is not protected using forward lock";
        }
        AssetManager assets = mContext.getAssets();
        try {
            if (f2717Yf) {
                String str6 = "Reading asset: " + str;
            }
            return assets.open(f2718Yg + str);
        } catch (IOException e) {
            if (f2717Yf) {
                String str7 = "Error reading asset: " + str + " :: " + e;
            }
            return null;
        }
    }

    public static String getSerial() {
        String str;
        if (Build.VERSION.SDK_INT > 8) {
            try {
                str = (String) Build.class.getField("SERIAL").get(null);
            } catch (IllegalAccessException e) {
            } catch (IllegalArgumentException e2) {
                str = "";
            } catch (NoSuchFieldException e3) {
                str = "";
            } catch (SecurityException e4) {
                str = "";
            }
            if (str != null || str.length() < 5 || str.equals("unknown")) {
                str = m2207qd();
            }
            return (!str.equals("") || str == null) ? "" : str;
        }
        str = "";
        if (str != null) {
        }
        str = m2207qd();
        if (str.equals("")) {
        }
    }

    public static synchronized String m2204i(Context context) {
        String string;
        synchronized (C0355i.class) {
            String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
            if (deviceId != null) {
                string = deviceId;
            } else {
                if (Build.VERSION.SDK_INT > 8) {
                    try {
                        string = (String) Build.class.getField("SERIAL").get(null);
                    } catch (IllegalAccessException e) {
                        string = deviceId;
                    } catch (IllegalArgumentException e2) {
                        string = deviceId;
                    } catch (NoSuchFieldException e3) {
                        string = deviceId;
                    } catch (SecurityException e4) {
                        string = deviceId;
                    }
                    if (string != null) {
                    }
                }
                try {
                    Class<?> cls = Class.forName("android.os.SystemProperties");
                    string = (String) cls.getMethod("get", String.class).invoke(cls, "ro.serialno");
                    if (string != null) {
                        if (string.length() > 0) {
                        }
                    }
                } catch (Exception e5) {
                }
                string = Settings.Secure.getString(context.getContentResolver(), "android_id");
                if (string != null) {
                    if (string.length() > 0) {
                    }
                }
            }
        }
        return string;
    }

    public static String m2205qb() {
        try {
            String macAddress = ((WifiManager) mContext.getSystemService("wifi")).getConnectionInfo().getMacAddress();
            if (macAddress != null) {
                if (macAddress.length() > 0) {
                    return macAddress;
                }
            }
        } catch (Exception e) {
            String str = "Error in getMac" + e.toString();
        }
        return "00:00:00:00:00:00";
    }

    public static String m2206qc() {
        String string;
        return (mContext == null || (string = Settings.Secure.getString(mContext.getContentResolver(), "android_id")) == null || string.equals("9774d56d682e549c") || string.length() < 15) ? "" : string;
    }

    public static String m2207qd() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getMethod("get", String.class).invoke(cls, "ro.serialno");
            if (str != null && str.length() >= 5) {
                if (!str.equals("unknown")) {
                    return str;
                }
            }
            return "";
        } catch (Exception e) {
            return "";
        }
    }

    public static String m2208qe() {
        return "";
    }

    public static String m2209qf() {
        try {
            File file = new File(Environment.getExternalStorageDirectory(), "GlotDebug");
            if (!file.exists()) {
                return null;
            }
            File file2 = new File(file, "QADEBUG.txt");
            if (!file2.exists()) {
                return null;
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file2));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return sb.toString();
                }
                sb.append(readLine);
                sb.append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean m2210qg() {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) mContext.getSystemService("connectivity");
            if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
                return activeNetworkInfo.isConnected();
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean m2211qh() {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) mContext.getSystemService("connectivity");
            if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
                if (activeNetworkInfo.isConnected()) {
                    if (activeNetworkInfo.getType() == 1) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean m2212qi() {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) mContext.getSystemService("connectivity");
            if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
                if (activeNetworkInfo.isConnected()) {
                    if (activeNetworkInfo.getType() == 0) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static String m2213qj() {
        return new StringBuilder().append(SystemClock.elapsedRealtime()).toString();
    }

    public static int m2214qk() {
        return ((AudioManager) mContext.getSystemService("audio")).getStreamVolume(3);
    }

    public static String m2215ql() {
        try {
            InputStream openRawResource = mContext.getResources().openRawResource(mContext.getResources().getIdentifier("serialkey", "raw", mContext.getPackageName()));
            int available = openRawResource.available();
            byte[] bArr = new byte[available];
            openRawResource.read(bArr, 0, available);
            openRawResource.close();
            return new String(bArr);
        } catch (Exception e) {
            return null;
        }
    }

    public static String m2216qm() {
        try {
            return mContext.getResources().getConfiguration().locale.getLanguage();
        } catch (Exception e) {
            try {
                return Locale.getDefault().getLanguage();
            } catch (Exception e2) {
                return "XX";
            }
        }
    }

    public static String m2217qn() {
        if (mContext != null) {
            try {
                String simCountryIso = ((TelephonyManager) mContext.getSystemService("phone")).getSimCountryIso();
                if (simCountryIso != null && simCountryIso.length() != 0) {
                    return simCountryIso;
                }
                String country = mContext.getResources().getConfiguration().locale.getCountry();
                if (country != null) {
                    if (country.length() != 0) {
                        return country;
                    }
                }
            } catch (Exception e) {
            }
        }
        String country2 = Locale.getDefault().getCountry();
        return (country2 == null || country2.length() != 0) ? "XX" : country2;
    }

    public static String m2218qo() {
        String simOperator;
        try {
            if (mContext != null && (simOperator = ((TelephonyManager) mContext.getSystemService("phone")).getSimOperator()) != null) {
                if (simOperator.length() != 0) {
                    return simOperator;
                }
            }
        } catch (Exception e) {
        }
        return "0";
    }

    private static int[] m2219qp() {
        int[] iArr = {0, 0, 0, 0};
        try {
            Signature[] signatureArr = mContext.getPackageManager().getPackageInfo(mContext.getPackageName(), 64).signatures;
            int length = signatureArr.length < 4 ? signatureArr.length : 4;
            for (int i = 0; i < length; i++) {
                iArr[i] = signatureArr[i].hashCode();
            }
            return iArr;
        } catch (Exception e) {
            return iArr;
        }
    }

    public static boolean m2220qq() {
        int[] m2219qp = m2219qp();
        if (m2219qp == null) {
            return true;
        }
        int[] iArr = {16847, 2021};
        boolean z = true;
        for (int i = 0; i < m2219qp.length; i++) {
            if (i == 0) {
                iArr[1] = iArr[1] << 1;
            }
            if (m2219qp[i] == (iArr[1] * 100000) + (iArr[0] * 3)) {
                return true;
            }
            if (m2219qp[i] > 0) {
                z = false;
            }
        }
        return z;
    }

    private static String m2221qr() {
        try {
            String str = "Package name:" + mContext.getPackageName();
            String packageName = mContext.getPackageName();
            return packageName.indexOf("com.gameloft.android.") == -1 ? packageName : packageName.substring(21);
        } catch (Exception e) {
            return "";
        }
    }

    public static String m2222qs() {
        if (mContext == null) {
            return "";
        }
        if (f2722Yk == null) {
            String m2226qw = m2226qw();
            if (!TextUtils.isEmpty(m2226qw)) {
                try {
                    String str = "InjectedIGP get from crc.bin:" + m2226qw;
                    f2722Yk = C0350d.m2175pY().m2176z(m2226qw, AbstractActivityC0092a.m209a((Activity) mContext, "GAME-IGP-CODE"));
                } catch (Exception e) {
                    f2722Yk = "";
                }
                String str2 = "InjectedIGP was null, setting to PlainDef:" + f2722Yk;
            }
        }
        if (TextUtils.isEmpty(f2722Yk)) {
            f2722Yk = "";
        }
        return f2722Yk;
    }

    public static String m2223qt() {
        int i = 0;
        if (f2723Yl == null) {
            try {
                String m2202e = m2202e("injectedSerialKey", "", "injectedIGP" + m2221qr());
                if (TextUtils.isEmpty(m2202e)) {
                    if (m2191a("retryNumSerialKey", 0, new StringBuilder("injectedIGP").append(m2221qr()).toString()) <= 1) {
                        m2202e = m2228qy();
                        if (TextUtils.isEmpty(m2202e)) {
                            String[] list = new File("/system/app").list();
                            while (true) {
                                if (i >= list.length) {
                                    break;
                                }
                                if (list[i].endsWith(".apk")) {
                                    String str = "/system/app/" + list[i];
                                    if (mContext.getPackageManager().getPackageArchiveInfo(str, 0).packageName.equals(mContext.getPackageName())) {
                                        m2202e = m2193a(new PathClassLoader(str, null, PathClassLoader.getSystemClassLoader()).getResourceAsStream("res/raw/serialkey.txt"), "UTF-8");
                                        if (!TextUtils.isEmpty(m2202e)) {
                                            m2194a("injectedSerialKey", m2202e, "injectedIGP" + m2221qr());
                                        }
                                    }
                                }
                                i++;
                            }
                        } else {
                            m2194a("injectedSerialKey", m2202e, "injectedIGP" + m2221qr());
                        }
                        m2225qv();
                    }
                }
                f2723Yl = m2202e;
                String str2 = "SerialKey Google:" + f2723Yl;
            } catch (Exception e) {
                f2723Yl = "";
                m2225qv();
            }
        }
        if (TextUtils.isEmpty(f2723Yl)) {
            f2723Yl = "";
        }
        return f2723Yl;
    }

    private static void m2224qu() {
        int m2191a = m2191a("retryNumIGP", 0, "injectedIGP" + m2221qr()) + 1;
        if (m2191a < 3) {
            m2194a("retryNumIGP", Integer.valueOf(m2191a), "injectedIGP" + m2221qr());
        }
        String str = "Increase IGP retry count to " + m2191a;
    }

    private static void m2225qv() {
        int m2191a = m2191a("retryNumSerialKey", 0, "injectedIGP" + m2221qr()) + 1;
        if (m2191a < 3) {
            m2194a("retryNumSerialKey", Integer.valueOf(m2191a), "injectedIGP" + m2221qr());
        }
        String str = "Increase SerialKey retry count to " + m2191a;
    }

    private static String m2226qw() {
        int i = 0;
        try {
            String m2202e = m2202e("injectedIGP", "", "injectedIGP" + m2221qr());
            if (!TextUtils.isEmpty(m2202e)) {
                return m2202e;
            }
            if (!(m2191a("retryNumIGP", 0, new StringBuilder("injectedIGP").append(m2221qr()).toString()) <= 1)) {
                return m2202e;
            }
            String m2227qx = m2227qx();
            String str = "Injected IGP from same APK :" + m2227qx;
            if (TextUtils.isEmpty(m2227qx)) {
                String[] list = new File("/system/app").list();
                while (true) {
                    if (i >= list.length) {
                        break;
                    }
                    if (list[i].endsWith(".apk")) {
                        String str2 = "/system/app/" + list[i];
                        if (mContext.getPackageManager().getPackageArchiveInfo(str2, 0).packageName.equals(mContext.getPackageName())) {
                            m2227qx = m2193a(new PathClassLoader(str2, null, PathClassLoader.getSystemClassLoader()).getResourceAsStream("res/raw/crc.bin"), "UTF-8");
                            if (!TextUtils.isEmpty(m2227qx)) {
                                String str3 = "Injected IGP from original APK :" + m2227qx;
                                m2194a("injectedIGP", m2227qx, "injectedIGP" + m2221qr());
                            }
                        }
                    }
                    i++;
                }
            } else {
                m2194a("injectedIGP", m2227qx, "injectedIGP" + m2221qr());
            }
            if (TextUtils.isEmpty(m2227qx)) {
                m2227qx = "";
            }
            m2224qu();
            return m2227qx;
        } catch (Exception e) {
            m2224qu();
            return "";
        }
    }

    private static String m2227qx() {
        InputStream openRawResource = mContext.getResources().openRawResource(mContext.getResources().getIdentifier("crc", "raw", mContext.getPackageName()));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            for (int read = openRawResource.read(); read != -1; read = openRawResource.read()) {
                byteArrayOutputStream.write(read);
            }
            openRawResource.close();
        } catch (IOException e) {
            String str = "err:" + e.toString();
        }
        return byteArrayOutputStream.toString();
    }

    private static String m2228qy() {
        InputStream openRawResource = mContext.getResources().openRawResource(mContext.getResources().getIdentifier("serialkey", "raw", mContext.getPackageName()));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            for (int read = openRawResource.read(); read != -1; read = openRawResource.read()) {
                byteArrayOutputStream.write(read);
            }
            openRawResource.close();
        } catch (IOException e) {
            String str = "err:" + e.toString();
        }
        return byteArrayOutputStream.toString();
    }

    public static void setContext(Context context) {
        mContext = context;
        try {
            Context context2 = mContext;
            ((Activity) mContext).runOnUiThread(new RunnableC0356j());
        } catch (ClassCastException e) {
        } catch (Exception e2) {
        }
    }
}
