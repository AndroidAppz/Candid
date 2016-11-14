package defpackage;

import android.content.Intent;
import com.facebook.internal.CallbackManagerImpl.a;

/* compiled from: LikeDialog */
class wl$2 implements a {
    final /* synthetic */ wp a;
    final /* synthetic */ wl b;

    wl$2(wl this$0, wp wpVar) {
        this.b = this$0;
        this.a = wpVar;
    }

    public boolean a(int resultCode, Intent data) {
        return wr.a(this.b.a(), resultCode, data, this.a);
    }
}
