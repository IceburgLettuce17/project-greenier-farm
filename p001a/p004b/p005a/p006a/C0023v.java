package p001a.p004b.p005a.p006a;

import android.os.Bundle;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import p001a.p004b.p005a.p007b.C0027a;
import p001a.p004b.p005a.p008c.C0034b;

final class C0023v extends AbstractC0021t {
    static boolean DEBUG = false;

    final C0034b<C0024w> f62ae = new C0034b<>();

    final C0034b<C0024w> f63af = new C0034b<>();

    private boolean f64ag;
    ActivityC0010i mActivity;
    boolean mRetaining;
    private boolean mStarted;

    C0023v(ActivityC0010i activityC0010i, boolean z) {
        this.mActivity = activityC0010i;
        this.mStarted = z;
    }

    private C0024w m88b(int i, Bundle bundle, InterfaceC0022u<Object> interfaceC0022u) {
        try {
            this.f64ag = true;
            C0024w c0024w = new C0024w(this, i, bundle, interfaceC0022u);
            c0024w.f68aj = interfaceC0022u.onCreateLoader(i, bundle);
            this.f62ae.put(c0024w.mId, c0024w);
            if (this.mStarted) {
                c0024w.start();
            }
            return c0024w;
        } finally {
            this.f64ag = false;
        }
    }

    @Override
    public final boolean mo86A() {
        int size = this.f62ae.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            C0024w valueAt = this.f62ae.valueAt(i);
            z |= valueAt.mStarted && !valueAt.f70al;
        }
        return z;
    }

    final void m89B() {
        if (this.mStarted) {
            RuntimeException runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doStart when already started: " + this, runtimeException);
        } else {
            this.mStarted = true;
            for (int size = this.f62ae.size() - 1; size >= 0; size--) {
                this.f62ae.valueAt(size).start();
            }
        }
    }

    final void m90C() {
        if (!this.mStarted) {
            RuntimeException runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doStop when not started: " + this, runtimeException);
        } else {
            for (int size = this.f62ae.size() - 1; size >= 0; size--) {
                this.f62ae.valueAt(size).stop();
            }
            this.mStarted = false;
        }
    }

    final void m91D() {
        if (!this.mStarted) {
            RuntimeException runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doRetain when not started: " + this, runtimeException);
            return;
        }
        this.mRetaining = true;
        this.mStarted = false;
        for (int size = this.f62ae.size() - 1; size >= 0; size--) {
            C0024w valueAt = this.f62ae.valueAt(size);
            valueAt.mRetaining = true;
            valueAt.f72an = valueAt.mStarted;
            valueAt.mStarted = false;
            valueAt.f67ai = null;
        }
    }

    final void m92E() {
        if (this.mRetaining) {
            this.mRetaining = false;
            for (int size = this.f62ae.size() - 1; size >= 0; size--) {
                C0024w valueAt = this.f62ae.valueAt(size);
                if (valueAt.mRetaining) {
                    valueAt.mRetaining = false;
                    if (valueAt.mStarted != valueAt.f72an && !valueAt.mStarted) {
                        valueAt.stop();
                    }
                }
                if (valueAt.mStarted && valueAt.f69ak && !valueAt.f73ao) {
                    valueAt.m98b(valueAt.f68aj, valueAt.f71am);
                }
            }
        }
    }

    final void m93F() {
        for (int size = this.f62ae.size() - 1; size >= 0; size--) {
            this.f62ae.valueAt(size).f73ao = true;
        }
    }

    final void m94G() {
        for (int size = this.f62ae.size() - 1; size >= 0; size--) {
            C0024w valueAt = this.f62ae.valueAt(size);
            if (valueAt.mStarted && valueAt.f73ao) {
                valueAt.f73ao = false;
                if (valueAt.f69ak) {
                    valueAt.m98b(valueAt.f68aj, valueAt.f71am);
                }
            }
        }
    }

    final void m95H() {
        if (!this.mRetaining) {
            for (int size = this.f62ae.size() - 1; size >= 0; size--) {
                this.f62ae.valueAt(size).destroy();
            }
        }
        for (int size2 = this.f63af.size() - 1; size2 >= 0; size2--) {
            this.f63af.valueAt(size2).destroy();
        }
        this.f63af.clear();
    }

    @Override
    public final <D> C0027a<D> mo87a(int i, Bundle bundle, InterfaceC0022u<D> interfaceC0022u) {
        if (this.f64ag) {
            throw new IllegalStateException("Called while creating a loader");
        }
        C0024w c0024w = this.f62ae.get(0);
        if (c0024w == null) {
            c0024w = m88b(0, null, interfaceC0022u);
        } else {
            c0024w.f67ai = interfaceC0022u;
        }
        if (c0024w.f69ak && this.mStarted) {
            c0024w.m98b(c0024w.f68aj, c0024w.f71am);
        }
        return (C0027a<D>) c0024w.f68aj;
    }

    final void m96c(ActivityC0010i activityC0010i) {
        this.mActivity = activityC0010i;
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if (this.f62ae.size() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i = 0; i < this.f62ae.size(); i++) {
                C0024w valueAt = this.f62ae.valueAt(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f62ae.keyAt(i));
                printWriter.print(": ");
                printWriter.println(valueAt.toString());
                valueAt.dump(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.f63af.size() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            for (int i2 = 0; i2 < this.f63af.size(); i2++) {
                C0024w valueAt2 = this.f63af.valueAt(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f63af.keyAt(i2));
                printWriter.print(": ");
                printWriter.println(valueAt2.toString());
                valueAt2.dump(str3, fileDescriptor, printWriter, strArr);
            }
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        C0002a.m7a(this.mActivity, sb);
        sb.append("}}");
        return sb.toString();
    }
}
