package com.gameloft.android.LATAM.GloftGF2H;

import com.facebook.widget.WorkQueue;
import java.util.Enumeration;
import java.util.Hashtable;

public final class C0280ag {

    private Hashtable f500vQ;
    public static final Boolean TRUE = new Boolean(true);
    public static final Boolean FALSE = new Boolean(false);
    public static final Object NULL = new C0281ah((byte) 0);

    public C0280ag() {
        this.f500vQ = new Hashtable();
    }

    public C0280ag(com.gameloft.android.LATAM.GloftGF2H.C0283aj r4) {
        throw new UnsupportedOperationException("Method not decompiled: com.gameloft.android.LATAM.GloftGF2H.C0280ag.<init>(com.gameloft.android.LATAM.GloftGF2H.aj):void");
    }

    public C0280ag(String str) {
        this(new C0283aj(str));
    }

    private static String m685b(Object obj) {
        if (obj == null) {
            throw new C0279af("Null pointer");
        }
        String obj2 = obj.toString();
        if (obj2.indexOf(46) <= 0 || obj2.indexOf(101) >= 0 || obj2.indexOf(69) >= 0) {
            return obj2;
        }
        while (obj2.endsWith("0")) {
            obj2 = obj2.substring(0, obj2.length() - 1);
        }
        return obj2.endsWith(".") ? obj2.substring(0, obj2.length() - 1) : obj2;
    }

    static String m686c(Object obj) {
        if (obj == null || obj.equals(null)) {
            return "null";
        }
        if (!(obj instanceof InterfaceC0282ai)) {
            return ((obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long)) ? m685b(obj) : ((obj instanceof Boolean) || (obj instanceof C0280ag) || (obj instanceof C0278ae)) ? obj.toString() : quote(obj.toString());
        }
        try {
            String m694cf = ((InterfaceC0282ai) obj).m694cf();
            if (m694cf instanceof String) {
                return m694cf;
            }
            throw new C0279af(new StringBuffer("Bad value from toJSONString: ").append((Object) m694cf).toString());
        } catch (Exception e) {
            throw new C0279af(e);
        }
    }

    private Object get(String str) {
        Object opt = opt(str);
        if (opt == null) {
            throw new C0279af(new StringBuffer("JSONObjects[").append(quote(str)).append("] not found.").toString());
        }
        return opt;
    }

    private Object opt(String str) {
        if (str == null) {
            return null;
        }
        return this.f500vQ.get(str);
    }

    private static String quote(String str) {
        int i = 0;
        if (str == null || str.length() == 0) {
            return "\"\"";
        }
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer(length + 4);
        stringBuffer.append('\"');
        char c = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            switch (charAt) {
                case WorkQueue.DEFAULT_MAX_CONCURRENT:
                    stringBuffer.append("\\b");
                    break;
                case '\t':
                    stringBuffer.append("\\t");
                    break;
                case '\n':
                    stringBuffer.append("\\n");
                    break;
                case '\f':
                    stringBuffer.append("\\f");
                    break;
                case '\r':
                    stringBuffer.append("\\r");
                    break;
                case '\"':
                case '\\':
                    stringBuffer.append('\\');
                    stringBuffer.append(charAt);
                    break;
                case '/':
                    if (c == '<') {
                        stringBuffer.append('\\');
                    }
                    stringBuffer.append(charAt);
                    break;
                default:
                    if (charAt >= ' ') {
                        stringBuffer.append(charAt);
                        break;
                    } else {
                        stringBuffer.append(new StringBuffer("\\u").append(new StringBuffer("000").append(Integer.toHexString(charAt)).toString().substring(r1.length() - 4)).toString());
                        break;
                    }
            }
            i++;
            c = charAt;
        }
        stringBuffer.append('\"');
        return stringBuffer.toString();
    }

    public final C0278ae m687V(String str) {
        Object obj = get(str);
        if (obj instanceof C0278ae) {
            return (C0278ae) obj;
        }
        throw new C0279af(new StringBuffer("JSONObjects[").append(quote(str)).append("] is not a JSONArray.").toString());
    }

    public final C0280ag m688W(String str) {
        Object obj = get(str);
        if (obj instanceof C0280ag) {
            return (C0280ag) obj;
        }
        if (obj instanceof String) {
            return new C0280ag((String) obj);
        }
        throw new C0279af(new StringBuffer("JSONObjects[").append(quote(str)).append("] is not a JSONObjects.").toString());
    }

    public final C0280ag m689a(String str, long j) {
        m693f(str, new Long(j));
        return this;
    }

    public final C0280ag m690c(String str, int i) {
        m693f(str, new Integer(i));
        return this;
    }

    public final C0278ae m691ce() {
        C0278ae c0278ae = new C0278ae();
        Enumeration keys = this.f500vQ.keys();
        while (keys.hasMoreElements()) {
            c0278ae.m684a(keys.nextElement());
        }
        if (c0278ae.f499vP.size() == 0) {
            return null;
        }
        return c0278ae;
    }

    public final C0280ag m692e(String str, Object obj) {
        Object opt = opt(str);
        if (opt == null) {
            m693f(str, obj);
        } else if (opt instanceof C0278ae) {
            ((C0278ae) opt).m684a(obj);
        } else {
            m693f(str, new C0278ae().m684a(opt).m684a(obj));
        }
        return this;
    }

    public final C0280ag m693f(String str, Object obj) {
        if (str == null) {
            throw new C0279af("Null key.");
        }
        if (obj != null) {
            this.f500vQ.put(str, obj);
        } else {
            this.f500vQ.remove(str);
        }
        return this;
    }

    public final int getInt(String str) {
        Object obj = get(str);
        if (obj instanceof Byte) {
            return ((Byte) obj).byteValue();
        }
        if (obj instanceof Short) {
            return ((Short) obj).shortValue();
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (obj instanceof Long) {
            return (int) ((Long) obj).longValue();
        }
        throw new C0279af(new StringBuffer("JSONObjects[").append(quote(str)).append("] is not a number.").toString());
    }

    public final long getLong(String str) {
        Object obj = get(str);
        if (obj instanceof Byte) {
            return ((Byte) obj).byteValue();
        }
        if (obj instanceof Short) {
            return ((Short) obj).shortValue();
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (obj instanceof Long) {
            return ((Long) obj).longValue();
        }
        throw new C0279af(new StringBuffer("JSONObjects[").append(quote(str)).append("] is not a number.").toString());
    }

    public final String getString(String str) {
        return get(str).toString();
    }

    public final boolean has(String str) {
        return this.f500vQ.containsKey(str);
    }

    public final String toString() {
        try {
            Enumeration keys = this.f500vQ.keys();
            StringBuffer stringBuffer = new StringBuffer("{");
            while (keys.hasMoreElements()) {
                if (stringBuffer.length() > 1) {
                    stringBuffer.append(',');
                }
                Object nextElement = keys.nextElement();
                stringBuffer.append(quote(nextElement.toString()));
                stringBuffer.append(':');
                stringBuffer.append(m686c(this.f500vQ.get(nextElement)));
            }
            stringBuffer.append('}');
            return stringBuffer.toString();
        } catch (Exception e) {
            return null;
        }
    }
}
