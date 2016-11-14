package defpackage;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

class aab$c$1 implements Callable<Long> {
    final /* synthetic */ SharedPreferences a;
    final /* synthetic */ String b;
    final /* synthetic */ Long c;

    aab$c$1(SharedPreferences sharedPreferences, String str, Long l) {
        this.a = sharedPreferences;
        this.b = str;
        this.c = l;
    }

    public Long a() {
        return Long.valueOf(this.a.getLong(this.b, this.c.longValue()));
    }

    public /* synthetic */ Object call() throws Exception {
        return a();
    }
}
