package com.p020a.p021a.p022a;

import android.content.Intent;
import android.os.Bundle;
import org.json.JSONException;
import org.json.JSONObject;
import p001a.p004b.p005a.p006a.C0002a;

final class C0113ad implements InterfaceC0139z {
    C0113ad() {
    }

    @Override
    public final void mo247e(String str) {
        if (C0002a.m12a()) {
            C0002a.m9a("SandboxRequestHandler", "sendGetUserIdRequest");
        }
        try {
            Bundle bundle = new Bundle();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("requestId", str);
            jSONObject.put("packageName", C0133t.m258Q().getPackageName());
            bundle.putString("userInput", jSONObject.toString());
            Intent intent = new Intent("com.amazon.testclient.iap.appUserId");
            intent.addFlags(268435456);
            intent.putExtras(bundle);
            C0133t.m258Q().startService(intent);
        } catch (JSONException e) {
            C0002a.m16b("SandboxRequestHandler", "Error in sendGetUserIdRequest.");
        }
    }

    @Override
    public final void mo248e(String str, String str2) {
        if (C0002a.m12a()) {
            C0002a.m9a("SandboxRequestHandler", "sendPurchaseRequest");
        }
        try {
            Bundle bundle = new Bundle();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sku", str);
            jSONObject.put("requestId", str2);
            jSONObject.put("packageName", C0133t.m258Q().getPackageName());
            bundle.putString("purchaseInput", jSONObject.toString());
            Intent intent = new Intent("com.amazon.testclient.iap.purchase");
            intent.addFlags(268435456);
            intent.putExtras(bundle);
            C0133t.m258Q().startService(intent);
        } catch (JSONException e) {
            C0002a.m16b("SandboxRequestHandler", "Error in sendPurchaseRequest.");
        }
    }
}
