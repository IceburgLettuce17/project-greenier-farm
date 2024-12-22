package com.gameloft.android2d.iap.utils;

import android.webkit.WebView;

final class C0478e extends Thread {
    C0478e() {
    }

    @Override
    public final void run() {
        WebView webView;
        WebView webView2;
        webView = C0477d.f2865eo;
        if (webView == null) {
            WebView unused = C0477d.f2865eo = new WebView(C0488o.getContext());
        }
        webView2 = C0477d.f2865eo;
        String unused2 = C0477d.userAgent = webView2.getSettings().getUserAgentString();
    }
}
