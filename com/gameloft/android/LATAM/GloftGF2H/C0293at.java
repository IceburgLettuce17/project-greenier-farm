package com.gameloft.android.LATAM.GloftGF2H;

import com.facebook.android.C0217R;

final class C0293at extends Thread {

    private Object[] f618yI;

    C0293at(Object[] objArr) {
        this.f618yI = objArr;
    }

    @Override
    public final void run() {
        int i;
        if (C0338r.f2538tb) {
            i = C0292as.f593yA;
            switch (i) {
                case 1:
                    C0292as.m816dm();
                    break;
                case 2:
                    C0292as.m817dn();
                    break;
                case 3:
                    C0292as.m824y((String) this.f618yI[0], (String) this.f618yI[1]);
                    break;
                case C0217R.styleable.com_facebook_picker_fragment_done_button_text:
                    C0292as.m797a((String) this.f618yI[0], (C0329i) this.f618yI[1]);
                    break;
                case C0217R.styleable.com_facebook_picker_fragment_title_bar_background:
                    C0292as.m818do();
                    break;
            }
            C0292as.m819dp();
        }
    }
}
