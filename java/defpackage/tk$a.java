package defpackage;

import java.util.List;

/* compiled from: ReportUploader */
class tk$a extends alk {
    final /* synthetic */ tk a;
    private final float b;

    tk$a(tk tkVar, float delay) {
        this.a = tkVar;
        this.b = delay;
    }

    public void a() {
        try {
            b();
        } catch (Exception e) {
            akp.h().e("CrashlyticsCore", "An unexpected error occurred while attempting to upload crash reports.", e);
        }
        this.a.f = null;
    }

    private void b() {
        akp.h().a("CrashlyticsCore", "Starting report processing in " + this.b + " second(s)...");
        if (this.b > 0.0f) {
            try {
                Thread.sleep((long) (this.b * 1000.0f));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        sr crashlyticsCore = sr.e();
        sw handler = crashlyticsCore.o();
        List<tj> reports = this.a.a();
        if (!handler.a()) {
            if (reports.isEmpty() || crashlyticsCore.z()) {
                int retryCount = 0;
                while (!reports.isEmpty() && !sr.e().o().a()) {
                    akp.h().a("CrashlyticsCore", "Attempting to send " + reports.size() + " report(s)");
                    for (tj report : reports) {
                        this.a.a(report);
                    }
                    reports = this.a.a();
                    if (!reports.isEmpty()) {
                        int retryCount2 = retryCount + 1;
                        long interval = (long) tk.c[Math.min(retryCount, tk.c.length - 1)];
                        akp.h().a("CrashlyticsCore", "Report submisson: scheduling delayed retry in " + interval + " seconds");
                        try {
                            Thread.sleep(1000 * interval);
                            retryCount = retryCount2;
                        } catch (InterruptedException e2) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                }
                return;
            }
            akp.h().a("CrashlyticsCore", "User declined to send. Removing " + reports.size() + " Report(s).");
            for (tj report2 : reports) {
                report2.a();
            }
        }
    }
}
