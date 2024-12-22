package com.gameloft.android.LATAM.GloftGF2H;

import java.io.IOException;

final class C0346z {

    private static final int[] f2677vA = {3, 4, 5, 6, 7, 8, 9, 10, 523, 525, 527, 529, 1043, 1047, 1051, 1055, 1571, 1579, 1587, 1595, 2115, 2131, 2147, 2163, 2691, 2723, 2755, 2787, 258};

    private static final int[] f2678vB = {1, 2, 3, 4, 65541, 65543, 131081, 131085, 196625, 196633, 262177, 262193, 327745, 327777, 393345, 393409, 459009, 459137, 524801, 525057, 590849, 591361, 657409, 658433, 724993, 727041, 794625, 798721, 868353, 876545};

    static final int[] f2679vC;

    static final int[] f2680vD;

    static final byte[] f2681vE;

    private static final char[] f2682vF;

    private static final byte[] f2683vG;

    static {
        char[] cArr = new char[288];
        int i = 0;
        while (i < 144) {
            cArr[i] = '\b';
            i++;
        }
        while (i < 256) {
            cArr[i] = '\t';
            i++;
        }
        while (i < 280) {
            cArr[i] = 7;
            i++;
        }
        while (i < cArr.length) {
            cArr[i] = '\b';
            i++;
        }
        f2679vC = m2163a(9, cArr);
        char[] cArr2 = new char[30];
        for (int i2 = 0; i2 < cArr2.length; i2++) {
            cArr2[i2] = 5;
        }
        f2680vD = m2163a(5, cArr2);
        f2681vE = new byte[]{16, 17, 18, 0, 8, 7, 9, 6, 10, 5, 11, 4, 12, 3, 13, 2, 14, 1, 15};
        f2682vF = new char[287];
        int i3 = 0;
        while (i3 < 144) {
            f2682vF[i3] = m2158E(i3 + 48, 8);
            i3++;
        }
        while (i3 < 256) {
            f2682vF[i3] = m2158E((i3 - 144) + 400, 9);
            i3++;
        }
        while (i3 < 280) {
            f2682vF[i3] = m2158E((i3 - 256) + 0, 7);
            i3++;
        }
        while (i3 < 287) {
            f2682vF[i3] = m2158E((i3 - 280) + 192, 8);
            i3++;
        }
        f2683vG = new byte[30];
        for (int i4 = 0; i4 < f2683vG.length; i4++) {
            f2683vG[i4] = (byte) m2157D(i4, 5);
        }
    }

    private static int m2157D(int i, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 <<= 1;
            if (((1 << i4) & i) != 0) {
                i3 |= 1;
            }
        }
        return i3;
    }

    private static char m2158E(int i, int i2) {
        return (char) (m2157D(i, i2) | (i2 << 9));
    }

    static int m2159a(int i, C0318br c0318br) {
        int i2 = f2677vA[i - 257];
        int i3 = i2 & 511;
        int i4 = i2 >>> 9;
        return i4 > 0 ? i3 + c0318br.m901bh(i4) : i3;
    }

    private static int m2160a(int i, int[] iArr, int i2) {
        int i3 = 0;
        int length = iArr.length;
        while (i3 < length) {
            int i4 = ((i3 + length) + 1) / 2;
            int i5 = iArr[i4] & i2;
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i4 - 1;
            } else {
                i3 = i4;
            }
        }
        return i3;
    }

    static int m2161a(C0318br c0318br, int[] iArr) {
        int i = 0;
        do {
            i = (iArr[i] >>> (c0318br.m901bh(1) == 0 ? 16 : 0)) & 65535;
            int i2 = i >= 32768 ? i - 32768 : -1;
            if (i2 >= 0) {
                return i2;
            }
        } while (i > 0);
        throw new IOException("code not found");
    }

    static char[] m2162a(C0318br c0318br, int[] iArr, int i) {
        int m901bh;
        char c;
        char[] cArr = new char[i];
        int i2 = 0;
        while (i2 < cArr.length) {
            int m2161a = m2161a(c0318br, iArr);
            switch (m2161a) {
                case 16:
                    c = cArr[i2 - 1];
                    m901bh = c0318br.m901bh(2) + 3;
                    break;
                case 17:
                    m901bh = c0318br.m901bh(3) + 3;
                    c = 0;
                    break;
                case 18:
                    m901bh = c0318br.m901bh(3) + 11;
                    c = 0;
                    break;
                default:
                    cArr[i2] = (char) m2161a;
                    i2++;
                    continue;
            }
            while (m901bh > 0 && i2 < cArr.length) {
                cArr[i2] = c;
                m901bh--;
                i2++;
            }
        }
        return cArr;
    }

    public static int[] m2163a(int i, char[] cArr) {
        if (cArr.length > 32767) {
            throw new RuntimeException(new StringBuffer("Too many leaves: ").append(cArr.length).toString());
        }
        char[] cArr2 = new char[i + 1];
        for (char c : cArr) {
            if (c > 0) {
                cArr2[c] = (char) (cArr2[c] + 1);
            }
        }
        char[] cArr3 = new char[cArr2.length + 1];
        char c2 = 0;
        for (int i2 = 1; i2 <= cArr2.length; i2++) {
            c2 = (char) ((c2 + cArr2[i2 - 1]) << 1);
            cArr3[i2] = c2;
        }
        int[] iArr = new int[Math.min((1 << (i + 1)) - 1, (cArr.length * i) + 1)];
        int i3 = 1;
        for (int i4 = 0; i4 < cArr.length; i4++) {
            char c3 = cArr[i4];
            if (c3 > 0) {
                char c4 = cArr3[c3];
                if (c4 > (1 << c3) - 1) {
                    throw new RuntimeException("Invalid symbol");
                }
                cArr3[c3] = (char) (cArr3[c3] + 1);
                i3 = m2165b(iArr, i3, c4, c3, i4);
            }
        }
        if (i3 / iArr.length >= 0.8d) {
            return iArr;
        }
        int[] iArr2 = new int[i3];
        System.arraycopy(iArr, 0, iArr2, 0, i3);
        return iArr2;
    }

    static int m2164b(int i, C0318br c0318br) {
        int i2 = f2678vB[i];
        int i3 = 65535 & i2;
        int i4 = i2 >>> 16;
        return i4 > 0 ? i3 + c0318br.m901bh(i4) : i3;
    }

    private static int m2165b(int[] iArr, int i, int i2, int i3, int i4) {
        int i5 = 0;
        int i6 = i;
        while (true) {
            int i7 = i3 - 1;
            if (i3 <= 0) {
                return i6;
            }
            int i8 = ((1 << i7) & i2) == 0 ? 16 : 0;
            int i9 = (iArr[i5] >>> i8) & 65535;
            if (i9 == 0) {
                if (i6 >= 32768) {
                    throw new RuntimeException(new StringBuffer("Too many nodes: ").append(i6).toString());
                }
                if (i7 > 0) {
                    iArr[i5] = (i6 << i8) | iArr[i5];
                    i5 = i6;
                    i3 = i7;
                    i6++;
                } else {
                    iArr[i5] = ((i4 + 32768) << i8) | iArr[i5];
                    i3 = i7;
                }
            } else {
                if (i9 >= 32768) {
                    throw new RuntimeException("Invalid tree");
                }
                i5 = i9;
                i3 = i7;
            }
        }
    }

    static void m2166c(int i, C0318br c0318br) {
        char c = f2682vF[i];
        c0318br.m898L(c & 511, c >>> '\t');
    }

    static void m2167d(int i, C0318br c0318br) {
        int m2160a = m2160a(i, f2677vA, 511);
        char c = f2682vF[m2160a + 257];
        c0318br.m898L(c & 511, c >>> '\t');
        int i2 = f2677vA[m2160a];
        int i3 = i2 >>> 9;
        if (i3 > 0) {
            c0318br.m898L(i - (i2 & 511), i3);
        }
    }

    static void m2168e(int i, C0318br c0318br) {
        int m2160a = m2160a(i, f2678vB, 65535);
        c0318br.m898L(f2683vG[m2160a], 5);
        int i2 = f2678vB[m2160a];
        int i3 = i2 >>> 16;
        if (i3 > 0) {
            c0318br.m898L(i - (i2 & 65535), i3);
        }
    }
}
