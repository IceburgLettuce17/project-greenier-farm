package com.gameloft.android.LATAM.GloftGF2H;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;
import com.facebook.android.C0217R;
import com.gameloft.android.wrapper.C0349c;
import com.gameloft.android.wrapper.C0355i;
import java.net.URLEncoder;
import java.util.Locale;
import p009b.p010a.p012b.AbstractC0054c;
import p009b.p010a.p012b.C0051af;
import p009b.p010a.p015d.AbstractActivityC0092a;

public class Start extends GloftGF2H {
    private static boolean m586b(String str, String[] strArr) {
        String str2 = " DEVICE MODEL: " + str;
        for (String str3 : strArr) {
            if (str.compareTo(str3) == 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    @Override
    public void onCreate(Bundle bundle) {
        boolean z;
        String str;
        int i;
        C0349c.f2689XE = "landscape";
        AbstractC0054c.setScale(1.0f, 1.0f);
        C0349c.f2690XF = "".compareTo("Single_axis_auto_align") == 0;
        C0349c.f2691XG = "".compareTo("Multiple_axis_auto_align") == 0;
        AbstractC0054c.m126ak(true);
        AbstractC0054c.m127am(true);
        AbstractC0054c.m128fj(-7);
        AbstractC0054c.m129fk(-8);
        C0051af.m122b(false, false);
        AbstractActivityC0092a.akQ = false;
        AbstractActivityC0092a.alD = false;
        AbstractActivityC0092a.akS = false;
        AbstractActivityC0092a.akV = false;
        AbstractActivityC0092a.alB = true;
        AbstractActivityC0092a.akT = false;
        AbstractActivityC0092a.akU = false;
        AbstractActivityC0092a.alc = false;
        C0349c.f2693XI = "GF2H";
        C0349c.f2695XK = false;
        C0349c.f2688XD = false;
        AbstractActivityC0092a.ald = true;
        AbstractActivityC0092a.ali = false;
        AbstractActivityC0092a.alj = false;
        AbstractActivityC0092a.alk = "USE_IAP_GL_SHOP";
        AbstractActivityC0092a.ale = false;
        AbstractActivityC0092a.alf = false;
        AbstractActivityC0092a.alg = false;
        AbstractActivityC0092a.alr = "";
        AbstractActivityC0092a.all = false;
        AbstractActivityC0092a.alm = false;
        AbstractActivityC0092a.aln = false;
        AbstractActivityC0092a.alo = false;
        AbstractActivityC0092a.alp = false;
        AbstractActivityC0092a.alq = false;
        C0349c.f2697XM = false;
        AbstractActivityC0092a.akZ = false;
        AbstractActivityC0092a.ala = true;
        AbstractActivityC0092a.alw = false;
        AbstractActivityC0092a.alx = false;
        AbstractActivityC0092a.akW = true;
        AbstractActivityC0092a.akX = "LATAM";
        AbstractActivityC0092a.akY = AbstractActivityC0092a.m209a(this, "GAME-IGP-CODE");
        AbstractActivityC0092a.VERSION = "100";
        C0349c.f2692XH = 0;
        C0349c.f2687XC = true;
        long m2192a = C0355i.m2192a(getFilesDir().getPath(), this);
        String str2 = " Current memory space: " + m2192a;
        String[] strArr = {"EN", "FR", "DE", "IT", "ES", "JA", "KO", "ZH", "BR", "PT", "RU", "TR", "AR", "TH", "ID", "VI", "ZT"};
        int[][] iArr = {new int[]{C0217R.string.LOW_MEMORY_EN, C0217R.string.LOW_MEMORY_OK_EN}, new int[]{C0217R.string.LOW_MEMORY_FR, C0217R.string.LOW_MEMORY_OK_FR}, new int[]{C0217R.string.LOW_MEMORY_DE, C0217R.string.LOW_MEMORY_OK_DE}, new int[]{C0217R.string.LOW_MEMORY_IT, C0217R.string.LOW_MEMORY_OK_IT}, new int[]{C0217R.string.LOW_MEMORY_SP, C0217R.string.LOW_MEMORY_OK_SP}, new int[]{C0217R.string.LOW_MEMORY_JP, C0217R.string.LOW_MEMORY_OK_JP}, new int[]{C0217R.string.LOW_MEMORY_KR, C0217R.string.LOW_MEMORY_OK_KR}, new int[]{C0217R.string.LOW_MEMORY_CN, C0217R.string.LOW_MEMORY_OK_CN}, new int[]{C0217R.string.LOW_MEMORY_BR, C0217R.string.LOW_MEMORY_OK_BR}, new int[]{C0217R.string.LOW_MEMORY_PT, C0217R.string.LOW_MEMORY_OK_PT}, new int[]{C0217R.string.LOW_MEMORY_RU, C0217R.string.LOW_MEMORY_OK_RU}, new int[]{C0217R.string.LOW_MEMORY_TR, C0217R.string.LOW_MEMORY_OK_TR}, new int[]{C0217R.string.LOW_MEMORY_AR, C0217R.string.LOW_MEMORY_OK_AR}, new int[]{C0217R.string.LOW_MEMORY_TH, C0217R.string.LOW_MEMORY_OK_TH}, new int[]{C0217R.string.LOW_MEMORY_ID, C0217R.string.LOW_MEMORY_OK_ID}, new int[]{C0217R.string.LOW_MEMORY_VI, C0217R.string.LOW_MEMORY_OK_VI}, new int[]{C0217R.string.LOW_MEMORY_ZT, C0217R.string.LOW_MEMORY_OK_ZT}};
        if (m2192a < 1) {
            try {
                str = URLEncoder.encode(Locale.getDefault().getLanguage(), "UTF-8").toUpperCase();
            } catch (Exception e) {
                str = "EN";
            }
            int i2 = 0;
            while (true) {
                if (i2 >= strArr.length) {
                    i = -1;
                    break;
                } else {
                    if (str.equals(strArr[i2])) {
                        i = i2;
                        break;
                    }
                    i2++;
                }
            }
            if (i == -1) {
                i = 0;
            }
            try {
                AlertDialog create = new AlertDialog.Builder(this).setPositiveButton(getString(iArr[i][1]), new DialogInterfaceOnClickListenerC0301ba(this)).setMessage(getString(iArr[i][0])).create();
                create.setCancelable(false);
                create.setCanceledOnTouchOutside(false);
                create.setOnKeyListener(new DialogInterfaceOnKeyListenerC0302bb(this));
                create.show();
            } catch (Exception e2) {
            }
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            AbstractActivityC0092a.alQ = true;
            super.onCreate(bundle);
            return;
        }
        super.onCreate(bundle);
        String str3 = " Phone model " + Build.MODEL;
        String str4 = " Phone sdk " + Build.VERSION.SDK_INT;
        Display defaultDisplay = ((WindowManager) getSystemService("window")).getDefaultDisplay();
        int width = defaultDisplay.getWidth();
        int height = defaultDisplay.getHeight();
        String str5 = " Width = " + width + " Height = " + height;
        if (m586b(width + "x" + height, "".split(","))) {
            C0051af.m122b(true, false);
        }
        if (m586b(height + "x" + width, "".split(","))) {
            C0051af.m122b(true, false);
        }
        if (m586b(Build.MODEL, "".split(","))) {
            C0051af.m122b(true, false);
        }
        if (m586b(new StringBuilder().append(Build.VERSION.SDK_INT).toString(), "".split(","))) {
            C0051af.m122b(true, false);
        }
        AbstractActivityC0092a.alE = false;
        C0349c.f2694XJ = false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        try {
            Thread.sleep(1000L);
        } catch (Exception e) {
        }
    }
}
