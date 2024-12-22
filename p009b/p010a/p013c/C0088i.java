package p009b.p010a.p013c;

import p009b.p010a.p013c.p014a.InterfaceC0080b;

final class C0088i implements InterfaceC0080b {
    private C0085f akA;

    public C0088i(C0085f c0085f) {
        this.akA = c0085f;
    }

    @Override
    public final int mo196fn(int i) {
        this.akA.akx = false;
        int i2 = i <= 100 ? i : 100;
        int i3 = i2 >= 0 ? i2 : 0;
        float f = i3 / 100.0f;
        this.akA.aku.setVolume(f, f);
        this.akA.akw = i3;
        return i3;
    }

    @Override
    public final int getLevel() {
        return this.akA.akw;
    }
}
