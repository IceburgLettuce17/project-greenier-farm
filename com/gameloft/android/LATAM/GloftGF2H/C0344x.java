package com.gameloft.android.LATAM.GloftGF2H;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class C0344x {
    public static int m2147a(InputStream inputStream, OutputStream outputStream) {
        int i;
        int i2;
        C0318br c0318br = new C0318br(inputStream, true, 0);
        C0318br c0318br2 = new C0318br(outputStream, false, 0);
        c0318br2.m896J(35615, 2);
        c0318br2.write(8);
        for (int i3 = 0; i3 < 7; i3++) {
            c0318br2.write(0);
        }
        C0285al c0285al = new C0285al(2048);
        boolean z = false;
        byte[] bArr = new byte[2048];
        while (!z) {
            int read = c0318br.read(bArr, 0, bArr.length);
            if (read < 0) {
                break;
            }
            z = read < bArr.length;
            c0285al.reset();
            c0318br2.m898L(z ? 1 : 0, 1);
            c0318br2.m898L(1, 2);
            int i4 = 0;
            int i5 = 0;
            while (i5 < read) {
                if (read - i5 > 2) {
                    short s = c0285al.f506vW[c0285al.m707aS(((bArr[i5] & 255) << 16) | 0 | ((bArr[i5 + 1] & 255) << 8) | (bArr[i5 + 2] & 255))];
                    if (s >= 0) {
                        i = c0285al.f508vY[s];
                        if (i >= 0) {
                            int i6 = i5 - i;
                            int i7 = 0;
                            while (i5 + i7 < read && (bArr[i5 + i7] & 255) == (bArr[i + i7] & 255) && i7 + 1 < 256 && i6 + i7 + 1 < 2048) {
                                i7++;
                            }
                            if (i7 > 2) {
                                C0346z.m2167d(i7, c0318br2);
                                C0346z.m2168e(i6, c0318br2);
                                i5 += i7 - 1;
                                i5++;
                            }
                        }
                        int i8 = bArr[i5] & 255;
                        i2 = i5 - 2;
                        i4 = ((i4 & 65535) << 8) | (((byte) i8) & 255);
                        if (i2 >= 0) {
                            int m707aS = c0285al.m707aS(i4);
                            if (c0285al.f506vW[m707aS] < 0 && c0285al.f509vZ != c0285al.f508vY.length) {
                                c0285al.f506vW[m707aS] = (short) c0285al.f509vZ;
                                c0285al.f507vX[c0285al.f509vZ] = i4;
                                c0285al.f508vY[c0285al.f509vZ] = i2;
                                c0285al.f509vZ++;
                            }
                        }
                        C0346z.m2166c(i8, c0318br2);
                        i5++;
                    }
                }
                i = -1;
                if (i >= 0) {
                }
                int i82 = bArr[i5] & 255;
                i2 = i5 - 2;
                i4 = ((i4 & 65535) << 8) | (((byte) i82) & 255);
                if (i2 >= 0) {
                }
                C0346z.m2166c(i82, c0318br2);
                i5++;
            }
            C0346z.m2166c(256, c0318br2);
        }
        c0318br2.m906ek();
        c0318br2.m896J(c0318br.m903eg(), 4);
        c0318br2.m896J(c0318br.getSize(), 4);
        return c0318br2.getSize();
    }

    private static void m2148a(C0318br c0318br, C0318br c0318br2) {
        int m901bh = c0318br.m901bh(5) + 257;
        int m901bh2 = c0318br.m901bh(5) + 1;
        int m901bh3 = c0318br.m901bh(4) + 4;
        char[] cArr = new char[19];
        for (int i = 0; i < m901bh3; i++) {
            cArr[C0346z.f2681vE[i]] = (char) c0318br.m901bh(3);
        }
        int[] m2163a = C0346z.m2163a(7, cArr);
        int[] m2163a2 = C0346z.m2163a(15, C0346z.m2162a(c0318br, m2163a, m901bh));
        char[] m2162a = C0346z.m2162a(c0318br, m2163a, m901bh2);
        m2149a(c0318br, c0318br2, m2163a2, (m2162a.length == 1 && m2162a[0] == 0) ? null : C0346z.m2163a(15, m2162a));
    }

    private static void m2149a(C0318br c0318br, C0318br c0318br2, int[] iArr, int[] iArr2) {
        while (true) {
            int m2161a = C0346z.m2161a(c0318br, iArr);
            if (m2161a == 256) {
                return;
            }
            if (m2161a < 256) {
                c0318br2.write(m2161a);
            } else {
                if (iArr2 == null) {
                    throw new IOException("no distance tree");
                }
                c0318br2.m897K(C0346z.m2164b(C0346z.m2161a(c0318br, iArr2), c0318br), C0346z.m2159a(m2161a, c0318br));
            }
        }
    }

    private static long m2150b(C0318br c0318br, C0318br c0318br2) {
        boolean z;
        do {
            z = c0318br.m901bh(1) != 0;
            switch (c0318br.m901bh(2)) {
                case 0:
                    c0318br.m905ej();
                    int m900bg = c0318br.m900bg(2);
                    if ((c0318br.m900bg(2) ^ m900bg) == 65535) {
                        while (true) {
                            int i = m900bg - 1;
                            if (m900bg <= 0) {
                                break;
                            } else {
                                int read = c0318br.read();
                                if (read < 0) {
                                    throw new IOException("Unexpected EOF.");
                                }
                                c0318br2.write(read);
                                m900bg = i;
                            }
                        }
                    } else {
                        throw new IOException("Invalid block.");
                    }
                case 1:
                    m2149a(c0318br, c0318br2, C0346z.f2679vC, C0346z.f2680vD);
                    break;
                case 2:
                    m2148a(c0318br, c0318br2);
                    break;
                default:
                    throw new IOException("Invalid block.");
            }
        } while (!z);
        c0318br.m905ej();
        return c0318br2.getSize();
    }

    public static C0344x m2151b(InputStream inputStream, OutputStream outputStream) {
        C0318br c0318br = new C0318br(inputStream, false, 0);
        C0318br c0318br2 = new C0318br(outputStream, true, 15);
        C0344x c0344x = new C0344x();
        c0318br.m902ef();
        if (c0318br.m900bg(2) != 35615) {
            throw new IOException("Bad magic number");
        }
        if (c0318br.m900bg(1) != 8) {
            throw new IOException("Unsupported compression method");
        }
        int m900bg = c0318br.m900bg(1);
        c0318br.m899bf(6);
        if ((m900bg & 4) != 0) {
            int m900bg2 = c0318br.m900bg(2);
            while (true) {
                int i = m900bg2 - 1;
                if (m900bg2 <= 0) {
                    break;
                }
                c0318br.read();
                m900bg2 = i;
            }
        }
        if ((m900bg & 8) != 0) {
            c0318br.m904ei();
        }
        if ((m900bg & 16) != 0) {
            c0318br.m904ei();
        }
        if ((m900bg & 2) != 0) {
            if (c0318br.m900bg(2) != (c0318br.m903eg() & 65535)) {
                throw new IOException("Header CRC check failed.");
            }
        }
        c0318br.m907r(false);
        c0318br2.m902ef();
        m2150b(c0318br, c0318br2);
        if (c0318br.m900bg(4) != c0318br2.m903eg()) {
            throw new IOException("CRC check failed.");
        }
        if (c0318br2.getSize() != c0318br.m900bg(4)) {
            throw new IOException("Size mismatches.");
        }
        return c0344x;
    }
}
