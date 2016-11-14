package defpackage;

import android.os.Handler.Callback;
import android.os.Message;

/* compiled from: GifFrameLoader */
class oj$c implements Callback {
    final /* synthetic */ oj a;

    private oj$c(oj ojVar) {
        this.a = ojVar;
    }

    public boolean handleMessage(Message msg) {
        if (msg.what == 1) {
            this.a.a(msg.obj);
            return true;
        }
        if (msg.what == 2) {
            jp.a((oj$a) msg.obj);
        }
        return false;
    }
}
