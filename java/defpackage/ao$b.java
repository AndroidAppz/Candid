package defpackage;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: VectorDrawableCompat */
class ao$b extends ao$d {
    int a = 0;
    float b = 0.0f;
    int c = 0;
    float d = 1.0f;
    int e;
    float f = 1.0f;
    float g = 0.0f;
    float h = 1.0f;
    float i = 0.0f;
    Cap j = Cap.BUTT;
    Join k = Join.MITER;
    float l = 4.0f;
    private int[] p;

    public ao$b(ao$b copy) {
        super(copy);
        this.p = copy.p;
        this.a = copy.a;
        this.b = copy.b;
        this.d = copy.d;
        this.c = copy.c;
        this.e = copy.e;
        this.f = copy.f;
        this.g = copy.g;
        this.h = copy.h;
        this.i = copy.i;
        this.j = copy.j;
        this.k = copy.k;
        this.l = copy.l;
    }

    private Cap a(int id, Cap defValue) {
        switch (id) {
            case zu.GOOGLE_PLAY_SERVICES_VERSION_CODE /*?: ONE_ARG  (wrap: int
  0x0001: INVOKE  (r0_0 int) =  zu.zzqZ():int type: STATIC)*/:
                return Cap.BUTT;
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                return Cap.ROUND;
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                return Cap.SQUARE;
            default:
                return defValue;
        }
    }

    private Join a(int id, Join defValue) {
        switch (id) {
            case zu.GOOGLE_PLAY_SERVICES_VERSION_CODE /*?: ONE_ARG  (wrap: int
  0x0001: INVOKE  (r0_0 int) =  zu.zzqZ():int type: STATIC)*/:
                return Join.MITER;
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                return Join.ROUND;
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                return Join.BEVEL;
            default:
                return defValue;
        }
    }

    public void a(Resources r, AttributeSet attrs, Theme theme, XmlPullParser parser) {
        TypedArray a = an.b(r, theme, attrs, aj.c);
        a(a, parser);
        a.recycle();
    }

    private void a(TypedArray a, XmlPullParser parser) {
        this.p = null;
        if (am.a(parser, "pathData")) {
            String pathName = a.getString(0);
            if (pathName != null) {
                this.n = pathName;
            }
            String pathData = a.getString(2);
            if (pathData != null) {
                this.m = al.a(pathData);
            }
            this.c = am.b(a, parser, "fillColor", 1, this.c);
            this.f = am.a(a, parser, "fillAlpha", 12, this.f);
            this.j = a(am.a(a, parser, "strokeLineCap", 8, -1), this.j);
            this.k = a(am.a(a, parser, "strokeLineJoin", 9, -1), this.k);
            this.l = am.a(a, parser, "strokeMiterLimit", 10, this.l);
            this.a = am.b(a, parser, "strokeColor", 3, this.a);
            this.d = am.a(a, parser, "strokeAlpha", 11, this.d);
            this.b = am.a(a, parser, "strokeWidth", 4, this.b);
            this.h = am.a(a, parser, "trimPathEnd", 6, this.h);
            this.i = am.a(a, parser, "trimPathOffset", 7, this.i);
            this.g = am.a(a, parser, "trimPathStart", 5, this.g);
        }
    }
}
