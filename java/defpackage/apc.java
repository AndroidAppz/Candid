package defpackage;

/* compiled from: Completable */
public class apc {
    static final apc a = apc.a(new apc$1());
    static final apc b = apc.a(new apc$2());
    static final arz c = asc.a().b();
    private final apc$a d;

    public static apc a(apc$a onSubscribe) {
        apc.a((Object) onSubscribe);
        try {
            return new apc(onSubscribe);
        } catch (NullPointerException ex) {
            throw ex;
        } catch (Throwable ex2) {
            c.a(ex2);
            NullPointerException a = apc.a(ex2);
        }
    }

    static <T> T a(T o) {
        if (o != null) {
            return o;
        }
        throw new NullPointerException();
    }

    static NullPointerException a(Throwable ex) {
        NullPointerException npe = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        npe.initCause(ex);
        return npe;
    }

    protected apc(apc$a onSubscribe) {
        this.d = onSubscribe;
    }

    public final void a(apc$b s) {
        apc.a((Object) s);
        try {
            this.d.call(s);
        } catch (NullPointerException ex) {
            throw ex;
        } catch (Throwable ex2) {
            c.a(ex2);
            NullPointerException a = apc.a(ex2);
        }
    }

    public final apc a(apg scheduler) {
        apc.a((Object) scheduler);
        return apc.a(new apc$3(this, scheduler));
    }
}
