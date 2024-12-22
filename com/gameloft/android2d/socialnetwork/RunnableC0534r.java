package com.gameloft.android2d.socialnetwork;

final class RunnableC0534r implements Runnable {
    private C0528l afM;
    private C0528l[] afN;
    private String afO;
    private String afP;

    RunnableC0534r(C0528l c0528l, C0528l[] c0528lArr, String str, String str2) {
        this.afM = c0528l;
        this.afN = c0528lArr;
        this.afO = str;
        this.afP = str2;
    }

    @Override
    public final void run() {
        int i;
        int i2;
        i = C0532p.f2884De;
        if (i == 1) {
            SocialNetwork_Facebook.m2709a(this.afM, this.afN, this.afO, this.afP);
            return;
        }
        i2 = C0532p.f2884De;
        if (i2 == 4) {
            C0511ar.m2752a(this.afM, this.afN, this.afO, this.afP);
        }
    }
}
