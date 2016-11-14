package defpackage;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/* compiled from: TutorialPagerAdapter */
public class ho extends FragmentPagerAdapter {
    private static int a = 4;

    public ho(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    public Fragment getItem(int position) {
        switch (position) {
            case zu.GOOGLE_PLAY_SERVICES_VERSION_CODE /*?: ONE_ARG  (wrap: int
  0x0001: INVOKE  (r0_0 int) =  zu.zzqZ():int type: STATIC)*/:
                return new ia();
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                return new hz();
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                return new hy();
            case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                return new hx();
            default:
                return null;
        }
    }

    public int getCount() {
        return a;
    }
}
