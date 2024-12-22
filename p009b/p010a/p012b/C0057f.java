package p009b.p010a.p012b;

import android.view.MotionEvent;

final class C0057f implements InterfaceC0062k {
    private AbstractC0054c aiK;
    private float aiL;
    private float aiM;
    private int aiN;

    private C0057f(AbstractC0054c abstractC0054c) {
        this.aiK = abstractC0054c;
        this.aiL = -1.0f;
        this.aiM = -1.0f;
        this.aiN = -1;
    }

    C0057f(AbstractC0054c abstractC0054c, byte b2) {
        this(abstractC0054c);
    }

    @Override
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        float f;
        int i;
        float f2;
        int i2;
        String str = "touch pressure: " + motionEvent.getPressure();
        float x = motionEvent.getX();
        f = AbstractC0054c.aiu;
        float f3 = x / f;
        i = AbstractC0054c.aiw;
        float f4 = f3 - i;
        float y = motionEvent.getY();
        f2 = AbstractC0054c.aiv;
        float f5 = y / f2;
        i2 = AbstractC0054c.aix;
        float f6 = f5 - i2;
        this.aiN = motionEvent.getAction();
        switch (this.aiN) {
            case 0:
                this.aiK.mo156u((int) f4, (int) f6);
                this.aiL = f4;
                this.aiM = f6;
                break;
            case 1:
                this.aiK.mo154t((int) this.aiL, (int) this.aiM);
                break;
            case 2:
                this.aiL = f4;
                this.aiM = f6;
                this.aiK.mo157v((int) f4, (int) f6);
                break;
        }
        return true;
    }
}
