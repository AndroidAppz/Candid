package defpackage;

import android.view.View;
import android.view.View.OnClickListener;
import com.becandid.candid.data.Comment;
import rx.schedulers.Schedulers;

/* compiled from: CommentsAdapter */
class he$6 implements OnClickListener {
    final /* synthetic */ iw a;
    final /* synthetic */ Comment b;
    final /* synthetic */ he c;

    he$6(he this$0, iw iwVar, Comment comment) {
        this.c = this$0;
        this.a = iwVar;
        this.b = comment;
    }

    public void onClick(View v) {
        int value;
        ih$al update;
        if (this.a.l.isSelected()) {
            value = 0;
            update = new ih$al(this.b.comment_id, 0, this.b.num_likes - 1, this.b.num_dislikes);
        } else {
            value = 1;
            if (this.a.o.isSelected()) {
                update = new ih$al(this.b.comment_id, 1, this.b.num_likes + 1, this.b.num_dislikes - 1);
            } else {
                update = new ih$al(this.b.comment_id, 1, this.b.num_likes + 1, this.b.num_dislikes);
            }
        }
        iq.a().a(update);
        ie.a().a(this.b.comment_id, value).b(Schedulers.io()).a(apn.a()).b(new he$6$1(this));
    }
}
