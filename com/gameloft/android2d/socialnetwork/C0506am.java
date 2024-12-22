package com.gameloft.android2d.socialnetwork;

import com.facebook.Request;
import com.facebook.Response;
import com.facebook.model.GraphObject;
import com.gameloft.android2d.socialnetwork.SocialNetwork_Facebook;
import org.json.JSONArray;

final class C0506am implements Request.Callback {
    private int ahb;

    C0506am(int i) {
        this.ahb = i;
    }

    @Override
    public final void onCompleted(Response response) {
        Object data;
        GraphObject graphObject = response.getGraphObject();
        if (graphObject == null || (data = ((SocialNetwork_Facebook.SCORE) graphObject.cast(SocialNetwork_Facebook.SCORE.class)).getData()) == null) {
            return;
        }
        try {
            int i = ((JSONArray) data).getJSONObject(0).getInt("score");
            if (this.ahb == -1) {
                SocialNetwork_Facebook.age.score = i;
            } else {
                SocialNetwork_Facebook.agl.m2774aU(this.ahb, i);
            }
        } catch (Exception e) {
            e.toString();
        }
    }
}
