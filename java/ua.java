/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.os.Parcelable
 *  java.lang.Object
 *  java.lang.String
 */
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Parcelable;
import com.facebook.AccessToken;

public abstract class ua {
    private final BroadcastReceiver a;
    private final bn b;
    private boolean c = false;

    public ua() {
        vx.a();
        this.a = new a(this, null);
        this.b = bn.a(ud.f());
        this.a();
    }

    private void d() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED");
        this.b.a(this.a, intentFilter);
    }

    public void a() {
        if (this.c) {
            return;
        }
        this.d();
        this.c = true;
    }

    public abstract void a(AccessToken var1, AccessToken var2);

    public void b() {
        if (!this.c) {
            return;
        }
        this.b.a(this.a);
        this.c = false;
    }

    public boolean c() {
        return this.c;
    }

    class a
    extends BroadcastReceiver {
        final /* synthetic */ ua a;

        private a(ua ua2) {
            this.a = ua2;
        }

        /* synthetic */ a(ua ua2,  var2_2) {
            super(ua2);
        }

        public void onReceive(Context context, Intent intent) {
            if ("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED".equals((Object)intent.getAction())) {
                AccessToken accessToken = (AccessToken)intent.getParcelableExtra("com.facebook.sdk.EXTRA_OLD_ACCESS_TOKEN");
                AccessToken accessToken2 = (AccessToken)intent.getParcelableExtra("com.facebook.sdk.EXTRA_NEW_ACCESS_TOKEN");
                this.a.a(accessToken, accessToken2);
            }
        }
    }

}

