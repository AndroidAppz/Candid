/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.support.v4.app.Fragment
 *  android.support.v4.widget.SwipeRefreshLayout
 *  android.support.v4.widget.SwipeRefreshLayout$OnRefreshListener
 *  android.support.v7.widget.LinearLayoutManager
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$Adapter
 *  android.support.v7.widget.RecyclerView$LayoutManager
 *  android.support.v7.widget.RecyclerView$OnItemTouchListener
 *  android.support.v7.widget.RecyclerView$OnScrollListener
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.Toast
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.List
 *  rx.schedulers.Schedulers
 */
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.becandid.candid.activities.GroupDetailsActivity;
import com.becandid.candid.activities.PostDetailsActivity;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.EmptyClass;
import com.becandid.candid.data.Notification;
import com.becandid.candid.data.User;
import com.becandid.candid.models.EmptySubscriber;
import com.becandid.candid.models.NetworkData;
import java.util.List;
import rx.schedulers.Schedulers;

public class hq
extends Fragment {
    private View a;
    private RecyclerView b;
    private hb c;
    private SwipeRefreshLayout d;
    private View e;
    private apk f;
    private long g;

    private apk b(boolean bl2) {
        this.g = System.currentTimeMillis();
        return ie.a().b(Boolean.toString((boolean)bl2), null).b(Schedulers.io()).a(apn.a()).b(new apj<NetworkData>(){

            public void a(NetworkData networkData) {
                if (networkData.success) {
                    if (networkData.activity != null) {
                        hq.this.c.a(networkData.activity);
                    }
                    hq.this.c.a(networkData.last_activity_id);
                    if (networkData.unread_count > -1) {
                        AppState.account.unread_activity_count = networkData.unread_count;
                        iq.a().a(new ih.an(3, networkData.unread_count, true));
                    }
                    if (networkData.unread_groups_count > -1) {
                        AppState.account.unread_groups_count = networkData.unread_groups_count;
                        iq.a().a(new ih.an(1, networkData.unread_groups_count, true));
                    }
                }
            }

            /*
             * Enabled aggressive block sorting
             */
            @Override
            public void onCompleted() {
                hq.this.d.setRefreshing(false);
                View view = hq.this.e;
                int n2 = hq.this.c.getItemCount();
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
                hq.this.d.setRefreshing(false);
                View view = hq.this.e;
                int n2 = hq.this.c.getItemCount();
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

    public void a(boolean bl2) {
        if (this.c != null) {
            this.f = super.b(bl2);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.a = layoutInflater.inflate(2130968670, viewGroup, false);
        this.e = this.a.findViewById(2131624280);
        this.d = (SwipeRefreshLayout)this.a.findViewById(2131624278);
        this.d.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){

            public void onRefresh() {
                if (hq.this.f != null) {
                    hq.this.f.unsubscribe();
                }
                hq.this.f = hq.this.b(true);
            }
        });
        this.b = (RecyclerView)this.a.findViewById(2131624279);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext());
        this.b.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
        this.c = new hb(this.getContext());
        this.b.setAdapter((RecyclerView.Adapter)this.c);
        this.b.addOnItemTouchListener((RecyclerView.OnItemTouchListener)new io(this.getContext()){

            /*
             * Unable to fully structure code
             * Enabled aggressive block sorting
             * Lifted jumps to return sites
             */
            @Override
            public void onItemClick(View var1, int var2_2) {
                if (var2_2 < 0 || var2_2 >= hq.b(hq.this).e().size()) {
                    Toast.makeText((Context)hq.this.getContext(), (CharSequence)"Unable to find that notification", (int)0).show();
                    return;
                }
                var3_3 = (Notification)hq.b(hq.this).e().get(var2_2);
                var3_3.unread = 0;
                hq.b(hq.this).notifyItemChanged(var2_2);
                ie.a().a(var3_3.activity_id).b(Schedulers.io()).a(apn.a()).b(new EmptySubscriber());
                AppState.account.unread_activity_count = 0;
                var5_4 = var3_3.onclick.split(":");
                var6_5 = Integer.valueOf((String)var5_4[1]);
                var7_6 = var5_4[0];
                switch (var7_6.hashCode()) {
                    case -338943683: {
                        if (!var7_6.equals((Object)"showPost")) ** GOTO lbl25
                        var8_7 = 0;
                        ** GOTO lbl32
                    }
                    case -1572993592: {
                        if (!var7_6.equals((Object)"showPostBottom")) ** GOTO lbl25
                        var8_7 = 1;
                        ** GOTO lbl32
                    }
                    case -1925545598: {
                        if (!var7_6.equals((Object)"showGroup")) ** GOTO lbl25
                        var8_7 = 2;
                        ** GOTO lbl32
                    }
lbl25: // 4 sources:
                    default: {
                        ** GOTO lbl-1000
                    }
                    case 2067279704: 
                }
                if (var7_6.equals((Object)"showTab")) {
                    var8_7 = 3;
                } else lbl-1000: // 2 sources:
                {
                    var8_7 = -1;
                }
lbl32: // 5 sources:
                switch (var8_7) {
                    default: {
                        return;
                    }
                    case 0: {
                        var15_8 = new Intent(hq.this.getContext(), (Class)PostDetailsActivity.class);
                        var15_8.putExtra("post_id", var6_5);
                        if (var3_3.comment_id > 0) {
                            var15_8.putExtra("comment_id", var3_3.comment_id);
                            var15_8.putExtra("scrollToBottom", true);
                        }
                        hq.this.getContext().startActivity(var15_8);
                        return;
                    }
                    case 1: {
                        var11_9 = new Intent(hq.this.getContext(), (Class)PostDetailsActivity.class);
                        var11_9.putExtra("post_id", var6_5);
                        var11_9.putExtra("comment_id", var3_3.comment_id);
                        var11_9.putExtra("scrollToBottom", true);
                        hq.this.getContext().startActivity(var11_9);
                        return;
                    }
                    case 2: {
                        var9_10 = new Intent(hq.this.getContext(), (Class)GroupDetailsActivity.class);
                        var9_10.putExtra("group_id", var6_5);
                        hq.this.getContext().startActivity(var9_10);
                        return;
                    }
                    case 3: 
                }
                iq.a().a(new ih.e(var6_5));
            }
        });
        this.b.addOnScrollListener((RecyclerView.OnScrollListener)new hl(linearLayoutManager, this.c){

            @Override
            public void onLoadMore(String string2) {
                if (string2 != null) {
                    ie.a().b(Boolean.toString((boolean)true), string2).b(Schedulers.io()).a(apn.a()).b(new apj<NetworkData>(){

                        public void a(NetworkData networkData) {
                            if (networkData == null || networkData.activity == null || networkData.activity.isEmpty()) {
                                hq.this.c.a((String)null);
                                return;
                            }
                            hq.this.c.b(networkData.activity);
                            hq.this.c.a(String.valueOf((int)networkData.last_activity_id));
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
        this.f = super.b(true);
        return this.a;
    }

    public void onResume() {
        super.onResume();
        if (AppState.account != null && AppState.account.unread_activity_count > 0) {
            this.f = this.b(false);
        }
        aom.a(this.getContext());
    }

}

