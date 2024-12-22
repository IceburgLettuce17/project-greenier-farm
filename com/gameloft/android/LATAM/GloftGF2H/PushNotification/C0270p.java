package com.gameloft.android.LATAM.GloftGF2H.PushNotification;

import android.R;
import android.app.Notification;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.android.C0217R;

public final class C0270p {
    private static int icon;

    private static float f340yh;

    static {
        Integer.valueOf(R.color.white);
        f340yh = 11.0f;
        icon = 0;
    }

    private static boolean m576a(Context context, ViewGroup viewGroup) {
        while (true) {
            int childCount = viewGroup.getChildCount();
            int i = 0;
            while (i < childCount) {
                if (viewGroup.getChildAt(i) instanceof TextView) {
                    TextView textView = (TextView) viewGroup.getChildAt(i);
                    if ("SOME_SAMPLE_TEXT".equals(textView.getText().toString())) {
                        Integer.valueOf(textView.getTextColors().getDefaultColor());
                        f340yh = textView.getTextSize();
                        DisplayMetrics displayMetrics = new DisplayMetrics();
                        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
                        float f = f340yh / displayMetrics.scaledDensity;
                        f340yh = f;
                        f340yh = f - 2.0f;
                        return true;
                    }
                } else if (viewGroup.getChildAt(i) instanceof ViewGroup) {
                    break;
                }
                i++;
            }
            return false;
            viewGroup = (ViewGroup) viewGroup.getChildAt(i);
        }
    }

    public static int m577dd() {
        return icon;
    }

    public static void m578h(Context context) {
        if (icon == 0) {
            try {
                Notification notification = new Notification();
                notification.setLatestEventInfo(context, "SOME_SAMPLE_TEXT", "Utest", null);
                LinearLayout linearLayout = new LinearLayout(context);
                if (!m576a(context, (ViewGroup) notification.contentView.apply(context, linearLayout))) {
                    Integer.valueOf(R.color.white);
                }
                linearLayout.removeAllViews();
            } catch (Exception e) {
                Integer.valueOf(R.color.white);
            }
        }
        Resources resources = context.getResources();
        if (C0263i.f320xR) {
            if (C0263i.f321xS != null) {
                icon = resources.getIdentifier(C0263i.f321xS, "drawable", context.getPackageName());
            }
            if (icon == 0) {
                icon = resources.getIdentifier("pn_custom_icon", "drawable", context.getPackageName());
            }
        } else {
            icon = resources.getIdentifier("pn_icon", "drawable", context.getPackageName());
        }
        resources.getIdentifier("custom_notification_layout", "layout", context.getPackageName());
        if (icon == 0) {
            icon = C0217R.drawable.icon;
        }
    }
}
