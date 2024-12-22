package p009b.p010a.p012b;

import android.opengl.GLDebugHelper;
import android.view.SurfaceHolder;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

final class C0075x extends Thread {
    private boolean ajF;
    private boolean ajG;
    private boolean ajH;
    private boolean ajI;
    private boolean ajJ;
    private boolean ajK;
    private boolean ajL;
    private boolean ajQ;
    private GL10 ajS;
    private boolean ajT;
    private C0046aa ajV;
    private C0074w ajW;
    private SurfaceHolderCallbackC0069r ajy;
    private ArrayList<Runnable> ajR = new ArrayList<>();
    private boolean ajU = false;
    private int ajM = 0;
    private int ajN = 0;
    private boolean ajP = true;
    private int ajO = 1;

    public C0075x(SurfaceHolderCallbackC0069r surfaceHolderCallbackC0069r, C0046aa c0046aa) {
        this.ajy = surfaceHolderCallbackC0069r;
        this.ajV = c0046aa;
    }

    static boolean m183a(C0075x c0075x, boolean z) {
        c0075x.ajG = true;
        return true;
    }

    private void m184uj() {
        C0076y c0076y;
        C0073v c0073v;
        if (this.ajL) {
            this.ajL = false;
            C0074w c0074w = this.ajW;
            if (c0074w.ajC != null && c0074w.ajC != EGL10.EGL_NO_SURFACE) {
                c0074w.ajA.eglMakeCurrent(c0074w.ajB, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                c0073v = c0074w.ajy.ajp;
                c0073v.destroySurface(c0074w.ajA, c0074w.ajB, c0074w.ajC);
                c0074w.ajC = null;
            }
            c0076y = SurfaceHolderCallbackC0069r.ajk;
            if (c0076y.akb == this) {
                c0076y.akb = null;
            }
            c0076y.notifyAll();
        }
    }

    private void m185uk() {
        C0076y c0076y;
        C0076y c0076y2;
        C0076y c0076y3;
        boolean z;
        GL10 gl10;
        C0073v c0073v;
        C0076y c0076y4;
        C0073v c0073v2;
        C0076y c0076y5;
        boolean z2;
        boolean z3;
        boolean z4;
        int i;
        boolean z5;
        boolean z6;
        int i2;
        C0076y c0076y6;
        C0076y c0076y7;
        boolean z7;
        AbstractC0071t abstractC0071t;
        C0072u c0072u;
        C0076y c0076y8;
        C0075x c0075x;
        C0076y c0076y9;
        C0076y c0076y10;
        C0076y c0076y11;
        this.ajW = new C0074w(this.ajy);
        this.ajK = false;
        this.ajL = false;
        boolean z8 = false;
        boolean z9 = false;
        boolean z10 = false;
        boolean z11 = false;
        int i3 = 0;
        int i4 = 0;
        Runnable runnable = null;
        GL10 gl102 = null;
        while (true) {
            try {
                c0076y2 = SurfaceHolderCallbackC0069r.ajk;
                synchronized (c0076y2) {
                    while (!this.ajF) {
                        if (this.ajR.isEmpty()) {
                            if (this.ajL && this.ajH) {
                                String str = "releasing EGL surface because paused tid=" + getId();
                                m184uj();
                            }
                            if (!this.ajI && !this.ajJ) {
                                String str2 = "noticed surfaceView surface lost tid=" + getId();
                                if (this.ajL) {
                                    m184uj();
                                }
                                this.ajJ = true;
                                c0076y11 = SurfaceHolderCallbackC0069r.ajk;
                                c0076y11.notifyAll();
                            }
                            if (this.ajI && this.ajJ) {
                                String str3 = "noticed surfaceView surface acquired tid=" + getId();
                                this.ajJ = false;
                                c0076y10 = SurfaceHolderCallbackC0069r.ajk;
                                c0076y10.notifyAll();
                            }
                            if (z11) {
                                z10 = false;
                                z11 = false;
                                this.ajQ = true;
                                c0076y9 = SurfaceHolderCallbackC0069r.ajk;
                                c0076y9.notifyAll();
                            }
                            if (!this.ajH && this.ajI && this.ajM > 0 && this.ajN > 0 && (this.ajP || this.ajO == 1)) {
                                if (this.ajK && !this.ajL) {
                                    C0074w c0074w = this.ajW;
                                    c0074w.ajA.eglGetCurrentContext();
                                    boolean z12 = c0074w.ajA.eglGetError() != 12302;
                                    if (z12) {
                                        c0074w.ajA.eglGetError();
                                        c0075x = c0074w.ajy.ajm;
                                        c0075x.ajS.glEnable(1);
                                        z12 = c0074w.ajA.eglGetError() == 12288;
                                    }
                                    if (!z12) {
                                        this.ajW.finish();
                                        this.ajV.m111up();
                                        this.ajK = false;
                                    }
                                }
                                if (!this.ajK) {
                                    c0076y7 = SurfaceHolderCallbackC0069r.ajk;
                                    if (c0076y7.akb == this || c0076y7.akb == null) {
                                        c0076y7.akb = this;
                                        c0076y7.notifyAll();
                                        z7 = true;
                                    } else {
                                        c0076y7.m192uo();
                                        z7 = c0076y7.aka;
                                    }
                                    if (z7) {
                                        this.ajK = true;
                                        C0074w c0074w2 = this.ajW;
                                        c0074w2.ajA = (EGL10) EGLContext.getEGL();
                                        c0074w2.ajB = c0074w2.ajA.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
                                        if (c0074w2.ajB == EGL10.EGL_NO_DISPLAY) {
                                            throw new RuntimeException("eglGetDisplay failed");
                                        }
                                        if (!c0074w2.ajA.eglInitialize(c0074w2.ajB, new int[2])) {
                                            throw new RuntimeException("eglInitialize failed");
                                        }
                                        abstractC0071t = c0074w2.ajy.ajn;
                                        c0074w2.ajD = abstractC0071t.chooseConfig(c0074w2.ajA, c0074w2.ajB);
                                        c0072u = c0074w2.ajy.ajo;
                                        c0074w2.ajE = c0072u.createContext(c0074w2.ajA, c0074w2.ajB, c0074w2.ajD);
                                        if (c0074w2.ajE == null || c0074w2.ajE == EGL10.EGL_NO_CONTEXT) {
                                            c0074w2.m182dg("createContext");
                                        }
                                        c0074w2.ajC = null;
                                        c0076y8 = SurfaceHolderCallbackC0069r.ajk;
                                        c0076y8.notifyAll();
                                    }
                                }
                                if (!this.ajK || this.ajL) {
                                    z2 = z9;
                                    z3 = z8;
                                } else {
                                    this.ajL = true;
                                    z2 = true;
                                    z3 = true;
                                }
                                if (this.ajL) {
                                    z4 = this.ajy.ajl;
                                    if (z4) {
                                        z6 = true;
                                        i = this.ajM;
                                        i2 = this.ajN;
                                        z5 = true;
                                        this.ajy.ajl = false;
                                    } else {
                                        this.ajP = false;
                                        int i5 = i4;
                                        i = i3;
                                        z5 = z10;
                                        z6 = z2;
                                        i2 = i5;
                                    }
                                    c0076y6 = SurfaceHolderCallbackC0069r.ajk;
                                    c0076y6.notifyAll();
                                    int i6 = i2;
                                    z = z3;
                                    z9 = z6;
                                    z10 = z5;
                                    i3 = i;
                                    i4 = i6;
                                } else {
                                    z8 = z3;
                                    z9 = z2;
                                }
                            }
                            c0076y5 = SurfaceHolderCallbackC0069r.ajk;
                            c0076y5.wait();
                        } else {
                            runnable = this.ajR.remove(0);
                            z = z8;
                        }
                    }
                    this.ajS = null;
                    c0076y3 = SurfaceHolderCallbackC0069r.ajk;
                    synchronized (c0076y3) {
                        m184uj();
                        this.ajW.finish();
                    }
                    return;
                }
                if (runnable != null) {
                    runnable.run();
                    runnable = null;
                    z8 = z;
                } else {
                    if (this.ajT && AbstractC0054c.aiB != 0) {
                        if (z && AbstractC0054c.aiB != 0) {
                            C0074w c0074w3 = this.ajW;
                            SurfaceHolder holder = this.ajy.getHolder();
                            if (c0074w3.ajC != null && c0074w3.ajC != EGL10.EGL_NO_SURFACE) {
                                c0074w3.ajA.eglMakeCurrent(c0074w3.ajB, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                                c0073v2 = c0074w3.ajy.ajp;
                                c0073v2.destroySurface(c0074w3.ajA, c0074w3.ajB, c0074w3.ajC);
                            }
                            c0073v = c0074w3.ajy.ajp;
                            c0074w3.ajC = c0073v.createWindowSurface(c0074w3.ajA, c0074w3.ajB, c0074w3.ajD, holder);
                            if (c0074w3.ajC == null || c0074w3.ajC == EGL10.EGL_NO_SURFACE) {
                                c0074w3.m182dg("createWindowSurface");
                            }
                            if (!c0074w3.ajA.eglMakeCurrent(c0074w3.ajB, c0074w3.ajC, c0074w3.ajC, c0074w3.ajE)) {
                                c0074w3.m182dg("eglMakeCurrent");
                            }
                            GL gl = c0074w3.ajE.getGL();
                            if (SurfaceHolderCallbackC0069r.m174e(c0074w3.ajy) != null) {
                                gl = SurfaceHolderCallbackC0069r.m174e(c0074w3.ajy).m43m();
                            }
                            if ((SurfaceHolderCallbackC0069r.m175f(c0074w3.ajy) & 3) != 0) {
                                gl = GLDebugHelper.wrap(gl, (SurfaceHolderCallbackC0069r.m175f(c0074w3.ajy) & 1) != 0 ? 1 : 0, (SurfaceHolderCallbackC0069r.m175f(c0074w3.ajy) & 2) != 0 ? new C0077z() : null);
                            }
                            GL10 gl103 = (GL10) gl;
                            c0076y4 = SurfaceHolderCallbackC0069r.ajk;
                            c0076y4.m191b(gl103);
                            this.ajS = gl103;
                            this.ajV.onSurfaceCreated(gl103, this.ajW.ajD);
                            gl102 = gl103;
                            z = false;
                        }
                        if (z9 && AbstractC0054c.aiB != 0) {
                            String str4 = "onSurfaceChanged(" + i3 + ", " + i4 + ")";
                            this.ajV.onSurfaceChanged(gl102, i3, i4);
                            z9 = false;
                        }
                        if (AbstractC0054c.aiB == 1) {
                            AbstractC0054c.aiB++;
                        } else if (AbstractC0054c.aiB != 0) {
                            this.ajV.onDrawFrame(gl102);
                        }
                        if (AbstractC0054c.aiB != 0 && AbstractC0054c.aiB != 1) {
                            try {
                                C0074w c0074w4 = this.ajW;
                                c0074w4.ajA.eglSwapBuffers(c0074w4.ajB, c0074w4.ajC);
                                if (!(c0074w4.ajA.eglGetError() != 12302)) {
                                    String str5 = "egl surface lost tid=" + getId();
                                    m184uj();
                                }
                                z8 = z;
                                gl10 = gl102;
                            } catch (Exception e) {
                            }
                            if (z10) {
                                gl102 = gl10;
                            } else {
                                z11 = true;
                                gl102 = gl10;
                            }
                        }
                    }
                    z8 = z;
                    gl10 = gl102;
                    if (z10) {
                    }
                }
            } catch (Throwable th) {
                this.ajS = null;
                c0076y = SurfaceHolderCallbackC0069r.ajk;
                synchronized (c0076y) {
                    m184uj();
                    this.ajW.finish();
                    throw th;
                }
            }
        }
    }

    public final void m186aW(int i, int i2) {
        C0076y c0076y;
        C0076y c0076y2;
        C0076y c0076y3;
        c0076y = SurfaceHolderCallbackC0069r.ajk;
        synchronized (c0076y) {
            this.ajM = i;
            this.ajN = i2;
            this.ajy.ajl = true;
            this.ajP = true;
            this.ajQ = false;
            c0076y2 = SurfaceHolderCallbackC0069r.ajk;
            c0076y2.notifyAll();
            while (!this.ajG && !this.ajH && !this.ajQ) {
                try {
                    c0076y3 = SurfaceHolderCallbackC0069r.ajk;
                    c0076y3.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public final void onPause() {
        C0076y c0076y;
        C0076y c0076y2;
        c0076y = SurfaceHolderCallbackC0069r.ajk;
        synchronized (c0076y) {
            this.ajH = true;
            c0076y2 = SurfaceHolderCallbackC0069r.ajk;
            c0076y2.notifyAll();
        }
    }

    public final void onResume() {
        C0076y c0076y;
        C0076y c0076y2;
        c0076y = SurfaceHolderCallbackC0069r.ajk;
        synchronized (c0076y) {
            this.ajH = false;
            this.ajP = true;
            c0076y2 = SurfaceHolderCallbackC0069r.ajk;
            c0076y2.notifyAll();
        }
    }

    public final void onWindowFocusChanged(boolean z) {
        C0076y c0076y;
        C0076y c0076y2;
        c0076y = SurfaceHolderCallbackC0069r.ajk;
        synchronized (c0076y) {
            this.ajT = z;
            c0076y2 = SurfaceHolderCallbackC0069r.ajk;
            c0076y2.notifyAll();
        }
        String str = "Focus " + (this.ajT ? "gained" : "lost");
    }

    @Override
    public final void run() {
        C0076y c0076y;
        setName("GLThread " + getId());
        String str = "starting tid=" + getId();
        try {
            m185uk();
        } catch (InterruptedException e) {
        } finally {
            c0076y = SurfaceHolderCallbackC0069r.ajk;
            c0076y.m190a(this);
        }
    }

    public final void m187ul() {
        C0076y c0076y;
        C0076y c0076y2;
        c0076y = SurfaceHolderCallbackC0069r.ajk;
        synchronized (c0076y) {
            String str = "surfaceCreated tid=" + getId();
            this.ajI = true;
            c0076y2 = SurfaceHolderCallbackC0069r.ajk;
            c0076y2.notifyAll();
        }
    }

    public final void m188um() {
        C0076y c0076y;
        C0076y c0076y2;
        C0076y c0076y3;
        c0076y = SurfaceHolderCallbackC0069r.ajk;
        synchronized (c0076y) {
            String str = "surfaceDestroyed tid=" + getId();
            this.ajI = false;
            c0076y2 = SurfaceHolderCallbackC0069r.ajk;
            c0076y2.notifyAll();
            while (!this.ajJ && !this.ajG) {
                try {
                    c0076y3 = SurfaceHolderCallbackC0069r.ajk;
                    c0076y3.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public final void m189un() {
        C0076y c0076y;
        C0076y c0076y2;
        C0076y c0076y3;
        c0076y = SurfaceHolderCallbackC0069r.ajk;
        synchronized (c0076y) {
            this.ajF = true;
            c0076y2 = SurfaceHolderCallbackC0069r.ajk;
            c0076y2.notifyAll();
            while (!this.ajG) {
                try {
                    c0076y3 = SurfaceHolderCallbackC0069r.ajk;
                    c0076y3.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
