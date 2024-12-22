package p009b.p010a.p012b;

import p009b.p010a.p015d.AbstractActivityC0092a;

final class RunnableC0055d implements Runnable {
    private AbstractC0054c aiK;

    RunnableC0055d(AbstractC0054c abstractC0054c) {
        this.aiK = abstractC0054c;
    }

    @Override
    public final void run() {
        while (AbstractActivityC0092a.isLocked()) {
            try {
                Thread.sleep(300L);
            } catch (Exception e) {
            }
        }
        if (this.aiK.aiD) {
            this.aiK.mo148aS();
        } else {
            this.aiK.mo149aT();
        }
        this.aiK.aiC = false;
        this.aiK.aiD = false;
        this.aiK.postInvalidate();
        AbstractC0054c.aiB = 1;
    }
}
