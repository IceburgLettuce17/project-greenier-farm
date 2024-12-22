package com.gameloft.android.LATAM.GloftGF2H;

import p009b.p010a.p012b.C0065n;
import p009b.p010a.p015d.AbstractActivityC0092a;

public class GloftGF2H extends AbstractActivityC0092a {

    public static C0320bt f303uT;

    public static GloftGF2H f304uU;

    public GloftGF2H() {
        f304uU = this;
    }

    @Override
    public final void mo212bX() {
        if (f303uT == null) {
            C0320bt c0320bt = new C0320bt(this, C0065n.m161b(this));
            f303uT = c0320bt;
            c0320bt.m512aO();
            try {
                f304uU.m215dj("MIDlet://stayAwake");
            } catch (Exception e) {
            }
        }
    }

    @Override
    public final void mo213bY() {
        f303uT.mo146aQ();
    }

    public final void m514bZ() {
        if (f303uT != null) {
            C0320bt c0320bt = f303uT;
            GLLib.f136iE = -1;
        }
    }
}
