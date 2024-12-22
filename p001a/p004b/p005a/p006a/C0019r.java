package p001a.p004b.p005a.p006a;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

final class C0019r implements Parcelable {
    public static final Parcelable.Creator<C0019r> CREATOR = new C0020s();

    private String f60ac;

    ComponentCallbacksC0006e f61ad;
    private Bundle mArguments;
    private int mContainerId;
    private boolean mDetached;
    private int mFragmentId;
    private boolean mFromLayout;
    private int mIndex;
    private boolean mRetainInstance;
    Bundle mSavedFragmentState;
    private String mTag;

    public C0019r(ComponentCallbacksC0006e componentCallbacksC0006e) {
        this.f60ac = componentCallbacksC0006e.getClass().getName();
        this.mIndex = componentCallbacksC0006e.mIndex;
        this.mFromLayout = componentCallbacksC0006e.mFromLayout;
        this.mFragmentId = componentCallbacksC0006e.mFragmentId;
        this.mContainerId = componentCallbacksC0006e.mContainerId;
        this.mTag = componentCallbacksC0006e.mTag;
        this.mRetainInstance = componentCallbacksC0006e.mRetainInstance;
        this.mDetached = componentCallbacksC0006e.mDetached;
        this.mArguments = componentCallbacksC0006e.mArguments;
    }

    public C0019r(Parcel parcel) {
        this.f60ac = parcel.readString();
        this.mIndex = parcel.readInt();
        this.mFromLayout = parcel.readInt() != 0;
        this.mFragmentId = parcel.readInt();
        this.mContainerId = parcel.readInt();
        this.mTag = parcel.readString();
        this.mRetainInstance = parcel.readInt() != 0;
        this.mDetached = parcel.readInt() != 0;
        this.mArguments = parcel.readBundle();
        this.mSavedFragmentState = parcel.readBundle();
    }

    public final ComponentCallbacksC0006e m85b(ActivityC0010i activityC0010i) {
        if (this.f61ad != null) {
            return this.f61ad;
        }
        if (this.mArguments != null) {
            this.mArguments.setClassLoader(activityC0010i.getClassLoader());
        }
        this.f61ad = ComponentCallbacksC0006e.instantiate(activityC0010i, this.f60ac, this.mArguments);
        if (this.mSavedFragmentState != null) {
            this.mSavedFragmentState.setClassLoader(activityC0010i.getClassLoader());
            this.f61ad.mSavedFragmentState = this.mSavedFragmentState;
        }
        this.f61ad.setIndex(this.mIndex);
        this.f61ad.mFromLayout = this.mFromLayout;
        this.f61ad.mRestored = true;
        this.f61ad.mFragmentId = this.mFragmentId;
        this.f61ad.mContainerId = this.mContainerId;
        this.f61ad.mTag = this.mTag;
        this.f61ad.mRetainInstance = this.mRetainInstance;
        this.f61ad.mDetached = this.mDetached;
        this.f61ad.mFragmentManager = activityC0010i.f30w;
        return this.f61ad;
    }

    @Override
    public final int describeContents() {
        return 0;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f60ac);
        parcel.writeInt(this.mIndex);
        parcel.writeInt(this.mFromLayout ? 1 : 0);
        parcel.writeInt(this.mFragmentId);
        parcel.writeInt(this.mContainerId);
        parcel.writeString(this.mTag);
        parcel.writeInt(this.mRetainInstance ? 1 : 0);
        parcel.writeInt(this.mDetached ? 1 : 0);
        parcel.writeBundle(this.mArguments);
        parcel.writeBundle(this.mSavedFragmentState);
    }
}
