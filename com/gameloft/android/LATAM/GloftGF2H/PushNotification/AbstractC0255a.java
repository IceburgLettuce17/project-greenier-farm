package com.gameloft.android.LATAM.GloftGF2H.PushNotification;

import android.os.Bundle;

public abstract class AbstractC0255a {

    private boolean f305xD;

    public AbstractC0255a() {
        this.f305xD = false;
        this.f305xD = false;
    }

    protected abstract Integer mo515b(Bundle bundle);

    public final void m516c(Bundle bundle) {
        new Thread(new RunnableC0257c(this, bundle), "Thread-doInBG").start();
    }
}
