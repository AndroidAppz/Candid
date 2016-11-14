package com.becandid.candid.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.becandid.candid.data.DataUtil;
import com.becandid.candid.data.Group;
import defpackage.hm;
import defpackage.io;
import java.util.ArrayList;
import java.util.List;

public class GroupMeSearchActivity extends BaseActivity {
    private hm b;
    private List<Group> c = new ArrayList();
    @BindView(2131624178)
    RelativeLayout emptyState;
    @BindView(2131624176)
    EditText gsEdit;
    @BindView(2131624177)
    RecyclerView recyclerView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(2130968610);
        ButterKnife.bind(this);
        this.c = (List) getIntent().getExtras().getSerializable("groups");
        this.recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, 1));
        this.b = new hm(this);
        this.recyclerView.setAdapter(this.b);
        this.recyclerView.addOnItemTouchListener(new io(this, getBaseContext()) {
            final /* synthetic */ GroupMeSearchActivity a;

            public void onItemClick(View v, int position) {
                Intent intent = new Intent(v.getContext(), GroupDetailsActivity.class);
                Group group = this.a.b.b(position);
                if (group != null) {
                    intent.putExtra("group_id", group.group_id);
                    intent.putExtra("group_name", group.group_name);
                    intent.putExtra("group_image", group.imageUrl());
                    intent.putExtra("group_json", DataUtil.toJson(group));
                    v.getContext().startActivity(intent);
                }
            }
        });
        this.gsEdit.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ GroupMeSearchActivity a;

            {
                this.a = this$0;
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            public void afterTextChanged(Editable s) {
                List<Group> newGroup = this.a.groupSearch(s.toString());
                this.a.b.a((List) newGroup);
                if (newGroup.size() == 0) {
                    this.a.recyclerView.setVisibility(8);
                    this.a.emptyState.setVisibility(0);
                    return;
                }
                this.a.recyclerView.setVisibility(0);
                this.a.emptyState.setVisibility(8);
            }
        });
    }

    public ArrayList<Group> groupSearch(String keyword) {
        ArrayList<Group> results = new ArrayList();
        if (this.c == null) {
            Toast.makeText(this, "Unable to find your groups", 1).show();
            finish();
        } else {
            for (Group group : this.c) {
                String groupName = group.group_name.toLowerCase();
                if (groupName.startsWith(keyword.toLowerCase())) {
                    results.add(0, group);
                } else if (groupName.contains(keyword.toLowerCase())) {
                    results.add(group);
                }
            }
        }
        return results;
    }
}
