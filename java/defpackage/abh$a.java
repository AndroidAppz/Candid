package defpackage;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.Status;

final class abh$a extends Handler {
    final /* synthetic */ abh a;

    public void handleMessage(Message message) {
        switch (message.what) {
            case zu.GOOGLE_PLAY_SERVICES_VERSION_CODE /*?: ONE_ARG  (wrap: int
  0x0001: INVOKE  (r0_0 int) =  zu.zzqZ():int type: STATIC)*/:
                xa xaVar = (xa) message.obj;
                synchronized (this.a.e) {
                    if (xaVar == null) {
                        this.a.b.a(new Status(13, "Transform returned null"));
                    } else if (xaVar instanceof abg) {
                        this.a.b.a(((abg) xaVar).b());
                    } else {
                        this.a.b.a(xaVar);
                    }
                }
                return;
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                RuntimeException runtimeException = (RuntimeException) message.obj;
                String str = "TransformedResultImpl";
                String str2 = "Runtime exception on the transformation worker thread: ";
                String valueOf = String.valueOf(runtimeException.getMessage());
                Log.e(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                throw runtimeException;
            default:
                Log.e("TransformedResultImpl", "TransformationResultHandler received unknown message type: " + message.what);
                return;
        }
    }
}
