package p009b.p018b.p019a;

import android.telephony.SmsManager;
import p009b.p010a.p011a.InterfaceC0035a;

public class C0107b implements InterfaceC0035a {
    String ama;

    public C0107b(String str) {
        this.ama = "";
        this.ama = str;
    }

    public void m238a(InterfaceC0106a interfaceC0106a) {
        InterfaceC0106a interfaceC0106a2 = interfaceC0106a;
        String str = "SENDING SMS address: " + interfaceC0106a2.getAddress() + " msg: " + interfaceC0106a2.mo237uF();
        SmsManager.getDefault().sendTextMessage(interfaceC0106a2.getAddress(), null, interfaceC0106a2.mo237uF(), null, null);
    }

    @Override
    public void close() {
    }

    public InterfaceC0106a m239dm(String str) {
        if (str.equalsIgnoreCase("text")) {
            C0108c c0108c = new C0108c();
            c0108c.setAddress(this.ama);
            return c0108c;
        }
        if (str.equalsIgnoreCase("binary") || str.equalsIgnoreCase("multipart")) {
        }
        return null;
    }
}
