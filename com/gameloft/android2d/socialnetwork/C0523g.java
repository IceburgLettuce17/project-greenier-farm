package com.gameloft.android2d.socialnetwork;

import com.facebook.Request;
import com.facebook.Response;

final class C0523g implements Request.Callback {
    private C0521e afy;

    C0523g(C0521e c0521e) {
        this.afy = c0521e;
    }

    @Override
    public final void onCompleted(Response response) {
        C0521e.m2776a(this.afy, response);
    }
}
