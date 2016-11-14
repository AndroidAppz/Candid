package defpackage;

/* compiled from: Completable */
class apc$3$1 implements apq {
    final /* synthetic */ apc$b a;
    final /* synthetic */ apg$a b;
    final /* synthetic */ apc$3 c;

    apc$3$1(apc$3 apc_3, apc$b apc_b, apg$a apg_a) {
        this.c = apc_3;
        this.a = apc_b;
        this.b = apg_a;
    }

    public void call() {
        try {
            this.c.b.a(this.a);
        } finally {
            this.b.unsubscribe();
        }
    }
}
