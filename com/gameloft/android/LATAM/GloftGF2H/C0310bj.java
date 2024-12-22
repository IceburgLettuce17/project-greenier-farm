package com.gameloft.android.LATAM.GloftGF2H;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;
import p001a.p004b.p005a.p006a.C0002a;
import p009b.p010a.p011a.InterfaceC0042h;

public final class C0310bj extends Thread {

    private static int f651zB = -1;
    private String url;

    public Exception f653vu;

    private boolean f654zC;

    public boolean f655zD;

    public String f656zE;

    private C0311bk f657zF;

    private InterfaceC0042h f660zI = null;

    private InputStream f661zJ = null;

    private OutputStream f662zK = null;

    public boolean f652dC = false;

    protected Vector f658zG = new Vector();

    private Vector f659zH = new Vector();

    private boolean f663zL = false;

    public C0310bj(String str, boolean z) {
        this.url = str;
    }

    private void cleanup() {
        if (this.f657zF != null) {
            this.f657zF.f667zP = false;
        }
        try {
            if (this.f661zJ != null) {
                this.f661zJ.close();
            }
        } catch (Exception e) {
        }
        try {
            if (this.f662zK != null) {
                this.f662zK.close();
            }
        } catch (Exception e2) {
        }
        try {
            if (this.f660zI != null) {
                this.f660zI.close();
            }
        } catch (Exception e3) {
        }
        this.f661zJ = null;
        this.f662zK = null;
        this.f660zI = null;
        synchronized (this.f659zH) {
            while (this.f659zH.size() > 0) {
                this.f659zH.removeElementAt(0);
            }
        }
        synchronized (this.f658zG) {
            while (this.f658zG.size() > 0) {
                this.f658zG.removeElementAt(0);
            }
        }
    }

    public final void connect() {
        if (this.f654zC) {
            return;
        }
        try {
            new Thread(this).start();
        } catch (Exception e) {
        }
    }

    public final void m833d(byte[] bArr) {
        synchronized (this.f659zH) {
            this.f659zH.addElement(bArr);
        }
    }

    public final byte[] m834dA() {
        byte[] bArr = null;
        synchronized (this.f658zG) {
            if (this.f658zG.size() > 0) {
                bArr = (byte[]) this.f658zG.firstElement();
                this.f658zG.removeElementAt(0);
            }
        }
        return bArr;
    }

    public final void disconnect() {
        this.f655zD = true;
    }

    @Override
    public final void run() {
        byte[] bArr;
        this.f654zC = false;
        this.f652dC = false;
        try {
            this.f660zI = (InterfaceC0042h) C0002a.m14b(this.url);
            if (this.f660zI == null) {
                this.f652dC = true;
                return;
            }
            this.f662zK = null;
            try {
                this.f662zK = this.f660zI.mo108tQ();
                if (this.f662zK == null) {
                    this.f652dC = true;
                    return;
                }
                this.f661zJ = null;
                try {
                    this.f661zJ = this.f660zI.mo107tP();
                    if (this.f661zJ == null) {
                        this.f652dC = true;
                        return;
                    }
                    this.f654zC = true;
                    this.f657zF = new C0311bk(this, this.f661zJ, this.f658zG, this.f663zL, this);
                    C0311bk c0311bk = this.f657zF;
                    new StringBuffer("receive_").append((String) null).toString();
                    this.f657zF.start();
                    while (this.f654zC && this.f657zF.f667zP) {
                        synchronized (this.f659zH) {
                            if (this.f659zH.size() > 0) {
                                bArr = (byte[]) this.f659zH.firstElement();
                                this.f659zH.removeElementAt(0);
                            } else {
                                if (this.f655zD) {
                                    this.f654zC = false;
                                }
                                bArr = null;
                            }
                        }
                        if (bArr == null) {
                            try {
                                Thread.sleep(300L);
                            } catch (InterruptedException e) {
                            }
                        } else {
                            try {
                                this.f662zK.write(bArr);
                            } catch (Exception e2) {
                                this.f652dC = true;
                                this.f653vu = e2;
                                this.f654zC = false;
                            }
                            try {
                                Thread.sleep(300L);
                            } catch (InterruptedException e3) {
                            }
                        }
                    }
                    this.f654zC = false;
                    cleanup();
                } catch (Exception e4) {
                    this.f652dC = true;
                    this.f653vu = e4;
                }
            } catch (Exception e5) {
                this.f652dC = true;
                this.f653vu = e5;
            }
        } catch (Exception e6) {
            this.f652dC = true;
            this.f653vu = e6;
        }
    }
}
