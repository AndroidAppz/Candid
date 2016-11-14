package defpackage;

import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.support.v7.app.AlertDialog;

/* compiled from: CommentsAdapter */
class he$15$1$2 implements OnShowListener {
    final /* synthetic */ he$15$1 a;

    he$15$1$2(he$15$1 this$2) {
        this.a = this$2;
    }

    public void onShow(DialogInterface dialog) {
        ((AlertDialog) dialog).getButton(-1).setEnabled(false);
    }
}
