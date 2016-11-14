package defpackage;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: MultiDex */
public final class ap {
    private static final String a = ("code_cache" + File.separator + "secondary-dexes");
    private static final Set<String> b = new HashSet();
    private static final boolean c = ap.a(System.getProperty("java.vm.version"));

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r11) {
        /*
        r9 = 20;
        r10 = 4;
        r7 = "MultiDex";
        r8 = "install";
        android.util.Log.i(r7, r8);
        r7 = c;
        if (r7 == 0) goto L_0x0016;
    L_0x000e:
        r7 = "MultiDex";
        r8 = "VM has multidex support, MultiDex support library is disabled.";
        android.util.Log.i(r7, r8);
    L_0x0015:
        return;
    L_0x0016:
        r7 = android.os.Build.VERSION.SDK_INT;
        if (r7 >= r10) goto L_0x0045;
    L_0x001a:
        r7 = new java.lang.RuntimeException;
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r9 = "Multi dex installation failed. SDK ";
        r8 = r8.append(r9);
        r9 = android.os.Build.VERSION.SDK_INT;
        r8 = r8.append(r9);
        r9 = " is unsupported. Min SDK version is ";
        r8 = r8.append(r9);
        r8 = r8.append(r10);
        r9 = ".";
        r8 = r8.append(r9);
        r8 = r8.toString();
        r7.<init>(r8);
        throw r7;
    L_0x0045:
        r1 = defpackage.ap.b(r11);	 Catch:{ Exception -> 0x005d }
        if (r1 == 0) goto L_0x0015;
    L_0x004b:
        r8 = b;	 Catch:{ Exception -> 0x005d }
        monitor-enter(r8);	 Catch:{ Exception -> 0x005d }
        r0 = r1.sourceDir;	 Catch:{ all -> 0x005a }
        r7 = b;	 Catch:{ all -> 0x005a }
        r7 = r7.contains(r0);	 Catch:{ all -> 0x005a }
        if (r7 == 0) goto L_0x0088;
    L_0x0058:
        monitor-exit(r8);	 Catch:{ all -> 0x005a }
        goto L_0x0015;
    L_0x005a:
        r7 = move-exception;
        monitor-exit(r8);	 Catch:{ all -> 0x005a }
        throw r7;	 Catch:{ Exception -> 0x005d }
    L_0x005d:
        r3 = move-exception;
        r7 = "MultiDex";
        r8 = "Multidex installation failure";
        android.util.Log.e(r7, r8, r3);
        r7 = new java.lang.RuntimeException;
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r9 = "Multi dex installation failed (";
        r8 = r8.append(r9);
        r9 = r3.getMessage();
        r8 = r8.append(r9);
        r9 = ").";
        r8 = r8.append(r9);
        r8 = r8.toString();
        r7.<init>(r8);
        throw r7;
    L_0x0088:
        r7 = b;	 Catch:{ all -> 0x005a }
        r7.add(r0);	 Catch:{ all -> 0x005a }
        r7 = android.os.Build.VERSION.SDK_INT;	 Catch:{ all -> 0x005a }
        if (r7 <= r9) goto L_0x00d9;
    L_0x0091:
        r7 = "MultiDex";
        r9 = new java.lang.StringBuilder;	 Catch:{ all -> 0x005a }
        r9.<init>();	 Catch:{ all -> 0x005a }
        r10 = "MultiDex is not guaranteed to work in SDK version ";
        r9 = r9.append(r10);	 Catch:{ all -> 0x005a }
        r10 = android.os.Build.VERSION.SDK_INT;	 Catch:{ all -> 0x005a }
        r9 = r9.append(r10);	 Catch:{ all -> 0x005a }
        r10 = ": SDK version higher than ";
        r9 = r9.append(r10);	 Catch:{ all -> 0x005a }
        r10 = 20;
        r9 = r9.append(r10);	 Catch:{ all -> 0x005a }
        r10 = " should be backed by ";
        r9 = r9.append(r10);	 Catch:{ all -> 0x005a }
        r10 = "runtime with built-in multidex capabilty but it's not the ";
        r9 = r9.append(r10);	 Catch:{ all -> 0x005a }
        r10 = "case here: java.vm.version=\"";
        r9 = r9.append(r10);	 Catch:{ all -> 0x005a }
        r10 = "java.vm.version";
        r10 = java.lang.System.getProperty(r10);	 Catch:{ all -> 0x005a }
        r9 = r9.append(r10);	 Catch:{ all -> 0x005a }
        r10 = "\"";
        r9 = r9.append(r10);	 Catch:{ all -> 0x005a }
        r9 = r9.toString();	 Catch:{ all -> 0x005a }
        android.util.Log.w(r7, r9);	 Catch:{ all -> 0x005a }
    L_0x00d9:
        r5 = r11.getClassLoader();	 Catch:{ RuntimeException -> 0x00e9 }
        if (r5 != 0) goto L_0x00f4;
    L_0x00df:
        r7 = "MultiDex";
        r9 = "Context class loader is null. Must be running in test mode. Skip patching.";
        android.util.Log.e(r7, r9);	 Catch:{ all -> 0x005a }
        monitor-exit(r8);	 Catch:{ all -> 0x005a }
        goto L_0x0015;
    L_0x00e9:
        r3 = move-exception;
        r7 = "MultiDex";
        r9 = "Failure while trying to obtain Context class loader. Must be running in test mode. Skip patching.";
        android.util.Log.w(r7, r9, r3);	 Catch:{ all -> 0x005a }
        monitor-exit(r8);	 Catch:{ all -> 0x005a }
        goto L_0x0015;
    L_0x00f4:
        defpackage.ap.c(r11);	 Catch:{ Throwable -> 0x0118 }
    L_0x00f7:
        r2 = new java.io.File;	 Catch:{ all -> 0x005a }
        r7 = r1.dataDir;	 Catch:{ all -> 0x005a }
        r9 = a;	 Catch:{ all -> 0x005a }
        r2.<init>(r7, r9);	 Catch:{ all -> 0x005a }
        r7 = 0;
        r4 = defpackage.aq.a(r11, r1, r2, r7);	 Catch:{ all -> 0x005a }
        r7 = defpackage.ap.a(r4);	 Catch:{ all -> 0x005a }
        if (r7 == 0) goto L_0x0121;
    L_0x010b:
        defpackage.ap.a(r5, r2, r4);	 Catch:{ all -> 0x005a }
    L_0x010e:
        monitor-exit(r8);	 Catch:{ all -> 0x005a }
        r7 = "MultiDex";
        r8 = "install done";
        android.util.Log.i(r7, r8);
        goto L_0x0015;
    L_0x0118:
        r6 = move-exception;
        r7 = "MultiDex";
        r9 = "Something went wrong when trying to clear old MultiDex extraction, continuing without cleaning.";
        android.util.Log.w(r7, r9, r6);	 Catch:{ all -> 0x005a }
        goto L_0x00f7;
    L_0x0121:
        r7 = "MultiDex";
        r9 = "Files were not valid zip files.  Forcing a reload.";
        android.util.Log.w(r7, r9);	 Catch:{ all -> 0x005a }
        r7 = 1;
        r4 = defpackage.aq.a(r11, r1, r2, r7);	 Catch:{ all -> 0x005a }
        r7 = defpackage.ap.a(r4);	 Catch:{ all -> 0x005a }
        if (r7 == 0) goto L_0x0137;
    L_0x0133:
        defpackage.ap.a(r5, r2, r4);	 Catch:{ all -> 0x005a }
        goto L_0x010e;
    L_0x0137:
        r7 = new java.lang.RuntimeException;	 Catch:{ all -> 0x005a }
        r9 = "Zip files were not valid.";
        r7.<init>(r9);	 Catch:{ all -> 0x005a }
        throw r7;	 Catch:{ all -> 0x005a }
        */
        throw new UnsupportedOperationException("Method not decompiled: ap.a(android.content.Context):void");
    }

    private static ApplicationInfo b(Context context) throws NameNotFoundException {
        try {
            PackageManager pm = context.getPackageManager();
            String packageName = context.getPackageName();
            if (pm == null || packageName == null) {
                return null;
            }
            return pm.getApplicationInfo(packageName, 128);
        } catch (RuntimeException e) {
            Log.w("MultiDex", "Failure while trying to obtain ApplicationInfo from Context. Must be running in test mode. Skip patching.", e);
            return null;
        }
    }

    static boolean a(String versionString) {
        boolean isMultidexCapable = false;
        if (versionString != null) {
            Matcher matcher = Pattern.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(versionString);
            if (matcher.matches()) {
                try {
                    int major = Integer.parseInt(matcher.group(1));
                    isMultidexCapable = major > 2 || (major == 2 && Integer.parseInt(matcher.group(2)) >= 1);
                } catch (NumberFormatException e) {
                }
            }
        }
        Log.i("MultiDex", "VM with version " + versionString + (isMultidexCapable ? " has multidex support" : " does not have multidex support"));
        return isMultidexCapable;
    }

    private static void a(ClassLoader loader, File dexDir, List<File> files) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException {
        if (!files.isEmpty()) {
            if (VERSION.SDK_INT >= 19) {
                ap$b.b(loader, files, dexDir);
            } else if (VERSION.SDK_INT >= 14) {
                ap$a.b(loader, files, dexDir);
            } else {
                ap$c.b(loader, files);
            }
        }
    }

    private static boolean a(List<File> files) {
        for (File file : files) {
            if (!aq.a(file)) {
                return false;
            }
        }
        return true;
    }

    private static Field b(Object instance, String name) throws NoSuchFieldException {
        Class<?> clazz = instance.getClass();
        while (clazz != null) {
            try {
                Field field = clazz.getDeclaredField(name);
                if (!field.isAccessible()) {
                    field.setAccessible(true);
                }
                return field;
            } catch (NoSuchFieldException e) {
                clazz = clazz.getSuperclass();
            }
        }
        throw new NoSuchFieldException("Field " + name + " not found in " + instance.getClass());
    }

    private static Method b(Object instance, String name, Class<?>... parameterTypes) throws NoSuchMethodException {
        Class<?> clazz = instance.getClass();
        while (clazz != null) {
            try {
                Method method = clazz.getDeclaredMethod(name, parameterTypes);
                if (!method.isAccessible()) {
                    method.setAccessible(true);
                }
                return method;
            } catch (NoSuchMethodException e) {
                clazz = clazz.getSuperclass();
            }
        }
        throw new NoSuchMethodException("Method " + name + " with parameters " + Arrays.asList(parameterTypes) + " not found in " + instance.getClass());
    }

    private static void b(Object instance, String fieldName, Object[] extraElements) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field jlrField = ap.b(instance, fieldName);
        Object[] original = (Object[]) jlrField.get(instance);
        Object[] combined = (Object[]) Array.newInstance(original.getClass().getComponentType(), original.length + extraElements.length);
        System.arraycopy(original, 0, combined, 0, original.length);
        System.arraycopy(extraElements, 0, combined, original.length, extraElements.length);
        jlrField.set(instance, combined);
    }

    private static void c(Context context) throws Exception {
        File dexDir = new File(context.getFilesDir(), "secondary-dexes");
        if (dexDir.isDirectory()) {
            Log.i("MultiDex", "Clearing old secondary dex dir (" + dexDir.getPath() + ").");
            File[] files = dexDir.listFiles();
            if (files == null) {
                Log.w("MultiDex", "Failed to list secondary dex dir content (" + dexDir.getPath() + ").");
                return;
            }
            for (File oldFile : files) {
                Log.i("MultiDex", "Trying to delete old file " + oldFile.getPath() + " of size " + oldFile.length());
                if (oldFile.delete()) {
                    Log.i("MultiDex", "Deleted old file " + oldFile.getPath());
                } else {
                    Log.w("MultiDex", "Failed to delete old file " + oldFile.getPath());
                }
            }
            if (dexDir.delete()) {
                Log.i("MultiDex", "Deleted old secondary dex dir " + dexDir.getPath());
            } else {
                Log.w("MultiDex", "Failed to delete secondary dex dir " + dexDir.getPath());
            }
        }
    }
}
