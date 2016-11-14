package defpackage;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ViewTarget */
class qr$a {
    private final View a;
    private final List<qo> b = new ArrayList();
    private qr$a$a c;
    private Point d;

    public qr$a(View view) {
        this.a = view;
    }

    private void a(int width, int height) {
        for (qo cb : this.b) {
            cb.a(width, height);
        }
        this.b.clear();
    }

    private void a() {
        if (!this.b.isEmpty()) {
            int currentWidth = c();
            int currentHeight = b();
            if (a(currentWidth) && a(currentHeight)) {
                a(currentWidth, currentHeight);
                ViewTreeObserver observer = this.a.getViewTreeObserver();
                if (observer.isAlive()) {
                    observer.removeOnPreDrawListener(this.c);
                }
                this.c = null;
            }
        }
    }

    public void a(qo cb) {
        int currentWidth = c();
        int currentHeight = b();
        if (a(currentWidth) && a(currentHeight)) {
            cb.a(currentWidth, currentHeight);
            return;
        }
        if (!this.b.contains(cb)) {
            this.b.add(cb);
        }
        if (this.c == null) {
            ViewTreeObserver observer = this.a.getViewTreeObserver();
            this.c = new qr$a$a(this);
            observer.addOnPreDrawListener(this.c);
        }
    }

    private int b() {
        LayoutParams layoutParams = this.a.getLayoutParams();
        if (a(this.a.getHeight())) {
            return this.a.getHeight();
        }
        if (layoutParams != null) {
            return a(layoutParams.height, true);
        }
        return 0;
    }

    private int c() {
        LayoutParams layoutParams = this.a.getLayoutParams();
        if (a(this.a.getWidth())) {
            return this.a.getWidth();
        }
        if (layoutParams != null) {
            return a(layoutParams.width, false);
        }
        return 0;
    }

    private int a(int param, boolean isHeight) {
        if (param != -2) {
            return param;
        }
        Point displayDimens = d();
        return isHeight ? displayDimens.y : displayDimens.x;
    }

    @TargetApi(13)
    private Point d() {
        if (this.d != null) {
            return this.d;
        }
        Display display = ((WindowManager) this.a.getContext().getSystemService("window")).getDefaultDisplay();
        if (VERSION.SDK_INT >= 13) {
            this.d = new Point();
            display.getSize(this.d);
        } else {
            this.d = new Point(display.getWidth(), display.getHeight());
        }
        return this.d;
    }

    private boolean a(int size) {
        return size > 0 || size == -2;
    }
}
