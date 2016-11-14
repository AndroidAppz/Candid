/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Arrays
 *  java.util.Collection
 *  rx.exceptions.CompositeException
 *  rx.exceptions.OnCompletedFailedException
 *  rx.exceptions.OnErrorFailedException
 *  rx.exceptions.OnErrorNotImplementedException
 *  rx.exceptions.UnsubscribeFailedException
 */
import java.util.Arrays;
import java.util.Collection;
import rx.exceptions.CompositeException;
import rx.exceptions.OnCompletedFailedException;
import rx.exceptions.OnErrorFailedException;
import rx.exceptions.OnErrorNotImplementedException;
import rx.exceptions.UnsubscribeFailedException;

public class arw<T>
extends apj<T> {
    boolean a = false;
    private final apj<? super T> b;

    public arw(apj<? super T> apj2) {
        super(apj2);
        this.b = apj2;
    }

    protected void a(Throwable throwable) {
        aqp.a(throwable);
        try {
            this.b.onError(throwable);
        }
        catch (Throwable var2_2) {
            if (var2_2 instanceof OnErrorNotImplementedException) {
                try {
                    this.unsubscribe();
                }
                catch (Throwable var4_3) {
                    aqp.a(var4_3);
                    throw new RuntimeException("Observer.onError not implemented and error while unsubscribing.", (Throwable)new CompositeException((Collection)Arrays.asList((Object[])new Throwable[]{throwable, var4_3})));
                }
                throw (OnErrorNotImplementedException)var2_2;
            }
            aqp.a(var2_2);
            try {
                this.unsubscribe();
            }
            catch (Throwable var3_4) {
                aqp.a(var3_4);
                throw new OnErrorFailedException("Error occurred when trying to propagate error to Observer.onError and during unsubscription.", (Throwable)new CompositeException((Collection)Arrays.asList((Object[])new Throwable[]{throwable, var2_2, var3_4})));
            }
            throw new OnErrorFailedException("Error occurred when trying to propagate error to Observer.onError", (Throwable)new CompositeException((Collection)Arrays.asList((Object[])new Throwable[]{throwable, var2_2})));
        }
        try {
            this.unsubscribe();
            return;
        }
        catch (RuntimeException var5_5) {
            aqp.a((Throwable)var5_5);
            throw new OnErrorFailedException((Throwable)var5_5);
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    @Override
    public void onCompleted() {
        if (this.a) return;
        this.a = true;
        this.b.onCompleted();
        try {
            this.unsubscribe();
            return;
        }
        catch (Throwable var4_1) {
            aqp.a(var4_1);
            throw new UnsubscribeFailedException(var4_1.getMessage(), var4_1);
        }
        catch (Throwable throwable) {
            try {
                app.a(throwable);
                aqp.a(throwable);
                throw new OnCompletedFailedException(throwable.getMessage(), throwable);
            }
            catch (Throwable var1_3) {
                try {
                    this.unsubscribe();
                }
                catch (Throwable var2_4) {
                    aqp.a(var2_4);
                    throw new UnsubscribeFailedException(var2_4.getMessage(), var2_4);
                }
                throw var1_3;
            }
        }
    }

    @Override
    public void onError(Throwable throwable) {
        app.a(throwable);
        if (!this.a) {
            this.a = true;
            this.a(throwable);
        }
    }

    @Override
    public void onNext(T t2) {
        try {
            if (!this.a) {
                this.b.onNext(t2);
            }
            return;
        }
        catch (Throwable var2_2) {
            app.a(var2_2, this);
            return;
        }
    }
}

