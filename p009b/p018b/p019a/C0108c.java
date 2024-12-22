package p009b.p018b.p019a;

public final class C0108c implements InterfaceC0106a {
    private String ama = "";
    private String amb = "";

    @Override
    public final void mo236dl(String str) {
        this.amb = str;
    }

    @Override
    public final String getAddress() {
        return this.ama;
    }

    @Override
    public final void setAddress(String str) {
        this.ama = str.substring(str.lastIndexOf("/") + 1);
    }

    @Override
    public final String mo237uF() {
        return this.amb;
    }
}
