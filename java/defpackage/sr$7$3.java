package defpackage;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: CrashlyticsCore */
class sr$7$3 implements OnClickListener {
    final /* synthetic */ sr$7 a;

    sr$7$3(sr$7 sr_7) {
        this.a = sr_7;
    }

    public void onClick(DialogInterface dialog, int id) {
        this.a.e.a(true);
        this.a.b.a(true);
        dialog.dismiss();
    }
}
