package defpackage;

import java.io.File;
import java.util.concurrent.Callable;

/* compiled from: FacebookSdk */
class ud$2 implements Callable<File> {
    ud$2() {
    }

    public /* synthetic */ Object call() throws Exception {
        return a();
    }

    public File a() throws Exception {
        return ud.m.getCacheDir();
    }
}
