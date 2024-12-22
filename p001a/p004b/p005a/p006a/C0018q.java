package p001a.p004b.p005a.p006a;

import android.os.Parcel;
import android.os.Parcelable;

final class C0018q implements Parcelable.Creator<C0017p> {
    C0018q() {
    }

    @Override
    public final C0017p createFromParcel(Parcel parcel) {
        return new C0017p(parcel);
    }

    @Override
    public final C0017p[] newArray(int i) {
        return new C0017p[i];
    }
}
