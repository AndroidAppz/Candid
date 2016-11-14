package defpackage;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: MultiDex */
final class ap$b {
    private static void b(ClassLoader loader, List<File> additionalClassPathEntries, File optimizedDirectory) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
        Object dexPathList = ap.b(loader, "pathList").get(loader);
        ArrayList<IOException> suppressedExceptions = new ArrayList();
        ap.b(dexPathList, "dexElements", ap$b.a(dexPathList, new ArrayList(additionalClassPathEntries), optimizedDirectory, suppressedExceptions));
        if (suppressedExceptions.size() > 0) {
            Iterator i$ = suppressedExceptions.iterator();
            while (i$.hasNext()) {
                Log.w("MultiDex", "Exception in makeDexElement", (IOException) i$.next());
            }
            Field suppressedExceptionsField = ap.b(loader, "dexElementsSuppressedExceptions");
            IOException[] dexElementsSuppressedExceptions = (IOException[]) suppressedExceptionsField.get(loader);
            if (dexElementsSuppressedExceptions == null) {
                dexElementsSuppressedExceptions = (IOException[]) suppressedExceptions.toArray(new IOException[suppressedExceptions.size()]);
            } else {
                IOException[] combined = new IOException[(suppressedExceptions.size() + dexElementsSuppressedExceptions.length)];
                suppressedExceptions.toArray(combined);
                System.arraycopy(dexElementsSuppressedExceptions, 0, combined, suppressedExceptions.size(), dexElementsSuppressedExceptions.length);
                dexElementsSuppressedExceptions = combined;
            }
            suppressedExceptionsField.set(loader, dexElementsSuppressedExceptions);
        }
    }

    private static Object[] a(Object dexPathList, ArrayList<File> files, File optimizedDirectory, ArrayList<IOException> suppressedExceptions) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return (Object[]) ap.b(dexPathList, "makeDexElements", ArrayList.class, File.class, ArrayList.class).invoke(dexPathList, new Object[]{files, optimizedDirectory, suppressedExceptions});
    }
}
