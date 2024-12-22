package com.facebook.widget;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.facebook.FacebookDialogException;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookServiceException;
import com.facebook.Session;
import com.facebook.android.C0217R;
import com.facebook.android.Util;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;

public class WebDialog extends Dialog {
    static final String CANCEL_URI = "fbconnect://cancel";
    public static final int DEFAULT_THEME = 16973840;
    static final boolean DISABLE_SSL_CHECK_FOR_TESTING = false;
    private static final String DISPLAY_TOUCH = "touch";
    private static final String LOG_TAG = "FacebookSDK.WebDialog";
    static final String REDIRECT_URI = "fbconnect://success";
    private static final String USER_AGENT = "user_agent";
    private FrameLayout contentFrameLayout;
    private ImageView crossImageView;
    private boolean isDetached;
    private boolean listenerCalled;
    private OnCompleteListener onCompleteListener;
    private ProgressDialog spinner;
    private String url;
    private WebView webView;

    class DialogInterfaceOnCancelListenerC02511 implements DialogInterface.OnCancelListener {
        DialogInterfaceOnCancelListenerC02511() {
        }

        @Override
        public void onCancel(DialogInterface dialogInterface) {
            WebDialog.this.sendCancelToListener();
        }
    }

    class DialogInterfaceOnCancelListenerC02522 implements DialogInterface.OnCancelListener {
        DialogInterfaceOnCancelListenerC02522() {
        }

        @Override
        public void onCancel(DialogInterface dialogInterface) {
            WebDialog.this.sendCancelToListener();
            WebDialog.this.dismiss();
        }
    }

    class ViewOnClickListenerC02533 implements View.OnClickListener {
        ViewOnClickListenerC02533() {
        }

        @Override
        public void onClick(View view) {
            WebDialog.this.sendCancelToListener();
            WebDialog.this.dismiss();
        }
    }

    public class Builder extends BuilderBase<Builder> {
        public Builder(Context context, Session session, String str, Bundle bundle) {
            super(context, session, str, bundle);
        }

        public Builder(Context context, String str, String str2, Bundle bundle) {
            super(context, str, str2, bundle);
        }

        @Override
        public WebDialog build() {
            return super.build();
        }
    }

    public class BuilderBase<CONCRETE extends BuilderBase<?>> {
        private String action;
        private String applicationId;
        private Context context;
        private OnCompleteListener listener;
        private Bundle parameters;
        private Session session;
        private int theme = 16973840;

        protected BuilderBase(Context context, Session session, String str, Bundle bundle) {
            Validate.notNull(session, "session");
            if (!session.isOpened()) {
                throw new FacebookException("Attempted to use a Session that was not open.");
            }
            this.session = session;
            finishInit(context, str, bundle);
        }

        protected BuilderBase(Context context, String str, String str2, Bundle bundle) {
            Validate.notNullOrEmpty(str, "applicationId");
            this.applicationId = str;
            finishInit(context, str2, bundle);
        }

        private void finishInit(Context context, String str, Bundle bundle) {
            this.context = context;
            this.action = str;
            if (bundle != null) {
                this.parameters = bundle;
            } else {
                this.parameters = new Bundle();
            }
        }

        public WebDialog build() {
            if (this.session == null || !this.session.isOpened()) {
                this.parameters.putString(ServerProtocol.DIALOG_PARAM_APP_ID, this.applicationId);
            } else {
                this.parameters.putString(ServerProtocol.DIALOG_PARAM_APP_ID, this.session.getApplicationId());
                this.parameters.putString("access_token", this.session.getAccessToken());
            }
            if (!this.parameters.containsKey(ServerProtocol.DIALOG_PARAM_REDIRECT_URI)) {
                this.parameters.putString(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, "fbconnect://success");
            }
            return new WebDialog(this.context, this.action, this.parameters, this.theme, this.listener);
        }

        protected String getApplicationId() {
            return this.applicationId;
        }

        protected Context getContext() {
            return this.context;
        }

        protected OnCompleteListener getListener() {
            return this.listener;
        }

        protected Bundle getParameters() {
            return this.parameters;
        }

        protected int getTheme() {
            return this.theme;
        }

        public CONCRETE setOnCompleteListener(OnCompleteListener onCompleteListener) {
            this.listener = onCompleteListener;
            return this;
        }

        public CONCRETE setTheme(int i) {
            this.theme = i;
            return this;
        }
    }

    class DialogWebViewClient extends WebViewClient {
        private DialogWebViewClient() {
        }

        DialogWebViewClient(WebDialog webDialog, DialogInterfaceOnCancelListenerC02511 dialogInterfaceOnCancelListenerC02511) {
            this();
        }

        @Override
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (!WebDialog.this.isDetached) {
                WebDialog.this.spinner.dismiss();
            }
            WebDialog.this.contentFrameLayout.setBackgroundColor(0);
            WebDialog.this.webView.setVisibility(0);
            WebDialog.this.crossImageView.setVisibility(0);
        }

        @Override
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Utility.logd(WebDialog.LOG_TAG, "Webview loading URL: " + str);
            super.onPageStarted(webView, str, bitmap);
            if (WebDialog.this.isDetached) {
                return;
            }
            WebDialog.this.spinner.show();
        }

        @Override
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            WebDialog.this.sendErrorToListener(new FacebookDialogException(str, i, str2));
            WebDialog.this.dismiss();
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            int i;
            Utility.logd(WebDialog.LOG_TAG, "Redirect URL: " + str);
            if (!str.startsWith("fbconnect://success")) {
                if (str.startsWith("fbconnect://cancel")) {
                    WebDialog.this.sendCancelToListener();
                    WebDialog.this.dismiss();
                    return true;
                }
                if (str.contains(WebDialog.DISPLAY_TOUCH)) {
                    return WebDialog.DISABLE_SSL_CHECK_FOR_TESTING;
                }
                WebDialog.this.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                return true;
            }
            Bundle parseUrl = Util.parseUrl(str);
            String string = parseUrl.getString("error");
            if (string == null) {
                string = parseUrl.getString("error_type");
            }
            String string2 = parseUrl.getString("error_msg");
            if (string2 == null) {
                string2 = parseUrl.getString("error_description");
            }
            String string3 = parseUrl.getString("error_code");
            if (Utility.isNullOrEmpty(string3)) {
                i = -1;
            } else {
                try {
                    i = Integer.parseInt(string3);
                } catch (NumberFormatException e) {
                    i = -1;
                }
            }
            if (Utility.isNullOrEmpty(string) && Utility.isNullOrEmpty(string2) && i == -1) {
                WebDialog.this.sendSuccessToListener(parseUrl);
            } else if (string == null || !(string.equals("access_denied") || string.equals("OAuthAccessDeniedException"))) {
                WebDialog.this.sendErrorToListener(new FacebookServiceException(new FacebookRequestError(i, string, string2), string2));
            } else {
                WebDialog.this.sendCancelToListener();
            }
            WebDialog.this.dismiss();
            return true;
        }
    }

    public class FeedDialogBuilder extends BuilderBase<FeedDialogBuilder> {
        private static final String CAPTION_PARAM = "caption";
        private static final String DESCRIPTION_PARAM = "description";
        private static final String FEED_DIALOG = "feed";
        private static final String FROM_PARAM = "from";
        private static final String LINK_PARAM = "link";
        private static final String NAME_PARAM = "name";
        private static final String PICTURE_PARAM = "picture";
        private static final String SOURCE_PARAM = "source";
        private static final String TO_PARAM = "to";

        public FeedDialogBuilder(Context context, Session session) {
            super(context, session, FEED_DIALOG, (Bundle) null);
        }

        public FeedDialogBuilder(Context context, Session session, Bundle bundle) {
            super(context, session, FEED_DIALOG, bundle);
        }

        @Override
        public WebDialog build() {
            return super.build();
        }

        public FeedDialogBuilder setCaption(String str) {
            getParameters().putString(CAPTION_PARAM, str);
            return this;
        }

        public FeedDialogBuilder setDescription(String str) {
            getParameters().putString(DESCRIPTION_PARAM, str);
            return this;
        }

        public FeedDialogBuilder setFrom(String str) {
            getParameters().putString(FROM_PARAM, str);
            return this;
        }

        public FeedDialogBuilder setLink(String str) {
            getParameters().putString(LINK_PARAM, str);
            return this;
        }

        public FeedDialogBuilder setName(String str) {
            getParameters().putString(NAME_PARAM, str);
            return this;
        }

        public FeedDialogBuilder setPicture(String str) {
            getParameters().putString(PICTURE_PARAM, str);
            return this;
        }

        public FeedDialogBuilder setSource(String str) {
            getParameters().putString(SOURCE_PARAM, str);
            return this;
        }

        public FeedDialogBuilder setTo(String str) {
            getParameters().putString(TO_PARAM, str);
            return this;
        }
    }

    public interface OnCompleteListener {
        void onComplete(Bundle bundle, FacebookException facebookException);
    }

    public class RequestsDialogBuilder extends BuilderBase<RequestsDialogBuilder> {
        private static final String APPREQUESTS_DIALOG = "apprequests";
        private static final String DATA_PARAM = "data";
        private static final String MESSAGE_PARAM = "message";
        private static final String TITLE_PARAM = "title";
        private static final String TO_PARAM = "to";

        public RequestsDialogBuilder(Context context, Session session) {
            super(context, session, APPREQUESTS_DIALOG, (Bundle) null);
        }

        public RequestsDialogBuilder(Context context, Session session, Bundle bundle) {
            super(context, session, APPREQUESTS_DIALOG, bundle);
        }

        @Override
        public WebDialog build() {
            return super.build();
        }

        public RequestsDialogBuilder setData(String str) {
            getParameters().putString(DATA_PARAM, str);
            return this;
        }

        public RequestsDialogBuilder setMessage(String str) {
            getParameters().putString(MESSAGE_PARAM, str);
            return this;
        }

        public RequestsDialogBuilder setTitle(String str) {
            getParameters().putString(TITLE_PARAM, str);
            return this;
        }

        public RequestsDialogBuilder setTo(String str) {
            getParameters().putString(TO_PARAM, str);
            return this;
        }
    }

    public WebDialog(Context context, String str) {
        this(context, str, 16973840);
    }

    public WebDialog(Context context, String str, int i) {
        super(context, i);
        this.listenerCalled = DISABLE_SSL_CHECK_FOR_TESTING;
        this.isDetached = DISABLE_SSL_CHECK_FOR_TESTING;
        this.url = str;
    }

    public WebDialog(Context context, String str, Bundle bundle, int i, OnCompleteListener onCompleteListener) {
        super(context, i);
        this.listenerCalled = DISABLE_SSL_CHECK_FOR_TESTING;
        this.isDetached = DISABLE_SSL_CHECK_FOR_TESTING;
        bundle = bundle == null ? new Bundle() : bundle;
        bundle.putString(ServerProtocol.DIALOG_PARAM_DISPLAY, DISPLAY_TOUCH);
        bundle.putString(ServerProtocol.DIALOG_PARAM_TYPE, USER_AGENT);
        this.url = Utility.buildUri(ServerProtocol.DIALOG_AUTHORITY, ServerProtocol.DIALOG_PATH + str, bundle).toString();
        this.onCompleteListener = onCompleteListener;
    }

    private void createCrossImage() {
        this.crossImageView = new ImageView(getContext());
        this.crossImageView.setOnClickListener(new View.OnClickListener() {
            ViewOnClickListenerC02533() {
            }

            @Override
            public void onClick(View view) {
                WebDialog.this.sendCancelToListener();
                WebDialog.this.dismiss();
            }
        });
        this.crossImageView.setImageDrawable(getContext().getResources().getDrawable(C0217R.drawable.com_facebook_close));
        this.crossImageView.setVisibility(4);
    }

    public void sendCancelToListener() {
        sendErrorToListener(new FacebookOperationCanceledException());
        freeMemory();
    }

    public void sendErrorToListener(Throwable th) {
        if (this.onCompleteListener != null && !this.listenerCalled) {
            this.listenerCalled = true;
            this.onCompleteListener.onComplete(null, th instanceof FacebookException ? (FacebookException) th : new FacebookException(th));
        }
        freeMemory();
    }

    public void sendSuccessToListener(Bundle bundle) {
        if (this.onCompleteListener != null && !this.listenerCalled) {
            this.listenerCalled = true;
            this.onCompleteListener.onComplete(bundle, null);
        }
        freeMemory();
    }

    private void setUpWebView(int i) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.webView = new WebView(getContext());
        this.webView.setVerticalScrollBarEnabled(DISABLE_SSL_CHECK_FOR_TESTING);
        this.webView.setHorizontalScrollBarEnabled(DISABLE_SSL_CHECK_FOR_TESTING);
        this.webView.setWebViewClient(new DialogWebViewClient());
        this.webView.getSettings().setJavaScriptEnabled(true);
        this.webView.loadUrl(this.url);
        this.webView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.webView.setVisibility(4);
        this.webView.getSettings().setSavePassword(DISABLE_SSL_CHECK_FOR_TESTING);
        linearLayout.setPadding(i, i, i, i);
        linearLayout.addView(this.webView);
        this.contentFrameLayout.addView(linearLayout);
        this.webView.setFocusable(true);
        this.webView.setFocusableInTouchMode(true);
        this.webView.requestFocus();
        this.webView.requestFocusFromTouch();
    }

    @Override
    public void dismiss() {
        if (this.webView != null) {
            this.webView.stopLoading();
        }
        if (this.isDetached) {
            return;
        }
        if (this.spinner.isShowing()) {
            this.spinner.dismiss();
        }
        super.dismiss();
    }

    public void freeMemory() {
        if (this.webView != null) {
            this.webView.clearCache(true);
            this.webView.clearSslPreferences();
            this.webView.clearAnimation();
            this.webView.clearDisappearingChildren();
            this.webView.clearFocus();
            this.webView.clearFormData();
            this.webView.clearHistory();
            this.webView.clearMatches();
            this.webView.freeMemory();
            System.gc();
        }
    }

    public OnCompleteListener getOnCompleteListener() {
        return this.onCompleteListener;
    }

    @Override
    public void onAttachedToWindow() {
        this.isDetached = DISABLE_SSL_CHECK_FOR_TESTING;
        super.onAttachedToWindow();
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setOnCancelListener(new DialogInterface.OnCancelListener() {
            DialogInterfaceOnCancelListenerC02511() {
            }

            @Override
            public void onCancel(DialogInterface dialogInterface) {
                WebDialog.this.sendCancelToListener();
            }
        });
        setCanceledOnTouchOutside(DISABLE_SSL_CHECK_FOR_TESTING);
        this.spinner = new ProgressDialog(getContext());
        this.spinner.requestWindowFeature(1);
        this.spinner.setMessage(getContext().getString(C0217R.string.com_facebook_loading));
        this.spinner.setOnCancelListener(new DialogInterface.OnCancelListener() {
            DialogInterfaceOnCancelListenerC02522() {
            }

            @Override
            public void onCancel(DialogInterface dialogInterface) {
                WebDialog.this.sendCancelToListener();
                WebDialog.this.dismiss();
            }
        });
        this.spinner.setCanceledOnTouchOutside(DISABLE_SSL_CHECK_FOR_TESTING);
        requestWindowFeature(1);
        this.contentFrameLayout = new FrameLayout(getContext());
        createCrossImage();
        setUpWebView(this.crossImageView.getDrawable().getIntrinsicWidth() / 2);
        this.contentFrameLayout.addView(this.crossImageView, new ViewGroup.LayoutParams(-2, -2));
        addContentView(this.contentFrameLayout, new ViewGroup.LayoutParams(-1, -1));
    }

    @Override
    public void onDetachedFromWindow() {
        this.isDetached = true;
        super.onDetachedFromWindow();
    }

    public void setOnCompleteListener(OnCompleteListener onCompleteListener) {
        this.onCompleteListener = onCompleteListener;
    }
}
