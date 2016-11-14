package com.becandid.candid.views;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.a;
import android.support.design.widget.TabLayout.d;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.activities.BaseActivity;
import com.becandid.candid.activities.MeSettingsActivity;
import com.becandid.candid.activities.OnboardingActivity;
import com.becandid.candid.activities.SeeAllBadgesActivity;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.ContactsInfo;
import com.becandid.candid.data.DataUtil;
import com.becandid.candid.data.FacebookInfo.LoadCallback;
import com.becandid.candid.data.Group;
import com.becandid.candid.data.User;
import com.becandid.candid.models.JoinedFacebookData;
import com.becandid.candid.models.NetworkData;
import com.becandid.thirdparty.BlurTask;
import com.becandid.thirdparty.BlurTask.BadgeType;
import com.facebook.AccessToken;
import com.facebook.FacebookAuthorizationException;
import com.facebook.FacebookException;
import defpackage.aif;
import defpackage.apd;
import defpackage.apj;
import defpackage.apn;
import defpackage.apv;
import defpackage.bb;
import defpackage.hn;
import defpackage.hq;
import defpackage.hr;
import defpackage.hs;
import defpackage.ht;
import defpackage.ib;
import defpackage.ib$a;
import defpackage.ie;
import defpackage.ih$an;
import defpackage.ih$ap;
import defpackage.ih$d;
import defpackage.ih$k;
import defpackage.ih$m;
import defpackage.ih$o;
import defpackage.ih$r;
import defpackage.iq;
import defpackage.rb;
import defpackage.ub;
import defpackage.ub$a;
import defpackage.uc;
import defpackage.we;
import defpackage.wf;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import rx.exceptions.CompositeException;
import rx.schedulers.Schedulers;

public class MeTab extends TabView implements a, BadgeInfoView.a {
    private ub a;
    @BindView(2131624751)
    LinearLayout buttonPanel;
    @BindView(2131624752)
    View connectContact;
    @BindView(2131624753)
    View connectFb;
    private boolean e;
    private long f = 0;
    private TabLayout g;
    private Context h;
    private BaseActivity i;
    private BadgeInfoView j;
    private View k;
    private hn l;
    private final String m = "ACTIVITY";
    @BindView(2131624079)
    ImageView mBadgeIcon;
    @BindView(2131624269)
    FrameLayout mBadgeInfoContainer;
    @BindView(2131624076)
    TextView mBadgeTitle;
    @BindView(2131624750)
    TextView mGroupsCount;
    @BindView(2131624748)
    TextView mNumContacts;
    @BindView(2131624747)
    TextView mNumFriends;
    @BindView(2131624749)
    TextView mPostsCount;
    @BindView(2131624741)
    View mProfileContainer;
    @BindView(2131624745)
    TextView mQualityScore;
    private final String n = "GROUPS";
    private final String o = "POSTS";
    private final String p = "HISTORY";
    @BindView(2131624755)
    TabViewPager viewPager;

    public MeTab(Context context) {
        super(context);
        this.h = context;
    }

    public void a(final Activity activity) {
        super.a(activity);
        this.h = activity;
        setContentView(2130968730);
        ButterKnife.bind(this);
        this.i = (BaseActivity) activity;
        this.g = (TabLayout) findViewById(2131624754);
        this.g.setSelectedTabIndicatorColor(getResources().getColor(2131558476));
        this.g.setTabTextColors(Color.parseColor("#888888"), getResources().getColor(2131558476));
        this.l = new hn(this.i.getSupportFragmentManager());
        hr groupFragment = new hr();
        ht postsFragment = new ht();
        hs historyFragment = new hs();
        if (AppState.config.getBoolean("messaging_turned_on", true)) {
            this.l.a(new hq(), "ACTIVITY");
        }
        this.l.a(groupFragment, "GROUPS");
        this.l.a(postsFragment, "POSTS");
        this.l.a(historyFragment, "HISTORY");
        this.viewPager.setAdapter(this.l);
        this.viewPager.setOffscreenPageLimit(3);
        this.viewPager.setCurrTab("me");
        this.g.setupWithViewPager(this.viewPager);
        this.g.setOnTabSelectedListener(this);
        for (int i = 0; i < this.g.getTabCount(); i++) {
            TextView tab = (TextView) LayoutInflater.from(this.h).inflate(2130968643, null);
            tab.setText(this.g.a(i).d());
            tab.setCompoundDrawablePadding(0);
            this.g.a(i).a(tab);
        }
        findViewById(2131624746).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MeTab a;

            {
                this.a = this$0;
            }

            public void onClick(View view) {
                this.a.getContext().startActivity(new Intent(this.a.getContext(), MeSettingsActivity.class));
            }
        });
        ((BaseActivity) activity).addToSubscriptionList(iq.a().a(ih$k.class, new apj<ih$k>(this) {
            final /* synthetic */ MeTab a;

            {
                this.a = this$0;
            }

            public /* synthetic */ void onNext(Object obj) {
                a((ih$k) obj);
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
                rb.a(e);
            }

            public void a(ih$k didCreatePost) {
                ((ht) this.a.l.a("POSTS")).a(didCreatePost.a);
                User user = AppState.account;
                user.num_posts++;
                this.a.h();
            }
        }));
        ((BaseActivity) activity).addToSubscriptionList(iq.a().a(ih$r.class, new apj<ih$r>(this) {
            final /* synthetic */ MeTab a;

            {
                this.a = this$0;
            }

            public /* synthetic */ void onNext(Object obj) {
                a((ih$r) obj);
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
                rb.a(e);
            }

            public void a(ih$r didRemovePost) {
                ((ht) this.a.l.a("POSTS")).a(didRemovePost.a);
                User user = AppState.account;
                user.num_posts--;
                this.a.h();
            }
        }));
        ((BaseActivity) activity).addToSubscriptionList(iq.a().a(ih$m.class, new apj<ih$m>(this) {
            final /* synthetic */ MeTab a;

            {
                this.a = this$0;
            }

            public /* synthetic */ void onNext(Object obj) {
                a((ih$m) obj);
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
                rb.a(e);
            }

            public void a(ih$m didJoinGroup) {
                ((hr) this.a.l.a("GROUPS")).a(didJoinGroup.a);
                if (!(AppState.groups == null || AppState.account == null)) {
                    AppState.account.num_groups = AppState.groups.size();
                }
                this.a.h();
            }
        }));
        ((BaseActivity) activity).addToSubscriptionList(iq.a().a(ih$o.class, new apj<ih$o>(this) {
            final /* synthetic */ MeTab a;

            {
                this.a = this$0;
            }

            public /* synthetic */ void onNext(Object obj) {
                a((ih$o) obj);
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
            }

            public void a(ih$o didLeaveGroup) {
                ((hr) this.a.l.a("GROUPS")).a(didLeaveGroup.a);
                AppState.account.num_groups = AppState.groups.size();
                this.a.c();
                this.a.h();
            }
        }));
        ((BaseActivity) activity).addToSubscriptionList(iq.a().a(ih$d.class, new apj<ih$d>(this) {
            final /* synthetic */ MeTab b;

            public /* synthetic */ void onNext(Object obj) {
                a((ih$d) obj);
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
                rb.a(e);
            }

            public void a(ih$d blurTaskFinished) {
                this.b.j = new BadgeInfoView(activity, AppState.account.badge_status, true, blurTaskFinished.a);
                this.b.setBadgeInfoListener(this.b.j);
                this.b.mBadgeInfoContainer.setVisibility(0);
                this.b.mProfileContainer.setVisibility(8);
                this.b.mBadgeInfoContainer.addView(this.b.j);
                Animation slideUpAnimation = AnimationUtils.loadAnimation(activity, 2131034137);
                slideUpAnimation.setDuration(500);
                this.b.k = this.b.mBadgeInfoContainer.findViewById(2131624074);
                this.b.k.startAnimation(slideUpAnimation);
                this.b.mBadgeInfoContainer.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass12 a;

                    {
                        this.a = this$1;
                    }

                    public void onClick(View v) {
                        this.a.b.a(v);
                    }
                });
                AppState.blurTaskCalledOnFlight = false;
            }
        }));
        h();
        this.mBadgeIcon.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MeTab b;

            public void onClick(View v) {
                if (AppState.account != null && AppState.account.badge_status != null && !AppState.blurTaskCalledOnFlight) {
                    AppState.blurTaskCalledOnFlight = true;
                    new BlurTask(activity, 2131624741).execute(new Void[0]);
                }
            }
        });
    }

    private void setBadgeInfoListener(BadgeInfoView badgeInfoView) {
        badgeInfoView.setSeeAllBadgesListener(this);
    }

    public void b() {
        super.b();
        if (!this.e && g()) {
            a(false, false);
        }
    }

    public void f() {
        this.viewPager.setCurrentItem(0, true);
        a(true, true);
        ((AppBarLayout) findViewById(2131624742)).setExpanded(true, true);
    }

    public void a(final boolean forceRefresh, final boolean markActivityRead) {
        if (AppState.account == null || AppState.account.user_id <= 0) {
            Toast.makeText(getContext(), "Unable to find your profile.", 1).show();
            return;
        }
        this.e = true;
        if (forceRefresh) {
            this.viewPager.setVisibility(8);
            findViewById(2131624756).setVisibility(0);
        }
        ie.a().d(AppState.account.user_id).b(Schedulers.io()).a(apn.a()).b(new apj<NetworkData>(this) {
            final /* synthetic */ MeTab c;

            public /* synthetic */ void onNext(Object obj) {
                a((NetworkData) obj);
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
                this.c.c = false;
                this.c.e = false;
                this.c.viewPager.setVisibility(0);
                this.c.findViewById(2131624756).setVisibility(8);
                rb.a(e);
                Log.d("MeTab", e.toString());
                if (e instanceof CompositeException) {
                    for (Throwable throwable : ((CompositeException) e).a()) {
                        Log.d("MeTab", throwable.toString());
                    }
                    return;
                }
                Log.d("MeTab", e.toString());
            }

            public void a(NetworkData networkData) {
                if (AppState.account != null) {
                    this.c.c = false;
                    this.c.e = false;
                    this.c.findViewById(2131624756).setVisibility(8);
                    this.c.viewPager.setVisibility(0);
                    if (this.c.g()) {
                        if (this.c.l.a("ACTIVITY") != null) {
                            ((hq) this.c.l.a("ACTIVITY")).a(markActivityRead);
                        }
                        this.c.m();
                    } else {
                        if (this.c.l.a("ACTIVITY") != null) {
                            ((hq) this.c.l.a("ACTIVITY")).a(markActivityRead);
                        }
                        if (forceRefresh) {
                            this.c.m();
                        }
                    }
                    if (networkData.profile != null) {
                        AppState.account.num_posts = networkData.profile.num_posts;
                        AppState.account.num_groups = networkData.profile.num_groups;
                        AppState.account.num_fb_friends = networkData.profile.num_fb_friends;
                        AppState.account.num_phone_friends = networkData.profile.num_phone_friends;
                        AppState.account.quality_score = networkData.profile.quality_score;
                    }
                    this.c.f = System.currentTimeMillis() / 1000;
                    this.c.h();
                }
            }
        });
    }

    private void m() {
        ((hr) this.l.a("GROUPS")).b();
        ((ht) this.l.a("POSTS")).b();
        ((hs) this.l.a("HISTORY")).b();
    }

    public boolean g() {
        return (System.currentTimeMillis() / 1000) - this.f > ((long) AppState.config.getInt("profile_update_time", 300));
    }

    public void h() {
        if (AppState.account != null) {
            this.mPostsCount.setText(Integer.toString(AppState.account.num_posts));
            this.mGroupsCount.setText(Integer.toString(AppState.account.num_groups));
            this.mNumFriends.setText(Integer.toString(AppState.account.num_fb_friends));
            this.mNumContacts.setText(Integer.toString(Integer.valueOf(AppState.account.num_phone_friends).intValue()));
            final String score = new DecimalFormat("#").format((double) AppState.account.quality_score);
            if (score == null || score.equals("0")) {
                this.mQualityScore.setVisibility(8);
            } else {
                this.mQualityScore.setVisibility(0);
                this.mQualityScore.setText(score);
                this.mQualityScore.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ MeTab b;

                    public void onClick(View v) {
                        if (!AppState.blurTaskCalledOnFlight) {
                            AppState.blurTaskCalledOnFlight = true;
                            new BlurTask((Activity) this.b.h, ((Activity) this.b.h).findViewById(16908290), score, BadgeType.ME_QUALITY_SCORE, null, null).execute(new Void[0]);
                        }
                    }
                });
            }
            ib$a badge = ib.a().a(AppState.account.badge_status);
            if (badge != null) {
                this.mBadgeIcon.setImageResource(badge.c);
                this.mBadgeTitle.setText(badge.b);
            }
            if (AppState.account.have_fb && AppState.account.have_phone_number) {
                this.buttonPanel.setVisibility(8);
                return;
            }
            this.buttonPanel.setVisibility(0);
            if (AppState.fbInfo != null) {
                this.connectFb.setVisibility(8);
            } else {
                this.connectFb.setVisibility(0);
            }
            if (AppState.account.have_phone_number) {
                this.connectContact.setVisibility(8);
            } else {
                this.connectContact.setVisibility(0);
            }
        }
    }

    public void a(d tab) {
        this.viewPager.setCurrentItem(tab.c(), true);
        if (tab.c() == 0 && AppState.config.getBoolean("messaging_turned_on", true)) {
            TextView tabView = (TextView) tab.a();
            tabView.setTextColor(getResources().getColor(2131558476));
            tabView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    public void b(d tab) {
        if (tab.c() == 0 && AppState.config.getBoolean("messaging_turned_on", true)) {
            TextView tabView = (TextView) tab.a();
            tabView.setTextColor(Color.parseColor("#888888"));
            tabView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    public void c(d tab) {
        c();
    }

    public void c() {
        super.c();
        a(false, false);
    }

    @OnClick({2131624753})
    public void connectFB(final View view) {
        view.setVisibility(8);
        if (this.a == null) {
            this.a = ub$a.a();
            we.c().a(this.a, new uc<wf>(this) {
                final /* synthetic */ MeTab b;

                public /* synthetic */ void onSuccess(Object obj) {
                    a((wf) obj);
                }

                public void a(wf loginResult) {
                    Log.d("FBConnect", "success");
                    AppState.setFBInfo(loginResult.a(), new LoadCallback(this) {
                        final /* synthetic */ AnonymousClass2 a;

                        {
                            this.a = this$1;
                        }

                        public void onNext(int numFriends) {
                            if (AppState.account != null) {
                                AppState.account.num_fb_friends = numFriends;
                            }
                            this.a.b.h();
                            this.a.b.k();
                        }
                    });
                }

                public void onCancel() {
                    Log.d("FBConnect", "cancel");
                    view.setVisibility(0);
                }

                public void onError(FacebookException error) {
                    Log.e("FBConnect", error.toString());
                    if (!(error instanceof FacebookAuthorizationException) || AccessToken.a() == null) {
                        Toast.makeText(GossipApplication.a(), "Unable to connect to Facebook", 1).show();
                        view.setVisibility(0);
                        return;
                    }
                    we.c().d();
                    we.c().a(this.b.i, Arrays.asList("public_profile,user_friends,user_work_history,user_education_history".split(",")));
                }
            });
        }
        we.c().a(this.i, Arrays.asList("public_profile,user_friends,user_work_history,user_education_history".split(",")));
    }

    @OnClick({2131624752})
    public void connectContacts(View view) {
        if (AppState.contactsInfo == null) {
            AppState.contactsInfo = new ContactsInfo();
        }
        if (!AppState.account.have_phone_number || bb.checkSelfPermission(view.getContext(), "android.permission.READ_CONTACTS") == 0) {
            Intent intent = new Intent(view.getContext(), OnboardingActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("first_fragment", "phone");
            bundle.putString("second_fragment", "phone");
            intent.putExtras(bundle);
            view.getContext().startActivity(intent);
            return;
        }
        ActivityCompat.requestPermissions((Activity) view.getContext(), new String[]{"android.permission.READ_CONTACTS"}, 1);
    }

    public void i() {
        GossipApplication.a().d();
        l();
        this.connectContact.setVisibility(8);
    }

    public void j() {
        this.connectContact.setEnabled(true);
    }

    public void a(int requestCode, int resultCode, Intent data) {
        super.a(requestCode, resultCode, data);
        if (this.a != null) {
            this.a.a(requestCode, resultCode, data);
        }
    }

    public void k() {
        Map hashParams = new HashMap();
        hashParams.put("fb_token", AppState.fbInfo.fbToken.b());
        hashParams.put("fb_uid", AppState.fbInfo.fbToken.i());
        Map<String, String> syncParams = new HashMap();
        syncParams.put("type", "fb");
        syncParams.put("fb_uid", AppState.fbInfo.fbToken.i());
        syncParams.put("id_list", DataUtil.join(AppState.fbInfo.friendIds));
        apd.a(ie.a().b(hashParams).b(Schedulers.io()).a(apn.a()), ie.a().a(AppState.fbInfo).b(Schedulers.io()).a(apn.a()), new apv<aif, NetworkData, JoinedFacebookData>(this) {
            final /* synthetic */ MeTab a;

            {
                this.a = this$0;
            }

            public /* synthetic */ Object call(Object obj, Object obj2) {
                return a((aif) obj, (NetworkData) obj2);
            }

            public JoinedFacebookData a(aif hash, NetworkData autoJoin) {
                return new JoinedFacebookData(hash, autoJoin);
            }
        }).b(new apj<JoinedFacebookData>(this) {
            final /* synthetic */ MeTab a;

            {
                this.a = this$0;
            }

            public /* synthetic */ void onNext(Object obj) {
                a((JoinedFacebookData) obj);
            }

            public void onCompleted() {
                iq.a().a(new ih$ap());
            }

            public void onError(Throwable e) {
            }

            public void a(JoinedFacebookData joinedFacebookData) {
                NetworkData autoJoin = joinedFacebookData.autoJoin;
                if (!(autoJoin == null || autoJoin.groups == null)) {
                    for (Group group : autoJoin.groups) {
                        iq.a().a(new ih$m(group));
                    }
                }
                if (!(autoJoin == null || autoJoin.my_info == null)) {
                    AppState.account.num_groups = autoJoin.my_info.num_groups;
                }
                this.a.h();
            }
        });
    }

    public void l() {
        Map params = new HashMap();
        params.put("type", "phone_number");
        params.put("id_list", DataUtil.join(AppState.contactsInfo.contacts));
        ie.a().c(params).b(Schedulers.io()).a(apn.a()).b(new apj<aif>(this) {
            final /* synthetic */ MeTab a;

            {
                this.a = this$0;
            }

            public /* synthetic */ void onNext(Object obj) {
                a((aif) obj);
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
                Log.d("MeTab", e.toString());
            }

            public void a(aif result) {
                AppState.account.num_phone_friends = result.b("num_phone_friends").g();
                AppState.saveState(GossipApplication.a());
                this.a.h();
                iq.a().a(new ih$ap());
            }
        });
    }

    public void a_() {
        a(this.mBadgeInfoContainer);
        final Context context = getContext();
        this.mProfileContainer.postDelayed(new Runnable(this) {
            final /* synthetic */ MeTab b;

            public void run() {
                context.startActivity(new Intent(context, SeeAllBadgesActivity.class));
            }
        }, 600);
    }

    private void a(View v) {
        Animation slideDownAnimation = AnimationUtils.loadAnimation(getContext(), 2131034132);
        slideDownAnimation.setDuration(500);
        this.k.startAnimation(slideDownAnimation);
        v.postDelayed(new Runnable(this) {
            final /* synthetic */ MeTab a;

            {
                this.a = this$0;
            }

            public void run() {
                this.a.mProfileContainer.setVisibility(0);
                this.a.mBadgeInfoContainer.removeView(this.a.j);
                this.a.mBadgeInfoContainer.setVisibility(8);
            }
        }, 500);
    }

    public void d() {
        this.mProfileContainer.setVisibility(0);
    }

    public void e() {
        this.mProfileContainer.setVisibility(8);
    }

    public void a(ih$an updateUnreadCount) {
        int position = this.viewPager.getCurrentItem();
        if (updateUnreadCount != null && position != 0 && updateUnreadCount.a == 3 && AppState.config.getBoolean("messaging_turned_on", true)) {
            int unreadDot;
            if (updateUnreadCount.b > 0) {
                unreadDot = 2130838240;
            } else {
                unreadDot = 0;
            }
            ((TextView) this.g.a(0).a()).setCompoundDrawablesWithIntrinsicBounds(0, 0, unreadDot, 0);
        }
    }
}
