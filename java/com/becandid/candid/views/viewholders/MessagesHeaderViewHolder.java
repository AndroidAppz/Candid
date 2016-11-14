package com.becandid.candid.views.viewholders;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import com.becandid.candid.data.User;
import defpackage.ii;
import defpackage.iv;

public class MessagesHeaderViewHolder extends iv {
    public static ii a;
    @BindView(2131624208)
    RelativeLayout messagesHeaderIconContainer;
    @BindView(2131624511)
    TextView messagesHeaderName;
    @BindView(2131624210)
    TextView messagesHeaderUserIcon;

    public MessagesHeaderViewHolder(View itemView) {
        super(itemView);
        a = ii.a();
    }

    public static void a(MessagesHeaderViewHolder holder, User myInfo) {
        int color = Color.parseColor(myInfo.icon_color);
        holder.messagesHeaderUserIcon.setTextColor(color);
        TextView textView = holder.messagesHeaderUserIcon;
        ii iiVar = a;
        textView.setTypeface(ii.b());
        textView = holder.messagesHeaderUserIcon;
        iiVar = a;
        textView.setText(ii.a(myInfo.icon_name));
        int iconWidth = holder.messagesHeaderIconContainer.getWidth();
        if (iconWidth == 0) {
            iconWidth = (int) (holder.messagesHeaderIconContainer.getResources().getDisplayMetrics().density * 30.0f);
        }
        int gradColor = (16777215 & color) | 1073741824;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(gradColor);
        gradientDrawable.setCornerRadius((float) (iconWidth / 2));
        holder.messagesHeaderIconContainer.setBackground(gradientDrawable);
        holder.messagesHeaderName.setText(myInfo.post_name);
        holder.messagesHeaderName.setTextColor(color);
    }
}
