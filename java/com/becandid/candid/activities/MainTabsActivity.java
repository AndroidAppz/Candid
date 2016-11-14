package com.becandid.candid.activities;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.DataUtil;
import com.becandid.candid.data.Group;
import com.becandid.candid.models.NetworkData;
import com.becandid.candid.views.ActivityTab;
import com.becandid.candid.views.FeedTab;
import com.becandid.candid.views.GroupsTab;
import com.becandid.candid.views.MeTab;
import com.becandid.candid.views.MessagesTab;
import com.becandid.candid.views.TabView;
import com.becandid.thirdparty.BlurTask;
import com.becandid.thirdparty.BlurTask.BadgeType;
import defpackage.apj;
import defpackage.apn;
import defpackage.ie;
import defpackage.ih$an;
import defpackage.ih$ap;
import defpackage.ih$u;
import defpackage.iq;
import defpackage.rb;
import defpackage.wv;
import java.util.List;
import rx.schedulers.Schedulers;

public class MainTabsActivity extends PopupWithBlurBackgroundActivity implements OnClickListener {
    public static int ACTIVITY_TAB = -1;
    public static final int CREATE_GROUP = 1001;
    public static final int CREATE_POST_REQUEST = 888;
    public static int FEED_TAB = -1;
    public static int GROUPS_TAB = -1;
    public static int MESSAGES_TAB = -1;
    public static int ME_TAB = -1;
    public static final int PERMISSION_READ_CONTACTS = 1;
    public static int POST_TAB = -1;
    public static int[] tabIds = new int[5];
    public static List<String> tabNames;
    public ActivityTab activityTab;
    final BroadcastReceiver b = new BroadcastReceiver(this) {
        final /* synthetic */ MainTabsActivity a;

        {
            this.a = this$0;
        }

        public void onReceive(Context context, Intent intent) {
            if (intent.getExtras().getString("activity_id") != null) {
                this.a.busSubscribe(ih$an.class, new apj<ih$an>(this) {
                    final /* synthetic */ AnonymousClass1 a;

                    {
                        this.a = this$1;
                    }

                    public void onCompleted() {
                    }

                    public void onError(Throwable e) {
                        rb.a(e);
                    }

                    public void onNext(ih$an updateUnreadCount) {
                        this.a.a.a(updateUnreadCount);
                    }
                });
            }
            abortBroadcast();
        }
    };
    private final int c = 999;
    public int currentTab = -1;
    private List<View> d;
    private RelativeLayout e;
    private Handler f;
    public FeedTab feedTab;
    private final int g = 60000;
    public GroupsTab groupsTab;
    private Runnable h = new Runnable(this) {
        final /* synthetic */ MainTabsActivity a;

        {
            this.a = this$0;
        }

        public void run() {
            if (this.a.meTab != null) {
                this.a.meTab.c();
            }
            this.a.f.postDelayed(this.a.h, 60000);
        }
    };
    @BindView(2131624199)
    View mActivityBadge;
    @BindView(2131624200)
    TextView mActivityUnread;
    @BindView(2131624189)
    View mFeedBadge;
    @BindView(2131624190)
    TextView mFeedUnread;
    @BindView(2131624192)
    View mGroupBadge;
    @BindView(2131624193)
    TextView mGroupUnread;
    @BindView(2131624196)
    View mMessagesBadge;
    @BindView(2131624197)
    TextView mMessagesUnread;
    public MeTab meTab;
    public MessagesTab messagesTab;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void onCreate(android.os.Bundle r14) {
        /*
        r13 = this;
        r10 = 3;
        r9 = 2;
        r11 = 5;
        r6 = 0;
        r8 = 1;
        r5 = com.becandid.candid.data.AppState.config;
        r5 = r5.experimentConfig;
        r7 = "messaging_turned_on";
        r5 = r5.containsKey(r7);
        if (r5 == 0) goto L_0x0083;
    L_0x0011:
        r5 = com.becandid.candid.data.AppState.config;
        r7 = "messaging_turned_on";
        r5 = r5.getBoolean(r7);
        if (r5 == 0) goto L_0x0083;
    L_0x001b:
        r5 = 2130968614; // 0x7f040026 float:1.7545887E38 double:1.0528383845E-314;
        r13.setContentView(r5);
        r5 = new java.lang.String[r11];
        r7 = "feed";
        r5[r6] = r7;
        r7 = "groups";
        r5[r8] = r7;
        r7 = "post";
        r5[r9] = r7;
        r7 = "messages";
        r5[r10] = r7;
        r7 = 4;
        r12 = "me";
        r5[r7] = r12;
        r5 = java.util.Arrays.asList(r5);
        tabNames = r5;
    L_0x003e:
        super.onCreate(r14);
        butterknife.ButterKnife.bind(r13);
        com.becandid.candid.data.AppState.mainTabsActivity = r13;
        r5 = new android.os.Handler;
        r7 = r13.getMainLooper();
        r5.<init>(r7);
        r13.f = r5;
        r5 = 2131624186; // 0x7f0e00fa float:1.8875545E38 double:1.05316228E-314;
        r5 = r13.findViewById(r5);
        r5 = (android.widget.RelativeLayout) r5;
        r13.e = r5;
        r5 = new java.util.ArrayList;
        r5.<init>(r11);
        r13.d = r5;
        r1 = 0;
    L_0x0064:
        r5 = tabNames;
        r5 = r5.size();
        if (r1 >= r5) goto L_0x01a4;
    L_0x006c:
        r5 = tabNames;
        r5 = r5.get(r1);
        r5 = (java.lang.String) r5;
        r7 = -1;
        r12 = r5.hashCode();
        switch(r12) {
            case -1655966961: goto L_0x00d9;
            case -1237460524: goto L_0x00b1;
            case -462094004: goto L_0x00c5;
            case 3480: goto L_0x00cf;
            case 3138974: goto L_0x00a7;
            case 3446944: goto L_0x00bb;
            default: goto L_0x007c;
        };
    L_0x007c:
        r5 = r7;
    L_0x007d:
        switch(r5) {
            case 0: goto L_0x00e3;
            case 1: goto L_0x0104;
            case 2: goto L_0x0125;
            case 3: goto L_0x0141;
            case 4: goto L_0x0162;
            case 5: goto L_0x0183;
            default: goto L_0x0080;
        };
    L_0x0080:
        r1 = r1 + 1;
        goto L_0x0064;
    L_0x0083:
        r5 = 2130968615; // 0x7f040027 float:1.7545889E38 double:1.052838385E-314;
        r13.setContentView(r5);
        r5 = new java.lang.String[r11];
        r7 = "feed";
        r5[r6] = r7;
        r7 = "groups";
        r5[r8] = r7;
        r7 = "post";
        r5[r9] = r7;
        r7 = "me";
        r5[r10] = r7;
        r7 = 4;
        r12 = "activity";
        r5[r7] = r12;
        r5 = java.util.Arrays.asList(r5);
        tabNames = r5;
        goto L_0x003e;
    L_0x00a7:
        r12 = "feed";
        r5 = r5.equals(r12);
        if (r5 == 0) goto L_0x007c;
    L_0x00af:
        r5 = r6;
        goto L_0x007d;
    L_0x00b1:
        r12 = "groups";
        r5 = r5.equals(r12);
        if (r5 == 0) goto L_0x007c;
    L_0x00b9:
        r5 = r8;
        goto L_0x007d;
    L_0x00bb:
        r12 = "post";
        r5 = r5.equals(r12);
        if (r5 == 0) goto L_0x007c;
    L_0x00c3:
        r5 = r9;
        goto L_0x007d;
    L_0x00c5:
        r12 = "messages";
        r5 = r5.equals(r12);
        if (r5 == 0) goto L_0x007c;
    L_0x00cd:
        r5 = r10;
        goto L_0x007d;
    L_0x00cf:
        r12 = "me";
        r5 = r5.equals(r12);
        if (r5 == 0) goto L_0x007c;
    L_0x00d7:
        r5 = 4;
        goto L_0x007d;
    L_0x00d9:
        r12 = "activity";
        r5 = r5.equals(r12);
        if (r5 == 0) goto L_0x007c;
    L_0x00e1:
        r5 = r11;
        goto L_0x007d;
    L_0x00e3:
        r5 = new com.becandid.candid.views.FeedTab;
        r5.<init>(r13);
        r13.feedTab = r5;
        r5 = r13.feedTab;
        r13.a(r5);
        FEED_TAB = r1;
        r5 = tabIds;
        r7 = 2131624188; // 0x7f0e00fc float:1.8875549E38 double:1.053162281E-314;
        r5[r1] = r7;
        r5 = 2131624188; // 0x7f0e00fc float:1.8875549E38 double:1.053162281E-314;
        r5 = r13.findViewById(r5);
        r5.setOnClickListener(r13);
        goto L_0x0080;
    L_0x0104:
        r5 = new com.becandid.candid.views.GroupsTab;
        r5.<init>(r13);
        r13.groupsTab = r5;
        r5 = r13.groupsTab;
        r13.a(r5);
        GROUPS_TAB = r1;
        r5 = tabIds;
        r7 = 2131624191; // 0x7f0e00ff float:1.8875555E38 double:1.0531622826E-314;
        r5[r1] = r7;
        r5 = 2131624191; // 0x7f0e00ff float:1.8875555E38 double:1.0531622826E-314;
        r5 = r13.findViewById(r5);
        r5.setOnClickListener(r13);
        goto L_0x0080;
    L_0x0125:
        r5 = r13.d;
        r7 = r13.groupsTab;
        r5.add(r7);
        r5 = tabIds;
        r7 = 2131624194; // 0x7f0e0102 float:1.887556E38 double:1.053162284E-314;
        r5[r1] = r7;
        POST_TAB = r1;
        r5 = 2131624194; // 0x7f0e0102 float:1.887556E38 double:1.053162284E-314;
        r5 = r13.findViewById(r5);
        r5.setOnClickListener(r13);
        goto L_0x0080;
    L_0x0141:
        r5 = new com.becandid.candid.views.MessagesTab;
        r5.<init>(r13);
        r13.messagesTab = r5;
        r5 = r13.messagesTab;
        r13.a(r5);
        MESSAGES_TAB = r1;
        r5 = tabIds;
        r7 = 2131624195; // 0x7f0e0103 float:1.8875563E38 double:1.0531622846E-314;
        r5[r1] = r7;
        r5 = 2131624195; // 0x7f0e0103 float:1.8875563E38 double:1.0531622846E-314;
        r5 = r13.findViewById(r5);
        r5.setOnClickListener(r13);
        goto L_0x0080;
    L_0x0162:
        r5 = new com.becandid.candid.views.MeTab;
        r5.<init>(r13);
        r13.meTab = r5;
        r5 = r13.meTab;
        r13.a(r5);
        ME_TAB = r1;
        r5 = tabIds;
        r7 = 2131624198; // 0x7f0e0106 float:1.8875569E38 double:1.053162286E-314;
        r5[r1] = r7;
        r5 = 2131624198; // 0x7f0e0106 float:1.8875569E38 double:1.053162286E-314;
        r5 = r13.findViewById(r5);
        r5.setOnClickListener(r13);
        goto L_0x0080;
    L_0x0183:
        r5 = new com.becandid.candid.views.ActivityTab;
        r5.<init>(r13);
        r13.activityTab = r5;
        r5 = r13.activityTab;
        r13.a(r5);
        ACTIVITY_TAB = r1;
        r5 = tabIds;
        r7 = 2131624201; // 0x7f0e0109 float:1.8875575E38 double:1.0531622876E-314;
        r5[r1] = r7;
        r5 = 2131624201; // 0x7f0e0109 float:1.8875575E38 double:1.0531622876E-314;
        r5 = r13.findViewById(r5);
        r5.setOnClickListener(r13);
        goto L_0x0080;
    L_0x01a4:
        r5 = r13.getIntent();
        r7 = "selected_tab";
        r5 = r5.hasExtra(r7);
        if (r5 == 0) goto L_0x0280;
    L_0x01b0:
        r5 = r13.getIntent();
        r7 = "selected_tab";
        r4 = r5.getStringExtra(r7);
    L_0x01ba:
        r13.setTab(r4);
        r5 = r13.b();
        if (r5 == 0) goto L_0x01cd;
    L_0x01c3:
        r2 = new android.content.Intent;
        r5 = com.becandid.candid.services.RegistrationIntentService.class;
        r2.<init>(r13, r5);
        r13.startService(r2);
    L_0x01cd:
        r5 = com.becandid.candid.data.AppState.config;
        if (r5 == 0) goto L_0x0202;
    L_0x01d1:
        r5 = com.becandid.candid.data.AppState.config;
        r7 = "android_force_upgrade_version_number";
        r5 = r5.getBoolean(r7);
        if (r5 != r8) goto L_0x0202;
    L_0x01db:
        r0 = new android.support.v7.app.AlertDialog$Builder;
        r0.<init>(r13);
        r5 = "A new version is available. Pleage update your app!";
        r5 = r0.setTitle(r5);
        r5 = r5.setCancelable(r6);
        r6 = "Update";
        r7 = new com.becandid.candid.activities.MainTabsActivity$4;
        r7.<init>(r13);
        r5 = r5.setPositiveButton(r6, r7);
        r6 = "Quit app";
        r7 = new com.becandid.candid.activities.MainTabsActivity$3;
        r7.<init>(r13);
        r5.setNegativeButton(r6, r7);
        r0.show();
    L_0x0202:
        r5 = com.becandid.candid.data.AppState.needAge;
        if (r5 != r8) goto L_0x0237;
    L_0x0206:
        r5 = com.becandid.candid.data.AppState.age;
        if (r5 != 0) goto L_0x0237;
    L_0x020a:
        r5 = com.becandid.candid.data.AppState.fbInfo;
        if (r5 == 0) goto L_0x0284;
    L_0x020e:
        r5 = com.becandid.candid.data.AppState.fbInfo;
        r5 = r5.fbToken;
        if (r5 == 0) goto L_0x0284;
    L_0x0214:
        r5 = com.becandid.candid.data.AppState.fbInfo;
        r5 = r5.fbToken;
        r5 = r5.b();
        if (r5 == 0) goto L_0x0284;
    L_0x021e:
        r3 = new java.util.HashMap;
        r3.<init>();
        r5 = "fb_token";
        r6 = com.becandid.candid.data.AppState.fbInfo;
        r6 = r6.fbToken;
        r6 = r6.b();
        r3.put(r5, r6);
        r5 = defpackage.ie.a();
        r5.a(r3);
    L_0x0237:
        r5 = defpackage.iq.a();
        r6 = defpackage.ih$e.class;
        r7 = new com.becandid.candid.activities.MainTabsActivity$5;
        r7.<init>(r13);
        r5 = r5.a(r6, r7);
        r13.busSubscribe(r5);
        r5 = defpackage.iq.a();
        r6 = defpackage.ih$an.class;
        r7 = new com.becandid.candid.activities.MainTabsActivity$6;
        r7.<init>(r13);
        r5 = r5.a(r6, r7);
        r13.busSubscribe(r5);
        r5 = defpackage.iq.a();
        r6 = defpackage.ih$ap.class;
        r7 = new com.becandid.candid.activities.MainTabsActivity$7;
        r7.<init>(r13);
        r5 = r5.a(r6, r7);
        r13.busSubscribe(r5);
        r5 = defpackage.iq.a();
        r6 = defpackage.ih$f.class;
        r7 = new com.becandid.candid.activities.MainTabsActivity$8;
        r7.<init>(r13);
        r5 = r5.a(r6, r7);
        r13.busSubscribe(r5);
        return;
    L_0x0280:
        r4 = "feed";
        goto L_0x01ba;
    L_0x0284:
        r5 = r13.e;
        r6 = 1045220557; // 0x3e4ccccd float:0.2 double:5.164075695E-315;
        r5.setAlpha(r6);
        r2 = new android.content.Intent;
        r5 = com.becandid.candid.activities.VerifyAgeActivity.class;
        r2.<init>(r13, r5);
        r5 = 999; // 0x3e7 float:1.4E-42 double:4.936E-321;
        r13.startActivityForResult(r2, r5);
        goto L_0x0237;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.becandid.candid.activities.MainTabsActivity.onCreate(android.os.Bundle):void");
    }

    public void hideCurrentScreen() {
        View currTab = (View) this.d.get(this.currentTab);
        if (currTab != null && (currTab instanceof TabView)) {
            ((TabView) currTab).e();
        }
    }

    public void showCurrentScreen() {
        View currTab = (View) this.d.get(this.currentTab);
        if (currTab != null && (currTab instanceof TabView)) {
            ((TabView) currTab).d();
        }
    }

    private void a(ih$an updateUnreadCount) {
        int tabIndex = updateUnreadCount.a;
        int tabCount = updateUnreadCount.b;
        String count = "";
        if (tabCount > 99) {
            count = "99+";
        } else {
            count = Integer.toString(tabCount);
        }
        if (tabIndex == 3 && this.currentTab != ME_TAB && this.currentTab != ACTIVITY_TAB) {
            AppState.account.unread_activity_count = tabCount;
            if (tabCount < PERMISSION_READ_CONTACTS) {
                this.mActivityBadge.setVisibility(8);
                return;
            }
            this.mActivityBadge.setVisibility(0);
            this.mActivityUnread.setText(count);
        } else if (tabIndex == 0 && this.currentTab != FEED_TAB) {
            AppState.account.unread_feed_count = tabCount;
            if (tabCount < PERMISSION_READ_CONTACTS) {
                this.mFeedBadge.setVisibility(8);
                return;
            }
            this.mFeedBadge.setVisibility(0);
            this.mFeedUnread.setText(count);
        } else if (tabIndex == PERMISSION_READ_CONTACTS && this.currentTab != GROUPS_TAB) {
            AppState.account.unread_groups_count = tabCount;
            if (tabCount < PERMISSION_READ_CONTACTS) {
                this.mGroupBadge.setVisibility(8);
                return;
            }
            this.mGroupBadge.setVisibility(0);
            this.mGroupUnread.setText(count);
        } else if (tabIndex == 2 && this.mMessagesBadge != null && this.mMessagesUnread != null) {
            AppState.account.unread_message_count = tabCount;
            if (tabCount < PERMISSION_READ_CONTACTS) {
                this.mMessagesBadge.setVisibility(8);
            } else if (this.currentTab != MESSAGES_TAB) {
                this.mMessagesBadge.setVisibility(0);
                this.mMessagesUnread.setText(count);
                if (!AppState.hasMessagingShown) {
                    setShowMessagingPopup(true);
                    new BlurTask((Activity) this, findViewById(16908290), BadgeType.MESSAGE_ENABLED_NEW).execute(new Void[0]);
                    AppState.hasMessagingShown = true;
                    AppState.saveState(GossipApplication.a());
                }
            }
        }
    }

    private void a() {
        if (AppState.account != null) {
            if (AppState.account.unread_groups_count < PERMISSION_READ_CONTACTS) {
                this.mGroupBadge.setVisibility(8);
            } else {
                this.mGroupBadge.setVisibility(0);
                this.mGroupUnread.setText(Integer.toString(AppState.account.unread_groups_count));
            }
            if (AppState.account.unread_feed_count < PERMISSION_READ_CONTACTS) {
                this.mFeedBadge.setVisibility(8);
            } else {
                this.mFeedBadge.setVisibility(0);
                this.mFeedUnread.setText(Integer.toString(AppState.account.unread_feed_count));
            }
            if (AppState.account.unread_activity_count < PERMISSION_READ_CONTACTS) {
                this.mActivityBadge.setVisibility(8);
            } else {
                this.mActivityBadge.setVisibility(0);
                this.mActivityUnread.setText(Integer.toString(AppState.account.unread_activity_count));
            }
            if (AppState.config.getBoolean("messaging_turned_on", true) && this.mMessagesBadge != null && this.mMessagesUnread != null) {
                if (AppState.account.unread_message_count < PERMISSION_READ_CONTACTS) {
                    this.mMessagesBadge.setVisibility(8);
                    return;
                }
                this.mMessagesBadge.setVisibility(0);
                this.mMessagesUnread.setText(Integer.toString(AppState.account.unread_message_count));
            }
        }
    }

    protected void onResume() {
        IntentFilter filter = new IntentFilter("com.becandid.candid.GOT_PUSH");
        filter.setPriority(2);
        registerReceiver(this.b, filter);
        Uri data = getIntent().getData();
        if (!(data == null || data.getPathSegments() == null || data.getPathSegments().isEmpty())) {
            setTab((String) data.getPathSegments().get(0));
        }
        View currTab = (View) this.d.get(this.currentTab);
        if (currTab != null && (currTab instanceof TabView)) {
            ((TabView) currTab).b();
        }
        a();
        ie.a().h().b(Schedulers.io()).a(apn.a()).b(new apj<NetworkData>(this) {
            final /* synthetic */ MainTabsActivity a;

            {
                this.a = this$0;
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
            }

            public void onNext(NetworkData networkData) {
                if (networkData != null) {
                    try {
                        AppState.account.unread_message_count = networkData.new_threads + networkData.new_requests;
                        this.a.a();
                    } catch (Exception e) {
                        rb.a(e);
                    }
                }
            }
        });
        super.onResume();
        this.f.postDelayed(this.h, 60000);
    }

    protected void onPause() {
        super.onPause();
        try {
            unregisterReceiver(this.b);
        } catch (IllegalArgumentException e) {
            rb.a(e);
        }
        View currTab = (View) this.d.get(this.currentTab);
        if (currTab != null && (currTab instanceof TabView)) {
            ((TabView) currTab).a();
        }
        this.f.removeCallbacks(this.h);
    }

    protected void onDestroy() {
        super.onDestroy();
        AppState.mainTabsActivity = null;
    }

    private void a(TabView tab) {
        tab.a(this);
        this.e.addView(tab, 0);
        tab.setVisibility(8);
        this.d.add(tab);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d("MTA", "onActivityResult");
        if (this.currentTab >= 0 && this.currentTab < this.d.size()) {
            View tab = (View) this.d.get(this.currentTab);
            if (tab instanceof TabView) {
                ((TabView) tab).a(requestCode, resultCode, data);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CREATE_POST_REQUEST && resultCode == -1 && this.currentTab != 0) {
            setTab(0);
        }
        if (requestCode == CREATE_GROUP && resultCode == -1 && data != null) {
            Group group = (Group) data.getSerializableExtra("group");
            if (group == null) {
                rb.a(new Throwable("Group is NULL after creating a Group"));
                return;
            }
            Intent intent = new Intent(this, GroupDetailsActivity.class);
            intent.putExtra("group_id", group.group_id);
            intent.putExtra("group_json", DataUtil.toJson(group));
            startActivity(intent);
        }
        if (requestCode == BaseActivity.UPSELL_FEED && resultCode == -1) {
            iq.a().a(new ih$ap());
        }
        if (requestCode == 999 && resultCode == -1) {
            this.e.setAlpha(1.0f);
        }
    }

    public void onClick(View v) {
        if (!this.mIsShowingMessagingPopup) {
            a(v);
        }
    }

    private void a(View v) {
        int i = 0;
        while (i < tabIds.length) {
            if (tabIds[i] == v.getId()) {
                if (i == ME_TAB || i == ACTIVITY_TAB) {
                    this.mActivityBadge.setVisibility(8);
                    AppState.account.unread_activity_count = 0;
                    if (AppState.config.getBoolean("messaging_turned_on", true)) {
                        this.meTab.f();
                    }
                } else if (i == FEED_TAB) {
                    this.mFeedBadge.setVisibility(8);
                    AppState.account.unread_feed_count = 0;
                } else if (i == GROUPS_TAB) {
                    this.mGroupBadge.setVisibility(8);
                    AppState.account.unread_groups_count = 0;
                } else if (i == MESSAGES_TAB && !AppState.hasMessagingShown) {
                    setShowMessagingPopup(true);
                }
                setTab(i);
                return;
            }
            i += PERMISSION_READ_CONTACTS;
        }
    }

    public void clearNotifications() {
        this.mActivityBadge.setVisibility(8);
    }

    public void setTab(String name) {
        setTab(tabNames.indexOf(name));
    }

    public void setTab(int idx) {
        if (idx < 0 || idx >= tabIds.length) {
            rb.a(new Exception("Maintab id is out of range"));
            return;
        }
        for (int i = 0; i < tabIds.length; i += PERMISSION_READ_CONTACTS) {
            if (!((String) tabNames.get(i)).equals("post")) {
                Button tabs = (Button) findViewById(tabIds[i]);
                tabs.setCompoundDrawablesWithIntrinsicBounds(0, getResources().getIdentifier(((String) tabNames.get(i)) + "_tab", "drawable", getPackageName()), 0, 0);
                tabs.setTextColor(getResources().getColor(17170444));
            }
            findViewById(tabIds[i]).setAlpha(0.5f);
        }
        if (!((String) tabNames.get(idx)).equals("post")) {
            Button curr = (Button) findViewById(tabIds[idx]);
            curr.setCompoundDrawablesWithIntrinsicBounds(0, getResources().getIdentifier(((String) tabNames.get(idx)) + "_tab_orange", "drawable", getPackageName()), 0, 0);
            curr.setTextColor(getResources().getColor(2131558476));
        }
        findViewById(tabIds[idx]).setAlpha(1.0f);
        if (idx == this.currentTab) {
            View tab = (View) this.d.get(this.currentTab);
            if (tab instanceof TabView) {
                ((TabView) tab).c();
                return;
            }
            return;
        }
        if (this.currentTab >= 0) {
            View oldTab = (View) this.d.get(this.currentTab);
            if (oldTab instanceof TabView) {
                ((TabView) oldTab).a();
            }
            oldTab.setVisibility(8);
        }
        View newTab = (View) this.d.get(idx);
        if (newTab instanceof TabView) {
            ((TabView) newTab).b();
            if (newTab instanceof MessagesTab) {
                iq.a().a(new ih$u());
            }
        }
        newTab.setVisibility(0);
        this.currentTab = idx;
    }

    public void createPost(View v) {
        if (!this.mIsShowingMessagingPopup) {
            startActivityForResult(new Intent(this, CreatePostActivity.class), CREATE_POST_REQUEST);
        }
    }

    private boolean b() {
        wv apiAvailability = wv.a();
        int resultCode = apiAvailability.a((Context) this);
        if (resultCode == 0) {
            return true;
        }
        if (apiAvailability.a(resultCode)) {
            apiAvailability.a((Activity) this, resultCode, 9000).show();
        } else {
            finish();
        }
        return false;
    }

    public static void disownAccount(final Context context) {
        ie.a().a(true).b(Schedulers.io()).a(apn.a()).b(new apj<NetworkData>() {
            public void onCompleted() {
            }

            public void onError(Throwable e) {
                Toast.makeText(context, "Unable to disown account, please try again.", MainTabsActivity.PERMISSION_READ_CONTACTS).show();
            }

            public void onNext(NetworkData networkData) {
                if (networkData.success) {
                    AppState.disownAccount();
                    Intent i = GossipApplication.a().getBaseContext().getPackageManager().getLaunchIntentForPackage(GossipApplication.a().getPackageName());
                    i.addFlags(32768);
                    i.addFlags(268435456);
                    context.startActivity(i);
                }
            }
        });
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PERMISSION_READ_CONTACTS /*1*/:
                if (grantResults.length <= 0 || grantResults[0] != 0) {
                    this.meTab = (MeTab) this.d.get(tabNames.indexOf("me"));
                    this.meTab.j();
                    return;
                }
                this.meTab = (MeTab) this.d.get(tabNames.indexOf("me"));
                this.meTab.i();
                return;
            default:
                return;
        }
    }

    public void upsellChange(int upsellId) {
        super.upsellChange(upsellId);
        this.feedTab.a(upsellId);
    }

    public void setShowMessagingPopup(boolean value) {
        this.mIsShowingMessagingPopup = value;
    }
}
