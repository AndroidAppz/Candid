package defpackage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import rx.exceptions.CompositeException;
import rx.exceptions.OnErrorFailedException;
import rx.exceptions.OnErrorNotImplementedException;
import rx.exceptions.OnErrorThrowable;

/* compiled from: Exceptions */
public final class app {
    public static void a(Throwable t) {
        if (t instanceof OnErrorNotImplementedException) {
            throw ((OnErrorNotImplementedException) t);
        } else if (t instanceof OnErrorFailedException) {
            throw ((OnErrorFailedException) t);
        } else if (t instanceof StackOverflowError) {
            throw ((StackOverflowError) t);
        } else if (t instanceof VirtualMachineError) {
            throw ((VirtualMachineError) t);
        } else if (t instanceof ThreadDeath) {
            throw ((ThreadDeath) t);
        } else if (t instanceof LinkageError) {
            throw ((LinkageError) t);
        }
    }

    public static void a(Throwable e, Throwable cause) {
        Set<Throwable> seenCauses = new HashSet();
        int i = 0;
        while (e.getCause() != null) {
            int i2 = i + 1;
            if (i >= 25) {
                i = i2;
                return;
            }
            e = e.getCause();
            if (seenCauses.contains(e.getCause())) {
                i = i2;
                break;
            } else {
                seenCauses.add(e.getCause());
                i = i2;
            }
        }
        try {
            e.initCause(cause);
        } catch (Throwable th) {
        }
    }

    public static Throwable b(Throwable e) {
        int i = 0;
        while (e.getCause() != null) {
            int i2 = i + 1;
            if (i >= 25) {
                i = i2;
                return new RuntimeException("Stack too deep to get final cause");
            }
            e = e.getCause();
            i = i2;
        }
        return e;
    }

    public static void a(List<? extends Throwable> exceptions) {
        if (exceptions != null && !exceptions.isEmpty()) {
            if (exceptions.size() == 1) {
                Throwable t = (Throwable) exceptions.get(0);
                if (t instanceof RuntimeException) {
                    throw ((RuntimeException) t);
                } else if (t instanceof Error) {
                    throw ((Error) t);
                } else {
                    throw new RuntimeException(t);
                }
            }
            throw new CompositeException("Multiple exceptions", exceptions);
        }
    }

    public static void a(Throwable t, ape<?> o, Object value) {
        app.a(t);
        o.onError(OnErrorThrowable.a(t, value));
    }

    public static void a(Throwable t, ape<?> o) {
        app.a(t);
        o.onError(t);
    }
}
