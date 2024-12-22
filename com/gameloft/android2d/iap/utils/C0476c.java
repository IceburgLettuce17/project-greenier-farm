package com.gameloft.android2d.iap.utils;

public class C0476c {
    private static boolean $assertionsDisabled;
    private final char[] adL = "0123456789ABCDEFGHJKMNPQRSTVWXYZ".toCharArray();

    static {
        $assertionsDisabled = !C0476c.class.desiredAssertionStatus();
    }

    public final char[] m2585f(byte[] bArr) {
        if (!$assertionsDisabled && bArr == null) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && bArr.length > 1342177271) {
            throw new AssertionError();
        }
        char[] cArr = new char[((bArr.length + 4) / 5) << 3];
        int i = 0;
        int i2 = 0;
        while (i + 4 < bArr.length) {
            long j = ((bArr[i] & 255) << 32) | ((bArr[i + 1] & 255) << 24) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 8) | (bArr[i + 4] & 255);
            cArr[i2] = this.adL[((int) (j >> 35)) & 31];
            cArr[i2 + 1] = this.adL[((int) (j >> 30)) & 31];
            cArr[i2 + 2] = this.adL[((int) (j >> 25)) & 31];
            cArr[i2 + 3] = this.adL[((int) (j >> 20)) & 31];
            cArr[i2 + 4] = this.adL[((int) (j >> 15)) & 31];
            cArr[i2 + 5] = this.adL[((int) (j >> 10)) & 31];
            cArr[i2 + 6] = this.adL[((int) (j >> 5)) & 31];
            cArr[i2 + 7] = this.adL[((int) j) & 31];
            i += 5;
            i2 += 8;
        }
        if (i + 4 == bArr.length) {
            long j2 = ((bArr[i] & 255) << 32) | ((bArr[i + 1] & 255) << 24) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 8);
            cArr[i2] = this.adL[((int) (j2 >> 35)) & 31];
            cArr[i2 + 1] = this.adL[((int) (j2 >> 30)) & 31];
            cArr[i2 + 2] = this.adL[((int) (j2 >> 25)) & 31];
            cArr[i2 + 3] = this.adL[((int) (j2 >> 20)) & 31];
            cArr[i2 + 4] = this.adL[((int) (j2 >> 15)) & 31];
            cArr[i2 + 5] = this.adL[((int) (j2 >> 10)) & 31];
            cArr[i2 + 6] = this.adL[((int) (j2 >> 5)) & 31];
            cArr[i2 + 7] = '=';
        } else if (i + 3 == bArr.length) {
            long j3 = ((bArr[i] & 255) << 32) | ((bArr[i + 1] & 255) << 24) | ((bArr[i + 2] & 255) << 16);
            cArr[i2] = this.adL[((int) (j3 >> 35)) & 31];
            cArr[i2 + 1] = this.adL[((int) (j3 >> 30)) & 31];
            cArr[i2 + 2] = this.adL[((int) (j3 >> 25)) & 31];
            cArr[i2 + 3] = this.adL[((int) (j3 >> 20)) & 31];
            cArr[i2 + 4] = this.adL[((int) (j3 >> 15)) & 31];
            cArr[i2 + 5] = '=';
            cArr[i2 + 6] = '=';
            cArr[i2 + 7] = '=';
        } else if (i + 2 == bArr.length) {
            long j4 = ((bArr[i] & 255) << 32) | ((bArr[i + 1] & 255) << 24);
            cArr[i2] = this.adL[((int) (j4 >> 35)) & 31];
            cArr[i2 + 1] = this.adL[((int) (j4 >> 30)) & 31];
            cArr[i2 + 2] = this.adL[((int) (j4 >> 25)) & 31];
            cArr[i2 + 3] = this.adL[((int) (j4 >> 20)) & 31];
            cArr[i2 + 4] = '=';
            cArr[i2 + 5] = '=';
            cArr[i2 + 6] = '=';
            cArr[i2 + 7] = '=';
        } else if (i + 1 == bArr.length) {
            long j5 = (bArr[i] & 255) << 32;
            cArr[i2] = this.adL[((int) (j5 >> 35)) & 31];
            cArr[i2 + 1] = this.adL[((int) (j5 >> 30)) & 31];
            cArr[i2 + 2] = '=';
            cArr[i2 + 3] = '=';
            cArr[i2 + 4] = '=';
            cArr[i2 + 5] = '=';
            cArr[i2 + 6] = '=';
            cArr[i2 + 7] = '=';
        }
        return cArr;
    }
}
