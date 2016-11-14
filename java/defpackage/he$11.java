package defpackage;

/* compiled from: CommentsAdapter */
class he$11 extends apj<ih$g> {
    final /* synthetic */ he a;

    he$11(he this$0) {
        this.a = this$0;
    }

    public /* synthetic */ void onNext(Object obj) {
        a((ih$g) obj);
    }

    public void onCompleted() {
    }

    public void onError(Throwable e) {
        rb.a(e);
    }

    public void a(ih$g commentEdit) {
        this.a.a(commentEdit.a, commentEdit.b, commentEdit.c);
    }
}
