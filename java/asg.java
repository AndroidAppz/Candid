/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.String
 *  java.util.concurrent.ThreadFactory
 *  rx.internal.util.RxThreadFactory
 */
import java.util.concurrent.ThreadFactory;
import rx.internal.util.RxThreadFactory;

public final class asg
extends apg {
    private static final RxThreadFactory b = new RxThreadFactory("RxNewThreadScheduler-");
    private static final asg c = new asg();

    private asg() {
    }

    public static asg a() {
        return c;
    }

    @Override
    public apg.a createWorker() {
        return new aql((ThreadFactory)b);
    }
}

