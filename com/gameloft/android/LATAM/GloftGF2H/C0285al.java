package com.gameloft.android.LATAM.GloftGF2H;

final class C0285al {

    short[] f506vW = new short[2729];

    int[] f507vX = new int[2048];

    int[] f508vY = new int[2048];

    int f509vZ;

    C0285al(int i) {
        reset();
    }

    int m707aS(int i) {
        int abs = Math.abs((((((((i & 255) + 31) * 31) + ((i >>> 8) & 255)) * 31) + ((i >>> 16) & 255)) * 31) + (i >>> 24)) % this.f506vW.length;
        int i2 = 1;
        while (true) {
            short s = this.f506vW[abs];
            if (s < 0 || this.f507vX[s] == i) {
                break;
            }
            abs = Math.abs(abs + (i2 * i2)) % this.f506vW.length;
            i2++;
        }
        return abs;
    }

    final void reset() {
        for (int i = 0; i < this.f506vW.length; i++) {
            this.f506vW[i] = -1;
        }
        this.f509vZ = 0;
    }
}
