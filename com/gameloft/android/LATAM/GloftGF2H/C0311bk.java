package com.gameloft.android.LATAM.GloftGF2H;

import java.io.InputStream;
import java.util.Vector;

final class C0311bk extends Thread {
    private int len;

    private C0310bj f664zM;

    private InputStream f665zN;

    private Vector f666zO;

    boolean f667zP;

    private byte[] f668zQ = new byte[2048];

    private int f669zR;

    private byte[] f670zS;

    private boolean f671zT;

    private final C0310bj f672zU;

    public C0311bk(C0310bj c0310bj, InputStream inputStream, Vector vector, boolean z, C0310bj c0310bj2) {
        this.f672zU = c0310bj;
        this.f665zN = inputStream;
        this.f666zO = vector;
        this.f671zT = z;
        this.f664zM = c0310bj2;
    }

    private void m835dB() {
        this.len = -2;
        try {
            if (this.f671zT) {
                this.len = this.f665zN.read(this.f668zQ, 0, this.f668zQ.length);
            } else {
                this.len = this.f665zN.read(this.f668zQ, 0, this.f668zQ.length);
            }
        } catch (Exception e) {
            if (!this.f672zU.f655zD) {
                this.f672zU.f652dC = true;
                this.f664zM.f653vu = e;
                this.f667zP = false;
            }
        }
        if (this.len < 0) {
            this.f667zP = false;
            return;
        }
        if (this.len != 0) {
            if (this.f671zT) {
                byte[] bArr = new byte[(this.len + this.f670zS.length) - this.f669zR];
                System.arraycopy(this.f670zS, this.f669zR, bArr, 0, this.f670zS.length - this.f669zR);
                System.arraycopy(this.f668zQ, 0, bArr, this.f670zS.length - this.f669zR, this.len);
                this.f669zR = 0;
                this.f670zS = bArr;
            }
            Thread.yield();
        }
    }

    private int m836dC() {
        while (this.f667zP && this.f670zS.length - this.f669zR <= 0) {
            m835dB();
        }
        if (!this.f667zP) {
            return -1;
        }
        byte[] bArr = this.f670zS;
        int i = this.f669zR;
        this.f669zR = i + 1;
        short s = (short) (((bArr[i] & 255) << 8) | 0);
        byte[] bArr2 = this.f670zS;
        int i2 = this.f669zR;
        this.f669zR = i2 + 1;
        return (short) (s | (bArr2[i2] & 255));
    }

    private byte[] getBytes(int i) {
        while (this.f667zP && this.f670zS.length - this.f669zR < i) {
            m835dB();
        }
        byte[] bArr = new byte[i];
        System.arraycopy(this.f670zS, this.f669zR, bArr, 0, i);
        this.f669zR += i;
        return bArr;
    }

    @Override
    public final void run() {
        byte[] bytes;
        this.f670zS = new byte[0];
        this.f669zR = 0;
        while (this.f667zP) {
            if (this.f671zT) {
                int m836dC = m836dC();
                if (m836dC == -1) {
                    this.f667zP = false;
                } else if (m836dC > 0) {
                    bytes = getBytes(m836dC);
                } else {
                    continue;
                }
            } else {
                m835dB();
                if (this.len > 0) {
                    bytes = new byte[this.len];
                    System.arraycopy(this.f668zQ, 0, bytes, 0, this.len);
                    int i = this.len;
                } else {
                    continue;
                }
            }
            synchronized (this.f666zO) {
                this.f666zO.addElement(bytes);
            }
            Thread.sleep(300L);
        }
    }

    @Override
    public final void start() {
        this.f667zP = true;
        super.start();
    }
}
