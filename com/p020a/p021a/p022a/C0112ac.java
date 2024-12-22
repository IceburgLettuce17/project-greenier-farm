package com.p020a.p021a.p022a;

import android.util.Log;

class C0112ac implements InterfaceC0130q {
    C0112ac() {
    }

    private static String m242g(String str) {
        return "In App Purchasing SDK - Sandbox Mode: " + str;
    }

    @Override
    public final boolean mo243P() {
        return true;
    }

    @Override
    public final void mo244a(String str, String str2) {
        Log.d(str, m242g(str2));
    }

    @Override
    public final boolean mo245a() {
        return true;
    }

    @Override
    public final void mo246b(String str, String str2) {
        Log.e(str, m242g(str2));
    }
}
