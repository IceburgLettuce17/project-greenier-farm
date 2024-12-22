package com.gameloft.android2d.iap.p042a.p047e;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.gameloft.android2d.iap.C0463b;
import com.p023b.p024a.p025a.AbstractBinderC0144e;
import com.p023b.p024a.p025a.InterfaceC0143d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import p001a.p004b.p005a.p006a.C0012k;

public final class ServiceC0367a extends Service implements ServiceConnection {
    private static InterfaceC0143d aaf;
    private static LinkedList<AbstractC0380b> aag = new LinkedList<>();
    private static HashMap<Long, AbstractC0380b> aah = new HashMap<>();

    static InterfaceC0143d m2290a(InterfaceC0143d interfaceC0143d) {
        aaf = null;
        return null;
    }

    private boolean m2292b(int i, String[] strArr) {
        return new C0382d(this, i, strArr).mo2325rP();
    }

    private void m2293c(int i, String str, String str2) {
        if (System.getProperty("os.name").equals("qnx")) {
            C0012k.m41c("IAP-BillingService", "purchaseStateChanged - Blackberry billing!");
            return;
        }
        ArrayList<C0378ai> m2314C = C0377ah.m2314C(str, str2);
        if (m2314C != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<C0378ai> it = m2314C.iterator();
            while (it.hasNext()) {
                C0378ai next = it.next();
                if (next.abQ != null) {
                    arrayList.add(next.abQ);
                }
                C0375af.m2308a(this, next.abP, next.abR, next.abS, next.abT, next.abU);
            }
            if (arrayList.isEmpty()) {
                return;
            }
            m2292b(i, (String[]) arrayList.toArray(new String[arrayList.size()]));
        }
    }

    public boolean m2294rJ() {
        try {
            C0012k.m41c("IAP-BillingService", "binding to Market billing service");
        } catch (SecurityException e) {
            C0012k.m40b("IAP-BillingService", "Security exception: " + e);
        }
        if (getApplicationContext().bindService(new Intent("com.android.vending.billing.MarketBillingService.BIND"), this, 1)) {
            return true;
        }
        C0012k.m40b("IAP-BillingService", "Could not bind to service.");
        return false;
    }

    public final boolean m2298bY(String str) {
        return new C0381c(this, str).mo2325rP();
    }

    public final boolean m2299f(String str, String str2, String str3) {
        return new C0384f(this, str, str2, str3).mo2325rP();
    }

    @Override
    public final IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        C0012k.m39a("IAP-BillingService", "Billing service connected");
        aaf = AbstractBinderC0144e.m271b(iBinder);
        int i = -1;
        while (true) {
            AbstractC0380b peek = aag.peek();
            if (peek == null) {
                if (i >= 0) {
                    C0012k.m41c("IAP-BillingService", "stopping service, startId: " + i);
                    stopSelf(i);
                    return;
                }
                return;
            }
            if (!peek.mo2326rQ()) {
                m2294rJ();
                return;
            } else {
                aag.remove();
                if (i < peek.mo2324rO()) {
                    i = peek.mo2324rO();
                }
            }
        }
    }

    @Override
    public final void onServiceDisconnected(ComponentName componentName) {
        C0012k.m42d("IAP-BillingService", "Billing service disconnected");
        aaf = null;
    }

    @Override
    public final void onStart(Intent intent, int i) {
        if (intent != null) {
            String action = intent.getAction();
            C0012k.m41c("IAP-BillingService", "handleCommand() action: " + action);
            if ("iap.CONFIRM_NOTIFICATION".equals(action)) {
                m2292b(i, intent.getStringArrayExtra("notification_id"));
                return;
            }
            if ("iap.GET_PURCHASE_INFORMATION".equals(action)) {
                new C0383e(this, i, new String[]{intent.getStringExtra("notification_id")}).mo2325rP();
                return;
            }
            if ("com.android.vending.billing.PURCHASE_STATE_CHANGED".equals(action)) {
                m2293c(i, intent.getStringExtra("inapp_signed_data"), intent.getStringExtra("inapp_signature"));
                return;
            }
            if ("com.android.vending.billing.RESPONSE_CODE".equals(action)) {
                long longExtra = intent.getLongExtra("request_id", -1L);
                int intExtra = intent.getIntExtra("response_code", EnumC0387i.RESULT_ERROR.ordinal());
                C0463b.m2521eV(intExtra);
                EnumC0387i m2329eX = EnumC0387i.m2329eX(intExtra);
                AbstractC0380b abstractC0380b = aah.get(Long.valueOf(longExtra));
                if (abstractC0380b != null) {
                    C0012k.m39a("IAP-BillingService", abstractC0380b.getClass().getSimpleName() + ": " + m2329eX);
                    abstractC0380b.mo2322b(m2329eX);
                }
                aah.remove(Long.valueOf(longExtra));
            }
        }
    }

    @Deprecated
    public final boolean m2300rK() {
        return new C0381c(this).mo2325rP();
    }

    public final void setContext(Context context) {
        attachBaseContext(context);
    }
}
