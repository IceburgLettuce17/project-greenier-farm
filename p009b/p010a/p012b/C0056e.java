package p009b.p010a.p012b;

import android.view.KeyEvent;

final class C0056e implements InterfaceC0061j {
    private AbstractC0054c aiK;

    private C0056e(AbstractC0054c abstractC0054c) {
        this.aiK = abstractC0054c;
    }

    C0056e(AbstractC0054c abstractC0054c, byte b2) {
        this(abstractC0054c);
    }

    @Override
    public final boolean mo158a(KeyEvent keyEvent) {
        boolean z;
        int i;
        int i2;
        int i3;
        int i4;
        int unused;
        int unused2;
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 82) {
            int action = keyEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    return true;
                }
                AbstractC0054c abstractC0054c = this.aiK;
                i3 = AbstractC0054c.aiG;
                abstractC0054c.mo143U(i3);
                return true;
            }
            if (keyEvent.getRepeatCount() == 0) {
                AbstractC0054c abstractC0054c2 = this.aiK;
                i4 = AbstractC0054c.aiG;
                abstractC0054c2.mo142T(i4);
                return true;
            }
            AbstractC0054c abstractC0054c3 = this.aiK;
            unused = AbstractC0054c.aiG;
            AbstractC0054c.m133tU();
            return true;
        }
        if (keyCode != 4) {
            z = AbstractC0054c.aiH;
            if (z) {
                int action2 = keyEvent.getAction();
                if (action2 == 0) {
                    if (keyEvent.getRepeatCount() == 0) {
                        this.aiK.mo142T(keyCode);
                    } else {
                        AbstractC0054c abstractC0054c4 = this.aiK;
                        AbstractC0054c.m133tU();
                    }
                } else if (action2 == 1) {
                    this.aiK.mo143U(keyCode);
                }
            }
            return false;
        }
        int action3 = keyEvent.getAction();
        if (action3 != 0) {
            if (action3 != 1) {
                return true;
            }
            AbstractC0054c abstractC0054c5 = this.aiK;
            i = AbstractC0054c.aiF;
            abstractC0054c5.mo143U(i);
            return true;
        }
        if (keyEvent.getRepeatCount() == 0) {
            AbstractC0054c abstractC0054c6 = this.aiK;
            i2 = AbstractC0054c.aiF;
            abstractC0054c6.mo142T(i2);
            return true;
        }
        AbstractC0054c abstractC0054c7 = this.aiK;
        unused2 = AbstractC0054c.aiF;
        AbstractC0054c.m133tU();
        return true;
    }
}
