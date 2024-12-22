package p001a.p004b.p005a.p006a;

import android.os.Parcel;
import android.os.Parcelable;

final class C0020s implements Parcelable.Creator<C0019r> {
    C0020s() {
    }

    @Override
    public final C0019r createFromParcel(Parcel parcel) {
        return new C0019r(parcel);
    }

    @Override
    public final C0019r[] newArray(int i) {
        return new C0019r[i];
    }
}
