package com.gameloft.android.LATAM.GloftGF2H;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

public final class RunnableC0345y implements Runnable {

    public String f2652dA;

    private boolean f2653dB;

    public boolean f2654dC;

    private Thread f2655du;

    private String f2656dv;

    private String f2657vc;

    private InputStream f2658ve;

    private OutputStream f2659vf;

    private boolean f2660vh;

    public long f2661vi;

    private long f2662vl;

    private boolean f2663vm;

    private HttpURLConnection f2664vn;

    public byte[] f2665vo;

    private int f2666vp;

    private boolean f2667vq;

    private boolean f2668vr;

    public int f2669vs;

    public String f2670vt;

    public Exception f2671vu;

    private String f2672vv;

    private String f2673vw;

    private Hashtable f2674vx;

    private Vector f2675vy;

    public Hashtable f2676vz;

    public RunnableC0345y() {
        this(true);
    }

    public RunnableC0345y(boolean z) {
        this.f2663vm = z;
        this.f2673vw = "application/x-www-form-urlencoded";
        this.f2672vv = new StringBuffer().append(hashCode()).toString();
    }

    public final void m2152U(String str) {
        if (this.f2675vy == null) {
            this.f2675vy = new Vector();
        }
        if (!this.f2675vy.contains(str)) {
            this.f2675vy.addElement(str);
        }
        if (this.f2676vz == null) {
            this.f2676vz = new Hashtable();
        }
    }

    public final void m2153a(String str, String str2, int i) {
        this.f2666vp = i;
        boolean z = C0338r.f2168lV;
        this.f2662vl = System.currentTimeMillis();
        while (this.f2653dB) {
            try {
                synchronized (this) {
                    wait(50L);
                }
            } catch (Exception e) {
                this.f2671vu = e;
            }
        }
        cleanup();
        this.f2653dB = true;
        this.f2660vh = false;
        if (i == 1) {
            this.f2656dv = str;
            this.f2657vc = str2;
        } else if (str2 == null || "".equals(str2)) {
            this.f2656dv = str;
        } else {
            if (!str2.startsWith("?") && !str.endsWith("?")) {
                str2 = new StringBuffer("?").append(str2).toString();
            }
            this.f2656dv = new StringBuffer().append(str).append(str2).toString();
        }
        this.f2654dC = false;
        this.f2655du = new Thread(this);
        this.f2655du.start();
    }

    public final synchronized void cancel() {
        if (!this.f2660vh) {
            this.f2660vh = true;
            if (this.f2664vn != null) {
                if (this.f2658ve != null) {
                    try {
                        synchronized (this.f2664vn) {
                            this.f2658ve.close();
                        }
                    } catch (Exception e) {
                        this.f2671vu = e;
                    }
                }
                if (this.f2664vn != null) {
                    try {
                        synchronized (this.f2664vn) {
                            this.f2664vn.disconnect();
                        }
                    } catch (Exception e2) {
                        this.f2671vu = e2;
                    }
                }
                if (this.f2659vf != null) {
                    try {
                        synchronized (this.f2659vf) {
                            this.f2659vf.close();
                        }
                    } catch (Exception e3) {
                        this.f2671vu = e3;
                    }
                }
                this.f2659vf = null;
            }
            this.f2658ve = null;
            this.f2664vn = null;
            this.f2653dB = false;
            this.f2655du = null;
        }
    }

    public final void cleanup() {
        cancel();
        this.f2654dC = false;
        this.f2652dA = null;
        this.f2665vo = null;
    }

    public final void m2154f(String str, String str2) {
        GLLib.m455bb();
        m2153a(str, str2, 0);
    }

    public final boolean isInProgress() {
        return this.f2653dB;
    }

    public final void m2155l(boolean z) {
        this.f2668vr = z;
    }

    public final void m2156p(String str, String str2) {
        if (this.f2674vx == null) {
            this.f2674vx = new Hashtable();
        }
        this.f2674vx.put(str, str2);
    }

    @Override
    public final void run() {
        int contentLength;
        if (this.f2656dv == null) {
            cancel();
            this.f2654dC = true;
            this.f2653dB = false;
            return;
        }
        if (this.f2666vp == 1 && this.f2657vc == null) {
            cancel();
            this.f2654dC = true;
            this.f2653dB = false;
            return;
        }
        try {
            try {
                this.f2654dC = false;
                if (this.f2660vh) {
                    this.f2653dB = false;
                    if (!this.f2667vq) {
                        cancel();
                    }
                    this.f2667vq = false;
                    return;
                }
                String m347H = GLLib.m347H(this.f2656dv);
                String m349J = GLLib.m349J(this.f2656dv);
                String m351L = GLLib.m351L(this.f2656dv);
                String m350K = GLLib.m350K(this.f2656dv);
                if (m351L == null) {
                    m351L = "https".equals(m347H) ? "443" : "80";
                }
                this.f2664vn = (HttpURLConnection) new URL(m347H, m349J, Integer.parseInt(m351L), m350K).openConnection();
                if (this.f2666vp == 1) {
                    this.f2664vn.setDoOutput(true);
                } else {
                    this.f2664vn.setDoOutput(false);
                }
                if (this.f2666vp == 2) {
                    this.f2664vn.setRequestMethod("DELETE");
                }
                if (this.f2666vp == 1) {
                    this.f2664vn.setRequestMethod("POST");
                } else if (this.f2666vp == 0) {
                    this.f2664vn.setRequestMethod("GET");
                }
                if (this.f2674vx != null && this.f2674vx.size() > 0) {
                    Enumeration keys = this.f2674vx.keys();
                    while (keys.hasMoreElements()) {
                        String str = (String) keys.nextElement();
                        String str2 = (String) this.f2674vx.get(str);
                        this.f2664vn.setRequestProperty(str, str2);
                        GLLib.m342C(new StringBuffer("HTTP:[").append(this.f2672vv).append("]: Set header field ").append(str).append(":").append(str2).toString());
                    }
                    this.f2674vx.clear();
                }
                if (this.f2666vp == 1) {
                    this.f2664vn.setRequestProperty("Content-Type", this.f2673vw);
                    String stringBuffer = this.f2663vm ? new StringBuffer("b=").append(this.f2657vc).toString() : this.f2657vc;
                    this.f2664vn.setRequestProperty("Content-Length", String.valueOf(stringBuffer.length()));
                    this.f2659vf = this.f2664vn.getOutputStream();
                    this.f2659vf.write(stringBuffer.getBytes(), 0, stringBuffer.length());
                    this.f2659vf.flush();
                }
                this.f2669vs = this.f2664vn.getResponseCode();
                this.f2670vt = this.f2664vn.getResponseMessage();
                this.f2661vi = this.f2664vn.getDate();
                if (this.f2669vs == 302) {
                    this.f2653dB = false;
                    this.f2667vq = true;
                    m2153a(this.f2664vn.getHeaderField("Location"), this.f2657vc, this.f2666vp);
                    if (!this.f2667vq) {
                        cancel();
                    }
                    this.f2667vq = false;
                    return;
                }
                if (this.f2675vy != null && this.f2675vy.size() > 0) {
                    for (int i = 0; i < this.f2675vy.size(); i++) {
                        String str3 = (String) this.f2675vy.elementAt(i);
                        String headerField = this.f2664vn.getHeaderField(str3);
                        if (headerField != null) {
                            this.f2676vz.put(str3, headerField);
                        }
                    }
                    this.f2675vy.removeAllElements();
                }
                if (this.f2669vs != 200 && this.f2669vs != 202) {
                    cancel();
                    this.f2654dC = true;
                    this.f2653dB = false;
                    if (!this.f2667vq) {
                        cancel();
                    }
                    this.f2667vq = false;
                    return;
                }
                if (this.f2660vh) {
                    this.f2653dB = false;
                    if (!this.f2667vq) {
                        cancel();
                    }
                    this.f2667vq = false;
                    return;
                }
                synchronized (this.f2664vn) {
                    this.f2658ve = this.f2664vn.getInputStream();
                }
                Thread thread = this.f2655du;
                Thread.yield();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                if (this.f2668vr && (contentLength = this.f2664vn.getContentLength()) > 0) {
                    this.f2665vo = new byte[contentLength];
                }
                byte[] bArr = new byte[256];
                int i2 = 0;
                int i3 = 0;
                while (i3 != -1) {
                    if (this.f2660vh) {
                        this.f2653dB = false;
                        if (!this.f2667vq) {
                            cancel();
                        }
                        this.f2667vq = false;
                        return;
                    }
                    if (!C0338r.f2424qr) {
                        for (int i4 = 0; i4 < 256; i4++) {
                            bArr[i4] = 0;
                        }
                    }
                    i3 = this.f2658ve.read(bArr, 0, 256);
                    if (i3 == -1) {
                        break;
                    }
                    if (!C0338r.f2424qr && !this.f2668vr) {
                        int i5 = 255;
                        while (i5 >= 0 && bArr[i5] == 0) {
                            i5--;
                        }
                        i3 = i5 + 1;
                    }
                    if (!this.f2668vr) {
                        byteArrayOutputStream.write(bArr, 0, i3);
                    } else if (i3 > 0 && i2 + i3 <= this.f2665vo.length) {
                        System.arraycopy(bArr, 0, this.f2665vo, i2, i3);
                        i2 += i3;
                    }
                }
                if (!this.f2668vr) {
                    this.f2665vo = byteArrayOutputStream.toByteArray();
                    this.f2652dA = new String(this.f2665vo, "UTF-8");
                }
                if (!this.f2667vq) {
                    cancel();
                }
                this.f2667vq = false;
            } catch (Exception e) {
                this.f2654dC = true;
                this.f2653dB = false;
                this.f2671vu = e;
                if (!this.f2667vq) {
                    cancel();
                }
                this.f2667vq = false;
            }
        } catch (Throwable th) {
            if (!this.f2667vq) {
                cancel();
            }
            this.f2667vq = false;
            throw th;
        }
    }

    public final String toString() {
        return new StringBuffer().append(this.f2672vv).append(": ").append(this.f2656dv).toString();
    }
}
