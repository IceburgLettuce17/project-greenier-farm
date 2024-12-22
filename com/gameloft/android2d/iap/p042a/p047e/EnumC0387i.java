package com.gameloft.android2d.iap.p042a.p047e;

public enum EnumC0387i {
    RESULT_OK,
    RESULT_USER_CANCELED,
    RESULT_SERVICE_UNAVAILABLE,
    RESULT_BILLING_UNAVAILABLE,
    RESULT_ITEM_UNAVAILABLE,
    RESULT_DEVELOPER_ERROR,
    RESULT_ERROR;

    public static EnumC0387i m2329eX(int i) {
        EnumC0387i[] enumC0387iArr = (EnumC0387i[]) values().clone();
        return (i < 0 || i >= enumC0387iArr.length) ? RESULT_ERROR : enumC0387iArr[i];
    }
}
