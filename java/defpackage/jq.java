package defpackage;

import android.content.Context;
import android.os.Build.VERSION;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.executor.FifoPriorityThreadPoolExecutor;
import java.util.concurrent.ExecutorService;

/* compiled from: GlideBuilder */
public class jq {
    private final Context a;
    private ku b;
    private lf c;
    private lt d;
    private ExecutorService e;
    private ExecutorService f;
    private DecodeFormat g;
    private lm$a h;

    public jq(Context context) {
        this.a = context.getApplicationContext();
    }

    jp a() {
        if (this.e == null) {
            this.e = new FifoPriorityThreadPoolExecutor(Math.max(1, Runtime.getRuntime().availableProcessors()));
        }
        if (this.f == null) {
            this.f = new FifoPriorityThreadPoolExecutor(1);
        }
        lu calculator = new lu(this.a);
        if (this.c == null) {
            if (VERSION.SDK_INT >= 11) {
                this.c = new li(calculator.b());
            } else {
                this.c = new lg();
            }
        }
        if (this.d == null) {
            this.d = new ls(calculator.a());
        }
        if (this.h == null) {
            this.h = new lr(this.a);
        }
        if (this.b == null) {
            this.b = new ku(this.d, this.h, this.f, this.e);
        }
        if (this.g == null) {
            this.g = DecodeFormat.d;
        }
        return new jp(this.b, this.d, this.c, this.a, this.g);
    }
}
