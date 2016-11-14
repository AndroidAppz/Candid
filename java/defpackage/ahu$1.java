package defpackage;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class ahu$1 extends Handler {
    final /* synthetic */ ahu a;

    ahu$1(ahu ahu, Looper looper) {
        this.a = ahu;
        super(looper);
    }

    public void handleMessage(Message message) {
        this.a.a(message);
    }
}
