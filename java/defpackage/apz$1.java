package defpackage;

import java.util.NoSuchElementException;

/* compiled from: OnSubscribeSingle */
class apz$1 extends apj<T> {
    final /* synthetic */ api a;
    final /* synthetic */ apz b;
    private boolean c = false;
    private boolean d = false;
    private T e = null;

    apz$1(apz apz, api api) {
        this.b = apz;
        this.a = api;
    }

    public void onStart() {
        request(2);
    }

    public void onCompleted() {
        if (!this.c) {
            if (this.d) {
                this.a.a(this.e);
            } else {
                this.a.a(new NoSuchElementException("Observable emitted no items"));
            }
        }
    }

    public void onError(Throwable e) {
        this.a.a(e);
        unsubscribe();
    }

    public void onNext(T t) {
        if (this.d) {
            this.c = true;
            this.a.a(new IllegalArgumentException("Observable emitted too many elements"));
            unsubscribe();
            return;
        }
        this.d = true;
        this.e = t;
    }
}
