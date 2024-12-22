package p009b.p010a.p013c;

import android.media.SoundPool;
import com.gameloft.android.wrapper.C0355i;
import java.util.ArrayList;

public final class C0089j implements SoundPool.OnLoadCompleteListener, InterfaceC0081b, InterfaceC0084e {
    private static int akB = 10;
    private static int akC = 100;
    private static long akD = 1000;
    private static ArrayList<C0089j> akE = new ArrayList<>();
    public static SoundPool akF = new SoundPool(akB, 3, akC);
    private static boolean akr = false;
    private boolean akG;
    private int akH;
    public boolean akx;
    private String aky;
    private int akt = 0;
    public ArrayList<Integer> akI = new ArrayList<>();
    public int akJ = 0;
    public int akw = 0;
    private boolean akv = false;

    protected C0089j(String str) {
        this.akG = false;
        this.akH = 0;
        if (!this.akG) {
            akF.setOnLoadCompleteListener(this);
            this.akG = true;
        }
        this.aky = str;
        this.akH = akF.load(C0355i.getContext().getFilesDir() + "/" + str, 1);
        akE.add(this);
    }

    public static void release() {
        try {
            akF.release();
        } catch (Exception e) {
        }
        akF = null;
    }

    @Override
    public final void close() {
        try {
            this.akv = false;
            akF.unload(this.akH);
            this.akH = 0;
            this.akI.clear();
            C0355i.getContext().deleteFile(this.aky);
            if (C0355i.f2717Yf) {
                String str = "Deleted temp file " + this.aky;
            }
            this.akt = 0;
            akE.remove(this);
        } catch (Exception e) {
            boolean z = C0355i.f2717Yf;
        }
    }

    @Override
    public final InterfaceC0078a mo197dh(String str) {
        if ("VolumeControl".equals(str)) {
            return new C0091l(this);
        }
        if ("RateControl".equals(str)) {
            return new C0090k(this, this);
        }
        return null;
    }

    @Override
    public final void mo201fm(int i) {
        if (!this.akv || (i <= 1 && i >= 0)) {
            if (i > 1 || i < 0) {
                this.akv = true;
            } else {
                this.akv = false;
            }
        }
    }

    @Override
    public final int getState() {
        if (this.akH != 0) {
            return this.akt;
        }
        return 0;
    }

    @Override
    public final long mo202k(long j) {
        return 0L;
    }

    @Override
    public final void onLoadComplete(SoundPool soundPool, int i, int i2) {
        for (int i3 = 0; i3 < akE.size(); i3++) {
            if (akE.get(i3).akH == i) {
                String str = "LoadCompleted sampleId:" + i + " current player:" + akE.get(i3).akH + " status:" + i2;
                if (i2 == 0) {
                    akE.get(i3).akt = 300;
                } else {
                    akE.get(i3).akt = 0;
                }
            }
        }
    }

    @Override
    public final void start() {
        if (this.akH == 0) {
            boolean z = C0355i.f2717Yf;
            return;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            while (this.akt < 300 && System.currentTimeMillis() - currentTimeMillis < akD) {
            }
            if (this.akt < 300) {
                throw new Exception("error for loading");
            }
            this.akI.add(new Integer(akF.play(this.akH, 1.0f, 1.0f, 1, this.akv ? -1 : 0, 1.0f)));
            this.akt = 400;
        } catch (Exception e) {
            if (C0355i.f2717Yf) {
                String str = "Player has not been Prefetched at " + e.toString();
            }
        }
    }

    @Override
    public final void stop() {
        int i = 0;
        this.akv = false;
        while (true) {
            int i2 = i;
            if (i2 >= this.akI.size()) {
                return;
            }
            akF.stop(this.akI.get(i2).intValue());
            i = i2 + 1;
        }
    }

    @Override
    public final void mo203u(int i, int i2, int i3) {
        float f = i / 100.0f;
        float f2 = i3 / 100000.0f;
        if (this.akH == 0) {
            boolean z = C0355i.f2717Yf;
            return;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            while (this.akt < 300 && System.currentTimeMillis() - currentTimeMillis < akD) {
            }
            if (this.akt < 300) {
                throw new Exception("error for loading");
            }
            this.akI.add(new Integer(akF.play(this.akH, f, f, i2, this.akv ? -1 : 0, f2)));
            this.akt = 400;
        } catch (Exception e) {
            if (C0355i.f2717Yf) {
                String str = "Player has not been Prefetched at " + e.toString();
            }
        }
    }

    @Override
    public final void mo204ut() {
    }

    @Override
    public final void mo205uu() {
        try {
            akF.unload(this.akH);
            this.akH = 0;
            this.akI.clear();
            this.akv = false;
            this.akt = 0;
            akE.remove(this);
        } catch (Exception e) {
            boolean z = C0355i.f2717Yf;
        }
    }

    @Override
    public final long mo206uv() {
        return 0L;
    }
}
