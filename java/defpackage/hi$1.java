package defpackage;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.activities.MeSettingsActivity.Setting;
import com.becandid.candid.activities.MeSettingsActivity.WebViewSetting;
import com.becandid.candid.activities.WebViewActivity;

/* compiled from: MeSettingsAdapter */
class hi$1 implements OnClickListener {
    final /* synthetic */ Setting a;
    final /* synthetic */ hi b;

    hi$1(hi this$0, Setting setting) {
        this.b = this$0;
        this.a = setting;
    }

    public void onClick(View v) {
        Intent intent = new Intent(this.b.d, WebViewActivity.class);
        intent.putExtra("url", GossipApplication.d + ((WebViewSetting) this.a).url);
        this.b.d.startActivity(intent);
    }
}
