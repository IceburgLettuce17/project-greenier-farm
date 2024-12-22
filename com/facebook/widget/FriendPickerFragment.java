package com.facebook.widget;

import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.facebook.FacebookException;
import com.facebook.Request;
import com.facebook.Session;
import com.facebook.android.C0217R;
import com.facebook.model.GraphUser;
import com.facebook.widget.PickerFragment;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FriendPickerFragment extends PickerFragment<GraphUser> {

    private static final String f128ID = "id";
    public static final String MULTI_SELECT_BUNDLE_KEY = "com.facebook.widget.FriendPickerFragment.MultiSelect";
    private static final String NAME = "name";
    public static final String USER_ID_BUNDLE_KEY = "com.facebook.widget.FriendPickerFragment.UserId";
    private boolean multiSelect;
    private String userId;

    class ImmediateLoadingStrategy extends PickerFragment.LoadingStrategy {
        private ImmediateLoadingStrategy() {
            super();
        }

        private void followNextLink() {
            FriendPickerFragment.this.displayActivityCircle();
            this.loader.followNextLink();
        }

        @Override
        protected void onLoadFinished(GraphObjectPagingLoader<GraphUser> graphObjectPagingLoader, SimpleGraphObjectCursor<GraphUser> simpleGraphObjectCursor) {
            super.onLoadFinished(graphObjectPagingLoader, simpleGraphObjectCursor);
            if (simpleGraphObjectCursor == null || graphObjectPagingLoader.isLoading()) {
                return;
            }
            if (simpleGraphObjectCursor.areMoreObjectsAvailable()) {
                followNextLink();
                return;
            }
            FriendPickerFragment.this.hideActivityCircle();
            if (simpleGraphObjectCursor.isFromCache()) {
                graphObjectPagingLoader.refreshOriginalRequest(simpleGraphObjectCursor.getCount() == 0 ? 2000L : 0L);
            }
        }
    }

    public FriendPickerFragment() {
        this(null);
    }

    public FriendPickerFragment(Bundle bundle) {
        super(GraphUser.class, C0217R.layout.com_facebook_friendpickerfragment, bundle);
        this.multiSelect = true;
        setFriendPickerSettingsFromBundle(bundle);
    }

    private Request createRequest(String str, Set<String> set, Session session) {
        Request newGraphPathRequest = Request.newGraphPathRequest(session, str + "/friends", null);
        HashSet hashSet = new HashSet(set);
        hashSet.addAll(Arrays.asList(f128ID, NAME));
        String pictureFieldSpecifier = this.adapter.getPictureFieldSpecifier();
        if (pictureFieldSpecifier != null) {
            hashSet.add(pictureFieldSpecifier);
        }
        Bundle parameters = newGraphPathRequest.getParameters();
        parameters.putString("fields", TextUtils.join(",", hashSet));
        newGraphPathRequest.setParameters(parameters);
        return newGraphPathRequest;
    }

    private void setFriendPickerSettingsFromBundle(Bundle bundle) {
        if (bundle != null) {
            if (bundle.containsKey(USER_ID_BUNDLE_KEY)) {
                setUserId(bundle.getString(USER_ID_BUNDLE_KEY));
            }
            setMultiSelect(bundle.getBoolean(MULTI_SELECT_BUNDLE_KEY, this.multiSelect));
        }
    }

    @Override
    PickerFragment<GraphUser>.PickerFragmentAdapter<GraphUser> createAdapter() {
        PickerFragment<GraphUser>.PickerFragmentAdapter<GraphUser> pickerFragmentAdapter = new PickerFragment<GraphUser>.PickerFragmentAdapter<GraphUser>(getActivity()) {
            @Override
            protected int getDefaultPicture() {
                return C0217R.drawable.com_facebook_profile_default_icon;
            }

            @Override
            protected int getGraphObjectRowLayoutId(GraphUser graphUser) {
                return C0217R.layout.com_facebook_picker_list_row;
            }
        };
        pickerFragmentAdapter.setShowCheckbox(true);
        pickerFragmentAdapter.setShowPicture(getShowPictures());
        pickerFragmentAdapter.setSortFields(Arrays.asList(NAME));
        pickerFragmentAdapter.setGroupByField(NAME);
        return pickerFragmentAdapter;
    }

    @Override
    PickerFragment<GraphUser>.LoadingStrategy createLoadingStrategy() {
        return new ImmediateLoadingStrategy();
    }

    @Override
    PickerFragment<GraphUser>.SelectionStrategy createSelectionStrategy() {
        return this.multiSelect ? new PickerFragment.MultiSelectionStrategy() : new PickerFragment.SingleSelectionStrategy();
    }

    @Override
    String getDefaultTitleText() {
        return getString(C0217R.string.com_facebook_choose_friends);
    }

    public boolean getMultiSelect() {
        return this.multiSelect;
    }

    @Override
    Request getRequestForLoadData(Session session) {
        if (this.adapter == null) {
            throw new FacebookException("Can't issue requests until Fragment has been created.");
        }
        return createRequest(this.userId != null ? this.userId : "me", this.extraFields, session);
    }

    public List<GraphUser> getSelection() {
        return getSelectedGraphObjects();
    }

    public String getUserId() {
        return this.userId;
    }

    @Override
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(activity, attributeSet, bundle);
        TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(attributeSet, C0217R.styleable.com_facebook_friend_picker_fragment);
        setMultiSelect(obtainStyledAttributes.getBoolean(0, this.multiSelect));
        obtainStyledAttributes.recycle();
    }

    @Override
    void saveSettingsToBundle(Bundle bundle) {
        super.saveSettingsToBundle(bundle);
        bundle.putString(USER_ID_BUNDLE_KEY, this.userId);
        bundle.putBoolean(MULTI_SELECT_BUNDLE_KEY, this.multiSelect);
    }

    public void setMultiSelect(boolean z) {
        if (this.multiSelect != z) {
            this.multiSelect = z;
            setSelectionStrategy(createSelectionStrategy());
        }
    }

    @Override
    public void setSettingsFromBundle(Bundle bundle) {
        super.setSettingsFromBundle(bundle);
        setFriendPickerSettingsFromBundle(bundle);
    }

    public void setUserId(String str) {
        this.userId = str;
    }
}
