package com.p026c.p027a.p028a;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.facebook.android.C0217R;

public abstract class AbstractBinderC0147b extends Binder implements InterfaceC0146a {
    public static InterfaceC0146a m277c(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.sec.android.iap.IAPConnector");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof InterfaceC0146a)) ? new C0148c(iBinder) : (InterfaceC0146a) queryLocalInterface;
    }

    @Override
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.sec.android.iap.IAPConnector");
                boolean a2 = mo275a(AbstractBinderC0150e.m279d(parcel.readStrongBinder()), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                parcel2.writeInt(a2 ? 1 : 0);
                return true;
            case 2:
                parcel.enforceInterface("com.sec.android.iap.IAPConnector");
                boolean a3 = mo274a(AbstractBinderC0150e.m279d(parcel.readStrongBinder()));
                parcel2.writeNoException();
                parcel2.writeInt(a3 ? 1 : 0);
                return true;
            case 3:
                parcel.enforceInterface("com.sec.android.iap.IAPConnector");
                Bundle fh = mo276fh(parcel.readInt());
                parcel2.writeNoException();
                if (fh == null) {
                    parcel2.writeInt(0);
                    return true;
                }
                parcel2.writeInt(1);
                fh.writeToParcel(parcel2, 1);
                return true;
            case C0217R.styleable.com_facebook_picker_fragment_done_button_text:
                parcel.enforceInterface("com.sec.android.iap.IAPConnector");
                Bundle a4 = mo272a(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                if (a4 == null) {
                    parcel2.writeInt(0);
                    return true;
                }
                parcel2.writeInt(1);
                a4.writeToParcel(parcel2, 1);
                return true;
            case C0217R.styleable.com_facebook_picker_fragment_title_bar_background:
                parcel.enforceInterface("com.sec.android.iap.IAPConnector");
                Bundle a5 = mo273a(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                if (a5 == null) {
                    parcel2.writeInt(0);
                    return true;
                }
                parcel2.writeInt(1);
                a5.writeToParcel(parcel2, 1);
                return true;
            case 1598968902:
                parcel2.writeString("com.sec.android.iap.IAPConnector");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
