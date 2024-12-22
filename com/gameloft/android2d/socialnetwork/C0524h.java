package com.gameloft.android2d.socialnetwork;

import com.facebook.Request;
import com.facebook.Response;

final class C0524h implements Request.Callback {
    private C0521e afy;

    C0524h(C0521e c0521e) {
        this.afy = c0521e;
    }

    @Override
    public final void onCompleted(Response response) {
        SocialNetwork_Facebook.agp = true;
        C0521e.m2776a(this.afy, response);
    }
}
