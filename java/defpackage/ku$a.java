package defpackage;

import java.util.concurrent.ExecutorService;

/* compiled from: Engine */
class ku$a {
    private final ExecutorService a;
    private final ExecutorService b;
    private final kw c;

    public ku$a(ExecutorService diskCacheService, ExecutorService sourceService, kw listener) {
        this.a = diskCacheService;
        this.b = sourceService;
        this.c = listener;
    }

    public kv a(kf key, boolean isMemoryCacheable) {
        return new kv(key, this.a, this.b, isMemoryCacheable, this.c);
    }
}
