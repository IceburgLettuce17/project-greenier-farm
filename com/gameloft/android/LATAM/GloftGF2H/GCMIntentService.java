package com.gameloft.android.LATAM.GloftGF2H;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.facebook.android.C0217R;
import com.facebook.internal.ServerProtocol;
import com.gameloft.android.LATAM.GloftGF2H.PushNotification.C0263i;
import com.google.android.gcm.GCMBaseIntentService;
import com.google.android.gcm.GCMRegistrar;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Locale;
import java.util.Vector;
import p001a.p004b.p005a.p006a.C0002a;

public class GCMIntentService extends GCMBaseIntentService {

    private static Vector<String> f133iB;

    public GCMIntentService() {
        super("108176907654");
        if (f133iB == null) {
            f133iB = new Vector<>();
        }
    }

    @Override
    protected final void mo337A(String str) {
        if (str == null || str.length() <= 0) {
            return;
        }
        C0263i.m557cZ();
    }

    @Override
    protected final void mo338a(Context context, Intent intent) {
        String str;
        String str2;
        String str3;
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return;
        }
        String str4 = (String) extras.get("id");
        if (f133iB.contains(str4)) {
            return;
        }
        if (f133iB.size() > 5) {
            f133iB.clear();
        }
        f133iB.add(str4);
        boolean m17b = C0002a.m17b(context);
        boolean z = context.getSharedPreferences("GLPN", 0).getBoolean("pn_online_enable", true);
        if (m17b && z) {
            Iterator<String> it = extras.keySet().iterator();
            while (it.hasNext()) {
                it.next();
            }
            if (extras == null || extras.isEmpty()) {
                return;
            }
            String str5 = (String) extras.get("subject");
            String str6 = (String) extras.get("reply_to");
            String str7 = (String) extras.get("to");
            String str8 = (String) extras.get("title");
            String str9 = (String) extras.get(ServerProtocol.DIALOG_PARAM_TYPE);
            String str10 = (String) extras.get("body");
            String str11 = (String) extras.get("url");
            String str12 = (String) extras.get("receive");
            String str13 = (String) extras.get("body_loc");
            String str14 = (String) extras.get("title_loc");
            SharedPreferences sharedPreferences = context.getSharedPreferences("GLPN", 0);
            sharedPreferences.getString("UserID", "");
            String str15 = "anonymous:" + sharedPreferences.getString("RandomUserID", "");
            if (str6 == null || str6.equals("None") || C0263i.m554c(context, str6) || str6.equals(str15)) {
                if (str7 == null || str7.equals("None") || C0263i.m554c(context, str7) || str7.equals(str15)) {
                    if (str5 != null && str5.length() != 0) {
                        str8 = str5;
                    } else if (str8 == null || str8.length() <= 0) {
                        str8 = context.getString(C0217R.string.MIDlet_Name);
                    }
                    if (str9 == null || str10 == null) {
                        return;
                    }
                    C0263i.m556cY();
                    extras.putString("friend_id", str6);
                    if (extras.containsKey("customIcon")) {
                        C0263i.f320xR = true;
                        C0263i.f321xS = (String) extras.get("customIcon");
                    } else {
                        C0263i.f320xR = false;
                        C0263i.f321xS = null;
                    }
                    if (str12 == null || !str12.equals("user") || str13 == null) {
                        str = str8;
                    } else {
                        try {
                            str2 = URLEncoder.encode(Locale.getDefault().getLanguage(), "UTF-8").toUpperCase();
                        } catch (Exception e) {
                            str2 = "";
                        }
                        String[] split = str13.split(":");
                        String string = sharedPreferences.getString("PN_TEMPLATE_" + split[0] + "_" + str2, "");
                        if (string.equals("")) {
                            string = sharedPreferences.getString("PN_TEMPLATE_" + split[0] + "_EN", "");
                        }
                        if (string.equals("")) {
                            str3 = str10;
                        } else {
                            str3 = string;
                            for (int i = 1; i < split.length; i++) {
                                str3 = str3.replaceAll("%s" + (i - 1), split[i]);
                            }
                        }
                        str = str14 != null ? sharedPreferences.getString("PN_TEMPLATE_" + str14 + "_" + str2, "") : "";
                        if (str.equals("")) {
                            str = sharedPreferences.getString("PN_TEMPLATE_" + str14 + "_EN", "");
                        }
                        if (str.equals("")) {
                            str10 = str3;
                            str = str8;
                        } else {
                            str10 = str3;
                        }
                    }
                    Intent m531a = C0263i.m531a(context, str9, str11, extras);
                    if (m531a != null) {
                        C0263i.m538a(context, str10, str, m531a);
                    }
                }
            }
        }
    }

    @Override
    protected final boolean mo339b(Context context, String str) {
        return super.mo339b(context, str);
    }

    @Override
    protected final void mo340d(Context context) {
        GCMRegistrar.m2808q(context);
    }
}
