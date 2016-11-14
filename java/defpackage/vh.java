package defpackage;

import com.facebook.LoggingBehavior;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: FileLruCache */
public final class vh {
    static final String a = vh.class.getSimpleName();
    private static final AtomicLong b = new AtomicLong();
    private final String c;
    private final vh$d d;
    private final File e;
    private boolean f;
    private boolean g;
    private final Object h;
    private AtomicLong i = new AtomicLong(0);

    public vh(String tag, vh$d limits) {
        this.c = tag;
        this.d = limits;
        this.e = new File(ud.m(), tag);
        this.h = new Object();
        if (this.e.mkdirs() || this.e.isDirectory()) {
            vh$a.a(this.e);
        }
    }

    public InputStream a(String key) throws IOException {
        return a(key, null);
    }

    public InputStream a(String key, String contentTag) throws IOException {
        File file = new File(this.e, vw.b(key));
        try {
            FileInputStream input = new FileInputStream(file);
            BufferedInputStream buffered = new BufferedInputStream(input, 8192);
            try {
                JSONObject header = vh$g.a(buffered);
                FileInputStream fileInputStream;
                if (header == null) {
                    fileInputStream = input;
                    return null;
                }
                String foundKey = header.optString("key");
                if (foundKey == null || !foundKey.equals(key)) {
                    if (null == null) {
                        buffered.close();
                    }
                    fileInputStream = input;
                    return null;
                }
                String headerContentTag = header.optString("tag", null);
                if ((contentTag != null || headerContentTag == null) && (contentTag == null || contentTag.equals(headerContentTag))) {
                    long accessTime = new Date().getTime();
                    vp.a(LoggingBehavior.CACHE, a, "Setting lastModified to " + Long.valueOf(accessTime) + " for " + file.getName());
                    file.setLastModified(accessTime);
                    if (!true) {
                        buffered.close();
                    }
                    fileInputStream = input;
                    return buffered;
                }
                if (null == null) {
                    buffered.close();
                }
                fileInputStream = input;
                return null;
            } finally {
                if (null == null) {
                    buffered.close();
                }
            }
        } catch (IOException e) {
            return null;
        }
    }

    public OutputStream b(String key) throws IOException {
        return b(key, null);
    }

    public OutputStream b(String key, String contentTag) throws IOException {
        File buffer = vh$a.b(this.e);
        buffer.delete();
        if (buffer.createNewFile()) {
            try {
                BufferedOutputStream buffered = new BufferedOutputStream(new vh$b(new FileOutputStream(buffer), new vh$1(this, System.currentTimeMillis(), buffer, key)), 8192);
                try {
                    JSONObject header = new JSONObject();
                    header.put("key", key);
                    if (!vw.a(contentTag)) {
                        header.put("tag", contentTag);
                    }
                    vh$g.a(buffered, header);
                    if (!true) {
                        buffered.close();
                    }
                    return buffered;
                } catch (JSONException e) {
                    vp.a(LoggingBehavior.CACHE, 5, a, "Error creating JSON header for cache file: " + e);
                    throw new IOException(e.getMessage());
                } catch (Throwable th) {
                    if (!false) {
                        buffered.close();
                    }
                }
            } catch (FileNotFoundException e2) {
                vp.a(LoggingBehavior.CACHE, 5, a, "Error creating buffer output stream: " + e2);
                throw new IOException(e2.getMessage());
            }
        }
        throw new IOException("Could not create file at " + buffer.getAbsolutePath());
    }

    public void a() {
        File[] filesToDelete = this.e.listFiles(vh$a.a());
        this.i.set(System.currentTimeMillis());
        if (filesToDelete != null) {
            ud.d().execute(new vh$2(this, filesToDelete));
        }
    }

    private void a(String key, File buffer) {
        if (!buffer.renameTo(new File(this.e, vw.b(key)))) {
            buffer.delete();
        }
        c();
    }

    public InputStream a(String key, InputStream input) throws IOException {
        return new vh$c(input, b(key));
    }

    public String toString() {
        return "{FileLruCache: tag:" + this.c + " file:" + this.e.getName() + "}";
    }

    private void c() {
        synchronized (this.h) {
            if (!this.f) {
                this.f = true;
                ud.d().execute(new vh$3(this));
            }
        }
    }

    private void d() {
        synchronized (this.h) {
            this.f = false;
            this.g = true;
        }
        try {
            File file;
            vp.a(LoggingBehavior.CACHE, a, "trim started");
            PriorityQueue<vh$e> heap = new PriorityQueue();
            long size = 0;
            long count = 0;
            File[] filesToTrim = this.e.listFiles(vh$a.a());
            if (filesToTrim != null) {
                for (File file2 : filesToTrim) {
                    vh$e modified = new vh$e(file2);
                    heap.add(modified);
                    vp.a(LoggingBehavior.CACHE, a, "  trim considering time=" + Long.valueOf(modified.b()) + " name=" + modified.a().getName());
                    size += file2.length();
                    count++;
                }
            }
            while (true) {
                if (size > ((long) this.d.a()) || count > ((long) this.d.b())) {
                    file2 = ((vh$e) heap.remove()).a();
                    vp.a(LoggingBehavior.CACHE, a, "  trim removing " + file2.getName());
                    size -= file2.length();
                    count--;
                    file2.delete();
                } else {
                    synchronized (this.h) {
                        this.g = false;
                        this.h.notifyAll();
                    }
                    return;
                }
            }
        } catch (Throwable th) {
            synchronized (this.h) {
                this.g = false;
                this.h.notifyAll();
            }
        }
    }
}
