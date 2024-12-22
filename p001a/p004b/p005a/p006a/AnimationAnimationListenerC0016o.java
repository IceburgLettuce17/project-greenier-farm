package p001a.p004b.p005a.p006a;

import android.view.animation.Animation;

final class AnimationAnimationListenerC0016o implements Animation.AnimationListener {

    private C0015n f56Y;
    private ComponentCallbacksC0006e val$fragment;

    AnimationAnimationListenerC0016o(C0015n c0015n, ComponentCallbacksC0006e componentCallbacksC0006e) {
        this.f56Y = c0015n;
        this.val$fragment = componentCallbacksC0006e;
    }

    @Override
    public final void onAnimationEnd(Animation animation) {
        if (this.val$fragment.mAnimatingAway != null) {
            this.val$fragment.mAnimatingAway = null;
            this.f56Y.m56a(this.val$fragment, this.val$fragment.mStateAfterAnimating, 0, 0, false);
        }
    }

    @Override
    public final void onAnimationRepeat(Animation animation) {
    }

    @Override
    public final void onAnimationStart(Animation animation) {
    }
}
