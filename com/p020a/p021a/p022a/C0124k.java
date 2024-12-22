package com.p020a.p021a.p022a;

import com.amazon.android.framework.util.KiwiLogger;

class C0124k implements InterfaceC0130q {

    private static KiwiLogger f103aQ = new KiwiLogger("In App Purchasing SDK - Production Mode");

    C0124k() {
    }

    private static String m257d(String str, String str2) {
        return str + ": " + str2;
    }

    @Override
    public final boolean mo243P() {
        return KiwiLogger.ERROR_ON;
    }

    @Override
    public final void mo244a(String str, String str2) {
        f103aQ.trace(m257d(str, str2));
    }

    @Override
    public final boolean mo245a() {
        return KiwiLogger.TRACE_ON;
    }

    @Override
    public final void mo246b(String str, String str2) {
        f103aQ.error(m257d(str, str2));
    }
}
