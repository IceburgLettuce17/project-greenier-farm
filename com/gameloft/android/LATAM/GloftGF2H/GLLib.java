package com.gameloft.android.LATAM.GloftGF2H;

import android.graphics.Canvas;
import android.opengl.GLES10;
import android.opengl.GLES11;
import android.opengl.GLU;
import com.facebook.android.C0217R;
import com.facebook.widget.PlacePickerFragment;
import com.facebook.widget.WorkQueue;
import com.gameloft.android.wrapper.C0355i;
import com.gameloft.android2d.iap.C0463b;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Hashtable;
import java.util.Random;
import java.util.Vector;
import javax.microedition.khronos.opengles.GL10;
import p009b.p010a.p012b.AbstractC0054c;
import p009b.p010a.p012b.C0048ac;
import p009b.p010a.p012b.C0051af;
import p009b.p010a.p012b.C0065n;
import p009b.p010a.p015d.AbstractActivityC0092a;
import p009b.p010a.p016e.C0100b;
import p009b.p010a.p016e.C0101c;

public abstract class GLLib extends AbstractC0054c implements Runnable {

    static boolean f135iD;

    static int f136iE;

    static long f137iF;

    static boolean f138iG;

    static C0065n f141iJ;

    private static boolean f142iK;

    static AbstractActivityC0092a f143iL;

    static int f146iP;

    private static long f147iQ;

    static int f148iR;

    private static int f149iS;

    static GLLib f150iT;

    private static int f153iW;

    private static int f154iX;

    private static int f155iY;

    private static int f156iZ;

    private static int f157jA;

    private static int f158jB;

    private static float f159jC;

    private static int f160jD;

    static String f161jE;

    private static InputStream f162jF;

    private static int f163jG;

    private static byte[] f164jH;

    private static int f165jI;

    private static int f166jJ;

    private static short f167jK;

    private static int[] f168jL;

    private static short f169jM;

    private static short[] f170jN;

    private static int f171jO;

    static int f172jP;

    private static boolean f173jQ;

    private static byte[] f174jR;

    private static byte[][] f175jS;

    private static int f176jT;

    private static int f177jU;

    private static int f178jV;

    private static int f179jW;

    private static int f180jX;

    private static C0277ad f181jY;

    static boolean f182jZ;

    private static int f183ja;

    private static int f184jb;

    private static int f186jd;

    private static Hashtable f187je;

    private static Hashtable f188jf;

    static boolean f196jn;

    private static String f198jp;

    static final int f199jq;

    static final int f200jr;

    static Random f201js;

    static int f202jt;

    static int f203ju;

    static int[] f204jv;

    static int[] f205jw;

    private static int f206jx;

    static final int f207jy;

    private static int f208jz;

    private static int[] f209kA;

    private static int[] f210kB;

    private static long[] f211kC;

    private static long[] f212kD;

    private static byte[] f213kE;

    private static byte[] f214kF;

    private static byte[] f215kG;

    private static final char[] f216kH;

    private static int[] f217kI;

    private static boolean f218kJ;

    private static int f219kK;

    static String f220kL;

    private static byte[] f221kM;

    private static int[] f222kN;

    private static String[] f223kO;

    private static int[] f224kP;

    private static byte[][] f225kQ;

    private static int[] f226kR;

    private static int[][] f227kS;

    private static String[][] f228kT;

    private static C0100b f229kU;

    private static int f230kV;

    static final boolean f231kW;

    static boolean f232kX;

    static int f233kY;

    static int[][] f234kZ;

    private static boolean f235ka;

    static int f236kb;

    static int f237kc;

    static int f238kd;

    static int f239ke;

    private static FloatBuffer f240kf;

    private static float[] f241kg;

    private static FloatBuffer f242kh;

    private static float[] f243ki;

    private static ByteBuffer f244kj;

    private static byte[] f245kk;

    private static int f246kl;

    private static int f247km;

    private static int f248kn;

    private static int f249ko;

    private static float f250kp;

    private static float f251kq;

    private static boolean f252kr;

    private static int f253ks;

    private static int f254kt;

    private static int f255ku;

    private static boolean f256kv;

    private static int f257kw;

    private static InputStream f258kx;

    private static int f259ky;

    private static char[] f260kz;

    private static boolean[] f261lA;

    private static final char[] f262lB;

    private static int[] f263lC;

    public static long f264lD;

    private static C0286am f265lE;

    private static Vector f266lF;

    private static String f267lG;

    private static int f268lH;

    private static C0317bq f269lI;

    private static C0317bq f270lJ;

    private static int f271lK;

    private static int f272lL;

    private static int f273lM;

    private static int[][] f274lN;

    private static final char[][] f275lO;

    static C0277ad f276la;

    static C0048ac f277lb;

    static int f278lc;

    private static int f279ld;

    static int f280le;

    static int f281lf;

    static int f282lg;

    static int f283lh;

    static int f284li;

    static int f285lj;

    static int f286lk;

    private static int f287ll;

    private static int f288lm;

    private static boolean f289ln;

    private static boolean f290lo;

    private static boolean f291lp;

    private static int f292lq;

    static int[] f293lr;

    static int[] f294ls;

    private static int[] f295lt;

    private static int[] f296lu;

    private static int[] f297lv;

    private static int[] f298lw;

    private static int[] f299lx;

    private static boolean[] f300ly;

    private static boolean[] f301lz;

    private long f302iN;

    public static C0048ac f134iC = null;

    static int f139iH = C0338r.f2166lT;

    static int f140iI = C0338r.f2167lU;

    private static int f144iM = PlacePickerFragment.DEFAULT_RADIUS_IN_METERS / C0338r.f2207mi;

    static int f145iO = -1;

    static boolean f151iU = false;

    private static String f152iV = null;

    private static int f185jc = -9999;

    private static int f189jg = 25;

    private static int f190jh = C0338r.f2447rO;

    private static int f191ji = C0338r.f2448rP;

    private static int f192jj = C0338r.f2449rQ;

    private static int f193jk = 0;

    private static boolean f194jl = false;

    private static boolean f195jm = true;

    private static int f197jo = -1;

    static {
        int i = 1 << C0338r.f2195mW;
        f199jq = i;
        f200jr = i >> 1;
        f206jx = 1 << C0338r.f2196mX;
        f207jy = (f206jx * 90) / 360;
        f208jz = (f206jx * 180) / 360;
        f157jA = (f206jx * 270) / 360;
        f158jB = (f206jx * 360) / 360;
        f159jC = 3.1415927f;
        f160jD = 1686629713 >> (29 - C0338r.f2195mW);
        int i2 = C0338r.f2195mW;
        int i3 = C0338r.f2195mW;
        int i4 = f160jD;
        int i5 = C0338r.f2195mW;
        int i6 = C0338r.f2196mX;
        int i7 = C0338r.f2195mW;
        f176jT = 0;
        f177jU = 0;
        f178jV = -1;
        f179jW = 2;
        f182jZ = true;
        f235ka = false;
        f246kl = 255;
        f247km = 255;
        f248kn = 255;
        f249ko = 255;
        f250kp = 1.0f;
        f251kq = 1.0f;
        f252kr = false;
        f253ks = -1;
        f254kt = 0;
        f255ku = 0;
        f256kv = false;
        f257kw = 0;
        f259ky = 0;
        f260kz = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        f215kG = new byte[]{Byte.MIN_VALUE, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        f216kH = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        f220kL = "UTF-8";
        f230kV = C0338r.f2444rL;
        boolean z = C0338r.f2473ro;
        f231kW = false;
        boolean z2 = C0338r.f2439rG;
        f232kX = false;
        f233kY = 0;
        f234kZ = null;
        f276la = null;
        f277lb = null;
        f278lc = 0;
        f279ld = 0;
        f262lB = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
        f264lD = 0L;
        f269lI = new C0317bq();
        f270lJ = new C0317bq();
        f271lK = 0;
        f272lL = 1;
        f273lM = 2;
        f275lO = new char[][]{new char[]{3, 65152}, new char[]{1, 65153}, new char[]{1, 65155}, new char[]{1, 65157}, new char[]{1, 65159}, new char[]{2, 65161}, new char[]{1, 65165}, new char[]{2, 65167}, new char[]{1, 65171}, new char[]{2, 65173}, new char[]{2, 65177}, new char[]{2, 65181}, new char[]{2, 65185}, new char[]{2, 65189}, new char[]{1, 65193}, new char[]{1, 65195}, new char[]{1, 65197}, new char[]{1, 65199}, new char[]{2, 65201}, new char[]{2, 65205}, new char[]{2, 65209}, new char[]{2, 65213}, new char[]{2, 65217}, new char[]{2, 65221}, new char[]{2, 65225}, new char[]{2, 65229}, new char[]{3, 0}, new char[]{3, 0}, new char[]{3, 0}, new char[]{3, 0}, new char[]{3, 0}, new char[]{4, 0}, new char[]{2, 65233}, new char[]{2, 65237}, new char[]{2, 65241}, new char[]{2, 65245}, new char[]{2, 65249}, new char[]{2, 65253}, new char[]{2, 65257}, new char[]{1, 65261}, new char[]{1, 65263}, new char[]{2, 65265}, new char[]{5, 0}, new char[]{5, 0}, new char[]{5, 0}, new char[]{5, 0}, new char[]{5, 0}, new char[]{5, 0}, new char[]{5, 0}, new char[]{5, 0}, new char[]{5, 0}, new char[]{5, 0}, new char[]{5, 0}, new char[]{5, 0}, new char[]{5, 0}, new char[]{5, 0}, new char[]{5, 0}, new char[]{5, 0}, new char[]{5, 0}, new char[]{5, 0}, new char[]{5, 0}, new char[]{5, 0}, new char[]{5, 0}, new char[]{3, 0}, new char[]{3, 0}, new char[]{3, 0}, new char[]{3, 0}, new char[]{3, 0}, new char[]{3, 0}, new char[]{3, 0}, new char[]{3, 0}, new char[]{3, 0}, new char[]{3, 0}, new char[]{3, 0}, new char[]{3, 0}, new char[]{3, 0}, new char[]{3, 0}, new char[]{3, 0}, new char[]{3, 0}, new char[]{5, 0}, new char[]{1, 64336}, new char[]{3, 0}, new char[]{3, 0}, new char[]{3, 0}, new char[]{3, 0}, new char[]{3, 0}, new char[]{3, 0}, new char[]{3, 0}, new char[]{2, 64358}, new char[]{2, 64350}, new char[]{2, 64338}, new char[]{3, 0}, new char[]{3, 0}, new char[]{2, 64342}, new char[]{2, 64354}, new char[]{2, 64346}, new char[]{3, 0}, new char[]{3, 0}, new char[]{2, 64374}, new char[]{2, 64370}, new char[]{3, 0}, new char[]{2, 64378}, new char[]{2, 64382}, new char[]{1, 64392}, new char[]{3, 0}, new char[]{3, 0}, new char[]{3, 0}, new char[]{1, 64388}, new char[]{1, 64386}, new char[]{1, 64390}, new char[]{3, 0}, new char[]{3, 0}, new char[]{1, 64396}, new char[]{3, 0}, new char[]{3, 0}, new char[]{3, 0}, new char[]{3, 0}, new char[]{3, 0}, new char[]{3, 0}, new char[]{1, 64394}, new char[]{3, 0}, new char[]{3, 0}, new char[]{3, 0}, new char[]{3, 0}, new char[]{3, 0}, new char[]{3, 0}, new char[]{3, 0}, new char[]{3, 0}, new char[]{3, 0}, new char[]{3, 0}, new char[]{3, 0}, new char[]{2, 64362}, new char[]{3, 0}, new char[]{2, 64366}, new char[]{3, 0}, new char[]{3, 0}, new char[]{2, 64398}, new char[]{3, 0}, new char[]{3, 0}, new char[]{3, 0}, new char[]{2, 64467}, new char[]{3, 0}, new char[]{2, 64402}, new char[]{3, 0}, new char[]{2, 64410}, new char[]{3, 0}, new char[]{2, 64406}, new char[]{3, 0}, new char[]{3, 0}, new char[]{3, 0}, new char[]{3, 0}, new char[]{3, 0}, new char[]{3, 0}, new char[]{1, 64414}, new char[]{2, 64416}, new char[]{3, 0}, new char[]{3, 0}, new char[]{2, 64426}, new char[]{3, 0}, new char[]{1, 64420}, new char[]{2, 64422}, new char[]{3, 0}, new char[]{3, 0}, new char[]{3, 0}, new char[]{1, 64480}, new char[]{1, 64473}, new char[]{1, 64471}, new char[]{1, 64475}, new char[]{1, 64482}, new char[]{3, 0}, new char[]{1, 64478}, new char[]{2, 64508}, new char[]{3, 0}, new char[]{3, 0}, new char[]{3, 0}, new char[]{3, 0}, new char[]{3, 0}, new char[]{1, 64430}};
    }

    public GLLib(Object obj, Object obj2) {
        f150iT = this;
        f136iE = -1;
        f142iK = true;
        f143iL = (AbstractActivityC0092a) obj;
        f141iJ = (C0065n) obj2;
        m403aU();
        f188jf = new Hashtable();
        Hashtable hashtable = new Hashtable();
        f187je = hashtable;
        hashtable.put(new Integer(48), new Integer(6));
        f187je.put(new Integer(49), new Integer(7));
        f187je.put(new Integer(50), new Integer(1));
        f187je.put(new Integer(51), new Integer(9));
        f187je.put(new Integer(52), new Integer(3));
        f187je.put(new Integer(53), new Integer(5));
        f187je.put(new Integer(54), new Integer(4));
        f187je.put(new Integer(55), new Integer(13));
        f187je.put(new Integer(56), new Integer(2));
        f187je.put(new Integer(57), new Integer(15));
        f187je.put(new Integer(35), new Integer(17));
        f187je.put(new Integer(42), new Integer(16));
        if (C0338r.f2178mF) {
            f187je.put(new Integer(C0338r.f2179mG), new Integer(18));
            f187je.put(new Integer(C0338r.f2180mH), new Integer(19));
        } else {
            f187je.put(new Integer(C0338r.f2179mG), new Integer(19));
            f187je.put(new Integer(C0338r.f2180mH), new Integer(18));
        }
        f187je.put(new Integer(C0338r.f2186mN), new Integer(24));
        f188jf.put(new Integer(C0338r.f2181mI), new Integer(5));
        f188jf.put(new Integer(C0338r.f2182mJ), new Integer(1));
        f188jf.put(new Integer(C0338r.f2183mK), new Integer(2));
        f188jf.put(new Integer(C0338r.f2184mL), new Integer(3));
        f188jf.put(new Integer(C0338r.f2185mM), new Integer(4));
        f147iQ = System.currentTimeMillis();
        this.f302iN = f147iQ;
    }

    static final void m341B(String str) {
        f151iU = true;
        f152iV = str;
        if (C0338r.f2200mb) {
            new Thread(new RunnableC0290aq()).start();
        } else {
            m405aX();
        }
    }

    static void m342C(String str) {
        if (f198jp == null) {
            f198jp = f143iL == null ? null : f143iL.m214di("MIDlet-Name");
        }
        String str2 = f198jp;
    }

    private static InputStream m343D(String str) {
        "".getClass();
        return C0355i.getResourceAsStream(str);
    }

    static final void m344E(String str) {
        f267lG = str;
        f163jG = 1;
        if (f161jE == null || str == null || str.compareTo(f161jE) != 0) {
            m501j(true);
            f161jE = str;
            f164jH = null;
            f165jI = 0;
            f162jF = m345F(f161jE);
            f167jK = (short) m462bi();
            int m462bi = (short) m462bi();
            f169jM = m462bi;
            f170jN = new short[m462bi];
            for (int i = 0; i < f169jM; i++) {
                f170jN[i] = (short) m462bi();
            }
            f171jO = 0;
            m458be();
        }
    }

    private static InputStream m345F(String str) {
        if (f163jG == 3) {
            return new ByteArrayInputStream(f164jH, f165jI, f164jH.length - f165jI);
        }
        if (f163jG != 2) {
            if (f163jG == 1) {
                GLLib gLLib = f150iT;
                return m343D(str);
            }
            if (f163jG == 4) {
                try {
                    return new FileInputStream(new File(str));
                } catch (Exception e) {
                }
            }
        }
        return null;
    }

    static void m346G(String str) {
        if (f175jS == null) {
            InputStream inputStream = f162jF;
            f162jF = m345F(str);
            int m461bh = m461bh();
            f175jS = new byte[m461bh][];
            for (int i = 0; i < m461bh; i++) {
                int m461bh2 = m461bh();
                f175jS[i] = new byte[m461bh2];
                m366a(f175jS[i], 0, m461bh2);
            }
            try {
                f162jF.close();
            } catch (Exception e) {
            }
            f162jF = inputStream;
        }
    }

    public static String m347H(String str) {
        int indexOf = str.indexOf("://");
        if (indexOf != -1) {
            return str.substring(0, indexOf);
        }
        return null;
    }

    private static String m348I(String str) {
        if (m347H(str) != null) {
            str = m352M(str);
        }
        int indexOf = str.indexOf("/");
        if (indexOf != -1) {
            str = str.substring(0, indexOf);
        }
        return new StringBuffer().append(str).toString();
    }

    public static String m349J(String str) {
        String m348I = m348I(str);
        int indexOf = m348I.indexOf(":");
        return indexOf != -1 ? m348I.substring(0, indexOf) : m348I;
    }

    public static String m350K(String str) {
        if (m347H(str) != null) {
            str = m352M(str);
        }
        int indexOf = str.indexOf("/");
        if (indexOf != -1) {
            return str.substring(indexOf);
        }
        return null;
    }

    public static String m351L(String str) {
        String m348I = m348I(str);
        int indexOf = m348I.indexOf(":");
        if (indexOf != -1) {
            return m348I.substring(indexOf + 1, m348I.length());
        }
        return null;
    }

    private static String m352M(String str) {
        return str.substring(m347H(str).length() + 3);
    }

    private static void m353N(String str) {
        f229kU = C0100b.m227g(str, true);
    }

    static byte[] m354O(String str) {
        byte[] bArr = null;
        if (!"".equals("") && "" != 0) {
            bArr = "".getBytes();
        }
        return m443b(str, bArr);
    }

    public static byte[] m355P(String str) {
        int i;
        int i2;
        char c;
        int length = str.length();
        if (!m478by()) {
            m479bz();
        }
        int i3 = (length / 4) * 3;
        if (str.charAt((length + 0) - 1) == '=') {
            i3--;
            if (str.charAt((length + 0) - 2) == '=') {
                i3--;
            }
        }
        byte[] bArr = new byte[i3];
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5 += 4) {
            char charAt = str.charAt(i5 + 0);
            char charAt2 = str.charAt(i5 + 0 + 1);
            char charAt3 = str.charAt(i5 + 0 + 2);
            char charAt4 = str.charAt(i5 + 0 + 3);
            int i6 = f263lC[charAt & 127];
            int i7 = f263lC[charAt2 & 127];
            if (charAt4 == '=') {
                c = 1;
                if (charAt3 == '=') {
                    c = 2;
                    i2 = 0;
                    i = 0;
                } else {
                    i = f263lC[charAt3 & 127];
                    i2 = 0;
                }
            } else {
                i = f263lC[charAt3 & 127];
                i2 = f263lC[charAt4 & 127];
                c = 0;
            }
            bArr[i4] = (byte) (((i6 << 2) & 252) | ((i7 >>> 4) & 3));
            if (c < 2) {
                bArr[i4 + 1] = (byte) (((i7 << 4) & 240) | ((i >>> 2) & 15));
                if (c <= 0) {
                    bArr[i4 + 2] = (byte) ((i2 & 63) | ((i << 6) & 192));
                }
            }
            i4 += 3;
        }
        return bArr;
    }

    protected static int Pointer_GetNumPointers() {
        return C0338r.f2456rX;
    }

    protected static void Pointer_SetCurrentPointer(int i) {
        if (!C0338r.f2455rW || C0338r.f2456rX <= 1 || i >= C0338r.f2456rX) {
            return;
        }
        f292lq = i;
    }

    static void m356Q(String str) {
        if (C0338r.f2518sh) {
            C0463b.m2507bn(str);
        }
    }

    static int m357R(String str) {
        return C0338r.f2518sh ? C0463b.m2504ah(str) : C0288ao.m727ah(str);
    }

    static void SetAndroidCanvas(Canvas canvas) {
    }

    private static byte m358V(int i) {
        Integer num = new Integer(i);
        if (f187je == null) {
            return (byte) 0;
        }
        Integer num2 = (Integer) f187je.get(num);
        if (num2 != null) {
            return num2.byteValue();
        }
        Integer num3 = (Integer) f188jf.get(num);
        if (num3 != null) {
            return num3.byteValue();
        }
        return (byte) 0;
    }

    static int m359W(int i) {
        if (i < 0) {
            i = -i;
        }
        int i2 = (f158jB - 1) & i;
        if (i2 <= f207jy) {
            return f204jv[i2];
        }
        if (i2 < f208jz) {
            return -f204jv[f208jz - i2];
        }
        if (i2 <= f157jA) {
            return -f204jv[i2 - f208jz];
        }
        return f204jv[f158jB - i2];
    }

    static int m360X(int i) {
        if (i >= 65536) {
            return i >= 16777216 ? i >= 268435456 ? i >= 1073741824 ? f205jw[i >> 24] << 8 : f205jw[i >> 22] << 7 : i >= 67108864 ? f205jw[i >> 20] << 6 : f205jw[i >> 18] << 5 : i >= 1048576 ? i >= 4194304 ? f205jw[i >> 16] << 4 : f205jw[i >> 14] << 3 : i >= 262144 ? f205jw[i >> 12] << 2 : f205jw[i >> 10] << 1;
        }
        if (i >= 256) {
            return i >= 4096 ? i >= 16384 ? f205jw[i >> 8] : f205jw[i >> 6] >> 1 : i >= 1024 ? f205jw[i >> 4] >> 2 : f205jw[i >> 2] >> 3;
        }
        if (i >= 0) {
            return f205jw[i] >> 4;
        }
        return 0;
    }

    static int m361Y(int i) {
        int i2 = 0;
        while ((1 << i2) < i) {
            i2++;
        }
        return 1 << i2;
    }

    private static int m362Z(int i) {
        int i2 = f169jM - 1;
        while (i2 >= 0 && f170jN[i2] > i) {
            i2--;
        }
        if (f171jO != i2) {
            f171jO = i2;
            m501j(false);
            if (f171jO == 0) {
                String str = f161jE;
                f161jE = null;
                m344E(str);
            } else {
                f162jF = m345F(new StringBuffer().append(f161jE).append(".").append(f171jO).toString());
                m458be();
            }
        } else if (f162jF == null) {
            if (f171jO == 0) {
                String str2 = f161jE;
                f161jE = null;
                m344E(str2);
            } else {
                f162jF = m345F(new StringBuffer().append(f161jE).append(".").append(f171jO).toString());
            }
        }
        int i3 = i - f170jN[f171jO];
        int i4 = f168jL[i3];
        int i5 = f168jL[i3 + 1] - i4;
        if (f166jJ != i4) {
            if (f166jJ > i4) {
                m459bf();
                if (f171jO == 0) {
                    f162jF = m345F(f161jE);
                } else {
                    f162jF = m345F(new StringBuffer().append(f161jE).append(".").append(f171jO).toString());
                }
            } else {
                i4 -= f166jJ;
            }
            m409ab(i4);
        }
        f173jQ = false;
        if (i5 <= 0) {
            return i5;
        }
        f172jP = m461bh() & 255;
        return i5 - 1;
    }

    static int m363a(int i, C0286am c0286am) {
        return i;
    }

    private static int m364a(InputStream inputStream, byte[] bArr, int i, int i2) {
        int i3 = 0;
        int i4 = i2;
        while (i4 > 0) {
            try {
                int read = inputStream.read(bArr, i3, i4);
                i4 -= read;
                i3 += read;
            } catch (Exception e) {
            }
        }
        f259ky += i2;
        return i2;
    }

    static int m365a(byte[] bArr, int i, byte b2) {
        int i2 = i + 1;
        bArr[i] = b2;
        return i2;
    }

    private static int m366a(byte[] bArr, int i, int i2) {
        int i3 = 0;
        int i4 = i2;
        while (i4 > 0) {
            try {
                int read = f162jF.read(bArr, i3, i4);
                i4 -= read;
                i3 += read;
            } catch (Exception e) {
            }
        }
        f166jJ += i2;
        return i2;
    }

    static int m367a(byte[] bArr, int i, int i2, int i3) {
        int i4 = -1;
        while (true) {
            int i5 = i2 - 1;
            if (i2 == 0) {
                return i4 ^ (-1);
            }
            i4 = (i4 >>> 8) ^ f217kI[(bArr[i] ^ i4) & 255];
            i2 = i5;
            i++;
        }
    }

    static int m368a(byte[] bArr, int i, long j) {
        int i2 = i + 1;
        bArr[i] = (byte) (j & 255);
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((j >>> 8) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((j >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((j >>> 24) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((j >>> 32) & 255);
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((j >>> 40) & 255);
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((j >>> 48) & 255);
        int i9 = i8 + 1;
        bArr[i8] = (byte) ((j >>> 56) & 255);
        return i9;
    }

    static int m369a(byte[] bArr, int i, short s) {
        int i2 = i + 1;
        bArr[i] = (byte) s;
        int i3 = i2 + 1;
        bArr[i2] = (byte) (s >>> 8);
        return i3;
    }

    private static Object m370a(InputStream inputStream) {
        Object[] objArr;
        int i = 0;
        try {
            int m430b = m430b(inputStream);
            int i2 = m430b >> 4;
            int i3 = m430b & 7;
            int m480c = (m430b & 8) != 0 ? m480c(inputStream) : m430b(inputStream);
            switch (i3) {
                case 0:
                    byte[] bArr = new byte[m480c];
                    while (i < m480c) {
                        bArr[i] = (byte) m430b(inputStream);
                        i++;
                    }
                    return bArr;
                case 1:
                    short[] sArr = new short[m480c];
                    if (i2 == 0) {
                        while (i < m480c) {
                            sArr[i] = (byte) m430b(inputStream);
                            i++;
                        }
                        return sArr;
                    }
                    while (i < m480c) {
                        sArr[i] = (short) m480c(inputStream);
                        i++;
                    }
                    return sArr;
                case 2:
                    int[] iArr = new int[m480c];
                    if (i2 == 0) {
                        while (i < m480c) {
                            iArr[i] = (byte) m430b(inputStream);
                            i++;
                        }
                        return iArr;
                    }
                    if (i2 == 1) {
                        while (i < m480c) {
                            iArr[i] = (short) m480c(inputStream);
                            i++;
                        }
                        return iArr;
                    }
                    while (i < m480c) {
                        iArr[i] = m490d(inputStream);
                        i++;
                    }
                    return iArr;
                default:
                    switch (i3 & 3) {
                        case 0:
                            if (i2 != 2) {
                                objArr = new byte[m480c][][];
                                break;
                            } else {
                                objArr = new byte[m480c][];
                                break;
                            }
                        case 1:
                            if (i2 != 2) {
                                objArr = new short[m480c][][];
                                break;
                            } else {
                                objArr = new short[m480c][];
                                break;
                            }
                        default:
                            if (i2 != 2) {
                                objArr = new int[m480c][][];
                                break;
                            } else {
                                objArr = new int[m480c][];
                                break;
                            }
                    }
                    while (i < m480c) {
                        objArr[i] = m370a(inputStream);
                        i++;
                    }
                    return objArr;
            }
        } catch (Exception e) {
            return null;
        }
    }

    static String m371a(long j, int i, String str) {
        long j2;
        long j3;
        String stringBuffer;
        if (j < 1000) {
            return new StringBuffer().append(j).toString();
        }
        switch (i) {
            case 0:
            case 7:
            case WorkQueue.DEFAULT_MAX_CONCURRENT:
            case 9:
            case 15:
            case 17:
                str = ",";
                String str2 = "";
                j2 = j % 1000 < 0 ? -(j % 1000) : j % 1000;
                j3 = j / 1000;
                while (true) {
                    if (j2 != 0 && j3 == 0) {
                        break;
                    } else {
                        if (j2 < 10) {
                            StringBuffer stringBuffer2 = new StringBuffer("00");
                            if (j2 < 0) {
                                j2 = -j2;
                            }
                            stringBuffer = stringBuffer2.append(j2).append(str2).toString();
                        } else if (j2 < 100) {
                            StringBuffer stringBuffer3 = new StringBuffer("0");
                            if (j2 < 0) {
                                j2 = -j2;
                            }
                            stringBuffer = stringBuffer3.append(j2).append(str2).toString();
                        } else {
                            StringBuffer stringBuffer4 = new StringBuffer();
                            if (j2 < 0) {
                                j2 = -j2;
                            }
                            stringBuffer = stringBuffer4.append(j2).append(str2).toString();
                        }
                        long j4 = j3 % 1000;
                        j3 /= 1000;
                        if (j3 != 0) {
                            str2 = new StringBuffer().append(str).append(stringBuffer).toString();
                            j2 = j4;
                        } else if (j4 != 0) {
                            str2 = new StringBuffer().append(j4).append(str).append(stringBuffer).toString();
                            j2 = 0;
                        } else {
                            str2 = stringBuffer;
                            j2 = j4;
                        }
                    }
                }
                break;
            case 1:
            case 3:
            case C0217R.styleable.com_facebook_picker_fragment_title_bar_background:
            case 16:
                str = ".";
                String str22 = "";
                if (j % 1000 < 0) {
                }
                j3 = j / 1000;
                while (true) {
                    if (j2 != 0) {
                        break;
                    }
                    if (j2 < 10) {
                    }
                    long j42 = j3 % 1000;
                    j3 /= 1000;
                    if (j3 != 0) {
                    }
                }
                break;
            case 11:
            case 14:
                if (j >= 10000) {
                    str = ".";
                    String str222 = "";
                    if (j % 1000 < 0) {
                    }
                    j3 = j / 1000;
                    while (true) {
                        if (j2 != 0) {
                        }
                        if (j2 < 10) {
                        }
                        long j422 = j3 % 1000;
                        j3 /= 1000;
                        if (j3 != 0) {
                        }
                    }
                }
                str = "";
                String str2222 = "";
                if (j % 1000 < 0) {
                }
                j3 = j / 1000;
                while (true) {
                    if (j2 != 0) {
                    }
                    if (j2 < 10) {
                    }
                    long j4222 = j3 % 1000;
                    j3 /= 1000;
                    if (j3 != 0) {
                    }
                }
                break;
            case 12:
            case 13:
                String str22222 = "";
                if (j % 1000 < 0) {
                }
                j3 = j / 1000;
                while (true) {
                    if (j2 != 0) {
                    }
                    if (j2 < 10) {
                    }
                    long j42222 = j3 % 1000;
                    j3 /= 1000;
                    if (j3 != 0) {
                    }
                }
                break;
        }
        return new StringBuffer().append(j).toString();
    }

    static String m372a(String str, String[] strArr) {
        int i = 0;
        String str2 = "";
        if (str.indexOf(37) < 0) {
            return str;
        }
        int i2 = 0;
        do {
            int indexOf = str.indexOf(37, i2);
            if (indexOf < 0 || indexOf == str.length() - 1) {
                str2 = new StringBuffer().append(str2).append(str.substring(i)).toString();
                i2 = -1;
            } else if (str.charAt(indexOf + 1) == 's') {
                int charAt = indexOf + 2 < str.length() ? str.charAt(indexOf + 2) - '0' : -1;
                if (charAt < 0 || charAt > 9) {
                    i2 = indexOf + 1;
                } else {
                    str2 = new StringBuffer().append(new StringBuffer().append(str2).append(str.substring(i, indexOf)).toString()).append(strArr[charAt]).toString();
                    i = indexOf + 3;
                    i2 = i;
                }
            } else {
                i2 = indexOf + 1;
            }
        } while (i2 >= 0);
        return str2;
    }

    static String m373a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer(bArr.length << 1);
        for (int i = 0; i < bArr.length; i++) {
            stringBuffer.append(f260kz[(bArr[i] >> 4) & 15]);
            stringBuffer.append(f260kz[bArr[i] & 15]);
        }
        return stringBuffer.toString();
    }

    private static void m374a(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        m375a(f, f2, f3, f4, f5, f6, f7, f8, false);
    }

    private static void m375a(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, boolean z) {
        float f9;
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        int i = f180jX * f179jW;
        if (f179jW != 4) {
            int i2 = i + 1;
            f241kg[i] = f;
            int i3 = i2 + 1;
            f241kg[i2] = f2;
            int i4 = i3 + 1;
            f241kg[i3] = f3;
            int i5 = i4 + 1;
            f241kg[i4] = f4;
            int i6 = i5 + 1;
            f241kg[i5] = f7;
            int i7 = i6 + 1;
            f241kg[i6] = f8;
            int i8 = i7 + 1;
            f241kg[i7] = f3;
            int i9 = i8 + 1;
            f241kg[i8] = f4;
            int i10 = i9 + 1;
            f241kg[i9] = f5;
            int i11 = i10 + 1;
            f241kg[i10] = f6;
            f241kg[i11] = f7;
            f241kg[i11 + 1] = f8;
            return;
        }
        float f15 = 1.0f;
        float f16 = 1.0f;
        if (z) {
            if (f - f7 == 0.0f) {
                f += 1.0f;
            }
            if (f4 - f2 == 0.0f) {
                f4 += 1.0f;
            }
            f16 = (f3 - f5) / (f - f7);
            f10 = (f6 - f8) / (f4 - f2);
            f9 = f16 * f10;
            f11 = f * f9;
            f12 = f2 * f9;
            f13 = f3 * f10;
            f14 = f4 * f10;
            f7 *= f16;
            f8 *= f16;
        } else {
            if (f3 - f == 0.0f) {
                f3 += 1.0f;
            }
            if (f6 - f4 == 0.0f) {
                f6 += 1.0f;
            }
            f9 = (f5 - f7) / (f3 - f);
            f15 = (f8 - f2) / (f6 - f4);
            f10 = f9 * f15;
            f11 = f * f9;
            f12 = f2 * f9;
            f13 = f3 * f10;
            f14 = f4 * f10;
            f5 *= f15;
            f6 *= f15;
        }
        int i12 = i + 1;
        f241kg[i] = f11;
        int i13 = i12 + 1;
        f241kg[i12] = f12;
        int i14 = i13 + 1;
        f241kg[i13] = 0.0f;
        int i15 = i14 + 1;
        f241kg[i14] = f9;
        int i16 = i15 + 1;
        f241kg[i15] = f13;
        int i17 = i16 + 1;
        f241kg[i16] = f14;
        int i18 = i17 + 1;
        f241kg[i17] = 0.0f;
        int i19 = i18 + 1;
        f241kg[i18] = f10;
        int i20 = i19 + 1;
        f241kg[i19] = f7;
        int i21 = i20 + 1;
        f241kg[i20] = f8;
        int i22 = i21 + 1;
        f241kg[i21] = 0.0f;
        int i23 = i22 + 1;
        f241kg[i22] = f16;
        int i24 = i23 + 1;
        f241kg[i23] = f13;
        int i25 = i24 + 1;
        f241kg[i24] = f14;
        int i26 = i25 + 1;
        f241kg[i25] = 0.0f;
        int i27 = i26 + 1;
        f241kg[i26] = f10;
        int i28 = i27 + 1;
        f241kg[i27] = f5;
        int i29 = i28 + 1;
        f241kg[i28] = f6;
        int i30 = i29 + 1;
        f241kg[i29] = 0.0f;
        int i31 = i30 + 1;
        f241kg[i30] = f15;
        int i32 = i31 + 1;
        f241kg[i31] = f7;
        int i33 = i32 + 1;
        f241kg[i32] = f8;
        f241kg[i33] = 0.0f;
        f241kg[i33 + 1] = f16;
    }

    private static void m376a(float f, float f2, float f3, float f4, int i) {
        switch (i) {
            case 1:
                m374a(f, f2 + f4, f + f3, f2 + f4, f + f3, f2, f, f2);
                break;
            case 2:
                m374a(f + f3, f2, f, f2, f, f2 + f4, f + f3, f2 + f4);
                break;
            case 3:
                m374a(f + f3, f2 + f4, f, f2 + f4, f, f2, f + f3, f2);
                break;
            case C0217R.styleable.com_facebook_picker_fragment_done_button_text:
                m374a(f, f2, f, f2 + f3, f + f4, f2 + f3, f + f4, f2);
                break;
            case C0217R.styleable.com_facebook_picker_fragment_title_bar_background:
                m374a(f + f4, f2, f + f4, f2 + f3, f, f2 + f3, f, f2);
                break;
            case C0217R.styleable.com_facebook_picker_fragment_done_button_background:
                m374a(f, f2 + f3, f, f2, f + f4, f2, f + f4, f2 + f3);
                break;
            case 7:
                m374a(f + f4, f2 + f3, f + f4, f2, f, f2, f, f2 + f3);
                break;
            default:
                m374a(f, f2, f + f3, f2, f + f3, f2 + f4, f, f2 + f4);
                break;
        }
    }

    private static void m377a(float f, float f2, float f3, float f4, int i, int i2, boolean z) {
        float f5 = f + (f3 / 2.0f);
        float f6 = f2 + (f4 / 2.0f);
        float f7 = f3 / 2.0f;
        float f8 = f4 / 2.0f;
        int i3 = f180jX << 1;
        float f9 = 0.0f;
        float f10 = 0.0f;
        int i4 = 0;
        while (i4 <= i2) {
            float f11 = ((i + i4) * f159jC) / 180.0f;
            if (z && i4 > 0) {
                int i5 = i3 + 1;
                f241kg[i3] = f5;
                i3 = i5 + 1;
                f241kg[i5] = f6;
            }
            if (i4 > 1) {
                int i6 = i3 + 1;
                f241kg[i3] = f9;
                i3 = i6 + 1;
                f241kg[i6] = f10;
            }
            f9 = f5 + (((float) Math.cos(f11)) * f7);
            f10 = f6 - (((float) Math.sin(f11)) * f8);
            int i7 = i3 + 1;
            f241kg[i3] = f9;
            f241kg[i7] = f10;
            i4++;
            i3 = i7 + 1;
        }
    }

    public static void m378a(float f, float f2, boolean z) {
        f250kp = f / 100.0f;
        f251kq = f2 / 100.0f;
        f252kr = z;
    }

    private static void m379a(int i, int i2, float f, float f2, float f3, float f4) {
        int i3 = f180jX << 1;
        int i4 = i3 + 1;
        f243ki[i3] = f / i;
        int i5 = i4 + 1;
        f243ki[i4] = f2 / i2;
        int i6 = i5 + 1;
        f243ki[i5] = (f + f3) / i;
        int i7 = i6 + 1;
        f243ki[i6] = f2 / i2;
        int i8 = i7 + 1;
        f243ki[i7] = f / i;
        int i9 = i8 + 1;
        f243ki[i8] = (f2 + f4) / i2;
        int i10 = i9 + 1;
        f243ki[i9] = (f + f3) / i;
        int i11 = i10 + 1;
        f243ki[i10] = f2 / i2;
        int i12 = i11 + 1;
        f243ki[i11] = (f + f3) / i;
        int i13 = i12 + 1;
        f243ki[i12] = (f2 + f4) / i2;
        f243ki[i13] = f / i;
        f243ki[i13 + 1] = (f2 + f4) / i2;
    }

    static final void m380a(int i, int i2, int i3, int i4) {
        f238kd += f236kb;
        f239ke += f237kc;
        f236kb = Math.max(f236kb, i);
        f237kc = Math.max(f237kc, i2);
        f238kd = Math.min(f238kd, i3 + i);
        f239ke = Math.min(f239ke, i4 + i2);
        f238kd -= f236kb;
        int i5 = f239ke - f237kc;
        f239ke = i5;
        if (i5 < 0 || f238kd < 0) {
            m484c(0, 0, 0, 0);
        } else {
            m484c(f236kb, f237kc, f238kd, f239ke);
        }
    }

    static void m381a(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8 = i7 * i7;
        int i9 = f199jq - i7;
        int i10 = i9 * i9;
        int i11 = i9 * i7;
        f202jt = (((i * i10) + ((i3 * 2) * i11)) + (i5 * i8)) / (1 << (C0338r.f2195mW << 1));
        int i12 = i8 * i6;
        f203ju = (i12 + ((i11 * (i4 * 2)) + (i10 * i2))) / (1 << (C0338r.f2195mW << 1));
    }

    static final void m382a(C0048ac c0048ac, float f, float f2, float f3, float f4) {
        m387a(c0048ac, 0, 2);
        if (f180jX + 2 > C0338r.f2218mt) {
            m465bl();
        }
        int i = f180jX << 1;
        int i2 = i + 1;
        f241kg[i] = f;
        int i3 = i2 + 1;
        f241kg[i2] = f2;
        f241kg[i3] = f3;
        f241kg[i3 + 1] = f4;
        m414ag(2);
        f180jX += 2;
    }

    static final void m383a(C0048ac c0048ac, float f, float f2, float f3, float f4, float f5, float f6) {
        m387a(c0048ac, 1, 2);
        if (f180jX + 3 > C0338r.f2218mt) {
            m465bl();
        }
        int i = f180jX << 1;
        int i2 = i + 1;
        f241kg[i] = f;
        int i3 = i2 + 1;
        f241kg[i2] = f2;
        int i4 = i3 + 1;
        f241kg[i3] = f3;
        int i5 = i4 + 1;
        f241kg[i4] = f4;
        f241kg[i5] = f5;
        f241kg[i5 + 1] = f6;
        m414ag(3);
        f180jX += 3;
        if (C0338r.f2206mh) {
            m382a(c0048ac, f, f2, f3, f4);
            m382a(c0048ac, f, f2, f5, f6);
            m382a(c0048ac, f5, f6, f3, f4);
        }
    }

    static final void m384a(C0048ac c0048ac, float f, float f2, float f3, float f4, int i, int i2) {
        int i3 = ((i % 360) + 360) % 360;
        int i4 = i2 % 360 == 0 ? 360 : ((i2 % 360) + 360) % 360;
        m387a(c0048ac, 1, 2);
        if (f180jX + (i4 * 3) > C0338r.f2218mt) {
            m465bl();
        }
        m377a(f, f2, f3, f4, i3, i4, true);
        m414ag(i4 * 3);
        f180jX += i4 * 3;
    }

    static void m385a(C0048ac c0048ac, float f, float f2, float f3, float f4, int i, int i2, int i3) {
        m386a(c0048ac, f, f2, f3, f4, i, i2, i3, false);
    }

    private static void m386a(C0048ac c0048ac, float f, float f2, float f3, float f4, int i, int i2, int i3, boolean z) {
        m387a(c0048ac, 1, 2);
        if (f180jX + 6 > C0338r.f2218mt) {
            m465bl();
        }
        if (!z) {
            i |= -16777216;
            i2 |= -16777216;
        }
        m376a(f, f2, f3, f4, 0);
        if (i3 == 8 || i3 == 32) {
            int i4 = i;
            i = i2;
            i2 = i4;
        }
        switch (i3) {
            case C0217R.styleable.com_facebook_picker_fragment_done_button_text:
            case WorkQueue.DEFAULT_MAX_CONCURRENT:
                m413af(i2);
                m414ag(1);
                f180jX++;
                m413af(i);
                m414ag(1);
                f180jX++;
                m413af(i2);
                m414ag(1);
                f180jX++;
                m413af(i);
                m414ag(2);
                f180jX += 2;
                m413af(i2);
                m414ag(1);
                f180jX++;
                break;
            case 16:
            case 32:
                m413af(i2);
                m414ag(2);
                f180jX += 2;
                m413af(i);
                m414ag(1);
                f180jX++;
                m413af(i2);
                m414ag(1);
                f180jX++;
                m413af(i);
                m414ag(2);
                f180jX += 2;
                break;
            default:
                f180jX += 6;
                break;
        }
    }

    private static void m387a(C0048ac c0048ac, int i, int i2) {
        if (f177jU != i || f179jW != i2) {
            m465bl();
        }
        if (f177jU != i) {
            switch (i) {
                case 0:
                case 1:
                    m464bk();
                    GLES10.glDisableClientState(32888);
                    GLES10.glEnableClientState(32886);
                    break;
                case 2:
                    GLES10.glDisableClientState(32886);
                    GLES10.glEnableClientState(32888);
                    break;
            }
        }
        f177jU = i;
        f179jW = i2;
    }

    public static void m388a(C0048ac c0048ac, C0277ad c0277ad, int i, int i2, int i3, int i4, int i5, float f, float f2, int i6) {
        float f3;
        float f4;
        if (i3 <= 0 || i4 <= 0) {
            return;
        }
        m387a(c0048ac, 2, 2);
        c0277ad.m682cd();
        if ((f181jY != c0277ad && f181jY != null) || f180jX + 6 > C0338r.f2218mt) {
            m465bl();
        }
        f181jY = c0277ad;
        int i7 = c0277ad.f496vM;
        int i8 = c0277ad.f497vN;
        if (f252kr) {
            f *= f250kp;
            f2 *= f251kq;
        }
        float f5 = i3;
        float f6 = i4;
        if (i5 <= 3) {
            f3 = f250kp * f5;
            f4 = f251kq * f6;
        } else {
            f3 = f251kq * f5;
            f4 = f250kp * f6;
        }
        m376a(f, f2, f3, f4, i5);
        m379a(i7, i8, i, i2, i3, i4);
        if (C0338r.f2439rG) {
            if ((f233kY & 262144) != 0) {
                int i9 = (f234kZ[18][6] * 360) >> C0338r.f2196mX;
                float m475bv = ((f234kZ[18][7] * m475bv()) / 100.0f) + f;
                float m476bw = ((f234kZ[18][8] * m476bw()) / 100.0f) + f2;
                int i10 = f180jX << 1;
                float f7 = (i9 * f159jC) / 180.0f;
                float sin = (float) Math.sin(f7);
                float cos = (float) Math.cos(f7);
                for (int i11 = i10; i11 < i10 + 12; i11 += 2) {
                    float f8 = f241kg[i11] - m475bv;
                    float f9 = f241kg[i11 + 1] - m476bw;
                    f241kg[i11] = ((f8 * cos) - (f9 * sin)) + m475bv;
                    f241kg[i11 + 1] = (f8 * sin) + (f9 * cos) + m476bw;
                }
            }
        }
        m414ag(6);
        f180jX += 6;
    }

    static final void m389a(C0048ac c0048ac, int[] iArr, int i, int i2, int i3, int i4, int i5, int i6, boolean z) {
        C0277ad m679b = C0277ad.m679b(iArr, i2, i6);
        m388a(c0048ac, m679b, 0, 0, i5, i6, 0, i3, i4, 20);
        m465bl();
        m679b.m681cc();
    }

    static void m390a(Object obj, int i, Object obj2, int i2, int i3) {
        System.arraycopy(obj, i, obj2, i2, i3);
    }

    static final void m391a(String str, int i, int i2, int i3) {
        try {
            int m168df = f134iC.m117ur().m168df(str);
            int height = f134iC.m117ur().getHeight();
            int m361Y = m361Y(m168df);
            int m361Y2 = m361Y(height);
            C0051af m121aX = C0051af.m121aX(m361Y, m361Y2);
            C0048ac m125cb = m121aX.m125cb();
            m125cb.m114a(f134iC.m117ur());
            m125cb.m116t(f246kl, f247km, f248kn);
            m125cb.m115b(str, 0, 0, 20);
            int[] m614a = C0271a.m614a(null);
            m121aX.m124a(m614a, 0, m361Y, 0, 0, m361Y, m361Y2);
            m389a(f134iC, m614a, 0, m361Y, (i3 & 1) != 0 ? i - (m168df / 2) : (i3 & 8) != 0 ? i - m168df : i, (i3 & 2) != 0 ? i2 - (height / 2) : (i3 & 32) != 0 ? i2 - height : i2, m361Y, m361Y2, true);
        } catch (Exception e) {
        }
    }

    static void m392a(String str, long j, long j2) {
        if (C0338r.f2518sh) {
            return;
        }
        C0288ao.m739b(str, 0L, 0L);
    }

    private static void m393a(String str, byte[] bArr, int i, int i2, byte[] bArr2) {
        m353N(str);
        if (f229kU.m235uD() > 0) {
            f229kU.m231b(1, bArr, i, i2);
        } else {
            f229kU.m232e(bArr, i, i2);
        }
        m474bu();
    }

    public static void m394a(boolean z, int i, int i2) {
        Integer num = new Integer(i);
        Hashtable hashtable = f187je;
        if (((Integer) hashtable.get(num)) != null) {
            hashtable.remove(num);
        }
        hashtable.put(num, new Integer(i2));
    }

    private static void m395a(byte[] bArr, int[] iArr, long[] jArr, byte[] bArr2, int i, int i2) {
        int i3 = 0;
        if (i2 > bArr2.length) {
            i2 = bArr2.length;
        }
        int i4 = (int) (jArr[0] & 63);
        jArr[0] = jArr[0] + i2;
        int i5 = 64 - i4;
        if (i2 >= i5) {
            int[] iArr2 = new int[16];
            if (i5 == 64) {
                i5 = 0;
            } else {
                for (int i6 = 0; i6 < i5; i6++) {
                    bArr[i6 + i4] = bArr2[i6];
                }
                m396a(iArr, bArr, 0, iArr2);
            }
            while (i5 + 63 < i2) {
                m396a(iArr, bArr2, i5, iArr2);
                i5 += 64;
            }
            i4 = 0;
            i3 = i5;
        }
        if (i3 < i2) {
            for (int i7 = i3; i7 < i2; i7++) {
                bArr[(i4 + i7) - i3] = bArr2[i7];
            }
        }
    }

    private static void m396a(int[] iArr, byte[] bArr, int i, int[] iArr2) {
        int i2 = iArr[0];
        int i3 = iArr[1];
        int i4 = iArr[2];
        int i5 = iArr[3];
        iArr2[0] = (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | (bArr[i + 3] << 24);
        iArr2[1] = (bArr[i + 4] & 255) | ((bArr[i + 5] & 255) << 8) | ((bArr[i + 6] & 255) << 16) | (bArr[i + 7] << 24);
        iArr2[2] = (bArr[i + 8] & 255) | ((bArr[i + 9] & 255) << 8) | ((bArr[i + 10] & 255) << 16) | (bArr[i + 11] << 24);
        iArr2[3] = (bArr[i + 12] & 255) | ((bArr[i + 13] & 255) << 8) | ((bArr[i + 14] & 255) << 16) | (bArr[i + 15] << 24);
        iArr2[4] = (bArr[i + 16] & 255) | ((bArr[i + 17] & 255) << 8) | ((bArr[i + 18] & 255) << 16) | (bArr[i + 19] << 24);
        iArr2[5] = (bArr[i + 20] & 255) | ((bArr[i + 21] & 255) << 8) | ((bArr[i + 22] & 255) << 16) | (bArr[i + 23] << 24);
        iArr2[6] = (bArr[i + 24] & 255) | ((bArr[i + 25] & 255) << 8) | ((bArr[i + 26] & 255) << 16) | (bArr[i + 27] << 24);
        iArr2[7] = (bArr[i + 28] & 255) | ((bArr[i + 29] & 255) << 8) | ((bArr[i + 30] & 255) << 16) | (bArr[i + 31] << 24);
        iArr2[8] = (bArr[i + 32] & 255) | ((bArr[i + 33] & 255) << 8) | ((bArr[i + 34] & 255) << 16) | (bArr[i + 35] << 24);
        iArr2[9] = (bArr[i + 36] & 255) | ((bArr[i + 37] & 255) << 8) | ((bArr[i + 38] & 255) << 16) | (bArr[i + 39] << 24);
        iArr2[10] = (bArr[i + 40] & 255) | ((bArr[i + 41] & 255) << 8) | ((bArr[i + 42] & 255) << 16) | (bArr[i + 43] << 24);
        iArr2[11] = (bArr[i + 44] & 255) | ((bArr[i + 45] & 255) << 8) | ((bArr[i + 46] & 255) << 16) | (bArr[i + 47] << 24);
        iArr2[12] = (bArr[i + 48] & 255) | ((bArr[i + 49] & 255) << 8) | ((bArr[i + 50] & 255) << 16) | (bArr[i + 51] << 24);
        iArr2[13] = (bArr[i + 52] & 255) | ((bArr[i + 53] & 255) << 8) | ((bArr[i + 54] & 255) << 16) | (bArr[i + 55] << 24);
        iArr2[14] = (bArr[i + 56] & 255) | ((bArr[i + 57] & 255) << 8) | ((bArr[i + 58] & 255) << 16) | (bArr[i + 59] << 24);
        iArr2[15] = (bArr[i + 60] & 255) | ((bArr[i + 61] & 255) << 8) | ((bArr[i + 62] & 255) << 16) | (bArr[i + 63] << 24);
        int i6 = i2 + ((((i3 & i4) | ((i3 ^ (-1)) & i5)) + iArr2[0]) - 680876936);
        int i7 = ((i6 >>> 25) | (i6 << 7)) + i3;
        int i8 = i5 + ((((i7 & i3) | ((i7 ^ (-1)) & i4)) + iArr2[1]) - 389564586);
        int i9 = ((i8 >>> 20) | (i8 << 12)) + i7;
        int i10 = i4 + ((i9 & i7) | ((i9 ^ (-1)) & i3)) + iArr2[2] + 606105819;
        int i11 = ((i10 >>> 15) | (i10 << 17)) + i9;
        int i12 = i3 + ((((i11 & i9) | ((i11 ^ (-1)) & i7)) + iArr2[3]) - 1044525330);
        int i13 = ((i12 >>> 10) | (i12 << 22)) + i11;
        int i14 = i7 + ((((i13 & i11) | ((i13 ^ (-1)) & i9)) + iArr2[4]) - 176418897);
        int i15 = ((i14 >>> 25) | (i14 << 7)) + i13;
        int i16 = i9 + ((i15 & i13) | ((i15 ^ (-1)) & i11)) + iArr2[5] + 1200080426;
        int i17 = ((i16 >>> 20) | (i16 << 12)) + i15;
        int i18 = i11 + ((((i17 & i15) | ((i17 ^ (-1)) & i13)) + iArr2[6]) - 1473231341);
        int i19 = ((i18 >>> 15) | (i18 << 17)) + i17;
        int i20 = i13 + ((((i19 & i17) | ((i19 ^ (-1)) & i15)) + iArr2[7]) - 45705983);
        int i21 = ((i20 >>> 10) | (i20 << 22)) + i19;
        int i22 = i15 + ((i21 & i19) | ((i21 ^ (-1)) & i17)) + iArr2[8] + 1770035416;
        int i23 = ((i22 >>> 25) | (i22 << 7)) + i21;
        int i24 = i17 + ((((i23 & i21) | ((i23 ^ (-1)) & i19)) + iArr2[9]) - 1958414417);
        int i25 = ((i24 >>> 20) | (i24 << 12)) + i23;
        int i26 = i19 + ((((i25 & i23) | ((i25 ^ (-1)) & i21)) + iArr2[10]) - 42063);
        int i27 = ((i26 >>> 15) | (i26 << 17)) + i25;
        int i28 = i21 + ((((i27 & i25) | ((i27 ^ (-1)) & i23)) + iArr2[11]) - 1990404162);
        int i29 = ((i28 >>> 10) | (i28 << 22)) + i27;
        int i30 = i23 + ((i29 & i27) | ((i29 ^ (-1)) & i25)) + iArr2[12] + 1804603682;
        int i31 = ((i30 >>> 25) | (i30 << 7)) + i29;
        int i32 = i25 + ((((i31 & i29) | ((i31 ^ (-1)) & i27)) + iArr2[13]) - 40341101);
        int i33 = ((i32 >>> 20) | (i32 << 12)) + i31;
        int i34 = i27 + ((((i33 & i31) | ((i33 ^ (-1)) & i29)) + iArr2[14]) - 1502002290);
        int i35 = ((i34 >>> 15) | (i34 << 17)) + i33;
        int i36 = i29 + ((i35 & i33) | ((i35 ^ (-1)) & i31)) + iArr2[15] + 1236535329;
        int i37 = ((i36 >>> 10) | (i36 << 22)) + i35;
        int i38 = i31 + ((((i37 & i33) | ((i33 ^ (-1)) & i35)) + iArr2[1]) - 165796510);
        int i39 = ((i38 >>> 27) | (i38 << 5)) + i37;
        int i40 = i33 + ((((i39 & i35) | ((i35 ^ (-1)) & i37)) + iArr2[6]) - 1069501632);
        int i41 = ((i40 >>> 23) | (i40 << 9)) + i39;
        int i42 = i35 + ((i41 & i37) | ((i37 ^ (-1)) & i39)) + iArr2[11] + 643717713;
        int i43 = ((i42 >>> 18) | (i42 << 14)) + i41;
        int i44 = i37 + ((((i43 & i39) | ((i39 ^ (-1)) & i41)) + iArr2[0]) - 373897302);
        int i45 = ((i44 >>> 12) | (i44 << 20)) + i43;
        int i46 = i39 + ((((i45 & i41) | ((i41 ^ (-1)) & i43)) + iArr2[5]) - 701558691);
        int i47 = ((i46 >>> 27) | (i46 << 5)) + i45;
        int i48 = i41 + ((i47 & i43) | ((i43 ^ (-1)) & i45)) + iArr2[10] + 38016083;
        int i49 = ((i48 >>> 23) | (i48 << 9)) + i47;
        int i50 = i43 + ((((i49 & i45) | ((i45 ^ (-1)) & i47)) + iArr2[15]) - 660478335);
        int i51 = ((i50 >>> 18) | (i50 << 14)) + i49;
        int i52 = i45 + ((((i51 & i47) | ((i47 ^ (-1)) & i49)) + iArr2[4]) - 405537848);
        int i53 = ((i52 >>> 12) | (i52 << 20)) + i51;
        int i54 = i47 + ((i53 & i49) | ((i49 ^ (-1)) & i51)) + iArr2[9] + 568446438;
        int i55 = ((i54 >>> 27) | (i54 << 5)) + i53;
        int i56 = i49 + ((((i55 & i51) | ((i51 ^ (-1)) & i53)) + iArr2[14]) - 1019803690);
        int i57 = ((i56 >>> 23) | (i56 << 9)) + i55;
        int i58 = i51 + ((((i57 & i53) | ((i53 ^ (-1)) & i55)) + iArr2[3]) - 187363961);
        int i59 = ((i58 >>> 18) | (i58 << 14)) + i57;
        int i60 = i53 + ((i59 & i55) | ((i55 ^ (-1)) & i57)) + iArr2[8] + 1163531501;
        int i61 = ((i60 >>> 12) | (i60 << 20)) + i59;
        int i62 = i55 + ((((i61 & i57) | ((i57 ^ (-1)) & i59)) + iArr2[13]) - 1444681467);
        int i63 = ((i62 >>> 27) | (i62 << 5)) + i61;
        int i64 = i57 + ((((i63 & i59) | ((i59 ^ (-1)) & i61)) + iArr2[2]) - 51403784);
        int i65 = ((i64 >>> 23) | (i64 << 9)) + i63;
        int i66 = i59 + ((i65 & i61) | ((i61 ^ (-1)) & i63)) + iArr2[7] + 1735328473;
        int i67 = ((i66 >>> 18) | (i66 << 14)) + i65;
        int i68 = i61 + ((((i67 & i63) | ((i63 ^ (-1)) & i65)) + iArr2[12]) - 1926607734);
        int i69 = ((i68 >>> 12) | (i68 << 20)) + i67;
        int i70 = i63 + ((((i69 ^ i67) ^ i65) + iArr2[5]) - 378558);
        int i71 = ((i70 >>> 28) | (i70 << 4)) + i69;
        int i72 = i65 + ((((i71 ^ i69) ^ i67) + iArr2[8]) - 2022574463);
        int i73 = ((i72 >>> 21) | (i72 << 11)) + i71;
        int i74 = i67 + ((i73 ^ i71) ^ i69) + iArr2[11] + 1839030562;
        int i75 = ((i74 >>> 16) | (i74 << 16)) + i73;
        int i76 = i69 + ((((i75 ^ i73) ^ i71) + iArr2[14]) - 35309556);
        int i77 = ((i76 >>> 9) | (i76 << 23)) + i75;
        int i78 = i71 + ((((i77 ^ i75) ^ i73) + iArr2[1]) - 1530992060);
        int i79 = ((i78 >>> 28) | (i78 << 4)) + i77;
        int i80 = i73 + ((i79 ^ i77) ^ i75) + iArr2[4] + 1272893353;
        int i81 = ((i80 >>> 21) | (i80 << 11)) + i79;
        int i82 = i75 + ((((i81 ^ i79) ^ i77) + iArr2[7]) - 155497632);
        int i83 = ((i82 >>> 16) | (i82 << 16)) + i81;
        int i84 = i77 + ((((i83 ^ i81) ^ i79) + iArr2[10]) - 1094730640);
        int i85 = ((i84 >>> 9) | (i84 << 23)) + i83;
        int i86 = i79 + ((i85 ^ i83) ^ i81) + iArr2[13] + 681279174;
        int i87 = ((i86 >>> 28) | (i86 << 4)) + i85;
        int i88 = i81 + ((((i87 ^ i85) ^ i83) + iArr2[0]) - 358537222);
        int i89 = ((i88 >>> 21) | (i88 << 11)) + i87;
        int i90 = i83 + ((((i89 ^ i87) ^ i85) + iArr2[3]) - 722521979);
        int i91 = ((i90 >>> 16) | (i90 << 16)) + i89;
        int i92 = i85 + ((i91 ^ i89) ^ i87) + iArr2[6] + 76029189;
        int i93 = ((i92 >>> 9) | (i92 << 23)) + i91;
        int i94 = i87 + ((((i93 ^ i91) ^ i89) + iArr2[9]) - 640364487);
        int i95 = ((i94 >>> 28) | (i94 << 4)) + i93;
        int i96 = i89 + ((((i95 ^ i93) ^ i91) + iArr2[12]) - 421815835);
        int i97 = ((i96 >>> 21) | (i96 << 11)) + i95;
        int i98 = i91 + ((i97 ^ i95) ^ i93) + iArr2[15] + 530742520;
        int i99 = ((i98 >>> 16) | (i98 << 16)) + i97;
        int i100 = i93 + ((((i99 ^ i97) ^ i95) + iArr2[2]) - 995338651);
        int i101 = ((i100 >>> 9) | (i100 << 23)) + i99;
        int i102 = i95 + (((((i97 ^ (-1)) | i101) ^ i99) + iArr2[0]) - 198630844);
        int i103 = ((i102 >>> 26) | (i102 << 6)) + i101;
        int i104 = i97 + (((i99 ^ (-1)) | i103) ^ i101) + iArr2[7] + 1126891415;
        int i105 = ((i104 >>> 22) | (i104 << 10)) + i103;
        int i106 = i99 + (((((i101 ^ (-1)) | i105) ^ i103) + iArr2[14]) - 1416354905);
        int i107 = ((i106 >>> 17) | (i106 << 15)) + i105;
        int i108 = i101 + (((((i103 ^ (-1)) | i107) ^ i105) + iArr2[5]) - 57434055);
        int i109 = ((i108 >>> 11) | (i108 << 21)) + i107;
        int i110 = i103 + (((i105 ^ (-1)) | i109) ^ i107) + iArr2[12] + 1700485571;
        int i111 = ((i110 >>> 26) | (i110 << 6)) + i109;
        int i112 = i105 + (((((i107 ^ (-1)) | i111) ^ i109) + iArr2[3]) - 1894986606);
        int i113 = ((i112 >>> 22) | (i112 << 10)) + i111;
        int i114 = i107 + (((((i109 ^ (-1)) | i113) ^ i111) + iArr2[10]) - 1051523);
        int i115 = ((i114 >>> 17) | (i114 << 15)) + i113;
        int i116 = i109 + (((((i111 ^ (-1)) | i115) ^ i113) + iArr2[1]) - 2054922799);
        int i117 = ((i116 >>> 11) | (i116 << 21)) + i115;
        int i118 = i111 + (((i113 ^ (-1)) | i117) ^ i115) + iArr2[8] + 1873313359;
        int i119 = ((i118 >>> 26) | (i118 << 6)) + i117;
        int i120 = i113 + (((((i115 ^ (-1)) | i119) ^ i117) + iArr2[15]) - 30611744);
        int i121 = ((i120 >>> 22) | (i120 << 10)) + i119;
        int i122 = i115 + (((((i117 ^ (-1)) | i121) ^ i119) + iArr2[6]) - 1560198380);
        int i123 = ((i122 >>> 17) | (i122 << 15)) + i121;
        int i124 = i117 + (((i119 ^ (-1)) | i123) ^ i121) + iArr2[13] + 1309151649;
        int i125 = ((i124 >>> 11) | (i124 << 21)) + i123;
        int i126 = i119 + (((((i121 ^ (-1)) | i125) ^ i123) + iArr2[4]) - 145523070);
        int i127 = ((i126 >>> 26) | (i126 << 6)) + i125;
        int i128 = i121 + (((((i123 ^ (-1)) | i127) ^ i125) + iArr2[11]) - 1120210379);
        int i129 = ((i128 >>> 22) | (i128 << 10)) + i127;
        int i130 = i123 + (((i125 ^ (-1)) | i129) ^ i127) + iArr2[2] + 718787259;
        int i131 = ((i130 >>> 17) | (i130 << 15)) + i129;
        int i132 = i125 + (((((i127 ^ (-1)) | i131) ^ i129) + iArr2[9]) - 343485551);
        iArr[0] = i127 + iArr[0];
        iArr[1] = iArr[1] + ((i132 >>> 11) | (i132 << 21)) + i131;
        iArr[2] = iArr[2] + i131;
        iArr[3] = iArr[3] + i129;
    }

    public static final void m397a(int[] iArr, int[] iArr2, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int[] iArr3 = new int[i3];
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (true) {
            int i9 = i6 + 1;
            if (i6 >= i2) {
                break;
            }
            m390a(iArr, i8, iArr2, i7, i);
            m390a(iArr3, 0, iArr2, i7 + i, i5);
            i7 += i3;
            i8 += i;
            i6 = i9;
        }
        int i10 = i3 * i4;
        while (i7 < i10) {
            m390a(iArr3, 0, iArr2, i7, i3);
            i7 += i3;
        }
    }

    public static boolean m398a(char[] cArr, int i, boolean z, boolean z2) {
        int i2;
        int i3;
        int i4;
        boolean z3;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        if (f274lN == null) {
            f274lN = (int[][]) m416ai(530);
        }
        boolean z4 = false;
        for (int i11 = 0; i11 < i; i11++) {
            int m428au = m428au(cArr[i11]);
            if (m428au == 3 || m428au == 4) {
                z4 = true;
                break;
            }
        }
        if (!z4) {
            return false;
        }
        int[] iArr = new int[i];
        int[] iArr2 = new int[i];
        byte[] bArr = new byte[i];
        int i12 = 1;
        int i13 = 18;
        boolean z5 = false;
        byte b2 = 0;
        int i14 = 0;
        while (i14 < i) {
            int m428au2 = m428au(cArr[i14]);
            if ((cArr[i14] == 1 || (C0338r.f2329pA && cArr[i14] == '\\')) && i14 < i - 1) {
                b2 = cArr[i14] == '\\' ? (byte) (cArr[i14 + 1] - '0') : (byte) cArr[i14 + 1];
                cArr[i14] = 14;
                cArr[i14 + 1] = 14;
                bArr[i14] = -1;
                bArr[i14 + 1] = -1;
                m428au2 = 14;
            }
            if (bArr[i14] != -1) {
                bArr[i14] = b2;
            }
            switch (m428au2) {
                case 1:
                    int i15 = (i12 + 2) & (-2);
                    iArr2[i14] = i15;
                    iArr2[i14] = m508w(iArr2[i14], i13);
                    boolean z6 = z5;
                    i5 = i15;
                    i6 = 18;
                    i13 = m428au2;
                    z3 = z6;
                    continue;
                case 2:
                    int i16 = (i12 + 2) & (-2);
                    iArr2[i14] = i16;
                    i13 = 0;
                    z3 = true;
                    i5 = i16;
                    i6 = 0;
                    continue;
                case C0217R.styleable.com_facebook_picker_fragment_title_bar_background:
                    int i17 = (i12 + 1) | 1;
                    iArr2[i14] = i17;
                    iArr2[i14] = m508w(iArr2[i14], i13);
                    boolean z7 = z5;
                    i5 = i17;
                    i6 = 18;
                    i13 = m428au2;
                    z3 = z7;
                    continue;
                case C0217R.styleable.com_facebook_picker_fragment_done_button_background:
                    int i18 = (i12 + 1) | 1;
                    iArr2[i14] = i18;
                    i13 = 3;
                    z3 = true;
                    i5 = i18;
                    i6 = 3;
                    continue;
                case 7:
                    if (i14 > 0) {
                        int i19 = i14 - 1;
                        int i20 = iArr2[i19];
                        while (i19 >= 0 && iArr2[i19] == i20) {
                            i19--;
                        }
                        i7 = i19 >= 0 ? iArr2[i19] : -1;
                    } else {
                        i7 = -1;
                    }
                    if (i7 == -1) {
                        i8 = 1;
                    } else {
                        i8 = i7 & 63;
                        int i21 = i7 & 192;
                        if ((i21 & 64) != 0) {
                            i9 = i8;
                            i10 = 3;
                        } else if ((i21 & 128) != 0) {
                            i9 = i8;
                            i10 = 0;
                        }
                        iArr2[i14] = i9;
                        boolean z8 = z5;
                        i5 = i9;
                        i6 = i10;
                        i13 = m428au2;
                        z3 = z8;
                        continue;
                    }
                    i9 = i8;
                    i10 = 18;
                    iArr2[i14] = i9;
                    boolean z82 = z5;
                    i5 = i9;
                    i6 = i10;
                    i13 = m428au2;
                    z3 = z82;
                    continue;
                case 16:
                case 17:
                    iArr2[i14] = i12;
                    m428au2 = 18;
                    if (i13 != 18) {
                        z3 = z5;
                        i5 = i12;
                        i6 = i13;
                        break;
                    }
                    break;
                default:
                    iArr2[i14] = i12;
                    if (i13 != 18) {
                        z3 = z5;
                        i5 = i12;
                        i6 = i13;
                        break;
                    }
                    break;
            }
            boolean z9 = z5;
            i5 = i12;
            i6 = i13;
            i13 = m428au2;
            z3 = z9;
            iArr[i14] = i13;
            i14++;
            i13 = i6;
            i12 = i5;
            z5 = z3;
        }
        if (z5) {
            for (int i22 = 0; i22 < i; i22++) {
                iArr2[i22] = iArr2[i22] & 63;
            }
        }
        for (int i23 = 0; i23 < i; i23++) {
            switch (iArr[i23]) {
                case 1:
                case 2:
                case C0217R.styleable.com_facebook_picker_fragment_title_bar_background:
                case C0217R.styleable.com_facebook_picker_fragment_done_button_background:
                case 7:
                    iArr[i23] = 14;
                    cArr[i23] = 31;
                    break;
            }
        }
        int i24 = 1;
        int i25 = 0;
        for (int i26 = 0; i26 < i; i26++) {
            if (iArr2[i26] != i24) {
                i24 = iArr2[i26];
                i25++;
            }
        }
        int i27 = i25 + 1;
        int[] iArr3 = new int[i27];
        int i28 = 0;
        int i29 = 0;
        int i30 = 1;
        int i31 = 0;
        while (i31 < i) {
            if (iArr2[i31] != i30) {
                i4 = i28 + 1;
                iArr3[i28] = i29;
                i3 = iArr2[i31];
                i29 = i31;
            } else {
                int i32 = i28;
                i3 = i30;
                i4 = i32;
            }
            i31++;
            int i33 = i4;
            i30 = i3;
            i28 = i33;
        }
        iArr3[i28] = i29;
        int i34 = 0;
        int i35 = 1;
        while (i34 < i27) {
            int i36 = iArr3[i34];
            int i37 = i34 == iArr3.length + (-1) ? i : iArr3[i34 + 1];
            int i38 = iArr2[i36];
            int i39 = i34 == i27 + (-1) ? 1 : iArr2[iArr3[i34 + 1]];
            int max = Math.max(i35, i38) % 2;
            int max2 = Math.max(i38, i39) % 2;
            int i40 = max;
            int i41 = max;
            for (int i42 = i36; i42 < i37; i42++) {
                if (iArr[i42] == 13) {
                    iArr[i42] = i41;
                }
                if (iArr[i42] == 8 && i40 == 4) {
                    iArr[i42] = 11;
                }
                if (iArr[i42] == 4) {
                    i40 = iArr[i42];
                    iArr[i42] = 3;
                } else if (iArr[i42] == 3 || iArr[i42] == 0) {
                    i40 = iArr[i42];
                }
                i41 = iArr[i42];
            }
            int i43 = max;
            int i44 = max;
            while (i36 < i37) {
                int i45 = i36 == i37 + (-1) ? max2 : iArr[i36 + 1];
                if (i44 == 8 && i45 == 8) {
                    if (iArr[i36] == 9 || iArr[i36] == 12) {
                        iArr[i36] = i45;
                    }
                } else if (i44 == 11 && i45 == 11 && iArr[i36] == 12) {
                    iArr[i36] = i45;
                }
                if (iArr[i36] == 10 || iArr[i36] == 14) {
                    if (i44 == 8) {
                        iArr[i36] = i44;
                    } else {
                        int i46 = i36 + 1;
                        while (i46 < i37 && (iArr[i46] == 10 || iArr[i46] == 14)) {
                            i46++;
                        }
                        if (i46 < i37 && iArr[i46] == 8) {
                            for (int i47 = i36; i47 < i46; i47++) {
                                iArr[i47] = 8;
                            }
                        }
                    }
                }
                switch (iArr[i36]) {
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                        iArr[i36] = 18;
                        break;
                }
                if (i43 == 0 && iArr[i36] == 8) {
                    iArr[i36] = i43;
                }
                if (iArr[i36] == 3 || iArr[i36] == 0 || iArr[i36] == 4) {
                    i43 = iArr[i36];
                }
                int i48 = iArr[i36];
                i36++;
                i44 = i48;
            }
            i34++;
            i35 = i38;
        }
        int i49 = 0;
        int i50 = 1;
        while (i49 < i27) {
            int i51 = iArr3[i49];
            int i52 = i49 == iArr3.length + (-1) ? i : iArr3[i49 + 1];
            int i53 = iArr2[i51];
            int i54 = i53 % 2 == 0 ? 0 : 3;
            int i55 = i49 == i27 + (-1) ? 1 : iArr2[iArr3[i49 + 1]];
            int max3 = Math.max(i50, i53) % 2;
            int max4 = Math.max(i53, i55) % 2;
            int i56 = -1;
            int i57 = max3;
            while (i51 <= i52) {
                int i58 = -1;
                switch (i51 == i52 ? max4 : iArr[i51]) {
                    case 0:
                        i58 = 0;
                        break;
                    case 3:
                    case WorkQueue.DEFAULT_MAX_CONCURRENT:
                    case 11:
                        i58 = 3;
                        break;
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                        if (i56 == -1) {
                            i56 = i51;
                            break;
                        }
                        break;
                }
                if (i58 != -1) {
                    if (i56 != -1) {
                        if (i57 != i58) {
                            i57 = i54;
                        }
                        while (i56 < i51) {
                            iArr[i56] = i57;
                            i56++;
                        }
                    }
                    int i59 = i58;
                    i2 = -1;
                    i57 = i59;
                } else {
                    i2 = i56;
                }
                i51++;
                i56 = i2;
            }
            i49++;
            i50 = i53;
        }
        for (int i60 = 0; i60 < i; i60++) {
            if ((iArr2[i60] & 1) == 0) {
                if (iArr[i60] != 3) {
                    if (iArr[i60] == 11 || iArr[i60] == 8) {
                        iArr2[i60] = iArr2[i60] + 2;
                    }
                }
                iArr2[i60] = iArr2[i60] + 1;
            } else {
                if (iArr[i60] != 0 && iArr[i60] != 8 && iArr[i60] != 11) {
                }
                iArr2[i60] = iArr2[i60] + 1;
            }
        }
        int i61 = i - 1;
        while (i61 > 0 && m428au(cArr[i61]) == 17) {
            i61--;
        }
        if (i61 < i - 1) {
            while (true) {
                i61++;
                if (i61 < i) {
                    iArr2[i61] = 1;
                }
            }
        }
        for (int i62 = 0; i62 < i; i62++) {
            int m428au3 = m428au(cArr[i62]);
            if (m428au3 == 17) {
                int i63 = i62;
                while (i63 < i && m428au(cArr[i63]) == 17) {
                    i63++;
                }
                if (i63 == i || m428au(cArr[i63]) == 15 || m428au(cArr[i63]) == 16) {
                    while (true) {
                        i63--;
                        if (i63 >= i62) {
                            iArr2[i63] = 1;
                        }
                    }
                }
            } else if (m428au3 == 15 || m428au3 == 16) {
                iArr2[i62] = 1;
            }
        }
        for (int i64 = 0; i64 < i; i64++) {
            if (iArr2[i64] % 2 == 1) {
                cArr[i64] = m429b(cArr[i64]);
            }
        }
        int i65 = iArr2[0];
        for (int i66 = 0; i66 < i; i66++) {
            if (iArr2[i66] > i65) {
                i65 = iArr2[i66];
            }
        }
        for (int i67 = i65; i67 > 0; i67--) {
            int i68 = 0;
            int i69 = 0;
            while (i68 < i && i69 < i) {
                while (true) {
                    if (i68 >= i) {
                        i68 = i;
                    } else if (iArr2[i68] < i67 || iArr2[i68] > i65) {
                        i68++;
                    }
                }
                int i70 = i68;
                while (i70 < i && i65 >= iArr2[i70] && i67 <= iArr2[i70]) {
                    i70++;
                }
                i69 = i68;
                int i71 = i70 - 1;
                while (i71 > i69) {
                    char c = cArr[i71];
                    cArr[i71] = cArr[i69];
                    cArr[i69] = c;
                    byte b3 = bArr[i71];
                    bArr[i71] = bArr[i69];
                    bArr[i69] = b3;
                    i71--;
                    i69++;
                }
                i68 = i70;
            }
        }
        byte b4 = 0;
        for (int i72 = 0; i72 < i - 1; i72++) {
            if (bArr[i72] == -1) {
                cArr[i72] = 1;
                if (i72 < i - 2) {
                    b4 = bArr[i72 + 2];
                }
                cArr[i72 + 1] = (char) b4;
                bArr[i72 + 1] = 0;
            }
        }
        return true;
    }

    static byte[] m399a(byte[] bArr, String str, boolean z) {
        int[] iArr;
        byte[] bArr2 = null;
        if (!"".equals(str) && str != null) {
            bArr2 = str.getBytes();
        }
        if (bArr.length == 0) {
            return bArr;
        }
        int[] m401a = m401a(bArr, true, (int[]) null);
        int[] m401a2 = m401a(bArr2, false, (int[]) null);
        int length = m401a.length - 1;
        if (length > 0) {
            if (m401a2.length < 4) {
                iArr = new int[4];
                System.arraycopy(m401a2, 0, iArr, 0, m401a2.length);
            } else {
                iArr = m401a2;
            }
            int i = (52 / (length + 1)) + 6;
            int i2 = 0;
            int i3 = m401a[length];
            while (true) {
                int i4 = i - 1;
                if (i <= 0) {
                    break;
                }
                i2 -= 1640531527;
                int i5 = (i2 >>> 2) & 3;
                int i6 = 0;
                while (i6 < length) {
                    int i7 = m401a[i6 + 1];
                    i3 = (((i3 ^ iArr[(i6 & 3) ^ i5]) + (i7 ^ i2)) ^ (((i3 >>> 5) ^ (i7 << 2)) + ((i7 >>> 3) ^ (i3 << 4)))) + m401a[i6];
                    m401a[i6] = i3;
                    i6++;
                }
                int i8 = m401a[0];
                i3 = m401a[length] + (((iArr[(i6 & 3) ^ i5] ^ i3) + (i8 ^ i2)) ^ (((i3 >>> 5) ^ (i8 << 2)) + ((i8 >>> 3) ^ (i3 << 4))));
                m401a[length] = i3;
                i = i4;
            }
        }
        return m400a(m401a, false, (byte[]) null);
    }

    private static byte[] m400a(int[] iArr, boolean z, byte[] bArr) {
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

    private static int[] m401a(byte[] bArr, boolean z, int[] iArr) {
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

    static String m402aK() {
        String m214di = f143iL.m214di("DeviceID");
        if (m214di != null) {
            return m214di;
        }
        if (C0338r.f2508sX) {
            String m214di2 = f143iL.m214di("IMEI");
            if (m214di2 != null) {
                return m214di2;
            }
            String property = System.getProperty("phone.imei");
            if (property != null) {
                return property;
            }
            String property2 = System.getProperty("com.nokia.imei");
            if (property2 != null) {
                return property2;
            }
            String property3 = System.getProperty("com.nokia.mid.imei");
            if (property3 != null) {
                return property3;
            }
            String property4 = System.getProperty("com.sonyericsson.imei");
            if (property4 != null) {
                return property4;
            }
            String property5 = System.getProperty("IMEI");
            if (property5 != null) {
                return property5;
            }
            String property6 = System.getProperty("com.motorola.IMEI");
            if (property6 != null) {
                return property6;
            }
            String property7 = System.getProperty("com.siemens.IMEI");
            if (property7 != null) {
                return property7;
            }
            String property8 = System.getProperty("com.lge.imei");
            if (property8 != null) {
                return property8;
            }
        }
        return null;
    }

    private void m403aU() {
        if (f141iJ != null) {
            C0065n c0065n = f141iJ;
            if (C0065n.m162ue() != this) {
                f141iJ.m164a(this);
            }
        }
    }

    private void m404aV() {
        if (f135iD) {
            this.f302iN = Math.min(this.f302iN, System.currentTimeMillis());
            if (C0338r.f2208mj) {
                Thread.sleep(C0338r.f2209mk);
                return;
            } else {
                Thread.yield();
                return;
            }
        }
        C0048ac c0048ac = f134iC;
        if (!f135iD && !f142iK) {
            f142iK = true;
            if (f136iE != -1) {
                f153iW = f183ja;
                f154iX = f184jb;
                f155iY = f156iZ;
                f183ja = 0;
                f184jb = 0;
                long j = f137iF;
                if (f186jd > 0) {
                    if (C0338r.f2171lY && f186jd != Integer.MAX_VALUE) {
                        f186jd -= f146iP;
                    }
                    m406aY();
                }
            }
            if (C0338r.f2455rW) {
                if (C0338r.f2455rW) {
                    switch (f282lg) {
                        case 1:
                            m507s(0, 4);
                            break;
                        case 2:
                            m507s(0, 0);
                            break;
                    }
                    f285lj = f287ll;
                    f286lk = f288lm;
                    if (C0338r.f2456rX > 1 && f297lv != null) {
                        for (int i = 0; i < C0338r.f2456rX; i++) {
                            switch (f297lv[i]) {
                                case 1:
                                    m507s(i, 4);
                                    break;
                                case 2:
                                    m507s(i, 0);
                                    break;
                            }
                            f295lt[i] = f298lw[i];
                            f296lu[i] = f299lx[i];
                        }
                    }
                }
                if (C0338r.f2455rW) {
                    if (f289ln) {
                        m507s(0, 1);
                        f289ln = false;
                    } else if (f290lo) {
                        m507s(0, 2);
                        f290lo = false;
                        f291lp = false;
                    } else if (f291lp) {
                        m507s(0, 3);
                        f291lp = false;
                    }
                    f287ll = f283lh;
                    f288lm = f284li;
                    if (C0338r.f2456rX > 1) {
                        for (int i2 = 0; i2 < C0338r.f2456rX; i2++) {
                            if (f300ly[i2]) {
                                m507s(i2, 1);
                                f300ly[i2] = false;
                            } else if (f301lz[i2]) {
                                m507s(i2, 2);
                                f301lz[i2] = false;
                                f261lA[i2] = false;
                            } else if (f261lA[i2]) {
                                m507s(i2, 3);
                                f261lA[i2] = false;
                            }
                            f298lw[i2] = f293lr[i2];
                            f299lx[i2] = f294ls[i2];
                        }
                    }
                }
            }
            f137iF = System.currentTimeMillis();
            if (C0338r.f2171lY) {
                int i3 = (int) (f137iF - f147iQ);
                f146iP = i3;
                if (i3 < 0) {
                    f146iP = 0;
                }
                if (f146iP > 1000) {
                    f146iP = PlacePickerFragment.DEFAULT_RADIUS_IN_METERS;
                }
                f147iQ = f137iF;
                f148iR += f146iP;
                int i4 = f149iS;
                int i5 = f148iR;
            }
            f149iS++;
            f254kt = 0;
            try {
            } catch (Exception e) {
                f136iE = -1;
            }
            if (f231kW) {
                if (f278lc != 0) {
                    f134iC = f277lb;
                    mo511aN();
                    if (f231kW && f232kX) {
                        if (f278lc == 0) {
                            f134iC = c0048ac;
                            C0277ad c0277ad = f276la;
                            m388a(c0048ac, c0277ad, 0, 0, c0277ad.f494vK, c0277ad.f495vL, 0, 0.0f, 0.0f, 20);
                            f279ld = 0;
                        }
                    }
                    f142iK = false;
                }
            }
            f134iC = c0048ac;
            mo511aN();
            if (f231kW) {
                if (f278lc == 0) {
                }
            }
            f142iK = false;
        }
        if (C0338r.f2430qx) {
            C0335o.m2046h(true);
        }
        m465bl();
        long currentTimeMillis = System.currentTimeMillis();
        this.f302iN = Math.min(this.f302iN, currentTimeMillis);
        if (!C0338r.f2210ml || f145iO < 0) {
            if (C0338r.f2208mj) {
                Thread.sleep(Math.max(1L, f144iM - (currentTimeMillis - this.f302iN)));
            } else {
                while (currentTimeMillis - this.f302iN < f144iM) {
                    Thread.yield();
                    currentTimeMillis = System.currentTimeMillis();
                    this.f302iN = Math.min(this.f302iN, currentTimeMillis);
                }
            }
        } else if (f145iO == 0) {
            Thread.yield();
        } else {
            Thread.sleep(f145iO);
        }
        this.f302iN = System.currentTimeMillis();
    }

    static final void m405aX() {
        f151iU = false;
        if (f152iV != null) {
            try {
                f143iL.m215dj(f152iV);
            } catch (Exception e) {
            }
        }
    }

    private static void m406aY() {
        f153iW = 0;
        f154iX = 0;
        f155iY = 0;
        f156iZ = 0;
        f183ja = 0;
        f184jb = 0;
    }

    public static int m407aZ() {
        if (f153iW == 0) {
            return -1;
        }
        int i = f189jg;
        do {
            i--;
            if (i < 0) {
                return -1;
            }
        } while ((f153iW & (1 << i)) == 0);
        return i;
    }

    static final byte[] m408aa(int i) {
        f268lH = i;
        byte[] bArr = new byte[m362Z(i)];
        m366a(bArr, 0, bArr.length);
        return bArr;
    }

    private static void m409ab(int i) {
        if (i == 0) {
            return;
        }
        if (C0338r.f2227nC == 0 || f163jG == 3) {
            f166jJ += i;
            while (i > 0) {
                try {
                    i = (int) (i - f162jF.skip(i));
                } catch (Exception e) {
                    return;
                }
            }
            return;
        }
        if (f174jR == null) {
            f174jR = new byte[C0338r.f2227nC];
        }
        while (i > C0338r.f2227nC) {
            m366a(f174jR, 0, C0338r.f2227nC);
            i -= C0338r.f2227nC;
        }
        if (i > 0) {
            m366a(f174jR, 0, i);
        }
    }

    static final Object m410ac(int i) {
        m362Z(i);
        f259ky = 0;
        Object m370a = m370a(f162jF);
        f166jJ += f259ky;
        return m370a;
    }

    static String m411ad(int i) {
        if (i >= f175jS.length) {
            return "";
        }
        try {
            return new String(f175jS[i], "UTF-8");
        } catch (Exception e) {
            return "";
        }
    }

    static final void m412ae(int i) {
        int m363a = m363a(((((i >> 16) & 255) & 255) << 16) | ((((i >> 8) & 255) & 255) << 8) | (i & 255 & 255), f265lE);
        f249ko = 255;
        f246kl = (m363a >> 16) & 255;
        f247km = (m363a >> 8) & 255;
        f248kn = m363a & 255;
    }

    static final void m413af(int i) {
        int m363a = m363a(i, f265lE);
        f249ko = m363a >>> 24;
        f246kl = (m363a >> 16) & 255;
        f247km = (m363a >> 8) & 255;
        f248kn = m363a & 255;
    }

    private static void m414ag(int i) {
        int i2 = f180jX << 2;
        int i3 = (i << 2) + i2;
        while (i2 < i3) {
            int i4 = i2 + 1;
            f245kk[i2] = (byte) f246kl;
            int i5 = i4 + 1;
            f245kk[i4] = (byte) f247km;
            int i6 = i5 + 1;
            f245kk[i5] = (byte) f248kn;
            i2 = i6 + 1;
            f245kk[i6] = (byte) f249ko;
        }
    }

    public static void m415ah(int i) {
        if (i == f178jV) {
        }
        m465bl();
        f178jV = i;
        switch (i) {
            case 0:
                GLES10.glTexEnvf(8960, 8704, 8448.0f);
                GLES10.glBlendFunc(770, 771);
                break;
            case 1:
                if (C0338r.f2221mw) {
                    GLES11.glTexEnvi(8960, 8704, 34160);
                    GLES11.glTexEnvi(8960, 34161, 7681);
                    GLES11.glTexEnvi(8960, 34176, 34168);
                    GLES11.glTexEnvi(8960, 34177, 5890);
                    GLES11.glTexEnvi(8960, 34192, 768);
                    GLES11.glTexEnvi(8960, 34193, 768);
                    GLES10.glBlendFunc(770, 771);
                    break;
                }
                break;
            case 2:
                if (C0338r.f2221mw) {
                    GLES11.glTexEnvi(8960, 8704, 34160);
                    GLES11.glTexEnvi(8960, 34161, 34478);
                    GLES11.glTexEnvi(8960, 34176, 5890);
                    GLES11.glTexEnvi(8960, 34177, 34167);
                    GLES11.glTexEnvi(8960, 34162, 7681);
                    GLES11.glTexEnvi(8960, 34184, 5890);
                    break;
                }
                break;
        }
    }

    protected static Object m416ai(int i) {
        Object obj = null;
        try {
            if (f258kx == null || i < f257kw) {
                if (f258kx != null) {
                    f258kx.close();
                }
                GLLib gLLib = f150iT;
                f258kx = m343D("/888");
                f257kw = 0;
            }
            f258kx.skip(i - f257kw);
            int available = f258kx.available();
            obj = m370a(f258kx);
            f257kw = (available - f258kx.available()) + i;
            return obj;
        } catch (IOException e) {
            return obj;
        }
    }

    static String m417aj(int i) {
        switch (i) {
            case 0:
                return "EN";
            case 1:
                return "DE";
            case 2:
                return "FR";
            case 3:
                return "IT";
            case C0217R.styleable.com_facebook_picker_fragment_done_button_text:
                return "ES";
            case C0217R.styleable.com_facebook_picker_fragment_title_bar_background:
                return "BR";
            case C0217R.styleable.com_facebook_picker_fragment_done_button_background:
                return "PT";
            case 7:
                return "JP";
            case WorkQueue.DEFAULT_MAX_CONCURRENT:
                return "CN";
            case 9:
                return "KR";
            case 10:
                return "RU";
            case 11:
                return "TR";
            case 12:
                return "PL";
            case 13:
                return "CZ";
            case 14:
                return "NL";
            case 15:
                return "TH";
            case 16:
                return "VI";
            case 17:
                return "AR";
            default:
                return null;
        }
    }

    static String m418ak(int i) {
        if (!C0338r.f2253nc) {
            if (C0338r.f2197mY && f223kO != null) {
                return f223kO[i];
            }
            try {
                int i2 = f222kN[i + 1] - f222kN[i];
                if (i2 != 0) {
                    return new String(f221kM, f222kN[i], i2, f220kL);
                }
                return null;
            } catch (Exception e) {
                return null;
            }
        }
        int i3 = i >> C0338r.f2255ne;
        int i4 = i & ((1 << C0338r.f2255ne) - 1);
        if (C0338r.f2197mY && f228kT != null && f228kT[i3] != null) {
            return f228kT[i3][i4];
        }
        try {
            int i5 = f227kS[i3][i4 + 1] - f227kS[i3][i4];
            if (i5 != 0) {
                return new String(f225kQ[i3], f227kS[i3][i4], i5, f220kL);
            }
            return null;
        } catch (Exception e2) {
            return null;
        }
    }

    private static void m419al(int i) {
        if (!C0338r.f2253nc || f226kR[i] == 0) {
            return;
        }
        String[] strArr = new String[f226kR[i]];
        for (int i2 = 0; i2 < f226kR[i]; i2++) {
            strArr[i2] = m418ak((i << C0338r.f2255ne) + i2);
        }
        f228kT[i] = strArr;
        f227kS[i] = null;
        f225kQ[i] = null;
        boolean z = C0338r.f2168lV;
    }

    private static void m420am(int i) {
        int i2;
        if (!C0338r.f2253nc || f224kP == null || (i2 = f224kP[i]) == -1) {
            return;
        }
        if (C0338r.f2197mY && f228kT[i2] != null) {
            for (int i3 = 0; i3 < f226kR[i2]; i3++) {
                f228kT[i2][i3] = null;
            }
            f228kT[i2] = null;
        }
        f227kS[i2] = null;
        f225kQ[i2] = null;
        f226kR[i2] = 0;
        f224kP[i] = -1;
    }

    static void m421an(int i) {
        m413af(i);
    }

    static final void m422ao(int i) {
        f234kZ[18][1] = i;
        f234kZ[18][3] = i;
        f234kZ[18][4] = i;
    }

    static final boolean m423ap(int i) {
        if (C0338r.f2455rW) {
            return C0338r.f2456rX > 1 ? f297lv[i] == 2 : f282lg == 2;
        }
        return false;
    }

    static final boolean m424aq(int i) {
        if (C0338r.f2455rW) {
            return C0338r.f2456rX > 1 ? f297lv[i] == 1 : f282lg == 1;
        }
        return false;
    }

    static final boolean m425ar(int i) {
        if (C0338r.f2455rW) {
            return C0338r.f2456rX > 1 ? f297lv[i] == 3 : f282lg == 3;
        }
        return false;
    }

    static final boolean m426as(int i) {
        if (C0338r.f2455rW) {
            return C0338r.f2456rX > 1 ? f297lv[i] == 4 : f282lg == 4;
        }
        return false;
    }

    static final boolean m427at(int i) {
        if (!C0338r.f2455rW) {
            return false;
        }
        if (C0338r.f2456rX <= 1) {
            return f282lg == 4 || f282lg == 1 || f282lg == 3;
        }
        int i2 = f297lv[i];
        return i2 == 4 || i2 == 1 || i2 == 3;
    }

    private static int m428au(int i) {
        int length = f274lN.length;
        int i2 = -1;
        while (length - i2 > 1) {
            int i3 = (i2 + length) / 2;
            if (i < f274lN[i3][0]) {
                length = i3;
            } else {
                if (i <= f274lN[i3][f272lL]) {
                    return f274lN[i3][f273lM];
                }
                i2 = i3;
            }
        }
        return 18;
    }

    private static char m429b(char c) {
        if ((c & 65280) == 0) {
            switch (c) {
                case '(':
                    return ')';
                case ')':
                    return '(';
                case '<':
                    return '>';
                case '>':
                    return '<';
                case '[':
                    return ']';
                case ']':
                    return '[';
                case '{':
                    return '}';
                case '}':
                    return '{';
                case 171:
                    return (char) 187;
                case 187:
                    return (char) 171;
                default:
                    return c;
            }
        }
        if ((c & 65280) == 8192) {
            switch (c) {
                case 8249:
                    return (char) 8250;
                case 8250:
                    return (char) 8249;
                case 8261:
                    return (char) 8262;
                case 8262:
                    return (char) 8261;
                case 8317:
                    return (char) 8318;
                case 8318:
                    return (char) 8317;
                case 8333:
                    return (char) 8334;
                case 8334:
                    return (char) 8333;
                default:
                    return c;
            }
        }
        if ((c & 65280) == 8704) {
            switch (c) {
                case 8712:
                    return (char) 8715;
                case 8713:
                    return (char) 8716;
                case 8714:
                    return (char) 8717;
                case 8715:
                    return (char) 8712;
                case 8716:
                    return (char) 8713;
                case 8717:
                    return (char) 8714;
                case 8718:
                case 8719:
                case 8720:
                case 8721:
                case 8722:
                case 8723:
                case 8724:
                case 8726:
                case 8727:
                case 8728:
                case 8729:
                case 8730:
                case 8731:
                case 8732:
                case 8733:
                case 8734:
                case 8735:
                case 8736:
                case 8737:
                case 8738:
                case 8739:
                case 8740:
                case 8741:
                case 8742:
                case 8743:
                case 8744:
                case 8745:
                case 8746:
                case 8747:
                case 8748:
                case 8749:
                case 8750:
                case 8751:
                case 8752:
                case 8753:
                case 8754:
                case 8755:
                case 8756:
                case 8757:
                case 8758:
                case 8759:
                case 8760:
                case 8761:
                case 8762:
                case 8763:
                case 8766:
                case 8767:
                case 8768:
                case 8769:
                case 8770:
                case 8772:
                case 8773:
                case 8774:
                case 8775:
                case 8776:
                case 8777:
                case 8778:
                case 8779:
                case 8780:
                case 8781:
                case 8782:
                case 8783:
                case 8784:
                case 8785:
                case 8790:
                case 8791:
                case 8792:
                case 8793:
                case 8794:
                case 8795:
                case 8796:
                case 8797:
                case 8798:
                case 8799:
                case 8800:
                case 8801:
                case 8802:
                case 8803:
                case 8812:
                case 8813:
                case 8844:
                case 8845:
                case 8846:
                case 8851:
                case 8852:
                case 8853:
                case 8854:
                case 8855:
                case 8857:
                case 8858:
                case 8859:
                case 8860:
                case 8861:
                case 8862:
                case 8863:
                case 8864:
                case 8865:
                case 8868:
                case 8869:
                case 8871:
                case 8874:
                case 8876:
                case 8877:
                case 8878:
                case 8879:
                case 8888:
                case 8889:
                case 8890:
                case 8891:
                case 8892:
                case 8893:
                case 8894:
                case 8895:
                case 8896:
                case 8897:
                case 8898:
                case 8899:
                case 8900:
                case 8901:
                case 8902:
                case 8903:
                case 8904:
                case 8910:
                case 8911:
                case 8914:
                case 8915:
                case 8916:
                case 8917:
                case 8942:
                case 8943:
                case 8949:
                case 8952:
                case 8953:
                default:
                    return c;
                case 8725:
                    return (char) 10741;
                case 8764:
                    return (char) 8765;
                case 8765:
                    return (char) 8764;
                case 8771:
                    return (char) 8909;
                case 8786:
                    return (char) 8787;
                case 8787:
                    return (char) 8786;
                case 8788:
                    return (char) 8789;
                case 8789:
                    return (char) 8788;
                case 8804:
                    return (char) 8805;
                case 8805:
                    return (char) 8804;
                case 8806:
                    return (char) 8807;
                case 8807:
                    return (char) 8806;
                case 8808:
                    return (char) 8809;
                case 8809:
                    return (char) 8808;
                case 8810:
                    return (char) 8811;
                case 8811:
                    return (char) 8810;
                case 8814:
                    return (char) 8815;
                case 8815:
                    return (char) 8814;
                case 8816:
                    return (char) 8817;
                case 8817:
                    return (char) 8816;
                case 8818:
                    return (char) 8819;
                case 8819:
                    return (char) 8818;
                case 8820:
                    return (char) 8821;
                case 8821:
                    return (char) 8820;
                case 8822:
                    return (char) 8823;
                case 8823:
                    return (char) 8822;
                case 8824:
                    return (char) 8825;
                case 8825:
                    return (char) 8824;
                case 8826:
                    return (char) 8827;
                case 8827:
                    return (char) 8826;
                case 8828:
                    return (char) 8829;
                case 8829:
                    return (char) 8828;
                case 8830:
                    return (char) 8831;
                case 8831:
                    return (char) 8830;
                case 8832:
                    return (char) 8833;
                case 8833:
                    return (char) 8832;
                case 8834:
                    return (char) 8835;
                case 8835:
                    return (char) 8834;
                case 8836:
                    return (char) 8837;
                case 8837:
                    return (char) 8836;
                case 8838:
                    return (char) 8839;
                case 8839:
                    return (char) 8838;
                case 8840:
                    return (char) 8841;
                case 8841:
                    return (char) 8840;
                case 8842:
                    return (char) 8843;
                case 8843:
                    return (char) 8842;
                case 8847:
                    return (char) 8848;
                case 8848:
                    return (char) 8847;
                case 8849:
                    return (char) 8850;
                case 8850:
                    return (char) 8849;
                case 8856:
                    return (char) 10680;
                case 8866:
                    return (char) 8867;
                case 8867:
                    return (char) 8866;
                case 8870:
                    return (char) 10974;
                case 8872:
                    return (char) 10980;
                case 8873:
                    return (char) 10979;
                case 8875:
                    return (char) 10981;
                case 8880:
                    return (char) 8881;
                case 8881:
                    return (char) 8880;
                case 8882:
                    return (char) 8883;
                case 8883:
                    return (char) 8882;
                case 8884:
                    return (char) 8885;
                case 8885:
                    return (char) 8884;
                case 8886:
                    return (char) 8887;
                case 8887:
                    return (char) 8886;
                case 8905:
                    return (char) 8906;
                case 8906:
                    return (char) 8905;
                case 8907:
                    return (char) 8908;
                case 8908:
                    return (char) 8907;
                case 8909:
                    return (char) 8771;
                case 8912:
                    return (char) 8913;
                case 8913:
                    return (char) 8912;
                case 8918:
                    return (char) 8919;
                case 8919:
                    return (char) 8918;
                case 8920:
                    return (char) 8921;
                case 8921:
                    return (char) 8920;
                case 8922:
                    return (char) 8923;
                case 8923:
                    return (char) 8922;
                case 8924:
                    return (char) 8925;
                case 8925:
                    return (char) 8924;
                case 8926:
                    return (char) 8927;
                case 8927:
                    return (char) 8926;
                case 8928:
                    return (char) 8929;
                case 8929:
                    return (char) 8928;
                case 8930:
                    return (char) 8931;
                case 8931:
                    return (char) 8930;
                case 8932:
                    return (char) 8933;
                case 8933:
                    return (char) 8932;
                case 8934:
                    return (char) 8935;
                case 8935:
                    return (char) 8934;
                case 8936:
                    return (char) 8937;
                case 8937:
                    return (char) 8936;
                case 8938:
                    return (char) 8939;
                case 8939:
                    return (char) 8938;
                case 8940:
                    return (char) 8941;
                case 8941:
                    return (char) 8940;
                case 8944:
                    return (char) 8945;
                case 8945:
                    return (char) 8944;
                case 8946:
                    return (char) 8954;
                case 8947:
                    return (char) 8955;
                case 8948:
                    return (char) 8956;
                case 8950:
                    return (char) 8957;
                case 8951:
                    return (char) 8958;
                case 8954:
                    return (char) 8946;
                case 8955:
                    return (char) 8947;
                case 8956:
                    return (char) 8948;
                case 8957:
                    return (char) 8950;
                case 8958:
                    return (char) 8951;
            }
        }
        if ((c & 65280) == 8960) {
            switch (c) {
                case 8968:
                    return (char) 8969;
                case 8969:
                    return (char) 8968;
                case 8970:
                    return (char) 8971;
                case 8971:
                    return (char) 8970;
                case 9001:
                    return (char) 9002;
                case 9002:
                    return (char) 9001;
                default:
                    return c;
            }
        }
        if ((c & 65280) == 9984) {
            switch (c) {
                case 10088:
                    return (char) 10089;
                case 10089:
                    return (char) 10088;
                case 10090:
                    return (char) 10091;
                case 10091:
                    return (char) 10090;
                case 10092:
                    return (char) 10093;
                case 10093:
                    return (char) 10092;
                case 10094:
                    return (char) 10095;
                case 10095:
                    return (char) 10094;
                case 10096:
                    return (char) 10097;
                case 10097:
                    return (char) 10096;
                case 10098:
                    return (char) 10099;
                case 10099:
                    return (char) 10098;
                case 10100:
                    return (char) 10101;
                case 10101:
                    return (char) 10100;
                case 10197:
                    return (char) 10198;
                case 10198:
                    return (char) 10197;
                case 10205:
                    return (char) 10206;
                case 10206:
                    return (char) 10205;
                case 10210:
                    return (char) 10211;
                case 10211:
                    return (char) 10210;
                case 10212:
                    return (char) 10213;
                case 10213:
                    return (char) 10212;
                case 10214:
                    return (char) 10215;
                case 10215:
                    return (char) 10214;
                case 10216:
                    return (char) 10217;
                case 10217:
                    return (char) 10216;
                case 10218:
                    return (char) 10219;
                case 10219:
                    return (char) 10218;
                default:
                    return c;
            }
        }
        if ((c & 65280) == 10496) {
            switch (c) {
                case 10627:
                    return (char) 10628;
                case 10628:
                    return (char) 10627;
                case 10629:
                    return (char) 10630;
                case 10630:
                    return (char) 10629;
                case 10631:
                    return (char) 10632;
                case 10632:
                    return (char) 10631;
                case 10633:
                    return (char) 10634;
                case 10634:
                    return (char) 10633;
                case 10635:
                    return (char) 10636;
                case 10636:
                    return (char) 10635;
                case 10637:
                    return (char) 10640;
                case 10638:
                    return (char) 10639;
                case 10639:
                    return (char) 10638;
                case 10640:
                    return (char) 10637;
                case 10641:
                    return (char) 10642;
                case 10642:
                    return (char) 10641;
                case 10643:
                    return (char) 10644;
                case 10644:
                    return (char) 10643;
                case 10645:
                    return (char) 10646;
                case 10646:
                    return (char) 10645;
                case 10647:
                    return (char) 10648;
                case 10648:
                    return (char) 10647;
                case 10680:
                    return (char) 8856;
                case 10688:
                    return (char) 10689;
                case 10689:
                    return (char) 10688;
                case 10692:
                    return (char) 10693;
                case 10693:
                    return (char) 10692;
                case 10703:
                    return (char) 10704;
                case 10704:
                    return (char) 10703;
                case 10705:
                    return (char) 10706;
                case 10706:
                    return (char) 10705;
                case 10708:
                    return (char) 10709;
                case 10709:
                    return (char) 10708;
                case 10712:
                    return (char) 10713;
                case 10713:
                    return (char) 10712;
                case 10714:
                    return (char) 10715;
                case 10715:
                    return (char) 10714;
                case 10741:
                    return (char) 8725;
                case 10744:
                    return (char) 10745;
                case 10745:
                    return (char) 10744;
                case 10748:
                    return (char) 10749;
                case 10749:
                    return (char) 10748;
                default:
                    return c;
            }
        }
        if ((c & 65280) != 10752) {
            if ((c & 65280) != 12288) {
                if ((c & 65280) != 65280) {
                    return c;
                }
                switch (c) {
                    case 65288:
                        return (char) 65289;
                    case 65289:
                        return (char) 65288;
                    case 65308:
                        return (char) 65310;
                    case 65310:
                        return (char) 65308;
                    case 65339:
                        return (char) 65341;
                    case 65341:
                        return (char) 65339;
                    case 65371:
                        return (char) 65373;
                    case 65373:
                        return (char) 65371;
                    case 65375:
                        return (char) 65376;
                    case 65376:
                        return (char) 65375;
                    case 65378:
                        return (char) 65379;
                    case 65379:
                        return (char) 65378;
                    default:
                        return c;
                }
            }
            switch (c) {
                case 12296:
                    return (char) 12297;
                case 12297:
                    return (char) 12296;
                case 12298:
                    return (char) 12299;
                case 12299:
                    return (char) 12298;
                case 12300:
                    return (char) 12301;
                case 12301:
                    return (char) 12300;
                case 12302:
                    return (char) 12303;
                case 12303:
                    return (char) 12302;
                case 12304:
                    return (char) 12305;
                case 12305:
                    return (char) 12304;
                case 12306:
                case 12307:
                default:
                    return c;
                case 12308:
                    return (char) 12309;
                case 12309:
                    return (char) 12308;
                case 12310:
                    return (char) 12311;
                case 12311:
                    return (char) 12310;
                case 12312:
                    return (char) 12313;
                case 12313:
                    return (char) 12312;
                case 12314:
                    return (char) 12315;
                case 12315:
                    return (char) 12314;
            }
        }
        switch (c) {
            case 10795:
                return (char) 10796;
            case 10796:
                return (char) 10795;
            case 10797:
                return (char) 10796;
            case 10798:
                return (char) 10797;
            case 10804:
                return (char) 10805;
            case 10805:
                return (char) 10804;
            case 10812:
                return (char) 10813;
            case 10813:
                return (char) 10812;
            case 10852:
                return (char) 10853;
            case 10853:
                return (char) 10852;
            case 10873:
                return (char) 10874;
            case 10874:
                return (char) 10873;
            case 10877:
                return (char) 10878;
            case 10878:
                return (char) 10877;
            case 10879:
                return (char) 10880;
            case 10880:
                return (char) 10879;
            case 10881:
                return (char) 10882;
            case 10882:
                return (char) 10881;
            case 10883:
                return (char) 10884;
            case 10884:
                return (char) 10883;
            case 10891:
                return (char) 10892;
            case 10892:
                return (char) 10891;
            case 10897:
                return (char) 10898;
            case 10898:
                return (char) 10897;
            case 10899:
                return (char) 10900;
            case 10900:
                return (char) 10899;
            case 10901:
                return (char) 10902;
            case 10902:
                return (char) 10901;
            case 10903:
                return (char) 10904;
            case 10904:
                return (char) 10903;
            case 10905:
                return (char) 10906;
            case 10906:
                return (char) 10905;
            case 10907:
                return (char) 10908;
            case 10908:
                return (char) 10907;
            case 10913:
                return (char) 10914;
            case 10914:
                return (char) 10913;
            case 10918:
                return (char) 10919;
            case 10919:
                return (char) 10918;
            case 10920:
                return (char) 10921;
            case 10921:
                return (char) 10920;
            case 10922:
                return (char) 10923;
            case 10923:
                return (char) 10922;
            case 10924:
                return (char) 10925;
            case 10925:
                return (char) 10924;
            case 10927:
                return (char) 10928;
            case 10928:
                return (char) 10927;
            case 10931:
                return (char) 10932;
            case 10932:
                return (char) 10931;
            case 10939:
                return (char) 10940;
            case 10940:
                return (char) 10939;
            case 10941:
                return (char) 10942;
            case 10942:
                return (char) 10941;
            case 10943:
                return (char) 10944;
            case 10944:
                return (char) 10943;
            case 10945:
                return (char) 10946;
            case 10946:
                return (char) 10945;
            case 10947:
                return (char) 10948;
            case 10948:
                return (char) 10947;
            case 10949:
                return (char) 10950;
            case 10950:
                return (char) 10949;
            case 10957:
                return (char) 10958;
            case 10958:
                return (char) 10957;
            case 10959:
                return (char) 10960;
            case 10960:
                return (char) 10959;
            case 10961:
                return (char) 10962;
            case 10962:
                return (char) 10961;
            case 10963:
                return (char) 10964;
            case 10964:
                return (char) 10963;
            case 10965:
                return (char) 10966;
            case 10966:
                return (char) 10965;
            case 10974:
                return (char) 8870;
            case 10979:
                return (char) 8873;
            case 10980:
                return (char) 8872;
            case 10981:
                return (char) 8875;
            case 10988:
                return (char) 10989;
            case 10989:
                return (char) 10988;
            case 10999:
                return (char) 11000;
            case 11000:
                return (char) 10999;
            case 11001:
                return (char) 11002;
            case 11002:
                return (char) 11001;
            default:
                return c;
        }
    }

    private static int m430b(InputStream inputStream) {
        int read = inputStream.read();
        if (read >= 0) {
            f259ky++;
        }
        return read;
    }

    static int m431b(byte[] bArr, int i, int i2) {
        int i3 = i + 1;
        bArr[i] = (byte) i2;
        int i4 = i3 + 1;
        bArr[i3] = (byte) (i2 >>> 8);
        int i5 = i4 + 1;
        bArr[i4] = (byte) (i2 >>> 16);
        int i6 = i5 + 1;
        bArr[i5] = (byte) (i2 >>> 24);
        return i6;
    }

    static String m432b(int i, String str) {
        int m499f = m499f(i, str);
        return C0338r.f2518sh ? C0463b.m2526p(m499f, str) : C0288ao.m783h(m499f, str);
    }

    static String m433b(String str, String str2, String str3) {
        int indexOf = str.indexOf(str2);
        while (indexOf != -1) {
            str = new StringBuffer().append(str.substring(0, indexOf)).append(str3).append(str.substring(str2.length() + indexOf)).toString();
            indexOf = str.indexOf(str2, indexOf + str3.length());
        }
        return str;
    }

    public static String m434b(byte[] bArr) {
        return m483c(bArr, 0, bArr.length);
    }

    static short m435b(byte[] bArr, int i) {
        return (short) (((bArr[i + 1] & 255) << 8) | (bArr[i] & 255));
    }

    static final void m436b(int i, int i2, int i3, int i4) {
        m484c(i, i2, i3, i4);
    }

    static final void m437b(int i, boolean z) {
        f233kY |= 1 << i;
        if (!f231kW && ((1 << i) & 2559) != 0) {
            f233kY &= -2560;
        }
        if (((1 << i) & 31) != 0) {
            f278lc |= 1 << i;
        }
        if (i == 14 || i != 18 || C0338r.f2439rG) {
            return;
        }
        m342C("PFX_EnableEffect: Free Rotate Scale Effect is not enabled, you must set pfx_useSpriteEffectFreeRotateScale to TRUE!");
    }

    static final void m438b(C0048ac c0048ac, float f, float f2, float f3, float f4) {
        m498e(c0048ac, f, f2, f3, f4);
    }

    static final void m439b(C0048ac c0048ac, float f, float f2, float f3, float f4, int i, int i2) {
        int i3 = ((i % 360) + 360) % 360;
        int i4 = i2 % 360 == 0 ? 360 : ((i2 % 360) + 360) % 360;
        m387a(c0048ac, 0, 2);
        if (f180jX + (i4 << 1) > C0338r.f2218mt) {
            m465bl();
        }
        m377a(f, f2, f3, f4, i3, i4, false);
        m414ag(i4 << 1);
        f180jX += i4 << 1;
    }

    static void m440b(C0048ac c0048ac, float f, float f2, float f3, float f4, int i, int i2, int i3) {
        m386a(c0048ac, f, f2, f3, f4, i, i2, i3, true);
    }

    static void m441b(String str, int i) {
        m344E(str);
        if (C0338r.f2253nc) {
            m420am(i);
        } else {
            m473bt();
        }
        if (C0338r.f2253nc && f224kP == null) {
            f224kP = new int[C0338r.f2254nd];
            for (int i2 = 0; i2 < C0338r.f2254nd; i2++) {
                f224kP[i2] = -1;
            }
            f225kQ = new byte[C0338r.f2254nd][];
            f227kS = new int[C0338r.f2254nd][];
            f226kR = new int[C0338r.f2254nd];
            if (C0338r.f2197mY) {
                f228kT = new String[C0338r.f2254nd][];
            }
        }
        m362Z(i);
        if (C0338r.f2253nc) {
            f224kP[i] = m497e(f162jF);
            m501j(true);
            if (C0338r.f2197mY) {
                m419al(f224kP[i]);
                return;
            }
            return;
        }
        m497e(f162jF);
        m501j(true);
        if (C0338r.f2197mY) {
            m472bs();
        }
    }

    static void m442b(int[] iArr, int i) {
        int length = iArr.length;
        if (length > 0) {
            iArr[0] = i;
        }
        int i2 = 1;
        while (i2 < length) {
            System.arraycopy(iArr, 0, iArr, i2, length - i2 < i2 ? length - i2 : i2);
            i2 += i2;
        }
    }

    private static byte[] m443b(String str, byte[] bArr) {
        int i;
        if (C0338r.f2238nN <= 0) {
            return m487c(str, bArr);
        }
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        while (!z) {
            try {
                m353N(new StringBuffer().append(str).append(i3).toString());
                if (f229kU.m235uD() > 0) {
                    i2 += f229kU.m233fp(1);
                    i3++;
                } else {
                    z = true;
                }
                m474bu();
            } catch (Exception e) {
                i = i3;
            }
        }
        i = i3;
        if (i2 <= 0) {
            return null;
        }
        byte[] bArr2 = new byte[i2];
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            byte[] m487c = m487c(new StringBuffer().append(str).append(i5).toString(), bArr);
            System.arraycopy(m487c, 0, bArr2, i4, m487c.length);
            i4 += m487c.length;
        }
        return bArr2;
    }

    static byte[] m444b(byte[] bArr, String str, boolean z) {
        int[] iArr;
        byte[] bArr2 = null;
        if (!"".equals(str) && str != null) {
            bArr2 = str.getBytes();
        }
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        int[] m401a = m401a(bArr, false, (int[]) null);
        int[] m401a2 = m401a(bArr2, false, (int[]) null);
        int length = m401a.length - 1;
        if (length > 0) {
            if (m401a2.length < 4) {
                iArr = new int[4];
                System.arraycopy(m401a2, 0, iArr, 0, m401a2.length);
            } else {
                iArr = m401a2;
            }
            int i = ((52 / (length + 1)) + 6) * (-1640531527);
            int i2 = m401a[0];
            while (i != 0) {
                int i3 = (i >>> 2) & 3;
                int i4 = i2;
                int i5 = length;
                while (i5 > 0) {
                    int i6 = m401a[i5 - 1];
                    i4 = m401a[i5] - (((i4 ^ i) + (i6 ^ iArr[(i5 & 3) ^ i3])) ^ (((i6 >>> 5) ^ (i4 << 2)) + ((i4 >>> 3) ^ (i6 << 4))));
                    m401a[i5] = i4;
                    i5--;
                }
                int i7 = m401a[length];
                int i8 = m401a[0] - (((iArr[(i5 & 3) ^ i3] ^ i7) + (i4 ^ i)) ^ (((i7 >>> 5) ^ (i4 << 2)) + ((i4 >>> 3) ^ (i7 << 4))));
                m401a[0] = i8;
                i -= -1640531527;
                i2 = i8;
            }
        }
        return m400a(m401a, true, (byte[]) null);
    }

    static boolean m445bA() {
        return C0338r.f2518sh ? C0463b.m2512cj() : C0288ao.m765cj();
    }

    static void m446bB() {
        if (C0338r.f2518sh) {
            C0463b.reset();
        } else {
            C0288ao.reset();
        }
    }

    static void m447bC() {
        if (C0338r.f2518sh) {
            C0463b.m2546qS();
        }
    }

    static long m448bD() {
        if (C0338r.f2518sh) {
            return C0463b.m2557rb();
        }
        return -1L;
    }

    static void m449bE() {
        if (C0338r.f2518sh) {
            C0463b.m2551qX();
        }
    }

    static int m450bF() {
        return C0338r.f2518sh ? C0463b.m2511cI() : C0288ao.m750cI();
    }

    static long m451bG() {
        return C0338r.f2518sh ? C0463b.m2548qU() : C0288ao.m747cF();
    }

    static boolean m452bH() {
        return false;
    }

    static C0286am m453bI() {
        if (f266lF != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= f266lF.size()) {
                    break;
                }
                C0337q c0337q = (C0337q) f266lF.elementAt(i2);
                if (f267lG.equals(c0337q.f2162lP) && f268lH == c0337q.f2163lQ) {
                    return c0337q.f2164lR;
                }
                i = i2 + 1;
            }
        }
        return f265lE;
    }

    public static int m454ba() {
        if (f154iX == 0) {
            return -1;
        }
        int i = f189jg;
        do {
            i--;
            if (i < 0) {
                return -1;
            }
        } while ((f154iX & (1 << i)) == 0);
        return i;
    }

    static void m455bb() {
    }

    static void m456bc() {
    }

    private static void m457bd() {
        if (f162jF != null) {
            try {
                f162jF.close();
            } catch (Exception e) {
            }
            f162jF = null;
        }
        f166jJ = 0;
    }

    private static void m458be() {
        int i = f171jO == f169jM + (-1) ? f167jK - f170jN[f171jO] : f170jN[f171jO + 1] - f170jN[f171jO];
        f168jL = new int[i + 1];
        for (int i2 = 0; i2 < i + 1; i2++) {
            f168jL[i2] = (m461bh() & 255) | ((m461bh() & 255) << 8) | ((m461bh() & 255) << 16) | ((m461bh() & 255) << 24);
        }
    }

    private static void m459bf() {
        try {
            if (f162jF != null) {
                try {
                    f162jF.close();
                } catch (Throwable th) {
                }
                f162jF = null;
            }
        } catch (Throwable th2) {
        }
    }

    static final void m460bg() {
        m501j(true);
    }

    private static int m461bh() {
        int i = 0;
        try {
            i = f162jF.read();
        } catch (Exception e) {
        }
        f166jJ++;
        return i;
    }

    private static int m462bi() {
        return (m461bh() & 255) | ((m461bh() & 255) << 8);
    }

    public static void m463bj() {
        if (f235ka) {
            return;
        }
        f235ka = true;
        GLES10.glEnable(3553);
    }

    public static void m464bk() {
        if (f235ka) {
            f235ka = false;
            GLES10.glDisable(3553);
        }
    }

    public static boolean m465bl() {
        if (f180jX == 0) {
            return false;
        }
        f254kt++;
        f255ku += f180jX;
        f240kf.clear();
        f240kf.put(f241kg);
        f240kf.position(0);
        f242kh.clear();
        f242kh.put(f243ki);
        f242kh.position(0);
        f244kj.clear();
        f244kj.put(f245kk);
        f244kj.position(0);
        GLES10.glVertexPointer(f179jW, 5126, 0, f240kf);
        switch (f177jU) {
            case 0:
                GLES10.glColorPointer(4, 5121, 0, f244kj);
                GLES10.glDrawArrays(1, 0, f180jX);
                break;
            case 1:
                GLES10.glColorPointer(4, 5121, 0, f244kj);
                GLES10.glDrawArrays(4, 0, f180jX);
                break;
            case 2:
                m463bj();
                GLES10.glBindTexture(3553, f181jY.m682cd());
                GLES10.glTexCoordPointer(2, 5126, 0, f242kh);
                GLES10.glDrawArrays(4, 0, f180jX);
                break;
        }
        f181jY = null;
        f180jX = 0;
        return true;
    }

    static final long m466bm() {
        return System.currentTimeMillis();
    }

    public static boolean m467bn() {
        return f182jZ && C0338r.f2220mv;
    }

    public static void m468bo() {
        f213kE = new byte[64];
        f211kC = new long[]{0};
        int[] iArr = new int[4];
        f209kA = iArr;
        iArr[0] = 1732584193;
        f209kA[1] = -271733879;
        f209kA[2] = -1732584194;
        f209kA[3] = 271733878;
    }

    public static String m469bp() {
        int i = 0;
        f214kF = new byte[64];
        f212kD = new long[]{0};
        f210kB = new int[4];
        System.arraycopy(f213kE, 0, f214kF, 0, f214kF.length);
        System.arraycopy(f209kA, 0, f210kB, 0, f210kB.length);
        f212kD = f211kC;
        byte[] m489c = m489c(new int[]{(int) (f212kD[0] << 3), (int) (f212kD[0] >> 29)}, 8);
        int i2 = (int) (f212kD[0] & 63);
        m395a(f214kF, f210kB, f212kD, f215kG, 0, i2 < 56 ? 56 - i2 : 120 - i2);
        m395a(f214kF, f210kB, f212kD, m489c, 0, 8);
        byte[] m489c2 = m489c(f210kB, 16);
        char[] cArr = new char[m489c2.length << 1];
        for (int i3 = 0; i3 < m489c2.length; i3++) {
            int i4 = i + 1;
            cArr[i] = f216kH[(m489c2[i3] >>> 4) & 15];
            i = i4 + 1;
            cArr[i4] = f216kH[m489c2[i3] & 15];
        }
        return new String(cArr);
    }

    public static void m470bq() {
        if (f218kJ) {
            return;
        }
        f217kI = new int[256];
        for (int i = 0; i < 256; i++) {
            int i2 = i;
            for (int i3 = 8; i3 > 0; i3--) {
                i2 = (i2 & 1) == 1 ? (i2 >>> 1) ^ (-306674912) : i2 >>> 1;
            }
            f217kI[i] = i2;
        }
        f218kJ = true;
    }

    static int m471br() {
        try {
            String property = System.getProperty("microedition.locale");
            if (property == null) {
                return -1;
            }
            String upperCase = property.toUpperCase();
            if (upperCase.indexOf("EN") >= 0) {
                return 0;
            }
            if (upperCase.indexOf("DE") >= 0) {
                return 1;
            }
            if (upperCase.indexOf("FR") >= 0) {
                return 2;
            }
            if (upperCase.indexOf("IT") >= 0) {
                return 3;
            }
            if (upperCase.indexOf("ES") >= 0) {
                return 4;
            }
            if (upperCase.indexOf("BR") >= 0) {
                return 5;
            }
            if (upperCase.indexOf("PT") >= 0) {
                return 6;
            }
            if (upperCase.indexOf("JA") < 0 && upperCase.indexOf("JP") < 0) {
                if (upperCase.indexOf("ZH") < 0 && upperCase.indexOf("CN") < 0) {
                    if (upperCase.indexOf("KO") < 0 && upperCase.indexOf("KP") < 0 && upperCase.indexOf("KR") < 0) {
                        if (upperCase.indexOf("RU") >= 0) {
                            return 10;
                        }
                        if (upperCase.indexOf("PL") >= 0) {
                            return 12;
                        }
                        if (upperCase.indexOf("TR") >= 0) {
                            return 11;
                        }
                        if (upperCase.indexOf("CZ") >= 0) {
                            return 13;
                        }
                        if (upperCase.indexOf("NL") >= 0) {
                            return 14;
                        }
                        if (upperCase.indexOf("TH") >= 0) {
                            return 15;
                        }
                        if (upperCase.indexOf("VI") < 0 && upperCase.indexOf("VN") < 0) {
                            return upperCase.indexOf("AR") >= 0 ? 17 : -1;
                        }
                        return 16;
                    }
                    return 9;
                }
                return 8;
            }
            return 7;
        } catch (Exception e) {
            return -1;
        }
    }

    private static void m472bs() {
        int i = 0;
        if (C0338r.f2253nc) {
            while (i < C0338r.f2254nd) {
                m419al(i);
                i++;
            }
            return;
        }
        String[] strArr = new String[f219kK];
        while (i < f219kK) {
            strArr[i] = m418ak(i);
            i++;
        }
        f223kO = strArr;
        f222kN = null;
        f221kM = null;
        boolean z = C0338r.f2168lV;
    }

    static void m473bt() {
        if (C0338r.f2253nc) {
            for (int i = 0; i < C0338r.f2254nd; i++) {
                m420am(i);
            }
            return;
        }
        if (f223kO != null) {
            for (int i2 = 0; i2 < f219kK; i2++) {
                f223kO[i2] = null;
            }
            f223kO = null;
        }
        f222kN = null;
        f221kM = null;
        f219kK = 0;
    }

    private static void m474bu() {
        if (f229kU == null) {
            return;
        }
        try {
            C0100b c0100b = f229kU;
            C0100b.m229uC();
        } catch (C0101c e) {
        }
        f229kU = null;
    }

    static final int m475bv() {
        int i = f234kZ[18][1];
        return i != 100 ? i : f234kZ[18][3];
    }

    static final int m476bw() {
        int i = f234kZ[18][1];
        return i != 100 ? i : f234kZ[18][4];
    }

    public static final void m477bx() {
        if (C0338r.f2455rW) {
            f282lg = 0;
            if (C0338r.f2456rX > 1) {
                if (f300ly == null) {
                    f293lr = new int[C0338r.f2456rX];
                    f294ls = new int[C0338r.f2456rX];
                    f295lt = new int[C0338r.f2456rX];
                    f296lu = new int[C0338r.f2456rX];
                    f298lw = new int[C0338r.f2456rX];
                    f299lx = new int[C0338r.f2456rX];
                    f297lv = new int[C0338r.f2456rX];
                    f300ly = new boolean[C0338r.f2456rX];
                    f301lz = new boolean[C0338r.f2456rX];
                    f261lA = new boolean[C0338r.f2456rX];
                }
                for (int i = 0; i < C0338r.f2456rX; i++) {
                    f297lv[i] = 0;
                }
            }
        }
    }

    private static boolean m478by() {
        return f263lC != null;
    }

    private static void m479bz() {
        f263lC = new int[128];
        for (int i = 0; i < f263lC.length; i++) {
            f263lC[i] = -1;
        }
        for (int i2 = 0; i2 < f262lB.length; i2++) {
            f263lC[f262lB[i2]] = i2;
        }
    }

    private static int m480c(InputStream inputStream) {
        return (m430b(inputStream) & 255) | ((m430b(inputStream) & 255) << 8);
    }

    static int m481c(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = i2 + 1;
        return ((bArr[i2] & 255) << 8) | (bArr[i] & 255) | ((bArr[i3] & 255) << 16) | ((bArr[i3 + 1] & 255) << 24);
    }

    static long m482c(int i, String str) {
        int m499f = m499f(i, str);
        return C0338r.f2518sh ? C0463b.m2524i(m499f, str) : C0288ao.m784i(m499f, str);
    }

    public static String m483c(byte[] bArr, int i, int i2) {
        if (!m478by()) {
            m479bz();
        }
        char[] cArr = new char[((i2 + 2) / 3) << 2];
        int i3 = 0;
        for (int i4 = 0; i4 < cArr.length; i4 += 4) {
            int i5 = i3 + 0;
            int i6 = i2 - i3;
            byte b2 = bArr[i5];
            cArr[i4] = f262lB[(b2 >>> 2) & 63];
            if (i6 > 2) {
                byte b3 = bArr[i5 + 1];
                byte b4 = bArr[i5 + 2];
                cArr[i4 + 1] = f262lB[((b2 << 4) & 48) + ((b3 >>> 4) & 15)];
                cArr[i4 + 2] = f262lB[((b3 << 2) & 60) + ((b4 >>> 6) & 3)];
                cArr[i4 + 3] = f262lB[b4 & 63];
            } else if (i6 > 1) {
                byte b5 = bArr[i5 + 1];
                cArr[i4 + 1] = f262lB[((b2 << 4) & 48) + ((b5 >>> 4) & 15)];
                cArr[i4 + 2] = f262lB[(b5 << 2) & 60];
                cArr[i4 + 3] = '=';
            } else {
                cArr[i4 + 1] = f262lB[(b2 << 4) & 48];
                cArr[i4 + 2] = '=';
                cArr[i4 + 3] = '=';
            }
            i3 += 3;
        }
        return new String(cArr);
    }

    static void m484c(int i, int i2, int i3, int i4) {
        m465bl();
        f236kb = i;
        f237kc = i2;
        f238kd = i3;
        f239ke = i4;
        int scaleY = (int) (f140iI * AbstractC0054c.getScaleY());
        int scaleX = (int) ((i * AbstractC0054c.getScaleX()) + AbstractC0054c.m130tR());
        int scaleY2 = (int) ((i2 * AbstractC0054c.getScaleY()) - AbstractC0054c.m131tS());
        int scaleX2 = (int) (i3 * AbstractC0054c.getScaleX());
        int scaleY3 = (int) (i4 * AbstractC0054c.getScaleY());
        GLES10.glScissor(scaleX, (scaleY - scaleY2) - scaleY3, scaleX2, scaleY3);
    }

    static final void m485c(int i, boolean z) {
        f233kY &= (1 << i) ^ (-1);
        if (((1 << i) & 31) != 0) {
            f278lc &= (1 << i) ^ (-1);
        }
    }

    static final void m486c(C0048ac c0048ac, float f, float f2, float f3, float f4) {
        m494d(c0048ac, f, f2, f3, f4);
    }

    private static byte[] m487c(String str, byte[] bArr) {
        byte[] bArr2 = null;
        try {
            m353N(str);
            if (f229kU.m235uD() > 0) {
                bArr2 = f229kU.m234fq(1);
            }
        } catch (C0101c e) {
        }
        m474bu();
        return bArr2;
    }

    static byte[] m488c(int[] iArr) {
        return m400a(iArr, false, (byte[]) null);
    }

    private static byte[] m489c(int[] iArr, int i) {
        byte[] bArr = new byte[i];
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3 += 4) {
            bArr[i3] = (byte) iArr[i2];
            bArr[i3 + 1] = (byte) (iArr[i2] >>> 8);
            bArr[i3 + 2] = (byte) (iArr[i2] >>> 16);
            bArr[i3 + 3] = (byte) (iArr[i2] >>> 24);
            i2++;
        }
        return bArr;
    }

    private static int m490d(InputStream inputStream) {
        return (m430b(inputStream) & 255) | ((m430b(inputStream) & 255) << 8) | ((m430b(inputStream) & 255) << 16) | ((m430b(inputStream) & 255) << 24);
    }

    static long m491d(int i, String str) {
        int m499f = m499f(i, str);
        if (C0338r.f2518sh) {
            return C0463b.m2568s(m499f, str);
        }
        return 0L;
    }

    static long m492d(byte[] bArr, int i) {
        int i2 = i + 1 + 1 + 1;
        long j = (bArr[i] & 255) | ((bArr[r0] & 255) << 8) | ((bArr[r3] & 255) << 16);
        long j2 = j | ((bArr[i2] & 255) << 24);
        long j3 = j2 | ((bArr[r3] & 255) << 32);
        int i3 = i2 + 1 + 1 + 1;
        return j3 | ((bArr[r2] & 255) << 40) | ((bArr[i3] & 255) << 48) | ((bArr[i3 + 1] & 255) << 56);
    }

    protected static void m493d(int i, int i2, int i3, int i4) {
        m465bl();
        GLES10.glColor4f(i / 255.0f, i2 / 255.0f, i3 / 255.0f, i4 / 255.0f);
    }

    private static void m494d(C0048ac c0048ac, float f, float f2, float f3, float f4) {
        m387a(c0048ac, 0, 2);
        if (f180jX + 8 > C0338r.f2218mt) {
            m465bl();
        }
        int i = f180jX << 1;
        int i2 = i + 1;
        f241kg[i] = f;
        int i3 = i2 + 1;
        f241kg[i2] = f2;
        int i4 = i3 + 1;
        f241kg[i3] = f + f3;
        int i5 = i4 + 1;
        f241kg[i4] = f2;
        int i6 = i5 + 1;
        f241kg[i5] = f + f3;
        int i7 = i6 + 1;
        f241kg[i6] = f2;
        int i8 = i7 + 1;
        f241kg[i7] = f + f3;
        int i9 = i8 + 1;
        f241kg[i8] = f2 + f4;
        int i10 = i9 + 1;
        f241kg[i9] = f + f3;
        int i11 = i10 + 1;
        f241kg[i10] = f2 + f4;
        int i12 = i11 + 1;
        f241kg[i11] = f;
        int i13 = i12 + 1;
        f241kg[i12] = f2 + f4;
        int i14 = i13 + 1;
        f241kg[i13] = f;
        int i15 = i14 + 1;
        f241kg[i14] = f2 + f4;
        f241kg[i15] = f;
        f241kg[i15 + 1] = f2;
        m414ag(8);
        f180jX += 8;
    }

    static void m495d(String str, byte[] bArr) {
        byte[] bArr2 = null;
        if (!"".equals("") && "" != 0) {
            bArr2 = "".getBytes();
        }
        int length = bArr.length;
        if (C0338r.f2238nN <= 0) {
            m393a(str, bArr, 0, length, bArr2);
            return;
        }
        int length2 = bArr.length;
        int i = 0;
        int i2 = 0;
        while (length2 > 0) {
            m393a(new StringBuffer().append(str).append(i).toString(), bArr, i2, C0338r.f2238nN < length2 ? C0338r.f2238nN : length2, bArr2);
            i2 += C0338r.f2238nN;
            length2 -= C0338r.f2238nN;
            i++;
        }
    }

    static float m496e(int i, String str) {
        int m499f = m499f(i, str);
        if (C0338r.f2518sh) {
            return C0463b.m2569t(m499f, str);
        }
        return 0.0f;
    }

    private static int m497e(InputStream inputStream) {
        int i = 0;
        if (!C0338r.f2253nc) {
            try {
                int m490d = m490d(inputStream);
                f219kK = m490d;
                f222kN = new int[m490d + 1];
                for (int i2 = 1; i2 < f219kK + 1; i2++) {
                    f222kN[i2] = m490d(inputStream);
                }
                f221kM = new byte[f222kN[f219kK]];
                m364a(inputStream, f221kM, 0, f221kM.length);
            } catch (Exception e) {
            }
            return f221kM.length + ((f219kK + 1) << 2);
        }
        try {
            i = m430b(inputStream);
            f226kR[i] = m490d(inputStream);
            if (f226kR[i] > (1 << C0338r.f2255ne)) {
                f226kR[i] = 1 << C0338r.f2255ne;
            }
            f227kS[i] = new int[f226kR[i] + 1];
            for (int i3 = 1; i3 < f226kR[i] + 1; i3++) {
                f227kS[i][i3] = m490d(inputStream);
            }
            f225kQ[i] = new byte[f227kS[i][f226kR[i]]];
            m364a(inputStream, f225kQ[i], 0, f225kQ[i].length);
            return i;
        } catch (Exception e2) {
            return i;
        }
    }

    private static void m498e(C0048ac c0048ac, float f, float f2, float f3, float f4) {
        m387a(c0048ac, 1, 2);
        if (f180jX + 6 > C0338r.f2218mt) {
            m465bl();
        }
        m376a(f, f2, f3, f4, 0);
        m414ag(6);
        f180jX += 6;
    }

    static int m499f(int i, String str) {
        return !C0338r.f2521sk ? i : C0338r.f2518sh ? C0463b.m2527q(i, str) : C0288ao.m786k(i, str);
    }

    static void m500f(C0048ac c0048ac, float f, float f2, float f3, float f4) {
        m498e(c0048ac, f, f2, f3, f4);
    }

    static final void m501j(boolean z) {
        m457bd();
        if (f163jG == 3) {
            f164jH = null;
        } else {
            int i = f163jG;
        }
        if (z) {
            f161jE = null;
        }
        boolean z2 = C0338r.f2168lV;
    }

    static final void m502k(boolean z) {
        f234kZ[18][5] = z ? 1 : 0;
    }

    public static void m503n(String str, String str2) {
        if (str2 == null) {
            str2 = "ISO8859_1";
        }
        byte[] bytes = str.getBytes(str2);
        m395a(f213kE, f209kA, f211kC, bytes, 0, bytes.length);
    }

    static int m504p(int i, int i2) {
        if (i2 == i) {
            return i2;
        }
        int nextInt = f201js.nextInt();
        if (nextInt < 0) {
            nextInt = -nextInt;
        }
        return i + (nextInt % (i2 - i));
    }

    private static void m505q(int i, int i2) {
        if (!C0338r.f2455rW || C0338r.f2456rX <= 1) {
            return;
        }
        m506r(i, i2);
    }

    private static void m506r(int i, int i2) {
        if (!C0338r.f2455rW || C0338r.f2456rX > 1) {
            return;
        }
        m505q(i, i2);
    }

    private static void m507s(int i, int i2) {
        if (C0338r.f2455rW) {
            if (C0338r.f2456rX <= 1) {
                m505q(f282lg, i2);
                f282lg = i2;
                return;
            }
            m506r(f297lv[i], i2);
            f297lv[i] = i2;
            if (i == 0) {
                f282lg = i2;
            }
        }
    }

    private static int m508w(int i, int i2) {
        return i2 == 18 ? i : i2 == 3 ? i | 64 : i2 == 0 ? i | 128 : i;
    }

    @Override
    protected final void mo142T(int i) {
        int m358V = 1 << m358V(i);
        f183ja |= m358V;
        f156iZ = m358V | f156iZ;
    }

    @Override
    protected final void mo143U(int i) {
        int m358V = 1 << m358V(i);
        f184jb |= m358V;
        f156iZ = (m358V ^ (-1)) & f156iZ;
    }

    final void m509a(int i, String str) {
        if (!C0338r.f2518sh && System.currentTimeMillis() - f264lD <= 3000) {
            m342C("Reject duplicated call within 3s");
            return;
        }
        f264lD = System.currentTimeMillis();
        int m499f = m499f(i, str);
        if (C0338r.f2518sh) {
            C0463b.m2506b(m499f, str, 0L);
        } else {
            C0288ao.m714a(m499f, str, 0L);
        }
    }

    public void mo510a(int i, String str, String str2, int i2, String str3, Exception exc) {
    }

    @Override
    public final void mo144a(GL10 gl10) {
        if (AbstractC0054c.aiJ != gl10) {
            AbstractC0054c.aiJ = gl10;
            f134iC = new C0048ac();
            int i = f139iH;
            int i2 = f140iI;
            GLES10.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
            GLES10.glHint(3152, 4353);
            GLES10.glShadeModel(7425);
            GLES10.glDisable(2929);
            GLES10.glEnable(3042);
            GLES10.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            GLES10.glEnable(3089);
            GLES10.glFogf(2917, 9729.0f);
            GLES10.glFogf(2914, 1.0f);
            GLES10.glHint(3156, 4352);
            int scaleX = (int) (i * AbstractC0054c.getScaleX());
            int scaleY = (int) (i2 * AbstractC0054c.getScaleY());
            GLES10.glViewport(AbstractC0054c.m130tR(), AbstractC0054c.m131tS(), scaleX, scaleY);
            GLES10.glMatrixMode(5889);
            GLES10.glLoadIdentity();
            GLU.gluOrtho2D(AbstractC0054c.aiJ, 0.0f, scaleX, scaleY, 0.0f);
            f241kg = new float[C0338r.f2218mt << 1];
            f243ki = new float[C0338r.f2218mt << 1];
            f245kk = new byte[C0338r.f2218mt << 2];
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(f241kg.length << 2);
            allocateDirect.order(ByteOrder.nativeOrder());
            f240kf = allocateDirect.asFloatBuffer();
            ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(f243ki.length << 2);
            allocateDirect2.order(ByteOrder.nativeOrder());
            f242kh = allocateDirect2.asFloatBuffer();
            ByteBuffer allocateDirect3 = ByteBuffer.allocateDirect(f245kk.length << 2);
            allocateDirect3.order(ByteOrder.nativeOrder());
            f244kj = allocateDirect3;
            f180jX = 0;
            m415ah(0);
            m484c(0, 0, f139iH, f140iI);
            GLES10.glMatrixMode(5888);
            GLES10.glLoadIdentity();
            GLES10.glScalef(AbstractC0054c.getScaleX(), AbstractC0054c.getScaleY(), 1.0f);
            GLES10.glEnableClientState(32884);
        }
    }

    abstract void mo511aN();

    protected final void m512aO() {
        if (f136iE >= 0) {
            return;
        }
        f139iH = C0338r.f2166lT;
        f140iI = C0338r.f2167lU;
        if (C0338r.f2455rW) {
            m477bx();
        }
        if (C0338r.f2323ou) {
            m470bq();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (f201js == null) {
            f201js = new Random(currentTimeMillis);
        } else {
            f201js.setSeed(currentTimeMillis);
        }
        f136iE = 0;
        f142iK = false;
    }

    protected void mo513aP() {
        f175jS = null;
        boolean z = C0338r.f2168lV;
    }

    @Override
    protected void mo146aQ() {
        if (f135iD) {
            return;
        }
        f135iD = true;
        RunnableC0340t.m2122bW();
    }

    @Override
    protected final void mo147aR() {
        if (f135iD) {
            long currentTimeMillis = System.currentTimeMillis();
            f137iF = currentTimeMillis;
            f147iQ = currentTimeMillis;
            this.f302iN = currentTimeMillis;
            f135iD = false;
            m403aU();
            f138iG = true;
            if (C0338r.f2203me && !f142iK) {
                m155tW();
            }
            m406aY();
        }
    }

    @Override
    public void mo148aS() {
        mo146aQ();
    }

    @Override
    public void mo149aT() {
        mo147aR();
    }

    @Override
    public final void mo151aW() {
        boolean z = f151iU;
        if (f136iE >= 0) {
            try {
                m404aV();
            } catch (Exception e) {
            }
            f138iG = false;
        } else {
            mo513aP();
            f143iL.m216ux();
        }
    }

    @Override
    public void run() {
        try {
            m403aU();
            f142iK = false;
            while (f136iE >= 0) {
                m404aV();
            }
        } catch (Exception e) {
            f136iE = -1;
        }
        mo513aP();
        f143iL.m216ux();
    }

    @Override
    protected void mo154t(int i, int i2) {
        int i3 = f292lq;
        if (C0338r.f2455rW) {
            if (C0338r.f2456rX <= 1) {
                f283lh = i;
                f284li = i2;
                f290lo = true;
                return;
            }
            if (i3 == 0) {
                f283lh = i;
                f284li = i2;
            }
            f293lr[i3] = i;
            f294ls[i3] = i2;
            f301lz[i3] = true;
            if (i3 == 0) {
                f290lo = true;
            }
        }
    }

    @Override
    protected void mo156u(int i, int i2) {
        int i3 = f292lq;
        if (C0338r.f2455rW) {
            if (C0338r.f2456rX <= 1) {
                f283lh = i;
                f284li = i2;
                f289ln = true;
                return;
            }
            if (i3 == 0) {
                f283lh = i;
                f284li = i2;
            }
            f293lr[i3] = i;
            f294ls[i3] = i2;
            f300ly[i3] = true;
            if (i3 == 0) {
                f289ln = true;
            }
        }
    }

    @Override
    protected void mo157v(int i, int i2) {
        int i3 = f292lq;
        if (C0338r.f2455rW) {
            if (C0338r.f2456rX <= 1) {
                f283lh = i;
                f284li = i2;
                f291lp = true;
                return;
            }
            if (i3 == 0) {
                f283lh = i;
                f284li = i2;
            }
            f293lr[i3] = i;
            f294ls[i3] = i2;
            f261lA[i3] = true;
            if (i3 == 0) {
                f291lp = true;
            }
        }
    }
}
