package com.gameloft.android.wrapper;

import android.webkit.WebView;

final class RunnableC0356j implements Runnable {
    RunnableC0356j() {
    }

    @Override
    public final void run() {
        try {
            String unused = C0355i.userAgent = new WebView(C0355i.getContext()).getSettings().getUserAgentString();
        } catch (Exception e) {
            String unused2 = C0355i.userAgent = "GL_EMU_001";
        }
    }
}
