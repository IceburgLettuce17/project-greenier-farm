package p001a.p004b.p005a.p006a;

import android.content.Context;
import android.content.SharedPreferences;
import com.gameloft.android.LATAM.GloftGF2H.C0338r;
import com.gameloft.android.LATAM.GloftGF2H.C0343w;
import com.gameloft.android.LATAM.GloftGF2H.SplashScreenActivity;
import com.gameloft.android2d.iap.p042a.AbstractC0358a;
import com.gameloft.android2d.iap.p042a.p043a.C0359a;
import com.gameloft.android2d.iap.p042a.p044b.C0361a;
import com.gameloft.android2d.iap.p042a.p045c.C0363a;
import com.gameloft.android2d.iap.p042a.p046d.C0365a;
import com.gameloft.android2d.iap.p042a.p047e.C0388j;
import com.gameloft.android2d.iap.p042a.p049f.C0405a;
import com.gameloft.android2d.iap.p042a.p050g.C0407a;
import com.gameloft.android2d.iap.p042a.p051h.C0412d;
import com.gameloft.android2d.iap.p042a.p052i.C0432a;
import com.gameloft.android2d.iap.p042a.p053j.C0441a;
import com.gameloft.android2d.iap.p042a.p054k.C0446a;
import com.gameloft.android2d.iap.p042a.p055l.C0461a;
import com.gameloft.android2d.socialnetwork.C0528l;
import com.gameloft.android2d.socialnetwork.C0532p;
import com.p020a.p021a.p022a.C0119f;
import com.p034e.p035a.p036a.C0182k;
import com.p034e.p035a.p036a.p038b.C0163a;
import com.p034e.p035a.p036a.p038b.InterfaceC0169g;
import java.util.ArrayList;
import java.util.Calendar;
import p009b.p010a.p011a.C0038d;
import p009b.p010a.p011a.C0039e;
import p009b.p010a.p011a.C0044j;
import p009b.p010a.p011a.InterfaceC0035a;
import p009b.p010a.p017f.C0105a;
import p009b.p018b.p019a.C0107b;

public class C0002a {

    C0002a f0a;

    C0002a f1b;

    int f2c;

    ComponentCallbacksC0006e f3d;

    int f4e;

    int f5f;

    int f6g;

    int f7h;

    ArrayList<ComponentCallbacksC0006e> f8i;

    C0002a() {
    }

    public static C0343w m0a(int i) {
        if (C0532p.m2793i() == 0) {
            return null;
        }
        C0528l m2791fg = C0532p.m2791fg(i);
        C0343w c0343w = new C0343w();
        c0343w.afB = m2791fg.afB;
        c0343w.afC = m2791fg.afC;
        c0343w.afD = m2791fg.afD;
        c0343w.afE = m2791fg.afE;
        c0343w.afF = m2791fg.afF;
        c0343w.afI = m2791fg.afI;
        c0343w.afG = m2791fg.afG;
        c0343w.score = m2791fg.score;
        c0343w.afJ = m2791fg.afJ;
        c0343w.f2651vk = i;
        return c0343w;
    }

    public static AbstractC0358a m1a(String str) {
        if (str.equalsIgnoreCase("google")) {
            return new C0388j();
        }
        if (str.equalsIgnoreCase("sms_2d")) {
            return new C0441a();
        }
        if (str.equalsIgnoreCase("http_2d")) {
            return new C0405a();
        }
        if (str.equalsIgnoreCase("cc_2d")) {
            return new C0365a();
        }
        if (str.equalsIgnoreCase("ump_2d")) {
            return new C0446a();
        }
        if (str.equalsIgnoreCase("shenzhoufu_2d")) {
            return new C0432a();
        }
        if (str.equalsIgnoreCase("amazon")) {
            return new C0359a();
        }
        if (str.equalsIgnoreCase("blackberry")) {
            return new C0363a();
        }
        if (str.equalsIgnoreCase("samsung")) {
            return new C0412d();
        }
        if (str.equalsIgnoreCase("wap_cc")) {
            return new C0461a();
        }
        if (str.equalsIgnoreCase("wap_pp")) {
            return new C0407a();
        }
        if (str.equalsIgnoreCase("wap_amazon")) {
            return new C0361a();
        }
        return null;
    }

    public static void m2a(int i, int i2) {
        if (C0338r.f2537ta) {
            C0532p.m2780a(100, 100);
        }
    }

    public static void m3a(Context context, int i) {
        SharedPreferences.Editor edit = context.getSharedPreferences("GLPN", 0).edit();
        edit.putInt("pn_count_push_local", i);
        edit.commit();
    }

    public static void m4a(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("GLPN", 0).edit();
        edit.putString("pn_time_first_push_local", str);
        edit.commit();
    }

    public static void m5a(C0343w c0343w, C0343w[] c0343wArr, String str, String str2) {
        if (C0338r.f2537ta) {
            C0532p.m2781a(c0343w, (C0528l[]) null, str, str2);
        }
    }

    public static void m6a(Exception exc) {
        exc.toString();
    }

    public static void m7a(Object obj, StringBuilder sb) {
        int lastIndexOf;
        if (obj == null) {
            sb.append("null");
            return;
        }
        String simpleName = obj.getClass().getSimpleName();
        if ((simpleName == null || simpleName.length() <= 0) && (lastIndexOf = (simpleName = obj.getClass().getName()).lastIndexOf(46)) > 0) {
            simpleName = simpleName.substring(lastIndexOf + 1);
        }
        sb.append(simpleName);
        sb.append('{');
        sb.append(Integer.toHexString(System.identityHashCode(obj)));
    }

    public static void m8a(String str, C0182k c0182k, String str2, InterfaceC0169g interfaceC0169g) {
        new C0163a(str, str2, c0182k, interfaceC0169g).start();
    }

    public static void m9a(String str, String str2) {
        if (m12a()) {
            C0119f.m255O().mo244a(str, str2);
        }
    }

    public static void m10a(String str, String str2, String str3, String str4) {
        if (C0338r.f2537ta) {
            C0532p.m2782a(str, str2, str3, str4);
        }
    }

    public static void m11a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        if (C0338r.f2537ta) {
            C0532p.m2783a(str, str2, str3, str4, str5, str6, str7, str8, str9);
        }
    }

    public static boolean m12a() {
        return C0119f.m255O().mo245a();
    }

    public static boolean m13a(Context context) {
        if (context.getSharedPreferences("GLPN", 0).getBoolean("pn_dont_disturbe_enable", true)) {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(12) + (calendar.get(11) * 60);
            if (i < 480 || i > 1380) {
                return true;
            }
        }
        return false;
    }

    public static InterfaceC0035a m14b(String str) {
        if ("android://sensorinfo_JSR256_acceleration".equals(str)) {
            if (C0105a.alZ == null) {
                C0105a.alZ = new C0105a();
            }
            return C0105a.alZ;
        }
        if (str.startsWith("sms:") || str.startsWith("sms:".toUpperCase())) {
            return new C0107b(str);
        }
        if (str.startsWith("http://")) {
            return new C0038d(str, 3);
        }
        if (str.startsWith("https://")) {
            return new C0039e(str, 3);
        }
        if (str.startsWith("socket://")) {
            return new C0044j(str);
        }
        return null;
    }

    public static void m15b() {
        if (C0338r.f2537ta) {
            C0532p.m2784b();
        }
    }

    public static void m16b(String str, String str2) {
        if (C0119f.m255O().mo243P()) {
            C0119f.m255O().mo246b(str, str2);
        }
    }

    public static boolean m17b(Context context) {
        return context.getSharedPreferences("GLPN", 0).getBoolean("enablePushNotification", true);
    }

    public static void m18c() {
        if (C0338r.f2537ta) {
            C0532p.m2785c();
        }
    }

    public static void m19c(String str, String str2) {
        if (C0338r.f2537ta) {
            C0532p.m2786c(str, str2);
        }
    }

    public static void m20d() {
        if (C0338r.f2537ta) {
            C0532p.m2787d();
        }
    }

    public static boolean m21e() {
        if (C0338r.f2537ta) {
            return C0532p.m2789e();
        }
        return false;
    }

    public static boolean m22f() {
        if (C0338r.f2537ta) {
            return C0532p.m2790f();
        }
        return false;
    }

    public static boolean m23g() {
        if (C0338r.f2537ta) {
            return C0532p.m2792g();
        }
        return false;
    }

    public static String getPassword() {
        return C0338r.f2537ta ? C0532p.getPassword() : "";
    }

    public static C0343w m24h() {
        if (!C0338r.f2537ta) {
            return new C0343w();
        }
        C0528l m2794tw = C0532p.m2794tw();
        C0343w c0343w = new C0343w();
        c0343w.afB = m2794tw.afB;
        c0343w.afC = m2794tw.afC;
        c0343w.afD = m2794tw.afD;
        c0343w.afE = m2794tw.afE;
        c0343w.afF = m2794tw.afF;
        c0343w.afI = m2794tw.afI;
        c0343w.afG = m2794tw.afG;
        c0343w.score = m2794tw.score;
        c0343w.afJ = m2794tw.afJ;
        c0343w.f2651vk = -2;
        return c0343w;
    }

    public static int m25i() {
        return C0532p.m2793i();
    }

    public static boolean isRunning() {
        return SplashScreenActivity.f342yU;
    }

    public static C0343w[] m26j() {
        if (C0338r.f2537ta) {
            try {
                C0343w[] c0343wArr = new C0343w[C0532p.m2793i()];
                for (int i = 0; i < C0532p.m2793i(); i++) {
                    c0343wArr[i] = m0a(i);
                }
                return c0343wArr;
            } catch (Exception e) {
            }
        }
        return null;
    }
}
