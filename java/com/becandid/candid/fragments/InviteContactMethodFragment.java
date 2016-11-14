package com.becandid.candid.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.becandid.candid.activities.InviteContactsActivity;

public class InviteContactMethodFragment extends Fragment {
    private Unbinder a;
    private Bundle b;
    private boolean c = false;
    private boolean d = false;
    @BindView(2131624417)
    ImageView mAnonCheckmark;
    @BindView(2131624416)
    View mAnonPlaceHolder;
    @BindView(2131624422)
    Button mContinueBtn;
    @BindView(2131624420)
    ImageView mKnownCheckmark;
    @BindView(2131624419)
    View mKnownPlaceHolder;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(2130968666, container, false);
        this.a = ButterKnife.bind(this, view);
        this.b = getArguments();
        this.mAnonPlaceHolder.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ InviteContactMethodFragment a;

            {
                this.a = this$0;
            }

            public void onClick(View v) {
                boolean z = true;
                if (this.a.c) {
                    this.a.a(false);
                } else {
                    this.a.a(true);
                    this.a.b(false);
                    this.a.d = false;
                }
                InviteContactMethodFragment inviteContactMethodFragment = this.a;
                if (this.a.c) {
                    z = false;
                }
                inviteContactMethodFragment.c = z;
                this.a.a();
            }
        });
        this.mKnownPlaceHolder.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ InviteContactMethodFragment a;

            {
                this.a = this$0;
            }

            public void onClick(View v) {
                boolean z = true;
                if (this.a.d) {
                    this.a.b(false);
                } else {
                    this.a.a(false);
                    this.a.b(true);
                    this.a.c = false;
                }
                InviteContactMethodFragment inviteContactMethodFragment = this.a;
                if (this.a.d) {
                    z = false;
                }
                inviteContactMethodFragment.d = z;
                this.a.a();
            }
        });
        this.mContinueBtn.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ InviteContactMethodFragment a;

            {
                this.a = this$0;
            }

            public void onClick(View v) {
                if (this.a.c) {
                    Fragment fragment = new InviteContactSentFragment();
                    if (this.a.getActivity() instanceof InviteContactsActivity) {
                        ((InviteContactsActivity) this.a.getActivity()).switchFragment(fragment);
                    }
                } else if (this.a.d) {
                    InviteContactNameFragment fragment2 = new InviteContactNameFragment();
                    if (this.a.getActivity() instanceof InviteContactsActivity) {
                        ((InviteContactsActivity) this.a.getActivity()).switchFragment(fragment2);
                    }
                }
            }
        });
        return view;
    }

    private void a(boolean isSelected) {
        if (isSelected) {
            this.mAnonPlaceHolder.setBackground(getResources().getDrawable(2130837979));
            this.mAnonCheckmark.setImageDrawable(getResources().getDrawable(2130837980));
            return;
        }
        this.mAnonPlaceHolder.setBackground(getResources().getDrawable(2130837710));
        this.mAnonCheckmark.setImageDrawable(getResources().getDrawable(2130837709));
    }

    private void b(boolean isSelected) {
        if (isSelected) {
            this.mKnownPlaceHolder.setBackground(getResources().getDrawable(2130837979));
            this.mKnownCheckmark.setImageDrawable(getResources().getDrawable(2130837980));
            return;
        }
        this.mKnownPlaceHolder.setBackground(getResources().getDrawable(2130837710));
        this.mKnownCheckmark.setImageDrawable(getResources().getDrawable(2130837709));
    }

    private void a() {
        if (this.d || this.c) {
            this.mContinueBtn.setEnabled(true);
        } else {
            this.mContinueBtn.setEnabled(false);
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.a.unbind();
    }

    @OnClick({2131624411})
    public void onContactClose() {
        getActivity().finish();
    }
}
