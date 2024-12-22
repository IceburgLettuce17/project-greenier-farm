package com.p034e.p035a.p036a.p040d;

import java.security.MessageDigest;

public final class C0174a {
    private static final char[] aii = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String m320h(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            char[] cArr = new char[32];
            int i = 0;
            for (int i2 = 0; i2 < 16; i2++) {
                byte b2 = digest[i2];
                int i3 = i + 1;
                cArr[i] = aii[(b2 >>> 4) & 15];
                i = i3 + 1;
                cArr[i3] = aii[b2 & 15];
            }
            return new String(cArr);
        } catch (Exception e) {
            return null;
        }
    }
}
