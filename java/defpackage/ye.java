package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import com.google.android.gms.R;
import okhttp3.internal.http.HttpEngine;

public final class ye {
    public static String a(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                return resources.getString(R.string.common_google_play_services_install_title);
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
            case ha$a.AppCompatTheme_dialogTheme /*42*/:
                return resources.getString(R.string.common_google_play_services_update_title);
            case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                return resources.getString(R.string.common_google_play_services_enable_title);
            case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
            case um$h.CardView_cardUseCompatPadding /*6*/:
                return null;
            case um$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
                return resources.getString(R.string.common_google_play_services_invalid_account_title);
            case um$h.CardView_cardPreventCornerOverlap /*7*/:
                Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
                return resources.getString(R.string.common_google_play_services_network_error_title);
            case um$h.CardView_contentPadding /*8*/:
                Log.e("GoogleApiAvailability", "Internal error occurred. Please see logs for detailed information");
                return null;
            case um$h.CardView_contentPaddingLeft /*9*/:
                Log.e("GoogleApiAvailability", "Google Play services is invalid. Cannot recover.");
                return resources.getString(R.string.common_google_play_services_unsupported_title);
            case um$h.CardView_contentPaddingRight /*10*/:
                Log.e("GoogleApiAvailability", "Developer error occurred. Please see logs for detailed information");
                return null;
            case um$h.CardView_contentPaddingTop /*11*/:
                Log.e("GoogleApiAvailability", "The application is not licensed to the user.");
                return null;
            case ha$a.Toolbar_titleMarginBottom /*16*/:
                Log.e("GoogleApiAvailability", "One of the API components you attempted to connect to is not available.");
                return null;
            case ha$a.Toolbar_maxButtonHeight /*17*/:
                Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
                return resources.getString(R.string.common_google_play_services_sign_in_failed_title);
            case ha$a.Toolbar_collapseIcon /*18*/:
                return resources.getString(R.string.common_google_play_services_updating_title);
            case HttpEngine.MAX_FOLLOW_UPS /*20*/:
                Log.e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
                return resources.getString(R.string.common_google_play_services_restricted_profile_title);
            default:
                Log.e("GoogleApiAvailability", "Unexpected error code " + i);
                return null;
        }
    }

    public static String a(Context context, int i, String str) {
        Resources resources = context.getResources();
        switch (i) {
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                if (zi.a(resources)) {
                    return resources.getString(R.string.common_google_play_services_install_text_tablet, new Object[]{str});
                }
                return resources.getString(R.string.common_google_play_services_install_text_phone, new Object[]{str});
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                return resources.getString(R.string.common_google_play_services_update_text, new Object[]{str});
            case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                return resources.getString(R.string.common_google_play_services_enable_text, new Object[]{str});
            case um$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                return resources.getString(R.string.common_google_play_services_invalid_account_text);
            case um$h.CardView_cardPreventCornerOverlap /*7*/:
                return resources.getString(R.string.common_google_play_services_network_error_text);
            case um$h.CardView_contentPaddingLeft /*9*/:
                return resources.getString(R.string.common_google_play_services_unsupported_text, new Object[]{str});
            case ha$a.Toolbar_titleMarginBottom /*16*/:
                return resources.getString(R.string.common_google_play_services_api_unavailable_text, new Object[]{str});
            case ha$a.Toolbar_maxButtonHeight /*17*/:
                return resources.getString(R.string.common_google_play_services_sign_in_failed_text);
            case ha$a.Toolbar_collapseIcon /*18*/:
                return resources.getString(R.string.common_google_play_services_updating_text, new Object[]{str});
            case HttpEngine.MAX_FOLLOW_UPS /*20*/:
                return resources.getString(R.string.common_google_play_services_restricted_profile_text);
            case ha$a.AppCompatTheme_dialogTheme /*42*/:
                return resources.getString(R.string.common_google_play_services_wear_update_text);
            default:
                return resources.getString(R.string.common_google_play_services_unknown_issue, new Object[]{str});
        }
    }

    public static String b(Context context, int i) {
        return i == 6 ? context.getResources().getString(R.string.common_google_play_services_resolution_required_title) : ye.a(context, i);
    }

    public static String b(Context context, int i, String str) {
        return i == 6 ? context.getResources().getString(R.string.common_google_play_services_resolution_required_text) : ye.a(context, i, str);
    }

    public static String c(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                return resources.getString(R.string.common_google_play_services_install_button);
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                return resources.getString(R.string.common_google_play_services_update_button);
            case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                return resources.getString(R.string.common_google_play_services_enable_button);
            default:
                return resources.getString(17039370);
        }
    }
}
