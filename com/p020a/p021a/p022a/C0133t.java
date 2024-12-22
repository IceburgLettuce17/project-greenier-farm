package com.p020a.p021a.p022a;

import android.content.Context;
import p001a.p004b.p005a.p006a.C0002a;

public final class C0133t {

    private static AbstractC0137x f112aX;

    public static String f113aY = "1.0.3";

    private static final C0117d f111aW = C0118e.m251d("PurchasingManagerHandlerThread");

    static {
        f111aW.post(new RunnableC0134u());
    }

    static Context m258Q() {
        if (f112aX == null) {
            return null;
        }
        return f112aX.f116bb.get();
    }

    private static void m259R() {
        if (f112aX == null) {
            throw new IllegalStateException("You must register a PurchasingObserver before invoking this operation");
        }
    }

    public static String m260S() {
        m259R();
        return m261a(new C0115b());
    }

    private static String m261a(AbstractC0138y abstractC0138y) {
        f111aW.post(abstractC0138y.mo249J());
        return abstractC0138y.f117aN;
    }

    public static void m262a(AbstractC0137x abstractC0137x) {
        if (C0002a.m12a()) {
            C0002a.m9a("PurchasingManager", "PurchasingObserver registered: " + abstractC0137x);
        }
        if (abstractC0137x == null) {
            throw new IllegalArgumentException("Provided PurchasingObserver must not be null");
        }
        f112aX = abstractC0137x;
        f111aW.post(new RunnableC0135v(abstractC0137x));
    }

    public static String m263f(String str) {
        m259R();
        return m261a(new C0131r(str));
    }
}
