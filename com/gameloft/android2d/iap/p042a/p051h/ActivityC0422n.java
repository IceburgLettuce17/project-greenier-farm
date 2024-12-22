package com.gameloft.android2d.iap.p042a.p051h;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import com.facebook.android.C0217R;
import com.gameloft.android2d.iap.C0463b;
import com.gameloft.android2d.iap.InterfaceC0357a;
import com.gameloft.android2d.iap.utils.C0488o;
import java.util.concurrent.RejectedExecutionException;
import p001a.p004b.p005a.p006a.C0012k;

public class ActivityC0422n extends Activity implements InterfaceC0357a {
    private C0414f acJ = null;
    private ProgressDialog acK = null;
    private AsyncTaskC0426r acL = null;
    private AsyncTaskC0428t acM = null;
    private AsyncTaskC0430v acN = null;
    private static boolean acG = false;
    public static boolean acH = false;
    private static String aco = null;
    private static String acI = null;

    public static void m2407a(ProgressDialog progressDialog) {
        if (progressDialog != null) {
            try {
                if (progressDialog.isShowing()) {
                    progressDialog.dismiss();
                }
            } catch (Exception e) {
                C0012k.m40b("IAP-SamsungIABActivity", "Exception: " + e.getMessage());
            }
        }
    }

    static void m2408a(ActivityC0422n activityC0422n) {
        C0012k.m41c("IAP-SamsungIABActivity", "[GetItemListTask]");
        try {
            if (activityC0422n.acL != null && activityC0422n.acL.getStatus() != AsyncTask.Status.FINISHED) {
                activityC0422n.acL.cancel(true);
            }
            activityC0422n.acL = new AsyncTaskC0426r(activityC0422n, activityC0422n);
            activityC0422n.acL.execute(new String[0]);
        } catch (RejectedExecutionException e) {
            C0012k.m40b("IAP-SamsungIABActivity", "RejectedExecutionException: " + e.toString());
            activityC0422n.m2416u(0, true);
        } catch (Exception e2) {
            C0012k.m40b("IAP-SamsungIABActivity", "Exception: " + e2.toString());
            activityC0422n.m2416u(0, true);
        }
    }

    public static void m2409a(String str, String str2, C0412d c0412d) {
        C0012k.m41c("IAP-SamsungIABActivity", "[LaunchSamsungBilling] _groupId =" + str);
        acI = str;
        aco = str2;
        acG = false;
        acH = false;
        Intent intent = new Intent(C0488o.getContext(), (Class<?>) ActivityC0422n.class);
        intent.putExtra("ItemId", str2);
        intent.putExtra("ItemGroupId", str);
        C0488o.getContext().startActivity(intent);
        C0012k.m41c("IAP-SamsungIABActivity", "[LaunchSamsungBilling] END 0000000000000000000000000");
    }

    static void m2413d(ActivityC0422n activityC0422n) {
        C0012k.m41c("IAP-SamsungIABActivity", "[PurchaseItemTask]");
        try {
            if (activityC0422n.acM != null && activityC0422n.acM.getStatus() != AsyncTask.Status.FINISHED) {
                activityC0422n.acM.cancel(true);
            }
            activityC0422n.acM = new AsyncTaskC0428t(activityC0422n, (byte) 0);
            activityC0422n.acM.execute(new String[0]);
        } catch (RejectedExecutionException e) {
            C0012k.m40b("IAP-SamsungIABActivity", "RejectedExecutionException: " + e.toString());
            activityC0422n.m2416u(0, true);
        } catch (Exception e2) {
            C0012k.m40b("IAP-SamsungIABActivity", "Exception: " + e2.toString());
            activityC0422n.m2416u(0, true);
        }
    }

    @Override
    protected void onActivityResult(int i, int i2, Intent intent) {
        String str;
        String str2;
        int i3;
        C0012k.m41c("IAP-SamsungIABActivity", "[onActivityResutl]");
        switch (i) {
            case 1:
                if (intent != null) {
                    Bundle extras = intent.getExtras();
                    String str3 = "";
                    C0411c c0411c = null;
                    if (extras != null) {
                        str2 = extras.getString("THIRD_PARTY_NAME");
                        i3 = extras.getInt("STATUS_CODE");
                        str3 = extras.getString("ERROR_STRING");
                        str = extras.getString("ITEM_ID");
                        c0411c = new C0411c(extras.getString("RESULT_OBJECT"));
                    } else {
                        C0012k.m40b("IAP-SamsungIABActivity", "The payment was not processed successfully");
                        str = "";
                        str2 = "";
                        i3 = 1;
                    }
                    if (-1 != i2) {
                        if (i2 == 0) {
                            C0012k.m42d("IAP-SamsungIABActivity", "@@@ Payment Cancelled, StatusCode: [" + i3 + "] Message: " + str3);
                            m2416u(0, true);
                            break;
                        }
                    } else if (i3 != 0) {
                        if (i3 != -1003) {
                            C0012k.m40b("IAP-SamsungIABActivity", "Payment error: \n-itemId : " + str + "\n-thirdPartyName : " + str2 + "\n-statusCode : " + i3 + "\n-errorString : " + str3);
                            m2416u(2, true);
                            break;
                        } else {
                            m2407a(this.acK);
                            acH = true;
                            this.acJ.m2403a(this, getString(C0217R.string.IAP_SAMSUNG_DIALOG_TITLE), getString(C0217R.string.IAP_SAMSUNG_ERROR_ALREADY_PURCHASED), false, new RunnableC0423o(this), false);
                            break;
                        }
                    } else {
                        C0012k.m41c("IAP-SamsungIABActivity", "##### [VerifyClientToServerTask] #####");
                        try {
                            if (this.acN != null && this.acN.getStatus() != AsyncTask.Status.FINISHED) {
                                this.acN.cancel(true);
                            }
                            this.acN = new AsyncTaskC0430v(this, c0411c);
                            this.acN.execute(new Void[0]);
                            break;
                        } catch (RejectedExecutionException e) {
                            C0012k.m40b("IAP-SamsungIABActivity", "RejectedExecutionException: " + e.toString());
                            m2416u(0, true);
                            return;
                        } catch (Exception e2) {
                            C0012k.m40b("IAP-SamsungIABActivity", "Exception: " + e2.toString());
                            m2416u(0, true);
                            return;
                        }
                    }
                }
                break;
            case 2:
                if (-1 != i2) {
                    if (i2 == 0) {
                        C0012k.m40b("IAP-SamsungIABActivity", "SamsungAccount authentication error");
                        m2416u(0, true);
                        break;
                    }
                } else if (C0463b.m2539qL() == 0) {
                    m2415so();
                    break;
                } else {
                    C0012k.m41c("IAP-SamsungIABActivity", "***************************[InitGetItemListService]******************************");
                    if (C0463b.m2539qL() != 0) {
                        this.acJ.acA = C0463b.m2539qL();
                    }
                    this.acJ.m2404a(new C0424p(this));
                    break;
                }
                break;
        }
    }

    @Override
    protected void onCreate(Bundle bundle) {
        C0012k.m41c("IAP-SamsungIABActivity", "[onCreate]");
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            aco = extras.getString("ItemId");
            C0012k.m39a("IAP-SamsungIABActivity", "ItemId: " + aco);
            acI = extras.getString("ItemGroupId");
            C0012k.m39a("IAP-SamsungIABActivity", "ItemGroupId: " + acI);
        }
        this.acJ = new C0414f(this);
        C0414f c0414f = this.acJ;
        if (!C0414f.m2385j(this)) {
            C0414f c0414f2 = this.acJ;
            C0012k.m41c("SamsungIAB", "[installIapPackage]");
            c0414f2.m2403a(this, getString(C0217R.string.IAP_SAMSUNG_DIALOG_TITLE), getString(C0217R.string.IAP_SAMSUNG_CLIENT_NOT_INSTALLED), true, new RunnableC0415g(c0414f2, this), true);
            return;
        }
        C0414f c0414f3 = this.acJ;
        if (!C0414f.m2386k(this)) {
            C0012k.m40b("IAP-SamsungIABActivity", "IAP Application installed in your device is not valid!!");
            m2416u(0, true);
            return;
        }
        this.acK = ProgressDialog.show(this, "", getString(C0217R.string.IAP_SAMSUNG_WAITING), true);
        C0414f c0414f4 = this.acJ;
        C0012k.m41c("SamsungIAB", "[startAccountActivity]");
        ComponentName componentName = new ComponentName("com.sec.android.iap", "com.sec.android.iap.activity.AccountActivity");
        Intent intent = new Intent();
        intent.setComponent(componentName);
        startActivityForResult(intent, 2);
    }

    @Override
    protected void onDestroy() {
        C0012k.m41c("IAP-SamsungIABActivity", "[onDestroy]");
        super.onDestroy();
        if (this.acJ != null) {
            C0414f c0414f = this.acJ;
            if (c0414f.aaT != null) {
                if (c0414f.mContext != null) {
                    c0414f.mContext.unbindService(c0414f.aaT);
                }
                c0414f.aaT = null;
                c0414f.acy = null;
            }
        }
        if (this.acM != null && this.acM.getStatus() != AsyncTask.Status.FINISHED) {
            this.acM.cancel(true);
        }
        if (this.acL != null && this.acL.getStatus() != AsyncTask.Status.FINISHED) {
            this.acL.cancel(true);
        }
        if (this.acN == null || this.acN.getStatus() == AsyncTask.Status.FINISHED) {
            return;
        }
        this.acN.cancel(true);
    }

    public final void m2415so() {
        C0012k.m41c("IAP-SamsungIABActivity", "##################[InitPurchaseService]######################");
        if (C0463b.m2539qL() != 0) {
            this.acJ.acA = C0463b.m2539qL();
        }
        this.acJ.m2404a(new C0425q(this));
    }

    public final void m2416u(int i, boolean z) {
        C0012k.m41c("IAP-SamsungIABActivity", "[ResultCallBack]");
        C0412d.m2363eZ(i);
        m2407a(this.acK);
        if (z) {
            try {
                finish();
            } catch (Exception e) {
                C0012k.m40b("IAP-SamsungIABActivity", "Exception: " + e.getMessage());
            }
        }
    }
}
