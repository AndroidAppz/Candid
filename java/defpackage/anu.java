package defpackage;

/* compiled from: SettingsData */
public class anu {
    public final ang a;
    public final anr b;
    public final anq c;
    public final ano d;
    public final and e;
    public final anh f;
    public final long g;
    public final int h;
    public final int i;

    public anu(long expiresAtMillis, ang appData, anr sessionData, anq promptData, ano featuresData, and analyticsSettingsData, anh betaSettingsData, int settingsVersion, int cacheDuration) {
        this.g = expiresAtMillis;
        this.a = appData;
        this.b = sessionData;
        this.c = promptData;
        this.d = featuresData;
        this.h = settingsVersion;
        this.i = cacheDuration;
        this.e = analyticsSettingsData;
        this.f = betaSettingsData;
    }

    public boolean a(long currentTimeMillis) {
        return this.g < currentTimeMillis;
    }
}
