package com.gameloft.android2d.iap.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Environment;
import com.facebook.widget.PlacePickerFragment;
import com.gameloft.android2d.iap.C0463b;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.Vector;
import p001a.p004b.p005a.p006a.C0012k;
import p009b.p010a.p012b.C0051af;

public final class C0488o {

    private static Context f2878dD = null;

    private static char[] f2879fK = {' ', '{', '}', ':', '*', ',', '|', '\"', '+', '-', '/', '$', '='};

    public static boolean m2634G(String str, String str2) {
        return str.equals(String.valueOf(Integer.parseInt(str2) ^ 53412));
    }

    public static long m2635H(String str, String str2) {
        try {
            long m2648cI = m2648cI(str);
            long m2648cI2 = m2648cI(str2);
            if (m2648cI <= 0 || m2648cI2 <= 0) {
                return -2000L;
            }
            return m2648cI - m2648cI2;
        } catch (Exception e) {
            C0012k.m39a("RMS", "computeCountDownTime Error : " + e.getMessage());
            return -2000L;
        }
    }

    private static String m2636a(char c) {
        for (int i = 0; i < f2879fK.length; i++) {
            if (f2879fK[i] == c) {
                return "%" + Integer.toHexString(c);
            }
        }
        return String.valueOf(c);
    }

    private static boolean m2637a(C0490q c0490q, String str) {
        if (c0490q == null) {
            return false;
        }
        int m2504ah = C0463b.m2504ah(str);
        for (int i = 0; i < m2504ah; i++) {
            C0483j m2664j = c0490q.m2664j(str, i);
            if (m2664j == null) {
                C0012k.m41c("IAP-SUtils", "Item NULL: " + i + "  Type: " + str);
            } else if (m2664j.m2626sW() == null) {
                File file = new File(m2664j.m2625sV());
                FileInputStream fileInputStream = !file.exists() ? null : new FileInputStream(file);
                if (fileInputStream == null) {
                    C0012k.m41c("IAP-SUtils", "Failed to Load Image data: " + m2664j.m2625sV());
                    return false;
                }
                C0012k.m41c("IAP-SUtils", "Load Item Image from local storage: " + m2664j.m2625sV());
                m2664j.m2611a(C0051af.m123h(fileInputStream));
            } else {
                continue;
            }
        }
        return true;
    }

    private static boolean m2638a(String str, String str2, String str3, C0483j c0483j) {
        HttpURLConnection httpURLConnection;
        String str4;
        int i;
        boolean z;
        int i2;
        int responseCode;
        HttpURLConnection httpURLConnection2 = null;
        HttpURLConnection httpURLConnection3 = null;
        try {
            try {
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                try {
                    httpURLConnection.setConnectTimeout(10000);
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setRequestProperty("Connection", "close");
                    str4 = str2 + "/" + str3;
                    C0012k.m41c("IAP-SUtils", "remoteUrl: " + str);
                    i = 0;
                } catch (Exception e) {
                    httpURLConnection3 = httpURLConnection;
                    e = e;
                    C0012k.m41c("IAP-SUtils", "Exception when download Image Item: " + str3 + ", Exception: " + e);
                    httpURLConnection2 = httpURLConnection3;
                    if (httpURLConnection3 != null) {
                        httpURLConnection3.disconnect();
                        httpURLConnection2 = httpURLConnection3;
                    }
                    return true;
                } catch (Throwable th) {
                    httpURLConnection2 = httpURLConnection;
                    th = th;
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
            }
            if (str2 != null) {
                File file = new File(str4);
                if (file.exists()) {
                    i = (int) file.length();
                } else {
                    file.createNewFile();
                }
                if (file.exists()) {
                    z = true;
                    i2 = i;
                    responseCode = httpURLConnection.getResponseCode();
                    C0012k.m41c("IAP-SUtils", "HTTP response: " + responseCode);
                    if (responseCode == 200) {
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return false;
                    }
                    int contentLength = httpURLConnection.getContentLength();
                    if (contentLength <= 1) {
                        C0012k.m41c("IAP-SUtils", "Error when getting Image: " + str3);
                    }
                    if (contentLength == i2) {
                        C0012k.m41c("IAP-SUtils", "File already exist, no need to re-download");
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return true;
                    }
                    DataInputStream dataInputStream = null;
                    ?? r1 = 0;
                    synchronized (httpURLConnection) {
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream(), 10240);
                        bufferedInputStream.mark(10240);
                        if (z) {
                            dataInputStream = new DataInputStream(bufferedInputStream);
                            FileOutputStream fileOutputStream = new FileOutputStream(str4);
                            int i3 = 0;
                            while (i3 < contentLength) {
                                int i4 = contentLength - i3;
                                if (i4 > 131072) {
                                    i4 = 131072;
                                }
                                byte[] bArr = new byte[i4];
                                dataInputStream.readFully(bArr);
                                fileOutputStream.write(bArr);
                                fileOutputStream.flush();
                                i3 = i4 + i3;
                            }
                            r1 = fileOutputStream;
                            if (dataInputStream.markSupported()) {
                                C0012k.m41c("IAP-SUtils", "Reset data input stream");
                                dataInputStream.reset();
                                r1 = fileOutputStream;
                            }
                        }
                        c0483j.m2611a(C0051af.m123h(bufferedInputStream));
                        if (r1 != 0) {
                            r1.close();
                        }
                        if (dataInputStream != null) {
                            dataInputStream.close();
                        }
                        bufferedInputStream.close();
                        httpURLConnection2 = r1;
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                        httpURLConnection2 = r1;
                    }
                    return true;
                }
            }
            z = false;
            i2 = i;
            responseCode = httpURLConnection.getResponseCode();
            C0012k.m41c("IAP-SUtils", "HTTP response: " + responseCode);
            if (responseCode == 200) {
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean m2639af() {
        boolean isConnected = ((ConnectivityManager) getContext().getSystemService("connectivity")).getNetworkInfo(1).isConnected();
        C0012k.m39a("IAP-SUtils", "UsingWIFI: " + isConnected);
        return isConnected;
    }

    public static String m2640ag() {
        try {
            InputStream openRawResource = getContext().getResources().openRawResource(getContext().getResources().getIdentifier("serialkey", "raw", getContext().getPackageName()));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openRawResource, Charset.forName("UTF-8")));
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                readLine = "";
            }
            openRawResource.close();
            bufferedReader.close();
            return readLine;
        } catch (Exception e) {
            return "";
        }
    }

    public static int m2641ap(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static String[] m2642b(String[] strArr) {
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

    public static boolean m2643bq(String str) {
        return (str == null || str.equals("")) ? false : true;
    }

    public static String[] m2644c(Vector vector) {
        String[] strArr = new String[vector.size()];
        vector.copyInto(strArr);
        return strArr;
    }

    public static long m2645cG(String str) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            return -1L;
        }
    }

    public static float m2646cH(String str) {
        try {
            return Float.parseFloat(str.replace(',', '.'));
        } catch (NumberFormatException e) {
            return -1.0f;
        }
    }

    public static String m2647cH() {
        int abs = Math.abs(new Random().nextInt() % 9999);
        while (abs < 1000) {
            if (abs < 1000) {
                abs += PlacePickerFragment.DEFAULT_RADIUS_IN_METERS;
            }
        }
        return String.valueOf(abs);
    }

    private static long m2648cI(String str) {
        if (str == null || str.equals("")) {
            return 0L;
        }
        str.trim();
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(Integer.parseInt(str.substring(0, 4)) + "-" + Integer.parseInt(str.substring(5, 7)) + "-" + Integer.parseInt(str.substring(8, 10)) + " " + Integer.parseInt(str.substring(11, 13)) + ":" + Integer.parseInt(str.substring(14, 16)) + ":" + Integer.parseInt(str.substring(17, 19))).getTime();
        } catch (Exception e) {
            C0012k.m40b("IAP-SUtils", e.getMessage());
            return 0L;
        }
    }

    public static String m2649cJ(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            return String.format("%0" + (digest.length << 1) + "x", new BigInteger(1, digest));
        } catch (Exception e) {
            return null;
        }
    }

    public static String m2650cK(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.reset();
            messageDigest.update(str.getBytes("UTF-8"));
            byte[] digest = messageDigest.digest();
            for (byte b2 : digest) {
                stringBuffer.append(Integer.toString((b2 & 255) + 256, 16).substring(1));
            }
        } catch (Exception e) {
            C0012k.m40b("IAP-SUtils", e.getMessage());
        }
        return stringBuffer.toString();
    }

    public static Context getContext() {
        if (f2878dD == null) {
            C0012k.m40b("IAP-SUtils", "getContext currentContext NOT PREVIOUSLY SET!!!");
        }
        return f2878dD;
    }

    public static InputStream getResourceAsStream(String str) {
        try {
            return f2878dD.getAssets().open(str);
        } catch (Exception e) {
            return null;
        }
    }

    public static void setContext(Context context) {
        C0012k.m39a("IAP-SUtils", "Set context");
        f2878dD = context;
    }

    public static String m2651tb() {
        try {
            String str = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0).versionName;
            if (str != null) {
                if (!str.equals("")) {
                    return str;
                }
            }
            return "100";
        } catch (Exception e) {
            return "100";
        }
    }

    public static boolean m2652tc() {
        boolean isConnected = ((ConnectivityManager) getContext().getSystemService("connectivity")).getNetworkInfo(0).isConnected();
        C0012k.m39a("IAP-SUtils", "Using3G: " + isConnected);
        return isConnected;
    }

    public static boolean m2653td() {
        try {
            String str = Environment.getExternalStorageState().equals("mounted") ? Build.VERSION.SDK_INT >= 8 ? getContext().getExternalFilesDir(null) + "/IAPImages" : Environment.getDownloadCacheDirectory() + "/IAPImages" : null;
            if (str != null) {
                File file = new File(str);
                if (!file.exists()) {
                    file.mkdirs();
                } else if (!file.isDirectory()) {
                    file.delete();
                    file.mkdirs();
                }
            } else {
                C0012k.m41c("IAP-SUtils", "External Storage is not available");
            }
            C0490q m2528qA = C0463b.m2528qA();
            if (m2528qA == null) {
                return false;
            }
            int m2504ah = C0463b.m2504ah("Cash");
            for (int i = 0; i < m2504ah; i++) {
                C0483j m2664j = m2528qA.m2664j("Cash", i);
                if (m2664j != null) {
                    m2638a(m2664j.m2623sT(), str, m2664j.getId() + ".png", m2664j);
                    m2664j.m2615cB(str + "/" + m2664j.getId() + ".png");
                }
            }
            int m2504ah2 = C0463b.m2504ah("Coin");
            for (int i2 = 0; i2 < m2504ah2; i2++) {
                C0483j m2664j2 = m2528qA.m2664j("Coin", i2);
                if (m2664j2 != null) {
                    m2638a(m2664j2.m2623sT(), str, m2664j2.getId() + ".png", m2664j2);
                    m2664j2.m2615cB(str + "/" + m2664j2.getId() + ".png");
                }
            }
            C0012k.m41c("IAP-SUtils", ":::::::: Image Item downloaded successful...");
            return true;
        } catch (Exception e) {
            C0012k.m41c("IAP-SUtils", "Exception when download Image Item");
            C0012k.m40b("IAP-SUtils", e);
            return false;
        }
    }

    public static boolean m2654te() {
        try {
            C0490q m2528qA = C0463b.m2528qA();
            if (m2528qA != null && m2637a(m2528qA, "Cash")) {
                return m2637a(m2528qA, "Coin");
            }
            return false;
        } catch (Exception e) {
            C0012k.m41c("IAP-SUtils", "Exception when Load Image data: " + e);
            return false;
        }
    }

    public static String m2655z(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            stringBuffer.append(m2636a(str.charAt(i)));
        }
        return stringBuffer.toString();
    }
}
