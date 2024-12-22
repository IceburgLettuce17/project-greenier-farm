package com.gameloft.android.LATAM.GloftGF2H;

import com.facebook.android.C0217R;
import java.lang.reflect.Array;

public final class C0331k {

    static C0331k[] f1930ea;

    private int f1931eb;

    public int f1932ec;

    public int[][] f1933ed;

    public static void m1982as() {
        GLLib.m342C("START LOADING CLASSES");
        f1930ea = new C0331k[34];
        GLLib.m342C("START Opening file");
        C0320bt.m344E("/13");
        GLLib.m342C("START loop");
        for (int i = 0; i < 34; i++) {
            f1930ea[i] = new C0331k();
            byte[] m408aa = GLLib.m408aa(i);
            GLLib.m342C(new StringBuffer("Open File ").append(i).toString());
            f1930ea[i].f1932ec = GLLib.m481c(m408aa, 0);
            f1930ea[i].f1931eb = GLLib.m481c(m408aa, 4);
            if (f1930ea[i].f1932ec > 0 && f1930ea[i].f1931eb > 0) {
                byte[] bArr = new byte[f1930ea[i].f1931eb];
                int i2 = 8;
                for (int i3 = 0; i3 < f1930ea[i].f1931eb; i3++) {
                    bArr[i3] = m408aa[i2];
                    i2++;
                }
                f1930ea[i].f1933ed = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, f1930ea[i].f1932ec, f1930ea[i].f1931eb);
                for (int i4 = 0; i4 < f1930ea[i].f1932ec; i4++) {
                    int i5 = 0;
                    while (i5 < f1930ea[i].f1931eb) {
                        switch (bArr[i5]) {
                            case 1:
                                f1930ea[i].f1933ed[i4][i5] = m408aa[i2];
                                break;
                            case 2:
                                f1930ea[i].f1933ed[i4][i5] = GLLib.m435b(m408aa, i2);
                                break;
                            case C0217R.styleable.com_facebook_picker_fragment_done_button_text:
                                f1930ea[i].f1933ed[i4][i5] = GLLib.m481c(m408aa, i2);
                                break;
                        }
                        int i6 = bArr[i5] + i2;
                        i5++;
                        i2 = i6;
                    }
                }
            }
        }
        C0320bt.m460bg();
    }
}
