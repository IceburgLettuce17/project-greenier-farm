package com.p026c.p027a.p028a;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class AbstractBinderC0150e extends Binder implements InterfaceC0149d {
    public static InterfaceC0149d m279d(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.sec.android.iap.IAPServiceCallback");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof InterfaceC0149d)) ? new C0151f(iBinder) : (InterfaceC0149d) queryLocalInterface;
    }

    @Override
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.sec.android.iap.IAPServiceCallback");
                mo278j(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                return true;
            case 1598968902:
                parcel2.writeString("com.sec.android.iap.IAPServiceCallback");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
