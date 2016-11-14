/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.ComponentName
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.support.v4.app.ActivityCompat
 *  android.support.v4.app.BundleCompat
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 */
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.BundleCompat;
import java.util.ArrayList;

public final class b {
    public final Intent a;
    public final Bundle b;

    private b(Intent intent, Bundle bundle) {
        this.a = intent;
        this.b = bundle;
    }

    /* synthetic */ b(Intent intent, Bundle bundle,  var3_2) {
        super(intent, bundle);
    }

    public void a(Activity activity, Uri uri) {
        this.a.setData(uri);
        ActivityCompat.startActivity((Activity)activity, (Intent)this.a, (Bundle)this.b);
    }

    public static final class a {
        private final Intent a = new Intent("android.intent.action.VIEW");
        private ArrayList<Bundle> b = null;
        private Bundle c = null;
        private ArrayList<Bundle> d = null;

        public a() {
            this(null);
        }

        /*
         * Enabled aggressive block sorting
         */
        public a(c c2) {
            if (c2 != null) {
                this.a.setPackage(c2.b().getPackageName());
            }
            Bundle bundle = new Bundle();
            IBinder iBinder = null;
            if (c2 != null) {
                iBinder = c2.a();
            }
            BundleCompat.putBinder((Bundle)bundle, (String)"android.support.customtabs.extra.SESSION", (IBinder)iBinder);
            this.a.putExtras(bundle);
        }

        public b a() {
            if (this.b != null) {
                this.a.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", this.b);
            }
            if (this.d != null) {
                this.a.putParcelableArrayListExtra("android.support.customtabs.extra.TOOLBAR_ITEMS", this.d);
            }
            return new b(this.a, this.c, null);
        }
    }

}

