package defpackage;

import java.io.File;
import java.io.InputStream;

/* compiled from: StreamFileDataLoadProvider */
public class od implements pq<InputStream, File> {
    private static final od$a a = new od$a(null);
    private final kh<File, File> b = new oa();
    private final ke<InputStream> c = new mm();

    public kh<File, File> a() {
        return this.b;
    }

    public kh<InputStream, File> b() {
        return a;
    }

    public ke<InputStream> c() {
        return this.c;
    }

    public ki<File> d() {
        return ne.b();
    }
}
