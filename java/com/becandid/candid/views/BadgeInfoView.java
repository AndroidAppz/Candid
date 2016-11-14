package com.becandid.candid.views;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import defpackage.ib;
import defpackage.ib$a;
import defpackage.iu;

public class BadgeInfoView extends BlurLayout {
    private String b;
    private a c;
    @BindView(2131624075)
    View mBadgeContainer;
    @BindView(2131624077)
    TextView mBadgeDesc;
    @BindView(2131624079)
    ImageView mBadgeIcon;
    @BindView(2131624076)
    TextView mBadgeTitle;
    @BindView(2131624078)
    View seeAllBadges;

    public interface a {
        void a_();
    }

    public void setSeeAllBadgesListener(a listener) {
        this.c = listener;
    }

    public BadgeInfoView(Context context, String badgeName, boolean showAllBadges, String blurFileName) {
        super(context);
        this.b = badgeName;
        this.a = blurFileName;
        LayoutInflater.from(context).inflate(2130968602, this, true);
        ButterKnife.bind(this);
        a();
        ib$a badge = ib.a().a(this.b);
        if (badge != null) {
            this.mBadgeIcon.setImageResource(badge.c);
            this.mBadgeTitle.setText(badge.b);
            this.mBadgeDesc.setText(badge.d);
            this.mBadgeTitle.setTextColor(Color.parseColor(badge.e));
        }
        iu.a(this.mBadgeContainer, "#ffffff");
        if (showAllBadges) {
            this.seeAllBadges.setVisibility(0);
            this.seeAllBadges.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ BadgeInfoView a;

                {
                    this.a = this$0;
                }

                public void onClick(View v) {
                    this.a.c.a_();
                }
            });
            return;
        }
        this.seeAllBadges.setVisibility(8);
    }
}
