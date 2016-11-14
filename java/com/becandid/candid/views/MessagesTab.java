package com.becandid.candid.views;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.a;
import android.support.design.widget.TabLayout.d;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.activities.BaseActivity;
import com.becandid.candid.activities.MainTabsActivity;
import com.becandid.candid.activities.MessageSearchActivity;
import com.becandid.candid.activities.MessageSettingsActivity;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.Message;
import com.becandid.candid.data.MessageThread;
import com.becandid.candid.models.EmptySubscriber;
import com.becandid.candid.models.NetworkData;
import com.becandid.thirdparty.BlurTask;
import com.becandid.thirdparty.BlurTask.BadgeType;
import defpackage.aom;
import defpackage.apj;
import defpackage.apk;
import defpackage.apn;
import defpackage.hn;
import defpackage.hu;
import defpackage.hv;
import defpackage.hw;
import defpackage.ie;
import defpackage.ih$ac;
import defpackage.ih$an;
import defpackage.ih$u;
import defpackage.ih$x;
import defpackage.ih$z;
import defpackage.iq;
import defpackage.rb;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.schedulers.Schedulers;

public class MessagesTab extends TabView {
    private Context a;
    private BaseActivity e;
    private hn f;
    private hu g;
    private hw h;
    private hv i;
    private apk j;
    private Handler k;
    private Runnable l = new Runnable(this) {
        final /* synthetic */ MessagesTab a;

        {
            this.a = this$0;
        }

        public void run() {
        }
    };
    @BindView(2131624513)
    TextView messagesSearch;
    @BindView(2131624514)
    ImageView messagesSettings;
    @BindView(2131624518)
    FrameLayout messagesSpinny;
    @BindView(2131624517)
    TextView messagingDisabled;
    @BindView(2131624515)
    TabLayout tabBar;
    @BindView(2131624516)
    TabViewPager viewPager;

    public MessagesTab(Context context) {
        super(context);
        this.a = context;
        this.k = new Handler(context.getMainLooper());
    }

    public apk getDataSubscription() {
        Map<String, String> params = new HashMap();
        params.put("include_messages", "1");
        return ie.a().o(params).b(Schedulers.io()).a(apn.a()).b(new apj<NetworkData>(this) {
            final /* synthetic */ MessagesTab a;

            {
                this.a = this$0;
            }

            public /* synthetic */ void onNext(Object obj) {
                a((NetworkData) obj);
            }

            public void onCompleted() {
                this.a.c = false;
            }

            public void onError(Throwable e) {
                rb.a(e);
                this.a.c = false;
            }

            public void a(NetworkData networkData) {
                if (networkData.threads != null) {
                    this.a.h.a(networkData.threads);
                    List online = new ArrayList();
                    for (MessageThread thread : networkData.threads) {
                        if (thread.online == 1) {
                            online.add(thread);
                        }
                    }
                    this.a.g.a(online);
                    if (networkData.thread_next_page > 0) {
                        this.a.h.b(Integer.toString(networkData.thread_next_page));
                        this.a.g.b(Integer.toString(networkData.thread_next_page));
                    }
                }
                if (networkData.requests != null) {
                    this.a.i.a(networkData.requests);
                    if (networkData.request_next_page > 0) {
                        this.a.i.b(Integer.toString(networkData.request_next_page));
                    }
                }
                this.a.a(0, networkData.new_threads, networkData.new_requests);
                iq.a().a(new ih$an(2, networkData.new_threads + networkData.new_requests, true));
                this.a.f();
            }
        });
    }

    public void f() {
        this.g.a();
        this.h.a();
        this.i.a();
    }

    public void a(int activeUnread, int threadUnread, int requestUnread) {
        if (this.tabBar != null) {
            int unreadDot;
            int position = this.viewPager.getCurrentItem();
            if (activeUnread <= 0 || position == 0 || position == 1) {
                unreadDot = 0;
            } else {
                unreadDot = 2130838240;
            }
            ((TextView) this.tabBar.a(0).a()).setCompoundDrawablesWithIntrinsicBounds(0, 0, unreadDot, 0);
            if (threadUnread <= 0 || position == 0 || position == 1) {
                unreadDot = 0;
            } else {
                unreadDot = 2130838240;
            }
            ((TextView) this.tabBar.a(1).a()).setCompoundDrawablesWithIntrinsicBounds(0, 0, unreadDot, 0);
            if (requestUnread <= 0 || position == 2) {
                unreadDot = 0;
            } else {
                unreadDot = 2130838240;
            }
            ((TextView) this.tabBar.a(2).a()).setCompoundDrawablesWithIntrinsicBounds(0, 0, unreadDot, 0);
        }
        if (((MainTabsActivity) this.a).currentTab == MainTabsActivity.MESSAGES_TAB) {
            ie.a().g().b(Schedulers.io()).a(apn.a()).b(new EmptySubscriber());
        }
    }

    public void a(Activity activity) {
        super.a(activity);
        this.e = (BaseActivity) activity;
        setContentView(2130968692);
        ButterKnife.bind(this);
        this.messagesSearch.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MessagesTab a;

            {
                this.a = this$0;
            }

            public void onClick(View v) {
                this.a.a.startActivity(new Intent(this.a.a, MessageSearchActivity.class));
            }
        });
        this.messagesSettings.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MessagesTab a;

            {
                this.a = this$0;
            }

            public void onClick(View v) {
                this.a.a.startActivity(new Intent(this.a.a, MessageSettingsActivity.class));
            }
        });
        this.f = new hn(this.e.getSupportFragmentManager());
        this.g = new hu();
        this.h = new hw();
        this.i = new hv();
        this.f.a(this.g, "ACTIVE");
        this.f.a(this.h, "THREADS");
        this.f.a(this.i, "REQUESTS");
        this.viewPager.setAdapter(this.f);
        this.viewPager.setOffscreenPageLimit(2);
        this.viewPager.setCurrTab("messages");
        this.tabBar.setupWithViewPager(this.viewPager);
        for (int i = 0; i < this.tabBar.getTabCount(); i++) {
            TextView tab = (TextView) LayoutInflater.from(this.a).inflate(2130968643, null);
            tab.setText(this.tabBar.a(i).d());
            tab.setCompoundDrawablePadding(0);
            this.tabBar.a(i).a(tab);
        }
        this.tabBar.setSelectedTabIndicatorColor(getResources().getColor(2131558476));
        this.tabBar.setTabTextColors(Color.parseColor("#888888"), getResources().getColor(2131558476));
        this.tabBar.setOnTabSelectedListener(new a(this) {
            final /* synthetic */ MessagesTab a;

            {
                this.a = this$0;
            }

            public void a(d tab) {
                TextView tabView = (TextView) tab.a();
                tabView.setTextColor(this.a.getResources().getColor(2131558476));
                tabView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                this.a.viewPager.setCurrentItem(tab.c(), true);
                if (tab.c() == 0) {
                    tabView = (TextView) this.a.tabBar.a(1).a();
                    tabView.setTextColor(Color.parseColor("#888888"));
                    tabView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                } else if (tab.c() == 1) {
                    tabView = (TextView) this.a.tabBar.a(0).a();
                    tabView.setTextColor(Color.parseColor("#888888"));
                    tabView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                }
            }

            public void b(d tab) {
                TextView tabView = (TextView) tab.a();
                tabView.setTextColor(Color.parseColor("#888888"));
                tabView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                if (tab.c() == 0) {
                    tabView = (TextView) this.a.tabBar.a(1).a();
                    tabView.setTextColor(Color.parseColor("#888888"));
                    tabView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                } else if (tab.c() == 1) {
                    tabView = (TextView) this.a.tabBar.a(0).a();
                    tabView.setTextColor(Color.parseColor("#888888"));
                    tabView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                }
            }

            public void c(d tab) {
                TextView tabView = (TextView) tab.a();
                tabView.setTextColor(this.a.getResources().getColor(2131558476));
                tabView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                this.a.getDataSubscription();
            }
        });
        this.j = getDataSubscription();
        a(AppState.account.messaging_disabled);
        ((BaseActivity) this.a).addToSubscriptionList(iq.a().a(ih$z.class, new apj<ih$z>(this) {
            final /* synthetic */ MessagesTab a;

            {
                this.a = this$0;
            }

            public /* synthetic */ void onNext(Object obj) {
                a((ih$z) obj);
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
                rb.a(e);
            }

            public void a(ih$z messagingDisabled) {
                this.a.a(messagingDisabled.a);
            }
        }));
        ((BaseActivity) this.a).addToSubscriptionList(iq.a().a(ih$x.class, new apj<ih$x>(this) {
            final /* synthetic */ MessagesTab a;

            {
                this.a = this$0;
            }

            public /* synthetic */ void onNext(Object obj) {
                a((ih$x) obj);
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
                rb.a(e);
            }

            public void a(ih$x handleMessageRequest) {
                this.a.j = this.a.getDataSubscription();
            }
        }));
        ((BaseActivity) this.a).addToSubscriptionList(iq.a().a(ih$ac.class, new apj<ih$ac>(this) {
            final /* synthetic */ MessagesTab a;

            {
                this.a = this$0;
            }

            public /* synthetic */ void onNext(Object obj) {
                a((ih$ac) obj);
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
            }

            public void a(final ih$ac newMessage) {
                int request = 1;
                boolean foundActive = this.a.g.a(newMessage);
                boolean foundThread = this.a.h.a(newMessage);
                boolean foundRequest = this.a.i.a(newMessage);
                if (((foundActive | foundThread) | foundRequest) == 0) {
                    Map params = new HashMap();
                    params.put("post_id", Integer.toString(newMessage.b));
                    params.put("post_name", newMessage.d);
                    ie.a().m(params).b(Schedulers.io()).a(apn.a()).b(new apj<NetworkData>(this) {
                        final /* synthetic */ AnonymousClass9 b;

                        public /* synthetic */ void onNext(Object obj) {
                            a((NetworkData) obj);
                        }

                        public void onCompleted() {
                        }

                        public void onError(Throwable e) {
                        }

                        public void a(NetworkData networkData) {
                            if (networkData.success) {
                                MessageThread thread = networkData.thread;
                                thread.unread_messages = 1;
                                ((Message) thread.messages.get(0)).subject = newMessage.c;
                                if (thread.is_request == 1) {
                                    this.b.a.i.a(thread);
                                    this.b.a.a(0, 0, 1);
                                    return;
                                }
                                this.b.a.h.a(thread);
                                if (thread.online == 1) {
                                    this.b.a.g.a(thread);
                                    this.b.a.a(1, 1, 0);
                                    return;
                                }
                                this.b.a.a(0, 1, 0);
                                return;
                            }
                            Toast.makeText(this.b.a.a, networkData.error, 0).show();
                        }
                    });
                    return;
                }
                int active;
                int thread;
                if (foundActive) {
                    active = 1;
                } else {
                    active = 0;
                }
                if (foundThread) {
                    thread = 1;
                } else {
                    thread = 0;
                }
                if (!foundRequest) {
                    request = 0;
                }
                this.a.a(active, thread, request);
            }
        }));
        ((BaseActivity) this.a).addToSubscriptionList(iq.a().a(ih$u.class, new apj<ih$u>(this) {
            final /* synthetic */ MessagesTab a;

            {
                this.a = this$0;
            }

            public /* synthetic */ void onNext(Object obj) {
                a((ih$u) obj);
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
            }

            public void a(ih$u dynamicMessageTabSelection) {
                MessageThread lastActivity = this.a.g.b();
                MessageThread lastRequest = this.a.i.b();
                MessageThread lastThread = this.a.h.b();
                if (lastRequest == null && lastThread == null) {
                    this.a.viewPager.setCurrentItem(1, true);
                } else if (lastRequest != null && lastThread == null) {
                    this.a.viewPager.setCurrentItem(2, true);
                } else if (lastRequest == null && lastThread != null) {
                    this.a.viewPager.setCurrentItem(1, true);
                } else if (lastRequest != null && lastThread != null) {
                    if (lastRequest.unread_messages > 0 && lastThread.unread_messages == 0) {
                        this.a.viewPager.setCurrentItem(2, true);
                    } else if (lastRequest.unread_messages == 0 && lastThread.unread_messages > 0) {
                        this.a.viewPager.setCurrentItem(1, true);
                    } else if (lastRequest.unread_messages <= 0 || lastThread.unread_messages <= 0) {
                        this.a.viewPager.setCurrentItem(1, true);
                    } else if (((Message) lastRequest.messages.get(0)).sent_time > ((Message) lastThread.messages.get(0)).sent_time) {
                        this.a.viewPager.setCurrentItem(2, true);
                    } else {
                        this.a.viewPager.setCurrentItem(1, true);
                    }
                }
            }
        }));
    }

    public void b() {
        super.b();
        aom.a(this.a);
        ie.a().g().b(Schedulers.io()).a(apn.a()).b(new EmptySubscriber());
        iq.a().a(new ih$an(2, 0, true));
        this.j = getDataSubscription();
        final View view = ((Activity) this.a).findViewById(16908290);
        view.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
            final /* synthetic */ MessagesTab b;

            public void onGlobalLayout() {
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                if (AppState.hasMessagingShown) {
                    ((MainTabsActivity) this.b.a).setShowMessagingPopup(false);
                    return;
                }
                new BlurTask((Activity) this.b.a, ((Activity) this.b.a).findViewById(16908290), BadgeType.MESSAGE_ENABLED_TAB).execute(new Void[0]);
                AppState.hasMessagingShown = true;
                AppState.saveState(GossipApplication.a());
            }
        });
    }

    public void a(int disabled) {
        if (disabled == 1) {
            this.viewPager.setVisibility(8);
            this.messagingDisabled.setVisibility(0);
            this.messagesSearch.setEnabled(false);
            this.tabBar.setEnabled(false);
            return;
        }
        this.viewPager.setVisibility(0);
        this.messagingDisabled.setVisibility(8);
        this.messagesSearch.setEnabled(true);
        this.tabBar.setEnabled(true);
    }

    public void c() {
        super.c();
        ((MainTabsActivity) this.a).setShowMessagingPopup(false);
        this.j = getDataSubscription();
    }

    public void d() {
        findViewById(2131624512).setVisibility(0);
    }

    public void e() {
        findViewById(2131624512).setVisibility(8);
    }
}
