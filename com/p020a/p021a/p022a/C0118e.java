package com.p020a.p021a.p022a;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.HashMap;
import java.util.Map;

class C0118e {

    private static volatile Map<String, C0117d> f95aI = new HashMap();

    private static volatile C0117d f96aJ = null;

    C0118e() {
    }

    static C0117d m250K() {
        if (f96aJ == null) {
            synchronized (C0118e.class) {
                if (f96aJ == null) {
                    f96aJ = new C0117d(new Handler(C0133t.m258Q().getMainLooper()));
                }
            }
        }
        return f96aJ;
    }

    static C0117d m251d(String str) {
        if (!f95aI.containsKey(str)) {
            synchronized (C0118e.class) {
                if (!f95aI.containsKey(str)) {
                    HandlerThread handlerThread = new HandlerThread(str);
                    handlerThread.start();
                    f95aI.put(str, new C0117d(new Handler(handlerThread.getLooper())));
                }
            }
        }
        return f95aI.get(str);
    }
}
