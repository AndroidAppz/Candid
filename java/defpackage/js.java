package defpackage;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: DiskLruCache */
public final class js implements Closeable {
    final ThreadPoolExecutor a = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private final File b;
    private final File c;
    private final File d;
    private final File e;
    private final int f;
    private long g;
    private final int h;
    private long i = 0;
    private Writer j;
    private final LinkedHashMap<String, js$b> k = new LinkedHashMap(0, 0.75f, true);
    private int l;
    private long m = 0;
    private final Callable<Void> n = new js$1(this);

    private js(File directory, int appVersion, int valueCount, long maxSize) {
        this.b = directory;
        this.f = appVersion;
        this.c = new File(directory, "journal");
        this.d = new File(directory, "journal.tmp");
        this.e = new File(directory, "journal.bkp");
        this.h = valueCount;
        this.g = maxSize;
    }

    public static js a(File directory, int appVersion, int valueCount, long maxSize) throws IOException {
        if (maxSize <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (valueCount <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        } else {
            File backupFile = new File(directory, "journal.bkp");
            if (backupFile.exists()) {
                File journalFile = new File(directory, "journal");
                if (journalFile.exists()) {
                    backupFile.delete();
                } else {
                    js.a(backupFile, journalFile, false);
                }
            }
            js cache = new js(directory, appVersion, valueCount, maxSize);
            if (cache.c.exists()) {
                try {
                    cache.b();
                    cache.c();
                    return cache;
                } catch (IOException journalIsCorrupt) {
                    System.out.println("DiskLruCache " + directory + " is corrupt: " + journalIsCorrupt.getMessage() + ", removing");
                    cache.a();
                }
            }
            directory.mkdirs();
            cache = new js(directory, appVersion, valueCount, maxSize);
            cache.d();
            return cache;
        }
    }

    private void b() throws IOException {
        int lineCount;
        Closeable reader = new jt(new FileInputStream(this.c), ju.a);
        try {
            String magic = reader.a();
            String version = reader.a();
            String appVersionString = reader.a();
            String valueCountString = reader.a();
            String blank = reader.a();
            if ("libcore.io.DiskLruCache".equals(magic) && "1".equals(version) && Integer.toString(this.f).equals(appVersionString) && Integer.toString(this.h).equals(valueCountString) && "".equals(blank)) {
                lineCount = 0;
                while (true) {
                    d(reader.a());
                    lineCount++;
                }
            } else {
                throw new IOException("unexpected journal header: [" + magic + ", " + version + ", " + valueCountString + ", " + blank + "]");
            }
        } catch (EOFException e) {
            this.l = lineCount - this.k.size();
            if (reader.b()) {
                d();
            } else {
                this.j = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.c, true), ju.a));
            }
            ju.a(reader);
        } catch (Throwable th) {
            ju.a(reader);
        }
    }

    private void d(String line) throws IOException {
        int firstSpace = line.indexOf(32);
        if (firstSpace == -1) {
            throw new IOException("unexpected journal line: " + line);
        }
        String key;
        int keyBegin = firstSpace + 1;
        int secondSpace = line.indexOf(32, keyBegin);
        if (secondSpace == -1) {
            key = line.substring(keyBegin);
            if (firstSpace == "REMOVE".length() && line.startsWith("REMOVE")) {
                this.k.remove(key);
                return;
            }
        }
        key = line.substring(keyBegin, secondSpace);
        js$b entry = (js$b) this.k.get(key);
        if (entry == null) {
            entry = new js$b(this, key, null);
            this.k.put(key, entry);
        }
        if (secondSpace != -1 && firstSpace == "CLEAN".length() && line.startsWith("CLEAN")) {
            String[] parts = line.substring(secondSpace + 1).split(" ");
            entry.f = true;
            entry.g = null;
            entry.a(parts);
        } else if (secondSpace == -1 && firstSpace == "DIRTY".length() && line.startsWith("DIRTY")) {
            entry.g = new js$a(this, entry, null);
        } else if (secondSpace != -1 || firstSpace != "READ".length() || !line.startsWith("READ")) {
            throw new IOException("unexpected journal line: " + line);
        }
    }

    private void c() throws IOException {
        js.a(this.d);
        Iterator<js$b> i = this.k.values().iterator();
        while (i.hasNext()) {
            js$b entry = (js$b) i.next();
            int t;
            if (entry.g == null) {
                for (t = 0; t < this.h; t++) {
                    this.i += entry.e[t];
                }
            } else {
                entry.g = null;
                for (t = 0; t < this.h; t++) {
                    js.a(entry.a(t));
                    js.a(entry.b(t));
                }
                i.remove();
            }
        }
    }

    private synchronized void d() throws IOException {
        if (this.j != null) {
            this.j.close();
        }
        Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.d), ju.a));
        try {
            writer.write("libcore.io.DiskLruCache");
            writer.write("\n");
            writer.write("1");
            writer.write("\n");
            writer.write(Integer.toString(this.f));
            writer.write("\n");
            writer.write(Integer.toString(this.h));
            writer.write("\n");
            writer.write("\n");
            for (js$b entry : this.k.values()) {
                if (entry.g != null) {
                    writer.write("DIRTY " + entry.d + '\n');
                } else {
                    writer.write("CLEAN " + entry.d + entry.a() + '\n');
                }
            }
            if (this.c.exists()) {
                js.a(this.c, this.e, true);
            }
            js.a(this.d, this.c, false);
            this.e.delete();
            this.j = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.c, true), ju.a));
        } finally {
            writer.close();
        }
    }

    private static void a(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void a(File from, File to, boolean deleteDestination) throws IOException {
        if (deleteDestination) {
            js.a(to);
        }
        if (!from.renameTo(to)) {
            throw new IOException();
        }
    }

    public synchronized js$c a(String key) throws IOException {
        js$c js_c = null;
        synchronized (this) {
            f();
            js$b entry = (js$b) this.k.get(key);
            if (entry != null) {
                if (entry.f) {
                    for (File file : entry.a) {
                        if (!file.exists()) {
                            break;
                        }
                    }
                    this.l++;
                    this.j.append("READ");
                    this.j.append(' ');
                    this.j.append(key);
                    this.j.append('\n');
                    if (e()) {
                        this.a.submit(this.n);
                    }
                    js_c = new js$c(this, key, entry.h, entry.a, entry.e, null);
                }
            }
        }
        return js_c;
    }

    public js$a b(String key) throws IOException {
        return a(key, -1);
    }

    private synchronized js$a a(String key, long expectedSequenceNumber) throws IOException {
        js$a js_a = null;
        synchronized (this) {
            f();
            js$b entry = (js$b) this.k.get(key);
            if (expectedSequenceNumber == -1 || (entry != null && entry.h == expectedSequenceNumber)) {
                if (entry == null) {
                    entry = new js$b(this, key, null);
                    this.k.put(key, entry);
                } else if (entry.g != null) {
                }
                js_a = new js$a(this, entry, null);
                entry.g = js_a;
                this.j.append("DIRTY");
                this.j.append(' ');
                this.j.append(key);
                this.j.append('\n');
                this.j.flush();
            }
        }
        return js_a;
    }

    private synchronized void a(js$a editor, boolean success) throws IOException {
        js$b entry = editor.b;
        if (entry.g != editor) {
            throw new IllegalStateException();
        }
        int i;
        if (success) {
            if (!entry.f) {
                i = 0;
                while (i < this.h) {
                    if (!editor.c[i]) {
                        editor.b();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                    } else if (!entry.b(i).exists()) {
                        editor.b();
                        break;
                    } else {
                        i++;
                    }
                }
            }
        }
        for (i = 0; i < this.h; i++) {
            File dirty = entry.b(i);
            if (!success) {
                js.a(dirty);
            } else if (dirty.exists()) {
                File clean = entry.a(i);
                dirty.renameTo(clean);
                long oldLength = entry.e[i];
                long newLength = clean.length();
                entry.e[i] = newLength;
                this.i = (this.i - oldLength) + newLength;
            }
        }
        this.l++;
        entry.g = null;
        if ((entry.f | success) != 0) {
            entry.f = true;
            this.j.append("CLEAN");
            this.j.append(' ');
            this.j.append(entry.d);
            this.j.append(entry.a());
            this.j.append('\n');
            if (success) {
                long j = this.m;
                this.m = 1 + j;
                entry.h = j;
            }
        } else {
            this.k.remove(entry.d);
            this.j.append("REMOVE");
            this.j.append(' ');
            this.j.append(entry.d);
            this.j.append('\n');
        }
        this.j.flush();
        if (this.i > this.g || e()) {
            this.a.submit(this.n);
        }
    }

    private boolean e() {
        return this.l >= 2000 && this.l >= this.k.size();
    }

    public synchronized boolean c(String key) throws IOException {
        boolean z;
        f();
        js$b entry = (js$b) this.k.get(key);
        if (entry == null || entry.g != null) {
            z = false;
        } else {
            int i = 0;
            while (i < this.h) {
                File file = entry.a(i);
                if (!file.exists() || file.delete()) {
                    this.i -= entry.e[i];
                    entry.e[i] = 0;
                    i++;
                } else {
                    throw new IOException("failed to delete " + file);
                }
            }
            this.l++;
            this.j.append("REMOVE");
            this.j.append(' ');
            this.j.append(key);
            this.j.append('\n');
            this.k.remove(key);
            if (e()) {
                this.a.submit(this.n);
            }
            z = true;
        }
        return z;
    }

    private void f() {
        if (this.j == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public synchronized void close() throws IOException {
        if (this.j != null) {
            Iterator i$ = new ArrayList(this.k.values()).iterator();
            while (i$.hasNext()) {
                js$b entry = (js$b) i$.next();
                if (entry.g != null) {
                    entry.g.b();
                }
            }
            g();
            this.j.close();
            this.j = null;
        }
    }

    private void g() throws IOException {
        while (this.i > this.g) {
            c((String) ((Entry) this.k.entrySet().iterator().next()).getKey());
        }
    }

    public void a() throws IOException {
        close();
        ju.a(this.b);
    }
}
