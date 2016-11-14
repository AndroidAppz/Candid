package defpackage;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;

/* compiled from: LocalBroadcastManager */
class bn$b {
    final IntentFilter a;
    final BroadcastReceiver b;
    boolean c;

    bn$b(IntentFilter _filter, BroadcastReceiver _receiver) {
        this.a = _filter;
        this.b = _receiver;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder(128);
        builder.append("Receiver{");
        builder.append(this.b);
        builder.append(" filter=");
        builder.append(this.a);
        builder.append("}");
        return builder.toString();
    }
}
