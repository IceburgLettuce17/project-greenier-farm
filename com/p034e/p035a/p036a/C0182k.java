package com.p034e.p035a.p036a;

import android.text.TextUtils;
import java.util.ArrayList;

public final class C0182k {
    public ArrayList<String> ahP = new ArrayList<>();
    public ArrayList<String> ahQ = new ArrayList<>();

    public final void m333O(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.ahP.add(str);
        this.ahQ.add(str2);
    }

    public final void m334b(String str, long j) {
        this.ahP.add(str);
        this.ahQ.add(String.valueOf(j));
    }

    public final String m335fi(int i) {
        return (i < 0 || i >= this.ahP.size()) ? "" : this.ahP.get(i);
    }

    public final String getValue(String str) {
        int indexOf = this.ahP.contains(str) ? this.ahP.indexOf(str) : -1;
        if (indexOf < 0 || indexOf >= this.ahP.size()) {
            return null;
        }
        return this.ahQ.get(indexOf);
    }

    public final void m336l(String str, int i) {
        this.ahP.add(str);
        this.ahQ.add(String.valueOf(i));
    }
}
