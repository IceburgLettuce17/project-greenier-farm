package com.p023b.p024a.p025a;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

final class C0142c implements InterfaceC0140a {

    private IBinder f118bc;

    C0142c(IBinder iBinder) {
        this.f118bc = iBinder;
    }

    @Override
    public final int mo264a(int i, String str, String str2) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
            obtain.writeInt(i);
            obtain.writeString(str);
            obtain.writeString(str2);
            this.f118bc.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override
    public final Bundle mo265a(int i, String str, String str2, Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
            obtain.writeInt(i);
            obtain.writeString(str);
            obtain.writeString(str2);
            if (bundle != null) {
                obtain.writeInt(1);
                bundle.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f118bc.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override
    public final Bundle mo266a(int i, String str, String str2, String str3) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
            obtain.writeInt(i);
            obtain.writeString(str);
            obtain.writeString(str2);
            obtain.writeString(str3);
            this.f118bc.transact(4, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override
    public final Bundle mo267a(int i, String str, String str2, String str3, String str4) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
            obtain.writeInt(i);
            obtain.writeString(str);
            obtain.writeString(str2);
            obtain.writeString(str3);
            obtain.writeString(str4);
            this.f118bc.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override
    public final IBinder asBinder() {
        return this.f118bc;
    }

    @Override
    public final int mo268b(int i, String str, String str2) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
            obtain.writeInt(i);
            obtain.writeString(str);
            obtain.writeString(str2);
            this.f118bc.transact(5, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
