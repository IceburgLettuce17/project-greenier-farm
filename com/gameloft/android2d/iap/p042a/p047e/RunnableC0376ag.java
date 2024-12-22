package com.gameloft.android2d.iap.p042a.p047e;

import android.content.Context;

final class RunnableC0376ag implements Runnable {
    private EnumC0386h abE;
    private long abH;
    private String abI;
    private String abL;
    private String abM;
    private Context val$context;

    RunnableC0376ag(Context context, String str, String str2, EnumC0386h enumC0386h, long j, String str3) {
        this.val$context = context;
        this.abL = str;
        this.abM = str2;
        this.abE = enumC0386h;
        this.abH = j;
        this.abI = str3;
    }

    @Override
    public final void run() {
        AbstractC0373ad abstractC0373ad;
        AbstractC0373ad abstractC0373ad2;
        C0371ab c0371ab = new C0371ab(this.val$context);
        int m2304a = c0371ab.m2304a(this.abL, this.abM, this.abE, this.abH, this.abI);
        c0371ab.close();
        synchronized (C0375af.class) {
            abstractC0373ad = C0375af.abK;
            if (abstractC0373ad != null) {
                abstractC0373ad2 = C0375af.abK;
                abstractC0373ad2.m2307a(this.abE, this.abM, m2304a, this.abH, this.abI);
            }
        }
    }
}
