package defpackage;

import android.content.Intent;
import android.os.Bundle;
import com.facebook.FacebookRequestError;
import com.facebook.internal.CallbackManagerImpl.a;

/* compiled from: DeviceShareDialog */
class wh$1 implements a {
    final /* synthetic */ uc a;
    final /* synthetic */ wh b;

    wh$1(wh this$0, uc ucVar) {
        this.b = this$0;
        this.a = ucVar;
    }

    public boolean a(int resultCode, Intent data) {
        Bundle extras = data.getExtras();
        if (data.hasExtra("error")) {
            this.a.onError(((FacebookRequestError) data.getParcelableExtra("error")).g());
        } else {
            this.a.onSuccess(new wh$a());
        }
        return true;
    }
}
