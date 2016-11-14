package defpackage;

/* compiled from: OperatorOnErrorResumeNextViaFunction */
class aqg$2 extends apj<T> {
    long a;
    final /* synthetic */ apj b;
    final /* synthetic */ aqi c;
    final /* synthetic */ asp d;
    final /* synthetic */ aqg e;
    private boolean f;

    aqg$2(aqg aqg, apj apj, aqi aqi, asp asp) {
        this.e = aqg;
        this.b = apj;
        this.c = aqi;
        this.d = asp;
    }

    public void onCompleted() {
        if (!this.f) {
            this.f = true;
            this.b.onCompleted();
        }
    }

    public void onError(Throwable e) {
        if (this.f) {
            app.a(e);
            asc.a().b().a(e);
            return;
        }
        this.f = true;
        try {
            unsubscribe();
            apj next = new aqg$2$1(this);
            this.d.a(next);
            long p = this.a;
            if (p != 0) {
                this.c.b(p);
            }
            ((apd) this.e.a.call(e)).a(next);
        } catch (Throwable e2) {
            app.a(e2, this.b);
        }
    }

    public void onNext(T t) {
        if (!this.f) {
            this.a++;
            this.b.onNext(t);
        }
    }

    public void setProducer(apf producer) {
        this.c.a(producer);
    }
}
