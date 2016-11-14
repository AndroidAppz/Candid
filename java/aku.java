/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  io.fabric.sdk.android.services.common.IdManager
 *  java.io.File
 *  java.lang.Class
 *  java.lang.Comparable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Void
 *  java.lang.annotation.Annotation
 *  java.util.Collection
 *  java.util.concurrent.ExecutorService
 */
import android.content.Context;
import io.fabric.sdk.android.services.common.IdManager;
import java.io.File;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.concurrent.ExecutorService;

public abstract class aku<Result>
implements Comparable<aku> {
    akp e;
    akt<Result> f;
    Context g;
    aks<Result> h;
    IdManager i;
    final alv j;

    public aku() {
        this.f = new akt(this);
        this.j = (alv)this.getClass().getAnnotation((Class)alv.class);
    }

    final void C() {
        akt<Result> akt2 = this.f;
        ExecutorService executorService = this.e.f();
        Void[] arrvoid = new Void[]{null};
        akt2.a(executorService, (Params[])arrvoid);
    }

    protected IdManager D() {
        return this.i;
    }

    public Context E() {
        return this.g;
    }

    public akp F() {
        return this.e;
    }

    public String G() {
        return ".Fabric" + File.separator + this.b();
    }

    boolean H() {
        if (this.j != null) {
            return true;
        }
        return false;
    }

    protected Collection<amc> I() {
        return this.f.c();
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public int a(aku aku2) {
        if (this.b(aku2)) {
            return 1;
        }
        if (aku2.b((aku)this)) {
            return -1;
        }
        if (this.H()) {
            if (!aku2.H()) return 1;
        }
        if (this.H()) return 0;
        if (!aku2.H()) return 0;
        return -1;
    }

    public abstract String a();

    void a(Context context, akp akp2, aks<Result> aks2, IdManager idManager) {
        this.e = akp2;
        this.g = new akq(context, this.b(), this.G());
        this.h = aks2;
        this.i = idManager;
    }

    protected void a(Result Result2) {
    }

    public abstract String b();

    protected void b(Result Result2) {
    }

    boolean b(aku aku2) {
        if (this.H()) {
            Class<?>[] arrclass = this.j.a();
            int n2 = arrclass.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                if (!arrclass[i2].isAssignableFrom(aku2.getClass())) continue;
                return true;
            }
        }
        return false;
    }

    protected boolean b_() {
        return true;
    }

    public /* synthetic */ int compareTo(Object object) {
        return this.a((aku)object);
    }

    protected abstract Result f();
}

