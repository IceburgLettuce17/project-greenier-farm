package com.gameloft.android.LATAM.GloftGF2H;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import p001a.p004b.p005a.p006a.C0002a;
import p009b.p010a.p011a.InterfaceC0037c;

public final class RunnableC0342v implements Runnable {
    private static String userAgent = null;

    private static final long f2638vj = C0341u.f2637vb;

    public String f2639dA;

    private long f2641dI;

    private String f2643dv;

    private String f2644vc;

    public long f2650vi;

    private Thread f2642du = null;

    private InterfaceC0037c f2645vd = null;

    private InputStream f2646ve = null;

    private OutputStream f2647vf = null;

    private boolean f2648vg = false;

    private boolean f2640dB = false;

    private boolean f2649vh = false;

    public final synchronized void cancel() {
        if (!this.f2649vh) {
            this.f2649vh = true;
            if (this.f2645vd != null) {
                try {
                    synchronized (this.f2645vd) {
                        this.f2646ve.close();
                    }
                } catch (Exception e) {
                }
                try {
                    synchronized (this.f2645vd) {
                        this.f2645vd.close();
                    }
                } catch (Exception e2) {
                }
                try {
                    synchronized (this.f2647vf) {
                        this.f2647vf.close();
                    }
                } catch (Exception e3) {
                }
                this.f2647vf = null;
            }
            this.f2646ve = null;
            this.f2645vd = null;
            this.f2640dB = false;
            this.f2642du = null;
        }
    }

    public final void cleanup() {
        cancel();
        this.f2639dA = null;
    }

    public final void m2144f(String str, String str2) {
        C0316bp.m884aU(new StringBuffer("CONNECT TO SERVER").append(str).append(str2).toString());
        this.f2648vg = false;
        this.f2641dI = System.currentTimeMillis();
        while (this.f2640dB) {
            try {
                if (System.currentTimeMillis() - this.f2641dI > f2638vj) {
                    cancel();
                }
                synchronized (this) {
                    wait(50L);
                }
            } catch (Exception e) {
            }
        }
        cleanup();
        this.f2640dB = true;
        this.f2649vh = false;
        this.f2643dv = new StringBuffer().append(str).append(str2).toString();
        if (this.f2642du != null) {
            try {
                this.f2642du.join();
            } catch (Exception e2) {
            }
        }
        this.f2642du = new Thread(this);
        this.f2642du.start();
    }

    public final boolean isInProgress() {
        return this.f2640dB;
    }

    public final void m2145o(String str, String str2) {
        C0316bp.m884aU(new StringBuffer("CONNECT TO SERVER").append(str).append("\t").append(str2).toString());
        this.f2648vg = true;
        this.f2641dI = System.currentTimeMillis();
        while (this.f2640dB) {
            try {
                if (System.currentTimeMillis() - this.f2641dI > f2638vj) {
                    cancel();
                }
                synchronized (this) {
                    wait(50L);
                }
            } catch (Exception e) {
            }
        }
        cleanup();
        this.f2640dB = true;
        this.f2649vh = false;
        this.f2643dv = str;
        this.f2644vc = str2;
        if (this.f2642du != null) {
            try {
                this.f2642du.join();
            } catch (Exception e2) {
            }
        }
        this.f2642du = new Thread(this);
        this.f2642du.start();
    }

    @Override
    public final void run() {
        if (this.f2643dv == null) {
            cancel();
            this.f2640dB = false;
            return;
        }
        if (this.f2648vg && this.f2644vc == null) {
            cancel();
            this.f2640dB = false;
            return;
        }
        try {
            if (this.f2649vh) {
                this.f2640dB = false;
                return;
            }
            this.f2645vd = (InterfaceC0037c) C0002a.m14b(this.f2643dv);
            if (this.f2648vg) {
                this.f2645vd.setRequestMethod("POST");
            } else {
                this.f2645vd.setRequestMethod("GET");
            }
            this.f2645vd.setRequestProperty("Connection", "close");
            if (this.f2648vg) {
                this.f2645vd.setRequestProperty("Content-Type", "application/json");
                byte[] bytes = this.f2644vc.getBytes("UTF-8");
                int length = bytes.length;
                this.f2645vd.setRequestProperty("Content-Length", String.valueOf(length));
                this.f2645vd.setRequestProperty("Accept-Charset", "UTF-8");
                this.f2647vf = this.f2645vd.mo108tQ();
                this.f2647vf.write(bytes, 0, length);
                this.f2647vf.flush();
            }
            int responseCode = this.f2645vd.getResponseCode();
            this.f2650vi = this.f2645vd.getDate();
            InterfaceC0037c interfaceC0037c = this.f2645vd;
            if (responseCode != 200) {
                cancel();
                this.f2640dB = false;
                return;
            }
            if (this.f2649vh) {
                this.f2640dB = false;
                return;
            }
            synchronized (this.f2645vd) {
                this.f2646ve = this.f2645vd.mo107tP();
            }
            Thread thread = this.f2642du;
            Thread.yield();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[16];
            int i = 0;
            while (i != -1) {
                if (!this.f2649vh) {
                    i = this.f2646ve.read(bArr, 0, 16);
                    if (i == -1) {
                        break;
                    } else {
                        byteArrayOutputStream.write(bArr, 0, i);
                    }
                } else {
                    this.f2640dB = false;
                    return;
                }
            }
            this.f2639dA = byteArrayOutputStream.toString();
            byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            this.f2640dB = false;
        } finally {
            cancel();
        }
    }
}
