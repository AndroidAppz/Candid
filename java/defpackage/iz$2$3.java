package defpackage;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v7.app.AlertDialog;

/* compiled from: MessageViewHolder */
class iz$2$3 implements OnClickListener {
    final /* synthetic */ int[] a;
    final /* synthetic */ iz$2 b;

    iz$2$3(iz$2 this$0, int[] iArr) {
        this.b = this$0;
        this.a = iArr;
    }

    public void onClick(DialogInterface dialog, int which) {
        this.a[0] = which;
        ((AlertDialog) dialog).getButton(-1).setEnabled(true);
    }
}
