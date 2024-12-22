package com.p034e.p035a.p036a.p039c;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import com.p034e.p035a.p036a.C0162b;
import com.p034e.p035a.p036a.InterfaceC0177f;
import com.p034e.p035a.p036a.p040d.C0175b;

public final class C0171a {
    private static String aid = "";
    private static String aie = "";
    private ServiceConnection aic;
    private Activity aif;
    private C0162b aig;

    public C0171a(Activity activity, C0162b c0162b) {
        this.aic = null;
        this.aif = activity;
        this.aig = c0162b;
        C0162b.m294ai(C0175b.m326t(activity));
        this.aic = new ServiceConnectionC0172b(this);
    }

    private static boolean m310a(Activity activity, Intent intent) {
        ResolveInfo resolveActivity = activity.getPackageManager().resolveActivity(intent, 0);
        if (resolveActivity == null) {
            return false;
        }
        try {
            Signature[] signatureArr = activity.getPackageManager().getPackageInfo(resolveActivity.activityInfo.packageName, 64).signatures;
            for (Signature signature : signatureArr) {
                if ("30820295308201fea00302010202044b4ef1bf300d06092a864886f70d010105050030818d310b300906035504061302434e3110300e060355040813074265694a696e673110300e060355040713074265694a696e67312c302a060355040a132353696e612e436f6d20546563686e6f6c6f677920284368696e612920436f2e204c7464312c302a060355040b132353696e612e436f6d20546563686e6f6c6f677920284368696e612920436f2e204c74643020170d3130303131343130323831355a180f32303630303130323130323831355a30818d310b300906035504061302434e3110300e060355040813074265694a696e673110300e060355040713074265694a696e67312c302a060355040a132353696e612e436f6d20546563686e6f6c6f677920284368696e612920436f2e204c7464312c302a060355040b132353696e612e436f6d20546563686e6f6c6f677920284368696e612920436f2e204c746430819f300d06092a864886f70d010101050003818d00308189028181009d367115bc206c86c237bb56c8e9033111889b5691f051b28d1aa8e42b66b7413657635b44786ea7e85d451a12a82a331fced99c48717922170b7fc9bc1040753c0d38b4cf2b22094b1df7c55705b0989441e75913a1a8bd2bc591aa729a1013c277c01c98cbec7da5ad7778b2fad62b85ac29ca28ced588638c98d6b7df5a130203010001300d06092a864886f70d0101050500038181000ad4b4c4dec800bd8fd2991adfd70676fce8ba9692ae50475f60ec468d1b758a665e961a3aedbece9fd4d7ce9295cd83f5f19dc441a065689d9820faedbb7c4a4c4635f5ba1293f6da4b72ed32fb8795f736a20c95cda776402099054fccefb4a1a558664ab8d637288feceba9508aa907fc1fe2b1ae5a0dec954ed831c0bea4".equals(signature.toCharsString())) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    public boolean m311a(Activity activity, String str, String str2, int i) {
        boolean z = true;
        String packageName = activity.getApplicationContext().getPackageName();
        Intent intent = new Intent();
        intent.setClassName(aid, aie);
        intent.putExtra("appKey", str);
        intent.putExtra("redirectUri", C0162b.m298tK());
        intent.putExtra("packagename", packageName);
        intent.putExtra("key_hash", C0175b.m325e(activity.getApplicationContext(), packageName));
        if (str2 != null) {
            intent.putExtra("scope", str2);
        }
        if (!m310a(activity, intent)) {
            return false;
        }
        try {
            activity.startActivityForResult(intent, i);
        } catch (ActivityNotFoundException e) {
            z = false;
        }
        activity.getApplication().unbindService(this.aic);
        return z;
    }

    static InterfaceC0177f m314c(C0171a c0171a) {
        return null;
    }

    static int m315d(C0171a c0171a) {
        return 0;
    }
}
