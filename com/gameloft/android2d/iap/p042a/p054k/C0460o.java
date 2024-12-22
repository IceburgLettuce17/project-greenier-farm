package com.gameloft.android2d.iap.p042a.p054k;

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

final class C0460o extends BroadcastReceiver {
    C0460o(C0446a c0446a) {
    }

    private int m2490ct(String str) {
        String[] split = str.replace('.', ' ').split(" ");
        int i = -1;
        for (int i2 = 0; i2 < split.length; i2++) {
            int m2491cu = m2491cu(split[i2]);
            if (m2491cu != -1 && split[i2].length() == 5) {
                i = m2491cu;
            }
        }
        return i;
    }

    private static int m2491cu(String str) {
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
            C0012k.m41c("IAP-UMPBilling", "SMSReceiver: onReceive()");
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
                C0012k.m41c("IAP-UMPBilling", "ServiceCenterAddress: " + smsMessageArr[i2].getServiceCenterAddress());
                int m2490ct = m2490ct(smsMessageArr[i2].getMessageBody());
                if (m2490ct != -1 && C0463b.m2498aT(m2490ct)) {
                    C0414f.m2387r(InterfaceC0357a.f2724wS[5], "1");
                    C0457l.stop();
                    try {
                        C0488o.getContext().unregisterReceiver(this);
                        C0012k.m41c("IAP-UMPBilling", "SMSResponseReceiver:SMSResponseReceiver Unregistered");
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
