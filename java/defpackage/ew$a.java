package defpackage;

import android.content.Context;
import android.text.method.SingleLineTransformationMethod;
import android.view.View;
import java.util.Locale;

/* compiled from: PagerTitleStripIcs */
class ew$a extends SingleLineTransformationMethod {
    private Locale a;

    public ew$a(Context context) {
        this.a = context.getResources().getConfiguration().locale;
    }

    public CharSequence getTransformation(CharSequence source, View view) {
        source = super.getTransformation(source, view);
        return source != null ? source.toString().toUpperCase(this.a) : null;
    }
}
