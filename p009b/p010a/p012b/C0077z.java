package p009b.p010a.p012b;

import java.io.Writer;

final class C0077z extends Writer {

    private StringBuilder f91aA = new StringBuilder();

    C0077z() {
    }

    private void m193I() {
        if (this.f91aA.length() > 0) {
            this.f91aA.toString();
            this.f91aA.delete(0, this.f91aA.length());
        }
    }

    @Override
    public final void close() {
        m193I();
    }

    @Override
    public final void flush() {
        m193I();
    }

    @Override
    public final void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == '\n') {
                m193I();
            } else {
                this.f91aA.append(c);
            }
        }
    }
}
