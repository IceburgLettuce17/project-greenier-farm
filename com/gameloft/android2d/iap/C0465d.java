package com.gameloft.android2d.iap;

import android.graphics.Color;
import android.text.method.ScrollingMovementMethod;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.android.C0217R;
import com.gameloft.android2d.iap.p042a.AbstractC0358a;
import com.gameloft.android2d.iap.utils.C0483j;
import com.gameloft.android2d.iap.utils.C0488o;
import com.gameloft.android2d.iap.utils.C0489p;
import com.gameloft.android2d.iap.utils.C0490q;
import java.util.Hashtable;
import p001a.p004b.p005a.p006a.C0012k;
import p009b.p010a.p012b.DialogC0064m;

final class C0465d extends Thread {

    private int f2844Zk;

    final long f2845Zl;

    C0465d(int i, long j) {
        this.f2844Zk = i;
        this.f2845Zl = j;
    }

    @Override
    public final void run() {
        C0463b c0463b;
        C0489p c0489p;
        C0463b c0463b2;
        String str;
        C0463b c0463b3;
        int i;
        C0463b c0463b4;
        C0489p c0489p2;
        C0463b c0463b5;
        C0489p c0489p3;
        boolean z;
        String str2;
        String str3;
        C0463b c0463b6;
        String str4;
        String str5;
        C0463b c0463b7;
        C0463b c0463b8;
        C0463b c0463b9;
        C0463b c0463b10;
        C0463b c0463b11;
        String str6;
        C0463b c0463b12;
        C0463b c0463b13;
        C0463b c0463b14;
        C0463b c0463b15;
        C0463b c0463b16;
        C0463b c0463b17;
        C0463b c0463b18;
        int width;
        ViewGroup.LayoutParams layoutParams;
        boolean z2;
        C0463b c0463b19;
        C0463b c0463b20;
        C0463b c0463b21;
        C0463b c0463b22;
        String str7;
        c0463b = C0463b.f2809Ym;
        c0489p = c0463b.f2827Yn;
        C0490q c0490q = c0489p.aeI;
        c0463b2 = C0463b.f2809Ym;
        str = c0463b2.f2831Yr;
        Hashtable<Integer, C0483j> m2660cN = c0490q.m2660cN(str.toLowerCase());
        c0463b3 = C0463b.f2809Ym;
        i = c0463b3.f2830Yq;
        AbstractC0358a m2620sQ = m2660cN.get(Integer.valueOf(i)).m2620sQ();
        String m2281rw = m2620sQ.m2281rw();
        c0463b4 = C0463b.f2809Ym;
        c0489p2 = c0463b4.f2827Yn;
        String str8 = c0489p2.aeI.afa;
        c0463b5 = C0463b.f2809Ym;
        c0489p3 = c0463b5.f2827Yn;
        String str9 = c0489p3.aeI.afb;
        z = C0463b.f2808YZ;
        if (z) {
            m2620sQ.m2284rz();
            m2620sQ.m2263rA();
            m2620sQ.m2264rB();
            String m2265rC = m2620sQ.m2265rC();
            str2 = m2620sQ.m2266rD();
            str3 = m2265rC;
        } else {
            str2 = str9;
            str3 = str8;
        }
        c0463b6 = C0463b.f2809Ym;
        str4 = c0463b6.f2823YC;
        if (str4 != null) {
            c0463b22 = C0463b.f2809Ym;
            str7 = c0463b22.f2823YC;
            if (str7.equalsIgnoreCase("th")) {
                str5 = m2281rw.replace("|", "");
                C0012k.m41c("IAP-IAPLib", "Confirm text: " + str5);
                C0012k.m41c("IAP-IAPLib", "OK text: " + str3);
                C0012k.m41c("IAP-IAPLib", "Later text: " + str2);
                int i2 = C0488o.getContext().getResources().getConfiguration().orientation != 1 ? 10 : 7;
                c0463b7 = C0463b.f2809Ym;
                c0463b7.f2826YG = null;
                c0463b8 = C0463b.f2809Ym;
                c0463b9 = C0463b.f2809Ym;
                c0463b8.f2826YG = new DialogC0064m(c0463b9.f2825YF);
                c0463b10 = C0463b.f2809Ym;
                c0463b10.f2826YG.requestWindowFeature(1);
                if (this.f2844Zk != 17) {
                    c0463b20 = C0463b.f2809Ym;
                    c0463b20.f2826YG.setContentView(C0217R.layout.layout_osconfirmation_sp);
                    c0463b21 = C0463b.f2809Ym;
                    TextView textView = (TextView) c0463b21.f2826YG.findViewById(C0217R.id.textView2);
                    textView.setMaxLines(i2);
                    textView.setTextSize(18.0f);
                    textView.setMovementMethod(ScrollingMovementMethod.getInstance());
                    String m2283ry = m2620sQ.m2283ry();
                    String m2282rx = m2620sQ.m2282rx();
                    textView.setText(m2283ry);
                    str6 = m2282rx;
                } else {
                    c0463b11 = C0463b.f2809Ym;
                    c0463b11.f2826YG.setContentView(C0217R.layout.layout_osconfirmation);
                    str6 = str5;
                }
                c0463b12 = C0463b.f2809Ym;
                c0463b12.f2826YG.setCancelable(false);
                c0463b13 = C0463b.f2809Ym;
                c0463b13.f2826YG.setTitle((CharSequence) null);
                c0463b14 = C0463b.f2809Ym;
                Button button = (Button) c0463b14.f2826YG.findViewById(C0217R.id.button1);
                c0463b15 = C0463b.f2809Ym;
                Button button2 = (Button) c0463b15.f2826YG.findViewById(C0217R.id.button2);
                c0463b16 = C0463b.f2809Ym;
                TextView textView2 = (TextView) c0463b16.f2826YG.findViewById(C0217R.id.textView1);
                c0463b17 = C0463b.f2809Ym;
                LinearLayout linearLayout = (LinearLayout) c0463b17.f2826YG.findViewById(C0217R.id.mainLayout);
                c0463b18 = C0463b.f2809Ym;
                LinearLayout linearLayout2 = (LinearLayout) c0463b18.f2826YG.findViewById(C0217R.id.buttonLayout);
                linearLayout.setBackgroundColor(Color.argb(255, 21, 40, 57));
                width = ((WindowManager) C0488o.getContext().getSystemService("window")).getDefaultDisplay().getWidth();
                layoutParams = linearLayout.getLayoutParams();
                if (width > 700 && C0488o.getContext().getResources().getConfiguration().orientation == 2) {
                    layoutParams.width = (width * 70) / 100;
                }
                textView2.setMaxLines(i2);
                linearLayout2.setBackgroundColor(Color.argb(255, 96, 99, 102));
                textView2.setTextSize(18.0f);
                textView2.setMovementMethod(ScrollingMovementMethod.getInstance());
                textView2.setText(str6);
                button2.setText(str3);
                button.setText(str2);
                z2 = C0463b.f2808YZ;
                if (z2) {
                    C0463b.m2550qW();
                }
                button2.setOnClickListener(new ViewOnClickListenerC0466e(this));
                button.setOnClickListener(new ViewOnClickListenerC0467f(this));
                c0463b19 = C0463b.f2809Ym;
                c0463b19.f2826YG.setOnKeyListener(new DialogInterfaceOnKeyListenerC0468g(this));
            }
        }
        str5 = m2281rw;
        C0012k.m41c("IAP-IAPLib", "Confirm text: " + str5);
        C0012k.m41c("IAP-IAPLib", "OK text: " + str3);
        C0012k.m41c("IAP-IAPLib", "Later text: " + str2);
        if (C0488o.getContext().getResources().getConfiguration().orientation != 1) {
        }
        c0463b7 = C0463b.f2809Ym;
        c0463b7.f2826YG = null;
        c0463b8 = C0463b.f2809Ym;
        c0463b9 = C0463b.f2809Ym;
        c0463b8.f2826YG = new DialogC0064m(c0463b9.f2825YF);
        c0463b10 = C0463b.f2809Ym;
        c0463b10.f2826YG.requestWindowFeature(1);
        if (this.f2844Zk != 17) {
        }
        c0463b12 = C0463b.f2809Ym;
        c0463b12.f2826YG.setCancelable(false);
        c0463b13 = C0463b.f2809Ym;
        c0463b13.f2826YG.setTitle((CharSequence) null);
        c0463b14 = C0463b.f2809Ym;
        Button button3 = (Button) c0463b14.f2826YG.findViewById(C0217R.id.button1);
        c0463b15 = C0463b.f2809Ym;
        Button button22 = (Button) c0463b15.f2826YG.findViewById(C0217R.id.button2);
        c0463b16 = C0463b.f2809Ym;
        TextView textView22 = (TextView) c0463b16.f2826YG.findViewById(C0217R.id.textView1);
        c0463b17 = C0463b.f2809Ym;
        LinearLayout linearLayout3 = (LinearLayout) c0463b17.f2826YG.findViewById(C0217R.id.mainLayout);
        c0463b18 = C0463b.f2809Ym;
        LinearLayout linearLayout22 = (LinearLayout) c0463b18.f2826YG.findViewById(C0217R.id.buttonLayout);
        linearLayout3.setBackgroundColor(Color.argb(255, 21, 40, 57));
        width = ((WindowManager) C0488o.getContext().getSystemService("window")).getDefaultDisplay().getWidth();
        layoutParams = linearLayout3.getLayoutParams();
        if (width > 700) {
            layoutParams.width = (width * 70) / 100;
        }
        textView22.setMaxLines(i2);
        linearLayout22.setBackgroundColor(Color.argb(255, 96, 99, 102));
        textView22.setTextSize(18.0f);
        textView22.setMovementMethod(ScrollingMovementMethod.getInstance());
        textView22.setText(str6);
        button22.setText(str3);
        button3.setText(str2);
        z2 = C0463b.f2808YZ;
        if (z2) {
        }
        button22.setOnClickListener(new ViewOnClickListenerC0466e(this));
        button3.setOnClickListener(new ViewOnClickListenerC0467f(this));
        c0463b19 = C0463b.f2809Ym;
        c0463b19.f2826YG.setOnKeyListener(new DialogInterfaceOnKeyListenerC0468g(this));
    }
}
