package com.gameloft.android.LATAM.GloftGF2H;

public final class C0312bl {

    private RunnableC0342v f673zV;

    private boolean f674zW;

    private String f675zX;

    private String f676zY;

    private C0314bn f677zZ;

    final void m837a(C0314bn c0314bn) {
        this.f677zZ = c0314bn;
    }

    final void m838a(boolean z, String str) {
        RunnableC0342v runnableC0342v = this.f673zV;
        this.f673zV = new RunnableC0342v();
        if (this.f675zX == null) {
            C0316bp.m884aU("SERVERCONFIG HAS NOT BEEN LOADED YET !!!!!");
            return;
        }
        String str2 = this.f675zX;
        if (z) {
            str2 = new StringBuffer().append(str2).append("/get_last_sent_package_id.php").toString();
        }
        this.f676zY = str;
        this.f673zV.m2145o(str2, this.f676zY);
        this.f674zW = false;
    }

    final void m839aQ(String str) {
        this.f675zX = str;
    }

    final void m840dD() {
        if (this.f673zV == null || this.f674zW || this.f673zV.isInProgress()) {
            return;
        }
        String str = this.f673zV.f2639dA;
        new StringBuffer("Response").append(this.f673zV.f2639dA).toString();
        if (str == null) {
            C0316bp.m884aU("RESPONSE NULL CONNECTION FAILED >>>>>>>>>>>");
            this.f677zZ.m873d(str, false);
        } else if (str.indexOf("200") != -1) {
            C0316bp.m884aU(new StringBuffer("RESPONSE OK CONNECTION SUCCESS >>>>>>>>>>> ").append(str).toString());
            this.f677zZ.m873d(str, true);
        } else {
            C0316bp.m884aU(new StringBuffer("RESPONSE FAILED >>>>>>>>>>> ").append(str).toString());
            this.f677zZ.m873d(str, false);
        }
        this.f674zW = true;
        if (this.f676zY != null) {
            this.f676zY = null;
        }
        this.f673zV.cleanup();
        this.f673zV = null;
    }
}
