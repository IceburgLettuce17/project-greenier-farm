package com.facebook;

public enum SessionLoginBehavior {
    SSO_WITH_FALLBACK(true, true),
    SSO_ONLY(true, false),
    SUPPRESS_SSO(false, true);

    private final boolean allowsKatanaAuth;
    private final boolean allowsWebViewAuth;

    SessionLoginBehavior(boolean z, boolean z2) {
        this.allowsKatanaAuth = z;
        this.allowsWebViewAuth = z2;
    }

    final boolean allowsKatanaAuth() {
        return this.allowsKatanaAuth;
    }

    final boolean allowsWebViewAuth() {
        return this.allowsWebViewAuth;
    }
}
