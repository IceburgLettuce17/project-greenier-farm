package com.gameloft.android2d.socialnetwork;

import com.facebook.Request;
import com.facebook.Response;
import com.gameloft.android.LATAM.GloftGF2H.C0320bt;

final class C0503aj implements Request.Callback {
    C0503aj() {
    }

    @Override
    public final void onCompleted(Response response) {
        String str = "Facebook: POST WALL: " + response.toString();
        if (response.getGraphObject() == null || response.getError() != null) {
            C0320bt.m1152bH(2);
        } else {
            C0320bt.m1152bH(0);
        }
    }
}
