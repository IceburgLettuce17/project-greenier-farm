package p009b.p010a.p013c;

import p009b.p010a.p013c.p014a.InterfaceC0080b;

final class C0091l implements InterfaceC0080b {
    private C0089j akL;

    public C0091l(C0089j c0089j) {
        this.akL = c0089j;
    }

    @Override
    public final int mo196fn(int i) {
        int i2 = 0;
        this.akL.akx = false;
        int i3 = i <= 100 ? i : 100;
        if (i3 < 0) {
            i3 = 0;
        }
        float f = i3 / 100.0f;
        while (true) {
            int i4 = i2;
            if (i4 >= this.akL.akI.size()) {
                this.akL.akw = i3;
                return i3;
            }
            C0089j c0089j = this.akL;
            C0089j.akF.setVolume(this.akL.akI.get(i4).intValue(), f, f);
            i2 = i4 + 1;
        }
    }

    @Override
    public final int getLevel() {
        return this.akL.akw;
    }
}
