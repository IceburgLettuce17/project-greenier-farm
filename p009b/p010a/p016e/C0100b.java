package p009b.p010a.p016e;

import com.gameloft.android.wrapper.C0355i;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Vector;
import java.util.zip.CRC32;
import p009b.p010a.p015d.AbstractActivityC0092a;

public final class C0100b {
    private static Vector alY = new Vector();
    private String alT;
    private int alU;
    private int alV = 0;
    private int alW = 0;
    private int alX = 0;

    private C0100b() {
        this.alT = null;
        this.alU = 0;
        this.alT = new String("game2.sav");
        try {
            FileInputStream openFileInput = C0355i.getContext().openFileInput(this.alT);
            this.alU = (byte) openFileInput.read();
            openFileInput.close();
        } catch (Exception e) {
            try {
                FileOutputStream openFileOutput = C0355i.getContext().openFileOutput(this.alT, 2);
                openFileOutput.write(0);
                this.alU = 0;
                openFileOutput.close();
            } catch (Exception e2) {
                boolean z = C0355i.f2717Yf;
            }
            boolean z2 = C0355i.f2717Yf;
        }
    }

    private C0100b(String str, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        this.alT = null;
        this.alU = 0;
        String replace = str.replace('/', 'S');
        this.alT = new String(replace);
        if (AbstractActivityC0092a.alu && !AbstractActivityC0092a.alv) {
            int size = alY.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    z3 = false;
                    break;
                } else if (this.alT.equals((String) alY.elementAt(i))) {
                    z3 = true;
                    break;
                } else {
                    try {
                        i++;
                    } catch (Exception e) {
                        String str2 = "Record " + e.getMessage();
                    }
                }
            }
            if (!z3) {
                alY.addElement(this.alT);
                FileOutputStream openFileOutput = C0355i.getContext().openFileOutput("Demo_RecordAllsNames", 2);
                int size2 = alY.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str3 = (String) alY.elementAt(i2);
                    int length = str3.length();
                    openFileOutput.write(new byte[]{(byte) length, (byte) (length >> 8)}, 0, 2);
                    byte[] bytes = str3.getBytes();
                    openFileOutput.write(bytes, 0, bytes.length);
                }
                openFileOutput.close();
            }
        }
        try {
            FileInputStream openFileInput = C0355i.getContext().openFileInput(this.alT);
            this.alU = (byte) openFileInput.read();
            openFileInput.close();
        } catch (Exception e2) {
            try {
                if (z) {
                    FileOutputStream openFileOutput2 = C0355i.getContext().openFileOutput(this.alT, 2);
                    openFileOutput2.write(0);
                    this.alU = 0;
                    openFileOutput2.close();
                    z2 = false;
                } else {
                    if (C0355i.f2717Yf) {
                        String str4 = "RMS doesnt exist and will not be created. try openRecordstore(" + replace + ",   true  ) to force creation";
                    }
                    z2 = true;
                }
            } catch (Exception e3) {
                boolean z5 = C0355i.f2717Yf;
                z2 = false;
            }
            boolean z6 = C0355i.f2717Yf;
            z4 = z2;
        }
        if (z4) {
            throw new C0103e();
        }
    }

    private static void m220P(String str, String str2) {
        try {
            FileInputStream openFileInput = C0355i.getContext().openFileInput(str);
            FileOutputStream openFileOutput = C0355i.getContext().openFileOutput(str2, 2);
            while (true) {
                int available = openFileInput.available();
                if (available == 0) {
                    openFileOutput.close();
                    openFileInput.close();
                    return;
                } else {
                    byte[] bArr = new byte[available];
                    openFileInput.read(bArr);
                    openFileOutput.write(bArr);
                }
            }
        } catch (Exception e) {
            String str3 = "RECORDSORE: CopyFileException " + e.toString();
        }
    }

    private static int m221a(FileInputStream fileInputStream) {
        byte[] bArr = new byte[4];
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) fileInputStream.read();
        }
        return ((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255);
    }

    private void m222a(int i, byte[] bArr, int i2, int i3) {
        if (AbstractActivityC0092a.alu && AbstractActivityC0092a.alv) {
            return;
        }
        int m225fr = m225fr(i);
        try {
            FileOutputStream openFileOutput = C0355i.getContext().openFileOutput(this.alT + "_" + i + "_CRC" + m225fr, 2);
            CRC32 crc32 = new CRC32();
            crc32.update(bArr, 0, i3);
            openFileOutput.write(m228l(crc32.getValue()));
            openFileOutput.close();
        } catch (Exception e) {
            String str = "RECORDSTORE error CRC:recordName:" + this.alT;
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                fileOutputStream = C0355i.getContext().openFileOutput(this.alT + "_" + i + "_saved" + m225fr, 2);
                fileOutputStream.write(i);
                this.alW = i3;
                fileOutputStream.write(new byte[]{this.alW >> 24, (byte) (this.alW >> 16), (byte) (this.alW >> 8), (byte) this.alW});
                fileOutputStream.write(bArr, i2, i3);
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e2) {
                    }
                }
            } catch (Exception e3) {
                throw e3;
            }
        } catch (Throwable th) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e4) {
                }
            }
            throw th;
        }
    }

    private int m223aY(int i, int i2) {
        int i3 = 0;
        for (int i4 = this.alX + 1; i4 < this.alX + 20 && C0355i.getContext().getFileStreamPath(this.alT + "_" + i + "_CRC" + i4).exists(); i4++) {
            i3++;
        }
        if (i3 - i2 < 0) {
            return 0;
        }
        return i3 + i2;
    }

    public static void m224dk(String str) {
        int i = 0;
        C0100b m227g = m227g(str, false);
        if (m227g != null) {
            try {
                m227g.m230uE();
            } catch (Exception e) {
                if (C0355i.f2717Yf) {
                    String str2 = "error deleting recordStore - " + e.toString();
                }
            }
            while (true) {
                int i2 = i;
                if (i2 < m227g.alU) {
                    int i3 = i2 + 1;
                    for (int i4 = 1; i4 < m227g.alX + 20; i4++) {
                        try {
                            if (C0355i.getContext().getFileStreamPath(m227g.alT + "_" + i3 + "_saved" + i4).exists()) {
                                C0355i.getContext().getFileStreamPath(m227g.alT + "_" + i3 + "_saved" + i4).delete();
                            }
                            if (C0355i.getContext().getFileStreamPath(m227g.alT + "_" + i3 + "_CRC" + i4).exists()) {
                                C0355i.getContext().deleteFile(m227g.alT + "_" + i3 + "_CRC" + i4);
                            }
                        } catch (Exception e2) {
                            try {
                                String str3 = "Can't delete file " + m227g.alT + "_" + i3;
                                throw new C0101c();
                            } catch (Exception e3) {
                                if (C0355i.f2717Yf) {
                                    String str4 = "error deleting record " + (i2 + 1) + " - " + e3.toString();
                                }
                            }
                        }
                    }
                    if (!C0355i.getContext().getFileStreamPath(m227g.alT + "_" + i3).delete()) {
                        String str5 = "Can't delete file " + m227g.alT + "_" + i3;
                        throw new C0101c();
                    }
                    continue;
                    i = i2 + 1;
                }
                try {
                    if (C0355i.getContext().getFileStreamPath(m227g.alT).delete()) {
                        return;
                    }
                    String str6 = "Can't delete file " + m227g.alT;
                    throw new C0101c();
                } catch (Exception e4) {
                    String str7 = "Can't delete file " + m227g.alT;
                    throw new C0101c();
                }
            }
        }
    }

    private int m225fr(int i) {
        int i2 = 0;
        try {
            byte[] bArr = new byte[8];
            int i3 = this.alX;
            while (true) {
                i3++;
                if (i3 >= this.alX + 20) {
                    break;
                }
                i2++;
                if (!C0355i.getContext().getFileStreamPath(this.alT + "_" + i + "_CRC" + i3).exists()) {
                    break;
                }
                FileInputStream openFileInput = C0355i.getContext().openFileInput(this.alT + "_" + i + "_CRC" + i3);
                if (openFileInput.read(bArr, 0, 8) != 8) {
                    break;
                }
                openFileInput.close();
            }
        } catch (Exception e) {
        }
        if (i2 >= this.alX + 20) {
            this.alX++;
        }
        return i2;
    }

    private void m226fs(int i) {
        for (int i2 = 1; i2 < this.alX + 20; i2++) {
            try {
                if (C0355i.getContext().getFileStreamPath(this.alT + "_" + i + "_CRC" + i2).exists()) {
                    C0355i.getContext().deleteFile(this.alT + "_" + i + "_CRC" + i2);
                }
            } catch (Exception e) {
                String str = "no exist  " + e.toString();
            }
        }
        for (int i3 = 1; i3 < this.alX + 20; i3++) {
            try {
                if (C0355i.getContext().getFileStreamPath(this.alT + "_" + i + "_saved" + i3).exists()) {
                    C0355i.getContext().deleteFile(this.alT + "_" + i + "_saved" + i3);
                }
            } catch (Exception e2) {
                String str2 = "no exist  " + e2.toString();
            }
        }
        this.alX = 0;
    }

    public static C0100b m227g(String str, boolean z) {
        C0100b c0100b;
        C0103e c0103e = null;
        try {
            c0100b = new C0100b(str, z);
        } catch (C0103e e) {
            boolean z2 = C0355i.f2717Yf;
            c0100b = null;
            c0103e = new C0103e();
        }
        if (c0103e == null) {
            return c0100b;
        }
        boolean z3 = C0355i.f2717Yf;
        throw c0103e;
    }

    private static byte[] m228l(long j) {
        return new byte[]{(byte) ((j >> 56) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 8) & 255), (byte) (j & 255)};
    }

    public static void m229uC() {
    }

    private void m230uE() {
        FileInputStream openFileInput = C0355i.getContext().openFileInput(this.alT);
        this.alU = 0;
        int i = this.alX;
        while (true) {
            i++;
            if (i >= this.alX + 20) {
                break;
            }
            if (C0355i.getContext().getFileStreamPath(this.alT + "_" + i).exists()) {
                this.alU++;
            } else if (C0355i.getContext().getFileStreamPath(this.alT + "_" + i + "_saved1").exists()) {
                this.alU++;
            }
        }
        String str = "RECORDSTORE: numRecordsOfRead:" + this.alU;
        if (this.alU < 0) {
            this.alU = 0;
        }
        openFileInput.close();
    }

    public final void m231b(int i, byte[] bArr, int i2, int i3) {
        try {
            try {
                m230uE();
                if (this.alU <= 0) {
                    boolean z = C0355i.f2717Yf;
                    return;
                }
                try {
                    FileOutputStream openFileOutput = C0355i.getContext().openFileOutput(this.alT, 0);
                    openFileOutput.write(this.alU);
                    openFileOutput.close();
                    m222a(1, bArr, i2, i3);
                    return;
                } catch (Exception e) {
                    if (e.toString().contains("ENOSPC")) {
                        throw new C0102d();
                    }
                    return;
                }
            } catch (Exception e2) {
                boolean z2 = C0355i.f2717Yf;
                return;
            }
        } catch (Exception e3) {
            boolean z3 = C0355i.f2717Yf;
        }
        boolean z32 = C0355i.f2717Yf;
    }

    public final int m232e(byte[] bArr, int i, int i2) {
        if (AbstractActivityC0092a.alu && AbstractActivityC0092a.alv) {
            return 0;
        }
        try {
            m230uE();
            try {
                FileOutputStream openFileOutput = C0355i.getContext().openFileOutput(this.alT, 2);
                this.alV = this.alU + 1;
                String str = "RECORDSTORE: recordNumber: " + this.alV;
                openFileOutput.write(this.alU + 1);
                openFileOutput.close();
                m222a(this.alV, bArr, i, i2);
            } catch (Exception e) {
                if (C0355i.f2717Yf) {
                    String str2 = "addRecord FAILED" + e.toString();
                }
                if (e.toString().contains("ENOSPC")) {
                    throw new C0102d();
                }
            }
            this.alU = this.alV;
            return this.alV;
        } catch (Exception e2) {
            boolean z = C0355i.f2717Yf;
            return 0;
        }
    }

    public final int m233fp(int i) {
        FileInputStream fileInputStream = null;
        try {
            if (C0355i.getContext().getFileStreamPath(this.alT + "_1_saved" + m223aY(1, 0)).exists()) {
                fileInputStream = C0355i.getContext().openFileInput(this.alT + "_1_saved" + m223aY(1, 0));
            } else if (C0355i.getContext().getFileStreamPath(this.alT + "_1").exists()) {
                fileInputStream = C0355i.getContext().openFileInput(this.alT + "_1");
            }
            fileInputStream.read();
            int m221a = m221a(fileInputStream);
            fileInputStream.close();
            return m221a;
        } catch (Exception e) {
            throw new C0103e();
        }
    }

    public final byte[] m234fq(int i) {
        int m223aY = m223aY(i, 0);
        int i2 = this.alX;
        while (true) {
            i2++;
            if (i2 >= this.alX + 20 || m223aY <= 0) {
                break;
            }
            if (C0355i.getContext().getFileStreamPath(this.alT + "_" + i + "_saved" + m223aY).exists()) {
                try {
                    FileInputStream openFileInput = C0355i.getContext().openFileInput(this.alT + "_" + i + "_saved" + m223aY);
                    CRC32 crc32 = new CRC32();
                    this.alV = (byte) openFileInput.read();
                    this.alW = m221a(openFileInput);
                    byte[] bArr = new byte[this.alW];
                    openFileInput.read(bArr, 0, this.alW);
                    openFileInput.close();
                    crc32.update(bArr);
                    FileInputStream openFileInput2 = C0355i.getContext().openFileInput(this.alT + "_" + i + "_CRC" + m223aY);
                    byte[] bArr2 = new byte[8];
                    openFileInput2.read(bArr2, 0, 8);
                    openFileInput2.close();
                    byte[] m228l = m228l(crc32.getValue());
                    boolean z = true;
                    for (int i3 = 0; i3 < bArr2.length; i3++) {
                        if (bArr2[i3] != m228l[i3]) {
                            z = false;
                        }
                    }
                    if (z) {
                        m220P(this.alT + "_" + i + "_saved" + m223aY, this.alT + "_" + i);
                        m226fs(i);
                        return bArr;
                    }
                    continue;
                } catch (Exception e) {
                    if (C0355i.f2717Yf) {
                        String str = "e=" + e.toString();
                    }
                }
            }
            m223aY = m223aY(i, -i2);
        }
    }

    public final int m235uD() {
        if (AbstractActivityC0092a.alu && AbstractActivityC0092a.alv) {
            return 0;
        }
        try {
            m230uE();
            return this.alU;
        } catch (Exception e) {
            e.toString();
            throw new C0104f();
        }
    }
}
