package com.gameloft.android.wrapper;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public final class C0347a {

    private static String f2684uS;

    static {
        byte[] bArr = new byte[25];
        byte[] bArr2 = {-48, -37, 4, 31, -39, -27, 52, -36, 41, 13, -32, 32, -35, 20, 5, 11, -8, -33, -5, -9, 5, -6, -4, 0, 0};
        bArr[0] = 118;
        for (int i = 1; i < 24; i++) {
            bArr[i] = (byte) (bArr[i - 1] + bArr2[i]);
        }
        f2684uS = new String(bArr, 0, 24);
    }

    public static String m2169T(String str) {
        byte[] bArr = null;
        try {
            int length = 16 - (str.length() % 16);
            if (length > 0 && length < 16) {
                StringBuffer stringBuffer = new StringBuffer(str.length() + length);
                stringBuffer.insert(0, str);
                while (length > 0) {
                    stringBuffer.append(" ");
                    length--;
                }
                str = stringBuffer.toString();
            }
            SecretKeySpec secretKeySpec = new SecretKeySpec(C0348b.m2170S(f2684uS), "ECB");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(1, secretKeySpec);
            bArr = cipher.doFinal(str.getBytes());
        } catch (Exception e) {
        }
        return new String(C0348b.m2173c(bArr));
    }
}
