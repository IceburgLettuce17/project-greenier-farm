package com.gameloft.android.LATAM.GloftGF2H.p041a;

public final class C0272a {

    private static final char[] f487uQ;

    private static final byte[] f488uR;

    static {
        System.getProperty("line.separator");
        f487uQ = new char[64];
        char c = 'A';
        int i = 0;
        while (c <= 'Z') {
            f487uQ[i] = c;
            c = (char) (c + 1);
            i++;
        }
        char c2 = 'a';
        while (c2 <= 'z') {
            f487uQ[i] = c2;
            c2 = (char) (c2 + 1);
            i++;
        }
        char c3 = '0';
        while (c3 <= '9') {
            f487uQ[i] = c3;
            c3 = (char) (c3 + 1);
            i++;
        }
        f487uQ[i] = '+';
        f487uQ[i + 1] = '/';
        f488uR = new byte[128];
        for (int i2 = 0; i2 < f488uR.length; i2++) {
            f488uR[i2] = -1;
        }
        for (int i3 = 0; i3 < 64; i3++) {
            f488uR[f487uQ[i3]] = (byte) i3;
        }
    }

    public static byte[] m674S(String str) {
        char c;
        int i;
        char c2;
        int i2;
        int i3;
        int i4 = 0;
        char[] cArr = new char[str.length()];
        int i5 = 0;
        for (int i6 = 0; i6 < str.length(); i6++) {
            char charAt = str.charAt(i6);
            if (charAt != ' ' && charAt != '\r' && charAt != '\n' && charAt != '\t') {
                cArr[i5] = charAt;
                i5++;
            }
        }
        if (i5 % 4 != 0) {
            throw new IllegalArgumentException("Length of Base64 encoded input string is not a multiple of 4.");
        }
        while (i5 > 0 && cArr[(i5 + 0) - 1] == '=') {
            i5--;
        }
        int i7 = (i5 * 3) / 4;
        byte[] bArr = new byte[i7];
        int i8 = i5 + 0;
        int i9 = 0;
        while (i4 < i8) {
            int i10 = i4 + 1;
            char c3 = cArr[i4];
            int i11 = i10 + 1;
            char c4 = cArr[i10];
            if (i11 < i8) {
                c = cArr[i11];
                i11++;
            } else {
                c = 'A';
            }
            if (i11 < i8) {
                int i12 = i11 + 1;
                c2 = cArr[i11];
                i = i12;
            } else {
                i = i11;
                c2 = 'A';
            }
            if (c3 > 127 || c4 > 127 || c > 127 || c2 > 127) {
                throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
            }
            byte b2 = f488uR[c3];
            byte b3 = f488uR[c4];
            byte b4 = f488uR[c];
            byte b5 = f488uR[c2];
            if (b2 < 0 || b3 < 0 || b4 < 0 || b5 < 0) {
                throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
            }
            int i13 = (b2 << 2) | (b3 >>> 4);
            int i14 = ((b3 & 15) << 4) | (b4 >>> 2);
            int i15 = ((b4 & 3) << 6) | b5;
            int i16 = i9 + 1;
            bArr[i9] = (byte) i13;
            if (i16 < i7) {
                i2 = i16 + 1;
                bArr[i16] = (byte) i14;
            } else {
                i2 = i16;
            }
            if (i2 < i7) {
                i3 = i2 + 1;
                bArr[i2] = (byte) i15;
            } else {
                i3 = i2;
            }
            i9 = i3;
            i4 = i;
        }
        return bArr;
    }

    public static char[] m675c(byte[] bArr) {
        int i;
        int i2;
        int length = bArr.length;
        int i3 = ((length << 2) + 2) / 3;
        char[] cArr = new char[((length + 2) / 3) << 2];
        int i4 = length + 0;
        int i5 = 0;
        int i6 = 0;
        while (i6 < i4) {
            int i7 = i6 + 1;
            int i8 = bArr[i6] & 255;
            if (i7 < i4) {
                i = bArr[i7] & 255;
                i7++;
            } else {
                i = 0;
            }
            if (i7 < i4) {
                i6 = i7 + 1;
                i2 = bArr[i7] & 255;
            } else {
                i6 = i7;
                i2 = 0;
            }
            int i9 = i8 >>> 2;
            int i10 = ((i8 & 3) << 4) | (i >>> 4);
            int i11 = ((i & 15) << 2) | (i2 >>> 6);
            int i12 = i2 & 63;
            int i13 = i5 + 1;
            cArr[i5] = f487uQ[i9];
            int i14 = i13 + 1;
            cArr[i13] = f487uQ[i10];
            cArr[i14] = i14 < i3 ? f487uQ[i11] : '=';
            int i15 = i14 + 1;
            cArr[i15] = i15 < i3 ? f487uQ[i12] : '=';
            i5 = i15 + 1;
        }
        return cArr;
    }
}
