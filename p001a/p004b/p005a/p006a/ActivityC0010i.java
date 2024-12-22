package p001a.p004b.p005a.p006a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.facebook.android.C0217R;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import p001a.p004b.p005a.p008c.C0034b;

public final class ActivityC0010i extends Activity {

    private boolean f28A;

    private C0034b<C0023v> f29B;
    private boolean mCheckedForLoaderManager;
    final Handler mHandler;
    private C0023v mLoaderManager;
    private boolean mLoadersStarted;
    private boolean mResumed;
    boolean mRetaining;

    final C0015n f30w;

    private boolean f31x;

    private boolean f32y;

    private boolean f33z;

    private void m32b(boolean z) {
        if (this.f33z) {
            return;
        }
        this.f33z = true;
        this.mRetaining = z;
        this.mHandler.removeMessages(1);
        if (this.mLoadersStarted) {
            this.mLoadersStarted = false;
            if (this.mLoaderManager != null) {
                if (this.mRetaining) {
                    this.mLoaderManager.m91D();
                } else {
                    this.mLoaderManager.m90C();
                }
            }
        }
        this.f30w.m82x();
    }

    public static void m33l() {
    }

    final C0023v m34a(int i, boolean z, boolean z2) {
        if (this.f29B == null) {
            this.f29B = new C0034b<>();
        }
        C0023v c0023v = this.f29B.get(i);
        if (c0023v != null) {
            c0023v.m96c(this);
            return c0023v;
        }
        if (!z2) {
            return c0023v;
        }
        C0023v c0023v2 = new C0023v(this, z);
        this.f29B.put(i, c0023v2);
        return c0023v2;
    }

    public final void m35a(ComponentCallbacksC0006e componentCallbacksC0006e, Intent intent, int i) {
        if (i == -1) {
            super.startActivityForResult(intent, -1);
        } else {
            if (((-65536) & i) != 0) {
                throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
            }
            super.startActivityForResult(intent, ((componentCallbacksC0006e.mIndex + 1) << 16) + (65535 & i));
        }
    }

    final void m36c(int i) {
        C0023v c0023v;
        if (this.f29B == null || (c0023v = this.f29B.get(i)) == null || c0023v.mRetaining) {
            return;
        }
        c0023v.m95H();
        this.f29B.remove(i);
    }

    @Override
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i = Build.VERSION.SDK_INT;
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.f31x);
        printWriter.print("mResumed=");
        printWriter.print(this.mResumed);
        printWriter.print(" mStopped=");
        printWriter.print(this.f32y);
        printWriter.print(" mReallyStopped=");
        printWriter.println(this.f33z);
        printWriter.print(str2);
        printWriter.print("mLoadersStarted=");
        printWriter.println(this.mLoadersStarted);
        if (this.mLoaderManager != null) {
            printWriter.print(str);
            printWriter.print("Loader Manager ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this.mLoaderManager)));
            printWriter.println(":");
            this.mLoaderManager.dump(str + "  ", fileDescriptor, printWriter, strArr);
        }
        this.f30w.dump(str, fileDescriptor, printWriter, strArr);
    }

    public final void m37k() {
        if (Build.VERSION.SDK_INT >= 11) {
            invalidateOptionsMenu();
        } else {
            this.f28A = true;
        }
    }

    @Override
    protected final void onActivityResult(int i, int i2, Intent intent) {
        int i3 = i >> 16;
        if (i3 == 0) {
            super.onActivityResult(i, i2, intent);
            return;
        }
        int i4 = i3 - 1;
        if (this.f30w.f41H == null || i4 < 0 || i4 >= this.f30w.f41H.size()) {
            Log.w("FragmentActivity", "Activity result fragment index out of range: 0x" + Integer.toHexString(i));
            return;
        }
        ComponentCallbacksC0006e componentCallbacksC0006e = this.f30w.f41H.get(i4);
        if (componentCallbacksC0006e == null) {
            Log.w("FragmentActivity", "Activity result no fragment exists for index: 0x" + Integer.toHexString(i));
        } else {
            componentCallbacksC0006e.onActivityResult(65535 & i, i2, intent);
        }
    }

    @Override
    public final void onBackPressed() {
        if (this.f30w.popBackStackImmediate()) {
            return;
        }
        finish();
    }

    @Override
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f30w.dispatchConfigurationChanged(configuration);
    }

    @Override
    protected final void onCreate(Bundle bundle) {
        this.f30w.m58a(this);
        if (getLayoutInflater().getFactory() == null) {
            getLayoutInflater().setFactory(this);
        }
        super.onCreate(bundle);
        C0012k c0012k = (C0012k) getLastNonConfigurationInstance();
        if (c0012k != null) {
            this.f29B = c0012k.f36E;
        }
        if (bundle != null) {
            this.f30w.m59a(bundle.getParcelable("android:support:fragments"), c0012k != null ? c0012k.f35D : null);
        }
        this.f30w.m78t();
    }

    @Override
    public final boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0) {
            return super.onCreatePanelMenu(i, menu);
        }
        boolean onCreatePanelMenu = super.onCreatePanelMenu(i, menu) | this.f30w.m61a(menu, getMenuInflater());
        if (Build.VERSION.SDK_INT >= 11) {
            return onCreatePanelMenu;
        }
        return true;
    }

    @Override
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        if (!"fragment".equals(str)) {
            return super.onCreateView(str, context, attributeSet);
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0011j.f34C);
        if (attributeValue == null) {
            attributeValue = obtainStyledAttributes.getString(0);
        }
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        String string = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        ComponentCallbacksC0006e m69d = resourceId != -1 ? this.f30w.m69d(resourceId) : null;
        if (m69d == null && string != null) {
            m69d = this.f30w.m67c(string);
        }
        if (m69d == null) {
            m69d = this.f30w.m69d(0);
        }
        if (m69d == null) {
            ComponentCallbacksC0006e instantiate = ComponentCallbacksC0006e.instantiate(this, attributeValue);
            instantiate.mFromLayout = true;
            instantiate.mFragmentId = resourceId != 0 ? resourceId : 0;
            instantiate.mContainerId = 0;
            instantiate.mTag = string;
            instantiate.mInLayout = true;
            instantiate.mFragmentManager = this.f30w;
            instantiate.onInflate(this, attributeSet, instantiate.mSavedFragmentState);
            this.f30w.m57a(instantiate, true);
            m69d = instantiate;
        } else {
            if (m69d.mInLayout) {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(0) + " with another fragment for " + attributeValue);
            }
            m69d.mInLayout = true;
            if (!m69d.mRetaining) {
                m69d.onInflate(this, attributeSet, m69d.mSavedFragmentState);
            }
            this.f30w.m63b(m69d);
        }
        if (m69d.mView == null) {
            throw new IllegalStateException("Fragment " + attributeValue + " did not create a view.");
        }
        if (resourceId != 0) {
            m69d.mView.setId(resourceId);
        }
        if (m69d.mView.getTag() == null) {
            m69d.mView.setTag(string);
        }
        return m69d.mView;
    }

    @Override
    protected final void onDestroy() {
        super.onDestroy();
        m32b(false);
        this.f30w.m83y();
        if (this.mLoaderManager != null) {
            this.mLoaderManager.m95H();
        }
    }

    @Override
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 5 || i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        onBackPressed();
        return true;
    }

    @Override
    public final void onLowMemory() {
        super.onLowMemory();
        this.f30w.m84z();
    }

    @Override
    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        switch (i) {
            case 0:
                return this.f30w.m62a(menuItem);
            case C0217R.styleable.com_facebook_picker_fragment_done_button_background:
                return this.f30w.m66b(menuItem);
            default:
                return false;
        }
    }

    @Override
    public final void onPanelClosed(int i, Menu menu) {
        switch (i) {
            case 0:
                this.f30w.m65b(menu);
                break;
        }
        super.onPanelClosed(i, menu);
    }

    @Override
    protected final void onPause() {
        super.onPause();
        this.mResumed = false;
        if (this.mHandler.hasMessages(2)) {
            this.mHandler.removeMessages(2);
            this.f30w.dispatchResume();
        }
        this.f30w.m81w();
    }

    @Override
    protected final void onPostResume() {
        super.onPostResume();
        this.mHandler.removeMessages(2);
        this.f30w.dispatchResume();
        this.f30w.m74p();
    }

    @Override
    public final boolean onPreparePanel(int i, View view, Menu menu) {
        if (i != 0 || menu == null) {
            return super.onPreparePanel(i, view, menu);
        }
        if (this.f28A) {
            this.f28A = false;
            menu.clear();
            onCreatePanelMenu(i, menu);
        }
        return (super.onPreparePanel(i, view, menu) || this.f30w.m60a(menu)) && menu.hasVisibleItems();
    }

    @Override
    protected final void onResume() {
        super.onResume();
        this.mHandler.sendEmptyMessage(2);
        this.mResumed = true;
        this.f30w.m74p();
    }

    @Override
    public final Object onRetainNonConfigurationInstance() {
        boolean z;
        if (this.f32y) {
            m32b(true);
        }
        ArrayList<ComponentCallbacksC0006e> m75q = this.f30w.m75q();
        boolean z2 = false;
        if (this.f29B != null) {
            int size = this.f29B.size() - 1;
            while (size >= 0) {
                C0023v valueAt = this.f29B.valueAt(size);
                if (valueAt.mRetaining) {
                    z = true;
                } else {
                    valueAt.m95H();
                    this.f29B.removeAt(size);
                    z = z2;
                }
                size--;
                z2 = z;
            }
        }
        if (m75q == null && !z2) {
            return null;
        }
        C0012k c0012k = new C0012k();
        c0012k.f35D = m75q;
        c0012k.f36E = this.f29B;
        return c0012k;
    }

    @Override
    protected final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Parcelable m76r = this.f30w.m76r();
        if (m76r != null) {
            bundle.putParcelable("android:support:fragments", m76r);
        }
    }

    @Override
    protected final void onStart() {
        super.onStart();
        this.f32y = false;
        this.f33z = false;
        this.mHandler.removeMessages(1);
        if (!this.f31x) {
            this.f31x = true;
            this.f30w.m79u();
        }
        this.f30w.m77s();
        this.f30w.m74p();
        if (!this.mLoadersStarted) {
            this.mLoadersStarted = true;
            if (this.mLoaderManager != null) {
                this.mLoaderManager.m89B();
            } else if (!this.mCheckedForLoaderManager) {
                this.mLoaderManager = m34a(-1, this.mLoadersStarted, false);
            }
            this.mCheckedForLoaderManager = true;
        }
        this.f30w.m80v();
        if (this.f29B != null) {
            for (int size = this.f29B.size() - 1; size >= 0; size--) {
                C0023v valueAt = this.f29B.valueAt(size);
                valueAt.m92E();
                valueAt.m94G();
            }
        }
    }

    @Override
    protected final void onStop() {
        super.onStop();
        this.f32y = true;
        this.mHandler.sendEmptyMessage(1);
        this.f30w.dispatchStop();
    }

    @Override
    public final void startActivityForResult(Intent intent, int i) {
        if (i != -1 && ((-65536) & i) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
        super.startActivityForResult(intent, i);
    }
}
