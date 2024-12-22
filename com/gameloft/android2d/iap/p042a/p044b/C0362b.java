package com.gameloft.android2d.iap.p042a.p044b;

import com.gameloft.android2d.iap.utils.C0488o;
import com.gameloft.android2d.iap.utils.MyWebView;
import java.util.HashMap;
import p001a.p004b.p005a.p006a.C0012k;

final class C0362b extends Thread {

    private String f2758ZW;

    private String f2759ZX;

    private String f2760ZY;

    private String f2761ZZ;
    private String aaa;
    private HashMap aab;

    C0362b(C0361a c0361a, String str, String str2, String str3, String str4, String str5, HashMap hashMap) {
        this.f2758ZW = str;
        this.f2759ZX = str2;
        this.f2760ZY = str3;
        this.f2761ZZ = str4;
        this.aaa = str5;
        this.aab = hashMap;
    }

    @Override
    public final void run() {
        C0012k.m41c("IAP-AmazonPayBilling", "Loading webview with headers");
        MyWebView.m2574a(C0361a.f2757ZV, this.f2758ZW + "?ggi=0&gliveid=" + this.f2759ZX + "&contentid=" + this.f2760ZY + "&verify=" + this.f2761ZZ + "&game=" + this.aaa + "&d=" + C0488o.m2640ag(), this.aab);
    }
}
