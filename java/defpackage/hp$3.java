package defpackage;

/* compiled from: FeedFragment */
class hp$3 extends apj<ih$k> {
    final /* synthetic */ hp a;

    hp$3(hp this$0) {
        this.a = this$0;
    }

    public /* synthetic */ void onNext(Object obj) {
        a((ih$k) obj);
    }

    public void onCompleted() {
    }

    public void onError(Throwable e) {
        rb.a(e);
    }

    public void a(ih$k didCreatePost) {
        if (this.a.c.equals("home")) {
            this.a.a(didCreatePost);
        }
    }
}
