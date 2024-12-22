package com.facebook;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import com.facebook.AuthorizationClient;
import com.facebook.android.C0217R;
import com.facebook.internal.SessionAuthorizationType;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import p001a.p004b.p005a.p006a.ComponentCallbacksC0006e;
import p001a.p004b.p005a.p007b.C0029c;

public class Session implements Serializable {
    public static final String ACTION_ACTIVE_SESSION_CLOSED = "com.facebook.sdk.ACTIVE_SESSION_CLOSED";
    public static final String ACTION_ACTIVE_SESSION_OPENED = "com.facebook.sdk.ACTIVE_SESSION_OPENED";
    public static final String ACTION_ACTIVE_SESSION_SET = "com.facebook.sdk.ACTIVE_SESSION_SET";
    public static final String ACTION_ACTIVE_SESSION_UNSET = "com.facebook.sdk.ACTIVE_SESSION_UNSET";
    public static final String APPLICATION_ID_PROPERTY = "com.facebook.sdk.ApplicationId";
    private static final String AUTH_BUNDLE_SAVE_KEY = "com.facebook.sdk.Session.authBundleKey";
    public static final int DEFAULT_AUTHORIZE_ACTIVITY_CODE = 64206;
    private static final String MANAGE_PERMISSION_PREFIX = "manage";
    private static final String PUBLISH_PERMISSION_PREFIX = "publish";
    private static final String SESSION_BUNDLE_SAVE_KEY = "com.facebook.sdk.Session.saveSessionKey";
    private static final int TOKEN_EXTEND_RETRY_SECONDS = 3600;
    private static final int TOKEN_EXTEND_THRESHOLD_SECONDS = 86400;
    public static final String WEB_VIEW_ERROR_CODE_KEY = "com.facebook.sdk.WebViewErrorCode";
    public static final String WEB_VIEW_FAILING_URL_KEY = "com.facebook.sdk.FailingUrl";
    private static Session activeSession = null;
    private static final long serialVersionUID = 1;
    private static volatile Context staticContext;
    private String applicationId;
    private volatile Bundle authorizationBundle;
    private AuthorizationClient authorizationClient;
    private AutoPublishAsyncTask autoPublishAsyncTask;
    private final List<StatusCallback> callbacks;
    private volatile TokenRefreshRequest currentTokenRefreshRequest;
    private Handler handler;
    private Date lastAttemptedTokenExtendDate;
    private final Object lock;
    private AuthorizationRequest pendingRequest;
    private SessionState state;
    private TokenCachingStrategy tokenCachingStrategy;
    private AccessToken tokenInfo;
    public static final String TAG = Session.class.getCanonicalName();
    private static final Object STATIC_LOCK = new Object();
    private static final Set<String> OTHER_PUBLISH_PERMISSIONS = new HashSet<String>() {
        C02011() {
            add("ads_management");
            add("create_event");
            add("rsvp_event");
        }
    };

    final class C02011 extends HashSet<String> {
        C02011() {
            add("ads_management");
            add("create_event");
            add("rsvp_event");
        }
    }

    class C02022 implements AuthorizationClient.OnCompletedListener {
        C02022() {
        }

        @Override
        public void onCompleted(AuthorizationClient.Result result) {
            Session.this.handleAuthorizationResult(result.code == AuthorizationClient.Result.Code.CANCEL ? 0 : -1, result);
        }
    }

    class RunnableC02033 implements Runnable {
        final Exception val$exception;
        final SessionState val$newState;

        class AnonymousClass1 implements Runnable {
            final StatusCallback val$callback;

            AnonymousClass1(StatusCallback statusCallback) {
                r2 = statusCallback;
            }

            @Override
            public void run() {
                r2.call(Session.this, r2, r3);
            }
        }

        RunnableC02033(SessionState sessionState, Exception exc) {
            r2 = sessionState;
            r3 = exc;
        }

        @Override
        public void run() {
            Iterator it = Session.this.callbacks.iterator();
            while (it.hasNext()) {
                Session.runWithHandlerOrExecutor(Session.this.handler, new Runnable() {
                    final StatusCallback val$callback;

                    AnonymousClass1(StatusCallback statusCallback) {
                        r2 = statusCallback;
                    }

                    @Override
                    public void run() {
                        r2.call(Session.this, r2, r3);
                    }
                });
            }
        }
    }

    public class AuthorizationRequest implements Serializable {
        private static final long serialVersionUID = 1;
        private String applicationId;
        private SessionDefaultAudience defaultAudience;
        private boolean isLegacy;
        private SessionLoginBehavior loginBehavior;
        private List<String> permissions;
        private int requestCode;
        private final StartActivityDelegate startActivityDelegate;
        private StatusCallback statusCallback;
        private String validateSameFbidAsToken;

        class C02051 implements StartActivityDelegate {
            final Activity val$activity;

            C02051(Activity activity) {
                r2 = activity;
            }

            @Override
            public Activity getActivityContext() {
                return r2;
            }

            @Override
            public void startActivityForResult(Intent intent, int i) {
                r2.startActivityForResult(intent, i);
            }
        }

        class C02062 implements StartActivityDelegate {
            final ComponentCallbacksC0006e val$fragment;

            C02062(ComponentCallbacksC0006e componentCallbacksC0006e) {
                r2 = componentCallbacksC0006e;
            }

            @Override
            public Activity getActivityContext() {
                return r2.getActivity();
            }

            @Override
            public void startActivityForResult(Intent intent, int i) {
                r2.startActivityForResult(intent, i);
            }
        }

        class C02073 implements StartActivityDelegate {
            C02073() {
            }

            @Override
            public Activity getActivityContext() {
                throw new UnsupportedOperationException("Cannot create an AuthorizationRequest without a valid Activity or Fragment");
            }

            @Override
            public void startActivityForResult(Intent intent, int i) {
                throw new UnsupportedOperationException("Cannot create an AuthorizationRequest without a valid Activity or Fragment");
            }
        }

        class C02084 implements AuthorizationClient.StartActivityDelegate {
            C02084() {
            }

            @Override
            public Activity getActivityContext() {
                return AuthorizationRequest.this.startActivityDelegate.getActivityContext();
            }

            @Override
            public void startActivityForResult(Intent intent, int i) {
                AuthorizationRequest.this.startActivityDelegate.startActivityForResult(intent, i);
            }
        }

        class AuthRequestSerializationProxyV1 implements Serializable {
            private static final long serialVersionUID = -8748347685113614927L;
            private final String applicationId;
            private final String defaultAudience;
            private boolean isLegacy;
            private final SessionLoginBehavior loginBehavior;
            private final List<String> permissions;
            private final int requestCode;
            private final String validateSameFbidAsToken;

            private AuthRequestSerializationProxyV1(SessionLoginBehavior sessionLoginBehavior, int i, List<String> list, String str, boolean z, String str2, String str3) {
                this.loginBehavior = sessionLoginBehavior;
                this.requestCode = i;
                this.permissions = list;
                this.defaultAudience = str;
                this.isLegacy = z;
                this.applicationId = str2;
                this.validateSameFbidAsToken = str3;
            }

            AuthRequestSerializationProxyV1(SessionLoginBehavior sessionLoginBehavior, int i, List list, String str, boolean z, String str2, String str3, C02011 c02011) {
                this(sessionLoginBehavior, i, list, str, z, str2, str3);
            }

            private Object readResolve() {
                return new AuthorizationRequest(this.loginBehavior, this.requestCode, this.permissions, this.defaultAudience, this.isLegacy, this.applicationId, this.validateSameFbidAsToken);
            }
        }

        AuthorizationRequest(ComponentCallbacksC0006e componentCallbacksC0006e) {
            this.loginBehavior = SessionLoginBehavior.SSO_WITH_FALLBACK;
            this.requestCode = Session.DEFAULT_AUTHORIZE_ACTIVITY_CODE;
            this.isLegacy = false;
            this.permissions = Collections.emptyList();
            this.defaultAudience = SessionDefaultAudience.FRIENDS;
            this.startActivityDelegate = new StartActivityDelegate() {
                final ComponentCallbacksC0006e val$fragment;

                C02062(ComponentCallbacksC0006e componentCallbacksC0006e2) {
                    r2 = componentCallbacksC0006e2;
                }

                @Override
                public Activity getActivityContext() {
                    return r2.getActivity();
                }

                @Override
                public void startActivityForResult(Intent intent, int i) {
                    r2.startActivityForResult(intent, i);
                }
            };
        }

        AuthorizationRequest(Activity activity) {
            this.loginBehavior = SessionLoginBehavior.SSO_WITH_FALLBACK;
            this.requestCode = Session.DEFAULT_AUTHORIZE_ACTIVITY_CODE;
            this.isLegacy = false;
            this.permissions = Collections.emptyList();
            this.defaultAudience = SessionDefaultAudience.FRIENDS;
            this.startActivityDelegate = new StartActivityDelegate() {
                final Activity val$activity;

                C02051(Activity activity2) {
                    r2 = activity2;
                }

                @Override
                public Activity getActivityContext() {
                    return r2;
                }

                @Override
                public void startActivityForResult(Intent intent, int i) {
                    r2.startActivityForResult(intent, i);
                }
            };
        }

        private AuthorizationRequest(SessionLoginBehavior sessionLoginBehavior, int i, List<String> list, String str, boolean z, String str2, String str3) {
            this.loginBehavior = SessionLoginBehavior.SSO_WITH_FALLBACK;
            this.requestCode = Session.DEFAULT_AUTHORIZE_ACTIVITY_CODE;
            this.isLegacy = false;
            this.permissions = Collections.emptyList();
            this.defaultAudience = SessionDefaultAudience.FRIENDS;
            this.startActivityDelegate = new StartActivityDelegate() {
                C02073() {
                }

                @Override
                public Activity getActivityContext() {
                    throw new UnsupportedOperationException("Cannot create an AuthorizationRequest without a valid Activity or Fragment");
                }

                @Override
                public void startActivityForResult(Intent intent, int i2) {
                    throw new UnsupportedOperationException("Cannot create an AuthorizationRequest without a valid Activity or Fragment");
                }
            };
            this.loginBehavior = sessionLoginBehavior;
            this.requestCode = i;
            this.permissions = list;
            this.defaultAudience = SessionDefaultAudience.valueOf(str);
            this.isLegacy = z;
            this.applicationId = str2;
            this.validateSameFbidAsToken = str3;
        }

        AuthorizationRequest(SessionLoginBehavior sessionLoginBehavior, int i, List list, String str, boolean z, String str2, String str3, C02011 c02011) {
            this(sessionLoginBehavior, i, list, str, z, str2, str3);
        }

        String getApplicationId() {
            return this.applicationId;
        }

        AuthorizationClient.AuthorizationRequest getAuthorizationClientRequest() {
            return new AuthorizationClient.AuthorizationRequest(this.loginBehavior, this.requestCode, this.isLegacy, this.permissions, this.defaultAudience, this.applicationId, this.validateSameFbidAsToken, new AuthorizationClient.StartActivityDelegate() {
                C02084() {
                }

                @Override
                public Activity getActivityContext() {
                    return AuthorizationRequest.this.startActivityDelegate.getActivityContext();
                }

                @Override
                public void startActivityForResult(Intent intent, int i) {
                    AuthorizationRequest.this.startActivityDelegate.startActivityForResult(intent, i);
                }
            });
        }

        StatusCallback getCallback() {
            return this.statusCallback;
        }

        SessionDefaultAudience getDefaultAudience() {
            return this.defaultAudience;
        }

        SessionLoginBehavior getLoginBehavior() {
            return this.loginBehavior;
        }

        List<String> getPermissions() {
            return this.permissions;
        }

        int getRequestCode() {
            return this.requestCode;
        }

        StartActivityDelegate getStartActivityDelegate() {
            return this.startActivityDelegate;
        }

        String getValidateSameFbidAsToken() {
            return this.validateSameFbidAsToken;
        }

        boolean isLegacy() {
            return this.isLegacy;
        }

        void readObject(ObjectInputStream objectInputStream) {
            throw new InvalidObjectException("Cannot readObject, serialization proxy required");
        }

        void setApplicationId(String str) {
            this.applicationId = str;
        }

        AuthorizationRequest setCallback(StatusCallback statusCallback) {
            this.statusCallback = statusCallback;
            return this;
        }

        AuthorizationRequest setDefaultAudience(SessionDefaultAudience sessionDefaultAudience) {
            if (sessionDefaultAudience != null) {
                this.defaultAudience = sessionDefaultAudience;
            }
            return this;
        }

        public void setIsLegacy(boolean z) {
            this.isLegacy = z;
        }

        AuthorizationRequest setLoginBehavior(SessionLoginBehavior sessionLoginBehavior) {
            if (sessionLoginBehavior != null) {
                this.loginBehavior = sessionLoginBehavior;
            }
            return this;
        }

        AuthorizationRequest setPermissions(List<String> list) {
            if (list != null) {
                this.permissions = list;
            }
            return this;
        }

        AuthorizationRequest setRequestCode(int i) {
            if (i >= 0) {
                this.requestCode = i;
            }
            return this;
        }

        void setValidateSameFbidAsToken(String str) {
            this.validateSameFbidAsToken = str;
        }

        Object writeReplace() {
            return new AuthRequestSerializationProxyV1(this.loginBehavior, this.requestCode, this.permissions, this.defaultAudience.name(), this.isLegacy, this.applicationId, this.validateSameFbidAsToken);
        }
    }

    class AutoPublishAsyncTask extends AsyncTask<Void, Void, Void> {
        private final Context mApplicationContext;
        private final String mApplicationId;

        public AutoPublishAsyncTask(String str, Context context) {
            this.mApplicationId = str;
            this.mApplicationContext = context.getApplicationContext();
        }

        @Override
        protected Void doInBackground(Void... voidArr) {
            try {
                Settings.publishInstallAndWait(this.mApplicationContext, this.mApplicationId);
                return null;
            } catch (Exception e) {
                Utility.logd("Facebook-publish", e);
                return null;
            }
        }

        @Override
        protected void onPostExecute(Void r4) {
            synchronized (Session.this) {
                Session.this.autoPublishAsyncTask = null;
            }
        }
    }

    public final class Builder {
        private String applicationId;
        private final Context context;
        private TokenCachingStrategy tokenCachingStrategy;

        public Builder(Context context) {
            this.context = context;
        }

        public final Session build() {
            return new Session(this.context, this.applicationId, this.tokenCachingStrategy);
        }

        public final Builder setApplicationId(String str) {
            this.applicationId = str;
            return this;
        }

        public final Builder setTokenCachingStrategy(TokenCachingStrategy tokenCachingStrategy) {
            this.tokenCachingStrategy = tokenCachingStrategy;
            return this;
        }
    }

    public final class NewPermissionsRequest extends AuthorizationRequest {
        private static final long serialVersionUID = 1;

        public NewPermissionsRequest(ComponentCallbacksC0006e componentCallbacksC0006e, List<String> list) {
            super(componentCallbacksC0006e);
            setPermissions(list);
        }

        public NewPermissionsRequest(Activity activity, List<String> list) {
            super(activity);
            setPermissions(list);
        }

        @Override
        public final NewPermissionsRequest setCallback(StatusCallback statusCallback) {
            super.setCallback(statusCallback);
            return this;
        }

        @Override
        public final NewPermissionsRequest setDefaultAudience(SessionDefaultAudience sessionDefaultAudience) {
            super.setDefaultAudience(sessionDefaultAudience);
            return this;
        }

        @Override
        public final NewPermissionsRequest setLoginBehavior(SessionLoginBehavior sessionLoginBehavior) {
            super.setLoginBehavior(sessionLoginBehavior);
            return this;
        }

        @Override
        public final NewPermissionsRequest setRequestCode(int i) {
            super.setRequestCode(i);
            return this;
        }
    }

    public final class OpenRequest extends AuthorizationRequest {
        private static final long serialVersionUID = 1;

        public OpenRequest(ComponentCallbacksC0006e componentCallbacksC0006e) {
            super(componentCallbacksC0006e);
        }

        public OpenRequest(Activity activity) {
            super(activity);
        }

        @Override
        public final OpenRequest setCallback(StatusCallback statusCallback) {
            super.setCallback(statusCallback);
            return this;
        }

        @Override
        public final OpenRequest setDefaultAudience(SessionDefaultAudience sessionDefaultAudience) {
            super.setDefaultAudience(sessionDefaultAudience);
            return this;
        }

        @Override
        public final OpenRequest setLoginBehavior(SessionLoginBehavior sessionLoginBehavior) {
            super.setLoginBehavior(sessionLoginBehavior);
            return this;
        }

        @Override
        public final AuthorizationRequest setPermissions(List list) {
            return setPermissions((List<String>) list);
        }

        @Override
        public final OpenRequest setPermissions(List<String> list) {
            super.setPermissions(list);
            return this;
        }

        @Override
        public final OpenRequest setRequestCode(int i) {
            super.setRequestCode(i);
            return this;
        }
    }

    class SerializationProxyV1 implements Serializable {
        private static final long serialVersionUID = 7663436173185080063L;
        private final String applicationId;
        private final Date lastAttemptedTokenExtendDate;
        private final AuthorizationRequest pendingRequest;
        private final boolean shouldAutoPublish;
        private final SessionState state;
        private final AccessToken tokenInfo;

        SerializationProxyV1(String str, SessionState sessionState, AccessToken accessToken, Date date, boolean z, AuthorizationRequest authorizationRequest) {
            this.applicationId = str;
            this.state = sessionState;
            this.tokenInfo = accessToken;
            this.lastAttemptedTokenExtendDate = date;
            this.shouldAutoPublish = z;
            this.pendingRequest = authorizationRequest;
        }

        private Object readResolve() {
            return new Session(this.applicationId, this.state, this.tokenInfo, this.lastAttemptedTokenExtendDate, this.shouldAutoPublish, this.pendingRequest);
        }
    }

    interface StartActivityDelegate {
        Activity getActivityContext();

        void startActivityForResult(Intent intent, int i);
    }

    public interface StatusCallback {
        void call(Session session, SessionState sessionState, Exception exc);
    }

    class TokenRefreshRequest implements ServiceConnection {
        final Messenger messageReceiver;
        Messenger messageSender = null;

        TokenRefreshRequest() {
            this.messageReceiver = new Messenger(new TokenRefreshRequestHandler(Session.this, this));
        }

        public void cleanup() {
            if (Session.this.currentTokenRefreshRequest == this) {
                Session.this.currentTokenRefreshRequest = null;
            }
        }

        private void refreshToken() {
            Bundle bundle = new Bundle();
            bundle.putString("access_token", Session.this.getTokenInfo().getToken());
            Message obtain = Message.obtain();
            obtain.setData(bundle);
            obtain.replyTo = this.messageReceiver;
            try {
                this.messageSender.send(obtain);
            } catch (RemoteException e) {
                cleanup();
            }
        }

        public void bind() {
            Intent createTokenRefreshIntent = NativeProtocol.createTokenRefreshIntent(Session.getStaticContext());
            if (createTokenRefreshIntent == null || !Session.staticContext.bindService(createTokenRefreshIntent, Session.this.new TokenRefreshRequest(), 1)) {
                cleanup();
            } else {
                Session.this.setLastAttemptedTokenExtendDate(new Date());
            }
        }

        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            this.messageSender = new Messenger(iBinder);
            refreshToken();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            cleanup();
            Session.staticContext.unbindService(this);
        }
    }

    class TokenRefreshRequestHandler extends Handler {
        private WeakReference<TokenRefreshRequest> refreshRequestWeakReference;
        private WeakReference<Session> sessionWeakReference;

        TokenRefreshRequestHandler(Session session, TokenRefreshRequest tokenRefreshRequest) {
            super(Looper.getMainLooper());
            this.sessionWeakReference = new WeakReference<>(session);
            this.refreshRequestWeakReference = new WeakReference<>(tokenRefreshRequest);
        }

        @Override
        public void handleMessage(Message message) {
            String string = message.getData().getString("access_token");
            Session session = this.sessionWeakReference.get();
            if (session != null && string != null) {
                session.extendTokenCompleted(message.getData());
            }
            TokenRefreshRequest tokenRefreshRequest = this.refreshRequestWeakReference.get();
            if (tokenRefreshRequest != null) {
                Session.staticContext.unbindService(tokenRefreshRequest);
                tokenRefreshRequest.cleanup();
            }
        }
    }

    public Session(Context context) {
        this(context, null, null, true);
    }

    Session(Context context, String str, TokenCachingStrategy tokenCachingStrategy) {
        this(context, str, tokenCachingStrategy, true);
    }

    Session(Context context, String str, TokenCachingStrategy tokenCachingStrategy, boolean z) {
        this.lastAttemptedTokenExtendDate = new Date(0L);
        this.lock = new Object();
        if (context != null && str == null) {
            str = Utility.getMetadataApplicationId(context);
        }
        Validate.notNull(str, "applicationId");
        initializeStaticContext(context);
        tokenCachingStrategy = tokenCachingStrategy == null ? new SharedPreferencesTokenCachingStrategy(staticContext) : tokenCachingStrategy;
        this.applicationId = str;
        this.tokenCachingStrategy = tokenCachingStrategy;
        this.state = SessionState.CREATED;
        this.pendingRequest = null;
        this.callbacks = new ArrayList();
        this.handler = new Handler(Looper.getMainLooper());
        Bundle load = z ? tokenCachingStrategy.load() : null;
        if (!TokenCachingStrategy.hasTokenInformation(load)) {
            this.tokenInfo = AccessToken.createEmptyToken(Collections.emptyList());
            return;
        }
        Date date = TokenCachingStrategy.getDate(load, TokenCachingStrategy.EXPIRATION_DATE_KEY);
        Date date2 = new Date();
        if (date == null || date.before(date2)) {
            tokenCachingStrategy.clear();
            this.tokenInfo = AccessToken.createEmptyToken(Collections.emptyList());
        } else {
            this.tokenInfo = AccessToken.createFromCache(load);
            this.state = SessionState.CREATED_TOKEN_LOADED;
        }
    }

    private Session(String str, SessionState sessionState, AccessToken accessToken, Date date, boolean z, AuthorizationRequest authorizationRequest) {
        this.lastAttemptedTokenExtendDate = new Date(0L);
        this.lock = new Object();
        this.applicationId = str;
        this.state = sessionState;
        this.tokenInfo = accessToken;
        this.lastAttemptedTokenExtendDate = date;
        this.pendingRequest = authorizationRequest;
        this.handler = new Handler(Looper.getMainLooper());
        this.currentTokenRefreshRequest = null;
        this.tokenCachingStrategy = null;
        this.callbacks = new ArrayList();
    }

    Session(String str, SessionState sessionState, AccessToken accessToken, Date date, boolean z, AuthorizationRequest authorizationRequest, C02011 c02011) {
        this(str, sessionState, accessToken, date, z, authorizationRequest);
    }

    private static boolean areEqual(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    private void autoPublishAsync() {
        String str;
        AutoPublishAsyncTask autoPublishAsyncTask = null;
        synchronized (this) {
            if (this.autoPublishAsyncTask == null && Settings.getShouldAutoPublishInstall() && (str = this.applicationId) != null) {
                autoPublishAsyncTask = new AutoPublishAsyncTask(str, staticContext);
                this.autoPublishAsyncTask = autoPublishAsyncTask;
            }
        }
        if (autoPublishAsyncTask != null) {
            autoPublishAsyncTask.execute(new Void[0]);
        }
    }

    private void finishAuthorization(AccessToken accessToken, Exception exc) {
        SessionState sessionState = this.state;
        if (accessToken != null) {
            this.tokenInfo = accessToken;
            saveTokenToCache(accessToken);
            this.state = SessionState.OPENED;
        } else if (exc != null) {
            this.state = SessionState.CLOSED_LOGIN_FAILED;
        }
        this.pendingRequest = null;
        postStateChange(sessionState, this.state, exc);
    }

    private void finishReauthorization(AccessToken accessToken, Exception exc) {
        SessionState sessionState = this.state;
        if (accessToken != null) {
            this.tokenInfo = accessToken;
            saveTokenToCache(accessToken);
            this.state = SessionState.OPENED_TOKEN_UPDATED;
        }
        this.pendingRequest = null;
        postStateChange(sessionState, this.state, exc);
    }

    public static final Session getActiveSession() {
        Session session;
        synchronized (STATIC_LOCK) {
            session = activeSession;
        }
        return session;
    }

    private Intent getLoginActivityIntent(AuthorizationRequest authorizationRequest) {
        Intent intent = new Intent();
        intent.setClass(getStaticContext(), LoginActivity.class);
        intent.setAction(authorizationRequest.getLoginBehavior().toString());
        intent.putExtras(LoginActivity.populateIntentExtras(authorizationRequest.getAuthorizationClientRequest()));
        return intent;
    }

    static Context getStaticContext() {
        return staticContext;
    }

    public void handleAuthorizationResult(int i, AuthorizationClient.Result result) {
        Exception exc;
        AccessToken accessToken;
        if (i == -1) {
            if (result.code == AuthorizationClient.Result.Code.SUCCESS) {
                accessToken = result.token;
                exc = null;
            } else {
                exc = new FacebookAuthorizationException(result.errorMessage);
                accessToken = null;
            }
        } else if (i == 0) {
            exc = new FacebookOperationCanceledException(result.errorMessage);
            accessToken = null;
        } else {
            exc = null;
            accessToken = null;
        }
        this.authorizationClient = null;
        finishAuthOrReauth(accessToken, exc);
    }

    static void initializeStaticContext(Context context) {
        if (context == null || staticContext != null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        staticContext = context;
    }

    static boolean isPublishPermission(String str) {
        return str != null && (str.startsWith(PUBLISH_PERMISSION_PREFIX) || str.startsWith(MANAGE_PERMISSION_PREFIX) || OTHER_PUBLISH_PERMISSIONS.contains(str));
    }

    private void open(OpenRequest openRequest, SessionAuthorizationType sessionAuthorizationType) {
        SessionState sessionState;
        validatePermissions(openRequest, sessionAuthorizationType);
        validateLoginBehavior(openRequest);
        synchronized (this.lock) {
            if (this.pendingRequest != null) {
                postStateChange(this.state, this.state, new UnsupportedOperationException("Session: an attempt was made to open a session that has a pending request."));
                return;
            }
            SessionState sessionState2 = this.state;
            switch (this.state) {
                case CREATED:
                    sessionState = SessionState.OPENING;
                    this.state = sessionState;
                    if (openRequest != null) {
                        this.pendingRequest = openRequest;
                        break;
                    } else {
                        throw new IllegalArgumentException("openRequest cannot be null when opening a new Session");
                    }
                case OPENING:
                default:
                    throw new UnsupportedOperationException("Session: an attempt was made to open an already opened session.");
                case CREATED_TOKEN_LOADED:
                    if (openRequest != null && !Utility.isNullOrEmpty(openRequest.getPermissions()) && !Utility.isSubset(openRequest.getPermissions(), getPermissions())) {
                        this.pendingRequest = openRequest;
                    }
                    if (this.pendingRequest != null) {
                        sessionState = SessionState.OPENING;
                        this.state = sessionState;
                        break;
                    } else {
                        sessionState = SessionState.OPENED;
                        this.state = sessionState;
                        break;
                    }
                    break;
            }
            if (openRequest != null) {
                addCallback(openRequest.getCallback());
            }
            postStateChange(sessionState2, sessionState, null);
            if (sessionState == SessionState.OPENING) {
                authorize(openRequest);
            }
        }
    }

    public static Session openActiveSession(Activity activity, boolean z, StatusCallback statusCallback) {
        return openActiveSession(activity, z, new OpenRequest(activity).setCallback(statusCallback));
    }

    public static Session openActiveSession(Context context, ComponentCallbacksC0006e componentCallbacksC0006e, boolean z, StatusCallback statusCallback) {
        return openActiveSession(context, z, new OpenRequest(componentCallbacksC0006e).setCallback(statusCallback));
    }

    private static Session openActiveSession(Context context, boolean z, OpenRequest openRequest) {
        Session build = new Builder(context).build();
        if (!SessionState.CREATED_TOKEN_LOADED.equals(build.getState()) && !z) {
            return null;
        }
        setActiveSession(build);
        build.openForRead(openRequest);
        return build;
    }

    public static Session openActiveSessionFromCache(Context context) {
        return openActiveSession(context, false, (OpenRequest) null);
    }

    public static Session openActiveSessionWithAccessToken(Context context, AccessToken accessToken, StatusCallback statusCallback) {
        Session session = new Session(context, null, null, false);
        setActiveSession(session);
        session.open(accessToken, statusCallback);
        return session;
    }

    static void postActiveSessionAction(String str) {
        C0029c.m101c(getStaticContext()).m103a(new Intent(str));
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Cannot readObject, serialization proxy required");
    }

    private void requestNewPermissions(NewPermissionsRequest newPermissionsRequest, SessionAuthorizationType sessionAuthorizationType) {
        validatePermissions(newPermissionsRequest, sessionAuthorizationType);
        validateLoginBehavior(newPermissionsRequest);
        if (newPermissionsRequest != null) {
            synchronized (this.lock) {
                if (this.pendingRequest != null) {
                    throw new UnsupportedOperationException("Session: an attempt was made to request new permissions for a session that has a pending request.");
                }
                switch (C02044.$SwitchMap$com$facebook$SessionState[this.state.ordinal()]) {
                    case C0217R.styleable.com_facebook_picker_fragment_done_button_text:
                    case C0217R.styleable.com_facebook_picker_fragment_title_bar_background:
                        this.pendingRequest = newPermissionsRequest;
                        break;
                    default:
                        throw new UnsupportedOperationException("Session: an attempt was made to request new permissions for a session that is not currently open.");
                }
            }
            newPermissionsRequest.setValidateSameFbidAsToken(getAccessToken());
            authorize(newPermissionsRequest);
        }
    }

    private boolean resolveIntent(Intent intent) {
        return getStaticContext().getPackageManager().resolveActivity(intent, 0) != null;
    }

    public static final Session restoreSession(Context context, TokenCachingStrategy tokenCachingStrategy, StatusCallback statusCallback, Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        byte[] byteArray = bundle.getByteArray(SESSION_BUNDLE_SAVE_KEY);
        if (byteArray != null) {
            try {
                Session session = (Session) new ObjectInputStream(new ByteArrayInputStream(byteArray)).readObject();
                initializeStaticContext(context);
                if (tokenCachingStrategy != null) {
                    session.tokenCachingStrategy = tokenCachingStrategy;
                } else {
                    session.tokenCachingStrategy = new SharedPreferencesTokenCachingStrategy(context);
                }
                if (statusCallback != null) {
                    session.addCallback(statusCallback);
                }
                session.authorizationBundle = bundle.getBundle(AUTH_BUNDLE_SAVE_KEY);
                return session;
            } catch (IOException e) {
                Log.w(TAG, "Unable to restore session.", e);
            } catch (ClassNotFoundException e2) {
                Log.w(TAG, "Unable to restore session", e2);
            }
        }
        return null;
    }

    public static void runWithHandlerOrExecutor(Handler handler, Runnable runnable) {
        if (handler != null) {
            handler.post(runnable);
        } else {
            Settings.getExecutor().execute(runnable);
        }
    }

    public static final void saveSession(Session session, Bundle bundle) {
        if (bundle == null || session == null || bundle.containsKey(SESSION_BUNDLE_SAVE_KEY)) {
            return;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            new ObjectOutputStream(byteArrayOutputStream).writeObject(session);
            bundle.putByteArray(SESSION_BUNDLE_SAVE_KEY, byteArrayOutputStream.toByteArray());
            bundle.putBundle(AUTH_BUNDLE_SAVE_KEY, session.authorizationBundle);
        } catch (IOException e) {
            throw new FacebookException("Unable to save session.", e);
        }
    }

    private void saveTokenToCache(AccessToken accessToken) {
        if (accessToken == null || this.tokenCachingStrategy == null) {
            return;
        }
        this.tokenCachingStrategy.save(accessToken.toCacheBundle());
    }

    public static final void setActiveSession(Session session) {
        synchronized (STATIC_LOCK) {
            if (session != activeSession) {
                Session session2 = activeSession;
                if (session2 != null) {
                    session2.close();
                }
                activeSession = session;
                if (session2 != null) {
                    postActiveSessionAction(ACTION_ACTIVE_SESSION_UNSET);
                }
                if (session != null) {
                    postActiveSessionAction(ACTION_ACTIVE_SESSION_SET);
                    if (session.isOpened()) {
                        postActiveSessionAction(ACTION_ACTIVE_SESSION_OPENED);
                    }
                }
            }
        }
    }

    private boolean tryLegacyAuth(AuthorizationRequest authorizationRequest) {
        this.authorizationClient = new AuthorizationClient();
        this.authorizationClient.setOnCompletedListener(new AuthorizationClient.OnCompletedListener() {
            C02022() {
            }

            @Override
            public void onCompleted(AuthorizationClient.Result result) {
                Session.this.handleAuthorizationResult(result.code == AuthorizationClient.Result.Code.CANCEL ? 0 : -1, result);
            }
        });
        this.authorizationClient.setContext(getStaticContext());
        this.authorizationClient.startOrContinueAuth(authorizationRequest.getAuthorizationClientRequest());
        return true;
    }

    private boolean tryLoginActivity(AuthorizationRequest authorizationRequest) {
        Intent loginActivityIntent = getLoginActivityIntent(authorizationRequest);
        if (!resolveIntent(loginActivityIntent)) {
            return false;
        }
        try {
            authorizationRequest.getStartActivityDelegate().startActivityForResult(loginActivityIntent, authorizationRequest.getRequestCode());
            return true;
        } catch (ActivityNotFoundException e) {
            return false;
        }
    }

    private void validateLoginBehavior(AuthorizationRequest authorizationRequest) {
        if (authorizationRequest == null || authorizationRequest.isLegacy) {
            return;
        }
        Intent intent = new Intent();
        intent.setClass(getStaticContext(), LoginActivity.class);
        if (!resolveIntent(intent)) {
            throw new FacebookException(String.format("Cannot use SessionLoginBehavior %s when %s is not declared as an activity in AndroidManifest.xml", authorizationRequest.getLoginBehavior(), LoginActivity.class.getName()));
        }
    }

    private void validatePermissions(AuthorizationRequest authorizationRequest, SessionAuthorizationType sessionAuthorizationType) {
        if (authorizationRequest == null || Utility.isNullOrEmpty(authorizationRequest.getPermissions())) {
            if (SessionAuthorizationType.PUBLISH.equals(sessionAuthorizationType)) {
                throw new FacebookException("Cannot request publish or manage authorization with no permissions.");
            }
            return;
        }
        for (String str : authorizationRequest.getPermissions()) {
            if (isPublishPermission(str)) {
                if (SessionAuthorizationType.READ.equals(sessionAuthorizationType)) {
                    throw new FacebookException(String.format("Cannot pass a publish or manage permission (%s) to a request for read authorization", str));
                }
            } else if (SessionAuthorizationType.PUBLISH.equals(sessionAuthorizationType)) {
                Log.w(TAG, String.format("Should not pass a read permission (%s) to a request for publish or manage authorization", str));
            }
        }
    }

    private Object writeReplace() {
        return new SerializationProxyV1(this.applicationId, this.state, this.tokenInfo, this.lastAttemptedTokenExtendDate, false, this.pendingRequest);
    }

    public final void addCallback(StatusCallback statusCallback) {
        synchronized (this.callbacks) {
            if (statusCallback != null) {
                if (!this.callbacks.contains(statusCallback)) {
                    this.callbacks.add(statusCallback);
                }
            }
        }
    }

    void authorize(AuthorizationRequest authorizationRequest) {
        authorizationRequest.setApplicationId(this.applicationId);
        autoPublishAsync();
        boolean tryLoginActivity = tryLoginActivity(authorizationRequest);
        if (!tryLoginActivity && authorizationRequest.isLegacy) {
            tryLoginActivity = tryLegacyAuth(authorizationRequest);
        }
        if (tryLoginActivity) {
            return;
        }
        synchronized (this.lock) {
            SessionState sessionState = this.state;
            switch (C02044.$SwitchMap$com$facebook$SessionState[this.state.ordinal()]) {
                case C0217R.styleable.com_facebook_picker_fragment_done_button_background:
                case 7:
                    break;
                default:
                    this.state = SessionState.CLOSED_LOGIN_FAILED;
                    postStateChange(sessionState, this.state, new FacebookException("Log in attempt failed."));
                    break;
            }
        }
    }

    public final void close() {
        synchronized (this.lock) {
            SessionState sessionState = this.state;
            switch (C02044.$SwitchMap$com$facebook$SessionState[this.state.ordinal()]) {
                case 1:
                case 2:
                    this.state = SessionState.CLOSED_LOGIN_FAILED;
                    postStateChange(sessionState, this.state, new FacebookException("Log in attempt aborted."));
                    break;
                case 3:
                case C0217R.styleable.com_facebook_picker_fragment_done_button_text:
                case C0217R.styleable.com_facebook_picker_fragment_title_bar_background:
                    this.state = SessionState.CLOSED;
                    postStateChange(sessionState, this.state, null);
                    break;
            }
        }
    }

    public final void closeAndClearTokenInformation() {
        if (this.tokenCachingStrategy != null) {
            this.tokenCachingStrategy.clear();
        }
        Utility.clearFacebookCookies(staticContext);
        close();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Session)) {
            return false;
        }
        Session session = (Session) obj;
        return areEqual(session.applicationId, this.applicationId) && areEqual(session.authorizationBundle, this.authorizationBundle) && areEqual(session.state, this.state) && areEqual(session.getExpirationDate(), getExpirationDate());
    }

    void extendAccessToken() {
        TokenRefreshRequest tokenRefreshRequest = null;
        synchronized (this.lock) {
            if (this.currentTokenRefreshRequest == null) {
                tokenRefreshRequest = new TokenRefreshRequest();
                this.currentTokenRefreshRequest = tokenRefreshRequest;
            }
        }
        if (tokenRefreshRequest != null) {
            tokenRefreshRequest.bind();
        }
    }

    void extendAccessTokenIfNeeded() {
        if (shouldExtendAccessToken()) {
            extendAccessToken();
        }
    }

    void extendTokenCompleted(Bundle bundle) {
        synchronized (this.lock) {
            SessionState sessionState = this.state;
            switch (C02044.$SwitchMap$com$facebook$SessionState[this.state.ordinal()]) {
                case C0217R.styleable.com_facebook_picker_fragment_done_button_text:
                    this.state = SessionState.OPENED_TOKEN_UPDATED;
                    postStateChange(sessionState, this.state, null);
                    break;
                case C0217R.styleable.com_facebook_picker_fragment_title_bar_background:
                    break;
                default:
                    Log.d(TAG, "refreshToken ignored in state " + this.state);
                    return;
            }
            this.tokenInfo = AccessToken.createFromRefresh(this.tokenInfo, bundle);
            if (this.tokenCachingStrategy != null) {
                this.tokenCachingStrategy.save(this.tokenInfo.toCacheBundle());
            }
        }
    }

    void finishAuthOrReauth(AccessToken accessToken, Exception exc) {
        if (accessToken != null && accessToken.isInvalid()) {
            accessToken = null;
            exc = new FacebookException("Invalid access token.");
        }
        synchronized (this.lock) {
            switch (C02044.$SwitchMap$com$facebook$SessionState[this.state.ordinal()]) {
                case 2:
                    finishAuthorization(accessToken, exc);
                    break;
                case C0217R.styleable.com_facebook_picker_fragment_done_button_text:
                case C0217R.styleable.com_facebook_picker_fragment_title_bar_background:
                    finishReauthorization(accessToken, exc);
                    break;
            }
        }
    }

    public final String getAccessToken() {
        String token;
        synchronized (this.lock) {
            token = this.tokenInfo == null ? null : this.tokenInfo.getToken();
        }
        return token;
    }

    public final String getApplicationId() {
        return this.applicationId;
    }

    public final Bundle getAuthorizationBundle() {
        Bundle bundle;
        synchronized (this.lock) {
            bundle = this.authorizationBundle;
        }
        return bundle;
    }

    public final Date getExpirationDate() {
        Date expires;
        synchronized (this.lock) {
            expires = this.tokenInfo == null ? null : this.tokenInfo.getExpires();
        }
        return expires;
    }

    Date getLastAttemptedTokenExtendDate() {
        return this.lastAttemptedTokenExtendDate;
    }

    public final List<String> getPermissions() {
        List<String> permissions;
        synchronized (this.lock) {
            permissions = this.tokenInfo == null ? null : this.tokenInfo.getPermissions();
        }
        return permissions;
    }

    public final SessionState getState() {
        SessionState sessionState;
        synchronized (this.lock) {
            sessionState = this.state;
        }
        return sessionState;
    }

    AccessToken getTokenInfo() {
        return this.tokenInfo;
    }

    public int hashCode() {
        return 0;
    }

    public final boolean isClosed() {
        boolean isClosed;
        synchronized (this.lock) {
            isClosed = this.state.isClosed();
        }
        return isClosed;
    }

    public final boolean isOpened() {
        boolean isOpened;
        synchronized (this.lock) {
            isOpened = this.state.isOpened();
        }
        return isOpened;
    }

    public final boolean onActivityResult(Activity activity, int i, int i2, Intent intent) {
        FacebookOperationCanceledException facebookOperationCanceledException;
        Validate.notNull(activity, "currentActivity");
        initializeStaticContext(activity);
        synchronized (this.lock) {
            if (this.pendingRequest == null || i != this.pendingRequest.getRequestCode()) {
                return false;
            }
            if (intent != null) {
                AuthorizationClient.Result result = (AuthorizationClient.Result) intent.getSerializableExtra("com.facebook.LoginActivity:Result");
                if (result != null) {
                    handleAuthorizationResult(i2, result);
                    return true;
                }
                if (this.authorizationClient != null) {
                    this.authorizationClient.onActivityResult(i, i2, intent);
                    return true;
                }
                facebookOperationCanceledException = null;
            } else {
                facebookOperationCanceledException = i2 == 0 ? new FacebookOperationCanceledException("User canceled operation.") : null;
            }
            finishAuthOrReauth(null, facebookOperationCanceledException);
            return true;
        }
    }

    public final void open(AccessToken accessToken, StatusCallback statusCallback) {
        synchronized (this.lock) {
            if (this.pendingRequest != null) {
                throw new UnsupportedOperationException("Session: an attempt was made to open a session that has a pending request.");
            }
            if (this.state != SessionState.CREATED && this.state != SessionState.CREATED_TOKEN_LOADED) {
                throw new UnsupportedOperationException("Session: an attempt was made to open an already opened session.");
            }
            if (statusCallback != null) {
                addCallback(statusCallback);
            }
            this.tokenInfo = accessToken;
            if (this.tokenCachingStrategy != null) {
                this.tokenCachingStrategy.save(accessToken.toCacheBundle());
            }
            SessionState sessionState = this.state;
            this.state = SessionState.OPENED;
            postStateChange(sessionState, this.state, null);
        }
        autoPublishAsync();
    }

    public final void openForPublish(OpenRequest openRequest) {
        open(openRequest, SessionAuthorizationType.PUBLISH);
    }

    public final void openForRead(OpenRequest openRequest) {
        open(openRequest, SessionAuthorizationType.READ);
    }

    void postStateChange(SessionState sessionState, SessionState sessionState2, Exception exc) {
        if (sessionState == sessionState2 && sessionState != SessionState.OPENED_TOKEN_UPDATED && exc == null) {
            return;
        }
        if (sessionState2.isClosed()) {
            this.tokenInfo = AccessToken.createEmptyToken(Collections.emptyList());
        }
        synchronized (this.callbacks) {
            runWithHandlerOrExecutor(this.handler, new Runnable() {
                final Exception val$exception;
                final SessionState val$newState;

                class AnonymousClass1 implements Runnable {
                    final StatusCallback val$callback;

                    AnonymousClass1(StatusCallback statusCallback) {
                        r2 = statusCallback;
                    }

                    @Override
                    public void run() {
                        r2.call(Session.this, r2, r3);
                    }
                }

                RunnableC02033(SessionState sessionState22, Exception exc2) {
                    r2 = sessionState22;
                    r3 = exc2;
                }

                @Override
                public void run() {
                    Iterator it = Session.this.callbacks.iterator();
                    while (it.hasNext()) {
                        Session.runWithHandlerOrExecutor(Session.this.handler, new Runnable() {
                            final StatusCallback val$callback;

                            AnonymousClass1(StatusCallback statusCallback) {
                                r2 = statusCallback;
                            }

                            @Override
                            public void run() {
                                r2.call(Session.this, r2, r3);
                            }
                        });
                    }
                }
            });
        }
        if (this != activeSession || sessionState.isOpened() == sessionState22.isOpened()) {
            return;
        }
        if (sessionState22.isOpened()) {
            postActiveSessionAction(ACTION_ACTIVE_SESSION_OPENED);
        } else {
            postActiveSessionAction(ACTION_ACTIVE_SESSION_CLOSED);
        }
    }

    public final void removeCallback(StatusCallback statusCallback) {
        synchronized (this.callbacks) {
            this.callbacks.remove(statusCallback);
        }
    }

    public final void requestNewPublishPermissions(NewPermissionsRequest newPermissionsRequest) {
        requestNewPermissions(newPermissionsRequest, SessionAuthorizationType.PUBLISH);
    }

    public final void requestNewReadPermissions(NewPermissionsRequest newPermissionsRequest) {
        requestNewPermissions(newPermissionsRequest, SessionAuthorizationType.READ);
    }

    void setCurrentTokenRefreshRequest(TokenRefreshRequest tokenRefreshRequest) {
        this.currentTokenRefreshRequest = tokenRefreshRequest;
    }

    void setLastAttemptedTokenExtendDate(Date date) {
        this.lastAttemptedTokenExtendDate = date;
    }

    void setTokenInfo(AccessToken accessToken) {
        this.tokenInfo = accessToken;
    }

    boolean shouldExtendAccessToken() {
        if (this.currentTokenRefreshRequest != null) {
            return false;
        }
        Date date = new Date();
        return this.state.isOpened() && this.tokenInfo.getSource().canExtendToken() && date.getTime() - this.lastAttemptedTokenExtendDate.getTime() > 3600000 && date.getTime() - this.tokenInfo.getLastRefresh().getTime() > 86400000;
    }

    public String toString() {
        return "{Session state:" + this.state + ", token:" + (this.tokenInfo == null ? "null" : this.tokenInfo) + ", appId:" + (this.applicationId == null ? "null" : this.applicationId) + "}";
    }
}
