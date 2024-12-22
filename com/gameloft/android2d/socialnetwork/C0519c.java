package com.gameloft.android2d.socialnetwork;

final class C0519c extends AbstractC0518b {
    private static boolean $assertionsDisabled;
    private static final byte[] afk;
    private static final byte[] afl;
    private final byte[] afm;
    private int afn;
    public final boolean afo;
    public final boolean afp;
    public final boolean afq;
    private final byte[] afr;
    private int count;

    static {
        $assertionsDisabled = !C0493a.class.desiredAssertionStatus();
        afk = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        afl = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
    }

    public C0519c(int i, byte[] bArr) {
        this.afi = null;
        this.afo = (i & 1) == 0;
        this.afp = (i & 2) == 0;
        this.afq = (i & 4) != 0;
        this.afr = (i & 8) == 0 ? afk : afl;
        this.afm = new byte[2];
        this.afn = 0;
        this.count = this.afp ? 19 : -1;
    }

    public final boolean m2773a(byte[] bArr, int i, int i2, boolean z) {
        int i3;
        int i4;
        int i5;
        int i6;
        byte b2;
        int i7;
        byte b3;
        int i8;
        byte b4;
        int i9;
        int i10;
        byte[] bArr2 = this.afr;
        byte[] bArr3 = this.afi;
        int i11 = 0;
        int i12 = this.count;
        int i13 = i2 + i;
        switch (this.afn) {
            case 0:
                i4 = -1;
                i3 = i;
                break;
            case 1:
                if (i + 2 <= i13) {
                    int i14 = i + 1;
                    int i15 = ((this.afm[0] & 255) << 16) | ((bArr[i] & 255) << 8) | (bArr[i14] & 255);
                    this.afn = 0;
                    i4 = i15;
                    i3 = i14 + 1;
                    break;
                }
                i4 = -1;
                i3 = i;
                break;
            case 2:
                if (i + 1 <= i13) {
                    i3 = i + 1;
                    int i16 = ((this.afm[0] & 255) << 16) | ((this.afm[1] & 255) << 8) | (bArr[i] & 255);
                    this.afn = 0;
                    i4 = i16;
                    break;
                }
                i4 = -1;
                i3 = i;
                break;
            default:
                i4 = -1;
                i3 = i;
                break;
        }
        if (i4 != -1) {
            bArr3[0] = bArr2[(i4 >> 18) & 63];
            bArr3[1] = bArr2[(i4 >> 12) & 63];
            bArr3[2] = bArr2[(i4 >> 6) & 63];
            int i17 = 4;
            bArr3[3] = bArr2[i4 & 63];
            int i18 = i12 - 1;
            if (i18 == 0) {
                if (this.afq) {
                    i17 = 5;
                    bArr3[4] = 13;
                }
                i11 = i17 + 1;
                bArr3[i17] = 10;
                i5 = 19;
            } else {
                i5 = i18;
                i11 = 4;
            }
        } else {
            i5 = i12;
        }
        while (i3 + 3 <= i13) {
            int i19 = ((bArr[i3] & 255) << 16) | ((bArr[i3 + 1] & 255) << 8) | (bArr[i3 + 2] & 255);
            bArr3[i11] = bArr2[(i19 >> 18) & 63];
            bArr3[i11 + 1] = bArr2[(i19 >> 12) & 63];
            bArr3[i11 + 2] = bArr2[(i19 >> 6) & 63];
            bArr3[i11 + 3] = bArr2[i19 & 63];
            int i20 = i3 + 3;
            int i21 = i11 + 4;
            int i22 = i5 - 1;
            if (i22 == 0) {
                if (this.afq) {
                    i10 = i21 + 1;
                    bArr3[i21] = 13;
                } else {
                    i10 = i21;
                }
                i11 = i10 + 1;
                bArr3[i10] = 10;
                i3 = i20;
                i5 = 19;
            } else {
                i5 = i22;
                i11 = i21;
                i3 = i20;
            }
        }
        if (i3 - this.afn == i13 - 1) {
            if (this.afn > 0) {
                i9 = 1;
                b4 = this.afm[0];
            } else {
                b4 = bArr[i3];
                i3++;
                i9 = 0;
            }
            int i23 = (b4 & 255) << 4;
            this.afn -= i9;
            int i24 = i11 + 1;
            bArr3[i11] = bArr2[(i23 >> 6) & 63];
            int i25 = i24 + 1;
            bArr3[i24] = bArr2[i23 & 63];
            if (this.afo) {
                int i26 = i25 + 1;
                bArr3[i25] = 61;
                i25 = i26 + 1;
                bArr3[i26] = 61;
            }
            if (this.afp) {
                if (this.afq) {
                    bArr3[i25] = 13;
                    i25++;
                }
                bArr3[i25] = 10;
                i25++;
            }
            i11 = i25;
        } else if (i3 - this.afn == i13 - 2) {
            if (this.afn > 1) {
                i7 = 1;
                b2 = this.afm[0];
            } else {
                b2 = bArr[i3];
                i3++;
                i7 = 0;
            }
            int i27 = (b2 & 255) << 10;
            if (this.afn > 0) {
                b3 = this.afm[i7];
                i7++;
            } else {
                b3 = bArr[i3];
                i3++;
            }
            int i28 = ((b3 & 255) << 2) | i27;
            this.afn -= i7;
            int i29 = i11 + 1;
            bArr3[i11] = bArr2[(i28 >> 12) & 63];
            int i30 = i29 + 1;
            bArr3[i29] = bArr2[(i28 >> 6) & 63];
            int i31 = i30 + 1;
            bArr3[i30] = bArr2[i28 & 63];
            if (this.afo) {
                i8 = i31 + 1;
                bArr3[i31] = 61;
            } else {
                i8 = i31;
            }
            if (this.afp) {
                if (this.afq) {
                    bArr3[i8] = 13;
                    i8++;
                }
                bArr3[i8] = 10;
                i8++;
            }
            i11 = i8;
        } else if (this.afp && i11 > 0 && i5 != 19) {
            if (this.afq) {
                i6 = i11 + 1;
                bArr3[i11] = 13;
            } else {
                i6 = i11;
            }
            i11 = i6 + 1;
            bArr3[i6] = 10;
        }
        if (!$assertionsDisabled && this.afn != 0) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && i3 != i13) {
            throw new AssertionError();
        }
        this.afj = i11;
        this.count = i5;
        return true;
    }
}
