package com.gameloft.android.LATAM.GloftGF2H;

import com.facebook.android.C0217R;
import com.facebook.internal.Utility;
import com.facebook.widget.WorkQueue;
import java.lang.reflect.Array;
import p009b.p010a.p012b.C0048ac;

public final class C0271a {

    private static char[] f367bd;

    private static boolean f368be;

    private static boolean f369bf;

    static int[] f370bg;

    private static byte[] f371bh;

    private static int[] f372bi;

    private static int f374cG;

    private static int f375cH;

    private static int f376cI;

    private static int f377cJ;

    private static int[][] f385cT;

    private static int[] f386cU;

    private static C0271a[][] f387cV;

    private static int f388cW;

    static int f389cX;

    private static int f390cY;

    private static short[] f398dk;

    private short[] f405bA;

    private byte[] f406bB;

    private short[] f407bC;

    private short[] f408bD;

    private byte[] f409bE;

    private byte[] f410bF;

    private short[] f411bG;

    private byte[] f412bH;

    private short[] f413bI;

    private short[] f414bJ;

    private byte[] f415bK;

    private byte[] f416bL;

    private byte[] f417bM;

    private short[] f418bN;

    private byte[] f419bO;

    private byte[] f420bP;

    private byte[] f421bQ;

    private short[] f422bR;

    private short[] f423bS;

    private byte[] f424bT;

    private byte[] f425bU;

    private byte[] f426bV;

    private short[][] f427bW;

    private short[][] f428bX;

    private byte[][] f429bY;

    private int f430bZ;

    private int f431bj;

    private byte[] f432bk;

    private byte[] f433bl;

    private short[] f434bm;

    private short[] f435bn;

    short[] f436bo;

    short[] f437bp;

    byte[] f438bq;

    byte[] f439br;

    private short[] f440bs;

    private short[] f441bt;

    private byte[] f442bu;

    private short[] f443bv;

    short[] f444bw;

    private byte[] f445bx;

    private short[] f446by;

    private byte[] f447bz;

    private byte[] f448cB;

    private byte[] f449cC;

    private int[] f450cD;

    private byte f451cE;

    private byte[][] f452cF;

    private byte[] f456ca;

    private int[] f457cb;

    private byte[][] f458cc;

    int f459cd;

    private int f460ce;

    private short[] f461cf;

    private int[][][] f462cg;

    private byte[] f463ch;

    int f464ci;

    int[] f465cj;

    private int[] f466ck;

    private int[] f467cl;

    private int f468cm;

    private short f469cn;

    private int[] f470co;

    private int[] f471cp;

    private C0277ad[][] f472ct;

    private int f475da;

    private int f476db;

    private int f477dc;

    private int f479de;

    private int[][] f482dh;

    private int f483di;

    static int f391cq = C0338r.f2166lT;

    static int f392cr = C0338r.f2167lU;

    private static int f393cs = 0;

    private static float[] f394cw = new float[8];

    private static int[] f395cx = {0, 2, 1, 3, 5, 7, 4, 6};

    private static int[] f396cy = {1, 0, 3, 2, 6, 7, 4, 5};

    private static int[] f397cz = {2, 3, 0, 1, 5, 4, 7, 6};

    private static int[] f373cA = {4, 5, 6, 7, 3, 2, 1, 0};

    private static int[] f378cK = new int[4];

    private static boolean f379cL = true;

    static boolean f380cM = false;

    private static char f381cN = '|';

    private static boolean f382cO = false;

    private static int f383cP = -1;

    private static int f384cQ = -1;

    private static int f399dl = -1;

    private static int f400dm = -1;

    private static int f401dn = -1;

    private static int f402do = -1;

    private static int f403dp = -1;

    private static int f404dq = 0;

    private int f473cu = 0;

    private int f474cv = 0;

    private int f453cR = 0;

    private int f454cS = -1;

    private boolean f455cZ = false;

    private int f478dd = 0;

    private boolean f480df = false;

    private boolean f481dg = false;

    private int f484dj = -1;

    private boolean f485dr = true;

    private int f486ds = 0;

    private void m602A(int i) {
        if (this.f462cg == null) {
            this.f462cg = (int[][][]) Array.newInstance((Class<?>) int[].class, i, C0338r.f2313ok);
        }
    }

    private int m603B(int i) {
        return this.f467cl[i];
    }

    private int m604D(int i) {
        if (this.f441bt != null) {
            for (int i2 = 0; i2 < this.f441bt.length; i2 += 2) {
                if (this.f441bt[i2] == i) {
                    return this.f441bt[i2 + 1];
                }
            }
        }
        return -1;
    }

    private int m605Z() {
        return (!C0338r.f2439rG || this.f484dj < 0) ? this.f477dc : (this.f477dc * this.f484dj) >> 8;
    }

    private int m606a(int i, byte[] bArr, int i2, int i3, int i4) {
        int i5;
        int i6 = 0;
        int i7 = i;
        while (true) {
            if (i6 >= ((this.f459cd & 1073741824) != 0 ? this.f465cj[i4] : this.f464ci)) {
                return i7;
            }
            this.f462cg[i4][i6] = new int[i3];
            int[] iArr = this.f462cg[i4][i6];
            if (C0338r.f2283oG && i2 == -30584) {
                int i8 = 0;
                while (i8 < i3) {
                    int i9 = i7 + 1;
                    int i10 = i9 + 1;
                    int i11 = i10 + 1;
                    iArr[i8] = (bArr[i7] & 255) + ((bArr[i9] & 255) << 8) + ((bArr[i10] & 255) << 16) + ((bArr[i11] & 255) << 24);
                    i8++;
                    i7 = i11 + 1;
                }
                i5 = i7;
            } else if (C0338r.f2286oJ && i2 == 21781) {
                int i12 = 0;
                while (i12 < i3) {
                    int i13 = i7 + 1;
                    int i14 = i13 + 1;
                    short s = (short) ((bArr[i7] & 255) + ((bArr[i13] & 255) << 8));
                    int i15 = ((32768 & s) != 32768 ? 0 : -16777216) | ((s & 31744) << 9) | ((s & 992) << 6) | ((s & 31) << 3);
                    if (i15 == 16253176) {
                        i15 = 16711935;
                    }
                    iArr[i12] = i15;
                    i12++;
                    i7 = i14;
                }
                i5 = i7;
            } else if (C0338r.f2287oK && i2 == 25861) {
                int i16 = 0;
                while (i16 < i3) {
                    int i17 = i7 + 1;
                    int i18 = i17 + 1;
                    short s2 = (short) ((bArr[i7] & 255) + ((bArr[i17] & 255) << 8));
                    int i19 = ((65535 & s2) == 63519 ? 0 : -16777216) | ((63488 & s2) << 8) | ((s2 & 2016) << 5) | ((s2 & 31) << 3);
                    if (i19 == 16253176) {
                        i19 = 16711935;
                    }
                    iArr[i16] = i19;
                    i16++;
                    i7 = i18;
                }
                i5 = i7;
            } else {
                if (C0338r.f2284oH && i2 == -30712) {
                    int i20 = 0;
                    while (i20 < i3) {
                        int i21 = i7 + 1;
                        int i22 = i21 + 1;
                        int i23 = (bArr[i7] & 255) + ((bArr[i21] & 255) << 8);
                        int i24 = i22 + 1;
                        int i25 = i23 + ((bArr[i22] & 255) << 16);
                        if (i25 != 16711935) {
                            i25 |= -16777216;
                        }
                        iArr[i20] = i25;
                        i20++;
                        i7 = i24;
                    }
                }
                i5 = i7;
            }
            if (GLLib.m452bH()) {
                C0286am m453bI = GLLib.m453bI();
                int[] iArr2 = (int[]) m624i(i4, i6);
                for (int i26 = 0; i26 < iArr2.length; i26++) {
                    if ((iArr2[i26] & 16777215) != 16711935 && (iArr2[i26] >> 24) != 0) {
                        iArr2[i26] = GLLib.m363a(iArr2[i26], m453bI);
                    }
                }
            }
            i6++;
            i7 = i5;
        }
    }

    private static int m607a(short[] sArr, int i) {
        return sArr[((C0338r.f2409qc ? 5 : 4) * i) + 3];
    }

    private void m608a(C0048ac c0048ac, int i, float f, float f2, int i2, int[] iArr) {
        float f3;
        boolean z;
        boolean z2;
        float f4;
        float f5;
        float f6;
        float f7;
        int i3;
        int i4;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        float f13;
        if (C0338r.f2328oz && this.f430bZ >= 0) {
            i = this.f427bW[this.f430bZ][i] & 65535;
        }
        float f14 = iArr[0];
        float f15 = iArr[1];
        if ((i2 & 4) == 0) {
            f14 = f15;
            f15 = f14;
        }
        int i5 = f404dq;
        if (C0338r.f2333pE) {
            if (((!C0338r.f2333pE || this.f448cB == null) ? (byte) 0 : this.f448cB[i]) != 0 && c0048ac != null) {
                if (C0338r.f2439rG) {
                    if ((GLLib.f233kY & 262144) != 0) {
                        int m475bv = GLLib.m475bv();
                        int m476bw = GLLib.m476bw();
                        f15 = (f15 * m475bv) / 100.0f;
                        f14 = (f14 * m476bw) / 100.0f;
                        if (GLLib.f234kZ[18][5] != 0) {
                            float f16 = (m475bv * f) / 100.0f;
                            float f17 = (m476bw * f2) / 100.0f;
                            f4 = f15;
                            f5 = f14;
                            f6 = f17;
                            f7 = f16;
                            int i6 = this.f450cD[i];
                            GLLib.m412ae(i6);
                            switch (this.f448cB[i]) {
                                case 1:
                                    GLLib.m486c(c0048ac, f7, f6, f4 - 1.0f, f5 - 1.0f);
                                    break;
                                case 2:
                                    if (((-16777216) & i6) != -16777216 && ((-16777216) & i6) != 0) {
                                        GLLib.m421an(i6);
                                        GLLib.m500f(c0048ac, f7, f6, f4, f5);
                                        break;
                                    } else {
                                        GLLib.m438b(c0048ac, f7, f6, f4, f5);
                                        break;
                                    }
                                    break;
                                case 3:
                                case C0217R.styleable.com_facebook_picker_fragment_done_button_text:
                                    int m604D = m604D(i);
                                    if (m604D != -1) {
                                        short s = this.f440bs[m604D];
                                        short s2 = this.f440bs[m604D + 1];
                                        int i7 = s;
                                        if ((i2 & 1) != 0) {
                                            i7 = 90 - s;
                                        }
                                        int i8 = i7;
                                        int i9 = s2;
                                        if ((i2 & 2) != 0) {
                                            i8 = -i7;
                                            i9 = -s2;
                                        }
                                        int i10 = i8;
                                        if ((i2 & 4) != 0) {
                                            i10 = i8 - 90;
                                        }
                                        if (this.f448cB[i] != 3) {
                                            GLLib.m384a(c0048ac, f7, f6, f4, f5, i10, i9);
                                            break;
                                        } else {
                                            GLLib.m439b(c0048ac, f7, f6, f4, f5, i10, i9);
                                            break;
                                        }
                                    }
                                    break;
                                case C0217R.styleable.com_facebook_picker_fragment_done_button_background:
                                case 7:
                                    int m604D2 = m604D(i);
                                    if (m604D2 != -1) {
                                        float f18 = this.f440bs[m604D2];
                                        float f19 = this.f440bs[m604D2 + 1];
                                        float f20 = this.f440bs[m604D2 + 2];
                                        float f21 = this.f440bs[m604D2 + 3];
                                        if (C0338r.f2439rG) {
                                            if ((GLLib.f233kY & 262144) != 0) {
                                                int m475bv2 = GLLib.m475bv();
                                                int m476bw2 = GLLib.m476bw();
                                                f18 = (m475bv2 * f18) / 100.0f;
                                                f19 = (m476bw2 * f19) / 100.0f;
                                                f20 = (m475bv2 * f20) / 100.0f;
                                                f21 = (m476bw2 * f21) / 100.0f;
                                            }
                                        }
                                        if ((i2 & 1) != 0) {
                                            f18 = -f18;
                                            f20 = -f20;
                                            f8 = f7 + (Math.abs(f18) > Math.abs(f20) ? Math.abs(f18) : Math.abs(f20));
                                        } else {
                                            f8 = f7;
                                        }
                                        if ((i2 & 2) != 0) {
                                            f19 = -f19;
                                            f21 = -f21;
                                            f9 = f6 + (Math.abs(f19) > Math.abs(f21) ? Math.abs(f19) : Math.abs(f21));
                                        } else {
                                            f9 = f6;
                                        }
                                        if ((i2 & 4) != 0) {
                                            float f22 = f9 - f6;
                                            f10 = f6 + (f8 - f7);
                                            f11 = (f7 - f22) + (Math.abs(f19) > Math.abs(f21) ? Math.abs(f19) : Math.abs(f21));
                                            f13 = f18;
                                            f18 = -f19;
                                            float f23 = f20;
                                            f20 = -f21;
                                            f12 = f23;
                                        } else {
                                            f10 = f9;
                                            f11 = f8;
                                            f12 = f21;
                                            f13 = f19;
                                        }
                                        if (this.f448cB[i] != 6) {
                                            GLLib.m383a(c0048ac, f11, f10, f11 + f18, f13 + f10, f20 + f11, f10 + f12);
                                            break;
                                        } else {
                                            GLLib.m382a(c0048ac, f11, f10, f11 + f18, f10 + f13);
                                            GLLib.m382a(c0048ac, f11 + f18, f13 + f10, f11 + f20, f10 + f12);
                                            GLLib.m382a(c0048ac, f11, f10, f11 + f20, f12 + f10);
                                            break;
                                        }
                                    }
                                    break;
                                case WorkQueue.DEFAULT_MAX_CONCURRENT:
                                    float f24 = f7 + f4;
                                    float f25 = f6 + f5;
                                    if ((i2 & 1) == 0) {
                                        f24 = f7;
                                        f7 = f24;
                                    }
                                    if ((i2 & 2) == 0) {
                                        f25 = f6;
                                        f6 = f25;
                                    }
                                    if ((i2 & 4) == 0) {
                                        float f26 = f7;
                                        f7 = f24;
                                        f24 = f26;
                                    }
                                    GLLib.m382a(c0048ac, f7, f25, f24, f6);
                                    break;
                                case 9:
                                    int m604D3 = m604D(i);
                                    if (m604D3 != -1) {
                                        int i11 = (this.f440bs[m604D3] & 65535) | ((this.f440bs[m604D3 + 1] << 16) & (-65536));
                                        short s3 = this.f440bs[m604D3 + 2];
                                        if ((i2 & 1) == 0 || s3 >= 2) {
                                            i3 = i6;
                                            i6 = i11;
                                        } else {
                                            i3 = i11;
                                        }
                                        if ((i2 & 2) == 0 || s3 <= 1) {
                                            i4 = i3;
                                            i3 = i6;
                                        } else {
                                            i4 = i6;
                                        }
                                        int i12 = s3 == 0 ? 4 : s3 == 1 ? 8 : s3 == 2 ? 16 : 32;
                                        if ((i2 & 4) != 0) {
                                            if (i12 == 4) {
                                                i12 = 16;
                                            } else if (i12 == 8) {
                                                i12 = 32;
                                            } else if (i12 == 16) {
                                                i12 = 8;
                                            } else if (i12 == 32) {
                                                i12 = 4;
                                            }
                                        }
                                        if ((i4 >>> 24) != 255 || (i3 >>> 24) != 255) {
                                            GLLib.m440b(c0048ac, f7 + 0.0f, f6 + 0.0f, f4, f5, i4, i3, i12);
                                            break;
                                        } else {
                                            GLLib.m385a(c0048ac, f7 + 0.0f, f6 + 0.0f, f4, f5, i4, i3, i12);
                                            break;
                                        }
                                    }
                                    break;
                            }
                            return;
                        }
                    }
                }
                f4 = f15;
                f5 = f14;
                f6 = f2;
                f7 = f;
                int i62 = this.f450cD[i];
                GLLib.m412ae(i62);
                switch (this.f448cB[i]) {
                }
                return;
            }
        }
        if (!C0338r.f2323ou || (this.f459cd & 536870912) == 0) {
            return;
        }
        if ((i2 & 4) != 0) {
            f3 = f15;
            f15 = f14;
        } else {
            f3 = f14;
        }
        int i13 = (!C0338r.f2357pc || (this.f459cd & 32) == 0) ? (!C0338r.f2356pb || (this.f459cd & 2) == 0) ? 0 : this.f432bk[i] & 255 : 65535 & this.f434bm[i];
        int i14 = (!C0338r.f2357pc || (this.f459cd & 32) == 0) ? (!C0338r.f2356pb || (this.f459cd & 2) == 0) ? 0 : this.f433bl[i] & 255 : 65535 & this.f435bn[i];
        byte b2 = this.f449cC == null ? (byte) 0 : this.f449cC[i];
        C0277ad c0277ad = this.f472ct[this.f467cl[b2]][b2];
        int i15 = f395cx[i2 & 7];
        if (c0277ad != null) {
            if (C0338r.f2439rG) {
                if ((GLLib.f233kY & 262144) != 0) {
                    GLLib.m378a(GLLib.m475bv(), GLLib.m476bw(), GLLib.f234kZ[18][5] != 0);
                    int i16 = GLLib.f234kZ[18][2] & 255;
                    if (i16 != 255) {
                        GLLib.m493d(255, 255, 255, i16);
                        z = true;
                        z2 = true;
                    } else {
                        z = false;
                        z2 = true;
                    }
                    if (C0338r.f2439rG) {
                        if (((GLLib.f233kY & 262144) != 0) && GLLib.f234kZ[18][9] != 255) {
                            GLLib.m415ah(2);
                        }
                    }
                    GLLib.m388a(c0048ac, c0277ad, i13, i14, (int) f15, (int) f3, f395cx[i2 & 7], f, f2, 20);
                    if (z2) {
                        GLLib.m378a(100.0f, 100.0f, false);
                    }
                    if (z) {
                        GLLib.m493d(255, 255, 255, 255);
                    }
                    GLLib.m415ah(0);
                }
            }
            z = false;
            z2 = false;
            if (C0338r.f2439rG) {
            }
            GLLib.m388a(c0048ac, c0277ad, i13, i14, (int) f15, (int) f3, f395cx[i2 & 7], f, f2, 20);
            if (z2) {
            }
            if (z) {
            }
            GLLib.m415ah(0);
        }
    }

    private void m609a(C0048ac c0048ac, String str, int i, int i2, int i3, boolean z) {
        m610a(c0048ac, str, null, i, i2, i3, -1, z, true, false);
    }

    private void m610a(C0048ac c0048ac, String str, char[] cArr, int i, int i2, int i3, int i4, boolean z, boolean z2, boolean z3) {
        int i5;
        int i6;
        int i7;
        boolean z4;
        char[] cArr2;
        String str2;
        int i8;
        int i9;
        char c;
        int i10;
        char[] cArr3;
        boolean z5;
        boolean z6 = str != null;
        if (str == null && cArr == null) {
            return;
        }
        if (z3) {
            i5 = i2;
            i6 = i;
        } else {
            i5 = (!C0338r.f2439rG || this.f484dj < 0) ? i2 + this.f479de : i2 + ((this.f479de * this.f484dj) >> 8);
            if (z2) {
                m647a(str, cArr);
            }
            if ((i3 & 43) != 0) {
                if (!z2) {
                    m647a(str, cArr);
                }
                if ((i3 & 8) != 0) {
                    i -= f389cX;
                } else if ((i3 & 1) != 0) {
                    i -= f389cX >> 1;
                }
                if ((i3 & 32) != 0) {
                    i5 -= f390cY;
                    i6 = i;
                } else if ((i3 & 2) != 0) {
                    i5 -= f390cY >> 1;
                    i6 = i;
                }
            }
            i6 = i;
        }
        if (z) {
            f388cW = this.f467cl[0];
        }
        int i11 = f399dl >= 0 ? f399dl : 0;
        int length = z6 ? f400dm >= 0 ? f400dm : str.length() : f400dm >= 0 ? f400dm : cArr.length;
        if (f401dn >= 0 && length > f401dn) {
            length = f401dn;
        }
        if (length > i11) {
            if (f368be) {
                int i12 = (length - i11) + 4;
                if (f367bd == null) {
                    f367bd = new char[Math.max(1024, i12)];
                }
                if (f367bd.length < i12) {
                    f367bd = new char[i12];
                }
                if (cArr == null) {
                    str.getChars(i11, length, f367bd, 2);
                    z5 = false;
                    str = null;
                    cArr3 = f367bd;
                } else {
                    GLLib.m390a(cArr, i11, f367bd, 2, length - i11);
                    boolean z7 = z6;
                    cArr3 = f367bd;
                    z5 = z7;
                }
                f367bd[0] = 1;
                f367bd[1] = (char) this.f467cl[0];
                f367bd[i12 - 2] = 1;
                f367bd[i12 - 1] = (char) this.f467cl[0];
                i11 = 0;
                GLLib.m398a(cArr3, i12, true, true);
                i7 = i12;
                z4 = z5;
                cArr2 = cArr3;
                str2 = str;
            } else {
                i7 = length;
                z4 = z6;
                cArr2 = cArr;
                str2 = str;
            }
            if (i4 != -1) {
                boolean z8 = f368be;
                boolean z9 = f369bf;
                f369bf = false;
                int i13 = this.f467cl[0];
                m628m(0, i4);
                f368be = false;
                m620e(false);
                int i14 = f399dl;
                int i15 = f400dm;
                f399dl = i11;
                f400dm = i7;
                m610a(c0048ac, str2, cArr2, i6 - 1, i5 - 1, 0, -1, false, false, true);
                m610a(c0048ac, str2, cArr2, i6 - 1, i5 + 1, 0, -1, false, false, true);
                m610a(c0048ac, str2, cArr2, i6 + 1, i5 + 1, 0, -1, false, false, true);
                m610a(c0048ac, str2, cArr2, i6 + 1, i5 - 1, 0, -1, false, false, true);
                f399dl = i14;
                f400dm = i15;
                m620e(!z9);
                f368be = z8;
                m628m(0, i13);
            }
            int i16 = i11;
            int i17 = i6;
            while (i16 < i7) {
                char charAt = z4 ? str2.charAt(i16) : cArr2[i16];
                if (C0338r.f2329pA && charAt == '\\') {
                    i16++;
                    char charAt2 = z4 ? str2.charAt(i16) : cArr2[i16];
                    if (charAt2 == '_') {
                        this.f480df = !this.f480df;
                        i9 = i5;
                    } else if (charAt2 == '^') {
                        this.f481dg = !this.f481dg;
                        i9 = i5;
                    } else {
                        int i18 = charAt2 & 255;
                        if (!f369bf) {
                            m628m(0, i18 - 48);
                        }
                        i9 = i5;
                    }
                } else {
                    if (!C0338r.f2411qe || charAt != f381cN) {
                        if (charAt > ' ') {
                            int m632x = m632x(charAt);
                            i8 = i16;
                            c = m632x;
                        } else if (charAt == ' ') {
                            if (this.f480df) {
                                m642a(c0048ac, m632x(95), ((m605Z() - m633y(r9)) >> 1) + i17, i5, 0);
                            }
                            i17 += m605Z();
                            i9 = i5;
                        } else if (charAt == '\n') {
                            i9 = m639X() + m651ab() + i5;
                            i17 = i6;
                        } else if (charAt == 1) {
                            i16++;
                            char charAt3 = z4 ? str2.charAt(i16) : cArr2[i16];
                            if (charAt3 < this.f464ci && !f369bf) {
                                m628m(0, charAt3);
                            }
                            if (charAt3 == 255 && !f369bf) {
                                this.f467cl[0] = f388cW;
                                i9 = i5;
                            }
                        } else if (charAt == 2) {
                            i8 = i16 + 1;
                            c = z4 ? str2.charAt(i8) : cArr2[i8];
                        }
                        m642a(c0048ac, c, i17, i5, 0);
                        if (this.f480df) {
                            m642a(c0048ac, m632x(95), ((m633y(c) - m633y(r12)) >> 1) + i17, i5, 0);
                        }
                        if (this.f481dg) {
                            i10 = i17 + 1;
                            m642a(c0048ac, c, i10, i5, 0);
                        } else {
                            i10 = i17;
                        }
                        i17 = i10 + m633y(c) + m615aa();
                        i16 = i8;
                        i9 = i5;
                    }
                    i9 = i5;
                }
                i16++;
                i5 = i9;
            }
            if (z) {
                this.f467cl[0] = f388cW;
            }
        }
    }

    private void m611a(int[] iArr, int i, int i2, int i3, int i4, boolean z) {
        m612a(iArr, i, 0, 0, 0, false, true);
    }

    private void m612a(int[] iArr, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int i5;
        int i6;
        if (!C0338r.f2319oq || z2) {
            f374cG = Integer.MAX_VALUE;
            f375cH = Integer.MAX_VALUE;
            f376cI = Integer.MIN_VALUE;
            f377cJ = Integer.MIN_VALUE;
            f404dq = 1;
            m642a((C0048ac) null, i, i2, i3, i4);
            f404dq = 0;
        } else {
            int m668p = m668p(i);
            int m669q = m669q(i);
            int m666n = m666n(i);
            int m667o = m667o(i);
            if ((i4 & 1) != 0) {
                m668p = (-m668p) - m666n;
            }
            if ((i4 & 2) != 0) {
                m669q = (-m669q) - m667o;
            }
            if ((i4 & 4) != 0) {
                int i7 = m668p;
                m668p = (-m669q) - m667o;
                i6 = m666n;
                i5 = i7;
            } else {
                i5 = m669q;
                i6 = m667o;
                m667o = m666n;
            }
            if (C0338r.f2439rG) {
                if ((GLLib.f233kY & 262144) != 0) {
                    if (GLLib.f234kZ[18][5] != 0) {
                        i2 = (GLLib.m475bv() * i2) / 100;
                        i3 = (GLLib.m476bw() * i3) / 100;
                    }
                    m668p = (m668p * GLLib.m475bv()) / 100;
                    i5 = (i5 * GLLib.m476bw()) / 100;
                    m667o = (m667o * GLLib.m475bv()) / 100;
                    i6 = (i6 * GLLib.m476bw()) / 100;
                }
            }
            f374cG = m668p + i2;
            f375cH = i5 + i3;
            f376cI = m667o + f374cG;
            f377cJ = f375cH + i6;
        }
        iArr[0] = f374cG;
        iArr[1] = f375cH;
        iArr[2] = f376cI;
        iArr[3] = f377cJ;
    }

    private boolean m613a(int i, byte[] bArr, int i2, int i3, int i4, boolean z) {
        int i5;
        int i6 = 0;
        int i7 = i3 * i4;
        boolean z2 = C0338r.f2318op & true;
        if (z2) {
            if (f370bg == null) {
                f370bg = new int[C0338r.f2314ol];
            }
        } else if (f371bh == null) {
            f371bh = new byte[C0338r.f2314ol];
        }
        int[] iArr = null;
        if (z2 && (iArr = (int[]) m624i(i, this.f467cl[i])) == null) {
            return false;
        }
        int i8 = 0;
        byte b2 = 0;
        if (C0338r.f2292oP && this.f469cn == 25840) {
            int i9 = 0;
            while (i9 < i7) {
                int i10 = i2 + 1;
                int i11 = bArr[i2] & 255;
                if (z2) {
                    i8 = iArr[this.f470co[i] & i11];
                } else {
                    b2 = (byte) (this.f470co[i] & i11);
                }
                int i12 = i11 >> this.f471cp[i];
                int i13 = i9;
                while (true) {
                    int i14 = i12 - 1;
                    if (i12 >= 0) {
                        if (z2) {
                            f370bg[i13] = i8;
                            i13++;
                            i12 = i14;
                        } else {
                            f371bh[i13] = b2;
                            i13++;
                            i12 = i14;
                        }
                    }
                }
                i9 = i13;
                i2 = i10;
            }
        } else if (C0338r.f2293oQ && this.f469cn == 10225) {
            int i15 = 0;
            while (i15 < i7) {
                int i16 = i2 + 1;
                int i17 = bArr[i2] & 255;
                if (i17 > 127) {
                    i2 = i16 + 1;
                    int i18 = bArr[i16] & 255;
                    if (z2) {
                        i8 = iArr[i18];
                    } else {
                        b2 = (byte) i18;
                    }
                    int i19 = i17 - 128;
                    int i20 = i15;
                    while (true) {
                        int i21 = i19 - 1;
                        if (i19 <= 0) {
                            break;
                        }
                        if (z2) {
                            f370bg[i20] = i8;
                            i20++;
                            i19 = i21;
                        } else {
                            f371bh[i20] = b2;
                            i20++;
                            i19 = i21;
                        }
                    }
                    i15 = i20;
                } else if (z2) {
                    f370bg[i15] = iArr[i17];
                    i15++;
                    i2 = i16;
                } else {
                    f371bh[i15] = (byte) i17;
                    i15++;
                    i2 = i16;
                }
            }
        } else if (!C0338r.f2294oR || this.f469cn != 22258) {
            if (!C0338r.f2291oO || this.f469cn != 5632) {
                if (!C0338r.f2290oN || this.f469cn != 1024) {
                    if (C0338r.f2289oM && this.f469cn == 512) {
                        int i22 = (((i7 & 7) == 0 ? 0 : 8) + i7) >> 3;
                        while (true) {
                            i22--;
                            if (i22 < 0) {
                                break;
                            }
                            int i23 = i2 + 1;
                            byte b3 = bArr[i2];
                            if (z2) {
                                int i24 = i6 + 1;
                                f370bg[i6] = iArr[(b3 >> 7) & 1];
                                int i25 = i24 + 1;
                                f370bg[i24] = iArr[(b3 >> 6) & 1];
                                int i26 = i25 + 1;
                                f370bg[i25] = iArr[(b3 >> 5) & 1];
                                int i27 = i26 + 1;
                                f370bg[i26] = iArr[(b3 >> 4) & 1];
                                int i28 = i27 + 1;
                                f370bg[i27] = iArr[(b3 >> 3) & 1];
                                int i29 = i28 + 1;
                                f370bg[i28] = iArr[(b3 >> 2) & 1];
                                int i30 = i29 + 1;
                                f370bg[i29] = iArr[(b3 >> 1) & 1];
                                i6 = i30 + 1;
                                f370bg[i30] = iArr[b3 & 1];
                                i2 = i23;
                            } else {
                                int i31 = i6 + 1;
                                f371bh[i6] = (byte) ((b3 >> 7) & 1);
                                int i32 = i31 + 1;
                                f371bh[i31] = (byte) ((b3 >> 6) & 1);
                                int i33 = i32 + 1;
                                f371bh[i32] = (byte) ((b3 >> 5) & 1);
                                int i34 = i33 + 1;
                                f371bh[i33] = (byte) ((b3 >> 4) & 1);
                                int i35 = i34 + 1;
                                f371bh[i34] = (byte) ((b3 >> 3) & 1);
                                int i36 = i35 + 1;
                                f371bh[i35] = (byte) ((b3 >> 2) & 1);
                                int i37 = i36 + 1;
                                f371bh[i36] = (byte) ((b3 >> 1) & 1);
                                i6 = i37 + 1;
                                f371bh[i37] = (byte) (b3 & 1);
                                i2 = i23;
                            }
                        }
                    } else if (C0338r.f2295oS && this.f469cn == 22018) {
                        int i38 = 0;
                        int i39 = i7;
                        while (true) {
                            int i40 = i39 - 1;
                            if (i40 < 0) {
                                break;
                            }
                            if (z2) {
                                f370bg[i38] = iArr[bArr[i2] & 255];
                                i38++;
                                i2++;
                                i39 = i40;
                            } else {
                                f371bh[i38] = bArr[i2];
                                i38++;
                                i2++;
                                i39 = i40;
                            }
                        }
                    }
                } else {
                    int i41 = (((i7 & 3) == 0 ? 0 : 4) + i7) >> 2;
                    while (true) {
                        i41--;
                        if (i41 < 0) {
                            break;
                        }
                        int i42 = i2 + 1;
                        byte b4 = bArr[i2];
                        if (z2) {
                            int i43 = i6 + 1;
                            f370bg[i6] = iArr[(b4 >> 6) & 3];
                            int i44 = i43 + 1;
                            f370bg[i43] = iArr[(b4 >> 4) & 3];
                            int i45 = i44 + 1;
                            f370bg[i44] = iArr[(b4 >> 2) & 3];
                            i6 = i45 + 1;
                            f370bg[i45] = iArr[b4 & 3];
                            i2 = i42;
                        } else {
                            int i46 = i6 + 1;
                            f371bh[i6] = (byte) ((b4 >> 6) & 3);
                            int i47 = i46 + 1;
                            f371bh[i46] = (byte) ((b4 >> 4) & 3);
                            int i48 = i47 + 1;
                            f371bh[i47] = (byte) ((b4 >> 2) & 3);
                            i6 = i48 + 1;
                            f371bh[i48] = (byte) (b4 & 3);
                            i2 = i42;
                        }
                    }
                }
            } else {
                int i49 = (((i7 & 1) == 0 ? 0 : 2) + i7) >> 1;
                while (true) {
                    i49--;
                    if (i49 < 0) {
                        break;
                    }
                    int i50 = i2 + 1;
                    byte b5 = bArr[i2];
                    if (z2) {
                        int i51 = i6 + 1;
                        f370bg[i6] = iArr[(b5 >> 4) & 15];
                        i6 = i51 + 1;
                        f370bg[i51] = iArr[b5 & 15];
                        i2 = i50;
                    } else {
                        int i52 = i6 + 1;
                        f371bh[i6] = (byte) ((b5 >> 4) & 15);
                        i6 = i52 + 1;
                        f371bh[i52] = (byte) (b5 & 15);
                        i2 = i50;
                    }
                }
            }
        } else {
            int i53 = i2 - 1;
            int i54 = -1;
            int i55 = i7 - 1;
            if (i55 >= 0) {
                do {
                    int i56 = i53 + 1;
                    byte b6 = bArr[i56];
                    if (b6 < 0) {
                        int i57 = b6 + 128;
                        i53 = i56;
                        int i58 = i57;
                        do {
                            if (z2) {
                                i54++;
                                i53++;
                                f370bg[i54] = iArr[bArr[i53] & 255];
                            } else {
                                i54++;
                                i53++;
                                f371bh[i54] = bArr[i53];
                            }
                            i58--;
                        } while (i58 > 0);
                    } else {
                        if (z2) {
                            int i59 = i56 + 1;
                            i8 = iArr[bArr[i59] & 255];
                            i53 = i59;
                            i5 = b6;
                        } else {
                            int i60 = i56 + 1;
                            b2 = bArr[i60];
                            i53 = i60;
                            i5 = b6;
                        }
                        do {
                            if (z2) {
                                i54++;
                                f370bg[i54] = i8;
                            } else {
                                i54++;
                                f371bh[i54] = b2;
                            }
                            i5--;
                        } while (i5 > 0);
                    }
                } while (i54 < i55);
            }
        }
        return true;
    }

    public static int[] m614a(int[] iArr) {
        if (iArr == null || iArr != f370bg) {
            if (f370bg == null) {
                f370bg = new int[C0338r.f2314ol];
            }
            return f370bg;
        }
        if (iArr != null && iArr == f372bi) {
            return null;
        }
        if (f372bi == null) {
            if (C0338r.f2315om > 0) {
                f372bi = new int[C0338r.f2315om];
            } else {
                f372bi = new int[C0338r.f2314ol];
            }
        }
        return f372bi;
    }

    private int m615aa() {
        if (!C0338r.f2439rG || this.f484dj < 0) {
            return 0;
        }
        return (this.f484dj * 0) >> 8;
    }

    static void m616ad() {
    }

    static void m617ae() {
    }

    private static int m618b(short[] sArr, int i) {
        return sArr[((C0338r.f2409qc ? 5 : 4) * i) + 4];
    }

    private int m619e(int i, int i2) {
        return (this.f444bw[i] + i2) & 65535;
    }

    private static void m620e(boolean z) {
        f369bf = !z;
    }

    private int m621f(int i, int i2) {
        return m664l(this.f444bw[i] + i2);
    }

    private int m622g(int i, int i2) {
        return m665m(this.f444bw[i] + i2);
    }

    private void m623h(int i) {
        if (this.f448cB == null) {
            this.f448cB = new byte[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.f448cB[i2] = 0;
            }
        }
        if (this.f450cD == null) {
            this.f450cD = new int[i];
        }
    }

    private Object m624i(int i, int i2) {
        int i3 = 0;
        if (i2 < 0 || i2 >= this.f465cj[i]) {
            return null;
        }
        if (C0338r.f2323ou && (this.f459cd & 536870912) != 0) {
            if (!(C0338r.f2317oo && (this.f460ce & 1048576) != 0)) {
                if (this.f463ch == null) {
                    return null;
                }
                int i4 = this.f466ck[0];
                int[] iArr = new int[i4];
                int i5 = i2 * ((i4 * 3) + 4 + i4 + 4);
                for (int i6 = 0; i6 < i4; i6++) {
                    iArr[i6] = ((this.f463ch[i5] & 255) << 16) | ((this.f463ch[i5 + 1] & 255) << 8) | (this.f463ch[i5 + 2] & 255);
                    i5 += 3;
                }
                int i7 = i5 + 4;
                while (i3 < i4) {
                    iArr[i3] = ((this.f463ch[i7] & 255) << 24) | iArr[i3];
                    i3++;
                    i7++;
                }
                return iArr;
            }
        }
        if (this.f462cg == null || i2 >= this.f462cg[i].length) {
            return null;
        }
        return this.f462cg[i][i2];
    }

    private int m625j(int i) {
        return (!C0338r.f2370pp || (this.f459cd & 262144) == 0) ? this.f424bT[i] : this.f422bR[i];
    }

    private int m626k(int i) {
        return (!C0338r.f2370pp || (this.f459cd & 262144) == 0) ? this.f425bU[i] : this.f423bS[i];
    }

    static void m627l(int i, int i2) {
        if (C0338r.f2281oE) {
            f386cU[i] = i2;
            f385cT[i] = new int[i2];
            f387cV[i] = new C0271a[i2];
            for (int i3 = 0; i3 < f385cT[i].length; i3++) {
                f385cT[i][i3] = -1;
            }
        }
    }

    private void m628m(int i, int i2) {
        if (i2 >= this.f465cj[i] || i2 < 0) {
            return;
        }
        this.f467cl[i] = i2;
    }

    private int m629r(int i) {
        m630s(i);
        return (!C0338r.f2360pf || (this.f459cd & 1048576) == 0) ? this.f410bF[i] & 255 : this.f411bG[i] & 65535;
    }

    private int m630s(int i) {
        return this.f412bH[i] & 255;
    }

    static void m631v(int i) {
        if (C0338r.f2281oE) {
            f385cT = new int[2][];
            f387cV = new C0271a[2][];
            f386cU = new int[2];
        }
    }

    private int m632x(int i) {
        int i2 = 2;
        short[] sArr = null;
        if (this.f482dh == null) {
            GLLib.m342C("ERROR: _pMapCharInt and _pMapCharShort are null!!! Did you set the Char Map?");
            return 0;
        }
        if (this.f482dh != null) {
            int i3 = i % this.f483di;
            if (this.f482dh[i3][0] == i) {
                return this.f482dh[i3][1];
            }
            int length = this.f482dh[i3].length;
            while (i2 < length && this.f482dh[i3][i2] != i) {
                i2 += 2;
            }
            if (i2 >= length) {
                return 1;
            }
            return this.f482dh[i3][i2 + 1];
        }
        if (sArr[0] == i) {
            return sArr[1];
        }
        int length2 = sArr.length;
        int i4 = 2;
        while (i4 < length2 && sArr[i4] != i) {
            i4 += 2;
        }
        if (i4 >= length2) {
            return 1;
        }
        return sArr[i4 + 1];
    }

    private final int m633y(int i) {
        return (!C0338r.f2439rG || this.f484dj < 0) ? m621f(i, 0) : (m621f(i, 0) * this.f484dj) >> 8;
    }

    final int m634C(int i) {
        return (!C0338r.f2360pf || (this.f459cd & 1048576) == 0) ? this.f442bu[i] : this.f443bv[i];
    }

    final void m635T() {
        if (this.f472ct != null) {
            for (int i = 0; i < this.f472ct.length; i++) {
                if (this.f472ct[i] != null) {
                    for (int i2 = 0; i2 < this.f472ct[i].length; i2++) {
                        if (this.f472ct[i][i2] != null) {
                            this.f472ct[i][i2].m681cc();
                            this.f472ct[i][i2] = null;
                        }
                    }
                }
            }
        }
        if (C0338r.f2357pc) {
            this.f435bn = null;
            this.f434bm = null;
        } else {
            this.f432bk = null;
            this.f433bl = null;
        }
        if (C0338r.f2358pd) {
            this.f436bo = null;
            this.f437bp = null;
        } else {
            this.f438bq = null;
            this.f439br = null;
        }
        if (C0338r.f2360pf) {
            this.f411bG = null;
        }
        this.f410bF = null;
        if (C0338r.f2362ph) {
            this.f443bv = null;
        }
        this.f442bu = null;
        this.f420bP = null;
        this.f417bM = null;
        this.f444bw = null;
        this.f445bx = null;
        this.f446by = null;
        this.f447bz = null;
        this.f405bA = null;
        this.f406bB = null;
        this.f407bC = null;
        this.f408bD = null;
        this.f409bE = null;
        this.f418bN = null;
        this.f419bO = null;
        if (this.f427bW != null) {
            for (int i3 = 0; i3 < this.f427bW.length; i3++) {
                this.f427bW[i3] = null;
            }
            this.f427bW = null;
        }
        if (this.f429bY != null) {
            for (int i4 = 0; i4 < this.f429bY.length; i4++) {
                this.f429bY[i4] = null;
            }
            this.f429bY = null;
        }
        if (this.f428bX != null) {
            for (int i5 = 0; i5 < this.f428bX.length; i5++) {
                this.f428bX[i5] = null;
            }
            this.f428bX = null;
        }
        if (C0338r.f2318op && this.f462cg != null) {
            for (int i6 = 0; i6 < this.f462cg.length; i6++) {
                this.f462cg[i6] = null;
            }
            this.f462cg = null;
        }
        if (this.f472ct != null) {
            for (int i7 = 0; i7 < this.f472ct.length; i7++) {
                this.f472ct[i7] = null;
            }
            this.f472ct = null;
        }
    }

    final int m636U() {
        if (this.f417bM == null) {
            return 0;
        }
        return this.f417bM.length;
    }

    final int m637V() {
        if (!C0338r.f2362ph || (this.f459cd & 2048) == 0) {
            if (this.f442bu != null) {
                return this.f442bu.length;
            }
            return 0;
        }
        if (this.f443bv == null) {
            return 0;
        }
        return this.f443bv.length;
    }

    final void m638W() {
        if (!C0338r.f2281oE || this.f454cS < 0) {
            return;
        }
        for (int i = 0; i < f386cU[this.f454cS]; i++) {
            if (f387cV[this.f454cS][i] == this) {
                int i2 = f385cT[this.f454cS][i];
                f387cV[this.f454cS][i] = null;
                this.f472ct[i2 >> 24][i2 & 16777215] = null;
            }
        }
    }

    final int m639X() {
        return (!C0338r.f2439rG || this.f484dj < 0) ? this.f476db : (this.f476db * this.f484dj) >> 8;
    }

    final int m640Y() {
        return (!C0338r.f2439rG || this.f484dj < 0) ? this.f475da : (this.f475da * this.f484dj) >> 8;
    }

    final void m641a(int i, int i2, int[] iArr, int i3) {
        if (!C0338r.f2346pR || this.f408bD == null || iArr == null) {
            return;
        }
        short s = this.f408bD[i];
        int i4 = this.f408bD[i + 1] - s;
        if (i4 <= 0 || i2 >= i4) {
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            iArr[3] = 0;
            return;
        }
        int i5 = (s + i2) << 2;
        if (!C0338r.f2364pj || (this.f459cd & 1024) == 0) {
            if (this.f406bB != null) {
                iArr[0] = this.f406bB[i5];
                iArr[1] = this.f406bB[i5 + 1];
                iArr[2] = this.f406bB[i5 + 2] & 255;
                iArr[3] = this.f406bB[i5 + 3] & 255;
                return;
            }
            return;
        }
        if (this.f407bC != null) {
            iArr[0] = this.f407bC[i5];
            iArr[1] = this.f407bC[i5 + 1];
            iArr[2] = this.f407bC[i5 + 2] & 65535;
            iArr[3] = this.f407bC[i5 + 3] & 65535;
        }
    }

    final void m642a(C0048ac c0048ac, int i, float f, float f2, int i2) {
        m654b(c0048ac, i, f, f2, i2);
    }

    final void m643a(C0048ac c0048ac, int i, float f, float f2, int i2, int i3, int i4) {
        f378cK[0] = i3;
        f378cK[1] = i4;
        m608a(c0048ac, i, f, f2, i2, f378cK);
    }

    final void m644a(C0048ac c0048ac, int i, int i2, int i3, int i4, int i5) {
        int i6 = this.f418bN[i] + i2;
        int i7 = this.f420bP[i6] & 255;
        int m625j = m625j(i6);
        int m626k = m626k(i6);
        int i8 = this.f426bV[i6] & 15;
        if ((i5 & 1) != 0) {
            i8 = f396cy[i8 & 7] | (i8 & (-8));
            m625j = -m625j;
        }
        if ((i5 & 2) != 0) {
            i8 = f397cz[i8 & 7] | (i8 & (-8));
            m626k = -m626k;
        }
        if ((i5 & 4) != 0) {
            i8 = f373cA[i8 & 7] | (i8 & (-8));
            if (C0338r.f2439rG) {
                if ((GLLib.f233kY & 262144) != 0) {
                }
            }
            int i9 = m625j;
            m625j = -m626k;
            m626k = i9;
        }
        if (C0338r.f2439rG) {
            if ((GLLib.f233kY & 262144) != 0) {
                if (!(GLLib.f234kZ[18][5] != 0)) {
                    m625j = (m625j * GLLib.m475bv()) / 100;
                    m626k = (m626k * GLLib.m476bw()) / 100;
                }
            }
        }
        m642a(c0048ac, i7, m625j + i3, m626k + i4, i8);
    }

    final void m645a(C0048ac c0048ac, String str, int i, int i2, int i3) {
        m609a(c0048ac, str, i, i2, i3, true);
    }

    final void m646a(C0048ac c0048ac, String str, short[] sArr, int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        short s = sArr[0];
        int i8 = i4 == -1 ? s : i4;
        int i9 = i8 + 0 > s ? s : i8;
        int m618b = m618b(sArr, 0);
        for (int i10 = 1; i10 < i9; i10++) {
            m618b += m618b(sArr, i10) + m639X();
        }
        if ((i5 & 32) != 0) {
            i2 -= m618b;
        } else if ((i5 & 2) != 0) {
            i2 -= m618b >> 1;
        }
        f388cW = this.f467cl[0];
        boolean z = this.f481dg;
        boolean z2 = this.f480df;
        int i11 = GLLib.f237kc;
        int i12 = i11 - m618b;
        int i13 = GLLib.f239ke + i11 + m618b;
        int i14 = 0;
        while (i14 < i9 + 0) {
            short s2 = sArr[((C0338r.f2409qc ? 5 : 4) * i14) + 1];
            f399dl = s2;
            f400dm = sArr[((C0338r.f2409qc ? 5 : 4) * i14) + 2] + s2;
            if (f399dl < str.length() && str.charAt(f399dl) == '\n') {
                f399dl++;
            }
            int m618b2 = i2 + (i14 == 0 ? m618b(sArr, i14) - this.f475da : m639X() + m618b(sArr, i14));
            if (m618b2 >= i12) {
                if (m618b2 > i13) {
                    break;
                }
                if ((i5 & 43) != 0) {
                    if (!C0338r.f2439rG || this.f484dj < 0) {
                        if ((i5 & 8) != 0) {
                            i7 = i - m607a(sArr, i14);
                        } else if ((i5 & 1) != 0) {
                            i7 = i - (m607a(sArr, i14) >> 1);
                        }
                        if (C0338r.f2409qc) {
                            short s3 = sArr[((C0338r.f2409qc ? 5 : 4) * i14) + 5];
                            this.f481dg = (s3 & 4096) != 0;
                            this.f480df = (s3 & 8192) != 0;
                            m628m(0, s3 & 4095);
                        }
                        m609a(c0048ac, str, i7, m618b2, 0, false);
                    } else {
                        if ((i5 & 8) != 0) {
                            i7 = i - ((m607a(sArr, i14) * this.f484dj) >> 8);
                        } else if ((i5 & 1) != 0) {
                            i7 = i - ((m607a(sArr, i14) * this.f484dj) >> 9);
                        }
                        if (C0338r.f2409qc) {
                        }
                        m609a(c0048ac, str, i7, m618b2, 0, false);
                    }
                }
                i7 = i;
                if (C0338r.f2409qc) {
                }
                m609a(c0048ac, str, i7, m618b2, 0, false);
            }
            i14++;
            i2 = m618b2;
        }
        f399dl = -1;
        f400dm = -1;
        f401dn = -1;
        this.f467cl[0] = f388cW;
        if (C0338r.f2409qc) {
            this.f481dg = z;
            this.f480df = z2;
        }
    }

    final void m647a(String str, char[] cArr) {
        boolean z;
        int i;
        int i2;
        if (str == null && cArr == null) {
            return;
        }
        f389cX = 0;
        f390cY = m651ab();
        boolean z2 = str != null;
        int i3 = f399dl >= 0 ? f399dl : 0;
        int length = z2 ? f400dm >= 0 ? f400dm : str.length() : f400dm >= 0 ? f400dm : cArr.length;
        boolean z3 = this.f481dg;
        int i4 = 0;
        while (i3 < length) {
            char charAt = z2 ? str.charAt(i3) : cArr[i3];
            if (C0338r.f2329pA && charAt == '\\') {
                i3++;
                if ((z2 ? str.charAt(i3) : cArr[i3]) == '^') {
                    z = !z3;
                    i = i4;
                }
                z = z3;
                i = i4;
            } else {
                if (charAt > ' ') {
                    i2 = m632x(charAt);
                } else {
                    if (!C0338r.f2411qe || charAt != f381cN) {
                        if (charAt == ' ') {
                            boolean z4 = z3;
                            i = m605Z() + i4;
                            z = z4;
                        } else if (charAt == '\n') {
                            if (i4 > f389cX) {
                                f389cX = i4;
                            }
                            f390cY += m639X() + m651ab();
                            z = z3;
                            i = 0;
                        } else if (charAt == 1) {
                            i3++;
                            z = z3;
                            i = i4;
                        } else if (charAt == 2) {
                            i3++;
                            i2 = z2 ? str.charAt(i3) : cArr[i3];
                        }
                    }
                    z = z3;
                    i = i4;
                }
                int m633y = m633y(i2) + m615aa() + i4;
                Math.abs(0);
                if (z3) {
                    boolean z5 = z3;
                    i = m633y + 1;
                    z = z5;
                } else {
                    boolean z6 = z3;
                    i = m633y;
                    z = z6;
                }
            }
            i3++;
            i4 = i;
            z3 = z;
        }
        if (i4 > f389cX) {
            f389cX = i4;
        }
        if (f389cX > 0) {
            f389cX -= m615aa();
        }
    }

    final void m648a(byte[] bArr, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int i19;
        boolean z6;
        int i20;
        int i21;
        int i22;
        short[][] sArr;
        if (bArr == null) {
            return;
        }
        try {
            if (!C0338r.f2349pU) {
                boolean z7 = f379cL;
            }
            int i23 = 6;
            this.f459cd = ((bArr[5] & 255) << 24) + ((bArr[4] & 255) << 16) + (bArr[2] & 255) + ((bArr[3] & 255) << 8);
            if (C0338r.f2317oo && (this.f459cd & 4194304) != 0) {
                i23 = 10;
                this.f460ce = ((bArr[9] & 255) << 24) + ((bArr[8] & 255) << 16) + (bArr[6] & 255) + ((bArr[7] & 255) << 8);
            }
            int i24 = i23 + 1;
            int i25 = bArr[i23] & 255;
            int i26 = i24 + 1;
            this.f431bj = ((bArr[i24] & 255) << 8) + i25;
            if (this.f431bj > 0) {
                if (C0338r.f2357pc && (this.f459cd & 32) != 0) {
                    this.f434bm = new short[this.f431bj];
                    this.f435bn = new short[this.f431bj];
                } else if (C0338r.f2356pb && (this.f459cd & 2) != 0) {
                    this.f432bk = new byte[this.f431bj];
                    this.f433bl = new byte[this.f431bj];
                }
                if (C0338r.f2358pd) {
                    this.f436bo = new short[this.f431bj];
                    this.f437bp = new short[this.f431bj];
                } else {
                    this.f438bq = new byte[this.f431bj];
                    this.f439br = new byte[this.f431bj];
                }
                if (C0338r.f2333pE && (this.f459cd & 4) != 0) {
                    this.f449cC = new byte[this.f431bj];
                }
                boolean z8 = false;
                boolean z9 = false;
                boolean z10 = false;
                int i27 = 0;
                short[][] sArr2 = null;
                int i28 = 0;
                int i29 = 0;
                int i30 = i26;
                while (i27 < this.f431bj) {
                    if (!C0338r.f2333pE) {
                        if ((bArr[i30] & 255) == 0) {
                            z = true;
                            z2 = false;
                            z3 = false;
                            z4 = false;
                            z5 = false;
                            i19 = i30 + 1;
                            z6 = true;
                        }
                        z = z9;
                        z2 = z8;
                        z3 = false;
                        z6 = z10;
                        z4 = false;
                        z5 = false;
                        i19 = i30;
                    } else if ((bArr[i30] & 255) == 0) {
                        int i31 = i30 + 1;
                        if ((this.f459cd & 4) != 0) {
                            int i32 = i31 + 1;
                            this.f449cC[i27] = bArr[i31];
                            z = true;
                            z2 = false;
                            z3 = false;
                            z4 = false;
                            z5 = false;
                            i19 = i32;
                            z6 = true;
                        } else {
                            z6 = true;
                            z2 = false;
                            z3 = false;
                            i19 = i31;
                            z = true;
                            z4 = false;
                            z5 = false;
                        }
                    } else if ((bArr[i30] & 255) == 255) {
                        m623h(this.f431bj);
                        this.f448cB[i27] = 1;
                        z = false;
                        z2 = true;
                        z3 = false;
                        z4 = false;
                        z5 = false;
                        i19 = i30 + 1;
                        z6 = true;
                    } else if ((bArr[i30] & 255) == 254) {
                        m623h(this.f431bj);
                        this.f448cB[i27] = 2;
                        z = false;
                        z2 = true;
                        z3 = false;
                        z4 = false;
                        z5 = false;
                        i19 = i30 + 1;
                        z6 = true;
                    } else if ((bArr[i30] & 255) == 253) {
                        m623h(this.f431bj);
                        this.f448cB[i27] = 5;
                        z = false;
                        z2 = false;
                        z3 = false;
                        z4 = false;
                        z5 = false;
                        i19 = i30 + 1;
                        z6 = true;
                    } else if ((bArr[i30] & 255) == 252) {
                        m623h(this.f431bj);
                        this.f448cB[i27] = 3;
                        z = false;
                        z2 = true;
                        z3 = true;
                        z4 = false;
                        z5 = false;
                        i19 = i30 + 1;
                        z6 = true;
                    } else if ((bArr[i30] & 255) == 251) {
                        m623h(this.f431bj);
                        this.f448cB[i27] = 4;
                        z = false;
                        z2 = true;
                        z3 = true;
                        z4 = false;
                        z5 = false;
                        i19 = i30 + 1;
                        z6 = true;
                    } else if ((bArr[i30] & 255) == 250) {
                        m623h(this.f431bj);
                        this.f448cB[i27] = 6;
                        z = false;
                        z2 = true;
                        z3 = false;
                        z4 = true;
                        z5 = false;
                        i19 = i30 + 1;
                        z6 = false;
                    } else if ((bArr[i30] & 255) == 249) {
                        m623h(this.f431bj);
                        this.f448cB[i27] = 7;
                        z = false;
                        z2 = true;
                        z3 = false;
                        z4 = true;
                        z5 = false;
                        i19 = i30 + 1;
                        z6 = false;
                    } else if ((bArr[i30] & 255) == 248) {
                        m623h(this.f431bj);
                        this.f448cB[i27] = 8;
                        z = false;
                        z2 = true;
                        z3 = false;
                        z4 = false;
                        z5 = false;
                        i19 = i30 + 1;
                        z6 = true;
                    } else {
                        if ((bArr[i30] & 255) == 247) {
                            m623h(this.f431bj);
                            this.f448cB[i27] = 9;
                            z = false;
                            z2 = true;
                            z3 = false;
                            z4 = false;
                            z5 = true;
                            i19 = i30 + 1;
                            z6 = true;
                        }
                        z = z9;
                        z2 = z8;
                        z3 = false;
                        z6 = z10;
                        z4 = false;
                        z5 = false;
                        i19 = i30;
                    }
                    if (C0338r.f2333pE) {
                        if (z2) {
                            int[] iArr = this.f450cD;
                            int i33 = i19 + 1;
                            int i34 = i33 + 1;
                            int i35 = (bArr[i19] & 255) + ((bArr[i33] & 255) << 8);
                            int i36 = i34 + 1;
                            int i37 = ((bArr[i34] & 255) << 16) + i35;
                            i19 = i36 + 1;
                            iArr[i27] = ((bArr[i36] & 255) << 24) + i37;
                        }
                        if (z5) {
                            if (sArr2 == null) {
                                sArr2 = new short[this.f431bj][];
                            }
                            int i38 = i19 + 1;
                            int i39 = i38 + 1;
                            int i40 = (bArr[i19] & 255) + ((bArr[i38] & 255) << 8);
                            int i41 = i39 + 1;
                            int i42 = i40 + ((bArr[i39] & 255) << 16);
                            int i43 = i41 + 1;
                            int i44 = i42 + ((bArr[i41] & 255) << 24);
                            sArr2[i27] = new short[]{(short) i44, (short) (i44 >> 16), bArr[i43]};
                            i20 = i28 + 3;
                            i21 = i29 + 1;
                            i22 = i43 + 1;
                            sArr = sArr2;
                            if (z) {
                                if (C0338r.f2357pc && (this.f459cd & 32) != 0) {
                                    int i45 = i22 + 1;
                                    int i46 = i45 + 1;
                                    this.f434bm[i27] = (short) ((bArr[i22] & 255) + ((bArr[i45] & 255) << 8));
                                    int i47 = i46 + 1;
                                    i22 = i47 + 1;
                                    this.f435bn[i27] = (short) (((bArr[i47] & 255) << 8) + (bArr[i46] & 255));
                                } else if (C0338r.f2356pb && (this.f459cd & 2) != 0) {
                                    int i48 = i22 + 1;
                                    this.f432bk[i27] = bArr[i22];
                                    i22 = i48 + 1;
                                    this.f433bl[i27] = bArr[i48];
                                }
                            }
                            if (z6) {
                                if (!C0338r.f2358pd) {
                                    int i49 = i22 + 1;
                                    this.f438bq[i27] = bArr[i22];
                                    i22 = i49 + 1;
                                    this.f439br[i27] = bArr[i49];
                                } else if ((this.f459cd & 16) == 0) {
                                    int i50 = i22 + 1;
                                    this.f436bo[i27] = (short) (bArr[i22] & 255);
                                    i22 = i50 + 1;
                                    this.f437bp[i27] = (short) (bArr[i50] & 255);
                                } else {
                                    int i51 = i22 + 1;
                                    int i52 = i51 + 1;
                                    this.f436bo[i27] = (short) ((bArr[i22] & 255) + ((bArr[i51] & 255) << 8));
                                    int i53 = i52 + 1;
                                    i22 = i53 + 1;
                                    this.f437bp[i27] = (short) (((bArr[i53] & 255) << 8) + (bArr[i52] & 255));
                                }
                            }
                            if (C0338r.f2333pE) {
                                if (z3) {
                                    if (sArr == null) {
                                        sArr = new short[this.f431bj][];
                                    }
                                    int i54 = i22 + 1;
                                    int i55 = i54 + 1;
                                    int i56 = i55 + 1;
                                    i22 = i56 + 1;
                                    sArr[i27] = new short[]{(short) ((bArr[i22] & 255) + ((bArr[i54] & 255) << 8)), (short) (((bArr[i56] & 255) << 8) + (bArr[i55] & 255))};
                                    i21++;
                                    i20 += 2;
                                }
                                if (z4) {
                                    if (sArr == null) {
                                        sArr = new short[this.f431bj][];
                                    }
                                    int i57 = i22 + 1;
                                    int i58 = i57 + 1;
                                    int i59 = i58 + 1;
                                    int i60 = bArr[i58] & 255;
                                    int i61 = i59 + 1;
                                    int i62 = i61 + 1;
                                    int i63 = bArr[i61] & 255;
                                    int i64 = i62 + 1;
                                    int i65 = i64 + 1;
                                    i22 = i65 + 1;
                                    sArr[i27] = new short[]{(short) ((bArr[i22] & 255) + ((bArr[i57] & 255) << 8)), (short) (((bArr[i59] & 255) << 8) + i60), (short) (((bArr[i62] & 255) << 8) + i63), (short) (((bArr[i65] & 255) << 8) + (bArr[i64] & 255))};
                                    i21++;
                                    i20 += 4;
                                }
                            }
                            i27++;
                            z9 = z;
                            sArr2 = sArr;
                            i28 = i20;
                            i29 = i21;
                            z10 = z6;
                            i30 = i22;
                            z8 = z2;
                        }
                    }
                    i20 = i28;
                    i21 = i29;
                    i22 = i19;
                    sArr = sArr2;
                    if (z) {
                    }
                    if (z6) {
                    }
                    if (C0338r.f2333pE) {
                    }
                    i27++;
                    z9 = z;
                    sArr2 = sArr;
                    i28 = i20;
                    i29 = i21;
                    z10 = z6;
                    i30 = i22;
                    z8 = z2;
                }
                if (C0338r.f2333pE && i29 > 0) {
                    this.f440bs = new short[i28];
                    this.f441bt = new short[i29 << 1];
                    int i66 = 0;
                    short s = 0;
                    for (short s2 = 0; s2 < this.f431bj; s2 = (short) (s2 + 1)) {
                        int i67 = (this.f448cB[s2] == 3 || this.f448cB[s2] == 4) ? 2 : (this.f448cB[s2] == 6 || this.f448cB[s2] == 7) ? 4 : this.f448cB[s2] == 9 ? 3 : -1;
                        if (i67 > 0) {
                            this.f441bt[i66 << 1] = s2;
                            this.f441bt[(i66 << 1) + 1] = s;
                            for (int i68 = 0; i68 < i67; i68++) {
                                this.f440bs[s] = sArr2[s2][i68];
                                s = (short) (s + 1);
                            }
                            sArr2[s2] = null;
                            i66++;
                        }
                    }
                }
                i26 = i30;
            }
            int i69 = i26 + 1;
            int i70 = bArr[i26] & 255;
            int i71 = i69 + 1;
            int i72 = i70 + ((bArr[i69] & 255) << 8);
            if (i72 > 0) {
                if (!C0338r.f2360pf || (this.f459cd & 1048576) == 0) {
                    this.f410bF = new byte[i72];
                } else {
                    this.f411bG = new short[i72];
                }
                if (C0338r.f2364pj) {
                    this.f413bI = new short[i72];
                    this.f414bJ = new short[i72];
                } else {
                    this.f415bK = new byte[i72];
                    this.f416bL = new byte[i72];
                }
                this.f412bH = new byte[i72];
                boolean z11 = C0338r.f2317oo;
                int i73 = 0;
                while (i73 < i72) {
                    if (!C0338r.f2360pf || (this.f459cd & 1048576) == 0) {
                        this.f410bF[i73] = bArr[i71];
                        i17 = i71 + 1;
                    } else {
                        short[] sArr3 = this.f411bG;
                        int i74 = i71 + 1;
                        int i75 = bArr[i71] & 255;
                        i17 = i74 + 1;
                        sArr3[i73] = (short) (((bArr[i74] & 255) << 8) + i75);
                    }
                    if (!C0338r.f2364pj) {
                        int i76 = i17 + 1;
                        this.f415bK[i73] = bArr[i17];
                        i18 = i76 + 1;
                        this.f416bL[i73] = bArr[i76];
                    } else if ((this.f459cd & 1024) != 0) {
                        int i77 = i17 + 1;
                        int i78 = i77 + 1;
                        this.f413bI[i73] = (short) ((bArr[i17] & 255) + ((bArr[i77] & 255) << 8));
                        int i79 = i78 + 1;
                        i18 = i79 + 1;
                        this.f414bJ[i73] = (short) (((bArr[i79] & 255) << 8) + (bArr[i78] & 255));
                    } else {
                        this.f413bI[i73] = bArr[i17];
                        i18 = i17 + 1 + 1;
                        this.f414bJ[i73] = bArr[r5];
                    }
                    int i80 = i18 + 1;
                    this.f412bH[i73] = bArr[i18];
                    boolean z12 = C0338r.f2317oo;
                    i73++;
                    i71 = i80;
                }
            }
            if (C0338r.f2346pR && (this.f459cd & 32768) != 0) {
                int i81 = i71 + 1;
                int i82 = bArr[i71] & 255;
                i71 = i81 + 1;
                int i83 = ((bArr[i81] & 255) << 8) + i82;
                if ((this.f459cd & 1024) == 0) {
                    this.f406bB = new byte[i83 << 2];
                    System.arraycopy(bArr, i71, this.f406bB, 0, i83 << 2);
                    i71 += i83 << 2;
                } else {
                    this.f407bC = new short[i83 << 2];
                    short[] sArr4 = this.f407bC;
                    int i84 = i83 << 2;
                    for (int i85 = 0; i85 < i84; i85++) {
                        int i86 = i71 + 1;
                        int i87 = bArr[i71] & 255;
                        i71 = i86 + 1;
                        sArr4[i85] = (short) (((bArr[i86] & 255) << 8) + i87);
                    }
                }
            }
            int i88 = i71 + 1;
            int i89 = bArr[i71] & 255;
            int i90 = i88 + 1;
            int i91 = i89 + ((bArr[i88] & 255) << 8);
            if (i91 > 0) {
                if (!C0338r.f2362ph || (this.f459cd & 2048) == 0) {
                    this.f442bu = new byte[i91];
                } else {
                    this.f443bv = new short[i91];
                }
                this.f444bw = new short[i91];
                if (C0338r.f2346pR && (this.f459cd & 32768) != 0) {
                    this.f408bD = new short[i91 + 1];
                }
                int i92 = i90;
                short s3 = 0;
                for (int i93 = 0; i93 < i91; i93++) {
                    if (!C0338r.f2362ph || (this.f459cd & 2048) == 0) {
                        this.f442bu[i93] = bArr[i92];
                        i16 = i92 + 1;
                    } else {
                        short[] sArr5 = this.f443bv;
                        int i94 = i92 + 1;
                        int i95 = bArr[i92] & 255;
                        i16 = i94 + 1;
                        sArr5[i93] = (short) (((bArr[i94] & 255) << 8) + i95);
                    }
                    int i96 = i16 + 1;
                    int i97 = i96 + 1;
                    this.f444bw[i93] = (short) ((bArr[i16] & 255) + ((bArr[i96] & 255) << 8));
                    if (!C0338r.f2346pR || (this.f459cd & 32768) == 0 || (this.f459cd & 32768) == 0) {
                        i92 = i97;
                    } else {
                        this.f408bD[i93] = s3;
                        i92 = i97 + 1;
                        s3 = (short) (s3 + bArr[i97]);
                    }
                }
                if (C0338r.f2346pR && (this.f459cd & 32768) != 0) {
                    this.f408bD[this.f408bD.length - 1] = s3;
                }
                if ((this.f459cd & 4096) != 0) {
                    i90 = i92;
                } else if (C0338r.f2319oq) {
                    int i98 = i91 << 2;
                    if ((this.f459cd & 1024) == 0) {
                        this.f445bx = new byte[i98];
                        i90 = i92;
                        int i99 = 0;
                        while (i99 < i98) {
                            this.f445bx[i99] = bArr[i90];
                            i99++;
                            i90++;
                        }
                    } else {
                        this.f446by = new short[i98];
                        i90 = i92;
                        int i100 = 0;
                        while (i100 < i98) {
                            int i101 = i90 + 1;
                            this.f446by[i100] = (short) ((bArr[i90] & 255) + ((bArr[i101] & 255) << 8));
                            i100++;
                            i90 = i101 + 1;
                        }
                    }
                } else {
                    i90 = (this.f459cd & 1024) == 0 ? (i91 << 2) + i92 : (i91 << 3) + i92;
                }
            }
            int i102 = i90 + 1;
            int i103 = bArr[i90] & 255;
            int i104 = i102 + 1;
            int i105 = i103 + ((bArr[i102] & 255) << 8);
            if (i105 > 0) {
                this.f420bP = new byte[i105];
                this.f421bQ = new byte[i105];
                if (!C0338r.f2370pp || (this.f459cd & 262144) == 0) {
                    this.f424bT = new byte[i105];
                    this.f425bU = new byte[i105];
                } else {
                    this.f422bR = new short[i105];
                    this.f423bS = new short[i105];
                }
                this.f426bV = new byte[i105];
                int i106 = 0;
                while (i106 < i105) {
                    int i107 = i104 + 1;
                    this.f420bP[i106] = bArr[i104];
                    int i108 = i107 + 1;
                    this.f421bQ[i106] = bArr[i107];
                    if (!C0338r.f2370pp || (this.f459cd & 262144) == 0) {
                        int i109 = i108 + 1;
                        this.f424bT[i106] = bArr[i108];
                        i15 = i109 + 1;
                        this.f425bU[i106] = bArr[i109];
                    } else {
                        int i110 = i108 + 1;
                        int i111 = i110 + 1;
                        this.f422bR[i106] = (short) ((bArr[i108] & 255) + ((bArr[i110] & 255) << 8));
                        int i112 = i111 + 1;
                        i15 = i112 + 1;
                        this.f423bS[i106] = (short) (((bArr[i112] & 255) << 8) + (bArr[i111] & 255));
                    }
                    this.f426bV[i106] = bArr[i15];
                    i106++;
                    i104 = i15 + 1;
                }
            }
            int i113 = i104 + 1;
            int i114 = bArr[i104] & 255;
            int i115 = i113 + 1;
            int i116 = i114 + ((bArr[i113] & 255) << 8);
            if (i116 > 0) {
                this.f417bM = new byte[i116];
                this.f418bN = new short[i116];
                int i117 = 0;
                while (i117 < i116) {
                    int i118 = i115 + 1;
                    this.f417bM[i117] = bArr[i115];
                    int i119 = i118 + 1;
                    this.f418bN[i117] = (short) ((bArr[i118] & 255) + ((bArr[i119] & 255) << 8));
                    i117++;
                    i115 = i119 + 1;
                }
            }
            if (this.f431bj <= 0) {
                if (C0338r.f2349pU) {
                    return;
                }
                boolean z13 = f379cL;
                return;
            }
            if (C0338r.f2324ov && (this.f459cd & 16777216) != 0 && (this.f459cd & 16777216) != 0 && i115 < bArr.length) {
                int i120 = i115 + 1;
                int i121 = i120 + 1;
                short s4 = (short) ((bArr[i115] & 255) + ((bArr[i120] & 255) << 8));
                if ((this.f459cd & 1073741824) != 0) {
                    i9 = bArr[i121];
                    i10 = i121 + 1;
                } else {
                    i9 = 1;
                    i10 = i121;
                }
                this.f465cj = new int[i9];
                if (this.f466ck == null) {
                    this.f466ck = new int[i9];
                }
                for (int i122 = 0; i122 < i9; i122++) {
                    int i123 = i10 + 1;
                    int i124 = bArr[i10] & 255;
                    this.f465cj[i122] = i124;
                    if (this.f464ci < i124) {
                        this.f464ci = i124;
                    }
                    int i125 = i123 + 1;
                    int i126 = bArr[i123] & 255;
                    if ((C0338r.f2295oS || C0338r.f2294oR) && i126 == 0) {
                        i126 = 256;
                    }
                    this.f466ck[i122] = i126;
                    m602A(i9);
                    i10 = m606a(i125, bArr, s4, i126, i122);
                }
                int i127 = i10 + 1;
                int i128 = bArr[i10] & 255;
                i115 = i127 + 1;
                this.f469cn = (short) (((bArr[i127] & 255) << 8) + i128);
                if (C0338r.f2292oP && (this.f469cn == 25840 || this.f469cn == -22976)) {
                    if (this.f470co == null) {
                        this.f470co = new int[i9];
                        this.f471cp = new int[i9];
                    }
                    for (int i129 = 0; i129 < i9; i129++) {
                        int i130 = this.f466ck[i129] - 1;
                        this.f470co[i129] = 1;
                        this.f471cp[i129] = 0;
                        while (i130 != 0) {
                            i130 >>= 1;
                            int[] iArr2 = this.f470co;
                            iArr2[i129] = iArr2[i129] << 1;
                            int[] iArr3 = this.f471cp;
                            iArr3[i129] = iArr3[i129] + 1;
                        }
                        this.f470co[i129] = r2[i129] - 1;
                    }
                }
                if (this.f431bj > 0) {
                    this.f457cb = new int[this.f431bj];
                    int i131 = 0;
                    int i132 = 0;
                    int i133 = i115;
                    while (i131 < this.f431bj) {
                        if ((this.f459cd & 128) != 0) {
                            int i134 = i133 + 1;
                            int i135 = i134 + 1;
                            int i136 = i135 + 1;
                            int i137 = (bArr[i133] & 255) + ((bArr[i134] & 255) << 8) + ((bArr[i135] & 255) << 16);
                            i13 = i136 + 1;
                            i14 = i137 + ((bArr[i136] & 255) << 24);
                        } else {
                            int i138 = i133 + 1;
                            i13 = i138 + 1;
                            i14 = (bArr[i133] & 255) + ((bArr[i138] & 255) << 8);
                        }
                        this.f457cb[i131] = i132;
                        i132 += i14;
                        i131++;
                        i133 = i13 + i14;
                    }
                    this.f456ca = new byte[i132];
                    int i139 = 0;
                    while (i139 < this.f431bj) {
                        if ((this.f459cd & 128) != 0) {
                            int i140 = i115 + 1;
                            int i141 = i140 + 1;
                            int i142 = i141 + 1;
                            int i143 = (bArr[i115] & 255) + ((bArr[i140] & 255) << 8) + ((bArr[i141] & 255) << 16) + ((bArr[i142] & 255) << 24);
                            i11 = i142 + 1;
                            i12 = i143;
                        } else {
                            int i144 = i115 + 1;
                            int i145 = (bArr[i115] & 255) + ((bArr[i144] & 255) << 8);
                            i11 = i144 + 1;
                            i12 = i145;
                        }
                        System.arraycopy(bArr, i11, this.f456ca, this.f457cb != null ? this.f457cb[i139] : -1, i12);
                        i139++;
                        i115 = i12 + i11;
                    }
                }
            }
            if (C0338r.f2323ou && (this.f459cd & 536870912) != 0 && (this.f459cd & 536870912) != 0) {
                if ((this.f459cd & 1073741824) != 0) {
                    i3 = i115 + 1;
                    this.f451cE = bArr[i115];
                    this.f452cF = new byte[this.f451cE][];
                } else {
                    this.f451cE = (byte) 1;
                    i3 = i115;
                }
                this.f465cj = new int[this.f451cE];
                this.f466ck = new int[this.f451cE];
                this.f458cc = new byte[this.f451cE][];
                int i146 = 0;
                i115 = i3;
                while (i146 < this.f451cE) {
                    if ((this.f459cd & 1073741824) != 0) {
                        i115 = i115 + 1 + 1 + 1 + 1;
                    }
                    if ((this.f459cd & 128) != 0) {
                        int i147 = i115 + 1;
                        int i148 = i147 + 1;
                        int i149 = i148 + 1;
                        int i150 = (bArr[i115] & 255) + ((bArr[i147] & 255) << 8) + ((bArr[i148] & 255) << 16);
                        i4 = i149 + 1;
                        i5 = i150 + ((bArr[i149] & 255) << 24);
                    } else {
                        int i151 = i115 + 1;
                        i4 = i151 + 1;
                        i5 = (bArr[i115] & 255) + ((bArr[i151] & 255) << 8);
                    }
                    if ((this.f459cd & 1073741824) != 0) {
                        this.f458cc[i146] = new byte[i5];
                        System.arraycopy(bArr, i4, this.f458cc[i146], 0, i5);
                        i6 = i5 + i4;
                    } else {
                        this.f456ca = new byte[i5];
                        System.arraycopy(bArr, i4, this.f456ca, 0, i5);
                        i6 = i5 + i4;
                    }
                    int i152 = i6 + 1;
                    int i153 = bArr[i6] & 255;
                    this.f465cj[i146] = i153;
                    if (this.f464ci < i153) {
                        this.f464ci = i153;
                    }
                    if ((this.f459cd & 1073741824) != 0) {
                        int i154 = i152 + 1;
                        i7 = bArr[i152] & 255;
                        if (i7 == 0) {
                            i7 = 256;
                        }
                        int i155 = (i7 * 3) + 4;
                        int i156 = i7 + 4;
                        int i157 = i155 + i156;
                        this.f452cF[i146] = new byte[i153 * i157];
                        System.arraycopy(this.f458cc[i146], 41, this.f452cF[i146], 0, i155);
                        System.arraycopy(this.f458cc[i146], i155 + 41 + 8, this.f452cF[i146], i155, i156);
                        System.arraycopy(bArr, i154, this.f452cF[i146], i157, (i153 - 1) * i157);
                        i8 = ((i153 - 1) * i157) + i154;
                    } else {
                        int i158 = i152 + 1;
                        i7 = bArr[i152] & 255;
                        if (i7 == 0) {
                            i7 = 256;
                        }
                        int i159 = (i7 * 3) + 4;
                        int i160 = i7 + 4;
                        int i161 = i159 + i160;
                        this.f463ch = new byte[i153 * i161];
                        System.arraycopy(this.f456ca, 41, this.f463ch, 0, i159);
                        System.arraycopy(this.f456ca, i159 + 41 + 8, this.f463ch, i159, i160);
                        System.arraycopy(bArr, i158, this.f463ch, i161, (i153 - 1) * i161);
                        i8 = ((i153 - 1) * i161) + i158;
                        int i162 = i159;
                        for (int i163 = 0; i163 < i153; i163++) {
                            for (int i164 = 0; i164 < i7; i164++) {
                                int i165 = this.f463ch[i162] & 255;
                                if (i165 == 255 || i165 == 0) {
                                    i162++;
                                }
                            }
                            i162 += i159 + 4;
                        }
                    }
                    this.f466ck[i146] = i7;
                    i146++;
                    i115 = i8;
                }
            }
            if (C0338r.f2317oo && (this.f459cd & 4194304) != 0 && (this.f460ce & 1048576) != 0) {
                int i166 = i115 + 1;
                int i167 = i166 + 1;
                short s5 = (short) ((bArr[i115] & 255) + ((bArr[i166] & 255) << 8));
                int i168 = i167 + 1;
                int i169 = bArr[i167] & 255;
                this.f469cn = (short) (((bArr[i168] & 255) << 8) + i169);
                i115 = i168 + 1 + 1;
                this.f451cE = bArr[r3];
                this.f465cj = new int[this.f451cE];
                if (this.f466ck == null) {
                    this.f466ck = new int[this.f451cE];
                }
                if (this.f461cf == null) {
                    this.f461cf = new short[this.f451cE << 1];
                }
                this.f467cl = new int[this.f451cE];
                for (int i170 = 0; i170 < this.f451cE; i170++) {
                    int i171 = i115 + 1;
                    int i172 = bArr[i115] & 255;
                    this.f465cj[i170] = i172;
                    if (this.f464ci < i172) {
                        this.f464ci = i172;
                    }
                    if (this.f464ci > C0338r.f2313ok) {
                        GLLib.m455bb();
                    }
                    int i173 = i171 + 1;
                    int i174 = bArr[i171] & 255;
                    if ((C0338r.f2295oS || C0338r.f2294oR) && i174 == 0) {
                        i174 = 256;
                    }
                    this.f466ck[i170] = i174;
                    m602A(this.f451cE);
                    i115 = m606a(i173, bArr, s5, i174, i170);
                }
                if (C0338r.f2292oP && (this.f469cn == 25840 || this.f469cn == -22976)) {
                    if (this.f470co == null) {
                        this.f470co = new int[this.f451cE];
                        this.f471cp = new int[this.f451cE];
                    }
                    for (int i175 = 0; i175 < this.f451cE; i175++) {
                        int i176 = this.f466ck[i175] - 1;
                        this.f470co[i175] = 1;
                        this.f471cp[i175] = 0;
                        while (i176 != 0) {
                            i176 >>= 1;
                            int[] iArr4 = this.f470co;
                            iArr4[i175] = iArr4[i175] << 1;
                            int[] iArr5 = this.f471cp;
                            iArr5[i175] = iArr5[i175] + 1;
                        }
                        this.f470co[i175] = r3[i175] - 1;
                    }
                }
                int i177 = 0;
                while (i177 < this.f451cE) {
                    int i178 = i115 + 1;
                    int i179 = i178 + 1;
                    short s6 = (short) ((bArr[i115] & 255) + ((bArr[i178] & 255) << 8));
                    int i180 = i179 + 1;
                    int i181 = bArr[i179] & 255;
                    int i182 = i180 + 1;
                    short s7 = (short) (((bArr[i180] & 255) << 8) + i181);
                    this.f461cf[i177 << 1] = s6;
                    this.f461cf[(i177 << 1) + 1] = s7;
                    int i183 = i182 + 1;
                    int i184 = bArr[i182] & 255;
                    int i185 = i183 + 1;
                    int i186 = ((bArr[i183] & 255) << 8) + i184;
                    int i187 = i185 + 1;
                    int i188 = i186 + ((bArr[i185] & 255) << 16);
                    int i189 = i187 + 1;
                    int i190 = ((bArr[i187] & 255) << 24) + i188;
                    int i191 = (this.f459cd & 1073741824) != 0 ? this.f465cj[i177] : this.f464ci;
                    if (this.f472ct == null) {
                        this.f472ct = new C0277ad[this.f464ci][];
                    }
                    if ((this.f459cd & 1073741824) != 0) {
                        if (this.f458cc == null) {
                            this.f458cc = new byte[this.f451cE][];
                        }
                        this.f458cc[i177] = new byte[i190];
                        System.arraycopy(bArr, i189, this.f458cc[i177], 0, i190);
                        i2 = i189 + i190;
                    } else {
                        this.f456ca = new byte[i190];
                        System.arraycopy(bArr, i189, this.f456ca, 0, i190);
                        i2 = i189 + i190;
                    }
                    for (int i192 = 0; i192 < i191; i192++) {
                        m673z(i192);
                        if (this.f472ct[i192] == null) {
                            this.f472ct[i192] = new C0277ad[this.f431bj];
                        }
                        if (C0338r.f2317oo && (this.f460ce & 1048576) != 0) {
                            int m603B = m603B(0);
                            C0277ad c0277ad = this.f472ct[i192][i177];
                            if (c0277ad != null) {
                                for (int i193 = 0; i193 < this.f472ct.length; i193++) {
                                    if (this.f472ct[i193] != null) {
                                        for (int i194 = 0; i194 < this.f472ct[i193].length; i194++) {
                                            if (this.f472ct[i193][i194] != null) {
                                                C0277ad[][] c0277adArr = this.f472ct;
                                            }
                                        }
                                    }
                                }
                                c0277ad.m683m(false);
                                this.f472ct[i192][i177] = null;
                            }
                            short s8 = this.f461cf == null ? (short) 0 : this.f461cf[i177 << 1];
                            short s9 = this.f461cf == null ? (short) 0 : this.f461cf[(i177 << 1) + 1];
                            m628m(i177, i192);
                            byte[] bArr2 = this.f458cc != null ? this.f458cc[i177] : this.f456ca;
                            if (C0338r.f2318op && bArr2 != null && m613a(i177, bArr2, 0, (int) s8, (int) s9, true)) {
                                if (C0338r.f2173mA && GLLib.m467bn()) {
                                    int[] iArr6 = f370bg;
                                    ?? r7 = C0338r.f2174mB;
                                    if (r7 > 0) {
                                        int i195 = s8 * s9;
                                        for (short s10 = r7; s10 < i195 - r7; s10++) {
                                            if ((iArr6[s10] >>> 24) == 0) {
                                                for (short s11 = 1; s11 <= r7; s11++) {
                                                    if (!((iArr6[s10 + s11] >>> 24) == 0)) {
                                                        iArr6[s10] = iArr6[s10 + s11] & 16777215;
                                                    } else if ((iArr6[s10 - s11] >>> 24) == 0) {
                                                        if (s10 - (s11 * s8) > 0) {
                                                            if (!((iArr6[s10 - (s11 * s8)] >>> 24) == 0)) {
                                                                iArr6[s10] = iArr6[s10 - (s11 * s8)] & 16777215;
                                                            }
                                                        }
                                                        if ((s11 * s8) + s10 < i195) {
                                                            if (!((iArr6[(s11 * s8) + s10] >>> 24) == 0)) {
                                                                iArr6[s10] = iArr6[(s11 * s8) + s10] & 16777215;
                                                            }
                                                        }
                                                    } else {
                                                        iArr6[s10] = iArr6[s10 - s11] & 16777215;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                this.f472ct[i192][i177] = C0277ad.m679b(f370bg, s8, s9);
                            }
                            m673z(m603B);
                        }
                        this.f453cR += s6 * s7;
                    }
                    i177++;
                    i115 = i2;
                }
                if (this.f485dr) {
                    m659d(true);
                }
                m673z(0);
                this.f459cd |= 536870912;
            }
            if (this.f467cl == null) {
                this.f467cl = new int[this.f465cj.length];
            }
            int i196 = this.f464ci;
            if (C0338r.f2328oz) {
                this.f430bZ = -1;
                if ((this.f460ce & 131072) == 0) {
                    this.f427bW = new short[C0338r.f2277oA][];
                } else if (C0338r.f2328oz) {
                    int m435b = GLLib.m435b(bArr, i115);
                    int i197 = i115 + 2;
                    this.f427bW = new short[m435b][];
                    if ((this.f460ce & 262144) != 0) {
                        if ((this.f460ce & 524288) != 0) {
                            this.f428bX = new short[m435b][];
                        } else {
                            this.f429bY = new byte[m435b][];
                        }
                    }
                    int i198 = 0;
                    while (i198 < m435b) {
                        if (this.f427bW[i198] == null) {
                            this.f427bW[i198] = new short[this.f431bj];
                            for (int i199 = 0; i199 < this.f431bj; i199++) {
                                this.f427bW[i198][65535 & i199] = (short) i199;
                            }
                        }
                        if ((this.f460ce & 262144) != 0) {
                            if ((this.f460ce & 524288) != 0) {
                                this.f428bX[i198] = new short[this.f431bj << 1];
                            } else {
                                this.f429bY[i198] = new byte[this.f431bj << 1];
                            }
                        }
                        short m435b2 = GLLib.m435b(bArr, i197);
                        int i200 = i197 + 2;
                        for (int i201 = 0; i201 < m435b2; i201++) {
                            short m435b3 = GLLib.m435b(bArr, i200);
                            int i202 = i200 + 2;
                            short m435b4 = GLLib.m435b(bArr, i202);
                            i200 = i202 + 2;
                            this.f427bW[i198][65535 & m435b3] = m435b4;
                            if ((this.f460ce & 262144) != 0) {
                                if ((this.f460ce & 524288) != 0) {
                                    short m435b5 = GLLib.m435b(bArr, i200);
                                    int i203 = i200 + 2;
                                    short m435b6 = GLLib.m435b(bArr, i203);
                                    i200 = i203 + 2;
                                    this.f428bX[i198][m435b3 << 1] = m435b5;
                                    this.f428bX[i198][(m435b3 << 1) + 1] = m435b6;
                                } else {
                                    int i204 = i200 + 1;
                                    this.f429bY[i198][m435b3 << 1] = bArr[i200];
                                    i200 = i204 + 1;
                                    this.f429bY[i198][(m435b3 << 1) + 1] = bArr[i204];
                                }
                            }
                        }
                        i198++;
                        i197 = i200;
                    }
                }
            }
            if (C0338r.f2319oq && (this.f459cd & 4096) != 0) {
                int m637V = m637V();
                if (m637V > 0) {
                    if ((this.f459cd & 1024) == 0 && (this.f468cm & 4) == 0) {
                        this.f445bx = new byte[m637V << 2];
                        int i205 = 0;
                        int i206 = 0;
                        while (i205 < m637V) {
                            m611a(f378cK, i205, 0, 0, 0, false);
                            int i207 = i206 + 1;
                            this.f445bx[i206] = (byte) f378cK[0];
                            int i208 = i207 + 1;
                            this.f445bx[i207] = (byte) f378cK[1];
                            int i209 = i208 + 1;
                            this.f445bx[i208] = (byte) (f378cK[2] - f378cK[0]);
                            this.f445bx[i209] = (byte) (f378cK[3] - f378cK[1]);
                            i205++;
                            i206 = i209 + 1;
                        }
                    } else {
                        this.f446by = new short[m637V << 2];
                        int i210 = 0;
                        int i211 = 0;
                        while (i210 < m637V) {
                            m611a(f378cK, i210, 0, 0, 0, false);
                            int i212 = i211 + 1;
                            this.f446by[i211] = (short) f378cK[0];
                            int i213 = i212 + 1;
                            this.f446by[i212] = (short) f378cK[1];
                            int i214 = i213 + 1;
                            this.f446by[i213] = (short) (f378cK[2] - f378cK[0]);
                            this.f446by[i214] = (short) (f378cK[3] - f378cK[1]);
                            i210++;
                            i211 = i214 + 1;
                        }
                    }
                }
            } else if ((this.f468cm & 4) != 0 && C0338r.f2319oq) {
                this.f468cm &= -5;
            }
            if (C0338r.f2349pU) {
                return;
            }
            boolean z14 = f379cL;
        } catch (Exception e) {
        }
    }

    final void m649a(int[] iArr, int i, int i2, int i3, int i4) {
        m612a(iArr, i, i2, i3, 0, false, false);
    }

    final short[] m650a(String str, int i, boolean z) {
        short s;
        int i2;
        boolean z2;
        short s2;
        int i3;
        short s3;
        short s4;
        short s5;
        short s6;
        boolean z3;
        int i4;
        int i5;
        boolean z4;
        short s7;
        int i6;
        short m605Z;
        int i7;
        boolean z5;
        boolean z6;
        short s8;
        if (f398dk == null) {
            f398dk = new short[C0338r.f2410qd];
        }
        int length = str.length();
        short s9 = 0;
        short s10 = 1;
        int i8 = this.f475da;
        short s11 = 0;
        boolean z7 = this.f481dg;
        boolean z8 = this.f480df;
        int i9 = this.f467cl[0];
        boolean z9 = false;
        short s12 = 0;
        boolean z10 = this.f481dg;
        boolean z11 = this.f480df;
        int i10 = this.f467cl[0];
        int i11 = 0;
        if (C0338r.f2409qc) {
            i11 = (z11 ? Utility.DEFAULT_STREAM_BUFFER_SIZE : 0) | (i10 & 4095) | (z10 ? 4096 : 0);
        }
        int i12 = 0;
        int i13 = i11;
        short s13 = 0;
        while (i12 < length) {
            char charAt = str.charAt(i12);
            char c = charAt;
            int m633y = m633y(m632x(charAt));
            char c2 = charAt;
            m632x(charAt);
            int m651ab = m651ab();
            if (i8 >= m651ab) {
                m651ab = i8;
            }
            if (charAt == ' ' || (C0338r.f2411qe && charAt == f381cN)) {
                if (!C0338r.f2411qe || charAt == ' ') {
                    s13 = (short) (s13 + ((short) m605Z()));
                }
                short s14 = (short) i12;
                if (C0338r.f2409qc) {
                    i2 = i10;
                    z2 = z11;
                } else {
                    i2 = i9;
                    z2 = z8;
                }
                if (s13 <= i || z) {
                    i9 = i2;
                    z8 = z2;
                    s2 = s9;
                    i3 = i12;
                    s3 = 0;
                    s4 = s14;
                    s5 = s10;
                    z7 = z10;
                    int i14 = m651ab;
                    s6 = s13;
                    z3 = true;
                    i4 = i14;
                } else {
                    if (!C0338r.f2411qe || str.charAt(s14) == ' ') {
                        s13 = (short) (s13 - ((short) m605Z()));
                    }
                    short s15 = (short) (s10 + 1);
                    f398dk[s10] = s9;
                    short s16 = (short) (s15 + 1);
                    f398dk[s15] = (short) (s14 - s9);
                    short s17 = (short) (s16 + 1);
                    f398dk[s16] = s13;
                    short s18 = (short) (s17 + 1);
                    f398dk[s17] = (short) m651ab;
                    if (C0338r.f2409qc) {
                        short s19 = (short) (s18 + 1);
                        f398dk[s18] = (short) i13;
                        i6 = (z2 ? Utility.DEFAULT_STREAM_BUFFER_SIZE : 0) | (i2 & 4095) | (z10 ? 4096 : 0);
                        i5 = i2;
                        s7 = s19;
                        z4 = z2;
                    } else {
                        int i15 = i13;
                        i5 = i10;
                        z4 = z11;
                        s7 = s18;
                        i6 = i15;
                    }
                    s6 = 0;
                    s2 = (short) (((short) ((s14 - s9) + 1)) + s9);
                    z8 = z2;
                    s3 = 0;
                    s4 = s14;
                    z7 = z10;
                    int i16 = i2;
                    i3 = i12;
                    s5 = s7;
                    z11 = z4;
                    i10 = i5;
                    i13 = i6;
                    z3 = false;
                    i4 = this.f475da;
                    i9 = i16;
                }
            } else if (C0338r.f2329pA && charAt == '\\') {
                int i17 = i12 + 1;
                char charAt2 = str.charAt(i17);
                if (charAt2 == '^') {
                    z10 = !z10;
                    s5 = s10;
                    i3 = i17;
                    s4 = s11;
                    s3 = s12;
                    i4 = m651ab;
                    s6 = s13;
                    z3 = z9;
                    s2 = s9;
                } else {
                    if (C0338r.f2409qc) {
                        if (charAt2 == '_') {
                            z11 = !z11;
                            s5 = s10;
                            i3 = i17;
                            s4 = s11;
                            s3 = s12;
                            i4 = m651ab;
                            s6 = s13;
                            z3 = z9;
                            s2 = s9;
                        } else {
                            int i18 = (charAt2 & 255) - 48;
                            if (i18 < this.f464ci) {
                                i10 = i18;
                            }
                        }
                    }
                    i3 = i17;
                    s5 = s10;
                    s4 = s11;
                    s3 = s12;
                    i4 = m651ab;
                    s6 = s13;
                    z3 = z9;
                    s2 = s9;
                }
            } else if (charAt == '\n') {
                short s20 = (short) (s10 + 1);
                f398dk[s10] = s9;
                short s21 = (short) (s20 + 1);
                f398dk[s20] = (short) (i12 - s9);
                short s22 = (short) (s21 + 1);
                f398dk[s21] = s13;
                short s23 = (short) (s22 + 1);
                f398dk[s22] = (short) m651ab;
                short s24 = (short) (i12 + 1);
                int i19 = this.f475da;
                if (C0338r.f2409qc) {
                    short s25 = (short) (s23 + 1);
                    f398dk[s23] = (short) i13;
                    i13 = (i10 & 4095) | (z10 ? 4096 : 0) | (z11 ? Utility.DEFAULT_STREAM_BUFFER_SIZE : 0);
                    s23 = s25;
                }
                i3 = i12;
                s5 = s23;
                z3 = false;
                s4 = s11;
                s3 = s12;
                i4 = i19;
                s2 = s24;
                s6 = 0;
            } else {
                if (charAt < ' ') {
                    if (charAt == 1 || charAt != 2) {
                        i3 = i12;
                        s4 = s11;
                        s3 = s12;
                        s5 = s10;
                        i4 = m651ab;
                        s6 = s13;
                        z3 = z9;
                        s2 = s9;
                    } else {
                        charAt = str.charAt(i12);
                    }
                }
                int m605Z2 = charAt == ' ' ? m605Z() : m615aa() + m633y;
                int i20 = z10 ? m605Z2 + 1 : m605Z2;
                short s26 = (short) (((short) i20) + s12);
                short s27 = (short) (s13 + ((short) i20));
                if (s27 > i) {
                    boolean z12 = z || !z9;
                    int i21 = 0;
                    if (z12) {
                        m605Z = (short) (s27 - ((short) i20));
                        s4 = 0;
                        i3 = i12 - 1;
                        s3 = 0;
                        i21 = 1;
                    } else {
                        m605Z = (short) (s27 - ((short) m605Z()));
                        s4 = s11;
                        i3 = s11;
                        s3 = s26;
                    }
                    short s28 = (short) (s10 + 1);
                    f398dk[s10] = s9;
                    short s29 = (short) (s28 + 1);
                    f398dk[s28] = (short) (i21 + (i3 - s9));
                    short s30 = (short) (s29 + 1);
                    f398dk[s29] = (short) (m605Z - s3);
                    short s31 = (short) (s30 + 1);
                    f398dk[s30] = (short) m651ab;
                    if (z12) {
                        s3 = 0;
                        i7 = i10;
                        z5 = z11;
                        z6 = z10;
                    } else {
                        i7 = i9;
                        z5 = z8;
                        z6 = z7;
                    }
                    if (C0338r.f2409qc) {
                        short s32 = (short) (s31 + 1);
                        f398dk[s31] = (short) i13;
                        if (i10 >= 4095) {
                            GLLib.m455bb();
                        }
                        i13 = (z5 ? Utility.DEFAULT_STREAM_BUFFER_SIZE : 0) | (i7 & 4095) | (z6 ? 4096 : 0);
                        i10 = i7;
                        s8 = s32;
                        z11 = z5;
                    } else {
                        s8 = s31;
                    }
                    s6 = 0;
                    s5 = s8;
                    z8 = z5;
                    i4 = this.f475da;
                    z10 = z6;
                    int i22 = i7;
                    z3 = false;
                    s2 = (short) (i3 + 1);
                    z7 = z6;
                    i9 = i22;
                } else {
                    z3 = z9;
                    i4 = m651ab;
                    s2 = s9;
                    s6 = s27;
                    s4 = s11;
                    s3 = s26;
                    i3 = i12;
                    s5 = s10;
                }
            }
            s10 = s5;
            s9 = s2;
            z9 = z3;
            i12 = i3 + 1;
            s13 = s6;
            short s33 = s4;
            i8 = i4;
            s12 = s3;
            s11 = s33;
        }
        short s34 = (short) (s10 + 1);
        f398dk[s10] = s9;
        short s35 = (short) (s34 + 1);
        f398dk[s34] = (short) (str.length() - s9);
        short s36 = (short) (s35 + 1);
        f398dk[s35] = s13;
        short s37 = (short) (s36 + 1);
        f398dk[s36] = (short) i8;
        if (C0338r.f2409qc) {
            s = (short) (s37 + 1);
            f398dk[s37] = (short) i13;
        } else {
            s = s37;
        }
        f398dk[0] = (short) (s / (C0338r.f2409qc ? (short) 5 : (short) 4));
        return f398dk;
    }

    final int m651ab() {
        return (!C0338r.f2439rG || this.f484dj < 0) ? this.f475da : (this.f475da * this.f484dj) >> 8;
    }

    final int m652ac() {
        return this.f467cl[0];
    }

    final int m653b(int i, int i2) {
        return this.f421bQ[this.f418bN[i] + i2] & 255;
    }

    final void m654b(C0048ac c0048ac, int i, float f, float f2, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        this.f473cu++;
        int i8 = (!C0338r.f2362ph || (this.f459cd & 2048) == 0) ? this.f442bu[i] & 255 : this.f443bv[i];
        if (i8 > 0) {
            for (int i9 = 0; i9 < i8; i9++) {
                int m619e = m619e(i, i9);
                int m630s = m630s(m619e);
                int m629r = m629r(m619e);
                boolean z = C0338r.f2317oo;
                float f3 = 0.0f;
                float f4 = 0.0f;
                if (!C0338r.f2328oz || this.f430bZ < 0) {
                    i3 = m629r;
                } else {
                    if ((this.f460ce & 262144) != 0) {
                        if ((this.f460ce & 524288) != 0) {
                            f3 = this.f428bX[this.f430bZ][m629r << 1];
                            f4 = this.f428bX[this.f430bZ][(m629r << 1) + 1];
                        } else {
                            f3 = this.f429bY[this.f430bZ][m629r << 1];
                            f4 = this.f429bY[this.f430bZ][(m629r << 1) + 1];
                        }
                    }
                    i3 = this.f427bW[this.f430bZ][m629r] & 65535;
                }
                int i10 = C0338r.f2358pd ? this.f436bo[i3] & 65535 : this.f438bq[i3] & 255;
                int i11 = C0338r.f2358pd ? 65535 & this.f437bp[i3] : this.f439br[i3] & 255;
                float m664l = f3 + m664l(m619e);
                float m665m = f4 + m665m(m619e);
                if ((m630s & 4) != 0) {
                    i4 = i11;
                    i5 = i10;
                } else {
                    i4 = i10;
                    i5 = i11;
                }
                if ((i2 & 1) != 0) {
                    i6 = f396cy[m630s & 7] | (m630s & (-8));
                    m664l = (-m664l) - i4;
                } else {
                    i6 = m630s;
                }
                if ((i2 & 2) != 0) {
                    i6 = (i6 & (-8)) | f397cz[i6 & 7];
                    m665m = (-m665m) - i5;
                }
                if ((i2 & 4) != 0) {
                    i6 = (i6 & (-8)) | f373cA[i6 & 7];
                    if (C0338r.f2439rG) {
                        if ((GLLib.f233kY & 262144) != 0) {
                        }
                    }
                    float f5 = (-m665m) - i5;
                    i7 = i6;
                    m665m = m664l;
                    m664l = f5;
                    if (C0338r.f2439rG) {
                        if ((GLLib.f233kY & 262144) != 0) {
                            if (GLLib.f234kZ[18][6] % GLLib.f199jq != 0) {
                                GLLib.f234kZ[18][7] = (int) (-m664l);
                                GLLib.f234kZ[18][8] = (int) (-m665m);
                            }
                            if (!(GLLib.f234kZ[18][5] != 0)) {
                                m664l = (m664l * GLLib.m475bv()) / 100.0f;
                                m665m = (m665m * GLLib.m476bw()) / 100.0f;
                            }
                        }
                    }
                    m643a(c0048ac, m629r, f + m664l, f2 + m665m, i7 & 15, i10, i11);
                    boolean z2 = C0338r.f2317oo;
                }
                i7 = i6;
                if (C0338r.f2439rG) {
                }
                m643a(c0048ac, m629r, f + m664l, f2 + m665m, i7 & 15, i10, i11);
                boolean z22 = C0338r.f2317oo;
            }
        }
        this.f473cu--;
    }

    final void m655b(C0048ac c0048ac, int i, int i2, int i3, int i4, int i5) {
        if (C0338r.f2439rG) {
            GLLib.m437b(18, false);
            GLLib.m422ao(i5);
            m642a(c0048ac, i, i2, i3, 0);
            GLLib.m485c(18, false);
        }
    }

    final void m656b(int[] iArr) {
        this.f483di = iArr[0];
        this.f482dh = new int[this.f483di][];
        int i = 1;
        for (int i2 = 0; i2 < this.f483di; i2++) {
            this.f482dh[i2] = new int[2];
            int i3 = i + 1;
            this.f482dh[i2][0] = iArr[i];
            i = i3 + 1;
            this.f482dh[i2][1] = iArr[i3];
        }
        while (i < iArr.length) {
            int i4 = i + 1;
            int i5 = iArr[i];
            i = i4 + 1;
            int i6 = iArr[i4];
            int[] iArr2 = new int[(i6 << 1) + 2];
            iArr2[0] = this.f482dh[i5][0];
            iArr2[1] = this.f482dh[i5][1];
            for (int i7 = 0; i7 < i6; i7++) {
                int i8 = i + 1;
                iArr2[(i7 << 1) + 2] = iArr[i];
                i = i8 + 1;
                iArr2[(i7 << 1) + 3] = iArr[i8];
            }
            this.f482dh[i5] = iArr2;
        }
        this.f479de = -m622g(0, 0);
        this.f475da = m622g(0, 1) + this.f479de;
        this.f476db = m622g(0, 2) - m622g(0, 1);
        this.f477dc = m621f(m632x(32), 0);
    }

    final int m657c(int i, int i2) {
        return m629r(m619e(i, i2));
    }

    final int m658d(int i, int i2) {
        return m630s(m619e(i, i2));
    }

    final void m659d(boolean z) {
        if (C0338r.f2323ou && (this.f459cd & 536870912) != 0) {
            this.f463ch = null;
        }
        this.f463ch = null;
        this.f462cg = null;
        this.f470co = null;
        this.f471cp = null;
        this.f456ca = null;
        this.f457cb = null;
        if (C0338r.f2349pU) {
            return;
        }
        boolean z2 = f379cL;
    }

    final int m660h(int i, int i2) {
        return this.f420bP[this.f418bN[i] + i2] & 255;
    }

    final int m661i(int i) {
        return this.f417bM[i] & 255;
    }

    final void m662j(int i, int i2) {
        if (C0338r.f2364pj) {
            this.f413bI[i] = (short) i2;
        } else {
            this.f415bK[i] = (byte) i2;
        }
    }

    final void m663k(int i, int i2) {
        if (C0338r.f2364pj) {
            this.f414bJ[i] = (short) i2;
        } else {
            this.f416bL[i] = (byte) i2;
        }
    }

    final int m664l(int i) {
        return C0338r.f2364pj ? this.f413bI[i] : this.f415bK[i];
    }

    final int m665m(int i) {
        return C0338r.f2364pj ? this.f414bJ[i] : this.f416bL[i];
    }

    final int m666n(int i) {
        if (C0338r.f2319oq) {
            return ((this.f459cd & 1024) == 0 && (this.f468cm & 4) == 0) ? this.f445bx[(i << 2) + 2] & 255 : this.f446by[(i << 2) + 2] & 65535;
        }
        m611a(f378cK, i, 0, 0, 0, false);
        return f378cK[2] - f378cK[0];
    }

    final int m667o(int i) {
        if (C0338r.f2319oq) {
            return ((this.f459cd & 1024) == 0 && (this.f468cm & 4) == 0) ? this.f445bx[(i << 2) + 3] & 255 : this.f446by[(i << 2) + 3] & 65535;
        }
        m611a(f378cK, i, 0, 0, 0, false);
        return f378cK[3] - f378cK[1];
    }

    final int m668p(int i) {
        if (C0338r.f2319oq) {
            return ((this.f459cd & 1024) == 0 && (this.f468cm & 4) == 0) ? this.f445bx[i << 2] : this.f446by[i << 2];
        }
        m611a(f378cK, i, 0, 0, 0, false);
        return f378cK[0];
    }

    final int m669q(int i) {
        if (C0338r.f2319oq) {
            return ((this.f459cd & 1024) == 0 && (this.f468cm & 4) == 0) ? this.f445bx[(i << 2) + 1] : this.f446by[(i << 2) + 1];
        }
        m611a(f378cK, i, 0, 0, 0, false);
        return f378cK[1];
    }

    final int m670t(int i) {
        if (!C0338r.f2346pR || this.f408bD == null) {
            return 0;
        }
        return this.f408bD[i + 1] - this.f408bD[i];
    }

    final boolean m671u(int i) {
        return i >= 0 && this.f472ct != null && i < this.f472ct.length && this.f472ct[i] != null;
    }

    final void m672w(int i) {
        if (C0338r.f2281oE) {
            this.f454cS = i;
            if (this.f472ct == null) {
                this.f472ct = new C0277ad[this.f464ci][];
                for (int i2 = 0; i2 < this.f464ci; i2++) {
                    this.f472ct[i2] = new C0277ad[this.f431bj];
                }
            }
        }
    }

    final void m673z(int i) {
        m628m(0, i);
    }
}
