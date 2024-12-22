package com.p020a.p021a.p022a;

import p001a.p004b.p005a.p006a.C0002a;

final class C0126m implements InterfaceC0139z {

    private final C0117d f105aS = C0118e.m251d("KiwiRequestHandlerHandlerThread");

    C0126m() {
    }

    @Override
    public final void mo247e(String str) {
        if (C0002a.m12a()) {
            C0002a.m9a("KiwiRequestHandler", "sendGetUserIdRequest");
        }
        this.f105aS.post(new RunnableC0127n(this, str));
    }

    @Override
    public final void mo248e(String str, String str2) {
        if (C0002a.m12a()) {
            C0002a.m9a("KiwiRequestHandler", "sendPurchaseRequest");
        }
        this.f105aS.post(new RunnableC0128o(this, str, str2));
    }
}
