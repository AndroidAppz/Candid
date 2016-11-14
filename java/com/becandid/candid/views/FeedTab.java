package com.becandid.candid.views;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.a;
import android.support.design.widget.TabLayout.d;
import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.becandid.candid.activities.BaseActivity;
import com.becandid.candid.data.AppState;
import defpackage.hn;
import defpackage.hp;
import defpackage.um$h;
import defpackage.zu;
import java.util.ArrayList;
import java.util.List;

public class FeedTab extends TabView implements a {
    BaseActivity a;
    private Context e;
    private hn f;
    private List<String> g;
    @BindView(2131624388)
    TabLayout mFeedTabs;
    @BindView(2131624390)
    View mNewPostsText;
    @BindView(2131624389)
    TabViewPager viewPager;

    public FeedTab(Context context) {
        super(context);
        this.e = context;
    }

    public void a(Activity activity) {
        super.a(activity);
        setContentView(2130968661);
        ButterKnife.bind(this);
        this.a = (BaseActivity) activity;
        this.mFeedTabs.setSelectedTabIndicatorColor(getResources().getColor(2131558476));
        this.mFeedTabs.setTabTextColors(Color.parseColor("#888888"), getResources().getColor(2131558476));
        this.g = AppState.tabsOrder;
        if (this.g == null || this.g.isEmpty()) {
            this.g = new ArrayList();
            this.g.add("home");
            this.g.add("trending");
            this.g.add("friends");
        }
        this.f = new hn(this.a.getSupportFragmentManager());
        for (String tab : this.g) {
            hp feedFragment = new hp();
            Bundle args = new Bundle();
            args.putString("feed_type", tab);
            feedFragment.setArguments(args);
            this.f.a(feedFragment, a(tab));
        }
        this.viewPager.setAdapter(this.f);
        this.viewPager.setOffscreenPageLimit(2);
        this.viewPager.setCurrTab("feed");
        this.mFeedTabs.setupWithViewPager(this.viewPager);
        this.mFeedTabs.setOnTabSelectedListener(this);
    }

    private String a(String tab) {
        Object obj = -1;
        switch (tab.hashCode()) {
            case 3208415:
                if (tab.equals("home")) {
                    obj = null;
                    break;
                }
                break;
            case 1394955557:
                if (tab.equals("trending")) {
                    obj = 1;
                    break;
                }
                break;
        }
        switch (obj) {
            case zu.GOOGLE_PLAY_SERVICES_VERSION_CODE /*?: ONE_ARG  (wrap: int
  0x0001: INVOKE  (r0_0 int) =  zu.zzqZ():int type: STATIC)*/:
                return "New";
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                return "Hot";
            default:
                return "Friends";
        }
    }

    public void a(d tab) {
        this.viewPager.setCurrentItem(tab.c(), true);
    }

    public void b(d tab) {
    }

    public void c(d tab) {
        ((hp) this.f.getItem(tab.c())).b();
    }

    public void c() {
        super.c();
        for (int i = 0; i < this.viewPager.getChildCount(); i++) {
            ((hp) this.f.getItem(i)).b();
        }
    }

    public void a(int requestCode, int resultCode, Intent data) {
        super.a(requestCode, resultCode, data);
        if (this.a.callbackManager != null) {
            this.a.callbackManager.a(requestCode, resultCode, data);
        }
    }

    public void a(int upsellId) {
        ((hp) this.f.getItem(this.viewPager.getCurrentItem())).a(upsellId);
    }

    public void b() {
        super.b();
        if (this.d != 0 && (System.currentTimeMillis() - this.d) / 60000 > ((long) AppState.config.getInt("refresh_timeout", 5))) {
            this.viewPager.setCurrentItem(0, true);
            c();
        }
    }

    public void d() {
        findViewById(2131624387).setVisibility(0);
    }

    public void e() {
        findViewById(2131624387).setVisibility(8);
    }
}
