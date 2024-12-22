package com.gameloft.android2d.socialnetwork;

import java.io.UnsupportedEncodingException;

public class C0493a {
    private static boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !C0493a.class.desiredAssertionStatus();
    }

    private C0493a() {
    }

    public static String encodeToString(byte[] bArr, int i) {
        int i2;
        try {
            int length = bArr.length;
            C0519c c0519c = new C0519c(0, null);
            int i3 = (length / 3) << 2;
            if (!c0519c.afo) {
                switch (length % 3) {
                    case 1:
                        i3 += 2;
                        break;
                    case 2:
                        i3 += 3;
                        break;
                }
            } else if (length % 3 > 0) {
                i3 += 4;
            }
            if (!c0519c.afp || length <= 0) {
                i2 = i3;
            } else {
                i2 = ((c0519c.afq ? 2 : 1) * (((length - 1) / 57) + 1)) + i3;
            }
            c0519c.afi = new byte[i2];
            c0519c.m2773a(bArr, 0, length, true);
            if ($assertionsDisabled || c0519c.afj == i2) {
                return new String(c0519c.afi, "US-ASCII");
            }
            throw new AssertionError();
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }
}
