package defpackage;

/* compiled from: CommentsAdapter */
class he$14 extends apj<ih$i> {
    final /* synthetic */ he a;

    he$14(he this$0) {
        this.a = this$0;
    }

    public /* synthetic */ void onNext(Object obj) {
        a((ih$i) obj);
    }

    public void onCompleted() {
    }

    public void onError(Throwable e) {
        rb.a(e);
    }

    public void a(ih$i deleteModeratorCommentEvent) {
        iu.a(deleteModeratorCommentEvent.a, deleteModeratorCommentEvent.d, deleteModeratorCommentEvent.b, deleteModeratorCommentEvent.c);
    }
}
