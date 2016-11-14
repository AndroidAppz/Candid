package defpackage;

import java.io.File;
import java.io.FileFilter;

/* compiled from: MultiDexExtractor */
class aq$1 implements FileFilter {
    final /* synthetic */ String a;

    aq$1(String str) {
        this.a = str;
    }

    public boolean accept(File pathname) {
        return !pathname.getName().startsWith(this.a);
    }
}
