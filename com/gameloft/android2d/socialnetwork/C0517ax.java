package com.gameloft.android2d.socialnetwork;

import com.p034e.p035a.p036a.C0181j;
import com.p034e.p035a.p036a.p038b.InterfaceC0169g;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class C0517ax implements InterfaceC0169g {
    C0517ax() {
    }

    @Override
    public final void mo307b(C0181j c0181j) {
        String str = "Weibo : UpdateFriendList Error : " + c0181j;
    }

    @Override
    public final void mo308da(String str) {
        C0528l[] c0528lArr;
        try {
            JSONArray jSONArray = new JSONArray(new JSONObject(str).getString("users"));
            int length = jSONArray.length();
            if (length > 0) {
                C0528l[] unused = C0511ar.ahi = new C0528l[length];
                for (int i = 0; i < length; i++) {
                    c0528lArr = C0511ar.ahi;
                    c0528lArr[i] = new C0528l(jSONArray.getJSONObject(i).toString());
                }
            }
            C0511ar.m2769o(true);
        } catch (JSONException e) {
            String str2 = "Weibo : UpdateFriendList Error : " + e.toString();
        }
    }
}
