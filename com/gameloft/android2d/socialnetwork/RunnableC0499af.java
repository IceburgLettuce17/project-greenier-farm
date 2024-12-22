package com.gameloft.android2d.socialnetwork;

import android.os.Looper;
import android.os.Process;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

final class RunnableC0499af implements Runnable {
    RunnableC0499af() {
    }

    @Override
    public final void run() {
        String str;
        URL url;
        HttpURLConnection httpURLConnection;
        boolean z;
        boolean z2;
        HttpURLConnection httpURLConnection2;
        boolean z3;
        URL url2;
        String str2;
        int i;
        int i2;
        Looper.prepare();
        Process.setThreadPriority(10);
        byte[] bArr = new byte[16384];
        boolean z4 = false;
        boolean z5 = false;
        String str3 = null;
        URL url3 = null;
        while (true) {
            try {
                Thread.sleep(200L);
            } catch (Exception e) {
            }
            if (z5) {
                str = str3;
                url = url3;
            } else {
                synchronized (SocialNetwork_Facebook.lock) {
                    try {
                        if (SocialNetwork_Facebook.agv.size() > 0) {
                            int i3 = 0;
                            while (true) {
                                if (i3 >= SocialNetwork_Facebook.agt.size()) {
                                    i2 = 0;
                                    break;
                                } else {
                                    if (SocialNetwork_Facebook.agt.get(i3).compareTo(SocialNetwork_Facebook.agv.get(0)) == 0) {
                                        i2 = i3;
                                        break;
                                    }
                                    i3++;
                                }
                            }
                            SocialNetwork_Facebook.agv.remove(0);
                            z4 = true;
                            i = i2;
                        } else {
                            z4 = false;
                            i = 0;
                        }
                    } catch (Exception e2) {
                        z3 = z4;
                        url2 = null;
                    }
                    if (SocialNetwork_Facebook.agt.size() > 0) {
                        str2 = SocialNetwork_Facebook.agt.get(i);
                        SocialNetwork_Facebook.agt.remove(i);
                        url2 = SocialNetwork_Facebook.agw.get(i);
                        try {
                            SocialNetwork_Facebook.agw.remove(i);
                        } catch (Exception e3) {
                            z3 = z4;
                            z4 = z3;
                            str2 = null;
                            str = str2;
                            url = url2;
                            if (str == null) {
                            }
                            if (url == null) {
                                break;
                            } else {
                                break;
                            }
                            SocialNetwork_Facebook.agy--;
                            try {
                                SocialNetwork_Facebook.agz.flush();
                                return;
                            } catch (Exception e4) {
                                String str4 = "Facebook: fos error:" + e4.toString();
                                return;
                            }
                        }
                        if (!SocialNetwork_Facebook.agx.contains(url2)) {
                            SocialNetwork_Facebook.agx.add(url2);
                            SocialNetwork_Facebook.agu.add(str2);
                        }
                    } else {
                        url2 = null;
                    }
                    str2 = null;
                }
                str = str2;
                url = url2;
            }
            if (str == null) {
                try {
                    httpURLConnection2 = (HttpURLConnection) url.openConnection();
                } catch (Exception e5) {
                    e = e5;
                    httpURLConnection = null;
                } catch (Throwable th) {
                    th = th;
                    httpURLConnection = null;
                }
                try {
                    try {
                        httpURLConnection2.setRequestMethod("GET");
                        InputStream inputStream = httpURLConnection2.getInputStream();
                        synchronized (SocialNetwork_Facebook.lock) {
                            int i4 = SocialNetwork_Facebook.agA;
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                SocialNetwork_Facebook.agA += read;
                                SocialNetwork_Facebook.agz.write(bArr, 0, read);
                            }
                            SocialNetwork_Facebook.m2729f(str, i4, SocialNetwork_Facebook.agA - i4);
                        }
                        inputStream.close();
                        SocialNetwork_Facebook.agk.remove(str);
                        SocialNetwork_Facebook.agD++;
                        String str5 = "Facebook: downloaded(" + str + ":" + SocialNetwork_Facebook.agD + ") " + url.toString();
                        if (z4) {
                            try {
                                SocialNetwork_Facebook.agz.flush();
                            } catch (Exception e6) {
                                String str6 = "Facebook: fos error:" + e6.toString();
                            }
                        }
                        httpURLConnection2.disconnect();
                        z2 = false;
                    } catch (Exception e7) {
                        httpURLConnection = httpURLConnection2;
                        e = e7;
                        try {
                            String str7 = "Facebook: url:" + (url != null ? url.toString() : "null") + " Update error! " + e.toString();
                            e.printStackTrace();
                            C0531o c0531o = SocialNetwork_Facebook.agk;
                            if (!c0531o.afK.containsKey(str)) {
                                if (c0531o.afL.containsKey(str)) {
                                    int intValue = c0531o.afL.get(str).intValue() - 1;
                                    if (intValue == 0) {
                                        c0531o.afL.remove(str);
                                        z = true;
                                    } else {
                                        c0531o.afL.put(str, Integer.valueOf(intValue));
                                        z = false;
                                    }
                                    if (z) {
                                        SocialNetwork_Facebook.agt.add(str);
                                        SocialNetwork_Facebook.agw.add(url);
                                        z2 = false;
                                    } else {
                                        z2 = true;
                                    }
                                    SocialNetwork_Facebook.m2729f(str, 0, 0);
                                    httpURLConnection.disconnect();
                                    SocialNetwork_Facebook.agx.remove(url);
                                    SocialNetwork_Facebook.agu.remove(str);
                                    int i5 = SocialNetwork_Facebook.agD;
                                    System.gc();
                                    if (url == null) {
                                    }
                                    SocialNetwork_Facebook.agy--;
                                    SocialNetwork_Facebook.agz.flush();
                                    return;
                                }
                                c0531o.afK.put(str, 10);
                            }
                            int intValue2 = c0531o.afK.get(str).intValue() - 1;
                            if (intValue2 == 0) {
                                c0531o.remove(str);
                                z = false;
                            } else {
                                c0531o.afK.put(str, Integer.valueOf(intValue2));
                                z = true;
                            }
                            if (z) {
                            }
                            SocialNetwork_Facebook.m2729f(str, 0, 0);
                            httpURLConnection.disconnect();
                            SocialNetwork_Facebook.agx.remove(url);
                            SocialNetwork_Facebook.agu.remove(str);
                            int i52 = SocialNetwork_Facebook.agD;
                            System.gc();
                            if (url == null) {
                            }
                            SocialNetwork_Facebook.agy--;
                            SocialNetwork_Facebook.agz.flush();
                            return;
                        } catch (Throwable th2) {
                            th = th2;
                            httpURLConnection.disconnect();
                            throw th;
                        }
                    }
                    SocialNetwork_Facebook.agx.remove(url);
                    SocialNetwork_Facebook.agu.remove(str);
                    int i522 = SocialNetwork_Facebook.agD;
                    System.gc();
                } catch (Throwable th3) {
                    httpURLConnection = httpURLConnection2;
                    th = th3;
                    httpURLConnection.disconnect();
                    throw th;
                }
            } else {
                z2 = z5;
            }
            if (url == null || SocialNetwork_Facebook.agp) {
                break;
            }
            z5 = z2;
            url3 = url;
            str3 = str;
        }
    }
}
