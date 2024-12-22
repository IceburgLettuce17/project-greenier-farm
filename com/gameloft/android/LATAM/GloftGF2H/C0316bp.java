package com.gameloft.android.LATAM.GloftGF2H;

import java.io.UnsupportedEncodingException;
import p009b.p010a.p016e.C0100b;
import p009b.p010a.p016e.C0103e;

public final class C0316bp {

    public static int f739Bg = 1;

    public static boolean f740Bh = false;

    public static void m880a(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) ((i >> 24) & 255);
        bArr[i2 + 1] = (byte) ((i >> 16) & 255);
        bArr[i2 + 2] = (byte) ((i >> 8) & 255);
        bArr[i2 + 3] = (byte) (i & 255);
    }

    public static void m881a(long j, byte[] bArr, int i) {
        bArr[i] = (byte) ((j >> 56) & 255);
        bArr[i + 1] = (byte) ((j >> 48) & 255);
        bArr[i + 2] = (byte) ((j >> 40) & 255);
        bArr[i + 3] = (byte) ((j >> 32) & 255);
        bArr[i + 4] = (byte) ((j >> 24) & 255);
        bArr[i + 5] = (byte) ((j >> 16) & 255);
        bArr[i + 6] = (byte) ((j >> 8) & 255);
        bArr[i + 7] = (byte) (255 & j);
    }

    public static byte[] m882a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public static byte[] m883aT(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            return str.getBytes();
        }
    }

    public static void m884aU(String str) {
        m890g(str, 2);
    }

    public static String m885b(String str, int i, char c) {
        int i2 = 0;
        int indexOf = str.indexOf(c, 1);
        int i3 = i;
        while (i3 > 0) {
            if (i2 == -1) {
                return null;
            }
            i3--;
            i2 = indexOf;
            indexOf = str.indexOf(c, indexOf + 1);
        }
        if (i2 == -1) {
            return null;
        }
        if (indexOf == -1) {
            indexOf = str.length();
        }
        if (i > 0) {
            i2++;
        }
        if (i2 == indexOf) {
            return "";
        }
        if (i2 > indexOf) {
            return null;
        }
        try {
            char[] cArr = new char[indexOf - i2];
            str.getChars(i2, indexOf, cArr, 0);
            return new String(cArr);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public static String m886d(byte[] bArr, int i, int i2) {
        try {
            return new String(bArr, i, i2, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return new String(bArr, i, i2);
        }
    }

    public static C0100b m887e(String str, boolean z) {
        try {
            return C0100b.m227g(str, z);
        } catch (C0103e e) {
            return null;
        } catch (Exception e2) {
            m890g(e2.getMessage(), 2);
            return null;
        }
    }

    public static int m888f(byte[] bArr, int i) {
        return ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8) | (bArr[i + 3] & 255);
    }

    public static long m889g(byte[] bArr, int i) {
        return ((bArr[i] & 255) << 56) | ((bArr[i + 1] & 255) << 48) | ((bArr[i + 2] & 255) << 40) | ((bArr[i + 3] & 255) << 32) | ((bArr[i + 4] & 255) << 24) | ((bArr[i + 5] & 255) << 16) | ((bArr[i + 6] & 255) << 8) | (bArr[i + 7] & 255);
    }

    public static void m890g(String str, int i) {
        if (C0341u.DEBUG) {
            new StringBuffer("[GLOT]>>>\t").append(str).toString();
        }
        if (!f740Bh || i > f739Bg) {
            return;
        }
        try {
            C0314bn.m849dE().f710Af.m215dj(new StringBuffer("GlotLogger: >>").append(str).toString());
        } catch (Exception e) {
        }
    }

    public static String m891h(byte[] bArr, int i) {
        return m886d(bArr, 4, bArr.length - 4);
    }
}
