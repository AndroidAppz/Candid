/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.res.TypedArray
 *  java.lang.Object
 *  java.lang.String
 *  org.xmlpull.v1.XmlPullParser
 */
import android.content.res.TypedArray;
import org.xmlpull.v1.XmlPullParser;

class am {
    public static float a(TypedArray typedArray, XmlPullParser xmlPullParser, String string2, int n2, float f2) {
        if (!am.a(xmlPullParser, string2)) {
            return f2;
        }
        return typedArray.getFloat(n2, f2);
    }

    public static int a(TypedArray typedArray, XmlPullParser xmlPullParser, String string2, int n2, int n3) {
        if (!am.a(xmlPullParser, string2)) {
            return n3;
        }
        return typedArray.getInt(n2, n3);
    }

    public static boolean a(TypedArray typedArray, XmlPullParser xmlPullParser, String string2, int n2, boolean bl2) {
        if (!am.a(xmlPullParser, string2)) {
            return bl2;
        }
        return typedArray.getBoolean(n2, bl2);
    }

    public static boolean a(XmlPullParser xmlPullParser, String string2) {
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", string2) != null) {
            return true;
        }
        return false;
    }

    public static int b(TypedArray typedArray, XmlPullParser xmlPullParser, String string2, int n2, int n3) {
        if (!am.a(xmlPullParser, string2)) {
            return n3;
        }
        return typedArray.getColor(n2, n3);
    }
}

