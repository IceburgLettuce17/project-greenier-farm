package com.gameloft.android2d.socialnetwork;

import com.p034e.p035a.p036a.C0181j;
import com.p034e.p035a.p036a.p038b.InterfaceC0169g;
import org.json.JSONException;
import org.json.JSONObject;

final class C0513at implements InterfaceC0169g {
    C0513at() {
    }

    @Override
    public final void mo307b(C0181j c0181j) {
        String str = "Weibo : GetUserID Error : " + c0181j;
    }

    @Override
    public final void mo308da(String str) {
        try {
            long unused = C0511ar.ahk = Long.parseLong(new JSONObject(str).getString("uid"));
        } catch (JSONException e) {
            String str2 = "Weibo : GetUserID error : " + e.toString();
        }
    }
}
