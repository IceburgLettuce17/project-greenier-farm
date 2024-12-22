package com.gameloft.android2d.iap.utils;

import com.facebook.internal.ServerProtocol;
import com.gameloft.android2d.iap.C0463b;
import com.gameloft.android2d.iap.p042a.AbstractC0358a;
import java.util.Hashtable;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import p001a.p004b.p005a.p006a.C0002a;
import p001a.p004b.p005a.p006a.C0012k;

public final class C0482i extends DefaultHandler {
    private boolean adO = false;
    private String adP = null;
    private String adQ = null;
    private C0483j adR = null;
    public AbstractC0358a adS = null;
    private C0490q adT = null;
    private boolean adU = false;
    private boolean adV = false;
    private boolean adW = false;
    private boolean adX = false;
    private boolean adY = false;
    private boolean adZ = false;
    private boolean aea = false;
    private boolean aeb = false;
    private boolean aec = false;
    private boolean aed = false;
    private boolean aee = false;
    private boolean aef = false;

    @Override
    public final void characters(char[] cArr, int i, int i2) {
        if (this.adO) {
            this.adP += new String(cArr, i, i2);
        }
    }

    @Override
    public final void endElement(String str, String str2, String str3) {
        try {
            this.adO = false;
            this.adP = this.adP.trim();
            if (this.adU) {
                if (str2.equals("country")) {
                    this.adT.aeQ = this.adP.trim();
                } else if (str2.equals("operator")) {
                    this.adT.aeS = this.adP.trim();
                } else if (str2.equals("product")) {
                    this.adT.aeT = this.adP.trim();
                } else if (str2.equals("platform")) {
                    this.adT.aeV = this.adP.trim();
                } else if (str2.equals("language")) {
                    this.adT.aeY = this.adP.trim();
                } else if (str2.equals("promo_description")) {
                    if (this.adP != null) {
                        C0490q c0490q = this.adT;
                        this.adP.trim();
                    }
                } else if (str2.equals("promo_endtime")) {
                    if (this.adP != null) {
                        this.adT.afc = this.adP.trim();
                    }
                } else if (str2.equals("server_time")) {
                    if (this.adP != null) {
                        this.adT.afd = this.adP.trim();
                    }
                } else if (str2.equals("limits_validation_url")) {
                    this.adT.aeW = this.adP.trim();
                } else if (str2.equals("flow_type")) {
                    this.adT.aeZ = Integer.parseInt(this.adP.trim());
                } else if (str2.equals("text")) {
                    if (this.adX) {
                        this.adT.afa = this.adP.trim();
                    } else {
                        this.adT.afb = this.adP.trim();
                    }
                } else if (str2.equals("shop_info")) {
                    this.adU = false;
                }
            } else if (this.adV) {
                if (this.adW) {
                    if (str2.equals("billing")) {
                        this.adS.m2251bV(this.adR.getId());
                        this.adR.m2612b(this.adS);
                    } else if (str2.equals("shenzhoufu_billing")) {
                        this.adS.m2235bF(this.adP.trim());
                    } else if (str2.equals("shenzhoufu_get_billing_result")) {
                        this.adS.m2239bJ(this.adP.trim());
                    } else if (str2.equals("msg_shenzhoufu_notice")) {
                        this.adS.m2238bI(this.adP.trim());
                    } else if (str2.equals("shortcode")) {
                        this.adS.m2231bB(this.adP.trim());
                    } else if (str2.equals("shortcode1")) {
                        this.adS.m2232bC(this.adP.trim());
                    } else if (str2.equals("shortcode2")) {
                        this.adS.m2233bD(this.adP.trim());
                    } else if (str2.equals("alias")) {
                        this.adS.m2234bE(this.adP.trim());
                    } else if (str2.equals("ump_get_transid")) {
                        this.adS.m2235bF(this.adP.trim());
                    } else if (str2.equals("ump_get_billing_result")) {
                        this.adS.m2239bJ(this.adP.trim());
                    } else if (str2.equals("msg_psms_notice_1")) {
                        this.adS.m2236bG(this.adP.trim());
                    } else if (str2.equals("msg_psms_notice_2")) {
                        this.adS.m2237bH(this.adP.trim());
                    } else if (str2.equals(ServerProtocol.DIALOG_PARAM_TYPE)) {
                        this.adS.m2257bu(this.adP.trim());
                    } else if (str2.equals("price")) {
                        this.adS.m2254br(this.adP.trim());
                    } else if (str2.equals("currency")) {
                        this.adS.m2255bs(this.adP.trim());
                    } else if (str2.equals("formatted_price")) {
                        this.adS.m2262bz(this.adP.trim());
                    } else if (str2.equals("tnc")) {
                        this.adS.m2256bt(this.adP.trim());
                    } else if (str2.equals("url")) {
                        this.adS.m2230bA(this.adP.trim());
                    } else if (str2.equals("uid") || str2.equals("sku") || str2.equals("samsung_item_id")) {
                        this.adS.m2258bv(this.adP.trim());
                    } else if (str2.equals("group_id")) {
                        this.adS.m2259bw(this.adP.trim());
                    } else if (str2.equals("money")) {
                        this.adS.m2260bx(this.adP.trim());
                    } else if (str2.equals("is_3g_only")) {
                        this.adS.m2261by(this.adP.trim());
                    } else if (str2.equals("id")) {
                        this.adS.setProfileId(this.adP.trim());
                    } else if (str2.equals("proxy")) {
                        this.adS.m2241bL(this.adP.trim());
                    } else if (str2.equals("port")) {
                        this.adS.m2242bM(this.adP.trim());
                    } else if (str2.equals("price_point")) {
                        this.adS.m2240bK(this.adP.trim());
                    } else if (str2.equals("text")) {
                        if (this.adY) {
                            this.adS.m2243bN(this.adP.trim());
                            this.adY = false;
                        }
                        if (this.adZ) {
                            this.adS.m2244bO(this.adP.trim());
                            this.adZ = false;
                        }
                        if (this.aea) {
                            this.adS.m2245bP(this.adP.trim());
                            this.aea = false;
                        }
                        if (this.aeb) {
                            this.adS.m2246bQ(this.adP.trim());
                            this.aeb = false;
                        }
                        if (this.aec) {
                            this.adS.m2247bR(this.adP.trim());
                            this.aec = false;
                        }
                        if (this.aed) {
                            this.adS.m2248bS(this.adP.trim());
                            this.aed = false;
                        }
                        if (this.aee) {
                            this.adS.m2249bT(this.adP.trim());
                            this.aee = false;
                        }
                        if (this.aef) {
                            this.adS.m2250bU(this.adP.trim());
                            this.aef = false;
                        }
                    } else if (str2.equals("billing_list")) {
                        this.adW = false;
                    }
                } else if (str2.equals("content")) {
                    C0490q c0490q2 = this.adT;
                    C0483j c0483j = this.adR;
                    if (c0483j != null) {
                        try {
                            String type = c0483j.getType();
                            C0012k.m41c("IAP-ShopProfile", "[add item] key = " + type + ", managed value = " + c0483j.m2624sU());
                            String m2278rt = c0483j.m2620sQ().m2278rt();
                            if (!c0490q2.aeK.containsKey(type)) {
                                Hashtable<Integer, C0483j> hashtable = new Hashtable<>();
                                if (m2278rt != "") {
                                    hashtable.put(Integer.valueOf(Integer.parseInt(m2278rt)), c0483j);
                                    c0490q2.aeM.put(type.toLowerCase() + "_0", Integer.valueOf(Integer.parseInt(m2278rt)));
                                } else {
                                    hashtable.put(0, c0483j);
                                    c0490q2.aeM.put(type.toLowerCase() + "_0", 0);
                                }
                                c0490q2.aeK.put(type, hashtable);
                            } else if (m2278rt != "") {
                                c0490q2.aeM.put(type.toLowerCase() + "_" + c0490q2.aeK.get(type).size(), Integer.valueOf(Integer.parseInt(m2278rt)));
                                c0490q2.aeK.get(type).put(Integer.valueOf(Integer.parseInt(m2278rt)), c0483j);
                            } else {
                                c0490q2.aeM.put(type.toLowerCase() + "_" + c0490q2.aeK.get(type).size(), Integer.valueOf(c0490q2.aeK.get(type).size()));
                                c0490q2.aeK.get(type).put(Integer.valueOf(c0490q2.aeK.get(type).size()), c0483j);
                            }
                            c0490q2.aeL.put(c0483j.getId(), c0483j);
                        } catch (Exception e) {
                            C0012k.m40b("IAP-ShopProfile", "[addItem]" + e.getMessage());
                        }
                    }
                } else if (str2.equals("attribute")) {
                    this.adR.m2610E(this.adQ, this.adP.trim());
                    this.adQ = null;
                } else if (str2.equals("billing_type_pref")) {
                    this.adR.m2614cA(this.adP.trim());
                } else if (str2.equals("content_list")) {
                    this.adV = false;
                } else if (str2.equals("offline_item")) {
                    this.adR.m2616cx(this.adP.trim());
                }
            }
            this.adP = "";
        } catch (Exception e2) {
            C0012k.m40b("IAP-IABXMLParser", "parser err " + e2.toString());
        }
    }

    public final C0490q m2608qA() {
        return this.adT;
    }

    @Override
    public final void startElement(String str, String str2, String str3, Attributes attributes) {
        if (!C0463b.m2544qQ() && this.adO) {
            this.adP = "";
        }
        this.adO = true;
        if (str2.equals("shop_info")) {
            this.adT = new C0490q();
            this.adU = true;
            return;
        }
        if (this.adU) {
            if (str2.equals("country")) {
                this.adT.aeP = attributes.getValue("id");
                return;
            }
            if (str2.equals("operator")) {
                this.adT.aeR = attributes.getValue("id");
                return;
            }
            if (str2.equals("product")) {
                this.adT.abR = attributes.getValue("id");
                return;
            }
            if (str2.equals("platform")) {
                this.adT.aeU = attributes.getValue("id");
                return;
            }
            if (str2.equals("language")) {
                this.adT.aeX = attributes.getValue("id");
                return;
            }
            if (str2.equals("text")) {
                String value = attributes.getValue("key");
                if (value != null && value.equals("ok")) {
                    this.adX = true;
                    return;
                } else {
                    if (value == null || !value.equals("later")) {
                        return;
                    }
                    this.adX = false;
                    return;
                }
            }
            return;
        }
        if (str2.equals("content_list")) {
            this.adV = true;
            return;
        }
        if (this.adV) {
            if (str2.equals("content")) {
                this.adR = new C0483j();
                this.adR.setId(attributes.getValue("id"));
                this.adR.m2613bu(attributes.getValue(ServerProtocol.DIALOG_PARAM_TYPE).toLowerCase());
                return;
            }
            if (str2.equals("attribute")) {
                this.adQ = attributes.getValue("name");
                return;
            }
            if (str2.equals("billing_list")) {
                this.adW = true;
                return;
            }
            if (str2.equals("offline_items_bonus")) {
                this.adR.m2618sO();
                return;
            }
            if (!str2.equals("text")) {
                if (this.adW && str2.equals("billing")) {
                    this.adS = C0002a.m1a(attributes.getValue(ServerProtocol.DIALOG_PARAM_TYPE));
                    return;
                }
                return;
            }
            String value2 = attributes.getValue("key");
            if (value2 == null || !value2.equals("purchase_confirm")) {
                this.adY = false;
            } else {
                this.adY = true;
            }
            if (value2 == null || !value2.equals("purchase_confirm_above_buttons")) {
                this.adZ = false;
            } else {
                this.adZ = true;
            }
            if (value2 == null || !value2.equals("purchase_confirm_below_buttons")) {
                this.aea = false;
            } else {
                this.aea = true;
            }
            if (value2 == null || !value2.equals("hint_wp8")) {
                this.aeb = false;
            } else {
                this.aeb = true;
            }
            if (value2 == null || !value2.equals("send_sms_wp8")) {
                this.aec = false;
            } else {
                this.aec = true;
            }
            if (value2 == null || !value2.equals("phone_account_notification_wp8")) {
                this.aed = false;
            } else {
                this.aed = true;
            }
            if (value2 == null || !value2.equals("confirm_wp8")) {
                this.aee = false;
            } else {
                this.aee = true;
            }
            if (value2 == null || !value2.equals("back_wp8")) {
                this.aef = false;
            } else {
                this.aef = true;
            }
        }
    }
}
