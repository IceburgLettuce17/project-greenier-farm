package com.gameloft.android2d.socialnetwork;

import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.model.GraphUser;
import com.gameloft.android.LATAM.GloftGF2H.C0337q;

final class C0495ab implements Request.GraphUserCallback {
    private Session agZ;

    C0495ab(Session session) {
        this.agZ = session;
    }

    @Override
    public final void onCompleted(GraphUser graphUser, Response response) {
        if (this.agZ == Session.getActiveSession() && graphUser != null) {
            String str = " Current user Name" + graphUser.getName() + " Id:" + graphUser.getId();
            C0528l m2070bJ = C0337q.m2070bJ();
            m2070bJ.afF = SocialNetwork_Facebook.m2706a(graphUser);
            m2070bJ.afB = SocialNetwork_Facebook.m2714b(graphUser);
            SocialNetwork_Facebook.m2717c(graphUser);
            m2070bJ.afC = SocialNetwork_Facebook.m2724d(graphUser);
            m2070bJ.afE = SocialNetwork_Facebook.m2726e(graphUser);
            m2070bJ.afD = SocialNetwork_Facebook.m2728f(graphUser);
            m2070bJ.afI = SocialNetwork_Facebook.m2734g(graphUser);
            SocialNetwork_Facebook.age = m2070bJ;
            SocialNetwork_Facebook.m2713ag(true);
            SocialNetwork_Facebook.m2712a(SocialNetwork_Facebook.m2706a(graphUser), SocialNetwork_Facebook.m2721cX(SocialNetwork_Facebook.m2706a(graphUser)));
            SocialNetwork_Facebook.m2737k(SocialNetwork_Facebook.age.afF, -1);
            SocialNetwork_Facebook.m2708a(SocialNetwork_Facebook.age);
        }
        response.getError();
    }
}
