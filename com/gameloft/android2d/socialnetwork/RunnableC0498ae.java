package com.gameloft.android2d.socialnetwork;

import java.io.InputStream;
import p009b.p010a.p012b.C0051af;

final class RunnableC0498ae implements Runnable {
    private String aha;

    RunnableC0498ae(String str) {
        this.aha = str;
    }

    @Override
    public final void run() {
        boolean z;
        SocialNetwork_Facebook.m2746tz();
        if (SocialNetwork_Facebook.agv.size() < 2) {
            SocialNetwork_Facebook.agv.add(this.aha);
        }
        synchronized (SocialNetwork_Facebook.lock) {
            if (SocialNetwork_Facebook.agB.containsKey(this.aha) && SocialNetwork_Facebook.agC.get(this.aha).intValue() > 0) {
                InputStream m2723cZ = SocialNetwork_Facebook.m2723cZ(this.aha);
                if (m2723cZ == null) {
                    z = true;
                } else {
                    try {
                        C0051af m120a = C0051af.m120a(m2723cZ, SocialNetwork_Facebook.agi, SocialNetwork_Facebook.agj);
                        m2723cZ.close();
                        z = m120a == null;
                        m120a.recycle();
                    } catch (Exception e) {
                        z = true;
                    }
                }
                if (z) {
                    SocialNetwork_Facebook.m2729f(this.aha, 0, 0);
                }
            }
        }
        SocialNetwork_Facebook.m2712a(this.aha, SocialNetwork_Facebook.m2721cX(this.aha));
    }
}
