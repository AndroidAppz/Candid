package defpackage;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

/* compiled from: PhotoHelper */
class im$2 implements OnCancelListener {
    final /* synthetic */ im a;

    im$2(im this$0) {
        this.a = this$0;
    }

    public void onCancel(DialogInterface dialog) {
        dialog.dismiss();
    }
}
