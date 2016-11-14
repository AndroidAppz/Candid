package defpackage;

import android.app.PendingIntent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;

final class ya$d extends Handler {
    final /* synthetic */ ya a;

    public ya$d(ya yaVar, Looper looper) {
        this.a = yaVar;
        super(looper);
    }

    private void a(Message message) {
        ya$e ya_e = (ya$e) message.obj;
        ya_e.b();
        ya_e.d();
    }

    private boolean b(Message message) {
        return message.what == 2 || message.what == 1 || message.what == 5;
    }

    public void handleMessage(Message message) {
        PendingIntent pendingIntent = null;
        if (this.a.b.get() != message.arg1) {
            if (b(message)) {
                a(message);
            }
        } else if ((message.what == 1 || message.what == 5) && !this.a.c()) {
            a(message);
        } else if (message.what == 3) {
            if (message.obj instanceof PendingIntent) {
                pendingIntent = (PendingIntent) message.obj;
            }
            ConnectionResult connectionResult = new ConnectionResult(message.arg2, pendingIntent);
            this.a.p.a(connectionResult);
            this.a.a(connectionResult);
        } else if (message.what == 4) {
            this.a.b(4, null);
            if (this.a.u != null) {
                this.a.u.a(message.arg2);
            }
            this.a.a(message.arg2);
            this.a.a(4, 1, null);
        } else if (message.what == 2 && !this.a.b()) {
            a(message);
        } else if (b(message)) {
            ((ya$e) message.obj).c();
        } else {
            Log.wtf("GmsClient", "Don't know how to handle message: " + message.what, new Exception());
        }
    }
}
