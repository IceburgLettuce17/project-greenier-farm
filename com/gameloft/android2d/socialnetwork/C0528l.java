package com.gameloft.android2d.socialnetwork;

import java.io.InputStream;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;
import p009b.p010a.p012b.C0051af;

public class C0528l {
    private String afA;
    public String afB;
    public String afC;
    public String afD;
    public String afE;
    public String afF;
    public String afG;
    private C0051af afH;
    public boolean afI;
    public C0529m[] afJ;
    public int score;

    public C0528l() {
        this.afA = "";
        this.afB = "";
        this.afC = "";
        this.afD = "";
        this.afE = "";
        this.afF = "";
        this.afG = "";
        this.afH = null;
        this.afI = false;
        this.score = 0;
        this.afJ = null;
    }

    public C0528l(String str) {
        this.afA = "";
        this.afB = "";
        this.afC = "";
        this.afD = "";
        this.afE = "";
        this.afF = "";
        this.afG = "";
        this.afH = null;
        this.afI = false;
        this.score = 0;
        this.afJ = null;
        if (C0532p.getType() == 4) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.afF = jSONObject.getString("idstr");
                this.afB = jSONObject.getString("screen_name");
                this.afA = jSONObject.getString("profile_image_url");
                m2778tu();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public final String getId() {
        return this.afF;
    }

    public final String getName() {
        return this.afB;
    }

    public final C0051af m2778tu() {
        C0051af c0051af = null;
        if (C0532p.getType() != 1) {
            if (C0532p.getType() != 4) {
                return null;
            }
            try {
                if (this.afH == null && this.afF != null && this.afF.length() > 0 && !this.afA.equals("")) {
                    this.afH = C0051af.m123h(new URL(this.afA).openStream());
                }
                return this.afH;
            } catch (Exception e) {
                String str = "Weibo: getPhoto error: " + e.toString();
                return null;
            }
        }
        try {
            if (this.afH == null && this.afF != null && this.afF.length() > 0) {
                InputStream m2723cZ = SocialNetwork_Facebook.m2723cZ(this.afF);
                if (m2723cZ != null) {
                    this.afH = C0051af.m120a(m2723cZ, SocialNetwork_Facebook.agi, SocialNetwork_Facebook.agj);
                    m2723cZ.close();
                    String str2 = "Facebook: create ID" + this.afF + " p:" + this.afH;
                } else {
                    SocialNetwork_Facebook.m2722cY(this.afF);
                }
            }
            c0051af = this.afH;
            return c0051af;
        } catch (Exception e2) {
            SocialNetwork_Facebook.m2722cY(this.afF);
            return c0051af;
        }
    }

    public final boolean m2779tv() {
        return this.afI;
    }
}
