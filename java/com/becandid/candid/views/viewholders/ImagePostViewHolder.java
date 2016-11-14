package com.becandid.candid.views.viewholders;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import butterknife.BindView;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.activities.FullScreenImageActivity;
import com.becandid.candid.activities.PostDetailsActivity;
import com.becandid.candid.data.Post;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import defpackage.iu;
import defpackage.rb;

public class ImagePostViewHolder extends BasePostViewHolder {
    @BindView(2131624115)
    TextView mPostCaption;
    @BindView(2131624373)
    ImageView mPostImage;
    @BindView(2131624378)
    ImageView mPostImageImage;
    @BindView(2131624372)
    View mPostImageRow;

    public ImagePostViewHolder(View itemView, Activity context) {
        super(itemView, context);
    }

    public void a(BasePostViewHolder viewHolder, Post post, int shareType) {
        super.a(viewHolder, post, shareType);
        Display display = ((WindowManager) viewHolder.f.getSystemService("window")).getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int phoneWidth = size.x;
        ImagePostViewHolder holder = (ImagePostViewHolder) viewHolder;
        holder.mPostImageImage.setImageDrawable(holder.mPostImage.getDrawable().getCurrent());
        holder.mPostImageImage.setLayoutParams(new LayoutParams(phoneWidth, post.actual_height));
        holder.mPostImageImage.setScaleType(ScaleType.FIT_XY);
    }

    public static void a(ImagePostViewHolder holder, Post post) {
        String url;
        BasePostViewHolder.a((BasePostViewHolder) holder, post);
        iu.a(holder.mPostImageRow, post.icon_color);
        if (post.thumb_url != null) {
            url = post.thumb_url;
        } else {
            url = post.source_url;
        }
        int width = post.width;
        int height = post.height;
        if (url == null || width == 0 || height == 0) {
            rb.a(new Exception("thumb_url and source_url are both null"));
            return;
        }
        if (post.actual_height == -1 && post.actual_width == -1) {
            Display display = ((WindowManager) holder.f.getSystemService("window")).getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            int imgWidth = size.x - (((int) (5.0f * (((float) holder.f.getResources().getDisplayMetrics().densityDpi) / 160.0f))) * 2);
            post.actual_height = (int) ((((float) imgWidth) * ((float) height)) / ((float) width));
            post.actual_width = imgWidth;
        }
        holder.mPostImage.setLayoutParams(new LayoutParams(post.actual_width, post.actual_height));
        holder.mPostImage.setBackgroundResource(17301613);
        if (post.localBitmapPath != null) {
            Options options = new Options();
            options.inPreferredConfig = Config.ARGB_8888;
            holder.mPostImage.setImageBitmap(BitmapFactory.decodeFile(post.localBitmapPath, options));
        } else {
            GossipApplication.c.a(url).d().a(DiskCacheStrategy.c).a(holder.mPostImage);
        }
        final ImagePostViewHolder imagePostViewHolder = holder;
        final Post post2 = post;
        holder.mPostImageRow.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (imagePostViewHolder.f instanceof PostDetailsActivity) {
                    Intent intent = new Intent(v.getContext(), FullScreenImageActivity.class);
                    Bundle extras = new Bundle();
                    extras.putInt("post_id", post2.post_id);
                    extras.putString("source_url", post2.source_url);
                    extras.putInt("num_likes", post2.num_likes);
                    extras.putInt("num_dislikes", post2.num_dislikes);
                    extras.putString("icon_name", post2.icon_name);
                    extras.putString("icon_color", post2.icon_color);
                    extras.putString("user_name", post2.user_name);
                    extras.putInt("like_value", post2.like_value);
                    extras.putInt("num_comments", post2.num_comments);
                    extras.putBoolean("fromDetails", true);
                    extras.putInt("is_rumor", post2.rumor);
                    extras.putInt("num_true", post2.num_true);
                    extras.putInt("num_false", post2.num_false);
                    extras.putInt("opinion_value", post2.opinion_value);
                    extras.putString("share_info_url", post2.share_info.url);
                    extras.putString("share_info_title", post2.share_info.title);
                    extras.putString("share_info_image", post2.share_info.image);
                    intent.putExtras(extras);
                    v.getContext().startActivity(intent);
                    return;
                }
                PostDetailsActivity.startPostDetailsActivity(post2.post_id, imagePostViewHolder.f, post2.icon_color);
            }
        });
        imagePostViewHolder = holder;
        post2 = post;
        holder.mPostImageRow.setOnLongClickListener(new OnLongClickListener() {
            public boolean onLongClick(View v) {
                if (!(imagePostViewHolder.f instanceof PostDetailsActivity)) {
                    Intent intent = new Intent(v.getContext(), FullScreenImageActivity.class);
                    Bundle extras = new Bundle();
                    extras.putInt("post_id", post2.post_id);
                    extras.putString("source_url", post2.source_url);
                    extras.putInt("num_likes", post2.num_likes);
                    extras.putInt("num_dislikes", post2.num_dislikes);
                    extras.putString("icon_name", post2.icon_name);
                    extras.putString("icon_color", post2.icon_color);
                    extras.putString("user_name", post2.user_name);
                    extras.putInt("like_value", post2.like_value);
                    extras.putInt("num_comments", post2.num_comments);
                    extras.putInt("is_rumor", post2.rumor);
                    extras.putInt("num_true", post2.num_true);
                    extras.putInt("num_false", post2.num_false);
                    extras.putInt("opinion_value", post2.opinion_value);
                    extras.putString("share_info_url", post2.share_info.url);
                    extras.putString("share_info_title", post2.share_info.title);
                    extras.putString("share_info_image", post2.share_info.image);
                    intent.putExtras(extras);
                    v.getContext().startActivity(intent);
                }
                return false;
            }
        });
    }
}
