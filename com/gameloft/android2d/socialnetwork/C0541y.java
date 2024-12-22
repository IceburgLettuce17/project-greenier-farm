package com.gameloft.android2d.socialnetwork;

import com.facebook.Request;
import com.facebook.Response;

final class C0541y implements Request.Callback {
    C0541y() {
    }

    @Override
    public final void onCompleted(Response response) {
        String str = "Facebook: POST USER ARCHIEVEMENTS : " + response.toString();
        if (SocialNetwork_Facebook.age != null) {
            SocialNetwork_Facebook.m2708a(SocialNetwork_Facebook.age);
        }
    }
}
