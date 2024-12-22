package p009b.p010a.p012b;

import android.view.KeyEvent;
import android.view.MotionEvent;
import com.gameloft.android.wrapper.C0355i;
import java.util.ArrayList;
import javax.microedition.khronos.opengles.GL10;

public abstract class AbstractC0067p {
    public ArrayList aiZ = new ArrayList();
    private InterfaceC0050ae aja;

    public AbstractC0067p() {
        C0355i.getContext();
        this.aja = new C0046aa(this);
        this.aja.mo110ug();
    }

    public void mo144a(GL10 gl10) {
    }

    public boolean mo145a(KeyEvent keyEvent) {
        return false;
    }

    public void mo146aQ() {
    }

    public void mo147aR() {
    }

    public void mo150aV(int i, int i2) {
    }

    public void mo151aW() {
    }

    public void mo152aj(boolean z) {
    }

    public void mo153al(boolean z) {
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public void onWindowFocusChanged(boolean z) {
    }

    public final void postInvalidate() {
        this.aja.postInvalidate();
    }

    public final InterfaceC0049ad m165ug() {
        return this.aja.mo110ug();
    }
}
