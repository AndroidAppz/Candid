package com.becandid.candid.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import defpackage.iu;

public class ModeratorInfoView extends BlurLayout {
    @BindView(2131624075)
    View mBadgeContainer;
    @BindView(2131624077)
    TextView mModDesc;
    @BindView(2131624076)
    TextView mModTitle;

    public ModeratorInfoView(Context context, String blurFileName, String title, String desc) {
        super(context);
        this.a = blurFileName;
        LayoutInflater.from(context).inflate(2130968700, this, true);
        ButterKnife.bind(this);
        a();
        iu.a(this.mBadgeContainer, "#ffffff");
        this.mModTitle.setText(title);
        this.mModDesc.setText(desc);
    }
}
