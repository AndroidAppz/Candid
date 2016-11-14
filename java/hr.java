/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.support.v4.app.Fragment
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$Adapter
 *  android.support.v7.widget.RecyclerView$LayoutManager
 *  android.support.v7.widget.RecyclerView$OnItemTouchListener
 *  android.support.v7.widget.RecyclerView$OnScrollListener
 *  android.support.v7.widget.StaggeredGridLayoutManager
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  java.io.Serializable
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.List
 *  rx.schedulers.Schedulers
 */
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.becandid.candid.activities.GroupDetailsActivity;
import com.becandid.candid.activities.GroupMeSearchActivity;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.DataUtil;
import com.becandid.candid.data.Group;
import com.becandid.candid.models.NetworkData;
import java.io.Serializable;
import java.util.List;
import rx.schedulers.Schedulers;

public class hr
extends Fragment {
    private View a;
    private RecyclerView b;
    private hm c;
    private apk d;

    public apk a() {
        return ie.a().i(0).b(Schedulers.io()).a(apn.a()).b(new apj<NetworkData>(){

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            public void a(NetworkData networkData) {
                if (!networkData.success) return;
                if (networkData.groups != null) {
                    hr.this.c.a(networkData.groups);
                }
                if (networkData.next_page != 0) {
                    hr.this.c.a(String.valueOf((int)networkData.next_page));
                    return;
                }
                hr.this.c.a((String)null);
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

    public void a(int n2) {
        if (this.c == null) {
            return;
        }
        this.c.c(n2);
    }

    public void a(Group group) {
        if (this.c == null) {
            return;
        }
        this.c.a(group);
    }

    public void b() {
        if (this.c != null) {
            this.d = this.a();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.a = layoutInflater.inflate(2130968671, viewGroup, false);
        this.b = (RecyclerView)this.a.findViewById(2131624439);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, 1);
        this.b.setLayoutManager((RecyclerView.LayoutManager)staggeredGridLayoutManager);
        this.c = new hm(this.getContext());
        this.b.setAdapter((RecyclerView.Adapter)this.c);
        this.b.addOnItemTouchListener((RecyclerView.OnItemTouchListener)new io(this.getContext()){

            @Override
            public void onItemClick(View view, int n2) {
                Intent intent = new Intent(hr.this.getContext(), (Class)GroupDetailsActivity.class);
                Group group = hr.this.c.b(n2);
                if (group == null) {
                    return;
                }
                intent.putExtra("group_id", group.group_id);
                intent.putExtra("group_name", group.group_name);
                intent.putExtra("group_image", group.imageUrl());
                intent.putExtra("group_json", DataUtil.toJson(group));
                hr.this.getContext().startActivity(intent);
            }
        });
        this.b.addOnScrollListener((RecyclerView.OnScrollListener)new hl(staggeredGridLayoutManager, this.c){

            @Override
            public void onLoadMore(String string2) {
                if (string2 != null) {
                    ie.a().i(Integer.parseInt((String)string2)).b(Schedulers.io()).a(apn.a()).b(new apj<NetworkData>(){

                        public void a(NetworkData networkData) {
                            if (networkData == null || networkData.groups == null || networkData.groups.isEmpty()) {
                                hr.this.c.a((String)null);
                                return;
                            }
                            hr.this.c.b(networkData.groups);
                            if (networkData.next_page != 0) {
                                hr.this.c.a(String.valueOf((int)networkData.next_page));
                                return;
                            }
                            hr.this.c.a((String)null);
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
        this.a.findViewById(2131624465).setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                Intent intent = new Intent(hr.this.getContext(), (Class)GroupMeSearchActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("groups", (Serializable)AppState.groups);
                intent.putExtras(bundle);
                hr.this.getContext().startActivity(intent);
            }
        });
        this.d = this.a();
        return this.a;
    }

}

