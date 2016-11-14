package defpackage;

import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.becandid.candid.activities.PostDetailsActivity;
import com.becandid.candid.data.Comment;

/* compiled from: CommentsAdapter */
class he$8 implements OnClickListener {
    final /* synthetic */ String a;
    final /* synthetic */ Comment b;
    final /* synthetic */ int c;
    final /* synthetic */ he d;

    he$8(he this$0, String str, Comment comment, int i) {
        this.d = this$0;
        this.a = str;
        this.b = comment;
        this.c = i;
    }

    public void onClick(View v) {
        ((PostDetailsActivity) this.d.f).replyTo(this.a, Integer.toString(this.b.comment_id), this.c);
        new Handler().postDelayed(new he$8$1(this), 500);
    }
}
