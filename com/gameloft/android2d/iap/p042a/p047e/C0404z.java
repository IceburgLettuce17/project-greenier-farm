package com.gameloft.android2d.iap.p042a.p047e;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class C0404z {
    Map<String, C0379aj> abp = new HashMap();
    Map<String, C0370aa> abq = new HashMap();

    C0404z() {
    }

    final List<String> m2359cg(String str) {
        ArrayList arrayList = new ArrayList();
        for (C0370aa c0370aa : this.abq.values()) {
            if (c0370aa.abr.equals(str)) {
                arrayList.add(c0370aa.abt);
            }
        }
        return arrayList;
    }
}
