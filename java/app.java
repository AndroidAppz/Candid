/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Error
 *  java.lang.LinkageError
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.StackOverflowError
 *  java.lang.String
 *  java.lang.ThreadDeath
 *  java.lang.Throwable
 *  java.lang.VirtualMachineError
 *  java.util.Collection
 *  java.util.HashSet
 *  java.util.List
 *  rx.exceptions.CompositeException
 *  rx.exceptions.OnErrorFailedException
 *  rx.exceptions.OnErrorNotImplementedException
 *  rx.exceptions.OnErrorThrowable
 */
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import rx.exceptions.CompositeException;
import rx.exceptions.OnErrorFailedException;
import rx.exceptions.OnErrorNotImplementedException;
import rx.exceptions.OnErrorThrowable;

public final class app {
    public static void a(Throwable throwable) {
        if (throwable instanceof OnErrorNotImplementedException) {
            throw (OnErrorNotImplementedException)throwable;
        }
        if (throwable instanceof OnErrorFailedException) {
            throw (OnErrorFailedException)throwable;
        }
        if (throwable instanceof StackOverflowError) {
            throw (StackOverflowError)throwable;
        }
        if (throwable instanceof VirtualMachineError) {
            throw (VirtualMachineError)throwable;
        }
        if (throwable instanceof ThreadDeath) {
            throw (ThreadDeath)throwable;
        }
        if (throwable instanceof LinkageError) {
            throw (LinkageError)throwable;
        }
    }

    public static void a(Throwable throwable, ape<?> ape2) {
        app.a(throwable);
        ape2.onError(throwable);
    }

    public static void a(Throwable throwable, ape<?> ape2, Object object) {
        app.a(throwable);
        ape2.onError(OnErrorThrowable.a((Throwable)throwable, (Object)object));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(Throwable throwable, Throwable throwable2) {
        HashSet hashSet = new HashSet();
        int n2 = 0;
        while (throwable.getCause() != null) {
            int n3 = n2 + 1;
            if (n2 >= 25) {
                return;
            }
            if (hashSet.contains((Object)(throwable = throwable.getCause()).getCause())) break;
            hashSet.add((Object)throwable.getCause());
            n2 = n3;
        }
        try {
            throwable.initCause(throwable2);
            return;
        }
        catch (Throwable var4_5) {
            return;
        }
    }

    public static void a(List<? extends Throwable> list) {
        if (list != null && !list.isEmpty()) {
            if (list.size() == 1) {
                Throwable throwable = (Throwable)list.get(0);
                if (throwable instanceof RuntimeException) {
                    throw (RuntimeException)throwable;
                }
                if (throwable instanceof Error) {
                    throw (Error)throwable;
                }
                throw new RuntimeException(throwable);
            }
            throw new CompositeException("Multiple exceptions", list);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Throwable b(Throwable throwable) {
        int n2 = 0;
        while (throwable.getCause() != null) {
            int n3 = n2 + 1;
            if (n2 >= 25) {
                return new RuntimeException("Stack too deep to get final cause");
            }
            throwable = throwable.getCause();
            n2 = n3;
        }
        return throwable;
    }
}

