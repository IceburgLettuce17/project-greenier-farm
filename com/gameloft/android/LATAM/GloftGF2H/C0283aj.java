package com.gameloft.android.LATAM.GloftGF2H;

public final class C0283aj {

    private int f501vR = 0;

    private String f502vS;

    public C0283aj(String str) {
        this.f502vS = str;
    }

    private String next(int i) {
        int i2 = this.f501vR;
        int i3 = i2 + i;
        if (i3 >= this.f502vS.length()) {
            throw m695X("Substring bounds error");
        }
        this.f501vR += i;
        return this.f502vS.substring(i2, i3);
    }

    public final C0279af m695X(String str) {
        return new C0279af(new StringBuffer().append(str).append(toString()).toString());
    }

    public final void back() {
        if (this.f501vR > 0) {
            this.f501vR--;
        }
    }

    public final char next() {
        if (!(this.f501vR < this.f502vS.length())) {
            return (char) 0;
        }
        char charAt = this.f502vS.charAt(this.f501vR);
        this.f501vR++;
        return charAt;
    }

    public final char nextClean() {
        char next;
        char next2;
        while (true) {
            char next3 = next();
            if (next3 == '/') {
                switch (next()) {
                    case '*':
                        while (true) {
                            char next4 = next();
                            if (next4 == 0) {
                                throw m695X("Unclosed comment.");
                            }
                            if (next4 == '*') {
                                if (next() != '/') {
                                    back();
                                }
                            }
                        }
                        break;
                    case '/':
                        do {
                            next = next();
                            if (next != '\n' && next != '\r') {
                            }
                        } while (next != 0);
                        break;
                    default:
                        back();
                        return '/';
                }
            } else if (next3 == '#') {
                do {
                    next2 = next();
                    if (next2 != '\n' && next2 != '\r') {
                    }
                } while (next2 != 0);
            } else if (next3 == 0 || next3 > ' ') {
            }
        }
    }

    public final Object nextValue() {
        char nextClean = nextClean();
        switch (nextClean) {
            case '\"':
            case '\'':
                StringBuffer stringBuffer = new StringBuffer();
                while (true) {
                    char next = next();
                    switch (next) {
                        case 0:
                        case '\n':
                        case '\r':
                            throw m695X("Unterminated string");
                        case '\\':
                            char next2 = next();
                            switch (next2) {
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
                                case 'u':
                                    stringBuffer.append((char) Integer.parseInt(next(4), 16));
                                    break;
                                case 'x':
                                    stringBuffer.append((char) Integer.parseInt(next(2), 16));
                                    break;
                                default:
                                    stringBuffer.append(next2);
                                    break;
                            }
                        default:
                            if (next != nextClean) {
                                stringBuffer.append(next);
                                break;
                            } else {
                                return stringBuffer.toString();
                            }
                    }
                }
            case '[':
                back();
                return new C0278ae(this);
            case '{':
                back();
                return new C0280ag(this);
            default:
                StringBuffer stringBuffer2 = new StringBuffer();
                char c = nextClean;
                while (c >= ' ' && ",:]}/\\\"[{;=#".indexOf(c) < 0) {
                    stringBuffer2.append(c);
                    c = next();
                }
                back();
                String trim = stringBuffer2.toString().trim();
                if (trim.equals("")) {
                    throw m695X("Missing value.");
                }
                if (trim.toLowerCase().equals("true")) {
                    return C0280ag.TRUE;
                }
                if (trim.toLowerCase().equals("false")) {
                    return C0280ag.FALSE;
                }
                if (trim.toLowerCase().equals("null")) {
                    return C0280ag.NULL;
                }
                if ((nextClean < '0' || nextClean > '9') && nextClean != '.' && nextClean != '-' && nextClean != '+') {
                    return trim;
                }
                if (nextClean == '0') {
                    if (trim.length() <= 2 || !(trim.charAt(1) == 'x' || trim.charAt(1) == 'X')) {
                        try {
                            return new Integer(Integer.parseInt(trim, 8));
                        } catch (Exception e) {
                        }
                    } else {
                        try {
                            return new Integer(Integer.parseInt(trim.substring(2), 16));
                        } catch (Exception e2) {
                        }
                    }
                }
                try {
                    return Integer.valueOf(trim);
                } catch (Exception e3) {
                    try {
                        return new Long(Long.parseLong(trim));
                    } catch (Exception e4) {
                        return trim;
                    }
                }
        }
    }

    public final String toString() {
        return new StringBuffer(" at character ").append(this.f501vR).append(" of ").append(this.f502vS).toString();
    }
}
