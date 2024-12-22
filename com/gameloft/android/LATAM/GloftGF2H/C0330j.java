package com.gameloft.android.LATAM.GloftGF2H;

import java.util.Timer;
import java.util.TimerTask;

public final class C0330j extends TimerTask {

    private static Timer f1929dZ;

    public static void m1981a(long j) {
        Timer timer = new Timer();
        f1929dZ = timer;
        timer.schedule(new C0330j(), 60000L);
    }

    public static void stop() {
        f1929dZ.cancel();
    }

    @Override
    public final void run() {
        RunnableC0300b m1967ak = C0326f.m1967ak();
        m1967ak.cancel();
        m1967ak.f636dC = true;
        m1967ak.f635dB = false;
    }
}
