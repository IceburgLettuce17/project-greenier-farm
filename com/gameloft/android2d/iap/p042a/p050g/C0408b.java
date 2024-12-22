package com.gameloft.android2d.iap.p042a.p050g;

import com.gameloft.android2d.iap.utils.C0488o;
import com.gameloft.android2d.iap.utils.MyWebView;
import java.util.HashMap;
import p001a.p004b.p005a.p006a.C0012k;

final class C0408b extends Thread {

    private String f2762ZW;

    private String f2763ZX;

    private String f2764ZY;

    private String f2765ZZ;
    private String aaa;
    private HashMap aab;

    C0408b(C0407a c0407a, String str, String str2, String str3, String str4, String str5, HashMap hashMap) {
        this.f2762ZW = str;
        this.f2763ZX = str2;
        this.f2764ZY = str3;
        this.f2765ZZ = str4;
        this.aaa = str5;
        this.aab = hashMap;
    }

    @Override
    public final void run() {
        C0012k.m41c("IAP-PayPalBilling", "Loading webview with headers");
        MyWebView.m2574a(C0407a.acl, this.f2762ZW + "?ggi=0&gliveid=" + this.f2763ZX + "&contentid=" + this.f2764ZY + "&verify=" + this.f2765ZZ + "&game=" + this.aaa + "&d=" + C0488o.m2640ag(), this.aab);
    }
}
