package com.p020a.p021a.p022a;

public final class C0119f {

    private static volatile boolean f97aK;

    private static volatile boolean f98aL;

    private static volatile InterfaceC0120g f99aM;

    C0119f() {
    }

    private static InterfaceC0120g m252L() {
        if (f99aM == null) {
            synchronized (C0119f.class) {
                if (f99aM == null) {
                    if (m253M()) {
                        f99aM = new C0111ab();
                    } else {
                        f99aM = new C0123j();
                    }
                }
            }
        }
        return f99aM;
    }

    static boolean m253M() {
        if (f98aL) {
            return f97aK;
        }
        synchronized (C0119f.class) {
            if (f98aL) {
                return f97aK;
            }
            try {
                C0119f.class.getClassLoader().loadClass("com.amazon.android.Kiwi");
                f97aK = false;
            } catch (Throwable th) {
                f97aK = true;
            }
            f98aL = true;
            return f97aK;
        }
    }

    static InterfaceC0139z m254N() {
        return (InterfaceC0139z) m256a(InterfaceC0139z.class, null);
    }

    public static InterfaceC0130q m255O() {
        return (InterfaceC0130q) m256a(InterfaceC0130q.class, null);
    }

    private static <T> T m256a(Class<T> cls, T t) {
        if (t == null) {
            synchronized (C0119f.class) {
                if (t == null) {
                    try {
                        t = m252L().mo241a(cls).newInstance();
                    } catch (Exception e) {
                    }
                }
            }
        }
        return t;
    }
}
