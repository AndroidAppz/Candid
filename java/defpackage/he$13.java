package defpackage;

/* compiled from: CommentsAdapter */
class he$13 extends apj<ih$h> {
    final /* synthetic */ he a;

    he$13(he this$0) {
        this.a = this$0;
    }

    public /* synthetic */ void onNext(Object obj) {
        a((ih$h) obj);
    }

    public void onCompleted() {
    }

    public void onError(Throwable e) {
        rb.a(e);
    }

    public void a(ih$h deleteCommentEvent) {
        iu.b(deleteCommentEvent.a, deleteCommentEvent.b, deleteCommentEvent.c);
    }
}
