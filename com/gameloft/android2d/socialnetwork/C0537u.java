package com.gameloft.android2d.socialnetwork;

import com.facebook.FacebookOperationCanceledException;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.android.C0217R;
import com.gameloft.android.LATAM.GloftGF2H.C0320bt;

final class C0537u implements Session.StatusCallback {
    C0537u() {
    }

    @Override
    public final void call(Session session, SessionState sessionState, Exception exc) {
        String str = "Facebook: login status " + sessionState + " exception:" + exc;
        switch (C0501ah.$SwitchMap$com$facebook$SessionState[sessionState.ordinal()]) {
            case 1:
                C0320bt.m1151bG(0);
                SocialNetwork_Facebook.agg = false;
                break;
            case 2:
                C0320bt.m1151bG(1);
                SocialNetwork_Facebook.m2738tA();
                break;
            case 3:
                if (exc instanceof FacebookOperationCanceledException) {
                    C0320bt.m1151bG(4);
                    SocialNetwork_Facebook.agg = true;
                } else {
                    C0320bt.m1151bG(2);
                }
                if (session != null) {
                    session.closeAndClearTokenInformation();
                    break;
                }
                break;
            case C0217R.styleable.com_facebook_picker_fragment_done_button_text:
                C0320bt.m1151bG(3);
                if (session != null) {
                    session.closeAndClearTokenInformation();
                    break;
                }
                break;
        }
    }
}
