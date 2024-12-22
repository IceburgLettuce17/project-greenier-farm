package com.gameloft.android2d.socialnetwork;

import android.os.Looper;

final class RunnableC0522f implements Runnable {
    private C0521e afy;

    RunnableC0522f(C0521e c0521e) {
        this.afy = c0521e;
    }

    @Override
    public final void run() {
        Looper.prepare();
        try {
            Thread.sleep(1000L);
            while (SocialNetwork_Facebook.agp) {
                Thread.sleep(2000L);
            }
            this.afy.addResults(this.afy.afx);
        } catch (Exception e) {
            String str = "Facebook: next page addResults error" + e.toString();
        }
    }
}
