package com.gameloft.android2d.iap.p042a.p047e;

final class RunnableC0374ae implements Runnable {
    private EnumC0386h abE;
    private String abF;
    private int abG;
    private long abH;
    private String abI;
    private AbstractC0373ad abJ;

    RunnableC0374ae(AbstractC0373ad abstractC0373ad, EnumC0386h enumC0386h, String str, int i, long j, String str2) {
        this.abJ = abstractC0373ad;
        this.abE = enumC0386h;
        this.abF = str;
        this.abG = i;
        this.abH = j;
        this.abI = str2;
    }

    @Override
    public final void run() {
        AbstractC0373ad abstractC0373ad = this.abJ;
        EnumC0386h enumC0386h = this.abE;
        String str = this.abF;
        int i = this.abG;
        long j = this.abH;
        String str2 = this.abI;
        abstractC0373ad.mo2287a(enumC0386h, str);
    }
}
