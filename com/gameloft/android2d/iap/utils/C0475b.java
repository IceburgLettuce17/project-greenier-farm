package com.gameloft.android2d.iap.utils;

import java.util.Timer;
import java.util.TimerTask;

public final class C0475b extends TimerTask {

    private static Timer f2854dZ;

    public static void m2584a(long j) {
        Timer timer = new Timer();
        f2854dZ = timer;
        timer.schedule(new C0475b(), 60000L);
    }

    public static void stop() {
        f2854dZ.cancel();
    }

    @Override
    public final void run() {
        RunnableC0479f m2686tq = C0491r.m2686tq();
        m2686tq.cancel();
        m2686tq.f2870dC = true;
        m2686tq.f2869dB = false;
    }
}
