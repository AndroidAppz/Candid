/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.AssetManager
 *  android.graphics.Typeface
 *  android.util.Log
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 */
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.Log;
import java.util.HashMap;

public class ic {
    private static volatile ic a;
    private Context b;
    private HashMap<String, Typeface> c = new HashMap();

    private ic(Context context) {
        this.b = context;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public static ic a(Context context) {
        if (a != null) return a;
        reference var2_1 = ic.class;
        // MONITORENTER : ic.class
        if (a == null) {
            a = new ic(context);
        }
        // MONITOREXIT : var2_1
        return a;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public Typeface a(String string2) {
        Typeface typeface = (Typeface)this.c.get((Object)string2);
        if (typeface != null) return typeface;
        try {
            typeface = Typeface.createFromAsset((AssetManager)this.b.getAssets(), (String)("fonts/" + string2));
            this.c.put((Object)string2, (Object)typeface);
        }
        catch (Exception exception) {
            Log.e((String)"FontFactory", (String)("Could not get typeface: " + exception.getMessage() + " with name: " + string2));
            return null;
        }
        return typeface;
    }
}

