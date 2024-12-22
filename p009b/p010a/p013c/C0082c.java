package p009b.p010a.p013c;

import com.gameloft.android.wrapper.C0355i;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.concurrent.atomic.AtomicInteger;

public final class C0082c {
    private static AtomicInteger akn = new AtomicInteger(0);
    private static Hashtable ako = new Hashtable();
    private static final byte[] akp = new byte[4096];
    private static boolean akq = false;

    private static String m198a(InputStream inputStream, int i) {
        int i2 = 0;
        String str = new String("SndDmp" + i + ".tmp");
        try {
            C0355i.getContext().openFileInput(str).close();
        } catch (Exception e) {
            FileOutputStream fileOutputStream = null;
            try {
                fileOutputStream = C0355i.getContext().openFileOutput(str, 2);
            } catch (Exception e2) {
                boolean z = C0355i.f2717Yf;
            }
            while (true) {
                try {
                    int read = inputStream.read(akp);
                    if (read < 0) {
                        break;
                    }
                    fileOutputStream.write(akp, 0, read);
                    i2 += read;
                } catch (IOException e3) {
                    boolean z2 = C0355i.f2717Yf;
                }
            }
            fileOutputStream.close();
            ako.put(str, Integer.valueOf(i2));
            String str2 = "Player file size " + i2;
        }
        return str;
    }

    public static void m199an(boolean z) {
        akq = z;
    }

    public static InterfaceC0084e m200i(InputStream inputStream) {
        String m198a = m198a(inputStream, akn.getAndIncrement());
        String str = "created temp file '" + m198a + "' for sound";
        return !akq ? new C0085f(m198a) : new C0089j(m198a);
    }
}
