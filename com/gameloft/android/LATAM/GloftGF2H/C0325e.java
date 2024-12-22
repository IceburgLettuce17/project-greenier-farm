package com.gameloft.android.LATAM.GloftGF2H;

import android.content.Context;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import p001a.p004b.p005a.p006a.C0002a;

public final class C0325e {

    private static Context f1907dD = null;

    public static boolean m1959af() {
        Context context = f1907dD;
        boolean isConnected = ((ConnectivityManager) f1907dD.getSystemService("connectivity")).getNetworkInfo(1).isConnected();
        ("UsingWIFI: " + isConnected).toString();
        return isConnected;
    }

    public static String m1960ag() {
        try {
            Context context = f1907dD;
            Resources resources = f1907dD.getResources();
            Context context2 = f1907dD;
            int identifier = resources.getIdentifier("serialkey", "raw", f1907dD.getPackageName());
            Context context3 = f1907dD;
            InputStream openRawResource = f1907dD.getResources().openRawResource(identifier);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openRawResource, Charset.forName("UTF-8")));
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                readLine = "";
            }
            openRawResource.close();
            bufferedReader.close();
            return readLine;
        } catch (Exception e) {
            return "";
        }
    }

    public static String m1961g(String str, String str2) {
        Context context = f1907dD;
        return f1907dD.getSharedPreferences(str2, 0).getString(str, "");
    }

    public static Context getContext() {
        Context context = f1907dD;
        return f1907dD;
    }

    public static String m1962h(String str) {
        try {
            File file = new File(str);
            byte[] bArr = new byte[(int) file.length()];
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(bArr);
            fileInputStream.close();
            return new String(bArr);
        } catch (Exception e) {
            C0002a.m6a(e);
            return null;
        }
    }

    public static boolean m1963h(String str, String str2) {
        try {
            ("WriteFile(), File = " + str).toString();
            File file = new File(str);
            if (!file.exists()) {
                new File(file.getParent()).mkdirs();
                file.createNewFile();
            }
        } catch (Exception e) {
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            outputStreamWriter.append((CharSequence) str2);
            outputStreamWriter.flush();
            outputStreamWriter.close();
            fileOutputStream.close();
            return true;
        } catch (Exception e2) {
            C0002a.m6a(e2);
            return true;
        }
    }

    public static void setContext(Context context) {
        f1907dD = context;
    }
}
