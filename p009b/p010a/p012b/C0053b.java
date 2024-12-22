package p009b.p010a.p012b;

import android.content.Context;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.gameloft.android.wrapper.C0351e;

public final class C0053b extends SurfaceHolderCallbackC0069r implements InterfaceC0049ad {
    private C0046aa aio;

    public C0053b(Context context, C0046aa c0046aa) {
        super(context);
        this.aio = c0046aa;
        C0046aa c0046aa2 = this.aio;
        if (this.ajm != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
        if (this.ajn == null) {
            this.ajn = new C0047ab(this, true);
        }
        if (this.ajo == null) {
            this.ajo = new C0072u(this, (byte) 0);
        }
        if (this.ajp == null) {
            this.ajp = new C0073v((byte) 0);
        }
        this.ajm = new C0075x(this, c0046aa2);
        this.ajm.start();
    }

    @Override
    public final boolean mo118a(KeyEvent keyEvent) {
        return this.aio.m109a(keyEvent);
    }

    @Override
    public final void mo119aj(boolean z) {
        super.onWindowFocusChanged(z);
    }

    @Override
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return this.aio.onTouchEvent(motionEvent);
    }

    @Override
    public final void onWindowFocusChanged(boolean z) {
        boolean m2179ab = C0351e.m2179ab(z);
        super.onWindowFocusChanged(m2179ab);
        this.aio.onWindowFocusChanged(m2179ab);
    }
}
