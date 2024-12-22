package com.gameloft.android.LATAM.GloftGF2H;

import android.graphics.Bitmap;
import android.opengl.GLES10;
import java.nio.IntBuffer;
import p009b.p010a.p012b.C0048ac;
import p009b.p010a.p012b.C0051af;

public final class C0277ad {

    private C0048ac f493iC;

    public int f494vK;

    public int f495vL;

    public final int f496vM;

    public final int f497vN;

    private int[] f498vO;

    public C0277ad(C0051af c0051af) {
        C0277ad m678a = m678a(c0051af.getBitmap());
        this.f498vO = m678a.f498vO;
        this.f494vK = m678a.f494vK;
        this.f495vL = m678a.f495vL;
        this.f496vM = m678a.f496vM;
        this.f497vN = m678a.f497vN;
    }

    public C0277ad(int[] iArr, int i, int i2) {
        int[] iArr2;
        this.f498vO = new int[1];
        this.f494vK = i;
        this.f495vL = i2;
        GLLib.m463bj();
        GLES10.glGenTextures(1, this.f498vO, 0);
        GLES10.glBindTexture(3553, this.f498vO[0]);
        GLES10.glTexParameterf(3553, 10242, 33071.0f);
        GLES10.glTexParameterf(3553, 10243, 33071.0f);
        GLES10.glTexParameterf(3553, 10241, GLLib.m467bn() ? 9729.0f : 9728.0f);
        GLES10.glTexParameterf(3553, 10240, GLLib.m467bn() ? 9729.0f : 9728.0f);
        if (!C0338r.f2175mC || (i == GLLib.m361Y(i) && i2 == GLLib.m361Y(i2))) {
            this.f496vM = i;
            this.f497vN = i2;
            iArr2 = iArr;
        } else {
            iArr2 = C0271a.m614a(iArr);
            int m361Y = GLLib.m361Y(i);
            int m361Y2 = GLLib.m361Y(i2);
            GLLib.m397a(iArr, iArr2, i, i2, m361Y, m361Y2);
            this.f496vM = m361Y;
            this.f497vN = m361Y2;
        }
        int i3 = this.f497vN * this.f496vM;
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = iArr2[i4];
            iArr2[i4] = ((i5 >> 16) & 255) | ((-16711936) & i5) | ((i5 & 255) << 16);
        }
        GLES10.glTexImage2D(3553, 0, 6408, this.f496vM, this.f497vN, 0, 6408, 5121, IntBuffer.wrap(iArr2));
        GLLib.m464bk();
    }

    public static C0277ad m677F(int i, int i2) {
        return m678a(Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888));
    }

    private static C0277ad m678a(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] m614a = C0271a.m614a(null);
        bitmap.getPixels(m614a, 0, width, 0, 0, width, height);
        return new C0277ad(m614a, width, height);
    }

    public static C0277ad m679b(int[] iArr, int i, int i2) {
        return new C0277ad(iArr, i, i2);
    }

    public final C0048ac m680cb() {
        if (this.f493iC == null) {
            this.f493iC = new C0048ac();
        }
        return this.f493iC;
    }

    public final void m681cc() {
        m683m(false);
    }

    public final int m682cd() {
        return this.f498vO[0];
    }

    public final void m683m(boolean z) {
        if (z) {
            return;
        }
        GLES10.glDeleteTextures(1, this.f498vO, 0);
    }
}
