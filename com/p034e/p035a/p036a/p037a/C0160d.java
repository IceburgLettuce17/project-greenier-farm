package com.p034e.p035a.p036a.p037a;

import com.p034e.p035a.p036a.C0156a;
import com.p034e.p035a.p036a.C0182k;
import com.p034e.p035a.p036a.p038b.InterfaceC0169g;

public final class C0160d extends AbstractC0161e {
    public C0160d(C0156a c0156a) {
        super(c0156a);
    }

    public final void m288a(long j, InterfaceC0169g interfaceC0169g) {
        C0182k c0182k = new C0182k();
        c0182k.m334b("uid", j);
        m289a("https://api.weibo.com/2/users/show.json", c0182k, "GET", interfaceC0169g);
    }
}
