package com.becandid.candid.activities;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.becandid.candid.adapters.ContactsAdapter;
import com.becandid.candid.adapters.ContactsAdapter.a;
import com.becandid.candid.adapters.ContactsAdapter.b;
import com.becandid.candid.data.AppState;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import defpackage.aib;
import defpackage.aid;
import defpackage.aif;
import defpackage.if;
import defpackage.ii;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class ChooseContactsActivity extends BaseActivity implements b {
    private ContactsAdapter b;
    private List<a> c;
    @BindView(2131624090)
    FrameLayout contactsSearchOuter;
    private HashSet<a> d;
    @BindView(2131624088)
    RecyclerView recyclerView;
    @BindView(2131624091)
    EditText search;
    @BindView(2131624092)
    Button sendInvites;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(2130968604);
        ButterKnife.bind(this);
        this.b = new ContactsAdapter();
        getContacts();
        this.b.a((b) this);
        this.recyclerView.setAdapter(this.b);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.recyclerView.setOnScrollListener(new OnScrollListener(this) {
            final /* synthetic */ ChooseContactsActivity a;

            {
                this.a = this$0;
            }

            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                this.a.contactsSearchOuter.setY(this.a.contactsSearchOuter.getY() - ((float) dy));
            }
        });
        this.search.addTextChangedListener(new if(this) {
            final /* synthetic */ ChooseContactsActivity a;

            {
                this.a = this$0;
            }

            public void afterTextChanged(Editable s) {
                this.a.filterContacts(s.toString());
            }
        });
        this.d = new HashSet();
    }

    public void getContacts() {
        if (ii.a == null) {
            ii.a();
        }
        List<String> animals = new ArrayList(ii.a.keySet());
        this.c = new ArrayList();
        Cursor phones = getContentResolver().query(Phone.CONTENT_URI, null, null, null, null);
        HashSet<String> hashSet = new HashSet(16);
        while (phones.moveToNext()) {
            String number = phones.getString(phones.getColumnIndex("data1"));
            if (number != null) {
                try {
                    if (number.length() >= 7) {
                        PhoneNumberUtil phoneUtil = PhoneNumberUtil.a();
                        PhoneNumber parsed = phoneUtil.a(number, "US");
                        a c = new a();
                        String[] parts = phones.getString(phones.getColumnIndex("display_name")).split(" ", 2);
                        c.c = parts[0];
                        c.d = parts.length > 1 ? parts[1] : "";
                        c.e = phoneUtil.a(parsed, PhoneNumberFormat.E164);
                        if (!hashSet.contains(c.e)) {
                            hashSet.add(c.e);
                            c.a = (String) animals.get(this.c.size() % animals.size());
                            c.b = (String) AppState.feedColors.get(this.c.size() % AppState.feedColors.size());
                            this.c.add(c);
                        }
                    }
                } catch (NumberParseException e) {
                    e.printStackTrace();
                }
            }
        }
        Collections.sort(this.c, new Comparator<a>(this) {
            final /* synthetic */ ChooseContactsActivity a;

            {
                this.a = this$0;
            }

            public int compare(a lhs, a rhs) {
                return lhs.c.toLowerCase().compareTo(rhs.c.toLowerCase());
            }
        });
        filterContacts("");
    }

    public void filterContacts(String filter) {
        filter = filter.toLowerCase();
        List filtered = new ArrayList();
        String last = "";
        for (a c : this.c) {
            if (c.c.toLowerCase().startsWith(filter)) {
                String firstChar = c.c.substring(0, 1).toUpperCase();
                if (!last.equals(firstChar)) {
                    a letter = new a();
                    if (firstChar.compareTo("A") < 0) {
                        letter.g = "0";
                    } else {
                        letter.g = firstChar;
                    }
                    last = firstChar;
                    filtered.add(letter);
                }
                filtered.add(c);
            }
        }
        this.b.a(filtered);
    }

    public void invite(a c, int position) {
        boolean z;
        if (c.h) {
            this.d.remove(c);
        } else {
            this.d.add(c);
        }
        if (c.h) {
            z = false;
        } else {
            z = true;
        }
        c.h = z;
        this.b.notifyItemChanged(position);
        this.sendInvites.setText("Invite (" + this.d.size() + ")");
        if (this.d.size() == 1) {
            this.sendInvites.setEnabled(true);
        } else if (this.d.size() == 0) {
            this.sendInvites.setEnabled(false);
        }
    }

    @OnClick({2131624092})
    public void sendInvites(View v) {
        new Builder(this).setTitle("Invite Contacts").setMessage("Do you want to anonymously invite your selected contacts?").setCancelable(true).setNegativeButton(getResources().getString(2131230887), new OnClickListener(this) {
            final /* synthetic */ ChooseContactsActivity a;

            {
                this.a = this$0;
            }

            public void onClick(DialogInterface dialog, int which) {
            }
        }).setPositiveButton(getResources().getString(2131230945), new OnClickListener(this) {
            final /* synthetic */ ChooseContactsActivity a;

            {
                this.a = this$0;
            }

            public void onClick(DialogInterface dialog, int which) {
                Intent data = new Intent();
                aib result = new aib();
                Iterator it = this.a.d.iterator();
                while (it.hasNext()) {
                    a c = (a) it.next();
                    aid contact = new aif();
                    boolean hasInfo = false;
                    if (c.e != null) {
                        contact.a("phone", c.e);
                        hasInfo = true;
                    }
                    if (c.f != null) {
                        contact.a("email", c.f);
                        hasInfo = true;
                    }
                    if (hasInfo) {
                        result.a(contact);
                    }
                }
                data.putExtra("contacts", result.toString());
                this.a.setResult(-1, data);
                this.a.finish();
            }
        }).create().show();
    }
}
