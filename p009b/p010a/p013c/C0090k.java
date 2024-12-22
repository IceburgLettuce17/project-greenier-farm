package p009b.p010a.p013c;

import p009b.p010a.p013c.p014a.InterfaceC0079a;

public final class C0090k implements InterfaceC0079a {
    private C0089j akK;

    public C0090k(C0089j c0089j, C0089j c0089j2) {
        this.akK = null;
        this.akK = c0089j2;
    }

    @Override
    public final int mo194fo(int i) {
        int i2 = 0;
        String str = "Wrapper Sound Pool setRate: " + i;
        int i3 = i <= 200000 ? i : 200000;
        if (i3 < 0) {
            i3 = 0;
        }
        float f = i3 / 100000.0f;
        while (true) {
            int i4 = i2;
            if (i4 >= this.akK.akI.size()) {
                this.akK.akJ = i3;
                return i3;
            }
            C0089j c0089j = this.akK;
            C0089j.akF.setRate(this.akK.akI.get(i4).intValue(), f);
            i2 = i4 + 1;
        }
    }

    @Override
    public final int mo195uw() {
        return this.akK.akJ;
    }
}
