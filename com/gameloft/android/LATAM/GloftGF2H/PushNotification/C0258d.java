package com.gameloft.android.LATAM.GloftGF2H.PushNotification;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.gameloft.android.wrapper.C0355i;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

public final class C0258d {

    private static int f310xH;

    public static int f311xI = 1814400;

    static String m517a(Bundle bundle, int i) {
        int i2 = 100;
        SharedPreferences sharedPreferences = C0355i.getContext().getSharedPreferences("GLPN", 0);
        int i3 = 0;
        while (true) {
            if (!sharedPreferences.contains("PN_LID_" + i3)) {
                i2 = i3;
                break;
            }
            i3++;
            if (i3 >= 100) {
                break;
            }
        }
        Context context = C0355i.getContext();
        f310xH = i2;
        SharedPreferences.Editor edit = context.getSharedPreferences("GLPN", 0).edit();
        edit.putInt("PN_AID", f310xH);
        edit.commit();
        bundle.putString("lID", "PN_LID_" + i2);
        Calendar calendar = Calendar.getInstance();
        calendar.add(13, i);
        String packageName = context.getPackageName();
        Intent intent = new Intent(context, (Class<?>) LocalPushReceiver.class);
        intent.putExtra(packageName + ".alarm_content", bundle);
        ((AlarmManager) context.getSystemService("alarm")).set(0, calendar.getTimeInMillis(), PendingIntent.getBroadcast(context, i2, intent, 134217728));
        m518a("PN_LID_" + i2, Integer.toString(i), bundle);
        return "PN_LID_" + i2;
    }

    private static void m518a(String str, String str2, Bundle bundle) {
        String str3 = "";
        Iterator<String> it = bundle.keySet().iterator();
        if (bundle != null) {
            while (it.hasNext()) {
                String next = it.next();
                str3 = (next == null || "".equals((String) bundle.get(next))) ? str3 : str3 + "|key|" + next + "=" + ((String) bundle.get(next));
            }
            str3 = (str3 + "|key|delay=" + str2) + "|key|expiration=" + m521au(str2);
        }
        SharedPreferences.Editor edit = C0355i.getContext().getSharedPreferences("GLPN", 0).edit();
        edit.putString(str, str3);
        edit.commit();
    }

    static void m519aO() {
        f310xH = 0;
        Context context = C0355i.getContext();
        if (context != null) {
            f310xH = context.getSharedPreferences("GLPN", 0).getInt("PN_AID", 0);
        }
    }

    public static void m520at(String str) {
        Context context = C0355i.getContext();
        ((AlarmManager) context.getSystemService("alarm")).cancel(PendingIntent.getBroadcast(context, Integer.parseInt(str.substring(7)), new Intent(context, (Class<?>) LocalPushReceiver.class), 134217728));
        SharedPreferences.Editor edit = context.getSharedPreferences("GLPN", 0).edit();
        edit.remove(str);
        edit.commit();
    }

    private static String m521au(String str) {
        try {
            return new Date(System.currentTimeMillis() + (Long.parseLong(str) * 1000)).toString();
        } catch (Exception e) {
            return "";
        }
    }

    public static String m522av(String str) {
        try {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(5);
            int i2 = calendar.get(2);
            return i + "/" + (i2 + 1) + "/" + calendar.get(1) + " " + calendar.get(11) + ":" + calendar.get(12) + ":" + (calendar.get(13) + Integer.parseInt(str));
        } catch (Exception e) {
            return "";
        }
    }

    static boolean m523aw(String str) {
        try {
            return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(m522av("0")).getTime() >= new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(str).getTime();
        } catch (Exception e) {
            return false;
        }
    }

    public static void m524cV() {
        int i;
        String str;
        SharedPreferences sharedPreferences = C0355i.getContext().getSharedPreferences("GLPN", 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        String str2 = "";
        int i2 = 0;
        int i3 = sharedPreferences.getInt("PN_AID", 0);
        while (i3 > 0) {
            if (sharedPreferences.contains("PN_LID_" + i3)) {
                String string = sharedPreferences.getString("PN_LID_" + i3, null);
                Bundle bundle = new Bundle();
                i = i2;
                str = str2;
                String str3 = string;
                int i4 = 0;
                while (i < str3.length()) {
                    int indexOf = str3.indexOf("|key|");
                    int indexOf2 = str3.indexOf("=", indexOf);
                    String substring = str3.substring(indexOf + 5, indexOf2);
                    String substring2 = str3.substring(indexOf2 + 1);
                    int indexOf3 = substring2.contains("|key|") ? substring2.indexOf("|key|") : substring2.length();
                    String substring3 = substring2.substring(0, indexOf3);
                    if ("delay".equals(substring)) {
                        i4 = Integer.parseInt(substring3);
                    } else if ("expiration".equals(substring)) {
                        str = substring3;
                    } else {
                        "lID".equals(substring);
                    }
                    bundle.putString(substring, substring3);
                    str3 = substring2;
                    i = indexOf3;
                }
                if (!m523aw(str)) {
                    m517a(bundle, i4);
                }
            } else {
                i = i2;
                str = str2;
            }
            i3--;
            str2 = str;
            i2 = i;
        }
        edit.commit();
    }

    public static void m525cW() {
        Context context = C0355i.getContext();
        SharedPreferences sharedPreferences = context.getSharedPreferences("GLPN", 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        Intent intent = new Intent(context, (Class<?>) LocalPushReceiver.class);
        for (int i = 100; i >= 0; i--) {
            String str = "PN_LID_" + i;
            if (sharedPreferences.contains(str)) {
                ((AlarmManager) context.getSystemService("alarm")).cancel(PendingIntent.getBroadcast(context, i, intent, 134217728));
                edit.remove(str);
            }
        }
        edit.putInt("PN_AID", 0);
        edit.commit();
    }

    static void m526e(Context context) {
        if (C0355i.getContext() == null) {
            C0355i.setContext(context);
        }
        m519aO();
    }

    static boolean m527u(String str, String str2) {
        try {
            Date parse = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(str2);
            Date parse2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(str);
            if (parse.getYear() > parse2.getYear()) {
                return true;
            }
            if (parse.getYear() == parse2.getYear() && parse.getMonth() > parse2.getMonth()) {
                return true;
            }
            if (parse.getYear() == parse2.getYear() && parse.getMonth() == parse2.getMonth()) {
                if (parse.getDate() > parse2.getDate()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
