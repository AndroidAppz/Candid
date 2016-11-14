package com.becandid.candid.fragments.onboarding;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.becandid.candid.activities.BaseActivity;
import com.becandid.candid.activities.OnboardingActivity;
import com.becandid.candid.data.AppState;
import com.becandid.candid.models.NetworkData;
import defpackage.aif;
import defpackage.apj;
import defpackage.apn;
import defpackage.ie;
import defpackage.rb;
import defpackage.rc;
import defpackage.rm;
import java.util.HashMap;
import java.util.Map;
import rx.schedulers.Schedulers;

public class OnboardingVerifyFragment extends Fragment {
    String a;
    private Unbinder b;
    @BindView(2131624669)
    TextView resend;
    @BindView(2131624670)
    FrameLayout spinny;
    @BindView(2131624668)
    Button submit;
    @BindView(2131624667)
    EditText verify;
    @BindView(2131624664)
    TextView verifyHeader;
    @BindView(2131624665)
    TextView verifySubheader;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            this.a = bundle.getString("second_fragment");
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(2130968717, container, false);
        this.b = ButterKnife.bind(this, view);
        ((BaseActivity) getActivity()).enableKeyboardEvents(view);
        c();
        Bundle args = getArguments();
        a(this.resend, true, 5000);
        this.resend.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ OnboardingVerifyFragment a;

            {
                this.a = this$0;
            }

            public void onClick(View v) {
                if (this.a.a != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("second_fragment", this.a.a);
                    ((OnboardingActivity) this.a.getActivity()).switchFragment("verify", "phone", bundle);
                    return;
                }
                this.a.a("verify", "phone");
            }
        });
        this.verify.requestFocus();
        ((BaseActivity) getActivity()).openKeyboard();
        this.verify.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ OnboardingVerifyFragment a;

            {
                this.a = this$0;
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() >= 4) {
                    this.a.submit.setEnabled(true);
                } else {
                    this.a.submit.setEnabled(false);
                }
            }

            public void afterTextChanged(Editable s) {
            }
        });
        this.submit.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ OnboardingVerifyFragment a;

            {
                this.a = this$0;
            }

            public void onClick(View v) {
                if (AppState.account != null) {
                    this.a.b();
                } else {
                    this.a.a();
                }
            }
        });
        return view;
    }

    private void c() {
        this.verifyHeader.setText(AppState.config.getString("code_header", getString(2131230937)));
        this.verifySubheader.setText(AppState.config.getString("code_subheader", getString(2131230940)));
        this.verify.setHint(AppState.config.getString("code_input", getString(2131230938)));
        this.resend.setText(AppState.config.getString("resend_code_button", getString(2131230939)));
    }

    public void a(final View viewToAnimate, final boolean fadeIn, int offset) {
        Animation fade = fadeIn ? new AlphaAnimation(0.0f, 1.0f) : new AlphaAnimation(1.0f, 0.0f);
        fade.setDuration(500);
        fade.setFillAfter(true);
        fade.setFillEnabled(true);
        if (offset != -1) {
            fade.setStartOffset((long) offset);
        }
        fade.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ OnboardingVerifyFragment c;

            public void onAnimationStart(Animation animation) {
                if (fadeIn) {
                    viewToAnimate.setClickable(true);
                    viewToAnimate.setVisibility(0);
                }
            }

            public void onAnimationEnd(Animation animation) {
                if (!fadeIn) {
                    viewToAnimate.setClickable(false);
                    viewToAnimate.setVisibility(8);
                }
            }

            public void onAnimationRepeat(Animation animation) {
            }
        });
        viewToAnimate.startAnimation(fade);
    }

    public void a() {
        this.submit.setClickable(false);
        this.spinny.setVisibility(0);
        ie.a().a(this.verify.getText().toString(), AppState.contactsInfo.phone_number).b(Schedulers.io()).a(apn.a()).b(new apj<NetworkData>(this) {
            final /* synthetic */ OnboardingVerifyFragment a;

            {
                this.a = this$0;
            }

            public /* synthetic */ void onNext(Object obj) {
                a((NetworkData) obj);
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
                Toast.makeText(this.a.getActivity(), "Unable to verify your code, please try again", 1).show();
                rb.a(e);
                Log.d("VerifyPhone", e.toString());
                this.a.spinny.setVisibility(8);
                this.a.submit.setClickable(true);
            }

            public void a(NetworkData networkData) {
                this.a.spinny.setVisibility(8);
                if (networkData != null && networkData.success) {
                    if (AppState.account != null) {
                        AppState.account.have_phone_number = true;
                    }
                    ((BaseActivity) this.a.getActivity()).closeKeyboard();
                    AppState.contactsInfo.otpCode = this.a.verify.getText().toString();
                    if (this.a.a != null) {
                        Bundle bundle = new Bundle();
                        bundle.putString("second_fragment", this.a.a);
                        ((OnboardingActivity) this.a.getActivity()).switchFragment("verify", "contacts", bundle);
                        return;
                    }
                    this.a.a("verify", "contacts");
                } else if (networkData != null && !networkData.success) {
                    Toast.makeText(this.a.getActivity(), "That does not match the expected code", 1).show();
                    this.a.submit.setClickable(true);
                    this.a.spinny.setVisibility(8);
                }
            }
        });
    }

    public void b() {
        Map hashParams = new HashMap();
        hashParams.put("otp_code", this.verify.getText().toString());
        hashParams.put("phone_number", AppState.contactsInfo.phone_number);
        this.submit.setClickable(false);
        this.spinny.setVisibility(0);
        ie.a().b(hashParams).b(Schedulers.io()).a(apn.a()).b(new apj<aif>(this) {
            final /* synthetic */ OnboardingVerifyFragment a;

            {
                this.a = this$0;
            }

            public /* synthetic */ void onNext(Object obj) {
                a((aif) obj);
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
                if (AppState.account != null) {
                    rc.c().a((rm) ((rm) new rm("Verify Phone Number").a("success", "false")).a("logged_in", "true"));
                } else {
                    rc.c().a((rm) ((rm) new rm("Verify Phone Number").a("success", "false")).a("logged_in", "false"));
                }
                rb.a(e);
                this.a.submit.setClickable(true);
                this.a.spinny.setVisibility(8);
            }

            public void a(aif result) {
                if (result != null && result.b("success") != null && result.b("success").h()) {
                    AppState.account.have_phone_number = true;
                    if (this.a.a != null) {
                        Bundle bundle = new Bundle();
                        bundle.putString("second_fragment", this.a.a);
                        ((OnboardingActivity) this.a.getActivity()).switchFragment("verify", "contacts", bundle);
                    } else {
                        this.a.a("verify", "contacts");
                    }
                    if (AppState.account != null) {
                        rc.c().a((rm) ((rm) new rm("Verify Phone Number").a("success", "true")).a("logged_in", "true"));
                    } else {
                        rc.c().a((rm) ((rm) new rm("Verify Phone Number").a("success", "true")).a("logged_in", "false"));
                    }
                } else if (result != null && result.b("success") != null && !result.b("success").h()) {
                    Toast.makeText(this.a.getActivity(), "That does not match the expected code", 1).show();
                    this.a.submit.setClickable(true);
                    this.a.spinny.setVisibility(8);
                }
            }
        });
    }

    public void a(String fromTag, String toTag) {
        Activity activity = getActivity();
        if (activity instanceof OnboardingActivity) {
            ((OnboardingActivity) activity).switchFragment(fromTag, toTag);
        }
    }
}
