package com.becandid.candid.fragments.onboarding;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.activities.BaseActivity;
import com.becandid.candid.activities.OnboardingActivity;
import com.becandid.candid.activities.WebViewActivity;
import com.becandid.candid.data.AppState;
import com.becandid.candid.models.NetworkData;
import com.facebook.AccessToken;
import com.facebook.FacebookAuthorizationException;
import com.facebook.FacebookException;
import defpackage.apj;
import defpackage.apn;
import defpackage.ha$a;
import defpackage.ie;
import defpackage.ih$aj;
import defpackage.ih$v;
import defpackage.iq;
import defpackage.rb;
import defpackage.rc;
import defpackage.rm;
import defpackage.ub;
import defpackage.ub$a;
import defpackage.uc;
import defpackage.we;
import defpackage.wf;
import java.util.ArrayList;
import java.util.Arrays;
import rx.schedulers.Schedulers;

public class OnboardingFacebookFragment extends Fragment {
    String a;
    private Unbinder b;
    private ub c;
    @BindView(2131624605)
    RelativeLayout fbButton;
    @BindView(2131624586)
    TextView fbHeader;
    @BindView(2131624608)
    TextView fbInfo;
    @BindView(2131624609)
    TextView fbInfo2;
    @BindView(2131624610)
    TextView fbPrivacy;
    @BindView(2131624587)
    TextView fbSubheader;
    @BindView(2131624585)
    TextView skip;
    @BindView(2131624611)
    FrameLayout spinny;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            this.a = bundle.getString("second_fragment");
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(2130968713, container, false);
        this.b = ButterKnife.bind(this, view);
        c();
        this.skip.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ OnboardingFacebookFragment a;

            {
                this.a = this$0;
            }

            public void onClick(View v) {
                if (this.a.a != null) {
                    this.a.getActivity().setResult(-1);
                    this.a.getActivity().finish();
                    return;
                }
                this.a.a("fb", "phone");
            }
        });
        this.fbButton.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ OnboardingFacebookFragment a;

            {
                this.a = this$0;
            }

            public void onClick(View v) {
                if (AppState.account != null) {
                    rc.c().a((rm) new rm("Connect To Facebook").a("logged_in", "true"));
                } else {
                    rc.c().a((rm) new rm("Connect To Facebook").a("logged_in", "false"));
                }
                this.a.a();
            }
        });
        this.fbPrivacy.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ OnboardingFacebookFragment a;

            {
                this.a = this$0;
            }

            public void onClick(View v) {
                Intent intent = new Intent(this.a.getContext(), WebViewActivity.class);
                intent.putExtra("title", "Why Can I Trust Candid?");
                intent.putExtra("url", GossipApplication.d + "content/whysafe");
                this.a.getContext().startActivity(intent);
            }
        });
        a(view);
        return view;
    }

    private void c() {
        if (AppState.config != null) {
            this.fbHeader.setText(AppState.config.getString("fb_header", getString(2131230839)));
            this.fbSubheader.setText(AppState.config.getString("fb_subheader", getString(2131230842)));
            this.fbPrivacy.setText(AppState.config.getString("more_info", getString(2131230900)));
            this.fbInfo.setText(AppState.config.getString("fb_info", getString(2131230840)));
            this.fbInfo2.setText(AppState.config.getString("fb_info_2", ""));
            return;
        }
        this.fbHeader.setText(getString(2131230839));
        this.fbSubheader.setText(getString(2131230842));
        this.fbPrivacy.setText(getString(2131230900));
        this.fbInfo.setText(getString(2131230840));
        this.fbInfo2.setText("");
    }

    public void a(View view) {
        Animation scale = new ScaleAnimation(0.75f, 1.0f, 0.75f, 1.0f, 1, 0.5f, 1, 0.5f);
        scale.setDuration(500);
        scale.setStartOffset(500);
        Animation rotate_left = new RotateAnimation(0.0f, -10.0f, 1, 0.5f, 1, 1.0f);
        rotate_left.setDuration(200);
        rotate_left.setStartOffset(1000);
        rotate_left.setFillAfter(true);
        rotate_left.setFillEnabled(true);
        Animation rotate_right = new RotateAnimation(0.0f, 10.0f, 1, 0.5f, 1, 1.0f);
        rotate_right.setDuration(200);
        rotate_right.setStartOffset(1200);
        rotate_right.setFillAfter(true);
        rotate_right.setFillEnabled(true);
        AnimationSet spark1 = a(-110, 20, 30, 2131624590, view);
        AnimationSet spark2 = a(-125, -10, 50, 2131624591, view);
        AnimationSet spark3 = a(-115, -40, 30, 2131624592, view);
        Animation spark4 = a(-90, -80, 40, 2131624593, view);
        Animation spark5 = a(-30, -105, 50, 2131624594, view);
        Animation spark6 = a(-15, -80, 10, 2131624595, view);
        Animation spark7 = a(68, -90, 20, 2131624596, view);
        Animation spark8 = a(115, -50, 30, 2131624597, view);
        Animation spark9 = a(100, -25, 10, 2131624598, view);
        AnimationSet spark10 = a(ha$a.AppCompatTheme_spinnerStyle, 8, 20, 2131624599, view);
        AnimationSet spark11 = a(100, 30, 40, 2131624600, view);
        view.findViewById(2131624589).startAnimation(scale);
        view.findViewById(2131624602).startAnimation(rotate_left);
        view.findViewById(2131624601).startAnimation(rotate_right);
        view.findViewById(2131624590).startAnimation(spark1);
        view.findViewById(2131624591).startAnimation(spark2);
        view.findViewById(2131624592).startAnimation(spark3);
        view.findViewById(2131624593).startAnimation(spark4);
        view.findViewById(2131624594).startAnimation(spark5);
        view.findViewById(2131624595).startAnimation(spark6);
        view.findViewById(2131624596).startAnimation(spark7);
        view.findViewById(2131624597).startAnimation(spark8);
        view.findViewById(2131624598).startAnimation(spark9);
        view.findViewById(2131624599).startAnimation(spark10);
        view.findViewById(2131624600).startAnimation(spark11);
    }

    public AnimationSet a(int midX, int midY, int offset, int identifier, View view) {
        AnimationSet set = new AnimationSet(false);
        float density = getResources().getDisplayMetrics().density;
        Animation spark = new TranslateAnimation(0, 0.0f, 0, ((float) midX) * density, 0, 0.0f, 0, ((float) midY) * density);
        spark.setInterpolator(new AccelerateDecelerateInterpolator());
        spark.setDuration(200);
        spark.setStartOffset((long) (offset + 1400));
        spark.setFillAfter(true);
        spark.setFillEnabled(true);
        set.addAnimation(spark);
        Animation fall = new TranslateAnimation(0, 0.0f, 0, 0.0f, 0, 0.0f, 2, 1.0f);
        fall.setInterpolator(new AccelerateDecelerateInterpolator());
        fall.setDuration(400);
        fall.setStartOffset((long) (offset + 2200));
        fall.setFillAfter(true);
        fall.setFillEnabled(true);
        final View view2 = view;
        final int i = identifier;
        final int i2 = offset;
        fall.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ OnboardingFacebookFragment d;

            public void onAnimationStart(Animation animation) {
                new Handler().postDelayed(new Runnable(this) {
                    final /* synthetic */ AnonymousClass4 a;

                    {
                        this.a = this$1;
                    }

                    public void run() {
                        view2.findViewById(i).bringToFront();
                        view2.findViewById(2131624604).bringToFront();
                    }
                }, (long) (i2 + 2200));
            }

            public void onAnimationEnd(Animation animation) {
                view2.findViewById(i).setVisibility(8);
            }

            public void onAnimationRepeat(Animation animation) {
            }
        });
        set.addAnimation(fall);
        return set;
    }

    public void a() {
        if (this.c == null) {
            this.c = ub$a.a();
            we.c().a(this.c, new uc<wf>(this) {
                final /* synthetic */ OnboardingFacebookFragment a;

                {
                    this.a = this$0;
                }

                public /* synthetic */ void onSuccess(Object obj) {
                    a((wf) obj);
                }

                public void a(wf loginResult) {
                    if (AppState.account != null) {
                        rc.c().a((rm) new rm("Connect To Facebook Successful").a("logged_in", "true"));
                    } else {
                        rc.c().a((rm) new rm("Connect To Facebook Successful").a("logged_in", "false"));
                    }
                    Log.d("FBConnect", "success");
                    this.a.spinny.setVisibility(8);
                    AppState.setFBInfo(loginResult.a());
                    if (this.a.a != null) {
                        this.a.spinny.setVisibility(0);
                        ((BaseActivity) this.a.getActivity()).addToSubscriptionList(iq.a().a(ih$v.class, new apj<ih$v>(this) {
                            final /* synthetic */ AnonymousClass5 a;

                            {
                                this.a = this$1;
                            }

                            public /* synthetic */ void onNext(Object obj) {
                                a((ih$v) obj);
                            }

                            public void onCompleted() {
                            }

                            public void onError(Throwable e) {
                                rb.a(e);
                            }

                            public void a(ih$v fbInfoReceived) {
                                this.a.a.spinny.setVisibility(8);
                                ((BaseActivity) this.a.a.getActivity()).sendFbDataToServer();
                                this.a.a.getActivity().setResult(-1);
                                ((OnboardingActivity) this.a.a.getActivity()).finish();
                            }
                        }));
                        return;
                    }
                    this.a.b();
                }

                public void onCancel() {
                    if (AppState.account != null) {
                        rc.c().a((rm) new rm("Connect To Facebook Cancelled").a("logged_in", "true"));
                    } else {
                        rc.c().a((rm) new rm("Connect To Facebook Cancelled").a("logged_in", "false"));
                    }
                    Log.d("FBConnect", "cancel");
                    this.a.spinny.setVisibility(8);
                    this.a.fbButton.setEnabled(true);
                }

                public void onError(FacebookException error) {
                    if (AppState.account != null) {
                        rc.c().a((rm) new rm("Connect To Facebook Error").a("logged_in", "true"));
                    } else {
                        rc.c().a((rm) new rm("Connect To Facebook Error").a("logged_in", "false"));
                    }
                    rb.a(error);
                    if (!(error instanceof FacebookAuthorizationException) || AccessToken.a() == null) {
                        Toast.makeText(GossipApplication.a(), "Unable to connect to Facebook", 1).show();
                        this.a.spinny.setVisibility(8);
                        this.a.fbButton.setEnabled(true);
                        return;
                    }
                    we.c().d();
                    we.c().a(this.a.getActivity(), Arrays.asList("public_profile,user_friends,user_work_history,user_education_history".split(",")));
                }
            });
        }
        we.c().a((Fragment) this, Arrays.asList("public_profile,user_friends,user_work_history,user_education_history".split(",")));
    }

    public void b() {
        if (AppState.config.getInt("disable_mobile_fb_phone_login", 0) == 0) {
            ie.a().d().b(Schedulers.io()).a(apn.a()).b(new apj<NetworkData>(this) {
                final /* synthetic */ OnboardingFacebookFragment a;

                {
                    this.a = this$0;
                }

                public /* synthetic */ void onNext(Object obj) {
                    a((NetworkData) obj);
                }

                public void onCompleted() {
                }

                public void onError(Throwable e) {
                    rb.a(e);
                    Log.d("FacebookLogin", e.toString());
                    iq.a().a(new ih$aj("fb", "phone"));
                }

                public void a(NetworkData networkData) {
                    if (networkData.success) {
                        if (networkData.my_info != null) {
                            AppState.account = networkData.my_info;
                            ((OnboardingActivity) this.a.getActivity()).finishSyncAccount();
                        }
                        if (networkData.config != null) {
                            AppState.setConfig(networkData.config);
                        }
                        if (networkData.activity_settings != null) {
                            AppState.notificationSettings = new ArrayList(networkData.activity_settings);
                            return;
                        }
                        return;
                    }
                    iq.a().a(new ih$aj("fb", "phone"));
                }
            });
        } else {
            a("fb", "phone");
        }
    }

    public void a(String fromTag, String toTag) {
        Activity activity = getActivity();
        if (activity instanceof OnboardingActivity) {
            ((OnboardingActivity) activity).switchFragment(fromTag, toTag);
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (this.c != null) {
            this.c.a(requestCode, resultCode, data);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
