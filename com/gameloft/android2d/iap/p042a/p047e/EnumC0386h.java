package com.gameloft.android2d.iap.p042a.p047e;

public enum EnumC0386h {
    PURCHASED,
    CANCELED,
    REFUNDED;

    public static EnumC0386h m2328eW(int i) {
        EnumC0386h[] enumC0386hArr = (EnumC0386h[]) values().clone();
        return (i < 0 || i >= enumC0386hArr.length) ? CANCELED : enumC0386hArr[i];
    }
}
