package com.gameloft.android2d.iap.p042a.p053j;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import com.gameloft.android2d.iap.C0463b;
import com.gameloft.android2d.iap.InterfaceC0357a;
import com.gameloft.android2d.iap.p042a.p051h.C0414f;
import com.gameloft.android2d.iap.utils.C0488o;
import p001a.p004b.p005a.p006a.C0012k;

final class C0445e extends BroadcastReceiver {
    C0445e(C0441a c0441a) {
    }

    private int m2457ct(String str) {
        String[] split = str.replace('.', ' ').replace(':', ' ').split(" ");
        int i = -1;
        for (int i2 = 0; i2 < split.length; i2++) {
            int m2458cu = m2458cu(split[i2]);
            if (m2458cu != -1 && split[i2].length() == 5) {
                i = m2458cu;
            }
        }
        return i;
    }

    private static int m2458cu(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    @Override
    public final void onReceive(Context context, Intent intent) {
        Bundle extras;
        try {
            C0012k.m41c("IAP-SMSBilling", "SMSReceiver: onReceive()");
            if (C0488o.getContext() == null) {
                C0488o.setContext(context);
            }
            if (!C0414f.m2370cA() || C0414f.m2393sg() || (extras = intent.getExtras()) == null) {
                return;
            }
            Object[] objArr = (Object[]) extras.get("pdus");
            SmsMessage[] smsMessageArr = new SmsMessage[objArr.length];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= smsMessageArr.length) {
                    return;
                }
                smsMessageArr[i2] = SmsMessage.createFromPdu((byte[]) objArr[i2]);
                C0012k.m41c("IAP-SMSBilling", "ServiceCenterAddress: " + smsMessageArr[i2].getServiceCenterAddress());
                int m2457ct = m2457ct(smsMessageArr[i2].getMessageBody());
                if (m2457ct != -1 && C0463b.m2498aT(m2457ct)) {
                    C0414f.m2379cn(new StringBuilder().append(C0463b.m2554qz()).toString());
                    C0414f.m2387r(InterfaceC0357a.f2724wS[5], "1");
                    C0443c.stop();
                    try {
                        C0488o.getContext().unregisterReceiver(this);
                        C0012k.m41c("IAP-SMSBilling", "SMSResponseReceiver:SMSResponseReceiver Unregistered");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                i = i2 + 1;
            }
        } catch (Exception e2) {
        }
    }
}
