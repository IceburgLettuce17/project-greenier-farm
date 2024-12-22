package com.gameloft.android2d.iap.p042a.p051h;

import android.os.AsyncTask;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import p001a.p004b.p005a.p006a.C0012k;

final class AsyncTaskC0430v extends AsyncTask<Void, Void, Boolean> {
    private ActivityC0422n acO;
    private C0411c acT;
    private C0431w acU = null;

    public AsyncTaskC0430v(ActivityC0422n activityC0422n, C0411c c0411c) {
        this.acO = activityC0422n;
        this.acT = null;
        this.acT = c0411c;
    }

    private static String m2421cr(String str) {
        BufferedInputStream bufferedInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        String str2;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            URLConnection openConnection = new URL(str).openConnection();
            openConnection.setConnectTimeout(10000);
            openConnection.setReadTimeout(10000);
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() == 200) {
                bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream(), 4096);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream(4096);
                } catch (Exception e) {
                    e = e;
                    byteArrayOutputStream = null;
                } catch (Throwable th) {
                    th = th;
                    if (bufferedInputStream != null) {
                    }
                    if (byteArrayOutputStream2 != null) {
                    }
                }
                try {
                    try {
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int read = bufferedInputStream.read(bArr, 0, 4096);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                        byteArrayOutputStream.flush();
                        str2 = byteArrayOutputStream.toString();
                    } catch (Throwable th2) {
                        th = th2;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (Exception e2) {
                            }
                        }
                        if (byteArrayOutputStream2 != null) {
                            throw th;
                        }
                        try {
                            byteArrayOutputStream2.close();
                            throw th;
                        } catch (IOException e3) {
                            throw th;
                        }
                    }
                } catch (Exception e4) {
                    e = e4;
                    C0012k.m40b("IAP-SamsungIABActivity", "Exception: " + e.getMessage());
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (Exception e5) {
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                            return null;
                        } catch (IOException e6) {
                            return null;
                        }
                    }
                    return null;
                }
            } else {
                byteArrayOutputStream = null;
                bufferedInputStream = null;
                str2 = null;
            }
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (Exception e7) {
                }
            }
            if (byteArrayOutputStream == null) {
                return str2;
            }
            try {
                byteArrayOutputStream.close();
                return str2;
            } catch (IOException e8) {
                return str2;
            }
        } catch (Exception e9) {
            e = e9;
            byteArrayOutputStream = null;
            bufferedInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = null;
        }
    }

    private Boolean m2422sr() {
        String m2421cr;
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(this.acT.acw);
            stringBuffer.append("&purchaseID=" + this.acT.acv);
            C0012k.m39a("IAP-SamsungIABActivity", "VerifyClientToServerUrl :" + ((Object) stringBuffer));
            int i = 0;
            do {
                m2421cr = m2421cr(stringBuffer.toString());
                i++;
                if (i >= 3) {
                    break;
                }
            } while (true == TextUtils.isEmpty(m2421cr));
            if (m2421cr == null || TextUtils.isEmpty(m2421cr)) {
                return false;
            }
            this.acU = new C0431w(m2421cr);
            return this.acU != null && true == "true".equals(this.acU.acV) && true == this.acT.acu.equals(this.acU.acu);
        } catch (Exception e) {
            C0012k.m40b("IAP-SamsungIABActivity", "Exception: " + e.getMessage());
            return false;
        }
    }

    @Override
    protected final Boolean doInBackground(Void[] voidArr) {
        return m2422sr();
    }

    @Override
    protected final void onCancelled() {
        C0012k.m42d("IAP-SamsungIABActivity", "VerifyClientToServerTask Cancelled");
        this.acO.m2416u(0, true);
        super.onCancelled();
    }

    @Override
    protected final void onPostExecute(Boolean bool) {
        if (bool.booleanValue()) {
            C0012k.m39a("IAP-SamsungIABActivity", "Payment success \n-itemId : " + this.acT.aco + "\n-paymentId : " + this.acT.acu);
            this.acO.m2416u(1, true);
        } else {
            C0012k.m40b("IAP-SamsungIABActivity", "Payment is not valid!! \n-ItemId : " + this.acT.aco + "\n-paymentId : " + this.acT.acu);
            this.acO.m2416u(2, true);
        }
    }

    @Override
    protected final void onPreExecute() {
        super.onPreExecute();
        if (this.acT == null || true == TextUtils.isEmpty(this.acT.acw) || true == TextUtils.isEmpty(this.acT.acv) || true == TextUtils.isEmpty(this.acT.acu)) {
            cancel(true);
        }
    }
}
