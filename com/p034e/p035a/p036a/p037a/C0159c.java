package com.p034e.p035a.p036a.p037a;

import android.text.TextUtils;
import com.p034e.p035a.p036a.C0156a;
import com.p034e.p035a.p036a.C0182k;
import com.p034e.p035a.p036a.p038b.InterfaceC0169g;

public final class C0159c extends AbstractC0161e {
    public C0159c(C0156a c0156a) {
        super(c0156a);
    }

    public final void m286a(String str, String str2, String str3, InterfaceC0169g interfaceC0169g) {
        C0182k c0182k = new C0182k();
        c0182k.m333O("status", str);
        if (!TextUtils.isEmpty(str3)) {
            c0182k.m333O("long", str3);
        }
        if (!TextUtils.isEmpty(str2)) {
            c0182k.m333O("lat", str2);
        }
        m289a("https://api.weibo.com/2/statuses/update.json", c0182k, "POST", interfaceC0169g);
    }

    public final void m287a(String str, String str2, String str3, String str4, InterfaceC0169g interfaceC0169g) {
        C0182k c0182k = new C0182k();
        c0182k.m333O("status", str);
        c0182k.m333O("pic", str2);
        if (!TextUtils.isEmpty(str4)) {
            c0182k.m333O("long", str4);
        }
        if (!TextUtils.isEmpty(str3)) {
            c0182k.m333O("lat", str3);
        }
        m289a("https://api.weibo.com/2/statuses/upload.json", c0182k, "POST", interfaceC0169g);
    }
}
