package defpackage;

/* compiled from: SessionSettingsData */
public class anr {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final boolean f;

    public anr(int logBufferSize, int maxChainedExceptionDepth, int maxCustomExceptionEvents, int maxCustomKeyValuePairs, int identifierMask, boolean sendSessionWithoutCrash) {
        this.a = logBufferSize;
        this.b = maxChainedExceptionDepth;
        this.c = maxCustomExceptionEvents;
        this.d = maxCustomKeyValuePairs;
        this.e = identifierMask;
        this.f = sendSessionWithoutCrash;
    }
}
