package com.becandid.candid.activities;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.becandid.candid.data.AppState;
import defpackage.aib;
import defpackage.aif;
import defpackage.apj;
import defpackage.apn;
import defpackage.hh;
import defpackage.ie;
import defpackage.io;
import defpackage.rb;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.schedulers.Schedulers;

public class GroupSearchActivity extends BaseActivity {
    private List<GroupSearchResult> b;
    private Handler c;
    @BindView(2131624176)
    EditText gsEdit;
    @BindView(2131624180)
    LinearLayout gsProgressBar;
    @BindView(2131624177)
    RecyclerView recyclerView;

    public class GroupSearchResult {
        final /* synthetic */ GroupSearchActivity a;
        public String firstTag;
        public int groupId;
        public String groupName;
        public String thumbUrl;

        GroupSearchResult(GroupSearchActivity this$0) {
            this.a = this$0;
        }

        public String toString() {
            return "groupName: " + this.groupName + ", groupId: " + Integer.toString(this.groupId);
        }
    }

    public void onCreate(Bundle savedInstances) {
        super.onCreate(savedInstances);
        this.b = new ArrayList();
        this.c = new Handler();
        setContentView(2130968611);
        ButterKnife.bind(this);
        this.recyclerView.setHasFixedSize(true);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.recyclerView.addOnItemTouchListener(new io(this, this) {
            final /* synthetic */ GroupSearchActivity a;

            public void onItemClick(View v, int position) {
                try {
                    this.a.startActivity(GroupDetailsActivity.startGroupDetailsActivity(this.a.getBaseContext(), ((GroupSearchResult) this.a.b.get(position)).groupId));
                } catch (ArrayIndexOutOfBoundsException e) {
                    rb.a(e);
                }
            }
        });
        this.recyclerView.setAdapter(new hh(this.b, this));
        this.gsEdit.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ GroupSearchActivity a;

            {
                this.a = this$0;
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            public void afterTextChanged(Editable s) {
                if (s.length() >= 3) {
                    this.a.a(s.toString());
                    return;
                }
                this.a.gsProgressBar.setVisibility(8);
                this.a.recyclerView.setVisibility(0);
            }
        });
        this.gsEdit.setOnEditorActionListener(new OnEditorActionListener(this) {
            final /* synthetic */ GroupSearchActivity a;

            {
                this.a = this$0;
            }

            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId != 3 && (event == null || event.getAction() != 1 || event.getKeyCode() != 66)) {
                    return false;
                }
                this.a.a(this.a.gsEdit.getText().toString());
                return true;
            }
        });
    }

    private void a(final String searchQuery) {
        this.gsProgressBar.setVisibility(0);
        this.recyclerView.setVisibility(8);
        a();
        Map params = new HashMap();
        params.put("query", searchQuery);
        if (AppState.location != null) {
            params.put("location", AppState.location.getLatitude() + "," + AppState.location.getLongitude() + "@" + (AppState.location.hasAccuracy() ? Float.valueOf(AppState.location.getAccuracy()) : "50"));
        }
        ie.a().j(params).b(Schedulers.io()).a(apn.a()).b(new apj<aif>(this) {
            final /* synthetic */ GroupSearchActivity b;

            public void onCompleted() {
            }

            public void onError(Throwable e) {
                Log.d("GroupSearch", e.toString());
                this.b.gsProgressBar.setVisibility(8);
                this.b.recyclerView.setVisibility(0);
            }

            public void onNext(aif result) {
                if (!this.b.isStopped && this.b.gsEdit.getText().toString().equals(searchQuery)) {
                    aib results = result.b("groups").n();
                    for (int i = 0; i < results.a(); i++) {
                        this.b.a(results.a(i).m());
                    }
                    this.b.recyclerView.getAdapter().notifyDataSetChanged();
                    this.b.gsProgressBar.setVisibility(8);
                    this.b.recyclerView.setVisibility(0);
                }
            }
        });
    }

    private void a(aif entry) {
        GroupSearchResult result = new GroupSearchResult(this);
        try {
            result.groupName = entry.b("group_name").c();
            result.groupId = entry.b("group_id").g();
            result.firstTag = entry.b("first_tag").c();
            result.thumbUrl = entry.b("thumb_url").c();
            this.b.add(result);
        } catch (Exception e) {
        }
    }

    private void a() {
        this.b.clear();
        this.recyclerView.getAdapter().notifyDataSetChanged();
    }
}
