package com.becandid.candid.views;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.becandid.candid.activities.NotificationSettingsActivity;
import com.becandid.candid.data.AppState;
import com.becandid.candid.models.NetworkData;
import defpackage.aom;
import defpackage.apj;
import defpackage.apk;
import defpackage.apn;
import defpackage.hb;
import defpackage.hl;
import defpackage.ie;
import defpackage.ih$an;
import defpackage.io;
import defpackage.iq;
import rx.schedulers.Schedulers;

public class ActivityTab extends TabView implements OnClickListener {
    private hb a;
    private Context e;
    private apk f;
    private long g;
    @BindView(2131624280)
    View mEmptyView;
    @BindView(2131624279)
    RecyclerView mRecyclerView;
    @BindView(2131624277)
    View mSettingView;
    @BindView(2131624278)
    SwipeRefreshLayout mSwipeRefresh;

    public ActivityTab(Context context) {
        super(context);
        this.e = context;
    }

    private apj getSubscriber() {
        return new apj<NetworkData>(this) {
            final /* synthetic */ ActivityTab a;

            {
                this.a = this$0;
            }

            public /* synthetic */ void onNext(Object obj) {
                a((NetworkData) obj);
            }

            public void onCompleted() {
                Handler handler = new Handler();
                this.a.mSwipeRefresh.setRefreshing(false);
                this.a.f();
            }

            public void onError(Throwable e) {
                Log.e("ActivityTab", e.toString());
                this.a.mSwipeRefresh.setRefreshing(false);
                this.a.f();
            }

            public void a(NetworkData data) {
                this.a.a.a(data.activity);
                this.a.a.a(String.valueOf(data.last_activity_id));
                iq.a().a(new ih$an(3, data.unread_count, true));
                iq.a().a(new ih$an(1, data.unread_groups_count, true));
            }
        };
    }

    private apk a(boolean markRead) {
        int readInt = 1;
        this.mSwipeRefresh.setRefreshing(true);
        this.g = System.currentTimeMillis();
        if (!markRead) {
            readInt = 0;
        }
        return ie.a().b(Integer.toString(readInt), null).b(Schedulers.io()).a(apn.a()).b(getSubscriber());
    }

    public void a(Activity activity) {
        super.a(activity);
        aom.a(this.e);
        setContentView(2130968626);
        ButterKnife.bind(this);
        this.mSettingView.setOnClickListener(this);
        this.mSwipeRefresh.setColorSchemeColors(new int[]{2131558476});
        this.mSwipeRefresh.setOnRefreshListener(new OnRefreshListener(this) {
            final /* synthetic */ ActivityTab a;

            {
                this.a = this$0;
            }

            public void onRefresh() {
                if (this.a.f != null) {
                    this.a.f.unsubscribe();
                }
                this.a.f = this.a.a(true);
                this.a.a.c();
            }
        });
        LinearLayoutManager llm = new LinearLayoutManager(this.e);
        this.mRecyclerView.setLayoutManager(llm);
        this.mRecyclerView.addOnItemTouchListener(new io(this, this.e) {
            final /* synthetic */ ActivityTab a;

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onItemClick(android.view.View r10, int r11) {
                /*
                r9 = this;
                r6 = 1;
                r4 = 0;
                if (r11 < 0) goto L_0x0014;
            L_0x0004:
                r5 = r9.a;
                r5 = r5.a;
                r5 = r5.e();
                r5 = r5.size();
                if (r11 < r5) goto L_0x0024;
            L_0x0014:
                r5 = r9.a;
                r5 = r5.e;
                r6 = "Unable to find that notification";
                r4 = android.widget.Toast.makeText(r5, r6, r4);
                r4.show();
            L_0x0023:
                return;
            L_0x0024:
                r5 = r9.a;
                r5 = r5.a;
                r5 = r5.e();
                r0 = r5.get(r11);
                r0 = (com.becandid.candid.data.Notification) r0;
                r0.unread = r4;
                r5 = r9.a;
                r5 = r5.a;
                r5.notifyItemChanged(r11);
                r5 = defpackage.ie.a();
                r7 = r0.activity_id;
                r5 = r5.a(r7);
                r7 = rx.schedulers.Schedulers.io();
                r5 = r5.b(r7);
                r7 = defpackage.apn.a();
                r5 = r5.a(r7);
                r7 = new com.becandid.candid.models.EmptySubscriber;
                r7.<init>();
                r5.b(r7);
                r5 = r0.onclick;
                r7 = ":";
                r2 = r5.split(r7);
                r5 = r2[r6];
                r5 = java.lang.Integer.valueOf(r5);
                r3 = r5.intValue();
                r7 = r2[r4];
                r5 = -1;
                r8 = r7.hashCode();
                switch(r8) {
                    case -1925545598: goto L_0x00c2;
                    case -1572993592: goto L_0x00b8;
                    case -338943683: goto L_0x00af;
                    case 2067279704: goto L_0x00cc;
                    default: goto L_0x007d;
                };
            L_0x007d:
                r4 = r5;
            L_0x007e:
                switch(r4) {
                    case 0: goto L_0x0082;
                    case 1: goto L_0x00d6;
                    case 2: goto L_0x00ff;
                    case 3: goto L_0x011c;
                    default: goto L_0x0081;
                };
            L_0x0081:
                goto L_0x0023;
            L_0x0082:
                r1 = new android.content.Intent;
                r4 = r9.a;
                r4 = r4.e;
                r5 = com.becandid.candid.activities.PostDetailsActivity.class;
                r1.<init>(r4, r5);
                r4 = "post_id";
                r1.putExtra(r4, r3);
                r4 = r0.comment_id;
                if (r4 <= 0) goto L_0x00a4;
            L_0x0098:
                r4 = "comment_id";
                r5 = r0.comment_id;
                r1.putExtra(r4, r5);
                r4 = "scrollToBottom";
                r1.putExtra(r4, r6);
            L_0x00a4:
                r4 = r9.a;
                r4 = r4.e;
                r4.startActivity(r1);
                goto L_0x0023;
            L_0x00af:
                r8 = "showPost";
                r7 = r7.equals(r8);
                if (r7 == 0) goto L_0x007d;
            L_0x00b7:
                goto L_0x007e;
            L_0x00b8:
                r4 = "showPostBottom";
                r4 = r7.equals(r4);
                if (r4 == 0) goto L_0x007d;
            L_0x00c0:
                r4 = r6;
                goto L_0x007e;
            L_0x00c2:
                r4 = "showGroup";
                r4 = r7.equals(r4);
                if (r4 == 0) goto L_0x007d;
            L_0x00ca:
                r4 = 2;
                goto L_0x007e;
            L_0x00cc:
                r4 = "showTab";
                r4 = r7.equals(r4);
                if (r4 == 0) goto L_0x007d;
            L_0x00d4:
                r4 = 3;
                goto L_0x007e;
            L_0x00d6:
                r1 = new android.content.Intent;
                r4 = r9.a;
                r4 = r4.e;
                r5 = com.becandid.candid.activities.PostDetailsActivity.class;
                r1.<init>(r4, r5);
                r4 = "post_id";
                r1.putExtra(r4, r3);
                r4 = "comment_id";
                r5 = r0.comment_id;
                r1.putExtra(r4, r5);
                r4 = "scrollToBottom";
                r1.putExtra(r4, r6);
                r4 = r9.a;
                r4 = r4.e;
                r4.startActivity(r1);
                goto L_0x0023;
            L_0x00ff:
                r1 = new android.content.Intent;
                r4 = r9.a;
                r4 = r4.e;
                r5 = com.becandid.candid.activities.GroupDetailsActivity.class;
                r1.<init>(r4, r5);
                r4 = "group_id";
                r1.putExtra(r4, r3);
                r4 = r9.a;
                r4 = r4.e;
                r4.startActivity(r1);
                goto L_0x0023;
            L_0x011c:
                r4 = defpackage.iq.a();
                r5 = new ih$e;
                r5.<init>(r3);
                r4.a(r5);
                goto L_0x0023;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.becandid.candid.views.ActivityTab.3.onItemClick(android.view.View, int):void");
            }
        });
        this.a = new hb(this.e);
        this.mRecyclerView.setAdapter(this.a);
        this.mRecyclerView.addOnScrollListener(new hl(this, llm, this.a) {
            final /* synthetic */ ActivityTab a;

            public void onLoadMore(String minPostId) {
                if (minPostId != null) {
                    ie.a().b(Boolean.toString(true), minPostId).b(Schedulers.io()).a(apn.a()).b(new apj<NetworkData>(this) {
                        final /* synthetic */ AnonymousClass4 a;

                        {
                            this.a = this$1;
                        }

                        public /* synthetic */ void onNext(Object obj) {
                            a((NetworkData) obj);
                        }

                        public void onCompleted() {
                        }

                        public void onError(Throwable e) {
                        }

                        public void a(NetworkData data) {
                            if (data == null || data.activity == null || data.activity.isEmpty()) {
                                this.a.a.a.a(null);
                                return;
                            }
                            this.a.a.a.b(data.activity);
                            this.a.a.a.a(String.valueOf(data.last_activity_id));
                        }
                    });
                }
            }
        });
        this.f = a(false);
    }

    public void a() {
        super.a();
    }

    public void b() {
        super.b();
        if (AppState.account != null) {
            this.f = a(true);
        }
        aom.a(this.e);
    }

    public void onClick(View v) {
        if (v.getId() == 2131624277) {
            getContext().startActivity(new Intent(getContext(), NotificationSettingsActivity.class));
        }
    }

    private void f() {
        if (this.a.d()) {
            Log.d("Toggle", "not empty");
            this.mRecyclerView.setVisibility(0);
            this.mEmptyView.setVisibility(8);
            return;
        }
        Log.d("Toggle", "empty");
        this.mRecyclerView.setVisibility(8);
        this.mEmptyView.setVisibility(0);
    }

    public void c() {
        super.c();
        this.mRecyclerView.scrollToPosition(0);
        if (this.f != null) {
            this.f.unsubscribe();
        }
        this.f = a(false);
        this.a.c();
        this.c = false;
    }
}
