package defpackage;

import java.util.concurrent.Executor;

/* compiled from: PriorityAsyncTask */
class alw$a<Result> implements Executor {
    private final Executor a;
    private final alw b;

    public alw$a(Executor ex, alw task) {
        this.a = ex;
        this.b = task;
    }

    public void execute(Runnable command) {
        this.a.execute(new alw$a$1(this, command, null));
    }
}
