package com.becandid.candid.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.ListPopupWindow;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.Group;
import com.becandid.candid.data.TextTag;
import com.becandid.candid.models.NetworkData;
import defpackage.apj;
import defpackage.apn;
import defpackage.hg;
import defpackage.ie;
import defpackage.ih$ad;
import defpackage.ih$g;
import defpackage.iq;
import defpackage.iu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import rx.schedulers.Schedulers;

public class ContentEditActivity extends BaseActivity {
    private String b;
    private int c;
    private int d;
    private String e;
    @BindView(2131624104)
    Button editCancel;
    @BindView(2131624100)
    FrameLayout editContainer;
    @BindView(2131624102)
    TextView editDetails;
    @BindView(2131624097)
    TextView editHeaderTitle;
    @BindView(2131624105)
    Button editSave;
    @BindView(2131624106)
    FrameLayout editSpinny;
    @BindView(2131624101)
    AppCompatEditText editText;
    @BindView(2131624095)
    RelativeLayout editTitle;
    private ArrayList<TextTag> f;
    private ListPopupWindow g;
    private hg h;
    private CharSequence i = "";
    private boolean j;
    private int k;
    private int l;
    private int m;
    @BindView(2131624094)
    RelativeLayout root;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(2130968605);
        ButterKnife.bind(this);
        enableKeyboardEvents(this.root);
        Rect r = new Rect();
        this.root.getWindowVisibleDisplayFrame(r);
        this.d = r.bottom - r.top;
        if (getIntent().hasExtra("comment_id")) {
            this.e = "comment";
            this.c = getIntent().getIntExtra("comment_id", 0);
            this.editHeaderTitle.setText(2131230832);
            this.editText.setText(2131230816);
            this.editDetails.setText(2131230814);
            this.b = getIntent().getStringExtra("comment_text");
        } else if (getIntent().hasExtra("post_id")) {
            this.e = "post";
            this.c = getIntent().getIntExtra("post_id", 0);
            this.editHeaderTitle.setText(2131230835);
            this.editText.setText(2131230899);
            this.editDetails.setText(2131230898);
            this.b = getIntent().getStringExtra("caption");
        } else {
            Toast.makeText(this, "Invalid edit attempt", 1).show();
            finish();
        }
        this.f = new ArrayList();
        if (getIntent().hasExtra("group_tags")) {
            for (String group : getIntent().getStringExtra("group_tags").split(";")) {
                String[] indices = group.split(",");
                this.f.add(new TextTag(Integer.parseInt(indices[1]), Integer.parseInt(indices[2]), Integer.parseInt(indices[0])));
            }
        }
        this.k = AppState.config.getInt("disable_group_tagging", 0);
        SpannableStringBuilder newText = new SpannableStringBuilder(this.b);
        if (this.k == 0 && !this.f.isEmpty()) {
            ArrayList<TextTag> newTags = new ArrayList();
            Iterator it = this.f.iterator();
            while (it.hasNext()) {
                TextTag indexes = (TextTag) it.next();
                if (indexes.endIndex > newText.length()) {
                    indexes.endIndex = newText.length();
                }
                if (indexes.startIndex < 0) {
                    indexes.startIndex = 0;
                }
                if (indexes.startIndex >= newText.length() || indexes.endIndex <= 0) {
                    break;
                }
                newTags.add(indexes);
                newText.setSpan(iu.a(), indexes.startIndex, indexes.endIndex, 33);
            }
            this.f = newTags;
        }
        this.editText.setText(newText);
        this.editText.setSelection(this.editText.length());
        this.editText.requestFocus();
        openKeyboard();
        this.editContainer.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ContentEditActivity a;

            {
                this.a = this$0;
            }

            public void onClick(View v) {
                this.a.editText.setSelection(this.a.editText.length());
                this.a.editText.requestFocus();
                if (!this.a.keyboardOpen) {
                    this.a.openKeyboard();
                }
            }
        });
        if (AppState.groups == null) {
            AppState.groups = new ArrayList();
        }
        this.h = new hg(this, 2130968683, new ArrayList(AppState.groups));
        this.g = new ListPopupWindow(this);
        this.g.setAdapter(this.h);
        this.g.setAnchorView(this.editText);
        this.g.setAnimationStyle(0);
        this.g.setHeight(-2);
        this.g.setWidth(iu.a(150, (Context) this));
        this.g.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ ContentEditActivity a;

            {
                this.a = this$0;
            }

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Group group = (Group) parent.getItemAtPosition(position);
                String[] tags = this.a.editText.getText().toString().split("(?=#)");
                int pos = this.a.editText.getSelectionStart();
                int size = 0;
                int spannableEnd = 0;
                CharSequence newText = new SpannableStringBuilder("");
                ArrayList newTags = new ArrayList();
                int indexUpdateSize = 0;
                for (String sub : tags) {
                    int substringStart = size;
                    size += sub.length();
                    if (substringStart >= pos || pos > size) {
                        newText.append(sub);
                    } else {
                        int spannableStart = newText.length();
                        newText.append("#" + group.group_name);
                        indexUpdateSize = (group.group_name.length() + 1) - (pos - spannableStart);
                        spannableEnd = newText.length();
                        newText.append(" ");
                        newText.append(sub.substring(pos - substringStart));
                        newTags.add(new TextTag(spannableStart, spannableEnd, group.group_id));
                    }
                }
                Iterator it = this.a.f.iterator();
                while (it.hasNext()) {
                    TextTag indexes = (TextTag) it.next();
                    if (pos < indexes.startIndex || pos > indexes.endIndex) {
                        if (indexes.startIndex > pos) {
                            indexes.startIndex += indexUpdateSize;
                            indexes.endIndex += indexUpdateSize;
                        }
                        newTags.add(indexes);
                    }
                }
                this.a.f = newTags;
                it = this.a.f.iterator();
                while (it.hasNext()) {
                    indexes = (TextTag) it.next();
                    newText.setSpan(iu.a(), indexes.startIndex, indexes.endIndex, 33);
                }
                this.a.i = newText;
                this.a.editText.setText(newText);
                this.a.editText.setSelection(spannableEnd + 1);
                this.a.g.dismiss();
            }
        });
        this.editText.setOnFocusChangeListener(new OnFocusChangeListener(this) {
            final /* synthetic */ ContentEditActivity a;

            {
                this.a = this$0;
            }

            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus && this.a.k == 0) {
                    iu.a(this.a.editText.getText(), this.a.editText, this.a.g, this.a.h);
                }
            }
        });
        this.editText.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ ContentEditActivity a;

            {
                this.a = this$0;
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                this.a.l = this.a.editText.getSelectionStart();
                this.a.m = this.a.editText.getSelectionEnd();
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (this.a.k == 0 && !s.toString().equals(this.a.i.toString())) {
                    int newCursorStart = this.a.editText.getSelectionStart();
                    ArrayList newTags = new ArrayList();
                    Iterator it = this.a.f.iterator();
                    while (it.hasNext()) {
                        TextTag indexes = (TextTag) it.next();
                        if (this.a.l <= indexes.startIndex && this.a.m <= indexes.startIndex) {
                            indexes.startIndex += count - before;
                            indexes.endIndex += count - before;
                            newTags.add(indexes);
                            this.a.j = true;
                        } else if (this.a.l <= indexes.startIndex && this.a.m > indexes.startIndex) {
                            this.a.j = true;
                        } else if (this.a.l > indexes.startIndex && this.a.l <= indexes.endIndex) {
                            this.a.j = true;
                        } else if (newCursorStart > indexes.endIndex) {
                            newTags.add(indexes);
                        } else {
                            this.a.j = true;
                        }
                    }
                    this.a.f = newTags;
                }
            }

            public void afterTextChanged(Editable s) {
                if (this.a.k == 0 && !s.toString().equals(this.a.i.toString())) {
                    this.a.i = s.toString();
                    iu.a((CharSequence) s, this.a.editText, this.a.g, this.a.h);
                    if (this.a.j) {
                        SpannableStringBuilder newText = new SpannableStringBuilder(s.toString());
                        Iterator it = this.a.f.iterator();
                        while (it.hasNext()) {
                            TextTag indexes = (TextTag) it.next();
                            newText.setSpan(iu.a(), indexes.startIndex, indexes.endIndex, 33);
                        }
                        this.a.j = false;
                        this.a.i = newText.toString();
                        int pos = this.a.editText.getSelectionStart();
                        this.a.editText.setText(newText);
                        this.a.editText.setSelection(pos);
                    }
                }
            }
        });
        this.editSave.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ContentEditActivity a;

            {
                this.a = this$0;
            }

            public void onClick(View v) {
                if (this.a.editText.getText().toString().equals("") || this.a.editText.getText().toString().trim().equals("")) {
                    Toast.makeText(this.a, 2131230815, 0).show();
                    return;
                }
                this.a.editSpinny.setVisibility(0);
                Map params = new HashMap();
                if (!this.a.f.isEmpty()) {
                    String ids = "";
                    Iterator it = this.a.f.iterator();
                    while (it.hasNext()) {
                        ids = ids + ((TextTag) it.next()).toString() + ";";
                    }
                    params.put("mentioned_group_ids", ids.substring(0, ids.length() - 1));
                }
                if (this.a.e.equals("comment")) {
                    params.put("comment_id", Integer.toString(this.a.c));
                    params.put("comment_text", this.a.editText.getText().toString());
                    ie.a().l(params).b(Schedulers.io()).a(apn.a()).b(new apj<NetworkData>(this) {
                        final /* synthetic */ AnonymousClass5 a;

                        {
                            this.a = this$1;
                        }

                        public void onCompleted() {
                        }

                        public void onError(Throwable e) {
                            this.a.a.editSpinny.setVisibility(8);
                            Toast.makeText(this.a.a, e.toString(), 1).show();
                        }

                        public void onNext(NetworkData networkData) {
                            if (networkData.success) {
                                String mentions = null;
                                if (!this.a.a.f.isEmpty()) {
                                    String ids = "";
                                    Iterator it = this.a.a.f.iterator();
                                    while (it.hasNext()) {
                                        ids = ids + ((TextTag) it.next()).toString() + ";";
                                    }
                                    mentions = ids.substring(0, ids.length() - 1);
                                }
                                iq.a().a(new ih$g(this.a.a.c, this.a.a.editText.getText().toString(), mentions));
                                Intent intent = new Intent();
                                intent.putExtra("comment_id", this.a.a.c);
                                this.a.a.setResult(PostDetailsActivity.COMMENT_EDIT, intent);
                                this.a.a.finish();
                                return;
                            }
                            this.a.a.editSpinny.setVisibility(8);
                            Toast.makeText(this.a.a, networkData.error, 1).show();
                        }
                    });
                } else if (this.a.e.equals("post")) {
                    params.put("post_id", Integer.toString(this.a.c));
                    params.put("caption", this.a.editText.getText().toString());
                    ie.a().k(params).b(Schedulers.io()).a(apn.a()).b(new apj<NetworkData>(this) {
                        final /* synthetic */ AnonymousClass5 a;

                        {
                            this.a = this$1;
                        }

                        public void onCompleted() {
                        }

                        public void onError(Throwable e) {
                            this.a.a.editSpinny.setVisibility(8);
                            Toast.makeText(this.a.a, e.toString(), 1).show();
                        }

                        public void onNext(NetworkData networkData) {
                            if (networkData.success) {
                                String mentions = null;
                                if (!this.a.a.f.isEmpty()) {
                                    String ids = "";
                                    Iterator it = this.a.a.f.iterator();
                                    while (it.hasNext()) {
                                        ids = ids + ((TextTag) it.next()).toString() + ";";
                                    }
                                    mentions = ids.substring(0, ids.length() - 1);
                                }
                                iq.a().a(new ih$ad(this.a.a.c, this.a.a.editText.getText().toString(), mentions));
                                this.a.a.finish();
                                return;
                            }
                            this.a.a.editSpinny.setVisibility(8);
                            Toast.makeText(this.a.a, networkData.error, 1).show();
                        }
                    });
                }
            }
        });
        this.editCancel.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ContentEditActivity a;

            {
                this.a = this$0;
            }

            public void onClick(View v) {
                this.a.backNavClick(v);
            }
        });
    }

    protected void keyboardOpened() {
        new Handler().post(new Runnable(this) {
            final /* synthetic */ ContentEditActivity a;

            {
                this.a = this$0;
            }

            public void run() {
                Rect r = new Rect();
                this.a.root.getWindowVisibleDisplayFrame(r);
                if (Float.compare(((float) (r.bottom - r.top)) / ((float) this.a.d), 0.5f) >= 0) {
                    this.a.editDetails.setVisibility(8);
                }
            }
        });
    }

    protected void keyboardClosed() {
        this.editDetails.setVisibility(0);
    }
}
