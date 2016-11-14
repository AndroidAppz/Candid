package defpackage;

import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;

/* compiled from: DialogStringResolver */
class tb {
    private final Context a;
    private final anq b;

    public tb(Context context, anq promptData) {
        this.a = context;
        this.b = promptData;
    }

    public String a() {
        return a("com.crashlytics.CrashSubmissionPromptTitle", this.b.a);
    }

    public String b() {
        return a("com.crashlytics.CrashSubmissionPromptMessage", this.b.b);
    }

    public String c() {
        return a("com.crashlytics.CrashSubmissionSendTitle", this.b.c);
    }

    public String d() {
        return a("com.crashlytics.CrashSubmissionAlwaysSendTitle", this.b.g);
    }

    public String e() {
        return a("com.crashlytics.CrashSubmissionCancelTitle", this.b.e);
    }

    private String a(String resourceName, String settingsValue) {
        return b(CommonUtils.b(this.a, resourceName), settingsValue);
    }

    private String b(String firstChoice, String fallback) {
        return a(firstChoice) ? fallback : firstChoice;
    }

    private boolean a(String s) {
        return s == null || s.length() == 0;
    }
}
