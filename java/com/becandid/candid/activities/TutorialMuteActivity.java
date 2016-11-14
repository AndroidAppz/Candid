package com.becandid.candid.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.data.AppState;

public class TutorialMuteActivity extends FragmentActivity {
    @BindView(2131624285)
    View muteNo;
    @BindView(2131624284)
    View muteYes;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(2130968627);
        ButterKnife.bind(this);
        this.muteYes.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ TutorialMuteActivity a;

            {
                this.a = this$0;
            }

            public void onClick(View v) {
                this.a.setResult(PostDetailsActivity.MUTE_THREAD);
                this.a.finishTutorial();
            }
        });
        this.muteNo.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ TutorialMuteActivity a;

            {
                this.a = this$0;
            }

            public void onClick(View v) {
                this.a.finishTutorial();
            }
        });
    }

    public void finishTutorial() {
        AppState.hasMuted = true;
        AppState.saveState(GossipApplication.a());
        finish();
    }

    public void onBackPressed() {
    }
}
