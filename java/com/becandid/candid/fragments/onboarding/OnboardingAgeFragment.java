package com.becandid.candid.fragments.onboarding;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.activities.OnboardingActivity;
import com.becandid.candid.activities.VerifyAgeActivity;
import com.becandid.candid.activities.WebViewActivity;
import com.becandid.candid.data.AppState;
import com.becandid.candid.models.EmptySubscriber;
import defpackage.apn;
import defpackage.ie;
import java.util.HashMap;
import java.util.Map;
import rx.schedulers.Schedulers;

public class OnboardingAgeFragment extends Fragment {
    private Unbinder a;
    @BindView(2131624569)
    TextView ageHeader;
    @BindView(2131624576)
    Button ageOver;
    @BindView(2131624570)
    TextView ageSubheader;
    @BindView(2131624574)
    Button ageUnder;
    private boolean b;
    @BindView(2131624577)
    TextView privacy;
    @BindView(2131624568)
    TextView skip;
    @BindView(2131624578)
    FrameLayout spinny;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            this.b = bundle.getBoolean("existing_user", false);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(2130968711, container, false);
        this.a = ButterKnife.bind(this, view);
        a();
        if (AppState.config.getInt("show_age_skip_android", 0) == 1) {
            this.skip.setVisibility(0);
            this.skip.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ OnboardingAgeFragment a;

                {
                    this.a = this$0;
                }

                public void onClick(View v) {
                    this.a.a("age", "tags");
                }
            });
        } else {
            this.skip.setVisibility(8);
        }
        if (this.b) {
            this.privacy.setVisibility(8);
            this.skip.setVisibility(8);
        } else {
            this.privacy.setVisibility(0);
            this.privacy.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ OnboardingAgeFragment a;

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
        }
        this.ageOver.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ OnboardingAgeFragment a;

            {
                this.a = this$0;
            }

            public void onClick(View v) {
                AppState.age = "18_plus";
                if (this.a.b) {
                    this.a.b();
                    ((VerifyAgeActivity) this.a.getActivity()).onActivityResult();
                } else {
                    this.a.a("age", "tags");
                }
                AppState.saveState(GossipApplication.a());
            }
        });
        this.ageUnder.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ OnboardingAgeFragment a;

            {
                this.a = this$0;
            }

            public void onClick(View v) {
                AppState.age = "under_18";
                if (this.a.b) {
                    this.a.b();
                    ((VerifyAgeActivity) this.a.getActivity()).onActivityResult();
                } else {
                    this.a.a("age", "tags");
                }
                AppState.saveState(GossipApplication.a());
            }
        });
        return view;
    }

    private void b() {
        Map params = new HashMap();
        params.put("age", AppState.age);
        ie.a().a(params).b(Schedulers.newThread()).a(apn.a()).b(new EmptySubscriber());
    }

    public void a() {
        this.ageHeader.setText(AppState.config.getString("age_prompt_title", "Approximately, How Old Are You?"));
        this.ageSubheader.setText(AppState.config.getString("age_prompt_desc", "This information will help us recommend the right groups for you"));
        this.privacy.setText(AppState.config.getString("more_info", getString(2131230900)));
        this.ageOver.setText(AppState.config.getString("age_prompt_over_18", "Over 18"));
        this.ageUnder.setText(AppState.config.getString("age_prompt_under_18", "Under 18"));
    }

    public void a(String fromTag, String toTag) {
        Activity activity = getActivity();
        if (activity instanceof OnboardingActivity) {
            ((OnboardingActivity) activity).switchFragment(fromTag, toTag);
        }
    }
}
