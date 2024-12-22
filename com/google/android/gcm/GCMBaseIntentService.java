package com.google.android.gcm;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.SystemClock;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public abstract class GCMBaseIntentService extends IntentService {
    private static PowerManager.WakeLock ahl;
    private final String[] ahm;
    private static final Object LOCK = GCMBaseIntentService.class;
    private static int ahn = 0;
    private static final Random aho = new Random();
    private static final int ahp = (int) TimeUnit.SECONDS.toMillis(3600);
    private static final String TOKEN = Long.toBinaryString(aho.nextLong());

    protected GCMBaseIntentService() {
        this(getName("DynamicSenderIds"), null);
    }

    private GCMBaseIntentService(String str, String[] strArr) {
        super(str);
        this.ahm = strArr;
    }

    public GCMBaseIntentService(String... strArr) {
        this(getName(GCMRegistrar.m2800d(strArr)), strArr);
    }

    static void m2795a(Context context, Intent intent, String str) {
        synchronized (LOCK) {
            if (ahl == null) {
                ahl = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "GCM_LIB");
            }
        }
        ahl.acquire();
        intent.setClassName(context, str);
        context.startService(intent);
    }

    private static String getName(String str) {
        StringBuilder append = new StringBuilder("GCMIntentService-").append(str).append("-");
        int i = ahn + 1;
        ahn = i;
        String sb = append.append(i).toString();
        String str2 = "Intent service name: " + sb;
        return sb;
    }

    protected abstract void mo337A(String str);

    protected abstract void mo338a(Context context, Intent intent);

    public boolean mo339b(Context context, String str) {
        return true;
    }

    protected abstract void mo340d(Context context);

    @Override
    public final void onHandleIntent(Intent intent) {
        try {
            Context applicationContext = getApplicationContext();
            String action = intent.getAction();
            if (action.equals("com.google.android.c2dm.intent.REGISTRATION")) {
                GCMRegistrar.m2804m(applicationContext);
                String stringExtra = intent.getStringExtra("registration_id");
                String stringExtra2 = intent.getStringExtra("error");
                String stringExtra3 = intent.getStringExtra("unregistered");
                String str = "handleRegistration: registrationId = " + stringExtra + ", error = " + stringExtra2 + ", unregistered = " + stringExtra3;
                if (stringExtra != null) {
                    GCMRegistrar.m2809r(applicationContext);
                    GCMRegistrar.m2799d(applicationContext, stringExtra);
                    mo337A(stringExtra);
                } else if (stringExtra3 != null) {
                    GCMRegistrar.m2809r(applicationContext);
                    GCMRegistrar.m2807p(applicationContext);
                    mo340d(applicationContext);
                } else {
                    String str2 = "Registration error: " + stringExtra2;
                    if ("SERVICE_NOT_AVAILABLE".equals(stringExtra2) && mo339b(applicationContext, stringExtra2)) {
                        int m2810s = GCMRegistrar.m2810s(applicationContext);
                        int nextInt = aho.nextInt(m2810s) + (m2810s / 2);
                        String str3 = "Scheduling registration retry, backoff = " + nextInt + " (" + m2810s + ")";
                        Intent intent2 = new Intent("com.google.android.gcm.intent.RETRY");
                        intent2.putExtra("token", TOKEN);
                        ((AlarmManager) applicationContext.getSystemService("alarm")).set(3, SystemClock.elapsedRealtime() + nextInt, PendingIntent.getBroadcast(applicationContext, 0, intent2, 0));
                        if (m2810s < ahp) {
                            GCMRegistrar.m2797b(applicationContext, m2810s << 1);
                        }
                    }
                }
            } else if (action.equals("com.google.android.c2dm.intent.RECEIVE")) {
                String stringExtra4 = intent.getStringExtra("message_type");
                if (stringExtra4 == null) {
                    mo338a(applicationContext, intent);
                } else if (stringExtra4.equals("deleted_messages")) {
                    String stringExtra5 = intent.getStringExtra("total_deleted");
                    if (stringExtra5 != null) {
                        try {
                            String str4 = "Received deleted messages notification: " + Integer.parseInt(stringExtra5);
                        } catch (NumberFormatException e) {
                            String str5 = "GCM returned invalid number of deleted messages: " + stringExtra5;
                        }
                    }
                } else {
                    String str6 = "Received unknown special message: " + stringExtra4;
                }
            } else if (action.equals("com.google.android.gcm.intent.RETRY")) {
                String stringExtra6 = intent.getStringExtra("token");
                if (!TOKEN.equals(stringExtra6)) {
                    String str7 = "Received invalid token: " + stringExtra6;
                    synchronized (LOCK) {
                        if (ahl != null) {
                            ahl.release();
                        }
                    }
                    return;
                }
                if (GCMRegistrar.m2806o(applicationContext)) {
                    GCMRegistrar.m2803l(applicationContext);
                } else {
                    if (this.ahm == null) {
                        throw new IllegalStateException("sender id not set on constructor");
                    }
                    GCMRegistrar.m2798b(applicationContext, this.ahm);
                }
            }
            synchronized (LOCK) {
                if (ahl != null) {
                    ahl.release();
                }
            }
        } catch (Throwable th) {
            synchronized (LOCK) {
                if (ahl != null) {
                    ahl.release();
                }
                throw th;
            }
        }
    }
}
