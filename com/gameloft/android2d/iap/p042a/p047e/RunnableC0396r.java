package com.gameloft.android2d.iap.p042a.p047e;

import android.os.Handler;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;
import p001a.p004b.p005a.p006a.InterfaceC0014m;

final class RunnableC0396r implements Runnable {
    private C0392n aaZ;
    private Handler abc;
    final List abh;
    final C0399u abi;
    final InterfaceC0014m abj;

    RunnableC0396r(C0392n c0392n, List list, C0399u c0399u, Handler handler, InterfaceC0014m interfaceC0014m) {
        this.aaZ = c0392n;
        this.abh = list;
        this.abi = c0399u;
        this.abc = handler;
        this.abj = interfaceC0014m;
    }

    @Override
    public final void run() {
        C0392n c0392n;
        ArrayList arrayList = new ArrayList();
        for (C0370aa c0370aa : this.abh) {
            try {
                c0392n = this.aaZ;
                c0392n.m2350cb("consume");
            } catch (C0391m e) {
                arrayList.add(e.m2339rV());
            }
            if (!c0370aa.abr.equals("inapp")) {
                throw new C0391m(-1010, "Items of type '" + c0370aa.abr + "' can't be consumed.");
            }
            try {
                String str = c0370aa.abv;
                String str2 = c0370aa.abt;
                if (str == null || str.equals("")) {
                    c0392n.m2352ce("Can't consume " + str2 + ". No token.");
                    throw new C0391m(-1007, "PurchaseInfo is missing token for sku: " + str2 + " " + c0370aa);
                }
                c0392n.m2351cd("Consuming sku: " + str2 + ", token: " + str);
                int mo268b = c0392n.aaS.mo268b(3, c0392n.mContext.getPackageName(), str);
                if (mo268b != 0) {
                    c0392n.m2351cd("Error consuming consuming sku " + str2 + ". " + C0392n.m2344eY(mo268b));
                    throw new C0391m(mo268b, "Error consuming sku " + str2);
                }
                c0392n.m2351cd("Successfully consumed sku: " + str2);
                arrayList.add(new C0403y(0, "Successful consume of sku " + c0370aa.abt));
            } catch (RemoteException e2) {
                throw new C0391m(-1001, "Remote exception while consuming. PurchaseInfo: " + c0370aa, e2);
            }
        }
        this.aaZ.m2353rW();
        if (this.abi != null) {
            this.abc.post(new RunnableC0397s(this, arrayList));
        }
        if (this.abj != null) {
            this.abc.post(new RunnableC0398t(this, arrayList));
        }
    }
}
