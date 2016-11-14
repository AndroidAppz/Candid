package com.becandid.candid.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.becandid.candid.data.AppState;
import com.becandid.candid.views.BadgeInfoView;
import com.becandid.candid.views.MessagingPopupView;
import com.becandid.candid.views.ModeratorInfoView;
import com.becandid.candid.views.QualityScoreInfoView;
import com.becandid.thirdparty.BlurTask.BadgeType;
import defpackage.apj;
import defpackage.ih$b;
import defpackage.ih$f;
import defpackage.iq;
import defpackage.rb;
import defpackage.um$h;

public abstract class PopupWithBlurBackgroundActivity extends BaseActivity {
    private boolean b = true;
    private int c = 500;
    protected boolean mIsShowingMessagingPopup;

    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] a = new int[BadgeType.values().length];

        static {
            try {
                a[BadgeType.BADGE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[BadgeType.MOD.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[BadgeType.POST_QUALITY_SCORE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[BadgeType.ME_QUALITY_SCORE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[BadgeType.MESSAGE_ENABLED_NEW.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                a[BadgeType.MESSAGE_ENABLED_TAB.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    public abstract void hideCurrentScreen();

    public abstract void showCurrentScreen();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Activity activity = this;
        addToSubscriptionList(iq.a().a(ih$b.class, new apj<ih$b>(this) {
            final /* synthetic */ PopupWithBlurBackgroundActivity b;

            public void onCompleted() {
            }

            public void onError(Throwable e) {
                rb.a(e);
            }

            public void onNext(ih$b blurTaskFinished) {
                String blurPath = blurTaskFinished.a;
                View layoutView = null;
                switch (AnonymousClass3.a[blurTaskFinished.b.ordinal()]) {
                    case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                        layoutView = new BadgeInfoView(activity, AppState.account.badge_status, true, blurPath);
                        break;
                    case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                        layoutView = new ModeratorInfoView(activity, blurPath, blurTaskFinished.d, blurTaskFinished.e);
                        break;
                    case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                        layoutView = new QualityScoreInfoView(activity, blurPath, blurTaskFinished.c, blurTaskFinished.d, blurTaskFinished.e);
                        break;
                    case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                        layoutView = new QualityScoreInfoView(activity, blurPath, blurTaskFinished.c);
                        break;
                    case um$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                        layoutView = new MessagingPopupView(activity, blurPath, true);
                        this.b.b = false;
                        break;
                    case um$h.CardView_cardUseCompatPadding /*6*/:
                        layoutView = new MessagingPopupView(activity, blurPath, false);
                        this.b.b = false;
                        break;
                }
                FrameLayout badgeInfoContainer = (FrameLayout) this.b.findViewById(2131624172);
                badgeInfoContainer.setVisibility(0);
                badgeInfoContainer.addView(layoutView);
                Animation slideUpAnimation = AnimationUtils.loadAnimation(this.b.getApplicationContext(), 2131034137);
                slideUpAnimation.setDuration((long) this.b.c);
                badgeInfoContainer.findViewById(2131624074).startAnimation(slideUpAnimation);
                badgeInfoContainer.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass1 a;

                    {
                        this.a = this$1;
                    }

                    public void onClick(View v) {
                        if (this.a.b.b) {
                            v.setOnClickListener(null);
                            this.a.b.slideOutAnimation(v);
                        }
                    }
                });
                this.b.hideCurrentScreen();
            }
        }));
    }

    public void slideOutAnimation(final View v) {
        Animation slideDownAnimation = AnimationUtils.loadAnimation(this, 2131034132);
        slideDownAnimation.setDuration((long) this.c);
        View badgeInfo = ((FrameLayout) findViewById(2131624172)).findViewById(2131624074);
        if (badgeInfo != null) {
            badgeInfo.startAnimation(slideDownAnimation);
        }
        v.postDelayed(new Runnable(this) {
            final /* synthetic */ PopupWithBlurBackgroundActivity b;

            public void run() {
                ((FrameLayout) this.b.findViewById(2131624172)).removeAllViews();
                v.setVisibility(8);
                this.b.showCurrentScreen();
                AppState.blurTaskCalledOnFlight = false;
            }
        }, (long) this.c);
        this.mIsShowingMessagingPopup = false;
        if (!this.b) {
            iq.a().a(new ih$f());
        }
    }

    protected void onResume() {
        super.onResume();
        View v = findViewById(2131624172);
        if (v != null) {
            v.setVisibility(8);
        }
        showCurrentScreen();
        if (!this.b) {
            iq.a().a(new ih$f());
        }
    }

    protected void onPause() {
        super.onPause();
        if (!this.b) {
            iq.a().a(new ih$f());
        }
    }
}
