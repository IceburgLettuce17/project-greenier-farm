package p001a.p004b.p005a.p006a;

import android.os.Bundle;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import p001a.p004b.p005a.p007b.C0027a;
import p001a.p004b.p005a.p007b.InterfaceC0028b;

final class C0024w implements InterfaceC0028b<Object> {

    private boolean f65R;

    private Bundle f66ah;

    InterfaceC0022u<Object> f67ai;

    C0027a<Object> f68aj;

    boolean f69ak;

    boolean f70al;

    Object f71am;

    boolean f72an;

    boolean f73ao;

    private boolean f74ap;

    private C0023v f75aq;
    final int mId;
    boolean mRetaining;
    boolean mStarted;

    public C0024w(C0023v c0023v, int i, Bundle bundle, InterfaceC0022u<Object> interfaceC0022u) {
        this.f75aq = c0023v;
        this.mId = i;
        this.f66ah = bundle;
        this.f67ai = interfaceC0022u;
    }

    @Override
    public final void mo97a(C0027a<Object> c0027a, Object obj) {
        if (!this.f65R && this.f75aq.f62ae.get(this.mId) == this) {
            if (this.f71am != obj || !this.f69ak) {
                this.f71am = obj;
                this.f69ak = true;
                if (this.mStarted) {
                    m98b(c0027a, obj);
                }
            }
            C0024w c0024w = this.f75aq.f63af.get(this.mId);
            if (c0024w != null && c0024w != this) {
                c0024w.f70al = false;
                c0024w.destroy();
                this.f75aq.f63af.remove(this.mId);
            }
            if (this.f75aq.mActivity == null || this.f75aq.mo86A()) {
                return;
            }
            this.f75aq.mActivity.f30w.m73o();
        }
    }

    final void m98b(C0027a<Object> c0027a, Object obj) {
        String str;
        if (this.f67ai != null) {
            if (this.f75aq.mActivity != null) {
                String str2 = this.f75aq.mActivity.f30w.f52S;
                this.f75aq.mActivity.f30w.f52S = "onLoadFinished";
                str = str2;
            } else {
                str = null;
            }
            try {
                this.f67ai.onLoadFinished(c0027a, obj);
                this.f70al = true;
            } finally {
                if (this.f75aq.mActivity != null) {
                    this.f75aq.mActivity.f30w.f52S = str;
                }
            }
        }
    }

    final void destroy() {
        String str;
        this.f65R = true;
        boolean z = this.f70al;
        this.f70al = false;
        if (this.f67ai != null && this.f68aj != null && this.f69ak && z) {
            if (this.f75aq.mActivity != null) {
                String str2 = this.f75aq.mActivity.f30w.f52S;
                this.f75aq.mActivity.f30w.f52S = "onLoaderReset";
                str = str2;
            } else {
                str = null;
            }
            try {
                this.f67ai.onLoaderReset(this.f68aj);
            } finally {
                if (this.f75aq.mActivity != null) {
                    this.f75aq.mActivity.f30w.f52S = str;
                }
            }
        }
        this.f67ai = null;
        this.f71am = null;
        this.f69ak = false;
        if (this.f68aj != null) {
            if (this.f74ap) {
                this.f74ap = false;
                this.f68aj.unregisterListener(this);
            }
            this.f68aj.reset();
        }
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.mId);
        printWriter.print(" mArgs=");
        printWriter.println(this.f66ah);
        printWriter.print(str);
        printWriter.print("mCallbacks=");
        printWriter.println(this.f67ai);
        printWriter.print(str);
        printWriter.print("mLoader=");
        printWriter.println(this.f68aj);
        if (this.f68aj != null) {
            this.f68aj.dump(str + "  ", fileDescriptor, printWriter, strArr);
        }
        if (this.f69ak || this.f70al) {
            printWriter.print(str);
            printWriter.print("mHaveData=");
            printWriter.print(this.f69ak);
            printWriter.print("  mDeliveredData=");
            printWriter.println(this.f70al);
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(this.f71am);
        }
        printWriter.print(str);
        printWriter.print("mStarted=");
        printWriter.print(this.mStarted);
        printWriter.print(" mReportNextStart=");
        printWriter.print(this.f73ao);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f65R);
        printWriter.print(str);
        printWriter.print("mRetaining=");
        printWriter.print(this.mRetaining);
        printWriter.print(" mRetainingStarted=");
        printWriter.print(this.f72an);
        printWriter.print(" mListenerRegistered=");
        printWriter.println(this.f74ap);
    }

    final void start() {
        if (this.mRetaining && this.f72an) {
            this.mStarted = true;
            return;
        }
        if (this.mStarted) {
            return;
        }
        this.mStarted = true;
        if (this.f68aj == null && this.f67ai != null) {
            this.f68aj = this.f67ai.onCreateLoader(this.mId, this.f66ah);
        }
        if (this.f68aj != null) {
            if (this.f68aj.getClass().isMemberClass() && !Modifier.isStatic(this.f68aj.getClass().getModifiers())) {
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.f68aj);
            }
            if (!this.f74ap) {
                this.f68aj.registerListener(this.mId, this);
                this.f74ap = true;
            }
            this.f68aj.startLoading();
        }
    }

    final void stop() {
        this.mStarted = false;
        if (this.mRetaining || this.f68aj == null || !this.f74ap) {
            return;
        }
        this.f74ap = false;
        this.f68aj.unregisterListener(this);
        this.f68aj.stopLoading();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append("LoaderInfo{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" #");
        sb.append(this.mId);
        sb.append(" : ");
        C0002a.m7a(this.f68aj, sb);
        sb.append("}}");
        return sb.toString();
    }
}
