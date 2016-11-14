/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.util.concurrent.TimeUnit
 *  rx.internal.schedulers.ScheduledAction
 */
import android.os.Handler;
import java.util.concurrent.TimeUnit;
import rx.internal.schedulers.ScheduledAction;

public final class apo
extends apg {
    private final Handler b;

    apo(Handler handler) {
        this.b = handler;
    }

    @Override
    public apg.a createWorker() {
        return new a(this.b);
    }

    static class a
    extends apg.a {
        private final Handler a;
        private final asn b = new asn();

        a(Handler handler) {
            this.a = handler;
        }

        @Override
        public apk a(apq apq2) {
            return this.a(apq2, 0, TimeUnit.MILLISECONDS);
        }

        @Override
        public apk a(apq apq2, long l2, TimeUnit timeUnit) {
            if (this.b.isUnsubscribed()) {
                return asq.b();
            }
            final ScheduledAction scheduledAction = new ScheduledAction(apl.a().b().a(apq2));
            scheduledAction.a(this.b);
            this.b.a((apk)scheduledAction);
            this.a.postDelayed((Runnable)scheduledAction, timeUnit.toMillis(l2));
            scheduledAction.a(asq.a(new apq(){

                @Override
                public void call() {
                    a.this.a.removeCallbacks((Runnable)scheduledAction);
                }
            }));
            return scheduledAction;
        }

        @Override
        public boolean isUnsubscribed() {
            return this.b.isUnsubscribed();
        }

        @Override
        public void unsubscribe() {
            this.b.unsubscribe();
        }

    }

}

