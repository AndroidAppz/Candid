package defpackage;

import android.os.Handler;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.becandid.candid.data.Comment;

/* compiled from: CommentsAdapter */
class he$3 implements OnFocusChangeListener {
    final /* synthetic */ iw a;
    final /* synthetic */ Comment b;
    final /* synthetic */ int c;
    final /* synthetic */ he d;

    he$3(he this$0, iw iwVar, Comment comment, int i) {
        this.d = this$0;
        this.a = iwVar;
        this.b = comment;
        this.c = i;
    }

    public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus) {
            new Handler().post(new he$3$1(this));
        }
    }
}
