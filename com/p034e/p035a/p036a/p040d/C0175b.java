package com.p034e.p035a.p036a.p040d;

import android.app.AlertDialog;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import com.facebook.android.Facebook;
import com.p029d.p031b.p032a.p033a.C0155a;
import com.p034e.p035a.p036a.C0156a;
import com.p034e.p035a.p036a.C0182k;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

public final class C0175b {
    static {
        "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
    }

    public static String m321a(C0182k c0182k) {
        boolean z;
        if (c0182k == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean z2 = true;
        int i = 0;
        while (i < c0182k.ahP.size()) {
            if (z2) {
                z = false;
            } else {
                sb.append("&");
                z = z2;
            }
            String m335fi = c0182k.m335fi(i);
            if (c0182k.getValue(m335fi) == null) {
                C0155a.m283N("encodeUrl", "key:" + m335fi + " 's value is null");
            } else {
                sb.append(String.valueOf(URLEncoder.encode(c0182k.m335fi(i))) + "=" + URLEncoder.encode((i < 0 || i >= c0182k.ahP.size()) ? null : c0182k.ahQ.get(i)));
            }
            C0155a.m283N("encodeUrl", sb.toString());
            i++;
            z2 = z;
        }
        return sb.toString();
    }

    public static Bundle m322b(C0156a c0156a) {
        Bundle bundle = new Bundle();
        bundle.putString("access_token", c0156a.ahu);
        bundle.putString("refresh_token", c0156a.ahv);
        bundle.putString(Facebook.EXPIRES, new StringBuilder(String.valueOf(c0156a.ahw)).toString());
        return bundle;
    }

    public static String m323b(C0182k c0182k) {
        if (c0182k != null) {
            if (!(c0182k == null || c0182k.ahP.size() == 0)) {
                StringBuilder sb = new StringBuilder();
                int i = 0;
                for (int i2 = 0; i2 < c0182k.ahP.size(); i2++) {
                    String m335fi = c0182k.m335fi(i2);
                    if (i != 0) {
                        sb.append("&");
                    }
                    try {
                        sb.append(URLEncoder.encode(m335fi, "UTF-8")).append("=").append(URLEncoder.encode(c0182k.getValue(m335fi), "UTF-8"));
                    } catch (UnsupportedEncodingException e) {
                    }
                    i++;
                }
                return sb.toString();
            }
        }
        return "";
    }

    public static Bundle m324de(String str) {
        Bundle bundle = new Bundle();
        if (str != null && str.indexOf("{") >= 0) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                bundle.putString("error", jSONObject.optString("error"));
                bundle.putString("error_code", jSONObject.optString("error_code"));
                bundle.putString("error_description", jSONObject.optString("error_description"));
            } catch (JSONException e) {
                bundle.putString("error", "JSONExceptionerror");
            }
        }
        return bundle;
    }

    private static Bundle decodeUrl(String str) {
        Bundle bundle = new Bundle();
        if (str != null) {
            for (String str2 : str.split("&")) {
                String[] split = str2.split("=");
                bundle.putString(URLDecoder.decode(split[0]), URLDecoder.decode(split[1]));
            }
        }
        return bundle;
    }

    public static String m325e(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            for (int i = 0; i < packageInfo.signatures.length; i++) {
                byte[] byteArray = packageInfo.signatures[i].toByteArray();
                if (byteArray != null) {
                    return C0174a.m320h(byteArray);
                }
            }
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    public static Bundle parseUrl(String str) {
        try {
            URL url = new URL(str);
            Bundle decodeUrl = decodeUrl(url.getQuery());
            decodeUrl.putAll(decodeUrl(url.getRef()));
            return decodeUrl;
        } catch (MalformedURLException e) {
            return new Bundle();
        }
    }

    public static void showAlert(Context context, String str, String str2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.create().show();
    }

    public static boolean m326t(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
    }

    public static boolean m327u(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
        if (allNetworkInfo != null) {
            for (NetworkInfo networkInfo : allNetworkInfo) {
                if (NetworkInfo.State.CONNECTED == networkInfo.getState()) {
                    return true;
                }
            }
        }
        return false;
    }
}
