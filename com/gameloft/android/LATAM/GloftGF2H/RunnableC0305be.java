package com.gameloft.android.LATAM.GloftGF2H;

import android.widget.ProgressBar;
import android.widget.TextView;

final class RunnableC0305be implements Runnable {

    private String f645zA;

    private int f646zz;

    RunnableC0305be(int i, String str) {
        this.f646zz = i;
        this.f645zA = str;
    }

    @Override
    public final void run() {
        ProgressBar progressBar;
        TextView textView;
        TextView textView2;
        ProgressBar progressBar2;
        progressBar = StartUpdate.f358zu;
        if (progressBar != null) {
            progressBar2 = StartUpdate.f358zu;
            progressBar2.setProgress(this.f646zz);
        }
        try {
            textView = StartUpdate.f359zv;
            if (textView != null) {
                textView2 = StartUpdate.f359zv;
                textView2.setText(this.f645zA);
            }
        } catch (Exception e) {
        }
    }
}
