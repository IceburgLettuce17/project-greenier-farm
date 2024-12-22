package p009b.p010a.p015d;

import android.widget.Toast;

final class RunnableC0095d implements Runnable {
    private AbstractActivityC0092a alR;
    private String alS;

    RunnableC0095d(AbstractActivityC0092a abstractActivityC0092a, String str) {
        this.alR = abstractActivityC0092a;
        this.alS = str;
    }

    @Override
    public final void run() {
        if (AbstractActivityC0092a.alz != null) {
            AbstractActivityC0092a.alz.cancel();
        }
        Toast makeText = Toast.makeText(this.alR.getApplicationContext(), this.alS, 0);
        AbstractActivityC0092a.alz = makeText;
        makeText.show();
    }
}
