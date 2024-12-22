package com.gameloft.android2d.socialnetwork;

import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.Request;
import com.facebook.Response;
import org.json.JSONArray;

final class C0497ad implements Request.Callback {
    C0497ad() {
    }

    @Override
    public final void onCompleted(Response response) {
        String str = "friend_count " + response.toString();
        if (response != null) {
            FacebookRequestError error = response.getError();
            FacebookException exception = error == null ? null : error.getException();
            if (response.getGraphObject() == null && exception == null) {
                exception = new FacebookException("GraphObjectPagingLoader received neither a result nor an error.");
            }
            if (exception != null) {
                String str2 = "Facebook: exception:" + exception.toString();
                return;
            }
            try {
                SocialNetwork_Facebook.agf = ((JSONArray) response.getGraphObject().getProperty("data")).getJSONObject(0).getInt("friend_count");
                String str3 = "friend_count received: " + SocialNetwork_Facebook.agf;
            } catch (Exception e) {
                String str4 = "erroe " + e.toString();
            }
        }
    }
}
