package com.gameloft.android2d.iap.p042a.p047e;

import com.facebook.internal.ServerProtocol;
import org.json.JSONObject;

public final class C0379aj {
    private String abV;
    String abt;

    public C0379aj(String str, String str2) {
        this.abV = str2;
        JSONObject jSONObject = new JSONObject(this.abV);
        this.abt = jSONObject.optString("productId");
        jSONObject.optString(ServerProtocol.DIALOG_PARAM_TYPE);
        jSONObject.optString("price");
        jSONObject.optString("title");
        jSONObject.optString("description");
    }

    public final String toString() {
        return "SkuDetails:" + this.abV;
    }
}
