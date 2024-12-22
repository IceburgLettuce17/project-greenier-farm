package com.gameloft.android.LATAM.GloftGF2H;

import com.facebook.internal.ServerProtocol;
import com.facebook.widget.PlacePickerFragment;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Hashtable;

public final class C0335o {

    private static C0310bj f1958eC;

    private static boolean f1959eD;

    private static String f1961eF;

    private static String f1963eH;

    private static String f1964eI;

    private static long f1965eJ;

    private static String f1966eK;

    private static String f1967eL;

    private static String f1968eM;

    private static String f1969eN;

    private static int[] f1970eO;

    private static int[] f1971eP;

    private static long[] f1972eQ;

    private static String[] f1973eR;

    private static C0310bj f1974eS;

    private static RunnableC0345y[] f1975eT;

    private static long f1976eU;

    private static String f1977eV;

    private static String f1978eW;

    private static String f1979eX;

    private static RunnableC0345y f1981eZ;

    private static int f1982fA;

    private static int f1983fB;

    private static String f1984fC;

    private static String f1985fD;

    private static String f1986fE;

    private static String f1987fF;

    private static String f1988fG;

    private static String f1989fH;

    private static String f1990fI;

    private static int f1991fJ;

    private static Object[][] f1993fa;

    private static String[][] f1994fc;

    private static String[][] f1995fd;

    private static String f1998fg;

    private static Exception f1999fh;

    private static String f2000fi;

    private static int[] f2001fj;

    private static Object[][] f2002fk;

    private static String[][] f2003fl;

    private static String[][] f2004fm;

    private static String[] f2005fn;

    private static String[] f2006fo;

    private static long[] f2007fp;

    private static boolean f2008fq;

    private static boolean f2009fr;

    private static int[] f2010fs;

    private static int[] f2011ft;

    private static boolean f2012fu;

    private static String f2013fv;

    private static String f2014fw;

    private static String f2015fx;

    private static boolean f2016fy;

    private static C0310bj f2017fz;

    private static final String[] f1957eB = {"message", "asset", "auth", "leaderboard", "social", "storage", "lobby", "matchmaker", "gllive", "bridge", "config", "chat", ""};

    private static int f1960eE = C0338r.f2469rk;

    private static String f1962eG = "";

    private static int f1980eY = -1;

    private static int f1996fe = C0338r.f2384qD;

    private static int f1997ff = 200;

    private static char[] f1992fK = {' ', '{', '}', ':', '*', ',', '|', '\"', '+', '-', '/', '$', '='};

    private static String m1990H(int i) {
        byte[] m834dA;
        int m1998P = m1998P(i);
        if (m1998P == InterfaceC0336p.f2115he) {
            String str = ((String[]) f2002fk[i])[0];
            if (str == null) {
                m2011a(false, i, 6, false);
            } else {
                m1996N(i);
                f1973eR[6] = str;
            }
        } else {
            m1996N(i);
        }
        if (!m2058o(i, 0)) {
            if (!m2058o(i, 1) || (m834dA = f1974eS.m834dA()) == null) {
                return null;
            }
            String str2 = new String(m834dA);
            if (m1998P != InterfaceC0336p.f2123hm && m1998P != InterfaceC0336p.f2124hn && m1998P != InterfaceC0336p.f2122hl) {
                C0284ak c0284ak = new C0284ak(str2);
                try {
                    if (m1998P == InterfaceC0336p.f2115he) {
                        str2 = c0284ak.m704ab("nonce");
                    } else if (m1998P == InterfaceC0336p.f2119hi) {
                        str2 = c0284ak.m704ab("room_id");
                    } else {
                        if (m1998P == InterfaceC0336p.f2120hj) {
                            if (m2016a(i, c0284ak)) {
                                str2 = m2003a(c0284ak.m704ab("controller_host"), c0284ak.m703aa("controller_tcp_port"));
                            }
                        } else if (m1998P == InterfaceC0336p.f2121hk) {
                            if (m2016a(i, c0284ak)) {
                                str2 = new StringBuffer("socket://").append(m2003a(c0284ak.m704ab("controller_host"), c0284ak.m703aa("controller_tcp_port"))).toString();
                            }
                        } else if (m1998P == InterfaceC0336p.f2116hf || m1998P == InterfaceC0336p.f2117hg || m1998P == InterfaceC0336p.f2118hh) {
                            m2016a(i, c0284ak);
                        }
                        str2 = null;
                    }
                } catch (Exception e) {
                    str2 = null;
                    GLLib.m456bc();
                }
            }
            if (!m2058o(i, 2)) {
                m2055n(i, 3);
            }
            return str2 == null ? "" : str2;
        }
        if (m1998P == InterfaceC0336p.f2115he) {
            C0310bj c0310bj = new C0310bj(m2063t(f1973eR[6]), false);
            f1974eS = c0310bj;
            c0310bj.connect();
            m2055n(i, 1);
            return null;
        }
        C0284ak c0284ak2 = new C0284ak();
        if (m1998P == InterfaceC0336p.f2116hf) {
            c0284ak2.m706g("action", "login");
            c0284ak2.m706g("access_token", f1968eM);
            c0284ak2.m706g("username", f2013fv);
        } else if (m1998P == InterfaceC0336p.f2117hg) {
            String[] strArr = (String[]) f2002fk[i];
            String str3 = strArr[0];
            String str4 = strArr[1];
            c0284ak2.m706g("action", "join room");
            c0284ak2.m706g("room_id", str3);
            if (str4 != null) {
                c0284ak2.m706g("reservation_code", str4);
            }
        } else if (m1998P == InterfaceC0336p.f2118hh) {
            String[] strArr2 = (String[]) f2002fk[i];
            String str5 = strArr2[0];
            String str6 = strArr2[1];
            c0284ak2.m706g("action", "leave room");
            c0284ak2.m706g("room_id", str5);
            c0284ak2.m706g("credential", str6);
        } else if (m1998P == InterfaceC0336p.f2120hj) {
            String str7 = ((String[]) f2002fk[i])[0];
            c0284ak2.m706g("action", "launch game");
            c0284ak2.m706g("room_id", str7);
        } else if (m1998P == InterfaceC0336p.f2124hn) {
            String[] strArr3 = (String[]) f2002fk[i];
            String str8 = strArr3[0];
            String str9 = strArr3[1];
            c0284ak2.m706g("action", "update user");
            c0284ak2.m706g("room_id", str8);
            c0284ak2.m706g("credential", str9);
        } else if (m1998P == InterfaceC0336p.f2123hm) {
            String[] strArr4 = (String[]) f2002fk[i];
            String str10 = strArr4[0];
            String str11 = strArr4[1];
            c0284ak2.m706g("action", "update room");
            c0284ak2.m706g("room_id", str10);
            if (str11 != null) {
                c0284ak2.m706g("name", str11);
            }
        } else if (m1998P == InterfaceC0336p.f2121hk) {
            String str12 = ((String[]) f2002fk[i])[0];
            c0284ak2.m706g("action", "get game controller");
            c0284ak2.m706g("room_id", str12);
        } else if (m1998P == InterfaceC0336p.f2122hl) {
            String str13 = ((String[]) f2002fk[i])[0];
            c0284ak2.m706g("action", "get room info");
            c0284ak2.m706g("room_id", str13);
        } else if (m1998P == InterfaceC0336p.f2119hi) {
            Object[] objArr = f2002fk[i];
            String str14 = ((String[]) objArr[0])[0];
            String str15 = ((String[]) objArr[0])[1];
            String[] strArr5 = (String[]) objArr[1];
            c0284ak2.m706g("action", "create room");
            c0284ak2.m706g("name", str14);
            if (!"-1".equals(str15)) {
                c0284ak2.m706g("capacity", str15);
            }
            if (strArr5 != null) {
                c0284ak2.m706g("reservation_codes", strArr5);
            }
        }
        String[] strArr6 = f2003fl[i];
        if (strArr6 != null) {
            for (int i2 = 0; i2 < strArr6.length; i2 += 2) {
                if (strArr6[i2] != null) {
                    c0284ak2.m706g(strArr6[i2], strArr6[i2 + 1]);
                }
            }
        }
        f1974eS.m833d(new StringBuffer().append(c0284ak2.toString()).append("\n").toString().getBytes());
        m2055n(i, 1);
        return null;
    }

    private static String m1991I(int i) {
        byte[] m834dA;
        String str;
        int m1998P = m1998P(i);
        m1996N(i);
        Object[] objArr = f2002fk[i];
        C0310bj c0310bj = (C0310bj) objArr[0];
        if (m2058o(i, 0)) {
            if (m1998P == InterfaceC0336p.f2127hq) {
                c0310bj.connect();
                m2055n(i, 1);
                return null;
            }
            C0284ak c0284ak = new C0284ak();
            if (m1998P == InterfaceC0336p.f2128hr) {
                c0284ak.m706g("action", "login");
                c0284ak.m706g("access_token", f1968eM);
                c0284ak.m706g("username", f2013fv);
            } else if (m1998P == InterfaceC0336p.f2129hs) {
                String str2 = (String) objArr[1];
                c0284ak.m706g("action", "connect game");
                c0284ak.m706g("room_id", str2);
            }
            c0310bj.m833d(new StringBuffer().append(c0284ak.toString()).append("\n").toString().getBytes());
            m2055n(i, 1);
            return null;
        }
        if (!m2058o(i, 1) || (m834dA = c0310bj.m834dA()) == null) {
            return null;
        }
        C0284ak c0284ak2 = new C0284ak(new String(m834dA));
        try {
        } catch (Exception e) {
            str = null;
            GLLib.m456bc();
        }
        if (m1998P == InterfaceC0336p.f2127hq) {
            if (m2016a(i, c0284ak2)) {
                str = c0284ak2.m704ab("nonce");
                if (!m2058o(i, 2)) {
                    m2055n(i, 3);
                }
                return str != null ? "" : str;
            }
        } else if (m1998P == InterfaceC0336p.f2116hf || m1998P == InterfaceC0336p.f2128hr || m1998P == InterfaceC0336p.f2129hs) {
            m2016a(i, c0284ak2);
        }
        str = null;
        if (!m2058o(i, 2)) {
        }
        if (str != null) {
        }
    }

    private static String m1992J(int i) {
        String m2038b;
        RunnableC0345y m1994L = m1994L(i);
        m1996N(i);
        if (m2058o(i, 0)) {
            m1994L.m2153a(f1978eW, "", 0);
            m2055n(i, 1);
        } else if (m2058o(i, 1) && m2020a(false, m1994L) && (m2038b = m2038b(false, m1994L)) != null) {
            f2010fs[i] = 0;
            C0284ak c0284ak = new C0284ak(m2038b);
            try {
                f1977eV = c0284ak.m704ab("pandora");
                f1979eX = new StringBuffer().append(c0284ak.m704ab("gllive-ope")).append("social_player.php").toString();
                c0284ak.m704ab("tapjoy");
                c0284ak.m704ab("offline_items");
                c0284ak.m704ab("game_portal");
                c0284ak.m704ab("status");
            } catch (Exception e) {
            }
            m2055n(i, 3);
            return m2038b;
        }
        return null;
    }

    private static String m1993K(int i) {
        RunnableC0345y m1994L = m1994L(i);
        m1996N(i);
        if (m2058o(i, 0)) {
            Object[] objArr = f1993fa[m1998P(i)];
            int intValue = ((Integer) objArr[0]).intValue();
            String str = f1957eB[intValue];
            boolean booleanValue = ((Boolean) objArr[1]).booleanValue();
            int intValue2 = ((Integer) objArr[2]).intValue();
            if (str != null) {
                m2011a(booleanValue, i, intValue, false);
            } else {
                m1996N(i);
            }
            String stringBuffer = new StringBuffer().append(m2037b(f1973eR[intValue], booleanValue)).append("/assets/").append(m2069z(m2033aM())).append("/").append(((String[]) f2002fk[i])[0]).toString();
            m1994L.m2155l(true);
            m1994L.m2153a(stringBuffer, "", intValue2);
            m2055n(i, 1);
        }
        if (m2058o(i, 1)) {
            if ((m1994L.f2665vo == null || m1994L.isInProgress()) ? false : true) {
                m1994L.m2155l(false);
                GLLib.m342C("Iris_DownloadAsset_Exec:Result");
                f1997ff = m1994L.f2669vs;
                f1976eU = m1994L.f2661vi;
                byte[] bArr = m1994L.f2665vo;
                String[] strArr = (String[]) f2002fk[i];
                if (bArr != null) {
                    f2010fs[i] = 0;
                    m2055n(i, 3);
                    try {
                        m2019a(strArr[1], bArr);
                    } catch (Exception e) {
                    }
                    return strArr[0];
                }
            }
        }
        return null;
    }

    private static RunnableC0345y m1994L(int i) {
        if (i < C0338r.f2384qD) {
            return f1975eT[i];
        }
        return null;
    }

    private static String m1995M(int i) {
        String str;
        String str2;
        int m1998P = m1998P(i);
        Object[] objArr = f1993fa[m1998P];
        int intValue = ((Integer) objArr[0]).intValue();
        String str3 = f1957eB[intValue];
        boolean booleanValue = ((Boolean) objArr[1]).booleanValue();
        int intValue2 = ((Integer) objArr[2]).intValue();
        RunnableC0345y m1994L = m1994L(i);
        if (str3 != null) {
            m2011a(booleanValue, i, intValue, false);
        } else {
            m1996N(i);
        }
        if (m2058o(i, 0)) {
            String[] strArr = (String[]) f2002fk[i];
            String[] strArr2 = f2003fl[i];
            String[] strArr3 = f1994fc[m1998P];
            String[] strArr4 = f1995fd[m1998P];
            String m2037b = m2037b(f1973eR[intValue], booleanValue);
            int i2 = 0;
            if (strArr3 != null) {
                for (int i3 = 0; i3 < strArr3.length; i3++) {
                    if (strArr3[i3] != null) {
                        m2037b = "clientId".equals(strArr3[i3]) ? new StringBuffer().append(m2037b).append("/").append(m2069z(m2033aM())).toString() : new StringBuffer().append(m2037b).append("/").append(m2069z(strArr3[i3])).toString();
                    } else {
                        if (strArr[i2] != null) {
                            m2037b = new StringBuffer().append(m2037b).append("/").append(m2069z(strArr[i2])).toString();
                        }
                        i2++;
                    }
                }
            }
            String str4 = m2037b;
            if (strArr4 != null) {
                String str5 = "";
                for (int i4 = 0; i4 < strArr4.length; i4++) {
                    if (strArr4[i4] != null) {
                        if ("clientId".equals(strArr4[i4])) {
                            str5 = m2004a(str5, "client_id", m2033aM(), true);
                        } else if ("access_token".equals(strArr4[i4])) {
                            str5 = f2006fo[i] != null ? m2004a(str5, "access_token", f2006fo[i], true) : m2004a(str5, "access_token", f1964eI, true);
                        } else if ("nonce".equals(strArr4[i4])) {
                            str5 = m2004a(str5, "nonce", f1969eN, true);
                        } else if ("&&".equals(strArr4[i4])) {
                            if (strArr[i2] != null) {
                                str5 = m2004a(str5, (String) null, strArr[i2], false);
                            }
                            i2++;
                        } else {
                            if (strArr[i2] != null) {
                                str5 = strArr4[i4].startsWith("&") ? m2004a(str5, strArr4[i4], GLLib.m483c(strArr[i2].getBytes(), 0, strArr[i2].getBytes().length), true) : m2004a(str5, strArr4[i4], strArr[i2], true);
                            }
                            i2++;
                        }
                    }
                }
                StringBuffer append = new StringBuffer().append("");
                if (intValue2 != 1) {
                    str5 = new StringBuffer("?").append(str5).toString();
                }
                str = append.append(str5).toString();
            } else {
                str = "";
            }
            if (strArr2 != null) {
                str2 = strArr4 != null ? str : "";
                for (int i5 = 0; i5 < strArr2.length; i5 += 2) {
                    str2 = m2004a(str2, strArr2[i5], strArr2[i5 + 1], true);
                }
                if (strArr4 == null) {
                    StringBuffer append2 = new StringBuffer().append(str);
                    if (intValue2 != 1) {
                        str2 = new StringBuffer("?").append(str2).toString();
                    }
                    str2 = append2.append(str2).toString();
                }
            } else {
                str2 = str;
            }
            if (m1998P == InterfaceC0336p.f2107hW) {
                String[] strArr5 = f2004fm[i];
                if (strArr5.length > 0) {
                    String str6 = strArr5[0];
                    if (str6 != null) {
                        m1994L.m2156p("If-None-Match", str6);
                    }
                    m1994L.m2152U("Etag");
                }
            }
            m1994L.m2153a(str4, str2, intValue2);
            m2055n(i, 1);
        }
        if (m2058o(i, 1) && m2020a(booleanValue, m1994L)) {
            boolean booleanValue2 = ((Boolean) objArr[3]).booleanValue();
            String m2038b = m2038b(booleanValue, m1994L);
            if (m1998P == InterfaceC0336p.f2107hW) {
                Hashtable hashtable = m1994L.f2676vz;
            }
            if (m2038b != null) {
                f2010fs[i] = 0;
                m2055n(i, 3);
                if (!booleanValue2) {
                    return m2038b;
                }
                try {
                    return new String(GLLib.m355P(m2038b));
                } catch (IOException e) {
                    GLLib.m456bc();
                    return m2038b;
                }
            }
        }
        return null;
    }

    private static void m1996N(int i) {
        if (m2058o(i, 3)) {
            m2055n(i, 0);
        }
    }

    private static synchronized int m1997O(int i) {
        int i2;
        synchronized (C0335o.class) {
            i2 = 0;
            while (true) {
                if (i2 >= f2001fj.length) {
                    i2 = -1;
                    break;
                }
                if (f2001fj[i2] == i) {
                    break;
                }
                i2++;
            }
        }
        return i2;
    }

    private static synchronized int m1998P(int i) {
        int i2;
        synchronized (C0335o.class) {
            i2 = f2001fj[i];
        }
        return i2;
    }

    private static synchronized void m1999Q(int i) {
        synchronized (C0335o.class) {
            f2001fj[i] = Integer.MAX_VALUE;
        }
    }

    private static synchronized void m2000R(int i) {
        synchronized (C0335o.class) {
            for (int i2 = i; i2 < f2001fj.length - 1; i2++) {
                f2001fj[i2] = f2001fj[i2 + 1];
                f2002fk[i2] = null;
                f2002fk[i2] = f2002fk[i2 + 1];
                f2003fl[i2] = f2003fl[i2 + 1];
                f2004fm[i2] = f2004fm[i2 + 1];
                f2006fo[i2] = f2006fo[i2 + 1];
                f2005fn[i2] = f2005fn[i2 + 1];
            }
            if (i < C0338r.f2384qD) {
                RunnableC0345y[] runnableC0345yArr = f1975eT;
                while (i < f1975eT.length - 1) {
                    f1975eT[i] = f1975eT[i + 1];
                    f1970eO[i] = f1970eO[i + 1];
                    f2007fp[i] = f2007fp[i + 1];
                    f2010fs[i] = f2010fs[i + 1];
                    i++;
                }
                f1975eT[f1975eT.length - 1] = new RunnableC0345y(false);
                f1970eO[f1970eO.length - 1] = 3;
            } else {
                new StringBuffer("Try to remove ").append(i).append(" request from array ").append(C0338r.f2384qD).append(" length").toString();
                GLLib.m455bb();
            }
            f2003fl[f2001fj.length - 1] = null;
            f2004fm[f2001fj.length - 1] = null;
            f2002fk[f2001fj.length - 1] = null;
            f2005fn[f2001fj.length - 1] = null;
            f2001fj[f2001fj.length - 1] = -1;
        }
    }

    private static int m2001S(int i) {
        Object[] objArr = f1993fa[i];
        if (objArr == null || objArr[0] == null) {
            return -1;
        }
        return ((Integer) objArr[0]).intValue();
    }

    private static String m2002a(char c) {
        for (int i = 0; i < f1992fK.length; i++) {
            if (f1992fK[i] == c) {
                return new StringBuffer("%").append(Integer.toHexString(c)).toString();
            }
        }
        return String.valueOf(c);
    }

    private static String m2003a(String str, int i) {
        return new StringBuffer().append(str).append(":").append(i).toString();
    }

    private static String m2004a(String str, String str2, String str3, boolean z) {
        if (z) {
            str3 = m2069z(str3);
        }
        if ("".equals(str)) {
            return new StringBuffer().append(str).append(str2 != null ? new StringBuffer().append(str2).append("=").toString() : "").append(str3).toString();
        }
        return new StringBuffer().append(str).append("&").append(str2 != null ? new StringBuffer().append(str2).append("=").toString() : "").append(str3).toString();
    }

    private static synchronized void m2005a(int i, Object[] objArr, String[] strArr, String str) {
        synchronized (C0335o.class) {
            m2006a(i, objArr, strArr, (String[]) null, (String) null, str);
        }
    }

    private static synchronized void m2006a(int i, Object[] objArr, String[] strArr, String[] strArr2, String str, String str2) {
        synchronized (C0335o.class) {
            int m1997O = m1997O(-1);
            if (m1997O != -1) {
                f2001fj[m1997O] = i;
                f2002fk[m1997O] = objArr;
                f2005fn[m1997O] = str2;
                f2003fl[m1997O] = strArr;
                f2004fm[m1997O] = null;
                f2006fo[m1997O] = str;
                f1997ff = 200;
                f2000fi = "";
                if (m1997O < C0338r.f2384qD) {
                    f2007fp[m1997O] = 0;
                }
                f2008fq = true;
            } else {
                GLLib.m455bb();
            }
        }
    }

    public static void m2007a(String str, String str2, String str3) {
        m2039b(str, str2, null, str3);
    }

    public static void m2008a(String str, String str2, String str3, String str4, String str5) {
        m2056n("message");
        m2005a(InterfaceC0336p.f2087hC, new String[]{str, str2, null, str4, null}, (String[]) null, "");
    }

    public static void m2009a(String str, String str2, String str3, String str4, String str5, String str6) {
        m2056n("storage");
        m2005a(InterfaceC0336p.f2053gU, new String[]{str, str2, str3, str4, str5}, (String[]) null, str6);
    }

    public static void m2010a(String str, boolean z) {
        try {
            GLLib.m468bo();
            GLLib.m503n(str, null);
            str = GLLib.m469bp();
        } catch (UnsupportedEncodingException e) {
            GLLib.m456bc();
        }
        f1963eH = str;
    }

    private static void m2011a(boolean z, int i, int i2, boolean z2) {
        if (f2012fu && z) {
            m1996N(i);
        }
        if (m2058o(i, 3)) {
            if (i2 == 12) {
                f1973eR[i2] = f1979eX;
                m2055n(i, 0);
                return;
            }
            if (f1971eP[i2] != 0) {
                m2055n(i, 5);
            } else {
                int m466bm = (int) (GLLib.m466bm() - f1972eQ[i2]);
                if (!z2 && m466bm <= 15000 && f1972eQ[i2] != 0) {
                    m2055n(i, 0);
                    return;
                } else {
                    f1973eR[i2] = null;
                    m2055n(i, 4);
                }
            }
        }
        if (m2058o(i, 4)) {
            String[] strArr = f1973eR;
            String str = f1957eB[i2];
            RunnableC0345y m1994L = m1994L(i);
            if (f1971eP[i2] == 0) {
                String str2 = f1977eV;
                if (str2 != null && str2.length() != 0) {
                    m1994L.m2153a(new StringBuffer().append(str2).append("/locate/").append(str).toString(), "", 0);
                }
                f1971eP[i2] = 1;
            }
            if (f1971eP[i2] == 1) {
                if (m2020a(false, m1994L) && (r0 = m2038b(false, m1994L)) != null) {
                    f2011ft[i2] = 0;
                    f1971eP[i2] = 0;
                    strArr[i2] = r0;
                    if (f1973eR[i2] != null) {
                        f1972eQ[i2] = GLLib.m466bm();
                        m2055n(i, 0);
                    }
                } else if (m2058o(i, 2)) {
                    f1971eP[i2] = 0;
                }
            }
            String str3 = null;
            strArr[i2] = str3;
            if (f1973eR[i2] != null) {
            }
        }
        if (!m2058o(i, 5) || f1973eR[i2] == null) {
            return;
        }
        m2055n(i, 0);
    }

    private static void m2012a(int[] iArr, int i) {
        for (int i2 = 0; i2 < iArr.length - 1; i2++) {
            if (iArr[i2] != i) {
                int i3 = i2 + 1;
                while (true) {
                    if (i3 >= iArr.length - 1) {
                        break;
                    }
                    if (iArr[i3] == i) {
                        m2013a(f2010fs, i2, i3);
                        m2013a(f1970eO, i2, i3);
                        m2013a(f2001fj, i2, i3);
                        m2014a(f2005fn, i2, i3);
                        Object[][] objArr = f2002fk;
                        if (i2 < objArr.length && i3 < objArr.length) {
                            Object[] objArr2 = objArr[i2];
                            objArr[i2] = objArr[i3];
                            objArr[i3] = objArr2;
                        }
                        m2015a(f2003fl, i2, i3);
                        m2015a(f2004fm, i2, i3);
                        long[] jArr = f2007fp;
                        if (i2 < jArr.length && i3 < jArr.length) {
                            long j = jArr[i2];
                            jArr[i2] = jArr[i3];
                            jArr[i3] = j;
                        }
                        m2014a(f2006fo, i2, i3);
                        RunnableC0345y[] runnableC0345yArr = f1975eT;
                        if (i2 < runnableC0345yArr.length && i3 < runnableC0345yArr.length) {
                            RunnableC0345y runnableC0345y = runnableC0345yArr[i2];
                            runnableC0345yArr[i2] = runnableC0345yArr[i3];
                            runnableC0345yArr[i3] = runnableC0345y;
                        }
                    } else {
                        i3++;
                    }
                }
            }
        }
    }

    private static void m2013a(int[] iArr, int i, int i2) {
        if (i >= iArr.length || i2 >= iArr.length) {
            return;
        }
        int i3 = iArr[i];
        iArr[i] = iArr[i2];
        iArr[i2] = i3;
    }

    private static void m2014a(String[] strArr, int i, int i2) {
        if (i >= strArr.length || i2 >= strArr.length) {
            return;
        }
        String str = strArr[i];
        strArr[i] = strArr[i2];
        strArr[i2] = str;
    }

    private static void m2015a(String[][] strArr, int i, int i2) {
        if (i >= strArr.length || i2 >= strArr.length) {
            return;
        }
        String[] strArr2 = strArr[i];
        strArr[i] = strArr[i2];
        strArr[i2] = strArr2;
    }

    private static final boolean m2016a(int i, C0284ak c0284ak) {
        Object m702Z = c0284ak.m702Z("success");
        if (m702Z == null) {
            throw new Exception(new StringBuffer("Key not found: ").append("success").toString());
        }
        boolean equals = "true".equals(((String) m702Z).toLowerCase());
        if (!equals) {
            String m704ab = c0284ak.m704ab("reason");
            m2055n(i, 2);
            f1998fg = m704ab;
            f1999fh = new Exception(new StringBuffer("Connection exception: ").append(m704ab).toString());
        }
        return equals;
    }

    private static boolean m2017a(C0310bj c0310bj, int i) {
        if (c0310bj == null || !c0310bj.f652dC) {
            return false;
        }
        f1997ff = 801;
        f1998fg = c0310bj.f656zE;
        f1999fh = c0310bj.f653vu;
        c0310bj.f653vu = null;
        c0310bj.f652dC = false;
        if (i != -1) {
            m2055n(i, 2);
        }
        return true;
    }

    private static boolean m2018a(RunnableC0345y runnableC0345y) {
        if (runnableC0345y == null || !runnableC0345y.f2654dC) {
            return false;
        }
        f1997ff = runnableC0345y.f2669vs;
        f1998fg = runnableC0345y.f2670vt;
        f1999fh = runnableC0345y.f2671vu;
        runnableC0345y.f2669vs = 0;
        runnableC0345y.f2670vt = null;
        runnableC0345y.f2671vu = null;
        runnableC0345y.f2654dC = false;
        runnableC0345y.cleanup();
        if (f1999fh != null && (f1997ff == 200 || f1997ff == 0)) {
            f1997ff = 801;
        }
        return true;
    }

    private static boolean m2019a(String str, byte[] bArr) {
        try {
            File file = new File(str);
            GLLib.m342C(new StringBuffer("FilePath:").append(file.getPath()).toString());
            if (!file.exists()) {
                GLLib.m342C("Not Exist");
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(bArr, 0, bArr.length);
            fileOutputStream.close();
            return true;
        } catch (Exception e) {
            throw e;
        }
    }

    private static boolean m2020a(boolean z, RunnableC0345y runnableC0345y) {
        boolean z2;
        C0310bj c0310bj = null;
        if (!f2012fu || !z) {
            return runnableC0345y.f2652dA != null;
        }
        synchronized (c0310bj.f658zG) {
            C0310bj c0310bj2 = null;
            z2 = c0310bj2.f658zG.size() > 0;
        }
        return z2;
    }

    private static void m2021aA() {
        f1975eT = new RunnableC0345y[C0338r.f2384qD];
        f1970eO = new int[C0338r.f2384qD];
        f2010fs = new int[C0338r.f2384qD];
        f1971eP = new int[13];
        f2011ft = new int[13];
        f1973eR = new String[13];
        f1972eQ = new long[13];
        for (int i = 0; i < f1975eT.length; i++) {
            f1975eT[i] = new RunnableC0345y(false);
            m2055n(i, 3);
            f1971eP[i] = 0;
        }
    }

    private static boolean m2022aB() {
        return f1993fa != null;
    }

    private static synchronized boolean m2023aC() {
        boolean z = false;
        synchronized (C0335o.class) {
            if (f2001fj != null) {
                for (int i = 0; i < f2001fj.length; i++) {
                    if (f2001fj[i] != -1) {
                        break;
                    }
                }
            }
            z = true;
        }
        return z;
    }

    private static synchronized void m2024aD() {
        synchronized (C0335o.class) {
            int i = 0;
            while (i < f2001fj.length) {
                if (m1998P(i) == Integer.MAX_VALUE) {
                    m2000R(i);
                } else {
                    i++;
                }
            }
        }
    }

    private static synchronized void m2025aE() {
        synchronized (C0335o.class) {
            if (f2001fj != null) {
                for (int i = 0; i < f2001fj.length; i++) {
                    f2001fj[i] = -1;
                }
                for (int i2 = 0; i2 < f1970eO.length; i2++) {
                    m2055n(i2, 3);
                }
                for (int i3 = 0; i3 < f1971eP.length; i3++) {
                    f1971eP[i3] = 0;
                }
                for (int i4 = 0; i4 < f1975eT.length; i4++) {
                    f1975eT[i4].cancel();
                    f1975eT[i4] = null;
                    f1975eT[i4] = new RunnableC0345y(false);
                }
            }
        }
    }

    private static int m2026aF() {
        for (int i = f1996fe - 1; i >= 0; i--) {
            if (m1998P(i) != -1) {
                return i;
            }
        }
        return -1;
    }

    private static void m2027aG() {
        for (int i = 0; i < f1970eO.length; i++) {
            if (m2058o(i, 2)) {
                m2055n(i, 3);
            }
        }
        f1999fh = null;
        f1998fg = null;
    }

    public static void m2028aH() {
        if (f2016fy) {
            return;
        }
        if (!(f2001fj != null)) {
            f2001fj = new int[C0338r.f2385qE];
            f2002fk = new Object[C0338r.f2385qE][];
            f2003fl = new String[C0338r.f2385qE][];
            f2004fm = new String[C0338r.f2385qE][];
            f2005fn = new String[C0338r.f2385qE];
            f2006fo = new String[C0338r.f2385qE];
            f2007fp = new long[C0338r.f2384qD];
            for (int i = 0; i < f2001fj.length; i++) {
                f2001fj[i] = -1;
            }
        }
        if (!m2022aB()) {
            f1993fa = new Object[InterfaceC0336p.max][];
            f1994fc = new String[InterfaceC0336p.max][];
            f1995fd = new String[InterfaceC0336p.max][];
            Boolean bool = Boolean.TRUE;
            Boolean bool2 = Boolean.FALSE;
            Integer num = new Integer(0);
            Integer num2 = new Integer(1);
            Integer num3 = new Integer(2);
            if (C0338r.f2461rc) {
                int i2 = InterfaceC0336p.f2135hy;
                f1993fa[i2] = new Object[]{new Integer(0), bool, num, bool2};
                f1994fc[i2] = new String[]{"messages", "secured", "me"};
                f1995fd[i2] = new String[]{"access_token", "delete"};
            }
            if (C0338r.f2461rc) {
                int i3 = InterfaceC0336p.f2136hz;
                f1993fa[i3] = new Object[]{new Integer(0), bool, num, bool2};
                f1994fc[i3] = new String[]{"messages", "secured", "me", null};
                f1995fd[i3] = new String[]{"access_token"};
            }
            if (C0338r.f2461rc) {
                int i4 = InterfaceC0336p.f2086hB;
                f1993fa[i4] = new Object[]{new Integer(0), bool, num, bool2};
                f1994fc[i4] = new String[]{"messages", "inbox", "me"};
                f1995fd[i4] = new String[]{"access_token", "delete"};
            }
            if (C0338r.f2461rc) {
                int i5 = InterfaceC0336p.f2085hA;
                f1993fa[i5] = new Object[]{new Integer(0), bool, num3, bool2};
                f1994fc[i5] = new String[]{"messages", "secured", "me"};
                f1995fd[i5] = new String[]{"access_token", "msgids"};
            }
            if (C0338r.f2461rc) {
                int i6 = InterfaceC0336p.f2087hC;
                f1993fa[i6] = new Object[]{new Integer(0), bool, num2, bool2};
                f1994fc[i6] = new String[]{"messages", "inbox", null};
                f1995fd[i6] = new String[]{"access_token", "&&", "replace_label", "delay", "payload"};
            }
            if (C0338r.f2461rc) {
                int i7 = InterfaceC0336p.f2090hF;
                f1993fa[i7] = new Object[]{new Integer(0), bool, num2, bool2};
                f1994fc[i7] = new String[]{"messages", "inbox", "multicast"};
                f1995fd[i7] = new String[]{"access_token", "credentials", "&&", "payload"};
            }
            if (C0338r.f2461rc) {
                int i8 = InterfaceC0336p.f2091hG;
                f1993fa[i8] = new Object[]{new Integer(0), bool, num, bool2};
                f1994fc[i8] = new String[]{"messages", null, "me", null};
                f1995fd[i8] = new String[]{"access_token"};
            }
            if (C0338r.f2461rc) {
                int i9 = InterfaceC0336p.f2092hH;
                f1993fa[i9] = new Object[]{new Integer(0), bool, num2, bool2};
                f1994fc[i9] = new String[]{"messages", null, "me", null};
                f1995fd[i9] = new String[]{"access_token"};
            }
            if (C0338r.f2461rc) {
                int i10 = InterfaceC0336p.f2093hI;
                f1993fa[i10] = new Object[]{new Integer(0), bool, num3, bool2};
                f1994fc[i10] = new String[]{"messages", null, "me"};
                f1995fd[i10] = new String[]{"access_token", "msgids"};
            }
            if (C0338r.f2395qO) {
                int i11 = InterfaceC0336p.f2018fL;
                f1993fa[i11] = new Object[]{new Integer(2), bool, num2, bool2};
                f1994fc[i11] = new String[]{"authorize"};
                f1995fd[i11] = new String[]{"clientId", "username", "password", "scope", "device_id", "access_token_only"};
            }
            if (C0338r.f2395qO) {
                int i12 = InterfaceC0336p.f2019fM;
                f1993fa[i12] = new Object[]{new Integer(2), bool, num2, bool2};
                f1994fc[i12] = new String[]{"authorize"};
                f1995fd[i12] = new String[]{"clientId", "username", "password", "scope", "device_id", "access_token_only", "for_username", "for_credential_type", "grant_type", ServerProtocol.DIALOG_PARAM_REDIRECT_URI};
            }
            if (C0338r.f2395qO) {
                int i13 = InterfaceC0336p.f2025fS;
                f1993fa[i13] = new Object[]{new Integer(2), bool, num2, bool2};
                f1994fc[i13] = new String[]{"authorize"};
                f1995fd[i13] = new String[]{"clientId", "scope", "grant_type", "refresh_token"};
            }
            if (C0338r.f2395qO) {
                int i14 = InterfaceC0336p.f2026fT;
                f1993fa[i14] = new Object[]{new Integer(2), bool, num2, bool2};
                f1994fc[i14] = new String[]{"encrypt_token"};
                f1995fd[i14] = new String[]{"access_token", "nonce"};
            }
            if (C0338r.f2395qO) {
                int i15 = InterfaceC0336p.f2027fU;
                f1993fa[i15] = new Object[]{new Integer(2), bool, num, bool2};
                f1994fc[i15] = new String[]{null, "authenticate"};
                f1995fd[i15] = new String[]{"password"};
            }
            int i16 = InterfaceC0336p.f2099hO;
            f1993fa[i16] = new Object[]{new Integer(1), bool, num, bool2};
            f1994fc[i16] = new String[]{"assets", "clientId", null, "url"};
            int i17 = InterfaceC0336p.f2103hS;
            f1993fa[i17] = new Object[]{new Integer(1), bool, num, bool2};
            f1994fc[i17] = new String[]{"assets", "clientId", null, "metadata"};
            int i18 = InterfaceC0336p.f2104hT;
            f1993fa[i18] = new Object[]{new Integer(1), bool, num2, bool2};
            f1994fc[i18] = new String[]{"assets", "clientId", null};
            f1995fd[i18] = new String[]{"access_token", "override", "onlyThisClient", "data"};
            int i19 = InterfaceC0336p.f2101hQ;
            f1993fa[i19] = new Object[]{new Integer(1), bool, num, bool2};
            f1994fc[i19] = new String[]{"assets", "clientId", null};
            int i20 = InterfaceC0336p.f2102hR;
            f1993fa[i20] = new Object[]{new Integer(1), bool, num, bool2};
            f1994fc[i20] = new String[]{"assets", "clientId", null};
            int i21 = InterfaceC0336p.f2105hU;
            f1993fa[i21] = new Object[]{new Integer(1), bool, num, bool2};
            f1994fc[i21] = new String[]{"coupons", "clientId", null};
            int i22 = InterfaceC0336p.f2106hV;
            f1993fa[i22] = new Object[]{new Integer(1), bool, num2, bool2};
            f1994fc[i22] = new String[]{"coupons", "clientId"};
            f1995fd[i22] = new String[]{"num", "length", "uses", "data", "access_token"};
            if (C0338r.f2402qV) {
                int i23 = InterfaceC0336p.f2052gT;
                f1993fa[i23] = new Object[]{new Integer(5), bool, num2, bool2};
                f1994fc[i23] = new String[]{"data", "me", null, "delete"};
                f1995fd[i23] = new String[]{"access_token"};
            }
            if (C0338r.f2402qV) {
                int i24 = InterfaceC0336p.f2050gR;
                f1993fa[i24] = new Object[]{new Integer(5), bool, num, bool2};
                f1994fc[i24] = new String[]{"data", null, null};
                f1995fd[i24] = new String[]{"access_token"};
            }
            if (C0338r.f2402qV) {
                int i25 = InterfaceC0336p.f2051gS;
                f1993fa[i25] = new Object[]{new Integer(5), bool, num2, bool2};
                f1994fc[i25] = new String[]{"data", null, null};
                f1995fd[i25] = new String[]{"access_token", "data", "visibility"};
            }
            if (C0338r.f2403qW) {
                int i26 = InterfaceC0336p.f2053gU;
                f1993fa[i26] = new Object[]{new Integer(5), bool, num2, bool2};
                f1994fc[i26] = new String[]{"profiles", null, "myprofile", null};
                f1995fd[i26] = new String[]{"access_token", "object", "visibility", "operation"};
            }
            if (C0338r.f2403qW) {
                int i27 = InterfaceC0336p.f2054gV;
                f1993fa[i27] = new Object[]{new Integer(5), bool, num, bool2};
                f1994fc[i27] = new String[]{"profiles", null, "myprofile", null};
                f1995fd[i27] = new String[]{"access_token", "include_fields"};
            }
            if (C0338r.f2403qW) {
                int i28 = InterfaceC0336p.f2055gW;
                f1993fa[i28] = new Object[]{new Integer(5), bool, num, bool2};
                f1994fc[i28] = new String[]{"profiles"};
                f1995fd[i28] = new String[]{"access_token", "credentials", "include_fields"};
            }
            if (C0338r.f2403qW) {
                int i29 = InterfaceC0336p.f2056gX;
                f1993fa[i29] = new Object[]{new Integer(5), bool, num2, bool2};
                f1994fc[i29] = new String[]{"profiles", "me", "myprofile", "delete"};
                f1995fd[i29] = new String[]{"access_token"};
            }
            if (C0338r.f2403qW) {
                int i30 = InterfaceC0336p.f2057gY;
                f1993fa[i30] = new Object[]{new Integer(5), bool, num2, bool2};
                f1994fc[i30] = new String[]{"profiles", "me", "myprofile", "visibility"};
                f1995fd[i30] = new String[]{"access_token", "visibility"};
            }
            if (C0338r.f2403qW) {
                int i31 = InterfaceC0336p.f2058gZ;
                f1993fa[i31] = new Object[]{new Integer(5), bool, num, bool2};
                f1994fc[i31] = new String[]{"profiles", "me", "myprofile", "visibility"};
                f1995fd[i31] = new String[]{"access_token"};
            }
            if (C0338r.f2403qW) {
                int i32 = InterfaceC0336p.f2111ha;
                f1993fa[i32] = new Object[]{new Integer(5), bool, num, bool2};
                f1994fc[i32] = new String[]{"profiles", "matchers", null, "matches"};
                f1995fd[i32] = new String[]{"access_token", "limit", "include_fields"};
            }
        }
        if (f1975eT == null) {
            m2021aA();
        }
        f1967eL = "";
        f2016fy = false;
        if (!m2029aI()) {
            f1977eV = null;
            return;
        }
        f1978eW = m2057o(null);
        m2005a(InterfaceC0336p.f2032fZ, (Object[]) null, (String[]) null, "");
        if (C0338r.f2402qV || C0338r.f2403qW) {
            m2051l("storage");
        }
        if (C0338r.f2461rc) {
            m2051l("message");
        }
        if (f2012fu) {
            f1982fA = 0;
            m2005a(InterfaceC0336p.f2060gb, (Object[]) null, (String[]) null, "");
        }
        m2056n(f1967eL);
        m2005a(InterfaceC0336p.f2061gc, (Object[]) null, (String[]) null, "");
    }

    public static boolean m2029aI() {
        if (f2016fy) {
            return true;
        }
        String m214di = GLLib.f143iL == null ? null : GLLib.f143iL.m214di(C0338r.f2383qC);
        return (m214di == null || "0".equals(m214di)) ? false : true;
    }

    public static void m2030aJ() {
        f2016fy = false;
        f1982fA = 0;
        f2017fz = null;
        m2025aE();
        f1998fg = null;
        f1999fh = null;
        f1964eI = null;
    }

    public static String m2031aK() {
        return f1963eH;
    }

    public static String m2032aL() {
        return new StringBuffer().append(f2015fx).append(":").append(f2013fv).toString();
    }

    public static String m2033aM() {
        if (f1989fH == null) {
            if (f1984fC == null) {
                if (f1984fC == null) {
                    m2064u(GLLib.f143iL == null ? null : GLLib.f143iL.m214di("GAME-PRODUCT-ID"));
                }
                if (f1985fD == null) {
                    m2065v(GLLib.f143iL == null ? null : GLLib.f143iL.m214di("GAME-GGI"));
                }
                if (f1986fE == null) {
                    m2066w(GLLib.f143iL == null ? null : GLLib.f143iL.m214di("MIDlet-Version"));
                }
                if (f1987fF == null) {
                    m2067x(GLLib.f143iL == null ? null : GLLib.f143iL.m214di("GAME-PLATFORM"));
                }
                if (f1988fG == null) {
                    m2068y(GLLib.f143iL != null ? GLLib.f143iL.m214di("GAME-SHOP") : null);
                }
            }
            f1989fH = new StringBuffer().append(f1984fC).append(":").append(f1985fD).append(":").append(f1986fE).append(":").append(f1987fF).toString();
            if (f1988fG != null && !"".equals(f1988fG)) {
                f1989fH = new StringBuffer().append(f1989fH).append(":").append(f1988fG).toString();
            }
        }
        return f1989fH;
    }

    private static final boolean m2034ax() {
        return (m1997O(InterfaceC0336p.f2019fM) == -1 && m1997O(InterfaceC0336p.f2025fS) == -1) ? false : true;
    }

    public static void m2035ay() {
        m2005a(InterfaceC0336p.f2134hx, (Object[]) null, (String[]) null, "");
    }

    public static String m2036az() {
        return f1977eV;
    }

    private static String m2037b(String str, boolean z) {
        if (str.startsWith("http")) {
            return str;
        }
        return !z ? new StringBuffer("http://").append(str).toString() : new StringBuffer("https://").append(str).toString();
    }

    private static String m2038b(boolean z, RunnableC0345y runnableC0345y) {
        String str;
        String str2;
        ?? r1 = 0;
        r1 = 0;
        if (f2012fu && z) {
            byte[] m834dA = r1.m834dA();
            if (m834dA != null) {
                String str3 = new String(m834dA);
                if (f1991fJ == -1) {
                    f1991fJ = Integer.parseInt(str3.substring(0, str3.indexOf(123)));
                    f1990fI = new StringBuffer().append(str3.substring(str3.indexOf(123), str3.length())).toString();
                } else {
                    f1990fI = new StringBuffer().append(f1990fI).append(str3).toString();
                }
                if (f1991fJ > f1990fI.length()) {
                    str2 = null;
                } else {
                    f1991fJ = -1;
                    str2 = f1990fI;
                }
                if (str2 == null) {
                    return null;
                }
                try {
                    C0284ak c0284ak = new C0284ak(str2);
                    str = c0284ak.m704ab("D");
                    if ("1".equals(c0284ak.m704ab("F"))) {
                        String str4 = new String(GLLib.m444b(GLLib.m355P(str), (String) null, true));
                        String str5 = "";
                        if (str4.indexOf("\r\n") != -1) {
                            str5 = new StringBuffer().append("").append(str4.substring(0, str4.indexOf("\r\n"))).toString();
                        } else if (str4.indexOf("\\r\\n") != -1) {
                            str5 = new StringBuffer().append("").append(str4.substring(0, str4.indexOf("\\r\\n"))).toString();
                        }
                        String stringBuffer = new StringBuffer().append(str5.substring(8).trim()).toString();
                        f1983fB = Integer.parseInt(new StringBuffer().append(stringBuffer.substring(0, stringBuffer.indexOf(" "))).toString());
                        str = new StringBuffer().append(str4.substring(str4.indexOf("\\r\\n\\r\\n") != -1 ? str4.indexOf("\\r\\n\\r\\n") + 8 : str4.indexOf("\r\n\r\n") != -1 ? str4.indexOf("\r\n\r\n") + 4 : 0, str4.length())).toString();
                        f1997ff = f1983fB;
                        r1 = f1983fB;
                    }
                } catch (Exception e) {
                }
            }
            str = r1;
        } else {
            str = runnableC0345y.f2652dA;
            f1997ff = runnableC0345y.f2669vs;
            f1976eU = runnableC0345y.f2661vi;
        }
        return str;
    }

    public static void m2039b(String str, String str2, String str3, String str4) {
        m2056n("storage");
        m2006a(InterfaceC0336p.f2050gR, new String[]{str, str2}, (String[]) null, (String[]) null, str3, str4);
    }

    public static void m2040b(String str, String str2, String str3, String str4, String str5) {
        m2056n("storage");
        m2005a(InterfaceC0336p.f2051gS, new String[]{str, str2, str3, str4}, (String[]) null, str5);
    }

    public static void m2041c(String str, String str2, String str3, String str4) {
        m2056n("storage");
        m2005a(InterfaceC0336p.f2054gV, new String[]{str, null, null}, (String[]) null, str4);
    }

    public static void m2042c(String str, String str2, String str3, String str4, String str5) {
        m2009a(str, str2, str3, str4, str5, "");
    }

    public static void m2043d(String str, String str2, String str3, String str4) {
        m2040b(str, str2, str3, str4, "");
    }

    public static void m2044f(boolean z) {
        m2056n("message");
        m2005a(InterfaceC0336p.f2135hy, new String[]{"1"}, (String[]) null, "");
    }

    public static void m2045g(boolean z) {
        m2056n("message");
        m2005a(InterfaceC0336p.f2086hB, new String[]{"1"}, (String[]) null, "");
    }

    public static void m2046h(boolean z) {
        long j;
        String str;
        String str2;
        if (f1980eY != -1) {
            if (f1980eY == 0) {
                RunnableC0345y runnableC0345y = null;
                runnableC0345y.m2153a(new StringBuffer().append(m2057o(null)).append("/datacenters").toString(), "", 0);
                f1980eY = 1;
            }
            if (f1980eY == 1) {
                if (m2018a((RunnableC0345y) null)) {
                    f1980eY = -1;
                    str2 = "";
                } else {
                    RunnableC0345y runnableC0345y2 = null;
                    if (runnableC0345y2.f2652dA != null) {
                        f1980eY = -1;
                        RunnableC0345y runnableC0345y3 = null;
                        str2 = runnableC0345y3.f2652dA;
                    }
                }
                if (str2 != null) {
                    GLLib.f150iT.mo510a(InterfaceC0336p.f2059ga, str2, (String) null, f1997ff, f1998fg, f1999fh);
                    f1981eZ = null;
                }
            }
            str2 = null;
            if (str2 != null) {
            }
        }
        if (!m2023aC() || f2016fy) {
            if (f2012fu) {
                if (C0338r.f2384qD > 0) {
                    f1996fe = 1;
                } else {
                    f1996fe = C0338r.f2384qD;
                }
            }
            if (!m2022aB()) {
                GLLib.m455bb();
            }
            m2027aG();
            if (f2008fq) {
                m2012a(f2001fj, InterfaceC0336p.f2025fS);
                m2012a(f2001fj, InterfaceC0336p.f2019fM);
                m2012a(f2001fj, InterfaceC0336p.f2032fZ);
                m2012a(f1970eO, 4);
                f2008fq = false;
            }
            int m2026aF = m2026aF() + 1;
            for (int i = 0; i < m2026aF; i++) {
                boolean z2 = (m1998P(i) == InterfaceC0336p.f2025fS && f1977eV != null) | (m1998P(i) == InterfaceC0336p.f2032fZ) | (m1998P(i) == InterfaceC0336p.f2060gb && f1977eV != null) | (m1998P(i) == InterfaceC0336p.f2019fM && f1977eV != null);
                if (m1998P(i) != Integer.MAX_VALUE && m1998P(i) != -1 && (z2 || f1964eI != null)) {
                    int i2 = GLLib.f146iP;
                    long[] jArr = f2007fp;
                    jArr[i] = jArr[i] + i2;
                    if (f2007fp[i] < C0338r.f2386qF || C0338r.f2386qF == 0) {
                        int m1998P = m1998P(i);
                        RunnableC0345y m1994L = m1994L(i);
                        f2000fi = null;
                        if (m1998P == InterfaceC0336p.f2100hP) {
                            RunnableC0345y m1994L2 = m1994L(i);
                            m1996N(i);
                            if (m2058o(i, 0)) {
                                m1994L2.m2153a(((String[]) f2002fk[i])[0], "", 0);
                                m2055n(i, 1);
                            }
                            if (m2058o(i, 1) && m2020a(false, m1994L2) && (str = m2038b(false, m1994L2)) != null) {
                                f2010fs[i] = 0;
                                m2055n(i, 3);
                            } else {
                                str = null;
                            }
                            f2000fi = str;
                        } else if (m1998P == InterfaceC0336p.f2102hR) {
                            f2000fi = m1993K(i);
                        } else if (m1998P == InterfaceC0336p.f2134hx && C0338r.f2463re) {
                            m2011a(true, i, 2, true);
                            if (m2058o(i, 0)) {
                                m2055n(i, 3);
                                j = f1976eU;
                            } else {
                                j = -1;
                            }
                            if (j != -1) {
                                f2000fi = Long.toString(j);
                            }
                        } else if (m1998P == InterfaceC0336p.f2128hr || m1998P == InterfaceC0336p.f2129hs || m1998P == InterfaceC0336p.f2127hq) {
                            f2000fi = m1991I(i);
                        } else if (m1998P == InterfaceC0336p.f2125ho) {
                            if (f1974eS != null) {
                                f1974eS.disconnect();
                                f1974eS = null;
                            }
                            f2000fi = "";
                        } else if (m1998P == InterfaceC0336p.f2116hf || m1998P == InterfaceC0336p.f2117hg || m1998P == InterfaceC0336p.f2118hh || m1998P == InterfaceC0336p.f2119hi || m1998P == InterfaceC0336p.f2120hj || m1998P == InterfaceC0336p.f2121hk || m1998P == InterfaceC0336p.f2123hm || m1998P == InterfaceC0336p.f2124hn || m1998P == InterfaceC0336p.f2122hl || m1998P == InterfaceC0336p.f2115he) {
                            f2000fi = m1990H(i);
                        } else if (m1998P == InterfaceC0336p.f2032fZ) {
                            f2000fi = m1992J(i);
                        } else if (m1998P == InterfaceC0336p.f2060gb) {
                            f2000fi = "";
                        } else if (m1998P == InterfaceC0336p.f2061gc) {
                            if (f1977eV == null) {
                                GLLib.m455bb();
                            }
                            if (f1977eV != null) {
                                boolean z3 = f2012fu;
                                if (!f2012fu) {
                                    f2016fy = true;
                                    f2000fi = "";
                                }
                            }
                        } else if (m1998P != -1) {
                            f2000fi = m1995M(i);
                        }
                        if (m1998P == InterfaceC0336p.f2018fL && C0338r.f2395qO) {
                            f1964eI = f2000fi;
                        } else if (m1998P == InterfaceC0336p.f2026fT && C0338r.f2395qO) {
                            f1968eM = f2000fi;
                        } else if ((m1998P == InterfaceC0336p.f2019fM || m1998P == InterfaceC0336p.f2025fS) && C0338r.f2395qO) {
                            String str3 = f2000fi;
                            if (str3 != null) {
                                C0284ak c0284ak = new C0284ak(str3);
                                try {
                                    f1964eI = c0284ak.m704ab("access_token");
                                    f1966eK = c0284ak.m704ab("refresh_token");
                                    f1965eJ = GLLib.m466bm();
                                } catch (Exception e) {
                                    GLLib.m456bc();
                                }
                            }
                        } else if (m1998P == InterfaceC0336p.f2027fU && C0338r.f2395qO) {
                            if (f2000fi != null) {
                                if (m1994L.f2669vs > 200) {
                                    f2000fi = "Failed";
                                } else {
                                    f2000fi = "Successful";
                                }
                            }
                        } else if (m1998P == InterfaceC0336p.f2127hq) {
                            f1969eN = f2000fi;
                        } else if (m1998P == InterfaceC0336p.f2115he) {
                            f1969eN = f2000fi;
                        }
                        RunnableC0345y m1994L3 = m1994L(i);
                        if (m1994L3 != null && m2018a(m1994L3)) {
                            if (f1999fh != null && ("java.net.SocketTimeoutException".equals(f1999fh.getClass().getName()) || "java.io.IOException".equals(f1999fh.getClass().getName()) || "java.net.ConnectException".equals(f1999fh.getClass().getName()) || C0338r.f2381qA)) {
                                int m2001S = m2001S(m1998P(i));
                                boolean m2058o = m2058o(i, 4);
                                if ((m2058o || i == -1 || f2010fs[i] >= C0338r.f2432qz) && (!m2058o || m2001S == -1 || f2011ft[m2001S] >= C0338r.f2432qz)) {
                                    if (i != -1) {
                                        f2010fs[i] = 0;
                                    }
                                    if (m2001S != -1) {
                                        f2011ft[m2001S] = 0;
                                    }
                                } else {
                                    if (m2058o) {
                                        int[] iArr = f2011ft;
                                        iArr[m2001S] = iArr[m2001S] + 1;
                                    } else {
                                        int[] iArr2 = f2010fs;
                                        iArr2[i] = iArr2[i] + 1;
                                    }
                                    m2055n(i, 3);
                                    if (m2001S != -1) {
                                        f1971eP[m2001S] = 0;
                                        f1972eQ[m2001S] = 0;
                                    }
                                }
                            }
                            if (i != -1 && m2058o(i, 4)) {
                                f1997ff = 800;
                            }
                            m2055n(i, 2);
                        }
                        int m1998P2 = m1998P(i);
                        if (m1998P2 >= InterfaceC0336p.f2115he && m1998P2 <= InterfaceC0336p.f2129hs) {
                            m2017a(f1974eS, i);
                        }
                        if (f2012fu) {
                            m2017a((C0310bj) null, i);
                        }
                    } else {
                        f1997ff = 504;
                        f1998fg = "Federation timeout";
                        f1999fh = new RuntimeException(f1998fg);
                        int m2001S2 = m2001S(m1998P(i));
                        if (m2001S2 != -1) {
                            f1971eP[m2001S2] = 0;
                        }
                        m2055n(i, 2);
                    }
                    if (m2058o(i, 2) || f2000fi != null) {
                        int m1998P3 = m1998P(i);
                        String str4 = f2005fn[i];
                        m1999Q(i);
                        GLLib.f150iT.mo510a(m1998P3, f2000fi, str4, f1997ff, f1998fg, f1999fh);
                    }
                    f2009fr = false;
                }
            }
            if (m2017a(f1974eS, -1)) {
                GLLib.f150iT.mo510a(-1, "", "", f1997ff, f1998fg, f1999fh);
            }
            m2024aD();
            if (f1959eD && f1960eE <= 0) {
                m2049k(f1961eF);
                f1960eE = C0338r.f2469rk;
            }
            f1960eE -= GLLib.f146iP;
        }
    }

    public static void m2047i(boolean z) {
        f2012fu = false;
    }

    public static String m2048j(String str, String str2) {
        return m2004a(m2004a(m2004a("", "from", str, true), "body", str2, true), "reply_to", m2032aL(), true);
    }

    private static void m2049k(String str) {
        f1961eF = str;
        f1958eC.m833d(new StringBuffer("<presence><status>").append(str).append("</status></presence>").toString().getBytes());
    }

    public static void m2050k(String str, String str2) {
        m2056n("storage");
        m2005a(InterfaceC0336p.f2052gT, new String[]{str}, (String[]) null, str2);
    }

    private static void m2051l(String str) {
        if (str == null) {
            f1967eL = "";
        } else {
            if (m2054m(str)) {
                return;
            }
            f1967eL = new StringBuffer().append(f1967eL).append(str).append(" ").toString();
        }
    }

    public static void m2052l(String str, String str2) {
        m2039b(str, str2, null, "");
    }

    public static void m2053m(String str, String str2) {
        m2056n("storage");
        m2005a(InterfaceC0336p.f2055gW, new String[]{str, str2}, (String[]) null, "");
    }

    private static boolean m2054m(String str) {
        return f1967eL.indexOf(new StringBuffer().append(str).append(" ").toString()) != -1;
    }

    private static void m2055n(int i, int i2) {
        f1970eO[i] = i2;
        f2007fp[i] = 0;
    }

    private static void m2056n(String str) {
        if (f1963eH == null) {
            GLLib.m342C("You didn't set device id. Please note that it's optional to set device id (for backward compatiblity) but is required for all new games.");
        }
        boolean m2054m = m2054m(str.trim());
        if ((f1964eI != null && GLLib.m466bm() - f1965eJ > ((long) (C0338r.f2401qU * PlacePickerFragment.DEFAULT_RADIUS_IN_METERS))) && !m2034ax()) {
            f1964eI = null;
            m2005a(InterfaceC0336p.f2025fS, new String[]{null, "refresh_token", f1966eK}, (String[]) null, "");
        } else if ((!m2054m || f1964eI == null) && !m2034ax()) {
            String str2 = f1963eH;
            if (!m2054m) {
                m2051l(str);
            }
            m2005a(InterfaceC0336p.f2019fM, new String[]{m2032aL(), f2014fw, f1967eL.trim(), f1963eH, null, null, null, null, null}, (String[]) null, "");
        }
    }

    private static String m2057o(String str) {
        String m214di = GLLib.f143iL == null ? null : GLLib.f143iL.m214di(C0338r.f2383qC);
        if (m214di != null && m214di.endsWith("/")) {
            m214di = new StringBuffer().append(m214di.substring(0, m214di.length() - 1)).toString();
        }
        String stringBuffer = new StringBuffer().append(m214di).append("/config/").append(m2033aM()).toString();
        return str != null ? new StringBuffer().append(stringBuffer).append("/datacenters/").append(str).append("/urls").toString() : stringBuffer;
    }

    private static boolean m2058o(int i, int i2) {
        return f1970eO[i] == i2;
    }

    public static void m2059p(String str) {
        m2056n("storage");
        m2005a(InterfaceC0336p.f2057gY, new String[]{str}, (String[]) null, "");
    }

    public static void m2060q(String str) {
        f2013fv = str;
        f1964eI = null;
    }

    public static void m2061r(String str) {
        f2014fw = str;
        f1964eI = null;
    }

    public static void m2062s(String str) {
        f2015fx = str;
        f1964eI = null;
    }

    private static String m2063t(String str) {
        return new StringBuffer("socket://").append(str).toString();
    }

    public static void m2064u(String str) {
        f1984fC = str;
        f1989fH = null;
    }

    public static void m2065v(String str) {
        f1985fD = str;
        f1989fH = null;
    }

    public static void m2066w(String str) {
        f1986fE = str;
        f1989fH = null;
    }

    public static void m2067x(String str) {
        f1987fF = str;
        f1989fH = null;
    }

    public static void m2068y(String str) {
        f1988fG = str;
        f1989fH = null;
    }

    public static String m2069z(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            stringBuffer.append(m2002a(str.charAt(i)));
        }
        return stringBuffer.toString();
    }
}
