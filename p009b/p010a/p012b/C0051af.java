package p009b.p010a.p012b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import com.gameloft.android.wrapper.C0355i;
import java.io.InputStream;

public final class C0051af {
    private static boolean aki = false;
    public static boolean akj = false;
    private Bitmap akk;
    private C0048ac akl;
    private int akm;

    private C0051af(Bitmap bitmap) {
        this.akk = bitmap;
        bitmap.getWidth();
        bitmap.getHeight();
    }

    public static C0051af m120a(InputStream inputStream, int i, int i2) {
        Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeStream, i, i2, true);
        if (decodeStream == createScaledBitmap) {
            return new C0051af(decodeStream);
        }
        if (decodeStream != null && !decodeStream.isRecycled()) {
            try {
                decodeStream.recycle();
            } catch (Exception e) {
            }
        }
        return new C0051af(createScaledBitmap);
    }

    public static C0051af m121aX(int i, int i2) {
        return new C0051af(Bitmap.createBitmap(i, i2, akj ? Bitmap.Config.RGB_565 : Bitmap.Config.ARGB_8888));
    }

    public static void m122b(boolean z, boolean z2) {
        akj = z;
        aki = false;
    }

    public static C0051af m123h(InputStream inputStream) {
        return new C0051af(BitmapFactory.decodeStream(inputStream));
    }

    public final void m124a(int[] iArr, int i, int i2, int i3, int i4, int i5, int i6) {
        this.akk.getPixels(iArr, 0, i2, 0, 0, i5, i6);
    }

    public final C0048ac m125cb() {
        if (!this.akk.isMutable()) {
            throw new IllegalStateException();
        }
        if (this.akl == null) {
            this.akl = new C0048ac(new Canvas(this.akk));
        } else if (this.akm > 0) {
            this.akl.akg.restoreToCount(this.akm);
        }
        this.akm = this.akl.akg.save();
        return this.akl;
    }

    public final boolean equals(Object obj) {
        boolean equals = super.equals(obj);
        if (aki && obj == "freeBitmap" && this.akk != null && !this.akk.isRecycled()) {
            try {
                this.akk.recycle();
                this.akk = null;
            } catch (Exception e) {
                if (C0355i.f2717Yf) {
                    e.printStackTrace();
                }
                this.akk = null;
            }
        }
        return equals;
    }

    public final Bitmap getBitmap() {
        return this.akk;
    }

    public final void recycle() {
        if (this.akk == null || this.akk.isRecycled()) {
            return;
        }
        try {
            this.akk.recycle();
            this.akk = null;
        } catch (Exception e) {
            if (C0355i.f2717Yf) {
                e.printStackTrace();
            }
            this.akk = null;
        }
    }
}
