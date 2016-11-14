package com.becandid.candid.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.becandid.candid.activities.InviteContactsActivity;

public class InviteContactNameFragment extends Fragment {
    private Unbinder a;
    @BindView(2131624067)
    ImageView mBackNav;
    @BindView(2131624426)
    AppCompatEditText mInviteName;
    @BindView(2131624427)
    Button mSendText;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(2130968667, container, false);
        this.a = ButterKnife.bind(this, view);
        this.mInviteName.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ InviteContactNameFragment a;

            {
                this.a = this$0;
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            public void afterTextChanged(Editable s) {
                if (s.toString().isEmpty()) {
                    this.a.mSendText.setEnabled(false);
                } else {
                    this.a.mSendText.setEnabled(true);
                }
            }
        });
        this.mSendText.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ InviteContactNameFragment a;

            {
                this.a = this$0;
            }

            public void onClick(View v) {
                if (this.a.getActivity() instanceof InviteContactsActivity) {
                    ((InviteContactsActivity) this.a.getActivity()).setSendInviteName(this.a.mInviteName.getText().toString());
                    InviteContactSentFragment inviteContactSentFragment = new InviteContactSentFragment();
                    FragmentTransaction transaction = this.a.getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.setCustomAnimations(2131034128, 2131034129, 2131034130, 2131034131);
                    transaction.replace(2131624107, inviteContactSentFragment, "SENT_FRAGMENT");
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            }
        });
        return view;
    }

    public void onPause() {
        super.onPause();
        ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(getView().getWindowToken(), 0);
    }

    public void onDestroyView() {
        super.onDestroyView();
        getActivity().getWindow().setSoftInputMode(3);
    }

    public void backNavClick(View backNav) {
        getActivity().onBackPressed();
    }
}
