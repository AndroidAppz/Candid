/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.content.Context
 *  android.widget.OverScroller
 */
import android.annotation.TargetApi;
import android.content.Context;
import android.widget.OverScroller;

@TargetApi(value=14)
public class atf
extends ate {
    public atf(Context context) {
        super(context);
    }

    @Override
    public boolean a() {
        return this.a.computeScrollOffset();
    }
}

