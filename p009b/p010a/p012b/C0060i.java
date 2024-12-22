package p009b.p010a.p012b;

import android.view.MotionEvent;
import com.facebook.android.C0217R;
import java.lang.reflect.Method;

final class C0060i implements InterfaceC0062k {
    private AbstractC0054c aiK;
    private Method aiO;
    private float[] aiP;
    private float[] aiQ;
    private int[] aiR;

    public C0060i(AbstractC0054c abstractC0054c, Method method) {
        this.aiK = abstractC0054c;
        this.aiO = method;
    }

    private void m160fl(int i) {
        try {
            this.aiO.invoke(this.aiK, new Integer(i));
        } catch (Exception e) {
        }
    }

    @Override
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        float f;
        int i;
        float f2;
        int i2;
        float f3;
        int i3;
        float f4;
        int i4;
        float f5;
        int i5;
        float f6;
        int i6;
        float f7;
        int i7;
        float f8;
        int i8;
        float f9;
        int i9;
        float f10;
        int i10;
        int i11 = 0;
        if (this.aiP == null) {
            this.aiP = new float[AbstractC0054c.aiq];
            this.aiQ = new float[AbstractC0054c.aiq];
            this.aiR = new int[AbstractC0054c.aiq];
            for (int i12 = 0; i12 < AbstractC0054c.aiq; i12++) {
                this.aiP[i12] = -1.0f;
                this.aiQ[i12] = -1.0f;
                this.aiR[i12] = 1;
            }
        }
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        int pointerId = motionEvent.getPointerId(actionIndex);
        int pointerCount = motionEvent.getPointerCount();
        float x = motionEvent.getX(actionIndex);
        f = AbstractC0054c.aiu;
        float f11 = x / f;
        i = AbstractC0054c.aiw;
        float f12 = f11 - i;
        float y = motionEvent.getY(actionIndex);
        f2 = AbstractC0054c.aiv;
        float f13 = y / f2;
        i2 = AbstractC0054c.aix;
        float f14 = f13 - i2;
        switch (actionMasked) {
            case 0:
                if (pointerId < AbstractC0054c.aiq) {
                    m160fl(pointerId);
                    this.aiK.mo156u((int) f12, (int) f14);
                    this.aiP[pointerId] = f12;
                    this.aiQ[pointerId] = f14;
                    this.aiR[pointerId] = 0;
                }
                if (pointerCount > 1) {
                    for (int i13 = 0; i13 < pointerCount; i13++) {
                        if (i13 != actionIndex) {
                            int pointerId2 = motionEvent.getPointerId(i13);
                            float x2 = motionEvent.getX(i13);
                            f9 = AbstractC0054c.aiu;
                            float f15 = x2 / f9;
                            i9 = AbstractC0054c.aiw;
                            float f16 = f15 - i9;
                            float y2 = motionEvent.getY(i13);
                            f10 = AbstractC0054c.aiv;
                            float f17 = y2 / f10;
                            i10 = AbstractC0054c.aix;
                            float f18 = f17 - i10;
                            m160fl(pointerId2);
                            this.aiK.mo156u((int) f16, (int) f18);
                            this.aiP[pointerId2] = f16;
                            this.aiQ[pointerId2] = f18;
                            this.aiR[pointerId2] = 0;
                        }
                    }
                    break;
                }
                break;
            case 1:
                if (pointerId < AbstractC0054c.aiq) {
                    m160fl(pointerId);
                    this.aiK.mo154t((int) this.aiP[pointerId], (int) this.aiQ[pointerId]);
                    this.aiR[pointerId] = 1;
                }
                if (pointerCount > 1) {
                    while (i11 < AbstractC0054c.aiq) {
                        if (i11 != pointerId && this.aiR[i11] != 1) {
                            m160fl(i11);
                            this.aiK.mo154t((int) this.aiP[i11], (int) this.aiQ[i11]);
                            this.aiR[i11] = 1;
                        }
                        i11++;
                    }
                    break;
                }
                break;
            case 2:
                if (pointerId < AbstractC0054c.aiq) {
                    m160fl(pointerId);
                    this.aiK.mo157v((int) f12, (int) f14);
                    this.aiP[pointerId] = f12;
                    this.aiQ[pointerId] = f14;
                    this.aiR[pointerId] = 2;
                }
                if (pointerCount > 1) {
                    while (i11 < pointerCount) {
                        if (i11 != actionIndex) {
                            int pointerId3 = motionEvent.getPointerId(i11);
                            float x3 = motionEvent.getX(i11);
                            f7 = AbstractC0054c.aiu;
                            float f19 = x3 / f7;
                            i7 = AbstractC0054c.aiw;
                            float f20 = f19 - i7;
                            float y3 = motionEvent.getY(i11);
                            f8 = AbstractC0054c.aiv;
                            float f21 = y3 / f8;
                            i8 = AbstractC0054c.aix;
                            float f22 = f21 - i8;
                            m160fl(pointerId3);
                            this.aiK.mo157v((int) f20, (int) f22);
                            this.aiP[pointerId3] = f20;
                            this.aiQ[pointerId3] = f22;
                            this.aiR[pointerId3] = 2;
                        }
                        i11++;
                    }
                    break;
                }
                break;
            case 3:
                String str = "Canvas FroyoMotionHandler cancel " + pointerId + " numPointers:" + pointerCount;
                if (pointerId < AbstractC0054c.aiq) {
                    m160fl(pointerId);
                    this.aiK.mo154t((int) this.aiP[pointerId], (int) this.aiQ[pointerId]);
                    this.aiR[pointerId] = 1;
                }
                if (pointerCount <= 1) {
                    return false;
                }
                for (int i14 = 0; i14 < AbstractC0054c.aiq; i14++) {
                    if (i14 != pointerId && this.aiR[i14] != 1) {
                        m160fl(i14);
                        this.aiK.mo154t((int) this.aiP[i14], (int) this.aiQ[i14]);
                        this.aiR[i14] = 1;
                    }
                }
                return false;
            case C0217R.styleable.com_facebook_picker_fragment_title_bar_background:
                if (pointerId < AbstractC0054c.aiq) {
                    m160fl(pointerId);
                    this.aiK.mo156u((int) f12, (int) f14);
                    this.aiP[pointerId] = f12;
                    this.aiQ[pointerId] = f14;
                    this.aiR[pointerId] = 0;
                }
                while (i11 < pointerCount) {
                    if (i11 != actionIndex) {
                        int pointerId4 = motionEvent.getPointerId(i11);
                        float x4 = motionEvent.getX(i11);
                        f5 = AbstractC0054c.aiu;
                        float f23 = x4 / f5;
                        i5 = AbstractC0054c.aiw;
                        float f24 = f23 - i5;
                        float y4 = motionEvent.getY(i11);
                        f6 = AbstractC0054c.aiv;
                        float f25 = y4 / f6;
                        i6 = AbstractC0054c.aix;
                        float f26 = f25 - i6;
                        m160fl(pointerId4);
                        this.aiK.mo157v((int) f24, (int) f26);
                        this.aiP[pointerId4] = f24;
                        this.aiQ[pointerId4] = f26;
                        this.aiR[pointerId4] = 2;
                    }
                    i11++;
                }
                break;
            case C0217R.styleable.com_facebook_picker_fragment_done_button_background:
                if (pointerId < AbstractC0054c.aiq) {
                    m160fl(pointerId);
                    this.aiK.mo154t((int) this.aiP[pointerId], (int) this.aiQ[pointerId]);
                    this.aiR[pointerId] = 1;
                }
                while (i11 < pointerCount) {
                    if (i11 != actionIndex) {
                        int pointerId5 = motionEvent.getPointerId(i11);
                        float x5 = motionEvent.getX(i11);
                        f3 = AbstractC0054c.aiu;
                        float f27 = x5 / f3;
                        i3 = AbstractC0054c.aiw;
                        float f28 = f27 - i3;
                        float y5 = motionEvent.getY(i11);
                        f4 = AbstractC0054c.aiv;
                        float f29 = y5 / f4;
                        i4 = AbstractC0054c.aix;
                        float f30 = f29 - i4;
                        m160fl(pointerId5);
                        this.aiK.mo157v((int) f28, (int) f30);
                        this.aiP[pointerId5] = f28;
                        this.aiQ[pointerId5] = f30;
                        this.aiR[pointerId5] = 2;
                    }
                    i11++;
                }
                break;
        }
        return true;
    }
}
