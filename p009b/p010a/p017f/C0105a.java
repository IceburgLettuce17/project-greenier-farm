package p009b.p010a.p017f;

import com.gameloft.android.wrapper.C0355i;
import p009b.p010a.p011a.InterfaceC0035a;

public final class C0105a implements InterfaceC0035a {
    public static InterfaceC0035a alZ;

    public C0105a() {
        if (C0355i.getContext() == null) {
            throw new RuntimeException("Utils.context is null, can't init motion sensor");
        }
        C0355i.getContext().getSystemService("sensor");
    }

    @Override
    public final void close() {
    }
}
