package defpackage;

import android.content.Intent;
import android.support.v7.app.AlertDialog.Builder;
import android.view.View;
import android.view.View.OnClickListener;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.activities.MessageActivity;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.Comment;

/* compiled from: CommentsAdapter */
class he$16 implements OnClickListener {
    final /* synthetic */ Comment a;
    final /* synthetic */ he b;

    he$16(he this$0, Comment comment) {
        this.b = this$0;
        this.a = comment;
    }

    public void onClick(View v) {
        if (this.a.messaging_blocked != null) {
            new Builder(this.b.f).setMessage(this.a.messaging_blocked).setPositiveButton(2131230891, null).show();
        } else if (this.a.messaging_disabled != null) {
            new Builder(this.b.f).setMessage(this.a.messaging_disabled).setPositiveButton(2131230891, null).show();
        } else if (AppState.hasMessagedFromAlert) {
            Intent intent = new Intent(this.b.f, MessageActivity.class);
            intent.putExtra("post_id", Integer.toString(this.b.e.post_id));
            if (this.a.user != null) {
                intent.putExtra("user_name", this.a.user.user_name);
            } else {
                intent.putExtra("user_name", this.a.user_name);
            }
            intent.putExtra("comment_id", Integer.toString(this.a.comment_id));
            this.b.f.startActivity(intent);
        } else {
            new Builder(this.b.f).setTitle("Message User?").setMessage("Would you like to send this user a message?").setNegativeButton(this.b.f.getResources().getString(2131230887), null).setPositiveButton(this.b.f.getResources().getString(2131230945), new he$16$1(this)).create().show();
            AppState.hasMessagedFromAlert = true;
            AppState.saveState(GossipApplication.a());
        }
    }
}
