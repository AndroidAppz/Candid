package defpackage;

import com.facebook.FacebookException;

/* compiled from: LikeActionController */
class wk$7 implements Runnable {
    final /* synthetic */ wk$c a;
    final /* synthetic */ wk b;
    final /* synthetic */ FacebookException c;

    wk$7(wk$c wk_c, wk wkVar, FacebookException facebookException) {
        this.a = wk_c;
        this.b = wkVar;
        this.c = facebookException;
    }

    public void run() {
        this.a.a(this.b, this.c);
    }
}
