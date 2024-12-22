package com.gameloft.android2d.socialnetwork;

import com.facebook.Request;
import com.facebook.Response;
import com.facebook.model.GraphObject;
import org.json.JSONArray;
import org.json.JSONObject;

final class C0494aa implements Request.Callback {
    private C0528l agY;

    C0494aa(C0528l c0528l) {
        this.agY = c0528l;
    }

    @Override
    public final void onCompleted(Response response) {
        int i;
        GraphObject graphObject = response.getGraphObject();
        if (graphObject == null || graphObject.getProperty("data") == null) {
            return;
        }
        try {
            Object property = graphObject.getProperty("data");
            int[] iArr = new int[((JSONArray) property).length()];
            int i2 = 0;
            int i3 = 0;
            while (i2 < ((JSONArray) property).length()) {
                if (new JSONObject(((JSONArray) property).getJSONObject(i2).getString("application")).getString("id").equals(SocialNetwork_Facebook.agh)) {
                    iArr[i3] = i2;
                    i = i3 + 1;
                } else {
                    i = i3;
                }
                i2++;
                i3 = i;
            }
            if (i3 > 0) {
                C0529m[] c0529mArr = new C0529m[i3];
                for (int i4 = 0; i4 < i3; i4++) {
                    JSONObject jSONObject = new JSONObject(new JSONObject(((JSONArray) property).getJSONObject(iArr[i4]).getString("data")).getString("achievement"));
                    c0529mArr[i4] = new C0529m();
                    jSONObject.getString("id");
                    jSONObject.getString("title");
                    jSONObject.getString("url");
                }
                this.agY.afJ = c0529mArr;
            }
        } catch (Exception e) {
            String str = "ERROR: " + e.toString();
        }
    }
}
