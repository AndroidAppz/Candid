package defpackage;

import com.crashlytics.android.answers.SessionEvent.a;

/* compiled from: AnswersEventsHandler */
class rg$6 implements Runnable {
    final /* synthetic */ a a;
    final /* synthetic */ boolean b;
    final /* synthetic */ rg c;

    rg$6(rg rgVar, a aVar, boolean z) {
        this.c = rgVar;
        this.a = aVar;
        this.b = z;
    }

    public void run() {
        try {
            this.c.b.a(this.a);
            if (this.b) {
                this.c.b.c();
            }
        } catch (Exception e) {
            akp.h().e("Answers", "Failed to process event", e);
        }
    }
}
