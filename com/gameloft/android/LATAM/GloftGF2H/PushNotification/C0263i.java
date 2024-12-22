package com.gameloft.android.LATAM.GloftGF2H.PushNotification;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.gameloft.android.LATAM.GloftGF2H.C0320bt;
import com.gameloft.android.wrapper.C0355i;
import com.google.android.gcm.GCMRegistrar;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.AllowAllHostnameVerifier;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p001a.p004b.p005a.p006a.C0002a;
import p009b.p010a.p015d.AbstractActivityC0092a;

public class C0263i extends BroadcastReceiver {

    private static ArrayList<String> f325xW;

    private static Bundle f326xX;

    public static WeakReference<Activity> f327xY;

    private static int f328xZ;

    private static boolean f332yd;

    private static boolean[] f333ye;

    private static int[] f334yf;

    private static boolean f316xN = false;

    private static boolean f317xO = false;

    private static boolean f318xP = false;

    static boolean[] f319xQ = new boolean[2];

    public static boolean f320xR = false;

    public static String f321xS = null;

    private static C0263i f322xT = null;

    public static String f323xU = "PANDORA_URL";

    public static String f324xV = "CLIENTID";

    static boolean f329ya = true;

    private static String[] f330yb = {"EN", "FR", "DE", "ES", "IT", "BR", "PT", "TR", "RU", "PL", "ZT", "JA", "ZH", "KO", "TH", "VI", "AR", "TK", "ID"};

    static String f331yc = "gllive";

    static {
        f332yd = Build.VERSION.SDK_INT < 8;
        f333ye = new boolean[7];
        f334yf = new int[7];
    }

    static void m529H(int i, int i2) {
        f334yf[i] = i2;
    }

    public synchronized void m530I(int i, int i2) {
        m536a(i, i2, new Bundle());
    }

    public static Intent m531a(Context context, String str, String str2, Bundle bundle) {
        if (!str.equals("url") && !str.equals("igpcode")) {
            if (!str.equals("play") && !str.equals("launch")) {
                Intent intent = new Intent();
                intent.setFlags(268435456);
                return intent;
            }
            Intent intent2 = new Intent();
            intent2.setFlags(67108864);
            intent2.setClassName("com.gameloft.android.LATAM.GloftGF2H", "com.gameloft.android.LATAM.GloftGF2H.Start");
            intent2.setAction("android.intent.action.MAIN");
            intent2.addCategory("android.intent.category.LAUNCHER");
            if (bundle != null) {
                intent2.putExtra("pn_data_bundle", bundle);
            }
            if (str.equals("play")) {
                intent2.putExtra("pn_goto_multiplayer", true);
            }
            intent2.putExtra("START_FROM_PUSH", true);
            return intent2;
        }
        if (!m546ax(str2)) {
            try {
                if (str.equals("igpcode")) {
                    if (C0355i.getContext() == null) {
                        C0355i.setContext(context);
                    }
                    String country = Locale.getDefault().getCountry();
                    String str3 = Build.MANUFACTURER + "_" + Build.MODEL;
                    String str4 = Build.VERSION.RELEASE;
                    String language = Locale.getDefault().getLanguage();
                    String string = context.getSharedPreferences("GLPN", 0).getString("PN_GAME_VERSION", "");
                    str2 = (str2 + "&udid=" + C0355i.m2204i(context)) + "&d=" + str3 + "&f=" + str4 + "&country=" + country + "&lg=" + language + "&t=PUSH&game_ver=" + string + "&ver=" + string;
                }
                Intent intent3 = new Intent("android.intent.action.VIEW", Uri.parse(str2));
                intent3.setFlags(268435456);
                return intent3;
            } catch (Exception e) {
            }
        }
        Intent intent4 = new Intent();
        intent4.setFlags(268435456);
        return intent4;
    }

    private static String m532a(Context context, Bundle bundle, String str, String str2, boolean z) {
        String[] strArr;
        int i;
        String str3;
        String str4 = "e";
        String str5 = new String();
        String str6 = new String();
        String str7 = new String();
        String[] strArr2 = new String[3];
        if (bundle != null) {
            String str8 = str5;
            String str9 = str6;
            String str10 = str7;
            for (String str11 : bundle.keySet()) {
                if (str11.equals("body")) {
                    str9 = (String) bundle.get("body");
                } else if (str11.equals("username")) {
                    str8 = (String) bundle.get("username");
                } else {
                    str10 = !m546ax(str11) ? str10 + "&X_" + str11 + "=" + m547ay((String) bundle.get(str11)) : str10;
                }
            }
            strArr2[0] = str8;
            strArr2[1] = str9;
            strArr2[2] = str10;
            strArr = strArr2;
        } else {
            strArr = null;
        }
        if (strArr != null) {
            String str12 = strArr[1];
            String str13 = strArr[2];
            String str14 = m546ax(str) ? "1" : str;
            try {
                i = Integer.parseInt(str14);
            } catch (Exception e) {
                i = 0;
            }
            if (i > 0) {
                SharedPreferences sharedPreferences = context.getSharedPreferences("GLPN", 0);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                String str15 = "";
                String str16 = "";
                for (String str17 : bundle.keySet()) {
                    if (str17.equals("infopush")) {
                        str16 = (String) bundle.get("infopush");
                    } else {
                        str15 = str17.equals("per_of_day") ? (String) bundle.get("per_of_day") : str15;
                    }
                }
                if (!str16.equals("") && !str15.equals("") && !sharedPreferences.contains("info_" + str16)) {
                    edit.putInt("info_" + str16, Integer.parseInt(str15));
                    edit.putInt("count_" + str16, 0);
                    edit.commit();
                }
                if (f332yd || i <= C0258d.f311xI) {
                    String m517a = C0258d.m517a(bundle, i);
                    m575w(m517a, "0");
                    return m517a;
                }
                String string = sharedPreferences.getString("RandomUserID", null);
                String string2 = sharedPreferences.getString("RandomUserToken", null);
                if (m546ax(string2)) {
                    f334yf[2] = 1002;
                } else if (m546ax(string)) {
                    f334yf[2] = 1001;
                    str3 = "e";
                } else {
                    String str18 = "anonymous:" + string;
                    if (z) {
                        int i2 = f328xZ + 1;
                        f328xZ = i2;
                        f328xZ = i2 % 512;
                        String sb = new StringBuilder().append(f328xZ).toString();
                        bundle.putString("pn_request_id", sb);
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("juid", str18);
                        bundle2.putString("jlbl", str2);
                        bundle2.putString("jbdy", str12);
                        bundle2.putString("jdly", str14);
                        bundle2.putString("jtkn", string2);
                        bundle2.putString("jxtr", str13);
                        bundle2.putString("jrqst", sb);
                        bundle2.putInt("jrtry", 3);
                        f322xT.m564e(bundle2);
                        return "p";
                    }
                    str3 = m549b(str18, str2, str12, str14, string2, str13);
                }
            } else {
                f334yf[2] = 1006;
                str3 = "e";
            }
            str4 = str3;
        } else {
            f334yf[2] = 1005;
        }
        str4.compareTo("e");
        return str4;
    }

    public static String m533a(String str, String str2, String str3, int i) {
        String str4;
        String m559d = m559d("auth", i);
        if (m546ax(m559d)) {
            return "";
        }
        String str5 = "https://" + m559d + "/authorize";
        String str6 = "?client_id=" + f324xV + "&username=" + str + "&password=" + str2 + "&credential_type=" + str3 + "&device_id=" + C0355i.getDeviceId() + "&scope=message%20auth&access_token_only=true";
        Locale locale = Locale.getDefault();
        String m547ay = m547ay(Build.MODEL);
        String m547ay2 = m547ay(C0355i.getNetworkOperator());
        String m547ay3 = m547ay(C0355i.getNetworkCountryIso());
        String m547ay4 = m547ay(locale.getLanguage());
        String upperCase = m547ay4.toUpperCase();
        int i2 = 0;
        for (int i3 = 0; i3 < f330yb.length && !upperCase.equals(f330yb[i3]); i3++) {
            i2++;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(m535a(new URL(str5 + (str6 + "&device_model=" + m547ay + "&device_carrier=" + m547ay2 + "&device_country=" + m547ay3 + "&device_language=" + (i2 >= f330yb.length ? "en" : m547ay4))), false).getInputStream()));
            str4 = null;
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                str4 = readLine;
            }
        } catch (UnknownHostException e) {
            f334yf[i] = 2020;
        } catch (IOException e2) {
            f334yf[i] = 3001;
        } catch (Exception e3) {
            f334yf[i] = 1002;
        }
        if (!m546ax(str4)) {
            return str4;
        }
        f334yf[i] = 1002;
        return "";
    }

    public static String m534a(Hashtable hashtable, String str, String str2, boolean z) {
        Bundle bundle = new Bundle();
        Enumeration keys = hashtable.keys();
        while (keys.hasMoreElements()) {
            Object nextElement = keys.nextElement();
            bundle.putString((String) nextElement, (String) hashtable.get(nextElement));
        }
        return m532a(f327xY.get(), bundle, str, str2, true);
    }

    private static HttpsURLConnection m535a(URL url, boolean z) {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{new C0264j()}, null);
            HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext.getSocketFactory());
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
            try {
                httpsURLConnection.setConnectTimeout(5000);
                httpsURLConnection.setHostnameVerifier(new AllowAllHostnameVerifier());
                httpsURLConnection.setDoOutput(true);
                httpsURLConnection.setUseCaches(false);
                HttpsURLConnection.setFollowRedirects(true);
                httpsURLConnection.setRequestProperty("Connection", "Keep-Alive");
                if (f318xP) {
                    f318xP = false;
                    httpsURLConnection.setDoOutput(false);
                    httpsURLConnection.setRequestMethod("DELETE");
                } else if (z) {
                    httpsURLConnection.setRequestMethod("POST");
                    httpsURLConnection.setDoInput(true);
                } else {
                    httpsURLConnection.setRequestMethod("GET");
                }
                return httpsURLConnection;
            } catch (Exception e) {
                return httpsURLConnection;
            }
        } catch (Exception e2) {
            return null;
        }
    }

    public synchronized void m536a(int i, int i2, Bundle bundle) {
        Activity activity = f327xY.get();
        if (i2 == -1) {
            int i3 = bundle.getInt("jrtry", 0);
            if (i3 == 0) {
                m550b(i, -2, bundle);
            } else {
                bundle.putInt("jrtry", i3 - 1);
                Intent intent = new Intent("com.gameloft.android.LATAM.GloftGF2H.PN_RETRY_REGITER_ACTION");
                long j = bundle.getLong("jbckff", 20000L);
                long currentTimeMillis = System.currentTimeMillis() + j;
                bundle.putLong("jbckff", j << 1);
                intent.putExtra("pn_rqstType", i);
                intent.putExtra("pn_rqstParams", bundle);
                f333ye[i] = true;
                activity.registerReceiver(f322xT, new IntentFilter("com.gameloft.android.LATAM.GloftGF2H.PN_RETRY_REGITER_ACTION"));
                ((AlarmManager) activity.getSystemService("alarm")).set(0, currentTimeMillis, PendingIntent.getBroadcast(activity, i + 1, intent, 134217728));
            }
        } else {
            f333ye[i] = false;
            if (!m563dc()) {
                try {
                    activity.unregisterReceiver(f322xT);
                } catch (Exception e) {
                }
            }
        }
        m550b(i, i2, bundle);
    }

    public static void m537a(Activity activity) {
        f327xY = new WeakReference<>(activity);
        if (f322xT == null) {
            f322xT = new C0263i();
        }
        if (f332yd) {
            f334yf[5] = 1000;
        } else if (m546ax(m562db())) {
            if (f322xT == null) {
                f322xT = new C0263i();
            }
            GCMRegistrar.m2796a(f327xY.get(), "108176907654");
            f334yf[5] = 2001;
        } else {
            f334yf[5] = 0;
        }
        C0258d.m519aO();
        f325xW = new ArrayList<>();
        SharedPreferences sharedPreferences = activity.getSharedPreferences("GLPN", 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        if (!sharedPreferences.contains("enablePushNotification")) {
            edit.putBoolean("enablePushNotification", true);
        }
        if (!sharedPreferences.contains("pn_local_enable")) {
            edit.putBoolean("pn_local_enable", true);
        }
        if (!sharedPreferences.contains("pn_remote_enable")) {
            edit.putBoolean("pn_remote_enable", true);
        }
        if (!sharedPreferences.contains("pn_online_enable")) {
            edit.putBoolean("pn_online_enable", true);
        }
        if (!sharedPreferences.contains("pn_dont_disturbe_enable")) {
            edit.putBoolean("pn_dont_disturbe_enable", true);
            edit.putInt("pn_dont_disturbe_start", 1380);
            edit.putInt("pn_dont_disturbe_end", 480);
        }
        if (!sharedPreferences.contains("pn_count_push_local")) {
            edit.putInt("pn_count_push_local", 0);
        }
        if (!sharedPreferences.contains("pn_time_first_push_local")) {
            edit.putString("pn_time_first_push_local", C0258d.m522av("0"));
        }
        edit.commit();
        C0270p.m578h(activity);
        f316xN = true;
        m551b(activity.getIntent());
        SharedPreferences.Editor edit2 = activity.getSharedPreferences("GLPN", 0).edit();
        edit2.putString("PN_GAME_VERSION", AbstractActivityC0092a.m209a(activity, "MIDlet-Version"));
        edit2.commit();
    }

    public static void m538a(Context context, String str, String str2, Intent intent) {
        Bundle bundle;
        long currentTimeMillis = System.currentTimeMillis();
        SharedPreferences sharedPreferences = context.getSharedPreferences("GLPN", 0);
        int i = sharedPreferences.getInt("notificationID", 0);
        C0270p.m578h(context);
        AbstractC0259e c0260f = (Build.VERSION.SDK_INT < 13 || Build.MANUFACTURER.equalsIgnoreCase("motorola")) ? new C0260f(context) : Build.VERSION.SDK_INT < 16 ? new C0261g(context) : new C0262h(context);
        c0260f.f313xK = str2;
        c0260f.f312xJ = str;
        c0260f.when = currentTimeMillis;
        c0260f.f314xL = PendingIntent.getActivity(context, i, intent, 0);
        c0260f.f315xM = true;
        ((NotificationManager) context.getSystemService("notification")).notify(i, c0260f.mo528cX());
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt("notificationID", (i + 1) % 32);
        edit.commit();
        Bundle extras = intent.getExtras();
        Bundle bundle2 = new Bundle();
        if (extras != null && (bundle = extras.getBundle("pn_data_bundle")) != null) {
            bundle2.putAll(bundle);
        }
        m560d(bundle2);
        C0320bt.m1850oO();
    }

    private static List<String> m541aA(String str) {
        String string = f327xY.get().getSharedPreferences("GLPN", 0).getString("LocalPNType_" + str, null);
        if (string == null) {
            return null;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(string, "|");
        ArrayList arrayList = new ArrayList();
        while (stringTokenizer.hasMoreTokens()) {
            arrayList.add(stringTokenizer.nextToken());
        }
        return arrayList;
    }

    public static void m542aB(String str) {
        boolean z;
        List<String> m569g = m569g(f327xY.get());
        List<String> arrayList = m569g == null ? new ArrayList() : m569g;
        Iterator<String> it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            } else if (it.next().equals(str)) {
                z = true;
                break;
            }
        }
        if (z) {
            return;
        }
        arrayList.add(str);
        String str2 = "";
        Iterator<String> it2 = arrayList.iterator();
        while (true) {
            String str3 = str2;
            if (!it2.hasNext()) {
                SharedPreferences.Editor edit = f327xY.get().getSharedPreferences("GLPN", 0).edit();
                edit.putString("UserID", str3);
                edit.commit();
                return;
            }
            str2 = str3 + it2.next() + "|";
        }
    }

    public static int m545aZ(int i) {
        return f334yf[i];
    }

    public static boolean m546ax(String str) {
        return str == null || str.length() == 0;
    }

    private static String m547ay(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (Exception e) {
            return "";
        }
    }

    public static int m548az(String str) {
        String m559d = m559d("message", 3);
        if (m546ax(m559d)) {
            return 0;
        }
        String str2 = "https://" + m559d + "/users/me/credentials";
        String string = f327xY.get().getSharedPreferences("GLPN", 0).getString("RandomUserToken", null);
        try {
            URL url = new URL(("https://" + m559d + "/messages/gcm/me") + (str.equals("Cancel_ALL") ? "?access_token=" + m547ay(string) : "?access_token=" + m547ay(string) + "&msgids=" + str));
            f318xP = true;
            int responseCode = m535a(url, true).getResponseCode();
            if (responseCode == 200 || responseCode == 404) {
                synchronized (f325xW) {
                    if (str.equals("Cancel_ALL")) {
                        f325xW.clear();
                    } else {
                        f325xW.remove(str);
                    }
                }
                return 1;
            }
        } catch (UnknownHostException e) {
            f334yf[3] = 2020;
        } catch (Exception e2) {
            f334yf[3] = 9999;
        }
        return 0;
    }

    static String m549b(String str, String str2, String str3, String str4, String str5, String str6) {
        String m559d = m559d("message", 2);
        if (m546ax(m559d)) {
            return "e";
        }
        String str7 = "https://" + m559d + "/messages/gcm/" + str;
        String str8 = !m546ax(str2) ? "body=" + m547ay(str3) + "&delay=" + str4 + "&replace_label=" + m547ay(str2) + "&access_token=" + str5 + str6 : "body=" + m547ay(str3) + "&delay=" + str4 + "&access_token=" + str5 + str6;
        try {
            HttpsURLConnection m535a = m535a(new URL(str7), true);
            DataOutputStream dataOutputStream = new DataOutputStream(m535a.getOutputStream());
            dataOutputStream.writeBytes(str8);
            dataOutputStream.close();
            String str9 = "e";
            int responseCode = m535a.getResponseCode();
            if (responseCode != 200) {
                if (responseCode == 404) {
                    f334yf[2] = 4001;
                    return "e";
                }
                f334yf[2] = 9999;
                return "e";
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(m535a.getInputStream()));
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                stringBuffer.append(readLine);
                stringBuffer.append('\r');
            }
            bufferedReader.close();
            try {
                str9 = new JSONObject(stringBuffer.toString()).getString("id");
            } catch (JSONException e) {
                try {
                    str9 = new JSONObject(new JSONArray(stringBuffer.toString()).get(0).toString()).getString("id");
                } catch (JSONException e2) {
                    f334yf[2] = 4002;
                }
            }
            synchronized (f325xW) {
                f325xW.add(str9);
            }
            return str9;
        } catch (UnknownHostException e3) {
            f334yf[2] = 2020;
            return "e";
        } catch (Exception e4) {
            f334yf[2] = 9999;
            return "e";
        }
    }

    private static synchronized void m550b(int i, int i2, Bundle bundle) {
        synchronized (C0263i.class) {
            Hashtable hashtable = new Hashtable();
            if (bundle != null) {
                for (String str : bundle.keySet()) {
                    if (!m546ax(str) && bundle.get(str) != null) {
                        if (bundle.get(str) instanceof String) {
                            hashtable.put(str, m547ay((String) bundle.get(str)));
                        } else {
                            hashtable.put(str, bundle.get(str));
                        }
                    }
                }
            }
            C0320bt.m1055a(i, i2, hashtable);
        }
    }

    private static void m551b(Intent intent) {
        Bundle extras;
        if (intent == null || (extras = intent.getExtras()) == null || (intent.getFlags() & 1048576) != 0) {
            return;
        }
        f317xO = extras.getBoolean("pn_goto_multiplayer", false);
        f326xX = new Bundle();
        Bundle bundle = extras.getBundle("pn_data_bundle");
        if (bundle != null) {
            f326xX.putAll(bundle);
        }
        f326xX.putInt("pn_launch_game", f316xN ? 1 : 0);
        f326xX.putInt("pn_goto_multiplayer", f317xO ? 1 : 0);
        extras.remove("pn_goto_multiplayer");
        extras.remove("pn_data_bundle");
        if (extras.getBoolean("START_FROM_PUSH", false)) {
            AbstractActivityC0092a.m211uy();
            C0320bt.m1068a(m560d(f326xX));
        }
    }

    private static int m552ba(int i) {
        List<String> m541aA = m541aA(Integer.toString(0));
        if (m541aA == null) {
            return 1;
        }
        for (String str : m541aA) {
            try {
                if (m546ax(str) || !str.startsWith("PN_LID_")) {
                    return 1;
                }
                C0258d.m520at(str);
            } catch (Exception e) {
                return 1;
            }
        }
        String str2 = "LocalPNType_" + Integer.toString(0);
        SharedPreferences.Editor edit = f327xY.get().getSharedPreferences("GLPN", 0).edit();
        edit.putString(str2, null);
        edit.commit();
        m541aA(Integer.toString(0));
        return 0;
    }

    public static int m553c(String str, String str2, String str3) {
        f331yc = str3;
        Bundle bundle = new Bundle();
        bundle.putString("juid", str);
        bundle.putString("jusrpss", str2);
        bundle.putString("jusrcred", f331yc);
        bundle.putLong("jbckff", 20000L);
        bundle.putInt("jrtry", 3);
        return f322xT.m567f(bundle);
    }

    public static boolean m554c(Context context, String str) {
        List<String> m569g = m569g(context);
        if (m569g == null) {
            return false;
        }
        Iterator<String> it = m569g.iterator();
        while (it.hasNext()) {
            if (it.next().equals(str)) {
                return true;
            }
        }
        return false;
    }

    static String m555cK() {
        if (m546ax("com.gameloft.android.LATAM.GloftGF2H") || m546ax(C0355i.getDeviceId()) || m546ax(Build.MANUFACTURER) || m546ax(Build.MODEL)) {
            return null;
        }
        return ("com.gameloft.android.LATAM.GloftGF2H." + Build.MANUFACTURER + "." + Build.MODEL + "." + C0355i.getDeviceId()).replace(" ", "_");
    }

    public static boolean m556cY() {
        return false;
    }

    public static void m557cZ() {
        f334yf[5] = 0;
    }

    public static int m558d(String str, String str2, String str3) {
        String m559d = m559d("auth", 1);
        if (m546ax(m559d) || m546ax(str) || m546ax(str2) || m546ax(str3)) {
            f334yf[1] = 1001;
            return -1;
        }
        String str4 = ((("access_token=" + str3) + "&credential=" + str) + "&password=" + str2) + "&if_exists=relink";
        try {
            HttpsURLConnection m535a = m535a(new URL("https://" + m559d + "/users/me/credentials"), true);
            DataOutputStream dataOutputStream = new DataOutputStream(m535a.getOutputStream());
            dataOutputStream.writeBytes(str4);
            dataOutputStream.close();
            if (m535a.getResponseCode() == 200) {
                return 0;
            }
        } catch (Exception e) {
        }
        f334yf[1] = 4002;
        return -1;
    }

    private static synchronized String m559d(String str, int i) {
        String str2;
        synchronized (C0263i.class) {
            try {
                HttpEntity entity = new DefaultHttpClient().execute(new HttpGet(f323xU + "/locate?service=" + str)).getEntity();
                str2 = "";
                if (entity != null) {
                    str2 = EntityUtils.toString(entity);
                }
            } catch (UnknownHostException e) {
                f334yf[i] = 2020;
                str2 = null;
                return str2;
            } catch (Exception e2) {
                f334yf[i] = 9999;
                str2 = null;
                return str2;
            }
        }
        return str2;
    }

    private static Hashtable m560d(Bundle bundle) {
        Hashtable hashtable = new Hashtable();
        String str = new String();
        String str2 = new String();
        new String();
        if (bundle == null) {
            return null;
        }
        String str3 = str2;
        String str4 = str;
        for (String str5 : bundle.keySet()) {
            if (str5.equals("body")) {
                str3 = (String) bundle.get("body");
            } else if (str5.equals("username")) {
                str4 = (String) bundle.get("username");
            } else if (!m546ax(str5) && bundle.get(str5) != null) {
                if (bundle.get(str5) instanceof String) {
                    hashtable.put(str5, m547ay((String) bundle.get(str5)));
                } else {
                    hashtable.put(str5, bundle.get(str5));
                }
            }
        }
        hashtable.put("username", str4);
        hashtable.put("body", str3);
        return hashtable;
    }

    public static int m561da() {
        Bundle bundle = new Bundle();
        bundle.putInt("jrtry", 3);
        bundle.putLong("jbckff", 20000L);
        return f322xT.m571h(bundle);
    }

    private static String m562db() {
        String str;
        Activity activity = f327xY.get();
        SharedPreferences sharedPreferences = activity.getSharedPreferences("GLPN", 0);
        String string = sharedPreferences.getString("PN_regId", "");
        if (m546ax(string)) {
            str = "";
        } else {
            if (sharedPreferences.getInt("PN_appVersion", Integer.MIN_VALUE) == m566f(activity)) {
                if (!(System.currentTimeMillis() > f327xY.get().getSharedPreferences("GLPN", 0).getLong("PN_regId_ExpirationTimeMs", -1L))) {
                    str = string;
                }
            }
            str = "";
        }
        if (m546ax(str)) {
            String m2805n = GCMRegistrar.m2805n(f327xY.get());
            if (!m546ax(m2805n)) {
                Activity activity2 = f327xY.get();
                SharedPreferences sharedPreferences2 = activity2.getSharedPreferences("GLPN", 0);
                int m566f = m566f(activity2);
                long currentTimeMillis = System.currentTimeMillis() + 604800000;
                SharedPreferences.Editor edit = sharedPreferences2.edit();
                edit.putString("PN_regId", m2805n);
                edit.putInt("PN_appVersion", m566f);
                edit.putLong("PN_regId_ExpirationTimeMs", currentTimeMillis);
                edit.commit();
            }
            str = m2805n;
        }
        return !m546ax(str) ? str : "";
    }

    private static boolean m563dc() {
        for (int i = 0; i < 7; i++) {
            if (f333ye[i]) {
                return true;
            }
        }
        return false;
    }

    private void m564e(Bundle bundle) {
        new C0266l(this).m516c(bundle);
    }

    static boolean m565e(String str, int i) {
        String m562db = m562db();
        if (m546ax(m562db)) {
            f334yf[i] = 2001;
            return false;
        }
        String m559d = m559d("message", i);
        if (m546ax(m559d)) {
            return false;
        }
        String str2 = "https://" + m559d + "/transports/gcm/endpoints/" + m562db;
        String str3 = "access_token=" + str;
        try {
            HttpsURLConnection m535a = m535a(new URL(str2), true);
            DataOutputStream dataOutputStream = new DataOutputStream(m535a.getOutputStream());
            dataOutputStream.writeBytes(str3);
            dataOutputStream.close();
            int responseCode = m535a.getResponseCode();
            if (responseCode == 200 || responseCode == 409) {
                return true;
            }
        } catch (Exception e) {
        }
        f334yf[i] = 4002;
        return false;
    }

    private static int m566f(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            return 0;
        }
    }

    private int m567f(Bundle bundle) {
        new C0268n(this).m516c(bundle);
        return 0;
    }

    private static boolean m568f(String str, int i) {
        String m559d = m559d("message", 6);
        if (m546ax(m559d)) {
            return false;
        }
        String str2 = "access_token=" + str;
        try {
            HttpsURLConnection m535a = m535a(new URL("https://" + m559d + "/transports/gcm/endpoints/delete"), true);
            DataOutputStream dataOutputStream = new DataOutputStream(m535a.getOutputStream());
            dataOutputStream.writeBytes(str2);
            dataOutputStream.close();
            int responseCode = m535a.getResponseCode();
            if (responseCode == 200 || responseCode == 409) {
                return true;
            }
        } catch (Exception e) {
        }
        f334yf[6] = 4002;
        return false;
    }

    private static List<String> m569g(Context context) {
        ArrayList arrayList = null;
        String string = context.getSharedPreferences("GLPN", 0).getString("UserID", null);
        if (string != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(string, "|");
            arrayList = new ArrayList();
            while (stringTokenizer.hasMoreTokens()) {
                arrayList.add(stringTokenizer.nextToken());
            }
        }
        return arrayList;
    }

    private void m570g(Bundle bundle) {
        new C0265k(this).m516c(bundle);
    }

    private int m571h(Bundle bundle) {
        new C0267m(this).m516c(bundle);
        return 0;
    }

    public static void onNewIntent(Intent intent) {
        boolean m17b = C0002a.m17b(f327xY.get());
        f316xN = false;
        if (m17b) {
            m551b(intent);
        }
    }

    public static void m572p(boolean z) {
        Activity activity = f327xY.get();
        String m214di = AbstractActivityC0092a.akM.m214di("Has-Push-Notification");
        if (m214di != null && m214di.compareTo("1") != 0) {
            z = false;
        }
        SharedPreferences.Editor edit = activity.getSharedPreferences("GLPN", 0).edit();
        edit.putBoolean("enablePushNotification", z);
        edit.commit();
        if (z) {
            return;
        }
        m573q(true);
    }

    public static void m573q(boolean z) {
        synchronized (f325xW) {
            new ArrayList(f325xW);
        }
        if (m546ax(f327xY.get().getSharedPreferences("GLPN", 0).getString("RandomUserToken", null))) {
            f334yf[3] = 1002;
        } else if (m546ax("Cancel_ALL")) {
            f334yf[3] = 1004;
        } else if ("Cancel_ALL".startsWith("PN_LID_")) {
            C0258d.m520at("Cancel_ALL");
        } else if (f334yf[5] == 0 || f334yf[5] == 2001) {
            Bundle bundle = new Bundle();
            bundle.putString("jphid", "Cancel_ALL");
            bundle.putInt("jrtry", 3);
            f322xT.m570g(bundle);
        } else {
            f334yf[3] = f334yf[5];
        }
        C0258d.m525cW();
        m552ba(0);
    }

    public static int m574v(String str, String str2) {
        if (f332yd) {
            f334yf[0] = 1000;
            return -1;
        }
        if (f334yf[5] != 0 && f334yf[5] != 2001) {
            f334yf[0] = f334yf[5];
            return -1;
        }
        C0355i.setContext(f327xY.get());
        String deviceId = C0355i.getDeviceId();
        if (m546ax(str)) {
            f334yf[0] = 1001;
        } else if (m546ax(str2)) {
            f334yf[0] = 1002;
        } else if (m546ax(deviceId)) {
            f334yf[0] = 1003;
        } else {
            m568f(str2, 6);
            if (m565e(str2, 0)) {
                SharedPreferences.Editor edit = f327xY.get().getSharedPreferences("GLPN", 0).edit();
                edit.putString("RandomUserID", str);
                edit.putString("RandomUserToken", str2);
                edit.commit();
                f319xQ[0] = true;
                return 0;
            }
        }
        return -1;
    }

    private static void m575w(String str, String str2) {
        List m541aA = m541aA(str2);
        if (m541aA == null) {
            m541aA = new ArrayList();
        }
        m541aA.add(str);
        String str3 = "";
        Iterator it = m541aA.iterator();
        while (it.hasNext()) {
            str3 = str3 + ((String) it.next()) + "|";
        }
        SharedPreferences.Editor edit = f327xY.get().getSharedPreferences("GLPN", 0).edit();
        edit.putString("LocalPNType_" + str2, str3);
        edit.commit();
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent == null || intent.getAction().compareTo("com.gameloft.android.LATAM.GloftGF2H.PN_RETRY_REGITER_ACTION") != 0) {
            return;
        }
        int intExtra = intent.getIntExtra("pn_rqstType", -1);
        Bundle bundleExtra = intent.getBundleExtra("pn_rqstParams");
        switch (intExtra) {
            case 0:
                m571h(bundleExtra);
                break;
            case 1:
                if (!f329ya) {
                    m567f(bundleExtra);
                    break;
                } else {
                    new C0269o(this).m516c(bundleExtra);
                    break;
                }
            case 2:
                m564e(bundleExtra);
                break;
            case 3:
                m570g(bundleExtra);
                break;
        }
    }
}
