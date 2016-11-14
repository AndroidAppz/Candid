package defpackage;

import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;
import java.io.File;
import java.util.Set;

/* compiled from: LogFileManager */
class td {
    private static final td$a a = new td$a(null);
    private final Context b;
    private final amy c;
    private tc d;

    public td(Context context, amy fileStore) {
        this(context, fileStore, null);
    }

    public td(Context context, amy fileStore, String currentSessionId) {
        this.b = context;
        this.c = fileStore;
        this.d = a;
        a(currentSessionId);
    }

    public final void a(String sessionId) {
        this.d.b();
        this.d = a;
        if (sessionId != null) {
            if (c()) {
                a(b(sessionId), 65536);
            } else {
                akp.h().a("CrashlyticsCore", "Preferences requested no custom logs. Aborting log file creation.");
            }
        }
    }

    public so a() {
        return this.d.a();
    }

    public void b() {
        this.d.c();
    }

    public void a(Set<String> sessionIdsToKeep) {
        File[] logFiles = d().listFiles();
        if (logFiles != null) {
            for (File file : logFiles) {
                if (!sessionIdsToKeep.contains(a(file))) {
                    file.delete();
                }
            }
        }
    }

    void a(File workingFile, int maxLogSize) {
        this.d = new ti(workingFile, maxLogSize);
    }

    private File b(String sessionId) {
        return new File(d(), "crashlytics-userlog-" + sessionId + ".temp");
    }

    private String a(File workingFile) {
        String filename = workingFile.getName();
        int indexOfExtension = filename.lastIndexOf(".temp");
        return indexOfExtension == -1 ? filename : filename.substring("crashlytics-userlog-".length(), indexOfExtension);
    }

    private boolean c() {
        return CommonUtils.a(this.b, "com.crashlytics.CollectCustomLogs", true);
    }

    private File d() {
        File logFileDir = new File(this.c.a(), "log-files");
        if (!logFileDir.exists()) {
            logFileDir.mkdirs();
        }
        return logFileDir;
    }
}
