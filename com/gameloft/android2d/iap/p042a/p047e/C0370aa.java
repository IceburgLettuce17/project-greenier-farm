package com.gameloft.android2d.iap.p042a.p047e;

import org.json.JSONObject;

public final class C0370aa {
    String abr;
    String abs;
    String abt;
    long abu;
    String abv;
    private String abw;

    public C0370aa(String str, String str2, String str3) {
        this.abr = str;
        this.abw = str2;
        JSONObject jSONObject = new JSONObject(this.abw);
        this.abs = jSONObject.optString("orderId");
        jSONObject.optString("packageName");
        this.abt = jSONObject.optString("productId");
        this.abu = jSONObject.optLong("purchaseTime");
        jSONObject.optInt("purchaseState");
        jSONObject.optString("developerPayload");
        this.abv = jSONObject.optString("token", jSONObject.optString("purchaseToken"));
    }

    public final String toString() {
        return "PurchaseInfo(type:" + this.abr + "):" + this.abw;
    }
}
