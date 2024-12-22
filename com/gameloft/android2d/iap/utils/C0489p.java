package com.gameloft.android2d.iap.utils;

import com.gameloft.android2d.iap.C0463b;
import java.io.ByteArrayInputStream;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import p001a.p004b.p005a.p006a.C0012k;

public final class C0489p {
    private SAXParserFactory aeC;
    private SAXParser aeD;
    private XMLReader aeE;
    public C0482i aeF;
    private C0477d aeG;
    private C0491r aeH;
    public C0490q aeI = null;
    private boolean aeJ;

    public C0489p() {
        try {
            if (!C0463b.m2544qQ()) {
                this.aeC = SAXParserFactory.newInstance();
                this.aeD = this.aeC.newSAXParser();
                this.aeE = this.aeD.getXMLReader();
            }
            this.aeF = new C0482i();
            if (!C0463b.m2544qQ()) {
                this.aeE.setContentHandler(this.aeF);
            }
            this.aeG = new C0477d();
            this.aeH = new C0491r(this.aeG);
        } catch (Exception e) {
            C0012k.m40b("InAppBilling", "XML Server Parsing Exception = " + e);
        }
    }

    private void m2656a(InputSource inputSource) {
        try {
            this.aeE.parse(inputSource);
            this.aeI = this.aeF.m2608qA();
        } catch (Exception e) {
            C0012k.m40b("InAppBilling", "parseXML Parsing Exception = " + e);
        }
    }

    private boolean m2657cL(String str) {
        if (!C0463b.f2811Za) {
            this.aeJ = false;
            return false;
        }
        C0477d.m2600sI();
        C0477d.m2599sH();
        this.aeJ = true;
        try {
            StringBuilder sb = new StringBuilder();
            C0477d c0477d = this.aeG;
            String sb2 = sb.append(C0477d.getSimOperator()).append(".xml").toString();
            if (str.startsWith("EMBED:")) {
                sb2 = str.substring(6) + ".xml";
            }
            m2656a(new InputSource(C0488o.getResourceAsStream(sb2)));
            C0490q m2528qA = C0463b.m2528qA();
            if (m2528qA.aeK.isEmpty()) {
                this.aeJ = false;
            } else {
                m2528qA.m2659I("Cash".toLowerCase(), "Coin".toLowerCase());
            }
        } catch (Exception e) {
            this.aeJ = false;
        }
        return this.aeJ;
    }

    public final boolean m2658cM(String str) {
        C0477d c0477d = this.aeG;
        if (!C0477d.m2593qg() || str.startsWith("EMBED:")) {
            return m2657cL(str);
        }
        String str2 = (str == null || str.equals("0") || str.equals("")) ? "http://iap.gameloft.com/freemium/fm_profiles_shop_2d.php" : str;
        C0012k.m39a("IAP-ServerInfo", "[getUpdateProfileInfo] url = " + str2);
        if (!C0463b.m2544qQ()) {
            C0491r c0491r = this.aeH;
            C0491r.m2673cP(str2);
            long j = 0;
            while (!this.aeH.m2692th()) {
                try {
                    Thread.sleep(50L);
                } catch (Exception e) {
                }
                if (System.currentTimeMillis() - j > 1500) {
                    C0012k.m39a("IAP-ServerInfo", "[sendProfileRequest]Waiting for response");
                    j = System.currentTimeMillis();
                }
            }
        }
        if (C0463b.m2544qQ()) {
            C0490q m2528qA = C0463b.m2528qA();
            if (m2528qA.aeK.isEmpty()) {
                return true;
            }
            m2528qA.m2659I("Cash".toLowerCase(), "Coin".toLowerCase());
            if (!C0463b.f2793YK) {
                return true;
            }
            if (!C0488o.m2653td()) {
                C0012k.m39a("IAP-ServerInfo", "downloadImageItems failed...");
                return false;
            }
            if (C0488o.m2654te()) {
                C0012k.m39a("IAP-ServerInfo", "Load Items Image OK...");
                return true;
            }
            C0012k.m39a("IAP-ServerInfo", "LoadImageData failed...");
            return false;
        }
        if (C0491r.m2682tg() != 0) {
            return m2657cL(str);
        }
        m2656a(new InputSource(new ByteArrayInputStream(C0491r.m2686tq().f2868dA.getBytes())));
        C0490q m2528qA2 = C0463b.m2528qA();
        if (m2528qA2.aeK.isEmpty()) {
            return m2657cL(str);
        }
        m2528qA2.m2659I("Cash".toLowerCase(), "Coin".toLowerCase());
        if (!C0463b.f2793YK) {
            return true;
        }
        if (!C0488o.m2653td()) {
            C0012k.m39a("IAP-ServerInfo", "downloadImageItems failed...");
            return false;
        }
        if (C0488o.m2654te()) {
            C0012k.m39a("IAP-ServerInfo", "Load Items Image OK...");
            return true;
        }
        C0012k.m39a("IAP-ServerInfo", "LoadImageData failed...");
        return false;
    }
}
