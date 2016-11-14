package defpackage;

import rx.internal.util.RxThreadFactory;

/* compiled from: NewThreadScheduler */
public final class asg extends apg {
    private static final RxThreadFactory b = new RxThreadFactory("RxNewThreadScheduler-");
    private static final asg c = new asg();

    public static asg a() {
        return c;
    }

    private asg() {
    }

    public apg$a createWorker() {
        return new aql(b);
    }
}
