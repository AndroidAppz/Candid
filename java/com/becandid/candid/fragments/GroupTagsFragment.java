package com.becandid.candid.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.becandid.candid.activities.CreateGroupActivity;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.Group;
import com.becandid.candid.views.TagBox;
import com.becandid.candid.views.TagBox.a;
import defpackage.apj;
import defpackage.apn;
import defpackage.ie;
import defpackage.ih$m;
import defpackage.ih$t;
import defpackage.iq;
import defpackage.iu;
import java.util.ArrayList;
import java.util.List;
import rx.schedulers.Schedulers;

public class GroupTagsFragment extends Fragment implements a {
    private Unbinder a;
    private Bundle b;
    private List<String> c;
    private boolean d = false;
    @BindView(2131624408)
    Button mCreateGroupBtn;
    @BindView(2131624185)
    View mProgressBar;
    @BindView(2131624403)
    View mTagsPlaceholder;
    @BindView(2131624406)
    RelativeLayout mTagsView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(2130968665, container, false);
        this.a = ButterKnife.bind(this, view);
        this.b = getArguments();
        final CreateGroupActivity activity = (CreateGroupActivity) getActivity();
        if (activity instanceof CreateGroupActivity) {
            activity.resetTags();
        }
        this.c = new ArrayList();
        if (this.b.containsKey("tags")) {
            boolean z;
            List<String> tags = this.b.getStringArrayList("tags");
            this.c.addAll(tags);
            iu.a(getActivity(), this.mTagsView, AppState.groupTags);
            for (int i = 0; i < tags.size(); i++) {
                activity.addTag((String) tags.get(i));
            }
            this.mCreateGroupBtn.setText("Update Group");
            Button button = this.mCreateGroupBtn;
            if (activity.isTagsEmpty()) {
                z = false;
            } else {
                z = true;
            }
            button.setEnabled(z);
        } else {
            iu.a(getActivity(), this.mTagsView, AppState.groupTags);
        }
        TagBox.setTagClickListener(this);
        this.mCreateGroupBtn.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ GroupTagsFragment b;

            public void onClick(View v) {
                this.b.mProgressBar.setVisibility(0);
                this.b.mTagsPlaceholder.setAlpha(0.3f);
                if (this.b.d || activity.ismGroupPhotoFailedToUpload()) {
                    this.b.d();
                } else if (!activity.isGroupPhotoSkipped() && activity.getmGroupSourceUrl() == null) {
                } else {
                    if (this.b.b.containsKey("edit_group")) {
                        this.b.a();
                    } else {
                        this.b.b();
                    }
                }
            }
        });
        return view;
    }

    public void a() {
        final CreateGroupActivity activity = (CreateGroupActivity) getActivity();
        ie.a().a(((Integer) this.b.get("group_id")).intValue(), activity.getmGroupName(), activity.getmGroupAbout(), activity.getGroupTags(), activity.getmGroupSourceUrl()).b(Schedulers.io()).a(apn.a()).b(new apj<Group>(this) {
            final /* synthetic */ GroupTagsFragment b;

            public /* synthetic */ void onNext(Object obj) {
                a((Group) obj);
            }

            public void onCompleted() {
                Toast.makeText(this.b.getContext(), "Successfully updated your group", 0).show();
            }

            public void onError(Throwable e) {
                this.b.mProgressBar.setVisibility(8);
                Toast.makeText(this.b.getContext(), "Failed to update your group", 0).show();
                activity.setResult(0);
                this.b.getActivity().finish();
            }

            public void a(Group group) {
                for (int i = 0; i < AppState.groups.size(); i++) {
                    if (((Group) AppState.groups.get(i)).group_id == group.group_id) {
                        AppState.groups.remove(i);
                    }
                }
                AppState.groups.add(group);
                iq.a().a(new ih$t(group));
                Intent data = new Intent();
                data.putExtra("group", group);
                activity.setResult(-1, data);
                activity.finish();
            }
        });
    }

    public void b() {
        final CreateGroupActivity activity = (CreateGroupActivity) getActivity();
        ie.a().a(activity.getmGroupName(), activity.getmGroupAbout(), activity.getGroupTags(), activity.getmGroupSourceUrl()).b(Schedulers.io()).a(apn.a()).b(new apj<Group>(this) {
            final /* synthetic */ GroupTagsFragment b;

            public /* synthetic */ void onNext(Object obj) {
                a((Group) obj);
            }

            public void onCompleted() {
                Toast.makeText(this.b.getContext(), "Successfully created your group", 0).show();
            }

            public void onError(Throwable e) {
                this.b.mProgressBar.setVisibility(8);
                Toast.makeText(this.b.getContext(), "Failed to create a group", 0).show();
                activity.setResult(0);
                this.b.getActivity().finish();
            }

            public void a(Group group) {
                AppState.groups.add(group);
                iq.a().a(new ih$m(group));
                Intent data = new Intent();
                data.putExtra("group", group);
                activity.setResult(-1, data);
                activity.finish();
            }
        });
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.a.unbind();
    }

    public boolean c() {
        return this.mProgressBar.getVisibility() == 0;
    }

    public void d() {
        if (c()) {
            this.mProgressBar.setVisibility(8);
            Toast.makeText(getContext(), "Failed to create a group", 0).show();
            getActivity().setResult(0);
            getActivity().finish();
            return;
        }
        this.d = true;
    }

    public void onResume() {
        super.onResume();
        int count = this.mTagsView.getChildCount();
        for (int i = 0; i < count; i++) {
            LinearLayout layout = (LinearLayout) this.mTagsView.getChildAt(i);
            for (int j = 0; j < layout.getChildCount(); j++) {
                TagBox tag = (TagBox) layout.getChildAt(j);
                if (this.c.contains(tag.getTagNameLowerCase())) {
                    tag.setSelected(true);
                }
            }
        }
    }

    public void a(View v, String label) {
        boolean z = true;
        boolean retState = false;
        FragmentActivity activity = getActivity();
        if (activity instanceof CreateGroupActivity) {
            retState = ((CreateGroupActivity) activity).addTag(label.toLowerCase());
        }
        if (retState) {
            boolean z2;
            if (v.isSelected()) {
                z2 = false;
            } else {
                z2 = true;
            }
            v.setSelected(z2);
        } else {
            Toast.makeText(v.getContext(), "You can only add three tags", 0).show();
        }
        Button button = this.mCreateGroupBtn;
        if (((CreateGroupActivity) activity).isTagsEmpty()) {
            z = false;
        }
        button.setEnabled(z);
    }
}
