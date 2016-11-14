package com.becandid.candid.fragments;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.activities.BaseActivity;
import com.becandid.candid.activities.CreateGroupActivity;
import com.becandid.candid.util.RoundedCornersTransformation;
import com.becandid.candid.util.RoundedCornersTransformation.CornerType;
import defpackage.apj;
import defpackage.ih$aa;
import defpackage.ih$ag;
import defpackage.ih$ao;
import defpackage.im;
import defpackage.iq;
import defpackage.iu;
import defpackage.rb;

public class GroupInfoFragment extends Fragment implements OnClickListener {
    private RoundedCornersTransformation a;
    private im b;
    private Unbinder c;
    private Bundle d;
    @BindView(2131624395)
    View mChoosePhotoPlaceholder;
    @BindView(2131624394)
    EditText mGroupInfo;
    @BindView(2131624396)
    ImageView mGroupPhoto;
    @BindView(2131624398)
    Button mNextBtn;
    @BindView(2131624399)
    Button mSkipBtn;

    public void a(im mPhotoHelper) {
        this.b = mPhotoHelper;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(2130968663, container, false);
        this.c = ButterKnife.bind(this, view);
        this.d = getArguments();
        this.mChoosePhotoPlaceholder.setOnClickListener(this);
        this.a = new RoundedCornersTransformation(getContext(), (int) (100.0f * getResources().getDisplayMetrics().density), 0, CornerType.ALL);
        if (this.d.containsKey("group_info")) {
            this.mGroupInfo.setText(this.d.getString("group_info"));
            this.mGroupInfo.setSelection(this.d.getString("group_info").length());
            this.mNextBtn.setEnabled(true);
        }
        this.mGroupInfo.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ GroupInfoFragment a;

            {
                this.a = this$0;
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            public void afterTextChanged(Editable s) {
                if (s.toString().isEmpty()) {
                    this.a.mNextBtn.setEnabled(false);
                } else {
                    this.a.mNextBtn.setEnabled(true);
                }
            }
        });
        a(((BaseActivity) getActivity()).getPhotoHelper());
        if (this.d.containsKey("source_url")) {
            this.b.choosePhoto(this.d.getString("source_url"), 0, 0);
            this.mNextBtn.setEnabled(true);
        }
        this.mSkipBtn.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ GroupInfoFragment a;

            {
                this.a = this$0;
            }

            public void onClick(View v) {
                Context activity = this.a.getActivity();
                iu.a(activity);
                if (activity instanceof CreateGroupActivity) {
                    ((CreateGroupActivity) activity).setGroupPhotoSkipped(true);
                    ((CreateGroupActivity) activity).setGroupSourceUrl(null);
                }
                GroupTagsFragment groupTagsFragment = new GroupTagsFragment();
                groupTagsFragment.setArguments(this.a.d);
                FragmentTransaction transaction = this.a.getActivity().getSupportFragmentManager().beginTransaction();
                transaction.setCustomAnimations(2131034128, 2131034129, 2131034130, 2131034131);
                transaction.replace(2131624107, groupTagsFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        this.mNextBtn.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ GroupInfoFragment a;

            {
                this.a = this$0;
            }

            public void onClick(View v) {
                Context activity = this.a.getActivity();
                iu.a(activity);
                if (activity instanceof CreateGroupActivity) {
                    ((CreateGroupActivity) activity).setGroupAbout(this.a.mGroupInfo.getText().toString());
                }
                GroupTagsFragment groupTagsFragment = new GroupTagsFragment();
                groupTagsFragment.setArguments(this.a.d);
                FragmentTransaction transaction = this.a.getActivity().getSupportFragmentManager().beginTransaction();
                transaction.setCustomAnimations(2131034128, 2131034129, 2131034130, 2131034131);
                transaction.replace(2131624107, groupTagsFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        return view;
    }

    public void choosePhoto() {
        if (this.b == null) {
            this.b = new im((BaseActivity) getActivity());
        }
        FragmentActivity activity = getActivity();
        if (activity instanceof CreateGroupActivity) {
            this.b.choosePhoto(((CreateGroupActivity) activity).getmGroupName());
        } else {
            this.b.choosePhoto();
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.c.unbind();
    }

    public void a() {
        if (this.b != null) {
            if (this.b.f != null && this.b.b != null && this.b.a != null) {
                this.mGroupPhoto.setImageBitmap((Bitmap) this.a.a(this.b.f, this.mGroupPhoto.getWidth(), this.mGroupPhoto.getHeight()).b());
                this.b.a();
                ((BaseActivity) getActivity()).addToSubscriptionList(iq.a().a(ih$ag.class, new apj<ih$ag>(this) {
                    final /* synthetic */ GroupInfoFragment a;

                    {
                        this.a = this$0;
                    }

                    public /* synthetic */ void onNext(Object obj) {
                        a((ih$ag) obj);
                    }

                    public void onCompleted() {
                    }

                    public void onError(Throwable e) {
                        rb.a(e);
                    }

                    public void a(ih$ag s3UploadResponse) {
                        if (s3UploadResponse.b) {
                            iq.a().a(new ih$ao(s3UploadResponse.a.full_url));
                        } else if (s3UploadResponse.c != null) {
                            iq.a().a(new ih$aa(s3UploadResponse.c));
                        } else {
                            iq.a().a(new ih$aa("S3 upload failure"));
                        }
                    }
                }));
            } else if (this.b.b != null) {
                GossipApplication.c.a(this.b.b).j().a(this.a).a(this.mGroupPhoto);
            }
        }
    }

    public void onClick(View v) {
        choosePhoto();
    }
}
