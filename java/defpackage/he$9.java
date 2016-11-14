package defpackage;

/* compiled from: CommentsAdapter */
class he$9 extends apj<ih$l> {
    final /* synthetic */ he a;

    he$9(he this$0) {
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
        this.a.c(didDeleteComment.a);
    }
}
