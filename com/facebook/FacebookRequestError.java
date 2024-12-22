package com.facebook;

import com.facebook.android.C0217R;
import com.facebook.internal.Utility;
import java.net.HttpURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

public final class FacebookRequestError {
    private static final String BODY_KEY = "body";
    private static final String CODE_KEY = "code";
    private static final int EC_APP_NOT_INSTALLED = 458;
    private static final int EC_APP_TOO_MANY_CALLS = 4;
    private static final int EC_EXPIRED = 463;
    private static final int EC_INVALID_SESSION = 102;
    private static final int EC_INVALID_TOKEN = 190;
    private static final int EC_PASSWORD_CHANGED = 460;
    private static final int EC_PERMISSION_DENIED = 10;
    private static final Range EC_RANGE_PERMISSION;
    private static final int EC_SERVICE_UNAVAILABLE = 2;
    private static final int EC_UNCONFIRMED_USER = 464;
    private static final int EC_UNKNOWN_ERROR = 1;
    private static final int EC_USER_CHECKPOINTED = 459;
    private static final int EC_USER_TOO_MANY_CALLS = 17;
    private static final String ERROR_CODE_FIELD_KEY = "code";
    private static final String ERROR_CODE_KEY = "error_code";
    private static final String ERROR_KEY = "error";
    private static final String ERROR_MESSAGE_FIELD_KEY = "message";
    private static final String ERROR_MSG_KEY = "error_msg";
    private static final String ERROR_REASON_KEY = "error_reason";
    private static final String ERROR_SUB_CODE_KEY = "error_subcode";
    private static final String ERROR_TYPE_FIELD_KEY = "type";
    private static final Range HTTP_RANGE_CLIENT_ERROR;
    private static final Range HTTP_RANGE_SERVER_ERROR;
    private static final Range HTTP_RANGE_SUCCESS;
    public static final int INVALID_ERROR_CODE = -1;
    public static final int INVALID_HTTP_STATUS_CODE = -1;
    private static final int INVALID_MESSAGE_ID = 0;
    private final Object batchRequestResult;
    private final Category category;
    private final HttpURLConnection connection;
    private final int errorCode;
    private final String errorMessage;
    private final String errorType;
    private final FacebookException exception;
    private final JSONObject requestResult;
    private final JSONObject requestResultBody;
    private final int requestStatusCode;
    private final boolean shouldNotifyUser;
    private final int subErrorCode;
    private final int userActionMessageId;

    public enum Category {
        AUTHENTICATION_RETRY,
        AUTHENTICATION_REOPEN_SESSION,
        PERMISSION,
        SERVER,
        THROTTLING,
        OTHER,
        BAD_REQUEST,
        CLIENT
    }

    class Range {
        private final int end;
        private final int start;

        private Range(int i, int i2) {
            this.start = i;
            this.end = i2;
        }

        boolean contains(int i) {
            return this.start <= i && i <= this.end;
        }
    }

    static {
        int i = 299;
        int i2 = 200;
        EC_RANGE_PERMISSION = new Range(i2, i);
        HTTP_RANGE_SUCCESS = new Range(i2, i);
        HTTP_RANGE_CLIENT_ERROR = new Range(400, 499);
        HTTP_RANGE_SERVER_ERROR = new Range(500, 599);
    }

    private FacebookRequestError(int i, int i2, int i3, String str, String str2, JSONObject jSONObject, JSONObject jSONObject2, Object obj, HttpURLConnection httpURLConnection) {
        this(i, i2, i3, str, str2, jSONObject, jSONObject2, obj, httpURLConnection, null);
    }

    private FacebookRequestError(int i, int i2, int i3, String str, String str2, JSONObject jSONObject, JSONObject jSONObject2, Object obj, HttpURLConnection httpURLConnection, FacebookException facebookException) {
        boolean z;
        int i4;
        boolean z2 = false;
        this.requestStatusCode = i;
        this.errorCode = i2;
        this.subErrorCode = i3;
        this.errorType = str;
        this.errorMessage = str2;
        this.requestResultBody = jSONObject;
        this.requestResult = jSONObject2;
        this.batchRequestResult = obj;
        this.connection = httpURLConnection;
        if (facebookException != null) {
            this.exception = facebookException;
            z = true;
        } else {
            this.exception = new FacebookServiceException(this, str2);
            z = false;
        }
        Category category = null;
        if (z) {
            category = Category.CLIENT;
            i4 = 0;
        } else {
            if (i2 == 1 || i2 == 2) {
                category = Category.SERVER;
                i4 = 0;
            } else if (i2 == 4 || i2 == EC_USER_TOO_MANY_CALLS) {
                category = Category.THROTTLING;
                i4 = 0;
            } else if (i2 == EC_PERMISSION_DENIED || EC_RANGE_PERMISSION.contains(i2)) {
                category = Category.PERMISSION;
                i4 = C0217R.string.com_facebook_requesterror_permissions;
            } else if (i2 != EC_INVALID_SESSION && i2 != EC_INVALID_TOKEN) {
                i4 = 0;
            } else if (i3 == EC_USER_CHECKPOINTED || i3 == EC_UNCONFIRMED_USER) {
                category = Category.AUTHENTICATION_RETRY;
                i4 = C0217R.string.com_facebook_requesterror_web_login;
                z2 = true;
            } else {
                category = Category.AUTHENTICATION_REOPEN_SESSION;
                if (i3 == EC_APP_NOT_INSTALLED || i3 == EC_EXPIRED) {
                    i4 = C0217R.string.com_facebook_requesterror_relogin;
                } else if (i3 == EC_PASSWORD_CHANGED) {
                    i4 = C0217R.string.com_facebook_requesterror_password_changed;
                } else {
                    i4 = C0217R.string.com_facebook_requesterror_reconnect;
                    z2 = true;
                }
            }
            if (category == null) {
                category = HTTP_RANGE_CLIENT_ERROR.contains(i) ? Category.BAD_REQUEST : HTTP_RANGE_SERVER_ERROR.contains(i) ? Category.SERVER : Category.OTHER;
            }
        }
        this.category = category;
        this.userActionMessageId = i4;
        this.shouldNotifyUser = z2;
    }

    public FacebookRequestError(int i, String str, String str2) {
        this(-1, i, -1, str, str2, null, null, null, null, null);
    }

    FacebookRequestError(HttpURLConnection httpURLConnection, Exception exc) {
        this(-1, -1, -1, null, null, null, null, null, httpURLConnection, exc instanceof FacebookException ? (FacebookException) exc : new FacebookException(exc));
    }

    static FacebookRequestError checkResponseAndCreateError(JSONObject jSONObject, Object obj, HttpURLConnection httpURLConnection) {
        String optString;
        String optString2;
        int optInt;
        int i;
        boolean z = false;
        try {
            if (jSONObject.has("code")) {
                int i2 = jSONObject.getInt("code");
                Object stringPropertyAsJSON = Utility.getStringPropertyAsJSON(jSONObject, BODY_KEY, Response.NON_JSON_RESPONSE_PROPERTY);
                if (stringPropertyAsJSON != null && (stringPropertyAsJSON instanceof JSONObject)) {
                    JSONObject jSONObject2 = (JSONObject) stringPropertyAsJSON;
                    if (jSONObject2.has(ERROR_KEY)) {
                        JSONObject jSONObject3 = (JSONObject) Utility.getStringPropertyAsJSON(jSONObject2, ERROR_KEY, null);
                        String optString3 = jSONObject3.optString("type", null);
                        optString2 = jSONObject3.optString(ERROR_MESSAGE_FIELD_KEY, null);
                        int optInt2 = jSONObject3.optInt("code", -1);
                        optInt = jSONObject3.optInt(ERROR_SUB_CODE_KEY, -1);
                        z = true;
                        i = optInt2;
                        optString = optString3;
                    } else if (jSONObject2.has(ERROR_CODE_KEY) || jSONObject2.has(ERROR_MSG_KEY) || jSONObject2.has(ERROR_REASON_KEY)) {
                        optString = jSONObject2.optString(ERROR_REASON_KEY, null);
                        optString2 = jSONObject2.optString(ERROR_MSG_KEY, null);
                        int optInt3 = jSONObject2.optInt(ERROR_CODE_KEY, -1);
                        optInt = jSONObject2.optInt(ERROR_SUB_CODE_KEY, -1);
                        i = optInt3;
                        z = true;
                    } else {
                        optInt = 0;
                        i = 0;
                        optString2 = null;
                        optString = null;
                    }
                    if (z) {
                        return new FacebookRequestError(i2, i, optInt, optString, optString2, jSONObject2, jSONObject, obj, httpURLConnection);
                    }
                }
                if (!HTTP_RANGE_SUCCESS.contains(i2)) {
                    return new FacebookRequestError(i2, -1, -1, null, null, jSONObject.has(BODY_KEY) ? (JSONObject) Utility.getStringPropertyAsJSON(jSONObject, BODY_KEY, Response.NON_JSON_RESPONSE_PROPERTY) : null, jSONObject, obj, httpURLConnection);
                }
            }
        } catch (JSONException e) {
        }
        return null;
    }

    public final Object getBatchRequestResult() {
        return this.batchRequestResult;
    }

    public final Category getCategory() {
        return this.category;
    }

    public final HttpURLConnection getConnection() {
        return this.connection;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMessage() {
        return this.errorMessage != null ? this.errorMessage : this.exception.getLocalizedMessage();
    }

    public final String getErrorType() {
        return this.errorType;
    }

    public final FacebookException getException() {
        return this.exception;
    }

    public final JSONObject getRequestResult() {
        return this.requestResult;
    }

    public final JSONObject getRequestResultBody() {
        return this.requestResultBody;
    }

    public final int getRequestStatusCode() {
        return this.requestStatusCode;
    }

    public final int getSubErrorCode() {
        return this.subErrorCode;
    }

    public final int getUserActionMessageId() {
        return this.userActionMessageId;
    }

    public final boolean shouldNotifyUser() {
        return this.shouldNotifyUser;
    }

    public final String toString() {
        return "{HttpStatus: " + this.requestStatusCode + ", errorCode: " + this.errorCode + ", errorType: " + this.errorType + ", errorMessage: " + this.errorMessage + "}";
    }
}
