package com.facebook.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.facebook.FacebookException;
import com.facebook.LoggingBehavior;
import com.facebook.android.C0217R;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.widget.ImageRequest;
import java.net.MalformedURLException;

public class ProfilePictureView extends FrameLayout {
    private static final String BITMAP_HEIGHT_KEY = "ProfilePictureView_height";
    private static final String BITMAP_KEY = "ProfilePictureView_bitmap";
    private static final String BITMAP_WIDTH_KEY = "ProfilePictureView_width";
    public static final int CUSTOM = -1;
    private static final boolean IS_CROPPED_DEFAULT_VALUE = true;
    private static final String IS_CROPPED_KEY = "ProfilePictureView_isCropped";
    public static final int LARGE = -4;
    private static final int MIN_SIZE = 1;
    public static final int NORMAL = -3;
    private static final String PENDING_REFRESH_KEY = "ProfilePictureView_refresh";
    private static final String PRESET_SIZE_KEY = "ProfilePictureView_presetSize";
    private static final String PROFILE_ID_KEY = "ProfilePictureView_profileId";
    public static final int SMALL = -2;
    private static final String SUPER_STATE_KEY = "ProfilePictureView_superState";
    public static final String TAG = ProfilePictureView.class.getSimpleName();
    private ImageView image;
    private Bitmap imageContents;
    private boolean isCropped;
    private ImageRequest lastRequest;
    private OnErrorListener onErrorListener;
    private int presetSizeType;
    private String profileId;
    private int queryHeight;
    private int queryWidth;

    public interface OnErrorListener {
        void onError(FacebookException facebookException);
    }

    public ProfilePictureView(Context context) {
        super(context);
        this.queryHeight = 0;
        this.queryWidth = 0;
        this.isCropped = IS_CROPPED_DEFAULT_VALUE;
        this.presetSizeType = -1;
        initialize(context);
    }

    public ProfilePictureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.queryHeight = 0;
        this.queryWidth = 0;
        this.isCropped = IS_CROPPED_DEFAULT_VALUE;
        this.presetSizeType = -1;
        initialize(context);
        parseAttributes(attributeSet);
    }

    public ProfilePictureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.queryHeight = 0;
        this.queryWidth = 0;
        this.isCropped = IS_CROPPED_DEFAULT_VALUE;
        this.presetSizeType = -1;
        initialize(context);
        parseAttributes(attributeSet);
    }

    private int getPresetSizeInPixels(boolean z) {
        int i;
        switch (this.presetSizeType) {
            case LARGE:
                i = C0217R.dimen.com_facebook_profilepictureview_preset_size_large;
                break;
            case NORMAL:
                i = C0217R.dimen.com_facebook_profilepictureview_preset_size_normal;
                break;
            case SMALL:
                i = C0217R.dimen.com_facebook_profilepictureview_preset_size_small;
                break;
            case -1:
                if (!z) {
                    return 0;
                }
                i = C0217R.dimen.com_facebook_profilepictureview_preset_size_normal;
                break;
            default:
                return 0;
        }
        return getResources().getDimensionPixelSize(i);
    }

    private void initialize(Context context) {
        removeAllViews();
        this.image = new ImageView(context);
        this.image.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.image.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        addView(this.image);
    }

    private void parseAttributes(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C0217R.styleable.com_facebook_profile_picture_view);
        setPresetSize(obtainStyledAttributes.getInt(0, -1));
        this.isCropped = obtainStyledAttributes.getBoolean(1, IS_CROPPED_DEFAULT_VALUE);
        obtainStyledAttributes.recycle();
    }

    public void processResponse(ImageResponse imageResponse) {
        if (imageResponse.getRequest() == this.lastRequest) {
            this.lastRequest = null;
            Bitmap bitmap = imageResponse.getBitmap();
            Exception error = imageResponse.getError();
            if (error != null) {
                OnErrorListener onErrorListener = this.onErrorListener;
                if (onErrorListener != null) {
                    onErrorListener.onError(new FacebookException("Error in downloading profile picture for profileId: " + getProfileId(), error));
                    return;
                } else {
                    Logger.log(LoggingBehavior.REQUESTS, 6, TAG, error.toString());
                    return;
                }
            }
            if (bitmap != null) {
                setImageBitmap(bitmap);
                if (imageResponse.isCachedRedirect()) {
                    sendImageRequest(false);
                }
            }
        }
    }

    private void refreshImage(boolean z) {
        boolean updateImageQueryParameters = updateImageQueryParameters();
        if (this.profileId == null || this.profileId.length() == 0 || (this.queryWidth == 0 && this.queryHeight == 0)) {
            setBlankProfilePicture();
        } else if (updateImageQueryParameters || z) {
            sendImageRequest(IS_CROPPED_DEFAULT_VALUE);
        }
    }

    private void sendImageRequest(boolean z) {
        try {
            ImageRequest build = new ImageRequest.Builder(getContext(), ImageRequest.getProfilePictureUrl(this.profileId, this.queryWidth, this.queryHeight)).setAllowCachedRedirects(z).setCallerTag(this).setCallback(new ImageRequest.Callback() {
                @Override
                public void onCompleted(ImageResponse imageResponse) {
                    ProfilePictureView.this.processResponse(imageResponse);
                }
            }).build();
            if (this.lastRequest != null) {
                ImageDownloader.cancelRequest(this.lastRequest);
            }
            this.lastRequest = build;
            ImageDownloader.downloadAsync(build);
        } catch (MalformedURLException e) {
            Logger.log(LoggingBehavior.REQUESTS, 6, TAG, e.toString());
        }
    }

    private void setBlankProfilePicture() {
        setImageBitmap(BitmapFactory.decodeResource(getResources(), isCropped() ? C0217R.drawable.com_facebook_profile_picture_blank_square : C0217R.drawable.com_facebook_profile_picture_blank_portrait));
    }

    private void setImageBitmap(Bitmap bitmap) {
        if (this.image == null || bitmap == null) {
            return;
        }
        this.imageContents = bitmap;
        this.image.setImageBitmap(bitmap);
    }

    private boolean updateImageQueryParameters() {
        int i;
        int height = getHeight();
        int width = getWidth();
        if (width > 0 && height > 0) {
            int presetSizeInPixels = getPresetSizeInPixels(false);
            if (presetSizeInPixels != 0) {
                height = presetSizeInPixels;
            } else {
                presetSizeInPixels = width;
            }
            if (presetSizeInPixels <= height) {
                i = isCropped() ? presetSizeInPixels : 0;
            } else {
                presetSizeInPixels = isCropped() ? height : 0;
                i = height;
            }
            r2 = (presetSizeInPixels == this.queryWidth && i == this.queryHeight) ? false : IS_CROPPED_DEFAULT_VALUE;
            this.queryWidth = presetSizeInPixels;
            this.queryHeight = i;
        }
        return r2;
    }

    public final OnErrorListener getOnErrorListener() {
        return this.onErrorListener;
    }

    public final int getPresetSize() {
        return this.presetSizeType;
    }

    public final String getProfileId() {
        return this.profileId;
    }

    public final boolean isCropped() {
        return this.isCropped;
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.lastRequest = null;
    }

    @Override
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        refreshImage(false);
    }

    @Override
    protected void onMeasure(int i, int i2) {
        int i3;
        boolean z = IS_CROPPED_DEFAULT_VALUE;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        boolean z2 = false;
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i);
        if (View.MeasureSpec.getMode(i2) != 1073741824 && layoutParams.height == -2) {
            size = getPresetSizeInPixels(IS_CROPPED_DEFAULT_VALUE);
            i2 = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
            z2 = true;
        }
        if (View.MeasureSpec.getMode(i) == 1073741824 || layoutParams.width != -2) {
            z = z2;
            i3 = size2;
        } else {
            i3 = getPresetSizeInPixels(IS_CROPPED_DEFAULT_VALUE);
            i = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
        }
        if (!z) {
            super.onMeasure(i, i2);
        } else {
            setMeasuredDimension(i3, size);
            measureChildren(i, i2);
        }
    }

    @Override
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable.getClass() != Bundle.class) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        super.onRestoreInstanceState(bundle.getParcelable(SUPER_STATE_KEY));
        this.profileId = bundle.getString(PROFILE_ID_KEY);
        this.presetSizeType = bundle.getInt(PRESET_SIZE_KEY);
        this.isCropped = bundle.getBoolean(IS_CROPPED_KEY);
        this.queryWidth = bundle.getInt(BITMAP_WIDTH_KEY);
        this.queryHeight = bundle.getInt(BITMAP_HEIGHT_KEY);
        setImageBitmap((Bitmap) bundle.getParcelable(BITMAP_KEY));
        if (bundle.getBoolean(PENDING_REFRESH_KEY)) {
            refreshImage(IS_CROPPED_DEFAULT_VALUE);
        }
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        Bundle bundle = new Bundle();
        bundle.putParcelable(SUPER_STATE_KEY, onSaveInstanceState);
        bundle.putString(PROFILE_ID_KEY, this.profileId);
        bundle.putInt(PRESET_SIZE_KEY, this.presetSizeType);
        bundle.putBoolean(IS_CROPPED_KEY, this.isCropped);
        bundle.putParcelable(BITMAP_KEY, this.imageContents);
        bundle.putInt(BITMAP_WIDTH_KEY, this.queryWidth);
        bundle.putInt(BITMAP_HEIGHT_KEY, this.queryHeight);
        bundle.putBoolean(PENDING_REFRESH_KEY, this.lastRequest != null ? IS_CROPPED_DEFAULT_VALUE : false);
        return bundle;
    }

    public final void setCropped(boolean z) {
        this.isCropped = z;
        refreshImage(false);
    }

    public final void setOnErrorListener(OnErrorListener onErrorListener) {
        this.onErrorListener = onErrorListener;
    }

    public final void setPresetSize(int i) {
        switch (i) {
            case LARGE:
            case NORMAL:
            case SMALL:
            case -1:
                this.presetSizeType = i;
                requestLayout();
                return;
            default:
                throw new IllegalArgumentException("Must use a predefined preset size");
        }
    }

    public final void setProfileId(String str) {
        boolean z = false;
        if (Utility.isNullOrEmpty(this.profileId) || !this.profileId.equalsIgnoreCase(str)) {
            setBlankProfilePicture();
            z = IS_CROPPED_DEFAULT_VALUE;
        }
        this.profileId = str;
        refreshImage(z);
    }
}
