package p001a.p004b.p005a.p006a;

import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import com.facebook.android.C0217R;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import p001a.p004b.p005a.p008c.C0033a;

final class C0015n extends AbstractC0013l {
    static boolean DEBUG = false;

    private static boolean f37F;

    private static Interpolator f38W;

    private static Interpolator f39X;

    private boolean f40G;

    ArrayList<ComponentCallbacksC0006e> f41H;

    ArrayList<ComponentCallbacksC0006e> f42I;

    private ArrayList<Integer> f43J;

    private ArrayList<RunnableC0003b> f44K;

    private ArrayList<ComponentCallbacksC0006e> f45L;

    private ArrayList<RunnableC0003b> f46M;

    private ArrayList<Integer> f47N;

    int f48O;

    private boolean f49P;

    private boolean f50Q;

    private boolean f51R;

    String f52S;

    private boolean f53T;

    private Bundle f54U;

    private SparseArray<Parcelable> f55V;
    private ActivityC0010i mActivity;

    static {
        f37F = Build.VERSION.SDK_INT >= 11;
        f38W = new DecelerateInterpolator(2.5f);
        f39X = new DecelerateInterpolator(1.5f);
        new AccelerateInterpolator(2.5f);
        new AccelerateInterpolator(1.5f);
    }

    private static Animation m45a(float f, float f2) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setInterpolator(f39X);
        alphaAnimation.setDuration(220L);
        return alphaAnimation;
    }

    private static Animation m46a(float f, float f2, float f3, float f4) {
        AnimationSet animationSet = new AnimationSet(false);
        ScaleAnimation scaleAnimation = new ScaleAnimation(f, f2, f, f2, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(f38W);
        scaleAnimation.setDuration(220L);
        animationSet.addAnimation(scaleAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(f3, f4);
        alphaAnimation.setInterpolator(f39X);
        alphaAnimation.setDuration(220L);
        animationSet.addAnimation(alphaAnimation);
        return animationSet;
    }

    private Animation m47a(ComponentCallbacksC0006e componentCallbacksC0006e, int i, boolean z, int i2) {
        Animation loadAnimation;
        Animation onCreateAnimation = componentCallbacksC0006e.onCreateAnimation(i, z, componentCallbacksC0006e.mNextAnim);
        if (onCreateAnimation != null) {
            return onCreateAnimation;
        }
        if (componentCallbacksC0006e.mNextAnim != 0 && (loadAnimation = AnimationUtils.loadAnimation(this.mActivity, componentCallbacksC0006e.mNextAnim)) != null) {
            return loadAnimation;
        }
        if (i == 0) {
            return null;
        }
        char c = 65535;
        switch (i) {
            case 4097:
                if (!z) {
                    c = 2;
                    break;
                } else {
                    c = 1;
                    break;
                }
            case 4099:
                if (!z) {
                    c = 6;
                    break;
                } else {
                    c = 5;
                    break;
                }
            case 8194:
                if (!z) {
                    c = 4;
                    break;
                } else {
                    c = 3;
                    break;
                }
        }
        if (c < 0) {
            return null;
        }
        switch (c) {
            case 1:
                ActivityC0010i activityC0010i = this.mActivity;
                return m46a(1.125f, 1.0f, 0.0f, 1.0f);
            case 2:
                ActivityC0010i activityC0010i2 = this.mActivity;
                return m46a(1.0f, 0.975f, 1.0f, 0.0f);
            case 3:
                ActivityC0010i activityC0010i3 = this.mActivity;
                return m46a(0.975f, 1.0f, 0.0f, 1.0f);
            case C0217R.styleable.com_facebook_picker_fragment_done_button_text:
                ActivityC0010i activityC0010i4 = this.mActivity;
                return m46a(1.0f, 1.075f, 1.0f, 0.0f);
            case C0217R.styleable.com_facebook_picker_fragment_title_bar_background:
                ActivityC0010i activityC0010i5 = this.mActivity;
                return m45a(0.0f, 1.0f);
            case C0217R.styleable.com_facebook_picker_fragment_done_button_background:
                ActivityC0010i activityC0010i6 = this.mActivity;
                return m45a(1.0f, 0.0f);
            default:
                if (i2 == 0 && this.mActivity.getWindow() != null) {
                    i2 = this.mActivity.getWindow().getAttributes().windowAnimations;
                }
                return i2 == 0 ? null : null;
        }
    }

    private void m48a(int i, RunnableC0003b runnableC0003b) {
        synchronized (this) {
            if (this.f46M == null) {
                this.f46M = new ArrayList<>();
            }
            int size = this.f46M.size();
            if (i < size) {
                this.f46M.set(i, runnableC0003b);
            } else {
                while (size < i) {
                    this.f46M.add(null);
                    if (this.f47N == null) {
                        this.f47N = new ArrayList<>();
                    }
                    this.f47N.add(Integer.valueOf(size));
                    size++;
                }
                this.f46M.add(runnableC0003b);
            }
        }
    }

    private void m49a(int i, boolean z) {
        m52a(i, 0, 0, false);
    }

    private void m50c(ComponentCallbacksC0006e componentCallbacksC0006e) {
        if (componentCallbacksC0006e.mInnerView == null) {
            return;
        }
        if (this.f55V == null) {
            this.f55V = new SparseArray<>();
        } else {
            this.f55V.clear();
        }
        componentCallbacksC0006e.mInnerView.saveHierarchyState(this.f55V);
        if (this.f55V.size() > 0) {
            componentCallbacksC0006e.mSavedViewState = this.f55V;
            this.f55V = null;
        }
    }

    public static int m51f(int i) {
        switch (i) {
            case 4097:
                return 8194;
            case 4099:
                return 4099;
            case 8194:
                return 4097;
            default:
                return 0;
        }
    }

    final void m52a(int i, int i2, int i3, boolean z) {
        if (this.mActivity == null && i != 0) {
            throw new IllegalStateException("No activity");
        }
        if (z || this.f48O != i) {
            this.f48O = i;
            if (this.f41H != null) {
                int i4 = 0;
                boolean z2 = false;
                while (i4 < this.f41H.size()) {
                    ComponentCallbacksC0006e componentCallbacksC0006e = this.f41H.get(i4);
                    if (componentCallbacksC0006e != null) {
                        m56a(componentCallbacksC0006e, i, i2, i3, false);
                        if (componentCallbacksC0006e.mLoaderManager != null) {
                            z2 |= componentCallbacksC0006e.mLoaderManager.mo86A();
                        }
                    }
                    i4++;
                    z2 = z2;
                }
                if (!z2) {
                    m73o();
                }
                if (this.f49P && this.mActivity != null && this.f48O == 5) {
                    this.mActivity.m37k();
                    this.f49P = false;
                }
            }
        }
    }

    final void m53a(RunnableC0003b runnableC0003b) {
        if (this.f44K == null) {
            this.f44K = new ArrayList<>();
        }
        this.f44K.add(runnableC0003b);
    }

    public final void m54a(ComponentCallbacksC0006e componentCallbacksC0006e) {
        if (componentCallbacksC0006e.mDeferStart) {
            if (this.f40G) {
                this.f53T = true;
            } else {
                componentCallbacksC0006e.mDeferStart = false;
                m56a(componentCallbacksC0006e, this.f48O, 0, 0, false);
            }
        }
    }

    public final void m55a(ComponentCallbacksC0006e componentCallbacksC0006e, int i, int i2) {
        boolean z = !componentCallbacksC0006e.isInBackStack();
        if (!componentCallbacksC0006e.mDetached || z) {
            if (this.f42I != null) {
                this.f42I.remove(componentCallbacksC0006e);
            }
            if (componentCallbacksC0006e.mHasMenu && componentCallbacksC0006e.mMenuVisible) {
                this.f49P = true;
            }
            componentCallbacksC0006e.mAdded = false;
            componentCallbacksC0006e.mRemoving = true;
            m56a(componentCallbacksC0006e, z ? 0 : 1, i, i2, false);
        }
    }

    final void m56a(ComponentCallbacksC0006e componentCallbacksC0006e, int i, int i2, int i3, boolean z) {
        ViewGroup viewGroup;
        ComponentCallbacksC0006e componentCallbacksC0006e2;
        if (!componentCallbacksC0006e.mAdded && i > 1) {
            i = 1;
        }
        if (componentCallbacksC0006e.mRemoving && i > componentCallbacksC0006e.mState) {
            i = componentCallbacksC0006e.mState;
        }
        if (componentCallbacksC0006e.mDeferStart && componentCallbacksC0006e.mState < 4 && i > 3) {
            i = 3;
        }
        if (componentCallbacksC0006e.mState >= i) {
            if (componentCallbacksC0006e.mState > i) {
                switch (componentCallbacksC0006e.mState) {
                    case 1:
                        if (i <= 0) {
                            if (this.f51R && componentCallbacksC0006e.mAnimatingAway != null) {
                                View view = componentCallbacksC0006e.mAnimatingAway;
                                componentCallbacksC0006e.mAnimatingAway = null;
                                view.clearAnimation();
                            }
                            if (componentCallbacksC0006e.mAnimatingAway != null) {
                                componentCallbacksC0006e.mStateAfterAnimating = i;
                                i = 1;
                            } else {
                                if (!componentCallbacksC0006e.mRetaining) {
                                    componentCallbacksC0006e.mCalled = false;
                                    componentCallbacksC0006e.onDestroy();
                                    if (!componentCallbacksC0006e.mCalled) {
                                        throw new C0026y("Fragment " + componentCallbacksC0006e + " did not call through to super.onDestroy()");
                                    }
                                }
                                componentCallbacksC0006e.mCalled = false;
                                componentCallbacksC0006e.onDetach();
                                if (!componentCallbacksC0006e.mCalled) {
                                    throw new C0026y("Fragment " + componentCallbacksC0006e + " did not call through to super.onDetach()");
                                }
                                if (!z) {
                                    if (componentCallbacksC0006e.mRetaining) {
                                        componentCallbacksC0006e.mActivity = null;
                                        componentCallbacksC0006e.mFragmentManager = null;
                                    } else if (componentCallbacksC0006e.mIndex >= 0) {
                                        this.f41H.set(componentCallbacksC0006e.mIndex, null);
                                        if (this.f43J == null) {
                                            this.f43J = new ArrayList<>();
                                        }
                                        this.f43J.add(Integer.valueOf(componentCallbacksC0006e.mIndex));
                                        this.mActivity.m36c(componentCallbacksC0006e.mIndex);
                                        componentCallbacksC0006e.initState();
                                    }
                                }
                            }
                        }
                        break;
                    case 2:
                        if (i < 2) {
                            if (componentCallbacksC0006e.mView != null && !this.mActivity.isFinishing() && componentCallbacksC0006e.mSavedViewState == null) {
                                m50c(componentCallbacksC0006e);
                            }
                            componentCallbacksC0006e.mCalled = false;
                            componentCallbacksC0006e.performDestroyView();
                            if (!componentCallbacksC0006e.mCalled) {
                                throw new C0026y("Fragment " + componentCallbacksC0006e + " did not call through to super.onDestroyView()");
                            }
                            if (componentCallbacksC0006e.mView != null && componentCallbacksC0006e.mContainer != null) {
                                Animation m47a = (this.f48O <= 0 || this.f51R) ? null : m47a(componentCallbacksC0006e, i2, false, i3);
                                if (m47a != null) {
                                    componentCallbacksC0006e.mAnimatingAway = componentCallbacksC0006e.mView;
                                    componentCallbacksC0006e.mStateAfterAnimating = i;
                                    m47a.setAnimationListener(new AnimationAnimationListenerC0016o(this, componentCallbacksC0006e));
                                    componentCallbacksC0006e.mView.startAnimation(m47a);
                                }
                                componentCallbacksC0006e.mContainer.removeView(componentCallbacksC0006e.mView);
                            }
                            componentCallbacksC0006e.mContainer = null;
                            componentCallbacksC0006e.mView = null;
                            componentCallbacksC0006e.mInnerView = null;
                        }
                        if (i <= 0) {
                        }
                        break;
                    case 3:
                        if (i < 3) {
                            componentCallbacksC0006e.performReallyStop();
                        }
                        if (i < 2) {
                        }
                        if (i <= 0) {
                        }
                        break;
                    case C0217R.styleable.com_facebook_picker_fragment_done_button_text:
                        if (i < 4) {
                            componentCallbacksC0006e.mCalled = false;
                            componentCallbacksC0006e.performStop();
                            if (!componentCallbacksC0006e.mCalled) {
                                throw new C0026y("Fragment " + componentCallbacksC0006e + " did not call through to super.onStop()");
                            }
                        }
                        if (i < 3) {
                        }
                        if (i < 2) {
                        }
                        if (i <= 0) {
                        }
                        break;
                    case C0217R.styleable.com_facebook_picker_fragment_title_bar_background:
                        if (i < 5) {
                            componentCallbacksC0006e.mCalled = false;
                            componentCallbacksC0006e.onPause();
                            if (!componentCallbacksC0006e.mCalled) {
                                throw new C0026y("Fragment " + componentCallbacksC0006e + " did not call through to super.onPause()");
                            }
                            componentCallbacksC0006e.mResumed = false;
                        }
                        if (i < 4) {
                        }
                        if (i < 3) {
                        }
                        if (i < 2) {
                        }
                        if (i <= 0) {
                        }
                        break;
                }
            }
        } else {
            if (componentCallbacksC0006e.mFromLayout && !componentCallbacksC0006e.mInLayout) {
                return;
            }
            if (componentCallbacksC0006e.mAnimatingAway != null) {
                componentCallbacksC0006e.mAnimatingAway = null;
                m56a(componentCallbacksC0006e, componentCallbacksC0006e.mStateAfterAnimating, 0, 0, true);
            }
            switch (componentCallbacksC0006e.mState) {
                case 0:
                    if (componentCallbacksC0006e.mSavedFragmentState != null) {
                        componentCallbacksC0006e.mSavedViewState = componentCallbacksC0006e.mSavedFragmentState.getSparseParcelableArray("android:view_state");
                        int i4 = componentCallbacksC0006e.mSavedFragmentState.getInt("android:target_state", -1);
                        if (i4 == -1) {
                            componentCallbacksC0006e2 = null;
                        } else {
                            if (i4 >= this.f41H.size()) {
                                throw new IllegalStateException("Fragement no longer exists for key android:target_state: index " + i4);
                            }
                            componentCallbacksC0006e2 = this.f41H.get(i4);
                            if (componentCallbacksC0006e2 == null) {
                                throw new IllegalStateException("Fragement no longer exists for key android:target_state: index " + i4);
                            }
                        }
                        componentCallbacksC0006e.mTarget = componentCallbacksC0006e2;
                        if (componentCallbacksC0006e.mTarget != null) {
                            componentCallbacksC0006e.mTargetRequestCode = componentCallbacksC0006e.mSavedFragmentState.getInt("android:target_req_state", 0);
                        }
                        componentCallbacksC0006e.mUserVisibleHint = componentCallbacksC0006e.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
                        if (!componentCallbacksC0006e.mUserVisibleHint) {
                            componentCallbacksC0006e.mDeferStart = true;
                            if (i > 3) {
                                i = 3;
                            }
                        }
                    }
                    componentCallbacksC0006e.mActivity = this.mActivity;
                    componentCallbacksC0006e.mFragmentManager = this.mActivity.f30w;
                    componentCallbacksC0006e.mCalled = false;
                    componentCallbacksC0006e.onAttach(this.mActivity);
                    if (!componentCallbacksC0006e.mCalled) {
                        throw new C0026y("Fragment " + componentCallbacksC0006e + " did not call through to super.onAttach()");
                    }
                    ActivityC0010i activityC0010i = this.mActivity;
                    ActivityC0010i.m33l();
                    if (!componentCallbacksC0006e.mRetaining) {
                        componentCallbacksC0006e.mCalled = false;
                        componentCallbacksC0006e.onCreate(componentCallbacksC0006e.mSavedFragmentState);
                        if (!componentCallbacksC0006e.mCalled) {
                            throw new C0026y("Fragment " + componentCallbacksC0006e + " did not call through to super.onCreate()");
                        }
                    }
                    componentCallbacksC0006e.mRetaining = false;
                    if (componentCallbacksC0006e.mFromLayout) {
                        componentCallbacksC0006e.mView = componentCallbacksC0006e.onCreateView(componentCallbacksC0006e.getLayoutInflater(componentCallbacksC0006e.mSavedFragmentState), null, componentCallbacksC0006e.mSavedFragmentState);
                        if (componentCallbacksC0006e.mView != null) {
                            componentCallbacksC0006e.mInnerView = componentCallbacksC0006e.mView;
                            componentCallbacksC0006e.mView = C0025x.m99a(componentCallbacksC0006e.mView);
                            if (componentCallbacksC0006e.mHidden) {
                                componentCallbacksC0006e.mView.setVisibility(8);
                            }
                            componentCallbacksC0006e.onViewCreated(componentCallbacksC0006e.mView, componentCallbacksC0006e.mSavedFragmentState);
                        } else {
                            componentCallbacksC0006e.mInnerView = null;
                        }
                    }
                case 1:
                    if (i > 1) {
                        if (!componentCallbacksC0006e.mFromLayout) {
                            if (componentCallbacksC0006e.mContainerId != 0) {
                                viewGroup = (ViewGroup) this.mActivity.findViewById(componentCallbacksC0006e.mContainerId);
                                if (viewGroup == null && !componentCallbacksC0006e.mRestored) {
                                    throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(componentCallbacksC0006e.mContainerId) + " for fragment " + componentCallbacksC0006e);
                                }
                            } else {
                                viewGroup = null;
                            }
                            componentCallbacksC0006e.mContainer = viewGroup;
                            componentCallbacksC0006e.mView = componentCallbacksC0006e.onCreateView(componentCallbacksC0006e.getLayoutInflater(componentCallbacksC0006e.mSavedFragmentState), viewGroup, componentCallbacksC0006e.mSavedFragmentState);
                            if (componentCallbacksC0006e.mView != null) {
                                componentCallbacksC0006e.mInnerView = componentCallbacksC0006e.mView;
                                componentCallbacksC0006e.mView = C0025x.m99a(componentCallbacksC0006e.mView);
                                if (viewGroup != null) {
                                    Animation m47a2 = m47a(componentCallbacksC0006e, i2, true, i3);
                                    if (m47a2 != null) {
                                        componentCallbacksC0006e.mView.startAnimation(m47a2);
                                    }
                                    viewGroup.addView(componentCallbacksC0006e.mView);
                                }
                                if (componentCallbacksC0006e.mHidden) {
                                    componentCallbacksC0006e.mView.setVisibility(8);
                                }
                                componentCallbacksC0006e.onViewCreated(componentCallbacksC0006e.mView, componentCallbacksC0006e.mSavedFragmentState);
                            } else {
                                componentCallbacksC0006e.mInnerView = null;
                            }
                        }
                        componentCallbacksC0006e.mCalled = false;
                        componentCallbacksC0006e.onActivityCreated(componentCallbacksC0006e.mSavedFragmentState);
                        if (!componentCallbacksC0006e.mCalled) {
                            throw new C0026y("Fragment " + componentCallbacksC0006e + " did not call through to super.onActivityCreated()");
                        }
                        if (componentCallbacksC0006e.mView != null) {
                            componentCallbacksC0006e.restoreViewState();
                        }
                        componentCallbacksC0006e.mSavedFragmentState = null;
                    }
                    break;
                case 2:
                case 3:
                    if (i > 3) {
                        componentCallbacksC0006e.mCalled = false;
                        componentCallbacksC0006e.performStart();
                        if (!componentCallbacksC0006e.mCalled) {
                            throw new C0026y("Fragment " + componentCallbacksC0006e + " did not call through to super.onStart()");
                        }
                    }
                case C0217R.styleable.com_facebook_picker_fragment_done_button_text:
                    if (i > 4) {
                        componentCallbacksC0006e.mCalled = false;
                        componentCallbacksC0006e.mResumed = true;
                        componentCallbacksC0006e.onResume();
                        if (!componentCallbacksC0006e.mCalled) {
                            throw new C0026y("Fragment " + componentCallbacksC0006e + " did not call through to super.onResume()");
                        }
                        componentCallbacksC0006e.mSavedFragmentState = null;
                        componentCallbacksC0006e.mSavedViewState = null;
                    }
                default:
                    componentCallbacksC0006e.mState = i;
            }
        }
        componentCallbacksC0006e.mState = i;
    }

    public final void m57a(ComponentCallbacksC0006e componentCallbacksC0006e, boolean z) {
        if (this.f42I == null) {
            this.f42I = new ArrayList<>();
        }
        if (componentCallbacksC0006e.mIndex < 0) {
            if (this.f43J == null || this.f43J.size() <= 0) {
                if (this.f41H == null) {
                    this.f41H = new ArrayList<>();
                }
                componentCallbacksC0006e.setIndex(this.f41H.size());
                this.f41H.add(componentCallbacksC0006e);
            } else {
                componentCallbacksC0006e.setIndex(this.f43J.remove(this.f43J.size() - 1).intValue());
                this.f41H.set(componentCallbacksC0006e.mIndex, componentCallbacksC0006e);
            }
        }
        if (componentCallbacksC0006e.mDetached) {
            return;
        }
        this.f42I.add(componentCallbacksC0006e);
        componentCallbacksC0006e.mAdded = true;
        componentCallbacksC0006e.mRemoving = false;
        if (componentCallbacksC0006e.mHasMenu && componentCallbacksC0006e.mMenuVisible) {
            this.f49P = true;
        }
        if (z) {
            m63b(componentCallbacksC0006e);
        }
    }

    public final void m58a(ActivityC0010i activityC0010i) {
        if (this.mActivity != null) {
            throw new IllegalStateException();
        }
        this.mActivity = activityC0010i;
    }

    final void m59a(Parcelable parcelable, ArrayList<ComponentCallbacksC0006e> arrayList) {
        if (parcelable == null) {
            return;
        }
        C0017p c0017p = (C0017p) parcelable;
        if (c0017p.f57Z != null) {
            if (arrayList != null) {
                for (int i = 0; i < arrayList.size(); i++) {
                    ComponentCallbacksC0006e componentCallbacksC0006e = arrayList.get(i);
                    C0019r c0019r = c0017p.f57Z[componentCallbacksC0006e.mIndex];
                    c0019r.f61ad = componentCallbacksC0006e;
                    componentCallbacksC0006e.mSavedViewState = null;
                    componentCallbacksC0006e.mBackStackNesting = 0;
                    componentCallbacksC0006e.mInLayout = false;
                    componentCallbacksC0006e.mAdded = false;
                    componentCallbacksC0006e.mTarget = null;
                    if (c0019r.mSavedFragmentState != null) {
                        c0019r.mSavedFragmentState.setClassLoader(this.mActivity.getClassLoader());
                        componentCallbacksC0006e.mSavedViewState = c0019r.mSavedFragmentState.getSparseParcelableArray("android:view_state");
                    }
                }
            }
            this.f41H = new ArrayList<>(c0017p.f57Z.length);
            if (this.f43J != null) {
                this.f43J.clear();
            }
            for (int i2 = 0; i2 < c0017p.f57Z.length; i2++) {
                C0019r c0019r2 = c0017p.f57Z[i2];
                if (c0019r2 != null) {
                    this.f41H.add(c0019r2.m85b(this.mActivity));
                    c0019r2.f61ad = null;
                } else {
                    this.f41H.add(null);
                    if (this.f43J == null) {
                        this.f43J = new ArrayList<>();
                    }
                    this.f43J.add(Integer.valueOf(i2));
                }
            }
            if (arrayList != null) {
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    ComponentCallbacksC0006e componentCallbacksC0006e2 = arrayList.get(i3);
                    if (componentCallbacksC0006e2.mTargetIndex >= 0) {
                        if (componentCallbacksC0006e2.mTargetIndex < this.f41H.size()) {
                            componentCallbacksC0006e2.mTarget = this.f41H.get(componentCallbacksC0006e2.mTargetIndex);
                        } else {
                            Log.w("FragmentManager", "Re-attaching retained fragment " + componentCallbacksC0006e2 + " target no longer exists: " + componentCallbacksC0006e2.mTargetIndex);
                            componentCallbacksC0006e2.mTarget = null;
                        }
                    }
                }
            }
            if (c0017p.f58aa != null) {
                this.f42I = new ArrayList<>(c0017p.f58aa.length);
                for (int i4 = 0; i4 < c0017p.f58aa.length; i4++) {
                    ComponentCallbacksC0006e componentCallbacksC0006e3 = this.f41H.get(c0017p.f58aa[i4]);
                    if (componentCallbacksC0006e3 == null) {
                        throw new IllegalStateException("No instantiated fragment for index #" + c0017p.f58aa[i4]);
                    }
                    componentCallbacksC0006e3.mAdded = true;
                    this.f42I.add(componentCallbacksC0006e3);
                }
            } else {
                this.f42I = null;
            }
            if (c0017p.f59ab == null) {
                this.f44K = null;
                return;
            }
            this.f44K = new ArrayList<>(c0017p.f59ab.length);
            for (int i5 = 0; i5 < c0017p.f59ab.length; i5++) {
                RunnableC0003b m31a = c0017p.f59ab[i5].m31a(this);
                this.f44K.add(m31a);
                if (m31a.mIndex >= 0) {
                    m48a(m31a.mIndex, m31a);
                }
            }
        }
    }

    public final boolean m60a(Menu menu) {
        if (this.f42I == null) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < this.f42I.size(); i++) {
            ComponentCallbacksC0006e componentCallbacksC0006e = this.f42I.get(i);
            if (componentCallbacksC0006e != null && !componentCallbacksC0006e.mHidden && componentCallbacksC0006e.mHasMenu && componentCallbacksC0006e.mMenuVisible) {
                z = true;
                componentCallbacksC0006e.onPrepareOptionsMenu(menu);
            }
        }
        return z;
    }

    public final boolean m61a(Menu menu, MenuInflater menuInflater) {
        boolean z;
        ArrayList<ComponentCallbacksC0006e> arrayList = null;
        if (this.f42I != null) {
            int i = 0;
            z = false;
            while (i < this.f42I.size()) {
                ComponentCallbacksC0006e componentCallbacksC0006e = this.f42I.get(i);
                if (componentCallbacksC0006e != null && !componentCallbacksC0006e.mHidden && componentCallbacksC0006e.mHasMenu && componentCallbacksC0006e.mMenuVisible) {
                    z = true;
                    componentCallbacksC0006e.onCreateOptionsMenu(menu, menuInflater);
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                    }
                    arrayList.add(componentCallbacksC0006e);
                }
                i++;
                z = z;
            }
        } else {
            z = false;
        }
        if (this.f45L != null) {
            for (int i2 = 0; i2 < this.f45L.size(); i2++) {
                ComponentCallbacksC0006e componentCallbacksC0006e2 = this.f45L.get(i2);
                if (arrayList == null || !arrayList.contains(componentCallbacksC0006e2)) {
                    componentCallbacksC0006e2.onDestroyOptionsMenu();
                }
            }
        }
        this.f45L = arrayList;
        return z;
    }

    public final boolean m62a(MenuItem menuItem) {
        if (this.f42I == null) {
            return false;
        }
        for (int i = 0; i < this.f42I.size(); i++) {
            ComponentCallbacksC0006e componentCallbacksC0006e = this.f42I.get(i);
            if (componentCallbacksC0006e != null && !componentCallbacksC0006e.mHidden && componentCallbacksC0006e.mHasMenu && componentCallbacksC0006e.mMenuVisible && componentCallbacksC0006e.onOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    final void m63b(ComponentCallbacksC0006e componentCallbacksC0006e) {
        m56a(componentCallbacksC0006e, this.f48O, 0, 0, false);
    }

    public final void m64b(ComponentCallbacksC0006e componentCallbacksC0006e, int i, int i2) {
        if (componentCallbacksC0006e.mHidden) {
            return;
        }
        componentCallbacksC0006e.mHidden = true;
        if (componentCallbacksC0006e.mView != null) {
            Animation m47a = m47a(componentCallbacksC0006e, i, true, i2);
            if (m47a != null) {
                componentCallbacksC0006e.mView.startAnimation(m47a);
            }
            componentCallbacksC0006e.mView.setVisibility(8);
        }
        if (componentCallbacksC0006e.mAdded && componentCallbacksC0006e.mHasMenu && componentCallbacksC0006e.mMenuVisible) {
            this.f49P = true;
        }
        componentCallbacksC0006e.onHiddenChanged(true);
    }

    public final void m65b(Menu menu) {
        if (this.f42I == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f42I.size()) {
                return;
            }
            ComponentCallbacksC0006e componentCallbacksC0006e = this.f42I.get(i2);
            if (componentCallbacksC0006e != null && !componentCallbacksC0006e.mHidden && componentCallbacksC0006e.mHasMenu && componentCallbacksC0006e.mMenuVisible) {
                componentCallbacksC0006e.onOptionsMenuClosed(menu);
            }
            i = i2 + 1;
        }
    }

    public final boolean m66b(MenuItem menuItem) {
        if (this.f42I == null) {
            return false;
        }
        for (int i = 0; i < this.f42I.size(); i++) {
            ComponentCallbacksC0006e componentCallbacksC0006e = this.f42I.get(i);
            if (componentCallbacksC0006e != null && !componentCallbacksC0006e.mHidden && componentCallbacksC0006e.mUserVisibleHint && componentCallbacksC0006e.onContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final ComponentCallbacksC0006e m67c(String str) {
        if (this.f42I != null && str != null) {
            for (int size = this.f42I.size() - 1; size >= 0; size--) {
                ComponentCallbacksC0006e componentCallbacksC0006e = this.f42I.get(size);
                if (componentCallbacksC0006e != null && str.equals(componentCallbacksC0006e.mTag)) {
                    return componentCallbacksC0006e;
                }
            }
        }
        if (this.f41H != null && str != null) {
            for (int size2 = this.f41H.size() - 1; size2 >= 0; size2--) {
                ComponentCallbacksC0006e componentCallbacksC0006e2 = this.f41H.get(size2);
                if (componentCallbacksC0006e2 != null && str.equals(componentCallbacksC0006e2.mTag)) {
                    return componentCallbacksC0006e2;
                }
            }
        }
        return null;
    }

    public final void m68c(ComponentCallbacksC0006e componentCallbacksC0006e, int i, int i2) {
        if (componentCallbacksC0006e.mHidden) {
            componentCallbacksC0006e.mHidden = false;
            if (componentCallbacksC0006e.mView != null) {
                Animation m47a = m47a(componentCallbacksC0006e, i, true, i2);
                if (m47a != null) {
                    componentCallbacksC0006e.mView.startAnimation(m47a);
                }
                componentCallbacksC0006e.mView.setVisibility(0);
            }
            if (componentCallbacksC0006e.mAdded && componentCallbacksC0006e.mHasMenu && componentCallbacksC0006e.mMenuVisible) {
                this.f49P = true;
            }
            componentCallbacksC0006e.onHiddenChanged(false);
        }
    }

    public final ComponentCallbacksC0006e m69d(int i) {
        if (this.f42I != null) {
            for (int size = this.f42I.size() - 1; size >= 0; size--) {
                ComponentCallbacksC0006e componentCallbacksC0006e = this.f42I.get(size);
                if (componentCallbacksC0006e != null && componentCallbacksC0006e.mFragmentId == i) {
                    return componentCallbacksC0006e;
                }
            }
        }
        if (this.f41H != null) {
            for (int size2 = this.f41H.size() - 1; size2 >= 0; size2--) {
                ComponentCallbacksC0006e componentCallbacksC0006e2 = this.f41H.get(size2);
                if (componentCallbacksC0006e2 != null && componentCallbacksC0006e2.mFragmentId == i) {
                    return componentCallbacksC0006e2;
                }
            }
        }
        return null;
    }

    public final void m70d(ComponentCallbacksC0006e componentCallbacksC0006e, int i, int i2) {
        if (componentCallbacksC0006e.mDetached) {
            return;
        }
        componentCallbacksC0006e.mDetached = true;
        if (componentCallbacksC0006e.mAdded) {
            if (this.f42I != null) {
                this.f42I.remove(componentCallbacksC0006e);
            }
            if (componentCallbacksC0006e.mHasMenu && componentCallbacksC0006e.mMenuVisible) {
                this.f49P = true;
            }
            componentCallbacksC0006e.mAdded = false;
            m56a(componentCallbacksC0006e, 1, i, i2, false);
        }
    }

    public final void dispatchConfigurationChanged(Configuration configuration) {
        if (this.f42I == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f42I.size()) {
                return;
            }
            ComponentCallbacksC0006e componentCallbacksC0006e = this.f42I.get(i2);
            if (componentCallbacksC0006e != null) {
                componentCallbacksC0006e.onConfigurationChanged(configuration);
            }
            i = i2 + 1;
        }
    }

    public final void dispatchResume() {
        this.f50Q = false;
        m49a(5, false);
    }

    public final void dispatchStop() {
        this.f50Q = true;
        m49a(3, false);
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        int size3;
        int size4;
        int size5;
        String str2 = str + "    ";
        if (this.f41H != null && (size5 = this.f41H.size()) > 0) {
            printWriter.print(str);
            printWriter.print("Active Fragments in ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(":");
            for (int i = 0; i < size5; i++) {
                ComponentCallbacksC0006e componentCallbacksC0006e = this.f41H.get(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(componentCallbacksC0006e);
                if (componentCallbacksC0006e != null) {
                    componentCallbacksC0006e.dump(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        if (this.f42I != null && (size4 = this.f42I.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i2 = 0; i2 < size4; i2++) {
                ComponentCallbacksC0006e componentCallbacksC0006e2 = this.f42I.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(componentCallbacksC0006e2.toString());
            }
        }
        if (this.f45L != null && (size3 = this.f45L.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i3 = 0; i3 < size3; i3++) {
                ComponentCallbacksC0006e componentCallbacksC0006e3 = this.f45L.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(componentCallbacksC0006e3.toString());
            }
        }
        if (this.f44K != null && (size2 = this.f44K.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i4 = 0; i4 < size2; i4++) {
                RunnableC0003b runnableC0003b = this.f44K.get(i4);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i4);
                printWriter.print(": ");
                printWriter.println(runnableC0003b.toString());
                runnableC0003b.m28a(str2, printWriter);
            }
        }
        synchronized (this) {
            if (this.f46M != null && (size = this.f46M.size()) > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack Indices:");
                for (int i5 = 0; i5 < size; i5++) {
                    Object obj = (RunnableC0003b) this.f46M.get(i5);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i5);
                    printWriter.print(": ");
                    printWriter.println(obj);
                }
            }
            if (this.f47N != null && this.f47N.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.f47N.toArray()));
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f48O);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.f50Q);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f51R);
        if (this.f49P) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f49P);
        }
        if (this.f52S != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.f52S);
        }
        if (this.f43J == null || this.f43J.size() <= 0) {
            return;
        }
        printWriter.print(str);
        printWriter.print("  mAvailIndices: ");
        printWriter.println(Arrays.toString(this.f43J.toArray()));
    }

    public final void m71e(int i) {
        synchronized (this) {
            this.f46M.set(i, null);
            if (this.f47N == null) {
                this.f47N = new ArrayList<>();
            }
            this.f47N.add(Integer.valueOf(i));
        }
    }

    public final void m72e(ComponentCallbacksC0006e componentCallbacksC0006e, int i, int i2) {
        if (componentCallbacksC0006e.mDetached) {
            componentCallbacksC0006e.mDetached = false;
            if (componentCallbacksC0006e.mAdded) {
                return;
            }
            if (this.f42I == null) {
                this.f42I = new ArrayList<>();
            }
            this.f42I.add(componentCallbacksC0006e);
            componentCallbacksC0006e.mAdded = true;
            if (componentCallbacksC0006e.mHasMenu && componentCallbacksC0006e.mMenuVisible) {
                this.f49P = true;
            }
            m56a(componentCallbacksC0006e, this.f48O, i, i2, false);
        }
    }

    final void m73o() {
        if (this.f41H == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f41H.size()) {
                return;
            }
            ComponentCallbacksC0006e componentCallbacksC0006e = this.f41H.get(i2);
            if (componentCallbacksC0006e != null) {
                m54a(componentCallbacksC0006e);
            }
            i = i2 + 1;
        }
    }

    public final boolean m74p() {
        if (this.f40G) {
            throw new IllegalStateException("Recursive entry to executePendingTransactions");
        }
        if (Looper.myLooper() != this.mActivity.mHandler.getLooper()) {
            throw new IllegalStateException("Must be called from main thread of process");
        }
        synchronized (this) {
        }
        if (this.f53T) {
            boolean z = false;
            for (int i = 0; i < this.f41H.size(); i++) {
                ComponentCallbacksC0006e componentCallbacksC0006e = this.f41H.get(i);
                if (componentCallbacksC0006e != null && componentCallbacksC0006e.mLoaderManager != null) {
                    z |= componentCallbacksC0006e.mLoaderManager.mo86A();
                }
            }
            if (!z) {
                this.f53T = false;
                m73o();
            }
        }
        return false;
    }

    public final boolean popBackStackImmediate() {
        int size;
        if (this.f50Q) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        if (this.f52S != null) {
            throw new IllegalStateException("Can not perform this action inside of " + this.f52S);
        }
        m74p();
        Handler handler = this.mActivity.mHandler;
        if (this.f44K == null || this.f44K.size() - 1 < 0) {
            return false;
        }
        this.f44K.remove(size).m29a(true);
        return true;
    }

    final ArrayList<ComponentCallbacksC0006e> m75q() {
        ArrayList<ComponentCallbacksC0006e> arrayList = null;
        if (this.f41H != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.f41H.size()) {
                    break;
                }
                ComponentCallbacksC0006e componentCallbacksC0006e = this.f41H.get(i2);
                if (componentCallbacksC0006e != null && componentCallbacksC0006e.mRetainInstance) {
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                    }
                    arrayList.add(componentCallbacksC0006e);
                    componentCallbacksC0006e.mRetaining = true;
                    componentCallbacksC0006e.mTargetIndex = componentCallbacksC0006e.mTarget != null ? componentCallbacksC0006e.mTarget.mIndex : -1;
                }
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    final Parcelable m76r() {
        int[] iArr;
        int size;
        int size2;
        boolean z;
        Bundle bundle;
        C0004c[] c0004cArr = null;
        m74p();
        if (f37F) {
            this.f50Q = true;
        }
        if (this.f41H == null || this.f41H.size() <= 0) {
            return null;
        }
        int size3 = this.f41H.size();
        C0019r[] c0019rArr = new C0019r[size3];
        int i = 0;
        boolean z2 = false;
        while (i < size3) {
            ComponentCallbacksC0006e componentCallbacksC0006e = this.f41H.get(i);
            if (componentCallbacksC0006e == null) {
                z = z2;
            } else {
                if (componentCallbacksC0006e.mIndex < 0) {
                    String str = "Failure saving state: active " + componentCallbacksC0006e + " has cleared index: " + componentCallbacksC0006e.mIndex;
                    Log.e("FragmentManager", str);
                    dump("  ", null, new PrintWriter(new C0033a("FragmentManager")), new String[0]);
                    throw new IllegalStateException(str);
                }
                C0019r c0019r = new C0019r(componentCallbacksC0006e);
                c0019rArr[i] = c0019r;
                if (componentCallbacksC0006e.mState <= 0 || c0019r.mSavedFragmentState != null) {
                    c0019r.mSavedFragmentState = componentCallbacksC0006e.mSavedFragmentState;
                } else {
                    if (this.f54U == null) {
                        this.f54U = new Bundle();
                    }
                    componentCallbacksC0006e.onSaveInstanceState(this.f54U);
                    if (this.f54U.isEmpty()) {
                        bundle = null;
                    } else {
                        bundle = this.f54U;
                        this.f54U = null;
                    }
                    if (componentCallbacksC0006e.mView != null) {
                        m50c(componentCallbacksC0006e);
                    }
                    if (componentCallbacksC0006e.mSavedViewState != null) {
                        if (bundle == null) {
                            bundle = new Bundle();
                        }
                        bundle.putSparseParcelableArray("android:view_state", componentCallbacksC0006e.mSavedViewState);
                    }
                    if (!componentCallbacksC0006e.mUserVisibleHint) {
                        if (bundle == null) {
                            bundle = new Bundle();
                        }
                        bundle.putBoolean("android:user_visible_hint", componentCallbacksC0006e.mUserVisibleHint);
                    }
                    c0019r.mSavedFragmentState = bundle;
                    if (componentCallbacksC0006e.mTarget != null) {
                        if (componentCallbacksC0006e.mTarget.mIndex < 0) {
                            String str2 = "Failure saving state: " + componentCallbacksC0006e + " has target not in fragment manager: " + componentCallbacksC0006e.mTarget;
                            Log.e("FragmentManager", str2);
                            dump("  ", null, new PrintWriter(new C0033a("FragmentManager")), new String[0]);
                            throw new IllegalStateException(str2);
                        }
                        if (c0019r.mSavedFragmentState == null) {
                            c0019r.mSavedFragmentState = new Bundle();
                        }
                        Bundle bundle2 = c0019r.mSavedFragmentState;
                        ComponentCallbacksC0006e componentCallbacksC0006e2 = componentCallbacksC0006e.mTarget;
                        if (componentCallbacksC0006e2.mIndex < 0) {
                            throw new IllegalStateException("Fragment " + componentCallbacksC0006e2 + " is not currently in the FragmentManager");
                        }
                        bundle2.putInt("android:target_state", componentCallbacksC0006e2.mIndex);
                        if (componentCallbacksC0006e.mTargetRequestCode != 0) {
                            c0019r.mSavedFragmentState.putInt("android:target_req_state", componentCallbacksC0006e.mTargetRequestCode);
                            z = true;
                        }
                    }
                }
                z = true;
            }
            i++;
            z2 = z;
        }
        if (!z2) {
            return null;
        }
        if (this.f42I == null || (size2 = this.f42I.size()) <= 0) {
            iArr = null;
        } else {
            iArr = new int[size2];
            for (int i2 = 0; i2 < size2; i2++) {
                iArr[i2] = this.f42I.get(i2).mIndex;
                if (iArr[i2] < 0) {
                    String str3 = "Failure saving state: active " + this.f42I.get(i2) + " has cleared index: " + iArr[i2];
                    Log.e("FragmentManager", str3);
                    dump("  ", null, new PrintWriter(new C0033a("FragmentManager")), new String[0]);
                    throw new IllegalStateException(str3);
                }
            }
        }
        if (this.f44K != null && (size = this.f44K.size()) > 0) {
            c0004cArr = new C0004c[size];
            for (int i3 = 0; i3 < size; i3++) {
                c0004cArr[i3] = new C0004c(this.f44K.get(i3));
            }
        }
        C0017p c0017p = new C0017p();
        c0017p.f57Z = c0019rArr;
        c0017p.f58aa = iArr;
        c0017p.f59ab = c0004cArr;
        return c0017p;
    }

    public final void m77s() {
        this.f50Q = false;
    }

    public final void m78t() {
        this.f50Q = false;
        m49a(1, false);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        C0002a.m7a(this.mActivity, sb);
        sb.append("}}");
        return sb.toString();
    }

    public final void m79u() {
        this.f50Q = false;
        m49a(2, false);
    }

    public final void m80v() {
        this.f50Q = false;
        m49a(4, false);
    }

    public final void m81w() {
        m49a(4, false);
    }

    public final void m82x() {
        m49a(2, false);
    }

    public final void m83y() {
        this.f51R = true;
        m74p();
        m49a(0, false);
        this.mActivity = null;
    }

    public final void m84z() {
        if (this.f42I == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f42I.size()) {
                return;
            }
            ComponentCallbacksC0006e componentCallbacksC0006e = this.f42I.get(i2);
            if (componentCallbacksC0006e != null) {
                componentCallbacksC0006e.onLowMemory();
            }
            i = i2 + 1;
        }
    }
}
