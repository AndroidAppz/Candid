package defpackage;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;

@TargetApi(14)
class afx$a implements ActivityLifecycleCallbacks {
    final /* synthetic */ afx a;

    private afx$a(afx afx) {
        this.a = afx;
    }

    private boolean a(Uri uri) {
        Object queryParameter = uri.getQueryParameter("utm_campaign");
        Object queryParameter2 = uri.getQueryParameter("utm_source");
        Object queryParameter3 = uri.getQueryParameter("utm_medium");
        Object queryParameter4 = uri.getQueryParameter("gclid");
        if (TextUtils.isEmpty(queryParameter) && TextUtils.isEmpty(queryParameter2) && TextUtils.isEmpty(queryParameter3) && TextUtils.isEmpty(queryParameter4)) {
            return false;
        }
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(queryParameter)) {
            bundle.putString("campaign", queryParameter);
        }
        if (!TextUtils.isEmpty(queryParameter2)) {
            bundle.putString("source", queryParameter2);
        }
        if (!TextUtils.isEmpty(queryParameter3)) {
            bundle.putString("medium", queryParameter3);
        }
        if (!TextUtils.isEmpty(queryParameter4)) {
            bundle.putString("gclid", queryParameter4);
        }
        queryParameter = uri.getQueryParameter("utm_term");
        if (!TextUtils.isEmpty(queryParameter)) {
            bundle.putString("term", queryParameter);
        }
        queryParameter = uri.getQueryParameter("utm_content");
        if (!TextUtils.isEmpty(queryParameter)) {
            bundle.putString("content", queryParameter);
        }
        queryParameter = uri.getQueryParameter("aclid");
        if (!TextUtils.isEmpty(queryParameter)) {
            bundle.putString("aclid", queryParameter);
        }
        queryParameter = uri.getQueryParameter("cp1");
        if (!TextUtils.isEmpty(queryParameter)) {
            bundle.putString("cp1", queryParameter);
        }
        queryParameter = uri.getQueryParameter("anid");
        if (!TextUtils.isEmpty(queryParameter)) {
            bundle.putString("anid", queryParameter);
        }
        this.a.a("auto", "_cmp", bundle);
        return true;
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        this.a.a("auto", "_ldl", (Object) str);
        return true;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        try {
            this.a.w().E().a("onActivityCreated");
            Intent intent = activity.getIntent();
            if (intent != null) {
                Uri data = intent.getData();
                if (data != null && data.isHierarchical()) {
                    if (bundle == null) {
                        a(data);
                    }
                    String queryParameter = data.getQueryParameter("referrer");
                    if (!TextUtils.isEmpty(queryParameter)) {
                        if (queryParameter.contains("gclid")) {
                            this.a.w().D().a("Activity created with referrer", queryParameter);
                            a(queryParameter);
                            return;
                        }
                        this.a.w().D().a("Activity created with data 'referrer' param without gclid");
                    }
                }
            }
        } catch (Throwable th) {
            this.a.w().f().a("Throwable caught in onActivityCreated", th);
        }
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
        this.a.u().g();
    }

    public void onActivityResumed(Activity activity) {
        this.a.u().f();
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }
}
