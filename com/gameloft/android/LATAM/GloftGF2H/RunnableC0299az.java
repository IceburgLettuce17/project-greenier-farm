package com.gameloft.android.LATAM.GloftGF2H;

final class RunnableC0299az implements Runnable {

    private String f631zl;

    private C0298ay f632zm;

    RunnableC0299az(C0298ay c0298ay, String str) {
        this.f632zm = c0298ay;
        this.f631zl = str;
    }

    @Override
    public final void run() {
        String m581aN;
        SplashScreenActivity splashScreenActivity = this.f632zm.f630zk;
        m581aN = SplashScreenActivity.m581aN(this.f631zl);
        if (m581aN == null) {
            m581aN = this.f631zl;
        }
        C0298ay c0298ay = this.f632zm;
        C0298ay.m831B(m581aN.replace("link:", ""));
    }
}
