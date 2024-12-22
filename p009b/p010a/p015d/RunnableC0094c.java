package p009b.p010a.p015d;

final class RunnableC0094c implements Runnable {
    private AbstractActivityC0092a alR;

    RunnableC0094c(AbstractActivityC0092a abstractActivityC0092a) {
        this.alR = abstractActivityC0092a;
    }

    @Override
    public final void run() {
        if (AbstractActivityC0092a.akT) {
            this.alR.getWindow().setFlags(0, 128);
            AbstractActivityC0092a.akT = false;
        }
    }
}
