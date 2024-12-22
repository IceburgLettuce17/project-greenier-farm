package com.gameloft.android2d.iap.p042a.p055l;

import com.gameloft.android2d.iap.utils.C0488o;
import com.gameloft.android2d.iap.utils.MyWebView;
import java.util.HashMap;
import p001a.p004b.p005a.p006a.C0012k;

final class C0462b extends Thread {

    private String f2785ZW;

    private String f2786ZX;

    private String f2787ZY;

    private String f2788ZZ;
    private String aaa;
    private HashMap aab;

    C0462b(C0461a c0461a, String str, String str2, String str3, String str4, String str5, HashMap hashMap) {
        this.f2785ZW = str;
        this.f2786ZX = str2;
        this.f2787ZY = str3;
        this.f2788ZZ = str4;
        this.aaa = str5;
        this.aab = hashMap;
    }

    @Override
    public final void run() {
        C0012k.m41c("IAP-WorldPayBilling", "Loading webview with headers");
        MyWebView.m2574a(C0461a.adK, this.f2785ZW + "?ggi=0&gliveid=" + this.f2786ZX + "&contentid=" + this.f2787ZY + "&verify=" + this.f2788ZZ + "&game=" + this.aaa + "&d=" + C0488o.m2640ag(), this.aab);
    }
}
