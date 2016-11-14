package defpackage;

import com.bumptech.glide.Priority;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

/* compiled from: ByteArrayFetcher */
public class kl implements km<InputStream> {
    private final byte[] a;
    private final String b;

    public /* synthetic */ Object b(Priority x0) throws Exception {
        return a(x0);
    }

    public kl(byte[] bytes, String id) {
        this.a = bytes;
        this.b = id;
    }

    public InputStream a(Priority priority) {
        return new ByteArrayInputStream(this.a);
    }

    public void a() {
    }

    public String b() {
        return this.b;
    }

    public void c() {
    }
}
