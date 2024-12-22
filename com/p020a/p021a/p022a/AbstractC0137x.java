package com.p020a.p021a.p022a;

import android.content.Context;
import java.lang.ref.WeakReference;

public abstract class AbstractC0137x {

    WeakReference<Context> f116bb;

    public AbstractC0137x(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Provided Context must not be null");
        }
        this.f116bb = new WeakReference<>(context.getApplicationContext());
    }

    public abstract void mo240c(boolean z);
}
