package com.gameloft.android.LATAM.GloftGF2H;

import java.util.TimerTask;

final class C0274aa extends TimerTask {
    C0274aa() {
    }

    @Override
    public final void run() {
        if (C0288ao.f577xl) {
            return;
        }
        try {
            C0288ao.f576xk = true;
            C0288ao.f575xj.close();
            C0288ao.warning("PaySMS.buy: SMS Timed Out");
        } catch (Exception e) {
            C0288ao.warning(new StringBuffer("PaySMS.buy: Failed to close connection in timer. Exception: ").append(e.toString()).toString());
        }
    }
}
