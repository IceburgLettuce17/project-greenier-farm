package p009b.p010a.p012b;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

public final class C0048ac {
    private C0068q ake;
    private int akf;
    public Canvas akg;
    private Paint akh;

    public C0048ac() {
        m113us();
    }

    public C0048ac(Canvas canvas) {
        this.akg = canvas;
        canvas.getWidth();
        canvas.getHeight();
        canvas.getWidth();
        canvas.getHeight();
        m113us();
    }

    private void m113us() {
        this.akh = new Paint();
        this.akh.setDither(false);
        this.akh.setStrokeWidth(1.0f);
        this.akh.setStrokeCap(Paint.Cap.SQUARE);
        this.ake = C0068q.m166uh();
        new RectF();
        new Path();
    }

    public final void m114a(C0068q c0068q) {
        if (c0068q == null) {
            c0068q = C0068q.m166uh();
        }
        this.ake = c0068q;
        c0068q.m167a(this.akh);
    }

    public final void m115b(String str, int i, int i2, int i3) {
        int length = str.length();
        this.akh.setTextAlign(Paint.Align.LEFT);
        int ascent = (int) (0 - this.akh.ascent());
        Paint paint = this.akh;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        this.akg.drawText(str, 0, length, 0, ascent, paint);
    }

    public final int getColor() {
        return this.akf;
    }

    public final void setColor(int i) {
        this.akf = 16777215 & i;
        this.akh.setColor((-16777216) | this.akf);
    }

    public final void m116t(int i, int i2, int i3) {
        if ((((i | i2) | i3) >> 8) != 0) {
            throw new IllegalArgumentException();
        }
        this.akf = (i << 16) | (i2 << 8) | i3;
        this.akh.setColor((-16777216) | this.akf);
    }

    public final C0068q m117ur() {
        return this.ake;
    }
}
