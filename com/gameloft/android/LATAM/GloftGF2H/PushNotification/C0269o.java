package com.gameloft.android.LATAM.GloftGF2H.PushNotification;

import android.os.Bundle;

final class C0269o extends AbstractC0255a {

    private C0263i f339yg;

    C0269o(C0263i c0263i) {
        this.f339yg = c0263i;
    }

    @Override
    protected final Integer mo515b(Bundle bundle) {
        boolean m546ax;
        boolean z;
        boolean m546ax2;
        String string = bundle.getString("juid");
        String string2 = bundle.getString("jusrpss");
        bundle.getString("jusrcred");
        String string3 = C0263i.f327xY.get().getSharedPreferences("GLPN", 0).getString("RandomUserID", null);
        C0263i.f329ya = true;
        m546ax = C0263i.m546ax(string3);
        if (m546ax) {
            C0263i.m529H(1, 4001);
            z = false;
        } else {
            String m533a = C0263i.m533a(string3, string3, "anonymous", 1);
            if (C0263i.m545aZ(5) == 0) {
                m546ax2 = C0263i.m546ax(m533a);
                if (!m546ax2) {
                    String str = C0263i.f331yc + ":" + string;
                    z = C0263i.m558d(str, string2, m533a) == 0;
                    if (z) {
                        C0263i.m542aB(str);
                        C0263i.f319xQ[1] = true;
                    }
                }
            } else {
                C0263i.m529H(1, C0263i.m545aZ(5));
            }
            z = false;
        }
        if (z) {
            C0263i.m529H(1, 0);
            this.f339yg.m530I(1, 0);
        } else if (C0263i.m545aZ(1) != 2020) {
            this.f339yg.m536a(1, -2, bundle);
        } else {
            this.f339yg.m536a(1, -1, bundle);
        }
        return new Integer(0);
    }
}
