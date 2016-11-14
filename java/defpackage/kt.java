package defpackage;

import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import java.io.IOException;

/* compiled from: DecodeJob */
public class kt<A, T, Z> {
    private static final kt$b a = new kt$b();
    private final kx b;
    private final int c;
    private final int d;
    private final km<A> e;
    private final pq<A, T> f;
    private final kj<T> g;
    private final ox<T, Z> h;
    private final kt$a i;
    private final DiskCacheStrategy j;
    private final Priority k;
    private final kt$b l;
    private volatile boolean m;

    private defpackage.lb<T> a(defpackage.kf r6) throws java.io.IOException {
        /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextEntry(HashMap.java:789)
	at java.util.HashMap$KeyIterator.next(HashMap.java:814)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:286)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:173)
*/
        /*
        r5 = this;
        r2 = r5.i;
        r2 = r2.a();
        r0 = r2.a(r6);
        if (r0 != 0) goto L_0x000e;
    L_0x000c:
        r1 = 0;
    L_0x000d:
        return r1;
    L_0x000e:
        r1 = 0;
        r2 = r5.f;	 Catch:{ all -> 0x0029 }
        r2 = r2.a();	 Catch:{ all -> 0x0029 }
        r3 = r5.c;	 Catch:{ all -> 0x0029 }
        r4 = r5.d;	 Catch:{ all -> 0x0029 }
        r1 = r2.a(r0, r3, r4);	 Catch:{ all -> 0x0029 }
        if (r1 != 0) goto L_0x000d;
    L_0x001f:
        r2 = r5.i;
        r2 = r2.a();
        r2.b(r6);
        goto L_0x000d;
    L_0x0029:
        r2 = move-exception;
        if (r1 != 0) goto L_0x0035;
    L_0x002c:
        r3 = r5.i;
        r3 = r3.a();
        r3.b(r6);
    L_0x0035:
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: kt.a(kf):lb<T>");
    }

    public kt(kx resultKey, int width, int height, km<A> fetcher, pq<A, T> loadProvider, kj<T> transformation, ox<T, Z> transcoder, kt$a diskCacheProvider, DiskCacheStrategy diskCacheStrategy, Priority priority) {
        this(resultKey, width, height, fetcher, loadProvider, transformation, transcoder, diskCacheProvider, diskCacheStrategy, priority, a);
    }

    kt(kx resultKey, int width, int height, km<A> fetcher, pq<A, T> loadProvider, kj<T> transformation, ox<T, Z> transcoder, kt$a diskCacheProvider, DiskCacheStrategy diskCacheStrategy, Priority priority, kt$b fileOpener) {
        this.b = resultKey;
        this.c = width;
        this.d = height;
        this.e = fetcher;
        this.f = loadProvider;
        this.g = transformation;
        this.h = transcoder;
        this.i = diskCacheProvider;
        this.j = diskCacheStrategy;
        this.k = priority;
        this.l = fileOpener;
    }

    public lb<Z> a() throws Exception {
        if (!this.j.b()) {
            return null;
        }
        long startTime = qw.a();
        lb<T> transformed = a(this.b);
        if (Log.isLoggable("DecodeJob", 2)) {
            a("Decoded transformed from cache", startTime);
        }
        startTime = qw.a();
        lb<Z> result = d(transformed);
        if (!Log.isLoggable("DecodeJob", 2)) {
            return result;
        }
        a("Transcoded transformed from cache", startTime);
        return result;
    }

    public lb<Z> b() throws Exception {
        if (!this.j.a()) {
            return null;
        }
        long startTime = qw.a();
        lb decoded = a(this.b.a());
        if (Log.isLoggable("DecodeJob", 2)) {
            a("Decoded source from cache", startTime);
        }
        return a(decoded);
    }

    public lb<Z> c() throws Exception {
        return a(e());
    }

    public void d() {
        this.m = true;
        this.e.c();
    }

    private lb<Z> a(lb<T> decoded) {
        long startTime = qw.a();
        lb transformed = c(decoded);
        if (Log.isLoggable("DecodeJob", 2)) {
            a("Transformed resource from source", startTime);
        }
        b(transformed);
        startTime = qw.a();
        lb<Z> result = d(transformed);
        if (Log.isLoggable("DecodeJob", 2)) {
            a("Transcoded transformed from source", startTime);
        }
        return result;
    }

    private void b(lb<T> transformed) {
        if (transformed != null && this.j.b()) {
            long startTime = qw.a();
            this.i.a().a(this.b, new kt$c(this, this.f.d(), transformed));
            if (Log.isLoggable("DecodeJob", 2)) {
                a("Wrote transformed from source to cache", startTime);
            }
        }
    }

    private lb<T> e() throws Exception {
        try {
            long startTime = qw.a();
            Object data = this.e.b(this.k);
            if (Log.isLoggable("DecodeJob", 2)) {
                a("Fetched data", startTime);
            }
            if (this.m) {
                return null;
            }
            lb<T> decoded = a(data);
            this.e.a();
            return decoded;
        } finally {
            this.e.a();
        }
    }

    private lb<T> a(A data) throws IOException {
        if (this.j.a()) {
            return b((Object) data);
        }
        long startTime = qw.a();
        lb<T> decoded = this.f.b().a(data, this.c, this.d);
        if (!Log.isLoggable("DecodeJob", 2)) {
            return decoded;
        }
        a("Decoded from source", startTime);
        return decoded;
    }

    private lb<T> b(A data) throws IOException {
        long startTime = qw.a();
        this.i.a().a(this.b.a(), new kt$c(this, this.f.c(), data));
        if (Log.isLoggable("DecodeJob", 2)) {
            a("Wrote source to cache", startTime);
        }
        startTime = qw.a();
        lb<T> result = a(this.b.a());
        if (Log.isLoggable("DecodeJob", 2) && result != null) {
            a("Decoded source from cache", startTime);
        }
        return result;
    }

    private lb<T> c(lb<T> decoded) {
        if (decoded == null) {
            return null;
        }
        lb<T> transformed = this.g.a(decoded, this.c, this.d);
        if (decoded.equals(transformed)) {
            return transformed;
        }
        decoded.d();
        return transformed;
    }

    private lb<Z> d(lb<T> transformed) {
        if (transformed == null) {
            return null;
        }
        return this.h.a(transformed);
    }

    private void a(String message, long startTime) {
        Log.v("DecodeJob", message + " in " + qw.a(startTime) + ", key: " + this.b);
    }
}
