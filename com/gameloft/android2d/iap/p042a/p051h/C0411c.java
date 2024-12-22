package com.gameloft.android2d.iap.p042a.p051h;

import android.text.format.DateFormat;
import org.json.JSONException;
import org.json.JSONObject;
import p001a.p004b.p005a.p006a.C0012k;

final class C0411c extends C0410b {
    String acu;
    String acv;
    String acw;

    public C0411c(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.acu = jSONObject.getString("mPaymentId");
            this.acv = jSONObject.getString("mPurchaseId");
            this.aco = jSONObject.getString("mItemId");
            this.acp = jSONObject.getString("mItemName");
            this.acq = Double.valueOf(Double.parseDouble(jSONObject.getString("mItemPrice")));
            this.acr = jSONObject.getString("mItemPriceString");
            jSONObject.getString("mCurrencyUnit");
            this.acs = jSONObject.getString("mItemDesc");
            jSONObject.getString("mItemImageUrl");
            jSONObject.getString("mItemDownloadUrl");
            jSONObject.getString("mReserved1");
            jSONObject.getString("mReserved2");
            this.acw = jSONObject.getString("mVerifyUrl");
            DateFormat.format("yyyy.MM.dd hh:mm:ss", Long.parseLong(jSONObject.getString("mPurchaseDate"))).toString();
        } catch (JSONException e) {
            C0012k.m40b("SamsungIAB PurchaseVO", "Exception: " + e.getMessage());
        }
    }
}
