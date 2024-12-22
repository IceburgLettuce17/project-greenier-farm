package p009b.p010a.p015d;

import com.gameloft.android.LATAM.GloftGF2H.C0335o;
import com.gameloft.android.LATAM.GloftGF2H.PushNotification.C0263i;

public final class RunnableC0097f implements Runnable {
    @Override
    public final void run() {
        while (C0335o.m2036az() == null) {
            try {
                Thread.sleep(1000L);
            } catch (Exception e) {
            }
        }
        String str = "PushNotification Pandora url: " + C0335o.m2036az().replace("/" + C0335o.m2033aM(), "");
        String str2 = "PushNotification Client Id: " + C0335o.m2033aM();
        C0263i.f323xU = C0335o.m2036az().replace("/" + C0335o.m2033aM(), "");
        C0263i.f324xV = C0335o.m2033aM();
        C0263i.m561da();
    }
}
