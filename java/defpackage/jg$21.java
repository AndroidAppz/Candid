package defpackage;

import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.Map;

/* compiled from: DynamicLayoutInflator */
class jg$21 implements jg$c {
    jg$21() {
    }

    public void a(View view, String value, ViewGroup parent, Map<String, String> map) {
        if (view instanceof TextView) {
            TruncateAt where = TruncateAt.END;
            Object obj = -1;
            switch (value.hashCode()) {
                case -1074341483:
                    if (value.equals("middle")) {
                        obj = 1;
                        break;
                    }
                    break;
                case 100571:
                    if (value.equals("end")) {
                        obj = 3;
                        break;
                    }
                    break;
                case 109757538:
                    if (value.equals("start")) {
                        obj = null;
                        break;
                    }
                    break;
                case 839444514:
                    if (value.equals("marquee")) {
                        obj = 2;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case zu.GOOGLE_PLAY_SERVICES_VERSION_CODE /*?: ONE_ARG  (wrap: int
  0x0001: INVOKE  (r0_0 int) =  zu.zzqZ():int type: STATIC)*/:
                    where = TruncateAt.START;
                    break;
                case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                    where = TruncateAt.MIDDLE;
                    break;
                case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                    where = TruncateAt.MARQUEE;
                    break;
            }
            ((TextView) view).setEllipsize(where);
        }
    }
}
