package defpackage;

/* compiled from: FeedFragment */
class hp$6 extends apj<ih$o> {
    final /* synthetic */ hp a;

    hp$6(hp this$0) {
        this.a = this$0;
    }

    public /* synthetic */ void onNext(Object obj) {
        a((ih$o) obj);
    }

    public void onCompleted() {
    }

    public void onError(Throwable e) {
        rb.a(e);
    }

    public void a(ih$o didLeaveGroup) {
        this.a.b();
    }
}
