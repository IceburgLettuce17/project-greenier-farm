package com.gameloft.android2d.iap.p042a.p047e.p048a;

public class C0368a {
    private static boolean $assertionsDisabled;
    private static final byte[] abW;
    private static final byte[] abX;

    static {
        $assertionsDisabled = !C0368a.class.desiredAssertionStatus();
        abW = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        byte[] bArr = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
        abX = new byte[]{-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9};
        byte[] bArr2 = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9};
    }

    private C0368a() {
    }

    private static int m2301a(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3) {
        if (bArr[2] == 61) {
            bArr2[i2] = (byte) ((((bArr3[bArr[0]] << 24) >>> 6) | ((bArr3[bArr[1]] << 24) >>> 12)) >>> 16);
            return 1;
        }
        if (bArr[3] == 61) {
            int i3 = ((bArr3[bArr[1]] << 24) >>> 12) | ((bArr3[bArr[0]] << 24) >>> 6) | ((bArr3[bArr[2]] << 24) >>> 18);
            bArr2[i2] = (byte) (i3 >>> 16);
            bArr2[i2 + 1] = (byte) (i3 >>> 8);
            return 2;
        }
        int i4 = ((bArr3[bArr[1]] << 24) >>> 12) | ((bArr3[bArr[0]] << 24) >>> 6) | ((bArr3[bArr[2]] << 24) >>> 18) | ((bArr3[bArr[3]] << 24) >>> 24);
        bArr2[i2] = (byte) (i4 >> 16);
        bArr2[i2 + 1] = (byte) (i4 >> 8);
        bArr2[i2 + 2] = (byte) i4;
        return 3;
    }

    public static byte[] m2302bf(String str) {
        int i;
        int i2;
        byte[] bytes = str.getBytes();
        int length = bytes.length;
        byte[] bArr = abX;
        byte[] bArr2 = new byte[((length * 3) / 4) + 2];
        byte[] bArr3 = new byte[4];
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            }
            byte b2 = (byte) (bytes[i3 + 0] & Byte.MAX_VALUE);
            byte b3 = bArr[b2];
            if (b3 < -5) {
                throw new C0369b("Bad Base64 input character at " + i3 + ": " + ((int) bytes[0 + i3]) + "(decimal)");
            }
            if (b3 < -1) {
                i = i4;
                i2 = i5;
            } else if (b2 == 61) {
                int i6 = length - i3;
                byte b4 = (byte) (bytes[(length - 1) + 0] & Byte.MAX_VALUE);
                if (i4 == 0 || i4 == 1) {
                    throw new C0369b("invalid padding byte '=' at byte offset " + i3);
                }
                if ((i4 == 3 && i6 > 2) || (i4 == 4 && i6 > 1)) {
                    throw new C0369b("padding byte '=' falsely signals end of encoded value at offset " + i3);
                }
                if (b4 != 61 && b4 != 10) {
                    throw new C0369b("encoded value has invalid trailing byte");
                }
            } else {
                i = i4 + 1;
                bArr3[i4] = b2;
                if (i == 4) {
                    i2 = m2301a(bArr3, 0, bArr2, i5, bArr) + i5;
                    i = 0;
                } else {
                    i2 = i5;
                }
            }
            i3++;
            i5 = i2;
            i4 = i;
        }
        if (i4 != 0) {
            if (i4 == 1) {
                throw new C0369b("single trailing character at offset " + (length - 1));
            }
            bArr3[i4] = 61;
            i5 += m2301a(bArr3, 0, bArr2, i5, bArr);
        }
        byte[] bArr4 = new byte[i5];
        System.arraycopy(bArr2, 0, bArr4, 0, i5);
        return bArr4;
    }

    public static String m2303e(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = abW;
        int i = ((length + 2) / 3) << 2;
        byte[] bArr3 = new byte[i + (i / Integer.MAX_VALUE)];
        int i2 = length - 2;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i5 < i2) {
            int i6 = ((bArr[i5 + 0] << 24) >>> 8) | ((bArr[(i5 + 1) + 0] << 24) >>> 16) | ((bArr[(i5 + 2) + 0] << 24) >>> 24);
            bArr3[i4] = bArr2[i6 >>> 18];
            bArr3[i4 + 1] = bArr2[(i6 >>> 12) & 63];
            bArr3[i4 + 2] = bArr2[(i6 >>> 6) & 63];
            bArr3[i4 + 3] = bArr2[i6 & 63];
            int i7 = i3 + 4;
            if (i7 == Integer.MAX_VALUE) {
                bArr3[i4 + 4] = 10;
                i4++;
                i7 = 0;
            }
            i5 += 3;
            i4 += 4;
            i3 = i7;
        }
        if (i5 < length) {
            int i8 = i5 + 0;
            int i9 = length - i5;
            int i10 = (i9 > 2 ? (bArr[i8 + 2] << 24) >>> 24 : 0) | (i9 > 0 ? (bArr[i8] << 24) >>> 8 : 0) | (i9 > 1 ? (bArr[i8 + 1] << 24) >>> 16 : 0);
            switch (i9) {
                case 1:
                    bArr3[i4] = bArr2[i10 >>> 18];
                    bArr3[i4 + 1] = bArr2[(i10 >>> 12) & 63];
                    bArr3[i4 + 2] = 61;
                    bArr3[i4 + 3] = 61;
                    break;
                case 2:
                    bArr3[i4] = bArr2[i10 >>> 18];
                    bArr3[i4 + 1] = bArr2[(i10 >>> 12) & 63];
                    bArr3[i4 + 2] = bArr2[(i10 >>> 6) & 63];
                    bArr3[i4 + 3] = 61;
                    break;
                case 3:
                    bArr3[i4] = bArr2[i10 >>> 18];
                    bArr3[i4 + 1] = bArr2[(i10 >>> 12) & 63];
                    bArr3[i4 + 2] = bArr2[(i10 >>> 6) & 63];
                    bArr3[i4 + 3] = bArr2[i10 & 63];
                    break;
            }
            if (i3 + 4 == Integer.MAX_VALUE) {
                bArr3[i4 + 4] = 10;
                i4++;
            }
            i4 += 4;
        }
        if ($assertionsDisabled || i4 == bArr3.length) {
            return new String(bArr3, 0, bArr3.length);
        }
        throw new AssertionError();
    }
}
