package defpackage;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;

public class ww extends DialogFragment {
    private Dialog a = null;
    private OnCancelListener b = null;

    public static ww a(Dialog dialog, OnCancelListener onCancelListener) {
        ww wwVar = new ww();
        Dialog dialog2 = (Dialog) xr.a((Object) dialog, (Object) "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        wwVar.a = dialog2;
        if (onCancelListener != null) {
            wwVar.b = onCancelListener;
        }
        return wwVar;
    }

    public void onCancel(DialogInterface dialogInterface) {
        if (this.b != null) {
            this.b.onCancel(dialogInterface);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        if (this.a == null) {
            setShowsDialog(false);
        }
        return this.a;
    }

    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}
