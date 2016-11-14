package defpackage;

class abh$1 implements Runnable {
    final /* synthetic */ xc a;
    final /* synthetic */ abh b;

    abh$1(abh abh, xc xcVar) {
        this.b = abh;
        this.a = xcVar;
    }

    public void run() {
        wz wzVar;
        try {
            aaw.a.set(Boolean.valueOf(true));
            this.b.h.sendMessage(this.b.h.obtainMessage(0, this.b.a.a(this.a)));
            aaw.a.set(Boolean.valueOf(false));
            this.b.b(this.a);
            wzVar = (wz) this.b.g.get();
            if (wzVar != null) {
                wzVar.b(this.b);
            }
        } catch (RuntimeException e) {
            this.b.h.sendMessage(this.b.h.obtainMessage(1, e));
            aaw.a.set(Boolean.valueOf(false));
            this.b.b(this.a);
            wzVar = (wz) this.b.g.get();
            if (wzVar != null) {
                wzVar.b(this.b);
            }
        } catch (Throwable th) {
            Throwable th2 = th;
            aaw.a.set(Boolean.valueOf(false));
            this.b.b(this.a);
            wzVar = (wz) this.b.g.get();
            if (wzVar != null) {
                wzVar.b(this.b);
            }
        }
    }
}
