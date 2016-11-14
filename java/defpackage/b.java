package defpackage;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;

/* compiled from: CustomTabsIntent */
public final class b {
    public final Intent a;
    public final Bundle b;

    public void a(Activity context, Uri url) {
        this.a.setData(url);
        ActivityCompat.startActivity(context, this.a, this.b);
    }

    private b(Intent intent, Bundle startAnimationBundle) {
        this.a = intent;
        this.b = startAnimationBundle;
    }
}
