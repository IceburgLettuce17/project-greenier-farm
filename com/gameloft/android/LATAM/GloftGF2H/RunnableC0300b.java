package com.gameloft.android.LATAM.GloftGF2H;

import android.os.Build;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.URL;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.security.SecureRandom;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.apache.http.HttpConnection;
import p001a.p004b.p005a.p006a.C0002a;

public final class RunnableC0300b implements Runnable {

    private static String f633dt = null;

    public String f634dA;

    private String f638dv;

    private Thread f637du = null;

    private HttpConnection f639dw = null;

    private HttpURLConnection f640dx = null;

    private HttpsURLConnection f641dy = null;

    private InputStream f642dz = null;

    boolean f635dB = false;

    public boolean f636dC = false;

    public RunnableC0300b() {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{new C0324d(this)}, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext.getSocketFactory());
            HttpsURLConnection.setDefaultHostnameVerifier(new C0323c(this));
        } catch (Exception e) {
            ("Exception Occurred on AUHTTP Constructor Method!!! " + e.toString()).toString();
        }
    }

    public final void cancel() {
        this.f642dz = null;
        this.f639dw = null;
        this.f637du = null;
        System.gc();
        this.f635dB = false;
    }

    public final void m832f(String str, String str2) {
        while (this.f635dB) {
            try {
                if (System.currentTimeMillis() - C0326f.f1911dI > 60000) {
                    cancel();
                }
                synchronized (this) {
                    wait(50L);
                }
            } catch (Exception e) {
            }
        }
        this.f635dB = true;
        this.f638dv = str + (str.indexOf("?") > 0 ? "&" : "?") + str2;
        if (C0326f.f1909dG.equals("TextHtml") || C0326f.f1909dG.equals("texthtml") || C0326f.f1909dG.equals("TEXTHTML")) {
            this.f638dv += "&texthtml=1";
        } else if (C0326f.f1909dG.equals("TextPlain") || C0326f.f1909dG.equals("textplain") || C0326f.f1909dG.equals("TEXTPLAIN")) {
            this.f638dv += "&textplain=1";
        }
        if (this.f637du != null) {
            try {
                this.f637du.join();
            } catch (Exception e2) {
            }
        }
        C0330j.m1981a(60000L);
        this.f636dC = false;
        this.f637du = new Thread(this);
        this.f637du.start();
    }

    public final boolean isInProgress() {
        return this.f635dB;
    }

    @Override
    public final void run() {
        String str;
        String str2;
        if (!(this.f638dv.indexOf("https") != -1)) {
            "********* NORMAL AUHTTP **********".toString();
            try {
                try {
                    this.f636dC = false;
                    ("AUHTTP: run:connecting to [" + this.f638dv + "]").toString();
                    String str3 = "UPDATE::AUHTTP::run:connecting to [" + this.f638dv + "]";
                    C0326f.m1966ai();
                    System.setProperty("http.keepAlive", "false");
                    URL url = new URL(this.f638dv);
                    ("AUHTTP: Proxy Enabled: false").toString();
                    String str4 = "UPDATE::AUHTTP::Proxy Enabled: false";
                    this.f640dx = (HttpURLConnection) url.openConnection();
                    this.f640dx.setRequestMethod("GET");
                    this.f640dx.setRequestProperty("Connection", "close");
                    HttpURLConnection httpURLConnection = this.f640dx;
                    C0326f.m1965ah();
                    httpURLConnection.setRequestProperty("User-Agent", C0332l.getUserAgent());
                    this.f640dx.setRequestProperty("x-gl-d", C0325e.m1960ag());
                    ("***** AUHTTP WIFI Warning: x-gl-d = " + C0325e.m1960ag()).toString();
                    String str5 = "UPDATE::AUHTTP::WIFI Warning: x-gl-d = " + C0325e.m1960ag();
                    String str6 = null;
                    try {
                        str6 = Build.MODEL;
                    } catch (Exception e) {
                    }
                    String encode = str6 == null ? "default-model" : URLEncoder.encode(str6.trim(), "UTF-8");
                    if (this.f638dv.startsWith("https://secure.gameloft.com/partners/android/update_check_hep.php")) {
                        this.f640dx.setRequestProperty("x-android-os-build-model", encode);
                    } else {
                        this.f640dx.setRequestProperty("x-android-os-build-model", Build.MODEL);
                    }
                    ("***** AUHTTP Warning: Adding " + Build.MODEL + " to http headers").toString();
                    String str7 = "UPDATE::AUHTTP::Warning: Adding " + Build.MODEL + " to http headers";
                    String str8 = "UPDATE::AUHTTP::Warning: build_model: " + encode;
                    String str9 = null;
                    try {
                        C0326f.m1965ah();
                        str9 = C0332l.m1986av();
                    } catch (Exception e2) {
                    }
                    String encode2 = str9 == null ? "00" : URLEncoder.encode(str9.trim(), "UTF-8");
                    if (this.f638dv.startsWith("https://secure.gameloft.com/partners/android/update_check_hep.php")) {
                        this.f640dx.setRequestProperty("x-up-gl-subno", encode2);
                    } else {
                        HttpURLConnection httpURLConnection2 = this.f640dx;
                        C0326f.m1965ah();
                        httpURLConnection2.setRequestProperty("x-up-gl-subno", C0332l.m1986av());
                    }
                    StringBuilder sb = new StringBuilder("***** AUHTTP Warning: x-up-gl-subno = ");
                    C0326f.m1965ah();
                    sb.append(C0332l.m1986av()).toString().toString();
                    StringBuilder sb2 = new StringBuilder("UPDATE::AUHTTP::Warning: x-up-gl-subno = ");
                    C0326f.m1965ah();
                    sb2.append(C0332l.m1986av()).toString();
                    String str10 = "UPDATE::AUHTTP::Warning: lineNumber: " + encode2;
                    if (this.f638dv.startsWith("https://secure.gameloft.com/partners/android/update_check_hep.php")) {
                        "***** HTTP AutoUpdate Request using safe imei".toString();
                        try {
                            C0326f.m1965ah();
                            str2 = C0332l.getDeviceId();
                        } catch (Exception e3) {
                            str2 = "00000000000000";
                        }
                        if (str2 == null) {
                            str2 = "00000000000000";
                        }
                        this.f640dx.setRequestProperty("x-up-gl-imei", str2);
                        ("***** HTTPS Warning: x-up-gl-imei = " + str2).toString();
                        String str11 = "UPDATE::AUHTTP::Warning: x-up-gl-imei = " + str2;
                    } else {
                        HttpURLConnection httpURLConnection3 = this.f640dx;
                        C0326f.m1965ah();
                        httpURLConnection3.setRequestProperty("x-up-gl-imei", C0332l.m1985au());
                        StringBuilder sb3 = new StringBuilder("***** HTTPS Warning: x-up-gl-imei = ");
                        C0326f.m1965ah();
                        sb3.append(C0332l.m1985au()).toString().toString();
                        StringBuilder sb4 = new StringBuilder("UPDATE::AUHTTP::Warning: x-up-gl-imei = ");
                        C0326f.m1965ah();
                        sb4.append(C0332l.m1985au()).toString();
                    }
                    if (this.f638dv.contains("gettimestamprequest=1")) {
                        "***** HTTPS Warning:  adding time = 1 to the headers".toString();
                        this.f640dx.setRequestProperty("time", "1");
                    }
                    "AUHTTP: run: receive".toString();
                } catch (SocketException e4) {
                    C0002a.m6a(e4);
                    ("AUHTTP: run: SocketException : " + e4.toString()).toString();
                    String str12 = "UPDATE::AUHTTP::run: SocketException : " + e4.toString();
                    this.f636dC = true;
                    this.f635dB = false;
                    C0326f.m1964E(-2);
                } catch (UnknownHostException e5) {
                    C0002a.m6a(e5);
                    ("AUHTTP: run: UnknownHostException : " + e5.toString()).toString();
                    String str13 = "UPDATE::AUHTTP::run: UnknownHostException : " + e5.toString();
                    this.f636dC = true;
                    this.f635dB = false;
                    C0326f.m1964E(-2);
                }
            } catch (Exception e6) {
                C0002a.m6a(e6);
                ("AUHTTP: run: exception : " + e6.toString()).toString();
                String str14 = "UPDATE::AUHTTP::run: exception : " + e6.toString();
                this.f636dC = true;
                this.f635dB = false;
            }
            if (this.f640dx.getResponseCode() != 200) {
                ("AUHTTP RESPONSE CODE RECEIVED = " + this.f640dx.getResponseCode()).toString();
                String str15 = "UPDATE::AUHTTP::RESPONSE CODE RECEIVED = " + this.f640dx.getResponseCode();
                cancel();
                this.f636dC = true;
                this.f635dB = false;
                C0330j.stop();
                return;
            }
            synchronized (this.f640dx) {
                this.f642dz = this.f640dx.getInputStream();
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[16];
            int i = 0;
            while (i != -1) {
                i = this.f642dz.read(bArr, 0, 16);
                if (i != -1) {
                    byteArrayOutputStream.write(bArr, 0, i);
                }
            }
            ("AUHTTP: run: received [\n" + byteArrayOutputStream.toString() + "\n]").toString();
            String str16 = "UPDATE::AUHTTP::run: received [\n" + byteArrayOutputStream.toString() + "\n]";
            ("AUHTTP: run: total bytes read: [" + byteArrayOutputStream.size() + "]").toString();
            String str17 = "UPDATE::AUHTTP::run: total bytes read: [" + byteArrayOutputStream.size() + "]";
            this.f634dA = byteArrayOutputStream.toString();
            cancel();
            this.f635dB = false;
            C0330j.stop();
            return;
        }
        "********* SECURED HTTPS **********".toString();
        try {
            try {
                this.f636dC = false;
                ("HTTPS: run:connecting to [" + this.f638dv + "]").toString();
                String str18 = "UPDATE::AUHTTP::run:connecting to [" + this.f638dv + "]";
                C0326f.m1966ai();
                System.setProperty("http.keepAlive", "false");
                URL url2 = new URL(this.f638dv);
                ("HTTPS: Proxy Enabled: false").toString();
                String str19 = "UPDATE::AUHTTP::Proxy Enabled: false";
                this.f641dy = (HttpsURLConnection) url2.openConnection();
                this.f641dy.setRequestMethod("GET");
                if (Integer.parseInt(Build.VERSION.SDK) != 8) {
                    this.f641dy.setRequestProperty("Connection", "close");
                }
                HttpsURLConnection httpsURLConnection = this.f641dy;
                C0326f.m1965ah();
                httpsURLConnection.setRequestProperty("User-Agent", C0332l.getUserAgent());
                StringBuilder sb5 = new StringBuilder("UPDATE::AUHTTP::Warning: User-Agent = ");
                C0326f.m1965ah();
                sb5.append(C0332l.getUserAgent()).toString();
                this.f641dy.setRequestProperty("x-gl-d", C0325e.m1960ag());
                ("***** HTTPS WIFI Warning: x-gl-d = " + C0325e.m1960ag()).toString();
                String str20 = "UPDATE::AUHTTP::WIFI Warning: x-gl-d = " + C0325e.m1960ag();
                String str21 = null;
                try {
                    str21 = Build.MODEL;
                } catch (Exception e7) {
                }
                String encode3 = str21 == null ? "default-model" : URLEncoder.encode(str21.trim(), "UTF-8");
                if (this.f638dv.startsWith("https://secure.gameloft.com/partners/android/update_check_hep.php")) {
                    this.f641dy.setRequestProperty("x-android-os-build-model", encode3);
                } else {
                    this.f641dy.setRequestProperty("x-android-os-build-model", Build.MODEL);
                }
                ("***** HTTPS Warning: Adding " + Build.MODEL + " to http headers").toString();
                String str22 = "UPDATE::AUHTTP::Warning: Adding " + Build.MODEL + " to http headers";
                String str23 = "UPDATE::AUHTTP::Warning: build_model: " + encode3;
                String str24 = null;
                try {
                    C0326f.m1965ah();
                    str24 = C0332l.m1986av();
                } catch (Exception e8) {
                }
                String encode4 = str24 == null ? "00" : URLEncoder.encode(str24.trim(), "UTF-8");
                if (this.f638dv.startsWith("https://secure.gameloft.com/partners/android/update_check_hep.php")) {
                    this.f641dy.setRequestProperty("x-up-gl-subno", encode4);
                } else {
                    HttpsURLConnection httpsURLConnection2 = this.f641dy;
                    C0326f.m1965ah();
                    httpsURLConnection2.setRequestProperty("x-up-gl-subno", C0332l.m1986av());
                }
                StringBuilder sb6 = new StringBuilder("***** HTTPS Warning: x-up-gl-subno = ");
                C0326f.m1965ah();
                sb6.append(C0332l.m1986av()).toString().toString();
                StringBuilder sb7 = new StringBuilder("UPDATE::AUHTTP::Warning: x-up-gl-subno = ");
                C0326f.m1965ah();
                sb7.append(C0332l.m1986av()).toString();
                String str25 = "UPDATE::AUHTTP::Warning: lineNumber: " + encode4;
                if (this.f638dv.startsWith("https://secure.gameloft.com/partners/android/update_check_hep.php")) {
                    "***** HTTP AutoUpdate Request using safe imei".toString();
                    try {
                        C0326f.m1965ah();
                        str = C0332l.getDeviceId();
                    } catch (Exception e9) {
                        str = "00000000000000";
                    }
                    if (str == null) {
                        str = "00000000000000";
                    }
                    this.f641dy.setRequestProperty("x-up-gl-imei", str);
                    ("***** HTTPS Warning: x-up-gl-imei = " + str).toString();
                    String str26 = "UPDATE::AUHTTP::Warning: x-up-gl-imei = " + str;
                } else {
                    HttpsURLConnection httpsURLConnection3 = this.f641dy;
                    C0326f.m1965ah();
                    httpsURLConnection3.setRequestProperty("x-up-gl-imei", C0332l.m1985au());
                    StringBuilder sb8 = new StringBuilder("***** HTTPS Warning: x-up-gl-imei = ");
                    C0326f.m1965ah();
                    sb8.append(C0332l.m1985au()).toString().toString();
                    StringBuilder sb9 = new StringBuilder("UPDATE::AUHTTP::Warning: x-up-gl-imei = ");
                    C0326f.m1965ah();
                    sb9.append(C0332l.m1985au()).toString();
                }
                if (this.f638dv.contains("gettimestamprequest=1")) {
                    this.f641dy.setRequestProperty("time", "1");
                }
                "HTTPS: run: receive".toString();
            } catch (SocketException e10) {
                C0002a.m6a(e10);
                ("HTTPS: run: SocketException : " + e10.toString()).toString();
                String str27 = "UPDATE::AUHTTP::run: SocketException : " + e10.toString();
                this.f636dC = true;
                this.f635dB = false;
                C0326f.m1964E(-2);
            } catch (UnknownHostException e11) {
                C0002a.m6a(e11);
                ("HTTPS: run: UnknownHostException : " + e11.toString()).toString();
                String str28 = "UPDATE::AUHTTP::run: UnknownHostException : " + e11.toString();
                this.f636dC = true;
                this.f635dB = false;
                C0326f.m1964E(-2);
            }
        } catch (Exception e12) {
            C0002a.m6a(e12);
            ("HTTPS: run: exception : " + e12.toString()).toString();
            String str29 = "UPDATE::AUHTTP::run: exception : " + e12.toString();
            this.f636dC = true;
            this.f635dB = false;
        }
        if (this.f641dy.getResponseCode() != 200) {
            ("HTTPS RESPONSE CODE RECEIVED = " + this.f641dy.getResponseCode()).toString();
            String str30 = "UPDATE::AUHTTP::RESPONSE CODE RECEIVED = " + this.f641dy.getResponseCode();
            cancel();
            this.f636dC = true;
            this.f635dB = false;
            C0330j.stop();
            return;
        }
        synchronized (this.f641dy) {
            this.f642dz = this.f641dy.getInputStream();
        }
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        byte[] bArr2 = new byte[16];
        int i2 = 0;
        while (i2 != -1) {
            i2 = this.f642dz.read(bArr2, 0, 16);
            if (i2 != -1) {
                byteArrayOutputStream2.write(bArr2, 0, i2);
            }
        }
        ("HTTPS: run: total bytes read: [" + byteArrayOutputStream2.size() + "]").toString();
        String str31 = "UPDATE::AUHTTP::run: total bytes read: [" + byteArrayOutputStream2.size() + "]";
        this.f634dA = byteArrayOutputStream2.toString();
        String[] split = this.f634dA.split("\n");
        "HTTPS: run: received [\n".toString();
        for (int i3 = 0; i3 < split.length; i3++) {
            split[i3].toString();
            String str32 = "UPDATE::AUHTTP::" + split[i3];
        }
        "]".toString();
        this.f641dy.disconnect();
        cancel();
        this.f635dB = false;
        C0330j.stop();
    }
}
