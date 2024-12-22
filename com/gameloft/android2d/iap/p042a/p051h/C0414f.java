package com.gameloft.android2d.iap.p042a.p051h;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.RemoteException;
import com.facebook.android.C0217R;
import com.gameloft.android2d.iap.InterfaceC0357a;
import com.gameloft.android2d.iap.p042a.AbstractC0358a;
import com.gameloft.android2d.iap.utils.C0488o;
import com.gameloft.android2d.iap.utils.C0492s;
import com.p026c.p027a.p028a.InterfaceC0146a;
import p001a.p004b.p005a.p006a.C0012k;

public class C0414f implements InterfaceC0357a {
    Context mContext;
    InterfaceC0146a acy = null;
    ServiceConnection aaT = null;
    public boolean acz = false;
    int acA = 1;

    public C0414f(Context context) {
        this.mContext = context.getApplicationContext();
    }

    private Bundle m2364a(String str, int i, int i2, String str2) {
        try {
            return this.acy.mo272a(this.acA, this.mContext.getPackageName(), str, 1, 15, str2);
        } catch (RemoteException e) {
            C0012k.m40b("SamsungIAB", "Exception: " + e.getMessage());
            return null;
        }
    }

    public static void m2367a(AbstractC0358a abstractC0358a) {
        m2384h(abstractC0358a.f2744Zq, 20);
        m2384h(abstractC0358a.f2741ZQ, 21);
        m2384h(abstractC0358a.url, 22);
        m2384h(abstractC0358a.f2743ZS, 23);
        m2384h(abstractC0358a.f2750Zw, 24);
        m2384h(abstractC0358a.f2751Zx, 25);
        m2384h(abstractC0358a.f2728ZD, 26);
        String str = abstractC0358a.f2745Zr;
        if (str != null) {
            str = str.replace(',', '.');
        }
        m2384h(str, 8);
    }

    public static String m2368am(String str) {
        try {
            return C0488o.getContext().getSharedPreferences("SMSPrefsFile", 0).getString(str, "");
        } catch (Exception e) {
            return "";
        }
    }

    public static void m2369c(String[] strArr) {
        String str = "";
        if (strArr != null) {
            for (String str2 : strArr) {
                str = str + str2 + ";";
            }
        }
        m2387r(f2724wS[19], C0492s.m2704cV(str));
    }

    public static boolean m2370cA() {
        String m2368am = m2368am(f2724wS[0]);
        return m2368am != null && m2368am.equals("1");
    }

    public static boolean m2371cB() {
        String m2368am = m2368am(f2724wS[4]);
        return m2368am != null && m2368am.equals("1");
    }

    public static long m2372cF() {
        String m2368am = m2368am(f2724wS[18]);
        if (m2368am == null || m2368am.length() == 0) {
            return 0L;
        }
        try {
            return Long.parseLong(C0492s.m2705cW(m2368am));
        } catch (Exception e) {
            return 0L;
        }
    }

    public static void m2373ci(String str) {
        m2387r(f2724wS[8], str);
    }

    public static void m2374cj(String str) {
        m2387r(f2724wS[9], str);
    }

    public static void m2375ck(String str) {
        m2387r(f2724wS[13], str);
    }

    public static void m2376cl(String str) {
        m2387r(f2724wS[18], C0492s.m2704cV(str));
    }

    public static void m2377cm(String str) {
        m2387r(f2724wS[10], str);
    }

    public static int m2378cn() {
        String m2368am = m2368am(f2724wS[2]);
        if (m2368am == null || m2368am.length() == 0) {
            return -1;
        }
        try {
            return Integer.parseInt(m2368am);
        } catch (Exception e) {
            return -1;
        }
    }

    public static void m2379cn(String str) {
        m2387r(f2724wS[11], str);
    }

    public static void m2380co(String str) {
        m2387r(f2724wS[14], str);
    }

    public static void m2381cp(String str) {
        m2387r(f2724wS[16], str);
    }

    public static void m2382cq(String str) {
        m2387r(f2724wS[34], str);
    }

    public static String m2383fa(int i) {
        return m2368am(f2724wS[i]);
    }

    public static void m2384h(String str, int i) {
        m2387r(f2724wS[i], str);
    }

    public static boolean m2385j(Context context) {
        C0012k.m41c("SamsungIAB", "[isInstalledIapPackage]");
        boolean z = true;
        try {
            context.getPackageManager().getApplicationInfo("com.sec.android.iap", 128);
        } catch (PackageManager.NameNotFoundException e) {
            C0012k.m40b("SamsungIAB", "NameNotFoundException: " + e.toString());
            z = false;
        }
        C0012k.m39a("SamsungIAB", "isInstalledIapPackage? " + z);
        return z;
    }

    public static boolean m2386k(Context context) {
        boolean z = false;
        C0012k.m41c("SamsungIAB", "[isValidIapPackage]");
        try {
            if (context.getPackageManager().getPackageInfo("com.sec.android.iap", 64).signatures[0].hashCode() == 2055122763) {
                z = true;
            }
        } catch (Exception e) {
            C0012k.m40b("SamsungIAB", "Exception: " + e.getMessage());
        }
        C0012k.m39a("SamsungIAB", "isValidIapPackage? " + z);
        return z;
    }

    public static void m2387r(String str, String str2) {
        try {
            SharedPreferences.Editor edit = C0488o.getContext().getSharedPreferences("SMSPrefsFile", 0).edit();
            edit.putString(str, str2);
            edit.commit();
        } catch (Exception e) {
        }
    }

    public static String m2388sb() {
        int indexOf;
        String m2368am = m2368am(f2724wS[7]);
        if (m2368am == null || (indexOf = m2368am.indexOf(95)) <= 0) {
            return null;
        }
        return m2368am.substring(0, indexOf);
    }

    public static String m2389sc() {
        String m2368am = m2368am(f2724wS[8]);
        return m2368am != null ? m2368am : "";
    }

    public static String m2390sd() {
        String m2368am = m2368am(f2724wS[9]);
        return m2368am != null ? m2368am : "";
    }

    public static String m2391se() {
        String m2368am = m2368am(f2724wS[13]);
        return m2368am != null ? m2368am : "";
    }

    public static String[] m2392sf() {
        String m2368am = m2368am(f2724wS[19]);
        if (m2368am == null || m2368am.equals("")) {
            return null;
        }
        return C0492s.m2705cW(m2368am).split(";");
    }

    public static boolean m2393sg() {
        String m2368am = m2368am(f2724wS[5]);
        return m2368am != null && m2368am.equals("1");
    }

    public static boolean m2394sh() {
        boolean z;
        try {
            z = C0488o.getContext().getSharedPreferences("SMSWrapperPreferences", 0).getBoolean("PREFERENCES_GAME_UNLOCKED", true);
        } catch (Exception e) {
            e.printStackTrace();
            z = false;
        }
        return !z;
    }

    public static String m2395si() {
        String m2368am = m2368am(f2724wS[10]);
        if (m2368am != "") {
            return m2368am;
        }
        return null;
    }

    public static String m2396sj() {
        String m2368am = m2368am(f2724wS[11]);
        if (m2368am != "") {
            return m2368am;
        }
        return null;
    }

    public static String m2397sk() {
        String m2368am = m2368am(f2724wS[14]);
        if (m2368am != "") {
            return m2368am;
        }
        return null;
    }

    public static void m2398sl() {
        m2387r(f2724wS[17], new StringBuilder().append(m2399sm() + 1).toString());
    }

    public static int m2399sm() {
        String m2368am = m2368am(f2724wS[17]);
        if (m2368am != "") {
            return C0488o.m2641ap(m2368am);
        }
        return 1;
    }

    public static String m2400sn() {
        String m2368am = m2368am(f2724wS[34]);
        if (m2368am != "") {
            return m2368am;
        }
        return null;
    }

    public final Bundle m2401D(String str, String str2) {
        C0012k.m41c("SamsungIAB", "[getItemList]");
        return m2364a(str, 1, 15, str2);
    }

    public final void m2402a(Activity activity, int i, String str, String str2) {
        C0012k.m41c("SamsungIAB", "[startPurchase]");
        try {
            Bundle bundle = new Bundle();
            bundle.putString("THIRD_PARTY_NAME", this.mContext.getPackageName());
            C0012k.m39a("SamsungIAB", "PackageName: " + this.mContext.getPackageName());
            bundle.putString("ITEM_GROUP_ID", str);
            C0012k.m39a("SamsungIAB", "GroupId " + str);
            bundle.putString("ITEM_ID", str2);
            C0012k.m39a("SamsungIAB", "ItemId " + str2);
            ComponentName componentName = new ComponentName("com.sec.android.iap", "com.sec.android.iap.activity.PaymentMethodListActivity");
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setComponent(componentName);
            intent.putExtras(bundle);
            activity.startActivityForResult(intent, 1);
        } catch (Exception e) {
            C0012k.m40b("SamsungIAB", "Exception: " + e.getMessage());
        }
    }

    public final void m2403a(Activity activity, String str, String str2, boolean z, Runnable runnable, boolean z2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.setPositiveButton(C0217R.string.IAP_SAMSUNG_OK_BUTTON, new DialogInterfaceOnClickListenerC0417i(this, runnable, z, activity));
        if (z2) {
            builder.setNegativeButton(C0217R.string.IAP_SAMSUNG_CANCEL_BUTTON, new DialogInterfaceOnClickListenerC0418j(this, z, activity));
        }
        if (ActivityC0422n.acH) {
            builder.setOnCancelListener(new DialogInterfaceOnCancelListenerC0419k(this, activity));
        }
        if (z) {
            builder.setOnCancelListener(new DialogInterfaceOnCancelListenerC0420l(this, activity));
        }
        builder.show();
    }

    public final void m2404a(InterfaceC0421m interfaceC0421m) {
        C0012k.m41c("SamsungIAB", "[bindIapService]");
        if (true == this.acz) {
            interfaceC0421m.mo2406fb(0);
            return;
        }
        this.aaT = new ServiceConnectionC0416h(this, interfaceC0421m);
        this.mContext.bindService(new Intent("com.sec.android.iap.service.iapService"), this.aaT, 1);
    }

    public final C0409a m2405sa() {
        C0409a c0409a = new C0409a();
        try {
            Bundle mo276fh = this.acy.mo276fh(this.acA);
            if (mo276fh != null) {
                c0409a.mErrorCode = mo276fh.getInt("STATUS_CODE");
                c0409a.acm = mo276fh.getString("ERROR_STRING");
                c0409a.acn = mo276fh.getString("IAP_UPGRADE_URL");
            }
        } catch (RemoteException e) {
            C0012k.m40b("SamsungIAB", "Exception: " + e.getMessage());
        }
        return c0409a;
    }
}
