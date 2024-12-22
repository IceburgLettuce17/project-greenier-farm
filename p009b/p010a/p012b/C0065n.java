package p009b.p010a.p012b;

import com.gameloft.android.wrapper.C0355i;
import p009b.p010a.p015d.AbstractActivityC0092a;

public final class C0065n {
    private static boolean aiT = false;
    private static AbstractC0067p aiU = null;
    private static C0065n aiV = null;
    public static boolean aiX = true;
    AbstractActivityC0092a aiW;

    public static C0065n m161b(AbstractActivityC0092a abstractActivityC0092a) {
        if (aiV == null) {
            aiV = new C0065n();
        }
        aiV.aiW = abstractActivityC0092a;
        return aiV;
    }

    public static AbstractC0067p m162ue() {
        return aiU;
    }

    public final void m164a(AbstractC0067p abstractC0067p) {
        AbstractC0067p abstractC0067p2 = aiU;
        if (abstractC0067p != null) {
            aiU = abstractC0067p;
            this.aiW.runOnUiThread(new RunnableC0066o(this));
        }
        if (abstractC0067p2 != null) {
            ((AbstractActivityC0092a) C0355i.getContext()).closeOptionsMenu();
        }
    }
}
