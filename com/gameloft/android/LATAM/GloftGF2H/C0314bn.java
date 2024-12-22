package com.gameloft.android.LATAM.GloftGF2H;

import com.facebook.android.C0217R;
import com.facebook.internal.ServerProtocol;
import com.facebook.widget.PlacePickerFragment;
import com.gameloft.android.wrapper.C0355i;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.Hashtable;
import p009b.p010a.p015d.AbstractActivityC0092a;
import p009b.p010a.p016e.C0099a;
import p009b.p010a.p016e.C0100b;
import p009b.p010a.p016e.C0101c;
import p009b.p010a.p016e.C0104f;

public final class C0314bn extends C0341u {

    private static C0314bn f680Ab = null;

    private static String f681Ac;

    private String f682AA;

    private String f683AB;

    private String f684AC;

    private String f685AD;

    private boolean f686AE;

    private boolean f688AG;

    private boolean f689AH;

    private boolean f690AI;

    private boolean f692AK;

    private String f695AN;

    private long f696AO;

    private long f697AP;

    private String f698AQ;

    private long f699AR;

    private String f703AV;

    private C0312bl f708Ad;

    private C0294au f709Ae;

    protected AbstractActivityC0092a f710Af;

    private C0280ag f711Ag;

    private Hashtable f712Ah;

    private C0328h f713Ai;

    private C0287an f714Aj;

    private int f717Am;

    private int f718An;

    private int f719Ao;

    private int f720Ap;

    private int f722Ar;

    private long f723As;

    private long f724At;

    private long f725Au;

    private long f726Av;

    private long f727Aw;

    private long f728Ax;

    private long f732Bb;

    private long f733Bc;

    private RunnableC0342v f734Bd;

    private String f736yL;

    private int f737yM = 0;

    private int f715Ak = -1;

    private int f716Al = 0;

    private int f721Aq = 0;

    private long f729Ay = -1;

    private long f730Az = -1;

    private boolean f687AF = false;

    private boolean f691AJ = false;

    private String f700AS = "";

    private String f701AT = "";

    private String f702AU = "";

    private String f704AW = "";

    private boolean f705AX = false;

    private boolean f706AY = false;

    private boolean f707AZ = false;

    private long f731Ba = -1;

    private String f735Be = "{\n\t\"name\": \"GLOT User's Device\",\n\t\"params\": [{\n\t\t\"p\": \"carrier\"\n\t},\n\t{\n\t\t\"p\": \"d_country\"\n\t},\n\t{\n\t\t\"p\": \"d_lang\"\n\t},\n\t{\n\t\t\"p\": \"d_name\"\n\t},\n\t{\n\t\t\"p\": \"fw\"\n\t},\n\t{\n\t\t\"p\": \"glot_rev\"\n\t},\n\t{\n\t\t\"p\": \"jb\"\n\t}]\n}";

    private boolean f693AL = false;

    private boolean f694AM = false;

    private C0314bn() {
    }

    public static C0314bn m841a(AbstractActivityC0092a abstractActivityC0092a, String str, String str2) {
        return m842a(abstractActivityC0092a, str, str2, null);
    }

    public static C0314bn m842a(AbstractActivityC0092a abstractActivityC0092a, String str, String str2, String str3) {
        boolean z;
        if (f680Ab == null) {
            f680Ab = new C0314bn();
            f681Ac = str2;
            if (!f680Ab.f691AJ) {
                f680Ab.f695AN = str3;
                C0314bn c0314bn = f680Ab;
                String m851dK = c0314bn.m851dK();
                if (!c0314bn.f691AJ) {
                    c0314bn.f718An = C0341u.f2635uZ;
                    c0314bn.f723As = C0341u.f2636va;
                    c0314bn.f737yM = 0;
                    c0314bn.f710Af = abstractActivityC0092a;
                    c0314bn.m870ed();
                    c0314bn.f685AD = "3";
                    String m214di = c0314bn.f710Af.m214di("DeviceID");
                    if (m214di == null && (m214di = c0314bn.f710Af.m214di("IMEI")) == null) {
                        if (System.getProperty("MAC") != null) {
                            m214di = null;
                        } else {
                            m214di = System.getProperty("phone.imei");
                            if (m214di == null && (m214di = System.getProperty("com.nokia.imei")) == null && (m214di = System.getProperty("com.nokia.mid.imei")) == null && (m214di = System.getProperty("com.sonyericsson.imei")) == null && (m214di = System.getProperty("IMEI")) == null && (m214di = System.getProperty("com.motorola.IMEI")) == null && (m214di = System.getProperty("com.siemens.IMEI")) == null && (m214di = System.getProperty("com.lge.imei")) == null) {
                                m214di = "NULL";
                            }
                        }
                    }
                    c0314bn.f683AB = m214di;
                    String property = System.getProperty("MAC");
                    if (property == null && ((property = c0314bn.f710Af.m214di("MAC")) == null || property.compareTo("00:00:00:00:00:00") == 0)) {
                        property = null;
                    }
                    c0314bn.f684AC = property;
                    String property2 = System.getProperty("download.code");
                    if (property2 == null) {
                        property2 = "NULL";
                    } else if (property2.equals("")) {
                        property2 = "NULL";
                    }
                    c0314bn.f698AQ = property2;
                    C0316bp.m890g("**************************************** GLOT Initialize **********************************************", 1);
                    C0316bp.m890g("GLOT VERSION: 222", 1);
                    c0314bn.m859dS();
                    c0314bn.f736yL = str;
                    String str4 = c0314bn.f736yL;
                    String substring = str4.substring(str4.indexOf(58) + 1);
                    int indexOf = substring.indexOf(58);
                    c0314bn.f717Am = Integer.parseInt(substring.substring(0, indexOf));
                    c0314bn.f682AA = substring.substring(indexOf + 1, substring.indexOf(58, indexOf + 1));
                    c0314bn.m844aR(m851dK);
                    c0314bn.f686AE = true;
                    c0314bn.f687AF = false;
                    c0314bn.f690AI = true;
                    c0314bn.f712Ah = new Hashtable();
                    c0314bn.f713Ai = new C0328h();
                    c0314bn.f714Aj = c0314bn.m852dL();
                    c0314bn.f692AK = true;
                    long m861dU = c0314bn.m861dU();
                    c0314bn.f725Au = 0L;
                    c0314bn.f731Ba = 0L;
                    c0314bn.f733Bc = 0L;
                    c0314bn.m863dW();
                    if (m861dU < c0314bn.f731Ba) {
                        c0314bn.f720Ap = 106370;
                        c0314bn.f726Av = (999 + m861dU) / 1000;
                        if (c0314bn.f731Ba > 0 && c0314bn.f727Aw > 0) {
                            c0314bn.f728Ax = ((c0314bn.f731Ba - c0314bn.f727Aw) + 999) / 1000;
                        }
                        long j = m861dU / 1000;
                        if (c0314bn.f725Au > 0) {
                            c0314bn.f725Au += j;
                        }
                        c0314bn.f733Bc = j + c0314bn.f733Bc;
                    } else if (c0314bn.f731Ba > 0) {
                        c0314bn.f720Ap = 100003;
                        long j2 = m861dU - c0314bn.f731Ba;
                        c0314bn.f726Av = (999 + j2) / 1000;
                        if (c0314bn.f727Aw > 0) {
                            c0314bn.f728Ax = ((c0314bn.f731Ba - c0314bn.f727Aw) + 999) / 1000;
                        }
                        long j3 = j2 / 1000;
                        if (c0314bn.f725Au > 0) {
                            c0314bn.f725Au += j3;
                        }
                        c0314bn.f733Bc = j3 + c0314bn.f733Bc;
                    } else {
                        c0314bn.f720Ap = 100002;
                        c0314bn.f726Av = 0L;
                        c0314bn.f727Aw = 0L;
                        c0314bn.f728Ax = 0L;
                        c0314bn.f725Au = 0L;
                        c0314bn.f733Bc = m861dU / 1000;
                        C0316bp.m884aU("FIRST LAUNCH DETECTED !!!!!!!!!!!!!!!!");
                    }
                    long j4 = c0314bn.f725Au;
                    c0314bn.f696AO = c0314bn.f725Au;
                    c0314bn.m864dX();
                    c0314bn.f731Ba = m861dU;
                    c0314bn.f727Aw = m861dU;
                    c0314bn.m862dV();
                    int m866dZ = c0314bn.m866dZ();
                    c0314bn.f722Ar++;
                    if (m866dZ == -100) {
                        c0314bn.f719Ao = 0;
                        c0314bn.m871k(51856, 0, 100002, 100006);
                    } else {
                        int i = 100006;
                        if (!c0314bn.f689AH) {
                            i = 100005;
                            C0316bp.m890g("CRASH DETECED ***************** GENERATE AUTOMATIC BI CRASHED EVENT *****************", 1);
                        }
                        c0314bn.m871k(51856, 0, c0314bn.f720Ap, i);
                        if (i == 100005) {
                        }
                    }
                    c0314bn.f689AH = false;
                    c0314bn.m865dY();
                    c0314bn.m855dO();
                    c0314bn.f709Ae = new C0294au(c0314bn.f736yL);
                    c0314bn.f708Ad = new C0312bl();
                    c0314bn.f708Ad.m837a(f680Ab);
                    c0314bn.m856dP();
                    c0314bn.m868eb();
                    String property3 = System.getProperty("microetition.device.carrier");
                    String property4 = System.getProperty("microedition.locale.country");
                    String property5 = System.getProperty("microedition.locale");
                    String property6 = System.getProperty("microedition.device");
                    String property7 = System.getProperty("microedition.device.version");
                    boolean z2 = "1".compareTo(new StringBuffer().append(System.getProperty("isDeviceRooted")).toString()) == 0;
                    if (property3 == null) {
                        property3 = "00-000000000";
                    }
                    if (property4 == null) {
                        property4 = "XX";
                    }
                    if (property5 == null) {
                        property5 = "EN";
                    }
                    if (property6 == null) {
                        property6 = "Unknown";
                    }
                    if (property7 == null) {
                        property7 = "Unknown";
                    }
                    if (property3.compareTo(c0314bn.f700AS) == 0 && property4.compareTo(c0314bn.f701AT) == 0 && property5.compareTo(c0314bn.f702AU) == 0 && property6.compareTo(c0314bn.f703AV) == 0 && property7.compareTo(c0314bn.f704AW) == 0 && z2 == c0314bn.f705AX) {
                        z = false;
                    } else {
                        c0314bn.f700AS = property3;
                        c0314bn.f701AT = property4;
                        c0314bn.f702AU = property5;
                        c0314bn.f703AV = property6;
                        c0314bn.f704AW = property7;
                        c0314bn.f705AX = z2;
                        c0314bn.m869ec();
                        z = true;
                    }
                    if (z) {
                        String[] strArr = new String[7];
                        strArr[0] = c0314bn.f700AS;
                        strArr[1] = c0314bn.f701AT;
                        strArr[2] = c0314bn.f702AU;
                        strArr[3] = c0314bn.f703AV;
                        strArr[4] = c0314bn.f704AW;
                        strArr[5] = "222";
                        strArr[6] = c0314bn.f705AX ? "1" : "0";
                        c0314bn.m872a(51905, strArr);
                    }
                    c0314bn.f691AJ = true;
                }
            }
        }
        return f680Ab;
    }

    private void m843a(C0280ag c0280ag, C0280ag c0280ag2) {
        try {
            String stringBuffer = new StringBuffer().append(m857dQ()).toString();
            String string = c0280ag2.getString("ts");
            String string2 = c0280ag2.getString("connectivity");
            int i = c0280ag2.getInt("gt");
            long j = c0280ag2.getLong("sts");
            String string3 = c0280ag2.getString("ses_id");
            String string4 = c0280ag2.getString("ses_t");
            c0280ag.m693f("token", stringBuffer);
            c0280ag.m693f("ts", string);
            C0280ag m688W = c0280ag.m688W("data");
            m688W.m693f("connectivity", string2);
            m688W.m690c("gt", i);
            m688W.m689a("sts", j);
            m688W.m693f("ses_id", string3);
            m688W.m693f("ses_t", string4);
        } catch (Exception e) {
            C0316bp.m884aU(new StringBuffer("[ERROR when adding automatic event params]").append(e.getMessage()).toString());
        }
    }

    private void m844aR(String str) {
        try {
            this.f711Ag = new C0280ag(str);
            if (this.f711Ag.has("events")) {
                this.f711Ag = this.f711Ag.m688W("events");
                try {
                    this.f711Ag.m693f("51905", new C0280ag(this.f735Be));
                } catch (C0279af e) {
                }
            } else {
                C0316bp.m884aU("[ERROR] eventParameters in incorrect format. Please add the correct setup file or tracking WILL NOT WORK \n");
            }
        } catch (C0279af e2) {
            C0316bp.m884aU("[ERROR] eventParameters in incorrect format. Please add the correct setup file or tracking WILL NOT WORK (2)\n");
        }
    }

    private static int m845aS(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            C0316bp.m884aU(new StringBuffer("[ERROR]").append(e.getMessage()).toString());
            return 0;
        }
    }

    private void m846b(C0313bm c0313bm) {
        try {
            c0313bm.f678Aa.m693f("token", new StringBuffer().append(m857dQ()).toString());
            c0313bm.f678Aa.m693f("ts", new StringBuffer().append(m858dR()).toString());
            C0280ag m688W = c0313bm.f678Aa.m688W("data");
            if (this.f688AG) {
                m688W.m690c("connectivity", 100067);
            } else {
                m688W.m690c("connectivity", 100068);
            }
            m688W.m690c("gt", (this.f719Ao + 999) / PlacePickerFragment.DEFAULT_RADIUS_IN_METERS);
            long j = this.f725Au;
            if (j <= 0) {
                j = this.f733Bc;
            }
            m688W.m689a("sts", j);
            m688W.m690c("ses_id", this.f722Ar);
            long m861dU = ((m861dU() - this.f727Aw) + 999) / 1000;
            if (m861dU == 0) {
                m861dU = 1;
            }
            m688W.m689a("ses_t", m861dU);
        } catch (Exception e) {
            C0316bp.m884aU(new StringBuffer("[ERROR when adding automatic event params]").append(e.getMessage()).toString());
        }
    }

    private boolean m847c(C0313bm c0313bm) {
        if (this.f694AM) {
            return true;
        }
        if (c0313bm == null) {
            return false;
        }
        try {
            int i = c0313bm.f679id;
            C0280ag c0280ag = new C0280ag();
            C0280ag c0280ag2 = new C0280ag();
            C0280ag m688W = c0313bm.f678Aa.m688W("data");
            C0280ag m688W2 = this.f711Ag.m688W(new StringBuffer().append(i).toString());
            int i2 = m688W2.getInt("batch_size");
            C0278ae m687V = m688W2.m687V("params");
            int size = m687V.f499vP.size();
            for (int i3 = 0; i3 < size; i3++) {
                Object obj = m687V.get(i3);
                if (!(obj instanceof C0280ag)) {
                    throw new C0279af(new StringBuffer("JSONArray[").append(i3).append("] is not a JSONObjects.").toString());
                }
                C0280ag c0280ag3 = (C0280ag) obj;
                String string = c0280ag3.getString("p");
                String string2 = m688W.getString(string);
                if (c0280ag3.has("batching")) {
                    c0280ag2.m690c(string, m845aS(string2));
                } else {
                    c0280ag.m693f(string, string2);
                }
            }
            c0280ag2.m693f("automaticevent", m850dI());
            c0280ag2.m690c("count", 1);
            c0280ag.m693f("ver", this.f682AA);
            C0280ag c0280ag4 = new C0280ag();
            c0280ag4.m693f("data", c0280ag);
            c0280ag4.m690c(ServerProtocol.DIALOG_PARAM_TYPE, i);
            String c0280ag5 = c0280ag4.toString();
            C0280ag c0280ag6 = (C0280ag) this.f712Ah.get(c0280ag5);
            if (c0280ag6 == null) {
                this.f712Ah.put(c0280ag5, c0280ag2);
            } else {
                C0278ae m691ce = c0280ag6.m691ce();
                int size2 = m691ce.f499vP.size();
                if (size2 > 0) {
                    for (int i4 = 0; i4 < size2; i4++) {
                        String string3 = m691ce.getString(i4);
                        if (string3.compareTo("automaticevent") != 0) {
                            c0280ag6.m690c(string3, c0280ag2.getInt(string3) + c0280ag6.getInt(string3));
                        }
                    }
                }
                c0280ag6.m693f("automaticevent", m850dI());
            }
            C0280ag c0280ag7 = (C0280ag) this.f712Ah.get(c0280ag5);
            C0316bp.m890g(new StringBuffer("Add batched event: ").append(c0280ag5).append("/").append(c0280ag7).toString(), 1);
            if (((C0280ag) this.f712Ah.get(c0280ag5)).getInt("count") >= i2 || this.f706AY) {
                C0280ag m688W3 = c0280ag7.m688W("automaticevent");
                C0278ae m691ce2 = c0280ag7.m691ce();
                int size3 = m691ce2.f499vP.size();
                for (int i5 = 0; i5 < size3; i5++) {
                    String string4 = m691ce2.getString(i5);
                    if (string4.compareTo("automaticevent") != 0) {
                        m688W.m690c(string4, c0280ag7.getInt(string4));
                    }
                }
                if (size3 > 2) {
                    m688W.m690c("count_sb", m688W.getInt("count"));
                    m688W.m690c("count", 1);
                } else {
                    m688W.m690c("count_sb", 1);
                }
                m843a(c0313bm.f678Aa, m688W3);
                C0316bp.m884aU(new StringBuffer("batched event reach max count FLUSH Batched event to message").append(c0313bm.toString()).toString());
                m848d(c0313bm);
                this.f712Ah.remove(c0280ag5);
            }
            return true;
        } catch (Exception e) {
            C0316bp.m884aU(new StringBuffer("ERROR PUSH BATCH EVENT").append(e.getMessage()).toString());
            return false;
        }
    }

    private boolean m848d(C0313bm c0313bm) {
        try {
            C0287an m1975an = this.f713Ai.m1975an();
            if (m1975an != null) {
                if (m1975an.m708a(c0313bm)) {
                    m1975an.f511wb = m1975an.f511wb || this.f692AK;
                    C0316bp.m884aU(new StringBuffer("Save old message").append(c0313bm.f679id).toString());
                    this.f713Ai.m1972a(m1975an);
                    return true;
                }
                this.f713Ai.m1973al();
            }
            C0287an c0287an = new C0287an(this.f717Am, this.f683AB, this.f684AC, this.f685AD, this.f695AN);
            c0287an.f511wb = c0287an.f511wb || this.f692AK;
            if (this.f730Az != -1) {
                C0280ag c0280ag = c0287an.f510wa;
                long j = this.f730Az + 1;
                this.f730Az = j;
                c0280ag.m689a("pkg_id", j);
            }
            c0287an.m708a(c0313bm);
            this.f713Ai.m1972a(c0287an);
            C0316bp.m884aU(new StringBuffer("Save new message ").append(c0313bm.f679id).toString());
            return true;
        } catch (C0279af e) {
            C0316bp.m884aU("ERROR when saving message");
            return false;
        }
    }

    public static C0314bn m849dE() {
        return f680Ab;
    }

    private C0280ag m850dI() {
        C0280ag c0280ag = new C0280ag();
        try {
            c0280ag.m693f("ts", new StringBuffer().append(m858dR()).toString());
            if (this.f688AG) {
                c0280ag.m690c("connectivity", 100067);
            } else {
                c0280ag.m690c("connectivity", 100068);
            }
            c0280ag.m690c("gt", (this.f719Ao + 999) / PlacePickerFragment.DEFAULT_RADIUS_IN_METERS);
            long j = this.f725Au;
            if (j <= 0) {
                j = this.f733Bc;
            }
            c0280ag.m689a("sts", j);
            c0280ag.m690c("ses_id", this.f722Ar);
            long m861dU = ((m861dU() - this.f727Aw) + 999) / 1000;
            if (m861dU == 0) {
                m861dU = 1;
            }
            c0280ag.m689a("ses_t", m861dU);
            return c0280ag;
        } catch (Exception e) {
            C0316bp.m884aU(new StringBuffer("[ERROR when adding automatic event params for batch ev]").append(e.getMessage()).toString());
            return null;
        }
    }

    private String m851dK() {
        try {
            getClass();
            InputStreamReader inputStreamReader = new InputStreamReader(C0355i.getResourceAsStream("/events.json"));
            StringBuffer stringBuffer = new StringBuffer(1024);
            char[] cArr = new char[1024];
            while (true) {
                int read = inputStreamReader.read(cArr, 0, cArr.length);
                if (read == -1) {
                    return stringBuffer.toString();
                }
                stringBuffer.append(cArr, 0, read);
            }
        } catch (IOException e) {
            C0316bp.m884aU("[ERROR] cannot find eventParameters.json file. Contact BI team to get it");
            return null;
        }
    }

    private C0287an m852dL() {
        if (this.f725Au <= 0) {
            return null;
        }
        C0287an m1976ap = this.f713Ai.m1976ap();
        if (m1976ap == null) {
            this.f713Ai.m1974am();
            return null;
        }
        if (m1976ap != null && this.f725Au != 0) {
            try {
                if (m1976ap.f511wb) {
                    C0278ae m687V = m1976ap.f510wa.m687V("events");
                    int size = m687V.f499vP.size();
                    if (size > 0) {
                        for (int i = 0; i < size; i++) {
                            C0280ag m688W = ((C0280ag) m687V.get(i)).m688W("data");
                            long j = m688W.getLong("sts");
                            if (j < 31536000) {
                                j = this.f725Au - (this.f733Bc - j);
                            }
                            m688W.m689a("sts", j);
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
        C0316bp.m890g(new StringBuffer("MSG Created ").append(m1976ap).toString(), 1);
        return m1976ap;
    }

    private boolean m853dM() {
        if (this.f714Aj == null) {
            return false;
        }
        if (!this.f714Aj.f510wa.has("pkg_id")) {
            if (this.f729Ay == -1 || this.f730Az == -1) {
                C0316bp.m884aU("[ERROR]!!!!!!!!!!! ERROR !!!!!!!! Missing package id!!!!!!!!!!!!!!");
            } else {
                try {
                    C0280ag c0280ag = this.f714Aj.f510wa;
                    long j = this.f730Az + 1;
                    this.f730Az = j;
                    c0280ag.m689a("pkg_id", j);
                } catch (C0279af e) {
                    C0316bp.m884aU(new StringBuffer("ERROR put packet ID").append(e.getMessage()).toString());
                }
            }
        }
        this.f708Ad.m838a(false, this.f714Aj.f510wa.toString());
        return true;
    }

    private boolean m854dN() {
        try {
            C0100b m887e = C0316bp.m887e("SAGFdfajkshSF2345sMHL", true);
            if (m887e.m235uD() == 0) {
                m887e.m232e(new byte[1], 0, 1);
            }
            Enumeration keys = this.f712Ah.keys();
            byte[] bArr = new byte[4];
            C0316bp.m880a(this.f712Ah.size(), bArr, 0);
            while (keys.hasMoreElements()) {
                String obj = keys.nextElement().toString();
                String obj2 = this.f712Ah.get(obj).toString();
                byte[] bArr2 = new byte[4];
                C0316bp.m880a(C0316bp.m883aT(obj).length, bArr2, 0);
                byte[] m882a = C0316bp.m882a(C0316bp.m882a(bArr, bArr2), C0316bp.m883aT(obj));
                byte[] bArr3 = new byte[4];
                C0316bp.m880a(obj2.getBytes().length, bArr3, 0);
                bArr = C0316bp.m882a(C0316bp.m882a(m882a, bArr3), C0316bp.m883aT(obj2));
            }
            m887e.m231b(1, bArr, 0, bArr.length);
            C0100b.m229uC();
            this.f712Ah.clear();
            return true;
        } catch (Exception e) {
            C0316bp.m884aU(new StringBuffer("SAVE batch error").append(e.getMessage()).toString());
            return false;
        }
    }

    private void m855dO() {
        this.f712Ah.clear();
        try {
            C0100b m887e = C0316bp.m887e("SAGFdfajkshSF2345sMHL", false);
            if (m887e != null) {
                byte[] m234fq = m887e.m234fq(1);
                int m888f = C0316bp.m888f(m234fq, 0);
                int i = 4;
                for (int i2 = 0; i2 < m888f; i2++) {
                    int m888f2 = C0316bp.m888f(m234fq, i);
                    int i3 = i + 4;
                    String m886d = C0316bp.m886d(m234fq, i3, m888f2);
                    int i4 = i3 + m888f2;
                    int m888f3 = C0316bp.m888f(m234fq, i4);
                    int i5 = i4 + 4;
                    String m886d2 = C0316bp.m886d(m234fq, i5, m888f3);
                    i = i5 + m888f3;
                    C0316bp.m890g(new StringBuffer("LOAD SAVED BATCH EV  ").append(m886d).append("/").append(m886d2).toString(), 1);
                    this.f712Ah.put(m886d, new C0280ag(m886d2));
                }
                C0100b.m229uC();
                C0100b.m224dk("SAGFdfajkshSF2345sMHL");
            }
        } catch (Exception e) {
            C0316bp.m884aU(new StringBuffer("ERROR when load batch").append(e.getMessage()).toString());
        }
    }

    private void m856dP() {
        if (this.f686AE) {
            Enumeration keys = this.f712Ah.keys();
            while (keys.hasMoreElements()) {
                try {
                    Object nextElement = keys.nextElement();
                    String obj = nextElement.toString();
                    C0280ag c0280ag = new C0280ag(obj);
                    C0313bm c0313bm = new C0313bm(c0280ag.getInt(ServerProtocol.DIALOG_PARAM_TYPE), 2);
                    C0280ag m688W = c0280ag.m688W("data");
                    C0280ag c0280ag2 = new C0280ag(this.f712Ah.get(obj).toString());
                    C0280ag m688W2 = c0280ag2.m688W("automaticevent");
                    C0278ae m691ce = c0280ag2.m691ce();
                    int size = m691ce.f499vP.size();
                    for (int i = 0; i < size; i++) {
                        String string = m691ce.getString(i);
                        if (string.compareTo("automaticevent") != 0) {
                            m688W.m690c(string, c0280ag2.getInt(string));
                        }
                    }
                    if (size > 2) {
                        m688W.m690c("count_sb", m688W.getInt("count"));
                        m688W.m690c("count", 1);
                    } else {
                        m688W.m690c("count_sb", 1);
                    }
                    c0313bm.f678Aa = c0280ag;
                    m843a(c0313bm.f678Aa, m688W2);
                    C0316bp.m884aU(new StringBuffer("FLUSH Batched event to message").append(c0280ag.toString()).toString());
                    m848d(c0313bm);
                    this.f712Ah.remove(nextElement);
                } catch (C0279af e) {
                    C0316bp.m884aU(e.getMessage());
                }
            }
            this.f686AE = false;
        }
    }

    private long m857dQ() {
        long j = this.f724At + 1;
        this.f724At = j;
        return j;
    }

    private static String m858dR() {
        return new StringBuffer().append(System.currentTimeMillis() / 1000).toString();
    }

    private boolean m859dS() {
        String stringBuffer = new StringBuffer().append(this.f710Af.m214di("conectivity")).toString();
        if (stringBuffer.compareTo("on") == 0 || stringBuffer.compareTo("off") != 0) {
            this.f688AG = false;
            return !this.f693AL;
        }
        this.f688AG = true;
        return false;
    }

    private int m860dT() {
        int i;
        boolean z;
        long m861dU = m861dU();
        if (m861dU < 0) {
            i = 50;
            this.f731Ba += 50;
        } else {
            i = (int) (m861dU - this.f731Ba);
            this.f731Ba = m861dU;
        }
        this.f732Bb += i;
        if (this.f732Bb >= 1000) {
            if (this.f725Au > 0) {
                this.f725Au += this.f732Bb / 1000;
            } else {
                m864dX();
            }
        }
        this.f733Bc += this.f732Bb / 1000;
        long j = this.f732Bb + 0;
        this.f732Bb %= 1000;
        if (j >= 5000) {
            m862dV();
        }
        if (this.f734Bd != null && !this.f734Bd.isInProgress()) {
            if (this.f734Bd.f2639dA != null) {
                z = true;
                if (z) {
                    long j2 = this.f734Bd.f2650vi / 1000;
                    this.f734Bd.cleanup();
                    this.f734Bd = null;
                    this.f725Au = j2;
                    this.f697AP = this.f725Au - this.f696AO;
                    C0316bp.m884aU(new StringBuffer("Get new STS  ").append(this.f725Au).toString());
                    if (this.f696AO < 1) {
                        this.f697AP = 0L;
                        this.f696AO = 0L;
                    } else if (this.f720Ap != 100002) {
                        C0316bp.m884aU(new StringBuffer("Get new STS. Time different with old value: ").append(this.f697AP).toString());
                        this.f726Av += this.f697AP;
                        this.f733Bc += this.f697AP;
                    }
                    this.f692AK = false;
                    m862dV();
                }
                return i;
            }
            this.f734Bd.cancel();
            this.f734Bd = null;
        }
        z = false;
        if (z) {
        }
        return i;
    }

    private long m861dU() {
        String property = System.getProperty("deviceuptimemillis");
        if (property == null) {
            if (this.f710Af == null) {
                return -1L;
            }
            property = this.f710Af.m214di("deviceuptimemillis");
        }
        if (property == null) {
            C0316bp.m884aU("CRITICAL ERROR DUE TO OUT DATED WRAPPER VERSION !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            return -1L;
        }
        try {
            return Long.parseLong(property);
        } catch (NumberFormatException e) {
            C0316bp.m884aU("CRITICAL ERROR DUE TO OUT DATED WRAPPER VERSION !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            return -1L;
        }
    }

    private void m862dV() {
        try {
            C0100b m887e = C0316bp.m887e("glot_save_time", true);
            if (m887e == null) {
                return;
            }
            byte[] bArr = new byte[32];
            C0316bp.m881a(this.f731Ba, bArr, 0);
            C0316bp.m881a(this.f725Au, bArr, 8);
            C0316bp.m881a(this.f733Bc, bArr, 16);
            C0316bp.m881a(this.f727Aw, bArr, 24);
            if (m887e.m235uD() == 0) {
                m887e.m232e(bArr, 0, bArr.length);
            } else {
                m887e.m231b(1, bArr, 0, bArr.length);
            }
            C0100b.m229uC();
        } catch (Exception e) {
            C0316bp.m884aU(new StringBuffer("[ERROR] SAVE TIME").append(e.getMessage()).toString());
        }
    }

    private void m863dW() {
        try {
            C0100b m887e = C0316bp.m887e("glot_save_time", false);
            if (m887e == null) {
                return;
            }
            byte[] m234fq = m887e.m234fq(1);
            if (m234fq != null) {
                this.f731Ba = C0316bp.m889g(m234fq, 0);
                this.f725Au = C0316bp.m889g(m234fq, 8);
                this.f733Bc = C0316bp.m889g(m234fq, 16);
                this.f727Aw = C0316bp.m889g(m234fq, 24);
            }
            C0100b.m229uC();
        } catch (Exception e) {
            C0316bp.m884aU(new StringBuffer("[ERROR] LOAD SAVED TIME").append(e.getMessage()).toString());
        }
    }

    private void m864dX() {
        if (this.f688AG) {
            return;
        }
        if (this.f699AR == 0 || System.currentTimeMillis() - this.f699AR >= 180000) {
            this.f699AR = System.currentTimeMillis();
            if (this.f734Bd == null) {
                this.f734Bd = new RunnableC0342v();
            }
            if (this.f734Bd.isInProgress()) {
                return;
            }
            this.f734Bd.m2144f("http://vgold.gameloft.com:20000", "/locate/auth");
        }
    }

    private int m865dY() {
        int i = -101;
        try {
            C0100b m887e = C0316bp.m887e("File_marker", true);
            if (m887e == null) {
                return -101;
            }
            byte[] bArr = new byte[34];
            C0316bp.m881a(this.f724At, bArr, 0);
            bArr[8] = (byte) (this.f689AH ? 1 : 0);
            C0316bp.m880a(this.f719Ao, bArr, 9);
            C0316bp.m881a(this.f729Ay, bArr, 13);
            C0316bp.m881a(this.f730Az, bArr, 21);
            bArr[29] = (byte) this.f721Aq;
            C0316bp.m880a(this.f722Ar, bArr, 30);
            if (m887e.m235uD() == 0) {
                m887e.m232e(bArr, 0, bArr.length);
            } else {
                m887e.m231b(1, bArr, 0, bArr.length);
            }
            C0100b.m229uC();
            i = 0;
            return 0;
        } catch (Exception e) {
            return i;
        }
    }

    private int m866dZ() {
        try {
            C0100b m887e = C0316bp.m887e("File_marker", false);
            if (m887e == null || m887e.m235uD() == 0) {
                return -100;
            }
            byte[] m234fq = m887e.m234fq(1);
            this.f724At = C0316bp.m889g(m234fq, 0);
            this.f689AH = m234fq[8] != 0;
            this.f719Ao = C0316bp.m888f(m234fq, 9);
            this.f729Ay = C0316bp.m889g(m234fq, 13);
            this.f730Az = C0316bp.m889g(m234fq, 21);
            this.f721Aq = m234fq[29];
            this.f722Ar = C0316bp.m888f(m234fq, 30);
            C0100b.m229uC();
            return 0;
        } catch (Exception e) {
            return -101;
        }
    }

    private void m867ea() {
        do {
            try {
            } catch (C0101c e) {
                return;
            }
        } while (this.f713Ai.m1974am() < this.f713Ai.m1977aq());
        this.f713Ai.m1974am();
        this.f714Aj = null;
        C0100b.m224dk("SAGFdfajkshSF2345sMHL");
        this.f712Ah.clear();
    }

    private boolean m868eb() {
        byte[] m234fq;
        try {
            C0100b m887e = C0316bp.m887e("device", false);
            if (m887e == null || (m234fq = m887e.m234fq(1)) == null) {
                return false;
            }
            String str = new String(m234fq);
            this.f700AS = C0316bp.m885b(str, 0, '\n');
            this.f701AT = C0316bp.m885b(str, 1, '\n');
            this.f702AU = C0316bp.m885b(str, 2, '\n');
            this.f703AV = C0316bp.m885b(str, 3, '\n');
            this.f704AW = C0316bp.m885b(str, 4, '\n');
            this.f705AX = C0316bp.m885b(str, 5, '\n').compareTo("1") == 0;
            return true;
        } catch (C0099a e) {
            return false;
        } catch (C0104f e2) {
            return false;
        } catch (C0101c e3) {
            return false;
        }
    }

    private void m869ec() {
        try {
            C0100b m887e = C0316bp.m887e("device", true);
            byte[] bytes = new StringBuffer().append(this.f700AS).append("\n").append(this.f701AT).append("\n").append(this.f702AU).append("\n").append(this.f703AV).append("\n").append(this.f704AW).append("\n").append(this.f705AX ? "1" : "0").toString().getBytes();
            if (m887e.m235uD() == 0) {
                m887e.m232e(bytes, 0, bytes.length);
            } else {
                m887e.m231b(1, bytes, 0, bytes.length);
            }
        } catch (C0101c e) {
        }
    }

    private void m870ed() {
        String property = System.getProperty("glot.debug.infor");
        if (property != null) {
            try {
                C0280ag c0280ag = new C0280ag(property);
                if (c0280ag.getInt("LOG") == 1) {
                    C0316bp.f740Bh = true;
                }
                C0316bp.m890g(c0280ag.toString(), 1);
                C0316bp.f739Bg = c0280ag.getInt("LEVEL");
                if (c0280ag.getInt("INSTANTMODE") == 1) {
                    C0316bp.m890g("DETECT INSTANT MODE ", 1);
                    this.f706AY = true;
                }
            } catch (C0279af e) {
            }
        }
    }

    private boolean m871k(int i, int i2, int i3, int i4) {
        try {
            C0313bm c0313bm = new C0313bm(i, 0);
            C0280ag c0280ag = c0313bm.f678Aa;
            c0280ag.m690c(ServerProtocol.DIALOG_PARAM_TYPE, i);
            C0280ag c0280ag2 = new C0280ag();
            if (i == 51856) {
                c0280ag2.m690c("launch_type", i3);
                c0280ag2.m690c("crash_detection", i4);
                c0280ag2.m689a("time_between_sessions", this.f726Av);
                c0280ag2.m689a("time_spent", this.f728Ax);
                c0280ag2.m693f("igp_code", f681Ac);
                c0280ag2.m693f("download_code", this.f698AQ);
            }
            c0280ag2.m693f("ver", this.f682AA);
            c0280ag.m693f("data", c0280ag2);
            m846b(c0313bm);
            C0316bp.m890g(new StringBuffer("Add automatic event: LAUNCH/PAUSE:\t").append(c0313bm).toString(), 1);
            m848d(c0313bm);
            if (c0313bm.type != 1) {
                return true;
            }
            this.f723As = -1L;
            return true;
        } catch (C0279af e) {
            C0316bp.m884aU(new StringBuffer("[ERROR] JSON exception on auto generated BI event !!!").append(e.getMessage()).toString());
            return false;
        }
    }

    public final void m872a(int i, String[] strArr) {
        C0280ag c0280ag;
        int i2;
        if (this.f694AM) {
            C0316bp.m884aU("BLOCKED ADDING from server !!!!!!!!!!");
            return;
        }
        try {
            if (!this.f711Ag.has(new StringBuffer().append(i).toString())) {
                C0316bp.m884aU(new StringBuffer("[ERROR] AddEvent !!!!!!!!!!!!!! Event DOES NOT EXIST:\t").append(i).toString());
                return;
            }
            try {
                c0280ag = this.f711Ag.m688W(new StringBuffer().append(i).toString());
            } catch (C0279af e) {
                C0316bp.m884aU(new StringBuffer("[ERROR] AddEvent !!!!!!!!!!!!!! Invalid event parameters\t").append(i).toString());
                c0280ag = null;
            }
            if (c0280ag != null) {
                if (c0280ag.has("dis")) {
                    C0316bp.m884aU(new StringBuffer("[ERROR] AddEvent !!!!!!!!!!!!!! Event disabled:\t").append(i).toString());
                    return;
                }
                C0313bm c0313bm = new C0313bm();
                c0313bm.type = 0;
                if (c0280ag.has("batch_size")) {
                    try {
                        i2 = c0280ag.getInt("batch_size");
                    } catch (C0279af e2) {
                        C0316bp.m884aU("[ERROR] AddEvent !!!!!!!!!!!!!!invalid batch_size");
                        i2 = 0;
                    }
                    if (i2 > 0) {
                        c0313bm.type = 2;
                    }
                }
                if (c0280ag.has("prio")) {
                    try {
                        if (c0280ag.getInt("prio") == 1) {
                            c0313bm.type = 1;
                        }
                    } catch (C0279af e3) {
                    }
                }
                C0280ag c0280ag2 = c0313bm.f678Aa;
                c0313bm.f679id = i;
                c0280ag2.m690c(ServerProtocol.DIALOG_PARAM_TYPE, c0313bm.f679id);
                C0280ag c0280ag3 = new C0280ag();
                c0280ag3.m693f("ver", this.f682AA);
                c0280ag2.m693f("data", c0280ag3);
                if (c0313bm.type != 2) {
                    m846b(c0313bm);
                }
                C0278ae m687V = c0280ag.m687V("params");
                int size = m687V.f499vP.size();
                if (size != strArr.length && size != 0) {
                    C0316bp.m884aU(new StringBuffer("[ERROR] AddEvent  ERROR Too many or too few event parameter ").append(i).toString());
                    return;
                }
                if (size != 0) {
                    for (int i3 = 0; i3 < size; i3++) {
                        C0280ag c0280ag4 = (C0280ag) m687V.get(i3);
                        if (!c0280ag4.has("dis") && c0280ag4.has("p")) {
                            c0280ag3.m693f(c0280ag4.getString("p"), strArr[i3]);
                        }
                    }
                } else {
                    C0316bp.m884aU("[ERROR] Event has no params !!!!");
                }
                if (c0313bm.type == 2) {
                    m847c(c0313bm);
                    if (this.f706AY) {
                        this.f723As = -1L;
                        return;
                    }
                    return;
                }
                if (c0313bm.type == 1 || this.f706AY) {
                    this.f723As = -1L;
                }
                C0316bp.m884aU(new StringBuffer("ADDD new event ").append(i).append(":").append(c0313bm.toString()).toString());
                m848d(c0313bm);
            }
        } catch (C0279af e4) {
            C0316bp.m884aU("[ERROR] Addevent Unknown json error !!!");
        }
    }

    protected final void m873d(String str, boolean z) {
        switch (this.f737yM) {
            case 2:
                if (!z) {
                    this.f716Al++;
                    if (this.f716Al >= C0341u.f2634uY) {
                        this.f690AI = true;
                        C0316bp.m884aU("[ERROR]!!!!!!!!!!!!!!!!! REQUEST PACKAGE ID FAILD");
                        this.f716Al = 0;
                        this.f723As = this.f718An;
                        this.f737yM = 0;
                        break;
                    } else {
                        this.f737yM = 1;
                        break;
                    }
                } else {
                    int indexOf = str.indexOf(124);
                    if (indexOf == -1) {
                        this.f690AI = true;
                        break;
                    } else {
                        try {
                            this.f715Ak = Integer.parseInt(str.substring(indexOf + 1));
                        } catch (Exception e) {
                            C0316bp.m884aU(new StringBuffer("ERROR PARSE INT").append(e.getMessage()).toString());
                        }
                        if (this.f729Ay == -1) {
                            this.f729Ay = this.f715Ak;
                            this.f730Az = this.f715Ak;
                        } else if (this.f729Ay != this.f715Ak) {
                            C0316bp.m884aU(new StringBuffer("[ERROR]!!!!!!!!!!Package ID doesn't match with server iD: ").append(this.f729Ay).append("/").append(this.f715Ak).toString());
                        }
                        this.f723As = -1L;
                        this.f737yM = 0;
                        break;
                    }
                }
            case 3:
            default:
                this.f737yM = 0;
                break;
            case C0217R.styleable.com_facebook_picker_fragment_done_button_text:
                if (!z) {
                    this.f716Al++;
                    if (this.f716Al >= C0341u.f2634uY) {
                        C0316bp.m884aU("[ERROR]SEND MESSAGE FAILD");
                        this.f716Al = 0;
                        int m845aS = m845aS(str);
                        switch (m845aS) {
                            case 409:
                                C0316bp.m884aU("[ERROR] !!!!!!!!!!!!!!!! 409 Something very bad happen !!!!!!! invalid json format message \n");
                                this.f713Ai.m1974am();
                                break;
                            case 410:
                                C0316bp.m884aU("[ERROR] !!!!!!!!!!!!!!!! 410 Invalid request format \n");
                                this.f713Ai.m1974am();
                                break;
                            case 411:
                                C0316bp.m884aU("[ERROR] !!!!!!!!!!!!!!!! 411 Save failed Game is not registered for tracking  \n");
                                this.f713Ai.m1974am();
                                break;
                            case 415:
                                C0316bp.m884aU("[ERROR] !!!!!!!!!!!!!!!! 415 Save failed Game is not registered for tracking  \n");
                                this.f713Ai.m1974am();
                                break;
                            case 416:
                                C0316bp.m884aU("[ERROR] !!!!!!!!!!!!!!!! 416 Save failed  Mac address is invalid \n");
                                this.f713Ai.m1974am();
                                break;
                            case 701:
                            case 702:
                            case 703:
                                C0316bp.m884aU(new StringBuffer("Handle server command  ").append(m845aS).toString());
                                if (m845aS != 701) {
                                    if (m845aS != 702) {
                                        if (m845aS == 703) {
                                            this.f693AL = true;
                                            this.f694AM = true;
                                            m867ea();
                                            break;
                                        }
                                    } else {
                                        this.f693AL = true;
                                        this.f694AM = false;
                                        m867ea();
                                        break;
                                    }
                                } else {
                                    this.f693AL = true;
                                    this.f694AM = false;
                                    break;
                                }
                                break;
                        }
                        this.f714Aj = null;
                        m865dY();
                        this.f737yM = 3;
                        this.f737yM = 0;
                        m865dY();
                        this.f690AI = true;
                        break;
                    } else {
                        this.f737yM = 3;
                        break;
                    }
                } else {
                    this.f716Al = 0;
                    try {
                        this.f729Ay = this.f714Aj.f510wa.getInt("pkg_id");
                        this.f713Ai.m1974am();
                        this.f714Aj = null;
                        m865dY();
                        this.f737yM = 3;
                        break;
                    } catch (C0279af e2) {
                        C0316bp.m884aU(new StringBuffer("[ERROR] message missing package ID").append(e2.toString()).toString());
                        return;
                    }
                }
        }
    }

    public final void m874dF() {
        if (this.f691AJ) {
            C0316bp.m890g("OnDestroy() EXIT THE GAME. SAVE BATCHED MESSAGES TO RMS !", 1);
            m854dN();
            this.f689AH = true;
            m865dY();
        }
    }

    public final void m875dG() {
        if (this.f707AZ) {
            this.f707AZ = false;
            this.f722Ar++;
            m859dS();
            long m861dU = ((m861dU() - this.f727Aw) + 999) / 1000;
            if (!this.f691AJ || m861dU < 3) {
                return;
            }
            C0316bp.m890g(new StringBuffer("OnResume() RESUME THE GAME, Session ID:").append(this.f722Ar).toString(), 1);
            if (this.f689AH) {
                this.f728Ax = ((this.f731Ba - this.f727Aw) + 999) / 1000;
                this.f727Aw = m861dU();
                this.f726Av = (m860dT() + 59999) / 60000;
                m871k(51856, 0, 100004, 100006);
            }
            this.f686AE = true;
            m856dP();
            m855dO();
            this.f689AH = false;
            m865dY();
            if (this.f706AY) {
                this.f723As = -1L;
            }
        }
    }

    public final void m876dH() {
        if (this.f707AZ) {
            return;
        }
        this.f707AZ = true;
        if (this.f691AJ) {
            C0316bp.m890g("OnPause() GAME PAUSED", 1);
            m871k(51857, 0, 0, 0);
            m854dN();
            this.f689AH = true;
            m865dY();
        }
    }

    public final int m877dJ() {
        int m860dT = m860dT();
        this.f719Ao += m860dT;
        if (this.f691AJ) {
            if (!this.f687AF && this.f709Ae.m826dr()) {
                this.f723As = -1L;
            }
            switch (this.f737yM) {
                case 0:
                    this.f723As -= m860dT;
                    if (this.f723As < 0) {
                        if (!m859dS()) {
                            if (!this.f688AG) {
                                this.f723As = this.f718An;
                                break;
                            } else {
                                this.f723As = this.f718An;
                                break;
                            }
                        } else if (!this.f687AF) {
                            String m827ds = this.f709Ae.m827ds();
                            if (m827ds.compareTo("0") == 0) {
                                this.f723As = this.f718An;
                                break;
                            } else {
                                this.f687AF = true;
                                this.f709Ae = null;
                                this.f708Ad.m839aQ(m827ds);
                                C0316bp.m884aU(new StringBuffer("Server config loaded: ").append(m827ds).toString());
                                break;
                            }
                        } else if (!this.f690AI) {
                            this.f737yM = 5;
                            this.f723As = this.f718An;
                            break;
                        } else {
                            this.f690AI = false;
                            this.f737yM = 1;
                            break;
                        }
                    }
                    break;
                case 1:
                    try {
                        C0280ag c0280ag = new C0280ag();
                        c0280ag.m693f("udid", this.f683AB);
                        c0280ag.m690c("ggid", this.f717Am);
                        c0280ag.m693f("mac", this.f684AC);
                        c0280ag.m693f("proto_ver", this.f685AD);
                        this.f708Ad.m838a(true, c0280ag.toString());
                    } catch (C0279af e) {
                        C0316bp.m884aU("[ERROR] Exception JSON on request packetID");
                    }
                    this.f737yM = 2;
                    break;
                case 2:
                case C0217R.styleable.com_facebook_picker_fragment_done_button_text:
                    if (this.f708Ad != null) {
                        this.f708Ad.m840dD();
                        break;
                    }
                    break;
                case 3:
                    if (this.f714Aj != null) {
                        m853dM();
                        m865dY();
                        this.f737yM = 4;
                        break;
                    } else {
                        this.f737yM = 5;
                        break;
                    }
                case C0217R.styleable.com_facebook_picker_fragment_title_bar_background:
                    this.f714Aj = m852dL();
                    if (this.f714Aj == null) {
                        this.f737yM = 0;
                        break;
                    } else if (this.f714Aj.m709cg() <= 0) {
                        this.f714Aj = null;
                        this.f737yM = 0;
                        break;
                    } else {
                        this.f737yM = 3;
                        break;
                    }
            }
        }
        return m860dT;
    }
}
