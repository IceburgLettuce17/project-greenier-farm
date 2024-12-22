package com.gameloft.android2d.iap.p042a.p047e;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Handler;
import java.lang.reflect.Method;
import p001a.p004b.p005a.p006a.C0012k;

public abstract class AbstractC0373ad {
    private static final Class[] abD = {IntentSender.class, Intent.class, Integer.TYPE, Integer.TYPE, Integer.TYPE};
    private final Activity abA;
    private Method abB;
    private Object[] abC = new Object[5];
    private final Handler mHandler;

    public AbstractC0373ad(Activity activity, Handler handler) {
        this.abA = activity;
        this.mHandler = handler;
        try {
            this.abB = this.abA.getClass().getMethod("startIntentSender", abD);
        } catch (NoSuchMethodException e) {
            this.abB = null;
        } catch (SecurityException e2) {
            this.abB = null;
        }
    }

    final void m2306a(PendingIntent pendingIntent, Intent intent) {
        if (this.abB == null) {
            try {
                pendingIntent.send(this.abA, 0, intent);
                return;
            } catch (PendingIntent.CanceledException e) {
                C0012k.m40b("IAP-PurchaseObserver", "error starting activity" + e);
                return;
            }
        }
        try {
            this.abC[0] = pendingIntent.getIntentSender();
            this.abC[1] = intent;
            this.abC[2] = 0;
            this.abC[3] = 0;
            this.abC[4] = 0;
            this.abB.invoke(this.abA, this.abC);
        } catch (Exception e2) {
            C0012k.m40b("IAP-PurchaseObserver", "error starting activity" + e2);
        }
    }

    public abstract void mo2287a(EnumC0386h enumC0386h, String str);

    final void m2307a(EnumC0386h enumC0386h, String str, int i, long j, String str2) {
        this.mHandler.post(new RunnableC0374ae(this, enumC0386h, str, i, j, str2));
    }

    public abstract void mo2288a(EnumC0387i enumC0387i);

    public abstract void mo2289rI();
}
