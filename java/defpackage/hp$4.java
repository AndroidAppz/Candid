package defpackage;

/* compiled from: FeedFragment */
class hp$4 extends apj<ih$p> {
    final /* synthetic */ hp a;

    hp$4(hp this$0) {
        this.a = this$0;
    }

    public /* synthetic */ void onNext(Object obj) {
        a((ih$p) obj);
    }

    public void onCompleted() {
    }

    public void onError(Throwable e) {
        rb.a(e);
    }

    public void a(ih$p didLeaveGroupFromFeed) {
        int pos = this.a.b.c(didLeaveGroupFromFeed.b);
        if (pos != -1) {
            int total = this.a.b.getItemCount();
            int i = pos;
            while (i < total) {
                if (this.a.b.e(i).group_id == didLeaveGroupFromFeed.a) {
                    this.a.b.b(this.a.b.d(i));
                    i--;
                    total--;
                }
                i++;
            }
            this.a.b.notifyDataSetChanged();
        }
    }
}
