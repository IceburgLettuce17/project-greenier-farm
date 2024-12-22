package com.facebook.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SectionIndexer;
import android.widget.TextView;
import com.facebook.FacebookException;
import com.facebook.android.C0217R;
import com.facebook.model.GraphObject;
import com.facebook.widget.ImageRequest;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

class GraphObjectAdapter<T extends GraphObject> extends BaseAdapter implements SectionIndexer {
    static final boolean $assertionsDisabled;
    private static final int ACTIVITY_CIRCLE_VIEW_TYPE = 2;
    private static final int DISPLAY_SECTIONS_THRESHOLD = 1;
    private static final int GRAPH_OBJECT_VIEW_TYPE = 1;
    private static final int HEADER_VIEW_TYPE = 0;

    private static final String f129ID = "id";
    private static final int MAX_PREFETCHED_PICTURES = 20;
    private static final String NAME = "name";
    private static final String PICTURE = "picture";
    private Context context;
    private GraphObjectCursor<T> cursor;
    private DataNeededListener dataNeededListener;
    private boolean displaySections;
    private Filter<T> filter;
    private String groupByField;
    private final LayoutInflater inflater;
    private OnErrorListener onErrorListener;
    private boolean showCheckbox;
    private boolean showPicture;
    private List<String> sortFields;
    private final Map<String, ImageRequest> pendingRequests = new HashMap();
    private List<String> sectionKeys = new ArrayList();
    private Map<String, ArrayList<T>> graphObjectsBySection = new HashMap();
    private Map<String, T> graphObjectsById = new HashMap();
    private Map<String, ImageResponse> prefetchedPictureCache = new HashMap();
    private ArrayList<String> prefetchedProfilePictureIds = new ArrayList<>();

    public interface DataNeededListener {
        void onDataNeeded();
    }

    interface Filter<T> {
        boolean includeItem(T t);
    }

    interface ItemPicture extends GraphObject {
        ItemPictureData getData();
    }

    interface ItemPictureData extends GraphObject {
        String getUrl();
    }

    public interface OnErrorListener {
        void onError(GraphObjectAdapter<?> graphObjectAdapter, FacebookException facebookException);
    }

    public class SectionAndItem<T extends GraphObject> {
        public T graphObject;
        public String sectionKey;

        public enum Type {
            GRAPH_OBJECT,
            SECTION_HEADER,
            ACTIVITY_CIRCLE
        }

        public SectionAndItem(String str, T t) {
            this.sectionKey = str;
            this.graphObject = t;
        }

        public Type getType() {
            return this.sectionKey == null ? Type.ACTIVITY_CIRCLE : this.graphObject == null ? Type.SECTION_HEADER : Type.GRAPH_OBJECT;
        }
    }

    static {
        $assertionsDisabled = !GraphObjectAdapter.class.desiredAssertionStatus() ? true : $assertionsDisabled;
    }

    public GraphObjectAdapter(Context context) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    private void callOnErrorListener(Exception exc) {
        if (this.onErrorListener != null) {
            this.onErrorListener.onError(this, (FacebookException) (!(exc instanceof FacebookException) ? new FacebookException(exc) : exc));
        }
    }

    public static int compareGraphObjects(GraphObject graphObject, GraphObject graphObject2, Collection<String> collection, Collator collator) {
        for (String str : collection) {
            String str2 = (String) graphObject.getProperty(str);
            String str3 = (String) graphObject2.getProperty(str);
            if (str2 == null || str3 == null) {
                if (str2 != null || str3 != null) {
                    return str2 == null ? -1 : 1;
                }
            } else {
                int compare = collator.compare(str2, str3);
                if (compare != 0) {
                    return compare;
                }
            }
        }
        return 0;
    }

    private void downloadProfilePicture(final String str, URL url, final ImageView imageView) {
        if (url == null) {
            return;
        }
        boolean z = imageView == null ? true : $assertionsDisabled;
        if (z || !url.equals(imageView.getTag())) {
            if (!z) {
                imageView.setTag(str);
                imageView.setImageResource(getDefaultPicture());
            }
            ImageRequest build = new ImageRequest.Builder(this.context.getApplicationContext(), url).setCallerTag(this).setCallback(new ImageRequest.Callback() {
                @Override
                public void onCompleted(ImageResponse imageResponse) {
                    GraphObjectAdapter.this.processImageResponse(imageResponse, str, imageView);
                }
            }).build();
            this.pendingRequests.put(str, build);
            ImageDownloader.downloadAsync(build);
        }
    }

    private View getActivityCircleView(View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.inflater.inflate(C0217R.layout.com_facebook_picker_activity_circle_row, (ViewGroup) null);
        }
        ((ProgressBar) view.findViewById(C0217R.id.com_facebook_picker_row_activity_circle)).setVisibility(0);
        return view;
    }

    public void processImageResponse(ImageResponse imageResponse, String str, ImageView imageView) {
        this.pendingRequests.remove(str);
        if (imageResponse.getError() != null) {
            callOnErrorListener(imageResponse.getError());
        }
        if (imageView == null) {
            if (imageResponse.getBitmap() != null) {
                if (this.prefetchedPictureCache.size() >= MAX_PREFETCHED_PICTURES) {
                    this.prefetchedPictureCache.remove(this.prefetchedProfilePictureIds.remove(0));
                }
                this.prefetchedPictureCache.put(str, imageResponse);
                return;
            }
            return;
        }
        if (imageView == null || !str.equals(imageView.getTag())) {
            return;
        }
        Exception error = imageResponse.getError();
        Bitmap bitmap = imageResponse.getBitmap();
        if (error != null || bitmap == null) {
            return;
        }
        imageView.setImageBitmap(bitmap);
        imageView.setTag(imageResponse.getRequest().getImageUrl());
    }

    private void rebuildSections() {
        int i;
        boolean z = $assertionsDisabled;
        this.sectionKeys = new ArrayList();
        this.graphObjectsBySection = new HashMap();
        this.graphObjectsById = new HashMap();
        this.displaySections = $assertionsDisabled;
        if (this.cursor == null || this.cursor.getCount() == 0) {
            return;
        }
        this.cursor.moveToFirst();
        int i2 = 0;
        while (true) {
            T graphObject = this.cursor.getGraphObject();
            if (filterIncludesItem(graphObject)) {
                i = i2 + 1;
                String sectionKeyOfGraphObject = getSectionKeyOfGraphObject(graphObject);
                if (!this.graphObjectsBySection.containsKey(sectionKeyOfGraphObject)) {
                    this.sectionKeys.add(sectionKeyOfGraphObject);
                    this.graphObjectsBySection.put(sectionKeyOfGraphObject, new ArrayList<>());
                }
                this.graphObjectsBySection.get(sectionKeyOfGraphObject).add(graphObject);
                this.graphObjectsById.put(getIdOfGraphObject(graphObject), graphObject);
            } else {
                i = i2;
            }
            if (!this.cursor.moveToNext()) {
                break;
            } else {
                i2 = i;
            }
        }
        if (this.sortFields != null) {
            final Collator collator = Collator.getInstance();
            Iterator<ArrayList<T>> it = this.graphObjectsBySection.values().iterator();
            while (it.hasNext()) {
                Collections.sort(it.next(), new Comparator<GraphObject>() {
                    @Override
                    public int compare(GraphObject graphObject2, GraphObject graphObject3) {
                        return GraphObjectAdapter.compareGraphObjects(graphObject2, graphObject3, GraphObjectAdapter.this.sortFields, collator);
                    }
                });
            }
        }
        Collections.sort(this.sectionKeys, Collator.getInstance());
        if (this.sectionKeys.size() > 1 && i > 1) {
            z = true;
        }
        this.displaySections = z;
    }

    private boolean shouldShowActivityCircleCell() {
        if (this.cursor == null || !this.cursor.areMoreObjectsAvailable() || this.dataNeededListener == null || isEmpty()) {
            return $assertionsDisabled;
        }
        return true;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return this.displaySections;
    }

    public boolean changeCursor(GraphObjectCursor<T> graphObjectCursor) {
        if (this.cursor == graphObjectCursor) {
            return $assertionsDisabled;
        }
        if (this.cursor != null) {
            this.cursor.close();
        }
        this.cursor = graphObjectCursor;
        rebuildAndNotify();
        return true;
    }

    protected View createGraphObjectView(T t, View view) {
        View inflate = this.inflater.inflate(getGraphObjectRowLayoutId(t), (ViewGroup) null);
        ViewStub viewStub = (ViewStub) inflate.findViewById(C0217R.id.com_facebook_picker_checkbox_stub);
        if (viewStub != null) {
            if (getShowCheckbox()) {
                updateCheckboxState((CheckBox) viewStub.inflate(), $assertionsDisabled);
            } else {
                viewStub.setVisibility(8);
            }
        }
        ViewStub viewStub2 = (ViewStub) inflate.findViewById(C0217R.id.com_facebook_picker_profile_pic_stub);
        if (getShowPicture()) {
            ((ImageView) viewStub2.inflate()).setVisibility(0);
        } else {
            viewStub2.setVisibility(8);
        }
        return inflate;
    }

    boolean filterIncludesItem(T t) {
        if (this.filter == null || this.filter.includeItem(t)) {
            return true;
        }
        return $assertionsDisabled;
    }

    @Override
    public int getCount() {
        int i;
        if (this.sectionKeys.size() == 0) {
            return 0;
        }
        int size = this.displaySections ? this.sectionKeys.size() : 0;
        Iterator<ArrayList<T>> it = this.graphObjectsBySection.values().iterator();
        while (true) {
            i = size;
            if (!it.hasNext()) {
                break;
            }
            size = it.next().size() + i;
        }
        if (shouldShowActivityCircleCell()) {
            i++;
        }
        return i;
    }

    public GraphObjectCursor<T> getCursor() {
        return this.cursor;
    }

    public DataNeededListener getDataNeededListener() {
        return this.dataNeededListener;
    }

    protected int getDefaultPicture() {
        return C0217R.drawable.com_facebook_profile_default_icon;
    }

    Filter<T> getFilter() {
        return this.filter;
    }

    protected int getGraphObjectRowLayoutId(T t) {
        return C0217R.layout.com_facebook_picker_list_row;
    }

    protected View getGraphObjectView(T t, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = createGraphObjectView(t, view);
        }
        populateGraphObjectView(view, t);
        return view;
    }

    public List<T> getGraphObjectsById(Collection<String> collection) {
        HashSet hashSet = new HashSet();
        hashSet.addAll(collection);
        ArrayList arrayList = new ArrayList(hashSet.size());
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            T t = this.graphObjectsById.get((String) it.next());
            if (t != null) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public String getGroupByField() {
        return this.groupByField;
    }

    String getIdOfGraphObject(T t) {
        if (t.asMap().containsKey(f129ID)) {
            Object property = t.getProperty(f129ID);
            if (property instanceof String) {
                return (String) property;
            }
        }
        throw new FacebookException("Received an object without an ID.");
    }

    @Override
    public Object getItem(int i) {
        SectionAndItem<T> sectionAndItem = getSectionAndItem(i);
        if (sectionAndItem.getType() == SectionAndItem.Type.GRAPH_OBJECT) {
            return sectionAndItem.graphObject;
        }
        return null;
    }

    @Override
    public long getItemId(int i) {
        String idOfGraphObject;
        SectionAndItem<T> sectionAndItem = getSectionAndItem(i);
        if (sectionAndItem == null || sectionAndItem.graphObject == null || (idOfGraphObject = getIdOfGraphObject(sectionAndItem.graphObject)) == null) {
            return 0L;
        }
        return Long.parseLong(idOfGraphObject);
    }

    @Override
    public int getItemViewType(int i) {
        switch (getSectionAndItem(i).getType()) {
            case SECTION_HEADER:
                return 0;
            case GRAPH_OBJECT:
                return 1;
            case ACTIVITY_CIRCLE:
                return 2;
            default:
                throw new FacebookException("Unexpected type of section and item.");
        }
    }

    public OnErrorListener getOnErrorListener() {
        return this.onErrorListener;
    }

    String getPictureFieldSpecifier() {
        ImageView imageView = (ImageView) createGraphObjectView(null, null).findViewById(C0217R.id.com_facebook_picker_image);
        if (imageView == null) {
            return null;
        }
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        return String.format("picture.height(%d).width(%d)", Integer.valueOf(layoutParams.height), Integer.valueOf(layoutParams.width));
    }

    protected URL getPictureUrlOfGraphObject(T t) {
        ItemPictureData data;
        Object property = t.getProperty(PICTURE);
        String url = property instanceof String ? (String) property : (!(property instanceof JSONObject) || (data = ((ItemPicture) GraphObject.Factory.create((JSONObject) property).cast(ItemPicture.class)).getData()) == null) ? null : data.getUrl();
        if (url != null) {
            try {
                return new URL(url);
            } catch (MalformedURLException e) {
            }
        }
        return null;
    }

    int getPosition(String str, T t) {
        boolean z;
        Iterator<String> it = this.sectionKeys.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            String next = it.next();
            if (this.displaySections) {
                i++;
            }
            if (next.equals(str)) {
                z = true;
                break;
            }
            i = this.graphObjectsBySection.get(next).size() + i;
        }
        if (!z) {
            return -1;
        }
        if (t == null) {
            return i - (this.displaySections ? 1 : 0);
        }
        Iterator<T> it2 = this.graphObjectsBySection.get(str).iterator();
        while (it2.hasNext()) {
            if (GraphObject.Factory.hasSameId(it2.next(), t)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override
    public int getPositionForSection(int i) {
        int max;
        if (!this.displaySections || (max = Math.max(0, Math.min(i, this.sectionKeys.size() - 1))) >= this.sectionKeys.size()) {
            return 0;
        }
        return getPosition(this.sectionKeys.get(max), null);
    }

    SectionAndItem<T> getSectionAndItem(int i) {
        T t;
        String str = null;
        if (this.sectionKeys.size() == 0) {
            return null;
        }
        if (this.displaySections) {
            Iterator<String> it = this.sectionKeys.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                String next = it.next();
                int i2 = i - 1;
                if (i == 0) {
                    t = null;
                    str = next;
                    break;
                }
                ArrayList<T> arrayList = this.graphObjectsBySection.get(next);
                if (i2 < arrayList.size()) {
                    t = arrayList.get(i2);
                    str = next;
                    break;
                }
                i = i2 - arrayList.size();
            }
        } else {
            String str2 = this.sectionKeys.get(0);
            ArrayList<T> arrayList2 = this.graphObjectsBySection.get(str2);
            if (i < 0 || i >= arrayList2.size()) {
                if ($assertionsDisabled || (this.dataNeededListener != null && this.cursor.areMoreObjectsAvailable())) {
                    return new SectionAndItem<>(null, null);
                }
                throw new AssertionError();
            }
            t = this.graphObjectsBySection.get(str2).get(i);
            str = str2;
        }
        if (str != null) {
            return new SectionAndItem<>(str, t);
        }
        throw new IndexOutOfBoundsException("position");
    }

    @Override
    public int getSectionForPosition(int i) {
        SectionAndItem<T> sectionAndItem = getSectionAndItem(i);
        if (sectionAndItem == null || sectionAndItem.getType() == SectionAndItem.Type.ACTIVITY_CIRCLE) {
            return 0;
        }
        return Math.max(0, Math.min(this.sectionKeys.indexOf(sectionAndItem.sectionKey), this.sectionKeys.size() - 1));
    }

    protected View getSectionHeaderView(String str, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        TextView textView2 = textView == null ? (TextView) this.inflater.inflate(C0217R.layout.com_facebook_picker_list_section_header, (ViewGroup) null) : textView;
        textView2.setText(str);
        return textView2;
    }

    protected String getSectionKeyOfGraphObject(T t) {
        String str = null;
        if (this.groupByField != null && (str = (String) t.getProperty(this.groupByField)) != null && str.length() > 0) {
            str = str.substring(0, 1).toUpperCase();
        }
        return str != null ? str : "";
    }

    @Override
    public Object[] getSections() {
        return this.displaySections ? this.sectionKeys.toArray() : new Object[0];
    }

    public boolean getShowCheckbox() {
        return this.showCheckbox;
    }

    public boolean getShowPicture() {
        return this.showPicture;
    }

    public List<String> getSortFields() {
        return this.sortFields;
    }

    protected CharSequence getSubTitleOfGraphObject(T t) {
        return null;
    }

    protected CharSequence getTitleOfGraphObject(T t) {
        return (String) t.getProperty(NAME);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        SectionAndItem<T> sectionAndItem = getSectionAndItem(i);
        switch (sectionAndItem.getType()) {
            case SECTION_HEADER:
                return getSectionHeaderView(sectionAndItem.sectionKey, view, viewGroup);
            case GRAPH_OBJECT:
                return getGraphObjectView(sectionAndItem.graphObject, view, viewGroup);
            case ACTIVITY_CIRCLE:
                if (!$assertionsDisabled && (!this.cursor.areMoreObjectsAvailable() || this.dataNeededListener == null)) {
                    throw new AssertionError();
                }
                this.dataNeededListener.onDataNeeded();
                return getActivityCircleView(view, viewGroup);
            default:
                throw new FacebookException("Unexpected type of section and item.");
        }
    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public boolean isEmpty() {
        if (this.sectionKeys.size() == 0) {
            return true;
        }
        return $assertionsDisabled;
    }

    @Override
    public boolean isEnabled(int i) {
        if (getSectionAndItem(i).getType() == SectionAndItem.Type.GRAPH_OBJECT) {
            return true;
        }
        return $assertionsDisabled;
    }

    boolean isGraphObjectSelected(String str) {
        return $assertionsDisabled;
    }

    protected void populateGraphObjectView(View view, T t) {
        URL pictureUrlOfGraphObject;
        String idOfGraphObject = getIdOfGraphObject(t);
        view.setTag(idOfGraphObject);
        CharSequence titleOfGraphObject = getTitleOfGraphObject(t);
        TextView textView = (TextView) view.findViewById(C0217R.id.com_facebook_picker_title);
        if (textView != null) {
            textView.setText(titleOfGraphObject, TextView.BufferType.SPANNABLE);
        }
        CharSequence subTitleOfGraphObject = getSubTitleOfGraphObject(t);
        TextView textView2 = (TextView) view.findViewById(C0217R.id.picker_subtitle);
        if (textView2 != null) {
            if (subTitleOfGraphObject != null) {
                textView2.setText(subTitleOfGraphObject, TextView.BufferType.SPANNABLE);
                textView2.setVisibility(0);
            } else {
                textView2.setVisibility(8);
            }
        }
        if (getShowCheckbox()) {
            updateCheckboxState((CheckBox) view.findViewById(C0217R.id.com_facebook_picker_checkbox), isGraphObjectSelected(idOfGraphObject));
        }
        if (!getShowPicture() || (pictureUrlOfGraphObject = getPictureUrlOfGraphObject(t)) == null) {
            return;
        }
        ImageView imageView = (ImageView) view.findViewById(C0217R.id.com_facebook_picker_image);
        if (!this.prefetchedPictureCache.containsKey(idOfGraphObject)) {
            downloadProfilePicture(idOfGraphObject, pictureUrlOfGraphObject, imageView);
            return;
        }
        ImageResponse imageResponse = this.prefetchedPictureCache.get(idOfGraphObject);
        imageView.setImageBitmap(imageResponse.getBitmap());
        imageView.setTag(imageResponse.getRequest().getImageUrl());
    }

    public void prioritizeViewRange(int i, int i2, int i3) {
        if (i2 < i) {
            return;
        }
        for (int i4 = i2; i4 >= 0; i4--) {
            SectionAndItem sectionAndItem = getSectionAndItem(i4);
            if (sectionAndItem.graphObject != null) {
                ImageRequest imageRequest = this.pendingRequests.get(getIdOfGraphObject(sectionAndItem.graphObject));
                if (imageRequest != null) {
                    ImageDownloader.prioritizeRequest(imageRequest);
                }
            }
        }
        int min = Math.min(i2 + i3, getCount() - 1);
        ArrayList arrayList = new ArrayList();
        for (int max = Math.max(0, i - i3); max < i; max++) {
            SectionAndItem sectionAndItem2 = getSectionAndItem(max);
            if (sectionAndItem2.graphObject != null) {
                arrayList.add(sectionAndItem2.graphObject);
            }
        }
        for (int i5 = i2 + 1; i5 <= min; i5++) {
            SectionAndItem sectionAndItem3 = getSectionAndItem(i5);
            if (sectionAndItem3.graphObject != null) {
                arrayList.add(sectionAndItem3.graphObject);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            GraphObject graphObject = (GraphObject) it.next();
            URL pictureUrlOfGraphObject = getPictureUrlOfGraphObject(graphObject);
            String idOfGraphObject = getIdOfGraphObject(graphObject);
            boolean remove = this.prefetchedProfilePictureIds.remove(idOfGraphObject);
            this.prefetchedProfilePictureIds.add(idOfGraphObject);
            if (!remove) {
                downloadProfilePicture(idOfGraphObject, pictureUrlOfGraphObject, null);
            }
        }
    }

    public void rebuildAndNotify() {
        rebuildSections();
        notifyDataSetChanged();
    }

    public void setDataNeededListener(DataNeededListener dataNeededListener) {
        this.dataNeededListener = dataNeededListener;
    }

    void setFilter(Filter<T> filter) {
        this.filter = filter;
    }

    public void setGroupByField(String str) {
        this.groupByField = str;
    }

    public void setOnErrorListener(OnErrorListener onErrorListener) {
        this.onErrorListener = onErrorListener;
    }

    public void setShowCheckbox(boolean z) {
        this.showCheckbox = z;
    }

    public void setShowPicture(boolean z) {
        this.showPicture = z;
    }

    public void setSortFields(List<String> list) {
        this.sortFields = list;
    }

    void updateCheckboxState(CheckBox checkBox, boolean z) {
    }
}
