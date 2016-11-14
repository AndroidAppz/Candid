package defpackage;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

class aab$d$1 implements Callable<String> {
    final /* synthetic */ SharedPreferences a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;

    aab$d$1(SharedPreferences sharedPreferences, String str, String str2) {
        this.a = sharedPreferences;
        this.b = str;
        this.c = str2;
    }

    public String a() {
        return this.a.getString(this.b, this.c);
    }

    public /* synthetic */ Object call() throws Exception {
        return a();
    }
}
