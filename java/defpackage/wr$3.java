package defpackage;

import android.content.Intent;
import com.facebook.internal.CallbackManagerImpl.a;

/* compiled from: ShareInternalUtility */
class wr$3 implements a {
    final /* synthetic */ int a;
    final /* synthetic */ uc b;

    wr$3(int i, uc ucVar) {
        this.a = i;
        this.b = ucVar;
    }

    public boolean a(int resultCode, Intent data) {
        return wr.a(this.a, resultCode, data, wr.a(this.b));
    }
}
