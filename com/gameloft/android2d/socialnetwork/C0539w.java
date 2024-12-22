package com.gameloft.android2d.socialnetwork;

import com.facebook.Request;
import com.facebook.Response;

final class C0539w implements Request.Callback {
    C0539w() {
    }

    @Override
    public final void onCompleted(Response response) {
        String str = "Facebook: POST ACTION OBJECT : " + response.toString();
    }
}
