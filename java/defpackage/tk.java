package defpackage;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* compiled from: ReportUploader */
class tk {
    static final Map<String, String> a = Collections.singletonMap("X-CRASHLYTICS-INVALID-SESSION", "1");
    private static final FilenameFilter b = new tk$1();
    private static final short[] c = new short[]{(short) 10, (short) 20, (short) 30, (short) 60, (short) 120, (short) 300};
    private final Object d = new Object();
    private final sy e;
    private Thread f;

    public tk(sy createReportCall) {
        if (createReportCall == null) {
            throw new IllegalArgumentException("createReportCall must not be null.");
        }
        this.e = createReportCall;
    }

    public synchronized void a(float delay) {
        if (this.f == null) {
            this.f = new Thread(new tk$a(this, delay), "Crashlytics Report Uploader");
            this.f.start();
        }
    }

    boolean a(tj report) {
        boolean removed = false;
        synchronized (this.d) {
            try {
                boolean sent = this.e.a(new sx(new alj().a(sr.e().E()), report));
                akp.h().c("CrashlyticsCore", "Crashlytics report upload " + (sent ? "complete: " : "FAILED: ") + report.b());
                if (sent) {
                    report.a();
                    removed = true;
                }
            } catch (Exception e) {
                akp.h().e("CrashlyticsCore", "Error occurred sending report " + report, e);
            }
        }
        return removed;
    }

    List<tj> a() {
        akp.h().a("CrashlyticsCore", "Checking for crash reports...");
        synchronized (this.d) {
            File[] clsFiles = sr.e().w().listFiles(b);
        }
        List<tj> reports = new LinkedList();
        for (File file : clsFiles) {
            akp.h().a("CrashlyticsCore", "Found crash report " + file.getPath());
            reports.add(new tm(file));
        }
        if (reports.isEmpty()) {
            akp.h().a("CrashlyticsCore", "No reports found.");
        }
        return reports;
    }
}
