package com.p026c.p027a.p028a;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

final class C0151f implements InterfaceC0149d {

    private IBinder f121bc;

    C0151f(IBinder iBinder) {
        this.f121bc = iBinder;
    }

    @Override
    public final IBinder asBinder() {
        return this.f121bc;
    }

    @Override
    public final void mo278j(Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.sec.android.iap.IAPServiceCallback");
            if (bundle != null) {
                obtain.writeInt(1);
                bundle.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f121bc.transact(1, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }
}
