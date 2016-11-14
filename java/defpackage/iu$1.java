package defpackage;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v7.app.AlertDialog;

/* compiled from: ViewUtils */
class iu$1 implements OnClickListener {
    final /* synthetic */ ih$a a;

    iu$1(ih$a ih_a) {
        this.a = ih_a;
    }

    public void onClick(DialogInterface dialog, int which) {
        if (((AlertDialog) dialog).getListView() != null) {
            this.a.d = ((AlertDialog) dialog).getListView().getCheckedItemPosition();
        }
        iq.a().a(this.a);
    }
}
