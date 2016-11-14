package defpackage;

/* compiled from: FeedAdapter */
class hf$6 extends apj<ih$ad> {
    final /* synthetic */ hf a;

    hf$6(hf this$0) {
        this.a = this$0;
    }

    public /* synthetic */ void onNext(Object obj) {
        a((ih$ad) obj);
    }

    public void onCompleted() {
    }

    public void onError(Throwable e) {
        rb.a(e);
    }

    public void a(ih$ad postEdit) {
        this.a.a(postEdit.a, postEdit.b, postEdit.c);
    }
}
