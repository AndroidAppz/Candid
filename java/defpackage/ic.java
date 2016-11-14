package defpackage;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import java.util.HashMap;

/* compiled from: FontFactory */
public class ic {
    private static volatile ic a;
    private Context b;
    private HashMap<String, Typeface> c = new HashMap();

    private ic(Context context) {
        this.b = context;
    }

    public static ic a(Context context) {
        if (a == null) {
            synchronized (ic.class) {
                if (a == null) {
                    a = new ic(context);
                }
            }
        }
        return a;
    }

    public Typeface a(String font) {
        Typeface typeface = (Typeface) this.c.get(font);
        if (typeface == null) {
            try {
                typeface = Typeface.createFromAsset(this.b.getAssets(), "fonts/" + font);
                this.c.put(font, typeface);
            } catch (Exception e) {
                Log.e("FontFactory", "Could not get typeface: " + e.getMessage() + " with name: " + font);
                return null;
            }
        }
        return typeface;
    }
}
