package com.facebook;

public enum SessionState {
    CREATED(Category.CREATED_CATEGORY),
    CREATED_TOKEN_LOADED(Category.CREATED_CATEGORY),
    OPENING(Category.CREATED_CATEGORY),
    OPENED(Category.OPENED_CATEGORY),
    OPENED_TOKEN_UPDATED(Category.OPENED_CATEGORY),
    CLOSED_LOGIN_FAILED(Category.CLOSED_CATEGORY),
    CLOSED(Category.CLOSED_CATEGORY);

    private final Category category;

    enum Category {
        CREATED_CATEGORY,
        OPENED_CATEGORY,
        CLOSED_CATEGORY
    }

    SessionState(Category category) {
        this.category = category;
    }

    public final boolean isClosed() {
        return this.category == Category.CLOSED_CATEGORY;
    }

    public final boolean isOpened() {
        return this.category == Category.OPENED_CATEGORY;
    }
}
