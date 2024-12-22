package com.gameloft.android2d.socialnetwork;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.widget.WebDialog;
import com.gameloft.android.LATAM.GloftGF2H.C0320bt;

final class C0502ai implements WebDialog.OnCompleteListener {
    C0502ai() {
    }

    @Override
    public final void onComplete(Bundle bundle, FacebookException facebookException) {
        String str = "Facebook: Invite friends " + facebookException;
        if (facebookException != null) {
            facebookException.toString().indexOf("Too many recipients");
            if (!(facebookException instanceof FacebookOperationCanceledException)) {
                C0320bt.m1153bI(2);
                return;
            }
        } else if (bundle.getString("request") != null) {
            C0320bt.m1153bI(0);
            return;
        }
        C0320bt.m1153bI(1);
    }
}
