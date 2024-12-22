package com.gameloft.android2d.socialnetwork;

import com.gameloft.android.wrapper.C0352f;
import com.gameloft.android.wrapper.C0355i;

public final class C0532p {

    private static int f2884De = 1;

    public static void m2780a(int i, int i2) {
        if (f2884De == 1) {
            SocialNetwork_Facebook.m2707a(i, i2);
        } else if (f2884De == 4) {
            C0511ar.m2751a(i, i2);
        }
    }

    public static void m2781a(C0528l c0528l, C0528l[] c0528lArr, String str, String str2) {
        C0355i.getActivity().runOnUiThread(new RunnableC0534r(c0528l, c0528lArr, str, str2));
    }

    public static void m2782a(String str, String str2, String str3, String str4) {
        C0355i.getActivity().runOnUiThread(new RunnableC0536t(str, str2, str3, str4));
    }

    public static void m2783a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        C0355i.getActivity().runOnUiThread(new RunnableC0535s(str, str2, str3, str4, str5, str6, str7, str8, str9));
    }

    public static void m2784b() {
        if (f2884De == 1) {
            C0352f.m2186eU(3);
            SocialNetwork_Facebook.m2715b();
        } else if (f2884De == 4) {
            C0511ar.m2757b();
        }
    }

    public static void m2785c() {
        if (f2884De == 1) {
            SocialNetwork_Facebook.m2718c();
        } else if (f2884De == 4) {
            C0511ar.m2758c();
        }
    }

    public static void m2786c(String str, String str2) {
        if (f2884De == 1) {
            SocialNetwork_Facebook.m2719c(str, str2);
        } else if (f2884De == 4) {
            C0511ar.m2759c(str, str2);
        }
    }

    public static void m2787d() {
        C0355i.getActivity().runOnUiThread(new RunnableC0533q());
    }

    public static boolean m2789e() {
        if (f2884De == 1) {
            return SocialNetwork_Facebook.m2727e();
        }
        if (f2884De == 4) {
            return C0511ar.m2762e();
        }
        return false;
    }

    public static boolean m2790f() {
        if (f2884De == 1) {
            return SocialNetwork_Facebook.m2730f();
        }
        if (f2884De == 4) {
            return C0511ar.m2763f();
        }
        return false;
    }

    public static C0528l m2791fg(int i) {
        if (f2884De == 1) {
            return SocialNetwork_Facebook.m2731fg(i);
        }
        if (f2884De == 4) {
            return C0511ar.m2764fg(i);
        }
        return null;
    }

    public static boolean m2792g() {
        if (f2884De == 1) {
            return SocialNetwork_Facebook.m2733g();
        }
        if (f2884De == 4) {
            return C0511ar.m2765g();
        }
        return false;
    }

    public static String getPassword() {
        if (f2884De == 1) {
            return SocialNetwork_Facebook.getPassword();
        }
        if (f2884De == 4) {
            return C0511ar.getPassword();
        }
        return null;
    }

    public static int getType() {
        return f2884De;
    }

    public static int m2793i() {
        if (f2884De == 1) {
            return SocialNetwork_Facebook.m2736i();
        }
        if (f2884De == 4) {
            return C0511ar.m2768i();
        }
        return 0;
    }

    public static C0528l m2794tw() {
        if (f2884De == 1) {
            return SocialNetwork_Facebook.m2743tw();
        }
        if (f2884De == 4) {
            return C0511ar.m2772tw();
        }
        return null;
    }
}
