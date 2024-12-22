package com.gameloft.android.wrapper;

public final class C0348b {

    private static final char[] f2685uQ;

    private static final byte[] f2686uR;

    static {
        System.getProperty("line.separator");
        f2685uQ = new char[64];
        char c = 'A';
        int i = 0;
        while (c <= 'Z') {
            f2685uQ[i] = c;
            c = (char) (c + 1);
            i++;
        }
        char c2 = 'a';
        while (c2 <= 'z') {
            f2685uQ[i] = c2;
            c2 = (char) (c2 + 1);
            i++;
        }
        char c3 = '0';
        while (c3 <= '9') {
            f2685uQ[i] = c3;
            c3 = (char) (c3 + 1);
            i++;
        }
        f2685uQ[i] = '+';
        f2685uQ[i + 1] = '/';
        f2686uR = new byte[128];
        for (int i2 = 0; i2 < f2686uR.length; i2++) {
            f2686uR[i2] = -1;
        }
        for (int i3 = 0; i3 < 64; i3++) {
            f2686uR[f2685uQ[i3]] = (byte) i3;
        }
    }

    public static byte[] m2170S(String str) {
        char[] cArr = new char[str.length()];
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (charAt != ' ' && charAt != '\r' && charAt != '\n' && charAt != '\t') {
                cArr[i] = charAt;
                i++;
            }
        }
        return m2171a(cArr, 0, i);
    }

    private static byte[] m2171a(char[] cArr, int i, int i2) {
        char c;
        int i3;
        char c2;
        int i4;
        int i5;
        int i6 = 0;
        if (i2 % 4 != 0) {
            throw new IllegalArgumentException("Length of Base64 encoded input string is not a multiple of 4.");
        }
        while (i2 > 0 && cArr[(i2 + 0) - 1] == '=') {
            i2--;
        }
        int i7 = (i2 * 3) / 4;
        byte[] bArr = new byte[i7];
        int i8 = i2 + 0;
        int i9 = 0;
        while (i6 < i8) {
            int i10 = i6 + 1;
            char c3 = cArr[i6];
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
                i3 = i12;
            } else {
                i3 = i11;
                c2 = 'A';
            }
            if (c3 > 127 || c4 > 127 || c > 127 || c2 > 127) {
                throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
            }
            byte b2 = f2686uR[c3];
            byte b3 = f2686uR[c4];
            byte b4 = f2686uR[c];
            byte b5 = f2686uR[c2];
            if (b2 < 0 || b3 < 0 || b4 < 0 || b5 < 0) {
                throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
            }
            int i13 = (b2 << 2) | (b3 >>> 4);
            int i14 = ((b3 & 15) << 4) | (b4 >>> 2);
            int i15 = ((b4 & 3) << 6) | b5;
            int i16 = i9 + 1;
            bArr[i9] = (byte) i13;
            if (i16 < i7) {
                i4 = i16 + 1;
                bArr[i16] = (byte) i14;
            } else {
                i4 = i16;
            }
            if (i4 < i7) {
                i5 = i4 + 1;
                bArr[i4] = (byte) i15;
            } else {
                i5 = i4;
            }
            i9 = i5;
            i6 = i3;
        }
        return bArr;
    }

    public static byte[] m2172bf(String str) {
        char[] charArray = str.toCharArray();
        return m2171a(charArray, 0, charArray.length);
    }

    public static char[] m2173c(byte[] bArr) {
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
            cArr[i5] = f2685uQ[i9];
            int i14 = i13 + 1;
            cArr[i13] = f2685uQ[i10];
            cArr[i14] = i14 < i3 ? f2685uQ[i11] : '=';
            int i15 = i14 + 1;
            cArr[i15] = i15 < i3 ? f2685uQ[i12] : '=';
            i5 = i15 + 1;
        }
        return cArr;
    }
}
