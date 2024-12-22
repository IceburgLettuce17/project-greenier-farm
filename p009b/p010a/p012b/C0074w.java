package p009b.p010a.p012b;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

final class C0074w {
    EGL10 ajA;
    EGLDisplay ajB;
    EGLSurface ajC;
    EGLConfig ajD;
    EGLContext ajE;
    final SurfaceHolderCallbackC0069r ajy;

    public C0074w(SurfaceHolderCallbackC0069r surfaceHolderCallbackC0069r) {
        this.ajy = surfaceHolderCallbackC0069r;
    }

    void m182dg(String str) {
        throw new RuntimeException(str + " failed: " + this.ajA.eglGetError());
    }

    public final void finish() {
        C0072u c0072u;
        if (this.ajE != null) {
            c0072u = this.ajy.ajo;
            c0072u.destroyContext(this.ajA, this.ajB, this.ajE);
            this.ajE = null;
        }
        if (this.ajB != null) {
            this.ajA.eglTerminate(this.ajB);
            this.ajB = null;
        }
    }
}
