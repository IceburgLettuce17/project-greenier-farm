package p001a.p004b.p005a.p007b;

import android.content.Context;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import p001a.p004b.p005a.p006a.C0002a;

public class C0027a<D> {
    Context mContext;
    int mId;
    InterfaceC0028b<D> mListener;
    boolean mStarted = false;
    boolean mAbandoned = false;
    boolean mReset = true;
    boolean mContentChanged = false;

    public C0027a(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public void abandon() {
        this.mAbandoned = true;
        onAbandon();
    }

    public String dataToString(D d) {
        StringBuilder sb = new StringBuilder(64);
        C0002a.m7a(d, sb);
        sb.append("}");
        return sb.toString();
    }

    public void deliverResult(D d) {
        if (this.mListener != null) {
            this.mListener.mo97a(this, d);
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.mId);
        printWriter.print(" mListener=");
        printWriter.println(this.mListener);
        printWriter.print(str);
        printWriter.print("mStarted=");
        printWriter.print(this.mStarted);
        printWriter.print(" mContentChanged=");
        printWriter.print(this.mContentChanged);
        printWriter.print(" mAbandoned=");
        printWriter.print(this.mAbandoned);
        printWriter.print(" mReset=");
        printWriter.println(this.mReset);
    }

    public void forceLoad() {
        onForceLoad();
    }

    public Context getContext() {
        return this.mContext;
    }

    public int getId() {
        return this.mId;
    }

    public boolean isAbandoned() {
        return this.mAbandoned;
    }

    public boolean isReset() {
        return this.mReset;
    }

    public boolean isStarted() {
        return this.mStarted;
    }

    protected void onAbandon() {
    }

    public void onContentChanged() {
        if (this.mStarted) {
            forceLoad();
        } else {
            this.mContentChanged = true;
        }
    }

    protected void onForceLoad() {
    }

    protected void onReset() {
    }

    public void onStartLoading() {
    }

    protected void onStopLoading() {
    }

    public void registerListener(int i, InterfaceC0028b<D> interfaceC0028b) {
        if (this.mListener != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.mListener = interfaceC0028b;
        this.mId = i;
    }

    public void reset() {
        onReset();
        this.mReset = true;
        this.mStarted = false;
        this.mAbandoned = false;
        this.mContentChanged = false;
    }

    public final void startLoading() {
        this.mStarted = true;
        this.mReset = false;
        this.mAbandoned = false;
        onStartLoading();
    }

    public void stopLoading() {
        this.mStarted = false;
        onStopLoading();
    }

    public boolean takeContentChanged() {
        boolean z = this.mContentChanged;
        this.mContentChanged = false;
        return z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        C0002a.m7a(this, sb);
        sb.append(" id=");
        sb.append(this.mId);
        sb.append("}");
        return sb.toString();
    }

    public void unregisterListener(InterfaceC0028b<D> interfaceC0028b) {
        if (this.mListener == null) {
            throw new IllegalStateException("No listener register");
        }
        if (this.mListener != interfaceC0028b) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
        this.mListener = null;
    }
}
