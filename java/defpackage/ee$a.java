package defpackage;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater.Factory2;
import android.view.View;

/* compiled from: LayoutInflaterCompatHC */
class ee$a extends ed$a implements Factory2 {
    ee$a(eg delegateFactory) {
        super(delegateFactory);
    }

    public View onCreateView(View parent, String name, Context context, AttributeSet attributeSet) {
        return this.a.onCreateView(parent, name, context, attributeSet);
    }
}
