package com.becandid.candid.views.viewholders;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.PopupMenu.OnMenuItemClickListener;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.activities.ContentEditActivity;
import com.becandid.candid.activities.GroupDetailsActivity;
import com.becandid.candid.activities.InviteContactsActivity;
import com.becandid.candid.activities.InviteContactsActivity.InviteFlowTypes;
import com.becandid.candid.activities.MessageActivity;
import com.becandid.candid.activities.PostDetailsActivity;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.DataUtil;
import com.becandid.candid.data.EmptyClass;
import com.becandid.candid.data.Group;
import com.becandid.candid.data.Post;
import com.becandid.candid.data.TextTag;
import com.becandid.candid.models.NetworkData;
import com.becandid.thirdparty.BlurTask;
import com.becandid.thirdparty.BlurTask.BadgeType;
import com.facebook.FacebookException;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.SharePhotoContent.a;
import com.facebook.share.widget.ShareDialog;
import defpackage.apj;
import defpackage.apn;
import defpackage.bb;
import defpackage.ie;
import defpackage.ih$ah;
import defpackage.ih$n;
import defpackage.ih$p;
import defpackage.ih$q;
import defpackage.ih$r;
import defpackage.ii;
import defpackage.iq;
import defpackage.ir;
import defpackage.iu;
import defpackage.iv;
import defpackage.jh;
import defpackage.rb;
import defpackage.ub$a;
import defpackage.uc;
import defpackage.wi$a;
import java.text.DecimalFormat;
import java.util.ArrayList;
import rx.schedulers.Schedulers;

public abstract class BasePostViewHolder extends iv {
    @BindView(2131624692)
    public TextView mCommentPostBtn;
    @BindView(2131624729)
    public TextView mCommentPostBtnOgImage;
    @BindView(2131624688)
    View mFalseRumorContainer;
    @BindView(2131624725)
    View mFalseRumorContainerOgImage;
    @BindView(2131624689)
    ImageView mFalseRumorIcon;
    @BindView(2131624726)
    ImageView mFalseRumorIconOgImage;
    @BindView(2131624690)
    public TextView mFalseRumorText;
    @BindView(2131624727)
    public TextView mFalseRumorTextOgImage;
    @BindView(2131624255)
    View mFooter;
    @BindView(2131624697)
    TextView mFooterCommentIcon;
    @BindView(2131624700)
    ImageView mFooterCommentImage;
    @BindView(2131624698)
    ImageView mFooterCommentModIcon;
    @BindView(2131624694)
    View mFooterCommentSnippet;
    @BindView(2131624701)
    TextView mFooterCommentText;
    @BindView(2131624699)
    TextView mFooterCommentTimestamp;
    @BindView(2131624695)
    TextView mFooterCommentValue;
    @BindView(2131624252)
    View mHeader;
    @BindView(2131624682)
    public TextView mLikePostBtn;
    @BindView(2131624719)
    public TextView mLikePostBtnOgImage;
    @BindView(2131624706)
    public TextView mPostAuthor;
    @BindView(2131624115)
    TextView mPostCaption;
    @BindView(2131624377)
    TextView mPostCaptionOgImage;
    @BindView(2131624715)
    public TextView mPostGroup;
    @BindView(2131624712)
    public FrameLayout mPostGroupContainer;
    @BindView(2131624714)
    public View mPostGroupMenu;
    @BindView(2131624713)
    RelativeLayout mPostGroupMenuContainer;
    @BindView(2131624731)
    TextView mPostGroupOgImage;
    @BindView(2131624707)
    View mPostHeaderBadge;
    @BindView(2131624709)
    FrameLayout mPostHeaderBadgeDot;
    @BindView(2131624710)
    TextView mPostHeaderBadgeScore;
    @BindView(2131624708)
    TextView mPostHeaderBadgeText;
    @BindView(2131624703)
    public TextView mPostIcon;
    @BindView(2131624379)
    View mPostImageFooter;
    @BindView(2131624704)
    public ImageView mPostModIcon;
    @BindView(2131624705)
    View mPostPopupAction;
    @BindView(2131624733)
    View mPostRumorAlert;
    @BindView(2131624734)
    ImageView mPostRumorAlertDrawable;
    @BindView(2131624735)
    TextView mPostRumorAlertText;
    @BindView(2131624374)
    View mPostShareOgImage;
    @BindView(2131624711)
    public TextView mPostTimestamp;
    @BindView(2131624736)
    View mPostTrending;
    @BindView(2131624737)
    ImageView mPostTrendingDrawable;
    @BindView(2131624738)
    TextView mPostTrendingText;
    @BindView(2131624185)
    ProgressBar mProgressBar;
    @BindView(2131624693)
    public TextView mShareButton;
    @BindView(2131624683)
    View mTrueRumorContainer;
    @BindView(2131624720)
    View mTrueRumorContainerOgImage;
    @BindView(2131624684)
    ImageView mTrueRumorIcon;
    @BindView(2131624721)
    ImageView mTrueRumorIconOgImage;
    @BindView(2131624685)
    public TextView mTrueRumorText;
    @BindView(2131624722)
    public TextView mTrueRumorTextOgImage;
    @BindView(2131624687)
    public TextView mUnlikePostBtn;
    @BindView(2131624724)
    public TextView mUnlikePostBtnOgImage;

    public BasePostViewHolder(View itemView, Activity activity) {
        super(itemView, activity);
    }

    public static void a(BasePostViewHolder holder, Post post) {
        holder.d(post, holder);
        holder.b(post, holder);
        holder.c(post, holder);
        holder.a(post, holder);
        final Handler handler = new Handler(holder.f.getMainLooper());
        if (post.rumor == 1) {
            holder.mTrueRumorContainer.setVisibility(0);
            holder.mFalseRumorContainer.setVisibility(0);
            holder.mLikePostBtn.setVisibility(8);
            holder.mUnlikePostBtn.setVisibility(8);
            int opinionValue = post.opinion_value;
            int whiteColor = Color.parseColor("#FFFFFF");
            int redColor = Color.parseColor("#FF0000");
            int greenColor = Color.parseColor("#00FF00");
            if (opinionValue == 1) {
                holder.mTrueRumorIcon.setColorFilter(greenColor);
                holder.mFalseRumorIcon.setColorFilter(whiteColor);
            } else if (opinionValue == -1) {
                holder.mTrueRumorIcon.setColorFilter(whiteColor);
                holder.mFalseRumorIcon.setColorFilter(redColor);
            } else {
                holder.mTrueRumorIcon.setColorFilter(whiteColor);
                holder.mFalseRumorIcon.setColorFilter(whiteColor);
            }
            holder.mTrueRumorText.setText("True " + Integer.toString(post.num_true));
            holder.mFalseRumorText.setText("False " + Integer.toString(post.num_false));
            holder.mShareButton.setText(null);
        } else {
            holder.mTrueRumorContainer.setVisibility(8);
            holder.mFalseRumorContainer.setVisibility(8);
            holder.mLikePostBtn.setVisibility(0);
            holder.mUnlikePostBtn.setVisibility(0);
            holder.mShareButton.setText(2131230915);
            int likeValue = post.like_value;
            if (likeValue == 1) {
                holder.mLikePostBtn.setCompoundDrawablesWithIntrinsicBounds(2130838003, 0, 0, 0);
                holder.mUnlikePostBtn.setCompoundDrawablesWithIntrinsicBounds(2130838005, 0, 0, 0);
            } else if (likeValue == -1) {
                holder.mLikePostBtn.setCompoundDrawablesWithIntrinsicBounds(2130838007, 0, 0, 0);
                holder.mUnlikePostBtn.setCompoundDrawablesWithIntrinsicBounds(2130838004, 0, 0, 0);
            } else {
                holder.mLikePostBtn.setCompoundDrawablesWithIntrinsicBounds(2130838007, 0, 0, 0);
                holder.mUnlikePostBtn.setCompoundDrawablesWithIntrinsicBounds(2130838005, 0, 0, 0);
            }
        }
        final Post post2 = post;
        final BasePostViewHolder basePostViewHolder = holder;
        holder.mTrueRumorContainer.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                int opinionValue = post2.opinion_value;
                Post post;
                if (opinionValue == 1) {
                    basePostViewHolder.a(basePostViewHolder.mTrueRumorIcon, post2.num_true, basePostViewHolder.mTrueRumorText, false);
                    post2.opinion_value = 0;
                    post = post2;
                    post.num_true--;
                } else {
                    if (opinionValue == -1) {
                        basePostViewHolder.b(basePostViewHolder.mFalseRumorIcon, post2.num_false, basePostViewHolder.mFalseRumorText, false);
                        post = post2;
                        post.num_false--;
                    }
                    basePostViewHolder.a(basePostViewHolder.mTrueRumorIcon, post2.num_true, basePostViewHolder.mTrueRumorText, true);
                    post2.opinion_value = 1;
                    post = post2;
                    post.num_true++;
                }
                basePostViewHolder.a(post2.post_id, post2.opinion_value, 1, (Activity) basePostViewHolder.f);
            }
        });
        post2 = post;
        basePostViewHolder = holder;
        holder.mFalseRumorContainer.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                int opinionValue = post2.opinion_value;
                Post post;
                if (opinionValue == -1) {
                    basePostViewHolder.b(basePostViewHolder.mFalseRumorIcon, post2.num_false, basePostViewHolder.mFalseRumorText, false);
                    post2.opinion_value = 0;
                    post = post2;
                    post.num_false--;
                } else {
                    if (opinionValue == 1) {
                        basePostViewHolder.a(basePostViewHolder.mTrueRumorIcon, post2.num_true, basePostViewHolder.mTrueRumorText, false);
                        post = post2;
                        post.num_true--;
                    }
                    basePostViewHolder.b(basePostViewHolder.mFalseRumorIcon, post2.num_false, basePostViewHolder.mFalseRumorText, true);
                    post2.opinion_value = -1;
                    post = post2;
                    post.num_false++;
                }
                basePostViewHolder.a(post2.post_id, post2.opinion_value, 1, (Activity) basePostViewHolder.f);
            }
        });
        post2 = post;
        basePostViewHolder = holder;
        holder.mLikePostBtn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                int likeValue = post2.like_value;
                Post post;
                if (likeValue == 1) {
                    basePostViewHolder.a(basePostViewHolder.mLikePostBtn, false);
                    post2.like_value = 0;
                    post = post2;
                    post.num_likes--;
                } else {
                    if (likeValue == -1) {
                        basePostViewHolder.b(basePostViewHolder.mUnlikePostBtn, false);
                        post = post2;
                        post.num_dislikes--;
                    }
                    basePostViewHolder.a(basePostViewHolder.mLikePostBtn, true);
                    post = post2;
                    post.num_likes++;
                    post2.like_value = 1;
                }
                basePostViewHolder.a(post2.post_id, post2.like_value, 0, (Activity) basePostViewHolder.f);
            }
        });
        post2 = post;
        basePostViewHolder = holder;
        holder.mUnlikePostBtn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                int likeValue = post2.like_value;
                Post post;
                if (likeValue == -1) {
                    basePostViewHolder.b(basePostViewHolder.mUnlikePostBtn, false);
                    post2.like_value = 0;
                    post = post2;
                    post.num_dislikes--;
                } else {
                    if (likeValue == 1) {
                        basePostViewHolder.a(basePostViewHolder.mLikePostBtn, false);
                        post = post2;
                        post.num_likes--;
                    }
                    basePostViewHolder.b(basePostViewHolder.mUnlikePostBtn, true);
                    post = post2;
                    post.num_dislikes++;
                    post2.like_value = -1;
                }
                basePostViewHolder.a(post2.post_id, post2.like_value, 0, (Activity) basePostViewHolder.f);
            }
        });
        final BasePostViewHolder basePostViewHolder2 = holder;
        final Post post3 = post;
        holder.mCommentPostBtn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (!(basePostViewHolder2.f instanceof PostDetailsActivity)) {
                    Intent intent = new Intent(v.getContext(), PostDetailsActivity.class);
                    intent.putExtra("post_id", post3.post_id);
                    intent.putExtra("op_color", post3.icon_color);
                    v.getContext().startActivity(intent);
                }
            }
        });
        basePostViewHolder2 = holder;
        post3 = post;
        holder.mShareButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (AppState.config.getInt("enable_share_post", 0) == 1) {
                    PopupMenu popupMenu = new PopupMenu(basePostViewHolder2.f, v);
                    popupMenu.getMenuInflater().inflate(2131689481, popupMenu.getMenu());
                    popupMenu.show();
                    popupMenu.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                        final /* synthetic */ AnonymousClass15 a;

                        {
                            this.a = this$0;
                        }

                        public boolean onMenuItemClick(MenuItem item) {
                            switch (item.getItemId()) {
                                case 2131624796:
                                    basePostViewHolder2.a(basePostViewHolder2, post3, ir.a);
                                    return true;
                                case 2131624797:
                                    basePostViewHolder2.a(basePostViewHolder2, post3, 1989);
                                    return true;
                                case 2131624798:
                                    Intent intent = new Intent(basePostViewHolder2.f, InviteContactsActivity.class);
                                    intent.putExtra("invite_type", InviteFlowTypes.POST.toString());
                                    if (post3.thats_me == 1) {
                                        intent.putExtra("upsell_id", "-7," + String.valueOf(post3.post_id));
                                    } else {
                                        intent.putExtra("upsell_id", "-3," + String.valueOf(post3.post_id));
                                    }
                                    basePostViewHolder2.f.startActivity(intent);
                                    return true;
                                case 2131624799:
                                    ir.a(basePostViewHolder2.f, post3.share_info.url, "Share Link");
                                    return true;
                                default:
                                    return false;
                            }
                        }
                    });
                    return;
                }
                Toast.makeText(basePostViewHolder2.f, "Sharing is not available", 0).show();
            }
        });
        basePostViewHolder2 = holder;
        post3 = post;
        holder.mPostPopupAction.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                final Context context = basePostViewHolder2.f;
                PopupMenu popupMenu = new PopupMenu(basePostViewHolder2.f, v);
                popupMenu.getMenuInflater().inflate(2131689480, popupMenu.getMenu());
                if (post3.thats_me == 1) {
                    if (post3.caption == null || post3.caption.equals("")) {
                        popupMenu.getMenu().getItem(0).setVisible(false);
                    } else {
                        popupMenu.getMenu().getItem(0).setVisible(true);
                    }
                    popupMenu.getMenu().getItem(1).setVisible(true);
                    popupMenu.getMenu().getItem(2).setVisible(false);
                    popupMenu.getMenu().getItem(3).setVisible(false);
                    popupMenu.getMenu().getItem(4).setVisible(false);
                } else {
                    popupMenu.getMenu().getItem(0).setVisible(false);
                    popupMenu.getMenu().getItem(1).setVisible(false);
                    if (!AppState.config.getBoolean("messaging_turned_on", true) || post3.thats_me == 1) {
                        popupMenu.getMenu().getItem(2).setVisible(false);
                    } else {
                        popupMenu.getMenu().getItem(2).setVisible(true);
                    }
                    popupMenu.getMenu().getItem(3).setVisible(true);
                    popupMenu.getMenu().getItem(4).setVisible(true);
                }
                if (post3.can_mute == 1 && post3.muted_post == 0) {
                    popupMenu.getMenu().getItem(5).setVisible(true);
                    popupMenu.getMenu().getItem(6).setVisible(false);
                } else if (post3.can_mute == 1 && post3.muted_post == 1) {
                    popupMenu.getMenu().getItem(5).setVisible(false);
                    popupMenu.getMenu().getItem(6).setVisible(true);
                }
                popupMenu.show();
                final Builder builder = new Builder(context);
                popupMenu.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                    final /* synthetic */ AnonymousClass16 c;

                    public boolean onMenuItemClick(MenuItem item) {
                        Intent intent;
                        switch (item.getItemId()) {
                            case 2131624789:
                                intent = new Intent(context, ContentEditActivity.class);
                                intent.putExtra("caption", post3.caption);
                                intent.putExtra("post_id", post3.post_id);
                                if (post3.mentioned_groups_info != null) {
                                    intent.putExtra("group_tags", post3.mentioned_groups_info);
                                }
                                context.startActivity(intent);
                                return true;
                            case 2131624790:
                                builder.setTitle(2131230795).setPositiveButton(2131230945, new DialogInterface.OnClickListener(this) {
                                    final /* synthetic */ AnonymousClass1 a;

                                    {
                                        this.a = this$1;
                                    }

                                    public void onClick(DialogInterface dialog, int which) {
                                        ie.a().a(post3, null).b(Schedulers.io()).a(apn.a()).b(new apj<EmptyClass>(this) {
                                            final /* synthetic */ AnonymousClass2 a;

                                            {
                                                this.a = this$2;
                                            }

                                            public /* synthetic */ void onNext(Object obj) {
                                                a((EmptyClass) obj);
                                            }

                                            public void onCompleted() {
                                                iq.a().a(new ih$r(post3.post_id));
                                                Context context = GossipApplication.a().getApplicationContext();
                                                Toast.makeText(context, context.getResources().getString(2131230949), 0).show();
                                            }

                                            public void onError(Throwable e) {
                                                String error = e.getLocalizedMessage();
                                            }

                                            public void a(EmptyClass emptyClass) {
                                                String has = emptyClass.toString();
                                            }
                                        });
                                    }
                                }).setNegativeButton(2131230887, new DialogInterface.OnClickListener(this) {
                                    final /* synthetic */ AnonymousClass1 a;

                                    {
                                        this.a = this$1;
                                    }

                                    public void onClick(DialogInterface dialog, int which) {
                                    }
                                });
                                builder.create().show();
                                return true;
                            case 2131624791:
                                if (post3.messaging_blocked != null) {
                                    new Builder(context).setMessage(post3.messaging_blocked).setPositiveButton(2131230891, null).show();
                                    return true;
                                } else if (post3.messaging_disabled != null) {
                                    new Builder(context).setMessage(post3.messaging_disabled).setPositiveButton(2131230891, null).show();
                                    return true;
                                } else {
                                    intent = new Intent(context, MessageActivity.class);
                                    intent.putExtra("post_id", Integer.toString(post3.post_id));
                                    intent.putExtra("user_name", post3.user_name);
                                    context.startActivity(intent);
                                    return true;
                                }
                            case 2131624792:
                                builder.setTitle(2131230904).setMessage(2131230903).setPositiveButton(2131230945, new DialogInterface.OnClickListener(this) {
                                    final /* synthetic */ AnonymousClass1 a;

                                    {
                                        this.a = this$1;
                                    }

                                    public void onClick(DialogInterface dialog, int which) {
                                        ie.a().b(post3, context.getString(2131230855)).b(Schedulers.io()).a(apn.a()).b(new apj<EmptyClass>(this) {
                                            final /* synthetic */ AnonymousClass3 a;

                                            {
                                                this.a = this$2;
                                            }

                                            public /* synthetic */ void onNext(Object obj) {
                                                a((EmptyClass) obj);
                                            }

                                            public void onCompleted() {
                                                iq.a().a(new ih$r(post3.post_id));
                                                Context context = GossipApplication.a().getApplicationContext();
                                                Toast.makeText(context, context.getResources().getString(2131230952), 0).show();
                                            }

                                            public void onError(Throwable e) {
                                            }

                                            public void a(EmptyClass emptyClass) {
                                            }
                                        });
                                    }
                                }).setNegativeButton(2131230887, null);
                                builder.create().show();
                                return true;
                            case 2131624793:
                                final int[] reasonPos = new int[]{-1};
                                final String[] chars = new String[]{context.getString(2131230889), context.getString(2131230922), context.getString(2131230854), context.getString(2131230890)};
                                builder.setTitle(2131230944).setSingleChoiceItems(chars, -1, new DialogInterface.OnClickListener(this) {
                                    final /* synthetic */ AnonymousClass1 b;

                                    public void onClick(DialogInterface dialog, int which) {
                                        reasonPos[0] = which;
                                        ((AlertDialog) dialog).getButton(-1).setEnabled(true);
                                    }
                                }).setPositiveButton(2131230891, new DialogInterface.OnClickListener(this) {
                                    final /* synthetic */ AnonymousClass1 c;

                                    public void onClick(DialogInterface dialog, int which) {
                                        if (reasonPos[0] < 0) {
                                            Log.d("BPVH", "No reason selected");
                                        } else {
                                            ie.a().b(post3, chars[reasonPos[0]]).b(Schedulers.io()).a(apn.a()).b(new apj<EmptyClass>(this) {
                                                final /* synthetic */ AnonymousClass5 a;

                                                {
                                                    this.a = this$2;
                                                }

                                                public /* synthetic */ void onNext(Object obj) {
                                                    a((EmptyClass) obj);
                                                }

                                                public void onCompleted() {
                                                    iq.a().a(new ih$r(post3.post_id));
                                                    Context context = GossipApplication.a().getApplicationContext();
                                                    Toast.makeText(context, context.getResources().getString(2131230952), 0).show();
                                                }

                                                public void onError(Throwable e) {
                                                }

                                                public void a(EmptyClass emptyClass) {
                                                }
                                            });
                                        }
                                    }
                                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener(this) {
                                    final /* synthetic */ AnonymousClass1 a;

                                    {
                                        this.a = this$1;
                                    }

                                    public void onClick(DialogInterface dialog, int which) {
                                    }
                                });
                                AlertDialog dialog = builder.create();
                                dialog.setOnShowListener(new OnShowListener(this) {
                                    final /* synthetic */ AnonymousClass1 b;

                                    public void onShow(DialogInterface dialog) {
                                        if (reasonPos[0] < 0) {
                                            ((AlertDialog) dialog).getButton(-1).setEnabled(false);
                                        }
                                    }
                                });
                                dialog.show();
                                return true;
                            case 2131624794:
                                ie.a().e(Integer.toString(post3.post_id)).b(Schedulers.io()).a(apn.a()).b(new apj<EmptyClass>(this) {
                                    final /* synthetic */ AnonymousClass1 a;

                                    {
                                        this.a = this$1;
                                    }

                                    public /* synthetic */ void onNext(Object obj) {
                                        a((EmptyClass) obj);
                                    }

                                    public void onCompleted() {
                                    }

                                    public void onError(Throwable e) {
                                    }

                                    public void a(EmptyClass emptyClass) {
                                        builder.setTitle("Muted").setMessage("You will no longer receive notifications about this post.").setPositiveButton(2131230891, null);
                                        builder.create().show();
                                        post3.muted_post = 1;
                                        if (context instanceof PostDetailsActivity) {
                                            ((PostDetailsActivity) context).toggleMuteIcon();
                                        }
                                    }
                                });
                                return true;
                            case 2131624795:
                                ie.a().f(Integer.toString(post3.post_id)).b(Schedulers.io()).a(apn.a()).b(new apj<EmptyClass>(this) {
                                    final /* synthetic */ AnonymousClass1 a;

                                    {
                                        this.a = this$1;
                                    }

                                    public /* synthetic */ void onNext(Object obj) {
                                        a((EmptyClass) obj);
                                    }

                                    public void onCompleted() {
                                    }

                                    public void onError(Throwable e) {
                                    }

                                    public void a(EmptyClass emptyClass) {
                                        builder.setTitle("Unmuted Post").setMessage("You will receive notifications about this post again.").setPositiveButton(2131230891, null);
                                        builder.create().show();
                                        post3.muted_post = 0;
                                        if (context instanceof PostDetailsActivity) {
                                            ((PostDetailsActivity) context).toggleMuteIcon();
                                        }
                                    }
                                });
                                return true;
                            default:
                                return false;
                        }
                    }
                });
            }
        });
        int disableGroupTagging = AppState.config.getInt("disable_group_tagging", 0);
        String textCaption = post.caption;
        boolean seeMore = false;
        if (textCaption != null) {
            Spannable spannable;
            int start;
            Spannable spannableString = new SpannableString(textCaption);
            if (!((holder.f instanceof PostDetailsActivity) || AppState.expandedPostIds == null || AppState.expandedPostIds.contains(Integer.valueOf(post.post_id)))) {
                spannable = iu.a(textCaption, Color.parseColor("#99FFFFFF"));
                if (spannable.toString().endsWith("See More")) {
                    seeMore = true;
                    holder.mPostCaption.setText(spannable);
                    post2 = post;
                    holder.mPostCaption.setOnClickListener(new OnClickListener() {
                        public void onClick(View v) {
                            handler.post(new Runnable(this) {
                                final /* synthetic */ AnonymousClass17 a;

                                {
                                    this.a = this$0;
                                }

                                public void run() {
                                    AppState.expandedPostIds.add(Integer.valueOf(post2.post_id));
                                    iq.a().a(new ih$ah(post2.post_id));
                                }
                            });
                        }
                    });
                }
            }
            ArrayList<TextTag> tagIndexes = new ArrayList();
            if (disableGroupTagging == 0 && post.mentioned_groups_info != null) {
                for (String group : post.mentioned_groups_info.split(";")) {
                    String[] indices = group.split(",");
                    tagIndexes.add(new TextTag(Integer.parseInt(indices[1]), Integer.parseInt(indices[2]), Integer.parseInt(indices[0])));
                }
            }
            DataUtil.sortTextTags(tagIndexes, 0, tagIndexes.size() - 1);
            int index = 0;
            while (!tagIndexes.isEmpty()) {
                TextTag currTag = (TextTag) tagIndexes.remove(0);
                if (currTag.startIndex >= spannable.length() || currTag.endIndex > spannable.length() || currTag.startIndex < 0 || currTag.endIndex <= 0 || (spannable.toString().endsWith("See More") && currTag.endIndex > spannable.length())) {
                    break;
                }
                start = index;
                if (start > spannable.length()) {
                    break;
                }
                while (index < currTag.startIndex) {
                    index++;
                }
                if (index > spannable.length()) {
                    index = spannable.length();
                }
                if (!(index - start <= 0 || (holder.f instanceof PostDetailsActivity) || seeMore)) {
                    spannable.setSpan(iu.a("#ffffff", post.post_id, holder.f, seeMore, post.icon_color), start, index, 33);
                }
                try {
                    spannable.setSpan(iu.a("#ffffff", currTag.groupId, holder.f), currTag.startIndex, currTag.endIndex, 33);
                    index = currTag.endIndex + 1;
                } catch (IndexOutOfBoundsException e) {
                    rb.a(e);
                }
            }
            start = index;
            while (index < spannable.length()) {
                index++;
            }
            if (!(index - start <= 0 || (holder.f instanceof PostDetailsActivity) || seeMore)) {
                spannable.setSpan(iu.a("#ffffff", post.post_id, holder.f, seeMore, post.icon_color), start, index, 33);
            }
            if (!((holder.f instanceof PostDetailsActivity) || seeMore)) {
                holder.mPostCaption.setTextIsSelectable(false);
            }
            holder.mPostCaption.setMovementMethod(LinkMovementMethod.getInstance());
            holder.mPostCaption.setText(spannable);
            return;
        }
        holder.mPostCaption.setText(textCaption);
    }

    private void a(int postId, int likeValue, int isRumor, final Activity context) {
        ie.a().b(Integer.toString(postId), Integer.toString(likeValue), Integer.toString(isRumor)).b(Schedulers.io()).b(new apj<Post>(this) {
            final /* synthetic */ BasePostViewHolder b;

            public /* synthetic */ void onNext(Object obj) {
                a((Post) obj);
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
            }

            public void a(Post post) {
                iq.a().a(new ih$q(post, context));
            }
        });
    }

    public void a(Post post, BasePostViewHolder holder) {
        int numLikes = post.num_likes;
        int numDislikes = post.num_dislikes;
        holder.mCommentPostBtn.setText(Integer.toString(post.num_comments));
        holder.mLikePostBtn.setText(Integer.toString(numLikes));
        holder.mUnlikePostBtn.setText(Integer.toString(numDislikes));
        String commentText = post.comment_text;
        String commentIcon = post.comment_icon_name;
        int commentImgHeight = post.comment_image_height;
        int commentImgWidth = post.comment_image_width;
        String commentSourceUrl = post.comment_source_url;
        String commentTimestamp = post.comment_time_ago;
        String commentStickerName = post.comment_sticker_name;
        int commentValue = post.num_comments;
        int commentIsCandidMod = post.comment_is_candid_mod;
        if (commentValue <= 1) {
            holder.mFooterCommentValue.setVisibility(8);
        } else {
            holder.mFooterCommentValue.setVisibility(0);
            holder.mFooterCommentValue.setText(String.format(holder.f.getString(2131230902), new Object[]{Integer.toString(commentValue)}));
        }
        if (commentIcon == null || commentIcon.isEmpty()) {
            holder.mFooterCommentSnippet.setVisibility(8);
        } else {
            holder.mFooterCommentSnippet.setVisibility(0);
            a(post.icon_color, commentIcon, commentText, commentTimestamp, commentSourceUrl, commentImgWidth, commentImgHeight, commentStickerName, holder, commentIsCandidMod, post.post_id);
        }
        iu.a(holder.mFooter);
    }

    public void a(final String icon_color, String commentIcon, String commentText, String commentTimestamp, String commentSourceUrl, int commentImgWidth, int commentImgHeight, String commentStickerName, BasePostViewHolder holder, int isMod, int post_id) {
        if (isMod == 1) {
            holder.mFooterCommentModIcon.setVisibility(0);
            holder.mFooterCommentIcon.setVisibility(8);
        } else {
            holder.mFooterCommentIcon.setVisibility(0);
            a(commentIcon, Color.parseColor(icon_color), holder.mFooterCommentIcon, holder.f, 25);
            holder.mFooterCommentModIcon.setVisibility(8);
        }
        holder.mFooterCommentTimestamp.setText(commentTimestamp);
        if (commentText == null || commentText.isEmpty()) {
            holder.mFooterCommentText.setVisibility(8);
        } else {
            holder.mFooterCommentText.setVisibility(0);
            holder.mFooterCommentText.setText(commentText);
        }
        boolean hasImage = (commentImgHeight == -1 || commentImgWidth == -1 || commentSourceUrl == null || commentSourceUrl.isEmpty()) ? false : true;
        boolean hasSticker = (commentImgHeight == -1 || commentImgWidth == -1 || commentStickerName == null) ? false : true;
        float density = holder.f.getResources().getDisplayMetrics().density;
        if (hasImage) {
            holder.mFooterCommentImage.setVisibility(0);
            holder.mFooterCommentImage.setLayoutParams(new LayoutParams((int) (((float) commentImgWidth) * density), (int) (((float) commentImgHeight) * density)));
            GossipApplication.c.a(commentSourceUrl).d().a(holder.mFooterCommentImage);
        } else if (hasSticker) {
            holder.mFooterCommentImage.setVisibility(0);
            holder.mFooterCommentImage.setLayoutParams(new LayoutParams((int) (((float) commentImgWidth) * density), (int) (((float) commentImgHeight) * density)));
            holder.mFooterCommentImage.setImageDrawable(GossipApplication.a.getResources().getDrawable(GossipApplication.a.getResources().getIdentifier(commentStickerName.toLowerCase(), "drawable", GossipApplication.a.getPackageName())));
        } else {
            holder.mFooterCommentImage.setVisibility(8);
        }
        final int i = post_id;
        holder.mFooterCommentSnippet.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BasePostViewHolder c;

            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), PostDetailsActivity.class);
                intent.putExtra("post_id", i);
                intent.putExtra("op_color", icon_color);
                intent.putExtra("scrollToBottom", true);
                this.c.f.startActivity(intent);
            }
        });
    }

    private void b(Post post, BasePostViewHolder holder) {
        int color = Color.parseColor(post.icon_color);
        if (post.trending != 1 || post.rumor == 1) {
            holder.mPostTrending.setVisibility(8);
            return;
        }
        holder.mPostTrending.setVisibility(0);
        holder.mPostTrendingDrawable.setColorFilter(color);
        holder.mPostTrendingText.setTextColor(color);
    }

    private void c(Post post, BasePostViewHolder holder) {
        int color = Color.parseColor(post.icon_color);
        if (post.rumor == 1) {
            holder.mPostRumorAlert.setVisibility(0);
            holder.mPostRumorAlertDrawable.setColorFilter(color);
            holder.mPostRumorAlertText.setTextColor(color);
            return;
        }
        holder.mPostRumorAlert.setVisibility(8);
    }

    private void d(Post post, BasePostViewHolder holder) {
        final BasePostViewHolder basePostViewHolder;
        final Post post2;
        String icon = post.icon_name;
        int color = Color.parseColor(post.icon_color);
        if (post.is_candid_mod == 1) {
            holder.mPostIcon.setVisibility(8);
            holder.mPostModIcon.setVisibility(0);
            basePostViewHolder = holder;
            holder.mPostModIcon.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ BasePostViewHolder b;

                public void onClick(View v) {
                    if (!AppState.blurTaskCalledOnFlight) {
                        AppState.blurTaskCalledOnFlight = true;
                        new BlurTask((Activity) basePostViewHolder.f, ((Activity) basePostViewHolder.f).findViewById(16908290), BadgeType.MOD, basePostViewHolder.f.getString(2131230882), basePostViewHolder.f.getString(2131230927)).execute(new Void[0]);
                    }
                }
            });
        } else {
            a(icon, color, holder.mPostIcon, holder.f, 40);
            if (AppState.config.getBoolean("messaging_turned_on", true) && post.thats_me != 1) {
                post2 = post;
                holder.mPostIcon.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ BasePostViewHolder b;

                    public void onClick(View v) {
                        if (post2.messaging_blocked != null) {
                            new Builder(this.b.f).setMessage(post2.messaging_blocked).setPositiveButton(2131230891, null).show();
                        } else if (post2.messaging_disabled != null) {
                            new Builder(this.b.f).setMessage(post2.messaging_disabled).setPositiveButton(2131230891, null).show();
                        } else if (AppState.hasMessagedFromAlert) {
                            Intent intent = new Intent(this.b.f, MessageActivity.class);
                            intent.putExtra("post_id", Integer.toString(post2.post_id));
                            if (post2.user_name != null) {
                                intent.putExtra("user_name", post2.user_name);
                            }
                            this.b.f.startActivity(intent);
                        } else {
                            new Builder(this.b.f).setTitle("Message User?").setMessage("Would you like to send this user a message?").setNegativeButton(this.b.f.getResources().getString(2131230887), null).setPositiveButton(this.b.f.getResources().getString(2131230945), new DialogInterface.OnClickListener(this) {
                                final /* synthetic */ AnonymousClass4 a;

                                {
                                    this.a = this$1;
                                }

                                public void onClick(DialogInterface dialog, int which) {
                                    Intent intent = new Intent(this.a.b.f, MessageActivity.class);
                                    intent.putExtra("post_id", Integer.toString(post2.post_id));
                                    if (post2.user_name != null) {
                                        intent.putExtra("user_name", post2.user_name);
                                    }
                                    this.a.b.f.startActivity(intent);
                                }
                            }).create().show();
                            AppState.hasMessagedFromAlert = true;
                            AppState.saveState(GossipApplication.a());
                        }
                    }
                });
                holder.mPostModIcon.setVisibility(8);
            }
        }
        holder.mPostAuthor.setText(post.user_name);
        Drawable triangle = new jh();
        triangle.a(Color.parseColor("#ffffff"));
        int width = iu.a(10, this.f);
        int height = iu.a(6, this.f);
        int lower = iu.a(1, this.f);
        triangle.setBounds(0, lower, width, height);
        holder.mPostAuthor.setCompoundDrawables(null, null, triangle, null);
        holder.mPostTimestamp.setText(post.post_time_ago);
        holder.mPostGroup.setText(post.group_name);
        holder.mPostGroup.setTextColor(color);
        post2 = post;
        holder.mPostGroup.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BasePostViewHolder b;

            public void onClick(View v) {
                if (!(this.b.f instanceof GroupDetailsActivity)) {
                    Intent intent = new Intent(this.b.f, GroupDetailsActivity.class);
                    intent.putExtra("group_id", post2.group_id);
                    this.b.f.startActivity(intent);
                }
            }
        });
        post2 = post;
        holder.mPostGroupContainer.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BasePostViewHolder b;

            public void onClick(View v) {
                if (!(this.b.f instanceof GroupDetailsActivity)) {
                    Intent intent = new Intent(this.b.f, GroupDetailsActivity.class);
                    intent.putExtra("group_id", post2.group_id);
                    this.b.f.startActivity(intent);
                }
            }
        });
        Drawable triangleGroup = new jh();
        triangleGroup.a(color);
        triangleGroup.setBounds(0, lower, width, height);
        holder.mPostGroupMenu.setBackground(triangleGroup);
        basePostViewHolder = holder;
        final Post post3 = post;
        holder.mPostGroupMenuContainer.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BasePostViewHolder c;

            public void onClick(View view) {
                PopupMenu groupPopupMenu = new PopupMenu(view.getContext(), view);
                boolean join;
                if (basePostViewHolder.f instanceof GroupDetailsActivity) {
                    groupPopupMenu.setOnMenuItemClickListener((OnMenuItemClickListener) this.c.f);
                    join = true;
                    if (AppState.groups != null) {
                        for (Group group : AppState.groups) {
                            if (group.group_id == post3.group_id) {
                                if (group.moderator != 1) {
                                    groupPopupMenu.getMenu().add(1, 2131624770, 0, 2131230865);
                                    groupPopupMenu.getMenu().add(1, 2131624773, 0, 2131230907);
                                    join = false;
                                } else {
                                    groupPopupMenu.getMenu().add(1, 2131624774, 0, 2131230834);
                                    if (group.num_posts == 0) {
                                        groupPopupMenu.getMenu().add(1, 2131624772, 0, 2131230826);
                                    }
                                }
                            }
                        }
                    }
                    if (join) {
                        if (join) {
                            groupPopupMenu.getMenu().add(1, 2131624771, 0, 2131230861);
                        }
                        groupPopupMenu.getMenu().add(1, 2131624773, 0, 2131230907);
                    }
                    groupPopupMenu.show();
                    return;
                }
                groupPopupMenu.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                    final /* synthetic */ AnonymousClass7 a;

                    {
                        this.a = this$1;
                    }

                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case 2131624769:
                                basePostViewHolder.f.startActivity(GroupDetailsActivity.startGroupDetailsActivity(basePostViewHolder.f, post3.group_id));
                                break;
                            case 2131624770:
                                ie.a().c(post3.group_id).b(Schedulers.io()).a(apn.a()).b(new apj<NetworkData>(this) {
                                    final /* synthetic */ AnonymousClass1 a;

                                    {
                                        this.a = this$2;
                                    }

                                    public /* synthetic */ void onNext(Object obj) {
                                        a((NetworkData) obj);
                                    }

                                    public void onCompleted() {
                                    }

                                    public void onError(Throwable e) {
                                        rb.a(e);
                                        Log.d("GroupPopupLeave", e.toString());
                                    }

                                    public void a(NetworkData networkData) {
                                        for (int i = 0; i < AppState.groups.size(); i++) {
                                            if (((Group) AppState.groups.get(i)).group_id == post3.group_id) {
                                                AppState.groups.remove(i);
                                                break;
                                            }
                                        }
                                        iq.a().a(new ih$p(post3.group_id, post3.post_id));
                                    }
                                });
                                break;
                            case 2131624771:
                                ie.a().b(post3.group_id).b(Schedulers.io()).a(apn.a()).b(new apj<NetworkData>(this) {
                                    final /* synthetic */ AnonymousClass1 a;

                                    {
                                        this.a = this$2;
                                    }

                                    public /* synthetic */ void onNext(Object obj) {
                                        a((NetworkData) obj);
                                    }

                                    public void onCompleted() {
                                    }

                                    public void onError(Throwable e) {
                                        rb.a(e);
                                        Log.d("GroupPopupLeave", e.toString());
                                    }

                                    public void a(NetworkData networkData) {
                                        if (networkData.success) {
                                            iq.a().a(new ih$n(networkData.group.group_id, post3.post_id));
                                        }
                                    }
                                });
                                break;
                        }
                        return false;
                    }
                });
                groupPopupMenu.getMenu().add(1, 2131624769, 0, 2131230852);
                join = true;
                if (AppState.groups != null) {
                    for (Group group2 : AppState.groups) {
                        if (group2.group_id == post3.group_id) {
                            if (group2.moderator != 1) {
                                groupPopupMenu.getMenu().add(1, 2131624770, 0, 2131230865);
                                join = false;
                            }
                        }
                    }
                }
                if (join) {
                    groupPopupMenu.getMenu().add(1, 2131624771, 0, 2131230861);
                }
                groupPopupMenu.show();
            }
        });
        if (post.quality_score != 0.0f || post.is_friend == 1 || post.thats_me == 1 || post.is_candid_mod == 1) {
            final String score = new DecimalFormat("#").format((double) post.quality_score);
            holder.mPostHeaderBadge.setVisibility(0);
            String badgeText = "";
            if (post.is_candid_mod == 1) {
                badgeText = "MOD";
            } else if (post.thats_me == 1) {
                badgeText = "YOU";
            } else if (post.is_friend == 1) {
                badgeText = "FRIEND";
            }
            holder.mPostHeaderBadgeText.setText(badgeText);
            holder.mPostHeaderBadgeText.setTextColor(color);
            if (post.quality_score != 0.0f) {
                holder.mPostHeaderBadgeScore.setVisibility(0);
                holder.mPostHeaderBadgeScore.setText(score);
                holder.mPostHeaderBadgeScore.setTextColor(color);
                if (badgeText.isEmpty()) {
                    holder.mPostHeaderBadgeDot.setVisibility(8);
                } else {
                    holder.mPostHeaderBadgeDot.setVisibility(0);
                    Drawable drawable = holder.f.getResources().getDrawable(2130837707);
                    drawable.setColorFilter(color, Mode.SRC_IN);
                    holder.mPostHeaderBadgeDot.setBackground(drawable);
                }
            } else {
                holder.mPostHeaderBadgeScore.setVisibility(8);
                holder.mPostHeaderBadgeDot.setVisibility(8);
            }
            if (post.quality_score != 0.0f) {
                basePostViewHolder = holder;
                holder.mPostHeaderBadge.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ BasePostViewHolder c;

                    public void onClick(View v) {
                        if (!AppState.blurTaskCalledOnFlight) {
                            AppState.blurTaskCalledOnFlight = true;
                            new BlurTask((Activity) basePostViewHolder.f, ((Activity) basePostViewHolder.f).findViewById(16908290), score, BadgeType.POST_QUALITY_SCORE, basePostViewHolder.f.getString(2131230901), basePostViewHolder.f.getString(2131230925)).execute(new Void[0]);
                        }
                    }
                });
                return;
            }
            holder.mPostHeaderBadge.setOnClickListener(null);
            return;
        }
        holder.mPostHeaderBadge.setVisibility(8);
    }

    private void a(String icon, int color, TextView mPostIcon, Context context, int iconSize) {
        ii candidAnimals = ii.a();
        mPostIcon.setTypeface(ii.b());
        mPostIcon.setTextColor(color);
        mPostIcon.setText(ii.a(icon));
        mPostIcon.setTextSize(1, (float) iconSize);
        int iconWidth = mPostIcon.getWidth();
        if (iconWidth == 0) {
            iconWidth = (int) (mPostIcon.getResources().getDisplayMetrics().density * 40.0f);
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(context.getResources().getColor(17170443));
        gradientDrawable.setCornerRadius((float) (iconWidth / 2));
        mPostIcon.setBackground(gradientDrawable);
        mPostIcon.getBackground().setAlpha(192);
        mPostIcon.setVisibility(0);
    }

    private void a(TextView view, boolean state) {
        int currCount = Integer.parseInt(view.getText().toString());
        if (state) {
            view.setCompoundDrawablesWithIntrinsicBounds(2130838003, 0, 0, 0);
            view.setText(Integer.toString(currCount + 1));
            return;
        }
        view.setCompoundDrawablesWithIntrinsicBounds(2130838007, 0, 0, 0);
        view.setText(Integer.toString(currCount - 1));
    }

    private void b(TextView view, boolean state) {
        int currCount = Integer.parseInt(view.getText().toString());
        if (state) {
            view.setCompoundDrawablesWithIntrinsicBounds(2130838004, 0, 0, 0);
            view.setText(Integer.toString(currCount + 1));
            return;
        }
        view.setCompoundDrawablesWithIntrinsicBounds(2130838005, 0, 0, 0);
        view.setText(Integer.toString(currCount - 1));
    }

    private void a(ImageView icon, int count, TextView text, boolean state) {
        if (state) {
            icon.setColorFilter(Color.parseColor("#00FF00"));
            text.setText("True " + Integer.toString(count + 1));
            return;
        }
        icon.setColorFilter(Color.parseColor("#FFFFFF"));
        text.setText("True " + Integer.toString(count - 1));
    }

    private void b(ImageView icon, int count, TextView text, boolean state) {
        if (state) {
            icon.setColorFilter(Color.parseColor("#FF0000"));
            text.setText("False " + Integer.toString(count + 1));
            return;
        }
        icon.setColorFilter(Color.parseColor("#FFFFFF"));
        text.setText("False " + Integer.toString(count - 1));
    }

    public void a(BasePostViewHolder holder, Post post, int shareType) {
        holder.mPostShareOgImage.setVisibility(4);
        if (post.rumor == 1) {
            holder.mTrueRumorContainerOgImage.setVisibility(0);
            holder.mFalseRumorContainerOgImage.setVisibility(0);
            holder.mLikePostBtnOgImage.setVisibility(8);
            holder.mUnlikePostBtnOgImage.setVisibility(8);
            int whiteColor = Color.parseColor("#FFFFFF");
            holder.mTrueRumorIconOgImage.setColorFilter(whiteColor);
            holder.mFalseRumorIconOgImage.setColorFilter(whiteColor);
            holder.mTrueRumorTextOgImage.setText("True " + Integer.toString(post.num_true));
            holder.mFalseRumorTextOgImage.setText("False " + Integer.toString(post.num_false));
        } else {
            holder.mTrueRumorContainerOgImage.setVisibility(8);
            holder.mFalseRumorContainerOgImage.setVisibility(8);
            holder.mLikePostBtnOgImage.setVisibility(0);
            holder.mUnlikePostBtnOgImage.setVisibility(0);
            holder.mLikePostBtnOgImage.setText(Integer.toString(post.num_likes));
            holder.mUnlikePostBtnOgImage.setText(Integer.toString(post.num_dislikes));
        }
        holder.mCommentPostBtnOgImage.setText(Integer.toString(post.num_comments));
        holder.mPostCaptionOgImage.setText(post.caption);
        holder.mPostGroupOgImage.setText(post.group_name);
        GradientDrawable shape = new GradientDrawable();
        shape.setShape(0);
        shape.setColor(iu.a);
        holder.mPostImageFooter.setBackground(shape);
        final ShareDialog shareDialog = new ShareDialog((Activity) this.f);
        shareDialog.a(ub$a.a(), new uc<wi$a>(this) {
            final /* synthetic */ BasePostViewHolder a;

            {
                this.a = this$0;
            }

            public /* synthetic */ void onSuccess(Object obj) {
                a((wi$a) obj);
            }

            public void a(wi$a result) {
            }

            public void onError(FacebookException error) {
            }

            public void onCancel() {
            }
        });
        ViewTreeObserver viewTreeObserver = holder.mPostShareOgImage.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            final int i = shareType;
            final BasePostViewHolder basePostViewHolder = holder;
            final Post post2 = post;
            viewTreeObserver.addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
                final /* synthetic */ BasePostViewHolder e;

                public void onGlobalLayout() {
                    if (this.e.mPostShareOgImage != null) {
                        View v = this.e.mPostShareOgImage;
                        this.e.mPostShareOgImage.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        Bitmap bitmap = Bitmap.createBitmap(v.getWidth(), v.getHeight(), Config.ARGB_8888);
                        Canvas c = new Canvas(bitmap);
                        v.layout(0, 0, v.getMeasuredWidth(), v.getMeasuredHeight());
                        v.draw(c);
                        if (bitmap != null) {
                            if (i == ir.a) {
                                if (shareDialog != null) {
                                    SharePhotoContent content = new a().a(new SharePhoto.a().a(bitmap).c()).a();
                                    ShareDialog shareDialog = shareDialog;
                                    if (ShareDialog.a(SharePhotoContent.class)) {
                                        shareDialog.b(content);
                                    }
                                }
                            } else if (i == 1989) {
                                ir.a().a(bitmap);
                                ir.a().a(basePostViewHolder.f);
                                if (post2.share_info != null) {
                                    ir.a().a(post2.share_info.url);
                                }
                                if (bb.checkSelfPermission(basePostViewHolder.f, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                                    ActivityCompat.requestPermissions((Activity) basePostViewHolder.f, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 1989);
                                } else {
                                    ir.a().b();
                                }
                            }
                        }
                        basePostViewHolder.mPostShareOgImage.setVisibility(8);
                    }
                }
            });
        }
    }
}
