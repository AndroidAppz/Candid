package defpackage;

import android.os.Handler.Callback;
import android.os.Message;

/* compiled from: EngineJob */
class kv$b implements Callback {
    private kv$b() {
    }

    public boolean handleMessage(Message message) {
        if (1 != message.what && 2 != message.what) {
            return false;
        }
        kv job = message.obj;
        if (1 == message.what) {
            job.b();
            return true;
        }
        job.c();
        return true;
    }
}
