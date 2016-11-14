package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.facebook.AccessToken;

/* compiled from: AccessTokenTracker */
class ua$a extends BroadcastReceiver {
    final /* synthetic */ ua a;

    private ua$a(ua uaVar) {
        this.a = uaVar;
    }

    public void onReceive(Context context, Intent intent) {
        if ("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED".equals(intent.getAction())) {
            this.a.a((AccessToken) intent.getParcelableExtra("com.facebook.sdk.EXTRA_OLD_ACCESS_TOKEN"), (AccessToken) intent.getParcelableExtra("com.facebook.sdk.EXTRA_NEW_ACCESS_TOKEN"));
        }
    }
}
