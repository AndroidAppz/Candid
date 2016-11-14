package com.becandid.candid.activities;

import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.becandid.candid.data.AppState;
import defpackage.hi;
import java.util.ArrayList;

public class MeSettingsActivity extends BaseActivity {
    public static final int HEADER = 0;
    public static final int ITEM = 1;
    public static String TAG_SETTINGS_KEY = "tag_settings";
    private ArrayList<Setting> b;
    private hi c;
    @BindView(2131624203)
    RecyclerView recyclerView;
    @BindView(2131624204)
    TextView versionNumber;

    public class Setting {
        final /* synthetic */ MeSettingsActivity b;
        public String name;
        public int type;

        public Setting(MeSettingsActivity this$0, int type, String name) {
            this.b = this$0;
            this.type = type;
            this.name = name;
        }
    }

    public class ActivitySetting extends Setting {
        final /* synthetic */ MeSettingsActivity a;
        public Bundle bundle;
        public Class toStart;

        public ActivitySetting(MeSettingsActivity this$0, int type, String name, Class toStart, Bundle bundle) {
            this.a = this$0;
            super(this$0, type, name);
            this.toStart = toStart;
            this.bundle = bundle;
        }
    }

    public class WebViewSetting extends Setting {
        final /* synthetic */ MeSettingsActivity a;
        public String url;

        public WebViewSetting(MeSettingsActivity this$0, int type, String name, String url) {
            this.a = this$0;
            super(this$0, type, name);
            this.url = url;
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(2130968616);
        ButterKnife.bind(this);
        this.b = new ArrayList();
        this.b.add(new Setting(this, HEADER, "ACCOUNT"));
        Bundle extras = new Bundle();
        extras.putBoolean(TAG_SETTINGS_KEY, true);
        this.b.add(new ActivitySetting(this, ITEM, "Edit Interests", OnboardingActivity.class, extras));
        this.b.add(new ActivitySetting(this, ITEM, "Notification Settings", NotificationSettingsActivity.class, null));
        this.b.add(new Setting(this, HEADER, "ABOUT"));
        this.b.add(new WebViewSetting(this, ITEM, "About Candid", "content/about"));
        this.b.add(new WebViewSetting(this, ITEM, "Terms of Service", "content/terms"));
        this.b.add(new WebViewSetting(this, ITEM, "Privacy Policy", "content/privacy"));
        this.b.add(new WebViewSetting(this, ITEM, "Community Guidelines", "content/community"));
        this.b.add(new WebViewSetting(this, ITEM, "Get Help", "content/help"));
        this.b.add(new Setting(this, HEADER, ""));
        this.b.add(new Setting(this, ITEM, "Disown Permanently"));
        if (AppState.internal) {
            this.b.add(new Setting(this, HEADER, "Internal"));
            this.b.add(new ActivitySetting(this, ITEM, "Change Endpoint", ChangeEndpointActivity.class, null));
        }
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.c = new hi(this.b, this);
        this.recyclerView.setAdapter(this.c);
        String versionInfo = "\u00a9 Candid 2016";
        try {
            versionInfo = versionInfo + " \u2022 Version " + getPackageManager().getPackageInfo(getPackageName(), HEADER).versionName;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        this.versionNumber.setText(versionInfo);
    }
}
