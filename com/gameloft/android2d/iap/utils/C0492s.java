package com.gameloft.android2d.iap.utils;

import com.gameloft.android2d.iap.InterfaceC0357a;

public final class C0492s implements InterfaceC0357a {

    private static char[] f2883kz = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String m2698a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer(bArr.length << 1);
        for (int i = 0; i < bArr.length; i++) {
            stringBuffer.append(f2883kz[(bArr[i] >> 4) & 15]);
            stringBuffer.append(f2883kz[bArr[i] & 15]);
        }
        return stringBuffer.toString();
    }

    public static byte[] m2699a(byte[] bArr, String str) {
        byte[] bArr2 = null;
        if (!"".equals(str) && str != null) {
            bArr2 = str.getBytes();
        }
        return m2702b(bArr, bArr2);
    }

    private static byte[] m2700a(int[] iArr, boolean z, byte[] bArr) {
        int i;
        int length = iArr.length << 2;
        if (z) {
            i = iArr[iArr.length - 1];
            if (i > length) {
                return null;
            }
        } else {
            i = length;
        }
        byte[] bArr2 = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr2[i2] = (byte) (iArr[i2 >>> 2] >>> ((i2 & 3) << 3));
        }
        return bArr2;
    }

    private static int[] m2701a(byte[] bArr, boolean z, int[] iArr) {
        int[] iArr2;
        int length = (bArr.length & 3) == 0 ? bArr.length >>> 2 : (bArr.length >>> 2) + 1;
        if (z) {
            iArr2 = new int[length + 1];
            iArr2[length] = bArr.length;
        } else {
            iArr2 = new int[length];
        }
        int length2 = bArr.length;
        for (int i = 0; i < length2; i++) {
            int i2 = i >>> 2;
            iArr2[i2] = iArr2[i2] | ((bArr[i] & 255) << ((i & 3) << 3));
        }
        return iArr2;
    }

    public static byte[] m2702b(byte[] bArr, byte[] bArr2) {
        int[] iArr;
        if (bArr.length == 0) {
            return bArr;
        }
        int[] m2701a = m2701a(bArr, true, (int[]) null);
        int[] m2701a2 = m2701a(bArr2, false, (int[]) null);
        int length = m2701a.length - 1;
        if (length > 0) {
            if (m2701a2.length < 4) {
                iArr = new int[4];
                System.arraycopy(m2701a2, 0, iArr, 0, m2701a2.length);
            } else {
                iArr = m2701a2;
            }
            int i = (52 / (length + 1)) + 6;
            int i2 = 0;
            int i3 = m2701a[length];
            while (true) {
                int i4 = i - 1;
                if (i <= 0) {
                    break;
                }
                i2 -= 1640531527;
                int i5 = (i2 >>> 2) & 3;
                int i6 = 0;
                while (i6 < length) {
                    int i7 = m2701a[i6 + 1];
                    i3 = (((i3 ^ iArr[(i6 & 3) ^ i5]) + (i7 ^ i2)) ^ (((i3 >>> 5) ^ (i7 << 2)) + ((i7 >>> 3) ^ (i3 << 4)))) + m2701a[i6];
                    m2701a[i6] = i3;
                    i6++;
                }
                int i8 = m2701a[0];
                i3 = m2701a[length] + (((iArr[(i6 & 3) ^ i5] ^ i3) + (i8 ^ i2)) ^ (((i3 >>> 5) ^ (i8 << 2)) + ((i8 >>> 3) ^ (i3 << 4))));
                m2701a[length] = i3;
                i = i4;
            }
        }
        return m2700a(m2701a, false, (byte[]) null);
    }

    public static byte[] m2703cU(String str) {
        try {
            byte[] bArr = new byte[str.length() >> 1];
            for (int i = 0; i < bArr.length; i++) {
                bArr[i] = (byte) Integer.parseInt(str.substring(i << 1, (i << 1) + 2), 16);
            }
            return bArr;
        } catch (Exception e) {
            return null;
        }
    }

    public static String m2704cV(String str) {
        return m2698a(m2699a(str.getBytes(), "abcd?a123456789"));
    }

    public static String m2705cW(String str) {
        int[] iArr;
        byte[] m2703cU = m2703cU(str);
        byte[] bytes = ("".equals("abcd?a123456789") || "abcd?a123456789" == 0) ? null : "abcd?a123456789".getBytes();
        if (m2703cU != null && m2703cU.length != 0) {
            int[] m2701a = m2701a(m2703cU, false, (int[]) null);
            int[] m2701a2 = m2701a(bytes, false, (int[]) null);
            int length = m2701a.length - 1;
            if (length > 0) {
                if (m2701a2.length < 4) {
                    iArr = new int[4];
                    System.arraycopy(m2701a2, 0, iArr, 0, m2701a2.length);
                } else {
                    iArr = m2701a2;
                }
                int i = ((52 / (length + 1)) + 6) * (-1640531527);
                int i2 = m2701a[0];
                while (i != 0) {
                    int i3 = (i >>> 2) & 3;
                    int i4 = i2;
                    int i5 = length;
                    while (i5 > 0) {
                        int i6 = m2701a[i5 - 1];
                        i4 = m2701a[i5] - (((i4 ^ i) + (i6 ^ iArr[(i5 & 3) ^ i3])) ^ (((i6 >>> 5) ^ (i4 << 2)) + ((i4 >>> 3) ^ (i6 << 4))));
                        m2701a[i5] = i4;
                        i5--;
                    }
                    int i7 = m2701a[length];
                    int i8 = m2701a[0] - (((iArr[(i5 & 3) ^ i3] ^ i7) + (i4 ^ i)) ^ (((i7 >>> 5) ^ (i4 << 2)) + ((i4 >>> 3) ^ (i7 << 4))));
                    m2701a[0] = i8;
                    i -= -1640531527;
                    i2 = i8;
                }
            }
            m2703cU = m2700a(m2701a, true, (byte[]) null);
        }
        return new String(m2703cU);
    }
}
