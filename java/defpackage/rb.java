package defpackage;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/* compiled from: Crashlytics */
public class rb extends aku<Void> implements akv {
    public final rc a;
    public final sf b;
    public final sr c;
    public final Collection<? extends aku> d;

    protected /* synthetic */ Object f() {
        return d();
    }

    public rb() {
        this(new rc(), new sf(), new sr());
    }

    rb(rc answers, sf beta, sr core) {
        this.a = answers;
        this.b = beta;
        this.c = core;
        this.d = Collections.unmodifiableCollection(Arrays.asList(new aku[]{answers, beta, core}));
    }

    public String a() {
        return "2.6.1.139";
    }

    public String b() {
        return "com.crashlytics.sdk.android:crashlytics";
    }

    public Collection<? extends aku> c() {
        return this.d;
    }

    protected Void d() {
        return null;
    }

    public static rb e() {
        return (rb) akp.a(rb.class);
    }

    public static void a(Throwable throwable) {
        rb.g();
        rb.e().c.a(throwable);
    }

    private static void g() {
        if (rb.e() == null) {
            throw new IllegalStateException("Crashlytics must be initialized by calling Fabric.with(Context) prior to calling Crashlytics.getInstance()");
        }
    }
}
