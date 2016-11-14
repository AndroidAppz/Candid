package com.becandid.candid.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.becandid.candid.activities.PopupWithBlurBackgroundActivity;
import com.becandid.candid.data.AppState;
import com.becandid.candid.models.EmptySubscriber;
import defpackage.apn;
import defpackage.ie;
import defpackage.ih$z;
import defpackage.iq;
import defpackage.iu;
import java.util.HashMap;
import java.util.Map;
import rx.schedulers.Schedulers;

public class MessagingPopupView extends BlurLayout {
    PopupWithBlurBackgroundActivity b;
    @BindView(2131624522)
    TextView badgeDescEnabled;
    private boolean c;
    private boolean d;
    @BindView(2131624532)
    ImageView mAutoCheckmark;
    @BindView(2131624531)
    View mAutoDeleteMsgContainer;
    @BindView(2131624079)
    ImageView mBadgeIcon;
    @BindView(2131624524)
    TextView mDisabledTextView;
    @BindView(2131624534)
    Button mFinishBtn;
    @BindView(2131624523)
    TextView mKeepEnabledTextView;
    @BindView(2131624529)
    ImageView mManualCheckmark;
    @BindView(2131624528)
    View mManualDeleteMsgContainer;
    @BindView(2131624535)
    View mMessageCloseBtn;
    @BindView(2131624525)
    View mMessageContainerDeleteMessage;
    @BindView(2131624520)
    View mMessageContainerEnabled;

    public MessagingPopupView(Context context, String blurFileName, boolean onNewMessage) {
        super(context);
        this.b = (PopupWithBlurBackgroundActivity) context;
        this.a = blurFileName;
        LayoutInflater.from(context).inflate(2130968693, this, true);
        ButterKnife.bind(this);
        a();
        iu.a(this.mMessageContainerEnabled, "#ffffff");
        if (onNewMessage) {
            this.badgeDescEnabled.setText(2131230950);
        } else {
            this.badgeDescEnabled.setText(2131230941);
        }
        this.mKeepEnabledTextView.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MessagingPopupView a;

            {
                this.a = this$0;
            }

            public void onClick(View v) {
                this.a.mMessageContainerEnabled.setVisibility(8);
                this.a.mMessageContainerDeleteMessage.setVisibility(0);
                Map<String, String> params = new HashMap();
                params.put("messaging_disabled", "0");
                ie.a().q(params).b(Schedulers.io()).a(apn.a()).b(new EmptySubscriber());
                AppState.account.messaging_disabled = 0;
                iq.a().a(new ih$z(0));
            }
        });
        this.mDisabledTextView.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MessagingPopupView a;

            {
                this.a = this$0;
            }

            public void onClick(View v) {
                Map<String, String> params = new HashMap();
                params.put("messaging_disabled", "1");
                ie.a().q(params).b(Schedulers.io()).a(apn.a()).b(new EmptySubscriber());
                AppState.account.messaging_disabled = 1;
                iq.a().a(new ih$z(1));
                this.a.b();
            }
        });
        this.mAutoDeleteMsgContainer.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MessagingPopupView a;

            {
                this.a = this$0;
            }

            public void onClick(View v) {
                boolean z = true;
                if (this.a.d) {
                    this.a.setAutoState(false);
                } else {
                    this.a.setAutoState(true);
                    this.a.setManualState(false);
                    this.a.c = false;
                }
                MessagingPopupView messagingPopupView = this.a;
                if (this.a.d) {
                    z = false;
                }
                messagingPopupView.d = z;
                this.a.c();
            }
        });
        this.mManualDeleteMsgContainer.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MessagingPopupView a;

            {
                this.a = this$0;
            }

            public void onClick(View v) {
                boolean z = true;
                if (this.a.c) {
                    this.a.setManualState(false);
                } else {
                    this.a.setAutoState(false);
                    this.a.setManualState(true);
                    this.a.d = false;
                }
                MessagingPopupView messagingPopupView = this.a;
                if (this.a.c) {
                    z = false;
                }
                messagingPopupView.c = z;
                this.a.c();
            }
        });
        this.mFinishBtn.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MessagingPopupView a;

            {
                this.a = this$0;
            }

            public void onClick(View v) {
                HashMap<String, String> params = new HashMap();
                int autoDeletetion = 0;
                if (this.a.d) {
                    autoDeletetion = 1;
                }
                params.put("message_auto_deletion", Integer.toString(autoDeletetion));
                AppState.account.message_auto_deletion = autoDeletetion;
                ie.a().q(params).b(Schedulers.io()).a(apn.a()).b(new EmptySubscriber());
                this.a.b();
            }
        });
        this.mMessageCloseBtn.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MessagingPopupView a;

            {
                this.a = this$0;
            }

            public void onClick(View v) {
                this.a.b();
            }
        });
        this.mManualDeleteMsgContainer.performClick();
    }

    private void b() {
        FrameLayout badgeInfoContainer = (FrameLayout) this.b.findViewById(2131624172);
        if (badgeInfoContainer != null) {
            this.b.slideOutAnimation(badgeInfoContainer);
        }
    }

    private void c() {
        if (this.c || this.d) {
            this.mFinishBtn.setEnabled(true);
        } else {
            this.mFinishBtn.setEnabled(false);
        }
    }

    private void setManualState(boolean isSelected) {
        if (isSelected) {
            this.mManualDeleteMsgContainer.setBackground(getResources().getDrawable(2130837979));
            this.mManualCheckmark.setImageDrawable(getResources().getDrawable(2130837980));
            return;
        }
        this.mManualDeleteMsgContainer.setBackground(getResources().getDrawable(2130837710));
        this.mManualCheckmark.setImageDrawable(getResources().getDrawable(2130837709));
    }

    private void setAutoState(boolean isSelected) {
        if (isSelected) {
            this.mAutoDeleteMsgContainer.setBackground(getResources().getDrawable(2130837979));
            this.mAutoCheckmark.setImageDrawable(getResources().getDrawable(2130837980));
            return;
        }
        this.mAutoDeleteMsgContainer.setBackground(getResources().getDrawable(2130837710));
        this.mAutoCheckmark.setImageDrawable(getResources().getDrawable(2130837709));
    }
}
