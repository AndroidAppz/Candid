package com.becandid.candid.activities;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog.Builder;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.becandid.candid.adapters.ContactsAdapter.a;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.DataUtil;
import com.becandid.candid.data.EmptyClass;
import com.becandid.candid.fragments.InviteContactMethodFragment;
import com.becandid.candid.fragments.InviteContactPeopleFragment;
import com.becandid.candid.fragments.InviteContactSentFragment;
import com.becandid.candid.models.EmptySubscriber;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import defpackage.aib;
import defpackage.apj;
import defpackage.apn;
import defpackage.ie;
import defpackage.ii;
import defpackage.rc;
import defpackage.rm;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import rx.schedulers.Schedulers;

public class InviteContactsActivity extends BaseActivity {
    public static final int CHOOSE_CONTACTS = 101;
    Activity b;
    int c = -1;
    int d = 0;
    String e;
    @BindView(2131624107)
    FrameLayout mPlaceholder;
    public String sendInviteName;

    public enum InviteFlowTypes {
        DOWNLOAD("Download"),
        GROUP("Group"),
        POST("Post");
        
        private String a;

        private InviteFlowTypes(String text) {
            this.a = text;
        }

        public String toString() {
            return this.a;
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(2130968613);
        ButterKnife.bind(this);
        setResult(0);
        this.b = this;
        if (this.mPlaceholder != null && savedInstanceState == null) {
            InviteContactPeopleFragment inviteContactPeopleFragment = new InviteContactPeopleFragment();
            inviteContactPeopleFragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(2131624107, inviteContactPeopleFragment).commit();
        }
    }

    public void inviteAllWithCheck(View v) {
        InviteContactsActivityPermissionsDispatcher.a((InviteContactsActivity) this.b, v);
    }

    public void chooseContactsWithCheck(View v) {
        InviteContactsActivityPermissionsDispatcher.b((InviteContactsActivity) this.b, v);
    }

    public void inviteAll(View v) {
        new Builder(this).setTitle("Invite Contacts").setMessage("Do you want to anonymously invite your selected contacts?").setCancelable(true).setNegativeButton(getResources().getString(2131230887), new OnClickListener(this) {
            final /* synthetic */ InviteContactsActivity a;

            {
                this.a = this$0;
            }

            public void onClick(DialogInterface dialog, int which) {
            }
        }).setPositiveButton(getResources().getString(2131230945), new OnClickListener(this) {
            final /* synthetic */ InviteContactsActivity a;

            {
                this.a = this$0;
            }

            public void onClick(DialogInterface dialog, int which) {
                this.a.setSendInviteData(this.a.getContacts().toString());
                if (AppState.config.getInt("enable_new_invite_flow", 0) == 1) {
                    this.a.a();
                    rc.c().a(new rm("New Text Invite FLow"));
                    return;
                }
                this.a.sendContactsToServer();
                rc.c().a(new rm("Old Text Invite Flow"));
            }
        }).create().show();
    }

    private void a() {
        InviteContactMethodFragment inviteContactMethodFragment = new InviteContactMethodFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(2131034128, 2131034129, 2131034130, 2131034131);
        transaction.replace(2131624107, inviteContactMethodFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public aib getContacts() {
        List<String> animals = new ArrayList(ii.a.keySet());
        aib contacts = new aib();
        Cursor phones = getContentResolver().query(Phone.CONTENT_URI, null, null, null, null);
        HashSet<String> seenNumbers = new HashSet(16);
        while (phones.moveToNext()) {
            String number = phones.getString(phones.getColumnIndex("data1"));
            if (number != null) {
                try {
                    if (number.length() >= 7) {
                        PhoneNumberUtil phoneUtil = PhoneNumberUtil.a();
                        PhoneNumber parsed = phoneUtil.a(number, "US");
                        a c = new a();
                        String phone = phoneUtil.a(parsed, PhoneNumberFormat.E164);
                        if (!seenNumbers.contains(phone)) {
                            seenNumbers.add(phone);
                            contacts.a(DataUtil.newJsonObject("phone", phone));
                        }
                    }
                } catch (NumberParseException e) {
                    e.printStackTrace();
                }
            }
        }
        return contacts;
    }

    public void chooseContacts(View v) {
        startActivityForResult(new Intent(this, ChooseContactsActivity.class), CHOOSE_CONTACTS);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CHOOSE_CONTACTS && resultCode == -1) {
            setSendInviteData(data.getStringExtra("contacts"));
            if (AppState.config.getInt("enable_new_invite_flow", 0) == 1) {
                a();
                rc.c().a(new rm("New Text Invite FLow"));
                return;
            }
            sendContactsToServer();
            rc.c().a(new rm("Old Text Invite Flow"));
        }
    }

    public void sendContactsToServer() {
        ie.a().a(this.e, getIntent().getStringExtra("upsell_id"), this.sendInviteName).b(Schedulers.io()).a(apn.a()).b(new apj<EmptyClass>(this) {
            final /* synthetic */ InviteContactsActivity a;

            {
                this.a = this$0;
            }

            public void onCompleted() {
                if (this.a.c != -1 || this.a.d != 0) {
                    ie.a().e(this.a.c).b(Schedulers.io()).a(apn.a()).b(new EmptySubscriber());
                    Intent data = new Intent();
                    data.putExtra("upsellId", this.a.d);
                    this.a.setResult(-1, data);
                    if (AppState.config.getInt("enable_new_invite_flow", 0) != 1) {
                        this.a.finish();
                        Toast.makeText(this.a.getBaseContext(), "Your friends have been notified. Thanks!", 1).show();
                    }
                }
            }

            public void onError(Throwable e) {
            }

            public void onNext(EmptyClass emptyClass) {
            }
        });
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        InviteContactsActivityPermissionsDispatcher.a(this, requestCode, grantResults);
    }

    public void setGroupId(int groupId) {
        this.c = groupId;
    }

    public void setUpsellId(int upsellId) {
        this.d = upsellId;
    }

    public void setSendInviteName(String sendInviteName) {
        this.sendInviteName = sendInviteName;
    }

    public void setSendInviteData(String sendInviteData) {
        this.e = sendInviteData;
    }

    public void switchFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(2131034128, 2131034129, 2131034130, 2131034131);
        transaction.replace(2131624107, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4 && event.getRepeatCount() == 0) {
            onBackPressed();
        }
        return super.onKeyDown(keyCode, event);
    }

    public void onBackPressed() {
        if (!(getSupportFragmentManager().findFragmentById(2131624107) instanceof InviteContactSentFragment)) {
            super.onBackPressed();
        }
    }
}
