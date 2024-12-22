package p009b.p010a.p013c;

import android.media.MediaPlayer;

final class C0086g implements MediaPlayer.OnCompletionListener {
    private C0085f akz;

    C0086g(C0085f c0085f) {
        this.akz = c0085f;
    }

    @Override
    public final void onCompletion(MediaPlayer mediaPlayer) {
        this.akz.akt = 300;
        mediaPlayer.seekTo(0);
    }
}
