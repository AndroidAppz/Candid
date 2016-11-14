package com.becandid.candid.activities;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore.Images.Media;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnMenuItemClickListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.becandid.candid.activities.InviteContactsActivity.InviteFlowTypes;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.EmptyClass;
import com.becandid.candid.data.Post;
import com.becandid.candid.data.UpdatePost;
import com.becandid.candid.data.UpdatePost.Updates;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import defpackage.apj;
import defpackage.apn;
import defpackage.asu;
import defpackage.asu$d;
import defpackage.bb;
import defpackage.ie;
import defpackage.ih$al;
import defpackage.ih$am;
import defpackage.ih$q;
import defpackage.ii;
import defpackage.iq;
import defpackage.ir;
import defpackage.iu;
import defpackage.jp;
import defpackage.nq;
import defpackage.nz;
import defpackage.of;
import defpackage.px;
import defpackage.qq;
import defpackage.rb;
import defpackage.um$h;
import defpackage.zu;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import rx.schedulers.Schedulers;

public class FullScreenImageActivity extends BaseActivity {
    private String b;
    private int c;
    @BindView(2131624155)
    RelativeLayout commentContainer;
    @BindView(2131624157)
    TextView commentCount;
    @BindView(2131624131)
    RelativeLayout container;
    private int d;
    @BindView(2131624149)
    RelativeLayout dislikeContainer;
    @BindView(2131624153)
    TextView dislikeCount;
    @BindView(2131624150)
    ImageView dislikeIcon;
    private int e;
    private int f;
    @BindView(2131624154)
    TextView falseCount;
    @BindView(2131624151)
    ImageView falseIcon;
    @BindView(2131624135)
    View fullscreenDownload;
    @BindView(2131624134)
    View fullscreenExit;
    @BindView(2131624137)
    RelativeLayout fullscreenFooter;
    @BindView(2131624136)
    FrameLayout fullscreenGradient;
    @BindView(2131624133)
    RelativeLayout fullscreenHeader;
    @BindView(2131624132)
    ImageView fullscreenImage;
    @BindView(2131624160)
    LinearLayout fullscreenSpinny;
    private int g;
    private int h;
    private boolean i = true;
    private boolean j;
    private String k;
    private String l;
    @BindView(2131624143)
    RelativeLayout likeContainer;
    @BindView(2131624147)
    TextView likeCount;
    @BindView(2131624144)
    ImageView likeIcon;
    private Activity m;
    private boolean n;
    private nz o;
    @BindView(2131624159)
    TextView replyContainer;
    @BindView(2131624158)
    TextView shareContainer;
    @BindView(2131624148)
    TextView trueCount;
    @BindView(2131624145)
    ImageView trueIcon;
    @BindView(2131624139)
    TextView userIcon;
    @BindView(2131624141)
    TextView userName;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(2130968608);
        ButterKnife.bind(this);
        final Bundle extras = getIntent().getExtras();
        if (extras.containsKey("source_url")) {
            this.b = extras.getString("source_url");
        } else {
            Toast.makeText(this, "Error finding image url", 1).show();
            finish();
        }
        if (extras.containsKey("post_id")) {
            setupPost(extras);
            subscribeToUpdates("post");
        } else if (extras.containsKey("comment_id")) {
            setupComment(extras);
            subscribeToUpdates("comment");
        } else {
            this.fullscreenGradient.setVisibility(8);
            this.fullscreenFooter.setVisibility(8);
            this.n = true;
        }
        final int deviceHeight = getResources().getDisplayMetrics().heightPixels;
        jp.a((FragmentActivity) this).a(this.b).b().a(DiskCacheStrategy.c).a(new px<String, nz>(this) {
            final /* synthetic */ FullScreenImageActivity c;

            public boolean onException(Exception e, String model, qq<nz> qqVar, boolean isFirstResource) {
                rb.a(e);
                this.c.fullscreenSpinny.setVisibility(8);
                this.c.fullscreenImage.setVisibility(0);
                return false;
            }

            public boolean onResourceReady(nz resource, String model, qq<nz> qqVar, boolean isFromMemoryCache, boolean isFirstResource) {
                this.c.fullscreenImage.setLayoutParams(new LayoutParams(-1, -1));
                LayoutParams flp = new LayoutParams(-1, deviceHeight / 5);
                flp.addRule(12);
                this.c.fullscreenGradient.setLayoutParams(flp);
                this.c.fullscreenSpinny.setVisibility(8);
                this.c.fullscreenImage.setVisibility(0);
                if (!this.c.n) {
                    this.c.setupFooterShared(extras);
                }
                this.c.o = resource;
                return false;
            }
        }).a(this.fullscreenImage);
        new asu(this.fullscreenImage).a(new asu$d(this) {
            final /* synthetic */ FullScreenImageActivity a;

            {
                this.a = this$0;
            }

            public void onPhotoTap(View view, float v, float v1) {
                if (this.a.j) {
                    this.a.fadeIn();
                } else {
                    this.a.fadeOut();
                }
                this.a.j = !this.a.j;
            }

            public void onOutsidePhotoTap() {
            }
        });
        final Activity activity = this;
        this.fullscreenDownload.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FullScreenImageActivity b;

            public void onClick(View v) {
                if (bb.checkSelfPermission(activity, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                    ActivityCompat.requestPermissions(activity, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, BaseActivity.UPSELL_FEED);
                    return;
                }
                this.b.a();
            }
        });
        this.fullscreenExit.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FullScreenImageActivity a;

            {
                this.a = this$0;
            }

            public void onClick(View v) {
                this.a.onBackPressed();
            }
        });
        addToSubscriptionList(iq.a().a(ih$q.class, new apj<ih$q>(this) {
            final /* synthetic */ FullScreenImageActivity a;

            {
                this.a = this$0;
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
                rb.a(e);
            }

            public void onNext(ih$q didLikePost) {
                this.a.a(didLikePost);
            }
        }));
        this.m = this;
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == BaseActivity.UPSELL_FEED && grantResults.length > 0 && grantResults[0] == 0) {
            a();
        }
    }

    private void a() {
        File candidDirectory;
        File output;
        OutputStream fOut;
        ContentValues values;
        if (this.o instanceof nq) {
            Bitmap bitmap = this.o.b();
            candidDirectory = new File(Environment.getExternalStorageDirectory() + File.separator + Environment.DIRECTORY_PICTURES + File.separator + "Candid" + File.separator);
            if (!candidDirectory.exists()) {
                candidDirectory.mkdir();
            }
            output = new File(candidDirectory, new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + ".png");
            try {
                fOut = new FileOutputStream(output);
                bitmap.compress(CompressFormat.PNG, 100, fOut);
                fOut.flush();
                fOut.close();
                values = new ContentValues();
                values.put("mime_type", "image/png");
                values.put("date_added", Long.valueOf(System.currentTimeMillis()));
                values.put("datetaken", Long.valueOf(System.currentTimeMillis()));
                values.put("_data", output.toString());
                Uri url = getContentResolver().insert(Media.EXTERNAL_CONTENT_URI, values);
                Toast.makeText(getApplicationContext(), "Image saved", 0).show();
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "An error occured. Please try again later.", 0).show();
            }
        } else if (this.o instanceof of) {
            of gifDrawable = this.o;
            candidDirectory = new File(Environment.getExternalStorageDirectory() + File.separator + Environment.DIRECTORY_PICTURES + File.separator + "Candid" + File.separator);
            if (!candidDirectory.exists()) {
                candidDirectory.mkdir();
            }
            output = new File(candidDirectory, new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + ".gif");
            try {
                fOut = new FileOutputStream(output);
                fOut.write(gifDrawable.d());
                fOut.flush();
                fOut.close();
                values = new ContentValues();
                values.put("mime_type", "image/gif");
                values.put("date_added", Long.valueOf(System.currentTimeMillis()));
                values.put("datetaken", Long.valueOf(System.currentTimeMillis()));
                values.put("_data", output.toString());
                getContentResolver().insert(Media.EXTERNAL_CONTENT_URI, values);
                Toast.makeText(getApplicationContext(), "Image saved", 0).show();
            } catch (IOException e2) {
                Toast.makeText(getApplicationContext(), "An error occured. Please try again later.", 0).show();
            }
        }
    }

    private void a(ih$q didLikePost) {
        this.f = didLikePost.e;
        this.g = didLikePost.f;
        b();
    }

    public void fadeOut() {
        this.fullscreenHeader.animate().setDuration(200).alpha(0.0f).setListener(new AnimatorListenerAdapter(this) {
            final /* synthetic */ FullScreenImageActivity a;

            {
                this.a = this$0;
            }

            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                this.a.fullscreenHeader.setVisibility(8);
            }
        });
        if (!this.n) {
            this.fullscreenFooter.animate().setDuration(200).alpha(0.0f).setListener(new AnimatorListenerAdapter(this) {
                final /* synthetic */ FullScreenImageActivity a;

                {
                    this.a = this$0;
                }

                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    this.a.fullscreenFooter.setVisibility(8);
                }
            });
            this.fullscreenGradient.animate().setDuration(200).alpha(0.0f).setListener(new AnimatorListenerAdapter(this) {
                final /* synthetic */ FullScreenImageActivity a;

                {
                    this.a = this$0;
                }

                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    this.a.fullscreenGradient.setVisibility(8);
                }
            });
        }
    }

    public void fadeIn() {
        this.fullscreenHeader.animate().setDuration(200).alpha(1.0f).setListener(new AnimatorListenerAdapter(this) {
            final /* synthetic */ FullScreenImageActivity a;

            {
                this.a = this$0;
            }

            public void onAnimationStart(Animator animation) {
                super.onAnimationEnd(animation);
                this.a.fullscreenHeader.setVisibility(0);
            }
        });
        if (!this.n) {
            this.fullscreenFooter.animate().setDuration(200).alpha(1.0f).setListener(new AnimatorListenerAdapter(this) {
                final /* synthetic */ FullScreenImageActivity a;

                {
                    this.a = this$0;
                }

                public void onAnimationStart(Animator animation) {
                    super.onAnimationEnd(animation);
                    this.a.fullscreenFooter.setVisibility(0);
                }
            });
            this.fullscreenGradient.animate().setDuration(200).alpha(1.0f).setListener(new AnimatorListenerAdapter(this) {
                final /* synthetic */ FullScreenImageActivity a;

                {
                    this.a = this$0;
                }

                public void onAnimationStart(Animator animation) {
                    super.onAnimationEnd(animation);
                    this.a.fullscreenGradient.setVisibility(0);
                }
            });
        }
    }

    public void setupFooterShared(Bundle extras) {
        String name = extras.getString("user_name");
        String icon_name = extras.getString("icon_name");
        String icon_color = extras.getString("icon_color");
        if (this.i) {
            icon_color = iu.a(icon_color, 0.3f);
        } else {
            icon_color = iu.a(icon_color, 0.7f);
        }
        int postColor = Color.parseColor(icon_color);
        this.userName.setText(name);
        this.userName.setTextColor(postColor);
        TextView textView = this.userIcon;
        ii.a();
        textView.setTypeface(ii.b());
        this.userIcon.setText(ii.a(icon_name));
        this.userIcon.setTextColor(postColor);
        GradientDrawable iconCircle = new GradientDrawable();
        int iconWidth = this.userIcon.getWidth();
        if (iconWidth == 0) {
            iconWidth = (int) (this.userIcon.getResources().getDisplayMetrics().density * 30.0f);
        }
        iconCircle.setColor((16777215 & postColor) | 1073741824);
        iconCircle.setCornerRadius((float) (iconWidth / 2));
        this.userIcon.setBackground(iconCircle);
        this.c = extras.getInt("num_likes", 0);
        this.d = extras.getInt("num_dislikes", 0);
        this.e = extras.getInt("like_value", 0);
        this.f = extras.getInt("num_true", 0);
        this.g = extras.getInt("num_false", 0);
        this.h = extras.getInt("opinion_value", 0);
        if (extras.getInt("is_rumor", 0) == 1) {
            this.likeIcon.setVisibility(8);
            this.dislikeIcon.setVisibility(8);
            this.trueIcon.setVisibility(0);
            this.falseIcon.setVisibility(0);
            int color = Color.parseColor("#FF0000");
            if (this.h == 1) {
                this.trueIcon.setColorFilter(color);
            } else if (this.h == -1) {
                this.falseIcon.setColorFilter(color);
            }
            this.trueCount.setText("True " + Integer.toString(this.f));
            this.falseCount.setText("False " + Integer.toString(this.g));
            return;
        }
        if (this.e == 1) {
            this.likeIcon.setSelected(true);
        } else if (this.e == -1) {
            this.dislikeIcon.setSelected(true);
        }
        this.likeCount.setText(Integer.toString(this.c));
        this.dislikeCount.setText(Integer.toString(this.d));
    }

    public void setupPost(final Bundle extras) {
        final int postId = extras.getInt("post_id");
        int numComments = extras.getInt("num_comments", 0);
        final int isRumor = extras.getInt("is_rumor", 0);
        if (isRumor == 1) {
            this.likeIcon.setVisibility(8);
            this.dislikeIcon.setVisibility(8);
            this.trueIcon.setVisibility(0);
            this.falseIcon.setVisibility(0);
            this.commentContainer.setVisibility(8);
        } else {
            this.commentCount.setText(Integer.toString(numComments));
            this.commentContainer.setVisibility(0);
        }
        this.k = extras.getString("share_info_url", null);
        this.l = extras.getString("share_info_image", null);
        if (!(this.l == null || this.k == null)) {
            this.shareContainer.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ FullScreenImageActivity a;

                {
                    this.a = this$0;
                }

                public void onClick(View v) {
                    Context context = v.getContext();
                    if (AppState.config.getInt("enable_share_post", 0) == 1) {
                        PopupMenu popupMenu = new PopupMenu(context, v);
                        popupMenu.getMenuInflater().inflate(2131689481, popupMenu.getMenu());
                        popupMenu.show();
                        popupMenu.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                            final /* synthetic */ AnonymousClass12 a;

                            {
                                this.a = this$1;
                            }

                            public boolean onMenuItemClick(MenuItem item) {
                                switch (item.getItemId()) {
                                    case 2131624796:
                                        ir.b(this.a.a.m, this.a.a.k, this.a.a.l);
                                        return true;
                                    case 2131624797:
                                        ir.b(this.a.a.m, this.a.a.k, this.a.a.l);
                                        return true;
                                    case 2131624798:
                                        Intent intent = new Intent(this.a.a.m, InviteContactsActivity.class);
                                        intent.putExtra("invite_type", InviteFlowTypes.POST.toString());
                                        this.a.a.m.startActivity(intent);
                                        return true;
                                    case 2131624799:
                                        ir.a(this.a.a.m, this.a.a.k, "Share Link");
                                        return true;
                                    default:
                                        return false;
                                }
                            }
                        });
                        return;
                    }
                    Toast.makeText(context, "Sharing is not available", 0).show();
                }
            });
        }
        this.replyContainer.setVisibility(8);
        this.likeContainer.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FullScreenImageActivity c;

            public void onClick(View v) {
                if (isRumor == 1) {
                    if (this.c.h == 1) {
                        this.c.a(this.c.trueIcon, this.c.f, this.c.trueCount, false);
                        this.c.h = 0;
                    } else {
                        if (this.c.h == -1) {
                            this.c.b(this.c.falseIcon, this.c.g, this.c.falseCount, false);
                        }
                        this.c.a(this.c.trueIcon, this.c.f, this.c.trueCount, true);
                        this.c.h = 1;
                    }
                    this.c.a(postId, this.c.h, 1);
                    return;
                }
                int value;
                this.c.disableLikes();
                final UpdatePost oldUpdatePost = new UpdatePost();
                oldUpdatePost.post_id = postId;
                oldUpdatePost.updates.num_likes = Integer.valueOf(this.c.c);
                oldUpdatePost.updates.num_dislikes = Integer.valueOf(this.c.d);
                oldUpdatePost.updates.like_value = Integer.valueOf(this.c.e);
                UpdatePost updatePost = new UpdatePost();
                updatePost.post_id = postId;
                if (this.c.likeIcon.isSelected()) {
                    value = 0;
                    updatePost.updates.num_likes = Integer.valueOf(this.c.c - 1);
                } else {
                    value = 1;
                    updatePost.updates.num_likes = Integer.valueOf(this.c.c + 1);
                    if (this.c.dislikeIcon.isSelected()) {
                        updatePost.updates.num_dislikes = Integer.valueOf(this.c.d - 1);
                    }
                }
                updatePost.updates.like_value = Integer.valueOf(value);
                iq.a().a(new ih$am(updatePost));
                ie.a().b(Integer.toString(postId), Integer.toString(value), null).b(Schedulers.io()).a(apn.a()).b(new apj<Post>(this) {
                    final /* synthetic */ AnonymousClass13 b;

                    public void onCompleted() {
                    }

                    public void onError(Throwable e) {
                        rb.a(e);
                        Log.d("LikePost", e.toString());
                        iq.a().a(new ih$am(oldUpdatePost));
                    }

                    public void onNext(Post post) {
                        this.b.c.enableLikes();
                    }
                });
            }
        });
        this.dislikeContainer.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FullScreenImageActivity c;

            public void onClick(View v) {
                if (isRumor == 1) {
                    if (this.c.h == -1) {
                        this.c.b(this.c.falseIcon, this.c.g, this.c.falseCount, false);
                        this.c.h = 0;
                    } else {
                        if (this.c.h == 1) {
                            this.c.a(this.c.trueIcon, this.c.f, this.c.trueCount, false);
                        }
                        this.c.b(this.c.falseIcon, this.c.g, this.c.falseCount, true);
                        this.c.h = -1;
                    }
                    this.c.a(postId, this.c.h, 1);
                    return;
                }
                int value;
                this.c.disableLikes();
                final UpdatePost oldUpdatePost = new UpdatePost();
                oldUpdatePost.post_id = postId;
                oldUpdatePost.updates.num_likes = Integer.valueOf(this.c.c);
                oldUpdatePost.updates.num_dislikes = Integer.valueOf(this.c.d);
                oldUpdatePost.updates.like_value = Integer.valueOf(this.c.e);
                UpdatePost updatePost = new UpdatePost();
                updatePost.post_id = postId;
                if (this.c.dislikeIcon.isSelected()) {
                    value = 0;
                    updatePost.updates.num_dislikes = Integer.valueOf(this.c.d - 1);
                } else {
                    value = -1;
                    updatePost.updates.num_dislikes = Integer.valueOf(this.c.d + 1);
                    if (this.c.likeIcon.isSelected()) {
                        updatePost.updates.num_likes = Integer.valueOf(this.c.c - 1);
                    }
                }
                updatePost.updates.like_value = Integer.valueOf(value);
                iq.a().a(new ih$am(updatePost));
                ie.a().b(Integer.toString(postId), Integer.toString(value), null).b(Schedulers.io()).a(apn.a()).b(new apj<Post>(this) {
                    final /* synthetic */ AnonymousClass14 b;

                    public void onCompleted() {
                    }

                    public void onError(Throwable e) {
                        rb.a(e);
                        Log.d("LikePost", e.toString());
                        iq.a().a(new ih$am(oldUpdatePost));
                    }

                    public void onNext(Post post) {
                        this.b.c.enableLikes();
                    }
                });
            }
        });
        this.commentContainer.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FullScreenImageActivity c;

            public void onClick(View v) {
                if (this.c.getIntent().hasExtra("fromDetails")) {
                    this.c.finish();
                    return;
                }
                PostDetailsActivity.startPostDetailsActivity(postId, this.c.m, extras.getString("icon_color"));
                this.c.finish();
            }
        });
    }

    public void setupComment(Bundle extras) {
        final int commentId = extras.getInt("comment_id");
        this.commentContainer.setVisibility(8);
        this.shareContainer.setVisibility(8);
        this.replyContainer.setVisibility(8);
        this.likeContainer.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FullScreenImageActivity b;

            public void onClick(View v) {
                int value;
                this.b.disableLikes();
                int likeUpdate = this.b.c;
                int dislikeUpdate = this.b.d;
                if (this.b.likeIcon.isSelected()) {
                    value = 0;
                    likeUpdate = this.b.c - 1;
                } else {
                    value = 1;
                    likeUpdate = this.b.c + 1;
                    if (this.b.dislikeIcon.isSelected()) {
                        dislikeUpdate = this.b.d - 1;
                    }
                }
                final ih$al update = new ih$al(commentId, value, likeUpdate, dislikeUpdate);
                ie.a().a(commentId, value).b(Schedulers.io()).a(apn.a()).b(new apj<EmptyClass>(this) {
                    final /* synthetic */ AnonymousClass16 b;

                    public void onCompleted() {
                    }

                    public void onError(Throwable e) {
                        rb.a(e);
                        Log.d("LikeComment", e.toString());
                        this.b.b.enableLikes();
                    }

                    public void onNext(EmptyClass emptyClass) {
                        iq.a().a(update);
                        this.b.b.enableLikes();
                    }
                });
            }
        });
        this.dislikeContainer.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FullScreenImageActivity b;

            public void onClick(View v) {
                int value;
                this.b.disableLikes();
                int likeUpdate = this.b.c;
                int dislikeUpdate = this.b.d;
                if (this.b.dislikeIcon.isSelected()) {
                    value = 0;
                    dislikeUpdate = this.b.d - 1;
                } else {
                    value = -1;
                    dislikeUpdate = this.b.d + 1;
                    if (this.b.likeIcon.isSelected()) {
                        likeUpdate = this.b.c - 1;
                    }
                }
                final ih$al update = new ih$al(commentId, value, likeUpdate, dislikeUpdate);
                ie.a().a(commentId, value).b(Schedulers.io()).a(apn.a()).b(new apj<EmptyClass>(this) {
                    final /* synthetic */ AnonymousClass17 b;

                    public void onCompleted() {
                    }

                    public void onError(Throwable e) {
                        rb.a(e);
                        Log.d("LikeComment", e.toString());
                        this.b.b.enableLikes();
                    }

                    public void onNext(EmptyClass emptyClass) {
                        iq.a().a(update);
                        this.b.b.enableLikes();
                    }
                });
            }
        });
    }

    public void subscribeToUpdates(String id) {
        Object obj = -1;
        switch (id.hashCode()) {
            case 3446944:
                if (id.equals("post")) {
                    obj = null;
                    break;
                }
                break;
            case 950398559:
                if (id.equals("comment")) {
                    obj = 1;
                    break;
                }
                break;
        }
        switch (obj) {
            case zu.GOOGLE_PLAY_SERVICES_VERSION_CODE /*?: ONE_ARG  (wrap: int
  0x0001: INVOKE  (r0_0 int) =  zu.zzqZ():int type: STATIC)*/:
                addToSubscriptionList(iq.a().a(ih$am.class, new apj<ih$am>(this) {
                    final /* synthetic */ FullScreenImageActivity a;

                    {
                        this.a = this$0;
                    }

                    public void onCompleted() {
                    }

                    public void onError(Throwable e) {
                        rb.a(e);
                    }

                    public void onNext(ih$am updatePostEvent) {
                        this.a.updatePost(updatePostEvent);
                    }
                }));
                return;
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                addToSubscriptionList(iq.a().a(ih$al.class, new apj<ih$al>(this) {
                    final /* synthetic */ FullScreenImageActivity a;

                    {
                        this.a = this$0;
                    }

                    public void onCompleted() {
                    }

                    public void onError(Throwable e) {
                        rb.a(e);
                    }

                    public void onNext(ih$al updateComment) {
                        this.a.updateComment(updateComment);
                    }
                }));
                return;
            default:
                return;
        }
    }

    public void updateComment(ih$al updateComment) {
        this.c = updateComment.c;
        this.d = updateComment.d;
        this.e = updateComment.b;
        updateFullscreenView();
    }

    public void updatePost(ih$am updatePost) {
        Updates updates = updatePost.a.updates;
        this.c = updates.num_likes != null ? updates.num_likes.intValue() : this.c;
        this.d = updates.num_dislikes != null ? updates.num_dislikes.intValue() : this.d;
        this.e = updates.like_value != null ? updates.like_value.intValue() : this.e;
        if (updates.num_comments != null) {
            this.commentCount.setText(Integer.toString(updates.num_comments.intValue()));
        }
        updateFullscreenView();
    }

    public void updateFullscreenView() {
        this.likeCount.setText(Integer.toString(this.c));
        this.dislikeCount.setText(Integer.toString(this.d));
        if (this.e == 1) {
            this.likeIcon.setSelected(true);
            this.dislikeIcon.setSelected(false);
        } else if (this.e == -1) {
            this.likeIcon.setSelected(false);
            this.dislikeIcon.setSelected(true);
        } else {
            this.likeIcon.setSelected(false);
            this.dislikeIcon.setSelected(false);
        }
    }

    private void b() {
        this.trueCount.setText("True " + Integer.toString(this.f));
        this.falseCount.setText("False " + Integer.toString(this.g));
    }

    public void disableLikes() {
        this.likeContainer.setEnabled(false);
        this.dislikeContainer.setEnabled(false);
    }

    public void enableLikes() {
        this.likeContainer.setEnabled(true);
        this.dislikeContainer.setEnabled(true);
    }

    private void a(ImageView icon, int count, TextView text, boolean state) {
        if (state) {
            icon.setColorFilter(Color.parseColor("#FF0000"));
            text.setText("True " + Integer.toString(count + 1));
            return;
        }
        icon.clearColorFilter();
        text.setText("True " + Integer.toString(count - 1));
    }

    private void b(ImageView icon, int count, TextView text, boolean state) {
        if (state) {
            icon.setColorFilter(Color.parseColor("#FF0000"));
            text.setText("False " + Integer.toString(count + 1));
            return;
        }
        icon.clearColorFilter();
        text.setText("False " + Integer.toString(count - 1));
    }

    private void a(int postId, int likeValue, int isRumor) {
        ie.a().b(Integer.toString(postId), Integer.toString(likeValue), Integer.toString(isRumor)).b(Schedulers.io()).b(new apj<Post>(this) {
            final /* synthetic */ FullScreenImageActivity a;

            {
                this.a = this$0;
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
            }

            public void onNext(Post post) {
                iq.a().a(new ih$q(post));
            }
        });
    }
}
