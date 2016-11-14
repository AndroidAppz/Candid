package com.becandid.candid.fragments.onboarding;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.becandid.candid.activities.MeSettingsActivity;
import com.becandid.candid.activities.OnboardingActivity;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.DataUtil;
import com.becandid.candid.models.NetworkData;
import com.becandid.candid.views.TagBox;
import com.becandid.candid.views.TagBox.a;
import defpackage.apj;
import defpackage.apn;
import defpackage.ie;
import defpackage.iu;
import defpackage.rb;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import rx.schedulers.Schedulers;

public class OnboardingTagsFragment extends Fragment implements a {
    private Unbinder a;
    private HashSet<String> b;
    private Bundle c;
    @BindView(2131624661)
    Button tagCancel;
    @BindView(2131624660)
    RelativeLayout tagContainer;
    @BindView(2131624662)
    Button tagSubmit;
    @BindView(2131624657)
    TextView tagsHeader;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(2130968716, container, false);
        this.a = ButterKnife.bind(this, view);
        b();
        if (AppState.tags == null) {
            AppState.tags = Arrays.asList(new String[]{"Politics", "Celebrities", "Music", "Technology", "Fashion", "Business", "School", "Art", "Photography", "LGBT", "Relationships", "Sports", "Funny", "Teens", "Confessions", "Personal", "Sex", "Family", "Work", "Faith", "Food", "Entertainment", "Womens Issues"});
        }
        List tag_array = AppState.tags;
        this.c = getArguments();
        if (this.c == null || !this.c.containsKey(MeSettingsActivity.TAG_SETTINGS_KEY)) {
            iu.a(getActivity(), this.tagContainer, tag_array);
        } else {
            iu.a(getActivity(), this.tagContainer, tag_array);
            this.b = new HashSet(AppState.account.tags);
            if (!this.b.isEmpty()) {
                this.tagSubmit.setEnabled(true);
            }
            this.tagCancel.setVisibility(0);
            this.tagCancel.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ OnboardingTagsFragment a;

                {
                    this.a = this$0;
                }

                public void onClick(View v) {
                    this.a.getActivity().finish();
                }
            });
        }
        TagBox.setTagClickListener(this);
        this.tagSubmit.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ OnboardingTagsFragment a;

            {
                this.a = this$0;
            }

            public void onClick(View v) {
                this.a.a();
            }
        });
        return view;
    }

    private void b() {
        this.tagsHeader.setText(AppState.config.getString("tags_header", getString(2131230923)));
    }

    public void a(View v, String label) {
        v.setSelected(!v.isSelected());
        if (this.b == null) {
            this.b = new HashSet();
        }
        if (this.b.contains(label)) {
            this.b.remove(label);
            if (this.b.isEmpty()) {
                this.tagSubmit.setEnabled(false);
                return;
            }
            return;
        }
        this.b.add(label);
        this.tagSubmit.setEnabled(true);
    }

    public void onResume() {
        super.onResume();
        c();
    }

    private void c() {
        if (AppState.activeTags == null && AppState.account.tags != null) {
            this.b = new HashSet(AppState.account.tags);
        }
        int count = this.tagContainer.getChildCount();
        for (int i = 0; i < count; i++) {
            LinearLayout layout = (LinearLayout) this.tagContainer.getChildAt(i);
            for (int j = 0; j < layout.getChildCount(); j++) {
                TagBox tag = (TagBox) layout.getChildAt(j);
                if (!(AppState.account == null || AppState.account.tags == null || !AppState.account.tags.contains(tag.getTagName()))) {
                    tag.setSelected(true);
                    this.tagSubmit.setEnabled(true);
                }
            }
        }
    }

    public void a() {
        this.tagSubmit.setEnabled(false);
        if (this.b == null || this.b.isEmpty()) {
            AppState.activeTags = new ArrayList();
            AppState.account.tags = AppState.activeTags;
        } else {
            AppState.activeTags = new ArrayList(this.b);
            AppState.account.tags = AppState.activeTags;
        }
        if (this.c == null || !this.c.containsKey(MeSettingsActivity.TAG_SETTINGS_KEY)) {
            ((OnboardingActivity) getActivity()).finishGetGroups();
            return;
        }
        Map params = new HashMap();
        params.put("tags", DataUtil.join(AppState.activeTags));
        ie.a().i(params).b(Schedulers.io()).a(apn.a()).b(new apj<NetworkData>(this) {
            final /* synthetic */ OnboardingTagsFragment a;

            {
                this.a = this$0;
            }

            public /* synthetic */ void onNext(Object obj) {
                a((NetworkData) obj);
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
                Log.d("SubmitTags", e.toString());
                rb.a(e);
            }

            public void a(NetworkData networkData) {
            }
        });
        getActivity().finish();
    }
}
