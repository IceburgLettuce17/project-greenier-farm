package com.gameloft.android.LATAM.GloftGF2H.PushNotification;

import android.os.Bundle;

final class C0266l extends AbstractC0255a {

    private C0263i f336yg;

    C0266l(C0263i c0263i) {
        this.f336yg = c0263i;
    }

    @Override
    protected final Integer mo515b(Bundle bundle) {
        int i;
        String string = bundle.getString("juid");
        String string2 = bundle.getString("jlbl");
        String string3 = bundle.getString("jbdy");
        String string4 = bundle.getString("jdly");
        String string5 = bundle.getString("jtkn");
        String string6 = bundle.getString("jxtr");
        String string7 = bundle.getString("jrqst");
        String m549b = C0263i.m549b(string, string2, string3, string4, string5, string6);
        if (m549b.compareTo("e") == 0) {
            i = C0263i.m545aZ(2) != 2020 ? -2 : -1;
        } else {
            C0263i.m529H(2, 0);
            i = 0;
        }
        bundle.putString("pn_push_id", m549b);
        bundle.putString("pn_request_id", string7);
        this.f336yg.m536a(2, i, bundle);
        return new Integer(0);
    }
}
