package defpackage;

import android.os.Looper;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.EngineRunnable;
import com.bumptech.glide.load.engine.EngineRunnable.a;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/* compiled from: Engine */
public class ku implements kw, kz$a, lt$a {
    private final Map<kf, kv> a;
    private final ky b;
    private final lt c;
    private final ku$a d;
    private final Map<kf, WeakReference<kz<?>>> e;
    private final lc f;
    private final ku$b g;
    private ReferenceQueue<kz<?>> h;

    public ku(lt memoryCache, lm$a diskCacheFactory, ExecutorService diskCacheService, ExecutorService sourceService) {
        this(memoryCache, diskCacheFactory, diskCacheService, sourceService, null, null, null, null, null);
    }

    ku(lt cache, lm$a diskCacheFactory, ExecutorService diskCacheService, ExecutorService sourceService, Map<kf, kv> jobs, ky keyFactory, Map<kf, WeakReference<kz<?>>> activeResources, ku$a engineJobFactory, lc resourceRecycler) {
        this.c = cache;
        this.g = new ku$b(diskCacheFactory);
        if (activeResources == null) {
            activeResources = new HashMap();
        }
        this.e = activeResources;
        if (keyFactory == null) {
            keyFactory = new ky();
        }
        this.b = keyFactory;
        if (jobs == null) {
            jobs = new HashMap();
        }
        this.a = jobs;
        if (engineJobFactory == null) {
            engineJobFactory = new ku$a(diskCacheService, sourceService, this);
        }
        this.d = engineJobFactory;
        if (resourceRecycler == null) {
            resourceRecycler = new lc();
        }
        this.f = resourceRecycler;
        cache.a((lt$a) this);
    }

    public <T, Z, R> ku$c a(kf signature, int width, int height, km<T> fetcher, pq<T, Z> loadProvider, kj<Z> transformation, ox<Z, R> transcoder, Priority priority, boolean isMemoryCacheable, DiskCacheStrategy diskCacheStrategy, py cb) {
        ra.a();
        long startTime = qw.a();
        kf key = this.b.a(fetcher.b(), signature, width, height, loadProvider.a(), loadProvider.b(), transformation, loadProvider.d(), transcoder, loadProvider.c());
        kz<?> cached = b(key, isMemoryCacheable);
        if (cached != null) {
            cb.a((lb) cached);
            if (Log.isLoggable("Engine", 2)) {
                ku.a("Loaded resource from cache", startTime, key);
            }
            return null;
        }
        kz<?> active = a(key, isMemoryCacheable);
        if (active != null) {
            cb.a((lb) active);
            if (Log.isLoggable("Engine", 2)) {
                ku.a("Loaded resource from active resources", startTime, key);
            }
            return null;
        }
        kv current = (kv) this.a.get(key);
        if (current != null) {
            current.a(cb);
            if (Log.isLoggable("Engine", 2)) {
                ku.a("Added to existing load", startTime, key);
            }
            return new ku$c(cb, current);
        }
        kv engineJob = this.d.a(key, isMemoryCacheable);
        a aVar = engineJob;
        EngineRunnable engineRunnable = new EngineRunnable(aVar, new kt(key, width, height, fetcher, loadProvider, transformation, transcoder, this.g, diskCacheStrategy, priority), priority);
        this.a.put(key, engineJob);
        engineJob.a(cb);
        engineJob.a(engineRunnable);
        if (Log.isLoggable("Engine", 2)) {
            ku.a("Started new load", startTime, key);
        }
        return new ku$c(cb, engineJob);
    }

    private static void a(String log, long startTime, kf key) {
        Log.v("Engine", log + " in " + qw.a(startTime) + "ms, key: " + key);
    }

    private kz<?> a(kf key, boolean isMemoryCacheable) {
        if (!isMemoryCacheable) {
            return null;
        }
        WeakReference<kz<?>> activeRef = (WeakReference) this.e.get(key);
        if (activeRef == null) {
            return null;
        }
        kz<?> active = (kz) activeRef.get();
        if (active != null) {
            active.e();
            return active;
        }
        this.e.remove(key);
        return active;
    }

    private kz<?> b(kf key, boolean isMemoryCacheable) {
        if (!isMemoryCacheable) {
            return null;
        }
        kz<?> cached = a(key);
        if (cached == null) {
            return cached;
        }
        cached.e();
        this.e.put(key, new ku$e(key, cached, a()));
        return cached;
    }

    private kz<?> a(kf key) {
        lb<?> cached = this.c.a(key);
        if (cached == null) {
            return null;
        }
        if (cached instanceof kz) {
            return (kz) cached;
        }
        return new kz(cached, true);
    }

    public void a(lb resource) {
        ra.a();
        if (resource instanceof kz) {
            ((kz) resource).f();
            return;
        }
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }

    public void a(kf key, kz<?> resource) {
        ra.a();
        if (resource != null) {
            resource.a(key, this);
            if (resource.a()) {
                this.e.put(key, new ku$e(key, resource, a()));
            }
        }
        this.a.remove(key);
    }

    public void a(kv engineJob, kf key) {
        ra.a();
        if (engineJob.equals((kv) this.a.get(key))) {
            this.a.remove(key);
        }
    }

    public void b(lb<?> resource) {
        ra.a();
        this.f.a(resource);
    }

    public void b(kf cacheKey, kz resource) {
        ra.a();
        this.e.remove(cacheKey);
        if (resource.a()) {
            this.c.b(cacheKey, resource);
        } else {
            this.f.a(resource);
        }
    }

    private ReferenceQueue<kz<?>> a() {
        if (this.h == null) {
            this.h = new ReferenceQueue();
            Looper.myQueue().addIdleHandler(new ku$d(this.e, this.h));
        }
        return this.h;
    }
}
