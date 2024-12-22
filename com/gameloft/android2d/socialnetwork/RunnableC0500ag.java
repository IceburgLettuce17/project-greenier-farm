package com.gameloft.android2d.socialnetwork;

import android.content.SharedPreferences;
import android.os.Looper;
import android.os.Process;
import com.gameloft.android.wrapper.C0355i;
import java.util.Enumeration;

final class RunnableC0500ag implements Runnable {
    RunnableC0500ag() {
    }

    @Override
    public final void run() {
        Looper.prepare();
        Process.setThreadPriority(10);
        Enumeration<String> keys = SocialNetwork_Facebook.agB.keys();
        SharedPreferences.Editor edit = C0355i.getContext().getSharedPreferences("FileOfOffsets", 0).edit();
        SharedPreferences.Editor edit2 = C0355i.getContext().getSharedPreferences("FileOfLengths", 0).edit();
        while (keys.hasMoreElements()) {
            String nextElement = keys.nextElement();
            if (SocialNetwork_Facebook.agC.get(nextElement).intValue() > 0) {
                edit.putInt(nextElement, SocialNetwork_Facebook.agB.get(nextElement).intValue());
                edit2.putInt(nextElement, SocialNetwork_Facebook.agC.get(nextElement).intValue());
            }
        }
        edit.commit();
        edit2.commit();
        try {
            SocialNetwork_Facebook.agz.flush();
        } catch (Exception e) {
        }
        SocialNetwork_Facebook.agE = false;
    }
}
