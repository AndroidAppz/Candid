package defpackage;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: DiskLruCache */
final class js$b {
    File[] a;
    File[] b;
    final /* synthetic */ js c;
    private final String d;
    private final long[] e;
    private boolean f;
    private js$a g;
    private long h;

    private js$b(js jsVar, String key) {
        this.c = jsVar;
        this.d = key;
        this.e = new long[jsVar.h];
        this.a = new File[jsVar.h];
        this.b = new File[jsVar.h];
        StringBuilder fileBuilder = new StringBuilder(key).append('.');
        int truncateTo = fileBuilder.length();
        for (int i = 0; i < jsVar.h; i++) {
            fileBuilder.append(i);
            this.a[i] = new File(jsVar.b, fileBuilder.toString());
            fileBuilder.append(".tmp");
            this.b[i] = new File(jsVar.b, fileBuilder.toString());
            fileBuilder.setLength(truncateTo);
        }
    }

    public String a() throws IOException {
        StringBuilder result = new StringBuilder();
        for (long size : this.e) {
            result.append(' ').append(size);
        }
        return result.toString();
    }

    private void a(String[] strings) throws IOException {
        if (strings.length != this.c.h) {
            throw b(strings);
        }
        int i = 0;
        while (i < strings.length) {
            try {
                this.e[i] = Long.parseLong(strings[i]);
                i++;
            } catch (NumberFormatException e) {
                throw b(strings);
            }
        }
    }

    private IOException b(String[] strings) throws IOException {
        throw new IOException("unexpected journal line: " + Arrays.toString(strings));
    }

    public File a(int i) {
        return this.a[i];
    }

    public File b(int i) {
        return this.b[i];
    }
}
