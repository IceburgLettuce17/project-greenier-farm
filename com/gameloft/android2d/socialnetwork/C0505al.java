package com.gameloft.android2d.socialnetwork;

import com.facebook.Request;
import com.facebook.Response;
import com.facebook.model.GraphObject;
import com.gameloft.android2d.socialnetwork.SocialNetwork_Facebook;
import org.json.JSONArray;
import org.json.JSONObject;

final class C0505al implements Request.Callback {
    C0505al() {
    }

    @Override
    public final void onCompleted(Response response) {
        Object data;
        GraphObject graphObject = response.getGraphObject();
        if (graphObject == null || (data = ((SocialNetwork_Facebook.SCORE) graphObject.cast(SocialNetwork_Facebook.SCORE.class)).getData()) == null) {
            return;
        }
        for (int i = 0; i < ((JSONArray) data).length(); i++) {
            try {
                JSONObject jSONObject = ((JSONArray) data).getJSONObject(i);
                if (jSONObject != null) {
                    int i2 = jSONObject.getInt("score");
                    String string = new JSONObject(jSONObject.getString("user")).getString("id");
                    if (string.equals(SocialNetwork_Facebook.age.afF)) {
                        SocialNetwork_Facebook.age.score = i2;
                    } else {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= SocialNetwork_Facebook.agl.graphObjects.size()) {
                                break;
                            }
                            if (string.equals(SocialNetwork_Facebook.agl.m2775ff(i3).afF)) {
                                SocialNetwork_Facebook.agl.m2774aU(i3, i2);
                                break;
                            }
                            i3++;
                        }
                    }
                }
            } catch (Exception e) {
                e.toString();
                return;
            }
        }
    }
}
