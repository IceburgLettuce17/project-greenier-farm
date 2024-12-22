package com.facebook.widget;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.facebook.FacebookException;
import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.SessionDefaultAudience;
import com.facebook.SessionLoginBehavior;
import com.facebook.SessionState;
import com.facebook.android.C0217R;
import com.facebook.internal.SessionAuthorizationType;
import com.facebook.internal.SessionTracker;
import com.facebook.internal.Utility;
import com.facebook.model.GraphUser;
import java.util.Collections;
import java.util.List;
import p001a.p004b.p005a.p006a.ComponentCallbacksC0006e;

public class LoginButton extends Button {
    private static final String TAG = LoginButton.class.getName();
    private String applicationId;
    private boolean confirmLogout;
    private boolean fetchUserInfo;
    private String loginText;
    private String logoutText;
    private ComponentCallbacksC0006e parentFragment;
    private LoginButtonProperties properties;
    private SessionTracker sessionTracker;
    private GraphUser user;
    private UserInfoChangedCallback userInfoChangedCallback;
    private Session userInfoSession;

    class LoginButtonCallback implements Session.StatusCallback {
        private LoginButtonCallback() {
        }

        @Override
        public void call(Session session, SessionState sessionState, Exception exc) {
            LoginButton.this.fetchUserInfo();
            LoginButton.this.setButtonText();
            if (exc != null) {
                LoginButton.this.handleError(exc);
            }
            if (LoginButton.this.properties.sessionStatusCallback != null) {
                LoginButton.this.properties.sessionStatusCallback.call(session, sessionState, exc);
            }
        }
    }

    class LoginButtonProperties {
        private OnErrorListener onErrorListener;
        private Session.StatusCallback sessionStatusCallback;
        private SessionDefaultAudience defaultAudience = SessionDefaultAudience.FRIENDS;
        private List<String> permissions = Collections.emptyList();
        private SessionAuthorizationType authorizationType = null;
        private SessionLoginBehavior loginBehavior = SessionLoginBehavior.SSO_WITH_FALLBACK;

        LoginButtonProperties() {
        }

        private boolean validatePermissions(List<String> list, SessionAuthorizationType sessionAuthorizationType, Session session) {
            if (SessionAuthorizationType.PUBLISH.equals(sessionAuthorizationType) && Utility.isNullOrEmpty(list)) {
                throw new IllegalArgumentException("Permissions for publish actions cannot be null or empty.");
            }
            if (session == null || !session.isOpened() || Utility.isSubset(list, session.getPermissions())) {
                return true;
            }
            Log.e(LoginButton.TAG, "Cannot set additional permissions when session is already open.");
            return false;
        }

        public void clearPermissions() {
            this.permissions = null;
            this.authorizationType = null;
        }

        public SessionDefaultAudience getDefaultAudience() {
            return this.defaultAudience;
        }

        public SessionLoginBehavior getLoginBehavior() {
            return this.loginBehavior;
        }

        public OnErrorListener getOnErrorListener() {
            return this.onErrorListener;
        }

        List<String> getPermissions() {
            return this.permissions;
        }

        public Session.StatusCallback getSessionStatusCallback() {
            return this.sessionStatusCallback;
        }

        public void setDefaultAudience(SessionDefaultAudience sessionDefaultAudience) {
            this.defaultAudience = sessionDefaultAudience;
        }

        public void setLoginBehavior(SessionLoginBehavior sessionLoginBehavior) {
            this.loginBehavior = sessionLoginBehavior;
        }

        public void setOnErrorListener(OnErrorListener onErrorListener) {
            this.onErrorListener = onErrorListener;
        }

        public void setPublishPermissions(List<String> list, Session session) {
            if (SessionAuthorizationType.READ.equals(this.authorizationType)) {
                throw new UnsupportedOperationException("Cannot call setPublishPermissions after setReadPermissions has been called.");
            }
            if (validatePermissions(list, SessionAuthorizationType.PUBLISH, session)) {
                this.permissions = list;
                this.authorizationType = SessionAuthorizationType.PUBLISH;
            }
        }

        public void setReadPermissions(List<String> list, Session session) {
            if (SessionAuthorizationType.PUBLISH.equals(this.authorizationType)) {
                throw new UnsupportedOperationException("Cannot call setReadPermissions after setPublishPermissions has been called.");
            }
            if (validatePermissions(list, SessionAuthorizationType.READ, session)) {
                this.permissions = list;
                this.authorizationType = SessionAuthorizationType.READ;
            }
        }

        public void setSessionStatusCallback(Session.StatusCallback statusCallback) {
            this.sessionStatusCallback = statusCallback;
        }
    }

    class LoginClickListener implements View.OnClickListener {
        private LoginClickListener() {
        }

        @Override
        public void onClick(View view) {
            Context context = LoginButton.this.getContext();
            final Session openSession = LoginButton.this.sessionTracker.getOpenSession();
            if (openSession != null) {
                if (!LoginButton.this.confirmLogout) {
                    openSession.closeAndClearTokenInformation();
                    return;
                }
                String string = LoginButton.this.getResources().getString(C0217R.string.com_facebook_loginview_log_out_action);
                String string2 = LoginButton.this.getResources().getString(C0217R.string.com_facebook_loginview_cancel_action);
                String string3 = (LoginButton.this.user == null || LoginButton.this.user.getName() == null) ? LoginButton.this.getResources().getString(C0217R.string.com_facebook_loginview_logged_in_using_facebook) : String.format(LoginButton.this.getResources().getString(C0217R.string.com_facebook_loginview_logged_in_as), LoginButton.this.user.getName());
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage(string3).setCancelable(true).setPositiveButton(string, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        openSession.closeAndClearTokenInformation();
                    }
                }).setNegativeButton(string2, (DialogInterface.OnClickListener) null);
                builder.create().show();
                return;
            }
            Session session = LoginButton.this.sessionTracker.getSession();
            if (session == null || session.getState().isClosed()) {
                LoginButton.this.sessionTracker.setSession(null);
                session = new Session.Builder(context).setApplicationId(LoginButton.this.applicationId).build();
                Session.setActiveSession(session);
            }
            if (session.isOpened()) {
                return;
            }
            Session.OpenRequest openRequest = LoginButton.this.parentFragment != null ? new Session.OpenRequest(LoginButton.this.parentFragment) : context instanceof Activity ? new Session.OpenRequest((Activity) context) : null;
            if (openRequest != null) {
                openRequest.setDefaultAudience(LoginButton.this.properties.defaultAudience);
                openRequest.setPermissions(LoginButton.this.properties.permissions);
                openRequest.setLoginBehavior(LoginButton.this.properties.loginBehavior);
                if (SessionAuthorizationType.PUBLISH.equals(LoginButton.this.properties.authorizationType)) {
                    session.openForPublish(openRequest);
                } else {
                    session.openForRead(openRequest);
                }
            }
        }
    }

    public interface OnErrorListener {
        void onError(FacebookException facebookException);
    }

    public interface UserInfoChangedCallback {
        void onUserInfoFetched(GraphUser graphUser);
    }

    public LoginButton(Context context) {
        super(context);
        this.applicationId = null;
        this.user = null;
        this.userInfoSession = null;
        this.properties = new LoginButtonProperties();
        initializeActiveSessionWithCachedToken(context);
        finishInit();
    }

    public LoginButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.applicationId = null;
        this.user = null;
        this.userInfoSession = null;
        this.properties = new LoginButtonProperties();
        if (attributeSet.getStyleAttribute() == 0) {
            setTextColor(getResources().getColor(C0217R.color.com_facebook_loginview_text_color));
            setTextSize(0, getResources().getDimension(C0217R.dimen.com_facebook_loginview_text_size));
            setPadding(getResources().getDimensionPixelSize(C0217R.dimen.com_facebook_loginview_padding_left), getResources().getDimensionPixelSize(C0217R.dimen.com_facebook_loginview_padding_top), getResources().getDimensionPixelSize(C0217R.dimen.com_facebook_loginview_padding_right), getResources().getDimensionPixelSize(C0217R.dimen.com_facebook_loginview_padding_bottom));
            setWidth(getResources().getDimensionPixelSize(C0217R.dimen.com_facebook_loginview_width));
            setHeight(getResources().getDimensionPixelSize(C0217R.dimen.com_facebook_loginview_height));
            setGravity(17);
            if (isInEditMode()) {
                setBackgroundColor(getResources().getColor(C0217R.color.com_facebook_blue));
                this.loginText = "Log in";
            } else {
                setBackgroundResource(C0217R.drawable.com_facebook_loginbutton_blue);
            }
        }
        parseAttributes(attributeSet);
        if (isInEditMode()) {
            return;
        }
        initializeActiveSessionWithCachedToken(context);
    }

    public LoginButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.applicationId = null;
        this.user = null;
        this.userInfoSession = null;
        this.properties = new LoginButtonProperties();
        parseAttributes(attributeSet);
        initializeActiveSessionWithCachedToken(context);
    }

    public void fetchUserInfo() {
        if (this.fetchUserInfo) {
            final Session openSession = this.sessionTracker.getOpenSession();
            if (openSession != null) {
                if (openSession != this.userInfoSession) {
                    Request.executeBatchAsync(Request.newMeRequest(openSession, new Request.GraphUserCallback() {
                        @Override
                        public void onCompleted(GraphUser graphUser, Response response) {
                            if (openSession == LoginButton.this.sessionTracker.getOpenSession()) {
                                LoginButton.this.user = graphUser;
                                if (LoginButton.this.userInfoChangedCallback != null) {
                                    LoginButton.this.userInfoChangedCallback.onUserInfoFetched(LoginButton.this.user);
                                }
                            }
                            if (response.getError() != null) {
                                LoginButton.this.handleError(response.getError().getException());
                            }
                        }
                    }));
                    this.userInfoSession = openSession;
                    return;
                }
                return;
            }
            this.user = null;
            if (this.userInfoChangedCallback != null) {
                this.userInfoChangedCallback.onUserInfoFetched(this.user);
            }
        }
    }

    private void finishInit() {
        setOnClickListener(new LoginClickListener());
        setButtonText();
        if (isInEditMode()) {
            return;
        }
        this.sessionTracker = new SessionTracker(getContext(), new LoginButtonCallback(), null, false);
        fetchUserInfo();
    }

    private boolean initializeActiveSessionWithCachedToken(Context context) {
        if (context == null) {
            return false;
        }
        Session activeSession = Session.getActiveSession();
        return activeSession != null ? activeSession.isOpened() : (Utility.getMetadataApplicationId(context) == null || Session.openActiveSessionFromCache(context) == null) ? false : true;
    }

    private void parseAttributes(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C0217R.styleable.com_facebook_login_view);
        this.confirmLogout = obtainStyledAttributes.getBoolean(0, true);
        this.fetchUserInfo = obtainStyledAttributes.getBoolean(1, true);
        this.loginText = obtainStyledAttributes.getString(2);
        this.logoutText = obtainStyledAttributes.getString(3);
        obtainStyledAttributes.recycle();
    }

    public void setButtonText() {
        if (this.sessionTracker == null || this.sessionTracker.getOpenSession() == null) {
            setText(this.loginText != null ? this.loginText : getResources().getString(C0217R.string.com_facebook_loginview_log_in_button));
        } else {
            setText(this.logoutText != null ? this.logoutText : getResources().getString(C0217R.string.com_facebook_loginview_log_out_button));
        }
    }

    public void clearPermissions() {
        this.properties.clearPermissions();
    }

    public SessionDefaultAudience getDefaultAudience() {
        return this.properties.getDefaultAudience();
    }

    public SessionLoginBehavior getLoginBehavior() {
        return this.properties.getLoginBehavior();
    }

    public OnErrorListener getOnErrorListener() {
        return this.properties.getOnErrorListener();
    }

    List<String> getPermissions() {
        return this.properties.getPermissions();
    }

    public Session.StatusCallback getSessionStatusCallback() {
        return this.properties.getSessionStatusCallback();
    }

    public UserInfoChangedCallback getUserInfoChangedCallback() {
        return this.userInfoChangedCallback;
    }

    void handleError(Exception exc) {
        if (this.properties.onErrorListener != null) {
            if (exc instanceof FacebookException) {
                this.properties.onErrorListener.onError((FacebookException) exc);
            } else {
                this.properties.onErrorListener.onError(new FacebookException(exc));
            }
        }
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        Session session = this.sessionTracker.getSession();
        if (session != null) {
            return session.onActivityResult((Activity) getContext(), i, i2, intent);
        }
        return false;
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.sessionTracker == null || this.sessionTracker.isTracking()) {
            return;
        }
        this.sessionTracker.startTracking();
        fetchUserInfo();
        setButtonText();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.sessionTracker != null) {
            this.sessionTracker.stopTracking();
        }
    }

    @Override
    public void onFinishInflate() {
        super.onFinishInflate();
        finishInit();
    }

    public void setApplicationId(String str) {
        this.applicationId = str;
    }

    public void setDefaultAudience(SessionDefaultAudience sessionDefaultAudience) {
        this.properties.setDefaultAudience(sessionDefaultAudience);
    }

    public void setFragment(ComponentCallbacksC0006e componentCallbacksC0006e) {
        this.parentFragment = componentCallbacksC0006e;
    }

    public void setLoginBehavior(SessionLoginBehavior sessionLoginBehavior) {
        this.properties.setLoginBehavior(sessionLoginBehavior);
    }

    public void setOnErrorListener(OnErrorListener onErrorListener) {
        this.properties.setOnErrorListener(onErrorListener);
    }

    void setProperties(LoginButtonProperties loginButtonProperties) {
        this.properties = loginButtonProperties;
    }

    public void setPublishPermissions(List<String> list) {
        this.properties.setPublishPermissions(list, this.sessionTracker.getSession());
    }

    public void setReadPermissions(List<String> list) {
        this.properties.setReadPermissions(list, this.sessionTracker.getSession());
    }

    public void setSession(Session session) {
        this.sessionTracker.setSession(session);
        fetchUserInfo();
        setButtonText();
    }

    public void setSessionStatusCallback(Session.StatusCallback statusCallback) {
        this.properties.setSessionStatusCallback(statusCallback);
    }

    public void setUserInfoChangedCallback(UserInfoChangedCallback userInfoChangedCallback) {
        this.userInfoChangedCallback = userInfoChangedCallback;
    }
}
