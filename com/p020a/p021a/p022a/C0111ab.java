package com.p020a.p021a.p022a;

import java.util.HashMap;
import java.util.Map;

final class C0111ab implements InterfaceC0120g {

    private static final Map<Class, Class> f92aP;

    static {
        HashMap hashMap = new HashMap();
        f92aP = hashMap;
        hashMap.put(InterfaceC0139z.class, C0113ad.class);
        f92aP.put(InterfaceC0110aa.class, C0114ae.class);
        f92aP.put(InterfaceC0130q.class, C0112ac.class);
    }

    C0111ab() {
    }

    @Override
    public final <T> Class<T> mo241a(Class<T> cls) {
        return f92aP.get(cls);
    }
}
