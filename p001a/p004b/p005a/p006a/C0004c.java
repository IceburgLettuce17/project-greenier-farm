package p001a.p004b.p005a.p006a;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;

final class C0004c implements Parcelable {
    public static final Parcelable.Creator<C0004c> CREATOR = new C0005d();
    private int mIndex;
    private String mName;

    private int f20n;

    private int f21o;

    private int f22q;

    private CharSequence f23r;

    private int f24s;

    private CharSequence f25t;

    private int[] f26u;

    public C0004c(RunnableC0003b runnableC0003b) {
        int i = 0;
        for (C0002a c0002a = runnableC0003b.f10k; c0002a != null; c0002a = c0002a.f0a) {
            if (c0002a.f8i != null) {
                i += c0002a.f8i.size();
            }
        }
        this.f26u = new int[i + (runnableC0003b.f12m * 7)];
        if (!runnableC0003b.f15p) {
            throw new IllegalStateException("Not on back stack");
        }
        int i2 = 0;
        for (C0002a c0002a2 = runnableC0003b.f10k; c0002a2 != null; c0002a2 = c0002a2.f0a) {
            int i3 = i2 + 1;
            this.f26u[i2] = c0002a2.f2c;
            int i4 = i3 + 1;
            this.f26u[i3] = c0002a2.f3d != null ? c0002a2.f3d.mIndex : -1;
            int i5 = i4 + 1;
            this.f26u[i4] = c0002a2.f4e;
            int i6 = i5 + 1;
            this.f26u[i5] = c0002a2.f5f;
            int i7 = i6 + 1;
            this.f26u[i6] = c0002a2.f6g;
            int i8 = i7 + 1;
            this.f26u[i7] = c0002a2.f7h;
            if (c0002a2.f8i != null) {
                int size = c0002a2.f8i.size();
                int i9 = i8 + 1;
                this.f26u[i8] = size;
                int i10 = 0;
                while (i10 < size) {
                    this.f26u[i9] = c0002a2.f8i.get(i10).mIndex;
                    i10++;
                    i9++;
                }
                i2 = i9;
            } else {
                i2 = i8 + 1;
                this.f26u[i8] = 0;
            }
        }
        this.f20n = runnableC0003b.f13n;
        this.f21o = runnableC0003b.f14o;
        this.mName = runnableC0003b.mName;
        this.mIndex = runnableC0003b.mIndex;
        this.f22q = runnableC0003b.f16q;
        this.f23r = runnableC0003b.f17r;
        this.f24s = runnableC0003b.f18s;
        this.f25t = runnableC0003b.f19t;
    }

    public C0004c(Parcel parcel) {
        this.f26u = parcel.createIntArray();
        this.f20n = parcel.readInt();
        this.f21o = parcel.readInt();
        this.mName = parcel.readString();
        this.mIndex = parcel.readInt();
        this.f22q = parcel.readInt();
        this.f23r = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f24s = parcel.readInt();
        this.f25t = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
    }

    public final RunnableC0003b m31a(C0015n c0015n) {
        RunnableC0003b runnableC0003b = new RunnableC0003b(c0015n);
        int i = 0;
        while (i < this.f26u.length) {
            C0002a c0002a = new C0002a();
            int i2 = i + 1;
            c0002a.f2c = this.f26u[i];
            int i3 = i2 + 1;
            int i4 = this.f26u[i2];
            if (i4 >= 0) {
                c0002a.f3d = c0015n.f41H.get(i4);
            } else {
                c0002a.f3d = null;
            }
            int i5 = i3 + 1;
            c0002a.f4e = this.f26u[i3];
            int i6 = i5 + 1;
            c0002a.f5f = this.f26u[i5];
            int i7 = i6 + 1;
            c0002a.f6g = this.f26u[i6];
            int i8 = i7 + 1;
            c0002a.f7h = this.f26u[i7];
            i = i8 + 1;
            int i9 = this.f26u[i8];
            if (i9 > 0) {
                c0002a.f8i = new ArrayList<>(i9);
                int i10 = 0;
                while (i10 < i9) {
                    c0002a.f8i.add(c0015n.f41H.get(this.f26u[i]));
                    i10++;
                    i++;
                }
            }
            runnableC0003b.m27a(c0002a);
        }
        runnableC0003b.f13n = this.f20n;
        runnableC0003b.f14o = this.f21o;
        runnableC0003b.mName = this.mName;
        runnableC0003b.mIndex = this.mIndex;
        runnableC0003b.f15p = true;
        runnableC0003b.f16q = this.f22q;
        runnableC0003b.f17r = this.f23r;
        runnableC0003b.f18s = this.f24s;
        runnableC0003b.f19t = this.f25t;
        runnableC0003b.m30b(1);
        return runnableC0003b;
    }

    @Override
    public final int describeContents() {
        return 0;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.f26u);
        parcel.writeInt(this.f20n);
        parcel.writeInt(this.f21o);
        parcel.writeString(this.mName);
        parcel.writeInt(this.mIndex);
        parcel.writeInt(this.f22q);
        TextUtils.writeToParcel(this.f23r, parcel, 0);
        parcel.writeInt(this.f24s);
        TextUtils.writeToParcel(this.f25t, parcel, 0);
    }
}
