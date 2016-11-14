/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.util.DisplayMetrics
 *  android.util.Log
 *  android.util.TypedValue
 *  android.view.ViewGroup
 *  java.lang.CharSequence
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 */
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.ViewGroup;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class jf {
    public static Map<String, Float> a = new HashMap();
    public static final Map<String, Integer> b = jf.a();
    private static final Pattern c = Pattern.compile((String)"^\\s*(\\d+(\\.\\d+)*)\\s*([a-zA-Z]+)\\s*$");

    /*
     * Enabled aggressive block sorting
     */
    public static int a(String string2, DisplayMetrics displayMetrics) {
        int n2;
        float f2;
        if (a.containsKey((Object)string2)) {
            f2 = ((Float)a.get((Object)string2)).floatValue();
        } else {
            a a2 = jf.a(string2);
            float f3 = a2.a;
            f2 = TypedValue.applyDimension((int)a2.b, (float)f3, (DisplayMetrics)displayMetrics);
            a.put((Object)string2, (Object)Float.valueOf((float)f2));
        }
        if ((n2 = (int)(0.5f + f2)) != 0) {
            return n2;
        }
        if (f2 == 0.0f) {
            return 0;
        }
        if (f2 > 0.0f) {
            return 1;
        }
        return -1;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int a(String string2, DisplayMetrics displayMetrics, ViewGroup viewGroup, boolean bl2) {
        int n2;
        if (!string2.endsWith("%")) return jf.a(string2, displayMetrics);
        float f2 = Float.parseFloat((String)string2.substring(0, -1 + string2.length())) / 100.0f;
        if (bl2) {
            n2 = viewGroup.getMeasuredWidth();
            do {
                return (int)(f2 * (float)n2);
                break;
            } while (true);
        }
        n2 = viewGroup.getMeasuredHeight();
        return (int)(f2 * (float)n2);
    }

    private static Map<String, Integer> a() {
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"px", (Object)0);
        hashMap.put((Object)"dip", (Object)1);
        hashMap.put((Object)"dp", (Object)1);
        hashMap.put((Object)"sp", (Object)2);
        hashMap.put((Object)"pt", (Object)3);
        hashMap.put((Object)"in", (Object)4);
        hashMap.put((Object)"mm", (Object)5);
        return Collections.unmodifiableMap((Map)hashMap);
    }

    private static a a(String string2) {
        Matcher matcher = c.matcher((CharSequence)string2);
        if (matcher.matches()) {
            float f2 = Float.valueOf((String)matcher.group(1)).floatValue();
            String string3 = matcher.group(3).toLowerCase();
            Integer n2 = (Integer)b.get((Object)string3);
            if (n2 == null) {
                throw new NumberFormatException();
            }
            return new a(f2, n2);
        }
        Log.e((String)"DimensionConverter", (String)("Invalid number format: " + string2));
        throw new NumberFormatException();
    }

    public static float b(String string2, DisplayMetrics displayMetrics) {
        if (a.containsKey((Object)string2)) {
            return ((Float)a.get((Object)string2)).floatValue();
        }
        a a2 = jf.a(string2);
        float f2 = TypedValue.applyDimension((int)a2.b, (float)a2.a, (DisplayMetrics)displayMetrics);
        a.put((Object)string2, (Object)Float.valueOf((float)f2));
        return f2;
    }

    static class a {
        float a;
        int b;

        public a(float f2, int n2) {
            this.a = f2;
            this.b = n2;
        }
    }

}

