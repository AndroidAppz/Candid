package defpackage;

/* compiled from: AnswersEventsHandler */
class rg$3 implements Runnable {
    final /* synthetic */ rg a;

    rg$3(rg rgVar) {
        this.a = rgVar;
    }

    public void run() {
        try {
            this.a.b.a();
        } catch (Exception e) {
            akp.h().e("Answers", "Failed to send events files", e);
        }
    }
}
