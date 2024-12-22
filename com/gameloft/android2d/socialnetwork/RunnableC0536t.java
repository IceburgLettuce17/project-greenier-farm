package com.gameloft.android2d.socialnetwork;

import com.gameloft.android.wrapper.C0352f;

final class RunnableC0536t implements Runnable {
    private String afY;
    private String afZ;
    private String aga;
    private String agb;

    RunnableC0536t(String str, String str2, String str3, String str4) {
        this.afY = str;
        this.afZ = str2;
        this.aga = str3;
        this.agb = str4;
    }

    @Override
    public final void run() {
        int i;
        i = C0532p.f2884De;
        if (i == 1) {
            C0352f.m2186eU(2);
            SocialNetwork_Facebook.m2710a(this.afY, this.afZ, this.aga, this.agb);
        }
    }
}
