package p009b.p010a.p012b;

import android.graphics.Paint;
import android.graphics.Typeface;

public final class C0068q {
    private static Paint ajf;
    private byte aje;
    private static float[] ajg = {14.0f, 11.0f, 18.0f};
    private static C0068q ajj = null;
    private static Typeface[] ajh = new Typeface[8];
    private static byte[] aji = new byte[8];
    private byte ajd = 0;
    private byte ajc = 0;
    private byte ajb = 0;

    static {
        String str = null;
        for (int i = 0; i < 8; i++) {
            if ((i & 4) != 0) {
                str = "monospace";
            }
            ajh[i] = Typeface.create(str, i & 3);
            aji[i] = (byte) (i & 3 & (ajh[i].getStyle() ^ (-1)));
        }
        Paint paint = new Paint();
        ajf = paint;
        paint.setAntiAlias(true);
    }

    private C0068q(int i, int i2, int i3) {
        synchronized (ajf) {
            Paint m167a = m167a(ajf);
            this.aje = (byte) (Math.round(m167a.descent()) - Math.round(m167a.ascent()));
        }
    }

    public static C0068q m166uh() {
        if (ajj == null) {
            ajj = new C0068q(0, 0, 0);
        }
        return ajj;
    }

    public final Paint m167a(Paint paint) {
        int i = (this.ajc & 3) | ((this.ajd & 32) >> 3);
        byte b2 = aji[i];
        paint.setTypeface(ajh[i]);
        paint.setTextSize(ajg[this.ajb >> 3]);
        paint.setFakeBoldText((b2 & 1) != 0);
        paint.setTextSkewX((b2 & 2) == 0 ? 0.0f : 0.25f);
        return paint;
    }

    public final int m168df(String str) {
        int length = str.length();
        Paint paint = ajf;
        return Math.round(m167a(ajf).measureText(str, 0, length));
    }

    public final int getHeight() {
        return this.aje;
    }
}
