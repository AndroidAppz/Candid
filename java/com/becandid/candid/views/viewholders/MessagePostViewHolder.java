package com.becandid.candid.views.viewholders;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.activities.PostDetailsActivity;
import com.becandid.candid.data.Message;
import com.becandid.candid.data.Post;
import com.becandid.candid.util.RoundedCornersTransformation;
import com.becandid.candid.util.RoundedCornersTransformation.CornerType;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import defpackage.ic;
import defpackage.ii;
import defpackage.iu;
import defpackage.iv;
import defpackage.nz;
import defpackage.qc;
import defpackage.qr;
import defpackage.rb;
import java.text.DecimalFormat;

public class MessagePostViewHolder extends iv {
    @BindView(2131624252)
    View mHeader;
    @BindView(2131624706)
    public TextView mPostAuthor;
    @BindView(2131624364)
    TextView mPostCaption;
    @BindView(2131624715)
    public TextView mPostGroup;
    @BindView(2131624712)
    public FrameLayout mPostGroupContainer;
    @BindView(2131624714)
    public View mPostGroupMenu;
    @BindView(2131624713)
    RelativeLayout mPostGroupMenuContainer;
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
    @BindView(2131624365)
    ImageView mPostImage;
    @BindView(2131624369)
    TextView mPostLinkDesc;
    @BindView(2131624370)
    TextView mPostLinkDomain;
    @BindView(2131624367)
    ImageView mPostLinkImage;
    @BindView(2131624366)
    LinearLayout mPostLinkPlacehoder;
    @BindView(2131624368)
    TextView mPostLinkTitle;
    @BindView(2131624704)
    public ImageView mPostModIcon;
    @BindView(2131624705)
    View mPostPopupAction;
    @BindView(2131624363)
    LinearLayout mPostRow;
    @BindView(2131624711)
    public TextView mPostTimestamp;
    @BindView(2131624371)
    TextView messagePostDeleted;
    @BindView(2131624362)
    FrameLayout messagePostWrapper;

    public MessagePostViewHolder(View itemView, Activity context) {
        super(itemView, context);
    }

    public static void a(MessagePostViewHolder holder, Message message) {
        final Post post = message.post;
        if (post == null) {
            holder.mPostRow.setVisibility(8);
            holder.messagePostDeleted.setVisibility(0);
            return;
        }
        holder.mPostRow.setVisibility(0);
        holder.messagePostDeleted.setVisibility(8);
        final MessagePostViewHolder messagePostViewHolder = holder;
        holder.messagePostWrapper.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                PostDetailsActivity.startPostDetailsActivity(post.post_id, messagePostViewHolder.f, post.icon_color);
            }
        });
        holder.a(post, holder);
        iu.a(holder.mPostRow, post.icon_color);
        holder.mPostCaption.setTypeface(ic.a(holder.f).a("JosefinSans-SemiBold.ttf"));
        String textCaption = post.caption;
        if (textCaption != null) {
            holder.mPostCaption.setText(iu.a(textCaption, Color.parseColor("#99FFFFFF"), 100, 3));
        } else {
            holder.mPostCaption.setVisibility(8);
        }
        boolean linkPost = false;
        if (post.link_domain != null) {
            holder.mPostLinkPlacehoder.setVisibility(0);
            holder.mPostLinkTitle.setText(post.og_title);
            holder.mPostLinkDesc.setText(post.og_desc);
            holder.mPostLinkDomain.setText(post.link_domain);
            linkPost = true;
        } else {
            holder.mPostLinkPlacehoder.setVisibility(8);
        }
        RoundedCornersTransformation mRoundedCornersTransformation = new RoundedCornersTransformation(holder.f, iu.a(10, holder.f), 3, CornerType.TOP);
        String url = null;
        boolean hasImage = false;
        if (post.thumb_url != null) {
            url = post.thumb_url;
            hasImage = true;
        } else if (post.source_url != null) {
            url = post.source_url;
            hasImage = true;
        }
        if (hasImage) {
            int width = post.width;
            int height = post.height;
            if (url == null || width == 0 || height == 0) {
                rb.a(new Exception("thumb_url and source_url are both null"));
                return;
            } else if (linkPost) {
                holder.mPostLinkImage.setVisibility(0);
                holder.mPostImage.setVisibility(8);
                GossipApplication.c.a(url).a().d().a(mRoundedCornersTransformation).a(DiskCacheStrategy.c).a(new qr<ImageView, nz>(holder.mPostLinkImage) {
                    public /* synthetic */ void onResourceReady(Object obj, qc qcVar) {
                        a((nz) obj, qcVar);
                    }

                    public void a(nz resource, qc<? super nz> qcVar) {
                        this.view.setImageDrawable(resource);
                    }
                });
                return;
            } else {
                holder.mPostImage.setVisibility(0);
                holder.mPostLinkImage.setVisibility(8);
                if (post.localBitmapPath != null) {
                    Options options = new Options();
                    options.inPreferredConfig = Config.ARGB_8888;
                    GossipApplication.c.a(BitmapFactory.decodeFile(post.localBitmapPath, options)).a().a(DiskCacheStrategy.c).a(new qr<ImageView, nz>(holder.mPostImage) {
                        public /* synthetic */ void onResourceReady(Object obj, qc qcVar) {
                            a((nz) obj, qcVar);
                        }

                        public void a(nz resource, qc<? super nz> qcVar) {
                            this.view.setImageDrawable(resource);
                        }
                    });
                    return;
                }
                GossipApplication.c.a(url).a().a(DiskCacheStrategy.c).a(new qr<ImageView, nz>(holder.mPostImage) {
                    public /* synthetic */ void onResourceReady(Object obj, qc qcVar) {
                        a((nz) obj, qcVar);
                    }

                    public void a(nz resource, qc<? super nz> qcVar) {
                        this.view.setImageDrawable(resource);
                    }
                });
                return;
            }
        }
        holder.mPostLinkImage.setVisibility(8);
        holder.mPostImage.setVisibility(8);
    }

    private void a(Post post, MessagePostViewHolder holder) {
        String icon = post.icon_name;
        int color = Color.parseColor(post.icon_color);
        if (post.is_candid_mod == 1) {
            holder.mPostIcon.setVisibility(8);
            holder.mPostModIcon.setVisibility(0);
        } else {
            a(icon, color, holder.mPostIcon, holder.f, 40);
            holder.mPostModIcon.setVisibility(8);
        }
        holder.mPostAuthor.setText(post.user_name);
        holder.mPostTimestamp.setText(post.post_time_ago);
        holder.mPostGroup.setText(post.group_name);
        holder.mPostGroup.setTextColor(color);
        LayoutParams margins = new LayoutParams(-2, -2);
        margins.setMargins(0, 0, 0, 0);
        holder.mPostGroup.setLayoutParams(margins);
        holder.mPostGroup.setPadding(iu.a(10, this.f), iu.a(4, this.f), iu.a(10, this.f), iu.a(4, this.f));
        if (post.quality_score != 0.0f || post.is_friend == 1 || post.thats_me == 1 || post.is_candid_mod == 1) {
            String score = new DecimalFormat("#").format((double) post.quality_score);
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
                    return;
                }
                holder.mPostHeaderBadgeDot.setVisibility(0);
                Drawable drawable = holder.f.getResources().getDrawable(2130837707);
                drawable.setColorFilter(color, Mode.SRC_IN);
                holder.mPostHeaderBadgeDot.setBackground(drawable);
                return;
            }
            holder.mPostHeaderBadgeScore.setVisibility(8);
            holder.mPostHeaderBadgeDot.setVisibility(8);
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
}
