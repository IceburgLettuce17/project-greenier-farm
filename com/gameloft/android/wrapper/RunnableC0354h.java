package com.gameloft.android.wrapper;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;

final class RunnableC0354h implements Runnable {

    private int f2716Ye;

    RunnableC0354h(int i) {
        this.f2716Ye = i;
    }

    @Override
    public final void run() {
        String str;
        try {
            str = C0352f.f2707XW;
            String m2184bh = C0352f.m2184bh(str);
            switch (this.f2716Ye) {
                case 0:
                    m2184bh = m2184bh + "&t=facebook";
                    break;
                case 1:
                case 2:
                case 3:
                    m2184bh = m2184bh + "&ctg=FBOOK";
                    break;
            }
            String str2 = "serverURL " + m2184bh;
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(m2184bh).openConnection();
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
