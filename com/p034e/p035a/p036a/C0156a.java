package com.p034e.p035a.p036a;

import android.text.TextUtils;
import com.facebook.android.Facebook;
import org.json.JSONException;
import org.json.JSONObject;

public final class C0156a {
    public String ahu;
    public String ahv;
    public long ahw;

    public C0156a() {
        this.ahu = "";
        this.ahv = "";
        this.ahw = 0L;
    }

    public C0156a(String str) {
        this.ahu = "";
        this.ahv = "";
        this.ahw = 0L;
        if (str == null || str.indexOf("{") < 0) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.ahu = jSONObject.optString("access_token");
            String optString = jSONObject.optString(Facebook.EXPIRES);
            if (optString != null && !optString.equals("0")) {
                this.ahw = System.currentTimeMillis() + (Long.parseLong(optString) * 1000);
            }
            this.ahv = jSONObject.optString("refresh_token");
        } catch (JSONException e) {
        }
    }

    public C0156a(String str, String str2) {
        this.ahu = "";
        this.ahv = "";
        this.ahw = 0L;
        this.ahu = str;
        this.ahw = System.currentTimeMillis() + (Long.parseLong(str2) * 1000);
    }

    public final String getToken() {
        return this.ahu;
    }

    public final boolean isSessionValid() {
        return !TextUtils.isEmpty(this.ahu) && (this.ahw == 0 || System.currentTimeMillis() < this.ahw);
    }
}
