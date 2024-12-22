package com.gameloft.android.LATAM.GloftGF2H;

public final class C0326f {

    private static C0332l f1908dE;

    public static String f1909dG = null;

    private static RunnableC0300b f1910dH;

    public static long f1911dI;

    public String f1912dF;
    private String url;

    public C0326f(C0332l c0332l) {
        f1908dE = c0332l;
        f1909dG = null;
        if (this.url != null && this.url.length() != 0) {
            this.url = this.url.trim();
        }
        f1910dH = new RunnableC0300b();
        if (f1909dG == null) {
            f1909dG = "";
        } else {
            f1909dG = f1909dG.trim();
        }
    }

    public static void m1964E(int i) {
    }

    public static C0332l m1965ah() {
        return f1908dE;
    }

    public static C0327g m1966ai() {
        C0332l c0332l = f1908dE;
        return C0332l.m1983ai();
    }

    public static RunnableC0300b m1967ak() {
        return f1910dH;
    }

    public final boolean m1968aj() {
        this.f1912dF = null;
        if (f1910dH.isInProgress()) {
            if (System.currentTimeMillis() - f1911dI <= 15000) {
                return false;
            }
            f1911dI = 0L;
            f1910dH.cancel();
            return true;
        }
        String str = "UPDATE::AUXPlayer::Value for response on whttp.m_bError =" + f1910dH.f636dC;
        if (f1910dH.f636dC) {
            return true;
        }
        String str2 = "UPDATE::AUXPlayer::Value for response on whttp.m_response =" + f1910dH.f634dA;
        String str3 = f1910dH.f634dA;
        if (str3.compareTo("-1") == 0 || str3.compareTo("-2") == 0 || str3.compareTo("-3") == 0 || str3.compareTo("-4") == 0 || str3.compareTo("-5") == 0 || str3.compareTo("-6") == 0) {
            return true;
        }
        if (str3.compareTo("0") == 0) {
            this.f1912dF = "Error: No live release";
            return true;
        }
        if (!str3.contains("VERSION_AVAILABLE") || !str3.contains("DOWNLOAD_URL")) {
            return true;
        }
        String str4 = "UPDATE::AUXPlayer::str_response: " + str3;
        this.f1912dF = str3;
        return true;
    }

    public final void m1969i(String str, String str2) {
        this.f1912dF = null;
        String str3 = "UPDATE::AUXPlayer::sendRequestNewVersion =" + str;
        f1910dH.cancel();
        f1911dI = System.currentTimeMillis();
        f1910dH.m832f(str, str2);
    }
}
