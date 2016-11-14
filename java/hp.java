/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.support.v4.app.Fragment
 *  android.support.v4.app.FragmentActivity
 *  android.support.v4.widget.SwipeRefreshLayout
 *  android.support.v4.widget.SwipeRefreshLayout$OnRefreshListener
 *  android.support.v7.widget.LinearLayoutManager
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$Adapter
 *  android.support.v7.widget.RecyclerView$ItemAnimator
 *  android.support.v7.widget.RecyclerView$LayoutManager
 *  android.support.v7.widget.RecyclerView$OnScrollListener
 *  android.support.v7.widget.SimpleItemAnimator
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.HashSet
 *  java.util.List
 *  rx.schedulers.Schedulers
 */
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.becandid.candid.activities.BaseActivity;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.Config;
import com.becandid.candid.data.Post;
import com.becandid.candid.data.User;
import java.util.HashSet;
import java.util.List;
import rx.schedulers.Schedulers;

public class hp
extends Fragment {
    private View a;
    private hf b;
    private String c;
    private apk d;
    private RecyclerView e;
    private SwipeRefreshLayout f;
    private View g;
    private Handler h;
    private final int i = 60000;
    private long j;
    private Runnable k;

    public hp() {
        this.k = new Runnable(){

            public void run() {
                ie.a().c(hp.this.c, null, hp.this.b.b(hp.this.c)).b(Schedulers.io()).a(apn.a()).b(new apj<List<Post>>(){

                    public void a(List<Post> list) {
                        for (Post post : list) {
                            int n2 = hp.this.b.b(post);
                            if (n2 == -1 || AppState.expandedPostIds.contains((Object)post.post_id)) continue;
                            hp.this.b.a(n2, post);
                        }
                    }

                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        rb.a(throwable);
                    }

                    @Override
                    public /* synthetic */ void onNext(Object object) {
                        this.a((List)object);
                    }
                });
                hp.this.h.postDelayed(hp.this.k, 60000);
            }

        };
    }

    private apk a(String string2) {
        if (this.b == null) {
            rb.a((Throwable)new Exception("Feed Adapter is NULL"));
            return null;
        }
        return ie.a().c(string2, null, this.b.b(string2)).b(Schedulers.io()).a(apn.a()).b(super.c());
    }

    private void a(ih.k k2) {
        try {
            Post post = k2.a;
            this.b.a(post);
            this.e.smoothScrollToPosition(0);
            return;
        }
        catch (Exception var2_3) {
            rb.a((Throwable)var2_3);
            return;
        }
    }

    private apj c() {
        return new apj<List<Post>>(){

            /*
             * Enabled aggressive block sorting
             */
            public void a(List<Post> list) {
                if (list == null || list.isEmpty() || list.size() == 1 && !(list.get(0) instanceof Post)) {
                    return;
                }
                hp.this.b.a(list);
                hp.this.b.a(Integer.toString((int)((Post)list.get((int)(-1 + list.size()))).post_id));
            }

            @Override
            public void onCompleted() {
                hp.this.e.scrollToPosition(0);
                hp.this.e.setVisibility(0);
                hp.this.g.setVisibility(8);
                hp.this.f.setRefreshing(false);
            }

            @Override
            public void onError(Throwable throwable) {
                hp.this.g.setVisibility(8);
                hp.this.f.setRefreshing(false);
            }

            @Override
            public /* synthetic */ void onNext(Object object) {
                this.a((List)object);
            }
        };
    }

    public void a() {
        this.h.postDelayed(this.k, 60000);
        if (AppState.account != null && AppState.account.unread_feed_count > 0) {
            this.d = this.a(this.c);
        }
    }

    public void a(int n2) {
        this.b.b(n2);
    }

    public void b() {
        AppState.expandedPostIds.clear();
        if (this.e != null) {
            this.e.setVisibility(8);
        }
        if (this.g != null) {
            this.g.setVisibility(0);
        }
        if (this.d != null) {
            this.d.unsubscribe();
        }
        this.d = this.a(this.c);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle bundle2 = this.getArguments();
        if (bundle2.containsKey("feed_type")) {
            this.c = bundle2.getString("feed_type");
        }
        this.h = new Handler(Looper.getMainLooper());
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.a = layoutInflater.inflate(2130968662, viewGroup, false);
        this.g = this.a.findViewById(2131624185);
        this.e = (RecyclerView)this.a.findViewById(2131624391);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext());
        this.e.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
        this.b = new hf((BaseActivity)this.getContext());
        this.e.setAdapter((RecyclerView.Adapter)this.b);
        RecyclerView.ItemAnimator itemAnimator = this.e.getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator)itemAnimator).setSupportsChangeAnimations(false);
        }
        this.e.addOnScrollListener((RecyclerView.OnScrollListener)new hl(linearLayoutManager, this.b){

            @Override
            public void onLoadMore(String string2) {
                if (string2 != null) {
                    ie.a().c(hp.this.c, string2, hp.this.b.b(hp.this.c)).b(Schedulers.io()).a(apn.a()).b(new apj<List<Post>>(){

                        /*
                         * Enabled aggressive block sorting
                         */
                        public void a(List<Post> list) {
                            if (list == null || list.isEmpty()) {
                                hp.this.b.a((String)null);
                                return;
                            } else {
                                if (list.size() == 1 && !(list.get(0) instanceof Post)) return;
                                {
                                    hp.this.b.b(list);
                                    hp.this.b.a(Integer.toString((int)((Post)list.get((int)(-1 + list.size()))).post_id));
                                    return;
                                }
                            }
                        }

                        @Override
                        public void onCompleted() {
                        }

                        @Override
                        public void onError(Throwable throwable) {
                        }

                        @Override
                        public /* synthetic */ void onNext(Object object) {
                            this.a((List)object);
                        }
                    });
                }
            }

        });
        this.f = (SwipeRefreshLayout)this.a.findViewById(2131624163);
        this.f.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){

            public void onRefresh() {
                hp.this.b();
            }
        });
        this.d = super.a(this.c);
        ((BaseActivity)this.getActivity()).addToSubscriptionList(this.d);
        apk apk2 = iq.a().a(ih.k.class, new apj<ih.k>(){

            public void a(ih.k k2) {
                if (hp.this.c.equals((Object)"home")) {
                    hp.this.a(k2);
                }
            }

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                rb.a(throwable);
            }

            @Override
            public /* synthetic */ void onNext(Object object) {
                this.a((ih.k)object);
            }
        });
        ((BaseActivity)this.getActivity()).addToSubscriptionList(apk2);
        apk apk3 = iq.a().a(ih.p.class, new apj<ih.p>(){

            public void a(ih.p p2) {
                int n2 = hp.this.b.c(p2.b);
                if (n2 == -1) {
                    return;
                }
                int n3 = hp.this.b.getItemCount();
                for (int i2 = n2; i2 < n3; ++i2) {
                    if (hp.a((hp)hp.this).e((int)i2).group_id != p2.a) continue;
                    hp.this.b.b(hp.this.b.d(i2));
                    --i2;
                    --n3;
                }
                hp.this.b.notifyDataSetChanged();
            }

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                rb.a(throwable);
            }

            @Override
            public /* synthetic */ void onNext(Object object) {
                this.a((ih.p)object);
            }
        });
        ((BaseActivity)this.getActivity()).addToSubscriptionList(apk3);
        apk apk4 = iq.a().a(ih.n.class, new apj<ih.n>(){

            public void a(ih.n n2) {
                hp.this.b.notifyDataSetChanged();
            }

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                rb.a(throwable);
            }

            @Override
            public /* synthetic */ void onNext(Object object) {
                this.a((ih.n)object);
            }
        });
        ((BaseActivity)this.getActivity()).addToSubscriptionList(apk4);
        apk apk5 = iq.a().a(ih.o.class, new apj<ih.o>(){

            public void a(ih.o o2) {
                hp.this.b();
            }

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                rb.a(throwable);
            }

            @Override
            public /* synthetic */ void onNext(Object object) {
                this.a((ih.o)object);
            }
        });
        ((BaseActivity)this.getActivity()).addToSubscriptionList(apk5);
        return this.a;
    }

    public void onPause() {
        super.onPause();
        this.h.removeCallbacks(this.k);
        this.j = System.currentTimeMillis();
    }

    public void onResume() {
        super.onResume();
        if (this.j != 0 && (System.currentTimeMillis() - this.j) / 60000 > (long)AppState.config.getInt("refresh_timeout", 5)) {
            this.b();
            return;
        }
        this.a();
    }

}

