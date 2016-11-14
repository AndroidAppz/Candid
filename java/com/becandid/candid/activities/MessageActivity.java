package com.becandid.candid.activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.PopupMenu.OnMenuItemClickListener;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.SimpleItemAnimator;
import android.text.Editable;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.Message;
import com.becandid.candid.data.MessageThread;
import com.becandid.candid.data.Post;
import com.becandid.candid.data.User;
import com.becandid.candid.models.EmptySubscriber;
import com.becandid.candid.models.NetworkData;
import com.becandid.candid.views.StickerKeyboard;
import com.becandid.candid.views.StickerKeyboard.a;
import defpackage.apj;
import defpackage.apk;
import defpackage.apn;
import defpackage.hk;
import defpackage.hl;
import defpackage.ie;
import defpackage.if;
import defpackage.ih$ag;
import defpackage.ih$an;
import defpackage.ih$j;
import defpackage.ih$x;
import defpackage.ih$y;
import defpackage.ih$z;
import defpackage.ii;
import defpackage.iq;
import defpackage.iu;
import defpackage.jc;
import defpackage.jh;
import defpackage.rb;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import rx.schedulers.Schedulers;

public class MessageActivity extends BaseActivity implements a {
    final BroadcastReceiver b = new BroadcastReceiver(this) {
        final /* synthetic */ MessageActivity a;

        {
            this.a = this$0;
        }

        public void onReceive(Context context, Intent intent) {
            Bundle data = intent.getExtras();
            String userInfo = data.getString("user_info");
            if (!(data.getString("message_id") == null || data.getString("post_id") == null || userInfo == null)) {
                try {
                    int messageId = Integer.parseInt(data.getString("message_id"));
                    int postId = Integer.parseInt(data.getString("post_id"));
                    String postName = new JSONObject(userInfo).getString("post_name");
                    if (messageId != 0 && postId != 0 && Integer.toString(postId).equals(this.a.d) && postName.equals(this.a.e)) {
                        Message message = new Message();
                        message.message_id = messageId;
                        message.post_id = postId;
                        message.message = data.getString("message");
                        message.subject = data.getString("subject");
                        if (data.containsKey("image_width") && data.containsKey("image_height") && data.containsKey("source_url")) {
                            message.image_width = Integer.parseInt(data.getString("image_width"));
                            message.image_height = Integer.parseInt(data.getString("image_height"));
                            message.source_url = data.getString("source_url");
                            message.uploaded = Integer.parseInt(data.getString("uploaded"));
                        } else if (data.containsKey("sticker_name")) {
                            message.sticker_name = data.getString("sticker_name");
                        }
                        this.a.a(message);
                    }
                } catch (JSONException e) {
                    rb.a(e);
                } catch (Exception e2) {
                    rb.a(e2);
                }
            }
            abortBroadcast();
        }
    };
    @BindView(2131624231)
    FrameLayout blockedFrameLayout;
    private ii c;
    private String d;
    private String e;
    private String f;
    private boolean g;
    private boolean h;
    @BindView(2131624209)
    TextView headerName;
    @BindView(2131624211)
    ImageView headerOnline;
    private String i;
    private int j;
    private String k;
    private hk l;
    private LayoutParams m;
    @BindView(2131624212)
    LinearLayout messageHeaderPostContainer;
    @BindView(2131624213)
    TextView messageHeaderPostText;
    @BindView(2131624214)
    ImageView messageHeaderRightArrow;
    @BindView(2131624210)
    TextView messageHeaderUserIcon;
    @BindView(2131624208)
    RelativeLayout messageHeaderUserIconContainer;
    @BindView(2131624222)
    EditText messageInput;
    @BindView(2131624218)
    RelativeLayout messageInputContainer;
    @BindView(2131624220)
    ImageView messagePhoto;
    @BindView(2131624223)
    ImageView messagePhotoButton;
    @BindView(2131624221)
    ImageView messagePhotoClear;
    @BindView(2131624217)
    RecyclerView messageRecycler;
    @BindView(2131624230)
    FrameLayout messageSpinnyContainer;
    @BindView(2131624215)
    SwipeRefreshLayout messageSwipeContainer;
    @BindView(2131624225)
    TextView messageTextPlaceholder;
    private Handler n;
    private final int o = 60000;
    private apk p;
    @BindView(2131624129)
    ImageView postButton;
    private apk q;
    private Runnable r = new Runnable(this) {
        final /* synthetic */ MessageActivity a;

        {
            this.a = this$0;
        }

        public void run() {
            Map params = new HashMap();
            if (this.a.d != null) {
                params.put("post_id", this.a.d);
            }
            if (this.a.e != null) {
                params.put("post_name", this.a.e);
            }
            ie.a().m(params).b(Schedulers.io()).a(apn.a()).b(new apj<NetworkData>(this) {
                final /* synthetic */ AnonymousClass16 a;

                {
                    this.a = this$1;
                }

                public void onCompleted() {
                }

                public void onError(Throwable e) {
                    rb.a(e);
                }

                public void onNext(NetworkData networkData) {
                    if (!networkData.success) {
                        Toast.makeText(this.a.a, networkData.error, 0).show();
                    }
                    MessageThread thread = networkData.thread;
                    List data = new ArrayList();
                    if (thread.messages != null && !thread.messages.isEmpty()) {
                        for (Message message : thread.messages) {
                            if (!this.a.a.l.b(message.message_id)) {
                                data.add(message);
                            }
                        }
                        this.a.a.l.a(0, data);
                    }
                }
            });
            this.a.n.postDelayed(this.a.r, 60000);
        }
    };
    @BindView(2131624228)
    TextView requestAccept;
    @BindView(2131624226)
    LinearLayout requestButtons;
    @BindView(2131624227)
    TextView requestIgnore;
    @BindView(2131624205)
    View root;
    @BindView(2131624224)
    ImageView stickerButton;
    @BindView(2131624229)
    StickerKeyboard stickerKeyboard;

    private void a(Message message) {
        message.sender = "other";
        this.l.a(message);
        this.messageRecycler.smoothScrollToPosition(this.l.getItemCount() - 1);
        markThreadRead();
    }

    public void markThreadRead() {
        Map<String, String> params = new HashMap();
        if (this.d != null) {
            params.put("post_id", this.d);
        }
        if (this.e != null) {
            params.put("post_name", this.e);
        }
        ie.a().v(params).b(Schedulers.io()).a(apn.a()).b(new EmptySubscriber());
    }

    public apk getDataSubscription() {
        Map params = new HashMap();
        if (this.d != null) {
            params.put("post_id", this.d);
        }
        if (this.e != null) {
            params.put("post_name", this.e);
        }
        markThreadRead();
        return ie.a().m(params).b(Schedulers.io()).a(apn.a()).b(new apj<NetworkData>(this) {
            final /* synthetic */ MessageActivity a;

            {
                this.a = this$0;
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
                rb.a(e);
                Log.d("ReadMessage", e.toString());
                this.a.messageSpinnyContainer.setVisibility(8);
                this.a.messageSwipeContainer.setRefreshing(false);
            }

            public void onNext(NetworkData networkData) {
                if (!networkData.success) {
                    Toast.makeText(this.a, networkData.error, 0).show();
                    this.a.finish();
                }
                MessageThread thread = networkData.thread;
                this.a.l.b(thread.user_info);
                this.a.l.a(thread.target_user_info);
                List<Message> data = new ArrayList();
                if (thread.messages == null || thread.messages.isEmpty()) {
                    this.a.l.a(null);
                } else {
                    data.addAll(thread.messages);
                    this.a.l.a(((Message) thread.messages.get(0)).message_id);
                }
                if (thread.thread_comment_id != null) {
                    this.a.f = thread.thread_comment_id;
                }
                this.a.l.a((List) data);
                this.a.postButton.setEnabled(true);
                this.a.setupActivityHeader(thread.target_user_info, thread.post);
                if (thread.target_user_info.is_blocked) {
                    this.a.setupBlockedUser();
                }
                if (thread.is_request == 1) {
                    this.a.setupRequest();
                }
                this.a.messagePhotoButton.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass2 a;

                    {
                        this.a = this$1;
                    }

                    public void onClick(View v) {
                        this.a.a.takePhoto();
                    }
                });
                this.a.messageSpinnyContainer.setVisibility(8);
                this.a.messageSwipeContainer.setRefreshing(false);
            }
        });
    }

    public void getPage(String minPostId) {
        Map params = new HashMap();
        if (this.d != null) {
            params.put("post_id", this.d);
        }
        if (this.e != null) {
            params.put("post_name", this.e);
        }
        params.put("prev_message_id", minPostId);
        ie.a().m(params).b(Schedulers.io()).a(apn.a()).b(new apj<NetworkData>(this) {
            final /* synthetic */ MessageActivity a;

            {
                this.a = this$0;
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
                rb.a(e);
                Log.d("ReadMessage", e.toString());
            }

            public void onNext(NetworkData networkData) {
                if (networkData.success) {
                    MessageThread thread = networkData.thread;
                    if (thread.messages == null || thread.messages.isEmpty()) {
                        this.a.l.a(null);
                        return;
                    }
                    this.a.l.c(thread.messages);
                    this.a.l.a(((Message) thread.messages.get(0)).message_id);
                    return;
                }
                Toast.makeText(this.a, networkData.error, 0).show();
            }
        });
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getIntent().getExtras();
        if (args == null) {
            finish();
        }
        if (args.containsKey("post_id")) {
            this.d = args.getString("post_id");
        }
        if (args.containsKey("user_name")) {
            this.e = args.getString("user_name");
        }
        if (args.containsKey("comment_id")) {
            this.f = args.getString("comment_id");
        }
        this.c = ii.a();
        this.n = new Handler(getMainLooper());
        setContentView(2130968617);
        ButterKnife.bind(this);
        enableKeyboardEvents(this.root);
        if (AppState.account.messaging_disabled == 1) {
            this.blockedFrameLayout.setVisibility(0);
            new Builder(this).setTitle("Enable Messaging?").setMessage("You've previously disabled messaging. Do you want to enable it?").setNegativeButton(getResources().getString(2131230887), new DialogInterface.OnClickListener(this) {
                final /* synthetic */ MessageActivity a;

                {
                    this.a = this$0;
                }

                public void onClick(DialogInterface dialog, int which) {
                    this.a.finish();
                }
            }).setPositiveButton(getResources().getString(2131230945), new DialogInterface.OnClickListener(this) {
                final /* synthetic */ MessageActivity a;

                {
                    this.a = this$0;
                }

                public void onClick(DialogInterface dialog, int which) {
                    Map<String, String> params = new HashMap();
                    params.put("messaging_disabled", "0");
                    ie.a().q(params).b(Schedulers.io()).a(apn.a()).b(new EmptySubscriber());
                    AppState.account.messaging_disabled = 0;
                    iq.a().a(new ih$z(0));
                    this.a.blockedFrameLayout.setVisibility(8);
                }
            }).setCancelable(false).create().show();
        }
        this.stickerKeyboard.a = this;
        LayoutManager llmMessage = new LinearLayoutManager(this);
        this.messageRecycler.setLayoutManager(llmMessage);
        ((LinearLayoutManager) llmMessage).setStackFromEnd(true);
        this.l = new hk(this);
        this.messageRecycler.setAdapter(this.l);
        this.messageRecycler.addOnScrollListener(new hl(this, (LinearLayoutManager) llmMessage, this.l, 1, 25) {
            final /* synthetic */ MessageActivity a;

            public void onLoadMore(String minPostId) {
                if (minPostId != null) {
                    this.a.getPage(minPostId);
                }
            }
        });
        ItemAnimator animator = this.messageRecycler.getItemAnimator();
        if (animator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) animator).setSupportsChangeAnimations(false);
        }
        this.messageSwipeContainer.setOnRefreshListener(new OnRefreshListener(this) {
            final /* synthetic */ MessageActivity a;

            {
                this.a = this$0;
            }

            public void onRefresh() {
                this.a.l.c();
                this.a.getDataSubscription();
            }
        });
        this.messageInput.addTextChangedListener(new if(this) {
            final /* synthetic */ MessageActivity a;

            {
                this.a = this$0;
            }

            public void afterTextChanged(Editable s) {
                this.a.updatePostButton();
            }
        });
        this.messageSpinnyContainer.setVisibility(0);
        addToSubscriptionList(getDataSubscription());
        this.q = iq.a().a(ih$y.class, new apj<ih$y>(this) {
            final /* synthetic */ MessageActivity a;

            {
                this.a = this$0;
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
                rb.a(e);
            }

            public void onNext(ih$y imageUploadStarted) {
                this.a.imageCaptured();
            }
        });
        addToSubscriptionList(this.q);
    }

    protected void onResume() {
        IntentFilter filter = new IntentFilter("com.becandid.candid.MESSAGING");
        filter.setPriority(2);
        registerReceiver(this.b, filter);
        this.n.postDelayed(this.r, 60000);
        iq.a().a(new ih$an(2, 0, true));
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
        unregisterReceiver(this.b);
        this.n.removeCallbacks(this.r);
    }

    public void setupBlockedUser() {
        this.blockedFrameLayout.setVisibility(0);
        new Builder(this).setTitle("Unblock This Thread?").setMessage("You've previously blocked this thread. Do you want to unblock it?").setNegativeButton(getResources().getString(2131230887), new DialogInterface.OnClickListener(this) {
            final /* synthetic */ MessageActivity a;

            {
                this.a = this$0;
            }

            public void onClick(DialogInterface dialog, int which) {
                this.a.finish();
            }
        }).setPositiveButton(getResources().getString(2131230945), new DialogInterface.OnClickListener(this) {
            final /* synthetic */ MessageActivity a;

            {
                this.a = this$0;
            }

            public void onClick(DialogInterface dialog, int which) {
                Map<String, String> params = new HashMap();
                params.put("post_id", this.a.d);
                params.put("post_name", this.a.e);
                ie.a().s(params).b(Schedulers.io()).a(apn.a()).b(new EmptySubscriber());
                this.a.blockedFrameLayout.setVisibility(8);
            }
        }).setCancelable(false).create().show();
    }

    public void setupActivityHeader(User targetUserInfo, Post post) {
        int color = Color.parseColor(targetUserInfo.icon_color);
        this.messageHeaderUserIcon.setTextColor(color);
        TextView textView = this.messageHeaderUserIcon;
        ii iiVar = this.c;
        textView.setTypeface(ii.b());
        textView = this.messageHeaderUserIcon;
        iiVar = this.c;
        textView.setText(ii.a(targetUserInfo.icon_name));
        int iconWidth = this.messageHeaderUserIconContainer.getWidth();
        if (iconWidth == 0) {
            iconWidth = (int) (this.messageHeaderUserIconContainer.getResources().getDisplayMetrics().density * 28.0f);
        }
        int gradColor = (16777215 & color) | 1073741824;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(gradColor);
        gradientDrawable.setCornerRadius((float) (iconWidth / 2));
        this.messageHeaderUserIconContainer.setBackground(gradientDrawable);
        if (targetUserInfo.online == 1) {
            this.headerOnline.setVisibility(0);
        } else {
            this.headerOnline.setVisibility(8);
        }
        jh triangle = new jh();
        triangle.setBounds(0, iu.a(1, (Context) this), iu.a(10, (Context) this), iu.a(6, (Context) this));
        triangle.a(color);
        this.headerName.setCompoundDrawables(null, null, triangle, null);
        this.headerName.setText(targetUserInfo.post_name);
        this.headerName.setTextColor(color);
        this.headerName.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MessageActivity a;

            {
                this.a = this$0;
            }

            public void onClick(View v) {
                PopupMenu userMenu = new PopupMenu(this.a, v);
                userMenu.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                    final /* synthetic */ AnonymousClass12 a;

                    {
                        this.a = this$1;
                    }

                    public boolean onMenuItemClick(MenuItem item) {
                        Map<String, String> params = new HashMap();
                        params.put("post_id", this.a.a.d);
                        params.put("post_name", this.a.a.e);
                        switch (item.getItemId()) {
                            case 2131624786:
                                iq.a().a(new ih$j(Integer.parseInt(this.a.a.d), this.a.a.e));
                                ie.a().r(params).b(Schedulers.io()).a(apn.a()).b(new EmptySubscriber());
                                this.a.a.finish();
                                break;
                            case 2131624788:
                                iq.a().a(new ih$j(Integer.parseInt(this.a.a.d), this.a.a.e));
                                ie.a().t(params).b(Schedulers.io()).a(apn.a()).b(new EmptySubscriber());
                                this.a.a.finish();
                                break;
                        }
                        return false;
                    }
                });
                userMenu.getMenu().add(1, 2131624786, 0, 2131230876);
                userMenu.getMenu().add(1, 2131624788, 0, 2131230877);
                userMenu.show();
            }
        });
        if (post != null) {
            this.messageHeaderPostContainer.setVisibility(0);
            if (this.f != null) {
                this.messageHeaderPostText.setText("See Comment");
            } else {
                this.messageHeaderPostText.setText("See Post");
            }
            jc arrow = new jc();
            arrow.setBounds(0, iu.a(2, (Context) this), iu.a(8, (Context) this), iu.a(10, (Context) this));
            arrow.a(getResources().getColor(2131558478));
            this.messageHeaderRightArrow.setImageDrawable(arrow);
            this.messageHeaderPostContainer.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ MessageActivity a;

                {
                    this.a = this$0;
                }

                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), PostDetailsActivity.class);
                    intent.putExtra("post_id", Integer.parseInt(this.a.d));
                    if (this.a.f != null) {
                        intent.putExtra("comment_id", Integer.parseInt(this.a.f));
                        intent.putExtra("scrollToBottom", true);
                    }
                    this.a.startActivity(intent);
                }
            });
            return;
        }
        this.messageHeaderPostContainer.setVisibility(8);
    }

    public void setupRequest() {
        this.requestButtons.setVisibility(0);
        this.requestIgnore.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MessageActivity a;

            {
                this.a = this$0;
            }

            public void onClick(View v) {
                this.a.requestIgnore.setEnabled(false);
                this.a.requestAccept.setEnabled(true);
                Map<String, String> params = new HashMap();
                params.put("post_id", this.a.d);
                params.put("post_name", this.a.e);
                params.put("ignore", "1");
                ie.a().u(params).b(Schedulers.io()).a(apn.a()).b(new apj<NetworkData>(this) {
                    final /* synthetic */ AnonymousClass14 a;

                    {
                        this.a = this$1;
                    }

                    public void onCompleted() {
                    }

                    public void onError(Throwable e) {
                        rb.a(e);
                        Log.d("HandleRequest", e.toString());
                        this.a.a.requestIgnore.setEnabled(true);
                    }

                    public void onNext(NetworkData networkData) {
                        if (networkData.success) {
                            iq.a().a(new ih$x(this.a.a.d, this.a.a.e, 1));
                            this.a.a.finish();
                            return;
                        }
                        this.a.a.requestIgnore.setEnabled(true);
                    }
                });
            }
        });
        this.requestAccept.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MessageActivity a;

            {
                this.a = this$0;
            }

            public void onClick(View v) {
                this.a.requestIgnore.setEnabled(false);
                this.a.requestAccept.setEnabled(true);
                Map<String, String> params = new HashMap();
                params.put("post_id", this.a.d);
                params.put("post_name", this.a.e);
                params.put("ignore", "0");
                ie.a().u(params).b(Schedulers.io()).a(apn.a()).b(new apj<NetworkData>(this) {
                    final /* synthetic */ AnonymousClass15 a;

                    {
                        this.a = this$1;
                    }

                    public void onCompleted() {
                    }

                    public void onError(Throwable e) {
                        rb.a(e);
                        Log.d("HandleRequest", e.toString());
                        this.a.a.requestIgnore.setEnabled(true);
                        this.a.a.requestAccept.setEnabled(true);
                    }

                    public void onNext(NetworkData networkData) {
                        if (networkData.success) {
                            this.a.a.requestButtons.setVisibility(8);
                            iq.a().a(new ih$x(this.a.a.d, this.a.a.e, 0));
                            return;
                        }
                        this.a.a.requestIgnore.setEnabled(true);
                        this.a.a.requestAccept.setEnabled(true);
                    }
                });
            }
        });
    }

    public void scrollToBottom() {
        this.messageRecycler.smoothScrollToPosition(this.messageRecycler.getBottom());
    }

    public void startMessage(View view) {
        showMessageInput();
        this.messageInput.requestFocus();
        this.messageInput.post(new Runnable(this) {
            final /* synthetic */ MessageActivity a;

            {
                this.a = this$0;
            }

            public void run() {
                this.a.openKeyboard();
            }
        });
    }

    public void showMessageInput() {
        this.messageInputContainer.setVisibility(0);
        this.messageTextPlaceholder.setVisibility(8);
    }

    public void hideMessageInput() {
        this.messageInputContainer.setVisibility(8);
        this.messageTextPlaceholder.setVisibility(0);
    }

    protected void keyboardOpened() {
        super.keyboardOpened();
        chooseSticker(null);
        scrollToBottom();
    }

    protected void keyboardClosed() {
        super.keyboardClosed();
        String text = this.messageInput.getText().toString().trim();
        if (!this.g && this.i == null && text.length() == 0) {
            hideMessageInput();
        }
    }

    public void takePhoto() {
        if (!(!this.g && this.i == null && this.k == null)) {
            clearPhoto(null);
        }
        if (AppState.config.getInt("android_msg_image_upload", 1) == 1) {
            getPhotoHelper().choosePhoto(false);
        } else {
            getPhotoHelper().choosePhoto(true);
        }
    }

    public void clearPhoto(View v) {
        super.clearPhoto();
        this.messagePhoto.setImageBitmap(null);
        this.g = false;
        this.i = null;
        this.j = 0;
        this.messagePhoto.setVisibility(8);
        if (this.m != null) {
            this.messagePhoto.setLayoutParams(this.m);
        }
        this.k = null;
        this.messagePhotoClear.setVisibility(8);
        if (!this.keyboardOpen) {
            keyboardClosed();
        }
        updatePostButton();
        if (this.p != null) {
            this.p.unsubscribe();
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != -1) {
            this.messagePhoto.setImageBitmap(null);
            clearPhoto();
        } else if (this.photoHelper != null && this.photoHelper.f != null && this.photoHelper.b != null && this.photoHelper.a != null) {
            this.messagePhoto.setImageBitmap(this.photoHelper.f);
            if (this.photoHelper.d > 0 && this.photoHelper.e > 0) {
                LayoutParams lp = (LayoutParams) this.messagePhoto.getLayoutParams();
                lp.width = (int) ((((float) this.photoHelper.d) / ((float) this.photoHelper.e)) * ((float) lp.height));
                this.messagePhoto.setLayoutParams(lp);
            }
            if (requestCode == 905 || requestCode == 902) {
                this.j = 1;
            }
            this.messagePhoto.setVisibility(0);
            this.messagePhoto.setAlpha(0.3f);
            this.messagePhotoClear.setVisibility(0);
            showMessageInput();
        }
    }

    protected void imageCaptured() {
        this.g = true;
        if (this.photoHelper == null) {
            rb.a(new Exception("photoHelper is NULL"));
            return;
        }
        this.photoHelper.a();
        if (!(this.p == null || this.p.isUnsubscribed())) {
            this.p.unsubscribe();
        }
        this.p = iq.a().a(ih$ag.class, new apj<ih$ag>(this) {
            final /* synthetic */ MessageActivity a;

            {
                this.a = this$0;
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
                rb.a(e);
            }

            public void onNext(ih$ag s3UploadResponse) {
                if (!s3UploadResponse.b) {
                    this.a.clearPhoto(null);
                    this.a.updatePostButton();
                    if (this.a.h) {
                        this.a.h = false;
                    }
                    Toast.makeText(this.a, this.a.getString(2131230933), 0).show();
                } else if (this.a.g) {
                    this.a.g = false;
                    this.a.i = s3UploadResponse.a.full_url;
                    if (this.a.h) {
                        this.a.h = false;
                        this.a.saveMessage(null);
                    }
                    this.a.updatePostButton();
                    this.a.messagePhoto.setAlpha(1.0f);
                }
            }
        });
        addToSubscriptionList(this.p);
    }

    public void chooseSticker(View v) {
        if (this.stickerKeyboard.getVisibility() == 0 || v == null) {
            this.stickerKeyboard.setVisibility(8);
            this.stickerButton.setImageResource(2130838218);
            this.stickerButton.setAlpha(0.5f);
            return;
        }
        if (this.keyboardOpen) {
            closeKeyboard();
        }
        this.stickerKeyboard.setVisibility(0);
        this.stickerButton.setImageResource(2130838219);
        this.stickerButton.setAlpha(1.0f);
    }

    public void clickSticker(String name) {
        this.k = name;
        this.messagePhoto.setVisibility(0);
        this.messagePhotoClear.setVisibility(0);
        this.messagePhoto.setImageDrawable(GossipApplication.a.getResources().getDrawable(GossipApplication.a.getResources().getIdentifier(name.toLowerCase(), "drawable", GossipApplication.a.getPackageName())));
        this.m = (LayoutParams) this.messagePhoto.getLayoutParams();
        LayoutParams lp = (LayoutParams) this.messagePhoto.getLayoutParams();
        lp.width = (int) (getResources().getDisplayMetrics().density * 50.0f);
        lp.height = lp.width;
        this.messagePhoto.setLayoutParams(lp);
        showMessageInput();
        updatePostButton();
    }

    public void updatePostButton() {
        if (this.messageInput.getText().toString().trim().length() <= 0 && this.i == null && this.k == null) {
            this.postButton.setImageResource(2130837648);
            return;
        }
        this.postButton.setImageResource(2130837649);
        if (this.g) {
            this.postButton.setImageResource(2130837648);
        }
    }

    public void saveMessage(View v) {
        if (!this.g) {
            Message message = new Message();
            HashMap params = new HashMap();
            String text = this.messageInput.getText().toString().trim();
            if (text.length() > 0) {
                params.put("message", text);
                message.message = text;
            }
            if (this.i != null) {
                params.put("source_url", this.i);
                message.source_url = this.i;
                params.put("uploaded", Integer.toString(this.j));
                message.uploaded = this.j;
                float width = (float) this.photoHelper.d;
                float height = (float) this.photoHelper.e;
                if (width <= 0.0f || height <= 0.0f) {
                    params.put("image_width", "240");
                    message.image_width = 240;
                    params.put("image_height", "160");
                    message.image_height = 160;
                } else if (((double) width) < (((double) height) * 240.0d) / 160.0d) {
                    params.put("image_width", String.valueOf((int) ((160.0d * ((double) width)) / ((double) height))));
                    message.image_width = (int) ((160.0d * ((double) width)) / ((double) height));
                    params.put("image_height", "160");
                    message.image_height = 160;
                } else {
                    params.put("image_width", "240");
                    message.image_width = 240;
                    params.put("image_height", String.valueOf((int) ((240.0d * ((double) height)) / ((double) width))));
                    message.image_height = (int) ((240.0d * ((double) height)) / ((double) width));
                }
            }
            if (this.k != null) {
                params.put("sticker_name", this.k);
                message.sticker_name = this.k;
                params.put("image_width", "120");
                message.image_width = 120;
                params.put("image_height", "120");
                message.image_height = 120;
            }
            a(params, message);
        }
    }

    private void a(HashMap<String, String> params, final Message message) {
        if (params.containsKey("message") || params.containsKey("sticker_name") || params.containsKey("source_url")) {
            this.messageInput.setText("");
            chooseSticker(null);
            params.put("post_id", this.d);
            message.post_id = Integer.parseInt(this.d);
            if (this.e != null) {
                params.put("post_name", this.e);
                message.user_info = new User();
                message.user_info.post_name = this.e;
            }
            if (this.f != null) {
                params.put("thread_comment_id", this.f);
            }
            params.put("send", Boolean.toString(true));
            final long messageTempId = System.currentTimeMillis();
            message.messageTempId = messageTempId;
            ie.a().n(params).b(Schedulers.io()).a(apn.a()).b(new apj<NetworkData>(this) {
                final /* synthetic */ MessageActivity c;

                public void onCompleted() {
                }

                public void onError(Throwable e) {
                    if (this.c.p != null) {
                        this.c.p.unsubscribe();
                    }
                    if (!this.c.isStopped) {
                        Toast.makeText(this.c, e.toString(), 1).show();
                        this.c.l.a(message.messageTempId, false, false, null);
                    }
                }

                public void onNext(NetworkData networkData) {
                    if (this.c.p != null) {
                        this.c.p.unsubscribe();
                    }
                    if (!this.c.isStopped) {
                        if (!(this.c.i == null && this.c.k == null)) {
                            this.c.clearPhoto(null);
                        }
                        if (networkData != null && !networkData.success) {
                            Toast.makeText(this.c, networkData.error, 1).show();
                            if (networkData.error.contains("blocked") || networkData.error.contains("disabled")) {
                                this.c.l.a(messageTempId, false, true, null);
                            }
                            this.c.l.a(messageTempId, false, false, null);
                        } else if (networkData != null && networkData.message != null) {
                            this.c.l.a(messageTempId, true, false, networkData.message);
                        }
                    }
                }
            });
            message.params = params;
            this.l.a(message);
            new Handler().postDelayed(new Runnable(this) {
                final /* synthetic */ MessageActivity a;

                {
                    this.a = this$0;
                }

                public void run() {
                    this.a.scrollToBottom();
                }
            }, 200);
            return;
        }
        Toast.makeText(this, "Empty messages are not allowed.", 0).show();
    }

    public void onBackPressed() {
        if (AppState.mainTabsActivity == null) {
            Intent intent = new Intent(this, MainTabsActivity.class);
            if (AppState.config.getBoolean("messaging_turned_on", true)) {
                intent.putExtra("selected_tab", "messages");
            }
            startActivity(intent);
            finish();
            return;
        }
        super.onBackPressed();
    }
}
