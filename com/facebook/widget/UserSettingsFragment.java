package com.facebook.widget;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.SessionDefaultAudience;
import com.facebook.SessionLoginBehavior;
import com.facebook.SessionState;
import com.facebook.android.C0217R;
import com.facebook.model.GraphUser;
import com.facebook.widget.ImageRequest;
import com.facebook.widget.LoginButton;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class UserSettingsFragment extends FacebookFragment {
    private static final String FIELDS = "fields";

    private static final String f132ID = "id";
    private static final String NAME = "name";
    private static final String PICTURE = "picture";
    private static final String REQUEST_FIELDS = TextUtils.join(",", new String[]{f132ID, NAME, PICTURE});
    private TextView connectedStateLabel;
    private LoginButton loginButton;
    private LoginButton.LoginButtonProperties loginButtonProperties = new LoginButton.LoginButtonProperties();
    private Session.StatusCallback sessionStatusCallback;
    private GraphUser user;
    private Session userInfoSession;
    private Drawable userProfilePic;
    private String userProfilePicID;

    private void fetchUserInfo() {
        final Session session = getSession();
        if (session == null || !session.isOpened()) {
            this.user = null;
            return;
        }
        if (session != this.userInfoSession) {
            Request newMeRequest = Request.newMeRequest(session, new Request.GraphUserCallback() {
                @Override
                public void onCompleted(GraphUser graphUser, Response response) {
                    if (session == UserSettingsFragment.this.getSession()) {
                        UserSettingsFragment.this.user = graphUser;
                        UserSettingsFragment.this.updateUI();
                    }
                    if (response.getError() != null) {
                        UserSettingsFragment.this.loginButton.handleError(response.getError().getException());
                    }
                }
            });
            Bundle bundle = new Bundle();
            bundle.putString(FIELDS, REQUEST_FIELDS);
            newMeRequest.setParameters(bundle);
            Request.executeBatchAsync(newMeRequest);
            this.userInfoSession = session;
        }
    }

    private ImageRequest getImageRequest() {
        try {
            return new ImageRequest.Builder(getActivity(), ImageRequest.getProfilePictureUrl(this.user.getId(), getResources().getDimensionPixelSize(C0217R.dimen.com_facebook_usersettingsfragment_profile_picture_width), getResources().getDimensionPixelSize(C0217R.dimen.com_facebook_usersettingsfragment_profile_picture_height))).setCallerTag(this).setCallback(new ImageRequest.Callback() {
                @Override
                public void onCompleted(ImageResponse imageResponse) {
                    UserSettingsFragment.this.processImageResponse(UserSettingsFragment.this.user.getId(), imageResponse);
                }
            }).build();
        } catch (MalformedURLException e) {
            return null;
        }
    }

    public void processImageResponse(String str, ImageResponse imageResponse) {
        Bitmap bitmap;
        if (imageResponse == null || (bitmap = imageResponse.getBitmap()) == null) {
            return;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), bitmap);
        bitmapDrawable.setBounds(0, 0, getResources().getDimensionPixelSize(C0217R.dimen.com_facebook_usersettingsfragment_profile_picture_width), getResources().getDimensionPixelSize(C0217R.dimen.com_facebook_usersettingsfragment_profile_picture_height));
        this.userProfilePic = bitmapDrawable;
        this.userProfilePicID = str;
        this.connectedStateLabel.setCompoundDrawables(null, bitmapDrawable, null, null);
        this.connectedStateLabel.setTag(imageResponse.getRequest().getImageUrl());
    }

    public void updateUI() {
        if (isAdded()) {
            if (!isSessionOpen()) {
                int color = getResources().getColor(C0217R.color.com_facebook_usersettingsfragment_not_connected_text_color);
                this.connectedStateLabel.setTextColor(color);
                this.connectedStateLabel.setShadowLayer(0.0f, 0.0f, 0.0f, color);
                this.connectedStateLabel.setText(getResources().getString(C0217R.string.com_facebook_usersettingsfragment_not_logged_in));
                this.connectedStateLabel.setCompoundDrawables(null, null, null, null);
                this.connectedStateLabel.setTag(null);
                return;
            }
            this.connectedStateLabel.setTextColor(getResources().getColor(C0217R.color.com_facebook_usersettingsfragment_connected_text_color));
            this.connectedStateLabel.setShadowLayer(1.0f, 0.0f, -1.0f, getResources().getColor(C0217R.color.com_facebook_usersettingsfragment_connected_shadow_color));
            if (this.user == null) {
                this.connectedStateLabel.setText(getResources().getString(C0217R.string.com_facebook_usersettingsfragment_logged_in));
                Drawable drawable = getResources().getDrawable(C0217R.drawable.com_facebook_profile_default_icon);
                drawable.setBounds(0, 0, getResources().getDimensionPixelSize(C0217R.dimen.com_facebook_usersettingsfragment_profile_picture_width), getResources().getDimensionPixelSize(C0217R.dimen.com_facebook_usersettingsfragment_profile_picture_height));
                this.connectedStateLabel.setCompoundDrawables(null, drawable, null, null);
                return;
            }
            ImageRequest imageRequest = getImageRequest();
            if (imageRequest != null) {
                URL imageUrl = imageRequest.getImageUrl();
                if (!imageUrl.equals(this.connectedStateLabel.getTag())) {
                    if (this.user.getId().equals(this.userProfilePicID)) {
                        this.connectedStateLabel.setCompoundDrawables(null, this.userProfilePic, null, null);
                        this.connectedStateLabel.setTag(imageUrl);
                    } else {
                        ImageDownloader.downloadAsync(imageRequest);
                    }
                }
            }
            this.connectedStateLabel.setText(this.user.getName());
        }
    }

    public void clearPermissions() {
        this.loginButtonProperties.clearPermissions();
    }

    public SessionDefaultAudience getDefaultAudience() {
        return this.loginButtonProperties.getDefaultAudience();
    }

    public SessionLoginBehavior getLoginBehavior() {
        return this.loginButtonProperties.getLoginBehavior();
    }

    public LoginButton.OnErrorListener getOnErrorListener() {
        return this.loginButtonProperties.getOnErrorListener();
    }

    List<String> getPermissions() {
        return this.loginButtonProperties.getPermissions();
    }

    public Session.StatusCallback getSessionStatusCallback() {
        return this.sessionStatusCallback;
    }

    @Override
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C0217R.layout.com_facebook_usersettingsfragment, viewGroup, false);
        this.loginButton = (LoginButton) inflate.findViewById(C0217R.id.com_facebook_usersettingsfragment_login_button);
        this.loginButton.setProperties(this.loginButtonProperties);
        this.loginButton.setFragment(this);
        Session session = getSession();
        if (session != null && !session.equals(Session.getActiveSession())) {
            this.loginButton.setSession(session);
        }
        this.connectedStateLabel = (TextView) inflate.findViewById(C0217R.id.com_facebook_usersettingsfragment_profile_name);
        if (inflate.getBackground() == null) {
            inflate.setBackgroundColor(getResources().getColor(C0217R.color.com_facebook_blue));
        } else {
            inflate.getBackground().setDither(true);
        }
        return inflate;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onResume() {
        super.onResume();
        fetchUserInfo();
        updateUI();
    }

    @Override
    protected void onSessionStateChange(SessionState sessionState, Exception exc) {
        fetchUserInfo();
        updateUI();
        if (this.sessionStatusCallback != null) {
            this.sessionStatusCallback.call(getSession(), sessionState, exc);
        }
    }

    public void setDefaultAudience(SessionDefaultAudience sessionDefaultAudience) {
        this.loginButtonProperties.setDefaultAudience(sessionDefaultAudience);
    }

    public void setLoginBehavior(SessionLoginBehavior sessionLoginBehavior) {
        this.loginButtonProperties.setLoginBehavior(sessionLoginBehavior);
    }

    public void setOnErrorListener(LoginButton.OnErrorListener onErrorListener) {
        this.loginButtonProperties.setOnErrorListener(onErrorListener);
    }

    public void setPublishPermissions(List<String> list) {
        this.loginButtonProperties.setPublishPermissions(list, getSession());
    }

    public void setReadPermissions(List<String> list) {
        this.loginButtonProperties.setReadPermissions(list, getSession());
    }

    @Override
    public void setSession(Session session) {
        super.setSession(session);
        if (this.loginButton != null) {
            this.loginButton.setSession(session);
        }
        fetchUserInfo();
        updateUI();
    }

    public void setSessionStatusCallback(Session.StatusCallback statusCallback) {
        this.sessionStatusCallback = statusCallback;
    }
}
