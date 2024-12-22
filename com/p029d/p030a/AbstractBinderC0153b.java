package com.p029d.p030a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class AbstractBinderC0153b extends Binder implements InterfaceC0152a {
    public static InterfaceC0152a m281e(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.sina.sso.RemoteSSO");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof InterfaceC0152a)) ? new C0154c(iBinder) : (InterfaceC0152a) queryLocalInterface;
    }

    @Override
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.sina.sso.RemoteSSO");
                String packageName = getPackageName();
                parcel2.writeNoException();
                parcel2.writeString(packageName);
                return true;
            case 2:
                parcel.enforceInterface("com.sina.sso.RemoteSSO");
                String tI = mo280tI();
                parcel2.writeNoException();
                parcel2.writeString(tI);
                return true;
            case 1598968902:
                parcel2.writeString("com.sina.sso.RemoteSSO");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
