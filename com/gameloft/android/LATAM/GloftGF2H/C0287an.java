package com.gameloft.android.LATAM.GloftGF2H;

public final class C0287an {

    public C0280ag f510wa;

    public boolean f511wb;

    public C0287an(int i, String str, String str2, String str3, String str4) {
        try {
            String stringBuffer = new StringBuffer().append(System.currentTimeMillis() / 1000).toString();
            this.f510wa = new C0280ag();
            this.f510wa.m690c("ggid", i);
            this.f510wa.m693f("mac", str2);
            this.f510wa.m693f("proto_ver", str3);
            this.f510wa.m693f("ts", stringBuffer);
            this.f510wa.m693f("udid", str);
            if (str4 == null || str4.compareTo("") == 0) {
                return;
            }
            this.f510wa.m693f("anon_id", str4);
        } catch (C0279af e) {
        }
    }

    public C0287an(String str) {
        try {
            this.f510wa = new C0280ag(str);
        } catch (C0279af e) {
        }
    }

    final boolean m708a(C0313bm c0313bm) {
        if (c0313bm == null || c0313bm.f678Aa.toString().length() + this.f510wa.toString().length() >= C0341u.f2632uW || m709cg() >= C0341u.f2631uV) {
            return false;
        }
        try {
            if (!this.f510wa.has("events")) {
                this.f510wa.m693f("events", new C0278ae());
            }
            this.f510wa.m692e("events", c0313bm.f678Aa);
            return true;
        } catch (C0279af e) {
            return false;
        }
    }

    public final int m709cg() {
        try {
            return this.f510wa.m687V("events").f499vP.size();
        } catch (C0279af e) {
            return 0;
        }
    }

    public final String toString() {
        return this.f510wa.toString();
    }
}
