package com.becandid.candid.fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AlertDialog.Builder;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.becandid.candid.activities.CreateGroupActivity;
import com.becandid.candid.activities.GroupDetailsActivity;
import com.becandid.candid.data.Group;
import com.becandid.candid.models.GroupNameCheck;
import defpackage.apj;
import defpackage.apn;
import defpackage.ie;
import defpackage.iu;
import rx.schedulers.Schedulers;

public class GroupNameFragment extends Fragment {
    private Bundle a;
    private Unbinder b;
    @BindView(2131624401)
    TextView groupNameHeader;
    @BindView(2131624110)
    EditText groupNameInfo;
    @BindView(2131624400)
    View mNamePlaceholder;
    @BindView(2131624185)
    View mProgressBar;
    @BindView(2131624402)
    Button nextBtn;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(2130968664, container, false);
        this.b = ButterKnife.bind(this, view);
        this.a = getArguments();
        if (this.a.containsKey("group_name")) {
            this.groupNameHeader.setText("Group Name");
            this.groupNameInfo.setText(this.a.getString("group_name"));
            this.groupNameInfo.setSelection(this.a.getString("group_name").length());
            this.nextBtn.setEnabled(true);
        }
        this.groupNameInfo.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ GroupNameFragment a;

            {
                this.a = this$0;
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            public void afterTextChanged(Editable s) {
                if (s.toString() == null || s.toString().isEmpty()) {
                    this.a.nextBtn.setEnabled(false);
                } else {
                    this.a.nextBtn.setEnabled(true);
                }
            }
        });
        this.nextBtn.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ GroupNameFragment a;

            {
                this.a = this$0;
            }

            public void onClick(View v) {
                this.a.mProgressBar.setVisibility(0);
                this.a.mNamePlaceholder.setAlpha(0.3f);
                String groupName = this.a.groupNameInfo.getText().toString();
                final boolean forPost = this.a.getActivity().getIntent().getBooleanExtra("for_post", false);
                if (this.a.a.containsKey("group_name") && groupName.equals(this.a.a.get("group_name"))) {
                    this.a.a();
                } else {
                    ie.a().a(groupName, forPost).b(Schedulers.io()).a(apn.a()).b(new apj<GroupNameCheck>(this) {
                        final /* synthetic */ AnonymousClass2 b;

                        public /* synthetic */ void onNext(Object obj) {
                            a((GroupNameCheck) obj);
                        }

                        public void onCompleted() {
                        }

                        public void onError(Throwable e) {
                        }

                        public void a(final GroupNameCheck groupNameCheck) {
                            if (groupNameCheck.isSuccess()) {
                                this.b.a.a();
                                return;
                            }
                            boolean isGroupNameExisted;
                            String error = groupNameCheck.getError();
                            final int groupId = groupNameCheck.getGroupId();
                            if (groupNameCheck.getGroupName() != null) {
                                isGroupNameExisted = true;
                            } else {
                                isGroupNameExisted = false;
                            }
                            Builder builder = new Builder(this.b.a.getActivity());
                            builder.setMessage(error);
                            if (isGroupNameExisted) {
                                builder.setPositiveButton(2131230945, new DialogInterface.OnClickListener(this) {
                                    final /* synthetic */ AnonymousClass1 c;

                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                        if (forPost) {
                                            Intent data = new Intent();
                                            Group group = new Group();
                                            group.group_id = groupNameCheck.getGroupId();
                                            group.group_name = groupNameCheck.getGroupName();
                                            data.putExtra("group", group);
                                            this.c.b.a.getActivity().setResult(-1, data);
                                        } else {
                                            this.c.b.a.getActivity().startActivity(GroupDetailsActivity.startGroupDetailsActivity(this.c.b.a.getContext(), groupId));
                                        }
                                        this.c.b.a.getActivity().finish();
                                    }
                                }).setNegativeButton(2131230887, new DialogInterface.OnClickListener(this) {
                                    final /* synthetic */ AnonymousClass1 a;

                                    {
                                        this.a = this$2;
                                    }

                                    public void onClick(DialogInterface dialog, int which) {
                                        this.a.b.a.mProgressBar.setVisibility(8);
                                        this.a.b.a.mNamePlaceholder.setAlpha(1.0f);
                                        dialog.dismiss();
                                    }
                                });
                            } else {
                                builder.setNeutralButton(2131230891, new DialogInterface.OnClickListener(this) {
                                    final /* synthetic */ AnonymousClass1 a;

                                    {
                                        this.a = this$2;
                                    }

                                    public void onClick(DialogInterface dialog, int which) {
                                        this.a.b.a.mProgressBar.setVisibility(8);
                                        this.a.b.a.mNamePlaceholder.setAlpha(1.0f);
                                        dialog.dismiss();
                                    }
                                });
                            }
                            AlertDialog dialog = builder.create();
                            dialog.setCanceledOnTouchOutside(false);
                            dialog.setCancelable(false);
                            dialog.show();
                        }
                    });
                }
            }
        });
        return view;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.b.unbind();
    }

    private void a() {
        Context activity = getActivity();
        iu.a(activity);
        if (activity instanceof CreateGroupActivity) {
            ((CreateGroupActivity) activity).setGroupName(this.groupNameInfo.getText().toString());
        }
        GroupInfoFragment groupInfoFragment = new GroupInfoFragment();
        groupInfoFragment.setArguments(this.a);
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(2131034128, 2131034129, 2131034130, 2131034131);
        transaction.replace(2131624107, groupInfoFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
