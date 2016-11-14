package defpackage;

/* compiled from: AnswersEventsHandler */
class rg$4 implements Runnable {
    final /* synthetic */ rg a;

    rg$4(rg rgVar) {
        this.a = rgVar;
    }

    public void run() {
        try {
            rz metadata = this.a.f.a();
            rv filesManager = this.a.e.a();
            filesManager.a(this.a);
            this.a.b = new ro(this.a.c, this.a.d, this.a.a, filesManager, this.a.g, metadata);
        } catch (Exception e) {
            akp.h().e("Answers", "Failed to enable events", e);
        }
    }
}
