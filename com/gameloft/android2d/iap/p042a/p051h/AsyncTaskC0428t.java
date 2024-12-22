package com.gameloft.android2d.iap.p042a.p051h;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.widget.Toast;
import com.facebook.android.C0217R;
import com.gameloft.android2d.iap.C0463b;
import p001a.p004b.p005a.p006a.C0012k;

final class AsyncTaskC0428t extends AsyncTask<String, Object, Boolean> {
    final ActivityC0422n acO;
    private C0409a acQ;

    private AsyncTaskC0428t(ActivityC0422n activityC0422n) {
        this.acO = activityC0422n;
        this.acQ = new C0409a();
    }

    AsyncTaskC0428t(ActivityC0422n activityC0422n, byte b2) {
        this(activityC0422n);
    }

    private Boolean m2420sq() {
        C0414f c0414f;
        try {
            c0414f = this.acO.acJ;
            this.acQ = c0414f.m2405sa();
            return true;
        } catch (Exception e) {
            C0012k.m40b("IAP-SamsungIABActivity", "Exception: " + e.getMessage());
            return false;
        }
    }

    @Override
    protected final Boolean doInBackground(String[] strArr) {
        return m2420sq();
    }

    @Override
    protected final void onPostExecute(Boolean bool) {
        ProgressDialog progressDialog;
        C0414f c0414f;
        C0414f c0414f2;
        String str;
        String str2;
        if (true != bool.booleanValue()) {
            if (!TextUtils.isEmpty(this.acQ.acm)) {
                C0012k.m40b("IAP-SamsungIABActivity", "PurchaseItemTask Init ERROR: " + this.acQ.acm);
                if (C0463b.m2539qL() != 0) {
                    Toast.makeText(this.acO, this.acQ.acm, 0).show();
                }
            }
            this.acO.m2416u(0, true);
            return;
        }
        if (this.acQ.mErrorCode == 0) {
            C0012k.m39a("IAP-SamsungIABActivity", "*** Samsung Account Authentication was successful ***");
            c0414f2 = this.acO.acJ;
            ActivityC0422n activityC0422n = this.acO;
            str = ActivityC0422n.acI;
            str2 = ActivityC0422n.aco;
            c0414f2.m2402a(activityC0422n, 1, str, str2);
            return;
        }
        if (this.acQ.mErrorCode != -1001) {
            if (!TextUtils.isEmpty(this.acQ.acm)) {
                C0012k.m40b("IAP-SamsungIABActivity", "PurchaseItemTask ERROR: " + this.acQ.acm);
                if (C0463b.m2539qL() != 0) {
                    Toast.makeText(this.acO, this.acQ.acm, 0).show();
                }
            }
            this.acO.m2416u(0, true);
            return;
        }
        C0012k.m39a("IAP-SamsungIABActivity", "Samsung In-App Purchase upgrade required message");
        ActivityC0422n activityC0422n2 = this.acO;
        progressDialog = this.acO.acK;
        ActivityC0422n.m2407a(progressDialog);
        RunnableC0429u runnableC0429u = new RunnableC0429u(this);
        c0414f = this.acO.acJ;
        c0414f.m2403a(this.acO, this.acO.getString(C0217R.string.IAP_SAMSUNG_DIALOG_TITLE), this.acO.getString(C0217R.string.IAP_SAMSUNG_UPGRADE_REQUIRED), true, runnableC0429u, true);
    }

    @Override
    protected final void onPreExecute() {
        super.onPreExecute();
    }
}
