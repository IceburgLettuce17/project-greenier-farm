package p001a.p004b.p005a.p006a;

import android.os.Parcel;
import android.os.Parcelable;

final class C0009h implements Parcelable.Creator<C0008g> {
    C0009h() {
    }

    @Override
    public final C0008g createFromParcel(Parcel parcel) {
        return new C0008g(parcel, null);
    }

    @Override
    public final C0008g[] newArray(int i) {
        return new C0008g[i];
    }
}
