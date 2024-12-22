package com.facebook;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import com.facebook.GetTokenClient;
import com.facebook.Request;
import com.facebook.RequestBatch;
import com.facebook.android.C0217R;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.model.GraphMultiResult;
import com.facebook.model.GraphObject;
import com.facebook.model.GraphObjectList;
import com.facebook.model.GraphUser;
import com.facebook.widget.WebDialog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class AuthorizationClient implements Serializable {
    private static final String TAG = "Facebook-AuthorizationClient";
    private static final String WEB_VIEW_AUTH_HANDLER_STORE = "com.facebook.AuthorizationClient.WebViewAuthHandler.TOKEN_STORE_KEY";
    private static final String WEB_VIEW_AUTH_HANDLER_TOKEN_KEY = "TOKEN";
    private static final long serialVersionUID = 1;
    transient BackgroundProcessingListener backgroundProcessingListener;
    transient boolean checkedInternetPermission;
    transient Context context;
    AuthHandler currentHandler;
    List<AuthHandler> handlersToTry;
    transient OnCompletedListener onCompletedListener;
    AuthorizationRequest pendingRequest;
    transient StartActivityDelegate startActivityDelegate;

    class AuthDialogBuilder extends WebDialog.Builder {
        private static final String OAUTH_DIALOG = "oauth";
        static final String REDIRECT_URI = "fbconnect://success";

        public AuthDialogBuilder(Context context, String str, Bundle bundle) {
            super(context, str, OAUTH_DIALOG, bundle);
        }

        @Override
        public WebDialog build() {
            Bundle parameters = getParameters();
            parameters.putString(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, "fbconnect://success");
            parameters.putString("client_id", getApplicationId());
            return new WebDialog(getContext(), OAUTH_DIALOG, parameters, getTheme(), getListener());
        }
    }

    abstract class AuthHandler implements Serializable {
        private static final long serialVersionUID = 1;

        AuthHandler() {
        }

        void cancel() {
        }

        boolean needsInternetPermission() {
            return false;
        }

        boolean needsRestart() {
            return false;
        }

        boolean onActivityResult(int i, int i2, Intent intent) {
            return false;
        }

        abstract boolean tryAuthorize(AuthorizationRequest authorizationRequest);
    }

    class AuthorizationRequest implements Serializable {
        private static final long serialVersionUID = 1;
        private String applicationId;
        private SessionDefaultAudience defaultAudience;
        private boolean isLegacy;
        private SessionLoginBehavior loginBehavior;
        private List<String> permissions;
        private String previousAccessToken;
        private int requestCode;
        private final transient StartActivityDelegate startActivityDelegate;

        AuthorizationRequest(SessionLoginBehavior sessionLoginBehavior, int i, boolean z, List<String> list, SessionDefaultAudience sessionDefaultAudience, String str, String str2, StartActivityDelegate startActivityDelegate) {
            this.isLegacy = false;
            this.loginBehavior = sessionLoginBehavior;
            this.requestCode = i;
            this.isLegacy = z;
            this.permissions = list;
            this.defaultAudience = sessionDefaultAudience;
            this.applicationId = str;
            this.previousAccessToken = str2;
            this.startActivityDelegate = startActivityDelegate;
        }

        String getApplicationId() {
            return this.applicationId;
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

        String getPreviousAccessToken() {
            return this.previousAccessToken;
        }

        int getRequestCode() {
            return this.requestCode;
        }

        StartActivityDelegate getStartActivityDelegate() {
            return this.startActivityDelegate;
        }

        boolean isLegacy() {
            return this.isLegacy;
        }

        boolean needsNewTokenValidation() {
            return (this.previousAccessToken == null || this.isLegacy) ? false : true;
        }

        void setIsLegacy(boolean z) {
            this.isLegacy = z;
        }

        void setPermissions(List<String> list) {
            this.permissions = list;
        }
    }

    interface BackgroundProcessingListener {
        void onBackgroundProcessingStarted();

        void onBackgroundProcessingStopped();
    }

    class GetTokenAuthHandler extends AuthHandler {
        private static final long serialVersionUID = 1;
        private transient GetTokenClient getTokenClient;

        GetTokenAuthHandler() {
            super();
        }

        @Override
        void cancel() {
            if (this.getTokenClient != null) {
                this.getTokenClient.cancel();
                this.getTokenClient = null;
            }
        }

        void getTokenCompleted(AuthorizationRequest authorizationRequest, Bundle bundle) {
            this.getTokenClient = null;
            AuthorizationClient.this.notifyBackgroundProcessingStop();
            if (bundle != null) {
                ArrayList<String> stringArrayList = bundle.getStringArrayList("com.facebook.platform.extra.PERMISSIONS");
                List<String> permissions = authorizationRequest.getPermissions();
                if (stringArrayList != null && (permissions == null || stringArrayList.containsAll(permissions))) {
                    AuthorizationClient.this.completeAndValidate(Result.createTokenResult(AccessToken.createFromNativeLogin(bundle, AccessTokenSource.FACEBOOK_APPLICATION_SERVICE)));
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (String str : permissions) {
                    if (!stringArrayList.contains(str)) {
                        arrayList.add(str);
                    }
                }
                authorizationRequest.setPermissions(arrayList);
            }
            AuthorizationClient.this.tryNextHandler();
        }

        @Override
        boolean tryAuthorize(final AuthorizationRequest authorizationRequest) {
            this.getTokenClient = new GetTokenClient(AuthorizationClient.this.context, authorizationRequest.getApplicationId());
            if (!this.getTokenClient.start()) {
                return false;
            }
            AuthorizationClient.this.notifyBackgroundProcessingStart();
            this.getTokenClient.setCompletedListener(new GetTokenClient.CompletedListener() {
                @Override
                public void completed(Bundle bundle) {
                    GetTokenAuthHandler.this.getTokenCompleted(authorizationRequest, bundle);
                }
            });
            return true;
        }
    }

    abstract class KatanaAuthHandler extends AuthHandler {
        private static final long serialVersionUID = 1;

        KatanaAuthHandler() {
            super();
        }

        protected boolean tryIntent(Intent intent, int i) {
            if (intent == null) {
                return false;
            }
            try {
                AuthorizationClient.this.getStartActivityDelegate().startActivityForResult(intent, i);
                return true;
            } catch (ActivityNotFoundException e) {
                return false;
            }
        }
    }

    class KatanaLoginDialogAuthHandler extends KatanaAuthHandler {
        private static final long serialVersionUID = 1;

        KatanaLoginDialogAuthHandler() {
            super();
        }

        private Result handleResultOk(Intent intent) {
            Bundle extras = intent.getExtras();
            String string = extras.getString("com.facebook.platform.status.ERROR_TYPE");
            if (string == null) {
                return Result.createTokenResult(AccessToken.createFromNativeLogin(extras, AccessTokenSource.FACEBOOK_APPLICATION_NATIVE));
            }
            if ("ServiceDisabled".equals(string)) {
                return null;
            }
            return "UserCanceled".equals(string) ? Result.createCancelResult(null) : Result.createErrorResult(string, extras.getString("error_description"));
        }

        @Override
        boolean onActivityResult(int i, int i2, Intent intent) {
            Result result = null;
            if (intent == null) {
                result = Result.createCancelResult("Operation canceled");
            } else if (!NativeProtocol.isServiceDisabledResult20121101(intent)) {
                result = i2 == 0 ? Result.createCancelResult(intent.getStringExtra("com.facebook.platform.status.ERROR_DESCRIPTION")) : i2 != -1 ? Result.createErrorResult("Unexpected resultCode from authorization.", null) : handleResultOk(intent);
            }
            if (result != null) {
                AuthorizationClient.this.completeAndValidate(result);
                return true;
            }
            AuthorizationClient.this.tryNextHandler();
            return true;
        }

        @Override
        boolean tryAuthorize(AuthorizationRequest authorizationRequest) {
            return tryIntent(NativeProtocol.createLoginDialog20121101Intent(AuthorizationClient.this.context, authorizationRequest.getApplicationId(), new ArrayList(authorizationRequest.getPermissions()), authorizationRequest.getDefaultAudience().getNativeProtocolAudience()), authorizationRequest.getRequestCode());
        }
    }

    class KatanaProxyAuthHandler extends KatanaAuthHandler {
        private static final long serialVersionUID = 1;

        KatanaProxyAuthHandler() {
            super();
        }

        private Result handleResultOk(Intent intent) {
            Bundle extras = intent.getExtras();
            String string = extras.getString("error");
            if (string == null) {
                string = extras.getString("error_type");
            }
            if (string == null) {
                return Result.createTokenResult(AccessToken.createFromWebBundle(AuthorizationClient.this.pendingRequest.getPermissions(), extras, AccessTokenSource.FACEBOOK_APPLICATION_WEB));
            }
            if (ServerProtocol.errorsProxyAuthDisabled.contains(string)) {
                return null;
            }
            return ServerProtocol.errorsUserCanceled.contains(string) ? Result.createCancelResult(null) : Result.createErrorResult(string, extras.getString("error_description"));
        }

        @Override
        boolean onActivityResult(int i, int i2, Intent intent) {
            Result createCancelResult = intent == null ? Result.createCancelResult("Operation canceled") : i2 == 0 ? Result.createCancelResult(intent.getStringExtra("error")) : i2 != -1 ? Result.createErrorResult("Unexpected resultCode from authorization.", null) : handleResultOk(intent);
            if (createCancelResult != null) {
                AuthorizationClient.this.completeAndValidate(createCancelResult);
                return true;
            }
            AuthorizationClient.this.tryNextHandler();
            return true;
        }

        @Override
        boolean tryAuthorize(AuthorizationRequest authorizationRequest) {
            return tryIntent(NativeProtocol.createProxyAuthIntent(AuthorizationClient.this.context, authorizationRequest.getApplicationId(), authorizationRequest.getPermissions()), authorizationRequest.getRequestCode());
        }
    }

    interface OnCompletedListener {
        void onCompleted(Result result);
    }

    class Result implements Serializable {
        private static final long serialVersionUID = 1;
        final Code code;
        final String errorMessage;
        final AccessToken token;

        enum Code {
            SUCCESS,
            CANCEL,
            ERROR
        }

        private Result(Code code, AccessToken accessToken, String str) {
            this.token = accessToken;
            this.errorMessage = str;
            this.code = code;
        }

        static Result createCancelResult(String str) {
            return new Result(Code.CANCEL, null, str);
        }

        static Result createErrorResult(String str, String str2) {
            if (str2 != null) {
                str = str + ": " + str2;
            }
            return new Result(Code.ERROR, null, str);
        }

        static Result createTokenResult(AccessToken accessToken) {
            return new Result(Code.SUCCESS, accessToken, null);
        }
    }

    interface StartActivityDelegate {
        Activity getActivityContext();

        void startActivityForResult(Intent intent, int i);
    }

    class WebViewAuthHandler extends AuthHandler {
        private static final long serialVersionUID = 1;
        private transient WebDialog loginDialog;

        WebViewAuthHandler() {
            super();
        }

        private String loadCookieToken() {
            return AuthorizationClient.this.getStartActivityDelegate().getActivityContext().getSharedPreferences(AuthorizationClient.WEB_VIEW_AUTH_HANDLER_STORE, 0).getString(AuthorizationClient.WEB_VIEW_AUTH_HANDLER_TOKEN_KEY, "");
        }

        private void saveCookieToken(String str) {
            SharedPreferences.Editor edit = AuthorizationClient.this.getStartActivityDelegate().getActivityContext().getSharedPreferences(AuthorizationClient.WEB_VIEW_AUTH_HANDLER_STORE, 0).edit();
            edit.putString(AuthorizationClient.WEB_VIEW_AUTH_HANDLER_TOKEN_KEY, str);
            if (edit.commit()) {
                return;
            }
            Utility.logd(AuthorizationClient.TAG, "Could not update saved web view auth handler token.");
        }

        @Override
        void cancel() {
            if (this.loginDialog != null) {
                this.loginDialog.dismiss();
                this.loginDialog = null;
            }
        }

        @Override
        boolean needsInternetPermission() {
            return true;
        }

        @Override
        boolean needsRestart() {
            return true;
        }

        void onWebDialogComplete(AuthorizationRequest authorizationRequest, Bundle bundle, FacebookException facebookException) {
            Result createCancelResult;
            if (bundle != null) {
                AccessToken createFromWebBundle = AccessToken.createFromWebBundle(authorizationRequest.getPermissions(), bundle, AccessTokenSource.WEB_VIEW);
                createCancelResult = Result.createTokenResult(createFromWebBundle);
                CookieSyncManager.createInstance(AuthorizationClient.this.context).sync();
                saveCookieToken(createFromWebBundle.getToken());
            } else {
                createCancelResult = facebookException instanceof FacebookOperationCanceledException ? Result.createCancelResult("User canceled log in.") : Result.createErrorResult(facebookException.getMessage(), null);
            }
            AuthorizationClient.this.completeAndValidate(createCancelResult);
        }

        @Override
        boolean tryAuthorize(final AuthorizationRequest authorizationRequest) {
            String applicationId = authorizationRequest.getApplicationId();
            Bundle bundle = new Bundle();
            if (!Utility.isNullOrEmpty(authorizationRequest.getPermissions())) {
                bundle.putString("scope", TextUtils.join(",", authorizationRequest.getPermissions()));
            }
            String previousAccessToken = authorizationRequest.getPreviousAccessToken();
            if (Utility.isNullOrEmpty(previousAccessToken) || !previousAccessToken.equals(loadCookieToken())) {
                Utility.clearFacebookCookies(AuthorizationClient.this.context);
            } else {
                bundle.putString("access_token", previousAccessToken);
            }
            this.loginDialog = new AuthDialogBuilder(AuthorizationClient.this.getStartActivityDelegate().getActivityContext(), applicationId, bundle).setOnCompleteListener(new WebDialog.OnCompleteListener() {
                @Override
                public void onComplete(Bundle bundle2, FacebookException facebookException) {
                    WebViewAuthHandler.this.onWebDialogComplete(authorizationRequest, bundle2, facebookException);
                }
            }).build();
            this.loginDialog.show();
            return true;
        }
    }

    AuthorizationClient() {
    }

    private void completeWithFailure() {
        complete(Result.createErrorResult("Login attempt failed.", null));
    }

    private List<AuthHandler> getHandlerTypes(AuthorizationRequest authorizationRequest) {
        ArrayList arrayList = new ArrayList();
        SessionLoginBehavior loginBehavior = authorizationRequest.getLoginBehavior();
        if (loginBehavior.allowsKatanaAuth()) {
            if (!authorizationRequest.isLegacy()) {
                arrayList.add(new GetTokenAuthHandler());
                arrayList.add(new KatanaLoginDialogAuthHandler());
            }
            arrayList.add(new KatanaProxyAuthHandler());
        }
        if (loginBehavior.allowsWebViewAuth()) {
            arrayList.add(new WebViewAuthHandler());
        }
        return arrayList;
    }

    public void notifyBackgroundProcessingStart() {
        if (this.backgroundProcessingListener != null) {
            this.backgroundProcessingListener.onBackgroundProcessingStarted();
        }
    }

    public void notifyBackgroundProcessingStop() {
        if (this.backgroundProcessingListener != null) {
            this.backgroundProcessingListener.onBackgroundProcessingStopped();
        }
    }

    private void notifyOnCompleteListener(Result result) {
        if (this.onCompletedListener != null) {
            this.onCompletedListener.onCompleted(result);
        }
    }

    void authorize(AuthorizationRequest authorizationRequest) {
        if (authorizationRequest == null) {
            return;
        }
        if (this.pendingRequest != null) {
            throw new FacebookException("Attempted to authorize while a request is pending.");
        }
        if (!authorizationRequest.needsNewTokenValidation() || checkInternetPermission()) {
            this.pendingRequest = authorizationRequest;
            this.handlersToTry = getHandlerTypes(authorizationRequest);
            tryNextHandler();
        }
    }

    void cancelCurrentHandler() {
        if (this.currentHandler != null) {
            this.currentHandler.cancel();
        }
    }

    boolean checkInternetPermission() {
        if (this.checkedInternetPermission) {
            return true;
        }
        if (checkPermission("android.permission.INTERNET") != 0) {
            complete(Result.createErrorResult(this.context.getString(C0217R.string.com_facebook_internet_permission_error_title), this.context.getString(C0217R.string.com_facebook_internet_permission_error_message)));
            return false;
        }
        this.checkedInternetPermission = true;
        return true;
    }

    int checkPermission(String str) {
        return this.context.checkCallingOrSelfPermission(str);
    }

    void complete(Result result) {
        this.handlersToTry = null;
        this.currentHandler = null;
        this.pendingRequest = null;
        notifyOnCompleteListener(result);
    }

    void completeAndValidate(Result result) {
        if (result.token == null || !this.pendingRequest.needsNewTokenValidation()) {
            complete(result);
        } else {
            validateSameFbidAndFinish(result);
        }
    }

    void continueAuth() {
        if (this.pendingRequest == null || this.currentHandler == null) {
            throw new FacebookException("Attempted to continue authorization without a pending request.");
        }
        if (this.currentHandler.needsRestart()) {
            this.currentHandler.cancel();
            tryCurrentHandler();
        }
    }

    Request createGetPermissionsRequest(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("fields", "id");
        bundle.putString("access_token", str);
        return new Request(null, "me/permissions", bundle, HttpMethod.GET, null);
    }

    Request createGetProfileIdRequest(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("fields", "id");
        bundle.putString("access_token", str);
        return new Request(null, "me", bundle, HttpMethod.GET, null);
    }

    RequestBatch createReauthValidationBatch(final Result result) {
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        String token = result.token.getToken();
        Request.Callback callback = new Request.Callback() {
            @Override
            public void onCompleted(Response response) {
                try {
                    GraphUser graphUser = (GraphUser) response.getGraphObjectAs(GraphUser.class);
                    if (graphUser != null) {
                        arrayList.add(graphUser.getId());
                    }
                } catch (Exception e) {
                }
            }
        };
        String previousAccessToken = this.pendingRequest.getPreviousAccessToken();
        Request createGetProfileIdRequest = createGetProfileIdRequest(previousAccessToken);
        createGetProfileIdRequest.setCallback(callback);
        Request createGetProfileIdRequest2 = createGetProfileIdRequest(token);
        createGetProfileIdRequest2.setCallback(callback);
        Request createGetPermissionsRequest = createGetPermissionsRequest(previousAccessToken);
        createGetPermissionsRequest.setCallback(new Request.Callback() {
            @Override
            public void onCompleted(Response response) {
                GraphObjectList<GraphObject> data;
                try {
                    GraphMultiResult graphMultiResult = (GraphMultiResult) response.getGraphObjectAs(GraphMultiResult.class);
                    if (graphMultiResult == null || (data = graphMultiResult.getData()) == null || data.size() != 1) {
                        return;
                    }
                    arrayList2.addAll(data.get(0).asMap().keySet());
                } catch (Exception e) {
                }
            }
        });
        RequestBatch requestBatch = new RequestBatch(createGetProfileIdRequest, createGetProfileIdRequest2, createGetPermissionsRequest);
        requestBatch.setBatchApplicationId(this.pendingRequest.getApplicationId());
        requestBatch.addCallback(new RequestBatch.Callback() {
            @Override
            public void onBatchCompleted(RequestBatch requestBatch2) {
                try {
                    AuthorizationClient.this.complete((arrayList.size() != 2 || arrayList.get(0) == null || arrayList.get(1) == null || !((String) arrayList.get(0)).equals(arrayList.get(1))) ? Result.createErrorResult("User logged in as different Facebook user.", null) : Result.createTokenResult(AccessToken.createFromTokenWithRefreshedPermissions(result.token, arrayList2)));
                } catch (Exception e) {
                    AuthorizationClient.this.complete(Result.createErrorResult("Caught exception", e.getMessage()));
                } finally {
                    AuthorizationClient.this.notifyBackgroundProcessingStop();
                }
            }
        });
        return requestBatch;
    }

    BackgroundProcessingListener getBackgroundProcessingListener() {
        return this.backgroundProcessingListener;
    }

    boolean getInProgress() {
        return (this.pendingRequest == null || this.currentHandler == null) ? false : true;
    }

    OnCompletedListener getOnCompletedListener() {
        return this.onCompletedListener;
    }

    StartActivityDelegate getStartActivityDelegate() {
        if (this.startActivityDelegate != null) {
            return this.startActivityDelegate;
        }
        if (this.pendingRequest != null) {
            return new StartActivityDelegate() {
                @Override
                public Activity getActivityContext() {
                    return AuthorizationClient.this.pendingRequest.getStartActivityDelegate().getActivityContext();
                }

                @Override
                public void startActivityForResult(Intent intent, int i) {
                    AuthorizationClient.this.pendingRequest.getStartActivityDelegate().startActivityForResult(intent, i);
                }
            };
        }
        return null;
    }

    boolean onActivityResult(int i, int i2, Intent intent) {
        if (i == this.pendingRequest.getRequestCode()) {
            return this.currentHandler.onActivityResult(i, i2, intent);
        }
        return false;
    }

    void setBackgroundProcessingListener(BackgroundProcessingListener backgroundProcessingListener) {
        this.backgroundProcessingListener = backgroundProcessingListener;
    }

    void setContext(final Activity activity) {
        this.context = activity;
        this.startActivityDelegate = new StartActivityDelegate() {
            @Override
            public Activity getActivityContext() {
                return activity;
            }

            @Override
            public void startActivityForResult(Intent intent, int i) {
                activity.startActivityForResult(intent, i);
            }
        };
    }

    void setContext(Context context) {
        this.context = context;
        this.startActivityDelegate = null;
    }

    void setOnCompletedListener(OnCompletedListener onCompletedListener) {
        this.onCompletedListener = onCompletedListener;
    }

    void startOrContinueAuth(AuthorizationRequest authorizationRequest) {
        if (getInProgress()) {
            continueAuth();
        } else {
            authorize(authorizationRequest);
        }
    }

    boolean tryCurrentHandler() {
        if (!this.currentHandler.needsInternetPermission() || checkInternetPermission()) {
            return this.currentHandler.tryAuthorize(this.pendingRequest);
        }
        return false;
    }

    void tryNextHandler() {
        while (this.handlersToTry != null && !this.handlersToTry.isEmpty()) {
            this.currentHandler = this.handlersToTry.remove(0);
            if (tryCurrentHandler()) {
                return;
            }
        }
        if (this.pendingRequest != null) {
            completeWithFailure();
        }
    }

    void validateSameFbidAndFinish(Result result) {
        if (result.token == null) {
            throw new FacebookException("Can't validate without a token");
        }
        RequestBatch createReauthValidationBatch = createReauthValidationBatch(result);
        notifyBackgroundProcessingStart();
        createReauthValidationBatch.executeAsync();
    }
}
