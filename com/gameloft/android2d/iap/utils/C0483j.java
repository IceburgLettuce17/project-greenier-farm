package com.gameloft.android2d.iap.utils;

import com.gameloft.android2d.iap.p042a.AbstractC0358a;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import p009b.p010a.p012b.C0051af;

public final class C0483j implements Comparable<C0483j> {
    private String aeg = "";
    private String type = "";

    private String f2877id = "";
    private String aeh = "";
    private C0051af aei = null;
    private Hashtable<String, String> aej = new Hashtable<>();
    private Hashtable<String, AbstractC0358a> aek = new Hashtable<>();
    private ArrayList<String> ael = new ArrayList<>();

    private String m2609cy(String str) {
        if (this.aej.isEmpty()) {
            return null;
        }
        return this.aej.get(str);
    }

    public final void m2610E(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        this.aej.put(str, str2);
    }

    public final void m2611a(C0051af c0051af) {
        this.aei = c0051af;
    }

    public final void m2612b(AbstractC0358a abstractC0358a) {
        if (abstractC0358a != null) {
            this.aek.put(abstractC0358a.m2271rm(), abstractC0358a);
        }
    }

    public final void m2613bu(String str) {
        this.type = str.toLowerCase();
    }

    public final void m2614cA(String str) {
        this.aeg = str;
    }

    public final void m2615cB(String str) {
        this.aeh = str;
    }

    @Override
    public final int compareTo(C0483j c0483j) {
        return Float.valueOf(Float.parseFloat(m2620sQ().m2272rn())).compareTo(Float.valueOf(Float.parseFloat(c0483j.m2620sQ().m2272rn())));
    }

    public final void m2616cx(String str) {
        this.ael.add(str);
    }

    public final AbstractC0358a m2617cz(String str) {
        if (this.aek.isEmpty()) {
            return null;
        }
        return this.aek.get(str);
    }

    public final String getId() {
        return this.f2877id;
    }

    public final String getType() {
        return this.type;
    }

    public final void m2618sO() {
        if (this.ael == null) {
            this.ael = new ArrayList<>();
        }
        this.ael.clear();
    }

    public final String[] m2619sP() {
        if (this.ael.isEmpty()) {
            return null;
        }
        return (String[]) this.ael.toArray(new String[this.ael.size()]);
    }

    public final AbstractC0358a m2620sQ() {
        return m2617cz(this.aeg);
    }

    public final long m2621sR() {
        String m2609cy = m2609cy("amount");
        if (m2609cy != null) {
            return C0488o.m2645cG(m2609cy);
        }
        return 0L;
    }

    public final long m2622sS() {
        String m2609cy = m2609cy("old_amount");
        if (m2609cy != null) {
            return C0488o.m2645cG(m2609cy);
        }
        return 0L;
    }

    public final String m2623sT() {
        return m2609cy("image");
    }

    public final String m2624sU() {
        return m2609cy("managed");
    }

    public final String m2625sV() {
        return this.aeh;
    }

    public final C0051af m2626sW() {
        return this.aei;
    }

    public final void setId(String str) {
        this.f2877id = str;
    }

    public final String toString() {
        String str;
        String str2 = "******Item********\nId: '" + this.f2877id + "' Type: '" + this.type + "' Type_pref: '" + this.aeg + "'";
        Enumeration<String> keys = this.aej.keys();
        while (true) {
            str = str2;
            if (!keys.hasMoreElements()) {
                break;
            }
            String nextElement = keys.nextElement();
            str2 = str + "\nName: " + nextElement + " '" + this.aej.get(nextElement) + "'";
        }
        Enumeration<String> keys2 = this.aek.keys();
        while (keys2.hasMoreElements()) {
            str = (str + "\n-----Billing-------") + "\n" + this.aek.get(keys2.nextElement()).toString();
        }
        return str;
    }
}
