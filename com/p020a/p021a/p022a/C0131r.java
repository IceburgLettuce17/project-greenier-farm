package com.p020a.p021a.p022a;

final class C0131r extends AbstractC0138y {

    final String f109aR;

    C0131r(String str) {
        if (str == null) {
            throw new IllegalArgumentException("sku must not be null");
        }
        this.f109aR = str;
    }

    @Override
    final Runnable mo249J() {
        return new RunnableC0132s(this);
    }
}
