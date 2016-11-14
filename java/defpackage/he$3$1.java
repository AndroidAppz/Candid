package defpackage;

import com.becandid.candid.activities.PostDetailsActivity;

/* compiled from: CommentsAdapter */
class he$3$1 implements Runnable {
    final /* synthetic */ he$3 a;

    he$3$1(he$3 this$1) {
        this.a = this$1;
    }

    public void run() {
        this.a.a.h.setOnFocusChangeListener(null);
        PostDetailsActivity.clipped.add(Integer.valueOf(this.a.b.comment_id));
        this.a.d.notifyItemChanged(this.a.c);
    }
}
