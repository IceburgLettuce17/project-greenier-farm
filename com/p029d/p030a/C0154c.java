package com.p029d.p030a;

import android.os.IBinder;
import android.os.Parcel;

final class C0154c implements InterfaceC0152a {

    private IBinder f122bc;

    C0154c(IBinder iBinder) {
        this.f122bc = iBinder;
    }

    @Override
    public final IBinder asBinder() {
        return this.f122bc;
    }

    @Override
    public final String getPackageName() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.sina.sso.RemoteSSO");
            this.f122bc.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readString();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override
    public final String mo280tI() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.sina.sso.RemoteSSO");
            this.f122bc.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readString();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
