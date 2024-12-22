package com.facebook;

public enum SessionDefaultAudience {
    NONE(null),
    ONLY_ME("SELF"),
    FRIENDS("ALL_FRIENDS"),
    EVERYONE("EVERYONE");

    private final String nativeProtocolAudience;

    SessionDefaultAudience(String str) {
        this.nativeProtocolAudience = str;
    }

    final String getNativeProtocolAudience() {
        return this.nativeProtocolAudience;
    }
}
