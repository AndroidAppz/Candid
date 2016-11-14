package defpackage;

import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.ViewGroup;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: DimensionConverter */
public class jf {
    public static Map<String, Float> a = new HashMap();
    public static final Map<String, Integer> b = jf.a();
    private static final Pattern c = Pattern.compile("^\\s*(\\d+(\\.\\d+)*)\\s*([a-zA-Z]+)\\s*$");

    private static Map<String, Integer> a() {
        Map<String, Integer> m = new HashMap();
        m.put("px", Integer.valueOf(0));
        m.put("dip", Integer.valueOf(1));
        m.put("dp", Integer.valueOf(1));
        m.put("sp", Integer.valueOf(2));
        m.put("pt", Integer.valueOf(3));
        m.put("in", Integer.valueOf(4));
        m.put("mm", Integer.valueOf(5));
        return Collections.unmodifiableMap(m);
    }

    public static int a(String dimension, DisplayMetrics metrics, ViewGroup parent, boolean horizontal) {
        if (!dimension.endsWith("%")) {
            return jf.a(dimension, metrics);
        }
        return (int) (((float) (horizontal ? parent.getMeasuredWidth() : parent.getMeasuredHeight())) * (Float.parseFloat(dimension.substring(0, dimension.length() - 1)) / 100.0f));
    }

    public static int a(String dimension, DisplayMetrics metrics) {
        float f;
        if (a.containsKey(dimension)) {
            f = ((Float) a.get(dimension)).floatValue();
        } else {
            jf$a internalDimension = jf.a(dimension);
            f = TypedValue.applyDimension(internalDimension.b, internalDimension.a, metrics);
            a.put(dimension, Float.valueOf(f));
        }
        int res = (int) (0.5f + f);
        if (res != 0) {
            return res;
        }
        if (f == 0.0f) {
            return 0;
        }
        if (f > 0.0f) {
            return 1;
        }
        return -1;
    }

    public static float b(String dimension, DisplayMetrics metrics) {
        if (a.containsKey(dimension)) {
            return ((Float) a.get(dimension)).floatValue();
        }
        jf$a internalDimension = jf.a(dimension);
        float val = TypedValue.applyDimension(internalDimension.b, internalDimension.a, metrics);
        a.put(dimension, Float.valueOf(val));
        return val;
    }

    private static jf$a a(String dimension) {
        Matcher matcher = c.matcher(dimension);
        if (matcher.matches()) {
            float value = Float.valueOf(matcher.group(1)).floatValue();
            Integer dimensionUnit = (Integer) b.get(matcher.group(3).toLowerCase());
            if (dimensionUnit != null) {
                return new jf$a(value, dimensionUnit.intValue());
            }
            throw new NumberFormatException();
        }
        Log.e("DimensionConverter", "Invalid number format: " + dimension);
        throw new NumberFormatException();
    }
}
