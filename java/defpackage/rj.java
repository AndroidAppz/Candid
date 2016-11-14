package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;

/* compiled from: AnswersPreferenceManager */
class rj {
    private final ana a;

    public static rj a(Context context) {
        return new rj(new anb(context, "settings"));
    }

    rj(ana prefStore) {
        this.a = prefStore;
    }

    @SuppressLint({"CommitPrefEdits"})
    public void a() {
        this.a.a(this.a.b().putBoolean("analytics_launched", true));
    }

    @SuppressLint({"CommitPrefEdits"})
    public boolean b() {
        return this.a.a().getBoolean("analytics_launched", false);
    }
}
