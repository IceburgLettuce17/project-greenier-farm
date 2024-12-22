package com.gameloft.android.LATAM.GloftGF2H;

import com.gameloft.android2d.socialnetwork.C0528l;
import p009b.p010a.p012b.C0051af;

public final class C0343w extends C0528l {

    public int f2651vk = -1;

    public final C0277ad m2146ca() {
        if (this.f2651vk != -2) {
            if (C0295av.m829aL(getId())) {
                return C0295av.m830dt();
            }
            C0051af m2778tu = super.m2778tu();
            if (m2778tu == null) {
                return null;
            }
            C0277ad c0277ad = new C0277ad(m2778tu);
            C0295av.m828a(getId(), c0277ad);
            return c0277ad;
        }
        if (C0295av.f623yN == null || (getId() != null && C0295av.userId != null && C0295av.userId.compareTo(getId()) != 0)) {
            C0051af m2778tu2 = super.m2778tu();
            if (m2778tu2 == null) {
                return null;
            }
            C0295av.f623yN = new C0277ad(m2778tu2);
            C0295av.userId = getId();
        }
        return C0295av.f623yN;
    }
}
