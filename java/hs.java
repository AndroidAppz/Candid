/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
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
 *  android.util.Log
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.List
 *  rx.schedulers.Schedulers
 */
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.becandid.candid.activities.BaseActivity;
import com.becandid.candid.data.Post;
import com.becandid.candid.models.NetworkData;
import java.util.List;
import rx.schedulers.Schedulers;

public class hs
extends Fragment {
    private View a;
    private RecyclerView b;
    private hf c;
    private View d;
    private SwipeRefreshLayout e;
    private apk f;

    public apk a() {
        return ie.a().g(0).b(Schedulers.io()).a(apn.a()).b(new apj<NetworkData>(){

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            public void a(NetworkData networkData) {
                if (!networkData.success) return;
                if (networkData.posts != null) {
                    hs.this.c.a(networkData.posts);
                }
                if (networkData.next_page != 0) {
                    hs.this.c.a(String.valueOf((int)networkData.next_page));
                    return;
                }
                hs.this.c.a((String)null);
            }

            /*
             * Enabled aggressive block sorting
             */
            @Override
            public void onCompleted() {
                hs.this.e.setRefreshing(false);
                View view = hs.this.d;
                int n2 = hs.this.c.getItemCount();
                int n3 = 0;
                if (n2 != 0) {
                    n3 = 8;
                }
                view.setVisibility(n3);
            }

            /*
             * Enabled aggressive block sorting
             */
            @Override
            public void onError(Throwable throwable) {
                rb.a(throwable);
                Log.d((String)"GetMyHistory", (String)throwable.toString());
                hs.this.e.setRefreshing(false);
                View view = hs.this.d;
                int n2 = hs.this.c.getItemCount();
                int n3 = 0;
                if (n2 != 0) {
                    n3 = 8;
                }
                view.setVisibility(n3);
            }

            @Override
            public /* synthetic */ void onNext(Object object) {
                this.a((NetworkData)object);
            }
        });
    }

    public void b() {
        if (this.c != null) {
            this.f = this.a();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.a = layoutInflater.inflate(2130968672, viewGroup, false);
        this.d = this.a.findViewById(2131624443);
        this.b = (RecyclerView)this.a.findViewById(2131624442);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext());
        this.b.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
        this.c = new hf((BaseActivity)this.getActivity());
        this.b.setAdapter((RecyclerView.Adapter)this.c);
        this.b.addOnScrollListener((RecyclerView.OnScrollListener)new hl(linearLayoutManager, this.c){

            @Override
            public void onLoadMore(String string2) {
                if (string2 != null) {
                    ie.a().g(Integer.parseInt((String)string2)).b(Schedulers.io()).a(apn.a()).b(new apj<NetworkData>(){

                        public void a(NetworkData networkData) {
                            if (networkData == null || networkData.posts == null || networkData.posts.isEmpty()) {
                                hs.this.c.a((String)null);
                                return;
                            }
                            hs.this.c.b(networkData.posts);
                            if (networkData.next_page != 0) {
                                hs.this.c.a(String.valueOf((int)networkData.next_page));
                                return;
                            }
                            hs.this.c.a((String)null);
                        }

                        @Override
                        public void onCompleted() {
                        }

                        @Override
                        public void onError(Throwable throwable) {
                        }

                        @Override
                        public /* synthetic */ void onNext(Object object) {
                            this.a((NetworkData)object);
                        }
                    });
                }
            }

        });
        RecyclerView.ItemAnimator itemAnimator = this.b.getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator)itemAnimator).setSupportsChangeAnimations(false);
        }
        this.e = (SwipeRefreshLayout)this.a.findViewById(2131624441);
        this.e.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){

            public void onRefresh() {
                hs.this.f = hs.this.a();
            }
        });
        this.f = this.a();
        return this.a;
    }

}

