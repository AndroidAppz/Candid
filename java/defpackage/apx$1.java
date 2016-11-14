package defpackage;

/* compiled from: Functions */
class apx$1 implements apw<R> {
    final /* synthetic */ apv a;

    apx$1(apv apv) {
        this.a = apv;
    }

    public R a(Object... args) {
        if (args.length == 2) {
            return this.a.call(args[0], args[1]);
        }
        throw new RuntimeException("Func2 expecting 2 arguments.");
    }
}
