package com.gameloft.android2d.iap.p042a.p051h;

import org.json.JSONException;
import org.json.JSONObject;
import p001a.p004b.p005a.p006a.C0012k;

class C0410b {
    String aco;
    String acp;
    Double acq;
    String acr;
    String acs;
    String act;

    public C0410b() {
    }

    public C0410b(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.aco = jSONObject.getString("mItemId");
            this.acp = jSONObject.getString("mItemName");
            this.acq = Double.valueOf(Double.parseDouble(jSONObject.getString("mItemPrice")));
            jSONObject.getString("mCurrencyUnit");
            this.acs = jSONObject.getString("mItemDesc");
            jSONObject.getString("mItemImageUrl");
            jSONObject.getString("mItemDownloadUrl");
            jSONObject.getString("mReserved1");
            jSONObject.getString("mReserved2");
            this.acr = jSONObject.getString("mItemPriceString");
            this.act = jSONObject.getString("mType");
        } catch (JSONException e) {
            C0012k.m40b("SamsungIAB ItemVO", "Exception: " + e.getMessage());
        }
    }
}
