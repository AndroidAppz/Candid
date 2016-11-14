package defpackage;

import android.content.Intent;
import com.facebook.FacebookException;

/* compiled from: LikeActionController */
class wk$1 implements wk$c {
    final /* synthetic */ int a;
    final /* synthetic */ int b;
    final /* synthetic */ Intent c;

    wk$1(int i, int i2, Intent intent) {
        this.a = i;
        this.b = i2;
        this.c = intent;
    }

    public void a(wk likeActionController, FacebookException error) {
        if (error == null) {
            likeActionController.b(this.a, this.b, this.c);
        } else {
            vw.a(wk.a, (Exception) error);
        }
    }
}
