package defpackage;

/* compiled from: CommentsAdapter */
class he$10 extends apj<ih$s> {
    final /* synthetic */ he a;

    he$10(he this$0) {
        this.a = this$0;
    }

    public /* synthetic */ void onNext(Object obj) {
        a((ih$s) obj);
    }

    public void onCompleted() {
    }

    public void onError(Throwable e) {
        rb.a(e);
    }

    public void a(ih$s didReportComment) {
        this.a.c(didReportComment.a);
    }
}
