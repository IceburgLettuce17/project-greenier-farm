package com.google.android.gcm;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import java.sql.Timestamp;

public final class GCMRegistrar {
    private static GCMBroadcastReceiver ahr;
    private static String ahs;

    private GCMRegistrar() {
        throw new UnsupportedOperationException();
    }

    public static void m2796a(Context context, String... strArr) {
        m2809r(context);
        m2798b(context, strArr);
    }

    static void m2797b(Context context, int i) {
        SharedPreferences.Editor edit = context.getSharedPreferences("com.google.android.gcm", 0).edit();
        edit.putInt("backoff_ms", i);
        edit.commit();
    }

    static void m2798b(Context context, String... strArr) {
        String m2800d = m2800d(strArr);
        String str = "Registering app " + context.getPackageName() + " of senders " + m2800d;
        Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
        intent.setPackage("com.google.android.gsf");
        intent.putExtra("app", PendingIntent.getBroadcast(context, 0, new Intent(), 0));
        intent.putExtra("sender", m2800d);
        context.startService(intent);
    }

    static String m2799d(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.android.gcm", 0);
        String string = sharedPreferences.getString("regId", "");
        int m2802f = m2802f(context);
        String str2 = "Saving regId on app version " + m2802f;
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("regId", str);
        edit.putInt("appVersion", m2802f);
        edit.commit();
        return string;
    }

    static String m2800d(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            throw new IllegalArgumentException("No senderIds");
        }
        StringBuilder sb = new StringBuilder(strArr[0]);
        for (int i = 1; i < strArr.length; i++) {
            sb.append(',').append(strArr[i]);
        }
        return sb.toString();
    }

    static void m2801db(String str) {
        String str2 = "Setting the name of retry receiver class to " + str;
        ahs = str;
    }

    private static int m2802f(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException("Coult not get package name: " + e);
        }
    }

    static void m2803l(Context context) {
        String str = "Unregistering app " + context.getPackageName();
        Intent intent = new Intent("com.google.android.c2dm.intent.UNREGISTER");
        intent.setPackage("com.google.android.gsf");
        intent.putExtra("app", PendingIntent.getBroadcast(context, 0, new Intent(), 0));
        context.startService(intent);
    }

    static synchronized void m2804m(Context context) {
        synchronized (GCMRegistrar.class) {
            if (ahr == null) {
                if (ahs == null) {
                    ahr = new GCMBroadcastReceiver();
                } else {
                    try {
                        ahr = (GCMBroadcastReceiver) Class.forName(ahs).newInstance();
                    } catch (Exception e) {
                        String str = "Could not create instance of " + ahs + ". Using " + GCMBroadcastReceiver.class.getName() + " directly.";
                        ahr = new GCMBroadcastReceiver();
                    }
                }
                String packageName = context.getPackageName();
                IntentFilter intentFilter = new IntentFilter("com.google.android.gcm.intent.RETRY");
                intentFilter.addCategory(packageName);
                context.registerReceiver(ahr, intentFilter, packageName + ".permission.C2D_MESSAGE", null);
            }
        }
    }

    public static String m2805n(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.android.gcm", 0);
        String string = sharedPreferences.getString("regId", "");
        int i = sharedPreferences.getInt("appVersion", Integer.MIN_VALUE);
        int m2802f = m2802f(context);
        if (i == Integer.MIN_VALUE || i == m2802f) {
            return string;
        }
        String str = "App version changed from " + i + " to " + m2802f + "; resetting registration id";
        m2799d(context, "");
        return "";
    }

    public static boolean m2806o(Context context) {
        return m2805n(context).length() > 0;
    }

    static String m2807p(Context context) {
        return m2799d(context, "");
    }

    public static boolean m2808q(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.android.gcm", 0);
        boolean z = sharedPreferences.getBoolean("onServer", false);
        String str = "Is registered on server: " + z;
        if (z) {
            long j = sharedPreferences.getLong("onServerExpirationTime", -1L);
            if (System.currentTimeMillis() > j) {
                String str2 = "flag expired on: " + new Timestamp(j);
                return false;
            }
        }
        return z;
    }

    static void m2809r(Context context) {
        String str = "resetting backoff for " + context.getPackageName();
        m2797b(context, 3000);
    }

    static int m2810s(Context context) {
        return context.getSharedPreferences("com.google.android.gcm", 0).getInt("backoff_ms", 3000);
    }
}
