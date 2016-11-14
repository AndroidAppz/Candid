package defpackage;

import android.os.Handler.Callback;
import android.os.Message;

/* compiled from: ResourceRecycler */
class lc$a implements Callback {
    private lc$a() {
    }

    public boolean handleMessage(Message message) {
        if (message.what != 1) {
            return false;
        }
        message.obj.d();
        return true;
    }
}
