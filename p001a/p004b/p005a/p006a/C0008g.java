package p001a.p004b.p005a.p006a;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public final class C0008g implements Parcelable {

    final Bundle f27v;

    static {
        new C0009h();
    }

    C0008g(Parcel parcel, ClassLoader classLoader) {
        this.f27v = parcel.readBundle();
    }

    @Override
    public final int describeContents() {
        return 0;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.f27v);
    }
}
