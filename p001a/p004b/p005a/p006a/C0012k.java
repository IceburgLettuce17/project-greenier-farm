package p001a.p004b.p005a.p006a;

import android.util.Log;
import com.gameloft.android2d.iap.C0463b;
import java.util.ArrayList;
import p001a.p004b.p005a.p008c.C0034b;

public class C0012k {

    ArrayList<ComponentCallbacksC0006e> f35D;

    C0034b<C0023v> f36E;

    C0012k() {
    }

    public static void m38a(Exception exc) {
        if (C0463b.m2542qO()) {
            m42d("EXCEPTION", exc);
        }
    }

    public static void m39a(String str, Object obj) {
        if (C0463b.m2542qO()) {
            Log.d(str, obj.toString());
        }
    }

    public static void m40b(String str, Object obj) {
        if (C0463b.m2542qO()) {
            Log.e(str, obj.toString());
        }
    }

    public static void m41c(String str, Object obj) {
        if (C0463b.m2542qO()) {
            Log.i(str, obj.toString());
        }
    }

    public static void m42d(String str, Object obj) {
        if (C0463b.m2542qO()) {
            Log.w(str, obj.toString());
        }
    }
}
