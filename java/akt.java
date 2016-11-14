/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  io.fabric.sdk.android.InitializationException
 *  io.fabric.sdk.android.services.concurrency.Priority
 *  io.fabric.sdk.android.services.concurrency.UnmetDependencyException
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.Void
 */
import io.fabric.sdk.android.InitializationException;
import io.fabric.sdk.android.services.concurrency.Priority;
import io.fabric.sdk.android.services.concurrency.UnmetDependencyException;

class akt<Result>
extends alw<Void, Void, Result> {
    final aku<Result> a;

    public akt(aku<Result> aku2) {
        this.a = aku2;
    }

    private alt a(String string2) {
        alt alt2 = new alt(this.a.b() + "." + string2, "KitInitialization");
        alt2.a();
        return alt2;
    }

    protected /* varargs */ Result a(Void ... arrvoid) {
        alt alt2 = super.a("doInBackground");
        boolean bl2 = this.e();
        Result Result2 = null;
        if (!bl2) {
            Result2 = this.a.f();
        }
        alt2.b();
        return Result2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected void a() {
        super.a();
        alt alt2 = this.a("onPreExecute");
        try {
            boolean bl2 = this.a.b_();
            return;
        }
        catch (UnmetDependencyException var6_3) {
            throw var6_3;
        }
        catch (Exception var2_5) {
            akp.h().e("Fabric", "Failure onPreExecute()", (Throwable)var2_5);
            return;
        }
        finally {
            alt2.b();
            if (!false) {
                this.a(true);
            }
        }
    }

    protected void a(Result Result2) {
        this.a.a(Result2);
        this.a.h.a(Result2);
    }

    @Override
    public Priority b() {
        return Priority.c;
    }

    protected void b(Result Result2) {
        this.a.b(Result2);
        InitializationException initializationException = new InitializationException(this.a.b() + " Initialization was cancelled");
        this.a.h.a((Exception)initializationException);
    }
}

