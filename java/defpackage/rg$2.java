package defpackage;

/* compiled from: AnswersEventsHandler */
class rg$2 implements Runnable {
    final /* synthetic */ rg a;

    rg$2(rg rgVar) {
        this.a = rgVar;
    }

    public void run() {
        try {
            ry prevStrategy = this.a.b;
            this.a.b = new rn();
            prevStrategy.b();
        } catch (Exception e) {
            akp.h().e("Answers", "Failed to disable events", e);
        }
    }
}
