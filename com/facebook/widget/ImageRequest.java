package com.facebook.widget;

import android.content.Context;
import android.net.Uri;
import com.facebook.internal.Validate;
import java.net.URL;

class ImageRequest {
    private static final String HEIGHT_PARAM = "height";
    private static final String MIGRATION_PARAM = "migration_overrides";
    private static final String MIGRATION_VALUE = "{october_2012:true}";
    private static final String PROFILEPIC_URL_FORMAT = "https://graph.facebook.com/%s/picture";
    static final int UNSPECIFIED_DIMENSION = 0;
    private static final String WIDTH_PARAM = "width";
    private boolean allowCachedRedirects;
    private Callback callback;
    private Object callerTag;
    private Context context;
    private URL imageUrl;

    class Builder {
        private boolean allowCachedRedirects;
        private Callback callback;
        private Object callerTag;
        private Context context;
        private URL imageUrl;

        Builder(Context context, URL url) {
            Validate.notNull(url, "imageUrl");
            this.context = context;
            this.imageUrl = url;
        }

        ImageRequest build() {
            return new ImageRequest(this);
        }

        Builder setAllowCachedRedirects(boolean z) {
            this.allowCachedRedirects = z;
            return this;
        }

        Builder setCallback(Callback callback) {
            this.callback = callback;
            return this;
        }

        Builder setCallerTag(Object obj) {
            this.callerTag = obj;
            return this;
        }
    }

    interface Callback {
        void onCompleted(ImageResponse imageResponse);
    }

    private ImageRequest(Builder builder) {
        this.context = builder.context;
        this.imageUrl = builder.imageUrl;
        this.callback = builder.callback;
        this.allowCachedRedirects = builder.allowCachedRedirects;
        this.callerTag = builder.callerTag == null ? new Object() : builder.callerTag;
    }

    static URL getProfilePictureUrl(String str, int i, int i2) {
        Validate.notNullOrEmpty(str, "userId");
        int max = Math.max(i, 0);
        int max2 = Math.max(i2, 0);
        if (max == 0 && max2 == 0) {
            throw new IllegalArgumentException("Either width or height must be greater than 0");
        }
        Uri.Builder encodedPath = new Uri.Builder().encodedPath(String.format(PROFILEPIC_URL_FORMAT, str));
        if (max2 != 0) {
            encodedPath.appendQueryParameter(HEIGHT_PARAM, String.valueOf(max2));
        }
        if (max != 0) {
            encodedPath.appendQueryParameter(WIDTH_PARAM, String.valueOf(max));
        }
        encodedPath.appendQueryParameter(MIGRATION_PARAM, MIGRATION_VALUE);
        return new URL(encodedPath.toString());
    }

    Callback getCallback() {
        return this.callback;
    }

    Object getCallerTag() {
        return this.callerTag;
    }

    Context getContext() {
        return this.context;
    }

    URL getImageUrl() {
        return this.imageUrl;
    }

    boolean isCachedRedirectAllowed() {
        return this.allowCachedRedirects;
    }
}
