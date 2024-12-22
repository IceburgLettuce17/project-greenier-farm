package com.gameloft.android2d.socialnetwork;

import android.app.Activity;
import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.facebook.internal.ServerProtocol;
import com.gameloft.android.wrapper.C0355i;
import com.p034e.p035a.p036a.C0156a;
import com.p034e.p035a.p036a.C0162b;
import com.p034e.p035a.p036a.C0182k;
import com.p034e.p035a.p036a.DialogC0178g;
import com.p034e.p035a.p036a.p037a.C0157a;
import com.p034e.p035a.p036a.p037a.C0158b;
import com.p034e.p035a.p036a.p037a.C0159c;
import com.p034e.p035a.p036a.p037a.C0160d;
import com.p034e.p035a.p036a.p039c.C0171a;
import com.p034e.p035a.p036a.p040d.C0175b;
import java.io.File;

public final class C0511ar {
    private static C0528l[] ahi;
    private static C0156a ahj;
    private static C0162b ahd = null;
    private static Activity ahe = null;
    private static Context ahf = null;
    private static String ahg = "";
    private static String ahh = "https://api.weibo.com/oauth2/default.html";
    private static C0528l age = null;
    private static long ahk = -1;
    private static boolean agq = false;
    private static boolean agr = false;
    private static boolean ags = false;

    public static void m2749L(String str, String str2) {
        if (str2 != null) {
            new C0159c(ahj).m287a(str, str2, "", "", new C0516aw());
        } else {
            m2767h(str, "", "");
        }
    }

    public static void m2751a(int i, int i2) {
    }

    public static void m2752a(C0528l c0528l, C0528l[] c0528lArr, String str, String str2) {
        String str3 = c0528l != null ? "@" + c0528l.afB : null;
        if (c0528lArr != null) {
            String str4 = "@" + c0528lArr[0].afB;
            for (int i = 1; i < c0528lArr.length; i++) {
                str4 = str4 + ",@" + c0528lArr[i].afB;
            }
        }
        if (c0528l == null && c0528lArr == null) {
            return;
        }
        m2767h(str + " : " + str3, "", "");
    }

    static boolean m2754af(boolean z) {
        return z;
    }

    static boolean m2755ah(boolean z) {
        agq = true;
        return true;
    }

    public static void m2757b() {
        if (ahd != null) {
            new C0171a(ahe, ahd);
            Activity activity = ahe;
            C0512as c0512as = new C0512as();
            C0182k c0182k = new C0182k();
            CookieSyncManager.createInstance(activity);
            c0182k.m333O("client_id", ahg);
            c0182k.m333O("response_type", "token");
            c0182k.m333O(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, ahh);
            c0182k.m333O(ServerProtocol.DIALOG_PARAM_DISPLAY, "mobile");
            c0182k.m333O("scope", "email,direct_messages_read,direct_messages_write,friendships_groups_read,friendships_groups_write,statuses_to_me_read,follow_app_official_microblog");
            c0182k.m333O("packagename", "com.weibo.android.example");
            c0182k.m333O("key_hash", C0175b.m325e(activity, "com.weibo.android.example"));
            String str = String.valueOf("https://api.weibo.com/oauth2") + "/authorize?" + C0175b.m321a(c0182k);
            if (activity.checkCallingOrSelfPermission("android.permission.INTERNET") != 0) {
                C0175b.showAlert(activity, "Error", "Application requires permission to access the Internet");
            } else {
                new DialogC0178g(activity, str, c0512as).show();
            }
        }
    }

    public static void m2758c() {
        if (ahd != null) {
            CookieSyncManager.createInstance(ahf.getApplicationContext());
            CookieSyncManager.getInstance().startSync();
            CookieManager.getInstance().removeAllCookie();
        }
    }

    public static void m2759c(String str, String str2) {
        Activity activity = C0355i.getActivity();
        ahe = activity;
        ahf = activity.getApplicationContext();
        ahg = str;
        ahd = C0162b.m296i(str, ahh, "email,direct_messages_read,direct_messages_write,friendships_groups_read,friendships_groups_write,statuses_to_me_read,follow_app_official_microblog");
        try {
            new File(C0355i.getContext().getFilesDir().getAbsolutePath() + "\\sinaweibo").mkdir();
        } catch (Exception e) {
            String str3 = "Weibo: exception create photo folder " + e.toString();
        }
    }

    public static void m2760d() {
        agq = false;
        agr = false;
        ags = false;
        if (ahj != null && ahk != -1) {
            new C0160d(ahj).m288a(ahk, new C0514au());
        }
        new C0158b(ahj).m285a(ahk, 50, 0, true, new C0517ax());
    }

    static void m2761dn() {
        if (ahj != null) {
            new C0157a(ahj).m284a(new C0513at());
        }
    }

    public static boolean m2762e() {
        return agq && agr;
    }

    public static boolean m2763f() {
        return false;
    }

    public static C0528l m2764fg(int i) {
        if (i < ahi.length) {
            return ahi[i];
        }
        return null;
    }

    public static boolean m2765g() {
        if (ahj != null) {
            return ahj.isSessionValid();
        }
        return false;
    }

    public static String getPassword() {
        return ahj.getToken();
    }

    private static void m2767h(String str, String str2, String str3) {
        new C0159c(ahj).m286a(str, str3, str2, new C0515av());
    }

    public static int m2768i() {
        if (ahi != null) {
            return ahi.length;
        }
        return 0;
    }

    static boolean m2769o(boolean z) {
        agr = true;
        return true;
    }

    public static C0528l m2772tw() {
        return age;
    }
}
