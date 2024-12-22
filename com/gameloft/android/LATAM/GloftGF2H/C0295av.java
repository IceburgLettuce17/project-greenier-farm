package com.gameloft.android.LATAM.GloftGF2H;

public final class C0295av {

    static C0277ad f623yN = null;
    static String userId = "";

    private static int f626yQ = 0;

    private static int f627yR = 50;

    private static C0277ad[] f624yO = new C0277ad[50];

    private static String[] f625yP = new String[f627yR];

    private static int f628yS = -1;

    static void m828a(String str, C0277ad c0277ad) {
        int i = f626yQ + 1;
        f626yQ = i;
        f626yQ = i % f627yR;
        if (f624yO[f626yQ] != null) {
            f624yO[f626yQ].m681cc();
        }
        f624yO[f626yQ] = c0277ad;
        f625yP[f626yQ] = str;
    }

    static boolean m829aL(String str) {
        f628yS = -1;
        for (int i = 0; i < f627yR; i++) {
            if (f625yP[i] != null && f625yP[i].compareTo(str) == 0) {
                f628yS = i;
                return true;
            }
        }
        return false;
    }

    static C0277ad m830dt() {
        if (f628yS >= 0) {
            return f624yO[f628yS];
        }
        return null;
    }
}
