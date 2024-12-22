package com.facebook.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.FacebookException;
import com.facebook.Request;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.android.C0217R;
import com.facebook.internal.SessionTracker;
import com.facebook.model.GraphObject;
import com.facebook.widget.GraphObjectAdapter;
import com.facebook.widget.GraphObjectPagingLoader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import p001a.p004b.p005a.p006a.ComponentCallbacksC0006e;
import p001a.p004b.p005a.p006a.InterfaceC0022u;
import p001a.p004b.p005a.p007b.C0027a;

public abstract class PickerFragment<T extends GraphObject> extends ComponentCallbacksC0006e {
    private static final String ACTIVITY_CIRCLE_SHOW_KEY = "com.facebook.android.PickerFragment.ActivityCircleShown";
    public static final String DONE_BUTTON_TEXT_BUNDLE_KEY = "com.facebook.widget.PickerFragment.DoneButtonText";
    public static final String EXTRA_FIELDS_BUNDLE_KEY = "com.facebook.widget.PickerFragment.ExtraFields";
    private static final int PROFILE_PICTURE_PREFETCH_BUFFER = 5;
    private static final String SELECTION_BUNDLE_KEY = "com.facebook.android.PickerFragment.Selection";
    public static final String SHOW_PICTURES_BUNDLE_KEY = "com.facebook.widget.PickerFragment.ShowPictures";
    public static final String SHOW_TITLE_BAR_BUNDLE_KEY = "com.facebook.widget.PickerFragment.ShowTitleBar";
    public static final String TITLE_TEXT_BUNDLE_KEY = "com.facebook.widget.PickerFragment.TitleText";
    private ProgressBar activityCircle;
    GraphObjectAdapter<T> adapter;
    private Button doneButton;
    private Drawable doneButtonBackground;
    private String doneButtonText;
    private GraphObjectFilter<T> filter;
    private final Class<T> graphObjectClass;
    private final int layout;
    private ListView listView;
    private PickerFragment<T>.LoadingStrategy loadingStrategy;
    private OnDataChangedListener onDataChangedListener;
    private OnDoneButtonClickedListener onDoneButtonClickedListener;
    private OnErrorListener onErrorListener;
    private OnSelectionChangedListener onSelectionChangedListener;
    private PickerFragment<T>.SelectionStrategy selectionStrategy;
    private SessionTracker sessionTracker;
    private Drawable titleBarBackground;
    private String titleText;
    private TextView titleTextView;
    private boolean showPictures = true;
    private boolean showTitleBar = true;
    HashSet<String> extraFields = new HashSet<>();
    private AbsListView.OnScrollListener onScrollListener = new AbsListView.OnScrollListener() {
        @Override
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            PickerFragment.this.reprioritizeDownloads();
        }

        @Override
        public void onScrollStateChanged(AbsListView absListView, int i) {
        }
    };

    public interface GraphObjectFilter<T> {
        boolean includeItem(T t);
    }

    abstract class LoadingStrategy {
        protected static final int CACHED_RESULT_REFRESH_DELAY = 2000;
        protected GraphObjectAdapter<T> adapter;
        protected GraphObjectPagingLoader<T> loader;

        LoadingStrategy() {
        }

        public void attach(GraphObjectAdapter<T> graphObjectAdapter) {
            this.loader = (GraphObjectPagingLoader) PickerFragment.this.getLoaderManager().mo87a(0, null, new InterfaceC0022u<SimpleGraphObjectCursor<T>>() {
                @Override
                public C0027a<SimpleGraphObjectCursor<T>> onCreateLoader(int i, Bundle bundle) {
                    return LoadingStrategy.this.onCreateLoader();
                }

                @Override
                public void onLoadFinished(C0027a<SimpleGraphObjectCursor<T>> c0027a, SimpleGraphObjectCursor<T> simpleGraphObjectCursor) {
                    if (c0027a != LoadingStrategy.this.loader) {
                        throw new FacebookException("Received callback for unknown loader.");
                    }
                    LoadingStrategy.this.onLoadFinished((GraphObjectPagingLoader) c0027a, simpleGraphObjectCursor);
                }

                @Override
                public void onLoaderReset(C0027a<SimpleGraphObjectCursor<T>> c0027a) {
                    if (c0027a != LoadingStrategy.this.loader) {
                        throw new FacebookException("Received callback for unknown loader.");
                    }
                    LoadingStrategy.this.onLoadReset((GraphObjectPagingLoader) c0027a);
                }
            });
            this.loader.setOnErrorListener(new GraphObjectPagingLoader.OnErrorListener() {
                @Override
                public void onError(FacebookException facebookException, GraphObjectPagingLoader<?> graphObjectPagingLoader) {
                    PickerFragment.this.hideActivityCircle();
                    if (PickerFragment.this.onErrorListener != null) {
                        PickerFragment.this.onErrorListener.onError(PickerFragment.this, facebookException);
                    }
                }
            });
            this.adapter = graphObjectAdapter;
            this.adapter.changeCursor(this.loader.getCursor());
            this.adapter.setOnErrorListener(new GraphObjectAdapter.OnErrorListener() {
                @Override
                public void onError(GraphObjectAdapter<?> graphObjectAdapter2, FacebookException facebookException) {
                    if (PickerFragment.this.onErrorListener != null) {
                        PickerFragment.this.onErrorListener.onError(PickerFragment.this, facebookException);
                    }
                }
            });
        }

        public void clearResults() {
            if (this.loader != null) {
                this.loader.clearResults();
            }
        }

        public void detach() {
            this.adapter.setDataNeededListener(null);
            this.adapter.setOnErrorListener(null);
            this.loader.setOnErrorListener(null);
            this.loader = null;
            this.adapter = null;
        }

        public boolean isDataPresentOrLoading() {
            return !this.adapter.isEmpty() || this.loader.isLoading();
        }

        protected GraphObjectPagingLoader<T> onCreateLoader() {
            return new GraphObjectPagingLoader<>(PickerFragment.this.getActivity(), PickerFragment.this.graphObjectClass);
        }

        protected void onLoadFinished(GraphObjectPagingLoader<T> graphObjectPagingLoader, SimpleGraphObjectCursor<T> simpleGraphObjectCursor) {
            PickerFragment.this.updateAdapter(simpleGraphObjectCursor);
        }

        protected void onLoadReset(GraphObjectPagingLoader<T> graphObjectPagingLoader) {
            this.adapter.changeCursor(null);
        }

        protected void onStartLoading(GraphObjectPagingLoader<T> graphObjectPagingLoader, Request request) {
            PickerFragment.this.displayActivityCircle();
        }

        public void startLoading(Request request) {
            if (this.loader != null) {
                this.loader.startLoading(request, true);
                onStartLoading(this.loader, request);
            }
        }
    }

    class MultiSelectionStrategy extends SelectionStrategy {
        private Set<String> selectedIds;

        MultiSelectionStrategy() {
            super();
            this.selectedIds = new HashSet();
        }

        @Override
        public void clear() {
            this.selectedIds.clear();
        }

        @Override
        public Collection<String> getSelectedIds() {
            return this.selectedIds;
        }

        @Override
        boolean isEmpty() {
            return this.selectedIds.isEmpty();
        }

        @Override
        boolean isSelected(String str) {
            return str != null && this.selectedIds.contains(str);
        }

        @Override
        void readSelectionFromBundle(Bundle bundle, String str) {
            String string;
            if (bundle == null || (string = bundle.getString(str)) == null) {
                return;
            }
            String[] split = TextUtils.split(string, ",");
            this.selectedIds.clear();
            Collections.addAll(this.selectedIds, split);
        }

        @Override
        void saveSelectionToBundle(Bundle bundle, String str) {
            if (this.selectedIds.isEmpty()) {
                return;
            }
            bundle.putString(str, TextUtils.join(",", this.selectedIds));
        }

        @Override
        boolean shouldShowCheckBoxIfUnselected() {
            return true;
        }

        @Override
        void toggleSelection(String str) {
            if (str != null) {
                if (this.selectedIds.contains(str)) {
                    this.selectedIds.remove(str);
                } else {
                    this.selectedIds.add(str);
                }
            }
        }
    }

    public interface OnDataChangedListener {
        void onDataChanged(PickerFragment<?> pickerFragment);
    }

    public interface OnDoneButtonClickedListener {
        void onDoneButtonClicked(PickerFragment<?> pickerFragment);
    }

    public interface OnErrorListener {
        void onError(PickerFragment<?> pickerFragment, FacebookException facebookException);
    }

    public interface OnSelectionChangedListener {
        void onSelectionChanged(PickerFragment<?> pickerFragment);
    }

    abstract class PickerFragmentAdapter<U extends GraphObject> extends GraphObjectAdapter<T> {
        public PickerFragmentAdapter(Context context) {
            super(context);
        }

        @Override
        boolean isGraphObjectSelected(String str) {
            return PickerFragment.this.selectionStrategy.isSelected(str);
        }

        @Override
        void updateCheckboxState(CheckBox checkBox, boolean z) {
            checkBox.setChecked(z);
            checkBox.setVisibility((z || PickerFragment.this.selectionStrategy.shouldShowCheckBoxIfUnselected()) ? 0 : 8);
        }
    }

    abstract class SelectionStrategy {
        SelectionStrategy() {
        }

        abstract void clear();

        abstract Collection<String> getSelectedIds();

        abstract boolean isEmpty();

        abstract boolean isSelected(String str);

        abstract void readSelectionFromBundle(Bundle bundle, String str);

        abstract void saveSelectionToBundle(Bundle bundle, String str);

        abstract boolean shouldShowCheckBoxIfUnselected();

        abstract void toggleSelection(String str);
    }

    class SingleSelectionStrategy extends SelectionStrategy {
        private String selectedId;

        SingleSelectionStrategy() {
            super();
        }

        @Override
        public void clear() {
            this.selectedId = null;
        }

        @Override
        public Collection<String> getSelectedIds() {
            return Arrays.asList(this.selectedId);
        }

        @Override
        boolean isEmpty() {
            return this.selectedId == null;
        }

        @Override
        boolean isSelected(String str) {
            return (this.selectedId == null || str == null || !this.selectedId.equals(str)) ? false : true;
        }

        @Override
        void readSelectionFromBundle(Bundle bundle, String str) {
            if (bundle != null) {
                this.selectedId = bundle.getString(str);
            }
        }

        @Override
        void saveSelectionToBundle(Bundle bundle, String str) {
            if (TextUtils.isEmpty(this.selectedId)) {
                return;
            }
            bundle.putString(str, this.selectedId);
        }

        @Override
        boolean shouldShowCheckBoxIfUnselected() {
            return false;
        }

        @Override
        void toggleSelection(String str) {
            if (this.selectedId == null || !this.selectedId.equals(str)) {
                this.selectedId = str;
            } else {
                this.selectedId = null;
            }
        }
    }

    PickerFragment(Class<T> cls, int i, Bundle bundle) {
        this.graphObjectClass = cls;
        this.layout = i;
        setPickerFragmentSettingsFromBundle(bundle);
    }

    public void clearResults() {
        if (this.adapter != null) {
            boolean z = !this.selectionStrategy.isEmpty();
            boolean z2 = this.adapter.isEmpty() ? false : true;
            this.loadingStrategy.clearResults();
            this.selectionStrategy.clear();
            this.adapter.notifyDataSetChanged();
            if (z2 && this.onDataChangedListener != null) {
                this.onDataChangedListener.onDataChanged(this);
            }
            if (!z || this.onSelectionChangedListener == null) {
                return;
            }
            this.onSelectionChangedListener.onSelectionChanged(this);
        }
    }

    private void inflateTitleBar(ViewGroup viewGroup) {
        ViewStub viewStub = (ViewStub) viewGroup.findViewById(C0217R.id.com_facebook_picker_title_bar_stub);
        if (viewStub != null) {
            View inflate = viewStub.inflate();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(3, C0217R.id.com_facebook_picker_title_bar);
            this.listView.setLayoutParams(layoutParams);
            if (this.titleBarBackground != null) {
                inflate.setBackgroundDrawable(this.titleBarBackground);
            }
            this.doneButton = (Button) viewGroup.findViewById(C0217R.id.com_facebook_picker_done_button);
            if (this.doneButton != null) {
                this.doneButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (PickerFragment.this.onDoneButtonClickedListener != null) {
                            PickerFragment.this.onDoneButtonClickedListener.onDoneButtonClicked(PickerFragment.this);
                        }
                    }
                });
                if (getDoneButtonText() != null) {
                    this.doneButton.setText(getDoneButtonText());
                }
                if (this.doneButtonBackground != null) {
                    this.doneButton.setBackgroundDrawable(this.doneButtonBackground);
                }
            }
            this.titleTextView = (TextView) viewGroup.findViewById(C0217R.id.com_facebook_picker_title);
            if (this.titleTextView == null || getTitleText() == null) {
                return;
            }
            this.titleTextView.setText(getTitleText());
        }
    }

    private void loadDataSkippingRoundTripIfCached() {
        clearResults();
        Request requestForLoadData = getRequestForLoadData(getSession());
        if (requestForLoadData != null) {
            onLoadingData();
            this.loadingStrategy.startLoading(requestForLoadData);
        }
    }

    public void onListItemClick(ListView listView, View view, int i) {
        this.selectionStrategy.toggleSelection(this.adapter.getIdOfGraphObject((GraphObject) listView.getItemAtPosition(i)));
        this.adapter.notifyDataSetChanged();
        if (this.onSelectionChangedListener != null) {
            this.onSelectionChangedListener.onSelectionChanged(this);
        }
    }

    public void reprioritizeDownloads() {
        int lastVisiblePosition = this.listView.getLastVisiblePosition();
        if (lastVisiblePosition >= 0) {
            this.adapter.prioritizeViewRange(this.listView.getFirstVisiblePosition(), lastVisiblePosition, 5);
        }
    }

    private static void setAlpha(View view, float f) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(f, f);
        alphaAnimation.setDuration(0L);
        alphaAnimation.setFillAfter(true);
        view.startAnimation(alphaAnimation);
    }

    private void setPickerFragmentSettingsFromBundle(Bundle bundle) {
        if (bundle != null) {
            this.showPictures = bundle.getBoolean(SHOW_PICTURES_BUNDLE_KEY, this.showPictures);
            String string = bundle.getString(EXTRA_FIELDS_BUNDLE_KEY);
            if (string != null) {
                setExtraFields(Arrays.asList(string.split(",")));
            }
            this.showTitleBar = bundle.getBoolean(SHOW_TITLE_BAR_BUNDLE_KEY, this.showTitleBar);
            String string2 = bundle.getString(TITLE_TEXT_BUNDLE_KEY);
            if (string2 != null) {
                this.titleText = string2;
                if (this.titleTextView != null) {
                    this.titleTextView.setText(this.titleText);
                }
            }
            String string3 = bundle.getString(DONE_BUTTON_TEXT_BUNDLE_KEY);
            if (string3 != null) {
                this.doneButtonText = string3;
                if (this.doneButton != null) {
                    this.doneButton.setText(this.doneButtonText);
                }
            }
        }
    }

    abstract PickerFragment<T>.PickerFragmentAdapter<T> createAdapter();

    abstract PickerFragment<T>.LoadingStrategy createLoadingStrategy();

    abstract PickerFragment<T>.SelectionStrategy createSelectionStrategy();

    void displayActivityCircle() {
        if (this.activityCircle != null) {
            layoutActivityCircle();
            this.activityCircle.setVisibility(0);
        }
    }

    boolean filterIncludesItem(T t) {
        if (this.filter != null) {
            return this.filter.includeItem(t);
        }
        return true;
    }

    String getDefaultDoneButtonText() {
        return getString(C0217R.string.com_facebook_picker_done_button_text);
    }

    String getDefaultTitleText() {
        return null;
    }

    public String getDoneButtonText() {
        if (this.doneButtonText == null) {
            this.doneButtonText = getDefaultDoneButtonText();
        }
        return this.doneButtonText;
    }

    public Set<String> getExtraFields() {
        return new HashSet(this.extraFields);
    }

    public GraphObjectFilter<T> getFilter() {
        return this.filter;
    }

    public OnDataChangedListener getOnDataChangedListener() {
        return this.onDataChangedListener;
    }

    public OnDoneButtonClickedListener getOnDoneButtonClickedListener() {
        return this.onDoneButtonClickedListener;
    }

    public OnErrorListener getOnErrorListener() {
        return this.onErrorListener;
    }

    public OnSelectionChangedListener getOnSelectionChangedListener() {
        return this.onSelectionChangedListener;
    }

    abstract Request getRequestForLoadData(Session session);

    List<T> getSelectedGraphObjects() {
        return this.adapter.getGraphObjectsById(this.selectionStrategy.getSelectedIds());
    }

    public Session getSession() {
        return this.sessionTracker.getSession();
    }

    public boolean getShowPictures() {
        return this.showPictures;
    }

    public boolean getShowTitleBar() {
        return this.showTitleBar;
    }

    public String getTitleText() {
        if (this.titleText == null) {
            this.titleText = getDefaultTitleText();
        }
        return this.titleText;
    }

    void hideActivityCircle() {
        if (this.activityCircle != null) {
            this.activityCircle.clearAnimation();
            this.activityCircle.setVisibility(4);
        }
    }

    void layoutActivityCircle() {
        setAlpha(this.activityCircle, !this.adapter.isEmpty() ? 0.25f : 1.0f);
    }

    public void loadData(boolean z) {
        if (z || !this.loadingStrategy.isDataPresentOrLoading()) {
            loadDataSkippingRoundTripIfCached();
        }
    }

    @Override
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.sessionTracker = new SessionTracker(getActivity(), new Session.StatusCallback() {
            @Override
            public void call(Session session, SessionState sessionState, Exception exc) {
                if (session.isOpened()) {
                    return;
                }
                PickerFragment.this.clearResults();
            }
        });
        setSettingsFromBundle(bundle);
        this.loadingStrategy = createLoadingStrategy();
        this.loadingStrategy.attach(this.adapter);
        this.selectionStrategy = createSelectionStrategy();
        this.selectionStrategy.readSelectionFromBundle(bundle, SELECTION_BUNDLE_KEY);
        if (this.showTitleBar) {
            inflateTitleBar((ViewGroup) getView());
        }
        if (this.activityCircle == null || bundle == null) {
            return;
        }
        if (bundle.getBoolean(ACTIVITY_CIRCLE_SHOW_KEY, false)) {
            displayActivityCircle();
        } else {
            hideActivityCircle();
        }
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.adapter = createAdapter();
        this.adapter.setFilter(new GraphObjectAdapter.Filter<T>() {
            @Override
            public boolean includeItem(T t) {
                return PickerFragment.this.filterIncludesItem(t);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(this.layout, viewGroup, false);
        this.listView = (ListView) viewGroup2.findViewById(C0217R.id.com_facebook_picker_list_view);
        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                PickerFragment.this.onListItemClick((ListView) adapterView, view, i);
            }
        });
        this.listView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                return false;
            }
        });
        this.listView.setOnScrollListener(this.onScrollListener);
        this.listView.setAdapter((ListAdapter) this.adapter);
        this.activityCircle = (ProgressBar) viewGroup2.findViewById(C0217R.id.com_facebook_picker_activity_circle);
        return viewGroup2;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.listView.setOnScrollListener(null);
        this.listView.setAdapter((ListAdapter) null);
        this.loadingStrategy.detach();
        this.sessionTracker.stopTracking();
    }

    @Override
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(activity, attributeSet, bundle);
        TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(attributeSet, C0217R.styleable.com_facebook_picker_fragment);
        setShowPictures(obtainStyledAttributes.getBoolean(0, this.showPictures));
        String string = obtainStyledAttributes.getString(1);
        if (string != null) {
            setExtraFields(Arrays.asList(string.split(",")));
        }
        this.showTitleBar = obtainStyledAttributes.getBoolean(2, this.showTitleBar);
        this.titleText = obtainStyledAttributes.getString(3);
        this.doneButtonText = obtainStyledAttributes.getString(4);
        this.titleBarBackground = obtainStyledAttributes.getDrawable(5);
        this.doneButtonBackground = obtainStyledAttributes.getDrawable(6);
        obtainStyledAttributes.recycle();
    }

    void onLoadingData() {
    }

    @Override
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        saveSettingsToBundle(bundle);
        this.selectionStrategy.saveSelectionToBundle(bundle, SELECTION_BUNDLE_KEY);
        if (this.activityCircle != null) {
            bundle.putBoolean(ACTIVITY_CIRCLE_SHOW_KEY, this.activityCircle.getVisibility() == 0);
        }
    }

    void saveSettingsToBundle(Bundle bundle) {
        bundle.putBoolean(SHOW_PICTURES_BUNDLE_KEY, this.showPictures);
        if (!this.extraFields.isEmpty()) {
            bundle.putString(EXTRA_FIELDS_BUNDLE_KEY, TextUtils.join(",", this.extraFields));
        }
        bundle.putBoolean(SHOW_TITLE_BAR_BUNDLE_KEY, this.showTitleBar);
        bundle.putString(TITLE_TEXT_BUNDLE_KEY, this.titleText);
        bundle.putString(DONE_BUTTON_TEXT_BUNDLE_KEY, this.doneButtonText);
    }

    @Override
    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
        setSettingsFromBundle(bundle);
    }

    public void setDoneButtonText(String str) {
        this.doneButtonText = str;
    }

    public void setExtraFields(Collection<String> collection) {
        this.extraFields = new HashSet<>();
        if (collection != null) {
            this.extraFields.addAll(collection);
        }
    }

    public void setFilter(GraphObjectFilter<T> graphObjectFilter) {
        this.filter = graphObjectFilter;
    }

    public void setOnDataChangedListener(OnDataChangedListener onDataChangedListener) {
        this.onDataChangedListener = onDataChangedListener;
    }

    public void setOnDoneButtonClickedListener(OnDoneButtonClickedListener onDoneButtonClickedListener) {
        this.onDoneButtonClickedListener = onDoneButtonClickedListener;
    }

    public void setOnErrorListener(OnErrorListener onErrorListener) {
        this.onErrorListener = onErrorListener;
    }

    public void setOnSelectionChangedListener(OnSelectionChangedListener onSelectionChangedListener) {
        this.onSelectionChangedListener = onSelectionChangedListener;
    }

    void setSelectionStrategy(PickerFragment<T>.SelectionStrategy selectionStrategy) {
        if (selectionStrategy != this.selectionStrategy) {
            this.selectionStrategy = selectionStrategy;
            if (this.adapter != null) {
                this.adapter.notifyDataSetChanged();
            }
        }
    }

    public void setSession(Session session) {
        this.sessionTracker.setSession(session);
    }

    public void setSettingsFromBundle(Bundle bundle) {
        setPickerFragmentSettingsFromBundle(bundle);
    }

    public void setShowPictures(boolean z) {
        this.showPictures = z;
    }

    public void setShowTitleBar(boolean z) {
        this.showTitleBar = z;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    void updateAdapter(SimpleGraphObjectCursor<T> simpleGraphObjectCursor) {
        int position;
        if (this.adapter != null) {
            View childAt = this.listView.getChildAt(1);
            int firstVisiblePosition = this.listView.getFirstVisiblePosition();
            if (firstVisiblePosition > 0) {
                firstVisiblePosition++;
            }
            GraphObjectAdapter.SectionAndItem<T> sectionAndItem = this.adapter.getSectionAndItem(firstVisiblePosition);
            int top = (childAt == null || sectionAndItem.getType() == GraphObjectAdapter.SectionAndItem.Type.ACTIVITY_CIRCLE) ? 0 : childAt.getTop();
            boolean changeCursor = this.adapter.changeCursor(simpleGraphObjectCursor);
            if (childAt != null && sectionAndItem != null && (position = this.adapter.getPosition(sectionAndItem.sectionKey, sectionAndItem.graphObject)) != -1) {
                this.listView.setSelectionFromTop(position, top);
            }
            if (!changeCursor || this.onDataChangedListener == null) {
                return;
            }
            this.onDataChangedListener.onDataChanged(this);
        }
    }
}
