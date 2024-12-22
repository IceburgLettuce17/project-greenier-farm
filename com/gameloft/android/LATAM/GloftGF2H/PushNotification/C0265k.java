package com.gameloft.android.LATAM.GloftGF2H.PushNotification;

import android.os.Bundle;

final class C0265k extends AbstractC0255a {

    private C0263i f335yg;

    C0265k(C0263i c0263i) {
        this.f335yg = c0263i;
    }

    @Override
    protected final Integer mo515b(Bundle bundle) {
        int m548az;
        String string = bundle.getString("jphid");
        m548az = C0263i.m548az(string);
        bundle.putString("pn_push_id", string);
        bundle.putString("pn_result", new StringBuilder().append(m548az).toString());
        if (m548az == 1) {
            this.f335yg.m536a(3, 0, bundle);
        } else {
            this.f335yg.m536a(3, -1, bundle);
        }
        return new Integer(0);
    }
}
