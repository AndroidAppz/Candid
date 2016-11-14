package defpackage;

import android.content.Context;
import java.io.File;

/* compiled from: FileStoreImpl */
public class amz implements amy {
    private final Context a;
    private final String b;
    private final String c;

    public amz(aku kit) {
        if (kit.E() == null) {
            throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
        }
        this.a = kit.E();
        this.b = kit.G();
        this.c = "Android/" + this.a.getPackageName();
    }

    public File a() {
        return a(this.a.getFilesDir());
    }

    File a(File file) {
        if (file == null) {
            akp.h().a("Fabric", "Null File");
        } else if (file.exists() || file.mkdirs()) {
            return file;
        } else {
            akp.h().d("Fabric", "Couldn't create file");
        }
        return null;
    }
}
