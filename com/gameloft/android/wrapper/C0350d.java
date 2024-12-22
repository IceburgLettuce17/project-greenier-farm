package com.gameloft.android.wrapper;

import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public final class C0350d {

    private static C0350d f2698XN = null;

    private static String m2174bg(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.reset();
            messageDigest.update(str.getBytes("UTF-8"));
            byte[] digest = messageDigest.digest();
            for (byte b2 : digest) {
                stringBuffer.append(Integer.toString((b2 & 255) + 256, 16).substring(1));
            }
        } catch (Exception e) {
            String str2 = "hf16 err:" + e.toString();
        }
        return stringBuffer.toString().substring(0, 16);
    }

    public static C0350d m2175pY() {
        if (f2698XN == null) {
            f2698XN = new C0350d();
        }
        return f2698XN;
    }

    public final String m2176z(String str, String str2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(m2174bg(str2).getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(2, secretKeySpec);
            return new String(cipher.doFinal(C0348b.m2172bf(str)));
        } catch (Exception e) {
            String str3 = "getPlainDef err:" + e.toString();
            return null;
        }
    }
}
