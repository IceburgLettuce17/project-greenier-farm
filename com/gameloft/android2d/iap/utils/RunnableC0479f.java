package com.gameloft.android2d.iap.utils;

import android.os.Build;
import com.gameloft.android2d.iap.C0463b;
import com.gameloft.android2d.iap.p042a.p051h.C0414f;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.SecureRandom;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.apache.http.HttpConnection;
import p001a.p004b.p005a.p006a.C0012k;

public final class RunnableC0479f implements Runnable {

    public String f2868dA;

    private String f2872dv;

    private Thread f2871du = null;

    private HttpConnection f2873dw = null;

    private HttpURLConnection f2874dx = null;

    private HttpsURLConnection f2875dy = null;

    private InputStream f2876dz = null;

    boolean f2869dB = false;

    public boolean f2870dC = false;

    public RunnableC0479f() {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{new C0481h(this)}, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext.getSocketFactory());
            HttpsURLConnection.setDefaultHostnameVerifier(new C0480g(this));
        } catch (Exception e) {
            C0012k.m39a("IAP-HTTP", "Exception Occurred on HTTP Constructor Method!!! " + e.toString());
        }
    }

    private static StringBuilder m2606g(InputStream inputStream) {
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return sb;
            }
            sb.append(readLine);
        }
    }

    public final void cancel() {
        this.f2876dz = null;
        this.f2873dw = null;
        this.f2871du = null;
        System.gc();
        this.f2869dB = false;
    }

    public final void m2607f(String str, String str2) {
        while (this.f2869dB) {
            try {
                if (System.currentTimeMillis() - C0491r.f2882dI > 60000) {
                    cancel();
                }
                synchronized (this) {
                    wait(50L);
                }
            } catch (Exception e) {
            }
        }
        this.f2869dB = true;
        if (str.indexOf("?") != -1) {
            this.f2872dv = str + "&" + str2;
        } else {
            this.f2872dv = str + "?" + str2;
        }
        if (C0491r.f2881dG.equals("TextHtml") || C0491r.f2881dG.equals("texthtml") || C0491r.f2881dG.equals("TEXTHTML")) {
            this.f2872dv += "&texthtml=1";
        } else if (C0491r.f2881dG.equals("TextPlain") || C0491r.f2881dG.equals("textplain") || C0491r.f2881dG.equals("TEXTPLAIN")) {
            this.f2872dv += "&textplain=1";
        }
        if (this.f2871du != null) {
            try {
                this.f2871du.join();
            } catch (Exception e2) {
            }
        }
        C0475b.m2584a(60000L);
        this.f2870dC = false;
        this.f2871du = new Thread(this);
        this.f2871du.start();
    }

    public final boolean isInProgress() {
        return this.f2869dB;
    }

    @Override
    public final void run() {
        if (!(this.f2872dv.indexOf("https") != -1)) {
            C0012k.m39a("IAP-HTTP", "********* NORMAL HTTP **********");
            try {
                this.f2870dC = false;
                C0012k.m39a("IAP-HTTP", "HTTP: run:connecting to [" + this.f2872dv + "]");
                C0474a m2680sM = C0491r.m2680sM();
                System.setProperty("http.keepAlive", "false");
                URL url = new URL(this.f2872dv);
                C0012k.m39a("IAP-HTTP", "HTTP: Proxy Enabled: " + m2680sM.f2851dJ);
                if (m2680sM.f2851dJ && C0488o.m2652tc()) {
                    C0012k.m39a("IAP-HTTP", "HTTP: Proxy server: " + m2680sM.f2852dK);
                    C0012k.m39a("IAP-HTTP", "HTTP: Proxy port:   " + m2680sM.f2853dL);
                    this.f2874dx = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(InetAddress.getByName(m2680sM.f2852dK), m2680sM.f2853dL)));
                } else {
                    this.f2874dx = (HttpURLConnection) url.openConnection();
                }
                this.f2874dx.setRequestMethod("GET");
                this.f2874dx.setRequestProperty("Connection", "close");
                if (C0463b.f2789YE == null || C0463b.f2789YE.equals("")) {
                    StringBuilder sb = new StringBuilder("***** HTTP Info: use device UserAgent ");
                    C0491r.m2681tf();
                    C0012k.m39a("IAP-HTTP", sb.append(C0477d.getUserAgent()).toString());
                    HttpURLConnection httpURLConnection = this.f2874dx;
                    C0491r.m2681tf();
                    httpURLConnection.setRequestProperty("User-Agent", C0477d.getUserAgent());
                } else {
                    C0012k.m39a("IAP-HTTP", "***** HTTP Warning: hardCode UserAgent " + C0463b.f2789YE);
                    this.f2874dx.setRequestProperty("User-Agent", C0463b.f2789YE);
                }
                this.f2874dx.setRequestProperty("x-android-os-build-model", Build.MODEL);
                C0012k.m39a("IAP-HTTP", "***** HTTP Warning: Adding " + Build.MODEL + " to http headers");
                HttpURLConnection httpURLConnection2 = this.f2874dx;
                C0491r.m2681tf();
                httpURLConnection2.setRequestProperty("x-up-gl-subno", C0477d.m2589av());
                StringBuilder sb2 = new StringBuilder("***** HTTP Warning: x-up-gl-subno = ");
                C0491r.m2681tf();
                C0012k.m39a("IAP-HTTP", sb2.append(C0477d.m2589av()).toString());
                if (C0463b.m2545qR() != 2) {
                    HttpURLConnection httpURLConnection3 = this.f2874dx;
                    C0491r.m2681tf();
                    httpURLConnection3.setRequestProperty("x-up-gl-imei", C0477d.m2588au());
                    StringBuilder sb3 = new StringBuilder("***** HTTP Warning: x-up-gl-imei = ");
                    C0491r.m2681tf();
                    C0012k.m39a("IAP-HTTP", sb3.append(C0477d.m2588au()).toString());
                }
                if (C0463b.m2545qR() != 0) {
                    HttpURLConnection httpURLConnection4 = this.f2874dx;
                    C0491r.m2681tf();
                    httpURLConnection4.setRequestProperty("x-up-gl-hdidfv", C0477d.m2592qe());
                    StringBuilder sb4 = new StringBuilder("***** HTTP Warning: x-up-gl-hdidfv = ");
                    C0491r.m2681tf();
                    C0012k.m39a("IAP-HTTP", sb4.append(C0477d.m2592qe()).toString());
                }
                if (C0488o.m2639af()) {
                    if (C0488o.m2640ag() != null) {
                        this.f2874dx.setRequestProperty("x-gl-d", C0488o.m2640ag());
                        C0012k.m39a("IAP-HTTP", "***** HTTP WIFI Warning: x-gl-d = " + C0488o.m2640ag());
                    }
                    HttpURLConnection httpURLConnection5 = this.f2874dx;
                    C0491r.m2681tf();
                    httpURLConnection5.setRequestProperty("x-up-calling-line-id", C0477d.m2589av());
                    StringBuilder sb5 = new StringBuilder("***** HTTP WIFI Warning: x-up-calling-line-id = ");
                    C0491r.m2681tf();
                    C0012k.m39a("IAP-HTTP", sb5.append(C0477d.m2589av()).toString());
                    HttpURLConnection httpURLConnection6 = this.f2874dx;
                    C0491r.m2681tf();
                    httpURLConnection6.setRequestProperty("x-up-gl-msisdn", C0477d.m2589av());
                    StringBuilder sb6 = new StringBuilder("***** HTTP WIFI Warning: x-up-gl-msisdn = ");
                    C0491r.m2681tf();
                    C0012k.m39a("IAP-HTTP", sb6.append(C0477d.m2589av()).toString());
                }
                this.f2874dx.setRequestProperty("x-up-gl-acnum", System.getProperty("UserName"));
                C0012k.m39a("IAP-HTTP", "***** HTTP WIFI Warning: x-up-gl-acnum = " + System.getProperty("UserName"));
                HttpURLConnection httpURLConnection7 = this.f2874dx;
                C0491r.m2681tf();
                httpURLConnection7.setRequestProperty("x-up-gl-sim-operator", C0477d.getSimOperator());
                StringBuilder sb7 = new StringBuilder("***** HTTP WIFI Warning: x-up-gl-sim-operator = ");
                C0491r.m2681tf();
                C0012k.m39a("IAP-HTTP", sb7.append(C0477d.getSimOperator()).toString());
                HttpURLConnection httpURLConnection8 = this.f2874dx;
                C0491r.m2681tf();
                httpURLConnection8.setRequestProperty("x-up-gl-sim-operator-name", C0477d.getSimOperatorName());
                StringBuilder sb8 = new StringBuilder("***** HTTP WIFI Warning: x-up-gl-sim-operator-name = ");
                C0491r.m2681tf();
                C0012k.m39a("IAP-HTTP", sb8.append(C0477d.getSimOperatorName()).toString());
                HttpURLConnection httpURLConnection9 = this.f2874dx;
                C0491r.m2681tf();
                httpURLConnection9.setRequestProperty("x-up-gl-sim-country-iso", C0477d.getSimCountryIso());
                StringBuilder sb9 = new StringBuilder("***** HTTP WIFI Warning: x-up-gl-sim-country-iso = ");
                C0491r.m2681tf();
                C0012k.m39a("IAP-HTTP", sb9.append(C0477d.getSimCountryIso()).toString());
                HttpURLConnection httpURLConnection10 = this.f2874dx;
                C0491r.m2681tf();
                httpURLConnection10.setRequestProperty("x-up-gl-network-operator", C0477d.getNetworkOperator());
                StringBuilder sb10 = new StringBuilder("***** HTTP WIFI Warning: x-up-gl-network-operator = ");
                C0491r.m2681tf();
                C0012k.m39a("IAP-HTTP", sb10.append(C0477d.getNetworkOperator()).toString());
                HttpURLConnection httpURLConnection11 = this.f2874dx;
                C0491r.m2681tf();
                httpURLConnection11.setRequestProperty("x-up-gl-network-operator-name", C0477d.getNetworkOperatorName());
                StringBuilder sb11 = new StringBuilder("***** HTTP WIFI Warning: x-up-gl-network-operator-name = ");
                C0491r.m2681tf();
                C0012k.m39a("IAP-HTTP", sb11.append(C0477d.getNetworkOperatorName()).toString());
                HttpURLConnection httpURLConnection12 = this.f2874dx;
                C0491r.m2681tf();
                httpURLConnection12.setRequestProperty("x-up-gl-network-country-iso", C0477d.getNetworkCountryIso());
                StringBuilder sb12 = new StringBuilder("***** HTTP WIFI Warning: x-up-gl-network-country-iso = ");
                C0491r.m2681tf();
                C0012k.m39a("IAP-HTTP", sb12.append(C0477d.getNetworkCountryIso()).toString());
                HttpURLConnection httpURLConnection13 = this.f2874dx;
                StringBuilder sb13 = new StringBuilder();
                C0491r.m2681tf();
                httpURLConnection13.setRequestProperty("x-up-gl-is-network-roaming", sb13.append(C0477d.m2603sL()).toString());
                StringBuilder sb14 = new StringBuilder("***** HTTP WIFI Warning: x-up-gl-is-network-roaming = ");
                C0491r.m2681tf();
                C0012k.m39a("IAP-HTTP", sb14.append(C0477d.m2603sL()).toString());
                this.f2874dx.setRequestProperty("time", "1");
                C0012k.m39a("IAP-HTTP", "***** HTTP WIFI Warning: time = 1");
                this.f2874dx.setRequestProperty("x-up-gl-ggi", "0");
                C0012k.m39a("IAP-HTTP", "***** HTTP WIFI Warning: x-up-gl-ggi = 0");
                this.f2874dx.setRequestProperty("x-up-gl-purchaseid", C0414f.m2400sn());
                C0012k.m39a("IAP-HTTP", "***** HTTP WIFI Warning: x-up-gl-purchaseid = " + C0414f.m2400sn());
                C0012k.m39a("IAP-HTTP", "HTTP: run: receive");
            } catch (SocketException e) {
                C0012k.m38a(e);
                C0012k.m39a("IAP-HTTP", "HTTP: run: SocketException : " + e.toString());
                this.f2870dC = true;
                this.f2869dB = false;
                C0491r.m2665E(-2);
            } catch (UnknownHostException e2) {
                C0012k.m38a(e2);
                C0012k.m39a("IAP-HTTP", "HTTP: run: UnknownHostException : " + e2.toString());
                this.f2870dC = true;
                this.f2869dB = false;
                C0491r.m2665E(-2);
            } catch (Exception e3) {
                C0012k.m38a(e3);
                C0012k.m39a("IAP-HTTP", "HTTP: run: exception : " + e3.toString());
                this.f2870dC = true;
                this.f2869dB = false;
            }
            if (this.f2874dx.getResponseCode() != 200) {
                C0012k.m39a("IAP-HTTP", "HTTP RESPONSE CODE RECEIVED = " + this.f2874dx.getResponseCode());
                if (this.f2875dy.getResponseCode() == 429 || this.f2875dy.getResponseCode() == 403) {
                    C0491r.m2665E(this.f2875dy.getResponseCode());
                    C0491r.m2676cS(m2606g(this.f2875dy.getErrorStream()).toString());
                }
                cancel();
                this.f2870dC = true;
                this.f2869dB = false;
                C0475b.stop();
                return;
            }
            synchronized (this.f2874dx) {
                this.f2876dz = this.f2874dx.getInputStream();
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[16];
            int i = 0;
            while (i != -1) {
                i = this.f2876dz.read(bArr, 0, 16);
                if (i != -1) {
                    byteArrayOutputStream.write(bArr, 0, i);
                }
            }
            C0012k.m39a("IAP-HTTP", "HTTP: run: received [\n" + byteArrayOutputStream.toString() + "\n]");
            C0012k.m39a("IAP-HTTP", "HTTP: run: total bytes read: [" + byteArrayOutputStream.size() + "]");
            this.f2868dA = byteArrayOutputStream.toString();
            cancel();
            this.f2869dB = false;
            C0475b.stop();
            return;
        }
        C0012k.m39a("HTTP", "********* SECURED HTTPS **********");
        try {
            this.f2870dC = false;
            C0012k.m39a("IAP-HTTP", "HTTPS: run:connecting to [" + this.f2872dv + "]");
            C0474a m2680sM2 = C0491r.m2680sM();
            System.setProperty("http.keepAlive", "false");
            URL url2 = new URL(this.f2872dv);
            C0012k.m39a("IAP-HTTP", "HTTPS: Proxy Enabled: " + m2680sM2.f2851dJ);
            if (m2680sM2.f2851dJ && C0488o.m2652tc()) {
                C0012k.m39a("IAP-HTTP", "HTTPS: Proxy server: " + m2680sM2.f2852dK);
                C0012k.m39a("IAP-HTTP", "HTTPS: Proxy port:   " + m2680sM2.f2853dL);
                this.f2875dy = (HttpsURLConnection) url2.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(InetAddress.getByName(m2680sM2.f2852dK), m2680sM2.f2853dL)));
            } else {
                this.f2875dy = (HttpsURLConnection) url2.openConnection();
            }
            this.f2875dy.setRequestMethod("GET");
            this.f2875dy.setRequestProperty("Connection", "close");
            if (C0463b.f2789YE == null || C0463b.f2789YE.equals("")) {
                StringBuilder sb15 = new StringBuilder("***** HTTPS Info: use device UserAgent ");
                C0491r.m2681tf();
                C0012k.m39a("IAP-HTTP", sb15.append(C0477d.getUserAgent()).toString());
                HttpsURLConnection httpsURLConnection = this.f2875dy;
                C0491r.m2681tf();
                httpsURLConnection.setRequestProperty("User-Agent", C0477d.getUserAgent());
            } else {
                C0012k.m39a("IAP-HTTP", "***** HTTPS Warning: hardCode UserAgent " + C0463b.f2789YE);
                this.f2875dy.setRequestProperty("User-Agent", C0463b.f2789YE);
            }
            this.f2875dy.setRequestProperty("x-android-os-build-model", Build.MODEL);
            C0012k.m39a("IAP-HTTP", "***** HTTPS Warning: Adding " + Build.MODEL + " to http headers");
            HttpsURLConnection httpsURLConnection2 = this.f2875dy;
            C0491r.m2681tf();
            httpsURLConnection2.setRequestProperty("x-up-gl-subno", C0477d.m2589av());
            StringBuilder sb16 = new StringBuilder("***** HTTPS Warning: x-up-gl-subno = ");
            C0491r.m2681tf();
            C0012k.m39a("IAP-HTTP", sb16.append(C0477d.m2589av()).toString());
            if (C0463b.m2545qR() != 2) {
                HttpsURLConnection httpsURLConnection3 = this.f2875dy;
                C0491r.m2681tf();
                httpsURLConnection3.setRequestProperty("x-up-gl-imei", C0477d.m2588au());
                StringBuilder sb17 = new StringBuilder("***** HTTPS Warning: x-up-gl-imei = ");
                C0491r.m2681tf();
                C0012k.m39a("IAP-HTTP", sb17.append(C0477d.m2588au()).toString());
            }
            if (C0463b.m2545qR() != 0) {
                HttpsURLConnection httpsURLConnection4 = this.f2875dy;
                C0491r.m2681tf();
                httpsURLConnection4.setRequestProperty("x-up-gl-hdidfv", C0477d.m2592qe());
                StringBuilder sb18 = new StringBuilder("***** HTTPS Warning: x-up-gl-hdidfv = ");
                C0491r.m2681tf();
                C0012k.m39a("IAP-HTTP", sb18.append(C0477d.m2592qe()).toString());
            }
            if (C0488o.m2639af()) {
                if (C0488o.m2640ag() != null) {
                    this.f2875dy.setRequestProperty("x-gl-d", C0488o.m2640ag());
                    C0012k.m39a("IAP-HTTP", "***** HTTPS WIFI Warning: x-gl-d = " + C0488o.m2640ag());
                }
                HttpsURLConnection httpsURLConnection5 = this.f2875dy;
                C0491r.m2681tf();
                httpsURLConnection5.setRequestProperty("x-up-calling-line-id", C0477d.m2589av());
                StringBuilder sb19 = new StringBuilder("***** HTTPS WIFI Warning: x-up-calling-line-id = ");
                C0491r.m2681tf();
                C0012k.m39a("IAP-HTTP", sb19.append(C0477d.m2589av()).toString());
                HttpsURLConnection httpsURLConnection6 = this.f2875dy;
                C0491r.m2681tf();
                httpsURLConnection6.setRequestProperty("x-up-gl-msisdn", C0477d.m2589av());
                StringBuilder sb20 = new StringBuilder("***** HTTPS WIFI Warning: x-up-gl-msisdn = ");
                C0491r.m2681tf();
                C0012k.m39a("IAP-HTTP", sb20.append(C0477d.m2589av()).toString());
            }
            this.f2875dy.setRequestProperty("x-up-gl-acnum", System.getProperty("UserName"));
            C0012k.m39a("IAP-HTTP", "***** HTTPS WIFI Warning: x-up-gl-acnum = " + System.getProperty("UserName"));
            HttpsURLConnection httpsURLConnection7 = this.f2875dy;
            C0491r.m2681tf();
            httpsURLConnection7.setRequestProperty("x-up-gl-sim-operator", C0477d.getSimOperator());
            StringBuilder sb21 = new StringBuilder("***** HTTPS WIFI Warning: x-up-gl-sim-operator = ");
            C0491r.m2681tf();
            C0012k.m39a("IAP-HTTP", sb21.append(C0477d.getSimOperator()).toString());
            HttpsURLConnection httpsURLConnection8 = this.f2875dy;
            C0491r.m2681tf();
            httpsURLConnection8.setRequestProperty("x-up-gl-sim-operator-name", C0477d.getSimOperatorName());
            StringBuilder sb22 = new StringBuilder("***** HTTPS WIFI Warning: x-up-gl-sim-operator-name = ");
            C0491r.m2681tf();
            C0012k.m39a("IAP-HTTP", sb22.append(C0477d.getSimOperatorName()).toString());
            HttpsURLConnection httpsURLConnection9 = this.f2875dy;
            C0491r.m2681tf();
            httpsURLConnection9.setRequestProperty("x-up-gl-sim-country-iso", C0477d.getSimCountryIso());
            StringBuilder sb23 = new StringBuilder("***** HTTPS WIFI Warning: x-up-gl-sim-country-iso = ");
            C0491r.m2681tf();
            C0012k.m39a("IAP-HTTP", sb23.append(C0477d.getSimCountryIso()).toString());
            HttpsURLConnection httpsURLConnection10 = this.f2875dy;
            C0491r.m2681tf();
            httpsURLConnection10.setRequestProperty("x-up-gl-network-operator", C0477d.getNetworkOperator());
            StringBuilder sb24 = new StringBuilder("***** HTTPS WIFI Warning: x-up-gl-network-operator = ");
            C0491r.m2681tf();
            C0012k.m39a("IAP-HTTP", sb24.append(C0477d.getNetworkOperator()).toString());
            HttpsURLConnection httpsURLConnection11 = this.f2875dy;
            C0491r.m2681tf();
            httpsURLConnection11.setRequestProperty("x-up-gl-network-operator-name", C0477d.getNetworkOperatorName());
            StringBuilder sb25 = new StringBuilder("***** HTTPS WIFI Warning: x-up-gl-network-operator-name = ");
            C0491r.m2681tf();
            C0012k.m39a("IAP-HTTP", sb25.append(C0477d.getNetworkOperatorName()).toString());
            HttpsURLConnection httpsURLConnection12 = this.f2875dy;
            C0491r.m2681tf();
            httpsURLConnection12.setRequestProperty("x-up-gl-network-country-iso", C0477d.getNetworkCountryIso());
            StringBuilder sb26 = new StringBuilder("***** HTTPS WIFI Warning: x-up-gl-network-country-iso = ");
            C0491r.m2681tf();
            C0012k.m39a("IAP-HTTP", sb26.append(C0477d.getNetworkCountryIso()).toString());
            HttpsURLConnection httpsURLConnection13 = this.f2875dy;
            StringBuilder sb27 = new StringBuilder();
            C0491r.m2681tf();
            httpsURLConnection13.setRequestProperty("x-up-gl-is-network-roaming", sb27.append(C0477d.m2603sL()).toString());
            StringBuilder sb28 = new StringBuilder("***** HTTPS WIFI Warning: x-up-gl-is-network-roaming = ");
            C0491r.m2681tf();
            C0012k.m39a("IAP-HTTP", sb28.append(C0477d.m2603sL()).toString());
            this.f2875dy.setRequestProperty("time", "1");
            C0012k.m39a("IAP-HTTP", "***** HTTPS WIFI Warning: time = 1");
            this.f2875dy.setRequestProperty("x-up-gl-ggi", "0");
            C0012k.m39a("IAP-HTTP", "***** HTTPS WIFI Warning: x-up-gl-ggi = 0");
            this.f2875dy.setRequestProperty("x-up-gl-purchaseid", C0414f.m2400sn());
            C0012k.m39a("IAP-HTTP", "***** HTTPS WIFI Warning: x-up-gl-purchaseid = " + C0414f.m2400sn());
            C0012k.m39a("IAP-HTTP", "HTTPS: run: receive");
        } catch (SocketException e4) {
            C0012k.m38a(e4);
            C0012k.m39a("IAP-HTTP", "HTTPS: run: SocketException : " + e4.toString());
            this.f2870dC = true;
            this.f2869dB = false;
            C0491r.m2665E(-2);
        } catch (UnknownHostException e5) {
            C0012k.m38a(e5);
            C0012k.m39a("IAP-HTTP", "HTTPS: run: UnknownHostException : " + e5.toString());
            this.f2870dC = true;
            this.f2869dB = false;
            C0491r.m2665E(-2);
        } catch (Exception e6) {
            C0012k.m38a(e6);
            C0012k.m39a("IAP-HTTP", "HTTPS: run: exception : " + e6.toString());
            this.f2870dC = true;
            this.f2869dB = false;
        }
        if (this.f2875dy.getResponseCode() != 200) {
            C0012k.m39a("IAP-HTTP", "HTTPS RESPONSE CODE RECEIVED = " + this.f2875dy.getResponseCode());
            if (this.f2875dy.getResponseCode() == 429 || this.f2875dy.getResponseCode() == 403) {
                C0491r.m2665E(this.f2875dy.getResponseCode());
                C0491r.m2676cS(m2606g(this.f2875dy.getErrorStream()).toString());
            }
            cancel();
            this.f2870dC = true;
            this.f2869dB = false;
            C0475b.stop();
            return;
        }
        synchronized (this.f2875dy) {
            this.f2876dz = this.f2875dy.getInputStream();
        }
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        byte[] bArr2 = new byte[16];
        int i2 = 0;
        while (i2 != -1) {
            i2 = this.f2876dz.read(bArr2, 0, 16);
            if (i2 != -1) {
                byteArrayOutputStream2.write(bArr2, 0, i2);
            }
        }
        C0012k.m39a("IAP-HTTP", "HTTPS: run: total bytes read: [" + byteArrayOutputStream2.size() + "]");
        this.f2868dA = byteArrayOutputStream2.toString();
        String[] split = this.f2868dA.split("\n");
        C0012k.m39a("IAP-HTTP", "HTTPS: run: received ######################[\n");
        for (String str : split) {
            C0012k.m39a("IAP-HTTP", str);
        }
        C0012k.m39a("IAP-HTTP", "] end feed.#################");
        cancel();
        this.f2869dB = false;
        C0475b.stop();
    }
}
