package com.gameloft.android.LATAM.GloftGF2H;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.gameloft.android.wrapper.C0355i;
import p001a.p002a.p003a.C0001a;

final class C0298ay extends WebViewClient {

    private boolean f629zj;

    final SplashScreenActivity f630zk;

    private C0298ay(SplashScreenActivity splashScreenActivity) {
        this.f630zk = splashScreenActivity;
        this.f629zj = false;
    }

    C0298ay(SplashScreenActivity splashScreenActivity, byte b2) {
        this(splashScreenActivity);
    }

    public static void m831B(String str) {
        if (str == null || str.length() <= 0) {
            return;
        }
        try {
            C0355i.getActivity().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        } catch (Exception e) {
        }
    }

    @Override
    public final void onPageFinished(WebView webView, String str) {
        if (this.f629zj) {
            this.f630zk.m585du();
        }
        this.f629zj = false;
    }

    @Override
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
    }

    @Override
    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        this.f629zj = true;
    }

    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, C0001a c0001a) {
        sslErrorHandler.proceed();
    }

    @Override
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str.startsWith("play:")) {
            SplashScreenActivity splashScreenActivity = this.f630zk;
            SplashScreenActivity.m580aM(str.replace("play:", "").split("[?]")[0]);
            this.f630zk.m585du();
            return true;
        }
        if (str.startsWith("link:")) {
            m831B(str.replace("link:", ""));
            this.f630zk.m585du();
            return true;
        }
        if (str.startsWith("exit:")) {
            this.f630zk.m585du();
            return true;
        }
        if (str.startsWith("goto:")) {
            try {
                C0320bt.m1108aZ(str.replace("goto:", ""));
            } catch (Exception e) {
            }
            this.f630zk.m585du();
            return true;
        }
        if (!str.contains("ingameads.gameloft.com/redir/ads/splashscreen_click")) {
            if (str.startsWith("market://")) {
                SplashScreenActivity.m579a(this.f630zk, str);
                this.f630zk.m585du();
                return true;
            }
            if (str.startsWith("amzn://")) {
                SplashScreenActivity.m582b(this.f630zk, str);
                this.f630zk.m585du();
                return true;
            }
            if (str.contains("ingameads.gameloft.com/redir/?from") && !str.contains("ctg=PLAY")) {
                new Thread(new RunnableC0299az(this, str)).start();
                this.f630zk.m585du();
                return true;
            }
            if (str.startsWith("vnd.youtube:")) {
                SplashScreenActivity.m584d(this.f630zk, str);
                this.f630zk.m585du();
                return true;
            }
        }
        webView.loadUrl(str);
        return true;
    }
}
