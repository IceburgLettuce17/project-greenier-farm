package com.gameloft.android2d.socialnetwork;

import com.facebook.Request;
import com.facebook.model.GraphObject;
import com.facebook.model.GraphUser;

abstract class AbstractC0508ao<T extends GraphObject> {
    protected C0521e<T> ahc;

    AbstractC0508ao() {
    }

    protected void mo2747a(C0521e<T> c0521e, C0520d<T> c0520d) {
        SocialNetwork_Facebook.m2744tx();
    }

    public final void startLoading(Request request) {
        if (this.ahc != null) {
            C0521e<T> c0521e = this.ahc;
            c0521e.originalRequest = request;
            c0521e.startLoading(request, false, 0L);
        }
    }

    public final void m2748tF() {
        this.ahc = new C0521e<>(GraphUser.class);
        this.ahc.aft = new C0527k<>(this);
        this.ahc.afs = new C0526j(this);
    }
}
