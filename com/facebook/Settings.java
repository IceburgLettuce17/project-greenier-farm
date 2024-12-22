package com.facebook;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import com.facebook.Request;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.model.GraphObject;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

public final class Settings {
    private static final String ANALYTICS_EVENT = "event";
    private static final String ATTRIBUTION_ID_COLUMN_NAME = "aid";
    private static final String ATTRIBUTION_KEY = "attribution";
    private static final String ATTRIBUTION_PREFERENCES = "com.facebook.sdk.attributionTracking";
    private static final int DEFAULT_CORE_POOL_SIZE = 5;
    private static final int DEFAULT_KEEP_ALIVE = 1;
    private static final int DEFAULT_MAXIMUM_POOL_SIZE = 128;
    private static final String MOBILE_INSTALL_EVENT = "MOBILE_APP_INSTALL";
    private static final String PUBLISH_ACTIVITY_PATH = "%s/activities";
    private static volatile Executor executor;
    private static volatile boolean shouldAutoPublishInstall;
    private static final HashSet<LoggingBehavior> loggingBehaviors = new HashSet<>(Arrays.asList(LoggingBehavior.DEVELOPER_ERRORS));
    private static final Object LOCK = new Object();
    private static final Uri ATTRIBUTION_ID_CONTENT_URI = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
    private static final BlockingQueue<Runnable> DEFAULT_WORK_QUEUE = new LinkedBlockingQueue(10);
    private static final ThreadFactory DEFAULT_THREAD_FACTORY = new ThreadFactory() {
        private final AtomicInteger counter = new AtomicInteger(0);

        ThreadFactoryC02091() {
        }

        @Override
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "FacebookSdk #" + this.counter.incrementAndGet());
        }
    };

    final class ThreadFactoryC02091 implements ThreadFactory {
        private final AtomicInteger counter = new AtomicInteger(0);

        ThreadFactoryC02091() {
        }

        @Override
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "FacebookSdk #" + this.counter.incrementAndGet());
        }
    }

    final class RunnableC02102 implements Runnable {
        final Context val$applicationContext;
        final String val$applicationId;
        final Request.Callback val$callback;

        class AnonymousClass1 implements Runnable {
            final Response val$response;

            AnonymousClass1(Response response) {
                r2 = response;
            }

            @Override
            public void run() {
                r3.onCompleted(r2);
            }
        }

        RunnableC02102(Context context, String str, Request.Callback callback) {
            r1 = context;
            r2 = str;
            r3 = callback;
        }

        @Override
        public final void run() {
            Response publishInstallAndWaitForResponse = Settings.publishInstallAndWaitForResponse(r1, r2);
            if (r3 != null) {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    final Response val$response;

                    AnonymousClass1(Response publishInstallAndWaitForResponse2) {
                        r2 = publishInstallAndWaitForResponse2;
                    }

                    @Override
                    public void run() {
                        r3.onCompleted(r2);
                    }
                });
            }
        }
    }

    public static final void addLoggingBehavior(LoggingBehavior loggingBehavior) {
        synchronized (loggingBehaviors) {
            loggingBehaviors.add(loggingBehavior);
        }
    }

    public static final void clearLoggingBehaviors() {
        synchronized (loggingBehaviors) {
            loggingBehaviors.clear();
        }
    }

    private static Executor getAsyncTaskExecutor() {
        try {
            Field field = AsyncTask.class.getField("THREAD_POOL_EXECUTOR");
            if (field == null) {
                return null;
            }
            try {
                Object obj = field.get(null);
                if (obj != null && (obj instanceof Executor)) {
                    return (Executor) obj;
                }
                return null;
            } catch (IllegalAccessException e) {
                return null;
            }
        } catch (NoSuchFieldException e2) {
            return null;
        }
    }

    public static String getAttributionId(ContentResolver contentResolver) {
        Cursor query = contentResolver.query(ATTRIBUTION_ID_CONTENT_URI, new String[]{"aid"}, null, null, null);
        if (query == null || !query.moveToFirst()) {
            return null;
        }
        String string = query.getString(query.getColumnIndex("aid"));
        query.close();
        return string;
    }

    public static Executor getExecutor() {
        synchronized (LOCK) {
            if (executor == null) {
                Executor asyncTaskExecutor = getAsyncTaskExecutor();
                if (asyncTaskExecutor == null) {
                    asyncTaskExecutor = new ThreadPoolExecutor(5, DEFAULT_MAXIMUM_POOL_SIZE, 1L, TimeUnit.SECONDS, DEFAULT_WORK_QUEUE, DEFAULT_THREAD_FACTORY);
                }
                executor = asyncTaskExecutor;
            }
        }
        return executor;
    }

    public static final Set<LoggingBehavior> getLoggingBehaviors() {
        Set<LoggingBehavior> unmodifiableSet;
        synchronized (loggingBehaviors) {
            unmodifiableSet = Collections.unmodifiableSet(new HashSet(loggingBehaviors));
        }
        return unmodifiableSet;
    }

    public static String getMigrationBundle() {
        return FacebookSdkVersion.MIGRATION_BUNDLE;
    }

    public static String getSdkVersion() {
        return FacebookSdkVersion.BUILD;
    }

    public static boolean getShouldAutoPublishInstall() {
        return shouldAutoPublishInstall;
    }

    public static final boolean isLoggingBehaviorEnabled(LoggingBehavior loggingBehavior) {
        synchronized (loggingBehaviors) {
        }
        return false;
    }

    public static boolean publishInstallAndWait(Context context, String str) {
        Response publishInstallAndWaitForResponse = publishInstallAndWaitForResponse(context, str);
        return publishInstallAndWaitForResponse != null && publishInstallAndWaitForResponse.getError() == null;
    }

    public static Response publishInstallAndWaitForResponse(Context context, String str) {
        GraphObject graphObject;
        GraphObject create;
        try {
            if (context == null || str == null) {
                throw new IllegalArgumentException("Both context and applicationId must be non-null");
            }
            String attributionId = getAttributionId(context.getContentResolver());
            SharedPreferences sharedPreferences = context.getSharedPreferences(ATTRIBUTION_PREFERENCES, 0);
            String str2 = str + "ping";
            String str3 = str + "json";
            long j = sharedPreferences.getLong(str2, 0L);
            String string = sharedPreferences.getString(str3, null);
            GraphObject create2 = GraphObject.Factory.create();
            create2.setProperty(ANALYTICS_EVENT, MOBILE_INSTALL_EVENT);
            create2.setProperty(ATTRIBUTION_KEY, attributionId);
            Request newPostRequest = Request.newPostRequest(null, String.format(PUBLISH_ACTIVITY_PATH, str), create2, null);
            if (j != 0) {
                if (string != null) {
                    try {
                        create = GraphObject.Factory.create(new JSONObject(string));
                    } catch (JSONException e) {
                        graphObject = null;
                    }
                } else {
                    create = null;
                }
                graphObject = create;
                return graphObject == null ? Response.createResponsesFromString("true", null, new RequestBatch(newPostRequest), true).get(0) : new Response((Request) null, (HttpURLConnection) null, graphObject, true);
            }
            if (attributionId == null) {
                throw new FacebookException("No attribution id returned from the Facebook application");
            }
            if (!Utility.queryAppAttributionSupportAndWait(str)) {
                throw new FacebookException("Install attribution has been disabled on the server.");
            }
            Response executeAndWait = newPostRequest.executeAndWait();
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putLong(str2, System.currentTimeMillis());
            if (executeAndWait.getGraphObject() != null && executeAndWait.getGraphObject().getInnerJSONObject() != null) {
                edit.putString(str3, executeAndWait.getGraphObject().getInnerJSONObject().toString());
            }
            edit.commit();
            return executeAndWait;
        } catch (Exception e2) {
            Utility.logd("Facebook-publish", e2);
            return new Response(null, null, new FacebookRequestError(null, e2));
        }
    }

    public static void publishInstallAsync(Context context, String str) {
        publishInstallAsync(context, str, null);
    }

    public static void publishInstallAsync(Context context, String str, Request.Callback callback) {
        getExecutor().execute(new Runnable() {
            final Context val$applicationContext;
            final String val$applicationId;
            final Request.Callback val$callback;

            class AnonymousClass1 implements Runnable {
                final Response val$response;

                AnonymousClass1(Response publishInstallAndWaitForResponse2) {
                    r2 = publishInstallAndWaitForResponse2;
                }

                @Override
                public void run() {
                    r3.onCompleted(r2);
                }
            }

            RunnableC02102(Context context2, String str2, Request.Callback callback2) {
                r1 = context2;
                r2 = str2;
                r3 = callback2;
            }

            @Override
            public final void run() {
                Response publishInstallAndWaitForResponse2 = Settings.publishInstallAndWaitForResponse(r1, r2);
                if (r3 != null) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        final Response val$response;

                        AnonymousClass1(Response publishInstallAndWaitForResponse22) {
                            r2 = publishInstallAndWaitForResponse22;
                        }

                        @Override
                        public void run() {
                            r3.onCompleted(r2);
                        }
                    });
                }
            }
        });
    }

    public static final void removeLoggingBehavior(LoggingBehavior loggingBehavior) {
        synchronized (loggingBehaviors) {
            loggingBehaviors.remove(loggingBehavior);
        }
    }

    public static void setExecutor(Executor executor2) {
        Validate.notNull(executor2, "executor");
        synchronized (LOCK) {
            executor = executor2;
        }
    }

    public static void setShouldAutoPublishInstall(boolean z) {
        shouldAutoPublishInstall = z;
    }
}
