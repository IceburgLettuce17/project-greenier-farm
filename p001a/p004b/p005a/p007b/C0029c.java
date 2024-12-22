package p001a.p004b.p005a.p007b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import com.facebook.internal.ServerProtocol;
import com.facebook.widget.ProfilePictureView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public final class C0029c {

    private static final Object f76av = new Object();

    private static C0029c f77aw;

    private final Context f78ar;

    private final HashMap<BroadcastReceiver, ArrayList<IntentFilter>> f79as = new HashMap<>();

    private final HashMap<String, ArrayList<C0032f>> f80at = new HashMap<>();

    private final ArrayList<C0031e> f81au = new ArrayList<>();
    private final Handler mHandler;

    private C0029c(Context context) {
        this.f78ar = context;
        this.mHandler = new HandlerC0030d(this, context.getMainLooper());
    }

    static void m100a(C0029c c0029c) {
        C0031e[] c0031eArr;
        while (true) {
            synchronized (c0029c.f79as) {
                int size = c0029c.f81au.size();
                if (size <= 0) {
                    return;
                }
                c0031eArr = new C0031e[size];
                c0029c.f81au.toArray(c0031eArr);
                c0029c.f81au.clear();
            }
            for (C0031e c0031e : c0031eArr) {
                for (int i = 0; i < c0031e.f83ay.size(); i++) {
                    c0031e.f83ay.get(i).receiver.onReceive(c0029c.f78ar, c0031e.intent);
                }
            }
        }
    }

    public static C0029c m101c(Context context) {
        C0029c c0029c;
        synchronized (f76av) {
            if (f77aw == null) {
                f77aw = new C0029c(context.getApplicationContext());
            }
            c0029c = f77aw;
        }
        return c0029c;
    }

    public final void m102a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.f79as) {
            C0032f c0032f = new C0032f(intentFilter, broadcastReceiver);
            ArrayList<IntentFilter> arrayList = this.f79as.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.f79as.put(broadcastReceiver, arrayList);
            }
            arrayList.add(intentFilter);
            for (int i = 0; i < intentFilter.countActions(); i++) {
                String action = intentFilter.getAction(i);
                ArrayList<C0032f> arrayList2 = this.f80at.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>(1);
                    this.f80at.put(action, arrayList2);
                }
                arrayList2.add(c0032f);
            }
        }
    }

    public final boolean m103a(Intent intent) {
        String str;
        ArrayList arrayList;
        synchronized (this.f79as) {
            String action = intent.getAction();
            String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f78ar.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            boolean z = (intent.getFlags() & 8) != 0;
            if (z) {
                Log.v("LocalBroadcastManager", "Resolving type " + resolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
            }
            ArrayList<C0032f> arrayList2 = this.f80at.get(intent.getAction());
            if (arrayList2 != null) {
                if (z) {
                    Log.v("LocalBroadcastManager", "Action list: " + arrayList2);
                }
                ArrayList arrayList3 = null;
                int i = 0;
                while (i < arrayList2.size()) {
                    C0032f c0032f = arrayList2.get(i);
                    if (z) {
                        Log.v("LocalBroadcastManager", "Matching against filter " + c0032f.filter);
                    }
                    if (c0032f.f84az) {
                        if (z) {
                            Log.v("LocalBroadcastManager", "  Filter's target already added");
                            arrayList = arrayList3;
                        }
                        arrayList = arrayList3;
                    } else {
                        int match = c0032f.filter.match(action, resolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                        if (match >= 0) {
                            if (z) {
                                Log.v("LocalBroadcastManager", "  Filter matched!  match=0x" + Integer.toHexString(match));
                            }
                            arrayList = arrayList3 == null ? new ArrayList() : arrayList3;
                            arrayList.add(c0032f);
                            c0032f.f84az = true;
                        } else {
                            if (z) {
                                switch (match) {
                                    case ProfilePictureView.LARGE:
                                        str = "category";
                                        break;
                                    case ProfilePictureView.NORMAL:
                                        str = "action";
                                        break;
                                    case ProfilePictureView.SMALL:
                                        str = "data";
                                        break;
                                    case -1:
                                        str = ServerProtocol.DIALOG_PARAM_TYPE;
                                        break;
                                    default:
                                        str = "unknown reason";
                                        break;
                                }
                                Log.v("LocalBroadcastManager", "  Filter did not match: " + str);
                            }
                            arrayList = arrayList3;
                        }
                    }
                    i++;
                    arrayList3 = arrayList;
                }
                if (arrayList3 != null) {
                    for (int i2 = 0; i2 < arrayList3.size(); i2++) {
                        ((C0032f) arrayList3.get(i2)).f84az = false;
                    }
                    this.f81au.add(new C0031e(intent, arrayList3));
                    if (!this.mHandler.hasMessages(1)) {
                        this.mHandler.sendEmptyMessage(1);
                    }
                    return true;
                }
            }
            return false;
        }
    }

    public final void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        int i;
        synchronized (this.f79as) {
            ArrayList<IntentFilter> remove = this.f79as.remove(broadcastReceiver);
            if (remove == null) {
                return;
            }
            for (int i2 = 0; i2 < remove.size(); i2++) {
                IntentFilter intentFilter = remove.get(i2);
                for (int i3 = 0; i3 < intentFilter.countActions(); i3++) {
                    String action = intentFilter.getAction(i3);
                    ArrayList<C0032f> arrayList = this.f80at.get(action);
                    if (arrayList != null) {
                        int i4 = 0;
                        while (i4 < arrayList.size()) {
                            if (arrayList.get(i4).receiver == broadcastReceiver) {
                                arrayList.remove(i4);
                                i = i4 - 1;
                            } else {
                                i = i4;
                            }
                            i4 = i + 1;
                        }
                        if (arrayList.size() <= 0) {
                            this.f80at.remove(action);
                        }
                    }
                }
            }
        }
    }
}
