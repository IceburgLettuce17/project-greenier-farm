package com.gameloft.android2d.iap.p042a.p047e;

import java.util.List;
import p001a.p004b.p005a.p006a.InterfaceC0014m;

final class RunnableC0398t implements Runnable {
    private List abk;
    private RunnableC0396r abl;

    RunnableC0398t(RunnableC0396r runnableC0396r, List list) {
        this.abl = runnableC0396r;
        this.abk = list;
    }

    @Override
    public final void run() {
        InterfaceC0014m interfaceC0014m = this.abl.abj;
        List list = this.abl.abh;
        List list2 = this.abk;
    }
}
