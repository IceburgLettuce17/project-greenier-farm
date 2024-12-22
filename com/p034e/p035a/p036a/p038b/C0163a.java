package com.p034e.p035a.p036a.p038b;

import com.p034e.p035a.p036a.C0181j;
import com.p034e.p035a.p036a.C0182k;

public final class C0163a extends Thread {
    private final String ahS;
    private final C0182k ahT;
    private final InterfaceC0169g ahU;
    private final String val$httpMethod;

    public C0163a(String str, String str2, C0182k c0182k, InterfaceC0169g interfaceC0169g) {
        this.ahS = str;
        this.val$httpMethod = str2;
        this.ahT = c0182k;
        this.ahU = interfaceC0169g;
    }

    @Override
    public final void run() {
        try {
            this.ahU.mo308da(C0164b.m301a(this.ahS, this.val$httpMethod, this.ahT, this.ahT.getValue("pic")));
        } catch (C0181j e) {
            this.ahU.mo307b(e);
        }
    }
}
