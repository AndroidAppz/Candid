package defpackage;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v7.app.AlertDialog;

/* compiled from: ViewUtils */
class iu$3 implements OnClickListener {
    iu$3() {
    }

    public void onClick(DialogInterface dialog, int which) {
        ((AlertDialog) dialog).getButton(-1).setEnabled(true);
    }
}
