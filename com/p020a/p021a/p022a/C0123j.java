package com.p020a.p021a.p022a;

import java.util.HashMap;
import java.util.Map;

final class C0123j implements InterfaceC0120g {

    private static final Map<Class, Class> f102aP;

    static {
        HashMap hashMap = new HashMap();
        f102aP = hashMap;
        hashMap.put(InterfaceC0139z.class, C0126m.class);
        f102aP.put(InterfaceC0110aa.class, C0129p.class);
        f102aP.put(InterfaceC0130q.class, C0124k.class);
    }

    C0123j() {
    }

    @Override
    public final <T> Class<T> mo241a(Class<T> cls) {
        return f102aP.get(cls);
    }
}
