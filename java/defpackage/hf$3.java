package defpackage;

/* compiled from: FeedAdapter */
class hf$3 extends apj<ih$r> {
    final /* synthetic */ hf a;

    hf$3(hf this$0) {
        this.a = this$0;
    }

    public /* synthetic */ void onNext(Object obj) {
        a((ih$r) obj);
    }

    public void onCompleted() {
    }

    public void onError(Throwable e) {
        rb.a(e);
    }

    public void a(ih$r didRemovePost) {
        this.a.b(didRemovePost.a);
    }
}
