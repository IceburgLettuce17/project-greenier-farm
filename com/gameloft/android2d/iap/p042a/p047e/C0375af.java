package com.gameloft.android2d.iap.p042a.p047e;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import p001a.p004b.p005a.p006a.C0012k;

public class C0375af {
    private static AbstractC0373ad abK;

    public static void m2308a(Context context, EnumC0386h enumC0386h, String str, String str2, long j, String str3) {
        new Thread(new RunnableC0376ag(context, str2, str, enumC0386h, j, str3)).start();
    }

    public static synchronized void m2309a(AbstractC0373ad abstractC0373ad) {
        synchronized (C0375af.class) {
            abK = abstractC0373ad;
        }
    }

    public static void m2310a(C0384f c0384f, EnumC0387i enumC0387i) {
        if (abK != null) {
            abK.mo2288a(enumC0387i);
        }
    }

    public static void m2311b(PendingIntent pendingIntent, Intent intent) {
        if (abK == null) {
            C0012k.m39a("IAP-ResponseHandler", "UI is not running");
        } else {
            abK.m2306a(pendingIntent, intent);
        }
    }

    public static void m2312b(boolean z, String str) {
        if (abK != null) {
            abK.mo2289rI();
        }
    }
}
