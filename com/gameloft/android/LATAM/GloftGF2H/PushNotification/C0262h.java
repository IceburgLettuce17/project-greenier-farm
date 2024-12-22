package com.gameloft.android.LATAM.GloftGF2H.PushNotification;

import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.facebook.android.C0217R;
import java.lang.reflect.Method;
import p001a.p004b.p005a.p006a.C0002a;

public final class C0262h extends AbstractC0259e {
    public C0262h(Context context) {
        super(context);
    }

    @Override
    public final Notification mo528cX() {
        try {
            Class<?> cls = Class.forName("android.app.Notification$Builder");
            Object newInstance = cls.getConstructor(Class.forName("android.content.Context")).newInstance(this.context);
            Class<?> cls2 = Class.forName("java.lang.CharSequence");
            Method declaredMethod = cls.getDeclaredMethod("setContentTitle", cls2);
            if (!declaredMethod.isAccessible()) {
                declaredMethod.setAccessible(true);
            }
            declaredMethod.invoke(newInstance, this.f313xK);
            Method declaredMethod2 = cls.getDeclaredMethod("setContentText", cls2);
            if (!declaredMethod2.isAccessible()) {
                declaredMethod2.setAccessible(true);
            }
            declaredMethod2.invoke(newInstance, this.f312xJ);
            Method declaredMethod3 = cls.getDeclaredMethod("setContentInfo", cls2);
            if (!declaredMethod3.isAccessible()) {
                declaredMethod3.setAccessible(true);
            }
            declaredMethod3.invoke(newInstance, null);
            Method declaredMethod4 = cls.getDeclaredMethod("setSmallIcon", Integer.TYPE);
            if (!declaredMethod4.isAccessible()) {
                declaredMethod4.setAccessible(true);
            }
            declaredMethod4.invoke(newInstance, Integer.valueOf(C0217R.drawable.pn_status_icon));
            Method declaredMethod5 = cls.getDeclaredMethod("setWhen", Long.TYPE);
            if (!declaredMethod5.isAccessible()) {
                declaredMethod5.setAccessible(true);
            }
            declaredMethod5.invoke(newInstance, Long.valueOf(this.when));
            Method declaredMethod6 = cls.getDeclaredMethod("setContentIntent", this.f314xL.getClass());
            if (!declaredMethod6.isAccessible()) {
                declaredMethod6.setAccessible(true);
            }
            declaredMethod6.invoke(newInstance, this.f314xL);
            Method declaredMethod7 = cls.getDeclaredMethod("setTicker", cls2);
            if (!declaredMethod7.isAccessible()) {
                declaredMethod7.setAccessible(true);
            }
            declaredMethod7.invoke(newInstance, this.f313xK);
            Method declaredMethod8 = cls.getDeclaredMethod("setAutoCancel", Boolean.TYPE);
            if (!declaredMethod8.isAccessible()) {
                declaredMethod8.setAccessible(true);
            }
            declaredMethod8.invoke(newInstance, Boolean.valueOf(this.f315xM));
            Class<?> cls3 = Class.forName("android.app.Notification$BigTextStyle");
            Object newInstance2 = cls3.getConstructor(new Class[0]).newInstance(new Object[0]);
            Method declaredMethod9 = cls3.getDeclaredMethod("setBigContentTitle", cls2);
            if (!declaredMethod9.isAccessible()) {
                declaredMethod9.setAccessible(true);
            }
            declaredMethod9.invoke(newInstance2, this.f313xK);
            Method declaredMethod10 = cls3.getDeclaredMethod("bigText", cls2);
            if (!declaredMethod10.isAccessible()) {
                declaredMethod10.setAccessible(true);
            }
            declaredMethod10.invoke(newInstance2, this.f312xJ);
            Method declaredMethod11 = cls.getDeclaredMethod("setStyle", Class.forName("android.app.Notification$Style"));
            if (!declaredMethod11.isAccessible()) {
                declaredMethod11.setAccessible(true);
            }
            declaredMethod11.invoke(newInstance, newInstance2);
            if (!C0002a.m13a(this.context)) {
                Method declaredMethod12 = cls.getDeclaredMethod("setDefaults", Integer.TYPE);
                if (!declaredMethod12.isAccessible()) {
                    declaredMethod12.setAccessible(true);
                }
                newInstance = declaredMethod12.invoke(newInstance, -1);
            }
            Bitmap decodeResource = BitmapFactory.decodeResource(this.context.getResources(), C0270p.m577dd());
            Method declaredMethod13 = cls.getDeclaredMethod("setLargeIcon", decodeResource.getClass());
            if (!declaredMethod13.isAccessible()) {
                declaredMethod13.setAccessible(true);
            }
            Object invoke = declaredMethod13.invoke(newInstance, decodeResource);
            Method declaredMethod14 = cls.getDeclaredMethod("getNotification", new Class[0]);
            if (!declaredMethod14.isAccessible()) {
                declaredMethod14.setAccessible(true);
            }
            return (Notification) declaredMethod14.invoke(invoke, new Object[0]);
        } catch (Exception e) {
            String str = "Exception: " + e;
            return null;
        }
    }
}
