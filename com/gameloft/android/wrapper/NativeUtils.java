package com.gameloft.android.wrapper;

public class NativeUtils {
    static {
        System.loadLibrary(C0349c.f2693XI + "nativeU");
    }

    public static native boolean CheckRoot();

    public static native float getClock();

    public static native long getClockMillis();

    public static native long getClockNano();
}
