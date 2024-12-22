package com.p034e.p035a.p036a;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Xml;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.facebook.android.C0217R;
import com.p034e.p035a.p036a.p040d.C0175b;
import java.io.IOException;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class DialogC0178g extends Dialog {
    private static int ahL;
    private static int ahM;
    private static int theme;
    private String ahG;
    private InterfaceC0177f ahH;
    private ProgressDialog ahI;
    private RelativeLayout ahJ;
    private RelativeLayout ahK;
    private Context mContext;

    private WebView f124za;

    static {
        new FrameLayout.LayoutParams(-1, -1);
        theme = 16973840;
        ahL = 0;
        ahM = 0;
    }

    public DialogC0178g(Context context, String str, InterfaceC0177f interfaceC0177f) {
        super(context, theme);
        this.ahG = str;
        this.ahH = interfaceC0177f;
        this.mContext = context;
    }

    static void m329a(DialogC0178g dialogC0178g, WebView webView, String str) {
        Bundle parseUrl = C0175b.parseUrl(str);
        String string = parseUrl.getString("error");
        String string2 = parseUrl.getString("error_code");
        if (string == null && string2 == null) {
            dialogC0178g.ahH.onComplete(parseUrl);
        } else if (string2 == null) {
            dialogC0178g.ahH.mo319a(new C0181j(string, 0));
        } else {
            dialogC0178g.ahH.mo319a(new C0181j(string, Integer.parseInt(string2)));
        }
    }

    private boolean m332tM() {
        IOException iOException;
        boolean z;
        InputStream inputStream;
        InputStream inputStream2 = null;
        boolean z2 = true;
        AssetManager assets = getContext().getAssets();
        float f = getContext().getResources().getDisplayMetrics().density;
        try {
            try {
                InputStream open = assets.open("values/dimens.xml");
                try {
                    XmlPullParser newPullParser = Xml.newPullParser();
                    try {
                        newPullParser.setInput(open, "utf-8");
                        for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                            switch (eventType) {
                                case 2:
                                    try {
                                        try {
                                            if (newPullParser.getName().equals("dimen")) {
                                                String attributeValue = newPullParser.getAttributeValue(null, "name");
                                                if ("weibosdk_dialog_left_margin".equals(attributeValue)) {
                                                    ahL = (int) (Integer.parseInt(newPullParser.nextText()) * f);
                                                } else if ("weibosdk_dialog_top_margin".equals(attributeValue)) {
                                                    Integer.parseInt(newPullParser.nextText());
                                                } else if ("weibosdk_dialog_right_margin".equals(attributeValue)) {
                                                    ahM = (int) (Integer.parseInt(newPullParser.nextText()) * f);
                                                } else if ("weibosdk_dialog_bottom_margin".equals(attributeValue)) {
                                                    Integer.parseInt(newPullParser.nextText());
                                                }
                                            }
                                        } catch (IOException e) {
                                            inputStream = open;
                                            z = z2;
                                            iOException = e;
                                            try {
                                                iOException.printStackTrace();
                                                if (inputStream != null) {
                                                    try {
                                                        inputStream.close();
                                                    } catch (IOException e2) {
                                                        e2.printStackTrace();
                                                    }
                                                }
                                                return z;
                                            } catch (Throwable th) {
                                                th = th;
                                                inputStream2 = inputStream;
                                                if (inputStream2 != null) {
                                                }
                                                throw th;
                                            }
                                        }
                                    } catch (XmlPullParserException e3) {
                                        e = e3;
                                        e.printStackTrace();
                                        z = z2;
                                        if (open != null) {
                                        }
                                        return z;
                                    }
                                    break;
                                default:
                            }
                        }
                        z = true;
                    } catch (XmlPullParserException e4) {
                        e = e4;
                        z2 = false;
                    }
                    if (open != null) {
                        try {
                            open.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                } catch (IOException e6) {
                    iOException = e6;
                    z = false;
                    inputStream = open;
                }
            } catch (IOException e7) {
                iOException = e7;
                z = false;
                inputStream = null;
            }
            return z;
        } catch (Throwable th2) {
            th = th2;
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (IOException e8) {
                    e8.printStackTrace();
                }
            }
            throw th;
        }
    }

    @Override
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ahI = new ProgressDialog(getContext());
        this.ahI.requestWindowFeature(1);
        this.ahI.setMessage("Loading...");
        requestWindowFeature(1);
        getWindow().setFeatureDrawableAlpha(0, 0);
        this.ahK = new RelativeLayout(getContext());
        getWindow().setSoftInputMode(16);
        this.ahJ = new RelativeLayout(getContext());
        this.f124za = new WebView(getContext());
        this.f124za.getSettings().setJavaScriptEnabled(true);
        this.f124za.getSettings().setSavePassword(false);
        this.f124za.setWebViewClient(new C0179h(this, (byte) 0));
        Context context = this.mContext;
        String str = this.ahG;
        CookieSyncManager.createInstance(context);
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        cookieManager.removeSessionCookie();
        cookieManager.removeAllCookie();
        CookieSyncManager.getInstance().sync();
        this.f124za.loadUrl(this.ahG);
        this.f124za.requestFocus();
        this.f124za.setScrollBarStyle(0);
        this.f124za.setVisibility(4);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        this.ahK.setBackgroundColor(0);
        AssetManager assets = getContext().getAssets();
        InputStream inputStream = null;
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        float f = displayMetrics.density;
        try {
            try {
                inputStream = assets.open("weibosdk_dialog_bg.9.png");
                layoutParams2.leftMargin = (int) (10.0f * f);
                layoutParams2.topMargin = (int) (10.0f * f);
                layoutParams2.rightMargin = (int) (10.0f * f);
                layoutParams2.bottomMargin = (int) (10.0f * f);
            } catch (Exception e) {
                try {
                    e.printStackTrace();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                }
            }
            if (inputStream == null) {
                this.ahJ.setBackgroundResource(C0217R.drawable.ic_action_search);
            } else {
                Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
                this.ahJ.setBackgroundDrawable(new NinePatchDrawable(decodeStream, decodeStream.getNinePatchChunk(), new Rect(0, 0, 0, 0), null));
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            this.ahJ.addView(this.f124za, layoutParams2);
            this.ahJ.setGravity(17);
            if (m332tM()) {
                layoutParams.leftMargin = ahL;
                if (f == 1.0d) {
                    layoutParams.topMargin = 15;
                } else if (f == 1.5d) {
                    layoutParams.topMargin = 25;
                } else {
                    layoutParams.topMargin = displayMetrics.heightPixels / 15;
                }
                layoutParams.rightMargin = ahM;
                layoutParams.bottomMargin = (displayMetrics.heightPixels - layoutParams.topMargin) - ((int) (1.5d * (displayMetrics.widthPixels - (ahL * 2))));
            } else {
                Resources resources = getContext().getResources();
                layoutParams.leftMargin = resources.getDimensionPixelSize(C0217R.dimen.com_facebook_usersettingsfragment_profile_picture_width);
                layoutParams.rightMargin = resources.getDimensionPixelSize(C0217R.dimen.com_facebook_loginview_padding_left);
                layoutParams.topMargin = resources.getDimensionPixelSize(C0217R.dimen.com_facebook_usersettingsfragment_profile_picture_height);
                layoutParams.bottomMargin = resources.getDimensionPixelSize(C0217R.dimen.com_facebook_loginview_padding_right);
            }
            this.ahK.addView(this.ahJ, layoutParams);
            addContentView(this.ahK, new ViewGroup.LayoutParams(-1, -1));
            C0175b.m327u(this.mContext);
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            throw th;
        }
    }

    @Override
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.ahH.onCancel();
        }
        return super.onKeyDown(i, keyEvent);
    }
}
