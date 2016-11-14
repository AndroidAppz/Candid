package defpackage;

import com.facebook.GraphRequest.b;

/* compiled from: LikeActionController */
class wk$a$1 implements b {
    final /* synthetic */ wk$a a;

    wk$a$1(wk$a this$1) {
        this.a = this$1;
    }

    public void onCompleted(ug response) {
        this.a.c = response.a();
        if (this.a.c != null) {
            this.a.a(this.a.c);
        } else {
            this.a.a(response);
        }
    }
}
