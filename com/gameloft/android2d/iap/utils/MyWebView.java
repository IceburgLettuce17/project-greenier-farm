package com.gameloft.android2d.iap.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import com.facebook.android.C0217R;
import com.gameloft.android2d.iap.C0463b;
import com.gameloft.android2d.iap.p042a.AbstractC0358a;
import java.util.HashMap;
import p001a.p004b.p005a.p006a.C0012k;

public class MyWebView extends Activity {
    private static String aet;
    private WebView aes = null;
    private boolean aev = false;
    private boolean aew = false;
    private static AbstractC0358a aer = null;
    private static HashMap<String, String> aeu = new HashMap<>();

    public static void m2574a(AbstractC0358a abstractC0358a, String str, HashMap<String, String> hashMap) {
        C0012k.m41c("IAP-WebView", "startWebView: " + str);
        aer = abstractC0358a;
        aet = str;
        aeu = hashMap;
        C0488o.getContext().startActivity(new Intent(C0488o.getContext(), (Class<?>) MyWebView.class));
    }

    static boolean m2575a(MyWebView myWebView, boolean z) {
        myWebView.aev = true;
        return true;
    }

    static String m2578c(MyWebView myWebView) {
        C0012k.m41c("IAP-WebView", "GetWAPPurchaseID");
        C0012k.m41c("IAP-WebView", "URL: " + myWebView.aes.getUrl());
        C0012k.m41c("IAP-WebView", "ID: " + myWebView.aes.getUrl().substring(myWebView.aes.getUrl().indexOf("id=") + 3, myWebView.aes.getUrl().length()));
        return myWebView.aes.getUrl().substring(myWebView.aes.getUrl().indexOf("id=") + 3, myWebView.aes.getUrl().length());
    }

    public void m2580sY() {
        C0012k.m41c("IAP-WebView", "destroyWebview");
        try {
            if (this.aes != null) {
                this.aes.clearHistory();
                this.aes.destroy();
            }
        } catch (Exception e) {
            C0012k.m41c("IAP-WebView", "There is a error in destroy webview process.");
        }
        finish();
    }

    @Override
    public void onCreate(Bundle bundle) {
        C0012k.m41c("IAP-WebView", "onCreate: " + aet);
        super.onCreate(bundle);
        this.aev = false;
        setContentView(C0217R.layout.webview);
        this.aes = (WebView) findViewById(C0217R.id.webview);
        this.aes.getSettings().setJavaScriptEnabled(true);
        this.aes.loadUrl(aet, aeu);
        this.aes.setWebViewClient(new C0486m(this, this));
    }

    @Override
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        C0012k.m41c("IAP-WebView", "onKeyUp: " + i);
        if (i != 4 || this.aes == null || this.aes.canGoBack() || this.aew) {
            return true;
        }
        C0463b.setResult(10);
        C0463b.m2521eV(0);
        m2580sY();
        return true;
    }

    public final void m2583sX() {
        runOnUiThread(new RunnableC0485l(this));
    }
}
