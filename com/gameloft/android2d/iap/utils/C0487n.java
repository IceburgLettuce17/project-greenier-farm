package com.gameloft.android2d.iap.utils;

import p001a.p004b.p005a.p006a.C0012k;

public final class C0487n {
    private static int aeA = 0;
    private static int aeB = 0;

    public static String m2630F(String str, String str2) {
        int i = 6;
        StringBuilder sb = new StringBuilder();
        String str3 = "";
        try {
            if (str == "000000") {
                sb.append(Long.toBinaryString(Long.parseLong(str2, 36)));
                i = 21;
                str3 = "IGP_CODE";
            } else if (str == "000001") {
                String binaryString = Integer.toBinaryString(Integer.parseInt(str2));
                C0012k.m39a("IAP-SMSUtils", "tmp=" + binaryString);
                sb.append(binaryString);
                i = 14;
                str3 = "GENERATED_CODE";
            } else if (str == "000010") {
                sb.append(Integer.toBinaryString(Integer.parseInt(str2)));
                i = 15;
                str3 = "PLATFORM_ID";
            } else if (str == "000011") {
                sb.append(Integer.toBinaryString(Integer.parseInt(str2)));
                i = 14;
                str3 = "PROFILE_ID";
            } else if (str == "000100") {
                sb.append(Long.toBinaryString(Long.parseLong(str2, 36)));
                i = 11;
                str3 = "LANGUAGE_ID";
            } else if (str == "000101") {
                sb.append(Integer.toBinaryString(Integer.parseInt(str2)));
                str3 = "TYPE";
            } else if (str == "000110") {
                sb.append(Long.toBinaryString(Long.parseLong(str2)));
                i = 50;
                str3 = "IMEI";
            } else if (str == "010001") {
                sb.append(Long.toBinaryString(Long.parseLong(str2, 16)));
                i = 56;
                str3 = "MEID";
            } else if (str == "010010") {
                String binaryString2 = Long.toBinaryString(Long.parseLong(str2));
                String m2633i = m2633i(Integer.toBinaryString(str2.length()), 6);
                int length = binaryString2.length();
                String m2633i2 = m2633i(Integer.toBinaryString(length), 7);
                sb.append(m2633i2 + m2633i + binaryString2);
                aeA = m2633i2.length() + m2633i.length() + length;
                str3 = "IMEI_VR";
                i = aeA;
            } else if (str == "010011") {
                String binaryString3 = Long.toBinaryString(Long.parseLong(str2, 16));
                String m2633i3 = m2633i(Integer.toBinaryString(str2.length()), 6);
                int length2 = binaryString3.length();
                String m2633i4 = m2633i(Integer.toBinaryString(length2), 7);
                sb.append(m2633i4 + m2633i3 + binaryString3);
                aeB = m2633i4.length() + m2633i3.length() + length2;
                str3 = "MEID_VR";
                i = aeB;
            } else if (str == "010100") {
                String binaryString4 = Long.toBinaryString(Long.parseLong(str2, 32));
                String m2633i5 = m2633i(Integer.toBinaryString(str2.length()), 6);
                int length3 = binaryString4.length();
                String m2633i6 = m2633i(Integer.toBinaryString(length3), 7);
                sb.append(m2633i6 + m2633i5 + binaryString4);
                aeB = m2633i6.length() + m2633i5.length() + length3;
                str3 = "MEID_36_VR";
                i = aeB;
            } else if (str == "000111") {
                sb.append(Long.toBinaryString(Long.parseLong(str2, 36)));
                i = 57;
                str3 = "DOWNLOAD_CODE";
            } else if (str == "001000") {
                sb.append(Integer.toBinaryString(Integer.parseInt(str2)));
                i = 32;
                str3 = "FM_SMS_ID";
            } else if (str == "001001") {
                sb.append(Long.toBinaryString(Long.parseLong(str2, 36)));
                i = 21;
            } else if (str == "001010") {
                sb.append(Integer.toBinaryString(Integer.parseInt(str2)));
                i = 3;
            } else if (str == "001011") {
                sb.append(Long.toBinaryString(Long.parseLong(str2)));
                i = 32;
            } else if (str == "001100") {
                sb.append(Long.toBinaryString(Long.parseLong(str2)));
                i = 15;
            } else if (str == "010000") {
                sb.append(Long.toBinaryString(Long.parseLong(str2)));
                str3 = "CONTENT_ID";
                i = 16;
            } else if (str == "001110") {
                sb.append(Long.toBinaryString(Long.parseLong(str2)));
                i = 20;
                str3 = "CONTENT_AMOUNT";
            } else if (str == "001111") {
                sb.append(Long.toBinaryString(Long.parseLong(str2)));
                i = 12;
                str3 = "SMSMO_COUNTER";
            } else {
                C0012k.m42d("IAP-SMSUtils", "Operation not found " + str);
                i = 0;
            }
        } catch (Exception e) {
            i = 0;
            C0012k.m40b("IAP-SMSUtils", "Error with operation " + str3 + " data=" + str2 + "binary ");
        }
        int length4 = i - sb.length();
        if (sb.length() < i) {
            C0012k.m39a("IAP-SMSUtils", "binaryData " + sb.length() + " - " + i);
            for (int i2 = 0; i2 < length4; i2++) {
                sb.insert(0, "0");
            }
        }
        if (sb.length() != i) {
            C0012k.m42d("IAP-SMSUtils", str3 + "length are not equal");
        }
        sb.insert(0, str);
        C0012k.m41c("IAP-SMSUtils", "[" + str3 + "|" + i + "|" + length4 + "] : " + str2);
        C0012k.m41c("IAP-SMSUtils", sb.toString());
        return sb.toString();
    }

    public static byte[] m2631cE(String str) {
        int length = str.length() / 8;
        byte[] bArr = new byte[length];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            C0012k.m39a("Billing", "Input byte:        " + str.substring(i << 3, (i << 3) + 8));
            bArr[i] = (byte) Integer.parseInt(str.substring(i << 3, (i << 3) + 8), 2);
            i++;
        }
        return bArr;
    }

    public static String m2632cF(String str) {
        boolean z;
        if (str == null || str.length() <= 0) {
            return null;
        }
        int length = str.length();
        int i = 0;
        while (true) {
            if (i < length) {
                if (!Character.isDigit(str.charAt(i))) {
                    break;
                }
                i++;
            } else if (length > 0) {
                z = true;
            }
        }
        z = false;
        if (z) {
            if (str.length() == 15) {
                C0012k.m39a("MyApp", "IMEI_15");
                return "000110";
            }
            C0012k.m39a("MyApp", "IMEI_VR");
            return "010010";
        }
        if (!(str.matches("^[\\da-fA-F]+$"))) {
            C0012k.m39a("MyApp", "MEID_36_VR");
            return "010100";
        }
        if (str.length() == 14) {
            C0012k.m39a("MyApp", "MEID_14");
            return "010001";
        }
        C0012k.m39a("MyApp", "MEID_VR");
        return "010011";
    }

    private static String m2633i(String str, int i) {
        StringBuilder sb = new StringBuilder(str);
        for (int i2 = 0; str.length() + i2 < i; i2++) {
            sb.insert(0, "0");
        }
        return sb.toString();
    }
}
