package p009b.p010a.p013c;

import android.content.Context;
import android.media.MediaPlayer;
import com.gameloft.android.wrapper.C0355i;
import java.io.FileInputStream;

public final class C0085f implements InterfaceC0081b, InterfaceC0084e {
    public static boolean akr = false;
    private static boolean aks = false;
    public MediaPlayer aku;
    public boolean akx;
    private String aky;
    public int akt = 0;
    private boolean akv = false;
    public int akw = 0;

    protected C0085f(String str) {
        this.aku = null;
        this.aky = str;
        this.aku = new MediaPlayer();
        this.aku.setOnCompletionListener(new C0086g(this));
        this.aku.setOnErrorListener(new C0087h(this));
        try {
            this.aku.setDataSource(C0355i.getContext().openFileInput(str).getFD());
        } catch (Exception e) {
            String str2 = "WRAPPER: Player error" + e.toString();
        }
    }

    public static void m207v(Context context) {
        try {
            String[] fileList = context.fileList();
            if (fileList != null) {
                for (int i = 0; i < fileList.length; i++) {
                    String str = "file found: " + fileList[i];
                    String str2 = fileList[i];
                    if (str2 != null && str2.endsWith(".tmp") && context.deleteFile(str2)) {
                        String str3 = "Cleaning temp file " + str2;
                    }
                }
            }
        } catch (Exception e) {
            String str4 = "Error while cleaning temp files: " + e;
            e.printStackTrace();
        }
    }

    @Override
    public final void close() {
        try {
            this.akv = false;
            this.aku.reset();
            this.aku.release();
            this.akt = 0;
            C0355i.getContext().deleteFile(this.aky);
            if (C0355i.f2717Yf) {
                String str = "Deleted temp file " + this.aky;
            }
        } catch (Exception e) {
            boolean z = C0355i.f2717Yf;
        }
    }

    @Override
    public final InterfaceC0078a mo197dh(String str) {
        if ("VolumeControl".equals(str)) {
            return new C0088i(this);
        }
        return null;
    }

    @Override
    public final void mo201fm(int i) {
        if (!this.akv || (i <= 1 && i >= 0)) {
            if (i <= 1 && i >= 0) {
                this.akv = false;
            } else {
                this.akv = true;
                this.aku.setLooping(true);
            }
        }
    }

    @Override
    public final int getState() {
        if (this.aku != null) {
            return this.akt;
        }
        return 0;
    }

    @Override
    public final long mo202k(long j) {
        try {
            this.aku.seekTo(0);
            return 0L;
        } catch (Exception e) {
            boolean z = C0355i.f2717Yf;
            return 0L;
        }
    }

    @Override
    public final void start() {
        if (akr) {
            return;
        }
        if (this.aku == null) {
            boolean z = C0355i.f2717Yf;
            return;
        }
        try {
            if (this.akt < 300) {
                mo204ut();
            }
            this.aku.start();
            this.akt = 400;
        } catch (Exception e) {
            boolean z2 = C0355i.f2717Yf;
        }
    }

    @Override
    public final void stop() {
        this.akv = false;
        if (this.aku.isPlaying()) {
            this.aku.pause();
            this.aku.seekTo(0);
        } else {
            this.aku.reset();
            try {
                FileInputStream openFileInput = C0355i.getContext().openFileInput(this.aky);
                this.aku.setDataSource(openFileInput.getFD());
                openFileInput.close();
            } catch (Exception e) {
                boolean z = C0355i.f2717Yf;
            }
            try {
                this.aku.prepare();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        this.akt = 300;
    }

    @Override
    public final void mo203u(int i, int i2, int i3) {
    }

    @Override
    public final void mo204ut() {
        try {
            this.aku.prepare();
            this.akt = 300;
        } catch (Exception e) {
            boolean z = C0355i.f2717Yf;
        }
    }

    @Override
    public final void mo205uu() {
        try {
            this.aku.reset();
            this.aku.release();
            this.akv = false;
            this.akt = 0;
        } catch (Exception e) {
            boolean z = C0355i.f2717Yf;
        }
    }

    @Override
    public final long mo206uv() {
        return this.aku.getCurrentPosition();
    }
}
