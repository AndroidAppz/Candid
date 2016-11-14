package okhttp3;

import defpackage.um$h;
import defpackage.zu;

public enum TlsVersion {
    TLS_1_2("TLSv1.2"),
    TLS_1_1("TLSv1.1"),
    TLS_1_0("TLSv1"),
    SSL_3_0("SSLv3");
    
    final String javaName;

    private TlsVersion(String javaName) {
        this.javaName = javaName;
    }

    public static TlsVersion forJavaName(String javaName) {
        Object obj = -1;
        switch (javaName.hashCode()) {
            case -503070503:
                if (javaName.equals("TLSv1.1")) {
                    obj = 1;
                    break;
                }
                break;
            case -503070502:
                if (javaName.equals("TLSv1.2")) {
                    obj = null;
                    break;
                }
                break;
            case 79201641:
                if (javaName.equals("SSLv3")) {
                    obj = 3;
                    break;
                }
                break;
            case 79923350:
                if (javaName.equals("TLSv1")) {
                    obj = 2;
                    break;
                }
                break;
        }
        switch (obj) {
            case zu.GOOGLE_PLAY_SERVICES_VERSION_CODE /*?: ONE_ARG  (wrap: int
  0x0001: INVOKE  (r0_0 int) =  zu.zzqZ():int type: STATIC)*/:
                return TLS_1_2;
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                return TLS_1_1;
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                return TLS_1_0;
            case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                return SSL_3_0;
            default:
                throw new IllegalArgumentException("Unexpected TLS version: " + javaName);
        }
    }

    public String javaName() {
        return this.javaName;
    }
}
