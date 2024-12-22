package com.gameloft.android2d.iap.p042a.p051h;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.facebook.android.C0217R;
import com.gameloft.android2d.iap.C0463b;
import java.util.ArrayList;
import java.util.Iterator;
import p001a.p004b.p005a.p006a.C0012k;

final class AsyncTaskC0426r extends AsyncTask<String, Object, Boolean> {
    final ActivityC0422n acO;
    private ArrayList<C0410b> acP = null;
    private C0409a acQ = new C0409a();

    public AsyncTaskC0426r(ActivityC0422n activityC0422n, Context context) {
        this.acO = activityC0422n;
    }

    private Boolean m2418sq() {
        C0414f c0414f;
        String str;
        try {
            c0414f = this.acO.acJ;
            str = ActivityC0422n.acI;
            Bundle m2401D = c0414f.m2401D(str, "10");
            this.acQ.mErrorCode = m2401D.getInt("STATUS_CODE");
            this.acQ.acm = m2401D.getString("ERROR_STRING");
            this.acQ.acn = m2401D.getString("IAP_UPGRADE_URL");
            if (this.acQ.mErrorCode != 0) {
                C0012k.m42d("IAP-SamsungIABActivity", "GetItemListTask MESSAGE: " + m2401D.getString("ERROR_STRING"));
                return false;
            }
            ArrayList<String> stringArrayList = m2401D.getStringArrayList("RESULT_LIST");
            if (stringArrayList != null) {
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    C0410b c0410b = new C0410b(it.next());
                    this.acP.add(c0410b);
                    C0012k.m39a("IAP-SamsungIABActivity", "**********************************");
                    C0012k.m39a("IAP-SamsungIABActivity", "ITEM ID: " + c0410b.aco);
                    C0012k.m39a("IAP-SamsungIABActivity", "ITEM TYPE: " + c0410b.act);
                    C0012k.m39a("IAP-SamsungIABActivity", "ITEM NAME: " + c0410b.acp);
                    C0012k.m39a("IAP-SamsungIABActivity", "ITEM PRICE: " + c0410b.acq);
                    C0012k.m39a("IAP-SamsungIABActivity", "ITEM PRICE STR: " + c0410b.acr);
                    C0012k.m39a("IAP-SamsungIABActivity", "ITEM DESC: " + c0410b.acs);
                    C0012k.m39a("IAP-SamsungIABActivity", "**********************************");
                }
            } else {
                C0012k.m42d("IAP-SamsungIABActivity", "Bundle Value 'RESULT_LIST' is null");
            }
            return true;
        } catch (Exception e) {
            C0012k.m40b("IAP-SamsungIABActivity", "GetItemListTask Exception: " + e.getMessage());
            return false;
        }
    }

    @Override
    protected final Boolean doInBackground(String[] strArr) {
        return m2418sq();
    }

    @Override
    protected final void onPostExecute(Boolean bool) {
        ProgressDialog progressDialog;
        C0414f c0414f;
        if (bool.booleanValue()) {
            try {
                if (this.acP != null && this.acP.size() > 0) {
                    C0012k.m39a("IAP-SamsungIABActivity", "Item list OK!");
                    this.acO.m2415so();
                    return;
                } else {
                    C0012k.m42d("IAP-SamsungIABActivity", "Item list EMPTY!");
                    if (!TextUtils.isEmpty(this.acQ.acm)) {
                        C0012k.m42d("IAP-SamsungIABActivity", "Message: " + this.acQ.acm);
                    }
                    this.acO.m2416u(0, true);
                    return;
                }
            } catch (Exception e) {
                C0012k.m40b("IAP-SamsungIABActivity", "Exception: " + e.getMessage());
            }
        } else {
            ActivityC0422n activityC0422n = this.acO;
            progressDialog = this.acO.acK;
            ActivityC0422n.m2407a(progressDialog);
            if (this.acQ.mErrorCode == -1001) {
                C0012k.m39a("IAP-SamsungIABActivity", "Samsung In-App Purchase upgrade required message");
                RunnableC0427s runnableC0427s = new RunnableC0427s(this);
                c0414f = this.acO.acJ;
                c0414f.m2403a(this.acO, this.acO.getString(C0217R.string.IAP_SAMSUNG_DIALOG_TITLE), this.acO.getString(C0217R.string.IAP_SAMSUNG_UPGRADE_REQUIRED), true, runnableC0427s, true);
                return;
            }
            if (!TextUtils.isEmpty(this.acQ.acm)) {
                C0012k.m40b("IAP-SamsungIABActivity", "GetItemList ERROR: " + this.acQ.acm);
                if (C0463b.m2539qL() != 0) {
                    Toast.makeText(this.acO, this.acQ.acm, 0).show();
                }
            }
        }
        this.acO.m2416u(0, true);
    }

    @Override
    protected final void onPreExecute() {
        super.onPreExecute();
        this.acP = new ArrayList<>();
    }
}
