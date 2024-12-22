package com.gameloft.android.LATAM.GloftGF2H;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.gameloft.android.LATAM.GloftGF2H.p041a.C0273b;
import com.gameloft.android.wrapper.C0349c;
import com.gameloft.android.wrapper.C0355i;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
import p009b.p010a.p012b.DialogC0064m;
import p009b.p010a.p015d.AbstractActivityC0092a;

public class SplashScreenActivity extends DialogC0064m {

    public static String f344yW;

    public static String f345yX;

    private static int f348zd;

    private static int f349ze;

    private Display f354yY;

    private RelativeLayout f355yZ;

    private WebView f356za;

    private static int f341yT = 0;

    public static boolean f342yU = false;

    private static boolean f343yV = false;

    private static int f346zb = 800;

    private static int f347zc = 480;

    private static String f350zf = "";

    private static String f351zg = "https://ingameads.gameloft.com/redir/ads/splashscreen_view.php?from=FROM&country=COUNTRY&lg=LANG&udid=UDIDPHONE&androidid=ANDROIDID&d=DEVICE&f=FIRMWARE&game_ver=VERSION&igp_rev=1005&os=android";

    private static String[] f352zh = {"EN", "DE", "FR", "IT", "SP", "BR", "BR", "JP", "CN", "KR", "RU", "TR", "PL", "CZ", "NL", "TH", "VI", "AR", "ID", "ZT"};

    private static boolean f353zi = false;

    static void m579a(SplashScreenActivity splashScreenActivity, String str) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        if (C0355i.getActivity().getPackageManager().queryIntentActivities(intent, 65536).size() == 0) {
            intent = new Intent("android.intent.action.VIEW", Uri.parse("http://market.android.com/" + str.replace("market://", "")));
        }
        C0355i.getActivity().startActivity(intent);
    }

    public static void m580aM(String str) {
        try {
            new Intent("android.intent.action.MAIN");
            Intent launchIntentForPackage = C0355i.getActivity().getPackageManager().getLaunchIntentForPackage(str);
            launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
            C0355i.getActivity().startActivity(launchIntentForPackage);
        } catch (Exception e) {
        }
    }

    public static String m581aN(String str) {
        HttpURLConnection httpURLConnection;
        String str2;
        HttpURLConnection httpURLConnection2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        } catch (MalformedURLException e) {
            httpURLConnection = null;
        } catch (Exception e2) {
            httpURLConnection = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            httpURLConnection.setAllowUserInteraction(false);
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            String headerField = httpURLConnection.getHeaderField("Location");
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
                str2 = headerField;
            } else {
                str2 = headerField;
            }
        } catch (MalformedURLException e3) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
                str2 = null;
                System.gc();
                return str2;
            }
            str2 = null;
            System.gc();
            return str2;
        } catch (Exception e4) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
                str2 = null;
                System.gc();
                return str2;
            }
            str2 = null;
            System.gc();
            return str2;
        } catch (Throwable th2) {
            httpURLConnection2 = httpURLConnection;
            th = th2;
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            throw th;
        }
        System.gc();
        return str2;
    }

    static void m582b(SplashScreenActivity splashScreenActivity, String str) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        if (C0355i.getActivity().getPackageManager().queryIntentActivities(intent, 65536).size() == 0) {
            intent = new Intent("android.intent.action.VIEW", Uri.parse(str.replace("amzn://", "http://")));
        }
        C0355i.getActivity().startActivity(intent);
    }

    static void m584d(SplashScreenActivity splashScreenActivity, String str) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        if (C0355i.getActivity().getPackageManager().queryIntentActivities(intent, 65536).size() == 0) {
            intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.youtube.com/watch?v=" + str.replace("vnd.youtube:", "")));
        }
        C0355i.getActivity().startActivity(intent);
    }

    final void m585du() {
        try {
            f342yU = false;
            this.f356za.loadUrl("about:blank");
            dismiss();
        } catch (Exception e) {
        }
    }

    @Override
    public void onBackPressed() {
        m585du();
    }

    @Override
    public void onCreate(Bundle bundle) {
        byte b2 = 0;
        super.onCreate(bundle);
        requestWindowFeature(1);
        setCanceledOnTouchOutside(false);
        if (AbstractActivityC0092a.akM == null) {
            m585du();
            return;
        }
        int i = f341yT;
        int i2 = (i < 0 || i >= f352zh.length) ? 0 : i;
        this.f354yY = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        f347zc = this.f354yY.getHeight();
        f346zb = this.f354yY.getWidth();
        this.f355yZ = new RelativeLayout(getContext());
        this.f356za = new WebView(getContext());
        this.f356za.setHorizontalScrollBarEnabled(false);
        this.f356za.setVerticalScrollBarEnabled(false);
        this.f356za.setBackgroundColor(0);
        this.f356za.setInitialScale(100);
        this.f356za.getSettings().setJavaScriptEnabled(true);
        this.f356za.getSettings().setAppCacheEnabled(false);
        this.f356za.getSettings().setSupportZoom(false);
        this.f356za.getSettings().setBuiltInZoomControls(false);
        this.f356za.getSettings().setLoadWithOverviewMode(true);
        this.f356za.getSettings().setUseWideViewPort(false);
        this.f356za.getSettings().setDefaultZoom(WebSettings.ZoomDensity.FAR);
        this.f356za.setOnLongClickListener(new ViewOnLongClickListenerC0296aw(this));
        this.f356za.setWebViewClient(new C0298ay(this, b2));
        this.f356za.setWebChromeClient(new C0297ax(this));
        int round = Math.round(0.8f * f346zb);
        int round2 = Math.round(0.835f * f347zc);
        f348zd = 0;
        f349ze = 0;
        float f = C0349c.f2689XE.compareTo("portrait") == 0 ? 0.6631579f : 1.5079365f;
        while (f349ze <= round && f348zd <= round2) {
            int i3 = f348zd + 1;
            f348zd = i3;
            f349ze = Math.round(i3 * f);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(f349ze, f348zd);
        layoutParams.addRule(13);
        this.f355yZ.addView(this.f356za, layoutParams);
        setContentView(this.f355yZ, layoutParams);
        f342yU = true;
        f341yT = i2;
        if (i2 < 0 || f341yT >= f352zh.length) {
            f341yT = 0;
        }
        f350zf = f351zg.replace("VERSION", AbstractActivityC0092a.m209a(this, "MIDlet-Version")).replace("LANG", f352zh[f341yT]).replace("COUNTRY", Locale.getDefault().getCountry()).replace("FROM", AbstractActivityC0092a.m209a(this, "GAME-IGP-CODE")).replace("DEVICE", Build.MANUFACTURER + "_" + Build.MODEL).replace("FIRMWARE", Build.VERSION.RELEASE).replace("ANDROIDID", C0355i.m2206qc()).replace("UDIDPHONE", C0355i.getDeviceId()).replaceAll(" ", "");
        f350zf += "&width=" + f349ze;
        f350zf += "&height=" + f348zd;
        String str = f350zf + "&is_pau=0";
        f350zf = str;
        String[] split = str.split("[?]");
        f350zf = split[0] + "?data=" + C0273b.m676T(split[1]) + "&enc=1";
        this.f356za.loadUrl(f350zf);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
