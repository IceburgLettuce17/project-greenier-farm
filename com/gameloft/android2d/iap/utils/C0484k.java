package com.gameloft.android2d.iap.utils;

import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class C0484k {
    private String aem;
    private IvParameterSpec aen;
    private SecretKeySpec aeo;
    private Cipher aep;
    private String aeq;

    public C0484k(String str, String str2) {
        this.aem = "1234567890123456";
        this.aeq = "f4793993b3a438151ce9d18513606421";
        this.aem = str;
        this.aeq = str2;
        this.aen = new IvParameterSpec(this.aem.getBytes());
        this.aeo = new SecretKeySpec(this.aeq.getBytes(), "AES");
        try {
            this.aep = Cipher.getInstance("AES/CBC/NoPadding");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e2) {
            e2.printStackTrace();
        }
    }

    private static String m2627cD(String str) {
        int length = 16 - (str.length() % 16);
        for (int i = 0; i < length; i++) {
            str = str + ' ';
        }
        return str;
    }

    public static String m2628g(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        String str = "";
        for (int i = 0; i < length; i++) {
            str = (bArr[i] & 255) < 16 ? str + "0" + Integer.toHexString(bArr[i] & 255) : str + Integer.toHexString(bArr[i] & 255);
        }
        return str;
    }

    public final byte[] m2629cC(String str) {
        if (str == null || str.length() == 0) {
            throw new Exception("Empty string");
        }
        try {
            this.aep.init(1, this.aeo, this.aen);
            return this.aep.doFinal(m2627cD(str).getBytes());
        } catch (Exception e) {
            throw new Exception("[encrypt] " + e.getMessage());
        }
    }
}
