package com.p023b.p024a.p025a;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

final class C0145f implements InterfaceC0143d {

    private IBinder f119bc;

    C0145f(IBinder iBinder) {
        this.f119bc = iBinder;
    }

    @Override
    public final Bundle mo270a(Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.android.vending.billing.IMarketBillingService");
            if (bundle != null) {
                obtain.writeInt(1);
                bundle.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f119bc.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override
    public final IBinder asBinder() {
        return this.f119bc;
    }
}
