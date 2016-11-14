package defpackage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.becandid.candid.activities.FullScreenImageActivity;
import com.becandid.candid.activities.PostDetailsActivity;
import com.becandid.candid.data.Comment;

/* compiled from: CommentsAdapter */
class he$5 implements OnClickListener {
    final /* synthetic */ Comment a;
    final /* synthetic */ he b;

    he$5(he this$0, Comment comment) {
        this.b = this$0;
        this.a = comment;
    }

    public void onClick(View v) {
        try {
            Intent intent = new Intent(this.b.f, FullScreenImageActivity.class);
            Bundle extras = new Bundle();
            extras.putInt("comment_id", this.a.comment_id);
            extras.putString("source_url", this.a.source_url);
            extras.putInt("num_likes", this.a.num_likes);
            extras.putInt("num_dislikes", this.a.num_dislikes);
            extras.putString("icon_name", this.a.icon_name);
            extras.putString("icon_color", this.a.icon_color);
            if (this.a.user != null) {
                extras.putString("user_name", this.a.user.user_name);
            } else {
                extras.putString("user_name", this.a.user_name);
            }
            extras.putInt("like_value", this.a.like_value);
            extras.putBoolean("fromDetails", true);
            extras.putInt("thats_me", this.a.thats_me);
            intent.putExtras(extras);
            ((Activity) this.b.f).startActivityForResult(intent, PostDetailsActivity.FULLSCREEN_VIEW_REPLY);
        } catch (NullPointerException e) {
            Toast.makeText(this.b.f, "This image is currently unavailable, please try again later", 1).show();
            rb.a(e);
        }
    }
}
