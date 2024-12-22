package com.gameloft.android2d.socialnetwork;

import com.facebook.FacebookException;
import com.facebook.model.GraphObject;

public class C0527k<T extends GraphObject> {
    final AbstractC0508ao afz;

    C0527k(AbstractC0508ao abstractC0508ao) {
        this.afz = abstractC0508ao;
    }

    public void m2777a(C0521e<T> c0521e, C0520d<T> c0520d) {
        if (c0521e != this.afz.ahc) {
            throw new FacebookException("Received callback for unknown loader.");
        }
        this.afz.mo2747a(c0521e, c0520d);
    }
}
