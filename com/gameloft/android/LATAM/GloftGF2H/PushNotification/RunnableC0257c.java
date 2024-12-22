package com.gameloft.android.LATAM.GloftGF2H.PushNotification;

import android.os.Bundle;
import com.gameloft.android.wrapper.C0355i;

final class RunnableC0257c implements Runnable {

    private AbstractC0255a f308xF;

    private Bundle f309xG;

    RunnableC0257c(AbstractC0255a abstractC0255a, Bundle bundle) {
        this.f308xF = abstractC0255a;
        this.f309xG = bundle;
    }

    @Override
    public final void run() {
        int intValue = this.f308xF.mo515b(this.f309xG).intValue();
        C0355i.getActivity().runOnUiThread(new RunnableC0256b(this.f308xF, Integer.valueOf(intValue)));
    }
}
