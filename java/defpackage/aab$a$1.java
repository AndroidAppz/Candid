package defpackage;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

class aab$a$1 implements Callable<Boolean> {
    final /* synthetic */ SharedPreferences a;
    final /* synthetic */ String b;
    final /* synthetic */ Boolean c;

    aab$a$1(SharedPreferences sharedPreferences, String str, Boolean bool) {
        this.a = sharedPreferences;
        this.b = str;
        this.c = bool;
    }

    public Boolean a() {
        return Boolean.valueOf(this.a.getBoolean(this.b, this.c.booleanValue()));
    }

    public /* synthetic */ Object call() throws Exception {
        return a();
    }
}
