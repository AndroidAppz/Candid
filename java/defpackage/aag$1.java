package defpackage;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class aag$1 extends Handler {
    final /* synthetic */ aag a;

    aag$1(aag aag, Looper looper) {
        this.a = aag;
        super(looper);
    }

    public void handleMessage(Message message) {
        this.a.a(message);
    }
}
