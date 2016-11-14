package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.util.Log;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/* compiled from: MultiDexExtractor */
final class aq {
    private static Method a;

    static List<File> a(Context context, ApplicationInfo applicationInfo, File dexDir, boolean forceReload) throws IOException {
        List<File> files;
        Log.i("MultiDex", "MultiDexExtractor.load(" + applicationInfo.sourceDir + ", " + forceReload + ")");
        File sourceApk = new File(applicationInfo.sourceDir);
        long currentCrc = aq.c(sourceApk);
        if (forceReload || aq.a(context, sourceApk, currentCrc)) {
            Log.i("MultiDex", "Detected that extraction must be performed.");
            files = aq.a(sourceApk, dexDir);
            aq.a(context, aq.b(sourceApk), currentCrc, files.size() + 1);
        } else {
            try {
                files = aq.a(context, sourceApk, dexDir);
            } catch (IOException ioe) {
                Log.w("MultiDex", "Failed to reload existing extracted secondary dex files, falling back to fresh extraction", ioe);
                files = aq.a(sourceApk, dexDir);
                aq.a(context, aq.b(sourceApk), currentCrc, files.size() + 1);
            }
        }
        Log.i("MultiDex", "load found " + files.size() + " secondary dex files");
        return files;
    }

    private static List<File> a(Context context, File sourceApk, File dexDir) throws IOException {
        Log.i("MultiDex", "loading existing secondary dex files");
        String extractedFilePrefix = sourceApk.getName() + ".classes";
        int totalDexNumber = aq.a(context).getInt("dex.number", 1);
        List<File> files = new ArrayList(totalDexNumber);
        int secondaryNumber = 2;
        while (secondaryNumber <= totalDexNumber) {
            File extractedFile = new File(dexDir, extractedFilePrefix + secondaryNumber + ".zip");
            if (extractedFile.isFile()) {
                files.add(extractedFile);
                if (aq.a(extractedFile)) {
                    secondaryNumber++;
                } else {
                    Log.i("MultiDex", "Invalid zip file: " + extractedFile);
                    throw new IOException("Invalid ZIP file.");
                }
            }
            throw new IOException("Missing extracted secondary dex file '" + extractedFile.getPath() + "'");
        }
        return files;
    }

    private static boolean a(Context context, File archive, long currentCrc) {
        SharedPreferences prefs = aq.a(context);
        return (prefs.getLong("timestamp", -1) == aq.b(archive) && prefs.getLong("crc", -1) == currentCrc) ? false : true;
    }

    private static long b(File archive) {
        long timeStamp = archive.lastModified();
        if (timeStamp == -1) {
            return timeStamp - 1;
        }
        return timeStamp;
    }

    private static long c(File archive) throws IOException {
        long computedValue = ar.a(archive);
        if (computedValue == -1) {
            return computedValue - 1;
        }
        return computedValue;
    }

    private static List<File> a(File sourceApk, File dexDir) throws IOException {
        String extractedFilePrefix = sourceApk.getName() + ".classes";
        aq.a(dexDir, extractedFilePrefix);
        List<File> files = new ArrayList();
        ZipFile apk = new ZipFile(sourceApk);
        int secondaryNumber = 2;
        try {
            ZipEntry dexFile = apk.getEntry("classes" + 2 + ".dex");
            while (dexFile != null) {
                File extractedFile = new File(dexDir, extractedFilePrefix + secondaryNumber + ".zip");
                files.add(extractedFile);
                Log.i("MultiDex", "Extraction is needed for file " + extractedFile);
                int numAttempts = 0;
                boolean isExtractionSuccessful = false;
                while (numAttempts < 3 && !isExtractionSuccessful) {
                    numAttempts++;
                    aq.a(apk, dexFile, extractedFile, extractedFilePrefix);
                    isExtractionSuccessful = aq.a(extractedFile);
                    Log.i("MultiDex", "Extraction " + (isExtractionSuccessful ? "success" : "failed") + " - length " + extractedFile.getAbsolutePath() + ": " + extractedFile.length());
                    if (!isExtractionSuccessful) {
                        extractedFile.delete();
                        if (extractedFile.exists()) {
                            Log.w("MultiDex", "Failed to delete corrupted secondary dex '" + extractedFile.getPath() + "'");
                        }
                    }
                }
                if (isExtractionSuccessful) {
                    secondaryNumber++;
                    dexFile = apk.getEntry("classes" + secondaryNumber + ".dex");
                } else {
                    throw new IOException("Could not create zip file " + extractedFile.getAbsolutePath() + " for secondary dex (" + secondaryNumber + ")");
                }
            }
            return files;
        } finally {
            try {
                apk.close();
            } catch (IOException e) {
                Log.w("MultiDex", "Failed to close resource", e);
            }
        }
    }

    private static void a(Context context, long timeStamp, long crc, int totalDexNumber) {
        Editor edit = aq.a(context).edit();
        edit.putLong("timestamp", timeStamp);
        edit.putLong("crc", crc);
        edit.putInt("dex.number", totalDexNumber);
        aq.a(edit);
    }

    private static SharedPreferences a(Context context) {
        return context.getSharedPreferences("multidex.version", VERSION.SDK_INT < 11 ? 0 : 4);
    }

    private static void a(File dexDir, String extractedFilePrefix) throws IOException {
        aq.d(dexDir.getParentFile());
        aq.d(dexDir);
        File[] files = dexDir.listFiles(new aq$1(extractedFilePrefix));
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
    }

    private static void d(File dir) throws IOException {
        dir.mkdir();
        if (!dir.isDirectory()) {
            File parent = dir.getParentFile();
            if (parent == null) {
                Log.e("MultiDex", "Failed to create dir " + dir.getPath() + ". Parent file is null.");
            } else {
                Log.e("MultiDex", "Failed to create dir " + dir.getPath() + ". parent file is a dir " + parent.isDirectory() + ", a file " + parent.isFile() + ", exists " + parent.exists() + ", readable " + parent.canRead() + ", writable " + parent.canWrite());
            }
            throw new IOException("Failed to create cache directory " + dir.getPath());
        }
    }

    private static void a(ZipFile apk, ZipEntry dexFile, File extractTo, String extractedFilePrefix) throws IOException, FileNotFoundException {
        Throwable th;
        Closeable in = apk.getInputStream(dexFile);
        File tmp = File.createTempFile(extractedFilePrefix, ".zip", extractTo.getParentFile());
        Log.i("MultiDex", "Extracting " + tmp.getPath());
        try {
            ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(tmp)));
            try {
                ZipEntry classesDex = new ZipEntry("classes.dex");
                classesDex.setTime(dexFile.getTime());
                out.putNextEntry(classesDex);
                byte[] buffer = new byte[16384];
                for (int length = in.read(buffer); length != -1; length = in.read(buffer)) {
                    out.write(buffer, 0, length);
                }
                out.closeEntry();
                out.close();
                Log.i("MultiDex", "Renaming to " + extractTo.getPath());
                if (tmp.renameTo(extractTo)) {
                    aq.a(in);
                    tmp.delete();
                    return;
                }
                throw new IOException("Failed to rename \"" + tmp.getAbsolutePath() + "\" to \"" + extractTo.getAbsolutePath() + "\"");
            } catch (Throwable th2) {
                th = th2;
                ZipOutputStream zipOutputStream = out;
                aq.a(in);
                tmp.delete();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            aq.a(in);
            tmp.delete();
            throw th;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean a(java.io.File r6) {
        /*
        r2 = new java.util.zip.ZipFile;	 Catch:{ ZipException -> 0x0029, IOException -> 0x004d }
        r2.<init>(r6);	 Catch:{ ZipException -> 0x0029, IOException -> 0x004d }
        r2.close();	 Catch:{ IOException -> 0x000a, ZipException -> 0x0029 }
        r3 = 1;
    L_0x0009:
        return r3;
    L_0x000a:
        r0 = move-exception;
        r3 = "MultiDex";
        r4 = new java.lang.StringBuilder;	 Catch:{ ZipException -> 0x0029, IOException -> 0x004d }
        r4.<init>();	 Catch:{ ZipException -> 0x0029, IOException -> 0x004d }
        r5 = "Failed to close zip file: ";
        r4 = r4.append(r5);	 Catch:{ ZipException -> 0x0029, IOException -> 0x004d }
        r5 = r6.getAbsolutePath();	 Catch:{ ZipException -> 0x0029, IOException -> 0x004d }
        r4 = r4.append(r5);	 Catch:{ ZipException -> 0x0029, IOException -> 0x004d }
        r4 = r4.toString();	 Catch:{ ZipException -> 0x0029, IOException -> 0x004d }
        android.util.Log.w(r3, r4);	 Catch:{ ZipException -> 0x0029, IOException -> 0x004d }
    L_0x0027:
        r3 = 0;
        goto L_0x0009;
    L_0x0029:
        r1 = move-exception;
        r3 = "MultiDex";
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "File ";
        r4 = r4.append(r5);
        r5 = r6.getAbsolutePath();
        r4 = r4.append(r5);
        r5 = " is not a valid zip file.";
        r4 = r4.append(r5);
        r4 = r4.toString();
        android.util.Log.w(r3, r4, r1);
        goto L_0x0027;
    L_0x004d:
        r1 = move-exception;
        r3 = "MultiDex";
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "Got an IOException trying to open zip file: ";
        r4 = r4.append(r5);
        r5 = r6.getAbsolutePath();
        r4 = r4.append(r5);
        r4 = r4.toString();
        android.util.Log.w(r3, r4, r1);
        goto L_0x0027;
        */
        throw new UnsupportedOperationException("Method not decompiled: aq.a(java.io.File):boolean");
    }

    private static void a(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e) {
            Log.w("MultiDex", "Failed to close resource", e);
        }
    }

    static {
        try {
            a = Editor.class.getMethod("apply", new Class[0]);
        } catch (NoSuchMethodException e) {
            a = null;
        }
    }

    private static void a(Editor editor) {
        if (a != null) {
            try {
                a.invoke(editor, new Object[0]);
                return;
            } catch (InvocationTargetException e) {
            } catch (IllegalAccessException e2) {
            }
        }
        editor.commit();
    }
}
