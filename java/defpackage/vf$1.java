package defpackage;

import com.facebook.FacebookRequestError.Category;

/* compiled from: FacebookRequestErrorClassification */
/* synthetic */ class vf$1 {
    static final /* synthetic */ int[] a = new int[Category.values().length];

    static {
        try {
            a[Category.OTHER.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            a[Category.LOGIN_RECOVERABLE.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            a[Category.TRANSIENT.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
    }
}
