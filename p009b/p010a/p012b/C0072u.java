package p009b.p010a.p012b;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

public class C0072u {
    final SurfaceHolderCallbackC0069r ajy;
    int ajz;

    C0072u(SurfaceHolderCallbackC0069r surfaceHolderCallbackC0069r) {
        this.ajy = surfaceHolderCallbackC0069r;
        this.ajz = 12440;
    }

    C0072u(SurfaceHolderCallbackC0069r surfaceHolderCallbackC0069r, byte b2) {
        this(surfaceHolderCallbackC0069r);
    }

    public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
        int[] iArr = {this.ajz, SurfaceHolderCallbackC0069r.m169a(this.ajy), 12344};
        EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
        if (SurfaceHolderCallbackC0069r.m169a(this.ajy) == 0) {
            iArr = null;
        }
        return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
    }

    public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
        egl10.eglDestroyContext(eGLDisplay, eGLContext);
    }
}
