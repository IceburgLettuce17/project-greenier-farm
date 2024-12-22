package com.gameloft.android2d.socialnetwork;

import com.facebook.FacebookException;
import com.facebook.model.GraphUser;

final class C0509ap extends AbstractC0508ao<GraphUser> {
    private C0509ap() {
    }

    C0509ap(byte b2) {
        this();
    }

    @Override
    protected final void mo2747a(C0521e<GraphUser> c0521e, C0520d<GraphUser> c0520d) {
        super.mo2747a(c0521e, c0520d);
        if (c0520d == null || c0521e.loading) {
            return;
        }
        if (c0520d.moreObjectsAvailable) {
            this.ahc.followNextLink();
        } else if (c0520d.fromCache) {
            long j = c0520d.graphObjects.size() == 0 ? 2000L : 0L;
            if (c0521e.originalRequest == null) {
                throw new FacebookException("refreshOriginalRequest may not be called until after startLoading has been called.");
            }
            c0521e.startLoading(c0521e.originalRequest, false, j);
        }
    }
}
