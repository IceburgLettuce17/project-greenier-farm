package com.gameloft.android.LATAM.GloftGF2H;

import p009b.p010a.p016e.C0100b;
import p009b.p010a.p016e.C0103e;

public final class C0294au {

    private RunnableC0342v f619yJ = null;

    private String f620yK;

    private String f621yL;

    private int f622yM;

    public C0294au(String str) {
        this.f621yL = str;
    }

    private boolean m825dq() {
        try {
            try {
                try {
                    C0100b m227g = C0100b.m227g("serverconfig", false);
                    int m235uD = m227g.m235uD();
                    for (int i = 1; i <= m235uD; i++) {
                        String str = new String(m227g.m234fq(i));
                        String m885b = C0316bp.m885b(str, 0, '|');
                        String m885b2 = C0316bp.m885b(str, 1, '|');
                        if (m885b.compareTo("Date") == 0) {
                            int parseInt = Integer.parseInt(C0316bp.m885b(m885b2, 0, '-'));
                            int parseInt2 = Integer.parseInt(C0316bp.m885b(m885b2, 1, '-'));
                            long currentTimeMillis = System.currentTimeMillis() / 1000;
                            int i2 = ((int) (currentTimeMillis / 31536000)) + 1970;
                            int i3 = ((int) (currentTimeMillis / 86400)) - ((i2 - 1970) * 365);
                            if (parseInt < i2 || (parseInt == i2 && i3 > parseInt2 + C0341u.f2633uX)) {
                                if (m227g == null) {
                                    return false;
                                }
                                try {
                                    C0100b.m229uC();
                                    return false;
                                } catch (Exception e) {
                                    C0316bp.m884aU(new StringBuffer("LoadServerConfig. Exception ").append(e).toString());
                                    return false;
                                }
                            }
                        } else if (m885b.compareTo("ETSAPI") == 0) {
                            this.f620yK = new String(m885b2);
                        }
                    }
                    if (this.f620yK == null) {
                        if (m227g == null) {
                            return false;
                        }
                        try {
                            C0100b.m229uC();
                            return false;
                        } catch (Exception e2) {
                            C0316bp.m884aU(new StringBuffer("LoadServerConfig. Exception ").append(e2).toString());
                            return false;
                        }
                    }
                    C0316bp.m884aU(new StringBuffer("m_sETSAPI: ").append(this.f620yK).toString());
                    if (m227g != null) {
                        try {
                            C0100b.m229uC();
                        } catch (Exception e3) {
                            C0316bp.m884aU(new StringBuffer("LoadServerConfig. Exception ").append(e3).toString());
                            return false;
                        }
                    }
                    return true;
                } catch (Exception e4) {
                    C0316bp.m884aU(new StringBuffer("LoadServerConfig. Exception ").append(e4).toString());
                    if (0 == 0) {
                        return false;
                    }
                    try {
                        C0100b.m229uC();
                        return false;
                    } catch (Exception e5) {
                        C0316bp.m884aU(new StringBuffer("LoadServerConfig. Exception ").append(e5).toString());
                        return false;
                    }
                }
            } catch (C0103e e6) {
                return false;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    C0100b.m229uC();
                } catch (Exception e7) {
                    C0316bp.m884aU(new StringBuffer("LoadServerConfig. Exception ").append(e7).toString());
                    return false;
                }
            }
            throw th;
        }
    }

    public final boolean m826dr() {
        switch (this.f622yM) {
            case 1:
                if (!this.f619yJ.isInProgress() && this.f619yJ.f2639dA != null) {
                    try {
                        this.f620yK = new C0280ag(this.f619yJ.f2639dA).getString("ets");
                        if (this.f620yK != null) {
                            C0100b c0100b = null;
                            try {
                                try {
                                    try {
                                        C0100b.m224dk("serverconfig");
                                    } catch (Exception e) {
                                        C0316bp.m884aU(new StringBuffer("SaveServerConfig: Exception ").append(e).toString());
                                        if (c0100b != null) {
                                            try {
                                                C0100b.m229uC();
                                            } catch (Exception e2) {
                                                C0316bp.m884aU(new StringBuffer("SaveServerConfig: Exception ").append(e2).toString());
                                            }
                                        }
                                    }
                                } catch (C0103e e3) {
                                }
                                c0100b = C0100b.m227g("serverconfig", true);
                                long currentTimeMillis = System.currentTimeMillis() / 1000;
                                int i = ((int) (currentTimeMillis / 31536000)) + 1970;
                                String stringBuffer = new StringBuffer("Date|").append(i).append("-").append(((int) (currentTimeMillis / 86400)) - ((i - 1970) * 365)).toString();
                                c0100b.m232e(stringBuffer.getBytes(), 0, stringBuffer.length());
                                if (this.f620yK != null) {
                                    String stringBuffer2 = new StringBuffer("ETSAPI|").append(this.f620yK).toString();
                                    c0100b.m232e(stringBuffer2.getBytes(), 0, stringBuffer2.length());
                                }
                                if (c0100b != null) {
                                    try {
                                        C0100b.m229uC();
                                    } catch (Exception e4) {
                                        C0316bp.m884aU(new StringBuffer("SaveServerConfig: Exception ").append(e4).toString());
                                    }
                                }
                                this.f622yM = 0;
                                break;
                            } catch (Throwable th) {
                                if (c0100b != null) {
                                    try {
                                        C0100b.m229uC();
                                    } catch (Exception e5) {
                                        C0316bp.m884aU(new StringBuffer("SaveServerConfig: Exception ").append(e5).toString());
                                    }
                                }
                                throw th;
                            }
                        }
                    } catch (C0279af e6) {
                        C0316bp.m884aU(e6.toString());
                        break;
                    }
                }
                break;
        }
        return this.f620yK != null;
    }

    public final String m827ds() {
        if (this.f620yK == null && !m825dq()) {
            this.f622yM = 1;
            String stringBuffer = new StringBuffer("/config/").append(this.f621yL).toString();
            if (this.f619yJ == null) {
                this.f619yJ = new RunnableC0342v();
            }
            this.f619yJ.m2144f("http://eve.gameloft.com:20001", stringBuffer);
            return "0";
        }
        return this.f620yK;
    }
}
