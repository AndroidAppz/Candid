package defpackage;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.becandid.candid.activities.MessageActivity;

/* compiled from: CommentsAdapter */
class he$2$1 implements OnClickListener {
    final /* synthetic */ he$2 a;

    he$2$1(he$2 this$1) {
        this.a = this$1;
    }

    public void onClick(DialogInterface dialog, int which) {
        Intent intent = new Intent(this.a.b.f, MessageActivity.class);
        intent.putExtra("post_id", Integer.toString(this.a.b.e.post_id));
        if (this.a.a.user != null) {
            intent.putExtra("user_name", this.a.a.user.user_name);
        } else {
            intent.putExtra("user_name", this.a.a.user_name);
        }
        intent.putExtra("comment_id", Integer.toString(this.a.a.comment_id));
        this.a.b.f.startActivity(intent);
    }
}
