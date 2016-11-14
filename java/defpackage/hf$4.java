package defpackage;

/* compiled from: FeedAdapter */
class hf$4 extends apj<ih$ab> {
    final /* synthetic */ hf a;

    hf$4(hf this$0) {
        this.a = this$0;
    }

    public /* synthetic */ void onNext(Object obj) {
        a((ih$ab) obj);
    }

    public void onCompleted() {
    }

    public void onError(Throwable e) {
        rb.a(e);
    }

    public void a(ih$ab newComment) {
        this.a.a(newComment);
    }
}
