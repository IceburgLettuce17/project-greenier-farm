package com.facebook.widget;

import android.graphics.Bitmap;

class ImageResponse {
    private Bitmap bitmap;
    private Exception error;
    private boolean isCachedRedirect;
    private ImageRequest request;

    ImageResponse(ImageRequest imageRequest, Exception exc, boolean z, Bitmap bitmap) {
        this.request = imageRequest;
        this.error = exc;
        this.bitmap = bitmap;
        this.isCachedRedirect = z;
    }

    Bitmap getBitmap() {
        return this.bitmap;
    }

    Exception getError() {
        return this.error;
    }

    ImageRequest getRequest() {
        return this.request;
    }

    boolean isCachedRedirect() {
        return this.isCachedRedirect;
    }
}
