package com.gameloft.android2d.iap.p042a;

import com.gameloft.android2d.iap.InterfaceC0357a;

public abstract class AbstractC0358a implements InterfaceC0357a {

    public String f2744Zq = "";

    public String f2745Zr = "";

    public String f2746Zs = "";

    public String f2747Zt = "";

    public String f2748Zu = "";
    public String type = "";
    public String profileId = "";

    private String f2749Zv = "";
    public String url = "";

    public String f2750Zw = "";

    public String f2751Zx = "";

    public String f2752Zy = "";

    public String f2753Zz = "";

    public String f2725ZA = "";

    public String f2726ZB = "";

    public String f2727ZC = "";

    public String f2728ZD = "";

    private String f2729ZE = "";

    private String f2730ZF = "";

    private String f2731ZG = "";

    private String f2732ZH = "";

    private String f2733ZI = "";

    private String f2734ZJ = "";

    public String f2735ZK = "";

    private String f2736ZL = "";

    private String f2737ZM = "";

    private String f2738ZN = "";

    private String f2739ZO = "";

    public String f2740ZP = "";

    public String f2741ZQ = "";

    public String f2742ZR = "";

    public String f2743ZS = "";

    protected static boolean m2229bq(String str) {
        return (str == null || str.equals("")) ? false : true;
    }

    public final void m2230bA(String str) {
        this.url = str;
    }

    public final void m2231bB(String str) {
        this.f2752Zy = str;
    }

    public final void m2232bC(String str) {
        this.f2725ZA = str;
    }

    public final void m2233bD(String str) {
        this.f2726ZB = str;
    }

    public final void m2234bE(String str) {
        this.f2753Zz = str;
    }

    public final void m2235bF(String str) {
        this.f2727ZC = str;
    }

    public final void m2236bG(String str) {
        this.f2729ZE = str;
    }

    public final void m2237bH(String str) {
        this.f2730ZF = str;
    }

    public final void m2238bI(String str) {
        this.f2731ZG = str;
    }

    public final void m2239bJ(String str) {
        this.f2728ZD = str;
    }

    public final void m2240bK(String str) {
        this.f2749Zv = str;
    }

    public final void m2241bL(String str) {
        this.f2750Zw = str;
    }

    public final void m2242bM(String str) {
        this.f2751Zx = str;
    }

    public final void m2243bN(String str) {
        this.f2732ZH = str;
    }

    public final void m2244bO(String str) {
        this.f2733ZI = str;
    }

    public final void m2245bP(String str) {
        this.f2734ZJ = str;
    }

    public final void m2246bQ(String str) {
        this.f2735ZK = str;
    }

    public final void m2247bR(String str) {
        this.f2736ZL = str;
    }

    public final void m2248bS(String str) {
        this.f2737ZM = str;
    }

    public final void m2249bT(String str) {
        this.f2738ZN = str;
    }

    public final void m2250bU(String str) {
        this.f2739ZO = str;
    }

    public final void m2251bV(String str) {
        this.f2743ZS = str;
    }

    public void mo2252bW(String str) {
    }

    public abstract void mo2253bp(String str);

    public final void m2254br(String str) {
        this.f2745Zr = str;
    }

    public final void m2255bs(String str) {
        this.f2746Zs = str;
    }

    public final void m2256bt(String str) {
        this.f2748Zu = str;
    }

    public final void m2257bu(String str) {
        this.type = str;
    }

    public final void m2258bv(String str) {
        this.f2740ZP = str;
    }

    public final void m2259bw(String str) {
        this.f2742ZR = str;
    }

    public final void m2260bx(String str) {
        this.f2741ZQ = str;
    }

    public final void m2261by(String str) {
        str.trim().equals("1");
    }

    public final void m2262bz(String str) {
        this.f2747Zt = str;
    }

    public final String getProfileId() {
        return this.profileId;
    }

    public final String m2263rA() {
        return this.f2736ZL;
    }

    public final String m2264rB() {
        return this.f2737ZM;
    }

    public final String m2265rC() {
        return this.f2738ZN;
    }

    public final String m2266rD() {
        return this.f2739ZO;
    }

    public void mo2267rE() {
    }

    public boolean mo2268rF() {
        return false;
    }

    public boolean mo2269rG() {
        return false;
    }

    public String mo2270rH() {
        return null;
    }

    public final String m2271rm() {
        return this.f2744Zq;
    }

    public final String m2272rn() {
        return this.f2745Zr;
    }

    public final String m2273ro() {
        return this.f2746Zs;
    }

    public final String m2274rp() {
        return this.f2752Zy;
    }

    public final String m2275rq() {
        return this.f2729ZE;
    }

    public final String m2276rr() {
        return this.f2730ZF;
    }

    public final String m2277rs() {
        return this.f2731ZG;
    }

    public final String m2278rt() {
        return this.f2749Zv;
    }

    public final String m2279ru() {
        return this.f2750Zw;
    }

    public final String m2280rv() {
        return this.f2751Zx;
    }

    public final String m2281rw() {
        return this.f2732ZH;
    }

    public final String m2282rx() {
        return this.f2733ZI;
    }

    public final String m2283ry() {
        return this.f2734ZJ;
    }

    public final String m2284rz() {
        return this.f2735ZK;
    }

    public final void setProfileId(String str) {
        this.profileId = str;
    }

    public String toString() {
        return "ProfID: '" + this.profileId + "' BillingType: '" + this.f2744Zq + "' Price: '" + this.f2745Zr + "' Currency: '" + this.f2746Zs + "(' Formatted Price: '" + this.f2747Zt + ")' TNC: '" + this.f2748Zu + "' URL: '" + this.url + "' Proxy Server: '" + this.f2750Zw + "' Proxy Port: '" + this.f2751Zx + "' Alias: '" + this.f2753Zz + "' ServerNumber: '" + this.f2752Zy + "\n";
    }
}
