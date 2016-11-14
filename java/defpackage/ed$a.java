package defpackage;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater.Factory;
import android.view.View;

/* compiled from: LayoutInflaterCompatBase */
class ed$a implements Factory {
    final eg a;

    ed$a(eg delegateFactory) {
        this.a = delegateFactory;
    }

    public View onCreateView(String name, Context context, AttributeSet attrs) {
        return this.a.onCreateView(null, name, context, attrs);
    }

    public String toString() {
        return getClass().getName() + "{" + this.a + "}";
    }
}
