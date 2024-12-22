package p009b.p010a.p013c;

import android.media.MediaPlayer;
import com.facebook.widget.PlacePickerFragment;

final class C0087h implements MediaPlayer.OnErrorListener {
    private C0085f akz;

    C0087h(C0085f c0085f) {
        this.akz = c0085f;
    }

    @Override
    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        switch (i) {
            case PlacePickerFragment.DEFAULT_RESULTS_LIMIT:
                if (mediaPlayer != null) {
                    this.akz.aku.release();
                }
                this.akz.aku = new MediaPlayer();
                return true;
            default:
                return false;
        }
    }
}
