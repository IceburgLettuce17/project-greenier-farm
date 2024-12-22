package com.gameloft.android.LATAM.GloftGF2H.PushNotification;

import android.os.Bundle;
import com.gameloft.android.wrapper.C0355i;

final class C0268n extends AbstractC0255a {

    private C0263i f338yg;

    C0268n(C0263i c0263i) {
        this.f338yg = c0263i;
    }

    @Override
    protected final Integer mo515b(Bundle bundle) {
        boolean m546ax;
        boolean z;
        boolean m546ax2;
        boolean m546ax3;
        String string = bundle.getString("juid");
        String string2 = bundle.getString("jusrpss");
        String string3 = bundle.getString("jusrcred");
        C0263i.f329ya = false;
        String m533a = C0263i.m533a(string, string2, string3, 1);
        C0355i.setContext(C0263i.f327xY.get());
        String deviceId = C0355i.getDeviceId();
        m546ax = C0263i.m546ax(string);
        if (!m546ax) {
            m546ax2 = C0263i.m546ax(m533a);
            if (m546ax2) {
                C0263i.m529H(0, 1002);
                z = false;
            } else {
                m546ax3 = C0263i.m546ax(deviceId);
                if (m546ax3) {
                    C0263i.m529H(0, 1003);
                    z = false;
                } else if (C0263i.m565e(m533a, 1)) {
                    C0263i.m542aB(string3 + ":" + string);
                    C0263i.f319xQ[0] = true;
                    z = true;
                }
            }
            if (!z) {
                C0263i.m529H(1, 0);
                this.f338yg.m530I(1, 0);
            } else if (C0263i.m545aZ(1) != 2020) {
                this.f338yg.m536a(1, -2, bundle);
            } else {
                this.f338yg.m536a(1, -1, bundle);
            }
            return new Integer(0);
        }
        C0263i.m529H(0, 1001);
        z = false;
        if (!z) {
        }
        return new Integer(0);
    }
}
