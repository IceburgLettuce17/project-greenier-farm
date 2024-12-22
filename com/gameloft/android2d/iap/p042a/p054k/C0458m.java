package com.gameloft.android2d.iap.p042a.p054k;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.facebook.android.C0217R;
import com.gameloft.android2d.iap.C0463b;
import com.gameloft.android2d.iap.utils.C0488o;
import p001a.p004b.p005a.p006a.C0012k;

final class C0458m extends BroadcastReceiver {
    final C0446a adF;

    C0458m(C0446a c0446a) {
        this.adF = c0446a;
    }

    @Override
    public final void onReceive(Context context, Intent intent) {
        switch (getResultCode()) {
            case -1:
                C0012k.m41c("IAP-UMPBilling", "SMS Sent Pending Intent: RESULT OK");
                if (!intent.getAction().equals("MO1_SENT")) {
                    if (intent.getAction().equals("MO2_SENT")) {
                        this.adF.m2488fc(0);
                        break;
                    }
                } else {
                    this.adF.f2777YF.runOnUiThread(new C0459n(this));
                    break;
                }
                break;
            case 1:
            case 2:
            case 3:
            case C0217R.styleable.com_facebook_picker_fragment_done_button_text:
                C0012k.m40b("IAP-UMPBilling", "SMS Sent Pending Intent: ERROR " + getResultCode());
                C0463b.setResult(3);
                C0463b.m2521eV(-1);
                break;
        }
        C0488o.getContext().unregisterReceiver(this);
    }
}
