package defpackage;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: LocalBroadcastManager */
class bn$1 extends Handler {
    final /* synthetic */ bn a;

    bn$1(bn bnVar, Looper x0) {
        this.a = bnVar;
        super(x0);
    }

    public void handleMessage(Message msg) {
        switch (msg.what) {
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                this.a.a();
                return;
            default:
                super.handleMessage(msg);
                return;
        }
    }
}
