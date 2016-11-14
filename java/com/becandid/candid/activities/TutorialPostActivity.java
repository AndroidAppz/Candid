package com.becandid.candid.activities;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.e;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import defpackage.ev;
import defpackage.ho;
import defpackage.um$h;
import defpackage.zu;

public class TutorialPostActivity extends FragmentActivity {
    private ev a;
    @BindView(2131624287)
    ImageView ind1;
    @BindView(2131624288)
    ImageView ind2;
    @BindView(2131624289)
    ImageView ind3;
    @BindView(2131624290)
    ImageView ind4;
    @BindView(2131624286)
    ViewPager viewPager;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(2130968628);
        ButterKnife.bind(this);
        this.a = new ho(getSupportFragmentManager());
        this.viewPager.setAdapter(this.a);
        this.viewPager.a(new e(this) {
            final /* synthetic */ TutorialPostActivity a;

            {
                this.a = this$0;
            }

            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            public void onPageSelected(int position) {
                Drawable active = this.a.getResources().getDrawable(2130838080);
                Drawable inactive = this.a.getResources().getDrawable(2130838076);
                this.a.ind1.setImageDrawable(inactive);
                this.a.ind2.setImageDrawable(inactive);
                this.a.ind3.setImageDrawable(inactive);
                this.a.ind4.setImageDrawable(inactive);
                switch (position) {
                    case zu.GOOGLE_PLAY_SERVICES_VERSION_CODE /*?: ONE_ARG  (wrap: int
  0x0001: INVOKE  (r0_0 int) =  zu.zzqZ():int type: STATIC)*/:
                        this.a.ind1.setImageDrawable(active);
                        return;
                    case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                        this.a.ind2.setImageDrawable(active);
                        return;
                    case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                        this.a.ind3.setImageDrawable(active);
                        return;
                    case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                        this.a.ind4.setImageDrawable(active);
                        return;
                    default:
                        return;
                }
            }

            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    public void onBackPressed() {
    }
}
