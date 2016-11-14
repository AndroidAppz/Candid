package com.becandid.candid.activities;

import android.os.Bundle;
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
import com.becandid.candid.models.NetworkData;
import defpackage.apj;
import defpackage.apn;
import defpackage.hj;
import defpackage.ie;
import defpackage.io;
import rx.schedulers.Schedulers;

public class MessageSearchActivity extends BaseActivity {
    private hj b;
    @BindView(2131624237)
    RecyclerView resultRecycler;
    @BindView(2131624235)
    EditText searchEdit;
    @BindView(2131624236)
    LinearLayout searchProgressBar;

    public void onCreate(Bundle savedInstances) {
        super.onCreate(savedInstances);
        setContentView(2130968618);
        ButterKnife.bind(this);
        this.b = new hj(this);
        this.resultRecycler.setAdapter(this.b);
        this.resultRecycler.setLayoutManager(new LinearLayoutManager(this));
        this.resultRecycler.setHasFixedSize(true);
        this.resultRecycler.addOnItemTouchListener(new io(this, this) {
            final /* synthetic */ MessageSearchActivity a;

            public void onItemClick(View v, int position) {
                this.a.b.b(position);
            }
        });
        this.searchEdit.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ MessageSearchActivity a;

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
                this.a.a();
                this.a.searchProgressBar.setVisibility(8);
                this.a.resultRecycler.setVisibility(0);
            }
        });
        this.searchEdit.setOnEditorActionListener(new OnEditorActionListener(this) {
            final /* synthetic */ MessageSearchActivity a;

            {
                this.a = this$0;
            }

            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId != 3 && (event == null || event.getAction() != 1 || event.getKeyCode() != 66)) {
                    return false;
                }
                this.a.a(this.a.searchEdit.getText().toString());
                return true;
            }
        });
    }

    private void a(final String searchQuery) {
        this.searchProgressBar.setVisibility(0);
        this.resultRecycler.setVisibility(8);
        a();
        ie.a().l(searchQuery).b(Schedulers.io()).a(apn.a()).b(new apj<NetworkData>(this) {
            final /* synthetic */ MessageSearchActivity b;

            public void onCompleted() {
            }

            public void onError(Throwable e) {
                Log.d("GroupSearch", e.toString());
                this.b.searchProgressBar.setVisibility(8);
                this.b.resultRecycler.setVisibility(0);
            }

            public void onNext(NetworkData networkData) {
                if (!this.b.isStopped) {
                    if (!networkData.success) {
                        this.b.a();
                        this.b.searchProgressBar.setVisibility(8);
                        this.b.resultRecycler.setVisibility(0);
                    } else if (this.b.searchEdit.getText().toString().equals(searchQuery)) {
                        if (networkData.results != null) {
                            this.b.b.a(networkData.results);
                            this.b.b.notifyDataSetChanged();
                        } else {
                            this.b.a();
                        }
                        this.b.searchProgressBar.setVisibility(8);
                        this.b.resultRecycler.setVisibility(0);
                    } else {
                        this.b.a();
                        this.b.searchProgressBar.setVisibility(8);
                        this.b.resultRecycler.setVisibility(0);
                    }
                }
            }
        });
    }

    private void a() {
        this.b.c();
        this.resultRecycler.getAdapter().notifyDataSetChanged();
    }
}
