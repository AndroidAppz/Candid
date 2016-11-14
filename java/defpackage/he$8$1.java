package defpackage;

import com.becandid.candid.activities.PostDetailsActivity;

/* compiled from: CommentsAdapter */
class he$8$1 implements Runnable {
    final /* synthetic */ he$8 a;

    he$8$1(he$8 this$1) {
        this.a = this$1;
    }

    public void run() {
        ((PostDetailsActivity) this.a.d.f).scrollToComment(this.a.b.comment_id);
    }
}
