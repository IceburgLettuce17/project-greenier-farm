package com.facebook;

import android.content.Context;
import android.os.Bundle;
import com.facebook.Session;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.model.GraphObject;
import java.math.BigDecimal;
import java.util.Currency;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class InsightsLogger {
    private static final String EVENT_NAME_LOG_CONVERSION_PIXEL = "fb_log_offsite_pixel";
    private static final String EVENT_NAME_LOG_MOBILE_PURCHASE = "fb_mobile_purchase";
    private static final String EVENT_PARAMETER_CURRENCY = "fb_currency";
    private static final String EVENT_PARAMETER_PIXEL_ID = "fb_offsite_pixel_id";
    private static final String EVENT_PARAMETER_PIXEL_VALUE = "fb_offsite_pixel_value";
    private static Session appAuthSession = null;
    private final String applicationId;
    private final String clientToken;
    private final Context context;
    private final Session specifiedSession;

    private InsightsLogger(Context context, String str, String str2, Session session) {
        Validate.notNull(context, "context");
        Validate.notNullOrEmpty(str, "clientToken");
        str2 = str2 == null ? Utility.getMetadataApplicationId(context) : str2;
        this.context = context;
        this.clientToken = str;
        this.applicationId = str2;
        this.specifiedSession = session;
    }

    public static String buildJSONForEvent(String str, double d, Bundle bundle) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("_eventName", str);
            if (d != 1.0d) {
                jSONObject.put("_valueToSum", d);
            }
            if (bundle != null) {
                for (String str2 : bundle.keySet()) {
                    Object obj = bundle.get(str2);
                    if (!(obj instanceof String) && !(obj instanceof Number)) {
                        notifyDeveloperError(String.format("Parameter '%s' must be a string or a numeric type.", str2));
                    }
                    jSONObject.put(str2, obj);
                }
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            return jSONArray.toString();
        } catch (JSONException e) {
            notifyDeveloperError(e.toString());
            return null;
        }
    }

    private void logEventNow(final String str, final double d, final Bundle bundle) {
        Settings.getExecutor().execute(new Runnable() {
            @Override
            public void run() {
                String attributionId;
                String buildJSONForEvent = InsightsLogger.buildJSONForEvent(str, d, bundle);
                if (buildJSONForEvent == null) {
                    return;
                }
                GraphObject create = GraphObject.Factory.create();
                create.setProperty("event", "CUSTOM_APP_EVENTS");
                create.setProperty("custom_events", buildJSONForEvent);
                if (Utility.queryAppAttributionSupportAndWait(InsightsLogger.this.applicationId) && (attributionId = Settings.getAttributionId(InsightsLogger.this.context.getContentResolver())) != null) {
                    create.setProperty("attribution", attributionId);
                }
                try {
                    Response executeAndWait = Request.newPostRequest(InsightsLogger.this.sessionToLogTo(), String.format("%s/activities", InsightsLogger.this.applicationId), create, null).executeAndWait();
                    if (executeAndWait.getError() == null || executeAndWait.getError().getErrorCode() == -1) {
                        return;
                    }
                    InsightsLogger.notifyDeveloperError(String.format("Error publishing Insights event '%s'\n  Response: %s\n  Error: %s", buildJSONForEvent, executeAndWait.toString(), executeAndWait.getError().toString()));
                } catch (Exception e) {
                    Utility.logd("Insights-exception: ", e);
                }
            }
        });
    }

    public static InsightsLogger newLogger(Context context, String str) {
        return new InsightsLogger(context, str, null, null);
    }

    public static InsightsLogger newLogger(Context context, String str, String str2) {
        return new InsightsLogger(context, str, str2, null);
    }

    public static InsightsLogger newLogger(Context context, String str, String str2, Session session) {
        return new InsightsLogger(context, str, str2, session);
    }

    public static void notifyDeveloperError(String str) {
        Logger.log(LoggingBehavior.DEVELOPER_ERRORS, "Insights", str);
    }

    public Session sessionToLogTo() {
        Session session;
        synchronized (this) {
            session = this.specifiedSession;
            if (session == null || !session.isOpened()) {
                session = Session.getActiveSession();
            }
            if (session == null || !session.isOpened() || session.getAccessToken() == null) {
                if (appAuthSession == null) {
                    AccessToken createFromString = AccessToken.createFromString(String.format("%s|%s", this.applicationId, this.clientToken), null, AccessTokenSource.CLIENT_TOKEN);
                    Session session2 = new Session(null, this.applicationId, new NonCachingTokenCachingStrategy(), false);
                    appAuthSession = session2;
                    session2.open(createFromString, (Session.StatusCallback) null);
                }
                session = appAuthSession;
            }
        }
        return session;
    }

    public void logConversionPixel(String str, double d) {
        if (str == null) {
            notifyDeveloperError("pixelID cannot be null");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(EVENT_PARAMETER_PIXEL_ID, str);
        bundle.putDouble(EVENT_PARAMETER_PIXEL_VALUE, d);
        logEventNow(EVENT_NAME_LOG_CONVERSION_PIXEL, d, bundle);
    }

    public void logPurchase(BigDecimal bigDecimal, Currency currency) {
        logPurchase(bigDecimal, currency, null);
    }

    public void logPurchase(BigDecimal bigDecimal, Currency currency, Bundle bundle) {
        if (bigDecimal == null) {
            notifyDeveloperError("purchaseAmount cannot be null");
            return;
        }
        if (currency == null) {
            notifyDeveloperError("currency cannot be null");
            return;
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString(EVENT_PARAMETER_CURRENCY, currency.getCurrencyCode());
        logEventNow(EVENT_NAME_LOG_MOBILE_PURCHASE, bigDecimal.doubleValue(), bundle);
    }
}
