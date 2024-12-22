package com.gameloft.android2d.socialnetwork;

import com.facebook.Request;
import com.facebook.Response;

final class C0538v implements Request.Callback {
    C0538v() {
    }

    @Override
    public final void onCompleted(Response response) {
        String str = "Facebook: POST SCORES : " + response.toString();
        SocialNetwork_Facebook.m2737k(SocialNetwork_Facebook.age.afF, -1);
    }
}
