package p009b.p010a.p012b;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.gameloft.android.wrapper.C0349c;
import p001a.p004b.p005a.p006a.InterfaceC0014m;

public class SurfaceHolderCallbackC0069r extends SurfaceView implements SurfaceHolder.Callback {
    private static final C0076y ajk = new C0076y(0);
    private boolean ajl;
    C0075x ajm;
    AbstractC0071t ajn;
    C0072u ajo;
    C0073v ajp;

    public SurfaceHolderCallbackC0069r(Context context) {
        super(context);
        this.ajl = true;
        SurfaceHolder holder = getHolder();
        holder.addCallback(this);
        holder.setType(2);
    }

    static int m169a(SurfaceHolderCallbackC0069r surfaceHolderCallbackC0069r) {
        return 0;
    }

    static InterfaceC0014m m174e(SurfaceHolderCallbackC0069r surfaceHolderCallbackC0069r) {
        return null;
    }

    static int m175f(SurfaceHolderCallbackC0069r surfaceHolderCallbackC0069r) {
        return 0;
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.ajm.m189un();
    }

    public void onPause() {
        this.ajm.onPause();
    }

    public void onResume() {
        this.ajm.onResume();
    }

    @Override
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.ajm.onWindowFocusChanged(z);
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if ((C0349c.f2689XE.compareTo("landscape") != 0 || i2 >= i3) && (C0349c.f2689XE.compareTo("portrait") != 0 || i2 <= i3)) {
            i3 = i2;
            i2 = i3;
        }
        String str = "onSizeChange: " + i3 + ", " + i2 + " orientation:" + C0349c.f2689XE;
        this.ajm.m186aW(i3, i2);
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.ajm.m187ul();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.ajm.m188um();
    }
}
