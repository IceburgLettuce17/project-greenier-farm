package com.gameloft.android2d.iap.p042a.p051h;

import org.json.JSONException;
import org.json.JSONObject;
import p001a.p004b.p005a.p006a.C0012k;

final class C0431w {
    String acV;
    String acu;

    public C0431w(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.getString("itemId");
            jSONObject.getString("itemName");
            jSONObject.getString("itemDesc");
            jSONObject.getString("purchaseDate");
            this.acu = jSONObject.getString("paymentId");
            jSONObject.getString("paymentAmount");
            this.acV = jSONObject.getString("status");
        } catch (JSONException e) {
            C0012k.m40b("SamsungIAB VerificationVO", "Exception: " + e.getMessage());
        }
    }
}
