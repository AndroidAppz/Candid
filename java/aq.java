/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.content.pm.ApplicationInfo
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.Log
 *  java.io.Closeable
 *  java.io.File
 *  java.io.FileFilter
 *  java.io.FileNotFoundException
 *  java.io.IOException
 *  java.lang.Class
 *  java.lang.IllegalAccessException
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.InvocationTargetException
 *  java.lang.reflect.Method
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.zip.ZipEntry
 *  java.util.zip.ZipException
 *  java.util.zip.ZipFile
 */
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.util.Log;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

final class aq {
    private static Method a;

    static {
        try {
            a = SharedPreferences.Editor.class.getMethod("apply", new Class[0]);
        }
        catch (NoSuchMethodException var0) {
            a = null;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static SharedPreferences a(Context context) {
        int n2;
        if (Build.VERSION.SDK_INT < 11) {
            n2 = 0;
            do {
                return context.getSharedPreferences("multidex.version", n2);
                break;
            } while (true);
        }
        n2 = 4;
        return context.getSharedPreferences("multidex.version", n2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static List<File> a(Context context, ApplicationInfo applicationInfo, File file, boolean bl2) throws IOException {
        List<File> list;
        Log.i((String)"MultiDex", (String)("MultiDexExtractor.load(" + applicationInfo.sourceDir + ", " + bl2 + ")"));
        File file2 = new File(applicationInfo.sourceDir);
        long l2 = aq.c(file2);
        if (!bl2 && !aq.a(context, file2, l2)) {
            try {
                List<File> list2;
                list = list2 = aq.a(context, file2, file);
            }
            catch (IOException var11_8) {
                Log.w((String)"MultiDex", (String)"Failed to reload existing extracted secondary dex files, falling back to fresh extraction", (Throwable)var11_8);
                list = aq.a(file2, file);
                aq.a(context, aq.b(file2), l2, 1 + list.size());
            }
        } else {
            Log.i((String)"MultiDex", (String)"Detected that extraction must be performed.");
            list = aq.a(file2, file);
            aq.a(context, aq.b(file2), l2, 1 + list.size());
        }
        Log.i((String)"MultiDex", (String)("load found " + list.size() + " secondary dex files"));
        return list;
    }

    private static List<File> a(Context context, File file, File file2) throws IOException {
        Log.i((String)"MultiDex", (String)"loading existing secondary dex files");
        String string2 = file.getName() + ".classes";
        int n2 = aq.a(context).getInt("dex.number", 1);
        ArrayList arrayList = new ArrayList(n2);
        for (int i2 = 2; i2 <= n2; ++i2) {
            File file3 = new File(file2, string2 + i2 + ".zip");
            if (file3.isFile()) {
                arrayList.add((Object)file3);
                if (aq.a(file3)) continue;
                Log.i((String)"MultiDex", (String)("Invalid zip file: " + (Object)file3));
                throw new IOException("Invalid ZIP file.");
            }
            throw new IOException("Missing extracted secondary dex file '" + file3.getPath() + "'");
        }
        return arrayList;
    }

    /*
     * Exception decompiling
     */
    private static List<File> a(File var0_1, File var1) throws IOException {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // java.lang.IllegalStateException: Backjump on non jumping statement [] lbl36 : TryStatement: try { 3[TRYBLOCK]

        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Cleaner$1.call(Cleaner.java:44)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Cleaner$1.call(Cleaner.java:22)
        // org.benf.cfr.reader.util.graph.GraphVisitorDFS.process(GraphVisitorDFS.java:68)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Cleaner.removeUnreachableCode(Cleaner.java:54)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.RemoveDeterministicJumps.apply(RemoveDeterministicJumps.java:35)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:507)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:128)
        // com.njlabs.showjava.processor.JavaExtractor$1.run(JavaExtractor.java:100)
        // java.lang.Thread.run(Thread.java:818)
        throw new IllegalStateException("Decompilation failed");
    }

    private static void a(Context context, long l2, long l3, int n2) {
        SharedPreferences.Editor editor = aq.a(context).edit();
        editor.putLong("timestamp", l2);
        editor.putLong("crc", l3);
        editor.putInt("dex.number", n2);
        aq.a(editor);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    private static void a(SharedPreferences.Editor var0) {
        if (aq.a != null) {
            try {
                aq.a.invoke((Object)var0, new Object[0]);
                return;
            }
            catch (IllegalAccessException var3_1) {
                // empty catch block
            }
        }
lbl7: // 4 sources:
        do {
            var0.commit();
            return;
            break;
        } while (true);
        catch (InvocationTargetException var2_2) {
            ** continue;
        }
    }

    private static void a(Closeable closeable) {
        try {
            closeable.close();
            return;
        }
        catch (IOException var1_1) {
            Log.w((String)"MultiDex", (String)"Failed to close resource", (Throwable)var1_1);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private static void a(File file, final String string2) throws IOException {
        aq.d(file.getParentFile());
        aq.d(file);
        File[] arrfile = file.listFiles(new FileFilter(){

            public boolean accept(File file) {
                if (!file.getName().startsWith(string2)) {
                    return true;
                }
                return false;
            }
        });
        if (arrfile == null) {
            Log.w((String)"MultiDex", (String)("Failed to list secondary dex dir content (" + file.getPath() + ")."));
            return;
        }
        int n2 = arrfile.length;
        int n3 = 0;
        while (n3 < n2) {
            File file2 = arrfile[n3];
            Log.i((String)"MultiDex", (String)("Trying to delete old file " + file2.getPath() + " of size " + file2.length()));
            if (!file2.delete()) {
                Log.w((String)"MultiDex", (String)("Failed to delete old file " + file2.getPath()));
            } else {
                Log.i((String)"MultiDex", (String)("Deleted old file " + file2.getPath()));
            }
            ++n3;
        }
    }

    /*
     * Exception decompiling
     */
    private static void a(ZipFile var0_1, ZipEntry var1, File var2_3, String var3_2) throws IOException, FileNotFoundException {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[TRYBLOCK]], but top level block is 2[TRYBLOCK]
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:394)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:446)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:2859)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:805)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:128)
        // com.njlabs.showjava.processor.JavaExtractor$1.run(JavaExtractor.java:100)
        // java.lang.Thread.run(Thread.java:818)
        throw new IllegalStateException("Decompilation failed");
    }

    private static boolean a(Context context, File file, long l2) {
        SharedPreferences sharedPreferences = aq.a(context);
        if (sharedPreferences.getLong("timestamp", -1) != aq.b(file) || sharedPreferences.getLong("crc", -1) != l2) {
            return true;
        }
        return false;
    }

    /*
     * Loose catch block
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    static boolean a(File file) {
        ZipFile zipFile = new ZipFile(file);
        {
            catch (IOException iOException) {
                Log.w((String)"MultiDex", (String)("Got an IOException trying to open zip file: " + file.getAbsolutePath()), (Throwable)iOException);
                return false;
            }
        }
        try {
            zipFile.close();
            return true;
        }
        catch (IOException var4_2) {
            try {
                Log.w((String)"MultiDex", (String)("Failed to close zip file: " + file.getAbsolutePath()));
                do {
                    return false;
                    break;
                } while (true);
            }
            catch (ZipException var2_3) {
                Log.w((String)"MultiDex", (String)("File " + file.getAbsolutePath() + " is not a valid zip file."), (Throwable)var2_3);
                return false;
            }
        }
    }

    private static long b(File file) {
        long l2 = file.lastModified();
        if (l2 == -1) {
            --l2;
        }
        return l2;
    }

    private static long c(File file) throws IOException {
        long l2 = ar.a(file);
        if (l2 == -1) {
            --l2;
        }
        return l2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static void d(File file) throws IOException {
        file.mkdir();
        if (file.isDirectory()) return;
        File file2 = file.getParentFile();
        if (file2 == null) {
            Log.e((String)"MultiDex", (String)("Failed to create dir " + file.getPath() + ". Parent file is null."));
            do {
                throw new IOException("Failed to create cache directory " + file.getPath());
                break;
            } while (true);
        }
        Log.e((String)"MultiDex", (String)("Failed to create dir " + file.getPath() + ". parent file is a dir " + file2.isDirectory() + ", a file " + file2.isFile() + ", exists " + file2.exists() + ", readable " + file2.canRead() + ", writable " + file2.canWrite()));
        throw new IOException("Failed to create cache directory " + file.getPath());
    }

}

