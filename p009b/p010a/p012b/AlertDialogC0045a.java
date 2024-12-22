package p009b.p010a.p012b;

import android.app.AlertDialog;
import com.gameloft.android.wrapper.C0351e;
import p009b.p010a.p015d.AbstractActivityC0092a;

public final class AlertDialogC0045a extends AlertDialog {
    public Boolean ain;

    @Override
    public final void cancel() {
        C0351e.m2180b(this);
        this.ain = null;
        super.cancel();
    }

    @Override
    public final void dismiss() {
        C0351e.m2180b(this);
        this.ain = null;
        super.dismiss();
    }

    @Override
    public final void hide() {
        C0351e.m2180b(this);
        this.ain = null;
        super.hide();
    }

    @Override
    public final void onWindowFocusChanged(boolean z) {
        String str = "AlerDialog onWindowFocusChanged: " + z;
        super.onWindowFocusChanged(z);
        if (C0351e.f2700XP != z) {
            if (!C0351e.m2182c(this)) {
                Boolean bool = new Boolean(z);
                this.ain = bool;
                C0351e.m2181b(this, bool);
            } else {
                Boolean bool2 = new Boolean(z);
                this.ain = bool2;
                C0351e.m2181b(this, bool2);
                AbstractActivityC0092a.akM.onWindowFocusChanged(z);
            }
        }
    }

    @Override
    public final void show() {
        Boolean bool = new Boolean(true);
        this.ain = bool;
        C0351e.m2178a(this, bool);
        C0351e.f2700XP = true;
        String str = "AlerDialog show: " + C0351e.f2700XP;
        super.show();
    }
}
