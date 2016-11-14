package defpackage;

/* compiled from: CommentsAdapter */
class he$1 extends apj<ih$al> {
    final /* synthetic */ he a;

    he$1(he this$0) {
        this.a = this$0;
    }

    public /* synthetic */ void onNext(Object obj) {
        a((ih$al) obj);
    }

    public void onCompleted() {
    }

    public void onError(Throwable e) {
        rb.a(e);
    }

    public void a(ih$al updateComment) {
        this.a.a(updateComment.a, updateComment);
    }
}
