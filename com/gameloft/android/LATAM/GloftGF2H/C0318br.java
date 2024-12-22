package com.gameloft.android.LATAM.GloftGF2H;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

final class C0318br {

    private static int[] f742Bn = new int[256];

    private boolean f743Bi;

    private byte[] f744Bj;

    private int f745Bk;

    private int f746Bl;

    private int f747Bm;

    private boolean f748Bo;

    private int f749Bp;

    private boolean f750Bq;

    private int f751Br;

    private int f752Bs;

    private InputStream f753in;
    private OutputStream out;

    private int f754vZ;

    static {
        for (int i = 0; i < 256; i++) {
            int i2 = i;
            for (int i3 = 0; i3 < 8; i3++) {
                i2 = (i2 & 1) != 0 ? (i2 >>> 1) ^ (-306674912) : i2 >>> 1;
            }
            f742Bn[i] = i2;
        }
    }

    public C0318br(InputStream inputStream, boolean z, int i) {
        this(z, 0);
        this.f753in = inputStream;
    }

    public C0318br(OutputStream outputStream, boolean z, int i) {
        this(z, i);
        this.out = outputStream;
    }

    private C0318br(boolean z, int i) {
        this.f749Bp = -1;
        this.f748Bo = z;
        if (i > 0) {
            this.f743Bi = true;
            this.f745Bk = (1 << i) - 1;
            this.f744Bj = new byte[1 << i];
        }
    }

    private void m892a(byte b2) {
        int i = this.f749Bp;
        this.f749Bp = (i >>> 8) ^ f742Bn[(i & 255) ^ (b2 & 255)];
    }

    private void m893bd(int i) {
        this.out.write(i);
        this.f754vZ++;
        if (this.f748Bo) {
            m892a((byte) i);
        }
        if (this.f743Bi) {
            this.f744Bj[this.f746Bl] = (byte) i;
            this.f746Bl = (this.f746Bl + 1) & this.f745Bk;
            if (this.f747Bm < this.f744Bj.length) {
                this.f747Bm++;
            }
        }
    }

    private static void m894be(int i) {
        if (i < 0) {
            throw new IOException("Unexpected EOF.");
        }
    }

    private int m895eh() {
        int read = this.f753in.read();
        if (read >= 0) {
            this.f754vZ++;
            if (this.f748Bo) {
                m892a((byte) read);
            }
            if (this.f743Bi) {
                this.f744Bj[this.f746Bl] = (byte) read;
                this.f746Bl = (this.f746Bl + 1) & this.f745Bk;
                if (this.f747Bm < this.f744Bj.length) {
                    this.f747Bm++;
                }
            }
        }
        return read;
    }

    final void m896J(int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            write((i >>> (i3 * 8)) & 255);
        }
    }

    final void m897K(int i, int i2) {
        if (!this.f743Bi) {
            throw new RuntimeException("buffer unavailable");
        }
        if (i > this.f747Bm) {
            throw new RuntimeException("invalid distance");
        }
        int length = this.f745Bk & ((this.f746Bl - i) + this.f744Bj.length);
        for (int i3 = 0; i3 < i2; i3++) {
            write(this.f744Bj[(length + i3) & this.f745Bk]);
        }
    }

    final void m898L(int i, int i2) {
        this.f750Bq = true;
        this.f751Br = ((((1 << i2) - 1) & i) << this.f752Bs) | this.f751Br;
        this.f752Bs += i2;
        while (this.f752Bs > 8) {
            m893bd((byte) this.f751Br);
            this.f754vZ++;
            this.f751Br >>>= 8;
            this.f752Bs -= 8;
        }
    }

    final void m899bf(int i) {
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                return;
            }
            m894be(read());
            i = i2;
        }
    }

    final int m900bg(int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            int read = read();
            m894be(read);
            i2 |= read << (i3 << 3);
        }
        return i2;
    }

    final int m901bh(int i) {
        this.f750Bq = true;
        while (this.f752Bs < i) {
            int m895eh = m895eh();
            if (m895eh < 0) {
                m894be(m895eh);
            }
            this.f751Br = (m895eh << this.f752Bs) | this.f751Br;
            this.f752Bs += 8;
        }
        int i2 = ((1 << i) - 1) & this.f751Br;
        this.f751Br >>>= i;
        this.f752Bs -= i;
        return i2;
    }

    final void m902ef() {
        this.f749Bp = -1;
        this.f748Bo = true;
    }

    final int m903eg() {
        return this.f749Bp ^ (-1);
    }

    final String m904ei() {
        StringBuffer stringBuffer = new StringBuffer(128);
        while (true) {
            int read = read();
            if (read <= 0) {
                return stringBuffer.toString();
            }
            stringBuffer.append((char) read);
        }
    }

    final void m905ej() {
        m901bh(this.f752Bs);
        this.f750Bq = false;
    }

    final void m906ek() {
        while (this.f752Bs > 0) {
            m893bd(this.f751Br & 255);
            this.f754vZ++;
            this.f751Br >>>= 8;
            this.f752Bs -= 8;
        }
        this.f750Bq = false;
        this.out.flush();
    }

    public final int getSize() {
        return this.f754vZ;
    }

    public final void m907r(boolean z) {
        this.f748Bo = false;
    }

    final int read() {
        if (this.f750Bq) {
            throw new RuntimeException("Unaligned byte");
        }
        return m895eh();
    }

    final int read(byte[] bArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            int read = read();
            if (read < 0) {
                return i3;
            }
            bArr[i3 + 0] = (byte) read;
        }
        return i2;
    }

    final void write(int i) {
        if (this.f750Bq) {
            throw new RuntimeException("Unaligned byte");
        }
        m893bd(i);
    }
}
