package defpackage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: BackgroundManager */
class rl {
    final AtomicReference<ScheduledFuture<?>> a = new AtomicReference();
    boolean b = true;
    private final ScheduledExecutorService c;
    private final List<rl$a> d = new ArrayList();
    private volatile boolean e = true;

    public rl(ScheduledExecutorService executorService) {
        this.c = executorService;
    }

    public void a(boolean flushOnBackground) {
        this.e = flushOnBackground;
    }

    private void c() {
        for (rl$a listener : this.d) {
            listener.a();
        }
    }

    public void a(rl$a listener) {
        this.d.add(listener);
    }

    public void a() {
        this.b = false;
        ScheduledFuture backgroundFuture = (ScheduledFuture) this.a.getAndSet(null);
        if (backgroundFuture != null) {
            backgroundFuture.cancel(false);
        }
    }

    public void b() {
        if (this.e && !this.b) {
            this.b = true;
            try {
                this.a.compareAndSet(null, this.c.schedule(new rl$1(this), 5000, TimeUnit.MILLISECONDS));
            } catch (Throwable e) {
                akp.h().a("Answers", "Failed to schedule background detector", e);
            }
        }
    }
}
