/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.text.method.SingleLineTransformationMethod
 *  android.text.method.TransformationMethod
 *  android.view.View
 *  android.widget.TextView
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Locale
 */
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.method.SingleLineTransformationMethod;
import android.text.method.TransformationMethod;
import android.view.View;
import android.widget.TextView;
import java.util.Locale;

public class ew {
    public static void a(TextView textView) {
        textView.setTransformationMethod((TransformationMethod)new a(textView.getContext()));
    }

    static class a
    extends SingleLineTransformationMethod {
        private Locale a;

        public a(Context context) {
            this.a = context.getResources().getConfiguration().locale;
        }

        public CharSequence getTransformation(CharSequence charSequence, View view) {
            CharSequence charSequence2 = super.getTransformation(charSequence, view);
            if (charSequence2 != null) {
                return charSequence2.toString().toUpperCase(this.a);
            }
            return null;
        }
    }

}

