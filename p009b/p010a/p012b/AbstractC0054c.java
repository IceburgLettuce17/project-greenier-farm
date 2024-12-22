package p009b.p010a.p012b;

import android.content.Context;
import android.graphics.Paint;
import android.os.Build;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.WindowManager;
import com.gameloft.android.wrapper.C0349c;
import com.gameloft.android.wrapper.C0355i;
import java.lang.reflect.Method;
import javax.microedition.khronos.opengles.GL10;
import p009b.p010a.p015d.AbstractActivityC0092a;

public abstract class AbstractC0054c extends AbstractC0067p {
    public static GL10 aiJ;
    private boolean aiA = false;
    public boolean aiC = false;
    public boolean aiD = false;
    private InterfaceC0062k aiE;
    private InterfaceC0061j aiI;
    public static AbstractC0054c aip = null;
    public static int aiq = 2;
    private static boolean air = true;
    private static int ais = -1;
    private static int ait = -1;
    private static float aiu = 1.0f;
    private static float aiv = 1.0f;
    private static int aiw = 0;
    private static int aix = 0;
    private static boolean aiy = false;
    private static Paint aiz = null;
    public static int aiB = 0;
    private static int aiF = -7;
    private static int aiG = -8;
    private static boolean aiH = true;

    public AbstractC0054c() {
        aip = this;
        Context context = C0355i.getContext();
        if (context == null) {
            String str = "Can't detect screen size. context is null!!! Using default: " + ais + "x" + ait;
            return;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            String str2 = "Can't detect screen size. windowManager is null!!! Using default: " + ais + "x" + ait;
            return;
        }
        Display defaultDisplay = windowManager.getDefaultDisplay();
        if (defaultDisplay == null) {
            String str3 = "Can't detect screen size. display is null!!! Using default: " + ais + "x" + ait;
            return;
        }
        if (!aiy) {
            ais = defaultDisplay.getWidth();
            ait = defaultDisplay.getHeight();
            if (C0349c.f2689XE.compareTo("landscape") == 0 && ais < ait) {
                int i = ais;
                ais = ait;
                ait = i;
            } else if (C0349c.f2689XE.compareTo("portrait") == 0 && ais > ait) {
                int i2 = ais;
                ais = ait;
                ait = i2;
            }
        }
        String str4 = "orientation: " + defaultDisplay.getOrientation();
    }

    public static void m126ak(boolean z) {
        if (aiz == null) {
            Paint paint = new Paint();
            aiz = paint;
            paint.setFilterBitmap(true);
        }
    }

    public static void m127am(boolean z) {
        aiH = true;
    }

    public static void m128fj(int i) {
        aiF = -7;
    }

    public static void m129fk(int i) {
        aiG = -8;
    }

    public static float getScaleX() {
        return aiu;
    }

    public static float getScaleY() {
        return aiv;
    }

    public static void setScale(float f, float f2) {
        aiu = f;
        aiv = f2;
    }

    public static int m130tR() {
        return aiw;
    }

    public static int m131tS() {
        return aix;
    }

    private InterfaceC0062k m132tT() {
        Method method;
        Method declaredMethod;
        Method declaredMethod2;
        try {
            Class<?> cls = getClass();
            if (air) {
                cls = Class.forName(getClass().getPackage().getName() + ".GLLib");
            }
            declaredMethod = cls.getDeclaredMethod("Pointer_GetNumPointers", new Class[0]);
            if (!declaredMethod.isAccessible()) {
                declaredMethod.setAccessible(true);
            }
            declaredMethod2 = cls.getDeclaredMethod("Pointer_SetCurrentPointer", Integer.TYPE);
        } catch (Exception e) {
            method = null;
        }
        try {
            if (!declaredMethod2.isAccessible()) {
                declaredMethod2.setAccessible(true);
            }
            aiq = ((Integer) declaredMethod.invoke(this, new Object[0])).intValue();
            method = declaredMethod2;
        } catch (Exception e2) {
            method = declaredMethod2;
            aiq = 1;
            if (aiq != 1) {
            }
            return new C0057f(this, (byte) 0);
        }
        if (aiq != 1 || method == null) {
            return new C0057f(this, (byte) 0);
        }
        int parseInt = Integer.parseInt(Build.VERSION.SDK);
        return parseInt < 5 ? new C0057f(this, (byte) 0) : parseInt < 8 ? new C0059h(this, method) : new C0060i(this, method);
    }

    protected static void m133tU() {
    }

    public static boolean m134tV() {
        return false;
    }

    protected void mo142T(int i) {
    }

    protected void mo143U(int i) {
    }

    @Override
    public void mo144a(GL10 gl10) {
    }

    @Override
    public final boolean mo145a(KeyEvent keyEvent) {
        if (this.aiI == null) {
            this.aiI = Integer.parseInt(Build.VERSION.SDK) < 5 ? new C0056e(this, (byte) 0) : new C0058g(this, (byte) 0);
        }
        return this.aiI.mo158a(keyEvent);
    }

    @Override
    public void mo146aQ() {
        m165ug().onPause();
    }

    @Override
    public void mo147aR() {
        m165ug().onResume();
    }

    protected void mo148aS() {
    }

    protected void mo149aT() {
    }

    @Override
    public final void mo150aV(int i, int i2) {
        if ((C0349c.f2689XE.compareTo("landscape") != 0 || i >= i2) && (C0349c.f2689XE.compareTo("portrait") != 0 || i <= i2)) {
            i2 = i;
            i = i2;
        }
        String str = "onSizeChange: " + i2 + ", " + i + " orientation:" + C0349c.f2689XE;
    }

    @Override
    public void mo151aW() {
    }

    @Override
    public final void mo152aj(boolean z) {
        m165ug().mo119aj(z);
    }

    @Override
    public final void mo153al(boolean z) {
        if (z) {
            this.aiD = false;
        }
        if (this.aiA == z) {
            String str = "onWindowFocusChanged IGNORED twice!: " + z;
            return;
        }
        if (z) {
            this.aiC = true;
            new Thread(new RunnableC0055d(this)).start();
            AbstractActivityC0092a.akN = false;
        } else if (!AbstractActivityC0092a.akN) {
            aiB = 0;
            mo148aS();
            if (this.aiC) {
                this.aiD = true;
            }
        }
        this.aiA = z;
    }

    @Override
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.aiE == null) {
            this.aiE = m132tT();
        }
        return this.aiE.onTouchEvent(motionEvent);
    }

    @Override
    public final void onWindowFocusChanged(boolean z) {
        String str = "onWindowFocusChanged: " + z;
        mo153al(z);
    }

    protected void mo154t(int i, int i2) {
    }

    public final void m155tW() {
        postInvalidate();
    }

    protected void mo156u(int i, int i2) {
    }

    protected void mo157v(int i, int i2) {
    }
}
