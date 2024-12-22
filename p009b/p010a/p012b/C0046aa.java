package p009b.p010a.p012b;

import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import com.gameloft.android.wrapper.C0355i;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class C0046aa implements InterfaceC0050ae {
    AbstractC0067p akc;
    protected C0053b akd;

    public C0046aa(AbstractC0067p abstractC0067p) {
        new ArrayList();
        this.akc = abstractC0067p;
        m112uq();
    }

    public boolean m109a(KeyEvent keyEvent) {
        return this.akc.mo145a(keyEvent);
    }

    public void onDrawFrame(GL10 gl10) {
        if (AbstractC0054c.aiB == 1) {
            AbstractC0054c.aiB++;
        } else if (AbstractC0054c.aiB != 0) {
            this.akc.mo151aW();
        }
    }

    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        AbstractC0067p abstractC0067p = this.akc;
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        this.akc.mo144a(gl10);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.akc.onTouchEvent(motionEvent);
    }

    public void onWindowFocusChanged(boolean z) {
        this.akc.onWindowFocusChanged(z);
    }

    @Override
    public void postInvalidate() {
        this.akd.postInvalidate();
    }

    @Override
    public InterfaceC0049ad mo110ug() {
        return this.akd;
    }

    public void m111up() {
        AbstractC0067p abstractC0067p = this.akc;
    }

    public View m112uq() {
        this.akd = new C0053b(C0355i.getContext(), this);
        return this.akd;
    }
}
