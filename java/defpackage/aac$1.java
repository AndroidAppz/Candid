package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.Callable;

class aac$1 implements Callable<SharedPreferences> {
    final /* synthetic */ Context a;

    aac$1(Context context) {
        this.a = context;
    }

    public SharedPreferences a() {
        return this.a.getSharedPreferences("google_sdk_flags", 1);
    }

    public /* synthetic */ Object call() throws Exception {
        return a();
    }
}
