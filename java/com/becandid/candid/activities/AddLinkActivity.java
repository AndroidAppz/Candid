package com.becandid.candid.activities;

import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.gson.internal.LinkedTreeMap;
import defpackage.apj;
import defpackage.apn;
import defpackage.ie;
import defpackage.is;
import java.util.Map;
import rx.schedulers.Schedulers;

public class AddLinkActivity extends BaseActivity {
    private String b;
    private Map<String, String> c;
    @BindView(2131624070)
    TextView copiedLink;
    @BindView(2131624072)
    View spinny;
    @BindView(2131624068)
    EditText typedLink;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(2130968601);
        ButterKnife.bind(this);
        ClipboardManager clipboard = (ClipboardManager) getSystemService("clipboard");
        this.b = null;
        if (clipboard.hasPrimaryClip() && clipboard.getPrimaryClip().getItemCount() > 0) {
            Item item = clipboard.getPrimaryClip().getItemAt(0);
            if (clipboard.getPrimaryClipDescription().hasMimeType("text/plain")) {
                this.b = item.getText().toString();
            } else if (clipboard.getPrimaryClipDescription().hasMimeType("text/uri-list")) {
                this.b = item.getUri().toString();
            }
        }
        Log.d("ALA", "Clipboard has: " + this.b);
        if (this.b != null && this.b.startsWith("http")) {
            this.copiedLink.setText(this.b);
            this.copiedLink.setVisibility(0);
        }
        this.typedLink.setOnEditorActionListener(new OnEditorActionListener(this) {
            final /* synthetic */ AddLinkActivity a;

            {
                this.a = this$0;
            }

            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId != 6 && (event == null || event.getAction() != 1 || event.getKeyCode() != 66)) {
                    return false;
                }
                this.a.chooseTypedLink(null);
                return true;
            }
        });
    }

    @OnClick({2131624069})
    public void chooseTypedLink(View button) {
        a(this.typedLink.getText().toString());
    }

    @OnClick({2131624071})
    public void chooseCopiedLink(View button) {
        if (this.b != null) {
            a(this.b);
        } else {
            Toast.makeText(this, "The clipboard doesn't seem to have a link.", 1).show();
        }
    }

    private void a(String url) {
        if (url == null || !is.a(url)) {
            Toast.makeText(this, "That does not appear to be a valid url", 1).show();
            return;
        }
        this.spinny.setVisibility(0);
        addToSubscriptionList(ie.a().d(url).b(Schedulers.io()).a(apn.a()).b(new apj<Map<String, String>>(this) {
            final /* synthetic */ AddLinkActivity a;

            {
                this.a = this$0;
            }

            public void onCompleted() {
                this.a.spinny.setVisibility(8);
                this.a.a();
            }

            public void onError(Throwable e) {
                e.printStackTrace();
                Toast.makeText(this.a, "There was an error fetching this link", 1);
            }

            public void onNext(Map<String, String> stringStringMap) {
                if (stringStringMap != null) {
                    this.a.c = stringStringMap;
                } else {
                    Toast.makeText(this.a, "There was an error fetching this link", 1);
                }
            }
        }));
    }

    private void a() {
        if (this.c != null) {
            Intent data = new Intent();
            data.putExtra("link_info", (LinkedTreeMap) this.c);
            setResult(-1, data);
            finish();
        }
    }
}
