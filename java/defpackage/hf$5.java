package defpackage;

/* compiled from: FeedAdapter */
class hf$5 extends apj<ih$l> {
    final /* synthetic */ hf a;

    hf$5(hf this$0) {
        this.a = this$0;
    }

    public /* synthetic */ void onNext(Object obj) {
        a((ih$l) obj);
    }

    public void onCompleted() {
    }

    public void onError(Throwable e) {
        rb.a(e);
    }

    public void a(ih$l didDeleteComment) {
        this.a.a(didDeleteComment);
    }
}
