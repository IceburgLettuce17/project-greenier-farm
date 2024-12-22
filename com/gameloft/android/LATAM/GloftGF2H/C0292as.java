package com.gameloft.android.LATAM.GloftGF2H;

import com.facebook.internal.ServerProtocol;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Vector;
import p009b.p010a.p016e.C0100b;
import p009b.p010a.p016e.C0101c;

public final class C0292as {

    private static boolean f594yB;

    private static String f595yC;

    private static String f598yF;

    private static int f599yG;

    private static String f601yj;

    private static C0329i f602yk;

    private static C0100b f603yl;

    private static C0100b f604ym;

    private static Vector f605yn;

    private static byte[] f606yo;

    private static int f607yp;

    private static int f608yq;

    private static int f609yr;

    private static boolean f610ys;

    private static boolean f611yt;

    private static boolean f612yu;

    private static int f616yy;

    private static String f617yz;

    private static String f613yv = "tempSaveFile";

    private static int f614yw = 5;

    private static String f615yx = "$savegamelib.objects.TOC";

    private static int f593yA = -1;

    private static int f596yD = -1;

    private static Exception f597yE = null;

    private static boolean f600yH = false;

    private static int m795a(byte[] bArr, int i, String str) {
        int i2;
        if (!C0338r.f2538tb) {
            return -1;
        }
        if (!f611yt) {
            return -16;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            i2 = C0344x.m2147a(byteArrayInputStream, byteArrayOutputStream);
        } catch (IOException e) {
            i2 = 0;
        }
        if (i2 == 0) {
            GLLib.m342C("Error while compressing buffer. Aborting Save\n");
            try {
                C0100b c0100b = f603yl;
                C0100b.m229uC();
            } catch (C0101c e2) {
            }
            f611yt = false;
            return -9;
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        GLLib.m470bq();
        int m367a = GLLib.m367a(bArr, 0, bArr.length, 0);
        byte[] m399a = GLLib.m399a(byteArray, str, true);
        f602yk.m1978a(new C0291ar(GLLib.m488c(new int[]{i, m367a, m399a.length})));
        f602yk.m1978a(new C0291ar(m399a));
        f608yq++;
        return 0;
    }

    public static void m796a(int i, String str, String str2, int i2, Exception exc) {
        if (str2.startsWith("cloud")) {
            f596yD = i;
            f598yF = str;
            f595yC = str2;
            f599yG = i2;
            f597yE = exc;
        }
    }

    static void m797a(String str, C0329i c0329i) {
        if (C0338r.f2538tb) {
            GLLib.m342C("Restoring save from cloud...");
            f616yy = 0;
            C0335o.m2007a(c0329i.f1928dY, c0329i.m1979ar(), "cloudGetCloudSave");
            m822n(InterfaceC0336p.f2050gR, "cloudGetCloudSave");
            if (f616yy != 0) {
                GLLib.m342C("Could not retrieve savegame");
                return;
            }
            try {
                byte[] m355P = GLLib.m355P(f598yF);
                if (m804aJ(f613yv)) {
                    C0100b.m224dk(f613yv);
                }
                C0100b m227g = C0100b.m227g(f613yv, true);
                f603yl = m227g;
                if (m227g == null) {
                    f616yy = -16;
                    GLLib.m342C(new StringBuffer("can't use ").append(f613yv).toString());
                    return;
                }
                f603yl.m232e(m355P, 0, m355P.length);
                C0100b c0100b = f603yl;
                C0100b.m229uC();
                int m800aF = m800aF(f613yv);
                f616yy = m800aF;
                if (m800aF != 0) {
                    GLLib.m342C(new StringBuffer("can't load ").append(f613yv).toString());
                    return;
                }
                int i = f608yq;
                int m799aE = m799aE(str);
                f616yy = m799aE;
                if (m799aE != 0) {
                    GLLib.m342C(new StringBuffer("can't save ").append(str).toString());
                    return;
                }
                for (int i2 = 0; i2 < i; i2++) {
                    byte[] m801aG = m801aG(c0329i.f1921dR);
                    if (f616yy != 0) {
                        GLLib.m342C(new StringBuffer("load buffer ").append(i2).append(" fail").toString());
                        return;
                    }
                    int m821e = m821e(m801aG, m801aG.length);
                    f616yy = m821e;
                    if (m821e != 0) {
                        GLLib.m342C(new StringBuffer("save buffer ").append(i2).append(" fail").toString());
                        return;
                    }
                }
                int m806c = m806c("", false);
                f616yy = m806c;
                if (m806c == 0) {
                    f616yy = m813dj();
                    try {
                        C0100b.m224dk(f613yv);
                    } catch (C0101c e) {
                        f616yy = -1;
                    }
                }
            } catch (Exception e2) {
                GLLib.m342C(e2.getMessage());
                f616yy = -1;
            }
        }
    }

    private static boolean m798a(Object[] objArr) {
        if (!C0338r.f2538tb || f600yH) {
            return false;
        }
        f600yH = true;
        new C0293at(objArr).start();
        return true;
    }

    public static int m799aE(String str) {
        if (!C0338r.f2538tb) {
            return -1;
        }
        if (f610ys) {
            return -125;
        }
        GLLib.m342C("Begin saving game.");
        try {
            if (m804aJ(str)) {
                C0100b.m224dk(str);
            }
            f603yl = C0100b.m227g(str, true);
        } catch (C0101c e) {
        }
        if (f603yl == null) {
            return -16;
        }
        f602yk = new C0329i();
        f611yt = true;
        f608yq = 0;
        return 0;
    }

    public static int m800aF(String str) {
        if (!C0338r.f2538tb) {
            return -1;
        }
        GLLib.m342C("Begin loading game");
        try {
            f604ym = C0100b.m227g(str, false);
        } catch (C0101c e) {
        }
        if (f604ym == null) {
            GLLib.m342C("Could not load save file");
            return -16;
        }
        f609yr = 0;
        try {
            f606yo = f604ym.m234fq(1);
            f607yp = 0;
            f608yq = m807c(f606yo, f606yo.length - 4);
        } catch (Exception e2) {
        }
        f612yu = true;
        return 0;
    }

    private static byte[] m801aG(String str) {
        if (!C0338r.f2538tb) {
            return null;
        }
        if (!f612yu) {
            f616yy = -16;
            return null;
        }
        byte[] bArr = f606yo;
        int i = f607yp;
        f607yp += 4;
        int m807c = m807c(f606yo, f607yp);
        f607yp += 4;
        int m807c2 = m807c(f606yo, f607yp);
        f607yp += 4;
        byte[] bArr2 = new byte[m807c2];
        byte[] bArr3 = f606yo;
        int i2 = f607yp;
        System.arraycopy(bArr3, i2, bArr2, 0, bArr2.length);
        f607yp = bArr2.length + i2;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(GLLib.m444b(bArr2, str, true));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            C0344x.m2151b(byteArrayInputStream, byteArrayOutputStream);
        } catch (IOException e) {
        }
        if (byteArrayOutputStream.size() == 0) {
            GLLib.m342C("Error while uncompressing buffer.\n");
            f616yy = -7;
            return null;
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        GLLib.m470bq();
        if (GLLib.m367a(byteArray, 0, byteArray.length, 0) == m807c) {
            f609yr++;
            f616yy = 0;
            return byteArray;
        }
        f617yz = "CRC Error.\n";
        GLLib.m342C("CRC Error.\n");
        f616yy = -10;
        return null;
    }

    public static int m802aH(String str) {
        try {
            C0100b.m224dk(str);
        } catch (C0101c e) {
        }
        f610ys = false;
        return 0;
    }

    public static int m803aI(String str) {
        f601yj = str;
        return 0;
    }

    private static boolean m804aJ(String str) {
        boolean z = false;
        try {
            C0100b.m227g(str, false);
            z = true;
            try {
                C0100b.m229uC();
            } catch (Exception e) {
            }
        } catch (Exception e2) {
            try {
                C0100b.m229uC();
            } catch (Exception e3) {
            }
        } catch (Throwable th) {
            try {
                C0100b.m229uC();
            } catch (Exception e4) {
            }
            throw th;
        }
        return z;
    }

    private static long m805aK(String str) {
        char[] charArray = str.toCharArray();
        long j = 0;
        for (int i = 0; i < charArray.length && charArray[i] >= '0' && charArray[i] <= '9'; i++) {
            j = (j * 10) + (charArray[i] - '0');
        }
        return j;
    }

    public static synchronized int m806c(String str, boolean z) {
        int i = -1;
        synchronized (C0292as.class) {
            if (C0338r.f2538tb) {
                if (f611yt) {
                    f602yk.m1978a(new C0291ar(GLLib.m488c(new int[]{f608yq})));
                    try {
                        f603yl.m232e(f602yk.f1924dU.f592yi, 0, f602yk.f1924dU.f592yi.length);
                        f602yk.f1920dQ = System.currentTimeMillis() / 1000;
                        f602yk.f1923dT = str;
                        f602yk.f1921dR = C0335o.m2031aK();
                        try {
                            C0100b c0100b = f603yl;
                            C0100b.m229uC();
                        } catch (C0101c e) {
                        }
                        f611yt = false;
                        if (z) {
                            f593yA = 1;
                            f594yB = false;
                        }
                        i = 0;
                    } catch (C0101c e2) {
                        f616yy = -1;
                        f617yz = "Can not save local record";
                        i = f616yy;
                    }
                } else {
                    i = -16;
                }
            }
        }
        return i;
    }

    private static int m807c(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = i2 + 1;
        return ((bArr[i2] & 255) << 8) | (bArr[i] & 255) | ((bArr[i3] & 255) << 16) | ((bArr[i3 + 1] & 255) << 24);
    }

    public static int m808de() {
        if (!f594yB) {
            return -1;
        }
        f594yB = false;
        return f593yA;
    }

    public static int m809df() {
        return f616yy;
    }

    public static String m810dg() {
        return f617yz;
    }

    public static int m811dh() {
        if (f602yk == null || f602yk.f1924dU == null) {
            return 0;
        }
        byte[] m488c = GLLib.m488c(new int[]{f608yq});
        C0329i c0329i = new C0329i();
        c0329i.m1978a(f602yk.f1924dU);
        c0329i.m1978a(new C0291ar(m488c));
        return GLLib.m434b(c0329i.f1924dU.f592yi).length();
    }

    public static byte[] m812di() {
        return m801aG(C0335o.m2031aK());
    }

    public static int m813dj() {
        if (!C0338r.f2538tb) {
            return -1;
        }
        try {
            C0100b c0100b = f604ym;
            C0100b.m229uC();
        } catch (Exception e) {
        }
        f612yu = false;
        if (f609yr == f608yq) {
            return 0;
        }
        f617yz = "Savegame parsing mismatch! You did not load all the data";
        GLLib.m342C("Savegame parsing mismatch! You did not load all the data");
        return -18;
    }

    public static int m814dk() {
        f610ys = false;
        return 0;
    }

    static void m816dm() {
        C0284ak c0284ak;
        int i;
        int i2;
        int i3;
        long j;
        int i4;
        if (!C0338r.f2538tb) {
            return;
        }
        GLLib.m342C("Attempting to upload save to cloud");
        f616yy = 0;
        Vector vector = new Vector();
        vector.removeAllElements();
        if (f601yj != null) {
            vector.addElement(f601yj);
        } else {
            vector.addElement("me");
        }
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= vector.size()) {
                return;
            }
            String str = (String) vector.elementAt(i6);
            C0284ak c0284ak2 = new C0284ak();
            C0335o.m2007a(str, f615yx, "cloudUploadGetToc");
            m822n(InterfaceC0336p.f2050gR, "cloudUploadGetToc");
            if (f616yy == 404) {
                GLLib.m342C("Table of Contents does not exist. Creating it");
                C0284ak c0284ak3 = new C0284ak();
                c0284ak3.m706g("TOC", new C0284ak());
                c0284ak = c0284ak3;
            } else if (f616yy == 0) {
                C0284ak c0284ak4 = new C0284ak(f598yF);
                if (((C0284ak) c0284ak4.m702Z("TOC")) == null) {
                    f617yz = "Retrieved Invalid Table Of Contents";
                    f616yy = -13;
                    GLLib.m342C(f617yz);
                    return;
                }
                c0284ak = c0284ak4;
            } else {
                c0284ak = c0284ak2;
            }
            C0284ak c0284ak5 = (C0284ak) c0284ak.m702Z("TOC");
            C0335o.m2041c(str, null, null, "cloudUploadGetProfile");
            m822n(InterfaceC0336p.f2054gV, "cloudUploadGetProfile");
            if (f616yy == 404) {
                C0335o.m2009a(str, (String) null, "{}", (String) null, "set", "cloudUploadSetProfile");
                m822n(InterfaceC0336p.f2053gU, "cloudUploadSetProfile");
                C0335o.m2041c(str, null, null, "cloudUploadGetProfile2");
                m822n(InterfaceC0336p.f2054gV, "cloudUploadGetProfile2");
            }
            if (f616yy != 0) {
                f616yy = -1;
                f617yz = "Can not get user standard profile";
                GLLib.m342C("Can not get user standard profile");
                return;
            }
            C0284ak c0284ak6 = new C0284ak(f598yF);
            try {
                if (c0284ak6.m702Z("@quota") != null) {
                    C0284ak c0284ak7 = (C0284ak) c0284ak6.m702Z("@quota");
                    if (c0284ak7.m702Z("@savegamelib") != null) {
                        C0284ak c0284ak8 = (C0284ak) c0284ak7.m702Z("@savegamelib");
                        try {
                            c0284ak8.m703aa("max");
                            int m703aa = c0284ak8.m703aa("remaining");
                            c0284ak8.m703aa("total");
                            i = m703aa;
                            i2 = c0284ak5.f505vV;
                            if (i2 != 0 && i <= 0) {
                                f616yy = -126;
                                f617yz = "server quotas exceed";
                                GLLib.m342C("server quotas exceed");
                                return;
                            }
                            if (i2 < f614yw || i == 0) {
                                GLLib.m342C("Maximum number of saves reached. Overwriting oldest save.");
                                int i7 = 0;
                                long j2 = m805aK(((C0284ak) c0284ak5.f504vU[0]).m704ab("Date"));
                                i3 = 1;
                                long j3 = j2;
                                while (i3 < i2) {
                                    try {
                                        j = m805aK(((C0284ak) c0284ak5.f504vU[i3]).m704ab("Date"));
                                    } catch (Exception e) {
                                        j = 0;
                                    }
                                    if (j3 >= j) {
                                        i4 = i3;
                                    } else {
                                        j = j3;
                                        i4 = i7;
                                    }
                                    i3++;
                                    i7 = i4;
                                    j3 = j;
                                }
                                String l = Long.toString(f602yk.f1920dQ);
                                C0284ak c0284ak9 = (C0284ak) c0284ak5.f504vU[i7];
                                c0284ak9.m706g("Date", l);
                                c0284ak9.m706g("Description", f602yk.f1923dT);
                                c0284ak9.m706g("Version", f602yk.f1927dX);
                                c0284ak9.m706g("GLUID", GLLib.m434b(f602yk.f1921dR.getBytes()));
                                f602yk.m1980i(c0284ak9.m704ab("SeshatFileKey"));
                            } else {
                                String stringBuffer = new StringBuffer().append("$savegamelib.objects.key").append(Long.toString(i2 + 1)).toString();
                                C0284ak c0284ak10 = new C0284ak();
                                c0284ak10.m706g("Description", f602yk.f1923dT);
                                c0284ak10.m706g("SeshatFileKey", stringBuffer);
                                f602yk.m1980i(stringBuffer);
                                c0284ak10.m706g("Date", Long.toString(f602yk.f1920dQ));
                                c0284ak10.m706g("GLUID", GLLib.m434b(f602yk.f1921dR.getBytes()));
                                c0284ak10.m706g("Version", f602yk.f1927dX);
                                c0284ak5.m706g(stringBuffer, c0284ak10);
                            }
                            C0335o.m2040b(str, f602yk.m1979ar(), GLLib.m434b(f602yk.f1924dU.f592yi), "private", "cloudUploadPutKey");
                            m822n(InterfaceC0336p.f2051gS, "cloudUploadPutKey");
                            if (f616yy != 0) {
                                GLLib.m342C("Savegame upload to cloud was successful.");
                                String c0284ak11 = c0284ak.toString();
                                GLLib.m342C("Updated Table Of Contents.");
                                C0335o.m2040b(str, f615yx, c0284ak11, "private", "cloudUploadPutToc");
                                m822n(InterfaceC0336p.f2051gS, "cloudUploadPutToc");
                                if (f616yy == 0) {
                                    GLLib.m342C("Table Of Contents upload to cloud was successful.");
                                } else {
                                    f617yz = "Table Of Contents upload to cloud failed.";
                                    GLLib.m342C("Table Of Contents upload to cloud failed.");
                                }
                            } else {
                                f617yz = "Savegame upload to cloud failed.";
                            }
                            i5 = i6 + 1;
                        } catch (Exception e2) {
                            f616yy = -1;
                            f617yz = "profile quotas error";
                            GLLib.m342C("profile quotas error");
                            return;
                        }
                    }
                }
                f602yk.m1980i(c0284ak9.m704ab("SeshatFileKey"));
                C0335o.m2040b(str, f602yk.m1979ar(), GLLib.m434b(f602yk.f1924dU.f592yi), "private", "cloudUploadPutKey");
                m822n(InterfaceC0336p.f2051gS, "cloudUploadPutKey");
                if (f616yy != 0) {
                }
                i5 = i6 + 1;
            } catch (Exception e3) {
                f616yy = -1;
                f617yz = "error get field seshatFileKey";
                return;
            }
            i = -1;
            i2 = c0284ak5.f505vV;
            if (i2 != 0) {
            }
            if (i2 < f614yw) {
            }
            GLLib.m342C("Maximum number of saves reached. Overwriting oldest save.");
            int i72 = 0;
            long j22 = m805aK(((C0284ak) c0284ak5.f504vU[0]).m704ab("Date"));
            i3 = 1;
            long j32 = j22;
            while (i3 < i2) {
            }
            String l2 = Long.toString(f602yk.f1920dQ);
            C0284ak c0284ak92 = (C0284ak) c0284ak5.f504vU[i72];
            c0284ak92.m706g("Date", l2);
            c0284ak92.m706g("Description", f602yk.f1923dT);
            c0284ak92.m706g("Version", f602yk.f1927dX);
            c0284ak92.m706g("GLUID", GLLib.m434b(f602yk.f1921dR.getBytes()));
        }
    }

    static void m817dn() {
        if (C0338r.f2538tb) {
            f605yn = new Vector();
            GLLib.m342C("Retrieving saves from cloud");
            f616yy = 0;
            Vector vector = new Vector();
            vector.removeAllElements();
            if (f601yj != null) {
                vector.addElement(f601yj);
            } else {
                vector.addElement("me");
            }
            for (int i = 0; i < vector.size(); i++) {
                String str = (String) vector.elementAt(i);
                new C0284ak();
                C0335o.m2007a(str, f615yx, "cloudGetCloudList");
                m822n(InterfaceC0336p.f2050gR, "cloudGetCloudList");
                if (f616yy != 0) {
                    GLLib.m342C("Fail retrieve cloud list (TOC)");
                    return;
                }
                C0284ak c0284ak = new C0284ak(f598yF);
                if (((C0284ak) c0284ak.m702Z("TOC")) == null) {
                    f616yy = -13;
                    GLLib.m342C("field TOC not exist");
                    return;
                }
                C0284ak c0284ak2 = (C0284ak) c0284ak.m702Z("TOC");
                int i2 = c0284ak2.f505vV;
                if (i2 != 0) {
                    for (int i3 = 0; i3 < i2; i3++) {
                        try {
                            C0284ak c0284ak3 = (C0284ak) c0284ak2.f504vU[i3];
                            C0329i c0329i = new C0329i();
                            c0329i.f1928dY = str;
                            c0329i.m1980i(c0284ak3.m704ab("SeshatFileKey"));
                            c0329i.f1923dT = c0284ak3.m704ab("Description");
                            c0329i.f1920dQ = m805aK(c0284ak3.m704ab("Date"));
                            String m704ab = c0284ak3.m704ab("GLUID");
                            if (m704ab.length() > 0) {
                                c0329i.f1921dR = new String(GLLib.m355P(m704ab));
                                f605yn.addElement(c0329i);
                            } else {
                                GLLib.m342C("Savegame does not have ID.\n");
                            }
                        } catch (Exception e) {
                            f616yy = -13;
                            f617yz = "Invalid TOC content";
                            GLLib.m342C("Invalid TOC content");
                            return;
                        }
                    }
                }
            }
        }
    }

    static void m818do() {
        GLLib.m342C("Attempting to reset the clouds");
        f616yy = 0;
        C0335o.m2050k("$savegamelib.objects.TOC", "cloudDeleteToc");
        m822n(InterfaceC0336p.f2052gT, "cloudDeleteToc");
        C0335o.m2050k("$savegamelib.objects.key1", "cloudDeleteKey1");
        m822n(InterfaceC0336p.f2052gT, "cloudDeleteKey1");
        C0335o.m2050k("$savegamelib.objects.key2", "cloudDeleteKey2");
        m822n(InterfaceC0336p.f2052gT, "cloudDeleteKey2");
        C0335o.m2050k("$savegamelib.objects.key3", "cloudDeleteKey3");
        m822n(InterfaceC0336p.f2052gT, "cloudDeleteKey3");
        C0335o.m2050k("$savegamelib.objects.key4", "cloudDeleteKey4");
        m822n(InterfaceC0336p.f2052gT, "cloudDeleteKey4");
        C0335o.m2050k("$savegamelib.objects.key5", "cloudDeleteKey5");
        m822n(InterfaceC0336p.f2052gT, "cloudDeleteKey5");
    }

    static void m819dp() {
        f600yH = false;
        f594yB = true;
        GLLib.m342C("oss: thread ended");
    }

    private static int m820e(String str, String str2, String str3, String str4) {
        byte[] m355P;
        C0100b m227g;
        if (!C0338r.f2538tb) {
            return -1;
        }
        f616yy = 0;
        if (str2 != null) {
            C0335o.m2039b("me", str4, str2, "cloudRestoreGetKey");
        } else {
            C0335o.m2007a("me", str4, "cloudRestoreGetKey");
        }
        m822n(InterfaceC0336p.f2050gR, "cloudRestoreGetKey");
        if (f616yy != 0) {
            GLLib.m342C("Could not retrieve savegame");
            return f616yy;
        }
        try {
            m355P = GLLib.m355P(f598yF);
            if (m804aJ(f613yv)) {
                C0100b.m224dk(f613yv);
            }
            m227g = C0100b.m227g(f613yv, true);
            f603yl = m227g;
        } catch (Exception e) {
            GLLib.m342C(e.getMessage());
        }
        if (m227g == null) {
            return -16;
        }
        f603yl.m232e(m355P, 0, m355P.length);
        C0100b c0100b = f603yl;
        C0100b.m229uC();
        int m800aF = m800aF(f613yv);
        f616yy = m800aF;
        if (m800aF != 0) {
            return f616yy;
        }
        int i = f608yq;
        int m799aE = m799aE(str);
        f616yy = m799aE;
        if (m799aE != 0) {
            return f616yy;
        }
        for (int i2 = 0; i2 < i; i2++) {
            byte[] m801aG = m801aG(str3);
            if (f616yy != 0) {
                return f616yy;
            }
            int m821e = m821e(m801aG, m801aG.length);
            f616yy = m821e;
            if (m821e != 0) {
                return f616yy;
            }
        }
        int m806c = m806c("", false);
        f616yy = m806c;
        if (m806c != 0) {
            return f616yy;
        }
        f616yy = m813dj();
        try {
            C0100b.m224dk(f613yv);
        } catch (C0101c e2) {
            f616yy = -1;
        }
        return f616yy;
    }

    public static int m821e(byte[] bArr, int i) {
        return m795a(bArr, i, C0335o.m2031aK());
    }

    private static void m822n(int i, String str) {
        f596yD = -1;
        f598yF = "";
        f595yC = "";
        f597yE = null;
        boolean z = true;
        do {
            if (f596yD != i || !f595yC.equals(str)) {
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e) {
                }
            } else {
                if (f599yG > 200) {
                    f616yy = f599yG;
                    f617yz = new StringBuffer().append(str).append(" errorcode:").append(f599yG).toString();
                    return;
                }
                if (f597yE != null) {
                    if ("java.io.IOException".equals(f597yE.getClass().getName()) || "java.net.ConnectException".equals(f597yE.getClass().getName())) {
                        GLLib.m342C("No Internet connection");
                    }
                    f616yy = -1;
                    return;
                }
                if (f597yE != null) {
                    if ("java.io.IOException".equals(f597yE.getClass().getName()) || "java.net.ConnectException".equals(f597yE.getClass().getName())) {
                        GLLib.m342C("No Internet connection");
                    }
                    f616yy = -1;
                    return;
                }
                z = false;
            }
        } while (z);
        f616yy = 0;
    }

    public static boolean m823x(String str, String str2) {
        if (!C0338r.f2538tb) {
            return false;
        }
        f593yA = 3;
        f594yB = false;
        return m798a(new Object[]{str, str2});
    }

    static void m824y(String str, String str2) {
        C0284ak c0284ak;
        if (C0338r.f2538tb) {
            GLLib.m342C("Restoring save from cloud...");
            f616yy = 0;
            C0284ak c0284ak2 = new C0284ak(str);
            if (c0284ak2.f505vV <= 0 || !c0284ak2.f503vT[0].equals("json")) {
                c0284ak = c0284ak2;
            } else {
                try {
                    C0284ak[] m705ac = c0284ak2.m705ac("json");
                    for (int i = 0; i < m705ac.length; i++) {
                        if (m705ac[i].m702Z("seshatSaveKey") != null) {
                            c0284ak2 = m705ac[i];
                        }
                    }
                    c0284ak = c0284ak2;
                } catch (Exception e) {
                    c0284ak = c0284ak2;
                }
            }
            try {
                String m704ab = c0284ak.m704ab(ServerProtocol.DIALOG_PARAM_TYPE);
                if (m704ab == null) {
                    f616yy = -122;
                    return;
                }
                if (m704ab.compareTo("OptionalRestoreSave") == 0 || m704ab.compareTo("MandatoryRestoreSave") == 0) {
                }
                if (c0284ak.m703aa("version") != 1) {
                    f616yy = -123;
                    return;
                }
                String m704ab2 = c0284ak.m704ab("token");
                if (m704ab2 == null) {
                    f616yy = -122;
                    return;
                }
                if (c0284ak.m702Z("refresh_token") != null) {
                    m704ab2 = null;
                }
                String m704ab3 = c0284ak.m704ab("seshatSaveKey");
                if (m704ab3 == null) {
                    f616yy = -122;
                    return;
                }
                String m704ab4 = c0284ak.m704ab("key");
                if (m704ab4 == null) {
                    f616yy = -122;
                    return;
                }
                int m820e = m820e(str2, m704ab2, new String(GLLib.m355P(m704ab4)), m704ab3);
                f616yy = m820e;
                if (m820e == 0) {
                    f610ys = true;
                }
            } catch (Exception e2) {
                f617yz = e2.getMessage();
                f616yy = -1;
            }
        }
    }
}
