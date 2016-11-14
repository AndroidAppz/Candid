package defpackage;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.Status;

public class aaw$a<R extends xc> extends Handler {
    public aaw$a() {
        this(Looper.getMainLooper());
    }

    public aaw$a(Looper looper) {
        super(looper);
    }

    public void a() {
        removeMessages(2);
    }

    public void a(xd<? super R> xdVar, R r) {
        sendMessage(obtainMessage(1, new Pair(xdVar, r)));
    }

    protected void b(xd<? super R> xdVar, R r) {
        try {
            xdVar.a(r);
        } catch (RuntimeException e) {
            aaw.c((xc) r);
            throw e;
        }
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                Pair pair = (Pair) message.obj;
                b((xd) pair.first, (xc) pair.second);
                return;
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                ((aaw) message.obj).c(Status.d);
                return;
            default:
                Log.wtf("BasePendingResult", "Don't know how to handle message: " + message.what, new Exception());
                return;
        }
    }
}
