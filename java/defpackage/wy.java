package defpackage;

public class wy {
    public static String a(int i) {
        switch (i) {
            case ev.POSITION_UNCHANGED /*-1*/:
                return "SUCCESS_CACHE";
            case zu.GOOGLE_PLAY_SERVICES_VERSION_CODE /*?: ONE_ARG  (wrap: int
  0x0001: INVOKE  (r0_0 int) =  zu.zzqZ():int type: STATIC)*/:
                return "SUCCESS";
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                return "SERVICE_MISSING";
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                return "SERVICE_DISABLED";
            case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                return "SIGN_IN_REQUIRED";
            case um$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                return "INVALID_ACCOUNT";
            case um$h.CardView_cardUseCompatPadding /*6*/:
                return "RESOLUTION_REQUIRED";
            case um$h.CardView_cardPreventCornerOverlap /*7*/:
                return "NETWORK_ERROR";
            case um$h.CardView_contentPadding /*8*/:
                return "INTERNAL_ERROR";
            case um$h.CardView_contentPaddingLeft /*9*/:
                return "SERVICE_INVALID";
            case um$h.CardView_contentPaddingRight /*10*/:
                return "DEVELOPER_ERROR";
            case um$h.CardView_contentPaddingTop /*11*/:
                return "LICENSE_CHECK_FAILED";
            case ha$a.Toolbar_titleMarginStart /*13*/:
                return "ERROR";
            case ha$a.Toolbar_titleMarginEnd /*14*/:
                return "INTERRUPTED";
            case ha$a.Toolbar_titleMarginTop /*15*/:
                return "TIMEOUT";
            case ha$a.Toolbar_titleMarginBottom /*16*/:
                return "CANCELED";
            case ha$a.Toolbar_maxButtonHeight /*17*/:
                return "API_NOT_CONNECTED";
            case 3000:
                return "AUTH_API_INVALID_CREDENTIALS";
            case 3001:
                return "AUTH_API_ACCESS_FORBIDDEN";
            case 3002:
                return "AUTH_API_CLIENT_ERROR";
            case 3003:
                return "AUTH_API_SERVER_ERROR";
            case 3004:
                return "AUTH_TOKEN_ERROR";
            case 3005:
                return "AUTH_URL_RESOLUTION";
            default:
                return "unknown status code: " + i;
        }
    }
}
