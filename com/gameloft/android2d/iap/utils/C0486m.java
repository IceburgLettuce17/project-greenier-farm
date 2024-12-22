package com.gameloft.android2d.iap.utils;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.android.C0217R;
import com.gameloft.android2d.iap.C0463b;
import java.util.HashMap;
import p001a.p002a.p003a.C0001a;
import p001a.p004b.p005a.p006a.C0012k;

final class C0486m extends WebViewClient {
    private MyWebView aex;
    private ProgressDialog aey = null;
    private MyWebView aez;

    public C0486m(MyWebView myWebView, MyWebView myWebView2) {
        this.aex = myWebView;
        this.aez = null;
        this.aez = myWebView2;
        C0012k.m41c("IAP-WebView", "MyWebViewClient");
    }

    @Override
    public final void onLoadResource(WebView webView, String str) {
        C0012k.m41c("IAP-WebView", "onLoadResource: " + str);
    }

    @Override
    public final void onPageFinished(WebView webView, String str) {
        C0012k.m41c("IAP-WebView", "onPageFinished: " + str);
        this.aex.aew = false;
        try {
            if (this.aey == null) {
                this.aey = new ProgressDialog(this.aex);
            } else {
                this.aey.dismiss();
                this.aey = null;
            }
            this.aez.m2583sX();
        } catch (Exception e) {
        }
    }

    @Override
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        C0012k.m41c("IAP-WebView", "onPageStarted: " + str);
        this.aex.aew = true;
        if (this.aey == null) {
            this.aey = new ProgressDialog(this.aex);
        }
        this.aey.setProgressStyle(0);
        this.aey.setMessage(((Activity) C0488o.getContext()).getString(C0217R.string.IAP_SAMSUNG_WAITING));
        try {
            this.aey.show();
        } catch (Exception e) {
        }
    }

    @Override
    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        C0012k.m41c("IAP-WebView", "onReceivedError: " + str2);
        C0012k.m41c("IAP-WebView", "errorCode: " + i);
        C0012k.m41c("IAP-WebView", "description: " + str);
        super.onReceivedError(webView, i, str, str2);
        if (this.aey != null) {
            this.aey.dismiss();
            this.aey = null;
        }
        C0463b.setResult(3);
        C0463b.m2521eV(-1);
        this.aex.m2580sY();
    }

    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, C0001a c0001a) {
        C0012k.m41c("IAP-WebView", "onReceivedSslError");
        sslErrorHandler.proceed();
    }

    @Override
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        HashMap hashMap;
        C0012k.m41c("IAP-WebView", "shouldOverrideUrlLoading: " + str);
        hashMap = MyWebView.aeu;
        webView.loadUrl(str, hashMap);
        return true;
    }
}
