package defpackage;

import java.util.Locale;

/* compiled from: TextUtilsCompat */
class df$a {
    private df$a() {
    }

    public int a(Locale locale) {
        if (!(locale == null || locale.equals(df.a))) {
            String scriptSubtag = da.a(locale);
            if (scriptSubtag == null) {
                return df$a.b(locale);
            }
            if (scriptSubtag.equalsIgnoreCase(df.c) || scriptSubtag.equalsIgnoreCase(df.d)) {
                return 1;
            }
        }
        return 0;
    }

    private static int b(Locale locale) {
        switch (Character.getDirectionality(locale.getDisplayName(locale).charAt(0))) {
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                return 1;
            default:
                return 0;
        }
    }
}
