package defpackage;

/* compiled from: CommentsAdapter */
class he$12 extends apj<ih$ae> {
    final /* synthetic */ he a;

    he$12(he this$0) {
        this.a = this$0;
    }

    public /* synthetic */ void onNext(Object obj) {
        a((ih$ae) obj);
    }

    public void onCompleted() {
    }

    public void onError(Throwable e) {
        rb.a(e);
    }

    public void a(ih$ae reportComment) {
        iu.a(reportComment.a, reportComment.d, reportComment.b);
    }
}
