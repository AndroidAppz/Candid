package defpackage;

import android.support.v7.widget.PopupMenu;
import android.view.View;
import android.view.View.OnClickListener;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.Comment;

/* compiled from: CommentsAdapter */
class he$15 implements OnClickListener {
    final /* synthetic */ Comment a;
    final /* synthetic */ he b;

    he$15(he this$0, Comment comment) {
        this.b = this$0;
        this.a = comment;
    }

    public void onClick(View v) {
        PopupMenu commentMenu = new PopupMenu(v.getContext(), v);
        commentMenu.setOnMenuItemClickListener(new he$15$1(this));
        if (this.a.thats_me == 1) {
            if (!this.a.comment_text.equals("")) {
                commentMenu.getMenu().add(1, 2131624762, 0, 2131230832);
            }
            commentMenu.getMenu().add(1, 2131624763, 0, 2131230825);
        } else if (this.b.e.group_id == 0 || !AppState.isGroupModerator(this.b.e.group_id)) {
            if (AppState.config.getBoolean("messaging_turned_on", true) && this.a.thats_me != 1) {
                commentMenu.getMenu().add(1, 2131624764, 0, 2131230875);
            }
            if (this.b.e.group_id == 0 || !AppState.isGroupModerator(this.b.e.group_id)) {
                commentMenu.getMenu().add(1, 2131624765, 0, 2131230906);
            } else {
                commentMenu.getMenu().add(1, 2131624766, 0, 2131230825);
            }
        } else {
            commentMenu.getMenu().add(1, 2131624766, 0, 2131230825);
        }
        commentMenu.show();
    }
}
