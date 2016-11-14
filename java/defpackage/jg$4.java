package defpackage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.Map;

/* compiled from: DynamicLayoutInflator */
class jg$4 implements jg$c {
    jg$4() {
    }

    public void a(View view, String value, ViewGroup parent, Map<String, String> map) {
        if (view instanceof TextView) {
            int inputType = 0;
            Object obj = -1;
            switch (value.hashCode()) {
                case -1034364087:
                    if (value.equals("number")) {
                        obj = 1;
                        break;
                    }
                    break;
                case 106642798:
                    if (value.equals("phone")) {
                        obj = 2;
                        break;
                    }
                    break;
                case 1727340165:
                    if (value.equals("textEmailAddress")) {
                        obj = null;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case zu.GOOGLE_PLAY_SERVICES_VERSION_CODE /*?: ONE_ARG  (wrap: int
  0x0001: INVOKE  (r0_0 int) =  zu.zzqZ():int type: STATIC)*/:
                    inputType = 0 | 33;
                    break;
                case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                    inputType = 0 | 2;
                    break;
                case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                    inputType = 0 | 3;
                    break;
            }
            if (inputType > 0) {
                ((TextView) view).setInputType(inputType);
            }
        }
    }
}
