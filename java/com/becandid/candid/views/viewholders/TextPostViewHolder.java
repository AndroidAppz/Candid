package com.becandid.candid.views.viewholders;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import com.becandid.candid.data.Post;
import defpackage.ic;
import defpackage.iu;

public class TextPostViewHolder extends BasePostViewHolder {
    @BindView(2131624115)
    TextView mPostCaption;
    @BindView(2131624386)
    LinearLayout mPostCaptionPlaceholder;
    @BindView(2131624377)
    TextView mPostImageCaption;
    @BindView(2131624731)
    TextView mPostImageGroup;
    @BindView(2131624374)
    View mPostShareImage;
    @BindView(2131624385)
    View mPostTextRow;

    public TextPostViewHolder(View itemView, Activity context) {
        super(itemView, context);
    }

    public void a(BasePostViewHolder holder, Post post, int shareType) {
        super.a(holder, post, shareType);
        this.mPostShareImage.setVisibility(4);
        GradientDrawable shape = new GradientDrawable();
        if (post.icon_color != null) {
            shape.setColor(Color.parseColor(post.icon_color));
        }
        this.mPostShareImage.setBackground(shape);
        this.mPostImageCaption.setTypeface(ic.a(holder.f).a("JosefinSans-SemiBold.ttf"));
    }

    public static void a(TextPostViewHolder holder, Post post) {
        BasePostViewHolder.a((BasePostViewHolder) holder, post);
        iu.a(holder.mPostTextRow, post.icon_color);
        holder.mPostCaption.setTypeface(ic.a(holder.f).a("JosefinSans-SemiBold.ttf"));
    }
}
