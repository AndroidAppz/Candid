package com.becandid.candid.views;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.a;
import android.support.design.widget.TabLayout.d;
import android.util.Log;
import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.becandid.candid.activities.GroupDetailsActivity;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.Group;
import com.becandid.candid.models.NetworkData;
import com.becandid.candid.views.GroupStackView.c;
import defpackage.apj;
import defpackage.apn;
import defpackage.ie;
import defpackage.rb;
import rx.schedulers.Schedulers;

public class GroupsTab extends TabView implements c {
    private Context a;
    private long e = 0;
    @BindView(2131624476)
    GroupStackView groupStackView;
    @BindView(2131624482)
    View loading;
    @BindView(2131624475)
    TabLayout tabBar;

    public GroupsTab(Context context) {
        super(context);
        this.a = context;
    }

    public void a(Activity activity) {
        super.a(activity);
        setContentView(2130968684);
        ButterKnife.bind(this);
        this.groupStackView.setListener(this);
        this.tabBar.setSelectedTabIndicatorColor(getResources().getColor(2131558476));
        this.tabBar.setTabTextColors(Color.parseColor("#888888"), getResources().getColor(2131558476));
        this.tabBar.a(this.tabBar.a().a("For You"));
        this.tabBar.a(this.tabBar.a().a("Discover"));
        this.tabBar.setOnTabSelectedListener(new a(this) {
            final /* synthetic */ GroupsTab a;

            {
                this.a = this$0;
            }

            public void a(d tab) {
                this.a.a(true);
            }

            public void b(d tab) {
            }

            public void c(d tab) {
                this.a.c();
            }
        });
    }

    public void b() {
        super.b();
        if (this.tabBar.getSelectedTabPosition() == 1) {
            this.tabBar.a(0).e();
        }
        a(true);
    }

    private void a(final boolean fullLoad) {
        boolean forYou = false;
        if (fullLoad) {
            this.groupStackView.setVisibility(8);
            findViewById(2131624477).setVisibility(8);
            findViewById(2131624481).setVisibility(8);
            this.loading.setVisibility(0);
        }
        if (this.tabBar.getSelectedTabPosition() == 0) {
            forYou = true;
        }
        ie.a().a(AppState.fbInfo, forYou).b(Schedulers.io()).a(apn.a()).b(new apj<NetworkData>(this) {
            final /* synthetic */ GroupsTab c;

            public /* synthetic */ void onNext(Object obj) {
                a((NetworkData) obj);
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
                rb.a(e);
                Log.d("GroupsTab", e.toString());
                this.c.loading.setVisibility(8);
            }

            public void a(NetworkData networkData) {
                boolean z;
                boolean z2 = forYou;
                if (this.c.tabBar.getSelectedTabPosition() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z2 == z) {
                    this.c.loading.setVisibility(8);
                    if (networkData != null && networkData.groups != null) {
                        if ((!fullLoad && this.c.groupStackView.a() != 0) || networkData.groups.size() != 0) {
                            this.c.groupStackView.setVisibility(0);
                        } else if (forYou) {
                            this.c.findViewById(2131624477).setVisibility(0);
                        } else {
                            this.c.findViewById(2131624481).setVisibility(0);
                        }
                        this.c.groupStackView.setGroups(networkData.groups);
                    }
                }
            }
        });
    }

    public void onJoinGroup(Group group) {
    }

    public void onSkipGroup(Group group) {
    }

    public void onTouchEvent(Group group) {
        long thisTime = System.currentTimeMillis();
        if (thisTime - this.e < 250) {
            Intent intent = new Intent(this.a, GroupDetailsActivity.class);
            intent.putExtra("group_id", group.group_id);
            this.a.startActivity(intent);
            return;
        }
        this.e = thisTime;
    }

    public void onEmptyGroups() {
        this.groupStackView.setVisibility(8);
        if (this.tabBar.getSelectedTabPosition() == 0) {
            findViewById(2131624477).setVisibility(0);
        } else {
            findViewById(2131624481).setVisibility(0);
        }
    }

    public void c() {
        super.c();
        a(true);
        this.c = false;
    }
}
