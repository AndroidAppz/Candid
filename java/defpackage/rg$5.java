package defpackage;

/* compiled from: AnswersEventsHandler */
class rg$5 implements Runnable {
    final /* synthetic */ rg a;

    rg$5(rg rgVar) {
        this.a = rgVar;
    }

    public void run() {
        try {
            this.a.b.c();
        } catch (Exception e) {
            akp.h().e("Answers", "Failed to flush events", e);
        }
    }
}
