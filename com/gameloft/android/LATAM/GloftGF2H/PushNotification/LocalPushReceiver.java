package com.gameloft.android.LATAM.GloftGF2H.PushNotification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.facebook.internal.ServerProtocol;
import p001a.p004b.p005a.p006a.C0002a;

public class LocalPushReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        try {
            C0258d.m526e(context);
            if ("android.intent.action.BOOT_COMPLETED".equals(intent.getAction())) {
                C0258d.m524cV();
                return;
            }
            boolean m17b = C0002a.m17b(context);
            Bundle extras = intent.getExtras();
            if (extras != null) {
                String str = "";
                Bundle bundle = extras.getBundle(context.getPackageName() + ".alarm_content");
                if (bundle != null) {
                    String str2 = "";
                    String str3 = "";
                    String str4 = "";
                    String str5 = "";
                    String str6 = "";
                    for (String str7 : bundle.keySet()) {
                        if (str7.equals("body")) {
                            str4 = (String) bundle.get("body");
                        } else if (str7.equals("subject")) {
                            str3 = (String) bundle.get("subject");
                        } else if (str7.equals(ServerProtocol.DIALOG_PARAM_TYPE)) {
                            str2 = (String) bundle.get(ServerProtocol.DIALOG_PARAM_TYPE);
                        } else if (str7.equals("url")) {
                            str6 = (String) bundle.get("url");
                        } else if (str7.equals("lID")) {
                            str5 = (String) bundle.get("lID");
                        } else {
                            str = str7.equals("infopush") ? (String) bundle.get("infopush") : str;
                        }
                    }
                    if (m17b) {
                        String m522av = C0258d.m522av("0");
                        if (!str.equals("")) {
                            SharedPreferences sharedPreferences = context.getSharedPreferences("GLPN", 0);
                            SharedPreferences.Editor edit = sharedPreferences.edit();
                            int i = sharedPreferences.getInt("info_" + str, 0);
                            int i2 = sharedPreferences.getInt("count_" + str, 0);
                            if (i != 0) {
                                if (i2 == 0) {
                                    edit.putString("time_" + str, m522av);
                                    edit.commit();
                                }
                                String string = sharedPreferences.getString("time_" + str, m522av);
                                if (!C0258d.m523aw(string)) {
                                    edit.putString("time_" + str, m522av);
                                    edit.commit();
                                    string = m522av;
                                }
                                if (C0258d.m527u(string, m522av)) {
                                    edit.putInt("count_" + str, 0);
                                    edit.putString("time_" + str, m522av);
                                    edit.commit();
                                    i2 = 0;
                                }
                                if (i2 >= i) {
                                    return;
                                }
                                edit.putInt("count_" + str, i2 + 1);
                                edit.commit();
                            }
                        }
                        int i3 = context.getSharedPreferences("GLPN", 0).getInt("pn_count_push_local", 0);
                        if (i3 == 0) {
                            C0002a.m4a(context, m522av);
                        }
                        String string2 = context.getSharedPreferences("GLPN", 0).getString("pn_time_first_push_local", C0258d.m522av("0"));
                        if (!C0258d.m523aw(string2)) {
                            C0002a.m4a(context, m522av);
                            string2 = m522av;
                        }
                        if (C0258d.m527u(string2, m522av)) {
                            C0002a.m3a(context, 0);
                            C0002a.m4a(context, m522av);
                            i3 = 0;
                        }
                        if (i3 < 2) {
                            C0002a.m3a(context, i3 + 1);
                            if ("".equals(str4)) {
                                return;
                            }
                            C0263i.m556cY();
                            if (bundle.containsKey("customIcon")) {
                                C0263i.f320xR = true;
                                C0263i.f321xS = (String) bundle.get("customIcon");
                            } else {
                                C0263i.f320xR = false;
                                C0263i.f321xS = null;
                            }
                            Intent m531a = C0263i.m531a(context, str2, str6, bundle);
                            if (m531a != null) {
                                C0263i.m538a(context, str4, str3, m531a);
                            }
                            if (str5.length() > 0) {
                                C0258d.m520at(str5);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
        }
    }
}
