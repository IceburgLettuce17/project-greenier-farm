package com.gameloft.android.LATAM.GloftGF2H;

final class C0339s {

    private static int[] f2541te = {0, -1, 0, 1, -1, 0, 1, 0, -1, -1, 1, -1, -1, 1, 1, 1};

    private short[] f2542tf;

    private short[] f2543tg;

    private short[] f2544th;

    private short[] f2545ti;

    private short[] f2546tj;

    private int f2547tk;

    private int f2548tl;

    private int f2549tm;

    private int f2550tn;

    private int f2551to;

    private int f2552tp;

    private byte[] f2553tq;

    private int f2554tr;

    private short[] f2555ts;

    private int f2556tt;

    private int f2557tu;

    private boolean f2558tv = false;

    private void m2071ax(int i) {
        if (this.f2557tu == -1) {
            this.f2557tu = i;
            return;
        }
        int i2 = this.f2546tj[i] + this.f2545ti[i];
        int i3 = this.f2557tu;
        while (i3 != -1) {
            if (i2 < this.f2545ti[i3] + this.f2546tj[i3]) {
                if (this.f2543tg[i3] == -1) {
                    this.f2557tu = i;
                } else {
                    this.f2544th[this.f2543tg[i3]] = (short) i;
                }
                this.f2543tg[i] = this.f2543tg[i3];
                this.f2544th[i] = (short) i3;
                this.f2543tg[i3] = (short) i;
                return;
            }
            if (this.f2544th[i3] == -1) {
                this.f2544th[i3] = (short) i;
                this.f2543tg[i] = (short) i3;
                return;
            }
            i3 = this.f2544th[i3];
        }
    }

    private void m2072ay(int i) {
        if (this.f2544th[i] != -1) {
            this.f2543tg[this.f2544th[i]] = this.f2543tg[i];
        }
        if (this.f2557tu == i) {
            this.f2557tu = this.f2544th[i];
        } else if (this.f2543tg[i] != -1) {
            this.f2544th[this.f2543tg[i]] = this.f2544th[i];
        }
        this.f2543tg[i] = -1;
        this.f2544th[i] = -1;
    }

    final void m2073a(int i, int i2, int i3, int i4, int i5) {
        int i6;
        int i7 = 0;
        int i8 = this.f2551to;
        int i9 = this.f2552tp;
        boolean z = this.f2558tv;
        GLLib.m455bb();
        for (int i10 = 0; i10 < C0338r.f2470rl; i10++) {
            this.f2542tf[i10] = -1;
            this.f2543tg[i10] = -1;
            this.f2544th[i10] = -1;
            this.f2545ti[i10] = 0;
            this.f2546tj[i10] = 0;
            this.f2555ts[i10] = 0;
        }
        this.f2557tu = -1;
        int i11 = (i2 * i8) + i;
        while (i11 != -1) {
            m2072ay(i11);
            short s = this.f2545ti[i11];
            this.f2545ti[i11] = -1;
            this.f2546tj[i11] = -1;
            int i12 = i11 % i8;
            int i13 = i11 / i8;
            if (i12 == i4 && i13 == i5) {
                break;
            }
            int i14 = 0;
            while (i14 < this.f2550tn) {
                int i15 = i12 + f2541te[i14 << 1];
                int i16 = i13 + f2541te[(i14 << 1) + 1];
                if (i15 >= 0 && i15 < i8 && i16 >= 0 && i16 < i9) {
                    int i17 = (i16 * i8) + i15;
                    if (this.f2545ti[i17] != -1) {
                        int i18 = this.f2547tk;
                        if (i14 >= 4) {
                            i18 = this.f2548tl;
                            int i19 = i11 % i8;
                            int i20 = i11 / i8;
                            if (i14 != 4) {
                            }
                        }
                        if ((this.f2553tq[(this.f2551to * i16) + i15] & this.f2554tr) == 0) {
                            int i21 = (i7 == i14 ? 0 : this.f2549tm) + i18 + s;
                            int abs = Math.abs(i15 - i4);
                            int abs2 = Math.abs(i16 - i5);
                            int i22 = this.f2550tn == 4 ? (abs + abs2) * this.f2547tk : abs > abs2 ? ((abs - abs2) * this.f2547tk) + (this.f2548tl * abs2) : ((abs2 - abs) * this.f2547tk) + (this.f2548tl * abs);
                            if (this.f2543tg[i17] == -1 && this.f2544th[i17] == -1 && this.f2557tu != i17) {
                                this.f2542tf[i17] = (short) i11;
                                this.f2545ti[i17] = (short) i21;
                                this.f2546tj[i17] = (short) i22;
                                m2071ax(i17);
                            } else if (this.f2545ti[i17] > i21) {
                                this.f2542tf[i17] = (short) i11;
                                this.f2545ti[i17] = (short) i21;
                                m2072ay(i17);
                                m2071ax(i17);
                            }
                        }
                    }
                }
                i14++;
            }
            i11 = this.f2557tu;
            if (i11 != -1) {
                short s2 = this.f2542tf[i11];
                if (i11 % i8 != s2 % i8) {
                    i7 = i11 % i8 > s2 % i8 ? 3 : 2;
                } else if (i11 / i8 != s2 / i8) {
                    i7 = 1;
                } else {
                    i6 = 0;
                }
            } else {
                i6 = i7;
            }
            i7 = i6;
        }
        if (i11 == -1) {
            this.f2556tt = -1;
            return;
        }
        this.f2556tt = 0;
        int i23 = i11;
        while (i23 != -1) {
            short[] sArr = this.f2555ts;
            int i24 = this.f2556tt;
            this.f2556tt = i24 + 1;
            sArr[i24] = (short) ((i23 % i8) + ((i23 / i8) * this.f2551to));
            i23 = this.f2542tf[i23];
        }
        this.f2556tt--;
    }

    public final void m2074a(int i, int i2, byte[] bArr, int i3, int i4, int i5, int i6) {
        GLLib.m455bb();
        this.f2551to = 96;
        this.f2552tp = 96;
        this.f2553tq = bArr;
        this.f2554tr = -1;
        this.f2547tk = 14;
        this.f2548tl = 10;
        this.f2549tm = 10;
        this.f2550tn = 8;
        this.f2542tf = new short[C0338r.f2470rl];
        this.f2543tg = new short[C0338r.f2470rl];
        this.f2544th = new short[C0338r.f2470rl];
        this.f2545ti = new short[C0338r.f2470rl];
        this.f2546tj = new short[C0338r.f2470rl];
        this.f2557tu = -1;
        this.f2555ts = new short[C0338r.f2470rl];
        this.f2556tt = -1;
        this.f2558tv = true;
    }

    final int m2075av(int i) {
        boolean z = this.f2558tv;
        GLLib.m455bb();
        return this.f2555ts[i] % this.f2551to;
    }

    final int m2076aw(int i) {
        boolean z = this.f2558tv;
        GLLib.m455bb();
        return this.f2555ts[i] / this.f2551to;
    }

    final int m2077bK() {
        boolean z = this.f2558tv;
        GLLib.m455bb();
        return this.f2556tt + 1;
    }
}
