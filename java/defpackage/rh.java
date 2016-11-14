package defpackage;

import android.content.Context;
import android.os.Looper;
import java.io.IOException;

/* compiled from: AnswersFilesManagerProvider */
class rh {
    final Context a;
    final amy b;

    public rh(Context context, amy fileStore) {
        this.a = context;
        this.b = fileStore;
    }

    public rv a() throws IOException {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("AnswersFilesManagerProvider cannot be called on the main thread");
        }
        return new rv(this.a, new sa(), new als(), new amo(this.a, this.b.a(), "session_analytics.tap", "session_analytics_to_send"));
    }
}
