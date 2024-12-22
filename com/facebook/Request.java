package com.facebook;

import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Pair;
import com.facebook.RequestBatch;
import com.facebook.internal.Logger;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.model.GraphMultiResult;
import com.facebook.model.GraphObject;
import com.facebook.model.GraphObjectList;
import com.facebook.model.GraphPlace;
import com.facebook.model.GraphUser;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Request {
    private static final String ACCESS_TOKEN_PARAM = "access_token";
    private static final String ATTACHED_FILES_PARAM = "attached_files";
    private static final String ATTACHMENT_FILENAME_PREFIX = "file";
    private static final String BATCH_APP_ID_PARAM = "batch_app_id";
    private static final String BATCH_BODY_PARAM = "body";
    private static final String BATCH_ENTRY_DEPENDS_ON_PARAM = "depends_on";
    private static final String BATCH_ENTRY_NAME_PARAM = "name";
    private static final String BATCH_ENTRY_OMIT_RESPONSE_ON_SUCCESS_PARAM = "omit_response_on_success";
    private static final String BATCH_METHOD_PARAM = "method";
    private static final String BATCH_PARAM = "batch";
    private static final String BATCH_RELATIVE_URL_PARAM = "relative_url";
    private static final String CONTENT_TYPE_HEADER = "Content-Type";
    private static final String FORMAT_JSON = "json";
    private static final String FORMAT_PARAM = "format";
    private static final String ISO_8601_FORMAT_STRING = "yyyy-MM-dd'T'HH:mm:ssZ";
    public static final int MAXIMUM_BATCH_SIZE = 50;

    private static final String f125ME = "me";
    private static final String MIGRATION_BUNDLE_PARAM = "migration_bundle";
    private static final String MIME_BOUNDARY = "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f";
    private static final String MY_FEED = "me/feed";
    private static final String MY_FRIENDS = "me/friends";
    private static final String MY_PHOTOS = "me/photos";
    private static final String MY_VIDEOS = "me/videos";
    private static final String PICTURE_PARAM = "picture";
    private static final String SDK_ANDROID = "android";
    private static final String SDK_PARAM = "sdk";
    private static final String SEARCH = "search";
    private static final String USER_AGENT_BASE = "FBAndroidSDK";
    private static final String USER_AGENT_HEADER = "User-Agent";
    private static String defaultBatchApplicationId;
    private static volatile String userAgent;
    private String batchEntryDependsOn;
    private String batchEntryName;
    private boolean batchEntryOmitResultOnSuccess;
    private Callback callback;
    private GraphObject graphObject;
    private String graphPath;
    private HttpMethod httpMethod;
    private String overriddenURL;
    private Bundle parameters;
    private String restMethod;
    private Session session;

    final class C01961 implements Callback {
        C01961() {
        }

        @Override
        public final void onCompleted(Response response) {
            if (GraphUserCallback.this != null) {
                GraphUserCallback.this.onCompleted((GraphUser) response.getGraphObjectAs(GraphUser.class), response);
            }
        }
    }

    final class C01972 implements Callback {
        C01972() {
        }

        @Override
        public final void onCompleted(Response response) {
            if (GraphUserListCallback.this != null) {
                GraphUserListCallback.this.onCompleted(Request.typedListFromResponse(response, GraphUser.class), response);
            }
        }
    }

    final class C01983 implements Callback {
        C01983() {
        }

        @Override
        public final void onCompleted(Response response) {
            if (GraphPlaceListCallback.this != null) {
                GraphPlaceListCallback.this.onCompleted(Request.typedListFromResponse(response, GraphPlace.class), response);
            }
        }
    }

    final class RunnableC01994 implements Runnable {
        final ArrayList val$callbacks;
        final RequestBatch val$requests;

        RunnableC01994(ArrayList arrayList, RequestBatch requestBatch) {
            r1 = arrayList;
            r2 = requestBatch;
        }

        @Override
        public final void run() {
            Iterator it = r1.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                ((Callback) pair.first).onCompleted((Response) pair.second);
            }
            Iterator<RequestBatch.Callback> it2 = r2.getCallbacks().iterator();
            while (it2.hasNext()) {
                it2.next().onBatchCompleted(r2);
            }
        }
    }

    class C02005 implements KeyValueSerializer {
        final ArrayList val$keysAndValues;

        C02005(ArrayList arrayList) {
            r2 = arrayList;
        }

        @Override
        public void writeString(String str, String str2) {
            r2.add(String.format("%s=%s", str, URLEncoder.encode(str2, "UTF-8")));
        }
    }

    public interface Callback {
        void onCompleted(Response response);
    }

    public interface GraphPlaceListCallback {
        void onCompleted(List<GraphPlace> list, Response response);
    }

    public interface GraphUserCallback {
        void onCompleted(GraphUser graphUser, Response response);
    }

    public interface GraphUserListCallback {
        void onCompleted(List<GraphUser> list, Response response);
    }

    interface KeyValueSerializer {
        void writeString(String str, String str2);
    }

    class Serializer implements KeyValueSerializer {
        private boolean firstWrite = true;
        private final Logger logger;
        private final BufferedOutputStream outputStream;

        public Serializer(BufferedOutputStream bufferedOutputStream, Logger logger) {
            this.outputStream = bufferedOutputStream;
            this.logger = logger;
        }

        public void write(String str, Object... objArr) {
            if (this.firstWrite) {
                this.outputStream.write("--".getBytes());
                this.outputStream.write(Request.MIME_BOUNDARY.getBytes());
                this.outputStream.write("\r\n".getBytes());
                this.firstWrite = false;
            }
            this.outputStream.write(String.format(str, objArr).getBytes());
        }

        public void writeBitmap(String str, Bitmap bitmap) {
            writeContentDisposition(str, str, "image/png");
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, this.outputStream);
            writeLine("", new Object[0]);
            writeRecordBoundary();
            this.logger.appendKeyValue("    " + str, "<Image>");
        }

        public void writeBytes(String str, byte[] bArr) {
            writeContentDisposition(str, str, "content/unknown");
            this.outputStream.write(bArr);
            writeLine("", new Object[0]);
            writeRecordBoundary();
            this.logger.appendKeyValue("    " + str, String.format("<Data: %d>", Integer.valueOf(bArr.length)));
        }

        public void writeContentDisposition(String str, String str2, String str3) {
            write("Content-Disposition: form-data; name=\"%s\"", str);
            if (str2 != null) {
                write("; filename=\"%s\"", str2);
            }
            writeLine("", new Object[0]);
            if (str3 != null) {
                writeLine("%s: %s", Request.CONTENT_TYPE_HEADER, str3);
            }
            writeLine("", new Object[0]);
        }

        public void writeFile(String str, ParcelFileDescriptor parcelFileDescriptor) {
            BufferedInputStream bufferedInputStream;
            ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream = null;
            writeContentDisposition(str, str, "content/unknown");
            try {
                ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream2 = new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor);
                try {
                    bufferedInputStream = new BufferedInputStream(autoCloseInputStream2);
                    try {
                        byte[] bArr = new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE];
                        int i = 0;
                        while (true) {
                            int read = bufferedInputStream.read(bArr);
                            if (read == -1) {
                                bufferedInputStream.close();
                                autoCloseInputStream2.close();
                                writeLine("", new Object[0]);
                                writeRecordBoundary();
                                this.logger.appendKeyValue("    " + str, String.format("<Data: %d>", Integer.valueOf(i)));
                                return;
                            }
                            this.outputStream.write(bArr, 0, read);
                            i += read;
                        }
                    } catch (Throwable th) {
                        th = th;
                        autoCloseInputStream = autoCloseInputStream2;
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                        if (autoCloseInputStream != null) {
                            autoCloseInputStream.close();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream = null;
                    autoCloseInputStream = autoCloseInputStream2;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream = null;
            }
        }

        public void writeLine(String str, Object... objArr) {
            write(str, objArr);
            write("\r\n", new Object[0]);
        }

        public void writeObject(String str, Object obj) {
            if (Request.isSupportedParameterType(obj)) {
                writeString(str, Request.parameterToString(obj));
                return;
            }
            if (obj instanceof Bitmap) {
                writeBitmap(str, (Bitmap) obj);
            } else if (obj instanceof byte[]) {
                writeBytes(str, (byte[]) obj);
            } else {
                if (!(obj instanceof ParcelFileDescriptor)) {
                    throw new IllegalArgumentException("value is not a supported type: String, Bitmap, byte[]");
                }
                writeFile(str, (ParcelFileDescriptor) obj);
            }
        }

        public void writeRecordBoundary() {
            writeLine("--%s", Request.MIME_BOUNDARY);
        }

        @Override
        public void writeString(String str, String str2) {
            writeContentDisposition(str, null, null);
            writeLine("%s", str2);
            writeRecordBoundary();
            if (this.logger != null) {
                this.logger.appendKeyValue("    " + str, str2);
            }
        }
    }

    public Request() {
        this(null, null, null, null, null);
    }

    public Request(Session session, String str) {
        this(session, str, null, null, null);
    }

    public Request(Session session, String str, Bundle bundle, HttpMethod httpMethod) {
        this(session, str, bundle, httpMethod, null);
    }

    public Request(Session session, String str, Bundle bundle, HttpMethod httpMethod, Callback callback) {
        this.batchEntryOmitResultOnSuccess = true;
        this.session = session;
        this.graphPath = str;
        this.callback = callback;
        setHttpMethod(httpMethod);
        if (bundle != null) {
            this.parameters = new Bundle(bundle);
        } else {
            this.parameters = new Bundle();
        }
        if (this.parameters.containsKey(MIGRATION_BUNDLE_PARAM)) {
            return;
        }
        this.parameters.putString(MIGRATION_BUNDLE_PARAM, FacebookSdkVersion.MIGRATION_BUNDLE);
    }

    Request(Session session, URL url) {
        this.batchEntryOmitResultOnSuccess = true;
        this.session = session;
        this.overriddenURL = url.toString();
        setHttpMethod(HttpMethod.GET);
        this.parameters = new Bundle();
    }

    private void addCommonParameters() {
        if (this.session != null) {
            if (!this.session.isOpened()) {
                throw new FacebookException("Session provided to a Request in un-opened state.");
            }
            if (!this.parameters.containsKey("access_token")) {
                String accessToken = this.session.getAccessToken();
                Logger.registerAccessToken(accessToken);
                this.parameters.putString("access_token", accessToken);
            }
        }
        this.parameters.putString(SDK_PARAM, SDK_ANDROID);
        this.parameters.putString(FORMAT_PARAM, FORMAT_JSON);
    }

    private String appendParametersToBaseUrl(String str) {
        Uri.Builder encodedPath = new Uri.Builder().encodedPath(str);
        for (String str2 : this.parameters.keySet()) {
            Object obj = this.parameters.get(str2);
            if (obj == null) {
                obj = "";
            }
            if (isSupportedParameterType(obj)) {
                encodedPath.appendQueryParameter(str2, parameterToString(obj).toString());
            } else if (this.httpMethod == HttpMethod.GET) {
                throw new IllegalArgumentException(String.format("Unsupported parameter type for GET request: %s", obj.getClass().getSimpleName()));
            }
        }
        return encodedPath.toString();
    }

    static HttpURLConnection createConnection(URL url) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestProperty(USER_AGENT_HEADER, getUserAgent());
        httpURLConnection.setRequestProperty(CONTENT_TYPE_HEADER, getMimeContentType());
        httpURLConnection.setChunkedStreamingMode(0);
        return httpURLConnection;
    }

    public static Response executeAndWait(Request request) {
        List<Response> executeBatchAndWait = executeBatchAndWait(request);
        if (executeBatchAndWait == null || executeBatchAndWait.size() != 1) {
            throw new FacebookException("invalid state: expected a single response");
        }
        return executeBatchAndWait.get(0);
    }

    public static List<Response> executeBatchAndWait(RequestBatch requestBatch) {
        Validate.notEmptyAndContainsNoNulls(requestBatch, "requests");
        try {
            return executeConnectionAndWait(toHttpConnection(requestBatch), requestBatch);
        } catch (Exception e) {
            List<Response> constructErrorResponses = Response.constructErrorResponses(requestBatch.getRequests(), null, new FacebookException(e));
            runCallbacks(requestBatch, constructErrorResponses);
            return constructErrorResponses;
        }
    }

    public static List<Response> executeBatchAndWait(Collection<Request> collection) {
        return executeBatchAndWait(new RequestBatch(collection));
    }

    public static List<Response> executeBatchAndWait(Request... requestArr) {
        Validate.notNull(requestArr, "requests");
        return executeBatchAndWait(Arrays.asList(requestArr));
    }

    public static RequestAsyncTask executeBatchAsync(RequestBatch requestBatch) {
        Validate.notEmptyAndContainsNoNulls(requestBatch, "requests");
        RequestAsyncTask requestAsyncTask = new RequestAsyncTask(requestBatch);
        requestAsyncTask.executeOnSettingsExecutor();
        return requestAsyncTask;
    }

    public static RequestAsyncTask executeBatchAsync(Collection<Request> collection) {
        return executeBatchAsync(new RequestBatch(collection));
    }

    public static RequestAsyncTask executeBatchAsync(Request... requestArr) {
        Validate.notNull(requestArr, "requests");
        return executeBatchAsync(Arrays.asList(requestArr));
    }

    public static List<Response> executeConnectionAndWait(HttpURLConnection httpURLConnection, RequestBatch requestBatch) {
        List<Response> fromHttpConnection = Response.fromHttpConnection(httpURLConnection, requestBatch);
        Utility.disconnectQuietly(httpURLConnection);
        int size = requestBatch.size();
        if (size != fromHttpConnection.size()) {
            throw new FacebookException(String.format("Received %d responses while expecting %d", Integer.valueOf(fromHttpConnection.size()), Integer.valueOf(size)));
        }
        runCallbacks(requestBatch, fromHttpConnection);
        HashSet hashSet = new HashSet();
        Iterator<Request> it = requestBatch.iterator();
        while (it.hasNext()) {
            Request next = it.next();
            if (next.session != null) {
                hashSet.add(next.session);
            }
        }
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            ((Session) it2.next()).extendAccessTokenIfNeeded();
        }
        return fromHttpConnection;
    }

    public static List<Response> executeConnectionAndWait(HttpURLConnection httpURLConnection, Collection<Request> collection) {
        return executeConnectionAndWait(httpURLConnection, new RequestBatch(collection));
    }

    public static RequestAsyncTask executeConnectionAsync(Handler handler, HttpURLConnection httpURLConnection, RequestBatch requestBatch) {
        Validate.notNull(httpURLConnection, "connection");
        RequestAsyncTask requestAsyncTask = new RequestAsyncTask(httpURLConnection, requestBatch);
        requestBatch.setCallbackHandler(handler);
        requestAsyncTask.executeOnSettingsExecutor();
        return requestAsyncTask;
    }

    public static RequestAsyncTask executeConnectionAsync(HttpURLConnection httpURLConnection, RequestBatch requestBatch) {
        return executeConnectionAsync(null, httpURLConnection, requestBatch);
    }

    public static RequestAsyncTask executeGraphPathRequestAsync(Session session, String str, Callback callback) {
        return newGraphPathRequest(session, str, callback).executeAsync();
    }

    public static RequestAsyncTask executeMeRequestAsync(Session session, GraphUserCallback graphUserCallback) {
        return newMeRequest(session, graphUserCallback).executeAsync();
    }

    public static RequestAsyncTask executeMyFriendsRequestAsync(Session session, GraphUserListCallback graphUserListCallback) {
        return newMyFriendsRequest(session, graphUserListCallback).executeAsync();
    }

    public static RequestAsyncTask executePlacesSearchRequestAsync(Session session, Location location, int i, int i2, String str, GraphPlaceListCallback graphPlaceListCallback) {
        return newPlacesSearchRequest(session, location, i, i2, str, graphPlaceListCallback).executeAsync();
    }

    public static RequestAsyncTask executePostRequestAsync(Session session, String str, GraphObject graphObject, Callback callback) {
        return newPostRequest(session, str, graphObject, callback).executeAsync();
    }

    public static RequestAsyncTask executeRestRequestAsync(Session session, String str, Bundle bundle, HttpMethod httpMethod) {
        return newRestRequest(session, str, bundle, httpMethod).executeAsync();
    }

    public static RequestAsyncTask executeStatusUpdateRequestAsync(Session session, String str, Callback callback) {
        return newStatusUpdateRequest(session, str, callback).executeAsync();
    }

    public static RequestAsyncTask executeUploadPhotoRequestAsync(Session session, Bitmap bitmap, Callback callback) {
        return newUploadPhotoRequest(session, bitmap, callback).executeAsync();
    }

    public static RequestAsyncTask executeUploadPhotoRequestAsync(Session session, File file, Callback callback) {
        return newUploadPhotoRequest(session, file, callback).executeAsync();
    }

    private static String getBatchAppId(RequestBatch requestBatch) {
        if (!Utility.isNullOrEmpty(requestBatch.getBatchApplicationId())) {
            return requestBatch.getBatchApplicationId();
        }
        Iterator<Request> it = requestBatch.iterator();
        while (it.hasNext()) {
            Session session = it.next().session;
            if (session != null) {
                return session.getApplicationId();
            }
        }
        return defaultBatchApplicationId;
    }

    public static final String getDefaultBatchApplicationId() {
        return defaultBatchApplicationId;
    }

    private static String getMimeContentType() {
        return String.format("multipart/form-data; boundary=%s", MIME_BOUNDARY);
    }

    private static String getUserAgent() {
        if (userAgent == null) {
            userAgent = String.format("%s.%s", USER_AGENT_BASE, FacebookSdkVersion.BUILD);
        }
        return userAgent;
    }

    private static boolean isSupportedAttachmentType(Object obj) {
        return (obj instanceof Bitmap) || (obj instanceof byte[]) || (obj instanceof ParcelFileDescriptor);
    }

    public static boolean isSupportedParameterType(Object obj) {
        return (obj instanceof String) || (obj instanceof Boolean) || (obj instanceof Number) || (obj instanceof Date);
    }

    public static Request newGraphPathRequest(Session session, String str, Callback callback) {
        return new Request(session, str, null, null, callback);
    }

    public static Request newMeRequest(Session session, GraphUserCallback graphUserCallback) {
        return new Request(session, f125ME, null, null, new Callback() {
            C01961() {
            }

            @Override
            public final void onCompleted(Response response) {
                if (GraphUserCallback.this != null) {
                    GraphUserCallback.this.onCompleted((GraphUser) response.getGraphObjectAs(GraphUser.class), response);
                }
            }
        });
    }

    public static Request newMyFriendsRequest(Session session, GraphUserListCallback graphUserListCallback) {
        return new Request(session, MY_FRIENDS, null, null, new Callback() {
            C01972() {
            }

            @Override
            public final void onCompleted(Response response) {
                if (GraphUserListCallback.this != null) {
                    GraphUserListCallback.this.onCompleted(Request.typedListFromResponse(response, GraphUser.class), response);
                }
            }
        });
    }

    public static Request newPlacesSearchRequest(Session session, Location location, int i, int i2, String str, GraphPlaceListCallback graphPlaceListCallback) {
        if (location == null && Utility.isNullOrEmpty(str)) {
            throw new FacebookException("Either location or searchText must be specified.");
        }
        Bundle bundle = new Bundle(5);
        bundle.putString(ServerProtocol.DIALOG_PARAM_TYPE, "place");
        bundle.putInt("limit", i2);
        if (location != null) {
            bundle.putString("center", String.format(Locale.US, "%f,%f", Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude())));
            bundle.putInt("distance", i);
        }
        if (!Utility.isNullOrEmpty(str)) {
            bundle.putString("q", str);
        }
        return new Request(session, SEARCH, bundle, HttpMethod.GET, new Callback() {
            C01983() {
            }

            @Override
            public final void onCompleted(Response response) {
                if (GraphPlaceListCallback.this != null) {
                    GraphPlaceListCallback.this.onCompleted(Request.typedListFromResponse(response, GraphPlace.class), response);
                }
            }
        });
    }

    public static Request newPostRequest(Session session, String str, GraphObject graphObject, Callback callback) {
        Request request = new Request(session, str, null, HttpMethod.POST, callback);
        request.graphObject = graphObject;
        return request;
    }

    public static Request newRestRequest(Session session, String str, Bundle bundle, HttpMethod httpMethod) {
        Request request = new Request(session, null, bundle, httpMethod);
        request.restMethod = str;
        return request;
    }

    public static Request newStatusUpdateRequest(Session session, String str, Callback callback) {
        Bundle bundle = new Bundle();
        bundle.putString("message", str);
        return new Request(session, MY_FEED, bundle, HttpMethod.POST, callback);
    }

    public static Request newUploadPhotoRequest(Session session, Bitmap bitmap, Callback callback) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable(PICTURE_PARAM, bitmap);
        return new Request(session, MY_PHOTOS, bundle, HttpMethod.POST, callback);
    }

    public static Request newUploadPhotoRequest(Session session, File file, Callback callback) {
        ParcelFileDescriptor open = ParcelFileDescriptor.open(file, 268435456);
        Bundle bundle = new Bundle(1);
        bundle.putParcelable(PICTURE_PARAM, open);
        return new Request(session, MY_PHOTOS, bundle, HttpMethod.POST, callback);
    }

    public static Request newUploadVideoRequest(Session session, File file, Callback callback) {
        ParcelFileDescriptor open = ParcelFileDescriptor.open(file, 268435456);
        Bundle bundle = new Bundle(1);
        bundle.putParcelable(file.getName(), open);
        return new Request(session, MY_VIDEOS, bundle, HttpMethod.POST, callback);
    }

    public static String parameterToString(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if ((obj instanceof Boolean) || (obj instanceof Number)) {
            return obj.toString();
        }
        if (obj instanceof Date) {
            return new SimpleDateFormat(ISO_8601_FORMAT_STRING, Locale.US).format(obj);
        }
        throw new IllegalArgumentException("Unsupported parameter type.");
    }

    private static void processGraphObject(GraphObject graphObject, String str, KeyValueSerializer keyValueSerializer) {
        boolean z;
        if (str.startsWith("me/") || str.startsWith("/me/")) {
            int indexOf = str.indexOf(":");
            int indexOf2 = str.indexOf("?");
            z = indexOf > 3 && (indexOf2 == -1 || indexOf < indexOf2);
        } else {
            z = false;
        }
        for (Map.Entry<String, Object> entry : graphObject.asMap().entrySet()) {
            processGraphObjectProperty(entry.getKey(), entry.getValue(), keyValueSerializer, z && entry.getKey().equalsIgnoreCase("image"));
        }
    }

    private static void processGraphObjectProperty(String str, Object obj, KeyValueSerializer keyValueSerializer, boolean z) {
        Class<?> cls;
        Object obj2;
        Class<?> cls2 = obj.getClass();
        if (GraphObject.class.isAssignableFrom(cls2)) {
            JSONObject innerJSONObject = ((GraphObject) obj).getInnerJSONObject();
            cls = innerJSONObject.getClass();
            obj2 = innerJSONObject;
        } else if (GraphObjectList.class.isAssignableFrom(cls2)) {
            JSONArray innerJSONArray = ((GraphObjectList) obj).getInnerJSONArray();
            cls = innerJSONArray.getClass();
            obj2 = innerJSONArray;
        } else {
            cls = cls2;
            obj2 = obj;
        }
        if (JSONObject.class.isAssignableFrom(cls)) {
            JSONObject jSONObject = (JSONObject) obj2;
            if (z) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    processGraphObjectProperty(String.format("%s[%s]", str, next), jSONObject.opt(next), keyValueSerializer, z);
                }
                return;
            }
            if (jSONObject.has("id")) {
                processGraphObjectProperty(str, jSONObject.optString("id"), keyValueSerializer, z);
                return;
            } else {
                if (jSONObject.has("url")) {
                    processGraphObjectProperty(str, jSONObject.optString("url"), keyValueSerializer, z);
                    return;
                }
                return;
            }
        }
        if (JSONArray.class.isAssignableFrom(cls)) {
            JSONArray jSONArray = (JSONArray) obj2;
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                processGraphObjectProperty(String.format("%s[%d]", str, Integer.valueOf(i)), jSONArray.opt(i), keyValueSerializer, z);
            }
            return;
        }
        if (String.class.isAssignableFrom(cls) || Number.class.isAssignableFrom(cls) || Boolean.class.isAssignableFrom(cls)) {
            keyValueSerializer.writeString(str, obj2.toString());
        } else if (Date.class.isAssignableFrom(cls)) {
            keyValueSerializer.writeString(str, new SimpleDateFormat(ISO_8601_FORMAT_STRING, Locale.US).format((Date) obj2));
        }
    }

    static void runCallbacks(RequestBatch requestBatch, List<Response> list) {
        int size = requestBatch.size();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < size; i++) {
            Request request = requestBatch.get(i);
            if (request.callback != null) {
                arrayList.add(new Pair(request.callback, list.get(i)));
            }
        }
        if (arrayList.size() > 0) {
            RunnableC01994 runnableC01994 = new Runnable() {
                final ArrayList val$callbacks;
                final RequestBatch val$requests;

                RunnableC01994(ArrayList arrayList2, RequestBatch requestBatch2) {
                    r1 = arrayList2;
                    r2 = requestBatch2;
                }

                @Override
                public final void run() {
                    Iterator it = r1.iterator();
                    while (it.hasNext()) {
                        Pair pair = (Pair) it.next();
                        ((Callback) pair.first).onCompleted((Response) pair.second);
                    }
                    Iterator<RequestBatch.Callback> it2 = r2.getCallbacks().iterator();
                    while (it2.hasNext()) {
                        it2.next().onBatchCompleted(r2);
                    }
                }
            };
            Handler callbackHandler = requestBatch2.getCallbackHandler();
            if (callbackHandler == null) {
                runnableC01994.run();
            } else {
                callbackHandler.post(runnableC01994);
            }
        }
    }

    private static void serializeAttachments(Bundle bundle, Serializer serializer) {
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (isSupportedAttachmentType(obj)) {
                serializer.writeObject(str, obj);
            }
        }
    }

    private static void serializeParameters(Bundle bundle, Serializer serializer) {
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (isSupportedParameterType(obj)) {
                serializer.writeObject(str, obj);
            }
        }
    }

    private static void serializeRequestsAsJSON(Serializer serializer, Collection<Request> collection, Bundle bundle) {
        JSONArray jSONArray = new JSONArray();
        Iterator<Request> it = collection.iterator();
        while (it.hasNext()) {
            it.next().serializeToBatch(jSONArray, bundle);
        }
        serializer.writeString(BATCH_PARAM, jSONArray.toString());
    }

    private void serializeToBatch(JSONArray jSONArray, Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        if (this.batchEntryName != null) {
            jSONObject.put(BATCH_ENTRY_NAME_PARAM, this.batchEntryName);
            jSONObject.put(BATCH_ENTRY_OMIT_RESPONSE_ON_SUCCESS_PARAM, this.batchEntryOmitResultOnSuccess);
        }
        if (this.batchEntryDependsOn != null) {
            jSONObject.put(BATCH_ENTRY_DEPENDS_ON_PARAM, this.batchEntryDependsOn);
        }
        String urlForBatchedRequest = getUrlForBatchedRequest();
        jSONObject.put(BATCH_RELATIVE_URL_PARAM, urlForBatchedRequest);
        jSONObject.put(BATCH_METHOD_PARAM, this.httpMethod);
        if (this.session != null) {
            Logger.registerAccessToken(this.session.getAccessToken());
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = this.parameters.keySet().iterator();
        while (it.hasNext()) {
            Object obj = this.parameters.get(it.next());
            if (isSupportedAttachmentType(obj)) {
                String format = String.format("%s%d", ATTACHMENT_FILENAME_PREFIX, Integer.valueOf(bundle.size()));
                arrayList.add(format);
                Utility.putObjectInBundle(bundle, format, obj);
            }
        }
        if (!arrayList.isEmpty()) {
            jSONObject.put(ATTACHED_FILES_PARAM, TextUtils.join(",", arrayList));
        }
        if (this.graphObject != null) {
            ArrayList arrayList2 = new ArrayList();
            processGraphObject(this.graphObject, urlForBatchedRequest, new KeyValueSerializer() {
                final ArrayList val$keysAndValues;

                C02005(ArrayList arrayList22) {
                    r2 = arrayList22;
                }

                @Override
                public void writeString(String str, String str2) {
                    r2.add(String.format("%s=%s", str, URLEncoder.encode(str2, "UTF-8")));
                }
            });
            jSONObject.put(BATCH_BODY_PARAM, TextUtils.join("&", arrayList22));
        }
        jSONArray.put(jSONObject);
    }

    static final void serializeToUrlConnection(RequestBatch requestBatch, HttpURLConnection httpURLConnection) {
        Logger logger = new Logger(LoggingBehavior.REQUESTS, "Request");
        int size = requestBatch.size();
        HttpMethod httpMethod = size == 1 ? requestBatch.get(0).httpMethod : HttpMethod.POST;
        httpURLConnection.setRequestMethod(httpMethod.name());
        URL url = httpURLConnection.getURL();
        logger.append("Request:\n");
        logger.appendKeyValue("Id", requestBatch.getId());
        logger.appendKeyValue("URL", url);
        logger.appendKeyValue("Method", httpURLConnection.getRequestMethod());
        logger.appendKeyValue(USER_AGENT_HEADER, httpURLConnection.getRequestProperty(USER_AGENT_HEADER));
        logger.appendKeyValue(CONTENT_TYPE_HEADER, httpURLConnection.getRequestProperty(CONTENT_TYPE_HEADER));
        httpURLConnection.setConnectTimeout(requestBatch.getTimeout());
        httpURLConnection.setReadTimeout(requestBatch.getTimeout());
        if (!(httpMethod == HttpMethod.POST)) {
            logger.log();
            return;
        }
        httpURLConnection.setDoOutput(true);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
        try {
            Serializer serializer = new Serializer(bufferedOutputStream, logger);
            if (size == 1) {
                Request request = requestBatch.get(0);
                logger.append("  Parameters:\n");
                serializeParameters(request.parameters, serializer);
                logger.append("  Attachments:\n");
                serializeAttachments(request.parameters, serializer);
                if (request.graphObject != null) {
                    processGraphObject(request.graphObject, url.getPath(), serializer);
                }
            } else {
                String batchAppId = getBatchAppId(requestBatch);
                if (Utility.isNullOrEmpty(batchAppId)) {
                    throw new FacebookException("At least one request in a batch must have an open Session, or a default app ID must be specified.");
                }
                serializer.writeString(BATCH_APP_ID_PARAM, batchAppId);
                Bundle bundle = new Bundle();
                serializeRequestsAsJSON(serializer, requestBatch, bundle);
                logger.append("  Attachments:\n");
                serializeAttachments(bundle, serializer);
            }
            bufferedOutputStream.close();
            logger.log();
        } catch (Throwable th) {
            bufferedOutputStream.close();
            throw th;
        }
    }

    public static final void setDefaultBatchApplicationId(String str) {
        defaultBatchApplicationId = str;
    }

    public static HttpURLConnection toHttpConnection(RequestBatch requestBatch) {
        Iterator<Request> it = requestBatch.iterator();
        while (it.hasNext()) {
            it.next().validate();
        }
        try {
            try {
                HttpURLConnection createConnection = createConnection(requestBatch.size() == 1 ? new URL(requestBatch.get(0).getUrlForSingleRequest()) : new URL(ServerProtocol.GRAPH_URL));
                serializeToUrlConnection(requestBatch, createConnection);
                return createConnection;
            } catch (IOException e) {
                throw new FacebookException("could not construct request body", e);
            } catch (JSONException e2) {
                throw new FacebookException("could not construct request body", e2);
            }
        } catch (MalformedURLException e3) {
            throw new FacebookException("could not construct URL for request", e3);
        }
    }

    public static HttpURLConnection toHttpConnection(Collection<Request> collection) {
        Validate.notEmptyAndContainsNoNulls(collection, "requests");
        return toHttpConnection(new RequestBatch(collection));
    }

    public static HttpURLConnection toHttpConnection(Request... requestArr) {
        return toHttpConnection(Arrays.asList(requestArr));
    }

    public static <T extends GraphObject> List<T> typedListFromResponse(Response response, Class<T> cls) {
        GraphObjectList<GraphObject> data;
        GraphMultiResult graphMultiResult = (GraphMultiResult) response.getGraphObjectAs(GraphMultiResult.class);
        if (graphMultiResult != null && (data = graphMultiResult.getData()) != null) {
            return data.castToListOf(cls);
        }
        return null;
    }

    private void validate() {
        if (this.graphPath != null && this.restMethod != null) {
            throw new IllegalArgumentException("Only one of a graph path or REST method may be specified per request.");
        }
    }

    public final Response executeAndWait() {
        return executeAndWait(this);
    }

    public final RequestAsyncTask executeAsync() {
        return executeBatchAsync(this);
    }

    public final String getBatchEntryDependsOn() {
        return this.batchEntryDependsOn;
    }

    public final String getBatchEntryName() {
        return this.batchEntryName;
    }

    public final boolean getBatchEntryOmitResultOnSuccess() {
        return this.batchEntryOmitResultOnSuccess;
    }

    public final Callback getCallback() {
        return this.callback;
    }

    public final GraphObject getGraphObject() {
        return this.graphObject;
    }

    public final String getGraphPath() {
        return this.graphPath;
    }

    public final HttpMethod getHttpMethod() {
        return this.httpMethod;
    }

    public final Bundle getParameters() {
        return this.parameters;
    }

    public final String getRestMethod() {
        return this.restMethod;
    }

    public final Session getSession() {
        return this.session;
    }

    final String getUrlForBatchedRequest() {
        if (this.overriddenURL != null) {
            throw new FacebookException("Can't override URL for a batch request");
        }
        String str = this.restMethod != null ? ServerProtocol.BATCHED_REST_METHOD_URL_BASE + this.restMethod : this.graphPath;
        addCommonParameters();
        return appendParametersToBaseUrl(str);
    }

    final String getUrlForSingleRequest() {
        if (this.overriddenURL != null) {
            return this.overriddenURL.toString();
        }
        String str = this.restMethod != null ? ServerProtocol.REST_URL_BASE + this.restMethod : ServerProtocol.GRAPH_URL_BASE + this.graphPath;
        addCommonParameters();
        return appendParametersToBaseUrl(str);
    }

    public final void setBatchEntryDependsOn(String str) {
        this.batchEntryDependsOn = str;
    }

    public final void setBatchEntryName(String str) {
        this.batchEntryName = str;
    }

    public final void setBatchEntryOmitResultOnSuccess(boolean z) {
        this.batchEntryOmitResultOnSuccess = z;
    }

    public final void setCallback(Callback callback) {
        this.callback = callback;
    }

    public final void setGraphObject(GraphObject graphObject) {
        this.graphObject = graphObject;
    }

    public final void setGraphPath(String str) {
        this.graphPath = str;
    }

    public final void setHttpMethod(HttpMethod httpMethod) {
        if (this.overriddenURL != null && httpMethod != HttpMethod.GET) {
            throw new FacebookException("Can't change HTTP method on request with overridden URL.");
        }
        if (httpMethod == null) {
            httpMethod = HttpMethod.GET;
        }
        this.httpMethod = httpMethod;
    }

    public final void setParameters(Bundle bundle) {
        this.parameters = bundle;
    }

    public final void setRestMethod(String str) {
        this.restMethod = str;
    }

    public final void setSession(Session session) {
        this.session = session;
    }

    public String toString() {
        return "{Request:  session: " + this.session + ", graphPath: " + this.graphPath + ", graphObject: " + this.graphObject + ", restMethod: " + this.restMethod + ", httpMethod: " + this.httpMethod + ", parameters: " + this.parameters + "}";
    }
}
