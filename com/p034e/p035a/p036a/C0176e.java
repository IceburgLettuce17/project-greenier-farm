package com.p034e.p035a.p036a;

import com.facebook.widget.PlacePickerFragment;
import com.p029d.p031b.p032a.p033a.C0155a;
import com.p034e.p035a.p036a.p038b.InterfaceC0169g;
import com.p034e.p035a.p036a.p040d.C0175b;

final class C0176e implements InterfaceC0169g {
    private C0162b ahE;

    C0176e(C0162b c0162b) {
        this.ahE = c0162b;
    }

    @Override
    public final void mo307b(C0181j c0181j) {
        C0162b.m291a(this.ahE, 1001, C0175b.m324de(c0181j.getMessage()), null);
    }

    @Override
    public final void mo308da(String str) {
        C0156a c0156a;
        C0156a c0156a2;
        C0156a c0156a3;
        C0156a c0156a4;
        C0156a c0156a5;
        C0156a c0156a6;
        c0156a = this.ahE.ahj;
        if (c0156a == null) {
            this.ahE.ahj = new C0156a(str);
        }
        c0156a2 = this.ahE.ahj;
        if (!c0156a2.isSessionValid()) {
            C0155a.m282M("Weibo-authorize", "Failed to receive access token");
            C0162b.m291a(this.ahE, 1001, null, null);
            return;
        }
        StringBuilder sb = new StringBuilder("Login Success! access_token=");
        c0156a3 = this.ahE.ahj;
        StringBuilder append = sb.append(c0156a3.ahu).append(" expires=");
        c0156a4 = this.ahE.ahj;
        StringBuilder append2 = append.append(c0156a4.ahw).append(" refresh_token=");
        c0156a5 = this.ahE.ahj;
        C0155a.m282M("Weibo-authorize", append2.append(c0156a5.ahv).toString());
        c0156a6 = this.ahE.ahj;
        C0162b.m291a(this.ahE, PlacePickerFragment.DEFAULT_RADIUS_IN_METERS, C0175b.m322b(c0156a6), null);
    }
}
