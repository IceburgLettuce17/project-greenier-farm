package com.gameloft.android2d.socialnetwork;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.widget.WebDialog;
import com.gameloft.android.LATAM.GloftGF2H.C0320bt;

final class C0504ak implements WebDialog.OnCompleteListener {
    C0504ak() {
    }

    @Override
    public final void onComplete(Bundle bundle, FacebookException facebookException) {
        if (facebookException == null) {
            if (bundle.getString("post_id") != null) {
                C0320bt.m1152bH(0);
                return;
            } else {
                C0320bt.m1152bH(1);
                return;
            }
        }
        if (facebookException instanceof FacebookOperationCanceledException) {
            C0320bt.m1152bH(1);
        } else {
            C0320bt.m1152bH(2);
        }
    }
}
