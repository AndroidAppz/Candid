package defpackage;

import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import java.util.ListIterator;
import java.util.zip.ZipFile;

/* compiled from: MultiDex */
final class ap$c {
    private static void b(ClassLoader loader, List<File> additionalClassPathEntries) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, IOException {
        int extraSize = additionalClassPathEntries.size();
        Field pathField = ap.b(loader, "path");
        StringBuilder path = new StringBuilder((String) pathField.get(loader));
        Object[] extraPaths = new String[extraSize];
        Object[] extraFiles = new File[extraSize];
        Object[] extraZips = new ZipFile[extraSize];
        Object[] extraDexs = new DexFile[extraSize];
        ListIterator<File> iterator = additionalClassPathEntries.listIterator();
        while (iterator.hasNext()) {
            File additionalEntry = (File) iterator.next();
            String entryPath = additionalEntry.getAbsolutePath();
            path.append(':').append(entryPath);
            int index = iterator.previousIndex();
            extraPaths[index] = entryPath;
            extraFiles[index] = additionalEntry;
            extraZips[index] = new ZipFile(additionalEntry);
            extraDexs[index] = DexFile.loadDex(entryPath, entryPath + ".dex", 0);
        }
        pathField.set(loader, path.toString());
        ap.b((Object) loader, "mPaths", extraPaths);
        ap.b((Object) loader, "mFiles", extraFiles);
        ap.b((Object) loader, "mZips", extraZips);
        ap.b((Object) loader, "mDexs", extraDexs);
    }
}
