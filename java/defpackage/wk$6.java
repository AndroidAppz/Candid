package defpackage;

import android.content.Intent;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.CallbackManagerImpl.a;

/* compiled from: LikeActionController */
class wk$6 implements a {
    wk$6() {
    }

    public boolean a(int resultCode, Intent data) {
        return wk.a(RequestCodeOffset.Like.a(), resultCode, data);
    }
}
