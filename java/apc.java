/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
public class apc {
    static final apc a = apc.a(new a(){

        public void a(b b2) {
            b2.a(asq.b());
            b2.a();
        }

        @Override
        public /* synthetic */ void call(Object object) {
            this.a((b)object);
        }
    });
    static final apc b = apc.a(new a(){

        public void a(b b2) {
            b2.a(asq.b());
        }

        @Override
        public /* synthetic */ void call(Object object) {
            this.a((b)object);
        }
    });
    static final arz c = asc.a().b();
    private final a d;

    protected apc(a a2) {
        this.d = a2;
    }

    public static apc a(a a2) {
        apc.a(a2);
        try {
            apc apc2 = new apc(a2);
            return apc2;
        }
        catch (NullPointerException var4_2) {
            throw var4_2;
        }
        catch (Throwable var3_3) {
            c.a(var3_3);
            throw apc.a(var3_3);
        }
    }

    static NullPointerException a(Throwable throwable) {
        NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        nullPointerException.initCause(throwable);
        return nullPointerException;
    }

    static <T> T a(T t2) {
        if (t2 == null) {
            throw new NullPointerException();
        }
        return t2;
    }

    public final apc a(final apg apg2) {
        apc.a(apg2);
        return apc.a(new a(){

            public void a(final b b2) {
                final apg.a a2 = apg2.createWorker();
                a2.a(new apq(){

                    @Override
                    public void call() {
                        try {
                            apc.this.a(b2);
                            return;
                        }
                        finally {
                            a2.unsubscribe();
                        }
                    }
                });
            }

            @Override
            public /* synthetic */ void call(Object object) {
                this.a((b)object);
            }

        });
    }

    public final void a(b b2) {
        apc.a(b2);
        try {
            this.d.call((Object)b2);
            return;
        }
        catch (NullPointerException var4_2) {
            throw var4_2;
        }
        catch (Throwable var3_3) {
            c.a(var3_3);
            throw apc.a(var3_3);
        }
    }

    public static interface a
    extends apr<b> {
    }

    public static interface b {
        public void a();

        public void a(apk var1);

        public void a(Throwable var1);
    }

}

