package defpackage;

/* compiled from: FeedAdapter */
class hf$7 extends apj<ih$ah> {
    final /* synthetic */ hf a;

    hf$7(hf this$0) {
        this.a = this$0;
    }

    public /* synthetic */ void onNext(Object obj) {
        a((ih$ah) obj);
    }

    public void onCompleted() {
    }

    public void onError(Throwable e) {
        rb.a(e);
    }

    public void a(ih$ah seeMorePost) {
        this.a.notifyItemChanged(this.a.c(seeMorePost.a));
    }
}
