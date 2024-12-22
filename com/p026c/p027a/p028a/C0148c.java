package com.p026c.p027a.p028a;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

final class C0148c implements InterfaceC0146a {

    private IBinder f120bc;

    C0148c(IBinder iBinder) {
        this.f120bc = iBinder;
    }

    @Override
    public final Bundle mo272a(int i, String str, String str2, int i2, int i3, String str3) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.sec.android.iap.IAPConnector");
            obtain.writeInt(i);
            obtain.writeString(str);
            obtain.writeString(str2);
            obtain.writeInt(i2);
            obtain.writeInt(i3);
            obtain.writeString(str3);
            this.f120bc.transact(4, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override
    public final Bundle mo273a(String str, String str2, int i, int i2, String str3, String str4) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.sec.android.iap.IAPConnector");
            obtain.writeString(str);
            obtain.writeString(str2);
            obtain.writeInt(i);
            obtain.writeInt(i2);
            obtain.writeString(str3);
            obtain.writeString(str4);
            this.f120bc.transact(5, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override
    public final boolean mo274a(InterfaceC0149d interfaceC0149d) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.sec.android.iap.IAPConnector");
            obtain.writeStrongBinder(interfaceC0149d != null ? interfaceC0149d.asBinder() : null);
            this.f120bc.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override
    public final boolean mo275a(InterfaceC0149d interfaceC0149d, Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.sec.android.iap.IAPConnector");
            obtain.writeStrongBinder(interfaceC0149d != null ? interfaceC0149d.asBinder() : null);
            if (bundle != null) {
                obtain.writeInt(1);
                bundle.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f120bc.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override
    public final IBinder asBinder() {
        return this.f120bc;
    }

    @Override
    public final Bundle mo276fh(int i) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.sec.android.iap.IAPConnector");
            obtain.writeInt(i);
            this.f120bc.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
