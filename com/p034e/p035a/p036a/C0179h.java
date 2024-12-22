package com.p034e.p035a.p036a;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;

final class C0179h extends WebViewClient {
    private boolean ahN;
    private DialogC0178g ahO;

    private C0179h(DialogC0178g dialogC0178g) {
        this.ahO = dialogC0178g;
        this.ahN = false;
    }

    C0179h(DialogC0178g dialogC0178g, byte b2) {
        this(dialogC0178g);
    }

    @Override
    public final void onPageFinished(WebView webView, String str) {
        ProgressDialog progressDialog;
        WebView webView2;
        ProgressDialog progressDialog2;
        super.onPageFinished(webView, str);
        String str2 = "onPageFinished URL: " + str;
        progressDialog = this.ahO.ahI;
        if (progressDialog.isShowing()) {
            progressDialog2 = this.ahO.ahI;
            progressDialog2.dismiss();
        }
        webView2 = this.ahO.f124za;
        webView2.setVisibility(0);
    }

    @Override
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        ProgressDialog progressDialog;
        String str2 = "onPageStarted URL: " + str;
        if (!str.startsWith(C0162b.m298tK()) || this.ahN) {
            super.onPageStarted(webView, str, bitmap);
            progressDialog = this.ahO.ahI;
            progressDialog.show();
        } else {
            this.ahN = true;
            this.ahO.dismiss();
            DialogC0178g.m329a(this.ahO, webView, str);
            webView.stopLoading();
        }
    }

    @Override
    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        InterfaceC0177f interfaceC0177f;
        super.onReceivedError(webView, i, str, str2);
        this.ahO.dismiss();
        interfaceC0177f = this.ahO.ahH;
        interfaceC0177f.mo318a(new C0180i(str, i, str2));
    }

    @Override
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (!str.startsWith("sms:")) {
            return super.shouldOverrideUrlLoading(webView, str);
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.putExtra("address", str.replace("sms:", ""));
        intent.setType("vnd.android-dir/mms-sms");
        this.ahO.getContext().startActivity(intent);
        return true;
    }
}
