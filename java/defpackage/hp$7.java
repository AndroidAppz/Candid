package defpackage;

import rx.schedulers.Schedulers;

/* compiled from: FeedFragment */
class hp$7 implements Runnable {
    final /* synthetic */ hp a;

    hp$7(hp this$0) {
        this.a = this$0;
    }

    public void run() {
        ie.a().c(this.a.c, null, this.a.b.b(this.a.c)).b(Schedulers.io()).a(apn.a()).b(new hp$7$1(this));
        this.a.h.postDelayed(this.a.k, 60000);
    }
}
