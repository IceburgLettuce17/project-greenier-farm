package com.p023b.p024a.p025a;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.facebook.android.C0217R;

public abstract class AbstractBinderC0141b extends Binder implements InterfaceC0140a {
    public static InterfaceC0140a m269a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.android.vending.billing.IInAppBillingService");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof InterfaceC0140a)) ? new C0142c(iBinder) : (InterfaceC0140a) queryLocalInterface;
    }

    @Override
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.android.vending.billing.IInAppBillingService");
                int a2 = mo264a(parcel.readInt(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(a2);
                return true;
            case 2:
                parcel.enforceInterface("com.android.vending.billing.IInAppBillingService");
                Bundle a3 = mo265a(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                if (a3 != null) {
                    parcel2.writeInt(1);
                    a3.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            case 3:
                parcel.enforceInterface("com.android.vending.billing.IInAppBillingService");
                Bundle a4 = mo267a(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                if (a4 != null) {
                    parcel2.writeInt(1);
                    a4.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            case C0217R.styleable.com_facebook_picker_fragment_done_button_text:
                parcel.enforceInterface("com.android.vending.billing.IInAppBillingService");
                Bundle a5 = mo266a(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                if (a5 != null) {
                    parcel2.writeInt(1);
                    a5.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            case C0217R.styleable.com_facebook_picker_fragment_title_bar_background:
                parcel.enforceInterface("com.android.vending.billing.IInAppBillingService");
                int b2 = mo268b(parcel.readInt(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(b2);
                return true;
            case 1598968902:
                parcel2.writeString("com.android.vending.billing.IInAppBillingService");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
