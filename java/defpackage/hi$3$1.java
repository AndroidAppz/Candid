package defpackage;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.becandid.candid.activities.MainTabsActivity;

/* compiled from: MeSettingsAdapter */
class hi$3$1 implements OnClickListener {
    final /* synthetic */ hi$3 a;

    hi$3$1(hi$3 this$1) {
        this.a = this$1;
    }

    public void onClick(DialogInterface dialog, int which) {
        MainTabsActivity.disownAccount(this.a.a.d);
    }
}
