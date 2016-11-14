package defpackage;

import android.content.res.TypedArray;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: TypedArrayUtils */
class am {
    public static boolean a(XmlPullParser parser, String attrName) {
        return parser.getAttributeValue("http://schemas.android.com/apk/res/android", attrName) != null;
    }

    public static float a(TypedArray a, XmlPullParser parser, String attrName, int resId, float defaultValue) {
        return !am.a(parser, attrName) ? defaultValue : a.getFloat(resId, defaultValue);
    }

    public static boolean a(TypedArray a, XmlPullParser parser, String attrName, int resId, boolean defaultValue) {
        return !am.a(parser, attrName) ? defaultValue : a.getBoolean(resId, defaultValue);
    }

    public static int a(TypedArray a, XmlPullParser parser, String attrName, int resId, int defaultValue) {
        return !am.a(parser, attrName) ? defaultValue : a.getInt(resId, defaultValue);
    }

    public static int b(TypedArray a, XmlPullParser parser, String attrName, int resId, int defaultValue) {
        return !am.a(parser, attrName) ? defaultValue : a.getColor(resId, defaultValue);
    }
}
