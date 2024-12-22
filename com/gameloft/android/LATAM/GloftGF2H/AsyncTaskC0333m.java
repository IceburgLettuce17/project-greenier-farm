package com.gameloft.android.LATAM.GloftGF2H;

import android.os.AsyncTask;
import com.facebook.android.C0217R;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;

public final class AsyncTaskC0333m extends AsyncTask<String, Integer, Long> {

    public static int f1949ex = 0;

    public static int f1950ey = 1;

    private static int f1951ez = 2;

    private int f1952eA = 0;

    private String f1953et;

    private File f1954eu;

    private InterfaceC0334n f1955ev;

    private StartUpdate f1956ew;

    public AsyncTaskC0333m(String str, String str2, StartUpdate startUpdate) {
        this.f1956ew = startUpdate;
        this.f1955ev = this.f1956ew;
        this.f1954eu = new File(str);
        if (str2 == null) {
            this.f1953et = "provisional_name.apk";
        } else {
            this.f1953et = str2;
        }
        String str3 = "UPDATE::DownloadFiles::download dir: " + str + " apk name: " + this.f1953et;
    }

    @Override
    private Long doInBackground(String... strArr) {
        for (String str : strArr) {
            try {
                byte[] bArr = new byte[5000];
                double d = 0.0d;
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setReadTimeout(10000);
                String str2 = "UPDATE::DownloadFiles::Status ReadTimeOut: " + httpURLConnection.getReadTimeout() + " ConnectTimeOut: " + httpURLConnection.getConnectTimeout();
                httpURLConnection.setDoOutput(true);
                httpURLConnection.connect();
                long contentLength = httpURLConnection.getContentLength();
                String str3 = "UPDATE::DownloadFiles::APK size: " + contentLength;
                StartUpdate startUpdate = this.f1956ew;
                if (StartUpdate.m592b(contentLength)) {
                    FileOutputStream fileOutputStream = new FileOutputStream(new File(this.f1954eu, this.f1953et), true);
                    InputStream inputStream = httpURLConnection.getInputStream();
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read <= 0 || isCancelled()) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                        d += read;
                        DecimalFormat decimalFormat = new DecimalFormat("0.00");
                        StartUpdate.m599o((int) ((d / contentLength) * 100.0d), this.f1956ew.getString(C0217R.string.DOWNLOADING).replace("{SIZE}", decimalFormat.format((d / 1024.0d) / 1024.0d)).replace("{TOTAL_SIZE}", decimalFormat.format((contentLength / 1024.0d) / 1024.0d)));
                    }
                    fileOutputStream.close();
                    this.f1952eA = 0;
                } else {
                    this.f1952eA = f1950ey;
                }
                httpURLConnection.disconnect();
            } catch (Exception e) {
                this.f1952eA = f1951ez;
            }
            if (isCancelled()) {
                break;
            }
        }
        return 0L;
    }

    @Override
    protected final void onPostExecute(Long l) {
        this.f1955ev.mo600G(this.f1952eA);
    }
}
