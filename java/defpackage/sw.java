package defpackage;

import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import com.crashlytics.android.core.CodedOutputStream;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.DeliveryMechanism;
import io.fabric.sdk.android.services.common.IdManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: CrashlyticsUncaughtExceptionHandler */
class sw implements UncaughtExceptionHandler {
    static final FilenameFilter a = new sw$1();
    static final Comparator<File> b = new sw$6();
    static final Comparator<File> c = new sw$7();
    static final FilenameFilter d = new sw$8();
    private static final Pattern e = Pattern.compile("([\\d|A-Z|a-z]{12}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{12}).+");
    private static final Map<String, String> f = Collections.singletonMap("X-CRASHLYTICS-SEND-FLAGS", "1");
    private static final String[] g = new String[]{"SessionUser", "SessionApp", "SessionOS", "SessionDevice"};
    private final AtomicInteger h = new AtomicInteger(0);
    private final UncaughtExceptionHandler i;
    private final amy j;
    private final AtomicBoolean k;
    private final ss l;
    private final IdManager m;
    private final sr n;
    private final td o;
    private final ta p;
    private final String q;

    sw(UncaughtExceptionHandler handler, ss executorServiceWrapper, IdManager idManager, tn unityVersionProvider, amy fileStore, sr crashlyticsCore) {
        this.i = handler;
        this.l = executorServiceWrapper;
        this.m = idManager;
        this.n = crashlyticsCore;
        this.q = unityVersionProvider.a();
        this.j = fileStore;
        this.k = new AtomicBoolean(false);
        Context context = crashlyticsCore.E();
        this.o = new td(context, fileStore);
        this.p = new ta(context);
    }

    public synchronized void uncaughtException(Thread thread, Throwable ex) {
        this.k.set(true);
        try {
            akp.h().a("CrashlyticsCore", "Crashlytics is handling uncaught exception \"" + ex + "\" from thread " + thread.getName());
            this.p.b();
            this.l.a(new sw$9(this, new Date(), thread, ex));
        } catch (Exception e) {
            akp.h().e("CrashlyticsCore", "An error occurred in the uncaught exception handler", e);
        } finally {
            akp.h().a("CrashlyticsCore", "Crashlytics completed exception processing. Invoking default exception handler.");
            this.i.uncaughtException(thread, ex);
            this.k.set(false);
        }
    }

    private void a(Date time, Thread thread, Throwable ex) throws Exception {
        this.n.A();
        b(time, thread, ex);
        d();
        l();
        f();
        if (!this.n.x()) {
            p();
        }
    }

    boolean a() {
        return this.k.get();
    }

    void a(Thread thread, Throwable ex) {
        this.l.a(new sw$10(this, new Date(), thread, ex));
    }

    void b() {
        this.l.b(new sw$2(this));
    }

    private String j() {
        File[] sessionBeginFiles = n();
        return sessionBeginFiles.length > 0 ? a(sessionBeginFiles[0]) : null;
    }

    private String k() {
        File[] sessionBeginFiles = n();
        return sessionBeginFiles.length > 1 ? a(sessionBeginFiles[1]) : null;
    }

    private String a(File sessionFile) {
        return sessionFile.getName().substring(0, 35);
    }

    boolean c() {
        return ((Boolean) this.l.a(new sw$3(this))).booleanValue();
    }

    private void l() throws Exception {
        Date startedAt = new Date();
        String sessionIdentifier = new sp(this.m).toString();
        akp.h().a("CrashlyticsCore", "Opening an new session with ID " + sessionIdentifier);
        a(sessionIdentifier, startedAt);
        c(sessionIdentifier);
        d(sessionIdentifier);
        e(sessionIdentifier);
        this.o.a(sessionIdentifier);
    }

    void d() throws Exception {
        a(false);
    }

    private void a(boolean excludeCurrent) throws Exception {
        int offset = excludeCurrent ? 1 : 0;
        a(offset + 8);
        File[] sessionBeginFiles = n();
        if (sessionBeginFiles.length <= offset) {
            akp.h().a("CrashlyticsCore", "No open sessions to be closed.");
            return;
        }
        f(a(sessionBeginFiles[offset]));
        sr srVar = this.n;
        anr settingsData = sr.B();
        if (settingsData == null) {
            akp.h().a("CrashlyticsCore", "Unable to close session. Settings are not loaded.");
        } else {
            a(sessionBeginFiles, offset, settingsData.c);
        }
    }

    private void a(File[] sessionBeginFiles, int beginIndex, int maxLoggedExceptionsCount) {
        akp.h().a("CrashlyticsCore", "Closing open sessions.");
        for (int i = beginIndex; i < sessionBeginFiles.length; i++) {
            File sessionBeginFile = sessionBeginFiles[i];
            String sessionIdentifier = a(sessionBeginFile);
            akp.h().a("CrashlyticsCore", "Closing session: " + sessionIdentifier);
            a(sessionBeginFile, sessionIdentifier, maxLoggedExceptionsCount);
        }
    }

    private void a(sq fos) {
        if (fos != null) {
            try {
                fos.a();
            } catch (IOException ex) {
                akp.h().e("CrashlyticsCore", "Error closing session file stream in the presence of an exception", ex);
            }
        }
    }

    private void a(String sessionId) {
        for (File file : b(sessionId)) {
            file.delete();
        }
    }

    private File[] b(String sessionId) {
        return a(new sw$d(sessionId));
    }

    private File[] m() {
        return a(a);
    }

    File[] e() {
        return a(new sw$b("BeginSession"));
    }

    private File[] n() {
        File[] sessionBeginFiles = e();
        Arrays.sort(sessionBeginFiles, b);
        return sessionBeginFiles;
    }

    private File[] a(FilenameFilter filter) {
        return b(q().listFiles(filter));
    }

    private File[] b(File[] files) {
        return files == null ? new File[0] : files;
    }

    private void a(String sessionId, int limit) {
        tp.a(q(), new sw$b(sessionId + "SessionEvent"), limit, c);
    }

    void f() {
        tp.a(q(), a, 4, c);
    }

    private void a(int maxOpenSessionCount) {
        Set sessionIdsToKeep = new HashSet();
        File[] beginSessionFiles = n();
        int count = Math.min(maxOpenSessionCount, beginSessionFiles.length);
        for (int i = 0; i < count; i++) {
            sessionIdsToKeep.add(a(beginSessionFiles[i]));
        }
        this.o.a(sessionIdsToKeep);
        for (File sessionPartFile : a(new sw$a())) {
            String fileName = sessionPartFile.getName();
            Matcher matcher = e.matcher(fileName);
            matcher.matches();
            if (!sessionIdsToKeep.contains(matcher.group(1))) {
                akp.h().a("CrashlyticsCore", "Trimming open session file: " + fileName);
                sessionPartFile.delete();
            }
        }
    }

    private File[] a(String sessionId, File[] nonFatalFiles, int maxLoggedExceptionsCount) {
        if (nonFatalFiles.length <= maxLoggedExceptionsCount) {
            return nonFatalFiles;
        }
        akp.h().a("CrashlyticsCore", String.format(Locale.US, "Trimming down to %d logged exceptions.", new Object[]{Integer.valueOf(maxLoggedExceptionsCount)}));
        a(sessionId, maxLoggedExceptionsCount);
        return a(new sw$b(sessionId + "SessionEvent"));
    }

    void g() {
        this.l.a(new sw$4(this));
    }

    void a(File[] invalidFiles) {
        o();
        for (File invalidFile : invalidFiles) {
            akp.h().a("CrashlyticsCore", "Found invalid session part file: " + invalidFile);
            String sessionId = a(invalidFile);
            FilenameFilter sessionFilter = new sw$5(this, sessionId);
            akp.h().a("CrashlyticsCore", "Deleting all part files for invalid session: " + sessionId);
            for (File sessionFile : a(sessionFilter)) {
                akp.h().a("CrashlyticsCore", "Deleting session file: " + sessionFile);
                sessionFile.delete();
            }
        }
    }

    private void o() {
        File cacheDir = new File(this.n.w(), "invalidClsFiles");
        if (cacheDir.exists()) {
            if (cacheDir.isDirectory()) {
                for (File cacheFile : cacheDir.listFiles()) {
                    cacheFile.delete();
                }
            }
            cacheDir.delete();
        }
    }

    private void b(Date time, Thread thread, Throwable ex) {
        Exception e;
        Throwable th;
        sq fos = null;
        CodedOutputStream cos = null;
        try {
            String currentSessionId = j();
            if (currentSessionId == null) {
                akp.h().e("CrashlyticsCore", "Tried to write a fatal exception while no session was open.", null);
                CommonUtils.a(null, "Failed to flush to session begin file.");
                CommonUtils.a(null, "Failed to close fatal exception file output stream.");
                return;
            }
            sr.b(currentSessionId, ex.getClass().getName());
            sq fos2 = new sq(q(), currentSessionId + "SessionCrash");
            try {
                cos = CodedOutputStream.a(fos2);
                a(cos, time, thread, ex, "crash", true);
                CommonUtils.a(cos, "Failed to flush to session begin file.");
                CommonUtils.a(fos2, "Failed to close fatal exception file output stream.");
                fos = fos2;
            } catch (Exception e2) {
                e = e2;
                fos = fos2;
                try {
                    akp.h().e("CrashlyticsCore", "An error occurred in the fatal exception logger", e);
                    CommonUtils.a(cos, "Failed to flush to session begin file.");
                    CommonUtils.a(fos, "Failed to close fatal exception file output stream.");
                } catch (Throwable th2) {
                    th = th2;
                    CommonUtils.a(cos, "Failed to flush to session begin file.");
                    CommonUtils.a(fos, "Failed to close fatal exception file output stream.");
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fos = fos2;
                CommonUtils.a(cos, "Failed to flush to session begin file.");
                CommonUtils.a(fos, "Failed to close fatal exception file output stream.");
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            akp.h().e("CrashlyticsCore", "An error occurred in the fatal exception logger", e);
            CommonUtils.a(cos, "Failed to flush to session begin file.");
            CommonUtils.a(fos, "Failed to close fatal exception file output stream.");
        }
    }

    private void a(tv crashEventData) throws IOException {
        Exception e;
        Throwable th;
        sq fos = null;
        CodedOutputStream cos = null;
        try {
            String previousSessionId = k();
            if (previousSessionId == null) {
                akp.h().e("CrashlyticsCore", "Tried to write a native crash while no session was open.", null);
                CommonUtils.a(null, "Failed to flush to session begin file.");
                CommonUtils.a(null, "Failed to close fatal exception file output stream.");
                return;
            }
            sr.b(previousSessionId, String.format(Locale.US, "<native-crash [%s (%s)]>", new Object[]{crashEventData.b.b, crashEventData.b.a}));
            sq fos2 = new sq(q(), previousSessionId + "SessionCrash");
            try {
                cos = CodedOutputStream.a(fos2);
                tg.a(crashEventData, new td(this.n.E(), this.j, previousSessionId), new tf(q()).b(previousSessionId), cos);
                CommonUtils.a(cos, "Failed to flush to session begin file.");
                CommonUtils.a(fos2, "Failed to close fatal exception file output stream.");
                fos = fos2;
            } catch (Exception e2) {
                e = e2;
                fos = fos2;
                try {
                    akp.h().e("CrashlyticsCore", "An error occurred in the native crash logger", e);
                    CommonUtils.a(cos, "Failed to flush to session begin file.");
                    CommonUtils.a(fos, "Failed to close fatal exception file output stream.");
                } catch (Throwable th2) {
                    th = th2;
                    CommonUtils.a(cos, "Failed to flush to session begin file.");
                    CommonUtils.a(fos, "Failed to close fatal exception file output stream.");
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fos = fos2;
                CommonUtils.a(cos, "Failed to flush to session begin file.");
                CommonUtils.a(fos, "Failed to close fatal exception file output stream.");
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            akp.h().e("CrashlyticsCore", "An error occurred in the native crash logger", e);
            CommonUtils.a(cos, "Failed to flush to session begin file.");
            CommonUtils.a(fos, "Failed to close fatal exception file output stream.");
        }
    }

    private void c(Date time, Thread thread, Throwable ex) {
        Exception e;
        Throwable th;
        String currentSessionId = j();
        if (currentSessionId == null) {
            akp.h().e("CrashlyticsCore", "Tried to write a non-fatal exception while no session was open.", null);
            return;
        }
        sr.a(currentSessionId, ex.getClass().getName());
        sq fos = null;
        CodedOutputStream cos = null;
        try {
            akp.h().a("CrashlyticsCore", "Crashlytics is logging non-fatal exception \"" + ex + "\" from thread " + thread.getName());
            sq fos2 = new sq(q(), currentSessionId + "SessionEvent" + CommonUtils.a(this.h.getAndIncrement()));
            try {
                cos = CodedOutputStream.a(fos2);
                a(cos, time, thread, ex, "error", false);
                CommonUtils.a(cos, "Failed to flush to non-fatal file.");
                CommonUtils.a(fos2, "Failed to close non-fatal file output stream.");
                fos = fos2;
            } catch (Exception e2) {
                e = e2;
                fos = fos2;
                try {
                    akp.h().e("CrashlyticsCore", "An error occurred in the non-fatal exception logger", e);
                    CommonUtils.a(cos, "Failed to flush to non-fatal file.");
                    CommonUtils.a(fos, "Failed to close non-fatal file output stream.");
                    a(currentSessionId, 64);
                } catch (Throwable th2) {
                    th = th2;
                    CommonUtils.a(cos, "Failed to flush to non-fatal file.");
                    CommonUtils.a(fos, "Failed to close non-fatal file output stream.");
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fos = fos2;
                CommonUtils.a(cos, "Failed to flush to non-fatal file.");
                CommonUtils.a(fos, "Failed to close non-fatal file output stream.");
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            akp.h().e("CrashlyticsCore", "An error occurred in the non-fatal exception logger", e);
            CommonUtils.a(cos, "Failed to flush to non-fatal file.");
            CommonUtils.a(fos, "Failed to close non-fatal file output stream.");
            a(currentSessionId, 64);
        }
        try {
            a(currentSessionId, 64);
        } catch (Exception e4) {
            akp.h().e("CrashlyticsCore", "An error occurred when trimming non-fatal files.", e4);
        }
    }

    private void a(String sessionId, Date startedAt) throws Exception {
        Throwable th;
        FileOutputStream fos = null;
        CodedOutputStream cos = null;
        try {
            FileOutputStream fos2 = new sq(q(), sessionId + "BeginSession");
            try {
                cos = CodedOutputStream.a(fos2);
                tl.a(cos, sessionId, String.format(Locale.US, "Crashlytics Android SDK/%s", new Object[]{this.n.a()}), startedAt.getTime() / 1000);
                CommonUtils.a(cos, "Failed to flush to session begin file.");
                CommonUtils.a(fos2, "Failed to close begin session file.");
            } catch (Throwable th2) {
                th = th2;
                fos = fos2;
                CommonUtils.a(cos, "Failed to flush to session begin file.");
                CommonUtils.a(fos, "Failed to close begin session file.");
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            CommonUtils.a(cos, "Failed to flush to session begin file.");
            CommonUtils.a(fos, "Failed to close begin session file.");
            throw th;
        }
    }

    private void c(String sessionId) throws Exception {
        Throwable th;
        FileOutputStream fos = null;
        CodedOutputStream cos = null;
        try {
            FileOutputStream fos2 = new sq(q(), sessionId + "SessionApp");
            try {
                cos = CodedOutputStream.a(fos2);
                tl.a(cos, this.m.c(), this.n.i(), this.n.l(), this.n.k(), this.m.b(), DeliveryMechanism.a(this.n.j()).a(), this.q);
                CommonUtils.a(cos, "Failed to flush to session app file.");
                CommonUtils.a(fos2, "Failed to close session app file.");
            } catch (Throwable th2) {
                th = th2;
                fos = fos2;
                CommonUtils.a(cos, "Failed to flush to session app file.");
                CommonUtils.a(fos, "Failed to close session app file.");
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            CommonUtils.a(cos, "Failed to flush to session app file.");
            CommonUtils.a(fos, "Failed to close session app file.");
            throw th;
        }
    }

    private void d(String sessionId) throws Exception {
        Throwable th;
        FileOutputStream fos = null;
        CodedOutputStream cos = null;
        try {
            FileOutputStream fos2 = new sq(q(), sessionId + "SessionOS");
            try {
                cos = CodedOutputStream.a(fos2);
                tl.a(cos, CommonUtils.g(this.n.E()));
                CommonUtils.a(cos, "Failed to flush to session OS file.");
                CommonUtils.a(fos2, "Failed to close session OS file.");
            } catch (Throwable th2) {
                th = th2;
                fos = fos2;
                CommonUtils.a(cos, "Failed to flush to session OS file.");
                CommonUtils.a(fos, "Failed to close session OS file.");
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            CommonUtils.a(cos, "Failed to flush to session OS file.");
            CommonUtils.a(fos, "Failed to close session OS file.");
            throw th;
        }
    }

    private void e(String sessionId) throws Exception {
        Throwable th;
        FileOutputStream fos = null;
        CodedOutputStream cos = null;
        try {
            FileOutputStream sqVar = new sq(q(), sessionId + "SessionDevice");
            try {
                cos = CodedOutputStream.a(sqVar);
                Context context = this.n.E();
                StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                tl.a(cos, this.m.h(), CommonUtils.a(), Build.MODEL, Runtime.getRuntime().availableProcessors(), CommonUtils.b(), ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize()), CommonUtils.f(context), this.m.i(), CommonUtils.h(context), Build.MANUFACTURER, Build.PRODUCT);
                CommonUtils.a(cos, "Failed to flush session device info.");
                CommonUtils.a(sqVar, "Failed to close session device file.");
            } catch (Throwable th2) {
                th = th2;
                fos = sqVar;
                CommonUtils.a(cos, "Failed to flush session device info.");
                CommonUtils.a(fos, "Failed to close session device file.");
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            CommonUtils.a(cos, "Failed to flush session device info.");
            CommonUtils.a(fos, "Failed to close session device file.");
            throw th;
        }
    }

    private void f(String sessionId) throws Exception {
        Throwable th;
        FileOutputStream fos = null;
        CodedOutputStream cos = null;
        try {
            FileOutputStream fos2 = new sq(q(), sessionId + "SessionUser");
            try {
                cos = CodedOutputStream.a(fos2);
                to userMetaData = g(sessionId);
                if (userMetaData.a()) {
                    CommonUtils.a(cos, "Failed to flush session user file.");
                    CommonUtils.a(fos2, "Failed to close session user file.");
                    return;
                }
                tl.a(cos, userMetaData.b, userMetaData.c, userMetaData.d);
                CommonUtils.a(cos, "Failed to flush session user file.");
                CommonUtils.a(fos2, "Failed to close session user file.");
            } catch (Throwable th2) {
                th = th2;
                fos = fos2;
                CommonUtils.a(cos, "Failed to flush session user file.");
                CommonUtils.a(fos, "Failed to close session user file.");
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            CommonUtils.a(cos, "Failed to flush session user file.");
            CommonUtils.a(fos, "Failed to close session user file.");
            throw th;
        }
    }

    private void a(CodedOutputStream cos, Date time, Thread thread, Throwable ex, String eventType, boolean includeAllThreads) throws Exception {
        Thread[] threads;
        Map attributes;
        Context context = this.n.E();
        long eventTime = time.getTime() / 1000;
        float batteryLevel = CommonUtils.c(context);
        int batteryVelocity = CommonUtils.a(context, this.p.a());
        boolean proximityEnabled = CommonUtils.d(context);
        int orientation = context.getResources().getConfiguration().orientation;
        long usedRamBytes = CommonUtils.b() - CommonUtils.b(context);
        long diskUsedBytes = CommonUtils.b(Environment.getDataDirectory().getPath());
        RunningAppProcessInfo runningAppProcessInfo = CommonUtils.a(context.getPackageName(), context);
        List stacks = new LinkedList();
        StackTraceElement[] exceptionStack = ex.getStackTrace();
        String buildId = this.n.n();
        String appIdentifier = this.m.c();
        if (includeAllThreads) {
            Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
            threads = new Thread[allStackTraces.size()];
            int i = 0;
            for (Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()) {
                threads[i] = (Thread) entry.getKey();
                stacks.add(entry.getValue());
                i++;
            }
        } else {
            threads = new Thread[0];
        }
        if (CommonUtils.a(context, "com.crashlytics.CollectCustomKeys", true)) {
            Map<String, String> attributes2 = this.n.g();
            if (attributes2 != null && attributes2.size() > 1) {
                attributes2 = new TreeMap(attributes2);
            }
        } else {
            attributes = new TreeMap();
        }
        tl.a(cos, eventTime, eventType, ex, thread, exceptionStack, threads, stacks, attributes, this.o, runningAppProcessInfo, orientation, appIdentifier, buildId, batteryLevel, batteryVelocity, proximityEnabled, usedRamBytes, diskUsedBytes);
    }

    private void a(File sessionBeginFile, String sessionId, int maxLoggedExceptionsCount) {
        akp.h().a("CrashlyticsCore", "Collecting session parts for ID " + sessionId);
        File[] fatalFiles = a(new sw$b(sessionId + "SessionCrash"));
        boolean hasFatal = fatalFiles != null && fatalFiles.length > 0;
        akp.h().a("CrashlyticsCore", String.format(Locale.US, "Session %s has fatal exception: %s", new Object[]{sessionId, Boolean.valueOf(hasFatal)}));
        File[] nonFatalFiles = a(new sw$b(sessionId + "SessionEvent"));
        boolean hasNonFatal = nonFatalFiles != null && nonFatalFiles.length > 0;
        akp.h().a("CrashlyticsCore", String.format(Locale.US, "Session %s has non-fatal exceptions: %s", new Object[]{sessionId, Boolean.valueOf(hasNonFatal)}));
        if (hasFatal || hasNonFatal) {
            a(sessionBeginFile, sessionId, a(sessionId, nonFatalFiles, maxLoggedExceptionsCount), hasFatal ? fatalFiles[0] : null);
        } else {
            akp.h().a("CrashlyticsCore", "No events present for session ID " + sessionId);
        }
        akp.h().a("CrashlyticsCore", "Removing session part files for ID " + sessionId);
        a(sessionId);
    }

    private void a(File sessionBeginFile, String sessionId, File[] nonFatalFiles, File fatalFile) {
        Exception e;
        Throwable th;
        boolean hasFatal = fatalFile != null;
        sq fos = null;
        try {
            sq fos2 = new sq(q(), sessionId);
            try {
                CodedOutputStream cos = CodedOutputStream.a(fos2);
                akp.h().a("CrashlyticsCore", "Collecting SessionStart data for session ID " + sessionId);
                sw.a(cos, sessionBeginFile);
                cos.a(4, new Date().getTime() / 1000);
                cos.a(5, hasFatal);
                cos.a(11, 1);
                cos.b(12, 3);
                a(cos, sessionId);
                sw.a(cos, nonFatalFiles, sessionId);
                if (hasFatal) {
                    sw.a(cos, fatalFile);
                }
                CommonUtils.a(cos, "Error flushing session file stream");
                if (null != null) {
                    a(fos2);
                    fos = fos2;
                    return;
                }
                CommonUtils.a(fos2, "Failed to close CLS file");
                fos = fos2;
            } catch (Exception e2) {
                e = e2;
                fos = fos2;
                try {
                    akp.h().e("CrashlyticsCore", "Failed to write session file for session ID: " + sessionId, e);
                    CommonUtils.a(null, "Error flushing session file stream");
                    if (true) {
                        a(fos);
                    } else {
                        CommonUtils.a(fos, "Failed to close CLS file");
                    }
                } catch (Throwable th2) {
                    th = th2;
                    CommonUtils.a(null, "Error flushing session file stream");
                    if (null == null) {
                        a(fos);
                    } else {
                        CommonUtils.a(fos, "Failed to close CLS file");
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fos = fos2;
                CommonUtils.a(null, "Error flushing session file stream");
                if (null == null) {
                    CommonUtils.a(fos, "Failed to close CLS file");
                } else {
                    a(fos);
                }
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            akp.h().e("CrashlyticsCore", "Failed to write session file for session ID: " + sessionId, e);
            CommonUtils.a(null, "Error flushing session file stream");
            if (true) {
                a(fos);
            } else {
                CommonUtils.a(fos, "Failed to close CLS file");
            }
        }
    }

    private static void a(CodedOutputStream cos, File[] nonFatalFiles, String sessionId) {
        Arrays.sort(nonFatalFiles, CommonUtils.a);
        for (File nonFatalFile : nonFatalFiles) {
            try {
                akp.h().a("CrashlyticsCore", String.format(Locale.US, "Found Non Fatal for session ID %s in %s ", new Object[]{sessionId, nonFatalFile.getName()}));
                sw.a(cos, nonFatalFile);
            } catch (Exception e) {
                akp.h().e("CrashlyticsCore", "Error writting non-fatal to session.", e);
            }
        }
    }

    private void a(CodedOutputStream cos, String sessionId) throws IOException {
        for (String tag : g) {
            File[] sessionPartFiles = a(new sw$b(sessionId + tag));
            if (sessionPartFiles.length == 0) {
                akp.h().e("CrashlyticsCore", "Can't find " + tag + " data for session ID " + sessionId, null);
            } else {
                akp.h().a("CrashlyticsCore", "Collecting " + tag + " data for session ID " + sessionId);
                sw.a(cos, sessionPartFiles[0]);
            }
        }
    }

    private static void a(CodedOutputStream cos, File file) throws IOException {
        Throwable th;
        if (file.exists()) {
            FileInputStream fis = null;
            try {
                InputStream fis2 = new FileInputStream(file);
                try {
                    sw.a(fis2, cos, (int) file.length());
                    CommonUtils.a(fis2, "Failed to close file input stream.");
                    return;
                } catch (Throwable th2) {
                    th = th2;
                    InputStream fis3 = fis2;
                    CommonUtils.a(fis, "Failed to close file input stream.");
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                CommonUtils.a(fis, "Failed to close file input stream.");
                throw th;
            }
        }
        akp.h().e("CrashlyticsCore", "Tried to include a file that doesn't exist: " + file.getName(), null);
    }

    private static void a(InputStream inStream, CodedOutputStream cos, int bufferLength) throws IOException {
        byte[] buffer = new byte[bufferLength];
        int offset = 0;
        while (offset < buffer.length) {
            int numRead = inStream.read(buffer, offset, buffer.length - offset);
            if (numRead < 0) {
                break;
            }
            offset += numRead;
        }
        cos.a(buffer);
    }

    private to g(String sessionId) {
        return a() ? new to(this.n.p(), this.n.r(), this.n.q()) : new tf(q()).a(sessionId);
    }

    private void p() {
        for (File finishedSessionFile : m()) {
            this.l.a(new sw$c(this.n, finishedSessionFile));
        }
    }

    private File q() {
        return this.j.a();
    }
}
