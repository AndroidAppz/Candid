/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.app.Activity
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Bundle
 *  android.text.TextUtils
 *  com.google.android.gms.measurement.AppMeasurement
 *  com.google.android.gms.measurement.AppMeasurement$b
 *  com.google.android.gms.measurement.AppMeasurement$c
 *  com.google.android.gms.measurement.internal.EventParams
 *  com.google.android.gms.measurement.internal.EventParcel
 *  com.google.android.gms.measurement.internal.UserAttributeParcel
 *  com.google.android.gms.measurement.internal.zzw
 *  java.lang.CharSequence
 *  java.lang.Character
 *  java.lang.Class
 *  java.lang.ClassNotFoundException
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.Method
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Set
 */
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.internal.EventParams;
import com.google.android.gms.measurement.internal.EventParcel;
import com.google.android.gms.measurement.internal.UserAttributeParcel;
import com.google.android.gms.measurement.internal.zzw;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class afx
extends afv {
    private a a;
    private AppMeasurement.b b;
    private final Set<AppMeasurement.c> c = new HashSet();
    private boolean d;

    protected afx(ahc ahc2) {
        super(ahc2);
    }

    private String A() {
        return "com.google.android.gms.tagmanager.TagManagerService";
    }

    private void a(String string2, String string3, Bundle bundle, boolean bl2, boolean bl3, boolean bl4, String string4) {
        this.a(string2, string3, this.p().a(), bundle, bl2, bl3, bl4, string4);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a(String string2, String string3, Object object, long l2) {
        xr.a(string2);
        xr.a(string3);
        this.j();
        this.h();
        this.c();
        if (!this.n.D()) {
            this.w().D().a("User property not set since app measurement is disabled");
            return;
        } else {
            if (!this.n.b()) return;
            {
                this.w().D().a("Setting user property (FE)", string3, object);
                UserAttributeParcel userAttributeParcel = new UserAttributeParcel(string3, l2, object, string2);
                this.o().a(userAttributeParcel);
                return;
            }
        }
    }

    private void a(boolean bl2) {
        this.j();
        this.h();
        this.c();
        this.w().D().a("Setting app measurement enabled (FE)", bl2);
        this.x().b(bl2);
        this.o().g();
    }

    /*
     * Enabled aggressive block sorting
     */
    private void b(String string2, String string3, long l2, Bundle bundle, boolean bl2, boolean bl3, boolean bl4, String string4) {
        xr.a(string2);
        xr.a(string3);
        xr.a(bundle);
        this.j();
        this.c();
        if (!this.n.D()) {
            this.w().D().a("Event not sent since app measurement is disabled");
            return;
        } else {
            if (!this.d) {
                this.d = true;
                super.z();
            }
            boolean bl5 = agg.j(string3);
            if (bl2 && this.b != null && !bl5) {
                this.w().D().a("Passing event to registered event handler (FE)", string3, (Object)bundle);
                this.b.a(string2, string3, bundle, l2);
                return;
            }
            if (!this.n.b()) return;
            {
                int n2 = this.s().b(string3);
                if (n2 != 0) {
                    String string5 = this.s().a(string3, this.y().c(), true);
                    this.n.n().a(n2, "_ev", string5);
                    return;
                }
                bundle.putString("_o", string2);
                List<String> list = zg.a("_o");
                Bundle bundle2 = this.s().a(string3, bundle, list, bl4);
                Bundle bundle3 = bl3 ? this.a(bundle2) : bundle2;
                this.w().D().a("Logging event (FE)", string3, (Object)bundle3);
                EventParcel eventParcel = new EventParcel(string3, new EventParams(bundle3), string2, l2);
                this.o().a(eventParcel, string4);
                Iterator iterator = this.c.iterator();
                while (iterator.hasNext()) {
                    ((AppMeasurement.c)iterator.next()).a(string2, string3, bundle3, l2);
                }
            }
        }
    }

    private void z() {
        try {
            this.a(Class.forName((String)this.A()));
            return;
        }
        catch (ClassNotFoundException var1_1) {
            this.w().C().a("Tag Manager is not found and thus will not be used");
            return;
        }
    }

    Bundle a(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String string2 : bundle.keySet()) {
                Object object = this.s().b(string2, bundle.get(string2));
                if (object == null) {
                    this.w().z().a("Param value can't be null", string2);
                    continue;
                }
                if ((object instanceof String || object instanceof Character || object instanceof CharSequence) && TextUtils.isEmpty((CharSequence)String.valueOf((Object)object))) continue;
                this.s().a(bundle2, string2, object);
            }
        }
        return bundle2;
    }

    public void a(Class<?> class_) {
        try {
            Method method = class_.getDeclaredMethod("initialize", new Class[]{Context.class});
            Object[] arrobject = new Object[]{this.q()};
            method.invoke((Object)null, arrobject);
            return;
        }
        catch (Exception var2_4) {
            this.w().z().a("Failed to invoke Tag Manager's initialize() method", (Object)var2_4);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    protected void a(final String string2, final String string3, final long l2, Bundle bundle, final boolean bl2, final boolean bl3, final boolean bl4, final String string4) {
        final Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
        this.v().a(new Runnable(){

            public void run() {
                afx.this.b(string2, string3, l2, bundle2, bl2, bl3, bl4, string4);
            }
        });
    }

    void a(final String string2, final String string3, final long l2, final Object object) {
        this.v().a(new Runnable(){

            public void run() {
                afx.this.a(string2, string3, object, l2);
            }
        });
    }

    /*
     * Enabled aggressive block sorting
     */
    public void a(String string2, String string3, Bundle bundle) {
        this.h();
        boolean bl2 = this.b == null || agg.j(string3);
        super.a(string2, string3, bundle, true, bl2, false, null);
    }

    /*
     * Enabled aggressive block sorting
     */
    public void a(String string2, String string3, Object object) {
        xr.a(string2);
        long l2 = this.p().a();
        int n2 = this.s().c(string3);
        if (n2 != 0) {
            String string4 = this.s().a(string3, this.y().d(), true);
            this.n.n().a(n2, "_ev", string4);
            return;
        } else {
            if (object == null) {
                this.a(string2, string3, l2, null);
                return;
            }
            int n3 = this.s().c(string3, object);
            if (n3 != 0) {
                String string5 = this.s().a(string3, this.y().d(), true);
                this.n.n().a(n3, "_ev", string5);
                return;
            }
            Object object2 = this.s().d(string3, object);
            if (object2 == null) return;
            {
                this.a(string2, string3, l2, object2);
                return;
            }
        }
    }

    @Override
    protected void e() {
    }

    @TargetApi(value=14)
    public void f() {
        if (this.q().getApplicationContext() instanceof Application) {
            Application application = (Application)this.q().getApplicationContext();
            if (this.a == null) {
                this.a = new a(this, null);
            }
            application.unregisterActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)this.a);
            application.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)this.a);
            this.w().E().a("Registered activity lifecycle callback");
        }
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public void g() {
        this.j();
        this.h();
        this.c();
        if (!this.n.b()) {
            return;
        }
        this.o().z();
        String string2 = this.x().D();
        if (TextUtils.isEmpty((CharSequence)string2)) return;
        if (string2.equals((Object)this.n().g())) return;
        Bundle bundle = new Bundle();
        bundle.putString("_po", string2);
        this.a("auto", "_ou", bundle);
    }

    @TargetApi(value=14)
    class a
    implements Application.ActivityLifecycleCallbacks {
        final /* synthetic */ afx a;

        private a(afx afx2) {
            this.a = afx2;
        }

        /* synthetic */ a(afx afx2,  var2_2) {
            super(afx2);
        }

        private boolean a(Uri uri) {
            String string2 = uri.getQueryParameter("utm_campaign");
            String string3 = uri.getQueryParameter("utm_source");
            String string4 = uri.getQueryParameter("utm_medium");
            String string5 = uri.getQueryParameter("gclid");
            if (!(TextUtils.isEmpty((CharSequence)string2) && TextUtils.isEmpty((CharSequence)string3) && TextUtils.isEmpty((CharSequence)string4) && TextUtils.isEmpty((CharSequence)string5))) {
                String string6;
                String string7;
                String string8;
                String string9;
                String string10;
                Bundle bundle = new Bundle();
                if (!TextUtils.isEmpty((CharSequence)string2)) {
                    bundle.putString("campaign", string2);
                }
                if (!TextUtils.isEmpty((CharSequence)string3)) {
                    bundle.putString("source", string3);
                }
                if (!TextUtils.isEmpty((CharSequence)string4)) {
                    bundle.putString("medium", string4);
                }
                if (!TextUtils.isEmpty((CharSequence)string5)) {
                    bundle.putString("gclid", string5);
                }
                if (!TextUtils.isEmpty((CharSequence)(string10 = uri.getQueryParameter("utm_term")))) {
                    bundle.putString("term", string10);
                }
                if (!TextUtils.isEmpty((CharSequence)(string7 = uri.getQueryParameter("utm_content")))) {
                    bundle.putString("content", string7);
                }
                if (!TextUtils.isEmpty((CharSequence)(string9 = uri.getQueryParameter("aclid")))) {
                    bundle.putString("aclid", string9);
                }
                if (!TextUtils.isEmpty((CharSequence)(string8 = uri.getQueryParameter("cp1")))) {
                    bundle.putString("cp1", string8);
                }
                if (!TextUtils.isEmpty((CharSequence)(string6 = uri.getQueryParameter("anid")))) {
                    bundle.putString("anid", string6);
                }
                this.a.a("auto", "_cmp", bundle);
                return true;
            }
            return false;
        }

        private boolean a(String string2) {
            if (!TextUtils.isEmpty((CharSequence)string2)) {
                this.a.a("auto", "_ldl", string2);
                return true;
            }
            return false;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public void onActivityCreated(Activity activity, Bundle bundle) {
            try {
                Uri uri;
                this.a.w().E().a("onActivityCreated");
                Intent intent = activity.getIntent();
                if (intent == null || (uri = intent.getData()) == null || !uri.isHierarchical()) return;
                {
                    String string2;
                    if (bundle == null) {
                        super.a(uri);
                    }
                    if (TextUtils.isEmpty((CharSequence)(string2 = uri.getQueryParameter("referrer")))) {
                        return;
                    }
                    if (!string2.contains((CharSequence)"gclid")) {
                        this.a.w().D().a("Activity created with data 'referrer' param without gclid");
                        return;
                    }
                    this.a.w().D().a("Activity created with referrer", string2);
                    super.a(string2);
                    return;
                }
            }
            catch (Throwable var3_6) {
                this.a.w().f().a("Throwable caught in onActivityCreated", (Object)var3_6);
                return;
            }
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
            this.a.u().g();
        }

        public void onActivityResumed(Activity activity) {
            this.a.u().f();
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }
    }

}

