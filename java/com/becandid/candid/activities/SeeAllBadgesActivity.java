package com.becandid.candid.activities;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.becandid.candid.data.AppState;
import com.becandid.candid.views.BadgeInfoView;
import defpackage.apj;
import defpackage.hc;
import defpackage.ih$c;
import defpackage.iq;
import defpackage.rb;

public class SeeAllBadgesActivity extends BaseActivity {
    private BadgeInfoView b;
    @BindView(2131624269)
    FrameLayout mBadgeInfoContainer;
    @BindView(2131624268)
    RecyclerView mRecyclerView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(2130968624);
        ButterKnife.bind(this);
        setSupportActionBar((Toolbar) findViewById(2131624081));
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(2130837589);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        this.mRecyclerView.setHasFixedSize(true);
        this.mRecyclerView.setLayoutManager(gridLayoutManager);
        this.mRecyclerView.setAdapter(new hc(this));
        addToSubscriptionList(iq.a().a(ih$c.class, new apj<ih$c>(this) {
            final /* synthetic */ SeeAllBadgesActivity a;

            {
                this.a = this$0;
            }

            public void onCompleted() {
            }

            public void onError(Throwable e) {
                rb.a(e);
            }

            public void onNext(ih$c blurTaskFinished) {
                String blurPath = blurTaskFinished.a;
                this.a.b = new BadgeInfoView(this.a.getBaseContext(), blurTaskFinished.b, false, blurPath);
                this.a.mBadgeInfoContainer.setVisibility(0);
                this.a.mRecyclerView.setVisibility(8);
                this.a.mBadgeInfoContainer.addView(this.a.b);
                Animation slideUpAnimation = AnimationUtils.loadAnimation(this.a.getBaseContext(), 2131034137);
                slideUpAnimation.setDuration(500);
                final View badgeInfo = this.a.mBadgeInfoContainer.findViewById(2131624074);
                badgeInfo.startAnimation(slideUpAnimation);
                this.a.mBadgeInfoContainer.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass1 b;

                    public void onClick(View v) {
                        Animation slideDownAnimation = AnimationUtils.loadAnimation(this.b.a.getBaseContext(), 2131034132);
                        slideDownAnimation.setDuration(500);
                        badgeInfo.startAnimation(slideDownAnimation);
                        v.postDelayed(new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 a;

                            {
                                this.a = this$2;
                            }

                            public void run() {
                                this.a.b.a.mRecyclerView.setVisibility(0);
                                this.a.b.a.mBadgeInfoContainer.removeView(this.a.b.a.b);
                                this.a.b.a.mBadgeInfoContainer.setVisibility(8);
                            }
                        }, 500);
                    }
                });
                AppState.blurTaskCalledOnFlight = false;
            }
        }));
    }

    public void onBackPressed() {
        super.onBackPressed();
        this.mRecyclerView.setVisibility(0);
        this.mBadgeInfoContainer.removeView(this.b);
        this.mBadgeInfoContainer.setVisibility(8);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == 16908332) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
