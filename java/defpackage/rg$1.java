package defpackage;

/* compiled from: AnswersEventsHandler */
class rg$1 implements Runnable {
    final /* synthetic */ and a;
    final /* synthetic */ String b;
    final /* synthetic */ rg c;

    rg$1(rg rgVar, and and, String str) {
        this.c = rgVar;
        this.a = and;
        this.b = str;
    }

    public void run() {
        try {
            this.c.b.a(this.a, this.b);
        } catch (Exception e) {
            akp.h().e("Answers", "Failed to set analytics settings data", e);
        }
    }
}
