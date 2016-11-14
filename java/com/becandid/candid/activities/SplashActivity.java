package com.becandid.candid.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.DataUtil;
import com.becandid.candid.models.NetworkData;
import defpackage.aif;
import defpackage.apj;
import defpackage.apn;
import defpackage.ie;
import defpackage.rb;
import defpackage.rc;
import defpackage.sc;
import java.util.List;
import java.util.Map;
import rx.exceptions.CompositeException;
import rx.schedulers.Schedulers;

public class SplashActivity extends BaseActivity {
    public static final int CHANGE_ENDPOINT_CODE = 1001;
    private View b;
    private View c;
    private boolean d = false;
    private boolean e = false;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (AppState.loggedin()) {
            ie.a().b().b(Schedulers.io()).a(apn.a()).b(new apj<NetworkData>(this) {
                final /* synthetic */ SplashActivity a;

                {
                    this.a = this$0;
                }

                public void onCompleted() {
                    if (AppState.needOnboarding == 1) {
                        Intent intent = new Intent(this.a, OnboardingActivity.class);
                        intent.putExtra("need_onboarding", 1);
                        this.a.startActivity(intent);
                        this.a.finish();
                        return;
                    }
                    this.a.startActivity(new Intent(this.a, MainTabsActivity.class));
                    this.a.finish();
                }

                public void onError(Throwable e) {
                    this.a.startActivity(new Intent(this.a, MainTabsActivity.class));
                    this.a.finish();
                }

                public void onNext(NetworkData data) {
                }
            });
            return;
        }
        renderSplashPage();
        TextView termsAndGuidelines = (TextView) findViewById(2131624273);
        Spanned spanned1 = Html.fromHtml("By selecting \"Get Started Anonymously\" you agree to the ");
        Spanned spanned2 = Html.fromHtml("<a href=\"" + GossipApplication.d + "content/terms\">Terms of Service</a>");
        Spanned spanned3 = Html.fromHtml("<a href=\"" + GossipApplication.d + "content/community\">Community Guidelines</a>");
        termsAndGuidelines.setText(TextUtils.concat(new CharSequence[]{spanned1, spanned2, " and ", spanned3}));
        termsAndGuidelines.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public void renderSplashPage() {
        setContentView(2130968625);
        this.b = findViewById(2131624275);
        this.c = findViewById(2131624274);
        a(findViewById(2131624272));
    }

    public void startOnboarding(View v) {
        if (!this.d) {
            a(v);
        }
        this.e = true;
        this.b.setVisibility(0);
        v.setEnabled(false);
    }

    private void a(final View v) {
        this.d = true;
        ie.a().c().b(Schedulers.io()).a(apn.a()).b(new apj<aif>(this) {
            final /* synthetic */ SplashActivity b;

            public void onCompleted() {
                this.b.d = false;
            }

            public void onError(Throwable e) {
                Log.d("Splash", e.toString());
                if (e instanceof CompositeException) {
                    for (Throwable throwable : ((CompositeException) e).a()) {
                        Log.d("Splash", throwable.toString());
                    }
                }
                this.b.b.setVisibility(8);
                v.setEnabled(true);
                rc.c().a(new sc().a("splash_page").a(false));
                this.b.d = false;
            }

            public void onNext(aif result) {
                this.b.b.setVisibility(8);
                v.setEnabled(true);
                Map<String, Object> config = DataUtil.toMap(result.d("config"));
                Map<String, Object> onboarding = DataUtil.toMap(result.d("onboarding_data"));
                try {
                    AppState.internal = result.b("debug").h();
                    if (AppState.internal) {
                        this.b.c.setVisibility(0);
                    }
                    AppState.referralId = result.b("referral_id").c();
                } catch (Exception e) {
                    rb.a(e);
                }
                try {
                    List<String> teenTags = DataUtil.toList(result.c("under_18_tags"), String.class);
                    List<String> adultTags = DataUtil.toList(result.c("18_plus_tags"), String.class);
                    AppState.setOnboardingTeenTags(teenTags);
                    AppState.setOnboardingAdultTags(adultTags);
                } catch (Exception e2) {
                    rb.a(e2);
                }
                AppState.setConfig(config);
                AppState.setOnboardingTags(onboarding);
                if (this.b.e) {
                    this.b.startActivity(new Intent(v.getContext(), OnboardingActivity.class));
                    rc.c().a(new sc().a("splash_page").a(true));
                    this.b.finish();
                }
            }
        });
    }

    public void changeEndpoint(View v) {
        startActivity(new Intent(this, ChangeEndpointActivity.class));
    }
}
