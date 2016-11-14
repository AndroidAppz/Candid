package defpackage;

import android.os.Bundle;
import android.util.Log;
import com.facebook.share.internal.LikeContent;

/* compiled from: LikeDialog */
class wl$a$1 implements vc$a {
    final /* synthetic */ LikeContent a;
    final /* synthetic */ wl$a b;

    wl$a$1(wl$a this$1, LikeContent likeContent) {
        this.b = this$1;
        this.a = likeContent;
    }

    public Bundle a() {
        return wl.b(this.a);
    }

    public Bundle b() {
        Log.e("LikeDialog", "Attempting to present the Like Dialog with an outdated Facebook app on the device");
        return new Bundle();
    }
}
