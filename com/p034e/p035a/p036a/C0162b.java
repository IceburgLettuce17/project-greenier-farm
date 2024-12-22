package com.p034e.p035a.p036a;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import com.facebook.internal.ServerProtocol;
import com.facebook.widget.PlacePickerFragment;
import com.p034e.p035a.p036a.p040d.C0175b;
import p001a.p004b.p005a.p006a.C0002a;

public final class C0162b {
    private static String ahx = "https://open.weibo.cn/oauth2";
    private static C0162b ahy = null;
    private static String ahz = "";
    private static String ahA = "";
    private static String ahB = "";
    private static String ahC = "";
    private C0156a ahj = null;
    private Handler ahD = new HandlerC0170c(this);

    static InterfaceC0177f m290a(C0162b c0162b) {
        return null;
    }

    static void m291a(C0162b c0162b, int i, Bundle bundle, Exception exc) {
        Message obtain = Message.obtain();
        obtain.what = i;
        switch (i) {
            case PlacePickerFragment.DEFAULT_RADIUS_IN_METERS:
                if (bundle != null) {
                    obtain.setData(bundle);
                    break;
                }
                break;
            case 1001:
                if (0 != 0) {
                    obtain.obj = null;
                }
                if (bundle != null) {
                    obtain.setData(bundle);
                    break;
                }
                break;
        }
        c0162b.ahD.sendMessage(obtain);
    }

    static void m293a(C0162b c0162b, String str) {
        C0182k c0182k = new C0182k();
        c0182k.m333O("client_id", ahz);
        c0182k.m333O("client_secret", ahC);
        c0182k.m333O("grant_type", "authorization_code");
        c0182k.m333O("code", str);
        c0182k.m333O(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, ahA);
        C0002a.m8a(String.valueOf(ahx) + "/access_token", c0182k, "POST", new C0176e(c0162b));
    }

    public static void m294ai(boolean z) {
    }

    public static synchronized C0162b m296i(String str, String str2, String str3) {
        C0162b c0162b;
        synchronized (C0162b.class) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                throw new RuntimeException("Parameter is not complete, please fill complete appkey and redirectUrl.");
            }
            if (ahy == null) {
                ahy = new C0162b();
            }
            ahz = str;
            ahA = str2;
            ahB = str3;
            c0162b = ahy;
        }
        return c0162b;
    }

    public static String m297tJ() {
        return ahz;
    }

    public static String m298tK() {
        return ahA;
    }

    public static String m299tL() {
        return ahB;
    }

    public final void m300a(Context context, InterfaceC0177f interfaceC0177f, int i) {
        C0182k c0182k = new C0182k();
        CookieSyncManager.createInstance(context);
        C0173d c0173d = new C0173d(this, 0, interfaceC0177f);
        c0182k.m333O("client_id", ahz);
        c0182k.m333O("response_type", "code");
        c0182k.m333O(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, ahA);
        c0182k.m333O(ServerProtocol.DIALOG_PARAM_DISPLAY, "mobile");
        c0182k.m333O("scope", ahB);
        c0182k.m333O("packagename", null);
        c0182k.m333O("key_hash", C0175b.m325e(context, null));
        String str = String.valueOf(ahx) + "/authorize?" + C0175b.m321a(c0182k);
        if (context.checkCallingOrSelfPermission("android.permission.INTERNET") != 0) {
            C0175b.showAlert(context, "Error", "Application requires permission to access the Internet");
        } else {
            new DialogC0178g(context, str, c0173d).show();
        }
    }
}
