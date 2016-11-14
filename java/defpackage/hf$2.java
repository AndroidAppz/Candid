package defpackage;

/* compiled from: FeedAdapter */
class hf$2 extends apj<ih$am> {
    final /* synthetic */ hf a;

    hf$2(hf this$0) {
        this.a = this$0;
    }

    public /* synthetic */ void onNext(Object obj) {
        a((ih$am) obj);
    }

    public void onCompleted() {
    }

    public void onError(Throwable e) {
        rb.a(e);
    }

    public void a(ih$am update) {
        this.a.a(update.a.post_id, update);
    }
}
