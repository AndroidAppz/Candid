/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.Log
 *  dalvik.system.DexFile
 *  java.io.File
 *  java.io.IOException
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.ClassLoader
 *  java.lang.Exception
 *  java.lang.IllegalAccessException
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.NoSuchFieldException
 *  java.lang.NoSuchMethodException
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.lang.reflect.Array
 *  java.lang.reflect.Field
 *  java.lang.reflect.InvocationTargetException
 *  java.lang.reflect.Method
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 *  java.util.ListIterator
 *  java.util.Set
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 *  java.util.zip.ZipFile
 */
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipFile;

public final class ap {
    private static final String a = "code_cache" + File.separator + "secondary-dexes";
    private static final Set<String> b = new HashSet();
    private static final boolean c = ap.a(System.getProperty((String)"java.vm.version"));

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public static void a(Context var0) {
        Log.i((String)"MultiDex", (String)"install");
        if (ap.c) {
            Log.i((String)"MultiDex", (String)"VM has multidex support, MultiDex support library is disabled.");
            return;
        }
        if (Build.VERSION.SDK_INT < 4) {
            throw new RuntimeException("Multi dex installation failed. SDK " + Build.VERSION.SDK_INT + " is unsupported. Min SDK version is " + 4 + ".");
        }
        try {
            var4_1 = ap.b(var0);
            if (var4_1 == null) return;
            var22_3 = var5_2 = ap.b;
            // MONITORENTER : var22_3
            var7_4 = var4_1.sourceDir;
        }
        catch (Exception var2_5) {
            Log.e((String)"MultiDex", (String)"Multidex installation failure", (Throwable)var2_5);
            throw new RuntimeException("Multi dex installation failed (" + var2_5.getMessage() + ").");
        }
        if (ap.b.contains((Object)var7_4)) {
            // MONITOREXIT : var22_3
            return;
        }
        ap.b.add((Object)var7_4);
        if (Build.VERSION.SDK_INT > 20) {
            Log.w((String)"MultiDex", (String)("MultiDex is not guaranteed to work in SDK version " + Build.VERSION.SDK_INT + ": SDK version higher than " + 20 + " should be backed by " + "runtime with built-in multidex capabilty but it's not the " + "case here: java.vm.version=\"" + System.getProperty((String)"java.vm.version") + "\""));
        }
        try {
            var11_6 = var0.getClassLoader();
            ** if (var11_6 != null) goto lbl-1000
        }
        catch (RuntimeException var9_7) {
            Log.w((String)"MultiDex", (String)"Failure while trying to obtain Context class loader. Must be running in test mode. Skip patching.", (Throwable)var9_7);
            // MONITOREXIT : var22_3
            return;
        }
lbl-1000: // 1 sources:
        {
            Log.e((String)"MultiDex", (String)"Context class loader is null. Must be running in test mode. Skip patching.");
            // MONITOREXIT : var22_3
            return;
        }
lbl-1000: // 1 sources:
        {
        }
        try {
            ap.c(var0);
        }
        catch (Throwable var12_10) {
            Log.w((String)"MultiDex", (String)"Something went wrong when trying to clear old MultiDex extraction, continuing without cleaning.", (Throwable)var12_10);
        }
        if (ap.a(var15_9 = aq.a(var0, var4_1, var14_8 = new File(var4_1.dataDir, ap.a), false))) {
            ap.a(var11_6, var14_8, var15_9);
        } else {
            Log.w((String)"MultiDex", (String)"Files were not valid zip files.  Forcing a reload.");
            var17_11 = aq.a(var0, var4_1, var14_8, true);
            if (ap.a(var17_11) == false) throw new RuntimeException("Zip files were not valid.");
            ap.a(var11_6, var14_8, var17_11);
        }
        // MONITOREXIT : var22_3
        Log.i((String)"MultiDex", (String)"install done");
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static void a(ClassLoader classLoader, File file, List<File> list) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException {
        if (list.isEmpty()) return;
        if (Build.VERSION.SDK_INT >= 19) {
            b.b(classLoader, list, file);
            return;
        }
        if (Build.VERSION.SDK_INT >= 14) {
            a.b(classLoader, list, file);
            return;
        }
        c.b(classLoader, list);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static boolean a(String string2) {
        boolean bl2 = false;
        if (string2 != null) {
            Matcher matcher = Pattern.compile((String)"(\\d+)\\.(\\d+)(\\.\\d+)?").matcher((CharSequence)string2);
            boolean bl3 = matcher.matches();
            bl2 = false;
            if (bl3) {
                try {
                    int n2 = Integer.parseInt((String)matcher.group(1));
                    int n3 = Integer.parseInt((String)matcher.group(2));
                    bl2 = n2 > 2 || n2 == 2 && n3 >= 1;
                }
                catch (NumberFormatException var7_8) {
                    bl2 = false;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder().append("VM with version ").append(string2);
        String string3 = bl2 ? " has multidex support" : " does not have multidex support";
        Log.i((String)"MultiDex", (String)stringBuilder.append(string3).toString());
        return bl2;
    }

    private static boolean a(List<File> list) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            if (aq.a((File)iterator.next())) continue;
            return false;
        }
        return true;
    }

    private static ApplicationInfo b(Context context) throws PackageManager.NameNotFoundException {
        PackageManager packageManager;
        String string2;
        try {
            packageManager = context.getPackageManager();
            string2 = context.getPackageName();
            if (packageManager == null || string2 == null) {
                return null;
            }
        }
        catch (RuntimeException var1_3) {
            Log.w((String)"MultiDex", (String)"Failure while trying to obtain ApplicationInfo from Context. Must be running in test mode. Skip patching.", (Throwable)var1_3);
            return null;
        }
        return packageManager.getApplicationInfo(string2, 128);
    }

    private static Field b(Object object, String string2) throws NoSuchFieldException {
        for (Class class_ = object.getClass(); class_ != null; class_ = class_.getSuperclass()) {
            try {
                Field field = class_.getDeclaredField(string2);
                if (!field.isAccessible()) {
                    field.setAccessible(true);
                }
                return field;
            }
            catch (NoSuchFieldException var3_3) {
                continue;
            }
        }
        throw new NoSuchFieldException("Field " + string2 + " not found in " + (Object)object.getClass());
    }

    private static /* varargs */ Method b(Object object, String string2, Class<?> ... arrclass) throws NoSuchMethodException {
        for (Class class_ = object.getClass(); class_ != null; class_ = class_.getSuperclass()) {
            try {
                Method method = class_.getDeclaredMethod(string2, arrclass);
                if (!method.isAccessible()) {
                    method.setAccessible(true);
                }
                return method;
            }
            catch (NoSuchMethodException var4_4) {
                continue;
            }
        }
        throw new NoSuchMethodException("Method " + string2 + " with parameters " + (Object)Arrays.asList((Object[])arrclass) + " not found in " + (Object)object.getClass());
    }

    private static void b(Object object, String string2, Object[] arrobject) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field field = ap.b(object, string2);
        Object[] arrobject2 = (Object[])field.get(object);
        Object[] arrobject3 = (Object[])Array.newInstance((Class)arrobject2.getClass().getComponentType(), (int)(arrobject2.length + arrobject.length));
        System.arraycopy((Object)arrobject2, (int)0, (Object)arrobject3, (int)0, (int)arrobject2.length);
        System.arraycopy((Object)arrobject, (int)0, (Object)arrobject3, (int)arrobject2.length, (int)arrobject.length);
        field.set(object, (Object)arrobject3);
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private static void c(Context context) throws Exception {
        File file = new File(context.getFilesDir(), "secondary-dexes");
        if (!file.isDirectory()) return;
        Log.i((String)"MultiDex", (String)("Clearing old secondary dex dir (" + file.getPath() + ")."));
        File[] arrfile = file.listFiles();
        if (arrfile == null) {
            Log.w((String)"MultiDex", (String)("Failed to list secondary dex dir content (" + file.getPath() + ")."));
            return;
        }
        for (File file2 : arrfile) {
            Log.i((String)"MultiDex", (String)("Trying to delete old file " + file2.getPath() + " of size " + file2.length()));
            if (!file2.delete()) {
                Log.w((String)"MultiDex", (String)("Failed to delete old file " + file2.getPath()));
                continue;
            }
            Log.i((String)"MultiDex", (String)("Deleted old file " + file2.getPath()));
        }
        if (!file.delete()) {
            Log.w((String)"MultiDex", (String)("Failed to delete secondary dex dir " + file.getPath()));
            return;
        }
        Log.i((String)"MultiDex", (String)("Deleted old secondary dex dir " + file.getPath()));
    }

    static final class a {
        private static Object[] a(Object object, ArrayList<File> arrayList, File file) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
            return (Object[])ap.b(object, "makeDexElements", new Class[]{ArrayList.class, File.class}).invoke(object, new Object[]{arrayList, file});
        }

        private static void b(ClassLoader classLoader, List<File> list, File file) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
            Object object = ap.b((Object)classLoader, "pathList").get((Object)classLoader);
            ap.b(object, "dexElements", a.a(object, new ArrayList(list), file));
        }
    }

    static final class b {
        private static Object[] a(Object object, ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
            return (Object[])ap.b(object, "makeDexElements", new Class[]{ArrayList.class, File.class, ArrayList.class}).invoke(object, new Object[]{arrayList, file, arrayList2});
        }

        /*
         * Enabled aggressive block sorting
         */
        private static void b(ClassLoader classLoader, List<File> list, File file) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
            Object object = ap.b((Object)classLoader, "pathList").get((Object)classLoader);
            ArrayList arrayList = new ArrayList();
            ap.b(object, "dexElements", b.a(object, new ArrayList(list), file, arrayList));
            if (arrayList.size() > 0) {
                IOException[] arriOException;
                Iterator iterator = arrayList.iterator();
                while (iterator.hasNext()) {
                    Log.w((String)"MultiDex", (String)"Exception in makeDexElement", (Throwable)((IOException)iterator.next()));
                }
                Field field = ap.b((Object)classLoader, "dexElementsSuppressedExceptions");
                IOException[] arriOException2 = (IOException[])field.get((Object)classLoader);
                if (arriOException2 == null) {
                    arriOException = (IOException[])arrayList.toArray((Object[])new IOException[arrayList.size()]);
                } else {
                    Object[] arrobject = new IOException[arrayList.size() + arriOException2.length];
                    arrayList.toArray(arrobject);
                    System.arraycopy((Object)arriOException2, (int)0, (Object)arrobject, (int)arrayList.size(), (int)arriOException2.length);
                    arriOException = arrobject;
                }
                field.set((Object)classLoader, (Object)arriOException);
            }
        }
    }

    static final class c {
        private static void b(ClassLoader classLoader, List<File> list) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, IOException {
            int n2 = list.size();
            Field field = ap.b((Object)classLoader, "path");
            StringBuilder stringBuilder = new StringBuilder((String)field.get((Object)classLoader));
            Object[] arrobject = new String[n2];
            Object[] arrobject2 = new File[n2];
            Object[] arrobject3 = new ZipFile[n2];
            Object[] arrobject4 = new DexFile[n2];
            ListIterator listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                File file = (File)listIterator.next();
                String string2 = file.getAbsolutePath();
                stringBuilder.append(':').append(string2);
                int n3 = listIterator.previousIndex();
                arrobject[n3] = string2;
                arrobject2[n3] = file;
                arrobject3[n3] = new ZipFile(file);
                arrobject4[n3] = DexFile.loadDex((String)string2, (String)(string2 + ".dex"), (int)0);
            }
            field.set((Object)classLoader, (Object)stringBuilder.toString());
            ap.b((Object)classLoader, "mPaths", arrobject);
            ap.b((Object)classLoader, "mFiles", arrobject2);
            ap.b((Object)classLoader, "mZips", arrobject3);
            ap.b((Object)classLoader, "mDexs", arrobject4);
        }
    }

}

