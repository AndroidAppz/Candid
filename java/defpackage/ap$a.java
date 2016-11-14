package defpackage;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MultiDex */
final class ap$a {
    private static void b(ClassLoader loader, List<File> additionalClassPathEntries, File optimizedDirectory) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
        Object dexPathList = ap.b(loader, "pathList").get(loader);
        ap.b(dexPathList, "dexElements", ap$a.a(dexPathList, new ArrayList(additionalClassPathEntries), optimizedDirectory));
    }

    private static Object[] a(Object dexPathList, ArrayList<File> files, File optimizedDirectory) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return (Object[]) ap.b(dexPathList, "makeDexElements", ArrayList.class, File.class).invoke(dexPathList, new Object[]{files, optimizedDirectory});
    }
}
