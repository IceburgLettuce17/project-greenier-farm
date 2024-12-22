package com.gameloft.android.LATAM.GloftGF2H;

import com.facebook.Request;
import com.facebook.android.C0217R;
import com.facebook.widget.PlacePickerFragment;
import com.facebook.widget.WorkQueue;
import p009b.p010a.p012b.C0048ac;

final class C0319bs {

    static C0319bs[] f755Bt;

    private static int f756CR = 0;

    private static int f757CS = 10;

    private static int f758CT = 0;

    private static int f759CU = 10;

    private static int f760CV = 0;

    private static int f761CW = 0;

    private static int f762CX = 0;

    private static int f763CY = 10;

    private static boolean f764CZ = false;

    private static int[] f765DT;

    private static int[][] f766DU;

    private static int f767DV;

    private int f769BB;

    private int f770BC;

    private int f771BD;

    private int f772BE;

    private int f773BF;

    private int f774BG;

    private float f775BH;

    private float f776BI;

    private float f777BJ;

    private float f778BK;

    private int f779BL;

    long f784BQ;

    int f785BR;

    private int f786BS;

    private int f787BT;

    long f792BY;

    private int f794Bu;

    private int f795Bv;

    private int f796Bw;

    private int f797Bx;

    private int f798By;

    private boolean f801CB;

    private int f843DA;

    int f844DB;

    int f845DC;

    int f846DD;

    private C0319bs f847DE;

    RunnableC0340t f848DF;

    private int f849DG;

    private int f850DH;

    RunnableC0340t f851DI;

    boolean f852DJ;

    int f853DK;

    int f854DL;

    private C0339s f857DO;

    private int f858DP;

    private int f859DQ;

    private boolean f860DR;

    private boolean f861DS;

    int f862DW;

    C0319bs f864Db;

    private C0319bs f865Dc;

    int f867De;

    int f868Df;

    int f869Dg;

    int f870Dh;

    private int f871Di;

    private int f872Dj;

    int f873Dk;

    int f874Dl;

    private int f875Dm;

    private int f876Dn;

    private int f877Do;

    int f878Dp;

    int f879Dq;

    private int f880Dr;

    int f883Du;

    int f886Dx;

    int f887Dy;

    int f888Dz;

    int f889yM;

    boolean f799Bz = false;

    private boolean f768BA = false;

    long f780BM = 0;

    boolean f781BN = false;

    private int f782BO = 0;

    private boolean f783BP = false;

    int f788BU = 0;

    byte f789BV = 0;

    private boolean f790BW = false;

    byte f791BX = 0;

    long f793BZ = 0;

    int f817Ca = Integer.MAX_VALUE;

    int f818Cb = 0;

    int f819Cc = 0;

    int f820Cd = 0;

    int f821Ce = 0;

    long f822Cf = 0;

    int f823Cg = 0;

    private boolean f824Ch = false;

    private boolean f825Ci = false;

    private boolean f826Cj = false;

    private boolean f827Ck = false;

    boolean f828Cl = false;

    int f829Cm = 0;

    short f830Cn = 0;

    private boolean f831Co = false;

    private boolean f832Cp = false;

    short f833Cq = 0;

    short f834Cr = 0;

    int f835Cs = 0;

    int f836Ct = 0;

    int f837Cu = 0;

    int f838Cv = 0;

    short f839Cw = 0;

    boolean f840Cx = false;

    long f841Cy = 0;

    int f842Cz = 0;

    int f800CA = 0;

    private int f802CC = 0;

    int f803CD = 0;

    int f804CE = 0;

    private int f805CF = 0;

    private int f806CG = 0;

    private int f807CH = 0;

    boolean f808CI = false;

    private boolean f809CJ = false;

    private int f810CK = 0;

    private int f811CL = 0;

    private int f812CM = 0;

    private int f813CN = 0;

    private int f814CO = 0;

    private int f815CP = 0;

    private boolean f816CQ = true;

    int f863Da = 0;

    private int f866Dd = -1;

    short f881Ds = 0;

    int f882Dt = -1;

    int f884Dv = 0;

    int f885Dw = 0;

    int f855DM = 0;

    byte f856DN = 0;

    C0319bs() {
    }

    private static int m908M(int i, int i2) {
        int i3 = 0;
        for (C0319bs c0319bs = f755Bt[1]; c0319bs != null; c0319bs = c0319bs.f864Db) {
            if (c0319bs.f867De == i2) {
                i3++;
            }
        }
        return i3;
    }

    static int m909N(int i, int i2) {
        int i3 = 0;
        for (C0319bs c0319bs = f755Bt[1]; c0319bs != null; c0319bs = c0319bs.f864Db) {
            if ((i2 == -1 || c0319bs.f867De == i2) && c0319bs.m975bB(512)) {
                i3++;
            }
        }
        return i3;
    }

    static int m910O(int i, int i2) {
        int i3 = 0;
        for (C0319bs c0319bs = f755Bt[1]; c0319bs != null; c0319bs = c0319bs.f864Db) {
            if (c0319bs.f867De == 54 && c0319bs.m975bB(512)) {
                if (i2 == 0 && c0319bs.m975bB(32)) {
                    i3++;
                } else if (i2 == 1 && !c0319bs.m975bB(32)) {
                    i3++;
                } else if (i2 == 2 && c0319bs.m975bB(2048)) {
                    i3++;
                }
            }
        }
        return i3;
    }

    static int m911P(int i, int i2) {
        int i3 = 0;
        for (C0319bs c0319bs = f755Bt[1]; c0319bs != null; c0319bs = c0319bs.f864Db) {
            if (c0319bs.f853DK == i2 && c0319bs.m975bB(512)) {
                i3++;
            }
        }
        return i3;
    }

    static int m912Q(int i, int i2) {
        int i3 = 0;
        for (C0319bs c0319bs = f755Bt[1]; c0319bs != null; c0319bs = c0319bs.f864Db) {
            if (c0319bs.f867De == 52 && c0319bs.m975bB(512)) {
                i3++;
            }
        }
        return i3;
    }

    static int m913R(int i, int i2) {
        int i3 = 0;
        for (C0319bs c0319bs = f755Bt[1]; c0319bs != null; c0319bs = c0319bs.f864Db) {
            if (c0319bs.f867De == 54 && c0319bs.m975bB(512) && c0319bs.f882Dt % 2 == 1 && c0319bs.m975bB(2048)) {
                i3++;
            }
        }
        return i3;
    }

    static C0319bs m914S(int i, int i2) {
        if (f755Bt != null) {
            C0319bs c0319bs = f755Bt[i];
            C0319bs c0319bs2 = c0319bs;
            while (c0319bs2 != null) {
                if ((i2 == -1 || c0319bs2.f867De == i2) && c0319bs2.m975bB(512) && c0319bs2.m963fe()) {
                    return c0319bs2;
                }
                C0319bs c0319bs3 = c0319bs2;
                c0319bs2 = c0319bs2.f864Db;
                c0319bs = c0319bs3;
            }
            for (C0319bs c0319bs4 = c0319bs; c0319bs4 != null; c0319bs4 = c0319bs4.f865Dc) {
                if ((i2 == -1 || c0319bs4.f867De == i2) && c0319bs4.m975bB(512) && c0319bs4.m962fd()) {
                    return c0319bs4;
                }
            }
        }
        return null;
    }

    static C0319bs m915T(int i, int i2) {
        for (C0319bs c0319bs = f755Bt[1]; c0319bs != null; c0319bs = c0319bs.f864Db) {
            if (c0319bs.f883Du == i2) {
                return c0319bs;
            }
        }
        return null;
    }

    static int m916U(int i, int i2) {
        int i3 = 0;
        for (C0319bs c0319bs = f755Bt[1]; c0319bs != null; c0319bs = c0319bs.f864Db) {
            int i4 = c0319bs.f867De;
            if (c0319bs.f867De == 54 && c0319bs.m975bB(512)) {
                i3 += c0319bs.f881Ds;
            }
        }
        return i3;
    }

    private void m917V(int i, int i2) {
        int i3;
        if (m959er()) {
            return;
        }
        int i4 = i & 32767;
        C0271a c0271a = (32768 & i) != 0 ? C0320bt.f987Fq[i4] : C0320bt.f1863Wk[i4];
        int i5 = this.f843DA;
        if (!m918W(i, i2) || c0271a == null || i2 < 0) {
            return;
        }
        if (m975bB(65536)) {
            i3 = (((c0271a.f459cd & 1073741824) != 0 ? c0271a.f465cj[0] : c0271a.f464ci) >> 1) + i5;
        } else {
            i3 = i5;
        }
        c0271a.m673z(i3);
        if (C0320bt.f1799VY == 100 || this.f871Di == 2) {
            c0271a.m642a(GLLib.f134iC, i2, this.f873Dk, this.f874Dl, 0);
            return;
        }
        GLLib.m502k(true);
        c0271a.m655b(GLLib.f134iC, i2, this.f873Dk, this.f874Dl, 0, C0320bt.f1799VY);
        GLLib.m502k(false);
    }

    private boolean m918W(int i, int i2) {
        int i3 = i & 32767;
        return m928a((32768 & i) != 0 ? C0320bt.f987Fq[i3] : C0320bt.f1863Wk[i3], i2);
    }

    static int m919a(int i, int i2, int i3, int i4, int i5, int i6, C0319bs[] c0319bsArr, int i7) {
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        int i8 = 0;
        for (C0319bs c0319bs = f755Bt[1]; c0319bs != null && i8 < 100; c0319bs = c0319bs.f864Db) {
            iArr[0] = c0319bs.f868Df;
            iArr[1] = c0319bs.f869Dg;
            C0320bt.m1184c(iArr, iArr2);
            if ((i2 == -1 || i2 == c0319bs.f867De) && c0319bs.f867De != -1 && iArr2[0] >= i3 && iArr2[0] < i4 && iArr2[1] >= i5 && iArr2[1] < i6) {
                c0319bsArr[i8] = c0319bs;
                i8++;
            }
        }
        return i8;
    }

    static int m920a(int i, int i2, int i3, int i4, C0319bs[] c0319bsArr, int i5) {
        int i6;
        int i7 = 0;
        C0319bs c0319bs = f755Bt[1];
        while (c0319bs != null && i7 < i5) {
            if (c0319bs.f867De == 54 && c0319bs.m975bB(512) && c0319bs.f882Dt >= i3 && c0319bs.f882Dt <= i4 && c0319bs.f882Dt % 2 == 1) {
                i6 = i7 + 1;
                c0319bsArr[i7] = c0319bs;
            } else {
                i6 = i7;
            }
            c0319bs = c0319bs.f864Db;
            i7 = i6;
        }
        return i7;
    }

    static int m921a(int i, int i2, int i3, C0319bs[] c0319bsArr, int i4) {
        int i5 = 0;
        for (C0319bs c0319bs = f755Bt[i]; c0319bs != null && i5 < i4; c0319bs = c0319bs.f864Db) {
            if ((i2 == -1 || c0319bs.f867De == i2) && (i3 == -1 || c0319bs.f882Dt == i3)) {
                c0319bsArr[i5] = c0319bs;
                i5++;
            }
        }
        return i5;
    }

    static int m922a(int i, int i2, C0319bs[] c0319bsArr, int i3) {
        return m921a(i, i2, -1, c0319bsArr, i3);
    }

    static int m923a(int i, int i2, C0319bs[] c0319bsArr, int i3, C0319bs c0319bs) {
        int i4;
        int i5 = 0;
        C0319bs c0319bs2 = f755Bt[1];
        while (c0319bs2 != null && i5 < 50) {
            if (c0319bs2.f867De == 54 && c0319bs2.m975bB(512) && C0320bt.m1080a(c0319bs2, c0319bs)) {
                i4 = i5 + 1;
                c0319bsArr[i5] = c0319bs2;
            } else {
                i4 = i5;
            }
            c0319bs2 = c0319bs2.f864Db;
            i5 = i4;
        }
        return i5;
    }

    static int m924a(C0319bs[] c0319bsArr, int i) {
        int i2 = 0;
        if (f755Bt != null) {
            for (C0319bs c0319bs = f755Bt[1]; c0319bs != null; c0319bs = c0319bs.f864Db) {
                if (c0319bs.m975bB(512) && (c0319bs.m963fe() || c0319bs.m962fd())) {
                    c0319bsArr[i2] = c0319bs;
                    i2++;
                }
            }
        }
        return i2;
    }

    static C0319bs m925a(int i, int i2, int[] iArr) {
        C0319bs c0319bs = new C0319bs();
        c0319bs.f864Db = null;
        c0319bs.f865Dc = null;
        c0319bs.f848DF = null;
        c0319bs.f851DI = null;
        c0319bs.f866Dd = -1;
        c0319bs.f867De = 0;
        c0319bs.f868Df = 0;
        c0319bs.f869Dg = 0;
        c0319bs.f870Dh = 0;
        c0319bs.f873Dk = 0;
        c0319bs.f874Dl = 0;
        c0319bs.f875Dm = 0;
        c0319bs.f871Di = -1;
        c0319bs.f849DG = 0;
        c0319bs.f850DH = 0;
        c0319bs.f883Du = -1;
        c0319bs.f886Dx = 0;
        c0319bs.f887Dy = -1;
        c0319bs.f888Dz = -1;
        c0319bs.f843DA = 0;
        c0319bs.f844DB = -1;
        c0319bs.f852DJ = false;
        c0319bs.f878Dp = 1;
        c0319bs.f879Dq = 1;
        c0319bs.f856DN = (byte) 0;
        c0319bs.f876Dn = 0;
        c0319bs.f877Do = 0;
        c0319bs.f867De = i;
        c0319bs.m982bz(8);
        switch (c0319bs.f867De) {
            case 10:
                c0319bs.f868Df = iArr[0];
                c0319bs.f869Dg = iArr[1];
                c0319bs.f870Dh = iArr[2];
                break;
            case 11:
                c0319bs.f868Df = iArr[0];
                c0319bs.f869Dg = iArr[1];
                c0319bs.f870Dh = iArr[2];
                c0319bs.f887Dy = iArr[3];
                c0319bs.f888Dz = iArr[4];
                c0319bs.f871Di = iArr[5];
                break;
            case 12:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 43:
            case 44:
            case 45:
            case 46:
            case 53:
            default:
                c0319bs.f867De = -1;
                break;
            case 13:
                c0319bs.f868Df = iArr[0];
                c0319bs.f869Dg = iArr[1];
                c0319bs.f870Dh = iArr[2];
                c0319bs.f889yM = 0;
                c0319bs.f771BD = 0;
                c0319bs.f773BF = 0;
                c0319bs.f772BE = RunnableC0340t.f2587uK[0][5];
                c0319bs.f774BG = RunnableC0340t.f2587uK[0][6];
                RunnableC0340t.m2082a(0, c0319bs.f868Df, c0319bs.f869Dg);
                c0319bs.m974bA(8);
                break;
            case 20:
                c0319bs.f868Df = iArr[0];
                c0319bs.f869Dg = iArr[1];
                c0319bs.f870Dh = iArr[2];
                c0319bs.f882Dt = iArr[3];
                c0319bs.f887Dy = iArr[4];
                c0319bs.f843DA = iArr[5];
                c0319bs.f888Dz = iArr[6];
                c0319bs.f878Dp = iArr[7];
                c0319bs.f879Dq = iArr[8];
                c0319bs.f880Dr = C0320bt.m1089aF(c0319bs.f878Dp, c0319bs.f879Dq);
                if (C0320bt.f1863Wk[c0319bs.f887Dy].m636U() > 0) {
                    c0319bs.f848DF = new RunnableC0340t(C0320bt.f1863Wk[c0319bs.f887Dy], c0319bs.f868Df, c0319bs.f869Dg);
                    c0319bs.f848DF.m2143x(0, -1);
                    c0319bs.m982bz(33554432);
                } else {
                    c0319bs.m982bz(16777216);
                }
                c0319bs.m982bz(515);
                int i3 = iArr[9];
                int i4 = iArr[10];
                if (i3 == 1) {
                    c0319bs.m982bz(64);
                }
                if (i4 == 1) {
                    c0319bs.m982bz(128);
                    break;
                }
                break;
            case 21:
                c0319bs.f868Df = iArr[0];
                c0319bs.f869Dg = iArr[1];
                c0319bs.f870Dh = iArr[2];
                c0319bs.m982bz(65536);
                break;
            case 22:
                c0319bs.f868Df = iArr[0];
                c0319bs.f869Dg = iArr[1];
                c0319bs.f870Dh = iArr[2];
                c0319bs.f848DF = new RunnableC0340t(C0320bt.f1863Wk[144], c0319bs.f868Df, c0319bs.f869Dg);
                c0319bs.f848DF.m2143x(0, -1);
                c0319bs.m982bz(514);
                c0319bs.f887Dy = 144;
                c0319bs.f888Dz = 0;
                break;
            case 23:
                c0319bs.f868Df = iArr[0];
                c0319bs.f869Dg = iArr[1];
                c0319bs.f870Dh = iArr[2];
                c0319bs.m982bz(65536);
                break;
            case 24:
                c0319bs.f868Df = iArr[0];
                c0319bs.f869Dg = iArr[1];
                c0319bs.f870Dh = iArr[2];
                c0319bs.m982bz(65536);
                break;
            case 32:
                c0319bs.f868Df = iArr[0];
                c0319bs.f869Dg = iArr[1];
                c0319bs.f884Dv = c0319bs.f868Df;
                c0319bs.f885Dw = c0319bs.f869Dg;
                c0319bs.f870Dh = iArr[2];
                c0319bs.f887Dy = iArr[3];
                c0319bs.f888Dz = iArr[4];
                c0319bs.f843DA = iArr[5];
                for (int i5 = 0; i5 < iArr.length; i5++) {
                    C0320bt.m342C(new StringBuffer("==p_param[").append(i5).append("] : ").append(iArr[i5]).toString());
                }
                if (iArr[6] != -1) {
                    c0319bs.f848DF = new RunnableC0340t(C0320bt.f1863Wk[c0319bs.f887Dy], c0319bs.f868Df, c0319bs.f869Dg);
                    C0320bt.m342C(new StringBuffer("======m_spriteID: ").append(c0319bs.f887Dy).toString());
                    c0319bs.f848DF.m2143x(iArr[6], -1);
                }
                c0319bs.f844DB = c0319bs.f887Dy;
                c0319bs.f845DC = iArr[7];
                c0319bs.f872Dj = iArr[8];
                break;
            case 33:
                c0319bs.f868Df = iArr[0];
                c0319bs.f869Dg = iArr[1];
                c0319bs.f870Dh = iArr[2];
                c0319bs.f887Dy = iArr[3];
                c0319bs.f888Dz = iArr[4];
                c0319bs.f876Dn = iArr[5];
                c0319bs.f877Do = iArr[6];
                if (iArr.length > 7) {
                    c0319bs.f848DF = new RunnableC0340t(C0320bt.f1863Wk[c0319bs.f887Dy], c0319bs.f868Df, c0319bs.f869Dg);
                    c0319bs.f848DF.m2143x(iArr[7], iArr[8]);
                } else {
                    c0319bs.m982bz(16777216);
                }
                c0319bs.f843DA = 0;
                break;
            case 34:
                c0319bs.f870Dh = iArr[0];
                c0319bs.f887Dy = iArr[1];
                c0319bs.f848DF = new RunnableC0340t(C0320bt.f1863Wk[c0319bs.f887Dy], 0, 0);
                c0319bs.f848DF.m2143x(iArr[2], -1);
                c0319bs.f889yM = iArr[3];
                switch (iArr[3]) {
                    case 0:
                        C0319bs[] c0319bsArr = new C0319bs[100];
                        int m922a = m922a(1, iArr[4], c0319bsArr, 100);
                        if (m922a > 0) {
                            int m504p = GLLib.m504p(0, m922a);
                            c0319bs.f868Df = c0319bsArr[m504p].f868Df;
                            c0319bs.f869Dg = c0319bsArr[m504p].f869Dg;
                            c0319bs.f884Dv = c0319bs.f868Df;
                            c0319bs.f885Dw = c0319bs.f869Dg;
                            break;
                        }
                        break;
                    case 1:
                        c0319bs.m953eV();
                        c0319bs.f872Dj = iArr[4];
                        break;
                }
            case 42:
                c0319bs.f868Df = iArr[0];
                c0319bs.f869Dg = iArr[1];
                c0319bs.f870Dh = iArr[2];
                c0319bs.f887Dy = iArr[3];
                c0319bs.f848DF = new RunnableC0340t(C0320bt.f1863Wk[c0319bs.f887Dy], c0319bs.f868Df, c0319bs.f869Dg);
                c0319bs.f884Dv = c0319bs.f868Df;
                c0319bs.f885Dw = c0319bs.f869Dg;
                c0319bs.f872Dj = 150;
                c0319bs.m982bz(33554432);
                c0319bs.m976bq(0);
                break;
            case 47:
                c0319bs.f868Df = iArr[0];
                c0319bs.f869Dg = iArr[1];
                c0319bs.f870Dh = iArr[2];
                c0319bs.f878Dp = 2;
                c0319bs.f879Dq = 2;
                c0319bs.m982bz(512);
                c0319bs.f816CQ = true;
                break;
            case 48:
                c0319bs.f868Df = iArr[0];
                c0319bs.f869Dg = iArr[1];
                c0319bs.f870Dh = iArr[2];
                c0319bs.f887Dy = iArr[3];
                c0319bs.f888Dz = iArr[4];
                c0319bs.f843DA = iArr[5];
                c0319bs.m982bz(16777730);
                c0319bs.f878Dp = 4;
                c0319bs.f879Dq = 4;
                c0319bs.f880Dr = 16;
                break;
            case 49:
                c0319bs.f868Df = iArr[0];
                c0319bs.f869Dg = iArr[1];
                c0319bs.f870Dh = iArr[2];
                c0319bs.f878Dp = 4;
                c0319bs.f879Dq = 4;
                c0319bs.f880Dr = 16;
                c0319bs.m982bz(64);
                c0319bs.m982bz(16777731);
                c0319bs.m978bt(1);
                break;
            case Request.MAXIMUM_BATCH_SIZE:
                c0319bs.f868Df = iArr[0];
                c0319bs.f869Dg = iArr[1];
                c0319bs.f870Dh = iArr[2];
                c0319bs.f882Dt = iArr[3];
                c0319bs.f887Dy = iArr[4];
                c0319bs.f888Dz = iArr[5];
                c0319bs.f878Dp = iArr[6];
                c0319bs.f879Dq = iArr[7];
                c0319bs.f880Dr = C0320bt.m1089aF(c0319bs.f878Dp, c0319bs.f879Dq);
                c0319bs.m982bz(16777730);
                int i6 = iArr[8];
                int i7 = iArr[9];
                int i8 = iArr[10];
                if (i6 == 1) {
                    c0319bs.m982bz(64);
                }
                if (i7 == 1) {
                    c0319bs.m982bz(128);
                }
                if (i8 == 1) {
                    c0319bs.m982bz(1);
                }
                if (c0319bs.f882Dt == 18) {
                    c0319bs.f844DB = 135;
                    c0319bs.f845DC = 0;
                    C0320bt.f1850WX = c0319bs.f868Df;
                    C0320bt.f1851WY = c0319bs.f869Dg;
                    break;
                }
                break;
            case 51:
                c0319bs.f868Df = iArr[0];
                c0319bs.f869Dg = iArr[1];
                c0319bs.f870Dh = iArr[2];
                c0319bs.f887Dy = iArr[4];
                C0271a c0271a = C0320bt.f1863Wk[c0319bs.f887Dy];
                c0319bs.f888Dz = 0;
                c0319bs.f848DF = new RunnableC0340t(c0271a, c0319bs.f868Df, c0319bs.f869Dg);
                c0319bs.f884Dv = c0319bs.f868Df;
                c0319bs.f885Dw = c0319bs.f869Dg;
                c0319bs.f872Dj = iArr[6];
                c0319bs.m944by(0);
                c0319bs.m982bz(33554432);
                break;
            case 52:
                c0319bs.f868Df = iArr[0];
                c0319bs.f869Dg = iArr[1];
                c0319bs.f870Dh = iArr[2];
                c0319bs.f878Dp = 4;
                c0319bs.f879Dq = 4;
                c0319bs.f880Dr = 16;
                c0319bs.f887Dy = iArr[3];
                c0319bs.m982bz(16777763);
                int i9 = iArr[4];
                int i10 = iArr[5];
                if (i9 == 1) {
                    c0319bs.m982bz(64);
                }
                if (i10 == 1) {
                    c0319bs.m982bz(128);
                }
                c0319bs.m979bu(2);
                break;
            case 54:
                c0319bs.f868Df = iArr[0];
                c0319bs.f869Dg = iArr[1];
                c0319bs.f870Dh = iArr[2];
                c0319bs.f878Dp = iArr[3];
                c0319bs.f879Dq = iArr[4];
                c0319bs.f880Dr = 16;
                C0271a c0271a2 = C0320bt.f1863Wk[iArr[5]];
                c0319bs.f843DA = iArr[6];
                if (iArr[7] == 1) {
                    c0319bs.m982bz(32);
                }
                c0319bs.f846DD = iArr[8];
                c0319bs.f887Dy = iArr[5];
                c0319bs.f888Dz = iArr[9];
                c0319bs.f848DF = new RunnableC0340t(c0271a2, c0319bs.f868Df, c0319bs.f869Dg);
                c0319bs.m980bv(0);
                c0319bs.m982bz(33554945);
                int i11 = iArr[10];
                int i12 = iArr[11];
                if (i11 == 1) {
                    c0319bs.m982bz(64);
                }
                if (i12 == 1) {
                    c0319bs.m982bz(128);
                }
                c0319bs.f872Dj = 50;
                break;
        }
        c0319bs.f884Dv = c0319bs.f868Df;
        c0319bs.f885Dw = c0319bs.f869Dg;
        if (c0319bs.m975bB(16777216)) {
            c0319bs.m1021fm();
        }
        m927a(c0319bs, i2);
        return c0319bs;
    }

    private void m926a(C0319bs c0319bs) {
        this.f847DE = c0319bs;
        c0319bs.f847DE = this;
    }

    private static void m927a(C0319bs c0319bs, int i) {
        c0319bs.f866Dd = i;
        c0319bs.f875Dm = c0319bs.m960et();
        C0319bs c0319bs2 = null;
        C0319bs c0319bs3 = f755Bt[i];
        while (c0319bs3 != null && c0319bs.f875Dm > c0319bs3.m960et()) {
            c0319bs2 = c0319bs3;
            c0319bs3 = c0319bs3.f864Db;
        }
        c0319bs.f865Dc = c0319bs2;
        c0319bs.f864Db = c0319bs3;
        if (c0319bs2 == null) {
            f755Bt[i] = c0319bs;
        } else {
            c0319bs2.f864Db = c0319bs;
        }
        if (c0319bs3 != null) {
            c0319bs3.f865Dc = c0319bs;
        }
    }

    private boolean m928a(C0271a c0271a, int i) {
        if (c0271a == null || i < 0) {
            return false;
        }
        int m668p = c0271a.m668p(i) + this.f873Dk;
        int m669q = c0271a.m669q(i) + this.f874Dl;
        return m668p + c0271a.m666n(i) > 0 && m668p < ((((((float) GLLib.f139iH) * 100.0f) / ((float) C0320bt.f1799VY)) > 0.0f ? 1 : (((((float) GLLib.f139iH) * 100.0f) / ((float) C0320bt.f1799VY)) == 0.0f ? 0 : -1)) > 0 ? (int) (((((float) GLLib.f139iH) * 100.0f) / ((float) C0320bt.f1799VY)) + 0.5f) : (((((float) GLLib.f139iH) * 100.0f) / ((float) C0320bt.f1799VY)) > 0.0f ? 1 : (((((float) GLLib.f139iH) * 100.0f) / ((float) C0320bt.f1799VY)) == 0.0f ? 0 : -1)) < 0 ? (int) (((((float) GLLib.f139iH) * 100.0f) / ((float) C0320bt.f1799VY)) - 0.5f) : 0) + 0 && m669q + c0271a.m667o(i) > 0 && m669q < ((((((float) GLLib.f140iI) * 100.0f) / ((float) C0320bt.f1799VY)) > 0.0f ? 1 : (((((float) GLLib.f140iI) * 100.0f) / ((float) C0320bt.f1799VY)) == 0.0f ? 0 : -1)) > 0 ? (int) (((((float) GLLib.f140iI) * 100.0f) / ((float) C0320bt.f1799VY)) + 0.5f) : (((((float) GLLib.f140iI) * 100.0f) / ((float) C0320bt.f1799VY)) > 0.0f ? 1 : (((((float) GLLib.f140iI) * 100.0f) / ((float) C0320bt.f1799VY)) == 0.0f ? 0 : -1)) < 0 ? (int) (((((float) GLLib.f140iI) * 100.0f) / ((float) C0320bt.f1799VY)) - 0.5f) : 0) + 0;
    }

    static void m929aO() {
        f755Bt = new C0319bs[6];
        f765DT = new int[4];
        f766DU = new int[500][];
        f767DV = 0;
        for (int i = 0; i < 500; i++) {
            f766DU[i] = new int[4];
        }
    }

    private void m930ac(int i, int i2) {
        if (i < 0 || i2 < 0) {
            return;
        }
        C0271a c0271a = C0320bt.f1863Wk[0];
        int i3 = C0338r.f2358pd ? c0271a.f436bo[0] & 65535 : c0271a.f438bq[0] & 255;
        C0271a c0271a2 = C0320bt.f1863Wk[0];
        int i4 = C0338r.f2358pd ? c0271a2.f437bp[0] & 65535 : c0271a2.f439br[0] & 255;
        int i5 = i & 32767;
        C0271a c0271a3 = (32768 & i) != 0 ? C0320bt.f987Fq[i5] : C0320bt.f1863Wk[i5];
        if (c0271a3.m670t(i2) > 0) {
            c0271a3.m649a(f765DT, i2, this.f868Df, this.f869Dg, 0);
            f765DT[0] = (f765DT[0] / i3) * i3;
            f765DT[1] = (f765DT[1] / i4) * i4;
            f765DT[2] = (((f765DT[2] + i3) - 1) / i3) * i3;
            f765DT[3] = (((f765DT[3] + i4) - 1) / i4) * i4;
            int i6 = f765DT[0];
            int i7 = f765DT[1];
            int i8 = f765DT[2];
            int i9 = f765DT[3];
            if (f767DV >= 500) {
                f767DV = 0;
            }
            f766DU[f767DV][0] = i6;
            f766DU[f767DV][1] = i7;
            f766DU[f767DV][2] = i8;
            f766DU[f767DV][3] = i9;
            f767DV++;
        }
    }

    private void m931ad(int i, int i2) {
        int i3 = 95;
        this.f857DO = new C0339s();
        this.f857DO.m2074a(96, 96, C0320bt.f1174JW, 14, 10, 10, 8);
        int[] iArr = new int[2];
        C0320bt.m1184c(new int[]{i, i2}, iArr);
        iArr[0] = iArr[0] < 0 ? 0 : iArr[0] > 95 ? 95 : iArr[0];
        iArr[1] = iArr[1] < 0 ? 0 : iArr[1] > 95 ? 95 : iArr[1];
        int[] iArr2 = new int[2];
        C0320bt.m1184c(new int[]{this.f868Df, this.f869Dg}, iArr2);
        iArr2[0] = iArr2[0] < 0 ? 0 : iArr2[0] > 95 ? 95 : iArr2[0];
        if (iArr2[1] < 0) {
            i3 = 0;
        } else if (iArr2[1] <= 95) {
            i3 = iArr2[1];
        }
        iArr2[1] = i3;
        this.f857DO.m2073a(iArr2[0], iArr2[1], 0, iArr[0], iArr[1]);
        int m2077bK = this.f857DO.m2077bK();
        this.f859DQ = GLLib.f199jq;
        this.f858DP = 0;
        if (this.f867De != 42) {
            if (this.f867De == 54) {
                if (m2077bK > 2) {
                    this.f858DP = m2077bK - 1;
                }
                if (this.f858DP == 0) {
                    m980bv(0);
                    return;
                }
                this.f884Dv = i;
                this.f885Dw = i2;
                m980bv(1);
                return;
            }
            return;
        }
        if (m2077bK > 0) {
            this.f858DP = m2077bK - 1;
        }
        if (this.f858DP > 2) {
            this.f858DP = 2;
            int[] iArr3 = new int[2];
            C0320bt.m1245d(new int[]{this.f857DO.m2075av(this.f858DP), this.f857DO.m2076aw(this.f858DP)}, iArr3);
            this.f868Df = iArr3[0];
            this.f869Dg = iArr3[1];
            return;
        }
        if (Math.abs(this.f884Dv - this.f868Df) > 180 || Math.abs(this.f885Dw - this.f869Dg) > 180) {
            this.f868Df += ((this.f884Dv - this.f868Df) * 80) / 100;
            this.f869Dg += ((this.f885Dw - this.f869Dg) * 80) / 100;
        }
        this.f859DQ = 0;
    }

    static int m932b(int i, int i2, int i3, int i4, C0319bs[] c0319bsArr, int i5) {
        int i6;
        int i7 = 0;
        C0319bs c0319bs = f755Bt[1];
        while (c0319bs != null && i7 <= 0) {
            if (c0319bs.f867De == 54 && c0319bs.m975bB(512) && c0319bs.f853DK >= i3 && c0319bs.f853DK <= i4 && c0319bs.f853DK % 2 == 1) {
                i6 = i7 + 1;
                c0319bsArr[i7] = c0319bs;
            } else {
                i6 = i7;
            }
            c0319bs = c0319bs.f864Db;
            i7 = i6;
        }
        return i7;
    }

    static int m933b(int i, int i2, int i3, C0319bs[] c0319bsArr, int i4) {
        int i5 = 0;
        for (C0319bs c0319bs = f755Bt[1]; c0319bs != null && i5 <= 0; c0319bs = c0319bs.f864Db) {
            if (c0319bs.f867De == 48 && c0319bs.m975bB(512) && (i3 == -1 || c0319bs.f882Dt == i3)) {
                c0319bsArr[i5] = c0319bs;
                i5++;
            }
        }
        return i5;
    }

    static void m934bi(int i) {
        C0319bs c0319bs = f755Bt[1];
        C0319bs c0319bs2 = null;
        while (c0319bs != null) {
            C0319bs c0319bs3 = c0319bs.f864Db;
            int m960et = c0319bs.m960et();
            if (m960et != c0319bs.f875Dm) {
                c0319bs.f875Dm = m960et;
                c0319bs.m1005ep();
                c0319bs.f864Db = c0319bs2;
            } else {
                c0319bs = c0319bs2;
            }
            c0319bs2 = c0319bs;
            c0319bs = c0319bs3;
        }
        while (c0319bs2 != null) {
            C0319bs c0319bs4 = c0319bs2.f864Db;
            m927a(c0319bs2, 1);
            c0319bs2 = c0319bs4;
        }
    }

    static void m935bj(int i) {
        C0319bs c0319bs = f755Bt[1];
        while (c0319bs != null) {
            C0319bs c0319bs2 = c0319bs.f864Db;
            c0319bs.f875Dm = 0;
            c0319bs = c0319bs2;
        }
    }

    static int m936bk(int i) {
        int i2 = 0;
        for (C0319bs c0319bs = f755Bt[1]; c0319bs != null; c0319bs = c0319bs.f864Db) {
            if (c0319bs.f867De == 49 && c0319bs.m975bB(512) && (c0319bs.f889yM == 3 || c0319bs.f889yM == 4 || c0319bs.f889yM == 5)) {
                i2++;
            }
        }
        return i2;
    }

    static C0319bs m937bl(int i) {
        return m914S(1, -1);
    }

    static void m938bm(int i) {
        for (C0319bs c0319bs = f755Bt[1]; c0319bs != null; c0319bs = c0319bs.f864Db) {
            int[] iArr = new int[2];
            C0320bt.m1184c(new int[]{c0319bs.f868Df, c0319bs.f869Dg}, iArr);
            if (C0320bt.m1195cK(C0320bt.m1088aE(iArr[0], iArr[1]))) {
                c0319bs.m982bz(512);
            } else {
                c0319bs.m974bA(512);
            }
        }
    }

    static int m939bn(int i) {
        int i2;
        int i3 = 0;
        for (C0319bs c0319bs = f755Bt[3]; c0319bs != null; c0319bs = c0319bs.f864Db) {
            if (c0319bs.f867De == 47 && c0319bs.f802CC == 59 && (i2 = c0319bs.f807CH & 65535) != 110 && i2 != 5 && (i2 < 111 || i2 > 116)) {
                i3 += c0319bs.f807CH >> 16;
            }
        }
        return i3;
    }

    static boolean m940bo(int i) {
        for (C0319bs c0319bs = f755Bt[3]; c0319bs != null; c0319bs = c0319bs.f864Db) {
            if (c0319bs.f867De == 47) {
                return true;
            }
        }
        return false;
    }

    static int m941bp(int i) {
        int i2 = 0;
        for (C0319bs c0319bs = f755Bt[3]; c0319bs != null; c0319bs = c0319bs.f864Db) {
            if (c0319bs.f867De == 47 && c0319bs.f802CC == 37) {
                i2++;
            }
        }
        return i2;
    }

    static void m942br(int i) {
        if (C0320bt.f1799VY != i) {
            C0320bt.f1799VY = i;
            int i2 = GLLib.f139iH >> 1;
            int i3 = GLLib.f140iI >> 1;
            int i4 = (((C0320bt.f1866Wn.f868Df - ((C0320bt.f1799VY * i2) / 100)) + i2) * 100) / C0320bt.f1799VY;
            int i5 = (((C0320bt.f1866Wn.f869Dg - ((C0320bt.f1799VY * i3) / 100)) + i3) * 100) / C0320bt.f1799VY;
            C0320bt.f1866Wn.f868Df = (((i4 + i2) * C0320bt.f1799VY) / 100) - i2;
            C0320bt.f1866Wn.f869Dg = (((i5 + i3) * C0320bt.f1799VY) / 100) - i3;
        }
    }

    static C0319bs m943bx(int i) {
        C0320bt.m1231cu(GLLib.m504p(25, 29));
        if (i == -1) {
            f756CR = -1;
        } else {
            f756CR = 0;
            f757CS = i;
        }
        if (C0320bt.f1863Wk[85] == null) {
            C0320bt.m1133b(0, 85, 15, 0, 24, 0, -1);
            C0320bt.m344E("/9");
            C0320bt.m1156bL(0);
            C0320bt.m460bg();
        }
        if (m908M(1, 21) <= 0) {
            C0319bs m925a = m925a(21, 1, new int[]{((C0320bt.f1866Wn.f868Df + (GLLib.f139iH >> 1)) * 100) / C0320bt.f1799VY, ((C0320bt.f1866Wn.f869Dg + (GLLib.f140iI >> 1)) * 100) / C0320bt.f1799VY, 255});
            m925a.f848DF = new RunnableC0340t(C0320bt.f1863Wk[85], m925a.f868Df, m925a.f869Dg);
            m925a.f848DF.m2143x(0, 1);
            return m925a;
        }
        C0319bs[] c0319bsArr = new C0319bs[1];
        m922a(1, 21, c0319bsArr, 1);
        c0319bsArr[0].f848DF = new RunnableC0340t(C0320bt.f1863Wk[85], c0319bsArr[0].f868Df, c0319bsArr[0].f869Dg);
        c0319bsArr[0].f848DF.m2143x(0, 1);
        return c0319bsArr[0];
    }

    private void m944by(int i) {
        int i2;
        boolean z = true;
        switch (i) {
            case 0:
                i2 = 1;
                z = false;
                break;
            case 1:
                if (this.f884Dv <= this.f868Df) {
                    i2 = 0;
                    break;
                } else {
                    z = false;
                    i2 = 0;
                    break;
                }
            default:
                z = false;
                i2 = 0;
                break;
        }
        this.f889yM = i;
        if (this.f848DF.f2630tz.m636U() > i2) {
            this.f848DF.m2143x(i2, -1);
            if (z) {
                this.f848DF.m2137az(2);
            } else {
                this.f848DF.m2137az(0);
            }
        }
    }

    static int m945c(int i, int i2, int i3) {
        int i4 = 0;
        for (C0319bs c0319bs = f755Bt[1]; c0319bs != null; c0319bs = c0319bs.f864Db) {
            if (c0319bs.f867De == 54 && c0319bs.m975bB(4096) && c0319bs.m975bB(2048)) {
                i4++;
            }
        }
        return i4;
    }

    static int m946c(int i, int i2, int i3, C0319bs[] c0319bsArr, int i4) {
        int i5 = 0;
        for (C0319bs c0319bs = f755Bt[1]; c0319bs != null && i5 < i4; c0319bs = c0319bs.f864Db) {
            if ((i2 == -1 || c0319bs.f867De == i2) && (i3 == -1 || c0319bs.f853DK == i3)) {
                c0319bsArr[i5] = c0319bs;
                i5++;
            }
        }
        return i5;
    }

    static C0319bs m947c(int i, int[] iArr) {
        return m925a(i, 1, iArr);
    }

    static int m948d(int i, int i2, int i3, C0319bs[] c0319bsArr, int i4) {
        int i5;
        int i6 = 0;
        C0319bs c0319bs = f755Bt[1];
        while (c0319bs != null && i6 <= 0) {
            if (c0319bs.f867De == 54 && c0319bs.m975bB(4096) && c0319bs.f853DK == i3) {
                i5 = i6 + 1;
                c0319bsArr[i6] = c0319bs;
            } else {
                i5 = i6;
            }
            c0319bs = c0319bs.f864Db;
            i6 = i5;
        }
        return i6;
    }

    static void m949eA() {
        C0320bt.f1060HL = 2;
        f762CX = -1;
        if (C0320bt.f1863Wk[85] == null) {
            C0320bt.m1133b(0, 85, 15, 0, 24, 0, -1);
            C0320bt.m344E("/9");
            C0320bt.m1156bL(0);
            C0320bt.m460bg();
        }
        C0320bt.m1452h(11, false);
        f764CZ = true;
        if (m908M(1, 24) <= 0) {
            C0319bs m925a = m925a(24, 1, new int[]{((C0320bt.f1866Wn.f868Df + (GLLib.f139iH >> 1)) * 100) / C0320bt.f1799VY, ((C0320bt.f1866Wn.f869Dg + (GLLib.f140iI >> 1)) * 100) / C0320bt.f1799VY, 255});
            m925a.f848DF = new RunnableC0340t(C0320bt.f1863Wk[85], m925a.f868Df, m925a.f869Dg);
            m925a.f848DF.m2143x(0, 1);
        } else {
            C0319bs[] c0319bsArr = new C0319bs[1];
            m922a(1, 24, c0319bsArr, 1);
            c0319bsArr[0].f848DF = new RunnableC0340t(C0320bt.f1863Wk[85], c0319bsArr[0].f868Df, c0319bsArr[0].f869Dg);
            c0319bsArr[0].f848DF.m2143x(0, 1);
            C0319bs c0319bs = c0319bsArr[0];
        }
    }

    static void m950eB() {
        int i = C0320bt.f1829WC == 0 ? C0320bt.f1831WE : C0320bt.f1661Sq;
        for (C0319bs c0319bs = f755Bt[1]; c0319bs != null; c0319bs = c0319bs.f864Db) {
            if (c0319bs.f867De == 50) {
                switch (c0319bs.f882Dt) {
                    case 0:
                        c0319bs.m1021fm();
                        if (i < 2) {
                            c0319bs.m974bA(8);
                            break;
                        } else {
                            c0319bs.m982bz(8);
                            break;
                        }
                    case 1:
                        c0319bs.m1021fm();
                        if (i < 4) {
                            c0319bs.f887Dy = 128;
                            c0319bs.f888Dz = 1;
                            break;
                        } else {
                            c0319bs.f887Dy = 130;
                            c0319bs.f888Dz = 0;
                            break;
                        }
                    case 2:
                        c0319bs.m1021fm();
                        if (i <= 0) {
                            c0319bs.m974bA(8);
                            break;
                        } else {
                            c0319bs.m982bz(8);
                            break;
                        }
                    case 3:
                        c0319bs.m1021fm();
                        if (i < 3) {
                            c0319bs.m974bA(8);
                            break;
                        } else {
                            c0319bs.m982bz(8);
                            break;
                        }
                    case C0217R.styleable.com_facebook_picker_fragment_done_button_text:
                        c0319bs.m1021fm();
                        if (i < 5) {
                            c0319bs.m974bA(8);
                            break;
                        } else {
                            c0319bs.m982bz(8);
                            break;
                        }
                    case C0217R.styleable.com_facebook_picker_fragment_title_bar_background:
                        c0319bs.m1021fm();
                        if (i < 6) {
                            c0319bs.m974bA(8);
                            break;
                        } else {
                            c0319bs.m982bz(8);
                            break;
                        }
                    case C0217R.styleable.com_facebook_picker_fragment_done_button_background:
                        c0319bs.m1021fm();
                        if (i < 7) {
                            c0319bs.m974bA(8);
                            break;
                        } else {
                            c0319bs.m982bz(8);
                            break;
                        }
                    case 7:
                        c0319bs.m1021fm();
                        if (i < 8) {
                            c0319bs.f887Dy = 128;
                            c0319bs.f888Dz = 2;
                            break;
                        } else {
                            c0319bs.f887Dy = 136;
                            c0319bs.f888Dz = 0;
                            break;
                        }
                    case WorkQueue.DEFAULT_MAX_CONCURRENT:
                        c0319bs.m1021fm();
                        if (i < 9) {
                            c0319bs.m974bA(8);
                            break;
                        } else {
                            c0319bs.m982bz(8);
                            break;
                        }
                }
            }
        }
    }

    static void m951eH() {
        for (C0319bs c0319bs = f755Bt[1]; c0319bs != null; c0319bs = c0319bs.f864Db) {
            if (c0319bs.f867De == 49 || c0319bs.f867De == 52) {
                c0319bs.m982bz(1024);
            }
        }
    }

    private void m952eS() {
        if (m975bB(32)) {
            int i = this.f853DK;
            C0320bt.m1074a(false, (C0319bs) null);
            m974bA(32);
            this.f882Dt++;
            C0331k c0331k = C0331k.f1930ea[0];
            this.f823Cg = c0331k.f1933ed[this.f882Dt][23];
            this.f818Cb = c0331k.f1933ed[this.f882Dt][14];
            this.f829Cm = c0331k.f1933ed[this.f882Dt][16];
            this.f819Cc = 0;
            this.f878Dp = c0331k.f1933ed[this.f882Dt][26];
            this.f879Dq = c0331k.f1933ed[this.f882Dt][27];
            this.f820Cd = c0331k.f1933ed[this.f882Dt][7];
            C0271a c0271a = C0320bt.f1863Wk[c0331k.f1933ed[this.f882Dt][30]];
            this.f843DA = c0331k.f1933ed[this.f882Dt][31];
            this.f888Dz = c0331k.f1933ed[this.f882Dt][32];
            this.f833Cq = (short) c0331k.f1933ed[this.f882Dt][28];
            this.f834Cr = (short) c0331k.f1933ed[this.f882Dt][29];
            if (this.f848DF != null && c0271a != null) {
                this.f848DF.m2135a(c0271a);
                this.f848DF.m2143x(0, -1);
            }
            this.f851DI = new RunnableC0340t(C0320bt.f1863Wk[13], this.f873Dk, this.f874Dl - 50);
            this.f851DI.m2143x(1, 1);
            if (C0320bt.f1829WC == 0) {
                C0320bt.m1947s(i, 1, 21);
            }
            this.f853DK = c0331k.f1933ed[this.f882Dt][1];
            this.f854DL = c0331k.f1933ed[this.f882Dt][2];
            if (C0320bt.f1829WC == 0) {
                C0320bt.m1326eT(this.f853DK);
                C0320bt.m1036O(true);
            }
            m995eO();
            m980bv(2);
            if (c0331k.f1933ed[this.f882Dt][18] != 5 && c0331k.f1933ed[this.f882Dt][18] != 110) {
                this.f842Cz = c0331k.f1933ed[this.f882Dt][17];
            }
            if (c0331k.f1933ed[this.f882Dt][21] != 5 && c0331k.f1933ed[this.f882Dt][21] != 110) {
                this.f800CA = c0331k.f1933ed[this.f882Dt][20];
            }
            C0320bt.m1231cu(43);
            short s = c0271a.f444bw[this.f833Cq];
            this.f835Cs = c0271a.m664l(s);
            this.f836Ct = c0271a.m665m(s);
            short s2 = c0271a.f444bw[this.f834Cr];
            this.f837Cu = c0271a.m664l(s2);
            this.f838Cv = c0271a.m665m(s2);
            this.f831Co = false;
        }
    }

    private void m953eV() {
        if ((GLLib.m504p(0, 100) & 1) == 0) {
            this.f868Df = GLLib.m504p(RunnableC0340t.f2587uK[0][5] >> 1, RunnableC0340t.f2587uK[0][5]);
            this.f869Dg = RunnableC0340t.f2587uK[0][6];
        } else {
            this.f868Df = RunnableC0340t.f2587uK[0][5];
            this.f869Dg = GLLib.m504p(RunnableC0340t.f2587uK[0][6] >> 1, RunnableC0340t.f2587uK[0][6]);
        }
        this.f884Dv = 0;
        this.f885Dw = 0;
        this.f801CB = false;
    }

    static void m954el() {
        boolean z;
        boolean z2;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 6) {
                return;
            }
            C0319bs c0319bs = f755Bt[i2];
            while (c0319bs != null) {
                C0319bs c0319bs2 = c0319bs.f864Db;
                if (c0319bs.f848DF != null) {
                    c0319bs.f848DF.m2136aA(GLLib.f146iP);
                }
                switch (c0319bs.f867De) {
                    case -1:
                        c0319bs.m1005ep();
                        break;
                    case 21:
                        c0319bs.m1012fa();
                        break;
                    case 22:
                        if (c0319bs.f889yM != 0) {
                            if (c0319bs.f848DF.m2141bQ()) {
                                c0319bs.f848DF.m2143x(0, -1);
                            }
                            c0319bs.m1006es();
                            break;
                        }
                        break;
                    case 23:
                        if (c0319bs.f848DF == null || !c0319bs.f848DF.m2141bQ() || (f758CT != -1 && f758CT >= f759CU)) {
                            if (c0319bs.f848DF != null && c0319bs.f848DF.m2141bQ() && f758CT >= f759CU) {
                                c0319bs.f848DF = null;
                                c0319bs.f867De = -1;
                                m922a(1, 23, new C0319bs[1], 1);
                                m950eB();
                                C0319bs[] c0319bsArr = new C0319bs[1];
                                m922a(1, 42, c0319bsArr, 1);
                                c0319bsArr[0].m976bq(3);
                                C0320bt.m1231cu(33);
                                m943bx(3);
                                break;
                            }
                        } else {
                            c0319bs.f848DF.m2143x(1, 1);
                            int m666n = c0319bs.f848DF.f2630tz.m666n(0);
                            int m667o = c0319bs.f848DF.f2630tz.m667o(0);
                            c0319bs.f868Df = GLLib.m504p(-m666n, m666n) + f760CV;
                            c0319bs.f869Dg = f761CW + GLLib.m504p(-m667o, m667o);
                            if (f758CT >= 0) {
                                f758CT++;
                                break;
                            }
                        }
                        break;
                    case 24:
                        if (!C0320bt.m1233cw(1) && f764CZ) {
                            c0319bs.f848DF = null;
                            C0320bt.f1060HL = 0;
                            C0320bt.m1818nl();
                            f764CZ = false;
                            C0320bt.m1147bC(42);
                        }
                        if (c0319bs.f848DF == null || !c0319bs.f848DF.m2141bQ() || (f762CX != -1 && f762CX >= f763CY)) {
                            if (c0319bs.f848DF != null && c0319bs.f848DF.m2141bQ()) {
                                int i3 = f762CX;
                                int i4 = f763CY;
                                break;
                            }
                        } else {
                            c0319bs.f848DF.m2143x(0, 1);
                            int m666n2 = c0319bs.f848DF.f2630tz.m666n(0);
                            int m667o2 = c0319bs.f848DF.f2630tz.m667o(0);
                            c0319bs.f868Df = ((GLLib.m504p(m666n2, GLLib.f139iH - m666n2) + C0320bt.f1866Wn.f868Df) * 100) / C0320bt.f1799VY;
                            c0319bs.f869Dg = ((C0320bt.f1866Wn.f869Dg + GLLib.m504p(m667o2, GLLib.f140iI - m667o2)) * 100) / C0320bt.f1799VY;
                            if (C0320bt.f919Ea[C0320bt.f892DZ] == 14) {
                                c0319bs.f873Dk = ((c0319bs.f868Df * C0320bt.f1799VY) / 100) - C0320bt.f1866Wn.f868Df;
                                c0319bs.f874Dl = ((c0319bs.f869Dg * C0320bt.f1799VY) / 100) - C0320bt.f1866Wn.f869Dg;
                            }
                            C0271a c0271a = c0319bs.f848DF.f2630tz;
                            c0319bs.f848DF.f2626tI = GLLib.m504p(0, (c0271a.f459cd & 1073741824) != 0 ? c0271a.f465cj[0] : c0271a.f464ci);
                            if (f762CX >= 0) {
                                f762CX++;
                                break;
                            }
                        }
                        break;
                    case 32:
                        if (c0319bs.f868Df != c0319bs.f884Dv || c0319bs.f869Dg != c0319bs.f885Dw) {
                            c0319bs.m964fh();
                            break;
                        }
                        break;
                    case 33:
                        c0319bs.f868Df = c0319bs.f847DE.f868Df;
                        c0319bs.f869Dg = c0319bs.f847DE.f869Dg;
                        if (c0319bs.f848DF != null && c0319bs.f848DF.m2141bQ()) {
                            c0319bs.f848DF = null;
                            break;
                        }
                        break;
                    case 34:
                        if (c0319bs.f889yM == 1) {
                            c0319bs.m964fh();
                            if (c0319bs.f868Df == c0319bs.f884Dv && c0319bs.f869Dg == c0319bs.f885Dw) {
                                c0319bs.m953eV();
                            }
                        }
                        if (c0319bs.f801CB || !c0319bs.m965fn() || c0319bs.f882Dt != 2) {
                            if (c0319bs.f801CB && !c0319bs.m965fn() && c0319bs.f882Dt == 2) {
                                c0319bs.f801CB = false;
                                break;
                            }
                        } else {
                            C0320bt.m1231cu(21);
                            c0319bs.f801CB = true;
                            break;
                        }
                        break;
                    case 42:
                        switch (c0319bs.f889yM) {
                            case 0:
                                if (c0319bs.f848DF.m2141bQ()) {
                                    c0319bs.m976bq(0);
                                    break;
                                }
                                break;
                            case 1:
                                c0319bs.m964fh();
                                if (c0319bs.f868Df == c0319bs.f884Dv && c0319bs.f869Dg == c0319bs.f885Dw) {
                                    c0319bs.m976bq(0);
                                    break;
                                }
                                break;
                            case 2:
                                int i5 = c0319bs.f848DF.f2619tA;
                                if (c0319bs.f848DF.m2141bQ() || i5 == 2) {
                                    c0319bs.m976bq(0);
                                    C0320bt.f1209KF = 3;
                                    break;
                                }
                                break;
                            case 3:
                                if (c0319bs.f848DF.m2141bQ()) {
                                    c0319bs.m976bq(0);
                                    C0320bt.m1303e(292, 293, 15, 0, 1);
                                    if (C0320bt.f1831WE == 3) {
                                        C0320bt.f1613Ru = 14;
                                    }
                                    C0320bt.f1060HL = 0;
                                    break;
                                }
                                break;
                        }
                    case 47:
                        c0319bs.m1001eW();
                        break;
                    case 49:
                        if (c0319bs.f851DI != null) {
                            c0319bs.f851DI.m2136aA(GLLib.f146iP);
                        }
                        if (c0319bs.f889yM == 3) {
                            long m1881ot = (C0320bt.m1881ot() - c0319bs.f784BQ) / 1000;
                            if (m1881ot >= c0319bs.f785BR / 2 && C0320bt.f1853Wa != 8 && C0320bt.f1853Wa != 45) {
                                c0319bs.m978bt(4);
                            }
                            if (C0320bt.f1871Ws == c0319bs && c0319bs.f785BR != 0) {
                                C0320bt.m1116ak((int) m1881ot, c0319bs.f785BR);
                                byte b2 = c0319bs.f789BV;
                                int i6 = c0319bs.f785BR;
                                c0319bs.f855DM = C0320bt.m1165bU((int) (c0319bs.f785BR - m1881ot));
                            }
                        } else if (c0319bs.f889yM == 4) {
                            long m1881ot2 = (C0320bt.m1881ot() - c0319bs.f784BQ) / 1000;
                            if (m1881ot2 >= c0319bs.f785BR && ((C0320bt.f1853Wa < 46 || C0320bt.f1853Wa > 57) && C0320bt.f1853Wa != 8 && C0320bt.f1853Wa != 45)) {
                                c0319bs.m978bt(5);
                            }
                            if (C0320bt.f1871Ws == c0319bs && c0319bs.f785BR != 0) {
                                C0320bt.m1116ak((int) m1881ot2, c0319bs.f785BR);
                                byte b3 = c0319bs.f789BV;
                                int i7 = c0319bs.f785BR;
                                c0319bs.f855DM = C0320bt.m1165bU((int) (c0319bs.f785BR - m1881ot2));
                            }
                        } else if (C0320bt.f1871Ws == c0319bs) {
                            C0320bt.m1074a(false, (C0319bs) null);
                        }
                        if ((c0319bs.f851DI == null || c0319bs.f851DI.f2630tz != C0320bt.f1863Wk[16]) && c0319bs.f889yM == 5) {
                            c0319bs.f851DI = new RunnableC0340t(C0320bt.f1863Wk[16], c0319bs.f873Dk, c0319bs.f874Dl);
                            c0319bs.f851DI.m2143x(0, -1);
                            c0319bs.f851DI.f2626tI = 0;
                        } else if (c0319bs.f851DI != null && c0319bs.f889yM != 5 && c0319bs.f851DI.f2630tz == C0320bt.f1863Wk[16]) {
                            c0319bs.f851DI = null;
                        }
                        if (c0319bs.f851DI != null && c0319bs.f889yM == 5) {
                            int i8 = c0319bs.m975bB(1024) ? 1 : 0;
                            if (c0319bs.f851DI.f2630tz.m652ac() != i8) {
                                c0319bs.f851DI.f2630tz.m673z(i8);
                                break;
                            }
                        }
                        break;
                    case Request.MAXIMUM_BATCH_SIZE:
                        if (c0319bs.f882Dt != 18) {
                            if ((c0319bs.f882Dt != 12 && c0319bs.f882Dt != 11) || C0320bt.f1829WC != 0 || !c0319bs.m975bB(512)) {
                                if (c0319bs.f882Dt == 15) {
                                    RunnableC0340t runnableC0340t = c0319bs.f848DF;
                                    if (C0320bt.m1793nM()) {
                                        if (c0319bs.f782BO >= 0) {
                                            c0319bs.f782BO -= GLLib.f146iP;
                                            if (c0319bs.f782BO < 0) {
                                                c0319bs.f848DF = new RunnableC0340t(C0320bt.f1863Wk[c0319bs.f887Dy], c0319bs.f873Dk, c0319bs.f874Dl);
                                                c0319bs.f848DF.m2143x(0, 1);
                                            }
                                        } else if (c0319bs.f848DF != null) {
                                            c0319bs.f848DF.m2136aA(GLLib.f146iP);
                                            if (c0319bs.f848DF.m2141bQ()) {
                                                c0319bs.f848DF = null;
                                                c0319bs.f782BO = GLLib.m504p(PlacePickerFragment.DEFAULT_RADIUS_IN_METERS, 4000);
                                            }
                                        }
                                    } else if (C0320bt.f1623SE > 0 || C0320bt.f1627SI > 0) {
                                        if (c0319bs.f782BO >= 0) {
                                            c0319bs.f782BO -= GLLib.f146iP;
                                            if (c0319bs.f782BO < 0) {
                                                c0319bs.f848DF = new RunnableC0340t(C0320bt.f1863Wk[c0319bs.f887Dy], c0319bs.f873Dk, c0319bs.f874Dl);
                                                c0319bs.f848DF.m2143x(0, 1);
                                            }
                                        } else if (c0319bs.f848DF != null) {
                                            c0319bs.f848DF.m2136aA(GLLib.f146iP);
                                            if (c0319bs.f848DF.m2141bQ()) {
                                                c0319bs.f848DF = null;
                                                c0319bs.f782BO = GLLib.m504p(PlacePickerFragment.DEFAULT_RADIUS_IN_METERS, 4000);
                                            }
                                        }
                                    } else if (c0319bs.f848DF != null) {
                                        c0319bs.f848DF = null;
                                    }
                                    if (runnableC0340t != c0319bs.f848DF) {
                                        c0319bs.m1021fm();
                                        break;
                                    }
                                } else if (c0319bs.f882Dt == 9) {
                                    RunnableC0340t runnableC0340t2 = c0319bs.f848DF;
                                    if (C0320bt.f1829WC != 0 || !C0320bt.m1795nO()) {
                                        if (c0319bs.f848DF != null) {
                                            c0319bs.f848DF = null;
                                            c0319bs.m1021fm();
                                        }
                                        if (c0319bs.f783BP) {
                                            c0319bs.m1020fl();
                                            c0319bs.f783BP = false;
                                            break;
                                        }
                                    } else {
                                        if (!c0319bs.f783BP && C0320bt.m1324eR(C0320bt.f1844WR[0]) && C0320bt.m1324eR(C0320bt.f1844WR[1])) {
                                            c0319bs.f783BP = true;
                                            c0319bs.m926a(m925a(33, 1, new int[]{c0319bs.f868Df, c0319bs.f869Dg, 150, 10, 13, -63, -117, 0, 1}));
                                        }
                                        if (c0319bs.f782BO >= 0) {
                                            c0319bs.f782BO -= GLLib.f146iP;
                                            if (c0319bs.f782BO < 0) {
                                                c0319bs.f848DF = new RunnableC0340t(C0320bt.f1863Wk[c0319bs.f887Dy], c0319bs.f873Dk, c0319bs.f874Dl);
                                                c0319bs.f848DF.m2143x(0, 1);
                                                break;
                                            }
                                        } else if (c0319bs.f848DF != null) {
                                            c0319bs.f848DF.m2136aA(GLLib.f146iP);
                                            if (c0319bs.f848DF.m2141bQ()) {
                                                c0319bs.f782BO = GLLib.m504p(10000, 30000);
                                                c0319bs.f848DF = null;
                                                break;
                                            }
                                        }
                                    }
                                } else if (c0319bs.f882Dt == 2) {
                                    if (C0320bt.m1837oB()) {
                                        if (c0319bs.f851DI == null) {
                                            C0271a c0271a2 = C0320bt.f1863Wk[c0319bs.f887Dy];
                                            short s = c0271a2.f444bw[1];
                                            c0319bs.f849DG = c0271a2.m664l(s);
                                            c0319bs.f850DH = c0271a2.m665m(s);
                                            c0319bs.f851DI = new RunnableC0340t(C0320bt.f1863Wk[147], c0319bs.f873Dk, c0319bs.f874Dl);
                                        }
                                        if (c0319bs.f782BO >= 0) {
                                            c0319bs.f782BO -= GLLib.f146iP;
                                            if (c0319bs.f782BO < 0) {
                                                c0319bs.f851DI.m2143x(0, 1);
                                                break;
                                            }
                                        } else {
                                            c0319bs.f851DI.m2136aA(GLLib.f146iP);
                                            if (c0319bs.f851DI.m2141bQ()) {
                                                c0319bs.f782BO = GLLib.m504p(3000, 4000);
                                                break;
                                            }
                                        }
                                    } else if (c0319bs.f851DI != null) {
                                        c0319bs.f851DI = null;
                                        break;
                                    }
                                } else if (c0319bs.f882Dt == 1) {
                                    if (C0320bt.f1829WC == 0) {
                                        C0320bt.m1881ot();
                                        if (C0320bt.m1928pn()) {
                                            if (c0319bs.f851DI == null) {
                                                C0271a c0271a3 = C0320bt.f1863Wk[c0319bs.f887Dy];
                                                short s2 = c0271a3.f444bw[C0320bt.f1831WE < 4 ? (char) 4 : (char) 1];
                                                c0319bs.f849DG = c0271a3.m664l(s2);
                                                c0319bs.f850DH = c0271a3.m665m(s2);
                                                c0319bs.f851DI = new RunnableC0340t(C0320bt.f1863Wk[148], c0319bs.f873Dk, c0319bs.f874Dl);
                                                c0319bs.f851DI.m2143x(0, -1);
                                                break;
                                            } else {
                                                c0319bs.f851DI.m2136aA(GLLib.f146iP);
                                                break;
                                            }
                                        } else if (c0319bs.f851DI != null) {
                                            c0319bs.f851DI = null;
                                            break;
                                        }
                                    }
                                } else if (c0319bs.f882Dt == 14) {
                                    if (!c0319bs.f781BN && C0320bt.m1840oE()) {
                                        c0319bs.f781BN = true;
                                        c0319bs.m982bz(16);
                                        c0319bs.m926a(m925a(33, 1, new int[]{c0319bs.f868Df, c0319bs.f869Dg, 150, 10, 13, -63, -117, 0, 1}));
                                    }
                                    long m1881ot3 = C0320bt.m1881ot() / 1000;
                                    boolean z3 = false;
                                    for (int i9 = 0; !z3 && i9 < C0320bt.f1408Nx; i9++) {
                                        z3 = C0320bt.f1362ND[i9] > 0 && m1881ot3 < C0320bt.f1362ND[i9] + ((long) C0320bt.f1361NC[i9]);
                                    }
                                    if (z3) {
                                        if (c0319bs.f848DF == null) {
                                            c0319bs.f848DF = new RunnableC0340t(C0320bt.f1863Wk[c0319bs.f887Dy], c0319bs.f873Dk, c0319bs.f874Dl);
                                            c0319bs.f848DF.m2143x(1, -1);
                                            C0320bt.m1231cu(36);
                                            break;
                                        } else {
                                            c0319bs.f848DF.m2136aA(GLLib.f146iP);
                                            break;
                                        }
                                    } else if (c0319bs.f848DF != null) {
                                        c0319bs.f848DF = null;
                                        break;
                                    }
                                } else if (c0319bs.f882Dt == 17) {
                                    if (c0319bs.f782BO >= 0) {
                                        c0319bs.f782BO -= GLLib.f146iP;
                                        if (c0319bs.f782BO < 0) {
                                            c0319bs.f848DF = new RunnableC0340t(C0320bt.f1863Wk[c0319bs.f887Dy], c0319bs.f873Dk, c0319bs.f874Dl);
                                            c0319bs.f848DF.m2143x(0, 1);
                                            if (c0319bs.m965fn()) {
                                                C0320bt.m1231cu(29);
                                            }
                                        }
                                    } else if (c0319bs.f848DF != null) {
                                        c0319bs.f848DF.m2136aA(GLLib.f146iP);
                                        if (c0319bs.f848DF.m2141bQ()) {
                                            c0319bs.f848DF = null;
                                            c0319bs.f782BO = GLLib.m504p(10000, 30000);
                                        }
                                    }
                                    if (C0320bt.f1829WC == 0) {
                                        C0320bt.f1723UA = C0320bt.m1881ot();
                                        if (!c0319bs.m975bB(512) || ((c0319bs.f847DE != null && c0319bs.f847DE.f867De != -1) || C0320bt.f1723UA <= C0320bt.f1724UB)) {
                                            if (c0319bs.m975bB(512) && c0319bs.f847DE != null && c0319bs.f847DE.f867De != -1 && C0320bt.f1723UA <= C0320bt.f1724UB) {
                                                c0319bs.m1020fl();
                                                break;
                                            }
                                        } else {
                                            c0319bs.m926a(m925a(33, 1, new int[]{c0319bs.f868Df, c0319bs.f869Dg, 150, 10, 13, -63, -117, 0, 1}));
                                            break;
                                        }
                                    }
                                }
                            } else {
                                long m1881ot4 = (C0320bt.m1881ot() / 1000) - c0319bs.f780BM;
                                if (m1881ot4 < 86400 && C0320bt.f1871Ws == c0319bs) {
                                    C0320bt.m1116ak((int) m1881ot4, 86400);
                                    c0319bs.f855DM = C0320bt.m1165bU((int) (86400 - m1881ot4));
                                }
                                if (!c0319bs.f781BN && m1881ot4 >= 86400) {
                                    c0319bs.f781BN = true;
                                    c0319bs.m982bz(16);
                                    c0319bs.m926a(m925a(33, 1, new int[]{c0319bs.f868Df, c0319bs.f869Dg, 150, 10, 13, -63, -117, 0, 1}));
                                    if (C0320bt.m1382fY()) {
                                        C0320bt.m1074a(false, (C0319bs) null);
                                        break;
                                    }
                                }
                            }
                        }
                        break;
                    case 51:
                        switch (c0319bs.f889yM) {
                            case 0:
                                if (c0319bs.f848DF.m2141bQ()) {
                                    c0319bs.m944by(0);
                                    break;
                                }
                                break;
                            case 1:
                                c0319bs.m964fh();
                                if (c0319bs.f868Df == c0319bs.f884Dv && c0319bs.f869Dg == c0319bs.f885Dw) {
                                    c0319bs.m944by(0);
                                    break;
                                }
                                break;
                        }
                    case 52:
                        if (c0319bs.f889yM == 2) {
                            long m1881ot5 = (C0320bt.m1881ot() - c0319bs.f792BY) / 1000;
                            if (m1881ot5 >= c0319bs.f862DW) {
                                c0319bs.m979bu(3);
                            }
                            if (C0320bt.f1871Ws == c0319bs && c0319bs.f862DW != 0) {
                                C0320bt.m1116ak((int) m1881ot5, c0319bs.f862DW);
                                byte b4 = c0319bs.f791BX;
                                int i10 = c0319bs.f862DW;
                                c0319bs.f855DM = C0320bt.m1165bU((int) (c0319bs.f862DW - m1881ot5));
                                break;
                            }
                        } else if (C0320bt.f1871Ws == c0319bs) {
                            C0320bt.m1074a(false, (C0319bs) null);
                            break;
                        }
                        break;
                    case 54:
                        if (c0319bs.f848DF != null) {
                            if (c0319bs.f851DI != null) {
                                int i11 = c0319bs.f851DI.f2619tA;
                                if (i11 != 0) {
                                    RunnableC0340t runnableC0340t3 = c0319bs.f851DI;
                                    int i12 = c0319bs.f873Dk;
                                    int i13 = c0319bs.f874Dl - 50;
                                    runnableC0340t3.f2627tw = i12;
                                    runnableC0340t3.f2628tx = i13;
                                } else if (c0319bs.f834Cr == 0) {
                                    C0331k c0331k = C0331k.f1930ea[0];
                                    c0319bs.f834Cr = (short) c0331k.f1933ed[c0319bs.f882Dt][29];
                                    C0271a c0271a4 = C0320bt.f1863Wk[c0331k.f1933ed[c0319bs.f882Dt][30]];
                                    short s3 = c0271a4.f444bw[c0319bs.f834Cr];
                                    c0319bs.f837Cu = c0271a4.m664l(s3);
                                    c0319bs.f838Cv = c0271a4.m665m(s3);
                                    c0319bs.f849DG = c0319bs.f837Cu;
                                    c0319bs.f850DH = c0319bs.f838Cv;
                                }
                                RunnableC0340t runnableC0340t4 = c0319bs.f851DI;
                                int i14 = C0320bt.f1799VY;
                                if (C0338r.f2439rG) {
                                    runnableC0340t4.f2625tG = i14;
                                }
                                if (c0319bs.f851DI.m2141bQ()) {
                                    if (i11 == 1 && C0320bt.f1853Wa == 18) {
                                        C0320bt.f1066HR = true;
                                    }
                                    c0319bs.f851DI = null;
                                } else {
                                    c0319bs.f851DI.m2136aA(GLLib.f146iP);
                                }
                            }
                            if ((c0319bs.f851DI == null || c0319bs.f851DI.f2630tz != C0320bt.f1863Wk[16]) && c0319bs.f828Cl) {
                                c0319bs.f851DI = new RunnableC0340t(C0320bt.f1863Wk[16], c0319bs.f873Dk, c0319bs.f874Dl);
                                c0319bs.f851DI.m2143x(0, -1);
                                c0319bs.f851DI.f2626tI = 1;
                            } else if (c0319bs.f851DI != null && !c0319bs.f828Cl && c0319bs.f851DI.f2630tz == C0320bt.f1863Wk[16]) {
                                c0319bs.f851DI = null;
                            }
                            if (c0319bs.m975bB(512)) {
                                if (c0319bs.m965fn()) {
                                    if (!c0319bs.f831Co && C0320bt.f1004GH != null && C0320bt.f1004GH != c0319bs && c0319bs.f868Df > C0320bt.f1850WX + 150 && c0319bs.f868Df < C0320bt.f1850WX + 530 && c0319bs.f869Dg > C0320bt.f1851WY + 340 && c0319bs.f869Dg < C0320bt.f1851WY + 570) {
                                        c0319bs.f831Co = true;
                                        c0319bs.m972aa(C0320bt.f1850WX + 150, C0320bt.f1851WY + 446);
                                    }
                                    if (c0319bs.f831Co && c0319bs.f868Df == c0319bs.f884Dv && c0319bs.f869Dg == c0319bs.f885Dw) {
                                        c0319bs.f831Co = false;
                                    }
                                    C0319bs[] c0319bsArr2 = new C0319bs[10];
                                    for (int i15 = 0; i15 < 10; i15++) {
                                        c0319bsArr2[i15] = null;
                                    }
                                    m946c(1, 50, C0320bt.f1836WJ[10], c0319bsArr2, 10);
                                    for (int i16 = 0; i16 < 10; i16++) {
                                        if (c0319bsArr2[i16] != null && c0319bs.f868Df > c0319bsArr2[i16].f868Df - 100 && c0319bs.f868Df < c0319bsArr2[i16].f868Df + 100 && c0319bs.f869Dg > c0319bsArr2[i16].f869Dg - 100 && c0319bs.f869Dg < c0319bsArr2[i16].f869Dg + 100 && !c0319bs.f832Cp) {
                                            c0319bs.f832Cp = true;
                                            c0319bs.m972aa(c0319bsArr2[i16].f868Df - 150, c0319bsArr2[i16].f869Dg);
                                        }
                                    }
                                    for (int i17 = 0; i17 < 10; i17++) {
                                        c0319bsArr2[i17] = null;
                                    }
                                    if (c0319bs.f832Cp && c0319bs.f868Df == c0319bs.f884Dv && c0319bs.f869Dg == c0319bs.f885Dw) {
                                        c0319bs.f832Cp = false;
                                    }
                                }
                                switch (c0319bs.f889yM) {
                                    case 0:
                                        if (c0319bs.f848DF.m2141bQ()) {
                                            if (C0320bt.f1003GG != 0 && C0320bt.f1003GG != 1 && C0320bt.f1003GG != 3 && ((!C0320bt.m1382fY() || C0320bt.f1871Ws != c0319bs) && c0319bs.m965fn() && !C0320bt.f1884Xd && GLLib.m504p(0, 100) >= 50)) {
                                                C0320bt.f1884Xd = true;
                                                int m504p = GLLib.m504p(-4, 8);
                                                int m504p2 = GLLib.m504p(-4, 8);
                                                int[] iArr = new int[2];
                                                int[] iArr2 = {c0319bs.f868Df, c0319bs.f869Dg};
                                                C0320bt.m1184c(iArr2, iArr);
                                                iArr[0] = m504p + iArr[0];
                                                iArr[1] = m504p2 + iArr[1];
                                                if (C0320bt.f1853Wa != -1 || C0320bt.m1890p(iArr[0], iArr[1], c0319bs.f878Dp << 1, c0319bs.f879Dq << 1)) {
                                                    c0319bs.m980bv(0);
                                                    break;
                                                } else {
                                                    C0320bt.m1245d(iArr, iArr2);
                                                    c0319bs.m931ad(iArr2[0], iArr2[1]);
                                                    break;
                                                }
                                            } else {
                                                c0319bs.m980bv(0);
                                                break;
                                            }
                                        }
                                        break;
                                    case 1:
                                        int i18 = c0319bs.f868Df;
                                        int i19 = c0319bs.f869Dg;
                                        c0319bs.m964fh();
                                        if (!c0319bs.f831Co) {
                                            int[] iArr3 = new int[2];
                                            C0320bt.m1184c(new int[]{c0319bs.f868Df, c0319bs.f869Dg}, iArr3);
                                            if (C0320bt.m1382fY() && C0320bt.f1871Ws == c0319bs) {
                                                c0319bs.f868Df = i18;
                                                c0319bs.f869Dg = i19;
                                                c0319bs.m980bv(0);
                                            }
                                            if (C0320bt.m1087aD(iArr3[0], iArr3[1])) {
                                                if (c0319bs.f868Df == c0319bs.f884Dv && c0319bs.f869Dg == c0319bs.f885Dw) {
                                                    c0319bs.m980bv(0);
                                                    break;
                                                }
                                            } else {
                                                c0319bs.f868Df = i18;
                                                c0319bs.f869Dg = i19;
                                                c0319bs.m980bv(0);
                                                break;
                                            }
                                        }
                                        break;
                                    case 2:
                                        if (!c0319bs.m975bB(4)) {
                                            c0319bs.m981bw(4);
                                        }
                                        if (c0319bs.f848DF.m2141bQ()) {
                                            c0319bs.m980bv(0);
                                            break;
                                        }
                                        break;
                                    case 3:
                                        if (c0319bs.f848DF.m2141bQ()) {
                                            if (!C0320bt.f1052HD && C0320bt.m1385fp() == 19) {
                                                C0320bt.f1052HD = true;
                                                C0320bt.f1066HR = false;
                                                C0320bt.f1065HQ = false;
                                                C0320bt.f1853Wa = 33;
                                            }
                                            c0319bs.m980bv(0);
                                            break;
                                        }
                                        break;
                                    case C0217R.styleable.com_facebook_picker_fragment_title_bar_background:
                                        int[] iArr4 = {0, 0, 14};
                                        m925a(47, 3, iArr4).m971a(c0319bs.f868Df, c0319bs.f869Dg, 37, PlacePickerFragment.DEFAULT_RADIUS_IN_METERS, false, false, 1);
                                        C0331k c0331k2 = C0331k.f1930ea[0];
                                        int i20 = c0331k2.f1933ed[c0319bs.f882Dt][17];
                                        int i21 = c0331k2.f1933ed[c0319bs.f882Dt][18];
                                        int i22 = c0331k2.f1933ed[c0319bs.f882Dt][19];
                                        int i23 = c0331k2.f1933ed[c0319bs.f882Dt][20];
                                        int i24 = c0331k2.f1933ed[c0319bs.f882Dt][21];
                                        int i25 = c0331k2.f1933ed[c0319bs.f882Dt][22];
                                        c0319bs.f820Cd = c0331k2.f1933ed[c0319bs.f882Dt][7];
                                        if (c0319bs.f828Cl) {
                                            if (i20 > 0) {
                                                i20++;
                                            }
                                            if (i23 > 0) {
                                                i23++;
                                            }
                                            c0319bs.f828Cl = false;
                                        }
                                        int i26 = i23;
                                        int i27 = i20;
                                        if (C0320bt.f1829WC == 0 || (C0320bt.m1199cO(5) < C0320bt.m1804nX() && GLLib.m504p(0, 100) < C0320bt.f1877Wy[20])) {
                                            int m504p3 = GLLib.m504p(0, 100);
                                            int i28 = 0;
                                            if (m504p3 < i22) {
                                                c0319bs.f846DD = i21;
                                                int i29 = i27 << 16;
                                                C0319bs m925a = m925a(47, 3, iArr4);
                                                i28 = C0320bt.f1829WC != 0 ? 1 : i29;
                                                m925a.m971a(c0319bs.f868Df, c0319bs.f869Dg, 59, PlacePickerFragment.DEFAULT_RADIUS_IN_METERS, false, true, c0319bs.f846DD | i28);
                                                z = true;
                                            } else {
                                                z = false;
                                            }
                                            if (m504p3 < i25) {
                                                if (C0320bt.f1829WC == 0) {
                                                    c0319bs.f846DD = i24;
                                                    m925a(47, 3, iArr4).m971a(c0319bs.f868Df + 50, c0319bs.f869Dg + 10, 59, PlacePickerFragment.DEFAULT_RADIUS_IN_METERS, false, true, (i26 << 16) | c0319bs.f846DD);
                                                    z2 = true;
                                                } else if (i28 == 0) {
                                                    c0319bs.f846DD = i24;
                                                    m925a(47, 3, iArr4).m971a(c0319bs.f868Df + 50, c0319bs.f869Dg + 10, 59, PlacePickerFragment.DEFAULT_RADIUS_IN_METERS, false, true, c0319bs.f846DD | 1);
                                                    z2 = true;
                                                }
                                                if (c0319bs.m975bB(2048) && c0319bs.f829Cm > 0) {
                                                    m925a(47, 3, iArr4).m971a(c0319bs.f868Df + 65, c0319bs.f869Dg, 36, PlacePickerFragment.DEFAULT_RADIUS_IN_METERS, false, true, c0319bs.f829Cm);
                                                    if (C0320bt.f1885Xe != null) {
                                                        C0320bt.f1885Xe.m872a(115443, new String[]{Integer.toString(C0320bt.m1862oa()), Integer.toString(0), Integer.toString(c0319bs.f829Cm), Integer.toString(116136), Integer.toString(115423), Integer.toString(1), Integer.toString(C0320bt.m1863ob())});
                                                    }
                                                }
                                            }
                                            z2 = z;
                                            if (c0319bs.m975bB(2048)) {
                                                m925a(47, 3, iArr4).m971a(c0319bs.f868Df + 65, c0319bs.f869Dg, 36, PlacePickerFragment.DEFAULT_RADIUS_IN_METERS, false, true, c0319bs.f829Cm);
                                                if (C0320bt.f1885Xe != null) {
                                                }
                                            }
                                        } else {
                                            z2 = false;
                                        }
                                        if (z2) {
                                            C0320bt.m1300e(c0319bs.f853DK, 1, 41, c0319bs.m975bB(2048));
                                        }
                                        c0319bs.m995eO();
                                        c0319bs.m980bv(2);
                                        break;
                                    case 7:
                                        if (c0319bs.f848DF.m2141bQ()) {
                                            c0319bs.m980bv(0);
                                            c0319bs.f828Cl = true;
                                            break;
                                        }
                                        break;
                                }
                                if (c0319bs.m975bB(32)) {
                                    long m1881ot6 = C0320bt.m1881ot();
                                    long j = (m1881ot6 / 1000) - c0319bs.f822Cf;
                                    if (c0319bs.f840Cx && c0319bs.f841Cy > 0) {
                                        c0319bs.f821Ce = (int) (((m1881ot6 - c0319bs.f841Cy) / 1000) + (C0331k.f1930ea[0].f1933ed[c0319bs.f882Dt][13] * 60));
                                    }
                                    if (c0319bs.f821Ce > 0 && C0320bt.f1871Ws == c0319bs) {
                                        C0320bt.m1116ak((int) j, c0319bs.f821Ce);
                                        int i30 = c0319bs.f820Cd;
                                        int i31 = c0319bs.f821Ce;
                                        c0319bs.f855DM = C0320bt.m1165bU((int) (c0319bs.f821Ce - j));
                                    }
                                    if (j >= c0319bs.f821Ce) {
                                        c0319bs.m952eS();
                                    }
                                } else if (!c0319bs.m975bB(4) && !c0319bs.m975bB(16)) {
                                    long m1881ot7 = C0320bt.m1881ot();
                                    if (C0320bt.f1853Wa == 33) {
                                        c0319bs.f793BZ = m1881ot7;
                                    }
                                    long j2 = (m1881ot7 - c0319bs.f793BZ) / 1000;
                                    if (!c0319bs.m975bB(256) && (C0320bt.m1325eS(20) || C0320bt.m1324eR(C0320bt.f1844WR[20]))) {
                                        if (j2 > (c0319bs.f817Ca * 3) / 4 && c0319bs.f793BZ > 0 && !c0319bs.f825Ci) {
                                            c0319bs.f825Ci = true;
                                            if (!c0319bs.f824Ch && GLLib.m504p(0, 100) < 35) {
                                                c0319bs.m981bw(256);
                                                c0319bs.f824Ch = true;
                                            }
                                        } else if (j2 > (c0319bs.f817Ca >> 1) && c0319bs.f793BZ > 0 && !c0319bs.f826Cj) {
                                            c0319bs.f826Cj = true;
                                            if (!c0319bs.f824Ch && GLLib.m504p(0, 100) < 35) {
                                                c0319bs.m981bw(256);
                                                c0319bs.f824Ch = true;
                                            }
                                        } else if (j2 > (c0319bs.f817Ca >> 2) && c0319bs.f793BZ > 0 && !c0319bs.f827Ck) {
                                            c0319bs.f827Ck = true;
                                            if (!c0319bs.f824Ch && GLLib.m504p(0, 100) < 35) {
                                                c0319bs.m981bw(256);
                                                c0319bs.f824Ch = true;
                                            }
                                        }
                                    }
                                    if (j2 >= c0319bs.f817Ca && c0319bs.f793BZ != 0) {
                                        if (C0320bt.f1853Wa == 35) {
                                            C0320bt.f1066HR = true;
                                        }
                                        if (C0320bt.f1853Wa != 34) {
                                            c0319bs.m981bw(16);
                                            C0320bt.m1074a(false, (C0319bs) null);
                                        }
                                    }
                                    if (C0320bt.f1871Ws == c0319bs && c0319bs.f817Ca != 0) {
                                        C0320bt.m1116ak((int) j2, c0319bs.f817Ca);
                                        int i32 = c0319bs.f820Cd;
                                        int i33 = c0319bs.f817Ca;
                                        c0319bs.f855DM = C0320bt.m1165bU((int) (c0319bs.f817Ca - j2));
                                    }
                                }
                                if (!c0319bs.m975bB(4) || (c0319bs.f847DE != null && c0319bs.f847DE.f867De != -1)) {
                                    if (!c0319bs.m975bB(16) || (c0319bs.f847DE != null && c0319bs.f847DE.f867De != -1)) {
                                        if (!c0319bs.m975bB(256) || (c0319bs.f847DE != null && c0319bs.f847DE.f867De != -1)) {
                                            if (!C0320bt.f1033Gk && InterfaceC0276ac.f492vJ && !C0320bt.m1233cw(2)) {
                                                if ((C0320bt.f1004GH == null || C0320bt.f1004GH != c0319bs) && c0319bs.m965fn() && GLLib.m504p(0, 100) < 10) {
                                                    C0320bt.m1232cv(c0319bs.f856DN);
                                                    C0320bt.f1033Gk = true;
                                                    C0320bt.f1037Go = 0;
                                                    break;
                                                }
                                            } else if (!InterfaceC0276ac.f492vJ || !C0320bt.f1033Gk || C0320bt.f1037Go < C0320bt.f999GC) {
                                                if (InterfaceC0276ac.f492vJ && C0320bt.f1033Gk && C0320bt.f1037Go < C0320bt.f999GC) {
                                                    C0320bt.f1037Go++;
                                                    break;
                                                }
                                            } else {
                                                C0320bt.f1033Gk = false;
                                                break;
                                            }
                                        } else {
                                            c0319bs.m981bw(256);
                                            break;
                                        }
                                    } else {
                                        c0319bs.m981bw(16);
                                        break;
                                    }
                                } else {
                                    c0319bs.m981bw(4);
                                    break;
                                }
                            } else if (c0319bs.f848DF.m2141bQ()) {
                                c0319bs.m980bv(0);
                                break;
                            }
                        }
                        break;
                }
                if (c0319bs.f867De != 10 && c0319bs.f867De != 13) {
                    c0319bs.m1006es();
                    if (c0319bs.f848DF != null) {
                        RunnableC0340t runnableC0340t5 = c0319bs.f848DF;
                        int i34 = c0319bs.f873Dk;
                        int i35 = c0319bs.f874Dl;
                        runnableC0340t5.f2627tw = i34;
                        runnableC0340t5.f2628tx = i35;
                    }
                }
                c0319bs = c0319bs2;
            }
            i = i2 + 1;
        }
    }

    static void m955em() {
        int i;
        for (int i2 = 0; i2 < 6; i2++) {
            C0319bs c0319bs = f755Bt[i2];
            boolean z = false;
            while (c0319bs != null) {
                boolean z2 = c0319bs.f867De == 10 ? true : z;
                if (c0319bs.f867De == 10 && C0320bt.f1866Wn.f869Dg < 648) {
                    float f = (648 - C0320bt.f1866Wn.f869Dg) / 648.0f;
                    int i3 = (648.0f - (f * 215.0f) > 0.0f ? (int) ((648.0f - (f * 215.0f)) + 0.5f) : 648.0f - (f * 215.0f) < 0.0f ? (int) ((648.0f - (f * 215.0f)) - 0.5f) : 0) - C0320bt.f1866Wn.f869Dg;
                    C0048ac[][] c0048acArr = RunnableC0340t.f2590uN;
                    GLLib.m412ae(-15682062);
                    RunnableC0340t.m2084a(0, 0, 0, RunnableC0340t.f2587uK[0][5], i3, C0320bt.f1827WA);
                }
                c0319bs = c0319bs.f864Db;
                z = z2;
            }
            if (z) {
                RunnableC0340t.m2089a(GLLib.f134iC, 0, 0, 0);
            }
            for (C0319bs c0319bs2 = f755Bt[i2]; c0319bs2 != null; c0319bs2 = c0319bs2.f864Db) {
                if (!c0319bs2.m959er() && c0319bs2.f844DB >= 0 && c0319bs2.m975bB(8)) {
                    c0319bs2.m917V(c0319bs2.f844DB, c0319bs2.f845DC);
                }
            }
            for (C0319bs c0319bs3 = f755Bt[i2]; c0319bs3 != null; c0319bs3 = c0319bs3.f864Db) {
                if (!c0319bs3.m959er()) {
                    if (c0319bs3.m975bB(8) && (c0319bs3.f867De == 11 || c0319bs3.m965fn())) {
                        int i4 = c0319bs3.f843DA;
                        if (c0319bs3.f848DF != null && c0319bs3.m928a(c0319bs3.f848DF.f2630tz, c0319bs3.f848DF.m2140bN())) {
                            if (c0319bs3.m975bB(65536)) {
                                C0271a c0271a = c0319bs3.f848DF.f2630tz;
                                i = (((c0271a.f459cd & 1073741824) != 0 ? c0271a.f465cj[0] : c0271a.f464ci) >> 1) + i4;
                            } else {
                                i = i4;
                            }
                            c0319bs3.f848DF.f2630tz.m673z(i);
                            RunnableC0340t runnableC0340t = c0319bs3.f848DF;
                            int i5 = c0319bs3.f873Dk;
                            int i6 = c0319bs3.f874Dl;
                            runnableC0340t.f2627tw = i5;
                            runnableC0340t.f2628tx = i6;
                            RunnableC0340t runnableC0340t2 = c0319bs3.f848DF;
                            int i7 = C0320bt.f1799VY;
                            if (C0338r.f2439rG) {
                                runnableC0340t2.f2625tG = i7;
                            }
                            GLLib.m502k(true);
                            c0319bs3.f848DF.m2142bR();
                            GLLib.m502k(false);
                        } else if (c0319bs3.f887Dy >= 0) {
                            c0319bs3.m917V(c0319bs3.f887Dy, c0319bs3.f888Dz);
                        }
                        int i8 = c0319bs3.f867De;
                        if (c0319bs3.f867De == 47) {
                            c0319bs3.m1003eY();
                        }
                    }
                    switch (c0319bs3.f867De) {
                        case 54:
                            if (c0319bs3.m975bB(8)) {
                                int i9 = c0319bs3.f848DF.f2619tA;
                                if ((i9 == 1 || i9 == 6 || i9 == 2 || i9 == 7) && C0320bt.f987Fq[1] != null) {
                                    int i10 = c0319bs3.f873Dk + c0319bs3.f835Cs;
                                    int i11 = c0319bs3.f874Dl + c0319bs3.f836Ct;
                                    if (C0320bt.f1799VY == 100) {
                                        C0320bt.f987Fq[1].m642a(GLLib.f134iC, 34, i10, i11, 0);
                                    } else {
                                        GLLib.m502k(true);
                                        C0320bt.f987Fq[1].m655b(GLLib.f134iC, 34, i10, i11, 0, C0320bt.f1799VY);
                                        GLLib.m502k(false);
                                    }
                                }
                                if (c0319bs3.m975bB(2048)) {
                                    int i12 = c0319bs3.f873Dk + 5;
                                    int i13 = c0319bs3.f874Dl - 80;
                                    if (C0320bt.f1799VY == 100) {
                                        C0320bt.f987Fq[1].m642a(GLLib.f134iC, 64, i12, i13, 0);
                                        break;
                                    } else {
                                        GLLib.m502k(true);
                                        C0320bt.f987Fq[1].m655b(GLLib.f134iC, 64, i12, i13, 0, C0320bt.f1799VY);
                                        GLLib.m502k(false);
                                        break;
                                    }
                                }
                            }
                            break;
                    }
                    if (c0319bs3.f852DJ && C0320bt.f1004GH == c0319bs3 && c0319bs3.m918W(14, c0319bs3.f880Dr) && C0320bt.m1246d(c0319bs3)) {
                        if (C0320bt.f1799VY == 100) {
                            C0320bt.f1863Wk[14].m642a(GLLib.f134iC, c0319bs3.f880Dr, c0319bs3.f873Dk, c0319bs3.f874Dl, 0);
                        } else {
                            GLLib.m502k(true);
                            C0320bt.f1863Wk[14].m655b(GLLib.f134iC, c0319bs3.f880Dr, c0319bs3.f873Dk, c0319bs3.f874Dl, 0, C0320bt.f1799VY);
                            GLLib.m502k(false);
                        }
                    }
                }
            }
            for (C0319bs c0319bs4 = f755Bt[i2]; c0319bs4 != null; c0319bs4 = c0319bs4.f864Db) {
                if (c0319bs4.f851DI != null) {
                    RunnableC0340t runnableC0340t3 = c0319bs4.f851DI;
                    int i14 = c0319bs4.f873Dk + c0319bs4.f849DG;
                    int i15 = c0319bs4.f874Dl + c0319bs4.f850DH;
                    runnableC0340t3.f2627tw = i14;
                    runnableC0340t3.f2628tx = i15;
                    RunnableC0340t runnableC0340t4 = c0319bs4.f851DI;
                    int i16 = C0320bt.f1799VY;
                    if (C0338r.f2439rG) {
                        runnableC0340t4.f2625tG = i16;
                    }
                    GLLib.m502k(true);
                    c0319bs4.f851DI.m2142bR();
                    GLLib.m502k(false);
                }
            }
        }
        C0320bt.f1827WA = false;
        C0320bt.f1828WB = false;
        f767DV = 0;
    }

    static void m956en() {
        for (int i = 0; i < 6; i++) {
            while (f755Bt[i] != null) {
                f755Bt[i].m1005ep();
            }
        }
    }

    static void m957eo() {
        for (C0319bs c0319bs = f755Bt[3]; c0319bs != null; c0319bs = c0319bs.f864Db) {
            if (c0319bs.f867De == 47) {
                if (c0319bs != null && c0319bs.f802CC == 37) {
                    C0320bt.m1275dc(c0319bs.f807CH);
                } else if (c0319bs.f802CC == 36) {
                    C0320bt.m1209cY(c0319bs.f807CH);
                } else if (c0319bs.f802CC == 6) {
                    C0320bt.m1210cZ(c0319bs.f807CH);
                } else if (c0319bs.f802CC == 59) {
                    int i = c0319bs.f807CH & 65535;
                    int i2 = c0319bs.f807CH >> 16;
                    if (i == 110) {
                        C0320bt.m1274db(i2);
                    } else if (i == 5) {
                        C0320bt.m1273da(i2);
                    } else if ((i < 111 || i > 116) && i > 0 && i <= 26) {
                        C0320bt.m1670l(0, i, i2);
                    }
                }
            }
        }
    }

    static C0319bs m958eq() {
        C0319bs c0319bs;
        C0319bs c0319bs2;
        C0319bs c0319bs3;
        C0319bs c0319bs4 = null;
        if (f755Bt != null) {
            c0319bs = null;
            c0319bs2 = null;
            c0319bs3 = null;
            for (C0319bs c0319bs5 = f755Bt[1]; c0319bs5 != null; c0319bs5 = c0319bs5.f864Db) {
                if (c0319bs5.m975bB(512) && (c0319bs5.m963fe() || c0319bs5.m962fd())) {
                    if (c0319bs5.f867De == 54) {
                        if (c0319bs5.m975bB(4) || c0319bs5.m975bB(16) || c0319bs5.m975bB(256)) {
                            return c0319bs5;
                        }
                        c0319bs3 = c0319bs5;
                    } else if (c0319bs5.f867De != 49 && c0319bs5.f867De != 52) {
                        c0319bs4 = c0319bs5;
                    } else if (c0319bs == null) {
                        boolean z = c0319bs5.f867De == 49 && c0319bs5.f889yM == 5;
                        boolean z2 = c0319bs5.f867De == 52 && c0319bs5.f889yM == 3;
                        if (z || z2) {
                            c0319bs = c0319bs5;
                        } else {
                            c0319bs2 = c0319bs5;
                        }
                    }
                }
            }
        } else {
            c0319bs = null;
            c0319bs2 = null;
            c0319bs3 = null;
        }
        if (C0320bt.f1003GG != -1 && C0320bt.f1004GH != null) {
            if (C0320bt.f1004GH == c0319bs) {
                return c0319bs;
            }
            if (C0320bt.f1004GH == c0319bs3) {
                return c0319bs3;
            }
            if (C0320bt.f1004GH == c0319bs2) {
                return c0319bs2;
            }
            if (C0320bt.f1004GH == c0319bs4) {
                return c0319bs4;
            }
        }
        return c0319bs == null ? c0319bs3 != null ? c0319bs3 : c0319bs2 != null ? c0319bs2 : c0319bs4 : c0319bs;
    }

    private boolean m959er() {
        return C0320bt.f1799VY == 100 ? (this.f873Dk < -144 || this.f873Dk > GLLib.f139iH + 144 || this.f874Dl < -288 || this.f874Dl > GLLib.f140iI + 288) && this.f871Di == -1 : (this.f873Dk < -36 || this.f873Dk > (GLLib.f139iH << 1) + 36 || this.f874Dl < -36 || this.f874Dl > (GLLib.f140iI << 1) + 36) && this.f871Di == -1;
    }

    private int m960et() {
        return (this.f870Dh << 20) + this.f869Dg;
    }

    static void m961ez() {
        C0320bt.f1060HL = 1;
        C0319bs[] c0319bsArr = new C0319bs[1];
        m921a(1, 50, 18, c0319bsArr, 1);
        if (c0319bsArr[0] != null) {
            f760CV = c0319bsArr[0].f868Df;
            f761CW = c0319bsArr[0].f869Dg;
        }
        C0320bt.m1231cu(30);
        f758CT = 0;
        f759CU = 4;
        if (m908M(1, 23) <= 0) {
            C0319bs m925a = m925a(23, 1, new int[]{(f760CV * 100) / C0320bt.f1799VY, (f761CW * 100) / C0320bt.f1799VY, 255});
            m925a.f848DF = new RunnableC0340t(C0320bt.f1863Wk[13], m925a.f868Df, m925a.f869Dg);
            m925a.f848DF.m2143x(1, 1);
        } else {
            C0319bs[] c0319bsArr2 = new C0319bs[1];
            m922a(1, 23, c0319bsArr2, 1);
            c0319bsArr2[0].f848DF = new RunnableC0340t(C0320bt.f1863Wk[13], c0319bsArr2[0].f868Df, c0319bsArr2[0].f869Dg);
            c0319bsArr2[0].f848DF.m2143x(1, 1);
            C0319bs c0319bs = c0319bsArr2[0];
        }
    }

    private boolean m962fd() {
        int[] iArr = new int[2];
        int[] iArr2 = {this.f868Df, this.f869Dg};
        C0320bt.m1184c(iArr2, iArr);
        iArr[0] = iArr[0] - (this.f878Dp >> 1);
        iArr[1] = iArr[1] - (this.f879Dq >> 1);
        int[] iArr3 = {C0320bt.f283lh, C0320bt.f284li};
        C0320bt.m1076a(iArr3, iArr2);
        C0320bt.m1184c(iArr2, iArr3);
        return iArr3[0] >= iArr[0] && iArr3[0] < iArr[0] + this.f878Dp && iArr3[1] >= iArr[1] && iArr3[1] < iArr[1] + this.f879Dq;
    }

    private boolean m963fe() {
        if (this.f887Dy != -1 && this.f888Dz != -1 && (this.f887Dy & (-65536)) == 0) {
            if (((this.f887Dy & 32768) != 0 ? C0320bt.f987Fq[this.f887Dy & 32767].m670t(this.f888Dz) : C0320bt.f1863Wk[this.f887Dy].m670t(this.f888Dz)) > 0) {
                int[] iArr = new int[4];
                int[] iArr2 = new int[2];
                C0320bt.m1076a(new int[]{C0320bt.f283lh, C0320bt.f284li}, iArr2);
                if ((this.f887Dy & 32768) != 0) {
                    C0320bt.f987Fq[this.f887Dy & 32767].m641a(this.f888Dz, 0, iArr, 0);
                } else {
                    C0320bt.f1863Wk[this.f887Dy].m641a(this.f888Dz, 0, iArr, 0);
                }
                int i = this.f868Df + iArr[0];
                int i2 = this.f869Dg + iArr[1];
                return iArr2[0] + 20 >= i && iArr2[0] + (-20) <= iArr[2] + i && iArr2[1] + 20 >= i2 && iArr2[1] + (-20) <= iArr[3] + i2;
            }
        }
        return false;
    }

    private void m964fh() {
        int[] iArr = {this.f884Dv, this.f885Dw};
        int[] iArr2 = new int[2];
        int[] iArr3 = new int[2];
        if (this.f857DO != null && this.f858DP > 0) {
            int[] iArr4 = new int[3];
            int[] iArr5 = new int[3];
            for (int i = 0; i < 3; i++) {
                iArr2[0] = this.f857DO.m2075av(i);
                iArr2[1] = this.f857DO.m2076aw(i);
                C0320bt.m1245d(iArr2, iArr3);
                iArr4[i] = iArr3[0];
                iArr5[i] = iArr3[1];
            }
            if (this.f867De == 42) {
                this.f859DQ -= InterfaceC0275ab.f491vI;
            } else if (this.f867De == 54) {
                this.f859DQ -= 5;
            }
            if (this.f859DQ <= 0) {
                this.f858DP = 0;
            } else {
                GLLib.m381a(iArr4[0], iArr5[0], iArr4[1], iArr5[1], iArr4[2], iArr5[2], this.f859DQ);
                iArr[0] = GLLib.f202jt;
                iArr[1] = GLLib.f203ju;
                if (this.f867De == 42) {
                    m1007eu();
                }
            }
        }
        int i2 = iArr[0] - this.f868Df;
        int i3 = iArr[1] - this.f869Dg;
        int m360X = GLLib.m360X((i2 * i2) + (i3 * i3));
        if (m360X == 0) {
            this.f868Df = iArr[0];
            this.f869Dg = iArr[1];
            if (this.f859DQ <= 0) {
                this.f868Df = this.f884Dv;
                this.f869Dg = this.f885Dw;
                return;
            }
            return;
        }
        int i4 = ((this.f872Dj * GLLib.f146iP) << 8) / PlacePickerFragment.DEFAULT_RADIUS_IN_METERS;
        int i5 = ((i2 * i4) / m360X) >> 8;
        int i6 = ((i4 * i3) / m360X) >> 8;
        int i7 = i5 < 0 ? -i5 : i5;
        if (i2 < 0) {
            i2 = -i2;
        }
        if (i7 >= i2 || i5 == 0) {
            this.f868Df = iArr[0];
        } else {
            this.f868Df += i5;
        }
        int i8 = i6 < 0 ? -i6 : i6;
        if (i3 < 0) {
            i3 = -i3;
        }
        if (i8 >= i3 || i6 == 0) {
            this.f869Dg = iArr[1];
        } else {
            this.f869Dg += i6;
        }
    }

    private boolean m965fn() {
        int[] iArr = new int[2];
        C0320bt.m1144b(new int[]{this.f868Df, this.f869Dg}, iArr);
        return iArr[0] > -350 && iArr[0] < GLLib.f139iH + 350 && iArr[1] >= -350 && iArr[1] < GLLib.f140iI + 350;
    }

    static int m966l(int i, int i2, int i3, int i4) {
        int i5 = 0;
        for (C0319bs c0319bs = f755Bt[1]; c0319bs != null; c0319bs = c0319bs.f864Db) {
            if (c0319bs.f867De == 54 && c0319bs.m975bB(512) && c0319bs.f882Dt % 2 == 1 && c0319bs.f882Dt >= i3 && c0319bs.f882Dt <= i4) {
                i5++;
            }
        }
        return i5;
    }

    private void m967s(boolean z) {
        int[] iArr = {0, 0, 14};
        m925a(47, 3, iArr).m971a(this.f868Df, this.f869Dg, 37, PlacePickerFragment.DEFAULT_RADIUS_IN_METERS, false, false, this.f788BU);
        if (C0320bt.f1829WC == 0 || (C0320bt.m1199cO(5) < C0320bt.m1804nX() && GLLib.m504p(0, 100) < C0320bt.f1877Wy[20])) {
            C0319bs m925a = m925a(47, 3, iArr);
            int i = this.f846DD;
            if (this.f846DD == -1) {
                return;
            }
            int i2 = z ? 3 : 1;
            if (m975bB(1024)) {
                i2++;
            }
            if (z && C0320bt.f1853Wa == -1) {
                C0320bt.m1615k(this.f853DK, i2, 14);
            }
            if (C0320bt.f1853Wa == -1) {
                C0320bt.m1947s(this.f853DK, i2, 14);
            }
            m925a.m971a(this.f868Df, this.f869Dg, 59, PlacePickerFragment.DEFAULT_RADIUS_IN_METERS, false, true, i | (i2 << 16));
        }
        if (C0320bt.m1863ob() < C0320bt.f1530QP[0] || GLLib.m504p(0, 100) >= C0320bt.f1877Wy[10]) {
            return;
        }
        m925a(47, 3, iArr).m971a(this.f868Df - 60, this.f869Dg, 60, 2000, false, false, 1);
    }

    final void m968X(int i, int i2) {
        this.f884Dv = i;
        this.f885Dw = i2;
        m976bq(1);
        m931ad(this.f884Dv, this.f885Dw);
    }

    final void m969Y(int i, int i2) {
        this.f884Dv = i;
        this.f885Dw = i2;
        if (Math.abs(this.f884Dv - this.f868Df) > 180 || Math.abs(this.f885Dw - this.f869Dg) > 180) {
            this.f868Df += ((this.f884Dv - this.f868Df) * 80) / 100;
            this.f869Dg += ((this.f885Dw - this.f869Dg) * 80) / 100;
        }
        m976bq(1);
    }

    final void m970Z(int i, int i2) {
        this.f868Df = i;
        this.f869Dg = i2;
        RunnableC0340t.m2082a(0, this.f868Df, this.f869Dg);
    }

    final void m971a(int i, int i2, int i3, int i4, boolean z, boolean z2, int i5) {
        this.f802CC = i3;
        this.f805CF = i;
        this.f806CG = i2;
        this.f873Dk = this.f805CF;
        this.f874Dl = this.f806CG;
        this.f804CE = i4;
        this.f803CD = 0;
        this.f808CI = z;
        this.f809CJ = z2;
        this.f807CH = i5;
        if (i3 == 59) {
            int i6 = this.f807CH & 65535;
            C0320bt.m342C(new StringBuffer("itemIndex : ").append(i6).toString());
            this.f887Dy = C0320bt.f1840WN[i6] | 32768;
            this.f888Dz = C0320bt.f1841WO[i6];
        } else if (i3 == 60) {
            int m1858oW = C0320bt.m1858oW();
            int i7 = (m1858oW / 4) + 108;
            this.f887Dy = i7 | 32768;
            this.f888Dz = m1858oW % 4;
            C0320bt.m1133b(1, i7, 1, 0, 24, 0, -1);
            C0320bt.m344E("/11");
            C0320bt.m1156bL(1);
            C0320bt.m460bg();
        } else {
            this.f887Dy = 32769;
            this.f888Dz = this.f802CC;
        }
        this.f813CN = 0;
        this.f814CO = 0;
        this.f812CM = 4;
        this.f815CP = 1;
    }

    final void m972aa(int i, int i2) {
        this.f884Dv = i;
        this.f885Dw = i2;
        this.f857DO = null;
        this.f858DP = 0;
        this.f859DQ = 0;
        m980bv(1);
    }

    final void m973ab(int i, int i2) {
        this.f884Dv = i;
        this.f885Dw = i2;
        m944by(1);
    }

    final void m974bA(int i) {
        if ((i & 8) != 0) {
            m1021fm();
        }
        this.f886Dx &= i ^ (-1);
    }

    final boolean m975bB(int i) {
        return (this.f886Dx & i) == i;
    }

    final void m976bq(int i) {
        int i2;
        int i3;
        int i4 = 3;
        boolean z = true;
        switch (i) {
            case 0:
                i4 = -1;
                i2 = 2;
                break;
            case 1:
                if (this.f884Dv > this.f868Df) {
                    this.f860DR = false;
                    if (this.f885Dw > this.f869Dg) {
                        this.f861DS = false;
                        i2 = 0;
                    } else {
                        this.f861DS = true;
                        i2 = 1;
                    }
                } else {
                    this.f860DR = true;
                    if (this.f885Dw > this.f869Dg) {
                        this.f861DS = false;
                        i2 = 0;
                    } else {
                        this.f861DS = true;
                        i2 = 1;
                    }
                }
                C0320bt.m1231cu(53);
                i4 = -1;
                break;
            case 2:
                switch (C0320bt.f1204KA[C0320bt.f1207KD]) {
                    case 0:
                        i3 = 46;
                        i4 = 4;
                        break;
                    case 1:
                        i3 = 39;
                        i4 = 4;
                        break;
                    case 2:
                        if (C0320bt.f1206KC[C0320bt.f1207KD] != null && (C0320bt.f1206KC[C0320bt.f1207KD].f882Dt == 0 || C0320bt.f1206KC[C0320bt.f1207KD].f882Dt == 51 || C0320bt.f1206KC[C0320bt.f1207KD].f882Dt == 52)) {
                            i3 = 22;
                            break;
                        } else if (C0320bt.f1206KC[C0320bt.f1207KD] != null && (C0320bt.f1206KC[C0320bt.f1207KD].f882Dt == 1 || C0320bt.f1206KC[C0320bt.f1207KD].f882Dt == 53 || C0320bt.f1206KC[C0320bt.f1207KD].f882Dt == 54)) {
                            i3 = 40;
                            break;
                        } else {
                            i3 = 40;
                            break;
                        }
                        break;
                    case 3:
                        i4 = 6;
                        i3 = 35;
                        break;
                    case C0217R.styleable.com_facebook_picker_fragment_done_button_text:
                        i3 = 31;
                        this.f861DS = false;
                        this.f860DR = false;
                        i4 = 4;
                        break;
                    case C0217R.styleable.com_facebook_picker_fragment_title_bar_background:
                        i3 = 31;
                        break;
                    case C0217R.styleable.com_facebook_picker_fragment_done_button_background:
                        i3 = 22;
                        break;
                    default:
                        i3 = 53;
                        i4 = 2;
                        break;
                }
                C0320bt.m1231cu(i3);
                i2 = i4;
                i4 = 1;
                break;
            case 3:
                i2 = 7;
                break;
            default:
                i4 = -1;
                i2 = 0;
                break;
        }
        this.f889yM = i;
        if ((this.f860DR || this.f861DS) && (!this.f860DR || !this.f861DS)) {
            z = false;
        }
        this.f848DF.m2143x(i2, i4);
        if (z) {
            this.f848DF.m2137az(2);
        } else {
            this.f848DF.m2137az(0);
        }
    }

    final void m977bs(int i) {
        if (this.f790BW) {
            return;
        }
        this.f790BW = true;
        this.f882Dt = (char) i;
        this.f846DD = C0320bt.f1017GU;
        this.f785BR = C0320bt.f1018GV;
        this.f788BU = C0320bt.f1077Hc;
        this.f786BS = C0320bt.f1019GW;
        this.f787BT = C0320bt.f1020GX;
        this.f882Dt = C0320bt.f1016GT;
        this.f853DK = C0320bt.f1021GY;
        this.f854DL = C0320bt.f1022GZ;
        this.f887Dy = C0320bt.f1075Ha;
        this.f789BV = C0320bt.f1078Hd;
    }

    final void m978bt(int i) {
        m1021fm();
        this.f889yM = i;
        switch (this.f889yM) {
            case 1:
                this.f887Dy = -1;
                this.f888Dz = -1;
                this.f882Dt = 0;
                this.f790BW = false;
                this.f870Dh = 11;
                break;
            case 3:
                this.f888Dz = 0;
                this.f784BQ = C0320bt.m1881ot();
                this.f870Dh = 11;
                m1020fl();
                break;
            case C0217R.styleable.com_facebook_picker_fragment_done_button_text:
                this.f888Dz = 1;
                this.f870Dh = 12;
                break;
            case C0217R.styleable.com_facebook_picker_fragment_title_bar_background:
                this.f888Dz = 2;
                this.f870Dh = 12;
                break;
            case WorkQueue.DEFAULT_MAX_CONCURRENT:
                this.f870Dh = 11;
                break;
        }
        this.f844DB = 6;
        this.f845DC = 0;
    }

    final void m979bu(int i) {
        m1021fm();
        this.f889yM = i;
        switch (this.f889yM) {
            case 2:
                this.f792BY = C0320bt.m1881ot();
                this.f888Dz = 0;
                break;
            case 3:
                m974bA(32);
                this.f888Dz = 1;
                break;
        }
    }

    final void m980bv(int i) {
        int i2;
        boolean z;
        int i3;
        m982bz(1);
        switch (i) {
            case 0:
                int i4 = m975bB(32) ? 5 : 0;
                r1 = GLLib.m504p(1, 5);
                i2 = i4;
                z = false;
                break;
            case 1:
                r1 = m975bB(32) ? 5 : 0;
                if (this.f884Dv > this.f868Df) {
                    if (this.f885Dw > this.f869Dg) {
                        i3 = 3;
                        z = true;
                    } else {
                        i3 = 4;
                        z = false;
                    }
                } else if (this.f885Dw > this.f869Dg) {
                    i3 = 3;
                    z = false;
                } else {
                    i3 = 4;
                    z = true;
                }
                i2 = r1 + i3;
                r1 = -1;
                break;
            case 2:
            case C0217R.styleable.com_facebook_picker_fragment_title_bar_background:
            case C0217R.styleable.com_facebook_picker_fragment_done_button_background:
            default:
                z = false;
                r1 = -1;
                i2 = 0;
                break;
            case 3:
                m974bA(1);
                i2 = m975bB(32) ? 6 : 1;
                r1 = 3;
                z = false;
                break;
            case C0217R.styleable.com_facebook_picker_fragment_done_button_text:
                if (!m975bB(32)) {
                    z = false;
                    r1 = -1;
                    i2 = 0;
                    break;
                } else {
                    z = false;
                    i2 = 5;
                    r1 = -1;
                    break;
                }
            case 7:
                m974bA(1);
                i2 = m975bB(32) ? 5 : 0;
                z = false;
                break;
        }
        boolean z2 = this.f848DF.f2619tA == i2;
        this.f889yM = i;
        RunnableC0340t runnableC0340t = this.f848DF;
        if (z2) {
            runnableC0340t.m2143x(-1, 1);
        }
        runnableC0340t.m2143x(i2, r1);
        if (z) {
            this.f848DF.m2137az(2);
        } else {
            this.f848DF.m2137az(0);
        }
    }

    final void m981bw(int i) {
        if (C0320bt.f1829WC == 0 || i != 4) {
            m1020fl();
            m982bz(i);
            m926a(m925a(33, 1, new int[]{this.f868Df, this.f869Dg, 150, 10, i == 4 ? 14 : i == 16 ? 13 : i == 256 ? 12 : 0, -63, -117, 0, 1}));
        }
    }

    final void m982bz(int i) {
        if ((i & 8) != 0) {
            m1021fm();
        }
        this.f886Dx |= i;
    }

    final void m983d(int i, int i2, int i3) {
        this.f884Dv = i;
        this.f885Dw = i2;
        this.f889yM = 1;
        this.f779BL = i3;
    }

    final boolean m984eC() {
        if (C0320bt.f1853Wa == 1 || C0320bt.f1853Wa == 2 || C0320bt.f1853Wa == 3 || (C0320bt.f1853Wa >= 32 && C0320bt.f1853Wa <= 36)) {
            return false;
        }
        if (this.f889yM == 5) {
            C0320bt.m1235cy(1);
        }
        return m985eD();
    }

    final boolean m985eD() {
        if (C0320bt.f1853Wa == 4 || C0320bt.f1853Wa == 7 || C0320bt.f1853Wa == 44) {
            C0320bt.f1066HR = true;
        }
        if (this.f889yM != 1 || C0320bt.f1013GQ != 0) {
            if (this.f889yM != 5 || C0320bt.f1013GQ != 1) {
                return false;
            }
            if (((C0320bt.f1210KG & 2) == 2) && !C0320bt.f1177JZ) {
                if ((C0320bt.f1829WC != 0 || C0320bt.m1199cO(5) + m939bn(3) + 1 <= C0320bt.m1804nX()) && (C0320bt.f1829WC != 0 || C0320bt.m1199cO(5) + C0320bt.f1176JY + 1 <= C0320bt.m1804nX())) {
                    C0320bt.m1056a(1, this);
                    if (C0320bt.f1853Wa == 5) {
                        C0320bt.f1073HY = false;
                    }
                    return true;
                }
                C0320bt.f1177JZ = true;
                C0320bt.m1142b(false, 1, C0320bt.f1015GS);
                C0320bt.m1950t(471, 477, 7, 0);
                return false;
            }
            return false;
        }
        if (C0320bt.f1076Hb <= C0320bt.m1863ob()) {
            if (C0320bt.f1853Wa == 45) {
                C0320bt.f1016GT = 1;
            }
            m977bs(C0320bt.f1016GT);
            if ((C0320bt.f1019GW <= 0 || !C0320bt.m1206cV(C0320bt.f1019GW)) && (C0320bt.f1020GX <= 0 || !C0320bt.m1207cW(C0320bt.f1020GX))) {
                C0320bt.f1613Ru = -1;
                if (C0320bt.f1019GW > 0) {
                    String ak = C0320bt.m418ak(379);
                    if (ak == null) {
                        ak = "";
                    }
                    C0320bt.f1614Rv = C0320bt.m433b(ak, "%d", C0320bt.m371a(C0320bt.f1019GW - C0320bt.m1806nZ(), C0320bt.f1855Wc, " "));
                    C0320bt.f1613Ru = 19;
                    C0320bt.f1755Ug = false;
                } else if (C0320bt.f1020GX > 0) {
                    String ak2 = C0320bt.m418ak(381);
                    if (ak2 == null) {
                        ak2 = "";
                    }
                    C0320bt.f1614Rv = C0320bt.m433b(ak2, "%d", C0320bt.m371a(C0320bt.f1020GX - C0320bt.m1862oa(), C0320bt.f1855Wc, " "));
                    C0320bt.f1613Ru = 20;
                    C0320bt.f1755Ug = true;
                }
                if (C0320bt.f1613Ru != -1) {
                    C0320bt.m1147bC(35);
                    C0320bt.f1899Xs = true;
                }
                C0320bt.f1013GQ = -1;
                this.f790BW = false;
            } else {
                C0320bt.m1056a(0, this);
                if (C0320bt.f1853Wa == 5 || C0320bt.f1853Wa == 8) {
                    C0320bt.f1073HY = false;
                }
            }
        }
        return true;
    }

    final boolean m986eE() {
        if (C0320bt.f1853Wa == 38) {
            return false;
        }
        if (this.f889yM == 1 && C0320bt.f1013GQ != 0) {
            if ((C0320bt.f1210KG & 1) == 1) {
                C0320bt.m1235cy(0);
                return true;
            }
        }
        if (C0320bt.f1853Wa >= 14 && C0320bt.f1853Wa <= 35) {
            return false;
        }
        if ((this.f889yM != 3 && this.f889yM != 4) || C0320bt.f1013GQ != -1 || C0320bt.f1853Wa != -1) {
            return false;
        }
        C0320bt.m1231cu(46);
        C0320bt.m1074a(true, this);
        return false;
    }

    final void m987eF() {
        if ((this.f786BS > 0 && C0320bt.m1205cU(this.f786BS)) || (this.f787BT > 0 && C0320bt.m1208cX(this.f787BT))) {
            C0331k c0331k = C0331k.f1930ea[2];
            int m1862oa = C0320bt.m1862oa();
            int i = this.f786BS > 0 ? 111552 : 111551;
            int i2 = c0331k.f1933ed[this.f882Dt][19];
            int i3 = C0320bt.f1887Xg;
            int i4 = C0320bt.f1886Xf;
            C0320bt.m1054a(m1862oa, i, 115424, i2, 1, i3, this.f786BS > 0 ? this.f786BS : this.f787BT, 0, 116011, C0320bt.f1889Xi, 111547, C0320bt.m1863ob());
            m978bt(3);
            if (C0320bt.f1853Wa == 45) {
                C0320bt.f1071HW++;
                return;
            } else if (C0320bt.f1853Wa == 8) {
                C0320bt.f1071HW++;
                return;
            } else {
                if (C0320bt.f1853Wa == -1) {
                    C0320bt.m1947s(this.f853DK, 1, 12);
                    return;
                }
                return;
            }
        }
        C0320bt.f1613Ru = -1;
        if (this.f786BS > 0) {
            String ak = C0320bt.m418ak(379);
            if (ak == null) {
                ak = "";
            }
            C0320bt.f1614Rv = C0320bt.m433b(ak, "%d", C0320bt.m371a(this.f786BS - C0320bt.m1806nZ(), C0320bt.f1855Wc, " "));
            C0320bt.f1613Ru = 19;
            C0320bt.f1755Ug = false;
        } else if (this.f787BT > 0) {
            String ak2 = C0320bt.m418ak(381);
            if (ak2 == null) {
                ak2 = "";
            }
            C0320bt.f1614Rv = C0320bt.m433b(ak2, "%d", C0320bt.m371a(this.f787BT - C0320bt.m1862oa(), C0320bt.f1855Wc, " "));
            C0320bt.f1613Ru = 20;
            C0320bt.f1755Ug = true;
        }
        if (C0320bt.f1613Ru != -1) {
            C0320bt.m1147bC(35);
            C0320bt.f1899Xs = true;
        }
        C0320bt.f1013GQ = -1;
        this.f790BW = false;
        if (this.f786BS > 0 && this.f786BS > C0320bt.m1806nZ()) {
            C0320bt.f1886Xf = this.f786BS - C0320bt.m1806nZ();
        } else {
            if (this.f787BT <= 0 || this.f787BT <= C0320bt.m1862oa()) {
                return;
            }
            C0320bt.f1887Xg = this.f787BT - C0320bt.m1862oa();
        }
    }

    final void m988eG() {
        m978bt(1);
        if (C0320bt.f1853Wa == 38) {
            C0320bt.f1071HW++;
        } else if (C0320bt.f1853Wa == 5) {
            C0320bt.f1071HW++;
        }
        m967s(false);
        this.f853DK = C0320bt.f1832WF[0];
        this.f854DL = C0320bt.f1833WG[0];
        m974bA(1024);
    }

    final boolean m989eI() {
        if (this.f889yM == 3) {
            C0320bt.m1235cy(1);
        }
        return m990eJ();
    }

    final boolean m990eJ() {
        if (this.f889yM != 3 || C0320bt.f1013GQ != 1) {
            return false;
        }
        if (C0320bt.f1177JZ) {
            return false;
        }
        if ((C0320bt.f1829WC != 0 || C0320bt.m1199cO(5) + m939bn(3) + 3 <= C0320bt.m1804nX()) && (C0320bt.f1829WC != 0 || C0320bt.m1199cO(5) + C0320bt.f1176JY + 3 <= C0320bt.m1804nX())) {
            C0320bt.m1056a(1, this);
            return true;
        }
        C0320bt.f1177JZ = true;
        C0320bt.m1142b(false, 1, C0320bt.f1015GS);
        if (C0320bt.m1199cO(5) < C0320bt.m1804nX()) {
            String ak = C0320bt.m418ak(476);
            if (ak == null) {
                ak = "";
            }
            String b2 = C0320bt.m433b(ak, "%slots", "3");
            String ak2 = C0320bt.m418ak(475);
            if (ak2 == null) {
                ak2 = "";
            }
            C0320bt.m1140b(ak2, b2, 7, 0);
        } else {
            C0320bt.m1950t(471, 477, 7, 0);
        }
        return false;
    }

    final boolean m991eK() {
        if (this.f889yM == 2) {
            if (C0320bt.f1853Wa != 18 && C0320bt.f1013GQ == -1) {
                C0320bt.m1231cu(46);
                C0320bt.m1074a(true, this);
                return true;
            }
        } else if (this.f889yM == 3 && C0320bt.f1013GQ != 1) {
            C0320bt.m1235cy(1);
            return true;
        }
        return false;
    }

    final void m992eL() {
        m979bu(2);
        m967s(true);
        m974bA(1024);
    }

    final void m993eM() {
        m1021fm();
        C0320bt.m1181c(this);
        C0331k c0331k = C0331k.f1930ea[11];
        int i = c0331k.f1933ed[this.f882Dt][3];
        int i2 = c0331k.f1933ed[this.f882Dt][4];
        int i3 = c0331k.f1933ed[this.f882Dt][5];
        int i4 = c0331k.f1933ed[this.f882Dt][6];
        int[] iArr = {0, 0, 14};
        if (i > 0) {
            m925a(47, 3, iArr).m971a(this.f868Df, this.f869Dg, 37, PlacePickerFragment.DEFAULT_RADIUS_IN_METERS, false, false, i);
        }
        if (i2 > 0) {
            m925a(47, 3, iArr).m971a(this.f868Df, this.f869Dg, 36, PlacePickerFragment.DEFAULT_RADIUS_IN_METERS, false, true, i2);
        }
        int i5 = 0;
        if (i4 > 0 && (i5 = GLLib.m504p(i3, i4 + 1)) > 0) {
            m925a(47, 3, iArr).m971a(this.f868Df, this.f869Dg, 6, PlacePickerFragment.DEFAULT_RADIUS_IN_METERS, false, true, i5);
        }
        if (C0320bt.f1885Xe != null) {
            C0320bt.f1885Xe.m872a(115443, new String[]{Integer.toString(C0320bt.m1862oa()), Integer.toString(i5), Integer.toString(i2), Integer.toString(119043), Integer.toString(115433), Integer.toString(i), Integer.toString(C0320bt.m1863ob())});
        }
        m1005ep();
    }

    final boolean m994eN() {
        if (C0320bt.f1060HL == 1 || this.f889yM == 3 || this.f889yM == 7) {
            return false;
        }
        C0320bt.m1231cu(this.f856DN);
        if (C0320bt.f1067HS == this) {
            C0320bt.m1783nC();
        }
        if (m975bB(4)) {
            if (C0320bt.m1276dd(this.f830Cn) >= this.f823Cg) {
                C0320bt.m1056a(4, this);
            } else {
                C0320bt.m1888p(391, 7, 0);
            }
            return true;
        }
        if (m975bB(16)) {
            if (C0320bt.m1199cO(5) + m939bn(3) < C0320bt.m1804nX() || C0320bt.f1829WC != 0) {
                C0320bt.m1056a(7, this);
                return true;
            }
            C0320bt.m1950t(471, 477, 7, 0);
            return false;
        }
        if (m975bB(256)) {
            C0320bt.m1056a(4, this);
            return true;
        }
        m980bv(0);
        if (C0320bt.f1079He == null) {
            C0320bt.m1074a(true, this);
        }
        if (m975bB(32) || this.f817Ca != 0 || this.f793BZ == 0 || C0320bt.f1829WC != 0) {
            return false;
        }
        m981bw(16);
        C0320bt.m1074a(false, (C0319bs) null);
        return false;
    }

    final void m995eO() {
        this.f817Ca = C0331k.f1930ea[0].f1933ed[this.f882Dt][24] * 60;
        this.f793BZ = C0320bt.m1881ot();
    }

    final void m996eP() {
        this.f821Ce = C0331k.f1930ea[0].f1933ed[this.f882Dt][13] * 60;
        this.f822Cf = C0320bt.m1881ot() / 1000;
    }

    final void m997eQ() {
        if (!m975bB(4)) {
            if (m975bB(256)) {
                m980bv(7);
                C0320bt.m1947s(this.f853DK, 1, 20);
                m974bA(256);
                m1020fl();
                this.f851DI = new RunnableC0340t(C0320bt.f1863Wk[13], this.f873Dk, this.f874Dl);
                this.f851DI.m2143x(0, 2);
                this.f849DG = this.f837Cu;
                this.f850DH = this.f838Cv;
                C0320bt.m1231cu(31);
                return;
            }
            return;
        }
        if (this.f889yM == 3 || C0320bt.f1829WC != 0) {
            if (C0320bt.f1829WC == 0) {
                C0320bt.m1231cu(55);
                return;
            }
            m980bv(3);
            m974bA(4);
            m1020fl();
            this.f793BZ = C0320bt.m1881ot();
            this.f824Ch = false;
            this.f827Ck = false;
            this.f826Cj = false;
            this.f825Ci = false;
            this.f828Cl = false;
            C0320bt.m1231cu(35);
            return;
        }
        C0320bt.m1095aL(this.f823Cg, this.f830Cn);
        m980bv(3);
        this.f819Cc++;
        if (this.f819Cc >= this.f818Cb && !m975bB(2048)) {
            m982bz(2048);
            int i = this.f887Dy;
            int i2 = this.f888Dz;
            int i3 = this.f843DA;
            C0320bt.m1948s(469, 470, 7, 0);
            C0320bt.m1326eT(0);
        }
        C0320bt.m1947s(this.f853DK, 1, 19);
        m974bA(4);
        m1020fl();
        this.f793BZ = C0320bt.m1881ot();
        this.f824Ch = false;
        this.f827Ck = false;
        this.f826Cj = false;
        this.f825Ci = false;
        this.f828Cl = false;
        C0320bt.m1231cu(35);
    }

    final void m998eR() {
        m980bv(5);
        m974bA(16);
        m1020fl();
        this.f793BZ = C0320bt.m1881ot();
    }

    final void m999eT() {
        m1020fl();
    }

    final void m1000eU() {
        if (m975bB(4) && this.f847DE != null) {
            m1020fl();
            this.f847DE = null;
        }
        if (m975bB(16) && this.f847DE != null) {
            m1020fl();
            this.f847DE = null;
        }
        if (!m975bB(256) || this.f847DE == null) {
            return;
        }
        m1020fl();
        this.f847DE = null;
    }

    final void m1001eW() {
        if (m975bB(8)) {
            if (!this.f808CI) {
                this.f813CN += GLLib.f146iP;
                this.f814CO += GLLib.f146iP;
                int i = this.f813CN << 1;
                int i2 = this.f809CJ ? 1 : -1;
                if (this.f815CP < 3) {
                    this.f810CK = (i2 * (this.f812CM * this.f814CO)) / 100;
                    this.f811CL = (((i * 4) * i) / 10000) + ((i * (-40)) / 100);
                    for (int i3 = 1; i3 < this.f815CP; i3++) {
                        this.f811CL = (this.f811CL * 40) / 100;
                    }
                    if (this.f811CL > 0) {
                        this.f815CP++;
                        this.f811CL = (this.f811CL * (-40)) / 100;
                        this.f813CN = 0;
                    }
                } else {
                    this.f808CI = true;
                    C0320bt.m1231cu(37);
                    if (this.f802CC == 60) {
                        C0320bt.m1399g(true, (((this.f887Dy & (-32769)) - 108) << 2) + this.f888Dz);
                    }
                }
                this.f868Df = this.f805CF + this.f810CK;
                this.f869Dg = this.f806CG + this.f811CL;
                return;
            }
            this.f803CD += GLLib.f146iP * 4;
            if (this.f802CC == 57) {
                this.f884Dv = C0320bt.f1866Wn.f868Df + C0320bt.f984Fn[1][26][2] + (C0320bt.f987Fq[1].m666n(33) >> 1);
                this.f885Dw = C0320bt.f1866Wn.f869Dg + C0320bt.f984Fn[1][26][3] + (C0320bt.f987Fq[1].m666n(33) >> 1);
            } else if (this.f802CC >= 59) {
                if ((this.f807CH & 65535) == 5) {
                    this.f884Dv = C0320bt.f1866Wn.f868Df + C0320bt.f984Fn[1][28][2];
                    this.f885Dw = C0320bt.f1866Wn.f869Dg + C0320bt.f984Fn[1][28][3];
                } else {
                    this.f884Dv = C0320bt.f1866Wn.f868Df + C0320bt.f984Fn[1][59][2];
                    this.f885Dw = C0320bt.f1866Wn.f869Dg + C0320bt.f984Fn[1][59][3];
                }
            } else if (this.f802CC == 37) {
                this.f884Dv = C0320bt.f1866Wn.f868Df + C0320bt.f984Fn[1][21][2] + (C0320bt.f987Fq[1].m666n(4) >> 1);
                this.f885Dw = C0320bt.f1866Wn.f869Dg + C0320bt.f984Fn[1][21][3] + (C0320bt.f987Fq[1].m666n(4) >> 1);
            } else {
                this.f884Dv = C0320bt.f1866Wn.f868Df;
                this.f885Dw = C0320bt.f1866Wn.f869Dg;
            }
            if (this.f802CC == 60) {
                this.f884Dv = C0320bt.f1866Wn.f868Df + C0320bt.f984Fn[1][this.f888Dz + 80][2];
                this.f885Dw = C0320bt.f1866Wn.f869Dg + C0320bt.f984Fn[1][this.f888Dz + 80][3];
            }
            if (this.f804CE > 0) {
                this.f868Df = this.f805CF + (((((this.f884Dv * 100) / C0320bt.f1799VY) - this.f805CF) * this.f803CD) / this.f804CE);
                this.f869Dg = this.f806CG + ((((((this.f885Dw * 100) / C0320bt.f1799VY) - this.f806CG) * (this.f803CD * this.f803CD)) / this.f804CE) / this.f804CE);
            }
            if (this.f803CD > this.f804CE) {
                m982bz(8);
                if (this.f816CQ) {
                    m1005ep();
                    if (this.f802CC == 37) {
                        C0320bt.m1275dc(this.f807CH);
                        return;
                    }
                    if (this.f802CC == 36) {
                        C0320bt.m1209cY(this.f807CH);
                        return;
                    }
                    if (this.f802CC == 6) {
                        C0320bt.m1210cZ(this.f807CH);
                        return;
                    }
                    if (this.f802CC != 59) {
                        int i4 = this.f802CC;
                        return;
                    }
                    int i5 = this.f807CH & 65535;
                    int i6 = this.f807CH >> 16;
                    if (i5 == 110) {
                        C0320bt.m1274db(i6);
                        short s = C0320bt.f1839WM[i5];
                        C0320bt.m1615k(s, i6, 34);
                        C0320bt.m1947s(s, i6, 34);
                        C0320bt.m1947s(s, i6, 22);
                    } else if (i5 == 5) {
                        C0320bt.m1273da(i6);
                    } else if (i5 < 111 || i5 > 116) {
                        C0320bt.m1670l(0, i5, i6);
                        if (i6 > 0) {
                            C0320bt.m1200cP(-i6);
                        }
                        C0320bt.m1805nY();
                    } else {
                        C0320bt.m1096aM(i6, i5 - 111);
                    }
                    if (i5 < 0 || i5 >= 6) {
                        return;
                    }
                    C0320bt.m1947s(C0320bt.f1839WM[i5], i6, 22);
                }
            }
        }
    }

    final void m1002eX() {
        m917V(this.f887Dy, this.f888Dz);
    }

    final void m1003eY() {
        int i = (this.f802CC == 37 || this.f802CC == 36 || this.f802CC == 6) ? this.f807CH : this.f802CC == 59 ? this.f807CH >> 16 : 0;
        if (i > 0) {
            GLLib.m502k(true);
            C0320bt.m1062a(new StringBuffer("+").append(C0320bt.m371a(i, C0320bt.f1855Wc, " ")).toString(), (((float) (((this.f868Df + this.f876Dn) - C0320bt.f1866Wn.f868Df) * C0320bt.f1799VY)) / 100.0f > 0.0f ? (int) (((((this.f868Df + this.f876Dn) - C0320bt.f1866Wn.f868Df) * C0320bt.f1799VY) / 100.0f) + 0.5f) : ((float) (((this.f868Df + this.f876Dn) - C0320bt.f1866Wn.f868Df) * C0320bt.f1799VY)) / 100.0f < 0.0f ? (int) (((((this.f868Df + this.f876Dn) - C0320bt.f1866Wn.f868Df) * C0320bt.f1799VY) / 100.0f) - 0.5f) : 0) + 10, (((float) (((this.f869Dg + this.f877Do) - C0320bt.f1866Wn.f869Dg) * C0320bt.f1799VY)) / 100.0f > 0.0f ? (int) (((((this.f869Dg + this.f877Do) - C0320bt.f1866Wn.f869Dg) * C0320bt.f1799VY) / 100.0f) + 0.5f) : ((float) (((this.f869Dg + this.f877Do) - C0320bt.f1866Wn.f869Dg) * C0320bt.f1799VY)) / 100.0f < 0.0f ? (int) (((((this.f869Dg + this.f877Do) - C0320bt.f1866Wn.f869Dg) * C0320bt.f1799VY) / 100.0f) - 0.5f) : 0) + 10, 0, 0, 0, 0, 2, 1, false, false);
            GLLib.m502k(false);
        }
    }

    final void m1004eZ() {
        if (this.f848DF != null) {
            RunnableC0340t runnableC0340t = this.f848DF;
            int i = C0320bt.f1799VY;
            if (C0338r.f2439rG) {
                runnableC0340t.f2625tG = i;
            }
            RunnableC0340t runnableC0340t2 = this.f848DF;
            int i2 = this.f873Dk;
            int i3 = this.f874Dl;
            runnableC0340t2.f2627tw = i2;
            runnableC0340t2.f2628tx = i3;
            this.f848DF.m2142bR();
        }
    }

    final void m1005ep() {
        if (m975bB(16777216)) {
            m1021fm();
        }
        if (this.f865Dc != null) {
            this.f865Dc.f864Db = this.f864Db;
        } else if (this.f866Dd >= 0) {
            f755Bt[this.f866Dd] = this.f864Db;
        }
        if (this.f864Db != null) {
            this.f864Db.f865Dc = this.f865Dc;
        }
        this.f866Dd = -1;
        this.f864Db = null;
        this.f865Dc = null;
    }

    final void m1006es() {
        int i = 0;
        if (this.f871Di == 2) {
            this.f873Dk = 0;
            this.f874Dl = ((((this.f869Dg + this.f877Do) - 215) - C0320bt.f1866Wn.f869Dg) * C0320bt.f1799VY) / 100;
            return;
        }
        if (this.f871Di != 1) {
            this.f873Dk = (this.f868Df + this.f876Dn) - C0320bt.f1866Wn.f868Df;
            this.f874Dl = (this.f869Dg + this.f877Do) - C0320bt.f1866Wn.f869Dg;
            return;
        }
        float f = (648 - C0320bt.f1866Wn.f869Dg) / 648.0f;
        this.f873Dk = this.f868Df - (C0320bt.f1866Wn.f868Df >> 4);
        if (this.f869Dg - (f * 40.0f) > 0.0f) {
            i = (int) ((this.f869Dg - (f * 40.0f)) + 0.5f);
        } else if (this.f869Dg - (f * 40.0f) < 0.0f) {
            i = (int) ((this.f869Dg - (f * 40.0f)) - 0.5f);
        }
        this.f874Dl = i - C0320bt.f1866Wn.f869Dg;
    }

    final void m1007eu() {
        int i;
        boolean z = true;
        if (this.f884Dv > this.f868Df) {
            this.f860DR = false;
            if (this.f885Dw > this.f869Dg) {
                this.f861DS = false;
                i = 0;
            } else {
                this.f861DS = true;
                i = 1;
            }
        } else {
            this.f860DR = true;
            if (this.f885Dw > this.f869Dg) {
                this.f861DS = false;
                i = 0;
            } else {
                this.f861DS = true;
                i = 1;
            }
        }
        if ((this.f860DR || this.f861DS) && (!this.f860DR || !this.f861DS)) {
            z = false;
        }
        this.f848DF.m2143x(i, -1);
        if (z) {
            this.f848DF.m2137az(2);
        } else {
            this.f848DF.m2137az(0);
        }
    }

    final boolean m1008ev() {
        boolean z;
        if (this.f889yM == 3) {
            return false;
        }
        if (C0320bt.f1208KE == 0 && C0320bt.m1800nT() < 50) {
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            iArr2[0] = C0338r.f2455rW ? C0338r.f2456rX > 1 ? GLLib.f293lr[0] : GLLib.f283lh : -1;
            iArr2[1] = C0338r.f2455rW ? C0338r.f2456rX > 1 ? GLLib.f294ls[0] : GLLib.f284li : -1;
            C0320bt.m1076a(iArr2, iArr);
            C0320bt.m1184c(iArr, iArr2);
            if (GLLib.m423ap(0) && C0320bt.f1003GG == -1) {
                if (C0320bt.m1087aD(iArr2[0], iArr2[1])) {
                    int[] iArr3 = new int[2];
                    C0320bt.m1076a(new int[]{C0338r.f2455rW ? C0338r.f2456rX > 1 ? GLLib.f293lr[0] : GLLib.f283lh : -1, C0338r.f2455rW ? C0338r.f2456rX > 1 ? GLLib.f294ls[0] : GLLib.f284li : -1}, iArr3);
                    m968X(iArr3[0], iArr3[1]);
                    z = true;
                } else if (C0320bt.f1829WC == 0 && C0320bt.m1088aE(iArr2[0], iArr2[1]) > 0) {
                    int m1088aE = C0320bt.m1088aE(iArr2[0], iArr2[1]);
                    if (m1088aE > 0 && !C0320bt.f1142Iq[m1088aE] && C0320bt.f1853Wa == -1 && C0320bt.m1324eR(C0320bt.f1844WR[0]) && C0320bt.m1324eR(C0320bt.f1844WR[1])) {
                        C0320bt.f1141Ip = m1088aE;
                        C0320bt.m1147bC(13);
                    }
                    z = false;
                }
                return z;
            }
            if (C0320bt.f1829WC == 0 && GLLib.m427at(0) && !C0320bt.m1195cK(C0320bt.m1088aE(iArr2[0], iArr2[1])) && C0320bt.m1088aE(iArr2[0], iArr2[1]) > 0 && C0320bt.f1003GG == -1 && C0320bt.m1324eR(C0320bt.f1844WR[0]) && C0320bt.m1324eR(C0320bt.f1844WR[1])) {
                int m1088aE2 = C0320bt.m1088aE(iArr2[0], iArr2[1]);
                if (C0320bt.m1088aE(iArr2[0], iArr2[1]) > 0 && C0320bt.f1853Wa == -1) {
                    C0320bt.f1141Ip = m1088aE2;
                    C0320bt.f1110IK = true;
                }
            }
        }
        z = false;
        return z;
    }

    final void m1009ew() {
        if (this.f889yM == 0) {
            if (GLLib.m424aq(0)) {
                this.f794Bu = this.f868Df;
                this.f795Bv = this.f869Dg;
                this.f796Bw = C0320bt.f283lh;
                this.f797Bx = C0320bt.f284li;
                this.f799Bz = true;
            } else if (!this.f768BA && GLLib.m425ar(0) && this.f799Bz && !C0320bt.f1097Hw) {
                this.f868Df = this.f794Bu + (((this.f796Bw - C0320bt.f283lh) * 100) / C0320bt.f1799VY);
                this.f869Dg = this.f795Bv + (((this.f797Bx - C0320bt.f284li) * 100) / C0320bt.f1799VY);
                if (C0320bt.f1013GQ == 0 && !C0320bt.f1097Hw) {
                    C0320bt.f1013GQ = -1;
                    C0320bt.m1142b(false, 0, C0320bt.f1015GS);
                }
            } else if (GLLib.m423ap(0)) {
                if (this.f799Bz && C0320bt.m1800nT() > 50) {
                    if ((C0320bt.f1157JF - C0320bt.f1155JD < 0 ? -(C0320bt.f1157JF - C0320bt.f1155JD) : C0320bt.f1157JF - C0320bt.f1155JD) <= 0) {
                    }
                    int i = C0320bt.f1157JF - C0320bt.f1155JD;
                    int i2 = C0320bt.f1158JG - C0320bt.f1156JE;
                    float sqrt = (float) Math.sqrt((i * i) + (i2 * i2));
                    this.f777BJ = i / sqrt;
                    this.f778BK = i2 / sqrt;
                    if (sqrt <= 200.0f) {
                        float sqrt2 = (float) Math.sqrt((GLLib.f139iH * GLLib.f139iH) + (GLLib.f140iI * GLLib.f140iI));
                        this.f775BH = (((float) (1000 - C0320bt.f1159JH)) / 1000.0f < 0.0f ? 0.0f : ((float) (1000 - C0320bt.f1159JH)) / 1000.0f > 1.0f ? 1.0f : (1000 - C0320bt.f1159JH) / 1000.0f) * ((100.0f * sqrt) / sqrt2);
                        this.f776BI = (1.0f - (sqrt / sqrt2)) * 0.5f;
                    }
                }
                this.f799Bz = false;
            }
            if (!GLLib.m427at(0) || !GLLib.m427at(1)) {
                if (this.f768BA) {
                    this.f768BA = false;
                    this.f799Bz = false;
                    return;
                }
                return;
            }
            int i3 = GLLib.f139iH >> 1;
            int i4 = GLLib.f140iI >> 1;
            if (!this.f768BA) {
                this.f768BA = true;
                this.f798By = C0320bt.f1799VY;
                this.f769BB = Math.abs((C0338r.f2455rW ? C0338r.f2456rX > 1 ? GLLib.f293lr[0] : GLLib.f283lh : -1) - (C0338r.f2455rW ? C0338r.f2456rX > 1 ? GLLib.f293lr[1] : GLLib.f283lh : -1));
                this.f770BC = Math.abs((C0338r.f2455rW ? C0338r.f2456rX > 1 ? GLLib.f294ls[0] : GLLib.f284li : -1) - (C0338r.f2455rW ? C0338r.f2456rX > 1 ? GLLib.f294ls[1] : GLLib.f284li : -1));
                this.f794Bu = this.f868Df + ((i3 * 100) / C0320bt.f1799VY);
                this.f795Bv = this.f869Dg + ((i4 * 100) / C0320bt.f1799VY);
            }
            int abs = Math.abs((C0338r.f2455rW ? C0338r.f2456rX > 1 ? GLLib.f293lr[0] : GLLib.f283lh : -1) - (C0338r.f2455rW ? C0338r.f2456rX > 1 ? GLLib.f293lr[1] : GLLib.f283lh : -1));
            int abs2 = Math.abs((C0338r.f2455rW ? C0338r.f2456rX > 1 ? GLLib.f294ls[0] : GLLib.f284li : -1) - (C0338r.f2455rW ? C0338r.f2456rX > 1 ? GLLib.f294ls[1] : GLLib.f284li : -1));
            int i5 = C0320bt.f1799VY;
            C0320bt.f1799VY = (this.f798By + ((int) (((double) (abs - this.f769BB)) * 0.1d))) + ((int) (((double) (abs2 - this.f770BC)) * 0.1d)) < 50 ? 50 : (this.f798By + ((int) (((double) (abs - this.f769BB)) * 0.1d))) + ((int) (((double) (abs2 - this.f770BC)) * 0.1d)) > 100 ? 100 : ((int) ((abs2 - this.f770BC) * 0.1d)) + ((int) ((abs - this.f769BB) * 0.1d)) + this.f798By;
            if (i5 != C0320bt.f1799VY) {
                this.f868Df = this.f794Bu - ((i3 * 100) / C0320bt.f1799VY);
                this.f869Dg = this.f795Bv - ((i4 * 100) / C0320bt.f1799VY);
            }
        }
    }

    final void m1010ex() {
        if (this.f889yM == 0 && GLLib.m425ar(0)) {
            if (C0320bt.f283lh < 40) {
                this.f868Df -= GLLib.f146iP * 1;
            } else if (C0320bt.f283lh > GLLib.f139iH - 40) {
                this.f868Df += GLLib.f146iP * 1;
            }
            if (C0320bt.f284li < 40) {
                this.f869Dg -= GLLib.f146iP * 1;
            } else if (C0320bt.f284li > GLLib.f140iI - 40) {
                this.f869Dg += GLLib.f146iP * 1;
            }
        }
    }

    final void m1011ey() {
        int i = 100;
        if (this.f889yM == 0) {
            if (this.f775BH > 1.0f) {
                this.f868Df -= (int) (this.f777BJ * this.f775BH);
                this.f869Dg -= (int) (this.f778BK * this.f775BH);
                this.f775BH -= (this.f775BH * this.f776BI) * (GLLib.f146iP / 100.0f);
            }
            int i2 = this.f772BE - ((GLLib.f139iH * 100) / C0320bt.f1799VY);
            int i3 = this.f774BG - ((GLLib.f140iI * 100) / C0320bt.f1799VY);
            if (this.f868Df < 0) {
                this.f868Df = 0;
            } else if (this.f868Df > i2) {
                this.f868Df = i2;
            }
            if (this.f869Dg < 0) {
                this.f869Dg = 0;
            } else if (this.f869Dg > i3) {
                this.f869Dg = i3;
            }
        } else if (this.f889yM == 1) {
            this.f779BL -= GLLib.f146iP;
            int[] iArr = new int[2];
            C0320bt.m1076a(new int[]{GLLib.f139iH >> 1, GLLib.f140iI >> 1}, iArr);
            int i4 = this.f884Dv - iArr[0];
            int i5 = this.f885Dw - iArr[1];
            if (this.f779BL > 0) {
                int i6 = (GLLib.f146iP * 100) / this.f779BL;
                if (i6 <= 100) {
                    i = i6;
                }
            } else {
                this.f779BL = 0;
                this.f889yM = 0;
            }
            this.f868Df = ((i4 * i) / 100) + this.f868Df;
            this.f869Dg = ((i * i5) / 100) + this.f869Dg;
        }
        RunnableC0340t.m2082a(0, this.f868Df, this.f869Dg);
        RunnableC0340t.f2592uP = C0320bt.f1799VY;
    }

    final void m1012fa() {
        if (this.f848DF == null || !this.f848DF.m2141bQ() || (f756CR != -1 && f756CR >= f757CS)) {
            if (this.f848DF == null || !this.f848DF.m2141bQ() || f756CR < f757CS) {
                return;
            }
            this.f848DF = null;
            this.f867De = -1;
            if (m922a(1, 21, new C0319bs[1], 1) == 0) {
                C0320bt.m1133b(0, 85, 65535, 1, 0, 0, -1);
                C0320bt.m1156bL(0);
                return;
            }
            return;
        }
        C0320bt.m1231cu(GLLib.m504p(25, 29));
        this.f848DF.m2143x(0, 1);
        int m666n = this.f848DF.f2630tz.m666n(0);
        int m667o = this.f848DF.f2630tz.m667o(0);
        this.f868Df = ((GLLib.m504p(m666n, GLLib.f139iH - m666n) + C0320bt.f1866Wn.f868Df) * 100) / C0320bt.f1799VY;
        this.f869Dg = ((C0320bt.f1866Wn.f869Dg + GLLib.m504p(m667o, GLLib.f140iI - m667o)) * 100) / C0320bt.f1799VY;
        if (C0320bt.f919Ea[C0320bt.f892DZ] == 14) {
            this.f873Dk = ((this.f868Df * C0320bt.f1799VY) / 100) - C0320bt.f1866Wn.f868Df;
            this.f874Dl = ((this.f869Dg * C0320bt.f1799VY) / 100) - C0320bt.f1866Wn.f869Dg;
        }
        C0271a c0271a = this.f848DF.f2630tz;
        this.f848DF.f2626tI = GLLib.m504p(0, (c0271a.f459cd & 1073741824) != 0 ? c0271a.f465cj[0] : c0271a.f464ci);
        if (f756CR >= 0) {
            f756CR++;
        }
    }

    final void m1013fb() {
        C0320bt.m1181c(this);
        m1005ep();
    }

    final void m1014fc() {
        C0320bt.m1136b(this);
        this.f889yM = 1;
        this.f848DF.m2143x(0, -1);
        this.f888Dz = 0;
    }

    final boolean m1015ff() {
        return (this.f884Dv == this.f868Df && this.f885Dw == this.f869Dg) ? false : true;
    }

    final void m1016fg() {
        if (this.f867De == 49) {
            this.f785BR = 0;
            m978bt(5);
            return;
        }
        if (this.f867De == 54) {
            if (m975bB(32)) {
                this.f821Ce = 0;
                m952eS();
            } else {
                this.f817Ca = 0;
            }
            C0320bt.f1873Wu = 100;
            C0320bt.f1874Wv = "0:0:0";
            return;
        }
        if (this.f867De == 52) {
            m979bu(3);
        } else if (this.f867De == 50) {
            this.f780BM = 0L;
        }
    }

    final int m1017fi() {
        int i = this.f853DK;
        switch (((i < 1000 || i >= 2000) && (i < 10000 || i >= 11000)) ? (i < 2000 || i >= 3000) ? (i < 3000 || i >= 4000) ? (i < 7000 || i >= 8000) ? (i < 25000 || i >= 26000) ? (char) 65535 : '0' : (char) 20 : '1' : '6' : '2') {
            case 20:
                return C0331k.f1930ea[4].f1933ed[this.f882Dt][18];
            case '1':
                return C0331k.f1930ea[2].f1933ed[this.f882Dt][16];
            case Request.MAXIMUM_BATCH_SIZE:
                return C0331k.f1930ea[3].f1933ed[this.f882Dt][30];
            case '6':
                C0331k c0331k = C0331k.f1930ea[0];
                return m975bB(2048) ? c0331k.f1933ed[this.f882Dt][11] : c0331k.f1933ed[this.f882Dt][10];
            default:
                return 0;
        }
    }

    final void m1018fj() {
        int m1017fi;
        int i;
        if (this.f867De != 49) {
            if (m975bB(2)) {
                C0320bt.m1181c(this);
            }
            m1017fi = m1017fi();
            m1005ep();
        } else if (this.f889yM == 3 || this.f889yM == 4) {
            m1017fi = m1017fi();
            m978bt(1);
            this.f853DK = C0320bt.f1832WF[0];
            this.f854DL = C0320bt.f1833WG[0];
            m974bA(1024);
        } else {
            if (m975bB(2)) {
                C0320bt.m1181c(this);
            }
            m1017fi = m1017fi();
            m1005ep();
        }
        m1020fl();
        m925a(47, 3, new int[]{0, 0, 14}).m971a(this.f868Df, this.f869Dg, 36, PlacePickerFragment.DEFAULT_RADIUS_IN_METERS, false, false, m1017fi);
        if (C0320bt.f1885Xe != null) {
            switch (this.f867De) {
                case 20:
                    i = 115430;
                    break;
                case 49:
                    i = 115424;
                    break;
                case Request.MAXIMUM_BATCH_SIZE:
                    i = 115421;
                    break;
                case 52:
                    i = 116010;
                    break;
                case 54:
                    if (this.f882Dt >= 4) {
                        i = 115423;
                        break;
                    } else {
                        i = 119024;
                        break;
                    }
                default:
                    i = 0;
                    break;
            }
            C0320bt.f1885Xe.m872a(115443, new String[]{Integer.toString(C0320bt.m1862oa()), Integer.toString(0), Integer.toString(m1017fi), Integer.toString(119043), Integer.toString(i), Integer.toString(0), Integer.toString(C0320bt.m1863ob())});
        }
    }

    final int m1019fk() {
        switch (this.f867De) {
            case 20:
                return 2;
            case Request.MAXIMUM_BATCH_SIZE:
                return 1;
            case 52:
                return 4;
            case 54:
                return 3;
            default:
                return -1;
        }
    }

    final void m1020fl() {
        if (this.f847DE != null) {
            this.f847DE.f867De = -1;
        }
    }

    final void m1021fm() {
        m930ac(this.f844DB, this.f845DC);
        m930ac(this.f887Dy, this.f888Dz);
    }
}
