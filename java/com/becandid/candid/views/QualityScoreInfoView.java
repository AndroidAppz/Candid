package com.becandid.candid.views;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.becandid.candid.activities.PopupWithBlurBackgroundActivity;
import defpackage.iu;

public class QualityScoreInfoView extends BlurLayout {
    @BindView(2131624075)
    View mBadgeContainer;
    @BindView(2131624732)
    Button mClosePopup;
    @BindView(2131624077)
    TextView mScoreDesc;
    @BindView(2131624485)
    TextView mScoreText;
    @BindView(2131624076)
    TextView mScoreTitle;

    public QualityScoreInfoView(final Activity context, String blurFileName, String score, String title, String desc) {
        super(context);
        this.a = blurFileName;
        LayoutInflater.from(context).inflate(2130968726, this, true);
        ButterKnife.bind(this);
        a();
        iu.a(this.mBadgeContainer, "#ffffff");
        this.mScoreText.setText(score);
        this.mScoreTitle.setText(title);
        this.mScoreDesc.setText(desc);
        this.mClosePopup.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ QualityScoreInfoView b;

            public void onClick(View v) {
                ((PopupWithBlurBackgroundActivity) context).slideOutAnimation(v);
            }
        });
    }

    public QualityScoreInfoView(Activity context, String blurFileName, String score) {
        super(context);
        this.a = blurFileName;
        LayoutInflater.from(context).inflate(2130968685, this, true);
        ButterKnife.bind(this);
        a();
        iu.a(this.mBadgeContainer, "#ffffff");
        this.mScoreText.setText(score);
    }
}
