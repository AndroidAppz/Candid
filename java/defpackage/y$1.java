package defpackage;

import android.os.Handler.Callback;
import android.os.Message;

/* compiled from: SnackbarManager */
class y$1 implements Callback {
    final /* synthetic */ y a;

    y$1(y yVar) {
        this.a = yVar;
    }

    public boolean handleMessage(Message message) {
        switch (message.what) {
            case zu.GOOGLE_PLAY_SERVICES_VERSION_CODE /*?: ONE_ARG  (wrap: int
  0x0001: INVOKE  (r0_0 int) =  zu.zzqZ():int type: STATIC)*/:
                this.a.b((y$b) message.obj);
                return true;
            default:
                return false;
        }
    }
}
