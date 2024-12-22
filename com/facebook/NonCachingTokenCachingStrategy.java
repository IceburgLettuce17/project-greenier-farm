package com.facebook;

import android.os.Bundle;

public class NonCachingTokenCachingStrategy extends TokenCachingStrategy {
    @Override
    public void clear() {
    }

    @Override
    public Bundle load() {
        return null;
    }

    @Override
    public void save(Bundle bundle) {
    }
}
