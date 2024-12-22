package p001a.p004b.p005a.p007b;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;

final class C0032f {

    boolean f84az;
    final IntentFilter filter;
    final BroadcastReceiver receiver;

    C0032f(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
        this.filter = intentFilter;
        this.receiver = broadcastReceiver;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("Receiver{");
        sb.append(this.receiver);
        sb.append(" filter=");
        sb.append(this.filter);
        sb.append("}");
        return sb.toString();
    }
}
