package defpackage;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.widget.PopupMenu.OnMenuItemClickListener;
import android.view.MenuItem;
import com.becandid.candid.activities.ContentEditActivity;
import com.becandid.candid.activities.MessageActivity;
import com.becandid.candid.activities.PostDetailsActivity;

/* compiled from: CommentsAdapter */
class he$15$1 implements OnMenuItemClickListener {
    final /* synthetic */ he$15 a;

    he$15$1(he$15 this$1) {
        this.a = this$1;
    }

    public boolean onMenuItemClick(MenuItem item) {
        Intent intent;
        AlertDialog dialog;
        switch (item.getItemId()) {
            case 2131624762:
                intent = new Intent(this.a.b.f, ContentEditActivity.class);
                intent.putExtra("comment_text", this.a.a.comment_text);
                intent.putExtra("comment_id", this.a.a.comment_id);
                if (this.a.a.mentioned_groups_info != null) {
                    intent.putExtra("group_tags", this.a.a.mentioned_groups_info);
                }
                ((PostDetailsActivity) this.a.b.f).startActivityForResult(intent, PostDetailsActivity.COMMENT_EDIT);
                break;
            case 2131624763:
                iu.a(this.a.b.f, "Delete this comment?", "Once you delete this comment you can never see it again.", "Yes", "No", 16843605, false, new ih$h(this.a.b.f, this.a.a.comment_id, this.a.a.post_id)).show();
                break;
            case 2131624764:
                if (this.a.a.messaging_blocked == null) {
                    if (this.a.a.messaging_disabled == null) {
                        intent = new Intent(this.a.b.f, MessageActivity.class);
                        intent.putExtra("post_id", Integer.toString(this.a.b.e.post_id));
                        if (this.a.a.user != null) {
                            intent.putExtra("user_name", this.a.a.user.user_name);
                        } else {
                            intent.putExtra("user_name", this.a.a.user_name);
                        }
                        intent.putExtra("comment_id", Integer.toString(this.a.a.comment_id));
                        this.a.b.f.startActivity(intent);
                        break;
                    }
                    new Builder(this.a.b.f).setMessage(this.a.a.messaging_disabled).setPositiveButton(2131230891, null).show();
                    break;
                }
                new Builder(this.a.b.f).setMessage(this.a.a.messaging_blocked).setPositiveButton(2131230891, null).show();
                break;
            case 2131624765:
                dialog = iu.a(this.a.b.f, "Report This Comment?", null, "Report Comment", "Cancel", -1, true, new ih$ae(this.a.b.f, this.a.a.comment_id)).create();
                dialog.setOnShowListener(new he$15$1$1(this));
                dialog.show();
                break;
            case 2131624766:
                dialog = iu.a(this.a.b.f, "Delete this comment?", null, "Delete Comment", "Cancel", 16843605, true, new ih$i(this.a.b.f, this.a.a.comment_id, this.a.a.post_id)).create();
                dialog.setOnShowListener(new he$15$1$2(this));
                dialog.show();
                break;
        }
        return true;
    }
}
