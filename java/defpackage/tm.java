package defpackage;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: SessionReport */
class tm implements tj {
    private final File a;
    private final Map<String, String> b;

    public tm(File file) {
        this(file, Collections.emptyMap());
    }

    public tm(File file, Map<String, String> customHeaders) {
        this.a = file;
        this.b = new HashMap(customHeaders);
        if (this.a.length() == 0) {
            this.b.putAll(tk.a);
        }
    }

    public File d() {
        return this.a;
    }

    public String b() {
        return d().getName();
    }

    public String c() {
        String fileName = b();
        return fileName.substring(0, fileName.lastIndexOf(46));
    }

    public Map<String, String> e() {
        return Collections.unmodifiableMap(this.b);
    }

    public boolean a() {
        akp.h().a("CrashlyticsCore", "Removing report at " + this.a.getPath());
        return this.a.delete();
    }
}
