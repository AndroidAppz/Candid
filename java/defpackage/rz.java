package defpackage;

/* compiled from: SessionEventMetadata */
public final class rz {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final Boolean f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;
    private String m;

    public rz(String appBundleId, String executionId, String installationId, String androidId, String advertisingId, Boolean limitAdTrackingEnabled, String betaDeviceToken, String buildId, String osVersion, String deviceModel, String appVersionCode, String appVersionName) {
        this.a = appBundleId;
        this.b = executionId;
        this.c = installationId;
        this.d = androidId;
        this.e = advertisingId;
        this.f = limitAdTrackingEnabled;
        this.g = betaDeviceToken;
        this.h = buildId;
        this.i = osVersion;
        this.j = deviceModel;
        this.k = appVersionCode;
        this.l = appVersionName;
    }

    public String toString() {
        if (this.m == null) {
            this.m = "appBundleId=" + this.a + ", executionId=" + this.b + ", installationId=" + this.c + ", androidId=" + this.d + ", advertisingId=" + this.e + ", limitAdTrackingEnabled=" + this.f + ", betaDeviceToken=" + this.g + ", buildId=" + this.h + ", osVersion=" + this.i + ", deviceModel=" + this.j + ", appVersionCode=" + this.k + ", appVersionName=" + this.l;
        }
        return this.m;
    }
}
