package p009b.p010a.p012b;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

public abstract class AbstractC0071t {
    protected int[] ajx;
    final SurfaceHolderCallbackC0069r ajy;

    public AbstractC0071t(SurfaceHolderCallbackC0069r surfaceHolderCallbackC0069r, int[] iArr) {
        this.ajy = surfaceHolderCallbackC0069r;
        this.ajx = m181e(iArr);
    }

    abstract EGLConfig mo180a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

    public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
        int[] iArr = new int[1];
        if (!egl10.eglChooseConfig(eGLDisplay, this.ajx, null, 0, iArr)) {
            throw new IllegalArgumentException("eglChooseConfig failed");
        }
        int i = iArr[0];
        if (i <= 0) {
            throw new IllegalArgumentException("No configs match configSpec");
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[i];
        if (!egl10.eglChooseConfig(eGLDisplay, this.ajx, eGLConfigArr, i, iArr)) {
            throw new IllegalArgumentException("eglChooseConfig#2 failed");
        }
        EGLConfig mo180a = mo180a(egl10, eGLDisplay, eGLConfigArr);
        if (mo180a == null) {
            throw new IllegalArgumentException("No config chosen");
        }
        return mo180a;
    }

    int[] m181e(int[] iArr) {
        if (SurfaceHolderCallbackC0069r.m169a(this.ajy) != 2) {
            return iArr;
        }
        int length = iArr.length;
        int[] iArr2 = new int[length + 2];
        System.arraycopy(iArr, 0, iArr2, 0, length - 1);
        iArr2[length - 1] = 12352;
        iArr2[length] = 4;
        iArr2[length + 1] = 12344;
        return iArr2;
    }
}
