/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Fragment
 *  android.content.Intent
 *  android.support.v4.app.Fragment
 *  android.util.Log
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Iterator
 *  java.util.List
 */
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;
import com.facebook.FacebookException;
import com.facebook.LoggingBehavior;
import com.facebook.internal.CallbackManagerImpl;
import java.util.Iterator;
import java.util.List;

public abstract class vd<CONTENT, RESULT> {
    protected static final Object a = new Object();
    private final Activity b;
    private final vi c;
    private List<vd<CONTENT, RESULT>> d;
    private int e;

    public vd(Activity activity, int n2) {
        vx.a((Object)activity, "activity");
        this.b = activity;
        this.c = null;
        this.e = n2;
    }

    public vd(vi vi2, int n2) {
        vx.a(vi2, "fragmentWrapper");
        this.c = vi2;
        this.b = null;
        this.e = n2;
        if (vi2.c() == null) {
            throw new IllegalArgumentException("Cannot use a fragment that is not attached to an activity");
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private ux c(CONTENT var1, Object var2_2) {
        var3_3 = var2_2 == vd.a;
        var4_4 = super.e().iterator();
        do {
            var5_5 = var4_4.hasNext();
            var6_7 = null;
            if (!var5_5) ** GOTO lbl-1000
            var7_6 = (a)var4_4.next();
        } while (!var3_3 && !vw.a(var7_6.a(), var2_2) || !var7_6.a(var1, true));
        try {
            var6_7 = var9_8 = var7_6.a(var1);
        }
        catch (FacebookException var8_9) {
            var6_7 = this.d();
            vc.a(var6_7, var8_9);
        }
        if (var6_7 == null) lbl-1000: // 2 sources:
        {
            var6_7 = this.d();
            vc.a(var6_7);
        }
        return var6_7;
    }

    private List<vd<CONTENT, RESULT>> e() {
        if (this.d == null) {
            this.d = this.c();
        }
        return this.d;
    }

    public int a() {
        return this.e;
    }

    /*
     * Enabled aggressive block sorting
     */
    protected void a(Intent intent, int n2) {
        String string2 = null;
        if (this.b != null) {
            this.b.startActivityForResult(intent, n2);
        } else if (this.c != null) {
            if (this.c.a() != null) {
                this.c.a().startActivityForResult(intent, n2);
                return;
            }
            if (this.c.b() != null) {
                this.c.b().startActivityForResult(intent, n2);
                return;
            }
            string2 = "Failed to find Activity or Fragment to startActivityForResult ";
        } else {
            string2 = "Failed to find Activity or Fragment to startActivityForResult ";
        }
        if (string2 != null) {
            vp.a(LoggingBehavior.f, 6, this.getClass().getName(), string2);
        }
    }

    public abstract void a(CallbackManagerImpl var1, uc<RESULT> var2);

    public final void a(ub ub2, uc<RESULT> uc2) {
        if (!(ub2 instanceof CallbackManagerImpl)) {
            throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
        }
        this.a((CallbackManagerImpl)ub2, uc2);
    }

    public boolean a(CONTENT CONTENT) {
        return this.a(CONTENT, a);
    }

    /*
     * Enabled aggressive block sorting
     */
    protected boolean a(CONTENT CONTENT, Object object) {
        a a2;
        boolean bl2 = object == a;
        Iterator iterator = super.e().iterator();
        do {
            if (!iterator.hasNext()) {
                return false;
            }
            a2 = (a)iterator.next();
        } while (!bl2 && !vw.a(a2.a(), object) || !a2.a(CONTENT, false));
        return true;
    }

    public Activity b() {
        if (this.b != null) {
            return this.b;
        }
        if (this.c != null) {
            return this.c.c();
        }
        return null;
    }

    public void b(CONTENT CONTENT) {
        this.b(CONTENT, a);
    }

    /*
     * Enabled aggressive block sorting
     */
    protected void b(CONTENT CONTENT, Object object) {
        ux ux2 = super.c(CONTENT, object);
        if (ux2 != null) {
            if (this.c == null) {
                vc.a(ux2, this.b);
                return;
            }
            vc.a(ux2, this.c);
            return;
        } else {
            Log.e((String)"FacebookDialog", (String)"No code path should ever result in a null appCall");
            if (!ud.b()) return;
            {
                throw new IllegalStateException("No code path should ever result in a null appCall");
            }
        }
    }

    public abstract List<vd<CONTENT, RESULT>> c();

    public abstract ux d();

    public abstract class a {
        public Object a() {
            return vd.a;
        }

        public abstract ux a(CONTENT var1);

        public abstract boolean a(CONTENT var1, boolean var2);
    }

}

