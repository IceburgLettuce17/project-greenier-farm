package com.gameloft.android.LATAM.GloftGF2H.PushNotification;

import android.os.Bundle;

final class C0267m extends AbstractC0255a {

    private C0263i f337yg;

    C0267m(C0263i c0263i) {
        this.f337yg = c0263i;
    }

    @Override
    protected final Integer mo515b(Bundle bundle) {
        boolean m546ax;
        boolean m546ax2;
        String string = C0263i.f327xY.get().getSharedPreferences("GLPN", 0).getString("RandomUserID", null);
        m546ax = C0263i.m546ax(string);
        if (m546ax) {
            string = C0263i.m555cK();
        }
        String m533a = C0263i.m533a(string, string, "anonymous", 0);
        m546ax2 = C0263i.m546ax(m533a);
        if (!m546ax2 ? C0263i.m574v(string, m533a) == 0 : false) {
            C0263i.m529H(0, 0);
            this.f337yg.m530I(0, 0);
        } else if (C0263i.m545aZ(0) != 2020) {
            this.f337yg.m536a(0, -2, bundle);
        } else {
            this.f337yg.m536a(0, -1, bundle);
        }
        return new Integer(0);
    }
}
