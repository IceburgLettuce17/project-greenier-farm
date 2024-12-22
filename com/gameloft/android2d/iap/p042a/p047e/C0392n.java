package com.gameloft.android2d.iap.p042a.p047e;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.text.TextUtils;
import com.p023b.p024a.p025a.InterfaceC0140a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import p001a.p004b.p005a.p006a.C0012k;

public final class C0392n {
    boolean aaM = false;
    private String aaN = "IabHelper";
    boolean aaO = false;
    boolean aaP = false;
    private boolean aaQ = false;
    private String aaR = "";
    InterfaceC0140a aaS;
    ServiceConnection aaT;
    private int aaU;
    private String aaV;
    private String aaW;
    C0400v aaX;
    Context mContext;

    public C0392n(Context context, String str) {
        this.aaW = null;
        this.mContext = context.getApplicationContext();
        this.aaW = str;
        m2351cd("IAB helper created.");
    }

    private int m2340a(C0404z c0404z, String str) {
        boolean z;
        m2351cd("Querying owned items, item type: " + str);
        m2351cd("Package name: " + this.mContext.getPackageName());
        String str2 = null;
        boolean z2 = false;
        while (true) {
            m2351cd("Calling getPurchases with continuation token: " + str2);
            try {
                Bundle mo266a = this.aaS.mo266a(3, this.mContext.getPackageName(), str, str2);
                int m2345i = m2345i(mo266a);
                m2351cd("Owned items response: " + String.valueOf(m2345i));
                if (m2345i != 0) {
                    m2351cd("getPurchases() failed: " + m2344eY(m2345i));
                    return m2345i;
                }
                if (!mo266a.containsKey("INAPP_PURCHASE_ITEM_LIST") || !mo266a.containsKey("INAPP_PURCHASE_DATA_LIST") || !mo266a.containsKey("INAPP_DATA_SIGNATURE_LIST")) {
                    break;
                }
                ArrayList<String> stringArrayList = mo266a.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                ArrayList<String> stringArrayList2 = mo266a.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                ArrayList<String> stringArrayList3 = mo266a.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                int i = 0;
                boolean z3 = z2;
                while (i < stringArrayList2.size()) {
                    String str3 = stringArrayList2.get(i);
                    String str4 = stringArrayList3.get(i);
                    String str5 = stringArrayList.get(i);
                    if (C0377ah.m2317g(this.aaW, str3, str4)) {
                        m2351cd("Sku is owned: " + str5);
                        C0370aa c0370aa = new C0370aa(str, str3, str4);
                        if (TextUtils.isEmpty(c0370aa.abv)) {
                            m2343cf("BUG: empty/null token!");
                            m2351cd("Purchase data: " + str3);
                        }
                        c0404z.abq.put(c0370aa.abt, c0370aa);
                        z = z3;
                    } else {
                        m2343cf("Purchase signature verification **FAILED**. Not adding item.");
                        m2351cd("   Purchase data: " + str3);
                        m2351cd("   Signature: " + str4);
                        z = true;
                    }
                    i++;
                    z3 = z;
                }
                String string = mo266a.getString("INAPP_CONTINUATION_TOKEN");
                m2351cd("Continuation token: " + string);
                if (TextUtils.isEmpty(string)) {
                    return z3 ? -1003 : 0;
                }
                str2 = string;
                z2 = z3;
            } catch (Exception e) {
                m2351cd("There is a exception in queryPurchases(): " + e.toString());
                return 9;
            }
        }
    }

    private int m2341a(String str, C0404z c0404z, List<String> list) {
        m2351cd("Querying SKU details.");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.addAll(c0404z.m2359cg(str));
        if (list != null) {
            arrayList.addAll(list);
        }
        if (arrayList.size() == 0) {
            m2351cd("queryPrices: nothing to do because there are no SKUs.");
            return 0;
        }
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("ITEM_ID_LIST", arrayList);
        Bundle mo265a = this.aaS.mo265a(3, this.mContext.getPackageName(), str, bundle);
        if (mo265a.containsKey("DETAILS_LIST")) {
            Iterator<String> it = mo265a.getStringArrayList("DETAILS_LIST").iterator();
            while (it.hasNext()) {
                C0379aj c0379aj = new C0379aj(str, it.next());
                m2351cd("Got sku details: " + c0379aj);
                c0404z.abp.put(c0379aj.abt, c0379aj);
            }
            return 0;
        }
        int m2345i = m2345i(mo265a);
        if (m2345i != 0) {
            m2351cd("getSkuDetails() failed: " + m2344eY(m2345i));
            return m2345i;
        }
        m2352ce("getSkuDetails() returned a bundle with neither an error nor a detail list.");
        return -1002;
    }

    private void m2342cc(String str) {
        if (this.aaQ) {
            throw new IllegalStateException("Can't start async operation (" + str + ") because another async operation(" + this.aaR + ") is in progress.");
        }
        this.aaR = str;
        this.aaQ = true;
        m2351cd("Starting async operation: " + str);
    }

    private void m2343cf(String str) {
        C0012k.m42d(this.aaN, "In-app billing warning: " + str);
    }

    public static String m2344eY(int i) {
        String[] split = "0:OK/1:User Canceled/2:Unknown/3:Billing Unavailable/4:Item unavailable/5:Developer Error/6:Error/7:Item Already Owned/8:Item not owned".split("/");
        String[] split2 = "0:OK/-1001:Remote exception during initialization/-1002:Bad response received/-1003:Purchase signature verification failed/-1004:Send intent failed/-1005:User cancelled/-1006:Unknown purchase response/-1007:Missing token/-1008:Unknown error/-1009:Subscriptions not available/-1010:Invalid consumption attempt".split("/");
        if (i > -1000) {
            return (i < 0 || i >= split.length) ? String.valueOf(i) + ":Unknown" : split[i];
        }
        int i2 = (-1000) - i;
        return (i2 < 0 || i2 >= split2.length) ? String.valueOf(i) + ":Unknown IAB Helper Error" : split2[i2];
    }

    private int m2345i(Bundle bundle) {
        Object obj = bundle.get("RESPONSE_CODE");
        if (obj == null) {
            m2351cd("Bundle with null response code, assuming OK (known issue)");
            return 0;
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (obj instanceof Long) {
            return (int) ((Long) obj).longValue();
        }
        m2352ce("Unexpected type for bundle response code.");
        m2352ce(obj.getClass().getName());
        throw new RuntimeException("Unexpected type for bundle response code: " + obj.getClass().getName());
    }

    public final C0404z m2346a(boolean z, List<String> list) {
        int m2341a;
        int m2341a2;
        m2350cb("queryInventory");
        try {
            C0404z c0404z = new C0404z();
            int m2340a = m2340a(c0404z, "inapp");
            if (m2340a != 0) {
                throw new C0391m(m2340a, "Error refreshing inventory (querying owned items).");
            }
            if (z && (m2341a2 = m2341a("inapp", c0404z, list)) != 0) {
                throw new C0391m(m2341a2, "Error refreshing inventory (querying prices of items).");
            }
            if (this.aaP) {
                int m2340a2 = m2340a(c0404z, "subs");
                if (m2340a2 != 0) {
                    throw new C0391m(m2340a2, "Error refreshing inventory (querying owned subscriptions).");
                }
                if (z && (m2341a = m2341a("subs", c0404z, list)) != 0) {
                    throw new C0391m(m2341a, "Error refreshing inventory (querying prices of subscriptions).");
                }
            }
            return c0404z;
        } catch (RemoteException e) {
            throw new C0391m(-1001, "Remote exception while refreshing inventory.", e);
        } catch (JSONException e2) {
            throw new C0391m(-1002, "Error parsing JSON response while refreshing inventory.", e2);
        }
    }

    public final void m2347a(Activity activity, String str, String str2, int i, C0400v c0400v, String str3) {
        m2350cb("launchPurchaseFlow");
        m2342cc("launchPurchaseFlow");
        if (str2.equals("subs") && !this.aaP) {
            C0403y c0403y = new C0403y(-1009, "Subscriptions are not available.");
            if (c0400v != null) {
                c0400v.m2355a(c0403y, null, -1);
                return;
            }
            return;
        }
        try {
            m2351cd("Constructing buy intent for " + str + ", item type: " + str2);
            Bundle mo267a = this.aaS.mo267a(3, this.mContext.getPackageName(), str, str2, str3);
            int m2345i = m2345i(mo267a);
            if (m2345i != 0) {
                m2352ce("Unable to buy item, Error response: " + m2344eY(m2345i));
                C0403y c0403y2 = new C0403y(m2345i, "Unable to buy item");
                if (c0400v != null) {
                    c0400v.m2355a(c0403y2, null, m2345i);
                }
            } else {
                PendingIntent pendingIntent = (PendingIntent) mo267a.getParcelable("BUY_INTENT");
                m2351cd("Launching buy intent for " + str + ". Request code: " + i);
                this.aaU = i;
                this.aaX = c0400v;
                this.aaV = str2;
                IntentSender intentSender = pendingIntent.getIntentSender();
                Intent intent = new Intent();
                Integer num = 0;
                int intValue = num.intValue();
                Integer num2 = 0;
                int intValue2 = num2.intValue();
                Integer num3 = 0;
                activity.startIntentSenderForResult(intentSender, i, intent, intValue, intValue2, num3.intValue());
            }
        } catch (IntentSender.SendIntentException e) {
            m2352ce("SendIntentException while launching purchase flow for sku " + str);
            e.printStackTrace();
            C0403y c0403y3 = new C0403y(-1004, "Failed to send intent.");
            if (c0400v != null) {
                c0400v.m2355a(c0403y3, null, -1);
            }
        } catch (RemoteException e2) {
            m2352ce("RemoteException while launching purchase flow for sku " + str);
            e2.printStackTrace();
            C0403y c0403y4 = new C0403y(-1001, "Remote exception while starting purchase flow");
            if (c0400v != null) {
                c0400v.m2355a(c0403y4, null, -1);
            }
        }
    }

    public final void m2348a(C0370aa c0370aa, C0399u c0399u) {
        m2350cb("consume");
        ArrayList arrayList = new ArrayList();
        arrayList.add(c0370aa);
        Handler handler = new Handler();
        m2342cc("consume");
        new Thread(new RunnableC0396r(this, arrayList, c0399u, handler, null)).start();
    }

    public final void m2349a(C0402x c0402x) {
        Handler handler = new Handler();
        m2350cb("queryInventory");
        m2342cc("refresh inventory");
        new Thread(new RunnableC0394p(this, true, null, handler, c0402x)).start();
    }

    final void m2350cb(String str) {
        if (this.aaO) {
            return;
        }
        m2352ce("Illegal state for operation (" + str + "): IAB helper is not set up.");
        throw new IllegalStateException("IAB helper is not set up. Can't perform operation: " + str);
    }

    final void m2351cd(String str) {
        if (this.aaM) {
            C0012k.m39a(this.aaN, str);
        }
    }

    final void m2352ce(String str) {
        C0012k.m40b(this.aaN, "In-app billing error: " + str);
    }

    final void m2353rW() {
        m2351cd("Ending async operation: " + this.aaR);
        this.aaR = "";
        this.aaQ = false;
    }
}
