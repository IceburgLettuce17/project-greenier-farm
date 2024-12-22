package com.gameloft.android2d.socialnetwork;

import android.database.CursorIndexOutOfBoundsException;
import com.facebook.model.GraphObject;
import com.gameloft.android.LATAM.GloftGF2H.C0337q;
import java.util.ArrayList;
import java.util.Collection;

public final class C0520d<T extends GraphObject> {
    boolean closed;
    boolean fromCache;
    ArrayList<C0528l> graphObjects;
    boolean moreObjectsAvailable;
    private int pos;

    C0520d() {
        this.pos = -1;
        this.closed = false;
        this.graphObjects = new ArrayList<>();
        this.moreObjectsAvailable = false;
        this.fromCache = false;
    }

    C0520d(C0520d<T> c0520d) {
        this.pos = -1;
        this.closed = false;
        this.graphObjects = new ArrayList<>();
        this.moreObjectsAvailable = false;
        this.fromCache = false;
        this.pos = c0520d.pos;
        this.closed = c0520d.closed;
        this.graphObjects = new ArrayList<>();
        this.graphObjects.addAll(c0520d.graphObjects);
        this.fromCache = c0520d.fromCache;
    }

    public final void m2774aU(int i, int i2) {
        if (i < 0) {
            throw new CursorIndexOutOfBoundsException("Before first object.");
        }
        if (i >= this.graphObjects.size()) {
            throw new CursorIndexOutOfBoundsException("After last object.");
        }
        this.graphObjects.get(i).score = i2;
    }

    public final void addGraphObjects(Collection<T> collection, boolean z) {
        this.graphObjects.size();
        for (T t : collection) {
            C0528l m2070bJ = C0337q.m2070bJ();
            this.graphObjects.add(m2070bJ);
            m2070bJ.afI = SocialNetwork_Facebook.m2734g(t);
            m2070bJ.afB = SocialNetwork_Facebook.m2714b(t);
            SocialNetwork_Facebook.m2717c(t);
            m2070bJ.afC = SocialNetwork_Facebook.m2724d(t);
            m2070bJ.afD = SocialNetwork_Facebook.m2728f(t);
            m2070bJ.afE = SocialNetwork_Facebook.m2726e(t);
            m2070bJ.afF = SocialNetwork_Facebook.m2706a(t);
            m2070bJ.afG = SocialNetwork_Facebook.m2735h(t);
            SocialNetwork_Facebook.m2712a(SocialNetwork_Facebook.m2706a(t), SocialNetwork_Facebook.m2721cX(SocialNetwork_Facebook.m2706a(t)));
            SocialNetwork_Facebook.m2708a(m2070bJ);
        }
        this.fromCache |= z;
    }

    public final C0528l m2775ff(int i) {
        if (i < 0) {
            throw new CursorIndexOutOfBoundsException("Before first object.");
        }
        if (i >= this.graphObjects.size()) {
            throw new CursorIndexOutOfBoundsException("After last object.");
        }
        return this.graphObjects.get(i);
    }
}
