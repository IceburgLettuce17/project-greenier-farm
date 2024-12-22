package p009b.p010a.p012b;

import android.app.Dialog;
import android.content.Context;
import com.gameloft.android.wrapper.C0351e;
import p009b.p010a.p015d.AbstractActivityC0092a;

public class DialogC0064m extends Dialog {
    public Boolean ain;

    public DialogC0064m(Context context) {
        super(context);
        this.ain = new Boolean(false);
        C0351e.m2177a(this);
    }

    @Override
    public void cancel() {
        C0351e.m2180b(this);
        this.ain = null;
        super.cancel();
    }

    @Override
    public void dismiss() {
        C0351e.m2180b(this);
        this.ain = null;
        super.dismiss();
    }

    @Override
    public void hide() {
        C0351e.m2180b(this);
        this.ain = null;
        super.hide();
    }

    @Override
    public void onWindowFocusChanged(boolean z) {
        String str = "Dialog onWindowFocusChanged: " + z;
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
    public void show() {
        Boolean bool = new Boolean(true);
        this.ain = bool;
        C0351e.m2178a(this, bool);
        C0351e.f2700XP = true;
        String str = "Dialog show: " + C0351e.f2700XP;
        super.show();
    }
}
