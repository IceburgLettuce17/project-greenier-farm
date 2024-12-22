package com.gameloft.android.LATAM.GloftGF2H.PushNotification;

import android.app.Notification;
import android.content.Context;
import p001a.p004b.p005a.p006a.C0002a;

public final class C0260f extends AbstractC0259e {
    public C0260f(Context context) {
        super(context);
    }

    @Override
    public final Notification mo528cX() {
        Notification notification = new Notification(C0270p.m577dd(), this.f313xK, this.when);
        notification.setLatestEventInfo(this.context, this.f313xK, this.f312xJ, this.f314xL);
        if (this.f315xM) {
            notification.flags |= 16;
        }
        if (!C0002a.m13a(this.context)) {
            int i = notification.defaults;
            notification.defaults = -1;
        }
        return notification;
    }
}
