package p009b.p010a.p015d;

final class RunnableC0093b implements Runnable {
    private AbstractActivityC0092a alR;

    RunnableC0093b(AbstractActivityC0092a abstractActivityC0092a) {
        this.alR = abstractActivityC0092a;
    }

    @Override
    public final void run() {
        if (AbstractActivityC0092a.akT) {
            return;
        }
        this.alR.getWindow().setFlags(128, 128);
        AbstractActivityC0092a.akT = true;
    }
}
