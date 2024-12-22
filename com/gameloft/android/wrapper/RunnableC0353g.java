package com.gameloft.android.wrapper;

import android.text.TextUtils;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;

final class RunnableC0353g implements Runnable {
    RunnableC0353g() {
    }

    @Override
    public final void run() {
        String str;
        try {
            String m2184bh = C0352f.m2184bh(C0352f.f2706XV);
            if (C0355i.m2197b("track_launch", true, C0352f.f2702XR + "_" + C0352f.f2703XS)) {
                str = m2184bh + "&check=1";
                C0355i.m2194a("track_launch", (Object) false, C0352f.f2702XR + "_" + C0352f.f2703XS);
            } else {
                str = m2184bh + "&check=2";
            }
            if (C0352f.f2714Yd.equals("ANMP")) {
                str = (C0355i.getContext().getApplicationInfo().flags & 128) != 0 ? str + "&appType=2" : (C0355i.getContext().getApplicationInfo().flags & 1) != 0 ? str + "&appType=1" : str + "&appType=3";
                if (!TextUtils.isEmpty(C0355i.m2222qs())) {
                    str = str + "&injected_igp=" + C0355i.m2222qs();
                }
                if (!TextUtils.isEmpty(C0355i.m2223qt())) {
                    str = str + "&d=" + C0355i.m2223qt();
                }
            }
            String str2 = "serverURL " + str;
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(C0352f.f2705XU);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Connection", "close");
            String str3 = "response: " + httpURLConnection.getResponseCode();
        } catch (UnknownHostException e) {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
