package com.gameloft.android.LATAM.GloftGF2H;

import com.facebook.android.C0217R;
import com.facebook.widget.PlacePickerFragment;
import java.io.ByteArrayInputStream;
import java.lang.reflect.Array;
import p001a.p004b.p005a.p006a.InterfaceC0014m;
import p009b.p010a.p012b.C0048ac;
import p009b.p010a.p013c.C0082c;
import p009b.p010a.p013c.InterfaceC0084e;
import p009b.p010a.p013c.p014a.InterfaceC0079a;
import p009b.p010a.p013c.p014a.InterfaceC0080b;

final class RunnableC0340t implements Runnable {

    static int f2562tL;

    private static int f2563tM;

    private static boolean f2564tN;

    private static byte[][] f2565tO;

    private static int[] f2566tP;

    private static InterfaceC0084e[] f2568tR;

    private static InterfaceC0084e[] f2569tS;

    private static long[] f2570tT;

    private static int[] f2571tU;

    private static int[] f2572tV;

    private static int[] f2573tW;

    private static int[] f2574tX;

    private static int[] f2575tY;

    private static Thread f2576tZ;

    private static long[] f2577uA;

    private static boolean[] f2578uB;

    private static int[] f2586uJ;

    static int[][] f2587uK;

    private static byte[][][] f2588uL;

    private static C0277ad[][] f2589uM;

    static C0048ac[][] f2590uN;

    private static C0271a[] f2591uO;

    private static RunnableC0340t f2593ua;

    private static int[] f2594ub;

    private static int[] f2595uc;

    private static int[] f2596ud;

    private static byte[] f2597ue;

    private static boolean f2598uf;

    private static int[] f2599ug;

    private static int[] f2600uh;

    private static int[] f2601ui;

    private static int[] f2602uj;

    private static boolean[] f2603uk;

    private static boolean[] f2604ul;

    private static boolean[] f2605um;

    private static long[] f2606un;

    private static long[] f2607uo;

    private static long f2608up;

    private static int[] f2609uq;

    private static boolean[] f2610ur;

    private static int[] f2611us;

    private static int f2612ut;

    private static boolean[] f2613uu;

    private static InterfaceC0084e[] f2614uv;

    private static int[] f2615uw;

    private static int[] f2616ux;

    private static int[] f2617uy;

    private static int[] f2618uz;

    int f2619tA;

    private int f2620tB;

    private int f2621tC;

    private int f2622tD;

    int f2623tE;

    private boolean f2624tF;

    int f2625tG;

    int f2626tI;

    int f2627tw;

    int f2628tx;

    private int f2629ty;

    C0271a f2630tz;

    private static int f2559tH = PlacePickerFragment.DEFAULT_RADIUS_IN_METERS / C0338r.f2311oi;

    private static final int f2560tJ = C0338r.f2257ng;

    private static final int f2561tK = C0338r.f2225nA;

    private static boolean f2567tQ = false;

    private static boolean f2579uC = false;

    private static int f2580uD = C0338r.f2241nQ;

    private static int f2581uE = -1;

    private static int f2582uF = -1;

    private static int f2583uG = 0;

    private static final int f2584uH = 20;

    private static final int f2585uI = C0338r.f2247nW;

    static int f2592uP = 100;

    RunnableC0340t() {
        m2138bL();
    }

    RunnableC0340t(C0271a c0271a, int i, int i2) {
        m2138bL();
        this.f2627tw = i;
        this.f2628tx = i2;
        m2135a(c0271a);
    }

    private static boolean m2078A(int i, int i2) {
        int m2100aH;
        if (f2564tN && (m2100aH = m2100aH(i)) != -1) {
            return C0338r.f2260nj && ((InterfaceC0014m) f2568tR[m2100aH].mo197dh("TempoControl")) != null;
        }
        return false;
    }

    private static boolean m2079B(int i, int i2) {
        return (f2587uK[i][15] & i2) != 0;
    }

    private static final int m2080C(int i, int i2) {
        return m2079B(i, 8) ? (f2587uK[i][6] - f2586uJ[1]) - i2 : i2;
    }

    private static int m2081a(int i, int i2, int i3, int i4, boolean z, int i5) {
        if (!f2564tN) {
            return -1;
        }
        C0082c.m199an(f2613uu[i]);
        if (f2613uu[i]) {
            if (i2 == 0) {
                f2614uv[i].mo201fm(-1);
            } else {
                f2614uv[i].mo201fm(i2);
            }
            int i6 = 100000;
            if (f2578uB[i]) {
                i6 = f2617uy[i];
                f2616ux[i] = 0;
                f2617uy[i] = 0;
                f2618uz[i] = 0;
                f2577uA[i] = 0;
                f2578uB[i] = false;
            }
            try {
                f2614uv[i].mo203u(i3, 15 - i4, i6);
            } catch (Exception e) {
            }
            return -1;
        }
        if (!C0338r.f2256nf) {
            return -1;
        }
        int m2118bS = m2118bS();
        if (m2118bS == -1) {
            int i7 = -1;
            int i8 = i4;
            for (int i9 = 0; i9 < f2560tJ; i9++) {
                byte b2 = f2597ue[i9];
                if (i8 < b2) {
                    i7 = i9;
                    i8 = b2;
                } else if (i8 == b2 && i8 > i4 && (i7 == -1 || (i9 != -1 && f2570tT[i7] > f2570tT[i9]))) {
                    i7 = i9;
                }
            }
            if (i7 == -1) {
                return -1;
            }
            m2118bS = i7;
        }
        boolean z2 = C0338r.f2268nr;
        f2609uq[m2118bS] = i;
        if (i < 0) {
            return -1;
        }
        f2597ue[m2118bS] = (byte) i4;
        f2604ul[m2118bS] = false;
        if (f2568tR[m2118bS] != null && f2568tR[m2118bS].getState() == 400 && !f2610ur[m2118bS]) {
            m2126e(m2118bS, 4, -1, f2561tK);
        }
        if (f2610ur[m2118bS]) {
            try {
                m2129g(4, m2118bS, m2099aG(m2118bS), f2561tK);
            } catch (Exception e2) {
            }
        }
        m2124c(m2118bS, 2, i, i4, i3, i2, -1, 0);
        f2611us[m2118bS] = i3;
        return m2118bS;
    }

    static final void m2082a(int i, int i2, int i3) {
        f2587uK[0][13] = i2;
        f2587uK[0][14] = m2080C(0, i3);
        if (m2079B(0, 16)) {
            if (f2587uK[0][13] < 0) {
                f2587uK[0][13] = 0;
            } else if (f2587uK[0][13] + f2586uJ[0] >= f2587uK[0][5]) {
                f2587uK[0][13] = (f2587uK[0][5] - f2586uJ[0]) - 1;
            }
        }
        if (m2079B(0, 32)) {
            if (f2587uK[0][14] < 0) {
                f2587uK[0][14] = 0;
            } else if (f2587uK[0][14] + f2586uJ[1] >= f2587uK[0][6]) {
                f2587uK[0][14] = (f2587uK[0][6] - f2586uJ[1]) - 1;
            }
        }
    }

    private static void m2083a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (f2564tN) {
            int i9 = f2595uc[i];
            int i10 = f2596ud[i];
            int m2094aB = m2094aB(i9 + i10);
            for (int i11 = 0; i11 < i10; i11++) {
                if (f2594ub[(m2094aB((m2094aB - i11) - 1) * 7) + (C0338r.f2275ny * i * 7)] == i2) {
                    return;
                }
            }
            int i12 = (C0338r.f2275ny * i * 7) + (m2094aB * 7);
            f2594ub[i12] = i2;
            f2594ub[i12 + 1] = i3;
            f2594ub[i12 + 2] = i4;
            f2594ub[i12 + 3] = i5;
            f2594ub[i12 + 4] = i6;
            f2594ub[i12 + 5] = i7;
            f2594ub[i12 + 6] = i8;
            int[] iArr = f2596ud;
            iArr[i] = iArr[i] + 1;
        }
    }

    static final void m2084a(int i, int i2, int i3, int i4, int i5, boolean z) {
        if (m2079B(0, 4)) {
            m2085a(2, 0, null, 0, 0, 0, 0, i4, i5, 0, z);
        } else {
            GLLib.m438b(GLLib.f134iC, 0 - f2587uK[0][13], 0 - m2109aQ(0), i4, i5);
        }
    }

    private static void m2085a(int i, int i2, Object obj, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        if (m2079B(i2, 4)) {
            int[] iArr = f2587uK[i2];
            int i15 = 0;
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            if (i == 0) {
                int m668p = ((C0271a) obj).m668p(i4);
                i16 = ((C0271a) obj).m669q(i4);
                int m666n = ((C0271a) obj).m666n(i4);
                i18 = ((C0271a) obj).m667o(i4);
                if (C0338r.f2439rG) {
                    if ((GLLib.f233kY & 262144) != 0) {
                        int i19 = GLLib.f234kZ[18][1];
                        i16 = (i16 * i19) / 100;
                        i17 = (m666n * i19) / 100;
                        i18 = (i18 * i19) / 100;
                        i15 = (m668p * i19) / 100;
                    }
                }
                i17 = m666n;
                i15 = m668p;
            } else if (i == 1 || i == 2 || i == 3 || i == 5 || i == 4) {
                i18 = i8;
                i17 = i7;
            }
            if ((i9 & 1) != 0) {
                i15 = (-i15) - i17;
            }
            if ((i9 & 2) != 0) {
                i16 = (-i16) - i18;
            }
            if ((i9 & 4) != 0) {
                i10 = i15;
                i11 = (-i16) - i18;
                i12 = i18;
                i18 = i17;
            } else {
                i10 = i16;
                i11 = i15;
                i12 = i17;
            }
            int m2080C = m2080C(i2, i6);
            int i20 = iArr[13];
            int i21 = iArr[14];
            if (C0338r.f2304ob && m2079B(i2, 256)) {
                i13 = iArr[2];
                i14 = iArr[3];
            } else {
                i13 = f2586uJ[2];
                i14 = f2586uJ[5];
            }
            int i22 = i20 % i13;
            int i23 = i21 % i14;
            int i24 = i20 - (i22 < 0 ? i13 + i22 : i22);
            int i25 = i21 - (i23 < 0 ? i14 + i23 : i23);
            int i26 = i5 - i24;
            int i27 = m2080C - i25;
            int i28 = (!m2079B(i2, 273) || i24 >= 0) ? i24 : iArr[7] + (i24 % iArr[7]);
            int i29 = (!m2079B(i2, 290) || i25 >= 0) ? i25 : iArr[8] + (i25 % iArr[8]);
            int i30 = i28 % iArr[7];
            int i31 = i29 % iArr[8];
            int i32 = iArr[7] - i30;
            int i33 = iArr[8] - i31;
            C0048ac c0048ac = f2590uN[i2][0];
            int i34 = GLLib.f236kb;
            int i35 = GLLib.f237kc;
            int i36 = GLLib.f238kd;
            int i37 = GLLib.f239ke;
            int i38 = iArr[7];
            int i39 = iArr[8];
            int i40 = C0271a.f391cq;
            int i41 = C0271a.f392cr;
            C0271a.f391cq = i38;
            C0271a.f392cr = i39;
            int i42 = i26 + i11;
            int i43 = i27 + i10;
            int i44 = i42 + i12;
            int i45 = i43 + i18;
            for (int i46 = 0; i46 <= 0; i46++) {
                for (int i47 = 0; i47 <= 0; i47++) {
                    if (i42 <= i38 && i45 >= 0 && i44 >= 0 && i43 <= i39) {
                        int i48 = 1;
                        while (true) {
                            int i49 = i48 - 1;
                            if (i49 >= 0) {
                                if (i42 < i32) {
                                    if (i43 < i33) {
                                        m2092a(c0048ac, obj, i4, i9, i30, i31, i32, i33, (i30 + i42) - i11, (i31 + i43) - i10, i7, i8, i, i34, i35, i36, i37, null, z);
                                    }
                                    if (i45 >= i33 && i31 != 0) {
                                        m2092a(c0048ac, obj, i4, i9, i30, 0, i32, i31, (i30 + i42) - i11, (i43 - i10) - i33, i7, i8, i, i34, i35, i36, i37, null, z);
                                    }
                                }
                                if (i44 >= i32 && i30 != 0) {
                                    if (i43 < i33) {
                                        m2092a(c0048ac, obj, i4, i9, 0, i31, i30, i33, (i42 - i11) - i32, (i31 + i43) - i10, i7, i8, i, i34, i35, i36, i37, null, z);
                                    }
                                    if (i45 >= i33 && i31 != 0) {
                                        m2092a(c0048ac, obj, i4, i9, 0, 0, i30, i31, (i42 - i11) - i32, (i43 - i10) - i33, i7, i8, i, i34, i35, i36, i37, null, z);
                                    }
                                }
                                i48 = i49;
                            }
                        }
                    }
                }
            }
            GLLib.m436b(i34, i35, i36, i37);
            C0271a.f391cq = i40;
            C0271a.f392cr = i41;
        }
    }

    private static void m2086a(int i, int i2, boolean z) {
        if (z) {
            int[] iArr = f2587uK[i];
            iArr[15] = iArr[15] | i2;
        } else {
            int[] iArr2 = f2587uK[i];
            iArr2[15] = iArr2[15] & (i2 ^ (-1));
        }
    }

    static void m2087a(int i, byte[] bArr, byte[] bArr2, byte[] bArr3, C0271a c0271a, int i2, int i3, int i4, int i5, boolean z) {
        if (f2579uC) {
            m2127e(0, false);
            f2587uK[0][18] = 0;
            f2587uK[0][19] = 0;
            f2587uK[0][18] = f2586uJ[0];
            f2587uK[0][19] = f2586uJ[1];
            f2588uL[0][0] = bArr2;
            f2588uL[0][1] = bArr3;
            f2587uK[0][2] = GLLib.m435b(bArr, 0);
            f2587uK[0][3] = GLLib.m435b(bArr, 2);
            f2587uK[0][5] = f2587uK[0][2] * f2586uJ[2];
            f2587uK[0][6] = f2587uK[0][3] * f2586uJ[5];
            f2591uO[0] = c0271a;
            f2587uK[0][9] = -1;
            f2587uK[0][10] = -1;
            f2587uK[0][11] = -1;
            f2587uK[0][12] = -1;
            f2587uK[0][0] = 1;
            f2587uK[0][1] = 1;
            f2587uK[0][13] = 0;
            f2587uK[0][14] = 0;
            f2587uK[0][16] = 0;
            f2587uK[0][17] = 0;
            m2086a(0, 1, false);
            m2086a(0, 16, false);
            m2086a(0, 2, false);
            m2086a(0, 32, false);
            m2086a(0, 8, false);
        }
    }

    private static void m2088a(int i, int[] iArr) {
        iArr[7] = f2596ud[i];
        if (f2596ud[i] > 0) {
            System.arraycopy(f2594ub, (f2595uc[i] * 7) + (C0338r.f2275ny * i * 7), iArr, 0, 7);
            f2595uc[i] = m2094aB(f2595uc[i] + 1);
            f2596ud[i] = r0[i] - 1;
        }
    }

    static void m2089a(C0048ac c0048ac, int i, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        if (f2579uC) {
            int[] iArr = f2586uJ;
            int[] iArr2 = f2586uJ;
            if (i3 == -1) {
                for (int i11 = 0; i11 < f2580uD; i11++) {
                    m2089a(c0048ac, i, i2, i11);
                }
                return;
            }
            int i12 = (f2587uK[i3][18] * 100) / f2592uP;
            int i13 = (f2587uK[i3][19] * 100) / f2592uP;
            if (i12 == 0) {
                f2587uK[i3][18] = f2586uJ[0];
                i12 = f2587uK[i3][18];
            }
            if (i13 == 0) {
                f2587uK[i3][19] = f2586uJ[1];
                i4 = f2587uK[i3][18];
            } else {
                i4 = i12;
            }
            int[] iArr3 = f2587uK[i3];
            if (iArr3[0] == 1 && iArr3[1] == 1) {
                int i14 = iArr3[13] + iArr3[16];
                int i15 = iArr3[14] + iArr3[17];
                if (!m2079B(i3, 4)) {
                    if (c0048ac != null) {
                        int i16 = i14 < 0 ? i14 - f2586uJ[2] : i14;
                        int i17 = i15 < 0 ? i15 - f2586uJ[5] : i15;
                        int i18 = i16 / f2586uJ[2];
                        int i19 = i17 / f2586uJ[5];
                        int i20 = i4 / f2586uJ[2];
                        if (f2586uJ[2] * i20 < i4) {
                            i20++;
                        }
                        int i21 = i13 / f2586uJ[5];
                        if (f2586uJ[5] * i21 < i13) {
                            i21++;
                        }
                        m2090a(c0048ac, i3, i18, i19, i20, i21, ((f2586uJ[2] * i18) - i14) + i, ((f2586uJ[5] * i19) - i15) + i2);
                        return;
                    }
                    return;
                }
                int i22 = 0;
                int i23 = 0;
                int i24 = 0;
                int i25 = 0;
                if (c0048ac != null) {
                    i22 = GLLib.f236kb;
                    i23 = GLLib.f237kc;
                    i24 = GLLib.f238kd;
                    i25 = GLLib.f239ke;
                }
                if (C0338r.f2304ob && m2079B(i3, 256)) {
                    int[] iArr4 = f2587uK[i3];
                    int i26 = iArr4[13];
                    int i27 = iArr4[14];
                    int i28 = f2586uJ[0];
                    int i29 = f2586uJ[1];
                    int i30 = iArr4[5];
                    int i31 = iArr4[6];
                    int i32 = i30 + iArr4[7];
                    int i33 = i31 + iArr4[8];
                    int i34 = iArr4[2];
                    int i35 = iArr4[3];
                    boolean z = iArr4[9] > 0;
                    int i36 = i26 < 0 ? i26 - (i34 - 1) : i26;
                    int i37 = i27 < 0 ? i27 - (i35 - 1) : i27;
                    if (!z) {
                        if (i32 + (-1) < i26 ? false : i30 > (i26 + i28) + (-1) ? false : i33 + (-1) < i27 ? false : i31 <= (i27 + i29) + (-1)) {
                            int i38 = 0;
                            int i39 = 0;
                            if (i26 < i30) {
                                int i40 = (i36 / i34) * i34;
                                i39 = i30 - i40;
                                int i41 = iArr4[8];
                                iArr4[5] = i40;
                                m2123c(i3, i40, (i37 / i35) * i35, i39, i41);
                                i38 = i39;
                            } else if (i26 + i28 >= i32) {
                                i39 = ((((i26 + i28) - i32) / i34) + 1) * i34;
                                int i42 = iArr4[8];
                                iArr4[5] = (i36 / i34) * i34;
                                m2123c(i3, i32, (i37 / i35) * i35, i39, i42);
                            }
                            if (i27 < i31) {
                                int i43 = (i37 / i35) * i35;
                                iArr4[6] = i43;
                                m2123c(i3, i38 + ((i36 / i34) * i34), i43, iArr4[7] - i39, i31 - i43);
                            } else if (i27 + i29 >= i33) {
                                iArr4[6] = (i37 / i35) * i35;
                                m2123c(i3, i38 + ((i36 / i34) * i34), i33, iArr4[7] - i39, ((((i27 + i29) - i33) / i35) + 1) * i35);
                            }
                            iArr4[10] = 0;
                        }
                    }
                    int i44 = (i36 / i34) * i34;
                    int i45 = (i37 / i35) * i35;
                    m2123c(i3, i44, i45, iArr4[7], iArr4[8]);
                    iArr4[5] = i44;
                    iArr4[6] = i45;
                    if (z) {
                        iArr4[9] = 0;
                    }
                    iArr4[10] = 1;
                } else {
                    int i46 = i14 < 0 ? i14 - f2586uJ[2] : i14;
                    int i47 = i15 < 0 ? i15 - f2586uJ[5] : i15;
                    int i48 = i46 / f2586uJ[2];
                    int i49 = i47 / f2586uJ[5];
                    int i50 = ((iArr3[7] / f2586uJ[2]) + i48) - 1;
                    int i51 = ((iArr3[8] / f2586uJ[5]) + i49) - 1;
                    if (iArr3[10] == i49 && iArr3[12] == i51) {
                        i5 = 0;
                        i6 = 0;
                    } else if (iArr3[10] < i49 || iArr3[12] < i51) {
                        if (iArr3[12] < i49) {
                            i5 = i51;
                            i6 = i49;
                        } else {
                            i5 = i51;
                            i6 = iArr3[12] + 1;
                        }
                    } else if (iArr3[10] > i51) {
                        i5 = i51;
                        i6 = i49;
                    } else {
                        i5 = iArr3[10] - 1;
                        i6 = i49;
                    }
                    if (iArr3[9] != i48 || iArr3[11] != i50) {
                        if (iArr3[9] < i48 || iArr3[11] < i50) {
                            if (iArr3[11] < i48) {
                                i8 = i50;
                                i7 = i48;
                            } else {
                                i7 = iArr3[11] + 1;
                                i8 = i50;
                            }
                        } else if (iArr3[9] > i50) {
                            i8 = i50;
                            i7 = i48;
                        } else {
                            i8 = iArr3[9] - 1;
                            i7 = i48;
                        }
                        int i52 = i51 - i49;
                        if (iArr3[10] == i49 && iArr3[12] == i51) {
                            i9 = i49;
                        } else if (iArr3[10] < i49 || iArr3[12] < i51) {
                            i52 -= (i5 - i6) + 1;
                            i9 = i49;
                        } else {
                            i52 -= (i5 - i6) + 1;
                            i9 = i49 + (i5 - i6) + 1;
                        }
                        if (i52 >= 0) {
                            m2090a(f2590uN[i3][0], i3, i7, i9, i8 - i7, i52, 0, 0);
                        }
                        iArr3[9] = i48;
                        iArr3[11] = i50;
                    }
                    if (iArr3[10] != i49 || iArr3[12] != i51) {
                        m2090a(f2590uN[i3][0], i3, i48, i6, i50 - i48, i5 - i6, 0, 0);
                        iArr3[10] = i49;
                        iArr3[12] = i51;
                    }
                }
                if (c0048ac != null) {
                    if (m2079B(i3, 273)) {
                        i10 = i14;
                        while (i10 < 0) {
                            i10 += iArr3[7];
                        }
                    } else if (i14 < 0) {
                        i -= i14;
                        i10 = 0;
                    } else if (i14 > iArr3[5] - i4) {
                        i -= i14 - (iArr3[5] - i4);
                        i10 = iArr3[5] - i4;
                    } else {
                        i10 = i14;
                    }
                    if (m2079B(i3, 290)) {
                        while (i15 < 0) {
                            i15 += iArr3[8];
                        }
                    } else if (i15 < 0) {
                        i2 -= i15;
                        i15 = 0;
                    } else if (i15 > iArr3[6] - i13) {
                        i2 -= i15 - (iArr3[6] - i13);
                        i15 = iArr3[6] - i13;
                    }
                    int i53 = i10 % iArr3[7];
                    int i54 = i15 % iArr3[8];
                    int i55 = (i10 + i4) % iArr3[7];
                    int i56 = (i15 + i13) % iArr3[8];
                    GLLib.m436b(i22, i23, i24, i25);
                    if (i55 > i53) {
                        if (i56 > i54) {
                            m2091a(c0048ac, i3, i53, i54, i4, i13, i + 0, i2 + 0, i22, i23, i24, i25);
                        } else {
                            m2091a(c0048ac, i3, i53, i54, i4, i13 - i56, i + 0, i2 + 0, i22, i23, i24, i25);
                            GLLib.m436b(i22, i23, i24, i25);
                            m2091a(c0048ac, i3, i53, 0, i4, i56, i + 0, (i13 - i56) + i2, i22, i23, i24, i25);
                        }
                    } else if (i56 > i54) {
                        m2091a(c0048ac, i3, i53, i54, i4 - i55, i13, i + 0, i2 + 0, i22, i23, i24, i25);
                        GLLib.m436b(i22, i23, i24, i25);
                        m2091a(c0048ac, i3, 0, i54, i55, i13, (i4 - i55) + i, i2 + 0, i22, i23, i24, i25);
                    } else {
                        m2091a(c0048ac, i3, i53, i54, i4 - i55, i13 - i56, i + 0, i2 + 0, i22, i23, i24, i25);
                        GLLib.m436b(i22, i23, i24, i25);
                        m2091a(c0048ac, i3, i53, 0, i4 - i55, i56, i + 0, (i13 - i56) + i2, i22, i23, i24, i25);
                        GLLib.m436b(i22, i23, i24, i25);
                        m2091a(c0048ac, i3, 0, i54, i55, i13 - i56, (i4 - i55) + i, i2 + 0, i22, i23, i24, i25);
                        GLLib.m436b(i22, i23, i24, i25);
                        m2091a(c0048ac, i3, 0, 0, i55, i56, (i4 - i55) + i, (i13 - i56) + i2, i22, i23, i24, i25);
                    }
                    GLLib.m436b(i22, i23, i24, i25);
                }
            }
        }
    }

    private static void m2090a(C0048ac c0048ac, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        boolean m2079B = m2079B(i, 4);
        boolean m2079B2 = m2079B(i, 1);
        boolean m2079B3 = m2079B(i, 2);
        int i14 = f2587uK[i][2];
        int i15 = f2587uK[i][3];
        int i16 = f2586uJ[2];
        int i17 = f2586uJ[5];
        int i18 = i14 * i15;
        if (m2079B) {
            i9 = ((f2586uJ[2] * i2) % f2587uK[i][7]) + i6;
            i8 = ((f2586uJ[5] * i3) % f2587uK[i][8]) + i7;
            if (i9 < 0) {
                i9 += f2587uK[i][7];
            }
            if (i8 < 0) {
                i8 += f2587uK[i][8];
            }
        } else {
            i8 = i7;
            i9 = i6;
        }
        if (m2079B2) {
            i11 = i2;
            while (i11 < 0) {
                i11 += i14;
            }
            while (i11 >= i14) {
                i11 -= i14;
            }
        } else if (m2079B(i, 16)) {
            i10 = i4;
            i11 = i2;
            if (!m2079B3) {
                while (i3 < 0) {
                    i3 += i15;
                }
                while (i3 >= i15) {
                    i3 -= i15;
                }
            } else if (!m2079B(i, 32)) {
                if (i3 < 0) {
                    i8 -= i3 * i17;
                    i5 += i3;
                    i3 = 0;
                    if (m2079B && i8 >= f2587uK[i][8]) {
                        i8 = 0;
                    }
                }
                if (i3 + i5 >= i15) {
                    i5 = (i15 - i3) - 1;
                }
                if (i5 < 0) {
                    return;
                }
            }
            int[][] iArr = f2587uK;
            int i19 = i8;
            while (true) {
                int i20 = i5 - 1;
                if (i5 >= 0) {
                    return;
                }
                int i21 = i11;
                int i22 = i10;
                int i23 = i9;
                while (true) {
                    int i24 = i22 - 1;
                    if (i22 < 0) {
                        break;
                    }
                    int i25 = i21 + (i3 * i14);
                    if (i25 < i18) {
                        int m2112b = m2112b(i, 0, i25, false);
                        if (!(m2112b == 255)) {
                            int i26 = f2587uK[i][2];
                            int i27 = i25 % i26;
                            int i28 = i25 / i26;
                            int m2112b2 = f2588uL[i][1] == null ? 0 : m2112b(i, 1, i25, false);
                            if (f2592uP != 100) {
                                GLLib.m437b(18, false);
                                GLLib.f234kZ[18][1] = f2592uP;
                                GLLib.m502k(true);
                            }
                            if (f2591uO[i].m637V() == 0) {
                                f2591uO[i].m643a(c0048ac, m2112b, i23, i19, m2112b2, f2586uJ[2], f2586uJ[5]);
                            } else {
                                if ((m2112b2 & 4) == 0) {
                                    int i29 = (m2112b2 & 1) != 0 ? i23 + i16 : i23;
                                    if ((m2112b2 & 2) != 0) {
                                        i12 = i29;
                                        i13 = i19 + i17;
                                    } else {
                                        i12 = i29;
                                        i13 = i19;
                                    }
                                } else if ((m2112b2 & 1) != 0 && (m2112b2 & 2) != 0) {
                                    i13 = i19 + i16;
                                    i12 = i23;
                                } else if ((m2112b2 & 1) != 0) {
                                    i12 = i23 + i17;
                                    i13 = i19 + i16;
                                } else if ((m2112b2 & 2) == 0) {
                                    i13 = i19;
                                    i12 = i23 + i17;
                                } else {
                                    i13 = i19;
                                    i12 = i23;
                                }
                                f2591uO[i].m642a(c0048ac, m2112b, i12, i13, m2112b2);
                            }
                            if (f2592uP != 100) {
                                GLLib.m502k(false);
                                GLLib.m485c(18, false);
                            }
                        }
                    }
                    i23 += i16;
                    int i30 = i21 + 1;
                    if (i30 >= i14) {
                        if (!m2079B2) {
                            break;
                        } else {
                            i30 = 0;
                        }
                    }
                    if (!m2079B || i23 < f2587uK[i][7]) {
                        i21 = i30;
                        i22 = i24;
                    } else {
                        i23 = 0;
                        i21 = i30;
                        i22 = i24;
                    }
                }
                i19 += i17;
                int i31 = i3 + 1;
                if (i31 >= i15) {
                    if (!m2079B3) {
                        return;
                    } else {
                        i31 = 0;
                    }
                }
                if (!m2079B || i19 < f2587uK[i][8]) {
                    i5 = i20;
                    i3 = i31;
                } else {
                    i19 = 0;
                    i5 = i20;
                    i3 = i31;
                }
            }
        } else {
            if (i2 < 0) {
                i9 -= i2 * i16;
                i4 += i2;
                i11 = 0;
                if (m2079B && i9 >= f2587uK[i][7]) {
                    i9 = 0;
                }
            } else {
                i11 = i2;
            }
            if (i11 + i4 >= i14) {
                i4 = (i14 - i11) - 1;
            }
            if (i4 < 0) {
                return;
            }
        }
        i10 = i4;
        if (!m2079B3) {
        }
        int[][] iArr2 = f2587uK;
        int i192 = i8;
        while (true) {
            int i202 = i5 - 1;
            if (i5 >= 0) {
            }
        }
    }

    private static void m2091a(C0048ac c0048ac, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        if (i6 > i8 + i10 || i7 > i9 + i11 || i6 + i4 < i8 || i7 + i5 < i9) {
            return;
        }
        GLLib.m380a(i6, i7, i4, i5);
        C0277ad c0277ad = f2589uM[i][0];
        GLLib.m388a(c0048ac, c0277ad, 0, 0, c0277ad.f494vK, c0277ad.f495vL, 0, i6 - i2, i7 - i3, 20);
    }

    private static void m2092a(C0048ac c0048ac, Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int[] iArr, boolean z) {
        GLLib.m436b(i12, i13, i14, i15);
        GLLib.m380a(i3, i4, i5, i6);
        if (i11 == 0) {
            ((C0271a) obj).m654b(c0048ac, i, i7, i8, i2);
            return;
        }
        if (i11 == 5) {
            GLLib.m389a(c0048ac, (int[]) obj, 0, i9, i7, i8, i9, i10, true);
            return;
        }
        if (i11 == 4) {
            C0277ad c0277ad = (C0277ad) obj;
            GLLib.m388a(c0048ac, c0277ad, 0, 0, c0277ad.f494vK, c0277ad.f495vL, 0, i7, i8, 20);
        } else if (i11 == 1) {
            GLLib.m486c(c0048ac, i7, i8, i9, i10);
        } else if (i11 == 2) {
            GLLib.m438b(c0048ac, i7, i8, i9, i10);
        } else if (i11 == 3) {
            GLLib.m500f(c0048ac, i7, i8, i9, i10);
        }
    }

    static void m2093a(String str, int i, boolean z, int i2) {
        if (C0338r.f2256nf && f2564tN && i >= 0) {
            GLLib.m344E(str);
            byte[] m408aa = GLLib.m408aa(i);
            int i3 = GLLib.f172jP;
            if (!C0338r.f2256nf || !f2564tN || m408aa == null || m408aa.length <= 0) {
                return;
            }
            f2565tO[i] = m408aa;
            f2566tP[i] = i3;
        }
    }

    private static final int m2094aB(int i) {
        while (i >= C0338r.f2275ny) {
            i -= C0338r.f2275ny;
        }
        while (i < 0) {
            i += C0338r.f2275ny;
        }
        return i;
    }

    static void m2095aC(int i) {
        if (C0338r.f2256nf) {
            int i2 = f2560tJ;
            f2568tR = new InterfaceC0084e[f2560tJ];
            f2611us = new int[f2560tJ];
            f2571tU = new int[f2560tJ];
            f2572tV = new int[f2560tJ];
            f2573tW = new int[f2560tJ];
            f2574tX = new int[f2560tJ];
            int[] iArr = new int[f2560tJ];
            f2575tY = iArr;
            GLLib.m442b(iArr, 1);
            f2594ub = new int[f2560tJ * C0338r.f2275ny * 7];
            f2595uc = new int[f2560tJ];
            f2596ud = new int[f2560tJ];
            f2597ue = new byte[f2560tJ];
            f2599ug = new int[8];
            f2600uh = new int[f2560tJ << 2];
            f2601ui = new int[f2560tJ << 2];
            f2602uj = new int[f2560tJ << 2];
            f2603uk = new boolean[f2560tJ];
            f2604ul = new boolean[f2560tJ];
            f2605um = new boolean[f2560tJ];
            f2606un = new long[f2560tJ];
            f2607uo = new long[f2560tJ];
            f2610ur = new boolean[f2560tJ];
            f2609uq = new int[f2560tJ];
            f2613uu = new boolean[62];
            f2615uw = new int[62];
            f2616ux = new int[62];
            f2617uy = new int[62];
            f2618uz = new int[62];
            f2577uA = new long[62];
            f2578uB = new boolean[62];
            f2614uv = new InterfaceC0084e[62];
            GLLib.m442b(f2609uq, -1);
            for (int i3 = 0; i3 < f2560tJ; i3++) {
                f2600uh[i3 << 2] = 0;
                f2601ui[i3 << 2] = 0;
                f2603uk[i3] = false;
            }
            f2612ut = 0;
            for (int i4 = 0; i4 < f2560tJ; i4++) {
                f2571tU[i4] = -1;
                f2595uc[i4] = 0;
                f2596ud[i4] = 0;
            }
            f2563tM = 62;
            f2565tO = new byte[62][];
            f2566tP = new int[f2563tM];
            f2570tT = new long[f2560tJ];
            f2562tL = 100;
            f2564tN = true;
            if (C0338r.f2258nh) {
                f2593ua = new RunnableC0340t();
                Thread thread = new Thread(f2593ua);
                f2576tZ = thread;
                thread.start();
            }
        }
    }

    static boolean m2096aD(int i) {
        if (f2565tO == null || i >= f2565tO.length || f2565tO[i] == null) {
            return (f2569tS == null || i >= f2569tS.length || f2569tS[i] == null) ? false : true;
        }
        return true;
    }

    static void m2097aE(int i) {
        if (C0338r.f2256nf && f2564tN && i >= 0) {
            f2565tO[i] = null;
            boolean z = C0338r.f2168lV;
        }
    }

    static void m2098aF(int i) {
        if (C0338r.f2256nf && f2564tN) {
            f2562tL = i;
            for (int i2 = 0; i2 < f2560tJ; i2++) {
                try {
                    m2134z(i2, f2574tX[i2]);
                } catch (Exception e) {
                    return;
                }
            }
        }
    }

    private static int m2099aG(int i) {
        int i2;
        if (!C0338r.f2256nf || !f2564tN) {
            return 0;
        }
        try {
            if (f2568tR[i] == null) {
            }
            i2 = ((((InterfaceC0080b) f2568tR[i].mo197dh("VolumeControl")).getLevel() * 100) * 100) / (f2562tL * 100);
        } catch (Exception e) {
            i2 = 0;
        }
        return i2;
    }

    private static int m2100aH(int i) {
        for (int i2 = 0; i2 < f2560tJ; i2++) {
            if (f2609uq[i2] == i) {
                return i2;
            }
            if (f2571tU[i2] == i && m2125d(i2, true)) {
                return i2;
            }
        }
        return -1;
    }

    protected static boolean m2101aI(int i) {
        return C0338r.f2256nf && f2564tN && m2100aH(i) != -1;
    }

    private static void m2102aJ(int i) {
        if (C0338r.f2256nf && f2564tN) {
            if (f2568tR[i] != null) {
                f2568tR[i].stop();
                f2568tR[i].mo205uu();
                f2568tR[i].close();
                f2568tR[i] = null;
            }
            f2573tW[i] = 0;
            f2571tU[i] = -1;
        }
    }

    private static void m2103aK(int i) {
        for (int i2 = 0; i2 < f2563tM; i2++) {
            if (f2564tN) {
                if (f2613uu[i2]) {
                    try {
                        f2614uv[i2].stop();
                    } catch (Exception e) {
                    }
                } else {
                    int i3 = !C0338r.f2268nr ? 0 : i;
                    for (int i4 = 0; i4 < f2560tJ; i4++) {
                        if (f2571tU[i4] == i2) {
                            f2604ul[i4] = false;
                            m2126e(i4, 3, -1, i3);
                        }
                    }
                }
            }
        }
        if (!C0338r.f2258nh) {
            m2119bT();
        } else if (GLLib.f135iD) {
            m2120bU();
        }
    }

    private static long m2104aL(int i) {
        int m2100aH;
        if (!f2564tN || (m2100aH = m2100aH(i)) == -1) {
            return -1L;
        }
        try {
            return f2568tR[m2100aH].mo206uv();
        } catch (Exception e) {
            return -1L;
        }
    }

    private static int m2105aM(int i) {
        int m2100aH;
        if (f2564tN && (m2100aH = m2100aH(i)) != -1) {
            if (C0338r.f2260nj) {
                try {
                    InterfaceC0014m interfaceC0014m = (InterfaceC0014m) f2568tR[m2100aH].mo197dh("TempoControl");
                    if (interfaceC0014m != null) {
                        return interfaceC0014m.m44n();
                    }
                } catch (Exception e) {
                }
            }
            return -1;
        }
        return -1;
    }

    private static int m2106aN(int i) {
        if (!f2564tN || i == -1 || !C0338r.f2260nj) {
            return -1;
        }
        try {
            InterfaceC0079a interfaceC0079a = (InterfaceC0079a) f2568tR[i].mo197dh("RateControl");
            return interfaceC0079a != null ? interfaceC0079a.mo195uw() : -1;
        } catch (Exception e) {
            return -1;
        }
    }

    private static void m2107aO(int i) {
        try {
            f2589uM[i][0] = C0277ad.m677F(f2587uK[i][7], f2587uK[i][8]);
            f2590uN[i][0] = f2589uM[i][0].m680cb();
        } catch (Exception e) {
        }
    }

    static void m2108aP(int i) {
        m2127e(i, true);
    }

    static final int m2109aQ(int i) {
        return m2079B(i, 8) ? (f2587uK[i][6] - f2586uJ[1]) - f2587uK[i][14] : f2587uK[i][14];
    }

    static void m2110aR(int i) {
        if (f2579uC) {
            if (C0338r.f2304ob && m2079B(0, 256)) {
                f2587uK[0][9] = 1;
                return;
            }
            f2587uK[0][9] = -1;
            f2587uK[0][10] = -1;
            f2587uK[0][11] = -1;
            f2587uK[0][12] = -1;
        }
    }

    static final int m2111b(int i, int i2, int i3) {
        return m2112b(0, 0, (m2080C(0, i3) * f2587uK[0][2]) + i2, false);
    }

    private static int m2112b(int i, int i2, int i3, boolean z) {
        return z ? GLLib.m435b(f2588uL[i][i2], i3 << 1) & 65535 : f2588uL[i][i2][i3] & 255;
    }

    static void m2113b(int i, int i2, int i3, int i4, int i5) {
        int m2080C = m2080C(0, i3);
        int i6 = ((m2080C / f2586uJ[5]) * f2587uK[0][2]) + (i2 / f2586uJ[2]);
        if (i4 != -1) {
            m2132j(0, 0, i6, i4);
        }
        m2132j(0, 1, i6, 0);
    }

    private static synchronized void m2114b(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        synchronized (RunnableC0340t.class) {
            m2083a(i, i2, i3, i4, i5, i6, i7, i8);
        }
    }

    private static synchronized void m2115b(int i, int[] iArr) {
        synchronized (RunnableC0340t.class) {
            m2088a(i, iArr);
        }
    }

    private int m2116bO() {
        if (this.f2630tz == null) {
            GLLib.m455bb();
        }
        if (this.f2619tA >= 0) {
            return this.f2630tz.m661i(this.f2619tA);
        }
        return -1;
    }

    private int m2117bP() {
        if (this.f2619tA >= 0) {
            return this.f2630tz.m653b(this.f2619tA, this.f2620tB) * this.f2622tD;
        }
        return 0;
    }

    private static final int m2118bS() {
        for (int i = 0; i < f2560tJ; i++) {
            try {
                if (f2596ud[i] == 0 && !m2125d(i, false)) {
                    return i;
                }
            } catch (Exception e) {
            }
        }
        return -1;
    }

    static void m2119bT() {
        if (!C0338r.f2258nh) {
            m2120bU();
        } else {
            if (f2576tZ == null || f2576tZ.isAlive()) {
                return;
            }
            f2576tZ.start();
        }
    }

    private static void m2120bU() {
        int i;
        InterfaceC0079a interfaceC0079a;
        int i2;
        int m2099aG;
        int i3;
        if (!C0338r.f2256nf || !f2564tN) {
            return;
        }
        if (C0338r.f2258nh) {
            if (f2598uf) {
                return;
            } else {
                f2598uf = true;
            }
        }
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= f2563tM) {
                break;
            }
            if (f2578uB[i5]) {
                boolean z = f2616ux[i5] >= f2617uy[i5];
                int i6 = f2617uy[i5];
                int i7 = f2616ux[i5];
                int[] iArr = f2615uw;
                f2608up = System.currentTimeMillis();
                int i8 = f2618uz[i5];
                int i9 = i8 == 0 ? f2617uy[i5] : (int) (i7 + (((i6 - i7) * (f2608up - f2577uA[i5])) / i8));
                int i10 = ((!z || i9 >= i6) && (z || i9 <= i6)) ? i9 : i6;
                f2615uw[i5] = ((InterfaceC0079a) f2614uv[i5].mo197dh("RateControl")).mo194fo(i10);
                if ((z && i10 <= i6) || (!z && i10 >= i6)) {
                    f2616ux[i5] = 0;
                    f2617uy[i5] = 0;
                    f2618uz[i5] = 0;
                    f2577uA[i5] = 0;
                    f2578uB[i5] = false;
                }
            }
            i4 = i5 + 1;
        }
        int i11 = 0;
        while (true) {
            int i12 = i11;
            if (i12 >= f2560tJ) {
                if (C0338r.f2258nh) {
                    f2598uf = false;
                    return;
                }
                return;
            }
            try {
                if (f2568tR[i12] != null && !m2125d(i12, true)) {
                    m2102aJ(i12);
                }
            } catch (Exception e) {
            }
            if (!f2604ul[i12] && !f2610ur[i12] && System.currentTimeMillis() - f2570tT[i12] > 0) {
                int[] iArr2 = f2599ug;
                if (C0338r.f2258nh && C0338r.f2259ni) {
                    m2115b(i12, iArr2);
                } else {
                    m2088a(i12, iArr2);
                }
                if (f2599ug[7] > 0) {
                    try {
                        switch (f2599ug[0]) {
                            case 0:
                                int i13 = f2599ug[1];
                                int[] iArr3 = f2599ug;
                                m2133y(i12, i13);
                                break;
                            case 1:
                                m2102aJ(i12);
                                break;
                            case 2:
                                f2568tR[i12] = null;
                                int i14 = f2599ug[6] == 0 ? f2599ug[3] : 0;
                                int i15 = f2599ug[1];
                                int i16 = f2599ug[2];
                                int i17 = f2599ug[4];
                                if (!C0338r.f2256nf || GLLib.f135iD) {
                                    f2609uq[i12] = -1;
                                } else {
                                    m2133y(i12, i15);
                                    if (!GLLib.f135iD) {
                                        if (f2573tW[i12] != 1 || f2568tR[i12] == null) {
                                            f2609uq[i12] = -1;
                                        } else {
                                            if (i17 == 0) {
                                                f2568tR[i12].mo201fm(-1);
                                            } else {
                                                f2568tR[i12].mo201fm(i17);
                                            }
                                            if (C0338r.f2267nq) {
                                                ((InterfaceC0080b) f2568tR[i12].mo197dh("VolumeControl")).mo196fn(((f2562tL * i14) * 100) / 10000);
                                            }
                                            if (C0338r.f2264nn) {
                                                f2568tR[i12].mo202k(0L);
                                            }
                                            f2568tR[i12].start();
                                            f2609uq[i12] = -1;
                                            f2573tW[i12] = 2;
                                            f2574tX[i12] = i14;
                                            f2575tY[i12] = i17;
                                            f2572tV[i12] = i16;
                                            f2571tU[i12] = i15;
                                            f2570tT[i12] = System.currentTimeMillis();
                                        }
                                    }
                                }
                                if (i14 == 0 && f2599ug[6] != 0) {
                                    m2129g(2, i12, f2599ug[3], f2599ug[6]);
                                    break;
                                }
                                break;
                            case 3:
                                m2129g(3, i12, 0, f2599ug[6]);
                                f2610ur[i12] = true;
                                break;
                            case C0217R.styleable.com_facebook_picker_fragment_done_button_text:
                                m2129g(4, i12, 0, f2599ug[6]);
                                f2610ur[i12] = true;
                                break;
                            case C0217R.styleable.com_facebook_picker_fragment_title_bar_background:
                                if (!f2610ur[i12]) {
                                    m2129g(5, i12, 0, f2599ug[6]);
                                    break;
                                }
                                break;
                            case C0217R.styleable.com_facebook_picker_fragment_done_button_background:
                                if (!f2610ur[i12]) {
                                    m2129g(7, i12, f2611us[i12], f2599ug[6]);
                                    break;
                                }
                                break;
                            case 7:
                                if (!f2610ur[i12]) {
                                    int i18 = f2599ug[5];
                                    if (C0338r.f2260nj) {
                                        InterfaceC0079a interfaceC0079a2 = f2568tR[i12] != null ? (InterfaceC0079a) f2568tR[i12].mo197dh("RateControl") : null;
                                        if (interfaceC0079a2 != null) {
                                            interfaceC0079a2.mo194fo(i18);
                                            break;
                                        }
                                    }
                                }
                                break;
                        }
                    } catch (Exception e2) {
                    }
                }
            }
            int i19 = f2612ut + GLLib.f146iP;
            f2612ut = i19;
            if (i19 >= 0) {
                int i20 = f2612ut;
                f2612ut = 0;
                long m2104aL = m2104aL(i12);
                if (m2104aL >= 0 && m2104aL <= i20 * PlacePickerFragment.DEFAULT_RADIUS_IN_METERS) {
                    f2603uk[i12] = true;
                }
                int i21 = i12 << 2;
                int i22 = f2600uh[i21];
                try {
                    m2125d(i12, true);
                    if (i22 != 0 && i22 != 1) {
                        boolean z2 = f2600uh[i21 + 3] >= f2600uh[i21 + 1];
                        int i23 = f2600uh[i21 + 1];
                        int i24 = f2600uh[i21 + 3];
                        try {
                            m2099aG = m2099aG(i12);
                            f2608up = System.currentTimeMillis();
                            i3 = f2600uh[i21 + 2];
                        } catch (Exception e3) {
                            f2574tX[i12] = i23;
                        }
                        if (i3 == 0) {
                            i2 = i23;
                        } else {
                            i2 = (i22 == 3 && GLLib.m411ad(f2566tP[f2571tU[i12]]).compareTo("audio/x-wav") == 0) ? m2099aG - 2 : (int) (i24 + (((i23 - i24) * (f2608up - f2606un[i12])) / i3));
                            if ((z2 && i2 < i23) || (!z2 && i2 > i23)) {
                                f2574tX[i12] = i23;
                                i2 = i23;
                            }
                        }
                        m2134z(i12, i2);
                        if (i22 == 7) {
                            if (f2573tW[i12] == 3) {
                                try {
                                    if (f2573tW[i12] == 3 && f2568tR[i12] != null) {
                                        f2568tR[i12].start();
                                        f2573tW[i12] = 2;
                                    }
                                } catch (Exception e4) {
                                }
                            }
                            int i25 = f2600uh[i21 + 1];
                            int i26 = f2600uh[i21 + 2];
                            if (f2564tN) {
                                if (!C0338r.f2268nr) {
                                    i26 = 0;
                                }
                                m2129g(2, i12, i25, i26);
                                f2611us[i12] = i25;
                            }
                        }
                        if ((z2 && i2 <= i23) || (!z2 && i2 >= i23)) {
                            switch (i22) {
                                case 2:
                                    f2573tW[i12] = 2;
                                    break;
                                case 3:
                                case C0217R.styleable.com_facebook_picker_fragment_done_button_text:
                                    try {
                                        if (f2568tR[i12] != null) {
                                            f2568tR[i12].stop();
                                            f2575tY[i12] = 1;
                                            f2573tW[i12] = 1;
                                            m2102aJ(i12);
                                            f2570tT[i12] = 0;
                                        }
                                        f2610ur[i12] = false;
                                        break;
                                    } catch (Exception e5) {
                                        break;
                                    }
                                case C0217R.styleable.com_facebook_picker_fragment_title_bar_background:
                                    try {
                                        if (f2568tR[i12] != null) {
                                            f2568tR[i12].stop();
                                            f2573tW[i12] = 3;
                                            break;
                                        }
                                    } catch (Exception e6) {
                                        break;
                                    }
                                    break;
                            }
                            m2129g(0, i12, 0, 0);
                            f2604ul[i12] = false;
                        }
                    }
                    int i27 = f2601ui[i21];
                    if (i27 != 0 && i27 != 1) {
                        int i28 = f2601ui[i21 + 1];
                        int i29 = -1;
                        try {
                            i29 = m2105aM(i12);
                            int i30 = 1 > (f2601ui[i21 + 2] * i20) / PlacePickerFragment.DEFAULT_RADIUS_IN_METERS ? 1 : (f2601ui[i21 + 2] * i20) / PlacePickerFragment.DEFAULT_RADIUS_IN_METERS;
                            i29 = i29 < i28 ? i28 < i29 + i30 ? i28 : i29 + i30 : i28 > i29 - i30 ? i28 : i29 - i30;
                            m2078A(i12, i29);
                        } catch (Exception e7) {
                            m2130h(0, i12, 0, 0);
                        }
                        if (i29 >= 0) {
                        }
                        m2130h(1, i12, 0, 0);
                    } else if (f2603uk[i12] && i27 == 1) {
                        try {
                            int i31 = f2601ui[i21 + 1];
                            int m2105aM = m2105aM(i12);
                            if ((m2105aM - i31 < 0 ? -(m2105aM - i31) : m2105aM - i31) >= 500) {
                                m2078A(i12, i31);
                            }
                        } catch (Exception e8) {
                        }
                    }
                    int i32 = f2602uj[i21];
                    if (i32 != 0 && i32 != 1) {
                        boolean z3 = f2602uj[i21 + 3] >= f2602uj[i21 + 1];
                        int i33 = f2602uj[i21 + 1];
                        int i34 = f2602uj[i21 + 3];
                        try {
                            m2106aN(i12);
                            f2608up = System.currentTimeMillis();
                            int i35 = f2602uj[i21 + 2];
                            int i36 = i35 == 0 ? i33 : (int) (i34 + (((i33 - i34) * (f2608up - f2607uo[i12])) / i35));
                            if ((z3 && i36 < i33) || (!z3 && i36 > i33)) {
                                i36 = i33;
                            }
                            i = i36;
                        } catch (Exception e9) {
                            i = i33;
                        }
                        if (f2568tR[i12] != null && (interfaceC0079a = (InterfaceC0079a) f2568tR[i12].mo197dh("RateControl")) != null) {
                            interfaceC0079a.mo194fo(i);
                        }
                        if ((z3 && i <= i33) || (!z3 && i >= i33)) {
                            boolean z4 = C0338r.f2268nr;
                            if (C0338r.f2260nj) {
                                int i37 = i12 << 2;
                                f2602uj[i37] = 0;
                                f2602uj[i37 + 1] = 0;
                                f2602uj[i37 + 2] = 0;
                                f2602uj[i37 + 3] = m2106aN(i12) != -1 ? m2106aN(i12) : 100000;
                                f2607uo[i12] = System.currentTimeMillis();
                                f2605um[i12] = true;
                            }
                            f2605um[i12] = false;
                        }
                    }
                    f2603uk[i12] = false;
                } catch (Exception e10) {
                }
            }
            i11 = i12 + 1;
        }
    }

    static void m2121bV() {
        m2103aK(500);
    }

    static void m2122bW() {
        if (C0338r.f2266np) {
            boolean z = f2567tQ;
            try {
                m2103aK(0);
                if (C0338r.f2258nh && GLLib.f135iD) {
                    m2120bU();
                }
            } catch (Exception e) {
            }
        }
    }

    private static void m2123c(int i, int i2, int i3, int i4, int i5) {
        int i6;
        C0048ac c0048ac = f2590uN[i][0];
        c0048ac.setColor(f2587uK[i][4]);
        int i7 = f2587uK[i][7];
        int i8 = f2587uK[i][8];
        int i9 = i2 % i7;
        if (i9 < 0) {
            i9 += i7;
        }
        int i10 = i3 % i8;
        int i11 = i10 < 0 ? i10 + i8 : i10;
        if (i9 + i4 > i7) {
            if (i11 + i5 > i8) {
                GLLib.m438b(c0048ac, 0.0f, 0.0f, (i9 + i4) - i7, (i11 + i5) - i8);
                int i12 = (i9 + i4) - i7;
                int i13 = (i11 + i5) - i8;
                i6 = i8 - i11;
            } else {
                i6 = i5;
            }
            GLLib.m438b(c0048ac, 0.0f, i11, (i9 + i4) - i7, i6);
            int i14 = (i9 + i4) - i7;
            i4 = i7 - i9;
        }
        if (i11 + i5 > i8) {
            GLLib.m438b(c0048ac, i9, 0.0f, i4, (i11 + i5) - i8);
            int i15 = (i11 + i5) - i8;
            i5 = i8 - i11;
        }
        GLLib.m438b(c0048ac, i9, i11, i4, i5);
    }

    private static void m2124c(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (C0338r.f2258nh && C0338r.f2259ni) {
            m2114b(i, i2, i3, i4, i5, i6, i7, i8);
        } else {
            m2083a(i, i2, i3, i4, i5, i6, i7, i8);
        }
    }

    private static boolean m2125d(int i, boolean z) {
        if (!C0338r.f2256nf || !f2564tN || i >= f2560tJ) {
            return false;
        }
        if (f2568tR[i] == null && f2609uq[i] == -1) {
            return false;
        }
        boolean z2 = true;
        if ((f2568tR[i] != null && f2568tR[i].getState() != 400 && f2609uq[i] == -1) || (f2610ur[i] && !z)) {
            z2 = false;
        }
        return z2;
    }

    private static final void m2126e(int i, int i2, int i3, int i4) {
        m2124c(i, i2, -1, -1, -1, -1, -1, i4);
    }

    private static void m2127e(int i, boolean z) {
        if (f2579uC) {
            f2587uK[i] = new int[f2584uH];
            if (z) {
                f2589uM[i] = new C0277ad[1];
                f2590uN[i] = new C0048ac[1];
            }
            if (C0338r.f2304ob && f2588uL == null) {
                return;
            }
            f2588uL[i] = new byte[2][];
            f2591uO[i] = null;
        }
    }

    static int m2128f(int i, int i2, int i3, int i4) {
        return m2081a(i, i2, i3, i4, false, 0);
    }

    private static void m2129g(int i, int i2, int i3, int i4) {
        int i5 = i2 << 2;
        if (!C0338r.f2268nr) {
            i4 = 0;
        }
        f2600uh[i5] = i;
        f2600uh[i5 + 1] = i3;
        f2600uh[i5 + 2] = i4;
        f2600uh[i5 + 3] = m2099aG(i2);
        f2606un[i2] = System.currentTimeMillis();
        f2604ul[i2] = true;
    }

    private static void m2130h(int i, int i2, int i3, int i4) {
        boolean z = C0338r.f2268nr;
        int i5 = i2 << 2;
        f2601ui[i5] = i;
        if (i != 1) {
            f2601ui[i5 + 1] = 0;
            f2601ui[i5 + 2] = 0;
        }
    }

    static void m2131i(int i, int i2, int i3, int i4) {
        f2586uJ = new int[8];
        f2587uK = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, f2580uD, f2584uH);
        f2589uM = (C0277ad[][]) Array.newInstance((Class<?>) C0277ad.class, f2580uD, 1);
        f2590uN = (C0048ac[][]) Array.newInstance((Class<?>) C0048ac.class, f2580uD, 1);
        if (!C0338r.f2304ob || (i3 > 0 && i4 > 0)) {
            f2588uL = (byte[][][]) Array.newInstance((Class<?>) byte[].class, f2580uD, 2);
            f2591uO = new C0271a[f2580uD];
            f2586uJ[2] = i3;
            f2586uJ[4] = 0;
            f2586uJ[5] = i4;
            f2586uJ[7] = 0;
        }
        f2586uJ[0] = i;
        f2586uJ[1] = i2;
        f2579uC = true;
    }

    private static final void m2132j(int i, int i2, int i3, int i4) {
        f2588uL[i][i2][i3] = (byte) i4;
    }

    private static void m2133y(int i, int i2) {
        if (C0338r.f2256nf) {
            int[] iArr = f2571tU;
            m2102aJ(i);
            if (f2568tR[i] == null) {
                if (f2565tO[i2] == null) {
                    return;
                }
                C0082c.m199an(f2613uu[i2]);
                InterfaceC0084e[] interfaceC0084eArr = f2568tR;
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(f2565tO[i2]);
                GLLib.m411ad(f2566tP[i2]);
                interfaceC0084eArr[i] = C0082c.m200i(byteArrayInputStream);
            }
            if (f2568tR[i] != null) {
                InterfaceC0084e[] interfaceC0084eArr2 = f2568tR;
                f2568tR[i].mo204ut();
                f2573tW[i] = 1;
                f2571tU[i] = i2;
            }
        }
    }

    private static void m2134z(int i, int i2) {
        if (C0338r.f2256nf && f2564tN && f2568tR[i] != null) {
            try {
                if (f2568tR[i] == null || !C0338r.f2267nq) {
                    return;
                }
                ((InterfaceC0080b) f2568tR[i].mo197dh("VolumeControl")).mo196fn(((f2562tL * i2) * 100) / 10000);
                f2574tX[i] = i2;
            } catch (Exception e) {
            }
        }
    }

    final void m2135a(C0271a c0271a) {
        this.f2630tz = c0271a;
        if (c0271a != null) {
            m2143x(-1, -1);
        } else {
            this.f2619tA = -1;
        }
    }

    final void m2136aA(int i) {
        if (this.f2624tF || this.f2619tA < 0) {
            return;
        }
        int m2117bP = m2117bP();
        if (C0338r.f2418ql && m2117bP == 0) {
            return;
        }
        while (true) {
            if (this.f2621tC < m2117bP) {
                break;
            }
            this.f2621tC -= m2117bP;
            if (this.f2620tB < this.f2630tz.m661i(this.f2619tA) - 1) {
                this.f2620tB++;
            } else if (this.f2623tE == 0) {
                this.f2624tF = true;
                break;
            } else {
                if (this.f2623tE > 0) {
                    this.f2623tE--;
                }
                this.f2620tB = 0;
            }
            m2117bP = m2117bP();
            if (C0338r.f2418ql && m2117bP == 0) {
                break;
            }
        }
        this.f2621tC += i;
    }

    final void m2137az(int i) {
        switch (i) {
            case 0:
                this.f2629ty = 0;
                break;
            case 1:
                this.f2629ty = 2;
                break;
            case 2:
                this.f2629ty = 1;
                break;
            case 3:
                this.f2629ty = 3;
                break;
            case C0217R.styleable.com_facebook_picker_fragment_done_button_text:
                this.f2629ty = 5;
                break;
            case C0217R.styleable.com_facebook_picker_fragment_title_bar_background:
                this.f2629ty = 4;
                break;
            case C0217R.styleable.com_facebook_picker_fragment_done_button_background:
                this.f2629ty = 7;
                break;
            case 7:
                this.f2629ty = 6;
                break;
        }
    }

    final void m2138bL() {
        this.f2627tw = 0;
        this.f2628tx = 0;
        this.f2619tA = -1;
        this.f2620tB = 0;
        this.f2630tz = null;
        this.f2629ty = 0;
        this.f2621tC = 0;
        this.f2623tE = 1;
        this.f2626tI = -1;
        this.f2624tF = true;
        if (C0338r.f2439rG) {
            this.f2625tG = -1;
        }
    }

    final void m2139bM() {
        this.f2620tB = GLLib.m504p(0, m2116bO());
        this.f2621tC = 0;
    }

    final int m2140bN() {
        if (this.f2630tz == null || this.f2619tA == -1) {
            return -1;
        }
        return this.f2630tz.m660h(this.f2619tA, this.f2620tB);
    }

    final boolean m2141bQ() {
        if (this.f2619tA < 0) {
            return true;
        }
        if (this.f2623tE < 0) {
            return false;
        }
        return this.f2624tF;
    }

    final void m2142bR() {
        boolean z;
        if (this.f2619tA >= 0 && !this.f2624tF) {
            if (C0338r.f2439rG && C0338r.f2439rG && this.f2625tG != -1 && this.f2625tG != 100) {
                if (!((GLLib.f233kY & 262144) != 0)) {
                    GLLib.m437b(18, false);
                    GLLib.m422ao(this.f2625tG);
                    z = true;
                    if (this.f2626tI == -1) {
                        int m652ac = this.f2630tz.m652ac();
                        this.f2630tz.m673z(this.f2626tI);
                        this.f2630tz.m644a(GLLib.f134iC, this.f2619tA, this.f2620tB, this.f2627tw, this.f2628tx, this.f2629ty);
                        this.f2630tz.m673z(m652ac);
                    } else {
                        this.f2630tz.m644a(GLLib.f134iC, this.f2619tA, this.f2620tB, this.f2627tw, this.f2628tx, this.f2629ty);
                    }
                    if (C0338r.f2439rG || !z) {
                    }
                    GLLib.f233kY &= -841697;
                    return;
                }
            }
            z = false;
            if (this.f2626tI == -1) {
            }
            if (C0338r.f2439rG) {
            }
        }
    }

    @Override
    public final void run() {
        while (f2576tZ != null) {
            m2120bU();
            try {
                Thread.sleep(PlacePickerFragment.DEFAULT_RADIUS_IN_METERS / C0338r.f2207mi);
            } catch (Exception e) {
            }
        }
    }

    final void m2143x(int i, int i2) {
        if (this.f2630tz == null) {
            GLLib.m455bb();
        }
        if (i >= this.f2630tz.m636U()) {
            GLLib.m455bb();
        }
        if (i2 == 0) {
            GLLib.m455bb();
        }
        if (this.f2624tF || i != this.f2619tA) {
            this.f2619tA = i;
            this.f2622tD = f2559tH;
            if (this.f2619tA >= 0) {
                this.f2620tB = 0 % m2116bO();
                this.f2621tC = 0;
            }
            this.f2623tE = i2 - 1;
            this.f2624tF = false;
        }
    }
}
