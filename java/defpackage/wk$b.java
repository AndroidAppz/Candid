package defpackage;

import com.facebook.share.widget.LikeView.ObjectType;

/* compiled from: LikeActionController */
class wk$b implements Runnable {
    private String a;
    private ObjectType b;
    private wk$c c;

    wk$b(String objectId, ObjectType objectType, wk$c callback) {
        this.a = objectId;
        this.b = objectType;
        this.c = callback;
    }

    public void run() {
        wk.c(this.a, this.b, this.c);
    }
}
