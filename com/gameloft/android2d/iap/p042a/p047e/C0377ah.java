package com.gameloft.android2d.iap.p042a.p047e;

import android.text.TextUtils;
import com.gameloft.android2d.iap.C0463b;
import com.gameloft.android2d.iap.p042a.p047e.p048a.C0368a;
import com.gameloft.android2d.iap.p042a.p047e.p048a.C0369b;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p001a.p004b.p005a.p006a.C0012k;

public final class C0377ah {
    private static final SecureRandom abN = new SecureRandom();
    private static HashSet<Long> abO = new HashSet<>();

    public static ArrayList<C0378ai> m2314C(String str, String str2) {
        boolean z;
        if (str == null) {
            C0012k.m40b("IAP-Security", "data is null");
            return null;
        }
        C0012k.m41c("IAP-Security", "signedData: " + str);
        if (TextUtils.isEmpty(str2)) {
            z = false;
        } else {
            String m2540qM = C0463b.m2540qM();
            C0012k.m41c("IAP-Security", "base64EncodedPublicKey : " + m2540qM);
            if (m2540qM == null || m2540qM == "") {
                return null;
            }
            boolean m2315a = m2315a(m2316ch(m2540qM), str, str2);
            if (!m2315a) {
                C0012k.m42d("IAP-Security", "signature does not match data.");
                return null;
            }
            z = m2315a;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            long optLong = jSONObject.optLong("nonce");
            JSONArray optJSONArray = jSONObject.optJSONArray("orders");
            int length = optJSONArray != null ? optJSONArray.length() : 0;
            if (!abO.contains(Long.valueOf(optLong))) {
                C0012k.m42d("IAP-Security", "Nonce not found: " + optLong);
                return null;
            }
            ArrayList<C0378ai> arrayList = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                try {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    EnumC0386h m2328eW = EnumC0386h.m2328eW(jSONObject2.getInt("purchaseState"));
                    String string = jSONObject2.getString("productId");
                    jSONObject2.getString("packageName");
                    long j = jSONObject2.getLong("purchaseTime");
                    String optString = jSONObject2.optString("orderId", "");
                    String string2 = jSONObject2.has("notificationId") ? jSONObject2.getString("notificationId") : null;
                    String optString2 = jSONObject2.optString("developerPayload", null);
                    if (m2328eW != EnumC0386h.PURCHASED || z) {
                        arrayList.add(new C0378ai(m2328eW, string2, string, optString, j, optString2));
                    }
                } catch (JSONException e) {
                    C0012k.m40b("IAP-Security", "JSON exception: " + e);
                    return null;
                }
            }
            m2318i(optLong);
            return arrayList;
        } catch (JSONException e2) {
            return null;
        }
    }

    private static boolean m2315a(PublicKey publicKey, String str, String str2) {
        C0012k.m41c("IAP-Security", "signature: " + str2);
        try {
            Signature signature = Signature.getInstance("SHA1withRSA");
            signature.initVerify(publicKey);
            signature.update(str.getBytes());
            if (signature.verify(C0368a.m2302bf(str2))) {
                return true;
            }
            C0012k.m40b("IAP-Security", "Signature verification failed.");
            return false;
        } catch (C0369b e) {
            C0012k.m40b("IAP-Security", "Base64 decoding failed.");
            return false;
        } catch (InvalidKeyException e2) {
            C0012k.m40b("IAP-Security", "Invalid key specification.");
            return false;
        } catch (NoSuchAlgorithmException e3) {
            C0012k.m40b("IAP-Security", "NoSuchAlgorithmException.");
            return false;
        } catch (SignatureException e4) {
            C0012k.m40b("IAP-Security", "Signature exception.");
            return false;
        }
    }

    private static PublicKey m2316ch(String str) {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(C0368a.m2302bf(str)));
        } catch (C0369b e) {
            C0012k.m40b("IAP-Security", "Base64 decoding failed.");
            throw new IllegalArgumentException(e);
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        } catch (InvalidKeySpecException e3) {
            C0012k.m40b("IAP-Security", "Invalid key specification.");
            throw new IllegalArgumentException(e3);
        }
    }

    public static boolean m2317g(String str, String str2, String str3) {
        if (str2 == null) {
            C0012k.m40b("IAP-Security", "data is null");
            return false;
        }
        if (TextUtils.isEmpty(str3) || m2315a(m2316ch(str), str2, str3)) {
            return true;
        }
        C0012k.m42d("IAP-Security", "signature does not match data.");
        return false;
    }

    public static void m2318i(long j) {
        abO.remove(Long.valueOf(j));
    }

    public static long m2319rZ() {
        long nextLong = abN.nextLong();
        abO.add(Long.valueOf(nextLong));
        return nextLong;
    }
}
