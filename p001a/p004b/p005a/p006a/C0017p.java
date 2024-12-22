package p001a.p004b.p005a.p006a;

import android.os.Parcel;
import android.os.Parcelable;

final class C0017p implements Parcelable {

    C0019r[] f57Z;

    int[] f58aa;

    C0004c[] f59ab;

    static {
        new C0018q();
    }

    public C0017p() {
    }

    public C0017p(Parcel parcel) {
        this.f57Z = (C0019r[]) parcel.createTypedArray(C0019r.CREATOR);
        this.f58aa = parcel.createIntArray();
        this.f59ab = (C0004c[]) parcel.createTypedArray(C0004c.CREATOR);
    }

    @Override
    public final int describeContents() {
        return 0;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.f57Z, i);
        parcel.writeIntArray(this.f58aa);
        parcel.writeTypedArray(this.f59ab, i);
    }
}
