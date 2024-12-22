package p001a.p004b.p005a.p006a;

import android.os.Parcel;
import android.os.Parcelable;

final class C0005d implements Parcelable.Creator<C0004c> {
    C0005d() {
    }

    @Override
    public final C0004c createFromParcel(Parcel parcel) {
        return new C0004c(parcel);
    }

    @Override
    public final C0004c[] newArray(int i) {
        return new C0004c[i];
    }
}
