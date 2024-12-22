package p009b.p010a.p012b;

import com.facebook.widget.PlacePickerFragment;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

class C0070s extends AbstractC0071t {
    private int[] ajq;
    protected int ajr;
    protected int ajs;
    protected int ajt;
    private int aju;
    private int ajv;
    private int ajw;

    public C0070s(SurfaceHolderCallbackC0069r surfaceHolderCallbackC0069r, int i, int i2, int i3, int i4, int i5, int i6) {
        super(surfaceHolderCallbackC0069r, new int[]{12324, 4, 12323, 4, 12322, 4, 12321, 0, 12325, i5, 12326, 0, 12344});
        this.ajq = new int[1];
        this.ajr = 4;
        this.ajs = 4;
        this.ajt = 4;
        this.aju = 0;
        this.ajv = i5;
        this.ajw = 0;
    }

    private int m179a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
        if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.ajq)) {
            return this.ajq[0];
        }
        return 0;
    }

    @Override
    public final EGLConfig mo180a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
        int i;
        EGLConfig eGLConfig = null;
        int i2 = PlacePickerFragment.DEFAULT_RADIUS_IN_METERS;
        int length = eGLConfigArr.length;
        int i3 = 0;
        while (i3 < length) {
            EGLConfig eGLConfig2 = eGLConfigArr[i3];
            int m179a = m179a(egl10, eGLDisplay, eGLConfig2, 12325, 0);
            int m179a2 = m179a(egl10, eGLDisplay, eGLConfig2, 12326, 0);
            if (m179a >= this.ajv && m179a2 >= this.ajw) {
                int m179a3 = m179a(egl10, eGLDisplay, eGLConfig2, 12324, 0);
                int m179a4 = m179a(egl10, eGLDisplay, eGLConfig2, 12323, 0);
                int m179a5 = m179a(egl10, eGLDisplay, eGLConfig2, 12322, 0);
                i = Math.abs(m179a(egl10, eGLDisplay, eGLConfig2, 12321, 0) - this.aju) + Math.abs(m179a3 - this.ajr) + Math.abs(m179a4 - this.ajs) + Math.abs(m179a5 - this.ajt);
                if (i < i2) {
                    i3++;
                    i2 = i;
                    eGLConfig = eGLConfig2;
                }
            }
            i = i2;
            eGLConfig2 = eGLConfig;
            i3++;
            i2 = i;
            eGLConfig = eGLConfig2;
        }
        return eGLConfig;
    }
}
