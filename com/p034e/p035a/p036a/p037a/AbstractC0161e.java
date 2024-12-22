package com.p034e.p035a.p036a.p037a;

import com.p034e.p035a.p036a.C0156a;
import com.p034e.p035a.p036a.C0182k;
import com.p034e.p035a.p036a.p038b.InterfaceC0169g;
import p001a.p004b.p005a.p006a.C0002a;

public abstract class AbstractC0161e {
    private String accessToken;
    private C0156a ahR;

    public AbstractC0161e(C0156a c0156a) {
        this.ahR = c0156a;
        if (this.ahR != null) {
            this.accessToken = this.ahR.ahu;
        }
    }

    protected final void m289a(String str, C0182k c0182k, String str2, InterfaceC0169g interfaceC0169g) {
        c0182k.m333O("access_token", this.accessToken);
        C0002a.m8a(str, c0182k, str2, interfaceC0169g);
    }
}
