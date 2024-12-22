package com.gameloft.android2d.iap.utils;

import java.util.Enumeration;
import java.util.Hashtable;
import p001a.p004b.p005a.p006a.C0012k;

public final class C0490q {
    private int[] aeN;
    private int[] aeO;
    public Hashtable<String, Hashtable<Integer, C0483j>> aeK = new Hashtable<>();
    public Hashtable<String, C0483j> aeL = new Hashtable<>();
    public Hashtable<String, Integer> aeM = new Hashtable<>();
    public String aeP = "";
    String aeQ = "";
    String aeR = "";
    String aeS = "";
    String abR = "";
    String aeT = "";
    public String aeU = "";
    String aeV = "";
    public String aeW = "";
    String aeX = "";
    String aeY = "";
    public int aeZ = 0;
    public String afa = "";
    public String afb = "";
    public String afc = "";
    public String afd = "";

    public final void m2659I(String str, String str2) {
        int i;
        int i2;
        if (this.aeK.containsKey(str)) {
            int size = this.aeK.get(str).size();
            C0012k.m41c("IAP-ShopProfile", "[sortPricepointIds] number of CASH" + size);
            i = size;
        } else {
            i = -1;
        }
        if (i > 0) {
            this.aeN = new int[i];
            for (int i3 = 0; i3 < i; i3++) {
                this.aeN[i3] = this.aeM.get(str + "_" + i3).intValue();
                this.aeM.remove(str + "_" + i3);
            }
            for (int i4 = 0; i4 < i - 1; i4++) {
                for (int i5 = i4 + 1; i5 < i; i5++) {
                    if (this.aeN[i4] > this.aeN[i5]) {
                        int i6 = this.aeN[i4];
                        this.aeN[i4] = this.aeN[i5];
                        this.aeN[i5] = i6;
                    }
                }
            }
        }
        if (this.aeK.containsKey(str2)) {
            int size2 = this.aeK.get(str2).size();
            C0012k.m41c("IAP-ShopProfile", "[sortPricepointIds] number of COIN" + size2);
            i2 = size2;
        } else {
            i2 = -1;
        }
        if (i2 > 0) {
            this.aeO = new int[i2];
            for (int i7 = 0; i7 < i2; i7++) {
                this.aeO[i7] = this.aeM.get(str2 + "_" + i7).intValue();
                this.aeM.remove(str2 + "_" + i7);
            }
            for (int i8 = 0; i8 < i2 - 1; i8++) {
                for (int i9 = i8 + 1; i9 < i2; i9++) {
                    if (this.aeO[i8] > this.aeO[i9]) {
                        int i10 = this.aeO[i8];
                        this.aeO[i8] = this.aeO[i9];
                        this.aeO[i9] = i10;
                    }
                }
            }
        }
    }

    public final Hashtable<Integer, C0483j> m2660cN(String str) {
        if (this.aeK.containsKey(str)) {
            return this.aeK.get(str);
        }
        return null;
    }

    public final boolean m2661cO(String str) {
        C0012k.m41c("IAP-ShopProfile", "[isValidType] itemType " + str);
        return this.aeK.containsKey(str);
    }

    public final int m2662fd(int i) {
        if (this.aeN != null) {
            return this.aeN[i];
        }
        return -1;
    }

    public final int m2663fe(int i) {
        if (this.aeO != null) {
            return this.aeO[i];
        }
        return -1;
    }

    public final C0483j m2664j(String str, int i) {
        String lowerCase = str.toLowerCase();
        int i2 = -1;
        if (lowerCase.equalsIgnoreCase("Cash")) {
            i2 = m2662fd(i);
        } else if (lowerCase.equalsIgnoreCase("Coin")) {
            i2 = m2663fe(i);
        }
        Hashtable<Integer, C0483j> m2660cN = m2660cN(lowerCase);
        if (m2660cN != null) {
            return m2660cN.get(Integer.valueOf(i2));
        }
        return null;
    }

    public final String toString() {
        String str = (((("****************ShopProfile*****************\nCountry Id: '" + this.aeP + "' [" + this.aeQ + "]") + "Operator Id: '" + this.aeR + "' [" + this.aeS + "]") + "Platform Id: '" + this.aeU + "' [" + this.aeV + "]") + "Product Id: '" + this.abR + "' [" + this.aeT + "]") + "Lan Id: '" + this.aeX + "' [" + this.aeY + "]";
        Enumeration<String> keys = this.aeK.keys();
        while (true) {
            String str2 = str;
            if (!keys.hasMoreElements()) {
                return str2;
            }
            String nextElement = keys.nextElement();
            Enumeration<C0483j> elements = this.aeK.get(nextElement).elements();
            str = str2 + "\n----------------------List Type: '" + nextElement + "'---------------------------";
            while (elements.hasMoreElements()) {
                str = str + "\n" + elements.nextElement().toString();
            }
        }
    }
}
