package com.gameloft.android.LATAM.GloftGF2H;

import java.util.Timer;
import java.util.Vector;
import p001a.p004b.p005a.p006a.C0002a;
import p009b.p018b.p019a.C0107b;
import p009b.p018b.p019a.InterfaceC0106a;

final class C0289ap extends Thread {
    C0289ap() {
    }

    @Override
    public final void run() {
        String str;
        String str2;
        String str3;
        int i;
        String[][] strArr;
        int i2;
        String stringBuffer;
        String str4;
        String property;
        String str5;
        String str6;
        long j;
        long j2;
        String str7;
        Vector vector;
        Timer timer;
        String str8;
        C0288ao.m736aq("PaySMS.buy: new thread started");
        try {
            String str9 = C0338r.f2512sb ? "sms://" : "";
            str = C0288ao.f516wD;
            if (str.equals("")) {
                str2 = C0288ao.f538wZ;
                if (str2.equals("1")) {
                    property = C0288ao.getProperty(new StringBuffer("IAP-ShortCode-PP").append(C0288ao.f542wf).toString());
                    String unused = C0288ao.f566xa = property;
                } else {
                    String unused2 = C0288ao.f566xa = "";
                }
                str3 = C0288ao.f566xa;
                if (str3.equals("")) {
                    i = C0288ao.f527wO;
                    if (i == -1) {
                        C0288ao.warning("PaySMS.buy: SMS sent failed!, unknown adress");
                        boolean unused3 = C0288ao.f534wV = false;
                        C0288ao.m792r(C0288ao.f531wS[0], "0");
                        C0288ao.m790o(false);
                        int unused4 = C0288ao.errorCode = -1;
                        return;
                    }
                    StringBuffer append = new StringBuffer().append(str9);
                    strArr = C0288ao.f550wn;
                    i2 = C0288ao.f527wO;
                    stringBuffer = append.append(strArr[i2][11]).toString();
                } else {
                    StringBuffer append2 = new StringBuffer().append(str9);
                    str4 = C0288ao.f566xa;
                    stringBuffer = append2.append(str4).toString();
                }
            } else {
                StringBuffer append3 = new StringBuffer().append(str9);
                str8 = C0288ao.f516wD;
                stringBuffer = append3.append(str8).toString();
            }
            C0288ao.m736aq(new StringBuffer("PaySMS.buy: smsAdress: ").append(stringBuffer).toString());
            C0288ao.f575xj = (C0107b) C0002a.m14b(stringBuffer);
            C0288ao.m736aq(new StringBuffer("PaySMS.buy: Connection opened - conn: ").append(C0288ao.f575xj).toString());
            InterfaceC0106a m239dm = C0288ao.f575xj.m239dm("text");
            C0288ao.m736aq(new StringBuffer("PaySMS.buy: TextMessage created - msg: ").append(m239dm).toString());
            str5 = C0288ao.f525wM;
            m239dm.mo236dl(str5);
            try {
                Thread.sleep(200L);
            } catch (Exception e) {
                C0288ao.warning(new StringBuffer("PaySMS.buy: Exception trying to sleep: ").append(e.toString()).toString());
            }
            if (C0338r.f2516sf > 0) {
                Timer unused5 = C0288ao.f512dZ = new Timer();
                timer = C0288ao.f512dZ;
                timer.schedule(new C0274aa(), C0338r.f2516sf);
            }
            C0288ao.f575xj.m238a(m239dm);
            C0288ao.f577xl = true;
            C0288ao.m736aq("PaySMS.buy: Message sent!");
            boolean unused6 = C0288ao.f534wV = true;
            C0288ao.m792r(C0288ao.f531wS[0], "1");
            String str10 = C0288ao.f531wS[1];
            str6 = C0288ao.f526wN;
            C0288ao.m792r(str10, str6);
            C0288ao.m792r(C0288ao.f531wS[2], String.valueOf(C0288ao.f540wd));
            C0288ao.m792r(C0288ao.f531wS[5], C0288ao.f541we);
            C0288ao.m759cR();
            String str11 = C0288ao.f531wS[11];
            StringBuffer stringBuffer2 = new StringBuffer();
            j = C0288ao.f530wR;
            C0288ao.m792r(str11, stringBuffer2.append(j).toString());
            C0288ao.m792r(C0288ao.f531wS[12], "sms_2d");
            String str12 = C0288ao.f531wS[13];
            StringBuffer stringBuffer3 = new StringBuffer();
            j2 = C0288ao.f529wQ;
            C0288ao.m792r(str12, stringBuffer3.append(j2).toString());
            str7 = C0288ao.f538wZ;
            if (!str7.equals("1")) {
                vector = C0288ao.f560wx;
                C0288ao.m715a(vector);
            }
            try {
                Thread.sleep(100L);
            } catch (Exception e2) {
                C0288ao.warning(new StringBuffer("PaySMS.buy: Exception trying to sleep: ").append(e2.toString()).toString());
            }
        } catch (SecurityException e3) {
            boolean unused7 = C0288ao.f534wV = false;
            C0288ao.m792r(C0288ao.f531wS[0], "0");
            int unused8 = C0288ao.errorCode = -9;
            C0288ao.warning(new StringBuffer("PaySMS.buy: SMS sent failed! Security Exception: ").append(e3.toString()).toString());
        } catch (Throwable th) {
            boolean unused9 = C0288ao.f534wV = false;
            C0288ao.m792r(C0288ao.f531wS[0], "0");
            if (C0288ao.f576xk) {
                int unused10 = C0288ao.errorCode = -4;
            } else {
                int unused11 = C0288ao.errorCode = -1;
            }
            C0288ao.warning(new StringBuffer("PaySMS.buy: SMS sent failed! Exception: ").append(th.toString()).toString());
        }
        try {
            if (C0288ao.f575xj != null) {
                C0288ao.f575xj.close();
            }
            C0288ao.m736aq("PaySMS.buy: Connection closed!");
        } catch (Exception e4) {
            C0288ao.warning(new StringBuffer("PaySMS.buy: Failed to close connection! Exception: ").append(e4.toString()).toString());
        }
        C0288ao.m790o(false);
        C0288ao.m736aq("PaySMS.buy: SMS Thread ended!");
    }
}
