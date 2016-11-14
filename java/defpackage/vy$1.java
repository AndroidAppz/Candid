package defpackage;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

/* compiled from: WebDialog */
class vy$1 implements OnCancelListener {
    final /* synthetic */ vy a;

    vy$1(vy this$0) {
        this.a = this$0;
    }

    public void onCancel(DialogInterface dialogInterface) {
        this.a.cancel();
    }
}
