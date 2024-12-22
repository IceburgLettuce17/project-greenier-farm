package com.p034e.p035a.p036a.p037a;

import com.p034e.p035a.p036a.C0156a;
import com.p034e.p035a.p036a.C0182k;
import com.p034e.p035a.p036a.p038b.InterfaceC0169g;

public final class C0158b extends AbstractC0161e {
    public C0158b(C0156a c0156a) {
        super(c0156a);
    }

    public final void m285a(long j, int i, int i2, boolean z, InterfaceC0169g interfaceC0169g) {
        C0182k c0182k = new C0182k();
        c0182k.m334b("uid", j);
        c0182k.m336l("count", 50);
        c0182k.m336l("cursor", 0);
        c0182k.m336l("trim_status", 1);
        m289a("https://api.weibo.com/2/friendships/friends.json", c0182k, "GET", interfaceC0169g);
    }
}
