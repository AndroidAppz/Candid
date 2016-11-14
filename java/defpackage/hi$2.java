package defpackage;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.becandid.candid.activities.MeSettingsActivity.ActivitySetting;
import com.becandid.candid.activities.MeSettingsActivity.Setting;

/* compiled from: MeSettingsAdapter */
class hi$2 implements OnClickListener {
    final /* synthetic */ Setting a;
    final /* synthetic */ hi b;

    hi$2(hi this$0, Setting setting) {
        this.b = this$0;
        this.a = setting;
    }

    public void onClick(View v) {
        Intent intent = new Intent(this.b.d, ((ActivitySetting) this.a).toStart);
        if (((ActivitySetting) this.a).bundle != null) {
            intent.putExtras(((ActivitySetting) this.a).bundle);
        }
        this.b.d.startActivity(intent);
    }
}
