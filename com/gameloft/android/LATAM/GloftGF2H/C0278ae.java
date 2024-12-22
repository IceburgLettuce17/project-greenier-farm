package com.gameloft.android.LATAM.GloftGF2H;

import java.util.Vector;

public final class C0278ae {

    Vector f499vP;

    public C0278ae() {
        this.f499vP = new Vector();
    }

    public C0278ae(com.gameloft.android.LATAM.GloftGF2H.C0283aj r4) {
        throw new UnsupportedOperationException("Method not decompiled: com.gameloft.android.LATAM.GloftGF2H.C0278ae.<init>(com.gameloft.android.LATAM.GloftGF2H.aj):void");
    }

    private String join(String str) {
        int size = this.f499vP.size();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                stringBuffer.append(str);
            }
            stringBuffer.append(C0280ag.m686c(this.f499vP.elementAt(i)));
        }
        return stringBuffer.toString();
    }

    public final C0278ae m684a(Object obj) {
        this.f499vP.addElement(obj);
        return this;
    }

    public final Object get(int i) {
        Object elementAt = (i < 0 || i >= this.f499vP.size()) ? null : this.f499vP.elementAt(i);
        if (elementAt == null) {
            throw new C0279af(new StringBuffer("JSONArray[").append(i).append("] not found.").toString());
        }
        return elementAt;
    }

    public final String getString(int i) {
        return get(i).toString();
    }

    public final String toString() {
        try {
            return new StringBuffer("[").append(join(",")).append(']').toString();
        } catch (Exception e) {
            return null;
        }
    }
}
