package defpackage;

/* compiled from: AnalyticsSettingsData */
public class and {
    public final String a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final int i;

    public and(String analyticsURL, int flushIntervalSeconds, int maxByteSizePerFile, int maxFileCountPerSend, int maxPendingSendFileCount, boolean trackCustomEvents, boolean trackPredefinedEvents, int samplingRate, boolean flushOnBackground) {
        this.a = analyticsURL;
        this.b = flushIntervalSeconds;
        this.c = maxByteSizePerFile;
        this.d = maxFileCountPerSend;
        this.e = maxPendingSendFileCount;
        this.f = trackCustomEvents;
        this.g = trackPredefinedEvents;
        this.i = samplingRate;
        this.h = flushOnBackground;
    }
}
