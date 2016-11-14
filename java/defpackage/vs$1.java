package defpackage;

import android.os.Handler;
import android.os.Message;

/* compiled from: PlatformServiceClient */
class vs$1 extends Handler {
    final /* synthetic */ vs a;

    vs$1(vs this$0) {
        this.a = this$0;
    }

    public void handleMessage(Message message) {
        this.a.a(message);
    }
}
