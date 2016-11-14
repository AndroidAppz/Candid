package com.becandid.candid.activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu.OnMenuItemClickListener;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.SimpleItemAnimator;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.becandid.candid.activities.InviteContactsActivity.InviteFlowTypes;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.DataUtil;
import com.becandid.candid.data.Group;
import com.becandid.candid.data.Post;
import com.becandid.candid.models.NetworkData;
import com.becandid.candid.util.RoundedCornersTransformation;
import com.becandid.candid.util.RoundedCornersTransformation.CornerType;
import defpackage.apj;
import defpackage.apk;
import defpackage.apn;
import defpackage.hf;
import defpackage.hl;
import defpackage.ie;
import defpackage.ih$k;
import defpackage.ih$o;
import defpackage.ih$r;
import defpackage.ih$t;
import defpackage.iq;
import defpackage.rb;
import defpackage.um$h;
import defpackage.zu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import rx.schedulers.Schedulers;

public class GroupDetailsActivity extends PopupWithBlurBackgroundActivity implements OnMenuItemClickListener {
    public static final int CREATE_POST_REQUEST = 888;
    private int b;
    private Group c;
    private RoundedCornersTransformation d;
    private int e = 0;
    private hf f;
    @BindView(2131624169)
    TextView gdCompose;
    @BindView(2131624167)
    TextView gdHeaderName;
    @BindView(2131624170)
    TextView gdJoin;
    @BindView(2131624166)
    TextView groupEmpty;
    @BindView(2131624165)
    RecyclerView groupPosts;
    @BindView(2131624171)
    LinearLayout loadingSpinny;
    @BindView(2131624163)
    SwipeRefreshLayout mSwipeContainer;

    public static Intent startGroupDetailsActivity(Context context, int groupId) {
        Intent intent = new Intent(context, GroupDetailsActivity.class);
        intent.putExtra("group_id", groupId);
        return intent;
    }

    private apk a() {
        return ie.a().a(this.b, null).b(Schedulers.io()).a(apn.a()).b(new apj<NetworkData>(this) {
            final /* synthetic */ GroupDetailsActivity a;

            {
                this.a = this$0;
            }

            public void onCompleted() {
                this.a.mSwipeContainer.setRefreshing(false);
            }

            public void onError(Throwable e) {
                this.a.loadingSpinny.setVisibility(8);
                this.a.groupPosts.setVisibility(0);
                rb.a(e);
                this.a.mSwipeContainer.setRefreshing(false);
            }

            public void onNext(NetworkData networkData) {
                if (!this.a.isStopped) {
                    if (networkData != null) {
                        this.a.c = networkData.group;
                        this.a.gdHeaderName.setText(this.a.c.group_name);
                        if (networkData.posts != null) {
                            List posts = networkData.posts;
                            this.a.a(posts);
                            this.a.f.a(this.a.c.convertToPost());
                            if (!posts.isEmpty()) {
                                this.a.f.a(Integer.toString(((Post) posts.get(posts.size() - 1)).post_id));
                            }
                        }
                    }
                    this.a.loadingSpinny.setVisibility(8);
                    this.a.groupPosts.setVisibility(0);
                }
            }
        });
    }

    protected void getRxSubscription() {
        this.mSubscription = a();
        addToSubscriptionList(this.mSubscription);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(2130968609);
        ButterKnife.bind(this);
        this.groupPosts.setVisibility(8);
        LayoutManager layoutManager = new LinearLayoutManager(this);
        this.groupPosts.setLayoutManager(layoutManager);
        this.f = new hf(this);
        this.groupPosts.setAdapter(this.f);
        this.loadingSpinny.setVisibility(0);
        this.groupPosts.setNestedScrollingEnabled(false);
        ItemAnimator animator = this.groupPosts.getItemAnimator();
        if (animator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) animator).setSupportsChangeAnimations(false);
        }
        this.d = new RoundedCornersTransformation((Context) this, (int) (40.0f * getResources().getDisplayMetrics().density), 0, CornerType.ALL);
        this.b = getIntent().getIntExtra("group_id", 0);
        String encodedId = DataUtil.getEncodedId(getIntent().getData());
        if (encodedId != null) {
            this.b = (int) DataUtil.decodeId(encodedId);
        }
        if (AppState.isGroupMember(this.b)) {
            this.gdCompose.setVisibility(0);
        } else {
            this.gdCompose.setVisibility(8);
        }
        if (getIntent().hasExtra("group_name")) {
            this.gdHeaderName.setText(getIntent().getStringExtra("group_name"));
        }
        if (getIntent().hasExtra("group_image")) {
        }
        if (getIntent().hasExtra("group_json")) {
            this.c = (Group) DataUtil.gson.a(getIntent().getStringExtra("group_json"), Group.class);
            if (this.c.group_name != null) {
                this.gdHeaderName.setText(this.c.group_name);
            }
        }
        getRxSubscription();
        this.mSwipeContainer.setOnRefreshListener(new OnRefreshListener(this) {
            final /* synthetic */ GroupDetailsActivity a;

            {
                this.a = this$0;
            }

            public void onRefresh() {
                this.a.getRxSubscription();
            }
        });
        this.groupPosts.addOnScrollListener(new hl(this, (LinearLayoutManager) layoutManager, this.f) {
            final /* synthetic */ GroupDetailsActivity a;

            public void onLoadMore(String minPostId) {
                if (minPostId != null && Integer.valueOf(minPostId).intValue() > 0) {
                    ie.a().a(this.a.b, minPostId).b(Schedulers.io()).a(apn.a()).b(new apj<NetworkData>(this) {
                        final /* synthetic */ AnonymousClass3 a;

                        {
                            this.a = this$1;
                        }

                        public void onCompleted() {
                        }

                        public void onError(Throwable e) {
                            rb.a(e);
                        }

                        public void onNext(NetworkData networkData) {
                            if (networkData.posts != null) {
                                List posts = networkData.posts;
                                this.a.a.f.b(posts);
                                if (!posts.isEmpty()) {
                                    this.a.a.f.a(Integer.toString(((Post) posts.get(posts.size() - 1)).post_id));
                                }
                            }
                        }
                    });
                }
            }
        });
        busSubscribe(ih$k.class, new apj<ih$k>(this) {
            final /* synthetic */ GroupDetailsActivity a;

            {
                this.a = this$0;
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
                rb.a(e);
            }

            public void onNext(ih$k didCreatePost) {
                if (didCreatePost.a.group_id == this.a.b) {
                    this.a.f.a(didCreatePost.a, 1);
                    this.a.groupPosts.smoothScrollToPosition(1);
                    this.a.groupEmpty.setVisibility(8);
                    Group a = this.a.c;
                    a.num_posts++;
                    this.a.getRxSubscription();
                }
            }
        });
        busSubscribe(ih$t.class, new apj<ih$t>(this) {
            final /* synthetic */ GroupDetailsActivity a;

            {
                this.a = this$0;
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
                rb.a(e);
            }

            public void onNext(ih$t didUpdateGroup) {
                if (didUpdateGroup.a.group_id == this.a.b) {
                    this.a.c = didUpdateGroup.a;
                    this.a.f.b(this.a.c.convertToPost(), 0);
                    this.a.getRxSubscription();
                }
            }
        });
        busSubscribe(ih$r.class, new apj<ih$r>(this) {
            final /* synthetic */ GroupDetailsActivity a;

            {
                this.a = this$0;
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
                rb.a(e);
            }

            public void onNext(ih$r didRemovePost) {
                this.a.f.b(didRemovePost.a);
            }
        });
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.loadingSpinny.setVisibility(0);
        this.groupPosts.setVisibility(8);
        this.b = intent.getIntExtra("group_id", 0);
        a();
    }

    public void hideCurrentScreen() {
        findViewById(2131624162).setVisibility(8);
    }

    public void showCurrentScreen() {
        findViewById(2131624162).setVisibility(0);
    }

    private void a(List<Post> posts) {
        this.f.a((List) posts);
        if (posts.size() > 0) {
            this.groupEmpty.setVisibility(8);
        } else {
            this.groupEmpty.setVisibility(0);
        }
    }

    public void createPostClick(View v) {
        if (this.c != null) {
            Intent intent = new Intent(this, CreatePostActivity.class);
            intent.putExtra("group_id", this.c.group_id);
            intent.putExtra("group_name", this.c.group_name);
            startActivityForResult(intent, CREATE_POST_REQUEST);
        }
    }

    public void joinGroupClick(View view) {
        if (this.c != null) {
            ie.a().b(this.c.group_id).b(Schedulers.io()).a(apn.a()).b(new apj<NetworkData>(this) {
                final /* synthetic */ GroupDetailsActivity a;

                {
                    this.a = this$0;
                }

                public void onCompleted() {
                }

                public void onError(Throwable e) {
                    rb.a(e);
                    Toast.makeText(this.a, "Unable to join this group", 0).show();
                }

                public void onNext(NetworkData networkData) {
                    Toast.makeText(this.a, "You have joined this group", 0).show();
                    this.a.gdCompose.setVisibility(0);
                    this.a.f.notifyItemChanged(0);
                }
            });
        }
    }

    public void leaveGroupClick(View view) {
        if (this.c != null) {
            ie.a().c(this.c.group_id).b(Schedulers.io()).a(apn.a()).b(new apj<NetworkData>(this) {
                final /* synthetic */ GroupDetailsActivity a;

                {
                    this.a = this$0;
                }

                public void onCompleted() {
                    this.a.finish();
                }

                public void onError(Throwable e) {
                    rb.a(e);
                    Log.d("GroupDetailsActivity", e.toString());
                }

                public void onNext(NetworkData networkData) {
                    for (int i = 0; i < AppState.groups.size(); i++) {
                        if (((Group) AppState.groups.get(i)).group_id == this.a.c.group_id) {
                            AppState.groups.remove(i);
                            break;
                        }
                    }
                    iq.a().a(new ih$o(this.a.c.group_id));
                    this.a.gdCompose.setVisibility(8);
                    Toast.makeText(this.a, "You have left this group", 0).show();
                }
            });
        }
    }

    public boolean onMenuItemClick(MenuItem item) {
        Log.d("GDA", "groupMenu");
        switch (item.getItemId()) {
            case 2131624770:
                leaveGroupClick(null);
                break;
            case 2131624771:
                joinGroupClick(null);
                break;
            case 2131624772:
                new Builder(this).setIconAttribute(16843605).setTitle("Delete this group?").setMessage("Are you sure you want to permanently delete this group?").setPositiveButton("Yes", new OnClickListener(this) {
                    final /* synthetic */ GroupDetailsActivity a;

                    {
                        this.a = this$0;
                    }

                    public void onClick(DialogInterface dialog, int which) {
                        new HashMap().put("group_id", Integer.toString(this.a.c.group_id));
                        ie.a().f(this.a.b).b(Schedulers.io()).a(apn.a()).b(new apj<NetworkData>(this) {
                            final /* synthetic */ AnonymousClass9 a;

                            {
                                this.a = this$1;
                            }

                            public void onCompleted() {
                            }

                            public void onError(Throwable e) {
                                rb.a(e);
                                Log.d("DeleteGroup", e.toString());
                            }

                            public void onNext(NetworkData networkData) {
                                iq.a().a(new ih$o(this.a.a.c.group_id));
                                this.a.a.finish();
                            }
                        });
                    }
                }).setNegativeButton("No", null).show();
                break;
            case 2131624773:
                new Builder(this).setTitle("Why Are You Reporting This Group?").setSingleChoiceItems(new CharSequence[]{"Pornographic", "Solicitation and Spam", "Hate Speech"}, 0, null).setPositiveButton("Report Group", new OnClickListener(this) {
                    final /* synthetic */ GroupDetailsActivity a;

                    {
                        this.a = this$0;
                    }

                    public void onClick(DialogInterface dialog, int which) {
                        String reason;
                        switch (((AlertDialog) dialog).getListView().getCheckedItemPosition()) {
                            case zu.GOOGLE_PLAY_SERVICES_VERSION_CODE /*?: ONE_ARG  (wrap: int
  0x0001: INVOKE  (r0_0 int) =  zu.zzqZ():int type: STATIC)*/:
                                reason = "nsfw";
                                break;
                            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                                reason = "spam";
                                break;
                            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                                reason = "hate";
                                break;
                            default:
                                reason = "";
                                break;
                        }
                        ie.a().b(this.a.b, reason).b(Schedulers.io()).a(apn.a()).b(new apj<NetworkData>(this) {
                            final /* synthetic */ AnonymousClass10 a;

                            {
                                this.a = this$1;
                            }

                            public void onCompleted() {
                            }

                            public void onError(Throwable e) {
                                rb.a(e);
                                Log.d("ReportGroup", e.toString());
                            }

                            public void onNext(NetworkData networkData) {
                                new Builder(this.a.a).setTitle("Group Reported").setMessage("This group has been reported.").setPositiveButton("OK", null).create().show();
                            }
                        });
                    }
                }).setNegativeButton("Cancel", null).create().show();
                break;
            case 2131624774:
                Intent intent = new Intent(this, CreateGroupActivity.class);
                Bundle bundle = new Bundle();
                bundle.putBoolean("edit_group", true);
                bundle.putInt("group_id", this.c.group_id);
                bundle.putString("group_name", this.c.group_name);
                bundle.putString("group_info", this.c.about);
                bundle.putString("source_url", this.c.source_url);
                bundle.putStringArrayList("tags", (ArrayList) this.c.tags);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
        }
        return true;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CREATE_POST_REQUEST) {
            if (resultCode != -1) {
                Log.e("GroupDetails", "Error on activity result");
            }
        } else if (requestCode == BaseActivity.UPSELL_GROUP && resultCode == -1 && data != null) {
            upsellChange(data.getIntExtra("upsellId", -1));
        }
    }

    public void upsellChange(int upsellId) {
        this.f.b(upsellId);
    }

    public void showContactsDialog(int upsellId, int groupId) {
        Intent intent = new Intent(this, InviteContactsActivity.class);
        intent.putExtra("invite_type", InviteFlowTypes.GROUP.toString());
        intent.putExtra("upsell_id", String.valueOf(upsellId) + "," + String.valueOf(groupId));
        intent.putExtra("groupId", groupId);
        intent.putExtra("upsellId", upsellId);
        startActivityForResult(intent, BaseActivity.UPSELL_GROUP);
    }
}
