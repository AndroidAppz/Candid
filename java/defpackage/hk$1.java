package defpackage;

/* compiled from: MessagesAdapter */
class hk$1 extends apj<ih$af> {
    final /* synthetic */ hk a;

    hk$1(hk this$0) {
        this.a = this$0;
    }

    public /* synthetic */ void onNext(Object obj) {
        a((ih$af) obj);
    }

    public void onCompleted() {
    }

    public void onError(Throwable e) {
        rb.a(e);
    }

    public void a(ih$af reportMessage) {
        int pos = this.a.a.indexOf(reportMessage.a);
        this.a.a.remove(reportMessage.a);
        this.a.notifyItemRemoved(pos);
    }
}
