package com.gameloft.android2d.socialnetwork;

import com.facebook.Request;
import com.facebook.Response;

final class C0540x implements Request.Callback {
    C0540x() {
    }

    @Override
    public final void onCompleted(Response response) {
        String str = "Facebook: POST ACTION OBJECT : " + response.toString();
    }
}
