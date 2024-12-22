package com.gameloft.android2d.iap.utils;

import android.webkit.WebView;
import com.facebook.android.C0217R;
import com.gameloft.android2d.iap.C0463b;
import com.gameloft.android2d.iap.p042a.AbstractC0358a;
import com.gameloft.android2d.iap.p042a.p051h.C0414f;
import p001a.p004b.p005a.p006a.C0012k;

final class RunnableC0485l implements Runnable {
    private MyWebView aex;

    RunnableC0485l(MyWebView myWebView) {
        this.aex = myWebView;
    }

    @Override
    public final void run() {
        WebView webView;
        WebView webView2;
        boolean z;
        AbstractC0358a abstractC0358a;
        this.aex.aes = (WebView) this.aex.findViewById(C0217R.id.webview);
        webView = this.aex.aes;
        String url = webView.getUrl();
        webView2 = this.aex.aes;
        if (webView2.findAll("PURCHASE_ID_") != 0 || (url != null && (url.indexOf("result=successful&id=") > 0 || url.indexOf("&error=") > 0 || url.indexOf("?error=") > 0))) {
            z = this.aex.aev;
            if (!z) {
                C0012k.m41c("IAP-WebView", "The MAGIC_WORD is found. So the webview should finish");
                MyWebView.m2575a(this.aex, true);
                if (url.indexOf("result=successful&id=") > 0) {
                    C0414f.m2382cq(MyWebView.m2578c(this.aex));
                    abstractC0358a = MyWebView.aer;
                    abstractC0358a.mo2267rE();
                } else {
                    C0463b.setResult(3);
                    C0463b.m2521eV(-5);
                }
                this.aex.m2580sY();
            }
        }
        C0012k.m41c("IAP-WebView", "handleWebView: " + url);
    }
}
