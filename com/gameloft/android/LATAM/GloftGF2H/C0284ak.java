package com.gameloft.android.LATAM.GloftGF2H;

public final class C0284ak {

    String[] f503vT;

    Object[] f504vU;

    int f505vV;

    public C0284ak() {
        this.f505vV = 0;
        this.f503vT = new String[10];
        this.f504vU = new Object[10];
    }

    public C0284ak(String str) {
        if (str != null) {
            this.f505vV = 0;
            this.f503vT = new String[10];
            this.f504vU = new Object[10];
            str = str.startsWith("[") ? new StringBuffer("{\"json\":").append(str).append("}").toString() : str;
            m697a(str, 0, str.length());
        }
    }

    private int m696Y(String str) {
        if (str == null) {
            return -1;
        }
        for (int i = 0; i < this.f505vV; i++) {
            if (this.f503vT[i].equals(str)) {
                return i;
            }
        }
        return -1;
    }

    private void m697a(String str, int i, int i2) {
        String str2;
        int i3 = i;
        while (true) {
            try {
                StringBuffer stringBuffer = new StringBuffer();
                boolean z = false;
                boolean z2 = false;
                int i4 = i3;
                while (true) {
                    if (i4 < i2) {
                        char charAt = str.charAt(i4);
                        if (!z) {
                            switch (charAt) {
                                case '\"':
                                case '\'':
                                    z2 = !z2;
                                    if (!z2) {
                                        str2 = stringBuffer.toString();
                                        break;
                                    } else {
                                        break;
                                    }
                                case '\\':
                                    z = true;
                                    break;
                                default:
                                    if (!z2) {
                                        break;
                                    } else {
                                        stringBuffer.append(charAt);
                                        break;
                                    }
                            }
                        } else {
                            switch (charAt) {
                                case 'b':
                                    stringBuffer.append('\b');
                                    break;
                                case 'f':
                                    stringBuffer.append('\f');
                                    break;
                                case 'n':
                                    stringBuffer.append('\n');
                                    break;
                                case 'r':
                                    stringBuffer.append('\r');
                                    break;
                                case 't':
                                    stringBuffer.append('\t');
                                    break;
                                default:
                                    stringBuffer.append(charAt);
                                    break;
                            }
                        }
                        i4++;
                    } else {
                        str2 = null;
                    }
                }
                if (str2 == null) {
                    return;
                }
                int indexOf = str.indexOf(str2, i3) + str2.length() + 1;
                i3 = m699b(str, indexOf, i2);
                m706g(str2, m700c(str, indexOf, i3));
            } catch (Exception e) {
                return;
            }
        }
    }

    private static void m698a(StringBuffer stringBuffer, Object obj) {
        boolean z;
        boolean z2 = true;
        if (obj.toString().equals(obj)) {
            String obj2 = obj.toString();
            if (obj2.length() != 0) {
                int i = 0;
                while (true) {
                    if (i >= obj2.length()) {
                        z = true;
                        break;
                    } else {
                        if (!Character.isDigit(obj2.charAt(i))) {
                            z = false;
                            break;
                        }
                        i++;
                    }
                }
            } else {
                z = false;
            }
            if (!z) {
                if (!obj.toString().startsWith("{")) {
                }
            }
        }
        z2 = false;
        if (z2) {
            stringBuffer.append("\"");
        }
        stringBuffer.append(obj);
        if (z2) {
            stringBuffer.append("\"");
        }
    }

    private static int m699b(String str, int i, int i2) {
        boolean z = false;
        int i3 = i;
        int i4 = 0;
        char c = 0;
        while (i3 < i2) {
            char charAt = str.charAt(i3);
            if (charAt != ' ' && charAt != ':' && charAt != ',' && charAt != '}' && charAt != ']') {
                z = true;
            }
            switch (charAt) {
                case '\"':
                case '\'':
                    if (c != 0) {
                        if (charAt != c) {
                            break;
                        } else {
                            return i3 + 1;
                        }
                    } else {
                        c = charAt;
                        break;
                    }
                case ',':
                    if (c == 0 && z) {
                        return i3 + 1;
                    }
                    break;
                case '[':
                case '{':
                    if (c != 0 && c != charAt) {
                        break;
                    } else {
                        i4++;
                        c = charAt;
                        break;
                    }
                case '\\':
                    i3++;
                    break;
                case ']':
                    if (c == '[') {
                        i4--;
                    }
                    if (i4 == 0 && z && c != '\"') {
                        return i3 + 1;
                    }
                    break;
                case '}':
                    if (c == '{') {
                        i4--;
                    }
                    if (i4 == 0 && z && c != '\"') {
                        return i3 + 1;
                    }
                    break;
            }
            i3++;
        }
        return -1;
    }

    private Object m700c(String str, int i, int i2) {
        char c = 0;
        while (i < i2) {
            c = str.charAt(i);
            if (c != ' ' && c != ':' && c != ',') {
                break;
            }
            i++;
        }
        switch (c) {
            case '\"':
            case '\'':
                return m701d(str, i + 1, i2);
            case '[':
                int i3 = i + 1;
                int i4 = -1;
                int i5 = i3;
                do {
                    i5 = m699b(str, i5, i2);
                    i4++;
                } while (i5 != -1);
                if (i4 < 0) {
                    return null;
                }
                Object[] objArr = new Object[i4];
                int m699b = m699b(str, i3, i2);
                int i6 = 0;
                while (m699b >= 0) {
                    objArr[i6] = m700c(str, i3, m699b);
                    i3 = m699b;
                    m699b = m699b(str, m699b, i2);
                    i6++;
                }
                return objArr;
            case '{':
                return new C0284ak(str.substring(i, i2));
            default:
                return m701d(str, i, i2);
        }
    }

    private static String m701d(String str, int i, int i2) {
        return i2 <= i ? "" : str.substring(i, i2 - 1).trim();
    }

    public final Object m702Z(String str) {
        int m696Y = m696Y(str);
        if (m696Y != -1) {
            return this.f504vU[m696Y];
        }
        return null;
    }

    public final int m703aa(String str) {
        Object m702Z = m702Z(str);
        if (m702Z == null) {
            throw new Exception(new StringBuffer("Key not found: ").append(str).toString());
        }
        String str2 = (String) m702Z;
        if (str2.indexOf(46) != -1) {
            str2 = str2.substring(0, str2.indexOf(46));
        }
        return Integer.parseInt(str2);
    }

    public final String m704ab(String str) {
        Object m702Z = m702Z(str);
        if (m702Z == null) {
            throw new Exception(new StringBuffer("Key not found: ").append(str).toString());
        }
        return m702Z.toString();
    }

    public final C0284ak[] m705ac(String str) {
        Object m702Z = m702Z(str);
        if (m702Z == null) {
            throw new Exception(new StringBuffer("Key not found: ").append(str).toString());
        }
        Object[] objArr = (Object[]) m702Z;
        C0284ak[] c0284akArr = new C0284ak[objArr.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= objArr.length) {
                return c0284akArr;
            }
            c0284akArr[i2] = (C0284ak) objArr[i2];
            i = i2 + 1;
        }
    }

    public final void m706g(String str, Object obj) {
        int m696Y = m696Y(str);
        if (m696Y != -1) {
            this.f504vU[m696Y] = obj;
            return;
        }
        this.f503vT[this.f505vV] = str;
        this.f504vU[this.f505vV] = obj;
        this.f505vV++;
        if (this.f505vV == this.f503vT.length) {
            String[] strArr = new String[this.f505vV + 5];
            Object[] objArr = new Object[this.f505vV + 5];
            System.arraycopy(this.f503vT, 0, strArr, 0, this.f505vV);
            System.arraycopy(this.f504vU, 0, objArr, 0, this.f505vV);
            this.f503vT = strArr;
            this.f504vU = objArr;
        }
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{");
        for (int i = 0; i < this.f505vV; i++) {
            m698a(stringBuffer, this.f503vT[i]);
            stringBuffer.append(": ");
            Object obj = this.f504vU[i];
            if (obj.getClass().isArray()) {
                Object[] objArr = (Object[]) obj;
                stringBuffer.append("[");
                for (int i2 = 0; i2 < objArr.length; i2++) {
                    m698a(stringBuffer, objArr[i2]);
                    if (i2 < objArr.length - 1) {
                        stringBuffer.append(", ");
                    }
                }
                stringBuffer.append("]");
            } else {
                m698a(stringBuffer, obj);
            }
            if (i < this.f505vV - 1) {
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append("}");
        return stringBuffer.toString();
    }
}
