package p001a.p004b.p005a.p008c;

import android.util.Log;
import java.io.Writer;

public final class C0033a extends Writer {

    private StringBuilder f85aA = new StringBuilder(128);
    private final String mTag;

    public C0033a(String str) {
        this.mTag = str;
    }

    private void m104I() {
        if (this.f85aA.length() > 0) {
            Log.d(this.mTag, this.f85aA.toString());
            this.f85aA.delete(0, this.f85aA.length());
        }
    }

    @Override
    public final void close() {
        m104I();
    }

    @Override
    public final void flush() {
        m104I();
    }

    @Override
    public final void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == '\n') {
                m104I();
            } else {
                this.f85aA.append(c);
            }
        }
    }
}
